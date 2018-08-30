@regressionlp @searchsettingsstudent @regressionlpset2
Feature: LitPro Search-Settings with exact class name
  As an SA LitPro User I should be able to search for students on settings page with exact student name
  at the School, Class and individual Student level
  so I can organize the sttings the way I want to
  
@admin  
Scenario: Search for an exact student name by SA that exists from school level 
Given I browse to Settings Page as "admin"
When I enter Settings search string "JoeMartina"
Then I should see Settings Page Page Header starting with "Joe Martina"

@teacher
Scenario: Search for an exact student name by teacher that is in the teachers's class 
Given I browse to Settings Page as "Teacher"
When I enter Settings search string "JoeMartina"
Then I should see Settings Page Page Header starting with "Joe Martina"

#@teacher
Scenario: Search for an exact student name by teacher that exists but not a member of the teachers's class 
Given I browse to Settings Page as "Teacher"
When I enter Settings search string "Dan Marion"
Then Settings Error Message should be displayed

@admin
Scenario: Search for an exact student name that exists by SA from class page
Given I browse to Settings Page as "admin"
When I enter Settings search string "Math"
Then I should see Settings Page Page Header starting with "Math"
When I enter Settings search string "JoeMartina"
Then I should see Settings Page Page Header starting with "Joe Martina"

@admin
Scenario: Search for an exact student name that exists by SA from a different student page   
Given I browse to Settings Page as "admin"
When I enter Settings search string "Martina"
Then I should see Settings Page Page Header starting with "Joe Martina"
When I enter Settings search string "JonSnow"
Then I should see Settings Page Page Header starting with "Jon Snow"  

@teacher
Scenario: Teacher Search for an exact student name that exists from a different student page   
Given I browse to Settings Page as "Teacher"
When I enter Settings search string "Martina"
Then I should see Settings Page Page Header starting with "Joe Martina"
When I enter Settings search string "jon"
Then I should see Settings Page Page Header starting with "Jon Snow"  

@admin
Scenario: Search for an exact student name that exists by SA from their own student page   
Given I browse to Settings Page as "admin"
When I enter Settings search string "JoeMartina"
Then I should see Settings Page Page Header starting with "Joe Martina"
When I enter Settings search string "Joe Martina"
Then I should see Settings Page Page Header starting with "Joe Martina"

@teacher
Scenario: Search for an exact student name that exists by SA from their own student page   
Given I browse to Settings Page as "Teacher"
When I enter Settings search string "JoeMartina"
Then I should see Settings Page Page Header starting with "Joe Martina"

@admin
Scenario: Search for an exact student name that does not exist from school level
Given I browse to Settings Page as "admin"
When I enter invalid Settings search string "xyzzy"
Then Settings Error Message should be displayed


@admin
Scenario: Search for an exact student name that does not exist from class level
Given I browse to Settings Page as "admin"
When I enter Settings search string "Math"
Then I should see Settings Page Page Header starting with "Math"
When I enter invalid Settings search string "xyzzy"
Then Settings Error Message should be displayed

@teacher
Scenario: Search for an exact student name that does not exist from class level
Given I browse to Settings Page as "Teacher"
When I enter invalid Settings search string "xyzzy"
Then Settings Error Message should be displayed

@admin
Scenario:  Search for an exact student name that does not exist from student
Given I browse to Settings Page as "admin"
When I enter Settings search string "Martina"
Then I should see Settings Page Page Header starting with "Joe Martina"
When I enter invalid Settings search string "xyzzy"
Then Settings Error Message should be displayed

@teacher
Scenario:  Teacher Search for an exact student name that does not exist from student page
Given I browse to Settings Page as "Teacher"
When I enter Settings search string "Martina"
Then I should see Settings Page Page Header starting with "Joe Martina"
When I enter invalid Settings search string "xyz xyzzy"
Then Settings Error Message should be displayed


@admin
Scenario: Search using a string that partially matches a student (starts with) from school level
Given I browse to Settings Page as "admin"
When I enter Settings search string "Joe"
Then I should see Settings Page Page Header starting with "Joe Martina"

@teacher
Scenario: Search using a string that partially matches a student (starts with) from class level
Given I browse to Settings Page as "Teacher"
When I enter Settings search string "Joe"
Then I should see Settings Page Page Header starting with "Joe Martina"


@admin 
Scenario: Search using a string that partially matches a student (ends with) from school level
Given I browse to Settings Page as "admin"
When I enter Settings search string "ina"
Then I should see Settings Page Page Header starting with "Joe Martina"

@teacher
Scenario: Teacher Search using a string that partially matches a student (ends with) 
Given I browse to Settings Page as "Teacher"
When I enter Settings search string "ina"
Then I should see Settings Page Page Header starting with "Joe Martina"

@admin
Scenario: Search using a string that partially matches a student (contains) from school level
Given I browse to Settings Page as "admin"
When I enter Settings search string "rti"
Then I should see Settings Page Page Header starting with "Joe Martina"

@teacher
Scenario: Teacher Search using a string that partially matches a student (contains) 
Given I browse to Settings Page as "Teacher"
When I enter Settings search string "rti"
Then I should see Settings Page Page Header starting with "Joe Martina"


@admin
Scenario: Verify search is case insensitive from 
Given I browse to Settings Page as "admin"
When I enter Settings search string "jOemArTiNa"
Then I should see Settings Page Page Header starting with "Joe Martina"

@teacher
Scenario: Verify Teacher search is case insensitive from 
Given I browse to Settings Page as "Teacher"
When I enter Settings search string "jOemArTiNa"
Then I should see Settings Page Page Header starting with "Joe Martina"


@admin
Scenario: use SQL wildcards
Given I browse to Settings Page as "admin"
When I enter Settings search string "Mart%"
Then I should see Settings Page Page Header starting with "Joe Martina"
When I enter Settings search string "m_rt"
Then I should see Settings Page Page Header starting with "Joe Martina"

@admin
Scenario: search for string of less than 3 chars
Given I browse to Settings Page as "admin"
When I enter invalid Settings search string "ma"
Then Settings Too Short Error Message should be displayed

@teacher
Scenario: Teacher search for string of less than 3 chars
Given I browse to Settings Page as "Teacher"
When I enter invalid Settings search string "ma"
Then Settings Too Short Error Message should be displayed
