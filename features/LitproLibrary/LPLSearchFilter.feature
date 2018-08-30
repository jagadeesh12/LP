@f1  @smokelpl @regressionlpl
Feature: LitPro library 
	
  	Scenario: LitProLibrary - Validation of search a book in Books page - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on select drop down button
    And I select the All to show
    Then I should see the selected as All in a header
    When Search for the book
    And I click on the book
    Then Expected book should be displayed
    
    @feb221 
    Scenario: LitProLibrary - Validation of search a book in Books page - Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on select drop down button
    And I select the All to show
    Then I should see the selected as All in a header
    When Search for the book
    And I click on the book
    Then Expected book should be displayed
    
    @feb10 
  Scenario: LitProLibrary - Validation of Reading level filter for Lexile level in Books page - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on Reading Level
    Then I should see the Lexile Level header
    When I set a lexile level from "1" to "100"
    Then I should click on search button for teacher
    Then I should valiatae that the books shown should have lexile range from "1" to "100"
    
 
 # @feb152
  #Scenario: LitProLibrary - Validation of Colour Wheel filter in a Books page - Teacher
   # When I launch LitProLibrary as "Teacher"
   # Then I should see Scholastic Literacy Library Home Page
    #And I should see user Profile
    #When I click on Books tab
    #Then I should see the books page
    #When I click on Reading Level
    #Then Colour wheel header should be displayed
    #When select the colour from the list and it's validation
    #And I click on close button in popup
    #Then I should see the books page

 # @feb153
 # Scenario: LitProLibrary - Validation of Reading level filter in a Books page - Teacher
  #  When I launch LitProLibrary as "Teacher"
   # Then I should see Scholastic Literacy Library Home Page
    #And I should see user Profile
    #When I click on Books tab
    #Then I should see the books page
    #When I click on Reading Level
    #Then Reading Level header should be displayed
    #When select the reading level value from the list and it's validation
    #And I click on close button in popup
    #Then I should see the books page

  @feb16 
  Scenario: LitProLibrary - Validation of Genre for Fiction in a Books page - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When click on Genre button
    Then Genre header should be displayed
    When Select the Fiction from the list
    Then Fiction tag should be displayed
    When I open the book from the selection
    Then I should see the book header
    And Expected Genre value Fiction should be displayed
    When I click on close button in popup
    Then I should see the books page

  @feb161 
  Scenario: LitProLibrary - Validation of Genre for Non-Fiction in a Books page - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When click on Genre button
    Then Genre header should be displayed
    When Select the NonFiction from the list
    Then NonFiction tag should be displayed
    When I open the book from the selection
    Then I should see the book header
    And Expected Genre value NonFiction should be displayed
    When I click on close button in popup
    Then I should see the books page

  @feb162 @defectLPL-4359
  Scenario: LitProLibrary - Validation of Interest category filter in a Books page - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When Click on Interest category
    Then Interest category header should be displayed
    When Select the category from the list and it's validation
    And I click on close button in popup
    Then I should see the books page

  @feb17 
  Scenario: LitProLibrary - Validation of Reading level filter for Lexile level in Books page - Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on Reading Level
    Then I should see the Lexile Level header
    When I enter from
    And I enter to
    When Open the book from the selection
    Then I should see the book header
    And I should see the Lexile value
    When I click on close button in popup
    Then I should see the books page

#  @feb171
 # Scenario: LitProLibrary - Validation of Colour Wheel filter in a Books page - Student
  #  When I launch LitProLibrary as "Student"
   # Then I should see Scholastic Literacy Library Home Page
   # And I should see user Profile
    #When I click on Books tab
    #Then I should see the books page
    #When I click on Reading Level
    #Then Colour wheel header should be displayed
    #When select the colour from the list and it's validation
    #And I click on close button in popup
    #Then I should see the books page

 
 # @feb173
 # Scenario: LitProLibrary - Validation of Genre for Fiction in a Books page - Student
  #  When I launch LitProLibrary as "Student"
   # Then I should see Scholastic Literacy Library Home Page
    #And I should see user Profile
    #When I click on Books tab
    #Then I should see the books page
   # When click on Genre button
    #Then Genre header should be displayed
    #When Select the Fiction from the list
    #And Open the book from the selection
    #Then I should see the book header
    #And Expected Genre value Fiction should be displayed
    #When I click on close button in popup
    #Then I should see the books page

  @feb174
  Scenario: LitProLibrary - Validation of Genre for Non-Fiction in a Books page - Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When click on Genre button
    Then Genre header should be displayed
    When Select the NonFiction from the list
    And Open the book from the selection
    Then I should see the book header
    And Expected Genre value NonFiction should be displayed
    When I click on close button in popup
    Then I should see the books page
    
      @feb175 @defectLPL-4359
  Scenario: LitProLibrary - Validation of Interest category filter in a Books page - Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When Click on Interest category
    Then Interest category header should be displayed
    When Select the category from the list and it's validation
    And I click on close button in popup
    Then I should see the books page
	
	    @feb175 @EBB-3764 @3940 @LPL-3966 @LPL-3954
  Scenario: LitProLibrary - Validation of search lexile range for BR books - Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I set a lexile level from "BR400" to "BR1"
    Then I should click on search button
    When I open the information pop
    Then I should valiate that the books shown should have BR in the lexile

 @LPL-4076 @LPL-3954
  Scenario: LitProLibrary - Validation of search lexile range for BR books - Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I set a lexile level from "BR" to "BR"
    Then I should click on search button
    When I open the information pop and valiate that the books shown should have BR in the lexile
    
     @LPL-4076 @LPL-3966 @LPL-3954
  Scenario: LitProLibrary - Validation of search lexile range for BR books - Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I set a lexile level from "BR400" to "BR"
    Then I should click on search button
    When I open the information pop and valiate that the books shown should have BR in the lexile
    
    @LPL-4076 @LPL-3966 @LPL-3954
  Scenario: LitProLibrary - Validation of Interest category filter in a Books page - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I set a lexile level from "BR400" to "BR1" for teacher
    Then I should click on search button for teacher
    When I open the Assign pop and valiate that the books shown should have BR in the lexile
    
     @feb175 @EBB-3761 @EBB-3762 @EBB-3941 @LPL-3966 @LPL-3966 
  Scenario: LitProLibrary - Validation of dashboard for BR in lexile- Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    And I should validate that the Student lexile score at dashboard should have BR
    
     @feb162 @EBB-3761 @EBB-3762 @EBB-3944 
  Scenario: LitProLibrary - Validation Student lexile as a teacher in overview page-Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I go to Student overview page
    Then I should see BR in the lexile score for student "Jon Snow"
    
    @feb162 @EBB-3764 @EBB-3762 @3940 @LPL-3954
  Scenario: LitProLibrary - Validation of Interest category filter in a Books page - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I set a lexile level from "BR400" to "BR1" for teacher
    Then I should click on search button for teacher
    When I open the Assign pop and valiate that the books shown should have BR in the lexile
    	
  @CSrep @EBB-3686 
  Scenario: LitProLibrary - TIME SPENT READING should show time for books which are half read - Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    And I should collect the WORDS READ and TIME SPENT READING data    
    When I click on Books tab
    Then I should see the books page
   	When I check option "Unread"
   	When I set a lexile level from "BR400" to "1500"
   	Then I should click on search button
    When I open the information pop
    Then I should collect word count information
    When I click on the read button and half read the book
    And the close the book
    When I click on Home tab
    Then I should verify that WORDS READ and TIME SPENT READING data should increase accordingly
   
  @EBB-3713 
  Scenario: LitProLibrary - Validation of Interest category filter in a Books page - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    And I should search for keyword "Time"
    Then I should click on search button for teacher
    When I open the Assign pop and click on assign button
    And I should click on Class dropdown
    Then I should validate the Alphabetical order of the class for book assigning
    When I go to Student overview page
    And I should click on Class dropdown
    Then I should validate the Alphabetical order of the class
    When I should go to ASSIGNED BOOKS REPORT page
    And I should click on Class dropdown
    Then I should validate the Alphabetical order of the class in ASSIGNED BOOKS REPORT page
    
    
    @feb162 @EBB-3604 
  Scenario: LitProLibrary - series filter to be responsive to metadata changes and product subscription, so that my filters work for current content - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    #When Click on Interest category
    When I click on Series option
    Then I should not see "Classic Goosebumps" Series  

	@EBB-3604 
  Scenario: LitProLibrary - series filter to be responsive to metadata changes and product subscription, so that my filters work for current content - Student    
	When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    And I should collect the WORDS READ and TIME SPENT READING data    
    When I click on Books tab
    When I click on Series option
    Then I should not see "Classic Goosebumps" Series 
    
    	@EBB-3281 
  Scenario: LitProLibrary - series filter to be responsive to metadata changes and product subscription, so that my filters work for current content - Student    
	When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    And I should collect the WORDS READ and TIME SPENT READING data    
    When I click on Books tab
    Then I should not see "Age Range" Filter for "Student"
    
      @feb162 @EBB-3281 
  Scenario: LitProLibrary - series filter to be responsive to metadata changes and product subscription, so that my filters work for current content - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    Then I should not see "Age Range" Filter for "Teacher"
    
     @EBB-2811 
    Scenario: LitProLibrary - Teacher view, Students page, Students avatars should appear in alphabetical order (by surname) - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I go to Student overview page
    Then I should validate the Alphabetical order of the student last name
    
    @EBB-3872 
    Scenario: LitProLibrary - Student tab in arrange table data in alphanumerical order by class name- Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I go to Student overview page
    And I should select All Classes from dropdown
	Then I should verify the content of the table 
		|Table content|
		|Class|
		|Average Lexile|
		|Assigned Books|
		|Completed Books|
		|Words Read 	|
		|Time Spent Reading|
	Then I should verify that the content of the tables are arranged in alphanumerical order by class
	And I should verify that user should be able to sort column "Average Lexile"
	And I should verify that user should be able to sort column "Assigned Books"
	And I should verify that user should be able to sort column "Completed Books"
	And I should verify that user should be able to sort column "Words Read"
    
     @EBB-1856
    Scenario: LitProLibrary - Student tab in arrange table data in alphanumerical order by class name- Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I go to Student overview page
    And I should select All Classes from dropdown
	Then I should verify the content of the table 
		|Table content|
		|Class|
		|Average Lexile|
		|Assigned Books|
		|Completed Books|
		|Words Read 	|
		|Time Spent Reading|
	When I click on the export button and export "StudentOverview" CSV
	#Then I should validate that the 
		
    @EBB-4063 
    Scenario: LitProLibrary - Student tab in arrange table data in alphanumerical order by class name- Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I go to Student overview page
    And I should select All Classes from dropdown
	Then I should verify the content of the table 
		|Table content|
		|Class|
		|Average Lexile|
		|Assigned Books|
		|Completed Books|
		|Words Read 	|
		|Time Spent Reading|
	Then I should verify that Class column should shown below classes
		|Class|
		|Lui Class|
		|Math|
	
    
    @EBB-1858 
   Scenario: LitProLibrary - Validation of Interest category filter in a Books page - Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When Click on Interest category
    Then I should verify that all the Interest category are arranged in Alphabetical order
    
     @EBB-1858 
   Scenario: LitProLibrary - Validation of Interest category filter in a Books page - Student
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When Click on Interest category
    Then I should verify that all the Interest category are arranged in Alphabetical order
    
    
 @EBB-2696
Scenario: LitProLibrary - Validation of Interest category filter in a Books page - Student 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When Click on Education Level 
	Then I should verify that follwing Eduation level is present 
		|Education level|
		|Lower Primary|
		|Middle Primary|
		|Upper Primary|
		|Lower Secondary|
		|Middle Secondary|
		|Upper Secondary|
	When I select "Upper Primary" education level
	Then I should verify the education level of the books as "Upper Primary"
	
	
	  @feb162 @EBB-1857 
  Scenario: LitProLibrary - Verify the table content in Student overview page -Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I go to Student overview page
    And I select student data in table view	
    Then I should verify the content of the table 
		|Table content|
		|STUDENT|
		|Lexile |
		|Assigned Books|
		|Completed Books|
		|Words Read|
		|Time Spent Reading|
		
@EBB-1850 @EBB-1853 @EBB-1854
  Scenario: LitProLibrary - Validation of LP-LPL integration in POP-up details page- Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    And I should search for keyword "Black Beauty"
    Then I should click on search button for teacher
    When I open the Assign pop and Click on Quiz button
    Then I should verify that teacher is redirected to LP page "Black Beauty" to take a Quiz Popup
    And I click on View quiz button and verify that quiz
    When I search for the book "Black Beauty" in litpro
    When I Click on the read book button of "Black Beauty"
    Then I should be taken to LPL read book page of "Black Beauty"
    
@EBB-1850 @EBB-1853 @EBB-1854
  Scenario: LitProLibrary - Validation of LP-LPL integration in POP-up details page- Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    And I should search for keyword "Tundra"
    When I set a lexile level from "BR400" to "2000"
    Then I should click on search button for teacher
    When I open the info pop and Click on Quiz button
    Then I should verify that Student is redirected to LP page "Tundra" to take a Quiz Popup
    And I should close the Quiz popup
    When I search for the book "Tundra" in litpro as student
    When I Click on the read book button of "Tundra" as student
    Then I should be taken to LPL read book page of "Tundra"
    
    @EBB-1851 @EBB-2087
  Scenario: LitProLibrary - Validation of LP-LPL integration in Book cover page- Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    And I should search for keyword "Tundra"
    When I set a lexile level from "BR400" to "2000"
    Then I should click on search button for teacher
    When I should Click on Quiz button of book cover
    Then I should verify that Student is redirected to LP page "Tundra" to take a Quiz Popup
    And I should close the Quiz popup
    When I search for the book "Tundra" in litpro as student
    When I Click on the read book button of "Tundra" as student
    Then I should be taken to LPL read book page of "Tundra"
        
    @EBB-1851 @EBB-2087 
  Scenario: LitProLibrary - Validation of LP-LPL integration in Book cover page- Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    And I should search for keyword "Black Beauty"
    Then I should click on search button for teacher
    When I should Click on Quiz button of book cover
    Then I should verify that teacher is redirected to LP page "Black Beauty" to take a Quiz Popup
    And I click on View quiz button and verify that quiz
    When I search for the book "Black Beauty" in litpro
    When I Click on the read book button of "Black Beauty"
    Then I should be taken to LPL read book page of "Black Beauty"
    