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

CDMR Approval: Approvers can approve/reject a requisition. Approve action will move the request forward for next approval. reject would stop the approval process and change the status of request to 'Rejected'.

Inbox: Lists all tasks waiting for an approver to take an action.

CDMR Search: Search facilitates the users to search the submitted requisitions by customer name or requisition id or all.

Manage Approvers: Admin page to set up the approvers information by admins

At a minimum, this application should provide:

    Create CDMR page to create a requisition
    Approve CDMR page and request routing
    Search functionality to cview the requisition and status
    Inbox page to get all tasks awaiting approver action
    
Optionally, application may provide:
    
    Admin page to manage the approvers and roles
    


Project Technologies/Techniques

Security/Authentication

    Admin Role: View, Manage the approvers
    Approver Role: view, cancel, approve, reject requisitions
    All: view requisitions
    
Database (MySQL and Hibernate)

    Store users and roles
    Store Requisition data
    Store Customer and Invoice information
    
Web Services or APIs:

    Planning to make the customer and invoice lookups as web service calls within the application.

Logging

    Configurable logging using Log4J. Logging can be set at error or debug level to facilitate trouble shooting

Unit Testing:

    Apply selenium webdriver testing for UI along with JUnit for code coverage.
    
Independent Research Topic
    
    Selenium Webdriver UI testing
