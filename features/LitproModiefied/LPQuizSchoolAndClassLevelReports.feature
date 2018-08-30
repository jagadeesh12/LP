@functional @reports @quizreportsvalidation @Fixtrg2
Feature: LitPro Reports UI validation at School level
  As a LitPro User
  I should be able to view school level reports
  So that I can ..
  
   Scenario: Book Comprehension Report verification
    Given I browse to Report Page as "admin"
	Then I should see header text for Reports page
    Then I should collect the data of all students
    |Student Name|
    |EdMcCreery|
	  |JonSnow|	
	  |AryaStark|
	When I search for the class "Lui Class"
    Then I should see Reports page header with text "Reports for"
    And I should see report card name "Book Comprehension Report"
    When I click on View Report button
    Then I see the report card on a modal with header "Book Comprehension Report"
    And the report modal footer should read '*Imported data may affect averages across reports. For more information, click here.'
    And Book Comprehension Report modal should display following buttons on the header
      | Report modal Elements |
      | export                |
      | print                 |
      | close                 |
    And Book Comprehension Report modal should display following reports
      | graph       |
      | table       |
    When I click on 'School Calendar' dropdown
    Then I should see list of school year options
    And I click on 'table' button
    Then I should validate the reports data of Book Comprehension Report at class level for Student
    |Student Name|
    |ReadingListReadingList|
	|JonSnow|
	
	
	@QuizReportsVerificationandValidation1 
  Scenario: Quiz Pass Rate Report UI verification
  Given I browse to Report Page as "Admin"
	Then I should see header text for Reports page
    Then I should collect the data of all students
    |Student Name|
    |ReadingListReadingList|
	|JonSnow|
	|AryaStark|	
    When I search for the class "Lui Class"
    Then I should see Reports page header with text "Reports for"
    And I should see report card name "Quiz Pass Rate Report"
    When I click on View Report button
    Then I see the report card on a modal with header "Quiz Pass Rate Report"
    And the report modal footer should read '*Imported data may affect averages across reports. For more information, click here.'
    And Quiz Pass Rate Report modal should display following buttons on the header
      | Report modal Elements |
      | export                |
      | print                 |
      | close                 |
    And Quiz Pass Rate Report modal should display following reports
      | graph |
      | table |
    When I click on 'School Calendar' dropdown
    Then I should see list of school year options
    And I click on 'table' button
    Then I should validate the reports data of Quiz Pass Report at class level for Student
    |Student Name|
    |ReadingListReadingList|
	|JonSnow|