@functional @test @regressionlp
Feature: LitPro Tests, Metrics, Reports and Charts
  As a LitPro User
  I should be able to changes Test and Quiz Setting
  So that I can ....

@student  @sanity 
  Scenario Outline: Change required settingsto take test
      Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
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
    And I change following Quiz settings:
      | Setting Name              | Action  | New Value |
      | Display incorrect answers | Uncheck | NA        |
      | Quiz pass mark            | NA      | 30        |
      | Allow student to print    | Check   | NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Examples:
     | username       | password | usertype | 
     | TonyStark    		| welcome1 | Teacher  | 

@student  @sanity 
  Scenario Outline: Take Test
    Given I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button
    And I complete the assessment
    And I click 'Create My Reading list' Button
    Then Home Page should be shown

@teacher  @sanity 
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
    When I search report card for student "StudOne"
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
  
   @student  @sanity @June27
  Scenario: Take Test edit reading List 
    Given I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button
    And I complete the assessment
    And I click 'Create My Reading list' Button
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
      | Humor                        |
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
      
     @student  @sanity 
  Scenario: Take Test edit reading List 
    Given I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button
    Then I should see the following data in directions popup :
      | DirectionsData  |
      | Directions           |
      | For each item, you will read a short passage and then complete a sentence about what you've  read               |
      | button or press the Enter key to move on to the next question                  |  
      
      
      
      