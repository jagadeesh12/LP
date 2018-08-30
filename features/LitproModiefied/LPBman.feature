
Feature: LitPro Bman 
  

  @bman @LAP-625
  Scenario Outline: Create Book in Bman application
   Given I launch Bman and browse to Create book page "<username>" and "<password>"
    Then I should see bman header
    When I create book in bman
    Then I should see sucess message for the book creation
    Then I create create quizzes in bman
    
    Examples: 
      | username       | password      | 
      | bookadmin      | Bookadmin@123 |