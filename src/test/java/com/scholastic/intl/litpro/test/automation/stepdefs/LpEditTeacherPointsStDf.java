package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;

import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SettingsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBaseProvider;

//import stepdefination.SharedDriver;

public class LpEditTeacherPointsStDf {
	WebDriver driver=TestBaseProvider.getTestBase().getDriver();
	private LitProUserType lpUserType;
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome= new SlzHomePg(driver);
	LitProHomePg lpHome = new LitProHomePg(driver, lpUserType);
	SettingsPg lpSettingsPg = new SettingsPg(driver,lpUserType);
	ReportsPg lpReportsPg = new ReportsPg(driver, lpUserType);;
	
	Scenario scenario;
	

	/*
	 * public LpEditTeacherPointsStDf(SharedDriver driver) { this.driver =
	 * driver; }
	 */
//	 @Before
//	 public void before(Scenario scenario) {
//	 this.scenario = scenario;
//	 }

	@When("^I click on Reports tab$")
	public void i_click_on_Reports_tab() throws Throwable {
		lpSettingsPg = new SettingsPg(driver, lpUserType);
		lpSettingsPg.clickReports();
		Thread.sleep(5000);
	}

	@Then("^I should see Reports Page$")
	public void i_should_see_Reports_Page() throws Throwable {
		lpReportsPg = new ReportsPg(driver, lpUserType);
		assertTrue("Report page header does not begin Reports for",
				lpReportsPg.verifyreportheader());

	}

	@When("^I click edit link for quiz points$")
	public void i_click_edit_link_for_quiz_points() throws Throwable {
		lpReportsPg.clickeditpts();
	}

	@Then("^I should see the points added in the Quiz Points Earned and Teacher-Added Points$")
	public void i_should_see_the_points_added_in_the_Quiz_Points_Earned_and_Teacher_Added_Points()
			throws Throwable {
		assertTrue("Teacher added points not added to Report",
				lpReportsPg.verifyteacheraddedpts());
	}
	
	@Then("^I should increase the teacher points by \"([^\"]*)\" points$")
    public void i_should_increase_the_teacher_points_by_something_points(String point) throws Throwable {
		lpReportsPg.TeacherEditedPoints(point);
    }
	@Then("^\"([^\"]*)\" Message should be displayed$")
    public void something_message_should_be_displayed(String message) throws Throwable {
		assertTrue("Saved points message is not displayed ",lpReportsPg.MessagePopup(message));
	}
	
	@And("^I should collect the data of Quiz Points Earned and Teacher Added Points$")
    public void i_should_collect_the_data_of_quiz_points_earned_and_teacher_added_points() throws Throwable {
		lpReportsPg.CollectPointData();	
    }
	
	@Then("^I should validate that Quiz Points Earned should be addition of Quiz Points Earned and Teacher Added Points$")
    public void i_should_validate_that_quiz_points_earned_should_be_addition_of_quiz_points_earned_and_teacher_added_points() throws Throwable {
		assertTrue("Quiz Points Earned displayed is NOT equal to the addition of Quiz Points Earned and Teacher Added Points",lpReportsPg.PointsDataValidation());
	}
}