#Builds the app
mvn clean install

#Run
java -jar target/demo-0.0.1-SNAPSHOT.jar

#test data
POST
http://localhost:8080/api/v1/transaction
{"type":"CREDIT","amount":100.01}

POST
http://localhost:8080/api/v1/transaction
{"type":"DEBIT","amount":10.01}

