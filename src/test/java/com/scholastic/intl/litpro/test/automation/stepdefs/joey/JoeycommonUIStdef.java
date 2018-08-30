package com.scholastic.intl.litpro.test.automation.stepdefs.joey;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.scholastic.intl.litpro.automation.pageobjects.joey.JoeyhomePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JoeycommonUIStdef {
	WebDriver driver= TestBaseProvider.getTestBase().getDriver();
	//Scenario scenario;
    LitProUserType lpUserType;
    TestBase testBase = TestBaseProvider.getTestBase();
	BasePage base = new BasePage(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	JoeyhomePage joeyHmPg = new JoeyhomePage(driver);
	
	@When("^I launch Joye as \"([^\"]*)\"$")
	public void i_launch_Joye_as(String userType) throws Throwable {
		slzLogin = new SlzLoginPg(driver);
		// assertTrue("Failed to Launch AUT due to missing info. Check the log.",
		// slzLogin.launchSlz());
		 lpUserType = slzLogin.getLitProUserType(userType);
	//	scenario.write("Credentials: "+slzLogin.getUserCreds());
		
		base.launchPortal(lpUserType);
		base.launchAppJoey(lpUserType);
	}

	@Then("^I should see Prime Professional Learning Home page$")
	public void i_should_see_Prime_Professional_Learning_Home_page() throws Throwable {
		JoeyhomePage joeyHmPg = new JoeyhomePage(driver);
		assertTrue("Joey Home Page not displayed",joeyHmPg.isJoeyhomePageDisplayed());
	}

	@Then("^I should see user \"([^\"]*)\"$")
	public void i_should_see_user(String arg1) throws Throwable {
		assertTrue("Joey Home Page not displayed",joeyHmPg.isGreetTextDisplayed());
	}

	@Then("^I should see below tabs in joey Home Page:$")
	public void i_should_see_below_tabs_in_joey_Home_Page(List<String> tabList) throws Throwable {
		String actual = joeyHmPg.getDisplayedTabNames().toString();
		String expected = tabList.toString();
		assertTrue("The expected Tabs list was '" + expected
				+ "' but actually was: " + actual, actual.contains(expected));
	}
	@Then("^I should see Search bar$")
	public void i_should_see_Search_bar() throws Throwable {
		assertTrue("Joey Home Page Search bar is not displayed",joeyHmPg.isSearchBarDisplayed());
	}

	@Then("^I should see Logout link in joey home Page$")
	public void i_should_see_Logout_link_in_joey_home_Page() throws Throwable {
		assertTrue("Log out link is not displayed not displayed",joeyHmPg.isLogoutDisplayed());
	}
	@When("^I click on Assessment Quiz Button$")
	public void i_click_on_Assessment_Quiz_Button() throws Throwable {
		joeyHmPg.clickAssesmentButton();
	}

	@Then("^Assessment Header has to be displayed$")
	public void assessment_Header_has_to_be_displayed() throws Throwable {
		assertTrue("Log out link is not displayed not displayed",joeyHmPg.isAssesmentHeaderDisplayed());
	}

	@Then("^I should see Quiz header$")
	public void i_should_see_Quiz_header() throws Throwable {
		assertTrue("Log out link is not displayed not displayed",joeyHmPg.isLogoutDisplayed());
	}

	@Then("^I complete Quiz$")
	public void i_complete_Quiz() throws Throwable {
		joeyHmPg.completeAssessment();
	}

	@Then("^Quiz completed message has to be displayed$")
	public void quiz_completed_message_has_to_be_displayed() throws Throwable {
		assertTrue("Log out link is not displayed not displayed",joeyHmPg.isTestfinished());
	}

}
