@regressionlp @defaultsettings @testset @LPDefaultSettings.feature
Feature: LitPro Default Settings
  As a LitPro User I should be able to verify default settings
  at the School, Class and individual Student level
  so I can be sure the program functions as expected

  @admin  @Fixtrq
  Scenario Outline: Default Settings for SA at school level
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | Yes     | NA            |
      | Limit reading list titles to only those in the school library | No      | NA            |
      | Limit number of books in reading list to                      | No      |               |
      | Show student Lexile measure after test completion             | Yes     | NA            |
      | Limit test access to certain days and times                   | No      | NA            |
      | Allow students to see their reading list                      | Yes     | NA            |
      | Limit reading list to titles with book quizzes                | Yes     | NA            |
      | Limit practice test to one per student                        | Yes     | NA            |
      | Allow students to change reading interests                    | Yes     | NA            |
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | Yes     | NA            |
      | Allow student to print                             | No      | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | No      | NA            |
    And I should see Awards Based set to "Points Earned"
    And I should see the following settings for awards
      | Award Name | Value |
      | Gold       | 500   |
      | Silver     | 250   |
      | Bronze     | 100   |
      | Red        | 50    |
      | Blue       | 25    |
      Examples:
      |username|password|usertype|
      |WalterWhite|welcome1|admin|

  @admin 
  Scenario Outline: SA Default LitPro Settings at Class level
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | Yes     | NA            |
      | Limit reading list titles to only those in the school library | No      | NA            |
      | Limit number of books in reading list to                      | No      |               |
      | Show student Lexile measure after test completion             | Yes     | NA            |
      | Limit test access to certain days and times                   | No      | NA            |
      | Allow students to see their reading list                      | Yes     | NA            |
      | Limit reading list to titles with book quizzes                | Yes     | NA            |
      | Limit practice test to one per student                        | Yes     | NA            |
      | Allow students to change reading interests                    | Yes     | NA            |
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | Yes     | NA            |
      | Allow student to print                             | No      | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | No      | NA            |
    And I should see Awards Based set to "Points Earned"
    And I should see the following settings for awards
      | Award Name | Value |
      | Gold       | 500   |
      | Silver     | 250   |
      | Bronze     | 100   |
      | Red        | 50    |
      | Blue       | 25    |
Examples:
      |username|password|usertype|
      |WalterWhite|welcome1|admin|
  @admin 
  Scenario Outline: SA Default LitPro Settings at Student Level
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | Yes     | NA            |
      | Limit reading list titles to only those in the school library | No      | NA            |
      | Limit number of books in reading list to                      | No      |               |
      | Show student Lexile measure after test completion             | Yes     | NA            |
      | Limit test access to certain days and times                   | No      | NA            |
      | Allow students to see their reading list                      | Yes     | NA            |
      | Limit reading list to titles with book quizzes                | Yes     | NA            |
      | Limit practice test to one per student                        | Yes     | NA            |
      | Allow students to change reading interests                    | Yes     | NA            |
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | Yes     | NA            |
      | Allow student to print                             | No      | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | No      | NA            |
    And I should see Awards Based set to "Points Earned"
    And I should see the following settings for awards
      | Award Name | Value |
      | Gold       | 500   |
      | Silver     | 250   |
      | Bronze     | 100   |
      | Red        | 50    |
      | Blue       | 25    |
Examples:
      |username|password|usertype|
      |WalterWhite|welcome1|admin|
  @teacher 
  Scenario Outline: Teacher Default LitPro Settings at Class Level
   Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | Yes     | NA            |
      | Limit reading list titles to only those in the school library | No      | NA            |
      | Limit number of books in reading list to                      | No      |               |
      | Show student Lexile measure after test completion             | Yes     | NA            |
      | Limit test access to certain days and times                   | No      | NA            |
      | Allow students to see their reading list                      | Yes     | NA            |
      | Limit reading list to titles with book quizzes                | Yes     | NA            |
      | Limit practice test to one per student                        | Yes     | NA            |
      | Allow students to change reading interests                    | Yes     | NA            |
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | Yes     | NA            |
      | Allow student to print                             | No      | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | No      | NA            |
    And I should see Awards Based set to "Points Earned"
    And I should see the following settings for awards
      | Award Name | Value |
      | Gold       | 500   |
      | Silver     | 250   |
      | Bronze     | 100   |
      | Red        | 50    |
      | Blue       | 25    |
      Examples:
      |username|password|usertype|
      |TonyStark|welcome1|teacher|

  @teacher 
  Scenario Outline: Teacher Default LitPro Settings at Student level
  
   Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | Yes     | NA            |
      | Limit reading list titles to only those in the school library | No      | NA            |
      | Limit number of books in reading list to                      | No      |               |
      | Show student Lexile measure after test completion             | Yes     | NA            |
      | Limit test access to certain days and times                   | No      | NA            |
      | Allow students to see their reading list                      | Yes     | NA            |
      | Limit reading list to titles with book quizzes                | Yes     | NA            |
      | Limit practice test to one per student                        | Yes     | NA            |
      | Allow students to change reading interests                    | Yes     | NA            |
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | Yes     | NA            |
      | Allow student to print                             | No      | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | No      | NA            |
    And I should see Awards Based set to "Points Earned"
    And I should see the following settings for awards
      | Award Name | Value |
      | Gold       | 500   |
      | Silver     | 250   |
      | Bronze     | 100   |
      | Red        | 50    |
      | Blue       | 25    |
   Examples:
      |username|password|usertype|
      |TonyStark|welcome1|teacher|