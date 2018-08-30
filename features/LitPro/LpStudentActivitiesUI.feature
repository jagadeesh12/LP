@regressionlp @studentactivities @LPStudentActivitiesUI.feature
Feature: Student Activities UI
  As a LitPro User
  I should be able to verify Student Activities UI
  So that I can detect any GUI issues

  @admin
 Scenario Outline: LitPro Student Activities UI for SA
    Given I browse launch LitPro and browse to Report Page using "<username>" and "<password>" with "<usertype>"
    Then I should see header text for Reports page
    When I enter Reports search string "Ed McCreery"
    Then I should see header text for Reports page    
    And I should see the Student Activities UI elements
    And I should see the expected row content for the Quiz
    When I click Student Activity column headings the sort order changes
  Examples:
  |username|password|usertype|
  |WalterWhite|welcome1|Admin|

@teacher 
  Scenario Outline: LitPro Student Activities UI for Teacher
     Given I browse launch LitPro and browse to Report Page using "<username>" and "<password>" with "<usertype>"
    Then I should see header text for Reports page
    When I enter Reports search string "Ed McCreery"
    Then I should see header text for Reports page    
    And I should see the Student Activities UI elements
    And I should see the expected row content for the Quiz
    When I click Student Activity column headings the sort order changes
  Examples:
  |username|password|usertype|
	|TonyStark|welcome1|Teacher|
   