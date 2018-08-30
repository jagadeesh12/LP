package com.scholastic.intl.litpro.test.automation.stepdefs.lpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.lpl.BooksPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.lpl.CollectionsPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.lpl.LitProLibraryHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.lpl.StudentsPage;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;


/* @ Author: Rajesh R
 * @ Created Date:20/01/2016
 * @ Functionality: Message Flows step Definition
 * @ Type: Smoke, regression
 * 
 * 
 * @ Updated Date
 * @ Updated By Rajesh R
 * 
 */

public class SendMessageFlow {
	WebDriver driver= TestBaseProvider.getTestBase().getDriver();

	//WebDriver driver;
	Scenario scenario;
	SlzLoginPg slzLogin = null;
	SlzHomePg slzHome;
	LitProLibraryHomePg lplHome;
	StudentsPage stdPage;
	BooksPage bookPage;
	CollectionsPage collectionPage;
	private LitProUserType lpUserType;
	BasePage base = new BasePage(driver);
	
	@Given("^I launch LitProLibrary as a \"([^\"]*)\"$")
	public void i_launch_LitProLibrary_as_a(String userType) throws Throwable {
		SlzLoginPg slzLogin = new SlzLoginPg(driver);
		 lpUserType = slzLogin.getLitProUserType(userType);
		base.launchPortal(lpUserType);
		SlzHomePg slzHome= new SlzHomePg(driver) ;
		base.launchRPLLPL(lpUserType);

		lplHome= new LitProLibraryHomePg(driver,lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lplHome);
	}


	@When("^I click on Assigned book by teacher$")
	public void i_click_on_Assigned_book_by_teacher() throws Throwable {
		lplHome = new LitProLibraryHomePg(driver, lpUserType);
		lplHome.openAssignedBookStudent();
	}

	@Then("^Book has to be opened$")
	public void book_has_to_be_opened() throws Throwable {
		lplHome = new LitProLibraryHomePg(driver, lpUserType);
		assertTrue("Assigned Book not displayed.",
				lplHome.isAssignedBookDisplayed());
	}
	
	

	@Then("^I enter message in messagbox$")
	public void i_enter_message_in_messagbox() throws Throwable {
		lplHome.writeAMessageToTeacher("Message to Teacher");
	}

	@Then("^I click SendMessage button$")
	public void i_click_SendMessage_button() throws Throwable {
		lplHome.sendMessageToTeachersButton();

	}

	@Then("^success message sent has to be displayed$")
	public void success_message_sent_has_to_be_displayed() throws Throwable{

		assertTrue("Sucess Sent Message not displayed.",
				lplHome.isSucessMessageDisplayed());
		lplHome.clickSucessfulOkButton();
	}

	@When("^I click on Assigned book$")
	public void i_click_on_Assigned_book() throws Throwable {
		bookPage = new BooksPage(driver);
		bookPage.openAssignedBookFromTeacher();
	}

	@When("^I click on send message icon$")
	public void i_click_on_send_message_icon() throws Throwable {
		bookPage.clickOnMessageIcon();
	}

	@Then("^I select students from message box$")
	public void i_select_students_from_message_box() throws Throwable {
		bookPage.selectStudentsToSendMessage();
	}
	@Then("^I enter message in students messagbox$")
	public void i_enter_message_in_students_messagbox() throws Throwable {
		bookPage.writeAMessageToStudentsFromAssignedBook("Message to students");
	}

	@Then("^I must see audio recording$")
	public void i_must_see_audio_recording() throws Throwable {
		bookPage = new BooksPage(driver);
		assertTrue("Audio recording not displayed.",
				bookPage.isAudiRecordingDisplayed());
	}

	@Then("^I must see send message$")
	public void i_must_send_message() throws Throwable {
		bookPage = new BooksPage(driver);
		assertTrue("Send Message not displayed.",
				bookPage.isSendMessageDipslayed());	
	}

	@Then("^I must see view Message$")
	public void i_must_see_view_Message() throws Throwable {
		bookPage = new BooksPage(driver);
		assertTrue("View message not displayed.",
				bookPage.isViewMessageDisplayed());
	}
}
