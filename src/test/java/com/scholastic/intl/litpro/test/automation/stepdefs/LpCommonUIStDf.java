package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.QuizModal;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;



//import stepdefination.SharedDriver;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LpCommonUIStDf {
	WebDriver driver= TestBaseProvider.getTestBase().getDriver();
	//Scenario scenario;
    LitProUserType lpUserType;
	String bookTitle = "Mouse Tales";
	SearchPg lpSearchPg = new SearchPg(driver);
	QuizModal lpQuizModal = new QuizModal(driver);
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
    LitProHomePg lpHome = new LitProHomePg(driver);
    ArrayList<String> ar = new ArrayList<String>();
	String skey;

	TestBase testBase = TestBaseProvider.getTestBase();
	BasePage base = new BasePage(driver);
	/*
	 * public LpCommonUIStDf(SharedDriver driver) { this.driver = driver; }
	 */
//	 @Before
//	 public void before(Scenario scenario) {
//	 this.scenario = scenario;
//	 }

	@When("^I launch LitPro as \"(.*?)\"$")
	public void i_launch_LitPro(String userType) {
		slzLogin = new SlzLoginPg(driver);
		// assertTrue("Failed to Launch AUT due to missing info. Check the log.",
		// slzLogin.launchSlz());
		 lpUserType = slzLogin.getLitProUserType(userType);
	//	scenario.write("Credentials: "+slzLogin.getUserCreds());
		
		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);
		 assertNotNull("Could NOT launch litpro. Check log", lpHome);

	}
	@Given("^I launch LitPro using \"(.*?)\" and \"(.*?)\" with \"(.*?)\"$")
	public void i_launch_LitPro_using_and_with(String username,
			String password, String userType) throws Throwable {

		slzLogin = new SlzLoginPg(driver);
//		assertTrue("Failed to Launch AUT due to missing info. Check the log.",
//				slzLogin.launchSlz());
	   lpUserType = slzLogin.getLitProUserType(userType);

	//	slzHome = slzLogin.login(username, password);
		base.loginApp(username, password);
		//scenario.write("Credentials:username,password ");
		base.launchApp(lpUserType);
	//	lpHome = slzHome.launchLitPro(lpUserType);

		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		Thread.sleep(5000);

	}


	@Then("^I should see Scholastic Literacy Pro Home Page$")
	public void i_should_see_Scholastic_Literacy_Pro_Home_Page() {
		LitProHomePg lpHome = new LitProHomePg(driver);
		String expected = lpHome.getExpectedTitle();
		String actual = testBase.getDriver().getTitle();
		assertTrue("The expected Page Title was '" + expected
				+ "' but actually was: " + actual,
				actual.equalsIgnoreCase(expected));

	}

	@Then("^I should see user greeting text \"(.*?)\"$")
	public void i_should_see_user_greeting_text(String greetTxt) {
		String expected = greetTxt;
		LitProHomePg lpHome = new LitProHomePg(driver,lpUserType);
		String actual = lpHome.getUserGreetingText();
		assertTrue("The expected Greet Text was '" + expected
				+ "' but actually was: " + actual, actual.contains("Welcome, "));
	}

	@Then("^I should see below tabs:$")
	public void i_should_see_following_tabs(List<String> tabList) {
		LitProHomePg lpHome = new LitProHomePg(driver,lpUserType);
		System.out.println(lpUserType);
		String actual = lpHome.getDisplayedTabNames().toString();
		String expected = tabList.toString();
		assertTrue("The expected Tabs list was '" + expected
				+ "' but actually was: " + actual, actual.contains(expected));
	}

	@Then("^I should see Logout link$")
	public void i_should_see_link() throws Throwable {
		assertTrue("Logout link NOT displayed", lpHome.isLogoutLinkPresent());
	}

	
	/*********************************************************************************************/
	@Then("^I should not see Home tab$")
	public void Missing_home_tab() throws InterruptedException {
		assertTrue("Home tab is visible", !lpHome.readinglistDisplayed());
	}

	@Then("^I should see Home tab$")
	public void home_tab_present() throws InterruptedException {
		assertTrue("Home tab not visible", lpHome.readinglistDisplayed());
	}

	@Then("^I should see LitPro Test tab enabled$")
	public void LitPro_Test_tab_disabled() throws InterruptedException {
		assertTrue("LitPro Test tab is disabled instead of enabled",
				lpHome.LitProTesttabEnabled());
	}

	@Then("^I should see LitPro Test tab disabled$")
	public void LitPro_Test_tab_enabledd() throws InterruptedException {
		assertTrue("LitPro Test tab is not disabled",
				lpHome.LitProTesttabdisabled());
	}

	@Then("^I should see that all the books in reading list should have quiz button$")
	public void reading_list_books() throws InterruptedException {
		assertTrue("LitPro Test tab is enabled instead of disabled",
				!lpHome.LitProTesttabEnabled());
	}

	@Then("^I should see already created reading list$")
	public void reading_list_Alreadycreated() throws InterruptedException {
		assertTrue(
				"Reading list is not created for student \"Reading/welcome1\"",
				lpHome.ReadingLlistAlreadyCreated());
	}

	@Then("^I should see all the books with the quizzes button$")
	public void books_with_quizzes() throws InterruptedException {
		assertTrue(
				"Not all the books in Reading list contains \"Take a Quiz\" button",
				lpHome.BooksWithQuizzes());
		// lpHome.BooksWithQuizzes();
	}

	@Then("^I should see all the books with inlib icon$")
	public void books_with_inlibIcon() throws InterruptedException {
		assertTrue(
				"Reading list contain books which does not have \"Inlib icon\" image",
				lpHome.BooksWithInlibIcons());
		// lpHome.BooksWithQuizzes();
	}

	@Then("^I should see only 10 books in reading list$")
	public void Tenbooks_In_ReadingList() throws InterruptedException {
		assertTrue("More then 10 books are shown in Reading list",
				lpHome.TenbooksInReadingList());
		// lpHome.BooksWithQuizzes();
	}

	@Then("^I should see Edit Reading Interests button$")
	public void Edit_Reading_Interests_button_visible()
			throws InterruptedException {
		assertTrue("Students are not able to edit Reading list",
				lpHome.EditReadingInterestsButtonVisible());
		// lpHome.BooksWithQuizzes();
	}

	@Then("^I should not see Edit Reading Interests button$")
	public void Edit_Reading_Interests_button_Invisible()
			throws InterruptedException {
		assertTrue("Students are able to edit Reading list",
				lpHome.EditReadingInterestsButtonNotVisible());
		// lpHome.BooksWithQuizzes();
	}

	@Then("^I should see print button in student home tab$")
	public void PrintButton_homeStudent_visible() throws InterruptedException {
		assertTrue("Students are not able to see print button in home tab",
				lpHome.PrintButtonHomeStudentVisible());
	}

	@When("^I should see print button in student search tab$")
	public void search_tab_printButton_student() throws Throwable {
		assertTrue("Print button is not present in search tab",
				lpHome.SerachButtonStudent());
	}

	@When("^I should see print button in student My results tab$")
	public void Myresult_tab_printButton_student() throws Throwable {
		assertTrue("Print button is not present in My result tab",
				lpHome.MyresultButtonStudent());
	}

	@Then("^I should verify the help icon$")
	public void I_should_verify_help_icon() {
		assertTrue("Help Icon is missing from the page",
				lpHome.Verifyhelpicon());
	}

	@Then("^I should verify the help dropdown link$")
	public void I_should_verify_help_dropdown_link() {
		assertTrue(
				"Either Help Icon dropdown does not have one of the options or it is not redirecting to correct URL",
				lpHome.Verifyhelpdropdownlink());
	}
	@Then("^I store all reading list book names to verify in Admin$")
	public void i_store_all_reading_list_book_names_to_verify_in_Admin() throws Throwable {
		ar =lpHome.storeBooknames();
	}

	@When("^I type search key from reading list$")
	public void i_type_search_key_from_reading_list() throws Throwable {
		 skey =ar.get(1);
		System.out.println(skey);
		lpSearchPg.typeSearchKey("\"" + skey + "\"");
	}
	@Then("^I must see book in search Result with middle primary$")
	public void i_must_see_book_in_search_Result_with_middle_primary() throws Throwable {
		assertTrue("Result doesnt contain book title",lpSearchPg.verifyBookTitle(skey));
	}
}
