@f1 @hideUnhide @smokelpl 
Feature: LitPro library Hide Unhide

	@lpl  @lplfix1 
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