import React, { useEffect, useState, useRef, useLayoutEffect } from 'react';
import axios from 'axios';
import './App.css';
import * as d3 from 'd3';

function App() {
  const [account, setAccount] = useState(null);
  const [positions, setPositions] = useState([]);
  const svgRef = useRef();

  const margin = { top: 30, right: 20, bottom: 60, left: 30 };
  const width = 700 - margin.left - margin.right;
  const height = 400 - margin.top - margin.bottom;

  useEffect(() => {
    axios.get('http://localhost:8080/api/dashboard')
      .then(response => {
        setAccount(response.data);
      })
      .catch(error => {
        console.error('There was an error!', error);
      });

    axios.get('http://localhost:8080/api/positions')
      .then(response => {
        console.log(response.data);
        setPositions(response.data);
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
  }, []);

  useLayoutEffect(() => {
    if (positions && positions.length > 0) {
      const svg = d3.select(svgRef.current)
        .attr("width", width + margin.left + margin.right)
        .attr("height", height + margin.top + margin.bottom)
        .append("g")
        .attr("transform", `translate(${margin.left}, ${margin.top})`);

      const xScale = d3.scaleBand()
        .domain(positions.map((_, i) => i))
        .range([0, width])
        .padding(0.1);

      const yScale = d3.scaleLinear()
        .domain([0, d3.max(positions, d => d.market.percentageChange)])
        .range([height, 0]);

      svg.selectAll('.bar')
        .data(positions)
        .enter()
        .append('rect')
        .attr('class', 'bar')
        .attr('x', (d, i) => xScale(i))
        .attr('width', xScale.bandwidth())
        .attr('y', d => yScale(d.market.percentageChange))
        .attr('height', d => height - yScale(d.market.percentageChange));

      svg.selectAll('.label')
        .data(positions)
        .enter()
        .append('text')
        .attr('class', 'label')
        .attr('x', (d, i) => xScale(i) + xScale.bandwidth() / 2)
        .attr('y', d => yScale(d.market.percentageChange) - 5)
        .attr('text-anchor', 'middle')
        .text(d => d.market.instrumentName);

      svg.append('g')
        .attr('class', 'axis')
        .attr('transform', `translate(0, ${height})`)
        .call(d3.axisBottom(xScale).tickValues([])); 

      svg.append('g')
        .attr('class', 'axis')
        .call(d3.axisLeft(yScale));
    }
  }, [positions]);

  return (
    <div className="App">
      <h1>IG Dashboard</h1>
      <h2>Account Info</h2>
      {account && (
        <>
          <p>Account Type: {account.accountType}</p>
          <p>Balance: {new Intl.NumberFormat('en-GB', { style: 'currency', currency: 'GBP' }).format(account.accountInfo.balance)}</p>
          <p>Profit/Los: {new Intl.NumberFormat('en-GB', { style: 'currency', currency: 'GBP' }).format(account.accountInfo.profitLoss)}</p>
        </>
      )}
      {positions && (
        <>
          <h2>Positions</h2>
          <table className="positions-table">
            <thead>
              <tr>
                <th>Market</th>
                <th>Direction</th>
                <th>Change</th>
              </tr>
            </thead>
            <tbody>
              {positions.map((position, index) => (
                <tr key={index}>
                  <td>{position.market.instrumentName}</td>
                  <td>{position.position.direction}</td>
                  <td>{position.market.percentageChange}%</td>
                </tr>
              ))}
            </tbody>
          </table>
          <div style={{marginTop: "20px", border: "1px solid #ccc", borderRadius: "5px", padding: "15px"}}>
            <svg ref={svgRef}></svg>
          </div>
        </>
      )}
    </div>
  );
}

export default App;
