@GRL-LexileSetting
Feature: As an educator (teacher or building admin), I want to configure whether or not I see GRL features and/or Lexile features

Scenario Outline: RP-Teacher can see the option to set their classroom for GR or lexile
Given I launch RP using "<username>" and "<password>" with "<usertype>"
When I navigate to settings page
Then there will an option to set the classroom/school for GR or lexile
Examples:
 |username|password|usertype|
 |lpteacher|welcome1 |Teacher|
 