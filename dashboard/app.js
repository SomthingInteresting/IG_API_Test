const express = require('express');
const fetch = require('isomorphic-fetch');
require('dotenv').config();
require('es6-promise').polyfill();

const app = express();
const cors = require('cors');

// Allow CORS
app.use(cors());

app.use(express.static('public'));

app.get('/', function (req, res) {
  res.sendFile(__dirname + '/public/index.html');
});


app.get('/api/data', (req, res) => {
  const authRequestBody = {
    identifier: process.env.IG_IDENTIFIER,
    password: process.env.IG_PASSWORD,
    encryptedPassword: null,
  }

  fetch('https://demo-api.ig.com/gateway/deal/session', {
    method: 'POST',
    headers: {
      'X-IG-API-KEY': process.env.IG_API_KEY,
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(authRequestBody),
  })
  .then((response) => response.json())
  .then((data) => {
    res.json(data);
  })
  .catch((err) => {
    console.error(err);
    res.status(500).json({ error: err.toString() });
  });
});

app.listen(3000, () => {
  console.log('Server is running on port 3000');
});
