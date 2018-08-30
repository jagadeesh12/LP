package com.scholastic.intl.litpro.test.automation.stepdefs;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg.SearchResultBook;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LpAlertReportUIStDf {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	LitProUserType lpUserType;
	SlzLoginPg slzLogin = null;
	SlzHomePg slzHome;
	LitProHomePg lpHome;
	SearchPg lpSearchPg;
	ReportsPg lpReportsPg;
	Scenario scenario;
	List<SearchResultBook> resultBooks;
	String searchKey = "";
	boolean isQuizzesOnlyEnabled = false;

	

	@When("^I click the Alert Report link$")
	public void i_click_the_Alert_Report_link() throws Throwable {
		lpReportsPg = new ReportsPg(driver, lpUserType);
		// lpReportsPg.clickAlertReportLink();

	}

	@Then("^the Alert Report should display$")
	public void the_Alert_Report_should_display() throws Throwable {
		// assertTrue("Alert Report Header not showing",
		// lpReportsPg.getAlertHeader());
		/*
		 * assertTrue("Export Button",lpReportsPg.verifyexportbtn());
		 * assertTrue("Print Button",lpReportsPg.verifyprintbtn());
		 * assertTrue("Close button",lpReportsPg.verifyclosebtn());
		 * assertTrue("summary text",lpReportsPg.verifysummarytxt());
		 * assertTrue("Student Heading",lpReportsPg.verifystudenthd());
		 * assertTrue("Days Heading",lpReportsPg.verifydayshd());
		 * assertTrue("Attempts heading",lpReportsPg.verifyattemptshd());
		 * assertTrue("Low Score Heading",lpReportsPg.verifylowscorehd());
		 * assertTrue("Not Passed Heading",lpReportsPg.verifynotpassedhd());
		 * assertTrue("Passed Higher Lexile",lpReportsPg.verifypassedhigherhd())
		 * ;
		 * assertTrue("Selected below lexile",lpReportsPg.verifyselectlowerhd())
		 * ; assertTrue("Footer Text",lpReportsPg.verifyfooter());
		 */

		// assertTrue("",lpReportsPg.verify);
	}

}