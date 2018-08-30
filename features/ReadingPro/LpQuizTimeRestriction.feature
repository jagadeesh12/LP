@regressionlp @quiztimerestrict 
Feature: LitPro Time Restriction Settings for a given Day for SRC Quiz
  As a LitPro User I should be able to change settings to restrict or allow students to take quizzes at specific times
  so I can ensure quizzes are taken only at the time I want

  #@admin  
  @quiz1 
  Scenario: Set Quiz restriction to not allow test at this time by SA at school level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I disable now as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed

  #@student  

  Scenario: Student attempts to take a quiz at a time that is restricted
    When I launch LitPro as "Student"
    Then I should see the available quizzes
    And I should see the Take Quiz button is disabled

#  @admin
  Scenario: Set Quiz restriction to allow test at this time by SA at school level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I enable now as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
  

#  @student
  Scenario: Student attempts to take a quiz at a time that is not restricted
    When I launch LitPro as "Student"
    Then I should see the available quizzes
    And I should see the Take Quiz button is enabled


#  @admin
  Scenario: Set Quiz restriction to not allow test at this time by SA at class level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I disable now as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed

#  @student
  Scenario: Student attempts to take a quiz at a time that is restricted
    When I launch LitPro as "Student"
    Then I should see the available quizzes
    And I should see the Take Quiz button is disabled

#  @admin
  Scenario: Set Quiz restriction to allow test at this time by SA at class level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I enable now as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed

#  @student
  Scenario: Student attempts to take a quiz at a time that is not restricted
    When I launch LitPro as "Student"
    Then I should see the available quizzes
    And I should see the Take Quiz button is enabled


#  @admin
  Scenario: Set Quiz restriction to not allow quiz at this time by SA at student level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "McCreery"
    Then I should see Settings Page Page Header starting with "Ed McCreery"
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I disable now as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed

#  @student
  Scenario: Student attempts to take a quiz at a time that is restricted
    When I launch LitPro as "Student"
    Then I should see the available quizzes
    And I should see the Take Quiz button is disabled


  @admin 
  Scenario: Set Quiz restriction to allow quiz at this time by SA at student level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "ReadingList ReadingList"
    Then I should see Settings Page Page Header starting with "ReadingList ReadingList"
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I enable now as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
  
  @student 
  Scenario Outline: Student attempts to take a quiz at a time that is not restricted
    Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
    Then I should see the available quizzes
    And I should see the Take Quiz button is enabled
    Examples: 
     | username       | password | usertype | 
     | ReadingList    | welcome1 | Student  | 
    