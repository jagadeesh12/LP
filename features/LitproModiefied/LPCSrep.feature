@CSrep
Feature: LitPro Reports UI validation at School level 
	As a LitPro User
  I should be able to view school level reports
  So that I can ....
  
  @CSrep
  Scenario: Uplaoding SRI historical data as a as csrep
    Given I am on Scholastic Learning Zone Login Page
    When I login with following credentials as csrep
      | UserName | kHegde-consultant@scholastic.com |
      | Password | welcome1                         |
    Then I should search for the school "breaking bad 6"
    Then I should enter by pass through
    Then I should open Litpro
    When I open the manager
    Then I should open the "SOAR Test Import" page
    When I should create the SRI Import File "sriUpload"
	When I enter the ORGID in SOAR test import
    Then I should confirm that school is correct
    When I Upload the SRI Import File "sriUpload"
	Then I should verify the uplaoded data