#  A tool that allows you to easily generate CSV files from any SQL query.


All you need to do is set up a connection to the database in application.properties and add your queries to the query.json file.

Then you need to send a POST Request to localhost:8080/get with your query name, and parameters if your query need it.

An example of a POST query sent
