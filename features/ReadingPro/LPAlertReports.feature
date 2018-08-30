@regressionlp @alertreportui 
Feature: LitPro Alert Report
  As an SA LitPro User I should verify Alert Report UI
  so I can view important info about student progress

  @admin
  Scenario: Verify Alert Report UI
    Given I browse to Report Page as "Admin"
    When I enter Reports search string "Math"
    Then I should see Reports Page Page Header starting with "Math"
    When I click the Alert Report link
    Then the Alert Report should display

 # @teacher
  Scenario: Verify Alert Report UI
    Given I browse to Report Page as "Teacher"
    Then I should see Reports Page Page Header starting with "Lui"
    When I click the Alert Report link
    Then the Alert Report should display
    