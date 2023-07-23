import React, { useEffect, useState } from 'react';
import axios from 'axios';

function App() {
  const [account, setAccount] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:8080/api/dashboard')
      .then(response => {
        setAccount(response.data);
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
          <p>Account ID: {account.currentAccountId}</p>
          <p>Account Type: {account.accountType}</p>
          <p>Balance: {account.accountInfo.balance}</p>
          {/* Add more fields as per your requirement */}
        </>
      )}
    </div>
  );
}

export default App;
