@login  
Feature: Scholastic Learning Zone Login
  As a School Admin
  I should have access to Scholastic Learning Zone
  So that I can ..

  @admin @Fixtrq9 
  Scenario: Create Order 
    Given I am on Scholastic Learning Zone Login Page
     When I login with following credentials as csrep
      | UserName | kHegde-consultant@scholastic.com | 
      | Password | welcome1                       | 
     Then I should see create order Page
     When I search for School "breaking bad 6"
     Then I should see "Breaking bad 6" as header
     When I click on slz access link 
     Then I must go to manage users Page
     Then I select student "AryaStark"
     Then I Must see student changes to different class 
     
     
     
      
   
      
     

     
