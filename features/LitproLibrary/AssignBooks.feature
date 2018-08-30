@f1 @regressionlpl @smokelpl
Feature: LitPro library  Assign and Unassign Books and collections

  @lpl @EBB-3209 @EBB-3208
  Scenario: LitProLibrary - Assign a book to entire class and verify if the book is avaible in Recent Assignments Secction home page- Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on Assign text on the book
    Then I should see the pop up with Read and Assign buttons
    When I click on Assign button
    Then I should see the Assign to header
    When I click on entire class
    Then I should see the entire class students
    When I click on Assign to students
    Then successful pop up should be displayed
    When I click on done button
    Then I should see the books page
    When I click on Home tab
    Then I should verify that Recent Assignments should contain above book

  @regression @EBB-3209 @EBB-3208
  Scenario: LitProLibrary Student should half read the book -Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    When I click on Books tab
    Then I should see the books page
    When I set a lexile level from "BR400" to "1500"
    And I should check option "Unread"
    Then I should click on search button
    When I open the information pop
    And I should click on Read button
    And I should read the book for some time

  @EBB-3208 @EBB-3209
  Scenario: LitProLibrary - Verify that above half read book is appearing in Recent student activity section at home page - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    And I should verify that Recent student activity should contain above book with Status as "read"

  @regression @EBB-3208 @EBB-3209 
  Scenario: LitProLibrary Student should fully read the book -Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    When I click on Books tab
    Then I should see the books page
    When I set a lexile level from "BR400" to "1500"
    And I should check option "Unread"
    Then I should click on search button
    When I open the information pop
    And I should click on Read button
    And I should read the books completetly

  @EBB-3208 @EBB-3209 
  Scenario: LitProLibrary - Verify that above fully read book is appearing in Recent student activity section at home page - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    And I should verify that Recent student activity should contain above book with Status as "finished reading"

  @EBB-3208 @EBB-3209
  Scenario: LitProLibrary - Assign a book to entire class and verify if the book is avaible in Recent Assignments Secction home page- Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on Assign text on the book
    Then I should see the pop up with Read and Assign buttons
    When I click on Assign button
    Then I should see the Assign to header
    When I click on entire class
    Then I should see the entire class students
    When I click on Assign to students
    Then successful pop up should be displayed
    When I click on done button
    Then I should see the books page

  @regression @EBB-3209 @EBB-3208 
  Scenario: LitProLibrary Student should fully read the book and submit the audio -Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    When I click on Books tab
    When I click on Home tab
    When I open the information pop of assigned book
    And I should click on Read button
    And I should read the books and record the audio


  @EBB-3209 @EBB-3208
  Scenario: LitProLibrary - Verify that above book is appearing in Recent student activity section at home page - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    And I should verify that Recent student activity should contain above book with Status as "submitted audio recording on"

  @lpl
  Scenario: LitProLibrary - unassign of assigned book to entire class - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on ASSIGNED text on the book
    Then I should see the pop up with Read and Assigned buttons
    When I click on Assigned button
    Then I should see the Assigned to header
    When I click on entire class
    Then I should see the entire class students
    Then I click on clear all assignments
    When I click on Save changes
    Then I should see the books page

  @lpl
  Scenario: LitProLibrary - Assign multiple books to entire class - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on Choose Multiple Books button
    Then I should see the Assign Books and Hide Books options are disabled
    When I select the multiple books by clicking on tick mark
    Then I should see the Assign Books and Hide Books options are enabled
    When I click on Assign Books button
    Then I should see the Assign to header
    When I click on entire class
    Then I should see the entire class students
    When I click on Assign to students
    Then successful pop up should be displayed
    When I click on done button
    Then I should see the books page

  @lpl
  Scenario: LitProLibrary - Assign a book to entire class - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on Assign text on the book
    Then I should see the pop up with Read and Assign buttons
    When I click on Assign button
    Then I should see the Assign to header
    When I click on entire class
    Then I should see the entire class students
    When I click on Assign to students
    Then successful pop up should be displayed
    When I click on done button
    Then I should see the books page

  @lpl
  Scenario: LitProLibrary - unassign of assigned book to entire class - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on ASSIGNED text on the book
    Then I should see the pop up with Read and Assigned buttons
    When I click on Assigned button
    Then I should see the Assigned to header
    When I click on entire class
    Then I should see the entire class students
    Then I click on clear all assignments
    When I click on Save changes
    Then I should see the books page

  @lpl
  Scenario: LitProLibrary - Assign multiple books to entire class - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on Choose Multiple Books button
    Then I should see the Assign Books and Hide Books options are disabled
    When I select the multiple books by clicking on tick mark
    Then I should see the Assign Books and Hide Books options are enabled
    When I click on Assign Books button
    Then I should see the Assign to header
    When I click on entire class
    Then I should see the entire class students
    When I click on Assign to students
    Then successful pop up should be displayed
    When I click on done button
    Then I should see the books page

  @lplp
  Scenario: LitProLibrary - Assign single book in a collection of books to entire class - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Collections tab
    Then I should see collections Page
    When I click on the collection of books to assign
    Then I should see the Scholastic collections header
    When I click on ASSIGN text on the book in Collections Page
    Then I should see the Read and Assign buttons in popup
    When I click on Assign button in popup
    Then I should see the Assign to header in popup
    When I click on entire class
    Then I should see the entire class students in popup
    When I click on Assign to students in popup
    Then successful pop up should be displayed in popup
    When I click on done button in popup
    Then I should see the Scholastic collections header

  @regression
  Scenario: LitProLibrary Verification of Assigned Collection count  After Assigning to Entire Class -Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    Then I get Assigned collections count
    When I click on Collections tab
    Then I should see collections Page
    When I click on ASSIGN text on the book in Collections Page
    Then I should see the Assign to header in popup
    When I click on entire class
    Then I should see the entire class students in popup
    When I click on Assign to students in popup
    Then successful pop up should be displayed in popup
    When I click on done button in popup
    Then Assigned collections count must be increased by 5

  @regression @EBB-3140
  Scenario: LitProLibrary Verification of message after assiging the collections to the student-Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    Then I get Assigned collections count
    When I click on Collections tab
    Then I should see collections Page
    When I click assign a collection
    Then I should see the Assign to header in popup
    When I click on entire class
    Then I should see the entire class students in popup
    When I click on Assign to students in popup
    Then successful pop up should be displayed in popup
    When I click on done button in popup

  @regression @EBB-3140
  Scenario: LitProLibrary Checking Student message after assigment of the collections -Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on message icon
    Then student should see a message "Your teacher has assigned you the collection" for collection assignment
    When I click on the collection message student

  @regression @EBB-3024
  Scenario: LitProLibrary Verification of message after assiging the collections to the student-Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    Then I get Assigned collections count
    When I click on Collections tab
    Then I should see collections Page
    And I should verify that collections are arrange in alphabetical order

  @regression @EBB-3024
  Scenario: LitProLibrary Verification of message after assiging the collections to the student-Teacher
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Collections tab
    Then I should see collections Page Student
    And I should verify that collections are arrange in alphabetical order in student collection page

  @regression @EBB-2277 @EBB-2283
  Scenario: LitProLibrary Should be able to sort the books in collections according to Lexile and Name-Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    Then I get Assigned collections count
    When I click on Collections tab
    Then I should see collections Page
    When I should open a Collection
    And I should sort the books of collection by "NAME"
    Then I should see the books of the collections arranged by "NAME"
    Then I should see collections Page
    When I should open a Collection
    And I should sort the books of collection by "LEXILE"
    Then I should see the books of the collections arranged by "LEXILE"

  @regression @lplfi1123111
  Scenario: LitProLibrary Verification of Assigned books count After Assigning to Entire Class -Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    Then I get Assigned books count
    When I click on Books tab
    Then I should see the books page
    When I click on Assign text on the book
    When I click on Assign button
    Then I should see the Assign to header
    When I click on entire class
    Then I should see the entire class students
    When I click on Assign to students
    Then successful pop up should be displayed
    When I click on done button
    Then Assigned book count must be increased by 5

  @Teacher
  Scenario: LitProLibrary - Validation of assigned book reading status - Teacher->Student
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Books tab
    Then I should see the books page
    When I click on select drop down button
    And I select the All to show
    Then I should see the selected as All in a header
    When I click on Assign text on the book
    Then I should see the pop up with Read and Assign buttons
    When I click on Assign button
    Then I should see the Assign to header
    Then I should see the entire class students
    When I click on entire class
    When I click on Assign to students
    Then successful pop up should be displayed
    When I click on done button
    Then I should see the books page

  Scenario: LitProLibrary - Validation of assigned book reading status - Teacher->Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    And I should see the book status as NOT STARTED

  @lplp
  Scenario: LitProLibrary - Assign collection of books to entire class - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Collections tab
    Then I should see collections Page
    When I click on ASSIGN text on the book in Collections Page
    Then I should see the Assign to header in popup
    When I click on entire class
    Then I should see the entire class students in popup
    When I click on Assign to students in popup
    Then successful pop up should be displayed in popup
    When I click on done button in popup
    Then I should see collections Page

  @lplp @cleanup1
  Scenario: LitProLibrary - UnAssign collection of books to entire class - Teacher
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    And I should see user Profile
    When I click on Collections tab
    Then I should see collections Page
    When I click on ASSIGNED text on the book in Collections Page
    When I click on entire class in colletion Page
    Then I should see the entire class students in popup
    When I click on clear all assignments in collections Page
    When I click on Save changes in collections Page
    Then I should see collections Page

  @EBB-2570
  Scenario: LitProLibrary Student should fully read the book -Student
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    When I click on Books tab

	
 @EBB-3209 @EBB-3208
Scenario: LitProLibrary - Verify that above book is appearing in Recent student activity section at home page - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	And I should verify that Recent student activity should contain above book with Status as "submitted audio recording on"


@lpl
Scenario: LitProLibrary - unassign of assigned book to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on ASSIGNED text on the book 
	Then I should see the pop up with Read and Assigned buttons 
	When I click on Assigned button 
	Then I should see the Assigned to header 
	When I click on entire class 
	Then I should see the entire class students
	Then I click on clear all assignments 
	When I click on Save changes 
	Then I should see the books page 
	
	
@lpl  
Scenario: LitProLibrary - Assign multiple books to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on Choose Multiple Books button 
	Then I should see the Assign Books and Hide Books options are disabled 
	When I select the multiple books by clicking on tick mark 
	Then I should see the Assign Books and Hide Books options are enabled 
	When I click on Assign Books button 
	Then I should see the Assign to header 
	When I click on entire class 
	Then I should see the entire class students 
	When I click on Assign to students 
	Then successful pop up should be displayed 
	When I click on done button 
	Then I should see the books page 
	
	

	
	
@lpl 
Scenario: LitProLibrary - Assign a book to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on Assign text on the book 
	Then I should see the pop up with Read and Assign buttons 
	When I click on Assign button 
	Then I should see the Assign to header 
	When I click on entire class 
	Then I should see the entire class students 
	When I click on Assign to students 
	Then successful pop up should be displayed 
	When I click on done button 
	Then I should see the books page 
	
		
	

	
	
@lpl 
Scenario: LitProLibrary - unassign of assigned book to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on ASSIGNED text on the book 
	Then I should see the pop up with Read and Assigned buttons 
	When I click on Assigned button 
	Then I should see the Assigned to header 
	When I click on entire class 
	Then I should see the entire class students 
	Then I click on clear all assignments
	When I click on Save changes 
	Then I should see the books page 
	
	
@lpl 
Scenario: LitProLibrary - Assign multiple books to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on Choose Multiple Books button 
	Then I should see the Assign Books and Hide Books options are disabled 
	When I select the multiple books by clicking on tick mark 
	Then I should see the Assign Books and Hide Books options are enabled 
	When I click on Assign Books button 
	Then I should see the Assign to header 
	When I click on entire class 
	Then I should see the entire class students 
	When I click on Assign to students 
	Then successful pop up should be displayed 
	When I click on done button 
	Then I should see the books page 
	
	

	
	
@lplp 
Scenario: LitProLibrary - Assign single book in a collection of books to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Collections tab 
	Then I should see collections Page 
	When I click on the collection of books to assign 
	Then I should see the Scholastic collections header 
	When I click on ASSIGN text on the book in Collections Page 
	Then I should see the Read and Assign buttons in popup 
	When I click on Assign button in popup 
	Then I should see the Assign to header in popup 
	When I click on entire class 
	Then I should see the entire class students in popup 
	When I click on Assign to students in popup 
	Then successful pop up should be displayed in popup 
	When I click on done button in popup 
	Then I should see the Scholastic collections header 
	
	@regression
Scenario: LitProLibrary Verification of Assigned Collection count  After Assigning to Entire Class -Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	Then I get Assigned collections count 
	When I click on Collections tab 
	Then I should see collections Page 
	When I click on ASSIGN text on the book in Collections Page 
	Then I should see the Assign to header in popup 
	When I click on entire class 
	Then I should see the entire class students in popup 
	When I click on Assign to students in popup 
	Then successful pop up should be displayed in popup 
	When I click on done button in popup 
	Then Assigned collections count must be increased by 5
	
	
	@regression	  @EBB-3140
Scenario: LitProLibrary Verification of message after assiging the collections to the student-Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	Then I get Assigned collections count 
	When I click on Collections tab 
	Then I should see collections Page 
	When I click assign a collection
	Then I should see the Assign to header in popup 
	When I click on entire class 
	Then I should see the entire class students in popup 
	When I click on Assign to students in popup 
	Then successful pop up should be displayed in popup 
	When I click on done button in popup 
	
	 @regression @EBB-3140
Scenario: LitProLibrary Checking Student message after assigment of the collections -Student
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on message icon
	Then student should see a message "Your teacher has assigned you the collection" for collection assignment
	When I click on the collection message student
	
	@regression @EBB-3024
Scenario: LitProLibrary Verification of message after assiging the collections to the student-Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	Then I get Assigned collections count 
	When I click on Collections tab 
	Then I should see collections Page
	And I should verify that collections are arrange in alphabetical order

	@regression	@EBB-3024
Scenario: LitProLibrary Verification of message after assiging the collections to the student-Teacher 
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Collections tab 
	Then I should see collections Page Student
	And I should verify that collections are arrange in alphabetical order in student collection page

	@regression  @EBB-2277 @EBB-2283 @EBB-2280
Scenario: LitProLibrary Should be able to sort the books in collections according to Lexile and Name-Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	Then I get Assigned collections count 
	When I click on Collections tab 
	Then I should see collections Page 
	When I should open a Collection
	And I should sort the books of collection by "NAME"
	Then I should see the books of the collections arranged by "NAME" 
	Then I should see collections Page 
	When I should open a Collection
	And I should sort the books of collection by "LEXILE"
	Then I should see the books of the collections arranged by "LEXILE" 

@regression @lplfi1123111
Scenario: LitProLibrary Verification of Assigned books count After Assigning to Entire Class -Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	Then I get Assigned books count 
	When I click on Books tab 
	Then I should see the books page 
	When I click on Assign text on the book 
	When I click on Assign button 
	Then I should see the Assign to header 
	When I click on entire class 
	Then I should see the entire class students 
	When I click on Assign to students 
	Then successful pop up should be displayed 
	When I click on done button 
	Then Assigned book count must be increased by 5
	

	
@Teacher 
Scenario: LitProLibrary - Validation of assigned book reading status - Teacher->Student 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on select drop down button 
	And I select the All to show 
	Then I should see the selected as All in a header 
	When I click on Assign text on the book 
	Then I should see the pop up with Read and Assign buttons 
	When I click on Assign button 
	Then I should see the Assign to header 
	Then I should see the entire class students 
	When I click on entire class 
	When I click on Assign to students 
	Then successful pop up should be displayed
	When I click on done button 
	Then I should see the books page 
	
	Scenario: LitProLibrary - Validation of assigned book reading status - Teacher->Student 
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	And I should see the book status as NOT STARTED 
	
		@lplp  
Scenario: LitProLibrary - Assign collection of books to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Collections tab 
	Then I should see collections Page 
	When I click on ASSIGN text on the book in Collections Page 
	Then I should see the Assign to header in popup 
	When I click on entire class 
	Then I should see the entire class students in popup 
	When I click on Assign to students in popup 
	Then successful pop up should be displayed in popup 
	When I click on done button in popup 
	Then I should see collections Page 
	
	@lplp @cleanup1 
Scenario: LitProLibrary - UnAssign collection of books to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Collections tab 
	Then I should see collections Page 
	When I click on ASSIGNED text on the book in Collections Page   
	When I click on entire class in colletion Page 
	Then I should see the entire class students in popup 
	When I click on clear all assignments in collections Page
	When I click on Save changes in collections Page
	Then I should see collections Page  
	
	 @EBB-2570 @EBB-2592
Scenario: LitProLibrary Student should fully read the book -Student  
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page
	When I click on Books tab
    When I click on Home tab
    When I open the information pop of Books I Selected
    And I should click on Read button
    And I should read the books completetly
    Then I should see the completed book in last section of Books I Selected


  @EBB-2570 @EBB-1857
  Scenario: LitProLibrary Student should fully read the book -Student Teacher assignned
    When I launch LitProLibrary as "Student"
    Then I should see Scholastic Literacy Library Home Page
    When I click on Books tab
    When I click on Home tab
    When I click on info icon on the book
    And I should click on Read button in teacher assigned
    And I should read the books completetly

  @EBB-185 @EBB-18571 @EBB-4068
  Scenario: LitProLibrary check prrogress in progress in report
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    When I click on Students tab
    Then I click assign book report
    Then I must see assignned book report headder
    Then I Click on see progress in recent assigment
    Then I must see progress details
    When I click on info icon on the book
    Then I must see the book details

  @EBB-3875
  Scenario: LitProLibrary Student overview
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    When I click on Students tab
    Then I click student overview
    Then I must see  student overview headder

  @EBB-3989 @EBB-4182
  Scenario: LitProLibrary report book info
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    When I click on Students tab
    Then I click assign book report
    Then I must see assignned book report headder
    Then I Click on see progress in recent assigment
    Then I must see progress report with name progress lexile time spent
    When I click on student link in the report
    Then I must see report of each student

  @EBB-3878
  Scenario: LitProLibrary report book search
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    When I click on Students tab
    Then I click assign book report
    Then I must see assignned book report headder
    When I search for book "asdsd"
    Then I must see error message
    When I search for book "Shark"
    Then I must see search result

  @EBB-4176
  Scenario: LitProLibrary Student overview export
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    When I click on Students tab
    Then I click student overview
    Then I must see  student overview headder
    When I select all classes from dropdown
    Then I click on Export button in overview
    Then I must see Export all classes and Students
    
    @LPL-4169
  Scenario: LitProLibrary Teacher home Page
    When I launch LitProLibrary as "Teacher"
    Then I should see Scholastic Literacy Library Home Page
    Then I must see recent activity and recent assingment
    
     @EBB-3132 
Scenario: LitProLibrary Student should fully read the book -Student  
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page
	When I click on Books tab
    When I click on Home tab
    When I open the information pop of Books I Selected
    And I should click on Read button
    Then I should verify that when I hovered over send audio A message should displays "Audio recording is only available on teacher-assigned books."
