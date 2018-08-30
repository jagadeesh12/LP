@login  @SLZ2Smoke
Feature: Scholastic Learning Zone Login
  As a School Admin
  I should have access to Scholastic Learning Zone
  So that I can ..

  @admin  
  Scenario: Create Order 
    Given I am on Scholastic Learning Zone Login Page
     When I login with following credentials as csrep
      | UserName | kHegde-consultant@scholastic.com | 
      | Password | welcome1                       | 
     Then I should see create order Page
     Then I create organization with following details
     | customer Group | International |           
     | customer Type  | Library - International |
     | org Type       | Public| 
      Then I should see Success Creation Message
      
   

    
     @admin @slzcreation1 @QAdata1
  Scenario: Create Order Add Students Teachers and LP LPL Integration
    Given I am on Scholastic Learning Zone Login Page
     When I login with following credentials as csrep
      | UserName | kHegde-consultant@scholastic.com | 
      | Password | welcome1 |
     Then I should see create order Page
      Then I create organization with following details
     | customer Group | International |           
     | customer Type  | Library - International |
     | org Type       | Public| 
      Then I should see Success Creation Message
     When I create new order with following orderline details 
     | Product Type  | intl Product | 
     | Product | Literacy Pro |
     |Rep Email | smoke.stressuser@mailinator.com |
     Then I should see order lines Created with "Literacy Pro"
     Then I create another order with following details 
       | Product Type  | intl Product | 
     | Product | Literacy Pro Library - US |
     |Rep Email | megha_user@mailinator.com |
      Then I should see order lines Created with "Literacy Pro Library - US"
     When I click on create order button
     Then I should see successful order creation message 
     Then I should see Slz order details Page 
     When I click on slz access link 
     Then I must go to manage users Page  
     When I upload "Students" to the organisation 
     Then I should see "Students" in Accounts uploaded
     When I upload "Teachers" to the organisation
     Then I should see "Teachers" in Accounts uploaded
     When I add Administrator manually
     Then I should see administrator created
     Then I click on litpro subscibed product
     Then I must navigate to Litpro Home Page 
     When I search for book Black hole 
     When I click on ReadBook 
     Then I should see corresponding book 
     Then I must navigate to Litpro Library 
     When I click on quiz button
     Then I must navigate to litrpo home with Quizz popup
     Then I must see quizz header corresponding to the book
     When I click on ViewQuizz header
     Then I should see Quizzes
      
         
 @admin 
  Scenario: Edit Order details and Verify
     Given I am on Scholastic Learning Zone Login Page
     When I login with following credentials as csrep
      | UserName | kHegde-consultant@scholastic.com | 
      | Password | welcome1 |
     Then I should see create order Page
      Then I create organization with following details
     | customer Group | International |           
     | customer Type  | Library - International |
     | org Type       | Public| 
      Then I should see Success Creation Message
     When I create new order with following orderline details 
     | Product Type  | intl Product | 
     | Product | Literacy Pro |
     |Rep Email | smoke.stressuser@mailinator.com |
     Then I should see order lines Created with "Literacy Pro"
     When I click on create order button
     Then I should see successful order creation message 
     When I edit order by Extended sales amount and license count 
     When I click update order
     Then I must see updated sales amount and license count
     
     @SLZ2Smoke 
     Scenario: Forgot Password 
     Given I am on Scholastic Learning Zone Login Page
     When I click on Forgot password link
     Then I should see Error Messages
     
     
       @admin @slzcreation
   Scenario Outline: Create Order Add Students Teachers and LP LPL Integration
    Given I am on Scholastic Learning Zone Login Page
     When I login with following credentials as csrep
      | UserName | kHegde-consultant@scholastic.com | 
      | Password | welcome1 |
     Then I should see create order Page
      Then I create organization with following details with "<customer Group>" with "<customer Type>" with "<org Type>" with "<Orgname>"
      Then I should see Success Creation Message
     When I create new order with following orderline details 
     | Product Type  | intl Product | 
     | Product | Literacy Pro |
     |Rep Email | smoke.stressuser@mailinator.com |
     Then I should see order lines Created with "Literacy Pro"
     Then I create another order with following details 
       | Product Type  | intl Product | 
     | Product | Literacy Pro Library - US |
     |Rep Email | megha_user@mailinator.com |
      Then I should see order lines Created with "Literacy Pro Library - US"
     When I click on create order button
     Then I should see successful order creation message 
     Then I should see Slz order details Page 
     When I click on slz access link 
     Then I must go to manage users Page  
     When I upload "Students" to the organisation 
     Then I should see "Students" in Accounts uploaded
     When I upload "Teachers" to the organisation
     Then I should see "Teachers" in Accounts uploaded
     When I add Administrator manually
     Then I should see administrator created
     Then I subscribe Subscribtion to Students
     Then I subscribe subscriptions to Teachers and edit password
     Then I subscribe subscriptions to Admin and edit password
     Examples:
     | customer Group | customer Type          | org Type  |Orgname      |
     | International  |Library - International | Public    |breaking bad 1|
     | International  |Library - International | Public    |breaking bad 2|
     | International  |Library - International | Public    |breaking bad 3|
     | International  |Library - International | Public    |breaking bad 4|
     | International  |Library - International | Public    |breaking bad 5|
     | International  |Library - International | Public    |breaking bad 6|
     
     
    
	@admin @xmlcreated
Scenario: Creating XML's for the user logins
	Given I am on Scholastic Learning Zone Login Page 
	When I login with following credentials as csrep 
		| UserName | kHegde-consultant@scholastic.com | 
		| Password | welcome1 |
	Then I should create an XML and store the URL 
		|Student Name|
		|breaking bad 6|
		|breaking bad 1|
		|breaking bad 2|
		|breaking bad 3|
		|breaking bad 4|
		|breaking bad 5|

			@admin @xmlcreated
Scenario: Create XML's for CSrep user logins
	Given I am on Scholastic Learning Zone Login Page 
	When I login with following credentials as csrep 
		| UserName | kHegde-consultant@scholastic.com | 
		| Password | welcome1 |
	Then I should create an XML and store the URL for CSrep
		|Student Name|
		|breaking bad 6|
