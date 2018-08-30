@functional  @regression
Feature: Login to TCOOL
  As a TCOOL User
  I should be able to login
  So that I can ....

  @teacher123
   Scenario: Valid Credentials
    Given I am on Tcool Login Page
    When I login with the following credentials
      | UserName | rasheed@gmail.com |
      | Password | pass1234          |
    Then I should see Tcool Home Page