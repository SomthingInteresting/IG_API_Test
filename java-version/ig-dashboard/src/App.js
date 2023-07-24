import React, { useEffect, useState } from 'react';
import axios from 'axios';

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
        console.log(response.data); // log response data
        setPositions(response.data); // response.data is an array of position objects
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
          {positions.map((position, index) => (
            <div key={index}>
              <h3>{position.market.instrumentName}</h3>
              <p>Contract Size: {position.position.contractSize}</p>
              <p>Direction: {position.position.direction}</p>
              {/* Display more data as desired */}
            </div>
          ))}
        </>
      )}
    </div>
  );
}

export default App;
