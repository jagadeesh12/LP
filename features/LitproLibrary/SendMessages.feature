@f1 @regressionlpl @smokelpl 
Feature: Send Message to Students and Teacher 

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
	Scenario: LitProLibrary - Send Messgae to Techer From students Book
	Given I launch LitProLibrary as a "Student" 
	Then I should see Scholastic Literacy Library Home Page 
	When I click on Assigned book by teacher 
	Then Book has to be opened 
	Then I enter message in messagbox 
	And I click SendMessage button 
	Then success message sent has to be displayed 
	
	
	
Scenario: LitProLibrary -Teacher should verify the Send Messgae by Student
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