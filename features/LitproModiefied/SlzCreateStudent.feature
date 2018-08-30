@login  
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
      
    @admin 
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
     |Rep Email | megha_user@mailinator.com |
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