@functional @quiz @regressionlpfix @regressionlpset4 
Feature: LitPro Quiz, Results
  As a LitPro User
  I should be able to take Quiz on Books
  So that I can ....

  @student @sanity @SmokeLP @fixremainingpart
  Scenario: Change required settingsto take quiz, Take quiz and check results in My Results
    Given I browse to Settings Page as "Teacher"
    Then I should see class name
    And I change following Quiz settings:
      | Setting Name                         | Action  | New Value |
      | Restrict number of quiz attempts to  | Check   | 99        |
      | Number of days between quiz attempts | Check   | 0         |
      | Display incorrect answers            | Uncheck | NA        |
      | Quiz pass mark                       | NA      | 10        |
      | Allow student to print               | Check   | NA        |
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
    When As a student, I am on the search page showing results for word "John, fire, snow, play, planet"
    And I click Take Quiz button for a random book
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I complete the quiz
    Then I should see score and percentage
    When I goto My Results page
    #Then I should see book details on which quiz was taken
    #And Score and Quiz date should match

  @student @nov10 @fixreptcard11
  Scenario: Setting 'Display Incorrect Answer' shows the incorrect ans post quiz
    Given I browse to Settings Page as "Teacher"
    Then I should see class name
    And I change following Quiz settings:
      | Setting Name                         | Action | New Value |
      | Restrict number of quiz attempts to  | Check  | 99        |
      | Number of days between quiz attempts | Check  | 0         |
      | Display incorrect answers            | Check  | NA        |
      | Quiz pass mark                       | NA     | 90        |
      | Allow student to print               | Check  | NA        |
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
    When As a student, I am on the search page showing results for word "John, fire, snow, play, planet"
    And I click Take Quiz button for a random book
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I complete the quiz
    Then I should see 'View Incorrect Answer' button
    When I click 'View Incorrect Answer' button
    Then I should see pop up showing incorrect answers
    And Incorrect answer should be selected for all incorrect answers
    When I click 'Exit Quiz' button
    Then Popup should close
    
@student @nov10 @testQuestions1234
  Scenario: Setting for taking test 
    Given I browse to Settings Page as "Teacher"
    Then I should see class name
    And I change following Quiz settings:
      | Setting Name                         | Action | New Value |
      | Restrict number of quiz attempts to  | Check  | 99        |
      | Number of days between quiz attempts | Check  | 0         |
      | Display incorrect answers            | Check  | NA        |
      | Quiz pass mark                       | NA     | 90        |
      | Allow student to print               | Check  | NA        |
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
    
   @admin @sanity @testQuestions1234
Scenario: Search as School Teacher  for Series
	  Given As a "Teacher", I am on the search page showing results for word "John, fire, snow, play, planet"
	   Then I click on view quiz button and Save all Questions and Answers
	   
	   @Remaining @defect @testQuestions1234
	Scenario: Vrify quiz questions
    Given I browse to Search Page as "Student"
    Then I should see Search Page Header "Search"
    When I search for books already viewed by teacher
    And I click on take Quiz button
    Then I should see quiz popup with header text starting with "Quizzes for"
    When I click Take Quiz button in Quiz Popup
    And I should verify Questions and answers in teacher and students are matching
  
    