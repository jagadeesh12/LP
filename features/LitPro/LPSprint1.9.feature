@f1 @LpSprint1.9feature
Feature: LP Sprint1

@student @common @rl123 
  Scenario Outline: As a teacher, I would like "incomplete test" added to the alerts report so that the information is easier to read
   Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
     Then I should see welcome message with get started button 
     When I click on lets get started button 
      And I take incomplete assessment 
      And I logout
      And I browse to Settings Page as "teacher" 
     When I click on Reports tab 
     Then I should see Reports Page
     Then I click on Alert Report
     Then I should see report card with Incomplete test as a Metric
     Examples:
     |username|password|usertype|
     |JonSnow|welcome1|student|
    
    
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
  Scenario Outline: As a teacher/admin, I would like a tooltip to explain BR results so I have more info on what it means
    Given I browse launch LitPro and browse to Report Page using "<username>" and "<password>" with "<usertype>"
     When I enter Reports search for student "Joe Martina" whose score is BR 
     Then I must see tool tip in Reading report card 
     When I click on the tool tip 
     Then I must see new BR page 
     Examples:
     |username| password|usertype|
     |TonyStark|welcome1|teacher|
  
  @teacher @wip1.9.2
  Scenario Outline: As a teacher/admin, I would like a tooltip/modal to display GR/Lexile mapping so it is clear to my customers
    Given I launch Litpro and browse to Search Page using "<username>" and "<password>" with "<usertype>"
     Then I should see Search Page Header "Search"
     When I search for books having title "Skylar"
     Then Image view search results count should match with the dispayed count
     Then I should see tool tip in Search Results 
      And I should see tool tip in Recomended reading list 
      Examples:
     |username| password|usertype|
     |TonyStark|welcome1|teacher|
  
  @teacher @wip1.9.2
  Scenario Outline: As a teacher/admin, I would like a tooltip to explain BR results so I have more info on what it means
      Given I browse launch LitPro and browse to Report Page using "<username>" and "<password>" with "<usertype>"
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
     Examples:
     |username| password|usertype|
     |TonyStark|welcome1|teacher|

 
    
    
    
    
    
      