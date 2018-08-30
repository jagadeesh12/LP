package com.scholastic.intl.litpro.test.automation.stepdefs.lpl;

/* @ Author: Rajesh R
 * @ Created Date: 05/02/2016
 * @ Functionality: Global assigning of Values 
 * @ Type: Smoke, regression
 * 
 * 
 * @ Updated Date
 * @ Updated By
 * 
 */
public class BooksObjectLp {
	
	private String Booktitle;
	private String AssignedBooksCount;
	private String  AssignedCollections; 
	
	public String getAssignedCollections() {
		return AssignedCollections;
	}

	public void setAssignedCollections(String assignedCollections) {
		AssignedCollections = assignedCollections;
	}

	public String getAssignedBooksCount() {
		return AssignedBooksCount;
	}

	public void setAssignedBooksCount(String assignedBooksCount) {
		AssignedBooksCount = assignedBooksCount;
	}

	public String getBooktitle() {
		return Booktitle;
	}

	public void setBooktitle(String booktitle) {
		Booktitle = booktitle;
	}

	
	
}
