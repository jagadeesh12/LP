@regressionlp  @quizdatetime 
Feature: LitPro Time Restriction Settings for a given Day for SRC Quiz
  As a LitPro User I should be able to change settings to restrict or allow students to take quizzes at specific times
  so I can ensure quizzes are taken only at the time I want

  @admin  
  Scenario: Set Quiz restriction to defaults
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed

  @student  
  Scenario: Student attempts to take a quiz with default settings


    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    Then I should search as student for book "slim"
    And I should see the Take Quiz button is enabled in search

  @admin
  Scenario: Set Quiz restriction to not allow quiz today by SA at school level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I disable today as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
     Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    Then I should search as student for book "slim"
    And I should see the Take Quiz button is disabled in search








  @admin 
  Scenario: Set Quiz restriction to not allow test at this time by SA at school level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I disable now as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed

  @student  
  Scenario: Student attempts to take a quiz at a time that is restricted


    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    Then I should search as student for book "slim"
    Then I should see the Take Quiz button is disabled in search

  @admin 
  Scenario: Set Quiz restriction to allow test at this time by SA at school level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I enable now as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed

  @student 
  Scenario: Student attempts to take a quiz at a time that is not restricted


    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    Then I should search as student for book "slim"
    And I should see the Take Quiz button is enabled in search

  @admin  
  Scenario: Set Quiz restriction to not allow quiz today by SA at class level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Lui Class"
    Then I should see Settings Page Page Header starting with "Lui Class"
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I disable today as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    Then I should search as student for book "slim"
    And I should see the Take Quiz button is disabled in search







  @admin  
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

  @admin  
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

  @student  
  Scenario: Student attempts to take a quiz at a time that is not restricted


    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    Then I should search as student for book "slim"
    And I should see the Take Quiz button is enabled in search


  @admin  
  Scenario: Set Quiz restriction to not allow quiz today by SA at student level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Jon Snow"
    Then I should see Settings Page Page Header starting with "Jon Snow"
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I disable today as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed

  @student   
  Scenario: Student attempts to take a quiz on a day that is restricted


    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    Then I should search as student for book "slim"
    Then I should see the Take Quiz button is disabled in search

  @admin  
  Scenario: Set Quiz restriction to not allow test at this time by SA at student level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Jon Snow"
    Then I should see Settings Page Page Header starting with "Jon Snow"
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I disable now as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed

  @student 
  Scenario: Student attempts to take a quiz on a day that is restricted


    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    Then I should search as student for book "slim"
    Then I should see the Take Quiz button is disabled in search


  @admin 
  Scenario: Set Quiz restriction to allow test at this time by SA at student level
    Given I browse to Settings Page as "admin"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Jon Snow"
    Then I should see Settings Page Page Header starting with "Jon Snow"
    When I click Limit quiz access to certain days and times
    Then I should see the day and time controls
    When I enable now as a permitted time to take a quiz
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
  
  @student 
  Scenario: Student attempts to take a quiz at a time that is not restricted


    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    Then I should search as student for book "slim"
    And I should see the Take Quiz button is enabled in search
    