Lack of **isolation** potentially causes what the database literature calls anomalies. An anomaly is when a transaction reads or 
writes data in a way that it wouldn’t if transactions were executed one at time. When an anomaly occurs, the outcome of executing
sagas *concurrently* is different than if they were executed *serially*.

*The lack of isolation can cause the following three anomalies*
- **Lost updates:** One saga overwrites without reading changes made by another saga.
- **Dirty reads:** A transaction or a saga reads the updates made by a saga that has not yet completed those updates.
- **Fuzzy/nonrepeatable reads:** Two different steps of a saga read the same data and get different results because another saga has made updates.

This above mentioned **anomalies** can be prevented or reduced by these counter measures..
- **Semantic lock :** An application-level lock.
- **Commutative updates :** Design update operations to be executable in any order.
- **Pessimistic view :** Reorder the steps of a saga to minimize business risk.
- **Reread value :** Prevent dirty writes by rereading data to verify that it’s unchanged before overwriting it.
- **Version file :** Record the updates to a record so that they can be reordered.

To understand the countermeasures we need to first understand the different types of transactions SAGA has.
- **Compensatable transactions :** Transactions that can potentially be rolled back using a compensating transaction.
- **Pivot transaction :** The go/no-go point in a saga. If the pivot transaction commits, the saga will run until completion. 
A pivot transaction can be a transaction that’s neither compensatable nor retriable.
- **Retriable transactions :** Transactions that follow the pivot transaction and are guaranteed to succeed.
