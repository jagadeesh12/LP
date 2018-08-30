package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;

import com.scholastic.intl.litpro.test.automation.pageobjects.AssessmentPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SettingsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.TestPg;
import com.scholastic.torque.common.TestBaseProvider;

public class LpTakeTestStDf {
	LitProUserType lpUserType;
	WebDriver driver=TestBaseProvider.getTestBase().getDriver();
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome= new SlzHomePg(driver);
	LitProHomePg lpHome = new LitProHomePg(driver);
	SettingsPg lpSettingsPg= new SettingsPg(driver, lpUserType);
	TestPg lpTestPg = new TestPg(driver, lpUserType);
	AssessmentPg lpAssessmentPg= new AssessmentPg(driver);
	ReportsPg lpReportsPg= new ReportsPg(driver, lpUserType);
	BasePage base = new BasePage(driver);
	
	Scenario scenario;

	// public LpTakeTestStDf(SharedDriver driver) {
	// this.driver = driver;
	// }

//	 @Before
//	 public void before(Scenario scenario) {
//	 this.scenario = scenario;
//	 }

	@Given("^I browse to LitPro Test Page as \"(.*?)\"$")
	public void i_browse_to_Setting_Page_as(String userType) {
		slzLogin = new SlzLoginPg(driver);
//		assertTrue("Failed to Launch AUT due to missing info. Check the log.",
//				slzLogin.launchSlz());
		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);
//		slzHome = slzLogin.loginAs(lpUserType);


	//	lpHome = slzHome.launchLitPro(lpUserType);
		base = new BasePage(driver);
		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		lpTestPg = lpHome.goToTakeTestPage();

	}
	

	@Given("^I launch Litpro and browse to LitPro Test Page using \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_launch_Litpro_and_browse_to_LitPro_Test_Page_using_and_with(String username, String password, String userType) throws Throwable {
	slzLogin = new SlzLoginPg(driver);

	LitProUserType lpUserType = slzLogin.getLitProUserType(userType);

	base = new BasePage(driver);
	base.loginApp(username,password);
	base.launchApp(lpUserType);
	assertNotNull("Could NOT launch litpro. Check log", lpHome);
	lpTestPg = lpHome.goToTakeTestPage();
	System.out.println(lpTestPg);
}

	@Then("^I should see welcome message with get started button$")
	public void i_should_see_welcome_message_with_get_started_button() {
		if (lpTestPg != null) {
			String actual = lpTestPg.getGreetingMessage();
			String expected = "This test will give you a Lexile measure that makes it easy to find books that are just right for you.";
			assertTrue("Complete welcome message NOT displayed. ",
					actual.contains(expected));
		} else {
			assertTrue(
					"LitPro Test tab is disabled, Perhaps Test is already taken",
					false);
			//scenario.write("LitPro Test tab is disabled, Perhaps Test is already taken");
		}
	}

	@When("^I click on lets get started button$")
	public void i_click_on_lets_get_started_button() {
		lpAssessmentPg = lpTestPg.launchAssessmentPg();
	}

	@When("^I complete the assessment$")
	public void i_complete_the_assessment() {
		try {
			// start answering if there are questions, otherwise it will be on
			// home page
			if (lpAssessmentPg.startAssessment()) {
				lpAssessmentPg.completeAssessment();
				lpAssessmentPg.clickCreateReadingList();
			} else {
				//scenario.write("There were no questions left to answer.");
			}

		} catch (Exception e) {
			lpHome.switchDriverToHomePg();
			String exp = e.getMessage();
			assertTrue("Error while attending test. " + exp, false);
		}
	}

	@When("^I complete the Test and store the question data$")
    public void i_complete_the_test_and_store_the_question_data() throws Throwable {
		try {
			// start answering if there are questions, otherwise it will be on
			// home page
			if (lpAssessmentPg.startAssessment()) {
				lpAssessmentPg.completeAssessmentStore();
			} else {
				//scenario.write("There were no questions left to answer.");
			}

		} catch (Exception e) {
			lpHome.switchDriverToHomePg();
			String exp = e.getMessage();
			assertTrue("Error while attending test. " + exp, false);
		}
    }
	
	@And("^I click 'Create My Reading list' Button$")
	public void i_click_Create_My_Reading_list_Button() {
		lpAssessmentPg.clickCreateReadingList();
	}

	@Then("^Home Page should be shown$")
	public void dashboard_should_be_shown() {
		LitProHomePg lpHomePg = new LitProHomePg(driver);
		lpHomePg.isLogoutLinkPresent();
		//lpHome.switchDriverToHomePg();

	}

	@Given("^I browse to Metrics section of Home Page as \"(.*?)\"$")
	public void i_browse_to_Metrics_section_of_Home_Page_as(String userType)
			throws Throwable {
		slzLogin = new SlzLoginPg(driver);
//		assertTrue("Failed to Launch AUT due to missing info. Check the log.",
//				slzLogin.launchSlz());
		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);
//		slzHome = slzLogin.loginAs(lpUserType);
//		lpHome = slzHome.launchLitPro(lpUserType);
		
		base = new BasePage(driver);
		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
	}

	@Then("^I should see Header Text stating with \"(.*?)\"$")
	public void i_should_see_Header_Text_stating_with(String header)
			throws Throwable {
		String expected = header;
		String actual = lpHome.getHeader();
		assertTrue("The expected Header was '" + expected
				+ "' but actually was: " + actual,
				actual.contains("Metrics for"));
	}

	@Then("^Metrics Section should display following metrics$")
	public void metrics_Section_should_display_following_metrics(
			List<Map<String, String>> metNames) throws Throwable {
		Iterator<Map<String, String>> metIterator = metNames.iterator();
		metIterator.next();
		while (metIterator.hasNext()) {
			Map<String, String> metricName = metIterator.next();
			String metricValue = lpHome.getMetricValue(metricName
					.get("Metric Name"));
			//scenario.write(metricName.get("Metric Name") + ": " + metricValue);
			
		}

	}

	@Then("^Following charts should display$")
	public void following_charts_should_display(List<String> metNames)
			throws Throwable {

	}

	@When("^I browse to Reports page$")
	public void i_browse_to_Reports_page() throws Throwable {
		lpReportsPg = lpHome.goToReportsPage();
	}

	@Then("^I should see following reports link$")
	public void i_should_see_following_reports_link(List<String> repsList) {
		Iterator<String> repsIterator = repsList.iterator();
		repsIterator.next();
		while (repsIterator.hasNext()) {
			String repName = repsIterator.next();
			assertTrue("'" + repName + "' Report link NOT displayed ",
					lpReportsPg.isReportDisplayed(repName));
		}
	}

	@When("^I open \"(.*?)\" report$")
	public void i_open_report(String repName) throws Throwable {
		String expected = "There is no data for this report for the selected year";
		lpReportsPg.openReport(repName);
		String notification = lpReportsPg.getNotificationText();

		if (StringUtils.containsIgnoreCase(notification, expected)) {
			//scenario.write("'" + notification + "' notification displayed");
		} else if (StringUtils.containsIgnoreCase(notification, "Error")
				|| StringUtils.containsIgnoreCase(notification, "Exception")) {
			assertTrue("Error/Exception occured. " + notification, false);
		}
	}

	@Then("^Popup should open with header \"(.*?)\"$")
	public void popup_should_open_with_header(String repName) throws Throwable {
		String expected = repName;
		String actual = lpReportsPg.getReportModalHeaderText();
		if (actual != "NULL") {
			lpReportsPg.closeReport();
			assertTrue("The expected Header was '" + expected
					+ "' but actually was: " + actual, expected.equals(actual));
		}
	}

	@When("^I search report card for student \"(.*?)\"$")
	public void i_search_report_card_for_student(String studentId)
			throws Throwable {
		lpReportsPg.searchStudentReportByUserName(studentId);
		//scenario.write(studentId + " Student's report card");
	}

	@Then("^I should see report card with following items$")
	public void i_should_see_report_card_with_following_information(
			List<String> elems) throws Throwable {
		Iterator<String> repsIterator = elems.iterator();
		repsIterator.next();
		while (repsIterator.hasNext()) {
			String repItem = repsIterator.next();
			assertTrue("Report item '" + repItem + "' NOT displayed ",
					!lpReportsPg.getReportCardItemValue(repItem).equals("NULL"));
		}
	}
	
	@Then("^I should see student grade level and class info on their reading report card so I have it as a reference$")
    public void i_should_see_student_grade_level_and_class_info_on_their_reading_report_card_so_i_have_it_as_a_reference() throws Throwable {
		assertTrue("Student Grade or class is not displayed ", lpReportsPg.VerifyClassGrade());
	}
	
	@When("^I complete the Test$")
	public void i_complete_the_test() {
		try {
			// start answering if there are questions, otherwise it will be on
			// home page
			if (lpAssessmentPg.startAssessment()) {
				lpAssessmentPg.completeAssessment();
			} else {
				//scenario.write("There were no questions left to answer.");
			}

		} catch (Exception e) {
			lpHome.switchDriverToHomePg();
			String exp = e.getMessage();
			assertTrue("Error while attending test. " + exp, false);
		}
	}

	@When("^I should not see the lexile score$")
	public void NotSee_Lexile_score() {
		assertTrue(
				"Students are able to see Lexile score after completion of the test",
				lpAssessmentPg.NoLexileScore());
	}

	@When("^I should see the lexile score$")
	public void See_Lexile_score() {
		assertTrue(
				"Students are not able to see Lexile score after completion of the test",
				lpAssessmentPg.LexileScore());
	}

	@Then("^I should see the following data in directions popup :$")
	public void i_should_see_the_following_data_in_directions_popup(
			List<Map<String, String>> option) throws Throwable {
		Iterator<Map<String, String>> inIterator = option.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();
			assertTrue("Modal Pop up Directions data not found ",
					lpAssessmentPg.verifyDirectionValue(row
							.get("DirectionsData")));

		}
	}

	@When(value="^I should be shown practise test while taking test$")
	public void i_complete_the_test_with_Pratise_test() throws InterruptedException{
		try {
			// start answering if there are questions, otherwise it will be on
			// home page
			if (lpAssessmentPg.startAssessment()) {
				assertTrue("Practise test question is not shown to students",
						lpAssessmentPg.completeAssessment_practisetest());
			} else {
				//scenario.write("There were no questions left to answer.");
			}

		} catch (Exception e) {
			lpHome.switchDriverToHomePg();
			String exp = e.getMessage();
			assertTrue("Error while attending test. " + exp, false);
		}
	}

	@When("^I complete the pause Test$")
	public void i_complete_the_pause_test() {
		try {
			// start answering if there are questions, otherwise it will be on
			// home page
			assertTrue("Resume test pop message is not shown",
					lpAssessmentPg.startPauseAssessment());
			lpAssessmentPg.incompleteAssessment();
		} catch (Exception e) {
			lpHome.switchDriverToHomePg();
			String exp = e.getMessage();
			assertTrue("Error while attending test. " + exp, false);
		}

	}

	@When("^I will take test and pause it$")
	public void i_take_incomplete_assessment() throws Throwable {
		lpAssessmentPg.startAssessment();
		lpAssessmentPg.incompleteAssessment();
		lpAssessmentPg.closePopup();
	}

	@When("^I will take interrupt the test$")
	public void i_interruot_assessment() throws Throwable {
		lpAssessmentPg.startAssessment();
		lpAssessmentPg.incompleteAssessment();

	}

	@Given("^I browse to LitPro SRI Test Page as \"(.*?)\"$")
	public void i_browse_to_SRI_Test_Page_as(String userType) {
		slzLogin = new SlzLoginPg(driver);
		assertTrue("Failed to Launch AUT due to missing info. Check the log.",
				slzLogin.launchSlz());
		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);
//		slzHome = slzLogin.loginAs(lpUserType);
		//scenario.write("Credentials: " + slzLogin.getUserCreds());
		base = new BasePage(driver);
		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);

//		lpHome = slzHome.launchLitPro(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		lpTestPg = lpHome.goToTakeTestPage();

	}

	@Then("^I should logout as student$")
	public void i_should_logout_as_student() {
		lpAssessmentPg.Handletestalert();
	}
}
