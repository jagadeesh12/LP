@functional @inlibrary @regressionlpset1
Feature: In Library - Import CSV
  As a LitPro User
  I should be able to upload books info
  So that I can ....

  @admin @sanity @July11
  Scenario: Import Books to Library
    Given I browse to In Library Page as "Admin"
    Then I should see In Library Page Header - "Match Your Library Books"
    When I select csv file
    And I click Upload button
    Then Import status should show "Done"
