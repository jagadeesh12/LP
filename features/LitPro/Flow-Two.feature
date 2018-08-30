 @f2 @flow-Two.feature
Feature: LitPro Sanity - Flow Two
  As a school teacher and student
  I should be able to do set of activities
  So that I can ..

  @teacher @common @smokeLP 
  Scenario: LitPro Common UI - Teacher
    When I launch LitPro as "Teacher"
    Then I should see Scholastic Literacy Pro Home Page
    And I should see user greeting text "Welcome, "
    And I should see below tabs:
      | Home | Reports | Search | Settings | Benchmarks |
    And I should see Logout link

 
   @teacher @sanity @smokeLP 
   Scenario Outline: Search as Teacher - Basic
   Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    Then I should see Search Page Header "Search"
    When I click on Search button without entering keyword
    Then 'You should enter at least one search criteria for the search.' notification should display
    When I search for books having title "Lorem Ipsum"
    Then 'No Results Found' notification should display
    When I search for books having title "Fire Snow"
    Then Image view search results count should match with the dispayed count
    And Search results should show following columns in Image View:
      | Title | Author | Lexile Code | Lexile | GRL | Points |
    And Book title or author name should contain the search key
    When I change the results view to "List View"
    Then Search results should show following columns in List View:
      | Library | Title | Author | Lexile Code | Lexile | GRL | Points |
    And List view search results count should match with the dispayed count
    And Book title or author name should contain the search key
    When I search for the author "Lipson"
    And I change the results view to "Image View"
    Then Image view search results count should match with the dispayed count
    And Book title or author name should contain the search key
    When I search for books having Title "Music" with Quiz
    Then Image view search results count should match with the dispayed count
    And Book title or author name should contain the search key
    And All books should have an associated Quiz
    Examples:
  |username|password|usertype|
	|TonyStark|welcome1|Teacher|
 
  @teacher @student @test  @reports @metrics @smokeLP
  Scenario Outline: Change Settings, Take Test,  Metrics, Charts and Reports
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
    When I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button
    And I complete the assessment
    And I click 'Create My Reading list' Button
    Then Home Page should be shown
    Given I browse to Metrics section of Home Page as "Teacher"
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
Examples:
  |username|password|usertype|
	|TonyStark|welcome1|Teacher|