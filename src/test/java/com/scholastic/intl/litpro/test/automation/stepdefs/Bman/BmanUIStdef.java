package com.scholastic.intl.litpro.test.automation.stepdefs.Bman;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.scholastic.intl.litpro.automation.pageobjects.joey.JoeyhomePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.bman.BmanHomePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.bman.BmanLogin;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BmanUIStdef {
	WebDriver driver= TestBaseProvider.getTestBase().getDriver();
	//Scenario scenario;
    LitProUserType lpUserType;
    TestBase testBase = TestBaseProvider.getTestBase();
	BasePage base = new BasePage(driver);
	BmanHomePage bmanHome = new BmanHomePage(driver);
	BmanLogin bmanLogin = new BmanLogin(driver);
	JoeyhomePage joeyHmPg = new JoeyhomePage(driver);
	
	/*@When("^I launch Joye as \"([^\"]*)\"$")
	public void i_launch_Joye_as(String userType) throws Throwable {
		slzLogin = new SlzLoginPg(driver);
		// assertTrue("Failed to Launch AUT due to missing info. Check the log.",
		// slzLogin.launchSlz());
		 lpUserType = slzLogin.getLitProUserType(userType);
	//	scenario.write("Credentials: "+slzLogin.getUserCreds());
		
		base.launchPortal(lpUserType);
		base.launchAppJoey(lpUserType);
	}*/

	@Given("^I launch Bman and browse to Create book page \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_launch_Bman_and_browse_to_Create_book_page_and(String username, String password) throws Throwable {
		bmanLogin=new BmanLogin(driver);
		bmanLogin.loginbman(username, password);
	}

	@Then("^I should see bman header$")
	public void i_should_see_bman_header() throws Throwable {
		bmanHome.isHeaderPresent();
	}

	@When("^I create book in bman$")
	public void i_create_book_in_bman() throws Throwable {
		bmanHome.Createbook();
	}

	@Then("^I should see sucess message for the book creation$")
	public void i_should_see_sucess_message_for_the_book_creation() throws Throwable {
		assertTrue("Book not created",bmanHome.getBookCreatedSuccess().contains("Book successfully added"));
			
	}
	
	@Then("^I create create quizzes in bman$")
	public void i_create_create_quizzes_in_bman() throws Throwable {
		bmanHome.createQuizz();
	}

}
