 @regressionlp @regressionlpfi @regressionlpreportdatacreation
Feature: LitPro Settings 
	As a LitPro User
  I should be able to changes Test and Quiz Setting
  So that I can ....
  
  @student  @regressionlpreportdatacreation
 @admin @student @quiz @settings @myresults
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
    
    
    @change123  @regressionlpreportdatacreation 
    Scenario Outline: Take test for all students 
    Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
    And I should see user greeting text "Welcome, "
    Then I navigate to the search page showing results for word "Planet,Tale, Story, Book"
    And I click Take Quiz button for a random book
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I complete the quiz
    Then I should see score and percentage
Examples: 
      | username  | password | usertype | 
      |JoeMartina | welcome1 | Student  |
	    |EdMcCreery | welcome1 | Student  |
	    |JonSnow    | welcome1 | Student  |
	    |AryaStark  | welcome1 | Student  | 
    
     @regressionlpreportdatacreation   
    Scenario: Change required settingsto take test
    Given I browse to Settings Page as "Admin"
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

  @sanity     @datacreation  @regressionlpreportdatacreation 
  Scenario Outline: Take test for all students 
    Given I launch Litpro and browse to LitPro Test Page using "<username>" and "<password>" with "<userType>"
    Then I should see welcome message with get started button
    When I click on lets get started button
    And I complete the assessment
    And I click 'Create My Reading list' Button
    Then Home Page should be shown
    Examples: 
      | username  | password | usertype | 
      |JoeMartina | welcome1 | Student  |
	    |EdMcCreery | welcome1 | Student  |
	    |JonSnow    | welcome1 | Student  |
	    |AryaStark  | welcome1 | Student  |
    
    
 
  Scenario: Collecting test data of all the students
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
    Then I should collect the data of all students
    |Student Name|
    |JoeMartina|
	  |EdMcCreery|
	  |JonSnow|
	  |AryaStark|
     

    @repbr1
    Scenario: Vaildating the data of Lexile Compared to Norm Report at class level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
    When I search for the class "Lui Class"
    When I Click on View Reprot button of "Lexile Compared to Norm Report"
    Then I should see then report header as "Lexile Compared to Norm Report"
    And I click on 'table' button
    Then I should see negatieve BR on Lexile Compared to Norm Report
	
	
	
     @repbr1
    Scenario: Vaildating the data of Lexile Compared to Norm Report at Grade level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
	When I select grade "Class 5" for the grade dropdown
	When I Click on View Reprot button of "Lexile Compared to Norm Report"
    Then I should see then report header as "Lexile Compared to Norm Report"
    And I click on 'table' button
     Then I should see negatieve BR for Lexile Compared to Norm Report at Grade "5" level for Student

    @repbr1
    Scenario: Vaildating the data of Lexile Compared to Norm Report at school level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
	  When I go to "breaking bad 6" for school level reprot validation.
	  When I Click on View Reprot button of "Lexile Compared to Norm Report"
    Then I should see then report header as "Lexile Compared to Norm Report"
    And I click on 'table' button
    Then I should see negatieve BR on Lexile Compared to Norm Report at school level for Student

	
    @repbr1
    Scenario: Vaildating the data of Reading Proficiency Report Report at class level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
    When I search for the class "Lui Class"
	When I Click on View Reprot button of "Reading Proficiency Report"
    Then I should see then report header as "Reading Proficiency Report"
    And I click on 'table' button
	 Then I should see negatieve BR on Reading Proficiency Report for "Lui Class" class level for Student


 	
  

    @repbr1
    Scenario: Vaildating the data of Lexile Growth Report at Class level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
    When I search for the class "Lui Class"
	  When I Click on View Reprot button of "Lexile Growth Report"
    Then I should see then report header as "Lexile Growth Report"
    And I click on 'table' button
   Then I should see negatieve BR on Lexile Growth Report for "Lui Class" class level for Student

     @repbr1
    Scenario: Vaildating the data of Lexile Growth Report at Grade level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
	When I select grade "Class 5" for the grade dropdown
	When I Click on View Reprot button of "Lexile Growth Report"
    Then I should see then report header as "Lexile Growth Report"
    And I click on 'table' button
  Then I should see negatieve BR on Lexile Growth Report at Grade "5" level for Student
    
    
     @repbr1
    Scenario: Vaildating the data of Lexile Growth Report at school level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
    When I go to "breaking bad 6" for school level reprot validation.
	When I Click on View Reprot button of "Lexile Growth Report"
    Then I should see then report header as "Lexile Growth Report"
    And I click on 'table' button
   Then I should see negatieve BR on Lexile Growth Report at School level for Student


     @repbr1
    Scenario: Vaildating the data of Expected Lexile Growth Report at Class level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
    When I search for the class "Lui Class"
	When I Click on View Reprot button of "Expected Lexile Growth Report"
    Then I should see then report header as "Expected Lexile Growth Report"
    And I click on 'table' button
	Then I should see negatieve BR on Expected Lexile Growth Report for "Lui Class" class level for Student

   @repbr1
 Scenario: Vaildating the data of Expected Lexile Growth Report at grade level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
    When I select grade "Class 5" for the grade dropdown
	  When I Click on View Reprot button of "Expected Lexile Growth Report"
    Then I should see then report header as "Expected Lexile Growth Report"
    And I click on 'table' button
	  Then I should see negatieve BR on Expected Lexile Growth Report at Grade "5" level for Student

   @repbr1
Scenario: Vaildating the data of Expected Lexile Growth Report at Class level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
    When I go to "breaking bad 6" for school level reprot validation.
	When I Click on View Reprot button of "Expected Lexile Growth Report"
    Then I should see then report header as "Expected Lexile Growth Report"
    And I click on 'table' button
	Then I should see negatieve BR on Expected Lexile Growth Report at School level for Student

    @repbr1
    Scenario: Vaildating the data of Class Reading Report Card at Class level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
    When I search for the class "Lui Class"
	When I Click on View Reprot button of "Class Reading Report Card"
    Then I should see then report header as "Class Reading Report Card"
    And I click on 'table' button
	Then I should see negatieve BR on Class Reading Report Card for "Lui Class" class level for Student



    @repbr1
    Scenario: Vaildating the data of Class Lexile History Report at Class level
    Given I browse to Report Page as "admin"
    Then I should see header text for Reports page
	When I search for the class "Lui Class"
	When I Click on View Reprot button of "Class Lexile History Report"
    Then I should see then report header as "Class Lexile History Report"
    And modal should display following buttons on the header
      | Report modal Elements |
      | export                |
      | print                 |
      | close                 |
    When I click on 'School Calendar' dropdown
    Then I should see list of school year options
    And I click on 'table' button
    Then I should see negatieve BR on Class Lexile History Report Card for "Lui Class" class level for Student

 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @QAdata
  Scenario Outline: Take test for all students 
	Given I launch Litpro and browse to LitPro Test Page using "<username>" and "<password>" with "<userType>" 
	Then I should see welcome message with get started button 
	When I click on lets get started button 
	And I complete the assessment 
	And I click 'Create My Reading list' Button 
	Then Home Page should be shown 
	Examples: 
		| username  | password | usertype | 
		|Student16    | welcome1 | Student  |
		|Student16    | welcome1 | Student  |
		|Student17    | welcome1 | Student  |
		|Student17    | welcome1 | Student  |
		|Student21    | welcome1 | Student  |
		|Student21    | welcome1 | Student  |
		|Student22    | welcome1 | Student  |
		|Student22    | welcome1 | Student  |
		
		@QAdata
	Scenario Outline: Take test for all students 
		Given I launch LitPro using "<username>" and "<password>" with "<usertype>" 
		And I should see user greeting text "Welcome, " 
		Then I navigate to the search page showing results for word "Planet,Tale, Story, Book" 
		And I click Take Quiz button for a random book 
		Then I should see quiz popup with header text starting with "Quizzes for" 
		When I click Take Quiz button in Quiz Popup 
		And I complete the quiz 
		Then I should see score and percentage 
		Examples: 
			| username  | password | usertype | 
			|Student16    | welcome1 | Student  |
			|Student16    | welcome1 | Student  |
			|Student17    | welcome1 | Student  |
			|Student17    | welcome1 | Student  |
			|Student21    | welcome1 | Student  |
			|Student21    | welcome1 | Student  |
			|Student22    | welcome1 | Student  |
			|Student22    | welcome1 | Student  |
	    