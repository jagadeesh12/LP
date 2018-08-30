@NoSearchBar
Feature: As a Admin/teacher, When I log into Reading Pro I should not see the class or search bar on benchmarks,settings and reports page.Also I should not see any roster information on the benchmarks page

Scenario Outline: As a teacher/admin I donot see the class or search bar on benchmarks,settings and reports page.
Given I launch RP using "<username>" and "<password>" with "<usertype>"
When I navigate to search page
 Then I should not see the search bar and also the search box label
 When I navigate to reports page
 Then I should not see the search bar and also the search box label
 When I navigate to benchmarks page
 Then I should not see the search bar and also the search box label
 Examples:
 |username|password|usertype|
 |teacher@sdm.org|password1|Teacher|
 |teacher@ps21.org|password1|Admin|
 
Scenario Outline: Remove roster information from the benchmark page
Given I launch RP using "<username>" and "<password>" with "<usertype>"
When I navigate to the benchmark page
Then the roster information does not appear
Examples:
 |username				|password	|	usertype|
 |teacher@sdm.org|password1|	Teacher|
 |teacher@ps21.org					|password1|	Admin		|
