Feature: As a Student 
Login grants me access to applications that I am entitled to 

Background:
Given a Student is Logged into DP Portal

Scenario: Student in Grades K-3 with entitlements to LitPro Library is granted access
	  
Given Student with <UserName> in Grades K-3 with entitlement <Entitlements> is logged in
When user selects LitPro Library icon 
Then Application Launches In A New Browser Tab 
And the user lands on the My Profile screen
And <Username> is displayed 

 Examples: Student Accounts with valid credentials
  | UserName                  | Password  | Entitlements         |
  | RusselB1                  | paw18     |  N/A                 |
