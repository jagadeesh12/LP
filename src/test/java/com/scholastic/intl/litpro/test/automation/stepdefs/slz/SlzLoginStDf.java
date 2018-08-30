package com.scholastic.intl.litpro.test.automation.stepdefs.slz;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.SlzCSRHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.ManagerPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SlzLoginStDf {
	SlzLoginPg slzLogin = null;
	SlzHomePg slzHome;
	Scenario scenario;
	SlzLoginPg slzLoginPg;
	SlzHomePg slzHomePg;
	WebDriver driver;
	SlzCSRHomePg slzCsrHomePg;
	ManagerPage ManagerPage;

	

	@Given("^I am on Scholastic Learning Zone Login Page$")
	public void i_am_on_Scholastic_Learning_Zone_Login_Page() throws Throwable {
		slzLoginPg = new SlzLoginPg(driver);
		slzLoginPg.launchSlz();
		//System.out.println("end of I am on Scholastic Learning Zone Login Page");
	}

	@When("^I login with following credentials$")
	public void i_login_with_following_credentials(Map<String, String> creds)throws Throwable {
		slzHomePg = slzLoginPg.login(creds.get("UserName"), creds.get("Password"));
		//System.out.println("end of I login with following credentials");
	}

	@Then("^I should see Scholastic Learning Zone Home Page$")
	public void i_should_see_Scholastic_Learning_Zone_Home_Page()
			throws Throwable {
		//System.out.println("start of I should see Scholastic Learning Zone Home Page");
		String actual = slzHomePg.getStudentGreetingText();
		String expected = "Hi ";
		assertTrue("The expected Greet Text was '" + expected
				+ "' but actually was: " + actual, actual.contains(expected));
		//System.out.println("end of I should see Scholastic Learning Zone Home Page");
	}

	@When("^I login using '(.*?)' and '(.*?)'$")
	public void i_login_using(String un, String pw) throws Throwable {
		slzLoginPg.login(un, pw);
	}

	@Then("^I should see Error Message \"(.*?)\"$")
	public void i_should_see_Error_Message(String expected) throws Throwable {
		String actual = slzLoginPg.getLoginErrorText();
		assertTrue("The expected Error Text was '" + expected
				+ "' but actually was: " + actual, actual.equals(expected));
	}
	
	@When("^I login with following credentials as csrep$")
	public void i_login_with_following_credentials_as_csrep(Map<String, String> creds) throws Throwable {
		SlzCSRHomePg slzCsrHomePg = slzLoginPg.loginAsCSRep(creds.get("UserName"));
		//System.out.println("end of I login with following credentials");
		
		
	}
	@Then("^I should see create order Page$")
	public void i_should_see_create_order_Page() throws Throwable {
		SlzCSRHomePg slzCsrHomePg = new  SlzCSRHomePg(driver);
		assertTrue("Create Order is not displayed '", slzCsrHomePg.isCreateOrderDisplayed());
		
	}
	
	@When("^I click on Forgot password link$")
	public void i_click_on_Forgot_password_link() throws Throwable {
		slzLoginPg = new SlzLoginPg(driver);
		slzLoginPg.clickForgotPasswordLink();
	}

	@Then("^I should see Error Messages$")
	public void i_should_see_Error_Messages() throws Throwable {
		slzLoginPg.isErrorMessageDisplayed();
	}
	
	@Then("^I should search for the school \"([^\"]*)\"$")
    public void i_should_search_for_the_school_something(String SchoolName) throws Throwable {
		slzLoginPg.SearchSchool(SchoolName);
    }
	
	@Then("^I should enter by pass through$")
    public void i_should_enter_by_pass_through() throws Throwable {
		slzLoginPg.PassThroughLink();
	}

	@Then("^I should open Litpro$")
	public void i_should_open_litpro() throws Throwable {
		slzLoginPg.OpenApplication();
	}
	@When("^I open the manager$")
	public void i_open_the_manager() throws Throwable {
		slzLoginPg.Openmanager();
	}
	
	@Then("^I should open the \"([^\"]*)\" page$")
    public void i_should_open_the_something_page(String name) throws Throwable {
		slzLoginPg.SOARImport(name);
	}
	
	@When("^I enter the ORGID in SOAR test import$")
    public void i_enter_the_orgid_in_soar_test_import() throws Throwable {
		slzLoginPg.EnterORDID();
	}
	
	@Then("^I should confirm that school is correct$")
    public void i_should_confirm_that_school_is_correct() throws Throwable {
		assertTrue("Org ID is not same",slzLoginPg.ConfirmSchool());		
	}
	
	@When("^I should create the SRI Import File \"([^\"]*)\"$")
    public void i_should_create_the_sri_import_file_something(String Filename) throws Throwable {
		slzLoginPg.CreateSRICSV();
	}
	
	@When("^I Upload the SRI Import File \"([^\"]*)\"$")
    public void i_upload_the_sri_import_file_something(String filename) throws Throwable {
		slzLoginPg.UploadSRIFile(filename);
	}
	
	@Then("^I should verify the uplaoded data$")
    public void i_should_verify_the_uplaoded_data() throws Throwable {
		assertTrue("Correct file did not got uploaded correctly",slzLoginPg.VerifyUpload());		
    }
	
	@Then("^I should open the Quizzes page$")
    public void i_should_open_the_quizzes_page() throws Throwable {
		slzLoginPg.ManagerQuizzes();
	}
	@When("^I should uplaod the CSV file$")
    public void i_should_uplaod_the_csv_file() throws Throwable {
		assertTrue("File did not got uplaoded successfully",slzLoginPg.UploadCSV());
	}
	
	@Then("^I should validate the uplaoded CSV Quizzes$")
	public void i_should_validate_uplaoded_to_quizzes() throws Throwable {
		assertTrue("Few or all the question did not got uplaoded successfully",
				slzLoginPg.ValidateuplaodedQuizzes());
	}

	@Then("^I should click Next button to complete the process$")
	public void i_should_click_next_button_to_complete_the_process() throws Throwable {
		assertTrue("Quizzes did not uplaoded successfully",slzLoginPg.NextButtonComplete());
	}
	
	@Then("^I should open the Books Import Export page$")
    public void i_should_open_the_books_import_export_page() throws Throwable {
		slzLoginPg.BookImportEport();
    }

	@When("^I uplaod the book XML file \"([^\"]*)\"$")
	public void i_uplaod_the_book_xml_file_something(String filename)
			throws Throwable {
		assertTrue("Book XML did not got uplaoded successfully",slzLoginPg.uplaodBookXML(filename));
	}
	
	@Then("^I will create a CSV file with - Title (.+) author FirstName (.+) Author LastName(.+)$")
    public void i_type_search_key_title_author_firstname_author_lastname(String title, String authorfirstname, String authorlastname) throws Throwable {
    	slzLoginPg.CreateCSV(title, authorfirstname, authorlastname);
    }
	
	@Then("^I should open SyncLog$")
	public void i_should_open_SyncLog() throws Throwable {
		slzLoginPg.BookSyncLog();
	}

	@Then("^I should see Synclog button is activated$")
	public void i_should_see_Synclog_button_is_activated() throws Throwable {
		slzLoginPg.isBookSynced();
	}
	
	@Then("^I should create an XML and store the URL$")
	public void i_should_create_an_XML_and_store_the_URL(List<String> uiElements) throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			slzLoginPg.CreateXML(repName);
		}
		slzLoginPg.EditXML();
	}
	
	@Then("^I should create an XML and store the URL for CSrep$")
    public void i_should_create_an_xml_and_store_the_url_for_csrep(List<String> uiElements) throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			slzLoginPg.CreateXML(repName);
		}
		slzLoginPg.EditXML1();
    }
	
	
	
	
	
	
	
	
	@Then("^deelte deelte deelte deelte$")
    public void deelte_deelte_deelte_deelte(List<String> uiElements) throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			slzLoginPg.CreateXML(repName);
		}
		slzLoginPg.EditXML2();
    }
}