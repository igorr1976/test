#Builds the app
mvn clean install

#Run
java -jar target/demo-0.0.1-SNAPSHOT.jar

#test add transaction
#CREDIT
method: POST
application/json
http://localhost:8080/api/v1/transaction
{"type":"CREDIT","amount":100.01}

#DEBIT
method: POST
application/json
http://localhost:8080/api/v1/transaction
{"type":"DEBIT","amount":10.01}

#open
http://localhoste:8080