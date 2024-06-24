const express = require("express");
const cors = require("cors");
const morgan = require("morgan");
const mysql = require("mysql2"); // mysql2 driver for MySQL/MariaDB

const app = express();

const port = 3000;

// MySQL database connection config
const dbConfig = {
  host: "localhost",
  user: "root",
  password: "password",
  database: "my_quiz_db",
};
// allow cors and morgan
app.use(cors());
app.use(morgan("dev"));

// Create a MySQL pool
const pool = mysql.createPool(dbConfig);

// Route to fetch data
app.get("/quiz", (req, res) => {
  // Use the pool to get a connection
  pool.getConnection((err, connection) => {
    if (err) {
      console.error("Error getting MySQL connection: " + err.stack);
      return res.status(500).json({ error: "Error getting MySQL connection" });
    }

    // Query to fetch data
    const sql =
      "SELECT id, question, option1, option2, option3, option4, correct_option FROM math_table";
    connection.query(sql, (queryErr, results) => {
      // Release the connection back to the pool
      connection.release();

      if (queryErr) {
        console.error("Error executing query: " + queryErr.stack);
        return res.status(500).json({ error: "Error executing query" });
      }

      // Convert results to JSON and send response
      res.json(results);
    });
  });
});

// Start the server
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
