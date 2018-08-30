@f1  
Feature: LitPro library 

@cleanup        
Scenario: LitProLibrary - unassign of assigned collections to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Collections tab 
	Then I should see collections Page 
	When I click on ASSIGNED text on the book in Collections Page for cleanup 
   
   @cleanup       
Scenario: LitProLibrary - unassign of assigned book to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on ASSIGNED text on the book for cleanup

@lplhideclean  @cleanup
Scenario: LitProLibrary - Unhide book to entire class - Teacher 
	When I launch LitProLibrary as "Teacher" 
	Then I should see Scholastic Literacy Library Home Page 
	And I should see user Profile 
	When I click on Books tab 
	Then I should see the books page 
	When I click on Unhide book for cleanup
	
	
	
	
	
	
      