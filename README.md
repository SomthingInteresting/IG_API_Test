# IG Group API Testing

In this project we're going to test the IG Group API using Javascript first then move onto using Java. The IG Group API is a RESTful API that allows you to access your IG account data. You can find out more about the API [here](https://labs.ig.com/rest-trading-api-reference).

We will solely focus on using the demo account for this project. You can find out more about the demo account [here](https://labs.ig.com/gettingstarted).

The Javascript tests are written using Jest and the Java tests are written using JUnit 5.

## Table of Contents

- [IG Group API Testing](#ig-group-api-testing)
  - [Table of Contents](#table-of-contents)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)

## Getting Started

### Prerequisites

Before you can run this project, you will need the following:

Node.js and NPM: This project is built using Node.js, and uses NPM (which comes with Node.js) to manage packages.
Java Development Kit (JDK): You will also need the Java Development Kit in order to run the Java portion of this project.
An IG Group Account: This project uses the IG Group API to access data from your IG account. You will need an account with IG Group in order to use this project. You can sign up for an account on their website.
API Key: Once you have an IG account, you will need to create an API key. This can be done in the IG Group dashboard. This key is needed to authenticate your application with IG Group's API.
Installation
After you have the prerequisites set up, you can install and run this project using the following steps:

Clone the Repository: git clone https://github.com/<your-github-username>/IG_API_Test.git

Navigate into the Project Directory: cd IG_API_Test

Install NPM Packages: npm install

Set up Environment Variables: Rename .env.sample to .env and replace the placeholder values with your IG Group account details and API key.

touch .env
Copy code
IG_API_KEY=your_ig_api_key
IG_IDENTIFIER=your_ig_username
IG_PASSWORD=your_ig_password
Start the Server: node app.js

You can now access the dashboard in your browser at http://localhost:3000.

About this Project
This project is a simple web dashboard that displays account balance and profit/loss information from your IG Group account. The backend server is built with Node.js and Express, and makes requests to the IG Group API to fetch account data. This data is then served to the frontend, which is a simple HTML/CSS/JavaScript webpage that fetches the data from the backend and displays it on the dashboard.

The server also serves static files for the frontend, which includes a basic CSS file for styling the dashboard, and a JavaScript file for fetching and displaying data from the server.

Future Work
We plan to extend this project to also use Java to interact with the IG Group API. We also aim to add more features to the dashboard, such as displaying historical data and real-time updates, as well as user authentication and handling for multiple accounts.
