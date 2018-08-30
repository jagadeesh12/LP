@regressionlp @savesettings @LPSaveSettings.feature
Feature: LitPro Save Settings by SA
  As an SA LitPro User I should be able to save settings
  at the School, Class and individual Student level
  so I can organize the sttings the way I want to

  #for story 130
  # @admin
   
  Scenario Outline: Verify SA is able to change settings
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
	Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|
    
  #@admin
  Scenario Outline: Verify SA sees Save Settings Confirmation message
         Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I change all of the default settings
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
		Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|
  #@admin
  Scenario Outline: Verify Setting Changes at School level are reflected at Class Level when using default settings
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
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    # min days between tests not being saved
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | No      | NA            |
      | Limit reading list titles to only those in the school library | Yes     | NA            |
      | Limit number of books in reading list to                      | Yes     | 1             |
      | Show student Lexile measure after test completion             | No      | NA            |
      | Limit test access to certain days and times                   | Yes     | NA            |
      | Allow students to see their reading list                      | No      | NA            |
      | Limit reading list to titles with book quizzes                | No      | NA            |
      | Limit practice test to one per student                        | No      | NA            |
      | Allow students to change reading interests                    | No      | NA            |
    # min days between quizzes not being saved
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | No      | NA            |
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 60            |
      | Limit quiz access to certain days and times        | Yes     | NA            |
      | Restrict number of quiz attempts to                | No      | 33            |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | Yes     | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 40    |
      | Silver     | 20    |
      | Bronze     | 8     |
      | Red        | 4     |
      | Blue       | 2     |
			Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|
  #@admin
  Scenario Outline: Verify Setting Changes at School level are reflected at Student Level when using default settings
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
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    # min days between tests not being saved
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | No      | NA            |
      | Limit reading list titles to only those in the school library | Yes     | NA            |
      | Limit number of books in reading list to                      | Yes     | 1             |
      | Show student Lexile measure after test completion             | No      | NA            |
      | Limit test access to certain days and times                   | Yes     | NA            |
      | Allow students to see their reading list                      | No      | NA            |
      | Limit reading list to titles with book quizzes                | No      | NA            |
      | Limit practice test to one per student                        | No      | NA            |
      | Allow students to change reading interests                    | No      | NA            |
    # min days between quizzes not being saved
    And I should see following settings under Book Quiz Settings:
      | Setting Name                                       | Enabled | Default Value |
      | Display incorrect answers                          | No      | NA            |
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 60            |
      | Limit quiz access to certain days and times        | Yes     | NA            |
      | Restrict number of quiz attempts to                | No      | 33            |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | Yes     | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 40    |
      | Silver     | 20    |
      | Bronze     | 8     |
      | Red        | 4     |
      | Blue       | 2     |
		Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|
  #@admin
  Scenario Outline: Verify Setting Changes at School level are not reflected at Class Level when Class settings have been changed
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    When I change settings on the Class page
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | No      | NA            |
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
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | No      | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 39    |
      | Silver     | 19    |
      | Bronze     | 7     |
      | Red        | 3     |
      | Blue       | 1     |
    When I click on the school in the smartbar
    Then I should see Settings Page Page Header starting with "School of Breaking Bad"
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
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | No      | NA            |
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
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | No      | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 39    |
      | Silver     | 19    |
      | Bronze     | 7     |
      | Red        | 3     |
      | Blue       | 1     |
	Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|
  #130
  #@admin
  Scenario Outline: Verify Setting Changes at School level are not reflected at Student Level when Student settings have been changed
     Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    When I change settings on the Student page
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | No      | NA            |
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
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | Yes     | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 39    |
      | Silver     | 19    |
      | Bronze     | 7     |
      | Red        | 3     |
      | Blue       | 1     |
    When I click on the school in the smartbar
    Then I should see Settings Page Page Header starting with "School of Breaking Bad"
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
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | No      | NA            |
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
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | Yes     | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 39    |
      | Silver     | 19    |
      | Bronze     | 7     |
      | Red        | 3     |
      | Blue       | 1     |
	Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|
  # for story 131
  #@admin
   
  Scenario Outline: Verify Save Setting Confirmation message at Class level
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    When I change settings on the Class page
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
		Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|
  #131
  #@admin
   
  Scenario Outline: Verify Changes at Class level Saved at Class level
     Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    When I change settings on the Class page
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | No      | NA            |
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
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | No      | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 39    |
      | Silver     | 19    |
      | Bronze     | 7     |
      | Red        | 3     |
      | Blue       | 1     |
		Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|
  #131
  #@admin
   
  Scenario Outline: Verify Changes at Class level saved at Student level
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    When I change settings on the Class page
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | No      | NA            |
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
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | No      | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 39    |
      | Silver     | 19    |
      | Bronze     | 7     |
      | Red        | 3     |
      | Blue       | 1     |
Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|
  #131
  #@admin
   
  Scenario Outline: Verify Setting Changes at Class level are not reflected at School Level
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
    When I change settings on the Class page
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    When I click on the school in the smartbar
    Then I should see Settings Page Page Header starting with "School of Breaking Bad"
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
  #131
  #@admin
   
  Scenario Outline: Verify Setting Changes at Class level are not reflected on other Classes
     Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Math"
    Then I should see Settings Page Page Header starting with "Math"
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
    When I enter Settings search string "Science"
    Then I should see Settings Page Page Header starting with "Science"
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
	
  #132
  @admin 
  Scenario Outline: Verify Setting Changes at Student level confirmation message
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    When I change settings on the Student page
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    	Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|

  #132
  @admin  
  Scenario Outline: Verify Setting Changes at Student saved at student level
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    When I change settings on the Student page
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    Then I should see following settings under LitPro Test Settings:
      | Setting Name                                                  | Enabled | Default Value |
      | Minimum number of days between completed tests                | Yes     | 50            |
      | Require students to take practice test                        | No      | NA            |
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
      | Allow student to print                             | Yes     | NA            |
      | Quiz pass mark                                     | NA      | 70            |
      | Limit quiz access to certain days and times        | No      | NA            |
      | Restrict number of quiz attempts to                | Yes     | 3             |
      | Number of days between quiz attempts               | Yes     | 7             |
      | Allow students to search outside educational level | No     | NA            |
    And I should see Awards Based set to "Quizzes Passed"
    And I should see the following settings for books awards
      | Award Name | Value |
      | Gold       | 39    |
      | Silver     | 19    |
      | Bronze     | 7     |
      | Red        | 3     |
      | Blue       | 1     |
	Examples:
	  |username|password|usertype|
    |WalterWhite|welcome1|admin|
  #132
  @admin  
  Scenario Outline: Verify Setting Changes at Student level are not reflected at School Level
      Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    When I change settings on the Student page
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    When I click on the school in the smartbar
    Then I should see Settings Page Page Header starting with "School of Breaking Bad"
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
  #132
  @admin 
  Scenario Outline: Verify Setting Changes at Student level are not reflected at Class Level
    Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    When I change settings on the Student page
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
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
      

  #132 Ed McCreery
  @admin 
  Scenario Outline: Verify Setting Changes at Student do not affect other students
   Given I launch Litpro and browse to Settings Page using "<username>" and "<password>" with "<usertype>"
    When I click the Restore Defaults button
    Then Settings Restored Message should be displayed
    When I enter Settings search string "Martina"
    Then I should see Settings Page Page Header starting with "Joe Martina"
    When I change settings on the Student page
    When I click the Settings page Save button
    Then 'Settings Saved' Message should be displayed
    When I enter Settings search string "McCreery"
    Then I should see Settings Page Page Header starting with "Ed McCreery"
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
      | Allow students to search outside educational level | No     | NA            |
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