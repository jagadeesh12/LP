@f1 
Feature: LitPro Sanity - Flow One
  As a school teacher and student
  I should be able to do set of activities
  So that I can ..

  @student @common @wipl @smokeLP 
  Scenario: LitPro Common UI - Student
    When I launch LitPro as "Student"
    Then I should see Scholastic Literacy Pro Home Page
    And I should see user greeting text "Welcome, "
    And I should see below tabs:
      | Home | Search | My Results | LitPro Test |
    And I should see Logout link

  @admin @common @smokeLP 
  Scenario: LitPro Common UI - Admin
    When I launch LitPro as "Admin"
    Then I should see Scholastic Literacy Pro Home Page
    And I should see user greeting text "Welcome, "
    And I should see below tabs:
      | Home | Reports | Search | Settings | Benchmarks |
    And I should see Logout link

  @admin @importbooks @smokeLP
  Scenario: Import Books to Library
    Given I browse to In Library Page as 'CSRep'
    Then I should see In Library Page Header - "Match Your Library Books"
    When I select csv file
    And I click Upload button
    Then Import status should be "Done"

  @student @sanity @smokeLP 
  Scenario: Search as Student - Basic
    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    When I click on Search button without entering keyword
    Then 'You should enter at least one search criteria for the search.' notification should display
    When I search for books having title "Lorem Ipsum"
    Then 'Resource not found' notification should display
    When I search for books having title "John"
    Then Image view search results count should match with the dispayed count
    And Search results should show following columns in Image View:
      | Word Count | Lexile |
    And Book title or author name should contain the search key
    When I change the results view to "List View"
    Then Search results should show following columns in List View:
      | Library | Title | Author | Lexile | Word Count | Quiz |
    And List view search results count should match with the dispayed count
    And Book title or author name should contain the search key
    When I search for the author "Lipson"
    And I change the results view to "Image View"
    Then Image view search results count should match with the dispayed count
    And Book title or author name should contain the search key
    When I search for books having title "Pilot &"
    Then Image view search results count should match with the dispayed count
    And Book title or author name should contain the search key
    When I search for books having Title "Music" with Quiz
    Then Image view search results count should match with the dispayed count
    And Book title or author name should contain the search key
    And All books should have an associated Quiz

  @admin @settings @smokeLP 
  Scenario: Default Settings
    Given I browse to Settings Page as "Admin"
    Then I should see class name
    And I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | Yes     | NA            |
      | Limit reading list titles to only those in the school library | No      | NA            |
      | Limit number of books in reading list to                      | No      |               |
      | Show student Lexile measure after test completion             | Yes     | NA            |
      | Limit test access to certain days and times                   | No      | NA            |
      | Allow students to see their reading list                      | Yes     | NA            |
      | Limit reading list to titles with book quizzes                | Yes     | NA            |
      | Limit practice test to one per student                        | Yes     | NA            |
      | Allow students to change reading interests                    | Yes     | NA            |
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | Yes     | NA            |
      | Allow student to print                             | No      | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | No      | NA            |

  @admin @student @quiz @settings @myresults @smokeLP 
  Scenario: Change required settingsto take quiz, Take quiz and check results in My Results
    Given I browse to Settings Page as "Admin"
    Then I should see class name
    And I change following Quiz settings:
      | Setting Name                         | Action  | New Value |
      | Restrict number of quiz attempts to  | Check   | 99        |
      | Number of days between quiz attempts | Check   | 0         |
      | Display incorrect answers            | Uncheck | NA        |
      | Quiz pass mark                       | NA      | 10        |
      | Allow student to print               | Check   | NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    When As a student, I am on the search page showing results for word "Planet,Tale, Story, Book"
    And I click Take Quiz button for a random book
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I complete the quiz
    Then I should see score and percentage
    When I goto My Results page
    Then I should see book details on which quiz was taken
    And Score and Quiz date should match

  @admin @benchmark @smokeLP 
  Scenario: Benchmark UI
    Given I browse to Benchmark Page as "Admin"
    Then I should see Benchmark Page Page Header starting with "Benchmark Proficiency Bands for"
    And I should see default selected benchmark as "LitPro Standard"
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    When I click on Save
    Then 'Banchmark Saved' Message should display