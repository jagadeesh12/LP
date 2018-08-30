@regressionlp @editteacherpts 
Feature: Edit Teacher Added Points
  As an QA engineer I want to edit points
  so I can verify the reports
  
 @admin 
 Scenario: LitPro Student SA Student Report Card UI
 Given I browse to Settings Page as "admin"
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
 
 @teacher
 @admin
 Scenario: LitPro Student SA Student Report Card UI
 Given I browse to Settings Page as "teacher"
 When I click on Reports tab
 Then I should see Reports Page
 When I enter Reports search string "Jon Snow"
 Then I should see header text for Reports page
 When I click edit link for quiz points
 Then I should see the points added in the Quiz Points Earned and Teacher-Added Points
 