@login  @SLZ2Smoke
Feature: Scholastic Learning Zone Login
  As a School Admin
  I should have access to Scholastic Learning Zone
  So that I can ..

    
     @admin 
  Scenario: Create Order Add Students Teachers and LP LPL Integration
    Given I am on Scholastic Learning Zone Login Page
     When I login with following credentials as csrep
      | UserName | rachna.pattnaik@mailinator.com | 
      | Password | welcome1 |
     Then I should see create order Page
     Then I search for admin "rachna.testok@mailinator.com"
     Then I must see "rachna.testok@mailinator.com" in search result
     
      
    