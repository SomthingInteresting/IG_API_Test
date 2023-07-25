# IG Group API Testing

In this project we're going to test the IG Group API using Javascript first then move onto using Java. The IG Group API is a RESTful API that allows you to access your IG account data. You can find out more about the API [here](https://labs.ig.com/rest-trading-api-reference).

We will solely focus on using the demo account for this project. You can find out more about the demo account [here](https://labs.ig.com/gettingstarted).

The Javascript tests will be written using Jest and the Java tests using JUnit 5.

## Current Version Screenshot (Java)
![Screenshot 2023-07-25 at 09 23 32](https://github.com/SomthingInteresting/IG_API_Test/assets/122159337/50ee4832-9d97-4d6b-a3db-3576c1e7babb)


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

## Node Version
This project is a simple web dashboard that displays account balance and profit/loss information from your IG Group account. The backend server is built with Node.js and Express, and makes requests to the IG Group API to fetch account data. This data is then served to the frontend, which is a simple HTML/CSS/JavaScript webpage that fetches the data from the backend and displays it on the dashboard.

The server also serves static files for the frontend, which includes a basic CSS file for styling the dashboard, and a JavaScript file for fetching and displaying data from the server.

Technologies Used:
- Node.js
- Express
- JavaScript
- HTML
- CSS

## Java Version
This project is a simple web dashboard that displays account balance and profit/loss information from your IG Group account. The backend server is built with Java and Spring Boot, and makes requests to the IG Group API to fetch account data. This data is then served to the frontend, where React is used to fetch and display the data from the server.

Technologies Used:
- Java
- Spring Boot
- React
- D3
- Maven
- CSS

## Future Work

Java Version
- Explore other routes of the IG Group API and add more data to the dashboard.
- Add more styling to the dashboard.
- Add tests for the backend
