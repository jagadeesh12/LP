Feature: LP Manager Feature
  As a School Admin
  I should have access to Scholastic Learning Zone
  So that I can ..

 @CSrep 
  Scenario: Uplaoding books as csrep
    Given I am on Scholastic Learning Zone Login Page
    When I login with following credentials as csrep
      | UserName | kHegde-consultant@scholastic.com |
      | Password | welcome1                         |
    Then I should search for the school "breaking bad 6"
    Then I should enter by pass through
    Then I should open Litpro
    When I open the manager
    Then I should open the "SOAR Test Import" page
    When I should create the SRI Import File "sriUpload"
	When I enter the ORGID in SOAR test import
    Then I should confirm that school is correct
    When I Upload the SRI Import File "sriUpload"
	Then I should verify the uplaoded data
 
 
 @CSrep
  Scenario Outline: Uplaoding quizzes for Teacher created quiz
    Given I am on Scholastic Learning Zone Login Page
    When I login with following credentials as csrep
      | UserName | kHegde-consultant@scholastic.com |
      | Password | welcome1                         |
    Then I should search for the school "breaking bad 6"
    Then I should enter by pass through
    Then I should open Litpro
    When I open the manager
    Then I should open the Quizzes page
    Then I will create a CSV file with - Title <Title> author FirstName <Author Firstname> Author LastName<Author Lastname>
    When I should uplaod the CSV file
    Then I should validate the uplaoded CSV Quizzes
    Then I should click Next button to complete the process
	Examples: 
		| Title  					| Author Firstname 	| Author Lastname |
		| Froggy Builds A Tree House| Jonathan      	| London          |
		
		
		@CSRep
  Scenario: Uplaoding books as csrep
    Given I am on Scholastic Learning Zone Login Page
    When I login with following credentials as csrep
      | UserName | kHegde-consultant@scholastic.com |
      | Password | welcome1                         |
    Then I should search for the school "breaking bad 6"
    Then I should enter by pass through
    Then I should open Litpro
    When I open the manager
    Then I should open the Books Import Export page
    When I uplaod the book XML file "BookUploadXML"
    
    
#above feature file and bellow feature file are dependent on each other so I have not specified what book keywood it should look for 
 @admin @regressionlpset1  
  Scenario: View Teacher created quiz as Admin
    Given I browse to Search Page as "Admin"
    When I search for the book for which quizzes where added
    And I Click on View quiz button of the book
    Then I should validate the data of the quizzes

@teacher @regressionlpset1
  Scenario: View Teacher created quiz as Teacher
    Given I browse to Search Page as "Teacher"
    When I search for the book for which quizzes where added
    And I Click on View quiz button of the book
    Then I should validate the data of the quizzes

@LAP-6251
Scenario: Checking of SyncLog functionality 
    Given I am on Scholastic Learning Zone Login Page
    When I login with following credentials as csrep
      | UserName | kHegde-consultant@scholastic.com |
      | Password | welcome1                         |
    Then I should search for the school "breaking bad 6"
    Then I should enter by pass through
    Then I should open Litpro
    When I open the manager
    Then I should open SyncLog
    Then I should see Synclog button is activated
