package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.*;

import com.scholastic.intl.litpro.test.automation.keys.Keys.hooksConstants;
import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.BooksObject;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.QuizModal;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg.SearchResultBook;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.intl.litpro.test.automation.stepdefs.lpl.BooksObjectLp;
import com.scholastic.torque.common.BaseTestPage;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.torque.common.TestPage;

public class LpSearchStDf extends BaseTestPage<TestPage> implements hooksConstants {
	LitProUserType lpUserType;
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	LitProHomePg lpHome = new LitProHomePg(driver, lpUserType);
	SearchPg lpSearchPg = new SearchPg(driver, lpUserType);
	BasePage base = new BasePage(driver);
	QuizModal lpQuizModal= new QuizModal(driver);

	BooksObject Searchtitle = new BooksObject();
	Scenario scenario;
	List<SearchResultBook> resultBooks;
	String searchKey = "";
	boolean isInMySchoolLibraryEnabled = false, isQuizzesOnlyEnabled = false, isSchEbookCollectionEnabled = false;
	String booktitle;
	

	@Given("^I browse to Search Page as \"(.*?)\"$")
	public void browseToSearchPage(String userType) {
		slzLogin = new SlzLoginPg(driver);

		// assertTrue("Failed to Launch AUT due to missing info. Check the
		// log.",slzLogin.launchSlz());
		lpUserType = slzLogin.getLitProUserType(userType);
		// slzHome = slzLogin.loginAs(lpUserType);

		//
		// lpHome = slzHome.launchLitPro(lpUserType);

		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		LitProHomePg lpHome = new LitProHomePg(driver, lpUserType);
		lpSearchPg = lpHome.goToSeachPage();
	}

	@Given("^I launch Litpro and browse to Search Page using \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_launch_Litpro_and_browse_to_Search_Page_using_and_with(String username, String password,
			String userType) throws Throwable {
		slzLogin = new SlzLoginPg(driver);

		// assertTrue("Failed to Launch AUT due to missing info. Check the
		// log.",slzLogin.launchSlz());
		lpUserType = slzLogin.getLitProUserType(userType);
		System.out.println(lpUserType);
		// slzHome = slzLogin.loginAs(lpUserType);
		// scenario.write("Credentials: " + slzLogin.getUserCreds());
		//
		// lpHome = slzHome.launchLitPro(lpUserType);

		base.loginApp(username, password);
		base.launchApp(lpUserType);
		System.out.println(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);

		lpSearchPg = lpHome.goToSeachPage();
	}

	@Then("^I should see Search Page Header \"(.*?)\"$")
	public void iShouldSeeSearchHeader(String expected) throws InterruptedException {
		System.out.println(lpUserType + "11111@@@@@@@@@@@@@");
		LitProHomePg lpHome = new LitProHomePg(driver, lpUserType);
		lpSearchPg = lpHome.goToSeachPage();
		String actual = lpSearchPg.getPageHeader();
		assertTrue("The expected Page Header was '" + expected + "' but actually was: " + actual,
				actual.equalsIgnoreCase(expected));
	}

	@Then("^Search results should show Book Titles that contain the word - \"(.*?)\"$")
	public void search_results_should_show_Book_Titles_that_contain_the_word(String key) {
		lpSearchPg = new SearchPg(driver, lpUserType);
		resultBooks = lpSearchPg.getImgViewSearchResults();
		System.out.println("#of Books found: " + resultBooks.size());
		// scenario.write("#of Books found: " + resultBooks.size());
		if (!resultBooks.isEmpty()) {
			for (SearchResultBook book : resultBooks) {
				assertTrue("Book '" + book.title + "' does NOT contain the word " + key, book.title.contains(key));
			}
		} else {
			System.out.println(" No book found for the title - " + key);
			// scenario.write(" No book found for the title - " + key);
		}
	}

	@When("^I search for books having Title \"(.*?)\" with Quiz$")
	public void i_search_for_books_having_Title_with_Quiz(String key) {
		this.searchKey = key;
		lpHome.goToHomePage();
		lpSearchPg = lpHome.goToSeachPage();
		lpSearchPg.checkQuizzesOnly();
		lpSearchPg.typeSearchKeyAndHitQuickSearchBtn(key);
	}

	@Then("^All books should have an associated Quiz$")
	public void all_books_should_have_an_associated_Quiz() {
		if (!resultBooks.isEmpty()) {
			for (SearchResultBook book : resultBooks) {
				assertTrue("Book '" + book.title + "' does NOT contain Quiz, but showed in Search Result ",
						book.hasQuizButton);
			}
		} else {
			System.out.println("No book found for the title");
			// scenario.write("No book found for the title");
		}
	}

	@When("^I click on Search button without entering keyword$")
	public void i_click_on_Search_button_without_entering_keyword() throws Throwable {
		lpSearchPg.typeSearchKeyAndHitQuickSearchBtn("  ");
	}

	@Then("^'You should enter at least one search criteria for the search\\.' notification should display$")
	public void you_should_enter_at_least_notification_should_display() throws Throwable {
		String actual = lpSearchPg.getNotificationText();
		String expected = "You should enter at least one search criteria for the search.";
		assertTrue("Notification Text NOT matched.Expected: " + expected + ", Actual:" + actual,
				actual.equalsIgnoreCase(expected));
	}

	@When("^I search for books having title \"(.*?)\"$")
	public void typeSearchKeyAndHitEnter(String key) throws Throwable {
		this.searchKey = key;
		 lpHome = new LitProHomePg(driver, lpUserType);
		lpHome.goToHomePage();
		lpSearchPg = lpHome.goToSeachPage();
		lpSearchPg.typeSearchKeyAndHitQuickSearchBtn(key);
		// Thread.sleep(3000);
	}

	@Then("^'No Results Found' notification should display$")
	public void no_Results_Found_notification_should_display() throws Throwable {
		String actual = lpSearchPg.getNotificationHeader();
		String expected = "No Results Found";
		assertTrue("Notification Text NOT matched. Expected: " + expected + ", Actual:" + actual,
				actual.equalsIgnoreCase(expected));
	}

	@Then("^'Resource not found' notification should display$")
	public void no_Resources_Found_notification_should_display() throws Throwable {
		String actual = lpSearchPg.getNotificationHeader();
		String expected = "Resource not found";
		assertTrue("Notification header text NOT matched. Expected: " + expected + ", Actual:" + actual,
				actual.equalsIgnoreCase(expected));

		expected = "There are no results found. Please try another title or author.";
		actual = lpSearchPg.getNotificationText();
		assertTrue("Notification Text NOT matched. Expected: " + expected + ", Actual:" + actual,
				actual.equalsIgnoreCase(expected));

	}

	@Then("^Image view search results count should match with the dispayed count$")
	public void img_view_search_results_count_should_match_with_the_count_dispayed() throws Throwable {
		int actual = 0, expected = 0;
		lpSearchPg.waitWhenLoadingBarActive();
		resultBooks = lpSearchPg.getImgViewSearchResults();
		String count = (resultBooks.size() == 0) ? "No" : String.valueOf(resultBooks.size());
		String booksPlrl = (resultBooks.size() == 1) ? " book" : " books";
		// scenario.write(count + booksPlrl + " found");

		// this check is temporary as stud search result doesnt display count
		if (lpUserType == LitProUserType.STUDENT) {

		} else {
			expected = resultBooks.size();
			actual = lpSearchPg.getDisplayedSearchResultsCount();
		}
		assertTrue("Search count and displayed search results count NOT matched. Expected: " + expected + ", Actual: "
				+ actual, actual >= expected);
	}
	@Then("^I should verify the search count of student match (.+)$")
    public void i_should_verify_the_search_count_of_student_match(int Search_count_student) throws Throwable {
		int actual = 0, expected=0;
		lpSearchPg.waitWhenLoadingBarActive();
		resultBooks = lpSearchPg.getImgViewSearchResults();
		String count = (resultBooks.size()==0)? "No": String.valueOf(resultBooks.size());
		String booksPlrl = (String) ((resultBooks.size()==1)? " book": " books");
		//scenario.write(count + booksPlrl +" found");
		
		//this check is temporary as stud search result doesnt display count
		if(lpUserType==LitProUserType.STUDENT){
			 expected = Search_count_student;
			 actual = lpSearchPg.getSudentSearchResultsCount();
		}
		else{
		}
		assertTrue("Search count and displayed search results count NOT matched. Expected: " + expected + ", Actual: " + actual , actual>=expected );

	}

	@And("^List view search results count should match with the dispayed count$")
	public void lst_view_search_results_count_should_match_with_the_count_dispayed() throws Throwable {
		int actual = 0, expected = 0;
		lpSearchPg.waitWhenLoadingBarActive();
		resultBooks = lpSearchPg.getListViewSearchResults();

		String count = (resultBooks.size() == 0) ? "No" : String.valueOf(resultBooks.size());
		String booksPlrl = (resultBooks.size() == 1) ? " book" : " books";
		System.out.println(count + booksPlrl + " found");
		// scenario.write(count + booksPlrl + " found");

		// this check is temporary as stud search result doesn't display count
		if (lpUserType == LitProUserType.STUDENT) {

		} else {
			expected = resultBooks.size();
			actual = lpSearchPg.getDisplayedSearchResultsCount();
		}
		assertTrue("Search count and displayed search results count NOT matched. Expected: " + expected + ", Actual: "
				+ actual, actual >= expected);
	}

	@Then("^Search results should show following columns in Image View:$")
	public void search_results_should_show_following_columns_in_Image_View(List<String> columnList) throws Throwable {
		if (resultBooks != null) {
			String actual = lpSearchPg.getImgViewSearchResultColumnNames().toString();
			String expected = columnList.toString();
			String orgid = testBase.getString(ORG_ID);
			if (!((orgid).contains("AUS"))) {
				assertTrue("The expected Column list was '" + expected + "' but actually was: " + actual,
						actual.contains(expected));
			}
		} else {
			System.out.println("No books found");
			// scenario.write("No books found");
			throw new PendingException();
		}

	}

	@Then("^Book title should contain the searched keyword$")
	public void book_title_should_contain_the_searched_keyword() throws Throwable {
		if (!resultBooks.isEmpty()) {
			for (SearchResultBook book : resultBooks) {
				assertTrue("Book '" + book.title + "' does NOT contain the word " + searchKey,
						book.title.contains(searchKey));
			}
		} else {
			// scenario.write(" No book found for the title - " + searchKey);
		}
	}

	@Then("^Book author name should not be empty$")
	public void book_author_name_should_not_be_empty() {
		if (!resultBooks.isEmpty()) {
			for (SearchResultBook book : resultBooks) {
				assertTrue("Book '" + book.title + "' does NOT have author name. Actual Author Name:" + book.author,
						book.author.length() > 0);
			}
		} else {
			// scenario.write(" No book found for the title - " + searchKey);
		}
	}

	@When("^I change the results view to \"(.*?)\"$")
	public void changeSearchResultView(String viewName) {
		if (viewName.trim().equals("List View")) {
			lpSearchPg.switchToListView();
		} else if (viewName.trim().equals("Image View")) {
			lpSearchPg.switchToImgView();
		}
	}

	@Then("^Search results should show following columns in List View:$")
	public void search_results_should_show_following_columns_in_List_View(List<String> columnList) throws Throwable {
		String actual = lpSearchPg.getListViewSearchResultColumnNames().toString();
		String expected = columnList.toString();
		String orgid = testBase.getString(ORG_ID);
		if (!((orgid).contains("AUS"))) {
			assertTrue("The expected Column list was '" + expected + "' but actually was: " + actual,
					actual.contains(expected));
		}
		// if(!StringUtils.contains(SharedDriver.appConfig.getProperty("org.id"),"AUS")){
		// assertTrue("The expected Column list was '" + expected +
		// "' but actually was: " + actual, actual.contains(expected));
		// }
	}

	@When("^I search for the author \"(.*?)\"$")
	public void i_search_for_the_author(String authorName) throws Throwable {
		this.typeSearchKeyAndHitEnter(authorName);
	}

	@And("^Book author name should contain the searched keyword$")
	public void book_author_name_should_contain_the_searched_keyword() throws Throwable {
		lpSearchPg.waitWhenLoadingBarActive();
		resultBooks = lpSearchPg.getImgViewSearchResults();
		if (!resultBooks.isEmpty()) {
			for (SearchResultBook book : resultBooks) {
				boolean assertFlag = book.author.contains(searchKey) || book.title.contains(searchKey);
				assertTrue("Book '" + book.title + "' author name does NOT contain search key:" + searchKey,
						assertFlag);
			}
		} else {
			// scenario.write(" No book found for the title - " + searchKey);
		}
	}

	@Then("^Books title should not be empty$")
	public void books_title_should_not_be_empty() throws Throwable {
		if (!resultBooks.isEmpty()) {
			for (SearchResultBook book : resultBooks) {
				assertTrue("Book Title is empty for search key: " + searchKey, book.title.length() > 0);
			}
		} else {
			// scenario.write(" No book found for the title - " + searchKey);
		}
	}

	// adv search options
	@Given("^I am on Search Page$")
	public void i_am_on_Search_Page() throws Throwable {
		String actual = lpSearchPg.getPageHeader();
		String expected = "Search";
		assertTrue("The expected Page Header was '" + expected + "' but actually was: " + actual,
				actual.equalsIgnoreCase(expected));
	}

	@When("^I type search key - (.*)$")
	public void i_type_search_key_Planets(String searchKey) {
		this.searchKey = searchKey;
		lpSearchPg.typeSearchKey(searchKey);
	}

	@When("^I select search options - (.*)$")
	public void i_select_search_options(String options) {
		options = options.trim();
		if (options != null && options.length() > 0) {
			String[] levels = options.split(",");
			for (String option : levels) {
				if (option.equals("Quizzes Only")) {
					lpSearchPg.checkQuizzesOnly();
					this.isQuizzesOnlyEnabled = true;
				} else if (option.equals("In My School Library")) {
					lpSearchPg.checkInMySchoolLibrary();
					this.isInMySchoolLibraryEnabled = true;
				} else if (option.equals("Scholastic eBook Collections")) {
					lpSearchPg.checkScholasticEbookCollection();
					this.isSchEbookCollectionEnabled = true;
				}

			}
		}
	}

	@When("^I click 'Additional Search Options' link$")
	public void i_click_Additional_Seach_Options_link() {
		lpSearchPg.clickAdditionalSearchOptsLink();
	}

	@When("^I click 'Select categories of books' link$")
	public void i_click_Select_categories_of_books_link() throws Throwable {
		lpSearchPg.clickSelectCatsBookLink();
	}

	@When("^I select education levels - (.*)$")
	public void i_select_education_levels_Secondary(String eduLevels) {
		eduLevels = eduLevels.trim();
		if (eduLevels != null && eduLevels.length() > 0) {
			String[] levels = eduLevels.split(",");
			for (String level : levels) {
				lpSearchPg.enableSearchOption(level);
			}
		}
	}

	@When("^I type lexile range (.*) - (.*)$")
	public void i_type_lexile_range(String from, String to) {
		if ((from + to).length() > 0) {
			lpSearchPg.setAdvSearchLexileRange(from, to);
		}
	}

	@When("^I type points range (.*) - (.*)$")
	public void i_type_points_range(String from, String to) {
		String country = testBase.getString(ORG_ID);
		// String country= SharedDriver.appConfig.getProperty("org.id");

		if (!StringUtils.startsWith(country, "AUS") && (from + to).length() > 0) {
			lpSearchPg.setAdvSearchPointRange(from, to);
		}
	}

	@When("^I select categories - (.*)$")
	public void i_select_categories(String cats) {

		cats = cats.trim();
		if (cats != null && cats.length() > 0) {
			if (this.lpUserType == LitProUserType.SCHOOL_ADMIN || this.lpUserType == LitProUserType.TEACHER) {
				lpSearchPg.clickElderCategoriesButton();
			}

			String[] categories = cats.split(",");
			for (String cat : categories) {

				if (this.lpUserType == LitProUserType.STUDENT) {
					lpSearchPg.selectStudentSearchBookCategory(cat);
				} else {
					lpSearchPg.enableSearchOption(cat);
				}

			}
		}
	}

	@When("^I click Search button$")
	public void i_click_Search_button() {
		if (this.lpUserType == LitProUserType.STUDENT) {
			lpSearchPg.clickQuickSearchBtn();
		} else {
			lpSearchPg.clickAdvSearchBtn();
		}

		String notification = lpSearchPg.getNotificationHeader();
		if (notification.length() > 0) {
			if (notification.equals("No Results Found")) {
				System.out.println("'No Results Found' notification displayed");
			} else {
				System.out.println("Unexpected: '" + notification + "' notification displayed");
			}

		}
	}

	@Then("^Book title or author name should contain the search key$")
	public void book_title_or_Author_should_contain_the_Planets() {
		// lpSearchPg.waitWhenLoadingBarActive();
		// resultBooks = lpSearchPg.getImgViewSearchResults();
		// scenario.write("#of Books found: " + resultBooks.size() );
		searchKey = searchKey.replace("\"", "");
		System.out.println(searchKey);
		if (!resultBooks.isEmpty()) {
			for (SearchResultBook book : resultBooks) {
				boolean assertFlag = StringUtils.containsIgnoreCase(book.author, searchKey)
						|| StringUtils.containsIgnoreCase(book.title, searchKey);
				assertTrue("Book '" + book.title + "' author name does NOT contain search key:" + searchKey,
						assertFlag);
			}
		} else {
			// scenario.write(" No book found for the title - " + searchKey);

		}
	}

	@And("^Take quiz button should be present if 'Quizzes Only' option is selected$")
	@Then("^View quiz button should be present if 'Quizzes Only' option is selected$")
	public void view_quiz_button_should_be_present_if_Quizzes_Only_option_is_selected() {
		if (isQuizzesOnlyEnabled) {
			if (!resultBooks.isEmpty()) {
				for (SearchResultBook book : resultBooks) {
					assertTrue("Book '" + book.title + "' does NOT contain Quiz, but showed in Search Result ",
							book.hasQuizButton);
				}
			} else {
				// scenario.write("No book found for the title");
			}
		}
	}

	@And("^In Library Icon should be present if 'In My School Library' option is selected$")
	public void in_lib_button_should_be_present_if_In_My_School_option_is_selected() {
		if (this.isInMySchoolLibraryEnabled) {
			if (!resultBooks.isEmpty()) {
				for (SearchResultBook book : resultBooks) {
					assertTrue(
							"Book '" + book.title + "' does NOT contain In Library Icon, but showed in Search Result ",
							book.isInLibIconDisplayed);
				}
			} else {
				scenario.write("No book found for the title");
			}
		}
	}

	@And("^Lit Pro Library Icon should be present if 'Scholastic eBook Collections' option is selected$")
	public void LitPro_Lib_Icon_In_My_School_option_is_selected() {
		if (this.isSchEbookCollectionEnabled) {
			System.out.println(resultBooks.toString());
			if (!resultBooks.isEmpty()) {
				for (SearchResultBook book : resultBooks) {
					assertTrue(
							"Book '" + book.title
									+ "' does NOT contain In LP Library Icon, but showed in Search Result ",
							book.isLitProLibIconDisplayed);
				}
			} else {
				// scenario.write("No book found for the title");
			}
		}
	}

	@Then("^Book Education Level should be one of (.*)$")
	public void book_Education_Level_should_be_one_of_Secondary(String eduLevels) {
		eduLevels = eduLevels.trim();

		if (eduLevels != null && eduLevels.length() > 0) {
			if (!resultBooks.isEmpty()) {
				for (SearchResultBook book : resultBooks) {
					assertTrue("Book '" + book.title
							+ "' Education level NOT matching with any of the selected Education levels in filter"
							+ eduLevels, eduLevels.contains(book.eduLevel));
				}
			} else {
				/*
				 * scenario.write(" No book found for the title - " +
				 * searchKey); throw new PendingException();
				 */
			}
		}

	}

	@Then("^Book lexile range should fall between (.*) and (.*)$")
	public void book_lexile_range_should_fall_bewteen_and(String from, String to) {
		if ((from + to).length() > 0) {
			if (!resultBooks.isEmpty()) {
				for (SearchResultBook book : resultBooks) {
					String actualLexile = book.lexile.substring(0, book.lexile.length() - 1);

					boolean assertFlag = Integer.parseInt(from) <= Integer.parseInt(actualLexile)
							&& Integer.parseInt(actualLexile) <= Integer.parseInt(to);
					assertTrue("Book '" + book.title + "' lexile value " + book.lexile
							+ " doesnt fall between selected range", assertFlag);
				}
			} else {
				/*
				 * scenario.write(" No book found for the title - " +
				 * searchKey); throw new PendingException();
				 */ }
		}
	}

	@Then("^Book points range should fall between (.*) and (.*)$")
	public void book_Points_range_should_fall_bewteen_and(String from, String to) {
		// String country= SharedDriver.appConfig.getProperty("org.id");
		String country = testBase.getString(ORG_ID);
		if (!StringUtils.startsWith(country, "AUS") && (from + to).length() > 0) {
			if (!resultBooks.isEmpty()) {
				for (SearchResultBook book : resultBooks) {
					boolean assertFlag = Integer.parseInt(from) <= Integer.parseInt(book.point)
							&& Integer.parseInt(book.point) <= Integer.parseInt(to);
					assertTrue("Book '" + book.title + "' point value " + book.point
							+ " doesnt fall between selected range", assertFlag);
				}
			} else {
				/*
				 * scenario.write(" No book found for the title - " +
				 * searchKey); throw new PendingException();
				 */
			}
		}
	}

	@Then("^Book category should match with (.*)$")
	public void book_categoty_should_match_with(String cats) {
		String expectedCat1, expectedCat2 = "";
		cats = cats.trim();

		if (cats != null && cats.length() > 0) {
			// get the expected cats in an array
			// taken care of max only 2 categories.
			String[] categories = cats.split(",");
			expectedCat1 = categories[0];

			if (categories.length > 1)
				expectedCat2 = categories[1];

			// check if result book has data
			if (!resultBooks.isEmpty()) {
				for (SearchResultBook book : resultBooks) {
					boolean assertFlag = StringUtils.containsIgnoreCase(book.categories, expectedCat1)
							|| StringUtils.containsIgnoreCase(book.categories, expectedCat2);
					assertTrue("Book '" + book.title + "' categories NOT matching.Actual: " + book.categories
							+ " Expected: " + expectedCat1 + "," + expectedCat2, assertFlag);
				}
			} else {
				/*
				 * scenario.write(" No book found for the title - " +
				 * searchKey); throw new PendingException();
				 */
			}

		}
	}

	@When("^I search for random book$")
	public void searchTile() throws Throwable {
		String title = Searchtitle.RandomSearch();
		LitProHomePg lpHome = new LitProHomePg(driver, lpUserType);
		lpHome.goToHomePage();
		lpSearchPg = lpHome.goToSeachPage();
		lpSearchPg.checkQuizzesOnly();
		lpSearchPg.typeSearchKeyAndHitQuickSearchBtn(title);
	}

	@When("^I search for above book again$")
	public void searchTileagain() throws Throwable {
		LitProHomePg lpHome = new LitProHomePg(driver, lpUserType);
		lpHome.goToHomePage();
		lpSearchPg = lpHome.goToSeachPage();
		lpSearchPg.typeSearchaboveKeyAndHitQuickSearchBtn();
	}

	@When("^I should search for book \"(.*?)\"$")
	public void search_title_student(String search) throws Throwable {
		lpSearchPg.typeSearchKeyAndHitQuickSearchBtn(search);
	}

	@When("^I should validate the titles with admin results$")
	public void Validate_search_title() throws Throwable {
		assertTrue("Serach title of students and teachers are not matching. The Education level setting is not working",
				lpSearchPg.validateTitles());
	}

	@When("^I should search as student for book \"(.*?)\"$")
	public void search_title_student_teacher(String title) throws Throwable {
		lpSearchPg.typeSearchKeyAndHitQuickSearchBtnStudent(title);
	}

	@When("^I should verify that search result should be 300$")
	public void I_should_verify_search_result_number_300() throws Throwable {
		assertTrue("The search result is showing more then 300", lpSearchPg.searchresultnumber());
	}

	@And("^I should click on print button$")
	public void I_should_click_on_print_button() throws Throwable {
		// lpSearchPg.Clickprintbutton();
	}

	@And("^I should verify all the titles in the search tab$")
	public void I_should_verify_all_titles_searchTab() throws Throwable {
		// lpSearchPg.verifyTitlesSearchTab();
	}

	@And("^I should verify all the titles in the print window$")
	public void I_should_verify_all_titles_in_print_window() throws Throwable {
		assertTrue(
				"Verified the Admin/teacher search result and print result of search. They both not same. Please check the reuslts",
				lpSearchPg.comapre());
	}

	@Then("^I should verify all the titles in the print window are excatly same as search window$")
	public void i_should_verify_all_the_titles_in_the_print_window_are_excatly_same_as_search_window()
			throws Throwable {
		assertTrue(
				"Verified the Admin/teacher search result and print result of search. They both not same. Please check the reuslts",
				lpSearchPg.StudentSearchPrint());
	}

	@When("^I search for books titles having all Ebook collection icons \"(.*?)\"$")
	public void EbooktypeSearchKeyAndHitEnter(String key) throws Throwable {
		this.searchKey = key;
		LitProHomePg lpHome = new LitProHomePg(driver, lpUserType);
		lpHome.goToHomePage();
		lpSearchPg = lpHome.goToSeachPage();
		lpSearchPg.ebookcollection();
		lpSearchPg.typeSearchKeyAndHitQuickSearchBtn(key);
	}

	@Then("^I should see the ebook icons indicator next to titles$")
	public void i_should_see_the_ebook_icon_for_all_books() throws Throwable {
		assertTrue(
				"Either one of the icon or all the 3 ebook icons are missing from the user search. Please check the serach result manually",
				lpSearchPg.VerifyEbookIconTecher());
	}

	@Then("^I should see the ebook icons indicator next to titles search for student$")
	public void i_should_see_the_ebook_icons_indicator_next_to_titles_search_for_student() throws Throwable {
		assertTrue(
				"Either one of the icon or all the 3 ebook icons are missing from the user search. Please check the serach result manually",
				lpSearchPg.VerifyEbookIconStudent());
	}

	@Then("^I should see the Take Quiz button is enabled in search$")
	public void i_should_see_the_Take_Quiz_button_is_enabled() throws Throwable {
		assertTrue("Quizzes enabled ", lpSearchPg.quizzes_enabled());

	}

	@Then("^I should see the Take Quiz button is disabled in search$")
	public void i_should_see_the_Take_Quiz_button_is_disabled_in_search() throws Throwable {

		assertTrue("Quizzes enabled ", lpSearchPg.quizzes_disabled());

	}

	@Then("^I click on clearAll button$")
	public void i_click_on_clearAll_button() throws Throwable {
		lpSearchPg.clickClearAllbutton();
	}

	@Then("^I must see education levels must be unchecked - (.+) $")
	public void i_must_see_education_levels_must_be_unchecked_Lower_Primary_Higher_Primary(String eduLevels)
			throws Throwable {
		eduLevels = eduLevels.trim();
		// boolean flag=false;
		if (eduLevels != null && eduLevels.length() > 0) {
			String[] levels = eduLevels.split(",");
			for (String level : levels) {
				assertTrue("Education level is Checked", lpSearchPg.checkEduOptionsSelected(level));

			}
		}

	}

	@Then("^I should not see Points search option$")
	public void i_should_not_see_Points_search_option() throws Throwable {
		assertTrue("Advance Points search displayed", (!lpSearchPg.checkAdvSearchPointRangeDisplayed()));
	}

	@Then("^I should not see any results table$")
	public void i_should_not_see_any_results_table() throws Throwable {
		assertTrue("Results are displayed ", !(lpSearchPg.isResultsDisplayed()));
	}

	@Then("^display count is one$")
	public void display_count_is_one() throws Throwable {
		int bookcount = lpSearchPg.getDisplayedSearchResultsCount();
		assertTrue("Results are displayed ", bookcount == 1);
	}

	@Then("^I should not see the search bar and also the search box label$")
	public void i_should_not_see_the_search_bar_and_also_the_search_box_label() throws Throwable {
		boolean searchbarelement = lpSearchPg.isElementPresent(By.id("cohortSearch"));
		Assert.assertEquals(searchbarelement, false);
		boolean searchheadingelement = lpSearchPg.isElementPresent(By.id("cohortHeading"));
		Assert.assertEquals(searchheadingelement, false);

	}

	@When("^I navigate to reports page$")
	public void i_navigate_to_reports_page() throws Throwable {
		lpHome.goToReportsPage();
	}

	@When("^I navigate to benchmarks page$")
	public void i_navigate_to_benchmarks_page() throws Throwable {
		lpHome.goToBenchmarksPage();
	}

	@When("^I navigate to search page$")
	public void i_navigate_to_search_page() throws Throwable {
		lpHome.goToSeachPage();
	}

	@Then("^I should verify the search count should match (\\d+)$")
	public void i_should_verify_the_search_count_should_match(int Search_count_student) throws Throwable {
		int actual = 0, expected = 0;
		lpSearchPg.waitWhenLoadingBarActive();
		resultBooks = lpSearchPg.getImgViewSearchResults();
		String count = (resultBooks.size() == 0) ? "No" : String.valueOf(resultBooks.size());
		String booksPlrl = (String) ((resultBooks.size() == 1) ? " book" : " books");
		//scenario.write(count + booksPlrl + " found");

		// this check is temporary as stud search result doesnt display count
		if (lpUserType == LitProUserType.STUDENT) {
			expected = Search_count_student;
			actual = lpSearchPg.getSudentSearchResultsCount();
		} else {
		}
		assertTrue("Search count and displayed search results count NOT matched. Expected: " + expected + ", Actual: "
				+ actual, actual >= expected);
	}

	@When("^I search for the book for which quizzes where added$")
    public void i_type_search_for_the_book_for_which_quizzes_where_added() throws Throwable {
		lpSearchPg.SearchKeyword();
    }
	
	@And("^I Click on View quiz button of the book$")
    public void i_click_on_view_quiz_button_of_the_book() throws Throwable {
		assertTrue("Unable to find the books in the search result for which the Quiz was added", lpSearchPg.SearchresultViewQuiz());
		lpSearchPg.ClickViewQuiz();
	}
	
	@Then("^I should validate the data of the quizzes$")
    public void i_should_validate_the_data_of_the_quizzes() throws Throwable {
		assertTrue("Book are not shown correctly", lpSearchPg.VerifyQuizzes());
    }
	
	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}
	@Then("^I should see the series \"([^\"]*)\" in the result$")
	public void i_should_see_the_series_in_the_result(String series) throws Throwable {
		assertTrue("Book are not shown correctly", lpSearchPg.getSeriesName().contains(series));
	}
	
	@Then("^I click on view quiz button and Save all Questions and Answers$")
	public void i_click_on_view_quiz_button_and_Save_all_Questions_and_Answers() throws Throwable {
		
			String viewbook=lpSearchPg.ClickViewQuizbutton();
			Searchtitle.setBooktitle(viewbook);
			
		System.out.println(viewbook);
		lpSearchPg.getQuestionsAndAnswersInQuiz();
	}
	@When("^I click on take Quiz button$")
	public void i_click_on_take_Quiz_button() throws Throwable {
		QuizModal lpQuizModal= new QuizModal(driver);
		lpQuizModal.clickSingleTakequizButton();
		//lpQuizModal.startTheQuiz();
	}
	@Given("^As a \"([^\"]*)\", I am on the search page showing results for word \"([^\"]*)\"$")
	public void as_a_I_am_on_the_search_page_showing_results_for_word(String user, String Keyword) throws Throwable {
		slzLogin = new SlzLoginPg(driver);
		
		LitProUserType lpUserType = slzLogin.getLitProUserType(user);
		slzHome = slzLogin.loginAs(lpUserType);
		base = new BasePage(driver);
		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);

		lpSearchPg = lpHome.goToSeachPage();
		SearchPg lpSearchPg= new SearchPg(driver,lpUserType);
		String actual = lpSearchPg.getPageHeader();
		String expected = "Search";
		assertTrue("The expected Search Page Header was '" + expected
				+ "' but actually was: " + actual,
				actual.equalsIgnoreCase(expected));
		lpSearchPg.checkQuizzesOnly();
		  lpSearchPg.typeSearchKeyAndHitQuickSearchBtn(Keyword);
		lpHome.waitWhenLoadingBarActive(); 
	}
	@When("^I search for books already viewed by teacher$")
	public void i_search_for_books_already_viewed_by_teacher() throws Throwable {
		 lpHome = new LitProHomePg(driver, lpUserType);
			lpHome.goToHomePage();
			lpSearchPg = lpHome.goToSeachPage();
			System.out.println("title searched"+Searchtitle.getBooktitle());
			lpSearchPg.typeSearchKeyAndHitQuickSearchBtn(Searchtitle.getBooktitle());
	}
	@When("^I should verify Questions and answers in teacher and students are matching$")
	public void i_should_verify_Questions_and_answers_in_teacher_and_students_are_matching() throws Throwable {
		assertTrue("Teacher Ques and Answers doesnt match with student",	lpQuizModal.verifyQuesAndAnswers());
	}

}
