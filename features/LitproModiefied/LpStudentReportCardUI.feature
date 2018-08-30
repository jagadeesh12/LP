@regressionlp @studentreportcard @regressionlpfix @regressionlpset1
Feature: Student Report Card UI
  As a LitPro User
  I should be able to verify Student Report Card UI
  So that I can detect any GUI issues

@admin
  Scenario: LitPro Student Report Card UI as admin
    Given I browse to Report Page as "Admin"
    Then I should see header text for Reports page
    When I enter Reports search string "JonSnow"
    Then I should see header text for Reports page
    And I should see the Students Reading Report Card
    And I should see the Student Activities UI elements
    When I click the School Calendar arrow the calendar drop down displays
    When I click the View Report button the Student Lexile History Report displays    
    When I click the Print Options Print Parent Letter link the Parent letter displays
    When I click the Print Options Print Student Test link the Student Test displays
    When I click the Print Options Print Reading Report Card link the Print Reading Report Card displays
    When I click Student Activity column headings the sort order changes
    
@teacher 
  Scenario: LitPro Student Report Card UI as teacher
    Given I browse to Report Page as "Teacher"
    Then I should see header text for Reports page
    When I enter Reports search string "JonSnow"
    Then I should see header text for Reports page
    And I should see the Students Reading Report Card
    And I should see the Student Activities UI elements
    When I click the School Calendar arrow the calendar drop down displays
    When I click the View Report button the Student Lexile History Report displays    
    When I click the Print Options Print Parent Letter link the Parent letter displays
    When I click the Print Options Print Student Test link the Student Test displays
    When I click the Print Options Print Reading Report Card link the Print Reading Report Card displays
    When I click Student Activity column headings the sort order changes
  
  @admin
  Scenario: LitPro School admin Print award certificate in reading report card
    Given I browse to Settings Page as "admin"
    Then I should see class name
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 0         |
      | Limit number of books in reading list to          | Check   | 5         |
      | Allow students to see their reading list          | Check   | NA        |
      | Require students to take practice test            | Uncheck | NA        |
      | Limit reading list to titles with book quizzes    | Uncheck | NA        |
      | Limit practice test to one per student            | Uncheck | NA        |
      | Show student Lexile measure after test completion | Uncheck | NA        |
    And I should set the following settings for awards
      | Award Name | Value |
      | Gold       | 4   |
      | Silver     | 3   |
      | Bronze     | 2   |
      | Red        | 1   |
      | Blue       | 0   |
    And I click Save
    
    
    @admin 
  Scenario: LitPro School admin Print award certificate in reading report card
    Given I browse to Report Page as "Admin"
    Then I should see header text for Reports page
    When I enter Reports search string "JonSnow"
    Then I should see header text for Reports page
    Then I should see student certificate
    When I click on Print certificate in print option
    Then I should verify award certificate
    
    
       @admin 
  Scenario: LitPro Teacher Print award certificate in reading report card
    Given I browse to Settings Page as "teacher"
    Then I should see class name
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 0         |
      | Limit number of books in reading list to          | Check   | 5         |
      | Allow students to see their reading list          | Check   | NA        |
      | Require students to take practice test            | Uncheck | NA        |
      | Limit reading list to titles with book quizzes    | Uncheck | NA        |
      | Limit practice test to one per student            | Uncheck | NA        |
      | Show student Lexile measure after test completion | Uncheck | NA        |
    And I should set the following settings for awards
      | Award Name | Value |
      | Gold       | 4   |
      | Silver     | 3   |
      | Bronze     | 2   |
      | Red        | 1   |
      | Blue       | 0   |
    And I click Save
    
    
    @admin 
  Scenario: LitPro Teacher Print award certificate in reading report card
    Given I browse to Report Page as "Teacher"
    Then I should see header text for Reports page
    When I enter Reports search string "JonSnow"
    Then I should see header text for Reports page
    Then I should see student certificate
    When I click on Print certificate in print option
    Then I should verify award certificate
  
    
  Scenario: Verifying the Print student test in Student reading report card page collecting data
    Given I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button
    When I complete the Test and store the question data


  Scenario: Verifying the Print student test in Student reading report card page viewing and validating data
    Given I browse to Report Page as "Teacher"
    Then I should see header text for Reports page
    When I enter Reports search string "JonSnow"
    Then I should see header text for Reports page
    When I click on Print option
    When I Should click on Print Student Test option
    And I should validate the user data of print student test
	|Jon Snow|Class 4|Lui Class|
	Then I should verify the litpro logo
    Then I should Validate the test question taken by students
    
    
  #  @vikram
Scenario: Vaildating the Print reading report card 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	Then I should collect the all the data of the student "JonSnow"
    When I click on Print option
    When I Should click on Print Reading Report Card option
    And I should validate the user data of print Reading Report Card
	|Jon Snow|Class 4|Lui Class|
	Then I should verify the litpro logo
    Then I should Validate the Reading Report Card of the students "JonSnow"