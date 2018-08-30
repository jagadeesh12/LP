 @functional @inlibrary  
Feature: In Library - Import CSV
  As a LitPro User
  I should be able to upload books info
  So that I can ....

  @admin @wip
  Scenario: Import Books - Verify Upload History Table
    Given I browse to In Library Page as "Admin"
    Then I should see In Library Page Header - "Match Your Library Books"
    When I select csv file
    And I click Upload button
    Then Import status should show "Done"
    And I should see a new row added to the Upload History table
    And Upload History table should have following columns:
      | File Name | Status | Successful Matches | No Matches Found | Date Uploaded | Uploaded By | Failed Records |
    And File Name column should show uploaded file name
    And Status should show 'Done'
   # And Matches + No Matches + Failed Records count should be equal to the count of rows in uploaded file
    And Date uploaded should show current date
    And Uploaded By should show current user name

  @admin   
  Scenario: In library - Download Successful Matches csv file
    Given I browse to In Library Page as "Admin"
    Then I should see In Library Page Header - "Match Your Library Books"
    When I click on 'Successful Matches' link
    Then I should be able to save the csv file as "SuccessfulMatch.csv"
    And 'SuccessfulMatch.csv' file record count should be 2
    And 'SuccessfulMatch.csv' should have following 2 records
      | TITLE     | AUTHOR_NAME    | 
      | Snow Idea | Jim Kjelgaard  | 
      | Snow Dog  |  Pat Flynn     |

  @admin @wip 
  Scenario: In library - Download Failed Matches csv file
    Given I browse to In Library Page as "Admin"
    Then I should see In Library Page Header - "Match Your Library Books"
    When I click on 'Failed Matches' link
    Then I should be able to save the csv file as "FailedMatches.csv"
    And 'FailedMatches.csv' file record count should be 2
    And 'FailedMatches.csv' should have following 2 records
      | ROW_NO | ERROR_ROW_TEXT             | ERROR                     |
      | 8      | Walk with me in H          | Row 8 missing author name |
      | 9      | Joe Duplantier             | Row 9 missing title       |
      
    @admin @wip 
  Scenario: In library - Review close matches 
    Given I browse to In Library Page as "Admin"
    Then I should see In Library Page Header - "Match Your Library Books"
    Then I click on ReviewCloseMatches button
    Then I must see title "Harry Potter and the" and author "J.K. Rowling"
    And I see and select  possible match book as "Harry Potter and the Half-Blood Prince (1030L)"
    And I must see Close Match Review left is zero
    
     @admin @wip 
  Scenario: In library - Download No Matches csv file
    Given I browse to In Library Page as "Admin"
    Then I should see In Library Page Header - "Match Your Library Books"
    When I click on 'No matches' link
    Then I should be able to save the csv file as "NoMatches.csv"
    And 'NoMatches.csv' should have following records
       | TITLE     | AUTHOR_NAME    | 
       | adsf      | adfs           |
       | asfasdf   | asdfadsf asfdadsf |
    
      
   @admin @wip 
  Scenario: Import Books - Verify Upload History Table
    Given I browse to In Library Page as "Admin"
    Then I should see In Library Page Header - "Match Your Library Books"   
	Then I should verify tooltip added to the big Library Match icon in the upper right of home page "Click here to match books in your school library to books and quizzes in Scholastic Literacy Pro"
    