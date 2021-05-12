### Introduction

**ACID** (Atomicity, Consistency, Isolation, Durability) transactions greatly simplify the job of the developer by providing the 
illusion that each transaction has exclusive access to the data. In a microservice architecture, transactions that are within a
single service can still use ACID transactions. The challenge, however, lies in implementing transactions for operations that 
update data owned by multiple services as each microservice holds its own database.

Transactionality in microservice systems can be realized by applying some well-known design patterns like **SAGA**.
SAGA, a message-driven sequence of local transactions, to maintain data consistency. One challenge with sagas is that 
they are ACD (Atomicity, Consistency,Durability). They lack the isolation feature of traditional ACID transactions.

