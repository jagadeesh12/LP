package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;

import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg.SearchResultBook;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBaseProvider;

public class LpReportsStudentSearchStDf {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	LitProUserType lpUserType;
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	LitProHomePg lpHome = new LitProHomePg(driver,lpUserType) ;
	SearchPg lpSearchPg = new SearchPg(driver,lpUserType);
	ReportsPg lpReportsPg= new ReportsPg(driver, lpUserType);
	
	Scenario scenario;
	List<SearchResultBook> resultBooks;
	String searchKey = "";
	boolean isQuizzesOnlyEnabled = false;

//	 @Before
//	 public void before(Scenario scenario) {
//	 this.scenario = scenario;
//	 }
	//
	// public LpReportsStudentSearchStDf(SharedDriver driver) {
	// this.driver = driver;
	// }
	//

	@Then("^I should see Reports Page Page Header starting with \"(.*?)\"$")
	public void i_should_see_Reports_Page_Page_Header_starting_with(String arg1)
			throws Throwable {
		lpReportsPg = new ReportsPg(driver, lpUserType);
		System.out
				.println("got to I should see Reports Page Page Header starting with");
		String actual = lpReportsPg.getPageHeader();
		System.out.println(actual);
		assertTrue("Page Header text NOT matched. Expected starts with " + arg1
				+ " Actual: " + actual,
				actual.startsWith("Reports for " + arg1));
	}

	@When("^I enter invalid Reports search string \"(.*?)\"$")
	public void i_enter_invalid_Reports_search_string(String arg1)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("^Reports Error Message should be displayed$")
	public void reports_Error_Message_should_be_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("^Reports Too Short Error Message should be displayed$")
	public void reports_Too_Short_Error_Message_should_be_displayed()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

}
