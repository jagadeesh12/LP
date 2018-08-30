package com.scholastic.intl.litpro.test.automation.stepdefs.slz;


import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.SlzManageUsersPg;
//import stepdefination.SharedDriver;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SlzCreateUserStDf {
	SlzLoginPg slzLogin = null;
	SlzHomePg slzHome;
	Scenario scenario;
	SlzLoginPg slzLoginPg;
	SlzHomePg slzHomePg;
	SlzManageUsersPg slzManageUsersPg;
	WebDriver driver;


	@When("^I click Manage Users$")
	public void i_click_manage_users() throws Throwable {
		slzHomePg =  new SlzHomePg(driver);
		slzHomePg.goToManageUsersPg();		
	}
	
	@Then("^Manage Users Page displays$")
	public void manage_Users_Page_displays() throws Throwable {
		slzManageUsersPg = new SlzManageUsersPg(driver);		
		assertTrue("Manage Users page did not display.", slzManageUsersPg.verifyManageUsersPg());	   
	}
	
	@When("^I select Student type and click Create$")
	public void i_select_Student_type_and_click_Create() throws Throwable {	
		slzManageUsersPg = new SlzManageUsersPg(driver);
		slzManageUsersPg.selectAddUserType("Student");
		slzManageUsersPg.clickCreateButton();
	}

	@Then("^Add Single User popup displays$")
	public void add_Single_User_popup_displays() throws Throwable {
		assertTrue("Create Single User popup did not display.", slzManageUsersPg.verifySingleUserPopup());		
	}

	@When("^I complete form and click submit$")
	public void i_complete_form_and_click_submit() throws Throwable {
		slzManageUsersPg.createStudent();
	}

	@Then("^student creation completed$")
	public void student_creation_completed() throws Throwable {
		assertTrue("Option 2: Create a new user - did not display",slzManageUsersPg.verifyStudentCreated());
	}
	
	

}