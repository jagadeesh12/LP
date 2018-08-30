@functional @settings @regressionlp 
Feature: LitPro Settings 
	As a LitPro User
  I should be able to changes Test and Quiz Setting
  So that I can ....
  
@teacher @sanity @student 
Scenario: Testing Require students to take practice test Setting checked 
	Given I browse to Settings Page as "Teacher" 
	Then I should see class name 
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
	Given I browse to LitPro Test Page as "Student" 
	Then I should see welcome message with get started button 
	When I click on lets get started button 
	#LP-50
	When I should be shown practise test while taking test 
	
	
@student @common @rl123
Scenario: As a Student, I would like to pause the test. I should be able to came back and retake it. 
	Given I browse to LitPro Test Page as "Student" 
	Then I should see welcome message with get started button
	#LP-374 
	When I click on lets get started button 
	And I will take test and pause it
	When I click on lets get started button 
	When I complete the pause Test 
	
@student @common @rl123 
Scenario: As a Student, I would like to interupt the test. Logout and then login as back and take the test(resume the test). 
	Given I browse to LitPro Test Page as "Student" 
	#LP-157
	Then I should see welcome message with get started button 
	When I click on lets get started button 
	And I will take test and pause it
	Then I should logout as student
	#lp-54
	Given I browse to LitPro Test Page as "Student" 
	Then I should see welcome message with get started button 
	When I click on lets get started button
	When I complete the pause Test 