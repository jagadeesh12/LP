@StudentDataLxl-OpenModal @TeacherJudgement
Feature: Student Data-Lexile-Open Modal
As a teacher, I need a place where I can see my students that do not have a previous RP score (so that I can enter info to determine the starting point for the assessment)

Scenario Outline: Teacher has a single class with no students - Student data button is only enabled for class with students
Given a teacher launches Reading Pro using "<username>" and "<password>" with "<usertype>" from SDM
When they navigate to the Reports tab
Then the [enter student data] button is disabled
Examples:
   |username				| password 		| usertype |
   |teacher@sdm.org | password1   |  teacher |
   
Scenario Outline: Teacher has multiple classes with atleast one has no students and one has students -Student data button is only enabled for a class with students and disabled for a class with no students
Given a teacher launches Reading Pro using "<username>" and "<password>" with "<usertype>" from SDM
When they navigate to the Reports tab
Then the Enter Student Scores button will be enabled when the teacher clicks on a class with students in the My Students selector "<classwithstudents>" 
And disabled when she clicks on class with no students in the My Students selector "<classwithnostudents>"
Examples:
  |username								|	password	|usertype| classwithnostudents | classwithstudents   |
  |   teacher@sdm.org     | password1 |teacher | TestingClass				 |				Another Class|

Scenario Outline: Student with previous RP score is not included in the modal
Given a teacher launches Reading Pro using "<username>" and "<password>" with "<usertype>" from SDM
When they navigate to the Reports tab
And opens the modal "<classname>" 
Then there is a student in the class with previous RP score , he is not included in the modal because there is no need to enter the info. "<student name>"
 Examples:
 |username 				| password | usertype | studentname |
 |teacher@sdm.org | password1| teacher  | Sansa Stark |
 
Scenario Outline: All students have RP scores
Given a teacher launches Reading Pro using "<username>" and "<password>" with "<usertype>" from SDM
And they navigate to the Reports tab
When all students in the class have Reading Pro scores from any time in the past,modal will not open "<classname>"
And an error message will be shown with the text "All students in this class have prior ReadingPro scores so no data entry is needed"
 Examples:
 |username				| password | usertype | studentname | classname |
 |teacher@sdm.org | password1| teacher 	| Sansa Stark | 		 			|

Scenario Outline: Base Case - Open Modal
Given a teacher launches Reading Pro using "<username>" and "<password>" with "<usertype>" from SDM
And they navigate to the Reports tab
When they select a class with has students "<classname>"
Then the enter student data button is enabled
When opens the modal "<classname>" 
Then each student with no previous RP score in the currently selected class is visible "<studentnames>"
|studentnames|
|['','','']|
And students are sorted alphabetically by last name
Examples:
  |username         |password   |usertype|  
  |  teacher@sdm.org|  password1| teacher| 
  
Scenario Outline: Teacher has a single class with student the button is only enabled at class and student level
Given a teacher launches Reading Pro using "<username>" and "<password>" with "<usertype>" from SDM
And they navigate to the Reports tab
When they select a student in the my students selector "<studentname>" "<classname>"
Then the enter student data button is enabled
When they select a class with has students "<classname>"
Then the enter student data button is enabled
Examples:
|username         |password   |usertype| studentname| classname|
|  teacher@sdm.org|  password1| teacher|						|					 |

Scenario Outline: Enter Teacher Judgement
Given a teacher launches Reading Pro using "<username>" and "<password>" with "<usertype>" from SDM
And they navigate to the Reports tab
And changes the Teacher Judgment value for a student "<studentname>"
When the teacher hits Save button
Then the data will be saved
Examples:
  |username         |password   |usertype| studentname |
  |  teacher@sdm.org|  password1| teacher|						 |

Scenario Outline: Default Teacher Judgement
Given a teacher launches Reading Pro using "<username>" and "<password>" with "<usertype>" from SDM
And they navigate to the Reports tab
When a student does not have a Reading Pro Lexile from any time/year in the past is displayed in the modal "<studentname>"
Then the no RP score will be displayed And the At Grade Level value under Teacher Judgment will be selected by default
Examples:
  |username         |password   |usertype| studentname|
  |  teacher@sdm.org|  password1| teacher|						|
  
Scenario Outline: Saved Teacher Judgement
Given a teacher launches Reading Pro using "<username>" and "<password>" with "<usertype>" from SDM
And they navigate to the Reports tab
And a student does not have a Reading Pro Lexile from any time in the past,doesnot have a prior assessment score and teacher saved a teacher judgement value in the past.
When opens the modal "<classname>" 
Then the no RP score will be displayed "<studentname>"
And Teacher Judgment = previously saved value "<previoussavedvalue>" "<studentname>"
Examples:
  |username         |password   |usertype|studentname|classname | previoussavedvalue |
  |  teacher@sdm.org|  password1| teacher|           |					|	 	Above Grade Level	 |
