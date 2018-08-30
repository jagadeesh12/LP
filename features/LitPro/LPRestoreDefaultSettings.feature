@regressionlp @restoresettings @LPRestoreDefaultSettings.feature
Feature: LitPro Restore Default Settings
  As a LitPro User I should be able to restore default settings
  at the School, Class and individual Student level
  so I can be return the system to a known state

  @admin
  Scenario Outline: Set Default Settings for SA at school level
      Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    	Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|

  @admin 
  Scenario Outline: Return to Default Settings for SA at school level
        Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I change all of the default settings
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | No      | 49            |
      | Require students to take practice test                        | No      | NA            |
      | Limit reading list titles to only those in the school library | Yes     | NA            |
      | Limit number of books in reading list to                      | Yes     | 1             |
      | Show student Lexile measure after test completion             | No      | NA            |
      | Limit test access to certain days and times                   | Yes     | NA            |
      | Allow students to see their reading list                      | No      | NA            |
      | Limit reading list to titles with book quizzes                | No      | NA            |
      | Limit practice test to one per student                        | No      | NA            |
      | Allow students to change reading interests                    | No      | NA            |
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | No      | NA            |
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 60            |
      | Limit quiz access to certain days and times        | Yes     | NA            |
      | Restrict number of quiz attempts to                | No      | 33            |
      | Number of days between quiz attempts               | No      | 77            |
      | Allow students to search outside educational level | Yes     | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 40    |
      | Silver     | 20    |
      | Bronze     | 8     |
      | Red        | 4     |
      | Blue       | 2     |
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
  Scenario Outline: Return to Default Settings for SA at class level
        Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    Then I should see that there is no Restore Defaults button
    When I change all of the default settings
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | No      | 49            |
      | Require students to take practice test                        | No      | NA            |
      | Limit reading list titles to only those in the school library | Yes     | NA            |
      | Limit number of books in reading list to                      | Yes     | 1             |
      | Show student Lexile measure after test completion             | No      | NA            |
      | Limit test access to certain days and times                   | Yes     | NA            |
      | Allow students to see their reading list                      | No      | NA            |
      | Limit reading list to titles with book quizzes                | No      | NA            |
      | Limit practice test to one per student                        | No      | NA            |
      | Allow students to change reading interests                    | No      | NA            |
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | No      | NA            |
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 60            |
      | Limit quiz access to certain days and times        | Yes     | NA            |
      | Restrict number of quiz attempts to                | No      | 33            |
      | Number of days between quiz attempts               | No      | 77            |
      | Allow students to search outside educational level | Yes     | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 40    |
      | Silver     | 20    |
      | Bronze     | 8     |
      | Red        | 4     |
      | Blue       | 2     |
    When I click on the school in the smartbar
    #Then I should see Settings Page Page Header starting with "LP Default"
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
  Scenario Outline: Return to Default Settings for SA at student level
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    When I change all of the default settings
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | No      | 49            |
      | Require students to take practice test                        | No      | NA            |
      | Limit reading list titles to only those in the school library | Yes     | NA            |
      | Limit number of books in reading list to                      | Yes     | 1             |
      | Show student Lexile measure after test completion             | No      | NA            |
      | Limit test access to certain days and times                   | Yes     | NA            |
      | Allow students to see their reading list                      | No      | NA            |
      | Limit reading list to titles with book quizzes                | No      | NA            |
      | Limit practice test to one per student                        | No      | NA            |
      | Allow students to change reading interests                    | No      | NA            |
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | No      | NA            |
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 60            |
      | Limit quiz access to certain days and times        | Yes     | NA            |
      | Restrict number of quiz attempts to                | No      | 33            |
      | Number of days between quiz attempts               | No      | 77            |
      | Allow students to search outside educational level | Yes     | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 40    |
      | Silver     | 20    |
      | Bronze     | 8     |
      | Red        | 4     |
      | Blue       | 2     |
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

  @teacher
  Scenario Outline: No Restore Defaultsbutton for Teacher at class level
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    Then I should see that there is no Restore Defaults button
	 Examples:
	  |username|password|usertype|
    |TonyStark|welcome1|teacher|
  @teacher 
  Scenario Outline: Return to Default Settings for Teacher at student level
   	Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I change all of the default settings
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | No      | 49            |
      | Require students to take practice test                        | No      | NA            |
      | Limit reading list titles to only those in the school library | Yes     | NA            |
      | Limit number of books in reading list to                      | Yes     | 1             |
      | Show student Lexile measure after test completion             | No      | NA            |
      | Limit test access to certain days and times                   | Yes     | NA            |
      | Allow students to see their reading list                      | No      | NA            |
      | Limit reading list to titles with book quizzes                | No      | NA            |
      | Limit practice test to one per student                        | No      | NA            |
      | Allow students to change reading interests                    | No      | NA            |
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | No      | NA            |
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 60            |
      | Limit quiz access to certain days and times        | Yes     | NA            |
      | Restrict number of quiz attempts to                | No      | 33            |
      | Number of days between quiz attempts               | No      | 77            |
      | Allow students to search outside educational level | Yes     | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 40    |
      | Silver     | 20    |
      | Bronze     | 8     |
      | Red        | 4     |
      | Blue       | 2     |
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
    |TonyStark|welcome1|teacher| 