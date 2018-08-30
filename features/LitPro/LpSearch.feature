@functional @search @regressionlp @wip1 @LpSearch.feature
Feature: Search Books and Authors
  As a LitPro User
  I should be able to search books
  So that I can ....


	@admin @sanity 
	Scenario Outline: Testing Allow students to search outside educational level setting
   	 Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
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
		Examples:
	  |username|password|usertype|
    |admin2|welcome1|admin|
  @student @sanity 
  Scenario Outline: Search as Student - Basic
    Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
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
    Examples:
    |username|password|usertype|
    |AryaStark|welcome1|student|

  @teacher @sanity 
  Scenario Outline: Search as School Teacher - Basic
    Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
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
    Examples:
    |username|password|usertype|
    |teacher1|welcome1|teacher|

  @admin 
  Scenario Outline: Search as School Admin - Basic
     Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
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
		Examples:
	  |username|password|usertype|
    |admin1|welcome1|admin|
  @student
  Scenario Outline: Search as Student - Advanced
     Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
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
      | Search Key | Options                           | Categories            |username|password|usertype|
      | Play       | Quizzes Only                      | Music & Art           |AryaStark|welcome1|student|
      | Laugh      |                                   | Animals & Pets, Humor |AryaStark|welcome1|student|
      | Laugh      | In My School Library              |                       |AryaStark|welcome1|student|
      | Laugh      | Quizzes Only,In My School Library |                       |AryaStark|welcome1|student|
      |            | In My School Library              |                       |AryaStark|welcome1|student|
      |            | In My School Library              | Music & Art           |AryaStark|welcome1|student|
      |            | Scholastic eBook Collections      |                       |AryaStark|welcome1|student|

  @teacher  
  Scenario Outline: Search as Teacher - Advanced
    Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
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
      | Search Key | Options                      | Education Levels | Lexile From | Lexile To | Points From | Points To | Categories    |username|password|usertype|
      | Planet     | Quizzes Only                 | Middle Primary   |             |           |             |           |               |teacher1|welcome1|teacher|
      | Planet     |                              | Lower Secondary        | 700         | 800       |             |           |               |teacher1|welcome1|teacher|
      | Planet     |                              |                  |             |           |             |           | Humor,Mystery |teacher1|welcome1|teacher|
      | Laugh      | In My School Library         |                  |             |           |             |           |               |teacher1|welcome1|teacher|
      |            | Scholastic eBook Collections |                  |             |           |             |           | Space         |teacher1|welcome1|teacher|

  @admin
  Scenario Outline: Search as Admin - Advanced
   Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
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
      | Search Key | Options                           | Education Levels              | Lexile From | Lexile To | Points From | Points To | Categories               | username|password|usertype|
      | Planet     | Quizzes Only                      |                               |             |           |             |           | Nature & the Environment |admin1|welcome1|admin|
      | Play       |                                   | Lower Primary, Higher Primary |             |           |             |           | History                  |admin1|welcome1|admin|
      | Play       |                                   |                               | 600         | 650       |             |           | Humor                    |admin1|welcome1|admin|
      | Planet     | Quizzes Only,In My School Library |                               |             |           |             |           |                          |admin1|welcome1|admin|
      | laugh      | Quizzes Only                      |                               |             |           | 5           | 8         |                          |admin1|welcome1|admin|
      |            | In My School Library              |                               |             |           |             |           | Humor,Mystery            |admin1|welcome1|admin|
      | Planet     | Quizzes Only                      | Middle Primary                |             |           |             |           |                          |admin1|welcome1|admin|
      | Planet     |                                   | Secondary                     | 700         | 800       |             |           |                          |admin1|welcome1|admin|
      | Planet     |                                   |                               |             |           |             |           | Humor,Mystery            |admin1|welcome1|admin|
      | Laugh      | In My School Library              |                               |             |           |             |           |                          |admin1|welcome1|admin|
      |            | Scholastic eBook Collections      |                               |             |           |             |           | Space                    |admin1|welcome1|admin|



  @teacher @sanity @incomplete 
    Scenario Outline: Search as School Teacher - Basic
    Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
    Then I should see Search Page Header "Search"
    When I search for books having title "david time hello lower"
    When I change the results view to "List View"
    Then I should verify that search result should be 300
    Examples:
    |username|password|usertype|
    |teacher1|welcome1|teacher|
      
      
  @teacher @sanity 
    Scenario Outline: Search as School Teacher - Basic
    Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
    #LP-686
    Then I should see Search Page Header "Search"
    When I search for books having title "J.K. Rowling"
    Then I should verify all the titles in the search tab
    And I should click on print button
    Then I should verify all the titles in the print window
     Examples:
    |username|password|usertype|
    |teacher1|welcome1|teacher|
    
    @admin @sanity 
    Scenario Outline: Verify that admin should be able to print the search result and print result should be same as search result
   Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
    #LP-686
    Then I should see Search Page Header "Search"
    When I search for books having title "J.K. Rowling"
    Then I should verify all the titles in the search tab
    And I should click on print button
    Then I should verify all the titles in the print window
    	Examples:
	  |username|password|usertype|
    |teacher1|welcome1|admin|
    
    @teacher @sanity 
    Scenario Outline: Verify that Teacher should be able to print the search result and print result should be same as search result
      Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
    #LP-686
    Then I should see Search Page Header "Search"
    When I search for books having title "J.K. Rowling"
    Then I should verify all the titles in the search tab
    And I should click on print button
    Then I should verify all the titles in the print window
    Examples:
     |username|password|usertype|
    |teacher1|welcome1|teacher|
    
     @student @sanity 
    Scenario Outline: Verify that stduent should be able to print the search result and print result should be same as search result
     Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
    #LP-686
    Then I should see Search Page Header "Search"
    When I search for books having title "Dune"
    Then I should verify all the titles in the search tab
    And I should click on print button
    Then I should verify all the titles in the print window are excatly same as search window
       Examples:
     |username|password|usertype|
    |AryaStark|welcome1|student|
    
    @teacher @sanity 
    Scenario Outline: Search as School Teacher for ebook icon and  intereset categories - Basic
      Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
    #LP-1516
    Then I should see Search Page Header "Search"
    When I search for books titles having all Ebook collection icons "Ann O. Squire"
    Then I should see the ebook icons indicator next to titles
       Examples:
     |username|password|usertype|
    |AryaStark|welcome1|teacher|
    
    @admin @sanity 
    Scenario Outline: Search as School Teacher - Basic
    Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
    #LP-1516
    Then I should see Search Page Header "Search"
    When I search for books titles having all Ebook collection icons "Ann O. Squire"
    Then I should see the ebook icons indicator next to titles
         Examples:
     |username|password|usertype|
    |admin1|welcome1|Admin|
    
    @admin @sanity
    Scenario Outline: Search as School Teacher - Basic
     Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
    #LP-1516
    Then I should see Search Page Header "Search"
    When I search for books titles having all Ebook collection icons "Ann O. Squire"
    Then I should see the ebook icons indicator next to titles search for student
    Examples:
    |username|password|usertype|
    |AryaStark|welcome1|student|