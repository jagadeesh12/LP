@regressionlp @searchreportsstudent  @LPReportsStudentSearch.feature
Feature: LitPro Search-Reports with exact class name
  As an SA LitPro User I should be able to search for students on Reports page with exact student name
  at the School, Class and individual Student level
  so I can organize the sttings the way I want to
  
@admin 
Scenario: Search for an exact student name by SA that exists from school level 
Given I browse to Report Page as "Admin"
When I enter Reports search string "Joe Martina"
Then I should see Reports Page Page Header starting with "Joe Martina"

@teacher 
Scenario: Search for an exact student name by teacher that is in the teachers class 
Given I browse to Report Page as "Teacher"
When I enter Reports search string "Joe Martina"
Then I should see Reports Page Page Header starting with "Joe Martina"

@teacher 
Scenario: Search for an exact student name by teacher that exists but not a member of the teachers's class 
Given I browse to Report Page as "Teacher"
When I enter Reports search string "Dan Marion"
Then Reports Error Message should be displayed

@admin 
Scenario: Search for an exact student name that exists by SA from class page
Given I browse to Report Page as "admin"
When I enter Reports search string "Math"
Then I should see Reports Page Page Header starting with "Math"
When I enter Reports search string "Joe Martina"
Then I should see Reports Page Page Header starting with "Joe Martina"

@admin 
Scenario: Search for an exact student name that exists by SA from a different student page   
Given I browse to Report Page as "admin"
When I enter Reports search string "Martina"
Then I should see Reports Page Page Header starting with "Joe Martina"
When I enter Reports search string "Dan Marion"
Then I should see Reports Page Page Header starting with "Dan Marion"  

@teacher 
Scenario: Teacher Search for an exact student name that exists from a different student page   
Given I browse to Report Page as "Teacher"
When I enter Reports search string "Martina"
Then I should see Reports Page Page Header starting with "Joe Martina"
When I enter Reports search string "La Rue Kirby"
Then I should see Reports Page Page Header starting with "La Rue Kirby"  

@admin 
Scenario: Search for an exact student name that exists by SA from their own student page   
Given I browse to Report Page as "admin"
When I enter Reports search string "Joe Martina"
Then I should see Reports Page Page Header starting with "Joe Martina"
When I enter Reports search string "Joe Martina"
Then I should see Reports Page Page Header starting with "Joe Martina"

@teacher 
Scenario: Search for an exact student name that exists by SA from their own student page   
Given I browse to Report Page as "Teacher"
When I enter Reports search string "Joe Martina"
Then I should see Reports Page Page Header starting with "Joe Martina"
When I enter Reports search string "Joe Martina"
Then I should see Reports Page Page Header starting with "Joe Martina"

@admin 
Scenario: Search for an exact student name that does not exist from school level
Given I browse to Report Page as "admin"
When I enter invalid Reports search string "xyzzy"
Then Reports Error Message should be displayed


@admin 
Scenario: Search for an exact student name that does not exist from class level
Given I browse to Report Page as "admin"
When I enter Reports search string "Math"
Then I should see Reports Page Page Header starting with "Math"
When I enter invalid Reports search string "xyzzy"
Then Reports Error Message should be displayed

@teacher 
Scenario: Search for an exact student name that does not exist from class level
Given I browse to Report Page as "Teacher"
When I enter invalid Reports search string "xyzzy"
Then Reports Error Message should be displayed

@admin 
Scenario:  Search for an exact student name that does not exist from student
Given I browse to Report Page as "admin"
When I enter Reports search string "Martina"
Then I should see Reports Page Page Header starting with "Joe Martina"
When I enter invalid Reports search string "xyzzy"
Then Reports Error Message should be displayed

@teacher 
Scenario:  Teacher Search for an exact student name that does not exist from student page
Given I browse to Report Page as "Teacher"
When I enter Reports search string "Martina"
Then I should see Reports Page Page Header starting with "Joe Martina"
When I enter invalid Reports search string "xyz xyzzy"
Then Reports Error Message should be displayed


@admin 
Scenario: Search using a string that partially matches a student (starts with) from school level
Given I browse to Report Page as "admin"
When I enter Reports search string "Joe"
Then I should see Reports Page Page Header starting with "Joe Martina"

@teacher 
Scenario: Search using a string that partially matches a student (starts with) from class level
Given I browse to Report Page as "Teacher"
When I enter Reports search string "Joe"
Then I should see Reports Page Page Header starting with "Joe Martina"


@admin 
Scenario: Search using a string that partially matches a student (ends with) from school level
Given I browse to Report Page as "admin"
When I enter Reports search string "ina"
Then I should see Reports Page Page Header starting with "Joe Martina"

@teacher 
Scenario: Teacher Search using a string that partially matches a student (ends with) 
Given I browse to Report Page as "Teacher"
When I enter Reports search string "ina"
Then I should see Reports Page Page Header starting with "Joe Martina"

@admin
Scenario: Search using a string that partially matches a student (contains) from school level
Given I browse to Report Page as "admin"
When I enter Reports search string "rti"
Then I should see Reports Page Page Header starting with "Joe Martina"

@teacher 
Scenario: Teacher Search using a string that partially matches a student (contains) 
Given I browse to Report Page as "Teacher"
When I enter Reports search string "rti"
Then I should see Reports Page Page Header starting with "Joe Martina"


@admin 
Scenario: Verify search is case insensitive from 
Given I browse to Report Page as "admin"
When I enter Reports search string "jOe mArTiNa"
Then I should see Reports Page Page Header starting with "Joe Martina"

@teacher 
Scenario: Verify Teacher search is case insensitive from 
Given I browse to Report Page as "Teacher"
When I enter Reports search string "jOe mArTiNa"
Then I should see Reports Page Page Header starting with "Joe Martina"


@admin 
Scenario: use SQL wildcards
Given I browse to Report Page as "admin"
When I enter Reports search string "Mart%"
Then I should see Reports Page Page Header starting with "Joe Martina"
When I enter Reports search string "m_rt"
Then I should see Reports Page Page Header starting with "Joe Martina"

@admin 
Scenario: search for string of less than 3 chars
Given I browse to Report Page as "admin"
When I enter invalid Reports search string "ma"
Then Reports Too Short Error Message should be displayed

@teacher 
Scenario: Teacher search for string of less than 3 chars
Given I browse to Report Page as "Teacher"
When I enter invalid Reports search string "ma"
Then Reports Too Short Error Message should be displayed
