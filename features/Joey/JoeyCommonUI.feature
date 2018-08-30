@joeySmoke
Feature: Joey Common UI
As a Teacher 
I should be able to login 
so that I can see all tabs in home page 

@Teacher12
Scenario: Joey Login page 
    When I launch Joye as "Teacher"
    Then I should see Prime Professional Learning Home page 
    And I should see user "Welcome, "
    And I should see below tabs in joey Home Page:
    |All Topics|Reports|
    And I should see Search bar
    And I should see Logout link in joey home Page
    
    @Teacher12  @joey
Scenario: Joey Take Assessment 
    When I launch Joye as "Teacher"
    Then I should see Prime Professional Learning Home page 
    And I should see user "Welcome, "
    When I click on Assessment Quiz Button 
   Then Assessment Header has to be displayed
   Then I should see Quiz header
   And I complete Quiz
   Then Quiz completed message has to be displayed