@f1   
Feature: LitPro library 

@smoke 
Scenario: LitProLibrary Common UI - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	And I should see litLibrary below tabs: 
		| HOME | STUDENTS | BOOKS | COLLECTIONS | 
	And I should see Logout dropdown 
	
@sanity @testfail1234 
Scenario: LitProLibrary Common UI - Student 
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	And I should see litLibrary below tabs: 
		| HOME | BOOKS | COLLECTIONS | 
	And I should see Logout dropdown 
	
@sanity 
Scenario: LitProLibrary Common UI - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Students tab 
	Then I should see Students Page 
	Then I should see student profile 
	
@sanity @testlpl
Scenario: LitProLibrary Common UI - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see Books  Page 
	Then I should see Assign books Header 
	
@sanity 
Scenario: LitProLibrary Common UI - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Collections tab 
	Then I should see collections Page 
	
@sanity 
Scenario: LitProLibrary Common UI - Student 
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see Books  Page 
	And I should see Logout dropdown 
	
	
Scenario: LitProLibrary Common UI - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	And I should see number of Students 
	And I should see Assigned books 
	And I should see Completed Books 
	And I should see Assigned Collections 
	And I should see Words Read By Class 
	And I should see Time Spent Reading by class 
	And I should see Average time spent per book 
	
@wipl12 
Scenario: LitProLibrary Common UI - Student 
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	And I should see My Lexile 
	And I should see Assigned books 
	And I should see Completed Books 
	And I should see Words Read 
	And I should see Time Spent Reading 
	
	
	
	
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
Scenario: LitProLibrary - Opening a book in Books tab - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on the book 
	Then I should see the VIEW MESSAGES 
	And Click on close button 
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
	
	
@lpl  
Scenario: LitProLibrary -Send Messgae to Techer From students Book 
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
	
	@sep6 
	Scenario: LitProLibrary -Verify Send Messgae to Techer From students Book
	Given I launch LitProLibrary as a "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	When I click on Assigned book by teacher 
	Then Book has to be opened 
	Then I enter message in messagbox 
	And I click SendMessage button 
	Then success message sent has to be displayed 
	
	
	
Scenario: LitProLibrary -Send Messgae to Student From students Book 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And  I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on Assigned in FILTER selection 
	When I click on Assigned book 
	Then Book has to be opened 
	When I click on send message icon 
	Then I select students from message box 
	Then I enter message in students messagbox 
	And I click SendMessage button 
	Then success message sent has to be displayed 
	
@wiplm 
Scenario: LitProLibrary Common UI - Student 
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	And I should see Assigned by my teacher header 
	And I should see Books I selected Header 
	And I should see See All link for Books selected 
	And I should see See All link for Assigned by my teacher 
	
@wiplm1
Scenario: LitProLibrary Common UI - Student 
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	When I click on Assigned book by teacher 
	Then Book has to be opened 
	Then I must see audio recording 
	Then I must see send message
	Then I must see view Message

	
	
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
Scenario: LitProLibrary - Opening a book in Books tab - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on the book 
	Then I should see the VIEW MESSAGES 
	And Click on close button 
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
	
	
@lplp 
Scenario: LitProLibrary - Disable audio recording for specific student - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Students tab 
	Then I should see Students Page 
	When I click on Jon Snow student 
	Then I should see the Disable audio recording text 
	When I click on Disable audio recording 
	Then I should see the Enable audio recording 
	
	
@lplp2 
Scenario: LitProLibrary - Enable audio recording(for already disabled) for specific student - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Students tab 
	Then I should see Students Page 
	When I click on Jon Snow student 
	Then I should see the Enable audio recording 
	When I click on Enable audio recording 
	Then I should see the Disable audio recording text 
	
	
@lplp2 
Scenario: LitProLibrary - Selecting specific class students in a Students page - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Students tab 
	Then I should see Students Page 
	When I click on select drop down list 
	And I select the specific class 
	Then I should see the selected class students 
	
	
@lplp2 
Scenario: LitProLibrary - Selection of specific class in a Home page and validation - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on select drop down list in Home page 
	And I select the specific class in Home page 
	Then I should see the selected class students in Home page 
	
	
@Teacher 
Scenario: LitProLibrary - Profile edit and changing the profile image - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on profile selection drop down list in Home page 
	Then I should see the MY PROFILE text and Sign Out 
	When I click on Profile edit button 
	Then I should see the Your profile image header 
	When I select particular image 
	And I click on Done button in prof edit popup 
	Then I should see the changed profile image 
	
	
	
@lplp5 
Scenario: LitProLibrary - Validation of next button for Recent Assignments in a Home page - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on next button till end in Recent Assignments 
	Then I should see the disabled next button 
	
	
@Teacher 
Scenario: LitProLibrary - Selection(40, 80 & All) of books in a books a page - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	And I should see the default books_40 to show in a page 
	When I click on select drop down button 
	And I select the 80 to show 
	Then I should see the selected as 80 in a header 
	When I click on select drop down button 
	And I select the All to show 
	Then I should see the selected as All in a header 
	
	
@Teacher 
Scenario: LitProLibrary - Filter by assigned in Books Page and it's validation - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on Assigned in FILTER selection 
	Then I should see the Assigned tag to be displayed in the current selection 
	And I should see the ASSIGNED books should be displayed in the page 
	
@Teacher 
Scenario: LitProLibrary - Profile edit and changing the profile image - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on profile selection drop down list in Home page 
	Then I should see the MY PROFILE text and Sign Out 
	When I click on Profile edit button 
	Then I should see the Your profile image header 
	When I select profile image 
	And I click on Done button in prof edit popup 
	Then I should see the profile image boarder 
	
@Teacher @testentire
Scenario: LitProLibrary - Verify Read button on Book -Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on Assign text on the book 
	Then I Should see Quiz button 
	
	
	@regression  
Scenario: LitProLibrary Verify Read button on Book -Teacher 
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	When I click on Assigned book by teacher 
	Then Book has to be opened 
	Then I Should see Quiz button 
	
@Teacher 	
Scenario: LitProLibrary Common UI - Teacher 
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
	
	Scenario: LitProLibrary Common UI - Student 
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	When I click on Assigned book by teacher 
	Then Book has to be opened 
	Then I Should see Quiz button 
	
@regression @lplfi1123
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
	
	
 @regression  
Scenario: LitProLibrary - Selection of info icon about the book - Student 
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	And I should see the Assigned By My Teacher header 
	When I click on info icon on the book 
	Then I should see the book header 
	And I should see the summary of the book 
	And I should see the Read button 
	
	
	@lplp4 @final
	Scenario: LitProLibrary - Selection(40, 80 & All) of books in a books a page - Teacher
	When I launch LitProLibrary as "Teacher"
	Then I should see Scholastic Literacy Library Home Page
	And I should see user Profile
	When I click on Books tab
	Then I should see the books page
	And I should see the default books_40 to show in a page
	When I click on select drop down button
	And I select the 80 to show
	Then I should see the selected as 80 in a header
	When I click on select drop down button
	And I select the All to show
	Then I should see the selected as All in a header
	
	@lpl  @lplfix1 @EBB-3664 @EBB-2207 @EBB-3367
Scenario: LitProLibrary - Hiding a book to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on Assign text on the book 
	Then I should see the pop up with Hide/Unhide this book button 
	When I click on Hide/Unhide this book button 
	Then I should see the Hide/Unhide this book from header 
	When I click on entire class
	And I click on Save changes
	Then I should see the books page
	And I should see the hiden book as grey
	When I try to assign the hidden book to student
	Then I should not be able to assign it

 @EBB-3664 @EBB-2207
Scenario: Verify that the books hidden should not be shown to Student
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab
	And I should search for Hidden book 
    When I set a lexile level from "BR400" to "1500" for Student
    And I should click on search button for teacher
    Then I should validate that book should not be shown in search result
	
	@lpl 
Scenario: LitProLibrary - UnHiding a book to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on Assign text on the book 
	Then I should see the pop up with Hide/Unhide this book button 
	When I click on Hide/Unhide this book button 
	Then I should see the Hide/Unhide this book from header 
	When I click on entire class 
	And I click on Save changes 
	Then I should see the books page 
	
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
	
@EBB-3139 @LPL-1991
Scenario: LitProLibrary - Search filter validation - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	And I should vaildate all the search filters 
		|FILTER|
		|My Books|
		|Reading Level|
		|Genre|
		|Interest Category|
		|Series|
		|School Subject|
		|Format|
		|Education Level|
		|Reading Skill|
	And I should see two extra filters also
		|Extra FILTER|
		|Audio Read Aloud|
		|Hi-lo|
				
	@EBB-3139 @LPL-1991
Scenario: LitProLibrary - Search filter validation - Student 
	When I launch LitProLibrary as "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab
	Then I should see Books  Page
	And I should vaildate all the search filters of student
		|FILTER|
		|My Books|
		|Reading Level|
		|Genre|
		|Interest Category|
		|Series|
	And I should see two extra filters of student
		|Extra FILTER|
		|Audio Read Aloud|
		|Hi-lo|