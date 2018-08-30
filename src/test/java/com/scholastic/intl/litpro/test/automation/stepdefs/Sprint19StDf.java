package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.scholastic.intl.litpro.test.automation.pageobjects.AssessmentPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SettingsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.TestPg;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sprint19StDf {
	WebDriver driver=TestBaseProvider.getTestBase().getDriver();
	LitProUserType lpUserType;
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	LitProHomePg lpHome= new LitProHomePg(driver,lpUserType);
	SettingsPg lpSettingsPg= new SettingsPg(driver, lpUserType);
	TestPg lpTestPg= new TestPg(driver, lpUserType);
	AssessmentPg lpAssessmentPg= new AssessmentPg(driver);
	ReportsPg lpReportsPg= new ReportsPg(driver,lpUserType);
	
	Scenario scenario;

	SearchPg srchPg= new SearchPg(driver,lpUserType);

	// public Sprint19StDf(SharedDriver driver) {
	// this.driver = driver;
	//
	// }

//	@Before
//	public void before(Scenario scenario) {
//		this.scenario = scenario;
//	}

	@Then("^My lexile score must be \"(.*?)\"$")
	public void my_lexile_score_must_be(String score) throws Throwable {
		lpHome = new LitProHomePg(driver, lpUserType);
		String st = lpHome.getLexileScore();

		if (score.equalsIgnoreCase("BR") || Integer.parseInt(score) == 0) {
			assertTrue("Lexile score is not BR", st.contains("BR"));

		} else {
			if (Integer.parseInt(score) > 100) {

				st = lpHome.getLexileScore().replaceAll("[A-Z]", "");
				System.out.println(st);
				assertTrue("Lexile score is not greater than 100",
						(Integer.parseInt(st) > 100));
			}

			if (Integer.parseInt(score) < 100 & Integer.parseInt(score) > 0) {
				st = lpHome.getLexileScore().replaceAll("[A-Z]", "");
				assertTrue("Lexile score is not Lesser than 100",
						(Integer.parseInt(st) < 100));
			}

		}
	}

	@When("^I take incomplete assessment$")
	public void i_take_incomplete_assessment() throws Throwable {
		lpAssessmentPg.startAssessment();
		lpAssessmentPg.incompleteAssessment();
		
	}

	@Then("^I click on Alert Report$")
	public void i_click_on_Alert_Report() throws Throwable {
		lpHome.clickOnAlertReport();
	}

	@Then("^I should see report card with Incomplete test as a Metric$")
	public void i_should_see_report_card_with_Incomplete_test_as_a_Metric()
			throws Throwable {
		assertTrue("Incomplete Test metric is not present",
				lpReportsPg.isIncompleteTestPresent());
	}

	@When("^I enter Reports search for student \"(.*?)\" whose score is BR$")
	public void i_enter_Reports_search_for_student_whose_score_is_BR(String arg1)
			throws Throwable {

	}

	@Then("^I must see tool tip in Reading report card$")
	public void i_must_see_tool_tip_in_Reading_report_card() throws Throwable {
		// lpReportsPg.isTooltipDisplayed();
		assertTrue("Tooltip is not presentt", lpReportsPg.isTooltipDisplayed());
	}

	@When("^I click on the tool tip$")
	public void i_click_on_the_tool_tip() throws Throwable {
		lpReportsPg.clickToolTip();

	}

	@Then("^I must see new BR page$")
	public void i_must_see_new_BR_page() throws Throwable {

	}

	@Then("^I should see tool tip in Search Results$")
	public void i_should_see_tool_tip_in_Search_Results() throws Throwable {

		assertTrue("Tooltip is not present", srchPg.isTooltipDisplayed());
	}

	@Then("^I should see tool tip in Recomended reading list$")
	public void i_should_see_tool_tip_in_Recomended_reading_list()
			throws Throwable {

	}

	@When("^I enter Reports search for Class \"(.*?)\"$")
	public void i_enter_Reports_search_for_Class(String arg1) throws Throwable {
		lpReportsPg.searchSmartbar(arg1);
	}

	@Then("^I must see class quiz activity Report$")
	public void i_must_see_class_quiz_activity_Report() throws Throwable {

		assertTrue("Class quiz activity not displayed",
				lpReportsPg.isClassQuizzActivityReportDisplayed());
	}

	@When("^I click the class quiz activity report$")
	public void i_click_the_class_quiz_activity_report() throws Throwable {

	}

	@Then("^I must see the following :$")
	public void i_must_see_the_following(DataTable arg1) throws Throwable {

	}

}
