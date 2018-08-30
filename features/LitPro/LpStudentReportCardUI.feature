@regressionlp @studentreportcard @LpStudentReportCardUI.feature
Feature: Student Report Card UI
  As a LitPro User
  I should be able to verify Student Report Card UI
  So that I can detect any GUI issues

@admin 
  Scenario Outline: LitPro Student Report Card UI

    Given I browse launch LitPro and browse to Report Page using "<username>" and "<password>" with "<usertype>"
    Then I should see header text for Reports page
    When I enter Reports search string "Ed McCreery"
    Then I should see header text for Reports page
    And I should see the Students Reading Report Card
    And I should see the Student Activities UI elements
    When I click the School Calendar arrow the calendar drop down displays
    When I click the View Report button the Student Lexile History Report displays    
    When I click the Print Options Print Parent Letter link the Parent letter displays
    When I click the Print Options Print Student Test link the Student Test displays
    When I click the Print Options Print Reading Report Card link the Print Reading Report Card displays
    When I click Student Activity column headings the sort order changes
	Examples:
	|username|password|usertype|
	|admin1|welcome1|Admin|
    
@teacher
  Scenario Outline: LitPro Student Report Card UI
     Given I browse launch LitPro and browse to Report Page using "<username>" and "<password>" with "<usertype>"
    Then I should see header text for Reports page
    When I enter Reports search string "Ed McCreery"
    Then I should see header text for Reports page
    And I should see the Students Reading Report Card
    And I should see the Student Activities UI elements
    When I click the School Calendar arrow the calendar drop down displays
    When I click the View Report button the Student Lexile History Report displays    
    When I click the Print Options Print Parent Letter link the Parent letter displays
    When I click the Print Options Print Student Test link the Student Test displays
    When I click the Print Options Print Reading Report Card link the Print Reading Report Card displays
    When I click Student Activity column headings the sort order changes
  Examples:
  |username|password|usertype|
	|teacher1|welcome1|Teacher|
  @admin
  Scenario Outline: LitPro School admin Print award certificate in reading report card
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    Then I should see class name
    And I should set the following settings for awards
      | Award Name | Value |
      | Gold       | 4   |
      | Silver     | 3   |
      | Bronze     | 2   |
      | Red        | 1   |
      | Blue       | 0   |
    And I click Save
    Examples:
  |username|password|usertype|
	|admin1|welcome1|Admin|
    
    
    @admin 
  Scenario Outline: LitPro School admin Print award certificate in reading report card
   Given I browse launch LitPro and browse to Report Page using "<username>" and "<password>" with "<usertype>"
    Then I should see header text for Reports page
    When I enter Reports search string "Jon Snow"
    Then I should see header text for Reports page
    Then I should see student certificate
    When I click on Print certificate in print option
    Then I should verify award certificate
  Examples:
  |username|password|usertype|
	|admin1|welcome1|Admin| 
    
       @admin 
  Scenario Outline: LitPro Teacher Print award certificate in reading report card
  Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    Then I should see class name
    And I should set the following settings for awards
      | Award Name | Value |
      | Gold       | 4   |
      | Silver     | 3   |
      | Bronze     | 2   |
      | Red        | 1   |
      | Blue       | 0   |
    And I click Save
    Examples:
  |username|password|usertype|
	|teacher1|welcome1|teacher| 
    
    @admin 
  Scenario Outline: LitPro Teacher Print award certificate in reading report card
    Given I browse launch LitPro and browse to Report Page using "<username>" and "<password>" with "<usertype>"
    Then I should see header text for Reports page
    When I enter Reports search string "Arya Stark"
    Then I should see header text for Reports page
    Then I should see student certificate
    When I click on Print certificate in print option
    Then I should verify award certificate
    Examples:
    |username|password|usertype|
    |teacher1|welcome1|teacher|