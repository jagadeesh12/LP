 @regressionlp  
Feature: LitPro Settings
  As a LitPro User
  I should be able to changes Test and Quiz Setting
  So that I can ....

   @sanity @dec12 @regressionlpset3
  Scenario: Default Settings
    Given I browse to Settings Page as "admin"
    Then I should see class name  
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
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

  @sanity @regressionlpset3
  Scenario: Change Settings and Save
    Given I browse to Settings Page as "admin"
    Then I should see class name 
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed     
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 2         |
      | Limit number of books in reading list to          | Check   | 5         |
      | Require students to take practice test            | Uncheck | NA        |
      | Limit reading list to titles with book quizzes    | Uncheck | NA        |
      | Limit practice test to one per student            | Uncheck | NA        |
      | Show student Lexile measure after test completion | Uncheck | NA        |
   # Then I should validate time zone
    And I change following Quiz settings:
      | Setting Name              | Action  | New Value |
      | Display incorrect answers | Uncheck | NA        |
      | Quiz pass mark            | NA      | 30        |
      | Allow student to print    | Check   | NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    


    
     @sanity @regressionlpset3
  Scenario: Testing Allow students to see their reading list setting by unchecking
    Given I browse to Settings Page as "teacher"
    Then I should see class name
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed    
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 50        |
      |	Allow students to see their reading list		  | Uncheck  | NA		|
      | Require students to take practice test            | check 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Uncheck | NA|
      | Limit practice test to one per student            | Check 	| NA        |
      | Limit number of books in reading list to          | Uncheck	| NA        |
      | Allow students to change reading interests		  | Check	|NA			|
      | Show student Lexile measure after test completion | Check 	| NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
    When I launch LitPro as "Student"
	Then I should see Scholastic Literacy Pro Home Page
    And I should see user greeting text "Welcome, "
   	Then I should not see Home tab
  
   @sanity @admintest @regressionlpset3
  Scenario: Testing Allow students to see their reading list setting by checking
    Given I browse to Settings Page as "Teacher"
    Then I should see class name     
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 50        |
      |	Allow students to see their reading list		  |	Check  | NA		|
      | Require students to take practice test            | check 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Uncheck | NA|
      | Limit practice test to one per student            | Check 	| NA        |
      | Limit number of books in reading list to          | Uncheck	| NA        |
      | Allow students to change reading interests		  | Check	|NA			|
      | Show student Lexile measure after test completion | Check 	| NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
    When I launch LitPro as "Student"
	Then I should see Scholastic Literacy Pro Home Page
    And I should see user greeting text "Welcome, "
   	Then I should see Home tab
   	
   	   @sanity  @SmokeLP @regressionlpset3 
  Scenario Outline: Testing Show student Lexile measure after test completion Setting checked
    Given I browse to Settings Page as "admin"
    Then I should see class name
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 0        |
      |	Allow students to see their reading list			    |Check  | NA		|
      | Require students to take practice test            | Uncheck 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Uncheck | NA|
      | Limit practice test to one per student            | Uncheck 	| NA        |
      | Limit number of books in reading list to          | Uncheck	| NA        |
      | Allow students to change reading interests		  | Check	|NA			|
      | Show student Lexile measure after test completion | Check 	| NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	 Given I launch Litpro and browse to LitPro Test Page using "<username>" and "<password>" with "<userType>"
    Then I should see welcome message with get started button
    When I click on lets get started button
    And I complete the assessment
    Then I should see the lexile score
   	Examples: 
      | username       | password | usertype | 
      | ReadingList    | welcome1 | Student  |
   	
   @sanity 
  Scenario: Testing Minimum number of days between completed tests: setting by 0 days
    Given I browse to Settings Page as "admin"
    Then I should see class name
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 0        |
      |	Allow students to see their reading list			|Check  | NA		|
      | Require students to take practice test            | check 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Uncheck | NA|
      | Limit practice test to one per student            | Check 	| NA        |
      | Limit number of books in reading list to          | Uncheck	| NA        |
      | Allow students to change reading interests		  | Check	|NA			|
      | Show student Lexile measure after test completion | Check 	| NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
    When I launch LitPro as "Student"
	Then I should see Scholastic Literacy Pro Home Page
    And I should see user greeting text "Welcome, "
    Then I should see LitPro Test tab enabled
    
   @sanity @regressionlpset3
  Scenario: Testing Minimum number of days between completed tests: setting by 55 days
    Given I browse to Settings Page as "admin"
    Then I should see class name
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 55        |
      |	Allow students to see their reading list			|Check  | NA		|
      | Require students to take practice test            | check 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Uncheck | NA|
      | Limit practice test to one per student            | Check 	| NA        |
      | Limit number of books in reading list to          | Uncheck	| NA        |
      | Allow students to change reading interests		  | Check	|NA			|
      | Show student Lexile measure after test completion | Check 	| NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
    When I launch LitPro as "Student"
    Then I should see LitPro Test tab disabled
    
  @sanity @regressionlpset3 @jun2711
  Scenario Outline: Testing Limit reading list to titles with book quizzes setting checked
    Given I browse to Settings Page as "admin"
    Then I should see class name
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 50        |
      |	Allow students to see their reading list			|Check  | NA		|
      | Require students to take practice test            | check 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Uncheck | NA|
      | Limit practice test to one per student            | Check 	| NA        |
      | Limit number of books in reading list to          | Uncheck	| NA        |
      | Allow students to change reading interests		  | Check	|NA			|
      | Show student Lexile measure after test completion | Check 	| NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
    And I should see user greeting text "Welcome, "
    Then I should see already created reading list
    Then I should see all the books with the quizzes button
Examples: 
      | username       | password | usertype | 
      | ReadingList    | welcome1 | Student  | 
      
      
  @sanity @regressionlpset3 
 Scenario Outline: Testing Limit reading list titles to only those in the school library setting checked
    Given I browse to Settings Page as "admin"
   	Then I should see class name
   	 When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
   	When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 50        |
      |	Allow students to see their reading list			|Check  | NA		|
      | Require students to take practice test            | check 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Check | NA|
      | Limit practice test to one per student            | Check 	| NA        |
      | Limit number of books in reading list to          | Uncheck	| NA        |
      | Allow students to change reading interests		  | Check	|NA			|
      | Show student Lexile measure after test completion | Check 	| NA        |
   When I set the setting Allow students to search outside educational level to
   		| Educational Level | Value 	|
    	| Lower Primary		| Checked |
		| Middle Primary    | Checked   |
		| Upper Primary     | Checked |
    	| Lower Secondary   | Checked   |
    	| Middle Secondary  | Checked |
    	| Upper Secondary	| Checked	|
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
    And I should see user greeting text "Welcome, "
    Then I should see already created reading list
    Then I should see all the books with inlib icon
Examples: 
      | username       | password | usertype | 
      | ReadingList    | welcome1 | Student  | 


 @sanity @regressionlpset3
  Scenario Outline: Testing Limit number of books in reading list to:10 Setting checked
    Given I browse to Settings Page as "admin"
    Then I should see class name
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
     
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 50        |
      |	Allow students to see their reading list			|Check  | NA		|
      | Require students to take practice test            | check 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Uncheck | NA|
      | Limit practice test to one per student            | Check 	| NA        |
      | Limit number of books in reading list to          | Check	| 10        |
      | Allow students to change reading interests		  | Check	|NA			|
      | Show student Lexile measure after test completion | Check 	| NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
    And I should see user greeting text "Welcome, "
    Then I should see already created reading list
    Then I should see only 10 books in reading list
Examples: 
      | username       | password | usertype | 
      | ReadingList    | welcome1 | Student  | 

      
	 @sanity @regressionlpset3
  Scenario Outline: Testing Allow students to change reading interests Setting checked
    Given I browse to Settings Page as "admin"
    Then I should see class name
      When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 50        |
      |	Allow students to see their reading list			|Check  | NA		|
      | Require students to take practice test            | check 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Uncheck | NA|
      | Limit practice test to one per student            | Check 	| NA        |
      | Limit number of books in reading list to          | Uncheck	| NA        |
      | Allow students to change reading interests		  | Check	|NA			|
      | Show student Lexile measure after test completion | Check 	| NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
    And I should see user greeting text "Welcome, "
    Then I should see already created reading list
    Then I should see Edit Reading Interests button
	Examples: 
      | username       | password | usertype | 
      | ReadingList    | welcome1 | Student  | 
      
      
      
       @sanity  @regressionlpset3
  Scenario Outline: Testing Allow students to change reading interests Setting Unchecked
    Given I browse to Settings Page as "admin"
    Then I should see class name 
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 50        |
      |	Allow students to see their reading list			|Check  | NA		|
      | Require students to take practice test            | check 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Uncheck | NA|
      | Limit practice test to one per student            | Check 	| NA        |
      | Limit number of books in reading list to          | Uncheck	| NA        |

      | Allow students to change reading interests		  | UnCheck	|NA			|
      | Show student Lexile measure after test completion | Check 	| NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
    And I should see user greeting text "Welcome, "
    Then I should see already created reading list
    Then I should not see Edit Reading Interests button
	Examples: 
      | username       | password | usertype | 
      | ReadingList    | welcome1 | Student  | 
      
      
  @sanity @regressionlpset3  @manual
  Scenario: Testing Require students to take practice test Setting checked
    Given I browse to Settings Page as "admin"
   	Then I should see class name
   	  When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 0        |

      |	Allow students to see their reading list			| Check  | NA		|
      | Require students to take practice test            | check 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Uncheck | NA|

      | Limit practice test to one per student            | Uncheck 	| NA        |
      | Limit number of books in reading list to          | Uncheck	| NA        |
      | Allow students to change reading interests		  | Check	|NA			|
      | Show student Lexile measure after test completion | Check 	| NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	Given I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button

    #LP-50
    #When I should be shown practise test while taking test    
    
   @sanity @regressionlpset3 @regressionlpset31
  Scenario: Testing Show student Lexile measure after test completion Setting Unchecked
    Given I browse to Settings Page as "admin"
    Then I should see class name
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 0        |
      |	Allow students to see their reading list			|Check  | NA		|
      | Require students to take practice test            | check 	| NA        |
      | Limit reading list to titles with book quizzes    | Check 	| NA        |
      | Limit reading list titles to only those in the school library | Uncheck | NA|
      | Limit practice test to one per student            | Check 	| NA        |
      | Limit number of books in reading list to          | Uncheck	| NA        |
      | Allow students to change reading interests		  | Check	|NA			|
      | Show student Lexile measure after test completion | Uncheck 	| NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	Given I browse to LitPro Test Page as "Student"
    Then I should see welcome message with get started button
    When I click on lets get started button
    When I complete the Test
    Then I should not see the lexile score
    
   @sanity 
  Scenario: Testing Display incorrect answers Setting checked
    Given I browse to Settings Page as "admin"
    Then I should see class name
      When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
     And I change following Quiz settings:
      | Setting Name              				| Action  | New Value |
      | Display incorrect answers 				| check | NA        |
      | Restrict number of quiz attempts to 	| check	  | 33|
      | Number of days between quiz attempts: 	| check   | 0 | 
      | Quiz pass mark            				| NA      | 90        |
      | Allow student to print    				| Check   | NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    When I search for random book
    And I click Take Quiz button for a random book
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I complete the quiz
    Then Verify that View Incorrect Answers button is visible
    
    
   @sanity @regressionlpset3
  Scenario: Testing Display incorrect answers Setting Unchecked
    Given I browse to Settings Page as "admin"
    Then I should see class name
      When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
     And I change following Quiz settings:
      | Setting Name              				| Action  | New Value |
      | Display incorrect answers 				| Uncheck | NA        |
      | Restrict number of quiz attempts to 	| check	  | 33|
      | Number of days between quiz attempts: 	| check   | 0 | 
      | Quiz pass mark            				| NA      | 90        |
      | Allow student to print    				| Check   | NA        |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    When I search for random book
    And I click Take Quiz button for a random book
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I complete the quiz
    Then Verify that View Incorrect Answers button should be Invisible


###########################################################################################
   @sanity @regressionlpset5  @settingstest12
  Scenario: Testing Restrict number of quiz attempts Setting to 0
    Given I browse to Settings Page as "admin"
    Then I should see class name 
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
	And I change following Quiz settings:
      | Setting Name              				| Action  | New Value |
      | Display incorrect answers 				| check | NA        |
      | Restrict number of quiz attempts to 	| check	  | 0|
      | Number of days between quiz attempts: 	| check   | 0 | 
      | Quiz pass mark            				| NA      | 90        |
      | Allow student to print    				| Check   | NA        |
       And I click Save
       Then 'Settings Saved' Message should be displayed
       Then I logout
  	Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    When I search for random book
    And I click Take Quiz button for a random book
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I complete the quiz
    Then I should see score and percentage
    When I search for above book again
    And I should not be able to take a quiz for the above random book again
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup for error
    Then I should see the error message
        
    
   @sanity @regressionlpset5 @testfixmay29 @settingstest
  Scenario: Testing Restrict number of quiz attempts Setting to 99
    Given I browse to Settings Page as "admin"
    Then I should see class name
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed    
    And I change following Quiz settings:
      | Setting Name              				| Action  | New Value |
      | Display incorrect answers 				| check | NA        |
      | Restrict number of quiz attempts to 	| check	  | 99|
      | Number of days between quiz attempts: 	| check   | 0 | 
      | Quiz pass mark            				| NA      | 90        |
    #Above value should be between 1 to 99
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    When I search for random book
    And I click Take Quiz button for a random book
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I complete the quiz
    Then I should see score and percentage
    When I search for above book again
    And I should not be able to take a quiz for the above random book again
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    Then I should be able to take a quiz again for the above book
    
  @sanity @regressionlpset5 @settingstest
 Scenario Outline:  Testing Allow student to print Setting checked
    Given I browse to Settings Page as "admin"
    Then I should see class name
      When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    And I change following Quiz settings:
      | Setting Name              				| Action  | New Value |
      | Display incorrect answers 				| check | NA        |
      | Restrict number of quiz attempts to 	| check	  | 33|
      | Number of days between quiz attempts: 	| check   | 0 | 
      | Quiz pass mark            				| NA      | 90        |
      | Allow student to print    				| Check   | NA        |
      | Allow student to print certificate		| Check	|NA|
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
   	Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
    And I should see user greeting text "Welcome, "
    Then I should see already created reading list
    Then I should see print button in student home tab
    Then I should see print button in student search tab
    When I should see print button in student My results tab
    
Examples: 
     | username       | password | usertype | 
     | ReadingList    | welcome1 | Student  | 
     
     
     
   @sanity @regressionlpset5 @settingstest
  Scenario: Testing Number of days between quiz attempts Setting to 0
    Given I browse to Settings Page as "admin"
    Then I should see class name
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    And I change following Quiz settings:
      | Setting Name              				| Action  | New Value |
      | Display incorrect answers 				| check | NA        |
      | Restrict number of quiz attempts to 	| check	  | 99|
      | Number of days between quiz attempts: 	| check   | 0 | 
      | Quiz pass mark            				| NA      | 90        |
      | Allow student to print    				| Check   | NA        |
      | Allow students to search outside educational level | No      | NA            |
   	And I click Save
   	Then 'Settings Saved' Message should be displayed
   	Then I logout
  	Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    When I search for random book
    And I click Take Quiz button for a random book
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I complete the quiz
    Then I should see score and percentage
    When I search for above book again
    And I should not be able to take a quiz for the above random book again
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    Then I should be able to take a quiz again for the above book 
    
        
   @sanity @regressionlpset5 @settingstest
  Scenario:   Testing Number of days between quiz attempts Setting to 99
  Given I browse to Settings Page as "admin"
   	Then I should see class name
   	 When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    And I change following Quiz settings:
      | Setting Name              				| Action  | New Value |
      | Display incorrect answers 				| check | NA        |
      | Restrict number of quiz attempts to 	| check	  | 99|
      | Number of days between quiz attempts: 	| check   | 99 | 
      | Quiz pass mark            				| NA      | 90        |
      | Allow student to print    				| Check   | NA        |
    #Above value should be between 1 to 99
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    When I search for random book
    And I click Take Quiz button for a random book
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I complete the quiz
    Then I should see score and percentage
    When I search for above book again
    And I should not be able to take a quiz for the above random book again
    Then I should see quiz popup with header text starting with "Quizzes for"
    Then I should click Take Quiz button in Quiz Popup and verify error message for the above book
    
    
   @sanity  @SmokeLP @settingstest
  Scenario: Testing Quiz pass mark: Setting to 20
   
  	Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    When I search for random book
    And I click Take Quiz button for a random book
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I complete the quiz
    Then I should see score and percentage and verify if student passed or failed
    
    
   @sanity @regressionlpset5 @settingstest
  Scenario: Testing Awards are based on: points earned Setting
   	Given I browse to Settings Page as "admin"
   	Then I should see class name
   	 When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    And I should set the following settings for awards
      | Award Name | Value |
      | Gold       | 5   |
      | Silver     | 4   |
      | Bronze     | 3   |
      | Red        | 2   |
      | Blue       | 1   |
    And I click Save
    Then 'Settings Saved' Message should be displayed
    Then I logout
  	When I launch LitPro as "Student"
    Then I should see Scholastic Literacy Pro Home Page
    And I should see user greeting text "Welcome, "
    When I click on My Results tab
    Then Verify that correct certificate is shown to user
      | Award Name | Value |
      | Gold       | 5   |
      | Silver     | 4   |
      | Bronze     | 3   |
      | Red        | 2   |
      | Blue       | 1   |
      
      
      
   @sanityiii @regressionlpset5 @settingstest
  Scenario: Testing Allow students to search outside educational level setting
   	Given I browse to Settings Page as "admin"
    Then I should see class name
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed   
    When I set the setting Allow students to search outside educational level to
   		| Educational Level | Value 	|
    	| Lower Primary		| unChecked |
		| Middle Primary    | Checked   |
		| Upper Primary     | unChecked |
    	| Lower Secondary   | Checked   |
    	| Middle Secondary  | unChecked |
    	| Upper Secondary	| unChecked	|
    #Lp-2471
   	#Then I should validate the order of education level
    And I click Save
    Then 'Settings Saved' Message should be displayed
    When I should go to search tab
    Then I should search as a teacher for book "slim"
    Then I should select Educational Levels in search
    	| Search Educational Level 	| Search Value 	|
    	| Lower Primary		| unChecked |
		| Middle Primary    | Checked   |
		| Upper Primary     | unChecked |
    	| Lower Secondary   | Checked   |
    	| Middle Secondary  | unChecked |
    	| Upper Secondary	| unChecked	|
    Then I logout
  	Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    Then I should search as student for book "slim"
    Then I should validate the titles with admin results
    
   @sanity
  Scenario: Testing Allow students to see their reading list setting by unchecking
    Given I browse to Settings Page as "admin"
    Then I should see class name
    #LP-2003
    Then I should verify tooltips for setting Limit reading list titles to only those in the school library "Checking this setting will limit the titles in the student's reading list to only those that have been matched using the Library Match feature."
    #LP-1466
    Then I should verify tooltips for setting Allow students to search outside educational level "Checking this setting will give the student access to titles that have an age-level designation that falls outside the student's grade range."
    Then I should verify tooltips for setting Awards are based on "Click on a number to edit the value."
    
      @sanity @regressionlpset5 @settingstest
  Scenario: validate time zone of LitPro Test and Quiz Settings
    Given I browse to Settings Page as "admin"
    Then I should see class name
     When I click the Restore Defaults button
    Then Settings Restored Message should be displayed    
    When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 0         |
      | Require students to take practice test            | Uncheck | NA        |
      | Limit reading list to titles with book quizzes    | Uncheck | NA        |
      | Limit practice test to one per student            | Uncheck | NA        |
      | Show student Lexile measure after test completion | Uncheck | NA        |
      | Limit test access to certain days and times       | Check      | NA            |
    Then I should validate time zone of LitPro Test Settings
    And I change following Quiz settings:
      | Setting Name              | Action  | New Value |
      | Display incorrect answers | Uncheck | NA        |
      | Quiz pass mark            | NA      | 30        |
      | Allow student to print    | Check   | NA        |
      |Limit quiz access to certain days and times|Check   | NA |
    Then I should validate time zone of LitPro Quiz Settings
    And I click Save
    Then 'Settings Saved' Message should be displayed
    
    
    
  #LP-19  
  @sanity  @regressionlpset8 @settingstest
  Scenario: As a CS rep I should be able to see and adjust the advanced settings for the schools
    Given I browse to Litpro as 'CSRep'
     When I change following Test settings:
      | Setting Name                                      | Action  | New Value |
      | Minimum number of days between completed tests    | Check   | 0         |
      | Limit number of books in reading list to          | Check   | 5         |
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
    And I click Save 
    Then 'Settings Saved' Message should be displayed
    #Then I should close the window
    
#LAP-585
@sanity @regressionlpset5 @settingstest 
Scenario: I should see the see my rating button after passing the quiz 
	Given I browse to Settings Page as "admin" 
	Then I should see class name 
	When I click the Restore Defaults button 
	Then Settings Restored Message should be displayed 
	And I change following Quiz settings: 
		| Setting Name              				| Action  | New Value |
		| Display incorrect answers 				| check | NA        |
		| Restrict number of quiz attempts to 	| check	  | 99|
		| Number of days between quiz attempts: 	| check   | 0 | 
		| Quiz pass mark            				| NA      | 00        |
		| Allow student to print    				| Check   | NA        |
	And I click Save 
	Then 'Settings Saved' Message should be displayed 
	Then I logout 
	Given I browse to Search Page as "Student" 
	Then I should see Search Page Header "Search" 
	When I search for random book 
	And I click Take Quiz button for a random book 
	Then I should see quiz popup with header text starting with "Quizzes for" 
	When I click Take Quiz button in Quiz Popup 
	And I complete the quiz
	And I should enter the comments "This book look good"
	Then I should see score and percentage 
	When I search for above book again 
	And I should see my rating button. verify the book title and book comment "This book look good"
	When I click on My Results tab 
	Then I should verify See My Book Rating button for the above book. verify the book title and book comment "This book look good"
	And I should Click on "Print My Results"
	Then I should Click on "Print All My Comments"
	And I should validate the user data of See my comments in my results
	|Jon Snow		|Class 4|Lui Class	|
	And I should validate the title of See my comments in my results
	| Date | Title | Author| Score| Student Rating|
	And I should see the comments "This book look good" for above books in my result
	
#LAP-585
@sanity @regressionlpset5 @settingstest  
Scenario: I should see the see my rating button after passing the quiz 
	Given I browse to Report Page as "admin" 
	When I enter Reports search string "JonSnow"
	Then I should click on View All Comments button
	And I should validate the user data of See my comments
	|Jon Snow		|Class 4|Lui Class|
	And I should validate the title of See my comments
	| Date | Book Title | Author| Score| Student Rating|
	And I should see the comments "This book look good" for above books
	
	#LAP-585
	@sanity @regressionlpset5 @settingstest 
Scenario: I should see the see my rating button after passing the quiz 
	Given I browse to Report Page as "teacher" 
	When I enter Reports search string "JonSnow"
	Then I should click on View All Comments button
	And I should validate the user data of See my comments
	|Jon Snow|Class 4|Lui Class|
	And I should validate the title of See my comments
	| Date | Book Title | Author| Score| Student Rating|
	And I should see the comments "This book look good" for above books
	
	@sanity  @regressionlpset3 @123123 @LAP628
  Scenario: Roster Tree sorting
    Given I browse to Settings Page as "admin"
    Then I should see class name 
    And I shoud see students in roster tree must be sorted by lastname 
    
   @sanity  @regressionlpset3 @123123 @LAP-622
  Scenario Outline: Reading List Grade Verification
    Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
    And I should see user greeting text "Welcome, "
    Then I should see already created reading list
    And I store all reading list book names to verify in Admin
    Then I logout
    Given I browse to Search Page as "Admin" 
	  Then I should see Search Page Header "Search" 
  	When I type search key from reading list
	 # And I select search options - <Options> 
	  And I click 'Additional Search Options' link 
	  And I select education levels - <Education Levels>  
	  And I click Search button
	  Then I must see book in search Result with middle primary 
	Examples: 
      | username       | password | usertype | Education Levels |
      | ReadingList    | welcome1 | Student  | Upper Primary   |
      