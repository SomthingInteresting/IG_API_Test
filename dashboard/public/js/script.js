fetch('/api/data')
  .then((res) => res.json())
  .then((data) => {
    if(data && data.accountInfo) {
      document.getElementById('balance').textContent = 'Balance: ' + data.accountInfo.balance;
      document.getElementById('profitLoss').textContent = 'Profit/Loss: ' + data.accountInfo.profitLoss;
    } else {
      console.error('Unexpected API response', data);
    }
  })
  .catch((err) => {
    console.error(err);
  });
