 @regressionlp @regressionlpfix @regressionlpset4 
Feature: LitPro Tests, Metrics, Reports and Charts
  As a LitPro User
  I should be able to changes Test and Quiz Setting
  So that I can ....

  @sanity 
  Scenario: Change required settingsto take test
    Given I browse to Settings Page as "Teacher"
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
      | Require students to take practice test            | Uncheck | NA        |
    And I change following Quiz settings:
      | Setting Name              | Action  | New Value |
      | Display incorrect answers | Uncheck | NA        |
      | Quiz pass mark            | NA      | 30        |
      | Allow student to print    | Check   | NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed

  @sanity 
  Scenario: Take Test 
    Given I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button
    And I complete the assessment
    Then Home Page should be shown

#LAP-573
  @sanity 
  Scenario: Metrics, Charts and Reports
    Given I browse to Metrics section of Home Page as "Admin"
    Then I should see Header Text stating with "Metrics for"
    And Metrics Section should display following metrics
      | Metric Name                     | Value Type |
      | Average Lexile                  | String     |
      | Average Lexile Growth This Year | String     |
      | Average Quiz Score              | Percentage |
      | Number of Quizzes Taken         | Number     |
      | Quiz Pass Rate                  | Percentage |
      | Words Read                      | Number     |
    And Following charts should display
      | Chart Name      |
      | Expected Growth |
      | Proficiency     |
    When I browse to Reports page
    Then I should see following reports link
      | Report Name                    |
      | Lexile Growth Report           |
      | Lexile Compared to Norm Report |
      | Reading Proficiency Report     |
      | Expected Lexile Growth Report  |
      | Book Comprehension Report      |
      | Quiz Pass Rate Report          |
    When I open "Lexile Growth Report" report
    Then Popup should open with header "Lexile Growth Report"
    When I search report card for student "JonSnow"
    Then I should see report card with following items
      | Report Element Name                |
      | Current Lexile                     |
      | Lexile Growth                      |
      | Date of Last Completed LitPro Test |
      | Proficiency Band                   |
      | # of Quizzes Passed/Attempted      |
      | Average Quiz Score                 |
      | Average Lexile of Quizzes Passed   |
      | Words Read                         |
      | Quiz Points Earned                 |
      | Teacher-Added Points               |
   Then I should see student grade level and class info on their reading report card so I have it as a reference
  
     @sanity @June27  @defect
  Scenario: Take Test edit reading List 
    Given I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button
    And I complete the assessment
    Then Home Page should be shown
    Then validate with edit or create reading list
    And I should see the following reading interest categories in modal popup:
      | Reading Interest Categories  |
      | Action & Adventure           |
      | Animals & Pets               |
      | Biographies                  |
      | Celebrations                 |
      | Classics                     |
      | Folktales & Legends          |
      | Food & Drink                 |
      | Friends, Family & Growing Up |
      | History                      |
      | Miscellaneous                |
      | Music & Art                  |
      | Mystery                      |
      | Nature & the Environment     |
      | Romance & Relationships      |
      | Science & Technology         |
      | Science Fiction & Fantasy    |
      | Space                        |
      | Sports & Hobbies             |
      | World Cultures & Geography   |
    And I will deselect the selected reading interest categories
    Then I select different reading interest categories
    And I click on corresponding list button
    Then I should be able to view my updated reading interest categories
      
       @sanity 
  Scenario: Take Test edit reading List 
    Given I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button
    Then I should see the following data in directions popup :
      | Directions For each item, you will read a short passage and then complete a sentence about what you've  read. Select your answer by choosing the word that best completes the sentence. When you are ready, select the  button or press the Enter key to move on to the next question. If you want to skip a question, select the  button. You may skip up to three questions. |
      
  
   Scenario: Change required settingsto take test and Test Notification
    Given I browse to Settings Page as "Teacher"
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
      | Require students to take practice test            | Uncheck | NA        |
    And I change following Quiz settings:
      | Setting Name              | Action  | New Value |
      | Display incorrect answers | Uncheck | NA        |
      | Quiz pass mark            | NA      | 30        |
      | Allow student to print    | Check   | NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed

  @sanity 
  Scenario: Take Test and Pause  
    Given I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button
    And I will take test and pause it 
    
    
    Scenario: Check for the notification  
    Given I browse to Report Page as "Admin"
    Then I should see header text for Reports page
    When I enter Reports search string "Lui"
    Then I should see header text for Reports page
    Then I should see Test Incomplete notification
    Then I should see tooltip as "Jon Snow"
    
    @sanity @lpfix1
  Scenario: Take Test and Completer  
    Given I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button
    And I complete the assessment 
    
     @lpfix1 
    Scenario: Notification is not displayed 
    Given I browse to Report Page as "Admin"
    Then I should see header text for Reports page
    When I enter Reports search string "Lui"
    Then I should see header text for Reports page
    Then I should not see Test Incomplete notification
    
    
    