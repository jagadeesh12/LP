@regressionlp @searchsettings @regressionlpfix @regressionlpset5
Feature: LitPro Search-Settings with exact class name
  As an SA LitPro User I should be able to search for classes on settings page with exact class name
  at the School, Class and individual Student level
  so I can organize the sttings the way I want to
  
@admin @Finfix
Scenario: Search for an exact class name by SA that exists from school level 
Given I browse to Settings Page as "admin"
When I enter Settings search string "Math"
Then I should see Settings Page Page Header starting with "Math"

@admin @Finfix
Scenario: Search for an exact class name that exists by SA from the same class page
Given I browse to Settings Page as "admin"
When I enter Settings search string "Math"
Then I should see Settings Page Page Header starting with "Math"
When I enter Settings search string "Math"
Then I should see Settings Page Page Header starting with "Math"

@admin
Scenario: Search for an exact class name that exists by SA from a different class page
Given I browse to Settings Page as "admin"
When I enter Settings search string "Math"
Then I should see Settings Page Page Header starting with "Math"
When I enter Settings search string "Science"
Then I should see Settings Page Page Header starting with "Science"

@admin
Scenario: Search for an exact class name that exists by SA from a student page   
Given I browse to Settings Page as "admin"
When I enter Settings search string "Martina"
Then I should see Settings Page Page Header starting with "Joe Martina"
When I enter Settings search string "Math"
Then I should see Settings Page Page Header starting with "Math"

@admin
Scenario: Search for an exact class name that does not exist from school level
Given I browse to Settings Page as "admin"
When I enter invalid Settings search string "xyzzy"
Then Settings Error Message should be displayed

@admin
Scenario: Search for an exact class name that does not exist from class level
Given I browse to Settings Page as "admin"
When I enter Settings search string "Math"
Then I should see Settings Page Page Header starting with "Math"
When I enter invalid Settings search string "xyzzy"
Then Settings Error Message should be displayed

@admin
Scenario:  Search for an exact class name that does not exist from student
Given I browse to Settings Page as "admin"
When I enter Settings search string "Martina"
Then I should see Settings Page Page Header starting with "Joe Martina"
When I enter invalid Settings search string "xyzzy"
Then Settings Error Message should be displayed

@admin
Scenario: Search using a string that partially matches a class (starts with) from school level
Given I browse to Settings Page as "admin"
When I enter Settings search string "Sci"
Then I should see Settings Page Page Header starting with "Science"

@admin
Scenario: Search using a string that partially matches a class (ends with) from school level
Given I browse to Settings Page as "admin"
When I enter Settings search string "nce"
Then I should see Settings Page Page Header starting with "Science"

@admin
Scenario: Search using a string that partially matches a class (contains) from school level
Given I browse to Settings Page as "admin"
When I enter Settings search string "cie"
Then I should see Settings Page Page Header starting with "Science"

@admin
Scenario: Verify search is case insensitive from 
Given I browse to Settings Page as "admin"
When I enter Settings search string "mATH"
Then I should see Settings Page Page Header starting with "Math"

@admin
Scenario: use SQL wildcards
Given I browse to Settings Page as "admin"
When I enter Settings search string "Sc%"
Then I should see Settings Page Page Header starting with "Science"
When I enter Settings search string "j_e"
Then I should see Settings Page Page Header starting with "Joe Martina"

@admin 
Scenario: search for string of less than 3 chars
Given I browse to Settings Page as "admin"
When I enter invalid Settings search string "ma"
Then Settings Too Short Error Message should be displayed

