@regressionlp @editteacherpts @regressionlpset1 @Fixtrg2 
Feature: Edit Teacher Added Points 
	As an QA engineer I want to edit points
  so I can verify the reports

@teacher @admin  
Scenario: Edit litpro Student points in Report Card UI- Admin 
	Given I browse to Report Page as "admin" 
	Then I should see Reports Page
	When I enter Reports search string "JonSnow" 
	Then I should see header text for Reports page 
	When I click edit link for quiz points 
	Then I should increase the teacher points by "2" points 
	Then "Points Updated" Message should be displayed 
	Then I should see the points added in the Quiz Points Earned and Teacher-Added Points 
	
	
@teacher 
@admin 
Scenario: Edit litpro Student points in Report Card UI- Teacher 
	Given I browse to Report Page as "Teacher" 
	Then I should see Reports Page 
	When I enter Reports search string "JonSnow" 
	Then I should see header text for Reports page 
	When I click edit link for quiz points 
	Then I should increase the teacher points by "2" points 
	Then "Points Updated" Message should be displayed 
	Then I should see the points added in the Quiz Points Earned and Teacher-Added Points 
	
	 
Scenario: Edit litpro Student points in Report Card UI- Teacher 
	Given I browse to Settings Page as "admin"
	Then I should see class name 
	When I click the Restore Defaults button
	When I click on Reports tab
	Then I should see Reports Page 
	When I enter Reports search string "JonSnow" 
	Then I should see header text for Reports page 
	And I should collect the data of Quiz Points Earned and Teacher Added Points
	When I navigate to settings page
	Then I should see class name
	When I click the Restore Defaults button
	Then Settings Restored Message should be displayed 
	When I change following Test settings: 
		| Setting Name                                      | Action  | New Value |
		| Include teacher-added points in report totals    | Check   | NA        |
	And I click Save 
	Then 'Settings Saved' Message should be displayed
	When I click on Reports tab
	Then I should see Reports Page 
	When I enter Reports search string "JonSnow" 
	Then I should see header text for Reports page 
	Then I should validate that Quiz Points Earned should be addition of Quiz Points Earned and Teacher Added Points
	
	
	Scenario: Edit litpro Student points in Report Card UI- Teacher 
	Given I browse to Report Page as "Teacher" 
	Then I should see Reports Page 
	When I enter Reports search string "JonSnow" 
	Then I should see header text for Reports page
	Then I collect Reading Report card data for student
	And I print Parent Letter
	Then student Report card data should match Parent Letter 
	
	
	