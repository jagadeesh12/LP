package com.scholastic.intl.litpro.test.automation.pageobjects;

import java.util.ArrayList;
import java.util.Random;

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
public class BooksObject {

	public static String Booktitle;
	public static String Booksearch;

	private String AssignedBooksCount;
	private String AssignedCollections;

	public BooksObject() {
	}

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
		return BooksObject.Booktitle;
	}

	public void setBooktitle(String booktitle) {
		BooksObject.Booktitle = booktitle;

	}

	public String getsearchtitle() {
		return BooksObject.Booksearch;
	}

	public void setsearchtitle(String booksearch) {
		BooksObject.Booksearch = booksearch;

	}

	public String RandomSearch() {
		ArrayList<String> search = new ArrayList<String>();
		search.add("guy");
		search.add("forest");
		search.add("john");
		search.add("cat");
		search.add("dog");
		search.add("ford");
		search.add("rule");
		search.add("wav");
		search.add("fire");
		search.add("tiger");
		search.add("gum");
		search.add("and");
		search.add("tom");
		search.add("gate");
		search.add("his");
		search.add("mar");
		search.add("man");
		search.add("class");
		search.add("box");
		search.add("time");
		search.add("book");
		search.add("read");
		int min = 0;
		int max = search.size() - 1;
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		System.out.println(r.nextInt((max - min) + 1) + min);
		int i = (r.nextInt((max - min) + 1) + min);
		return search.get(i);
	}
}
