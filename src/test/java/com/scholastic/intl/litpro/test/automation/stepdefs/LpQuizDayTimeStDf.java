package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;

import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg.SearchResultBook;
import com.scholastic.intl.litpro.test.automation.pageobjects.SettingsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBaseProvider;

public class LpQuizDayTimeStDf {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	LitProUserType lpUserType;
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome= new SlzHomePg(driver);
	LitProHomePg lpHome=new LitProHomePg(driver,lpUserType);
	SearchPg lpSearchPg= new SearchPg(driver,lpUserType);
	SettingsPg lpSettingsPg= new SettingsPg(driver, lpUserType);
	
	Scenario scenario;
	List<SearchResultBook> resultBooks;
	String searchKey = "";
	boolean isQuizzesOnlyEnabled = false;


//	 @Before
//	 public void before(Scenario scenario) {
//	 this.scenario = scenario;
//	 }
	//
	// public LpQuizDayTimeStDf(SharedDriver driver) {
	// this.driver = driver;
	// }

	@When("^I click Limit quiz access to certain days and times$")
	public void i_click_Limit_quiz_access_to_certain_days_and_times()
			throws Throwable {
		lpSettingsPg = new SettingsPg(driver, lpUserType);
		lpSettingsPg.enabletimerestictSetting();
	}

	@Then("^I should see the day and time controls$")
	public void i_should_see_the_day_and_time_controls() throws Throwable {
		assertTrue("Day Time controls not visible ",
				lpSettingsPg.verifydaytimecontrols());
	}

	@When("^I disable today as a permitted time to take a quiz$")
	public void i_disable_today_as_a_permitted_time_to_take_a_quiz()
			throws Throwable {
		lpSettingsPg.disabletodaySetting();
	}

	@When("^I disable now as a permitted time to take a quiz$")
	public void i_disable_now_as_a_permitted_time_to_take_a_quiz()
			throws Throwable {
		lpSettingsPg.disablenowSetting();
	}

	@When("^I enable now as a permitted time to take a quiz$")
	public void i_enable_now_as_a_permitted_time_to_take_a_quiz()
			throws Throwable {
		lpSettingsPg.enablenowSetting();
	}

	@Then("^I should see the available quizzes$")
	public void i_should_see_the_available_quizzes() throws Throwable {
		lpHome = new LitProHomePg(driver, lpUserType);
		assertTrue("Quizzes not visible ", lpHome.quizzes_visible());
	}

	@Then("^I should see the Take Quiz button is disabled$")
	public void i_should_see_the_Take_Quiz_button_is_disabled()
			throws Throwable {
		assertTrue("Quizzes enabled ", lpHome.quizzes_disabled());
	}

	@Then("^I should see the Take Quiz button is enabled$")
	public void i_should_see_the_Take_Quiz_button_is_enabled() throws Throwable {
		assertTrue("Quizzes enabled ", lpHome.quizzes_enabled());
	}

}
