@regressionlp @editteacherpts @LpEditTeacherPoints.feature
Feature: Edit Teacher Added Points
  As an QA engineer I want to edit points
  so I can verify the reports
  
 @admin 
 Scenario Outline: LitPro Student SA Student Report Card UI
Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
 When I click the Restore Defaults button
 Then Settings Restored Message should be displayed
 When I enable teacher points option
 When I click the Settings page Save button
 Then 'Settings Saved' Message should be displayed
 When I click on Reports tab
 Then I should see Reports Page
 When I enter Reports search string "Jon Snow"
 Then I should see header text for Reports page
 When I click edit link for quiz points
 Then I should see the points added in the Quiz Points Earned and Teacher-Added Points
 Examples:
 |username|password|usertype|
 |admin1|welcome1|admin|
 @teacher
 @admin
 Scenario Outline: LitPro Student SA Student Report Card UI
Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
 When I click on Reports tab
 Then I should see Reports Page
 When I enter Reports search string "Jon Snow"
 Then I should see header text for Reports page
 When I click edit link for quiz points
 Then I should see the points added in the Quiz Points Earned and Teacher-Added Points
 Examples:
 |username|password|usertype|
 |teacher1|welcome1|teacher|