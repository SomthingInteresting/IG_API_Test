import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [account, setAccount] = useState(null);
  const [positions, setPositions] = useState([]);

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

  return (
    <div className="App">
      <h1>IG Dashboard</h1>
      {account && (
        <>
          <p>Account Type: {account.accountType}</p>
          <p>Balance: £{account.accountInfo.balance}</p>
          <p>Profit/Loss: {account.accountInfo.profitLoss}</p>
        </>
      )}
      {positions && (
        <>
          <h2>Positions</h2>
          <table className="positions-table">
            <thead>
              <tr>
                <th>Instrument Name</th>
                <th>Contract Size</th>
                <th>Direction</th>
              </tr>
            </thead>
            <tbody>
              {positions.map((position, index) => (
                <tr key={index}>
                  <td>{position.market.instrumentName}</td>
                  <td>{position.position.contractSize}</td>
                  <td>{position.position.direction}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      )}
    </div>
  );
}

export default App;
