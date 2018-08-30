@f1 
Feature: LP Sprint1

@student @common @rl123 
  Scenario: As a teacher, I would like "incomplete test" added to the alerts report so that the information is easier to read
    Given I browse to LitPro Test Page as "Student" 
     Then I should see welcome message with get started button 
     When I click on lets get started button 
      And I take incomplete assessment 
      And I browse to Settings Page as "teacher" 
     When I click on Reports tab 
     Then I should see Reports Page
     Then I click on Alert Report
     Then I should see report card with Incomplete test as a Metric
    
    
   @wip1.9 @wipl12345 
  Scenario Outline: LP-4355 As a student, I would like my Lexile to display to me with its numeric value for all results >0 so that I know my score
  
    Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
     And I should see user greeting text "Welcome, "
     Then My lexile score must be "<Score>"
  
  Examples: 
      | username       | password | Score | usertype | 
      | Bellow_zero    | welcome1 | BR    | Student  | 
      | Equal_zero     | welcome1 | 0     | Student  | 
      | More_then_zero | welcome1 | 20    | Student  | 
      | more_then_100  | welcome1 | 150   | Student  | 

@teacher @wip1.9.2
  Scenario: As a teacher/admin, I would like a tooltip to explain BR results so I have more info on what it means
    Given I browse to Report Page as "Teacher"
     When I enter Reports search for student "Joe Martina" whose score is BR 
     Then I must see tool tip in Reading report card 
     When I click on the tool tip 
     Then I must see new BR page 
  
  @teacher @wip1.9.2
  Scenario: As a teacher/admin, I would like a tooltip/modal to display GR/Lexile mapping so it is clear to my customers
    Given I browse to Search Page as "Teacher"
     Then I should see Search Page Header "Search"
     When I search for books having title "Skylar"
     Then Image view search results count should match with the dispayed count
     Then I should see tool tip in Search Results 
      And I should see tool tip in Recomended reading list 
  
  @teacher @wip1.9.2
  Scenario: As a teacher/admin, I would like a tooltip to explain BR results so I have more info on what it means
    Given I browse to Report Page as "Teacher"
     When I enter Reports search for Class "Lui"
     Then I must see class quiz activity Report
     When I click the class quiz activity report 
     Then I must see the following :
      | Column         | 
      | Student name   | 
      | Quiz name      | 
      | Quiz score     | 
      | Quiz date      | 
      | Lexile of book | 
      | Words Read     | 
   

 
    
    
    
    
    
      