@functional @reports @regressionlp 
Feature: LitPro Reports UI validation at School level
  As a LitPro User
  I should be able to view school level reports
  So that I can ....

  @admin @regression 
  Scenario: Reading Proficiency Report UI verification
    Given I browse to 'Reports' page as an "Admin"
    Then I should see Reports page header with text "Reports for"
    And I should see report card name "Reading Proficiency Report"
    When I click on View Report button
    Then I see the report card on a modal with header "Reading Proficiency Report"
    And the report modal description should read 'This report shows the percentage or number of students in each proficiency band.'
    And the report modal footer should read '*Imported data may affect averages across reports. For more information, click here.'
    And Reading Proficiency Report modal should display following buttons on the header
      | Report modal Elements |
      | export                |
      | print                 |
      | close                 |
    And Reading Proficiency Report modal should display following reports
      | pie   |
      | graph |
      | table |
    When I click on 'School Calendar' dropdown
    Then I should see list of school year options
    And I click on bar 'graph' button
    And I click on 'table' button
    When I click on 'close' button
    Then I should see Reports page header with text "Reports for"

  @admin @regression 
  Scenario: Book Comprehension Report UI verification
    Given I browse to 'Reports' page as an "Admin"
    Then I should see Reports page header with text "Reports for"
    And I should see report card name "Book Comprehension Report"
    When I click on View Report button
    Then I see the report card on a modal with header "Book Comprehension Report"
    And the report modal footer should read '*Imported data may affect averages across reports. For more information, click here.'
    And Book Comprehension Report modal should display following buttons on the header
      | Report modal Elements |
      | export                |
      | print                 |
      | close                 |
    And Book Comprehension Report modal should display following reports
      | graph       |
      | table       |
    When I click on 'School Calendar' dropdown
    Then I should see list of school year options
    And I click on 'table' button
    When I click on 'close' button
    Then I should see Reports page header with text "Reports for"

  @admin @regression 
  Scenario: Quiz Pass Rate Report UI verification
    Given I browse to 'Reports' page as an "Admin"
    Then I should see Reports page header with text "Reports for"
    And I should see report card name "Quiz Pass Rate Report"
    When I click on View Report button
    Then I see the report card on a modal with header "Quiz Pass Rate Report"
    And the report modal footer should read '*Imported data may affect averages across reports. For more information, click here.'
    And Quiz Pass Rate Report modal should display following buttons on the header
      | Report modal Elements |
      | export                |
      | print                 |
      | close                 |
    And Quiz Pass Rate Report modal should display following reports
      | graph |
      | table |
    When I click on 'School Calendar' dropdown
    Then I should see list of school year options
    And I click on 'table' button
    When I click on 'close' button
    Then I should see Reports page header with text "Reports for"
