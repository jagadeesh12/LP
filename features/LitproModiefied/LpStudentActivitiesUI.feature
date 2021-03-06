 @regression13 @regressionlpset1 @dec16
Feature: Student Activities UI
  As a LitPro User
  I should be able to verify Student Activities UI
  So that I can detect any GUI issues

 @admin  
  Scenario: LitPro Student Activities UI for SA
    Given I browse to Report Page as "Admin"
    Then I should see header text for Reports page
    When I enter Reports search string "JonSnow"
    Then I should see header text for Reports page    
    And I should see the Student Activities UI elements
    And I should see the expected row content for the Quiz
    When I click Student Activity column headings the sort order changes

@teacher   
  Scenario: LitPro Student Activities UI for Teacher
    Given I browse to Report Page as "Teacher"
    Then I should see header text for Reports page
    When I enter Reports search string "JonSnow"
    Then I should see header text for Reports page    
    And I should see the Student Activities UI elements
    And I should see the expected row content for the Quiz
    When I click Student Activity column headings the sort order changes

   