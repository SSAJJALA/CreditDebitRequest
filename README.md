# CreditDebitRequest
Credit/Debit Application work flow automation

Credit Debit application automates the work flow approvals for customer credits and bebits requisitions. A requisition is created by a sales person to give a credit/debit to his/her customer
based on the invoice. These are the adjustements for the items that are either returned by the customer or for damaged products. Once a requisition is filed, it goes thru atleast 2 approvals before 
getting approved completely. This application will route the requisitions to the appropriate approver and approver can check their inbox to see the waiting tasks.
Once an approver completes his task from the inbox, system check if there are any more approvals neded and routes appropriately. once all approvals are complete, status changes to 'complete'

User Interface:

Login: User authentication and authorization.

Home Page/Main Menu: Landing page to display all links to the application

Create CDR (Credit/Debit Request): This screen will allow the originator to create a new credit or debit request. It will have customer lookup, invoice lookup, calculate and submit options. Once a new request is submitted, system would generate a unique requisition ID to keep track of.

CDR Approval: Approvers can approve/reject a requisition. Approve action will move the request forward for next approval. reject would stop the approval process and change the status of request to 'Rejected'.

Inbox: Lists all tasks waiting for an approver to take an action.

CDR Search: Search facilitates the users to search the submitted requisitions by customer name or requisition id or all.


Database: 
Both transaction and maintenance data are stored in MySQL server database.

Technology: JavaEE, JSP, HTML, XML, MySQL Server, JDBC 