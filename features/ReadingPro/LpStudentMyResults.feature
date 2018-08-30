@regressionlp @studentmyresults
Feature: Student Report Card UI
  As a LitPro User
  I should be able to verify Student My Reults UI
  So that I can detect any GUI issues

  @student 
  Scenario: LitPro Student My Results UI
    When I launch LitPro as "Student"
    Then I should see Scholastic Literacy Pro Home Page
    And I should see user greeting text "Welcome, "
    And I should see below tabs:
      | Home | Search | My Results | LitPro Test |
    And I should see Logout link
    When I click on My Results tab
    Then I should see My Results Page
    When I click date sort column
    Then the quiz results date order should change
	When I click title sort column
	Then the quiz results title order should change
	When I click author sort column
	Then the quiz results author order should change
	When I click lexile sort column
	Then the quiz results lexile order should change
#	When I click score sort column
#	Then the quiz results score order should change
	When I click points sort column
	Then the quiz results points order should change
@student
  Scenario: LitPro Student Print My Results Activities
    Given I browse to Settings Page as "admin"
    Then I should see class name
    And I change following Quiz settings:
      | Setting Name              				| Action  | New Value |
      | Display incorrect answers 				| check | NA        |
      | Restrict number of quiz attempts to 	| check	  | 33|
      | Number of days between quiz attempts: 	| check   | 0 | 
      | Quiz pass mark            				| NA      | 90        |
      | Allow student to print    				| Check   | NA        |
      | Allow student to print certificate		| Check	|NA|
    And I click Save
    When I launch LitPro as "Student"
    Then I should see Scholastic Literacy Pro Home Page
    When I click on My Results tab
    When I click on list view
    Then I should click on the print activity
    Then I should validate the print result with my result activities
    
    
    
    @student 
  Scenario: LitPro Student Print My Results Activities
  #LP-705
    Given I browse to Settings Page as "admin"
    Then I should see class name
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    And I change following Quiz settings:
      | Setting Name              				| Action  | New Value |
      | Allow student to print    				| Check   | NA        |
      | Allow student to print certificate		| Check	|NA|
    And I should set the following settings for awards
      | Award Name | Value |
      | Gold       | 5   |
      | Silver     | 4   |
      | Bronze     | 3   |
      | Red        | 2   |
      | Blue       | 1   |
    And I click Save
    When I launch LitPro as "Student"
    Then I should see Scholastic Literacy Pro Home Page
    When I click on My Results tab
    Then I should see the certificate
    When I click on the print certificate option
    Then I should validate the certificate