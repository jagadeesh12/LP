@functional @search @regressionlp @wip1
Feature: Search Books and Authors
  As a LitPro User
  I should be able to search books
  So that I can ....


	@admin @sanity 
	Scenario: Testing Allow students to search outside educational level setting
   	Given I browse to Settings Page as "admin"
   	When I click the Restore Defaults button
   	When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 0         |
      | Limit number of books in reading list to          | unCheck   | NA         |
      | Require students to take practice test            | Uncheck | NA        |
      | Limit reading list to titles with book quizzes    | Uncheck | NA        |
      | Limit practice test to one per student            | Uncheck | NA        |
      | Show student Lexile measure after test completion | Uncheck | NA        |
    And I change following Quiz settings:
      | Setting Name              | Action  | New Value |
      | Display incorrect answers | Uncheck | NA        |
      | Quiz pass mark            | NA      | 30        |
      | Allow student to print    | Check   | NA        |
      |Restrict number of quiz attempts to: |Check|99|
      |Number of days between quiz attempts:|Check| 0 |
    When I set the setting Allow students to search outside educational level to
   		| Educational Level | Value 	|
    	| Lower Primary		| Checked |
		| Middle Primary    | Checked   |
		| Upper Primary     | Checked |
    	| Lower Secondary   | Checked   |
    	| Middle Secondary  | Checked |
    	| Upper Secondary	| Checked	|
    #Lp-2471
    And I click Save
    Then 'Settings Saved' Message should be displayed

  @student @sanity 
  Scenario: Search as Student - Basic
    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    When I click on Search button without entering keyword
    Then 'You should enter at least one search criteria for the search.' notification should display
    When I search for books having title "Lorem Ipsum"
    Then 'Resource not found' notification should display
    When I search for books having title "Planets"
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

  @teacher @sanity 
  Scenario: Search as School Teacher - Basic
    Given I browse to Search Page as "Teacher"
    Then I should see Search Page Header "Search"
    When I click on Search button without entering keyword
    Then 'You should enter at least one search criteria for the search.' notification should display
    When I search for books having title "Lorem Ipsum"
    Then 'No Results Found' notification should display
    When I search for books having title "Skylar"
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

  @admin 
  Scenario: Search as School Admin - Basic
    Given I browse to Search Page as "Admin"
    Then I should see Search Page Header "Search"
    When I click on Search button without entering keyword
    Then 'You should enter at least one search criteria for the search.' notification should display
    When I search for books having title "Lorem Ipsum"
    Then 'No Results Found' notification should display
    When I search for books having title "Skylar"
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

  @student
  Scenario Outline: Search as Student - Advanced
    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    When I type search key - <Search Key>
    And I select search options - <Options>
    And I click 'Select categories of books' link
    And I select categories - <Categories>
    And I click Search button
    Then Image view search results count should match with the dispayed count
    And Book title or author name should contain the search key
    And Take quiz button should be present if 'Quizzes Only' option is selected
    And In Library Icon should be present if 'In My School Library' option is selected
    And Lit Pro Library Icon should be present if 'Scholastic eBook Collections' option is selected
    And Book category should match with <Categories>

    Examples: 
      | Search Key | Options                           | Categories            |
      | Play       | Quizzes Only                      | Music & Art           |
      | Laugh      |                                   | Animals & Pets, Humor |
      | Laugh      | In My School Library              |                       |
      | Laugh      | Quizzes Only,In My School Library |                       |
      |            | In My School Library              |                       |
      |            | In My School Library              | Music & Art           |
      |            | Scholastic eBook Collections      |                       |

  @teacher  
  Scenario Outline: Search as Teacher - Advanced
    Given I browse to Search Page as "Teacher"
    Then I should see Search Page Header "Search"
    When I type search key - <Search Key>
    And I select search options - <Options>
    And I click 'Additional Search Options' link
    And I select education levels - <Education Levels>
    And I type lexile range <Lexile From> - <Lexile To>
    And I type points range <Points From> - <Points To>
    And I select categories - <Categories>
    And I click Search button
    Then Image view search results count should match with the dispayed count
    And Book title or author name should contain the search key
    And View quiz button should be present if 'Quizzes Only' option is selected
    And In Library Icon should be present if 'In My School Library' option is selected
    And Lit Pro Library Icon should be present if 'Scholastic eBook Collections' option is selected
    And Book Education Level should be one of <Education Levels>
    And Book lexile range should fall between <Lexile From> and <Lexile To>
    And Book points range should fall between <Points From> and <Points To>
    And Book category should match with <Categories>

    Examples: 
      | Search Key | Options                      | Education Levels | Lexile From | Lexile To | Points From | Points To | Categories    |
      | Planet     | Quizzes Only                 | Middle Primary   |             |           |             |           |               |
      | Planet     |                              | Lower Secondary        | 700         | 800       |             |           |               |
      | Planet     |                              |                  |             |           |             |           | Humor,Mystery |
      | Laugh      | In My School Library         |                  |             |           |             |           |               |
      |            | Scholastic eBook Collections |                  |             |           |             |           | Space         |

  @admin
  Scenario Outline: Search as Admin - Advanced
    Given I browse to Search Page as "Admin"
    Then I should see Search Page Header "Search"
    When I type search key - <Search Key>
    And I select search options - <Options>
    And I click 'Additional Search Options' link
    And I select education levels - <Education Levels>
    And I type lexile range <Lexile From> - <Lexile To>
    And I type points range <Points From> - <Points To>
    And I select categories - <Categories>
    And I click Search button
    Then Image view search results count should match with the dispayed count
    And Book title or author name should contain the search key
    And View quiz button should be present if 'Quizzes Only' option is selected
    And In Library Icon should be present if 'In My School Library' option is selected
    And Lit Pro Library Icon should be present if 'Scholastic eBook Collections' option is selected
    And Book Education Level should be one of <Education Levels>
    And Book lexile range should fall between <Lexile From> and <Lexile To>
    And Book points range should fall between <Points From> and <Points To>
    And Book category should match with <Categories>

    Examples: 
      | Search Key | Options                           | Education Levels              | Lexile From | Lexile To | Points From | Points To | Categories               |
      | Planet     | Quizzes Only                      |                               |             |           |             |           | Nature & the Environment |
      | Play       |                                   | Lower Primary, Higher Primary |             |           |             |           | History                  |
      | Play       |                                   |                               | 600         | 650       |             |           | Humor                    |
      | Planet     | Quizzes Only,In My School Library |                               |             |           |             |           |                          |
      | laugh      | Quizzes Only                      |                               |             |           | 5           | 8         |                          |
      |            | In My School Library              |                               |             |           |             |           | Humor,Mystery            |
      | Planet     | Quizzes Only                      | Middle Primary                |             |           |             |           |                          |
      | Planet     |                                   | Secondary                     | 700         | 800       |             |           |                          |
      | Planet     |                                   |                               |             |           |             |           | Humor,Mystery            |
      | Laugh      | In My School Library              |                               |             |           |             |           |                          |
      |            | Scholastic eBook Collections      |                               |             |           |             |           | Space                    |



  @teacher @sanity @incomplete 
    Scenario: Search as School Teacher - Basic
    Given I browse to Search Page as "Teacher"
    Then I should see Search Page Header "Search"
    When I search for books having title "david time hello lower"
    When I change the results view to "List View"
    Then I should verify that search result should be 300
    
      
      
  @teacher @sanity 
    Scenario: Search as School Teacher - Basic
    Given I browse to Search Page as "Teacher"
    #LP-686
    Then I should see Search Page Header "Search"
    When I search for books having title "J.K. Rowling"
    Then I should verify all the titles in the search tab
    And I should click on print button
    Then I should verify all the titles in the print window
    
    
    @admin @sanity 
    Scenario: Verify that admin should be able to print the search result and print result should be same as search result
    Given I browse to Search Page as "admin"
    #LP-686
    Then I should see Search Page Header "Search"
    When I search for books having title "J.K. Rowling"
    Then I should verify all the titles in the search tab
    And I should click on print button
    Then I should verify all the titles in the print window
    
    
    @teacher @sanity 
    Scenario: Verify that Teacher should be able to print the search result and print result should be same as search result
    Given I browse to Search Page as "Teacher"
    #LP-686
    Then I should see Search Page Header "Search"
    When I search for books having title "J.K. Rowling"
    Then I should verify all the titles in the search tab
    And I should click on print button
    Then I should verify all the titles in the print window
    
    
     @student @sanity 
    Scenario: Verify that stduent should be able to print the search result and print result should be same as search result
    Given I browse to Search Page as "student"
    #LP-686
    Then I should see Search Page Header "Search"
    When I search for books having title "Dune"
    Then I should verify all the titles in the search tab
    And I should click on print button
    Then I should verify all the titles in the print window are excatly same as search window
    
    @teacher @sanity 
    Scenario: Search as School Teacher for ebook icon and  intereset categories - Basic
    Given I browse to Search Page as "Teacher"
    #LP-1516
    Then I should see Search Page Header "Search"
    When I search for books titles having all Ebook collection icons "Ann O. Squire"
    Then I should see the ebook icons indicator next to titles
    
    @admin @sanity 
    Scenario: Search as School Teacher - Basic
    Given I browse to Search Page as "Admin"
    #LP-1516
    Then I should see Search Page Header "Search"
    When I search for books titles having all Ebook collection icons "Ann O. Squire"
    Then I should see the ebook icons indicator next to titles
    
    @admin @sanity
    Scenario: Search as School Teacher - Basic
    Given I browse to Search Page as "student"
    #LP-1516
    Then I should see Search Page Header "Search"
    When I search for books titles having all Ebook collection icons "Ann O. Squire"
    Then I should see the ebook icons indicator next to titles search for student