package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;

import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.MyResultsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SettingsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBaseProvider;

public class LpStudentActivitiesStDf {
	WebDriver driver=TestBaseProvider.getTestBase().getDriver();
	private LitProUserType lpUserType;
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome= new SlzHomePg(driver);
	LitProHomePg lpHome= new LitProHomePg(driver,lpUserType);
	MyResultsPg lpResults= new MyResultsPg(driver, lpUserType);
	SettingsPg lpSettingsPg= new SettingsPg(driver, lpUserType);
	ReportsPg lpReportsPg= new ReportsPg(driver, lpUserType);
	

	
	Scenario scenario;

	// public LpStudentActivitiesStDf(SharedDriver driver) {
	// this.driver = driver;
	// }

//	@Before
//	public void before(Scenario scenario) {
//		this.scenario = scenario;
//	}

	@And("^I should see the expected row content for the Quiz$")
	public void i_should_see_the_expected_row_content_for_the_Quiz()
			throws Throwable {
		lpReportsPg = new ReportsPg(driver, lpUserType);
		assertTrue("", lpReportsPg.verifyquizrow());
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

}
