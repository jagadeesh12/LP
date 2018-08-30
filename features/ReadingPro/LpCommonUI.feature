@functional @common @regressionlp
Feature: LitPro Common UI
  As a LitPro User
  I should have access to Literacy Pro
  So that I can take quizzes, view my results and ...

  @student @sanity @regressionlp123 
  Scenario: LitPro Common UI - Student
    When I launch LitPro as "Student"
    Then I should see Scholastic Literacy Pro Home Page
    And I should see user greeting text "Welcome, "
    And I should see below tabs:
      | Home | Search | My Results | LitPro Test |
    And I should see Logout link

  @teacher @sanity
  Scenario: LitPro Common UI - Teacher
    When I launch LitPro as "Teacher"
    Then I should see Scholastic Literacy Pro Home Page
    And I should see user greeting text "Welcome, "
    And I should see below tabs:
      | Home | Reports | Search | Settings | Benchmarks |
    And I should see Logout link

  @admin @sanity
  Scenario: LitPro Common UI - Admin
    When I launch LitPro as "Admin"
    Then I should see Scholastic Literacy Pro Home Page
    And I should see user greeting text "Welcome, "
    And I should see below tabs:
      | Home | Reports | Search | Settings | Benchmarks |
    And I should see Logout link

	@admin @sanity 
   Scenario: LitPro Help Icon Common UI - Admin
    When I launch LitPro as "Admin"
    Then I should see Scholastic Literacy Pro Home Page
    #LP-815
    Then I should verify the help icon
    #LP-1138
    And I should verify the help dropdown link
    
    @teacher 
    Scenario: LitPro Help Icon Common UI - Teacher
    When I launch LitPro as "Teacher"
    Then I should see Scholastic Literacy Pro Home Page
    #LP-815
    Then I should verify the help icon
    #LP-1138
    And I should verify the help dropdown link  
    
    
      @admin @sanity
  Scenario: As a School, I don't want to load all the students when click on Setting and Reports Page
	Given I browse to Settings Page as "admin"
	#LP-3642, LP-3643
    Then I should see the schoolname in roster tree
    Then I should verify that student should not get loaded
    When I should click on class name in roster tree which has student
    Then I should verify that student should get loaded
    Then I should Click on report page
    Then I should see the schoolname in roster tree
    Then I should verify that student should not get loaded
    When I should click on class name in roster tree which has student
    Then I should verify that student should get loaded
    
      @teacher @sanity  
  Scenario: As a Teacher, I don't want to load all the students when click on Setting and Reports Page
	#LP-3642, LP-3643
	Given I browse to Settings Page as "Teacher"
    Then I should see class name
    Then I should verify that student should not get loaded for teacher
    When I should click on class name of teacher in roster tree which has student
    Then I should verify that student should get loaded for teacher
    Then I should Click on report page
   	Then I should verify that student should not get loaded for teacher
    When I should click on class name of teacher in roster tree which has student
    Then I should verify that student should get loaded for teacher