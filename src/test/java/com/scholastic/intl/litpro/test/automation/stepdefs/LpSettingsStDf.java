package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.*;

import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.BooksObject;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.SettingsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBaseProvider;

public class LpSettingsStDf{
	LitProUserType lpUserType;
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	LitProHomePg lpHome = new LitProHomePg(driver,lpUserType);
	SettingsPg lpSettingsPg = new SettingsPg(driver, lpUserType);
	BasePage base = new BasePage(driver);
	ParentPage parent = new ParentPage(driver);

	Scenario scenario;
	BooksObject Searchtitle = new BooksObject();

	//
	// public LpSettingsStDf(SharedDriver driver) {
	// this.driver = driver;
	// }

//	 @Before
//	 public void before(Scenario scenario) {
//	 this.scenario = scenario;
//	 }

	@Given("^I browse to Settings Page as \"(.*?)\"$")
	public void i_browse_to_Setting_Page_as(String userType) {
		slzLogin = new SlzLoginPg(driver);
		// assertTrue("Failed to Launch AUT due to missing info. Check the log.",
		// slzLogin.launchSlz());
		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);
//		slzHome = slzLogin.loginAs(lpUserType);

//
//		lpHome = slzHome.launchLitPro(lpUserType);
		
		base = new BasePage(driver);
		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		lpSettingsPg = lpHome.goToSettingPage();

	}

@Given("^I launch Litpro and browse to Settings Page using \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$")
public void i_launch_Litpro_and_browse_to_Settings_Page_using_and_with(String username, String password, String userType) throws Throwable {

	slzLogin = new SlzLoginPg(driver);

	LitProUserType lpUserType = slzLogin.getLitProUserType(userType);

	base.loginApp(username, password);
		base.launchApp(lpUserType);

	assertNotNull("Could NOT launch litpro. Check log", lpHome);
	Thread.sleep(5000);
	lpSettingsPg = lpHome.goToSettingPage();
}


	@Then("^I should see class name$")
	public void i_should_see_same_School_name_that_is_displayed_in_toolbar()
			throws Throwable {
		assertTrue("The Page Header is empty ", !lpSettingsPg.getPageHeader()
				.trim().isEmpty());
	}

	@Then("^I should verify tooltips for setting Limit reading list titles to only those in the school library \"([^\"]*)\"$")
    public void i_should_verify_tooltips_for_setting_limit_reading_list_titles_to_only_those_in_the_school_library_something(String tooltip) throws Throwable {
		String actual = lpSettingsPg.tooltip();
		String expected = tooltip;
		assertTrue("The tool tip which was expected :" + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}
	
	@Then("^I should verify tooltips for setting Allow students to search outside educational level \"([^\"]*)\"$")
    public void i_should_verify_tooltips_for_setting_allow_students_to_search_outside_educational_level_something(String tooltip) throws Throwable {
		String actual = lpSettingsPg.tooltipEducation();
		String expected = tooltip;
		assertTrue("The tool tip which was expected : " + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}
	
	@Then("^I should verify tooltips for setting Awards are based on \"([^\"]*)\"$")
    public void i_should_verify_tooltips_for_setting_awards_are_based_on_something(String tooltip) throws Throwable {
		String actual = lpSettingsPg.tooltipAwards();
		String expected = tooltip;
		assertTrue("The tool tip which was expected : " + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}
	
	@Then("^I should see following settings under LitPro Test Settings:$")
	public void i_should_see_following_settings_under_LitPro_Test_Settings(
			List<Map<String, String>> input) throws Throwable {
		Iterator<Map<String, String>> inIterator = input.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();
			System.out.println(row);
			assertTrue("Test Setting '" + row.get("Setting Name")
					+ "' NOT displayed ",
					lpSettingsPg.isSettingExist(row.get("Setting Name")));
			assertTrue(
					"Test Setting '" + row.get("Setting Name")
							+ "' NOT enabled ",
					lpSettingsPg.isSettingEnabledExpected(
							row.get("Setting Name"), row.get("Enabled")));
			assertTrue("Test Setting '" + row.get("Setting Name")
					+ "' does NOT match expected value ",
					lpSettingsPg.isSettingExpectedValue(
							row.get("Setting Name"), row.get("Default Value")));
		}
		// System.out.println("End of i_should_see_following_settings_under_LitPro_Test_Settings");
	}

	@Then("^I should see following settings under Book Quiz Settings:$")
	public void i_should_see_following_settings_under_Book_Quiz_Settings(
			List<Map<String, String>> input) throws Throwable {
		Thread.sleep(5000);
		Iterator<Map<String, String>> inIterator = input.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();
			System.out.println(row);
			assertTrue("Quiz Setting '" + row.get("Setting Name")
					+ "' NOT displayed ",
					lpSettingsPg.isSettingExist(row.get("Setting Name")));
			assertTrue(
					"Quiz Setting '" + row.get("Setting Name")
							+ "' NOT enabled ",
					lpSettingsPg.isSettingEnabledExpected(
							row.get("Setting Name"), row.get("Enabled")));
			assertTrue("Test Setting '" + row.get("Setting Name")
					+ "' does NOT match expected value ",
					lpSettingsPg.isSettingExpectedValue(
							row.get("Setting Name"), row.get("Default Value")));
		}
		// System.out.println("End of i_should_see_following_settings_under_Book_Quiz_Settings");
	}

	@When("^I change following Test settings:$")
	public void i_change_following_Test_settings(List<Map<String, String>> input) throws InterruptedException {
		Iterator<Map<String, String>> inIterator = input.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();

			// enable disable based on Action
			if (row.get("Action").equalsIgnoreCase("Check")) {
				lpSettingsPg.enableSetting(row.get("Setting Name"));
			} else if (row.get("Action").equalsIgnoreCase("Uncheck")) {
				lpSettingsPg.disableSetting(row.get("Setting Name"));
			}

			// change the value
			if (!row.get("New Value").equalsIgnoreCase("NA")) {
				lpSettingsPg.setSettingValue(row.get("Setting Name"),
						row.get("New Value"));
			}
		}
	}

	@When("^I change following Quiz settings:$")
	public void i_change_following_Quiz_settings(List<Map<String, String>> input) throws InterruptedException {
		Iterator<Map<String, String>> inIterator = input.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();
			// enable disable based on Action
			if (row.get("Action").equalsIgnoreCase("Check")) {
				lpSettingsPg.enableSetting(row.get("Setting Name"));
			} else if (row.get("Action").equalsIgnoreCase("Uncheck")) {
				lpSettingsPg.disableSetting(row.get("Setting Name"));
			}
			// change the value
			if (!row.get("New Value").equalsIgnoreCase("NA")) {
				lpSettingsPg.setSettingValue(row.get("Setting Name"),
						row.get("New Value"));
			}
		}
	}

	@When("^I click Save$")
	public void i_click_Save() throws Throwable {
		lpSettingsPg.saveSettings();
	}

	@Then("^'Settings Saved' Message should be displayed$")
	public void settings_Saved_Message_should_be_displayed() {
		String actual = lpSettingsPg.getSaveNotification();
		String expected = "Settings Saved";
		assertTrue("Setting saved message NOT matched. Expected: " + expected
				+ ", Actual:" + actual, actual.equals(expected));
	}
	@When("^I logout$")
	public void i_logout() throws Throwable {
	   lpSettingsPg.clickLogout();
	   parent.switchToNewWindow();
	   lpSettingsPg.clickLogout();
	}
	@Then("^I should see Awards Based set to \"(.*?)\"$")
	public void i_should_see_Awards_Based_set_to(String awardsbased)
			throws Throwable {
		String actual = lpSettingsPg.getAwardsBased();
		assertTrue("Awards Based text NOT matched. Expected " + awardsbased
				+ " Actual: " + actual, actual.equals(awardsbased));
	}

	@And("^I should see the following settings for awards$")
	public void i_should_see_the_following_settings_for_awards(
			List<Map<String, String>> input) throws Throwable {
		Iterator<Map<String, String>> inIterator = input.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();
			// System.out.println(row);
			String awardName = row.get("Award Name");
			String awardValue = row.get("Value");
			assertTrue("Awards NOT matched. Expected " + awardName + " "
					+ awardValue,
					lpSettingsPg.verifyAwards(awardName, awardValue));
		}
	}

	@Then("^I should see the following settings for books awards$")
	public void i_should_see_the_following_settings_for_books_awards(
			List<Map<String, String>> input) throws Throwable {
		Iterator<Map<String, String>> inIterator = input.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();
			// System.out.println(row);
			String awardName = row.get("Award Name");
			String awardValue = row.get("Value");
			assertTrue("Awards NOT matched. Expected " + awardName + " "
					+ awardValue,
					lpSettingsPg.verifybookAwards(awardName, awardValue));
		}
	}

	@Then("^I should see Settings Page Page Header starting with \"(.*?)\"$")
	public void i_should_see_Settings_Page_Page_Header_starting_with(String arg1)
			throws Throwable {
		String actual = lpSettingsPg.getPageHeader();
		assertTrue("Page Header text NOT matched. Expected starts with " + arg1
				+ " Actual: " + actual, actual.startsWith(arg1));
	}

	@When("^I enter Settings search string \"(.*?)\"$")
	public void i_enter_Settings_search_string(String searchString)
			throws Throwable {
		lpSettingsPg.searchSmartbar(searchString);
		Thread.sleep(3000);
	}

	@When("^I enter invalid Settings search string \"(.*?)\"$")
	public void i_enter_invalid_Settings_search_string(String searchString)
			throws Throwable {
		lpSettingsPg.searchError(searchString);
	}

	// adding below for restore default settings
	@When("^I change all of the default settings$")
	public void i_change_all_default_settings() throws Throwable {
		lpSettingsPg.changeallSettings();
		// System.out.println("End of i_change_all_default_settings" );
	}

	@When("^I click the Restore Defaults button$")
	public void i_click_the_Restore_Defaults_button() throws Throwable {
		lpSettingsPg.restoreDefaults();
		// System.out.println("End of i_click_the_Restore_Defaults_button" );

	}

	@Then("^Settings Restored Message should be displayed$")
	public void settings_Restored_Message_should_be_displayed()
			throws InterruptedException {
		// System.out.println("start of settings_Restored_Message_should_be_displayed");
		String actual = lpSettingsPg.getRestoreNotification();
		String expected = "Settings Restored";
		assertTrue("Setting Restored message NOT matched. Expected: "
				+ expected + ", Actual:" + actual, actual.equals(expected));
		// System.out.println("end of settings_Restored_Message_should_be_displayed");
		Thread.sleep(10000);
	}

	@When("^I click the Settings page Save button$")
	public void i_click_the_Settings_page_Save_button() throws Throwable {
		lpSettingsPg.saveSettings();
	}

	@When("^I click on the school in the smartbar$")
	public void i_click_on_the_school_in_the_smartbar() throws Throwable {
		lpSettingsPg.clickSchool();
	}

	@Then("^I should see that there is no Restore Defaults button$")
	public void i_should_see_that_there_is_no_Restore_Defaults_button()
			throws Throwable {
		lpSettingsPg.restoredefaultsButton_not_visible();
		assertTrue("Restore Defaults button is visible on Class page ",
				lpSettingsPg.restoredefaultsButton_not_visible());
		// throw new PendingException();
	}

	@When("^I change settings on the Class page$")
	public void i_change_settings_on_class_page() throws InterruptedException {
		lpSettingsPg.change_class_settings();
	}

	@When("^I change settings on the Student page$")
	public void i_change_settings_on_student_page() throws InterruptedException {
		lpSettingsPg.change_class_settings();
	}

	@Then("^Settings Error Message should be displayed$")
	public void settings_Error_Message_should_be_displayed() throws Throwable {
		String actual = lpSettingsPg.getErrorMessage();
		System.out.println("Actual = " + actual);
		String expected = "No results containing your search terms were found.";

		assertTrue("Setting Error message NOT matched. Expected: " + expected
				+ ", Actual:" + actual, actual.equals(expected));
		// System.out.println("end of settings_Restored_Message_should_be_displayed");
		Thread.sleep(3000);
		// throw new PendingException();
	}

	@Then("^Settings Too Short Error Message should be displayed$")
	public void settings_Too_Short_Error_Message_should_be_displayed()
			throws Throwable {
		String actual = lpSettingsPg.getTooShortErrorMessage();
		System.out.println("Actual = " + actual);
		String expected = "Search term must be at least 3 characters";
		assertTrue("Setting Too Short Error message NOT matched. Expected: "
				+ expected + ", Actual:" + actual, actual.equals(expected));
		Thread.sleep(3000);
	}

	@When("^I enable teacher points option$")
	public void i_enable_teacher_points_option() throws Throwable {
		Thread.sleep(5000);
		System.out.println("Enable teacher points option");
		assertTrue("Can't enable Teacher Points option",
				lpSettingsPg.enableteacherpts());
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------------
	//

	// 33333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333

	@When("^I check the setting Limit reading list titles to only those in the school library$")
	public void Limit_reading_list_Inlib_settings_check()
			throws InterruptedException {
		lpSettingsPg.Limit_reading_list_Inlib_settings_checked();
		lpSettingsPg.Limit_reading_list_books_settings_unchecked();
		lpSettingsPg.uncheck_see_reading_list();
	}

	@When("^I check the setting Allow students to change reading interests$")
	public void Change_ReadingInterest_settings_check()
			throws InterruptedException {
		lpSettingsPg.ChangeReadingInterestSettingsCheck();
	}

	@When("^I Uncheck the setting Display incorrect answers$")
	public void Display_incorrect_answers_uncheck() throws InterruptedException {
		lpSettingsPg.IncorrectAnswerUnCheck();
		lpSettingsPg.QuizAttempts("99");
	}

	@When("^I set the setting Restrict number of quiz attempts to \"(.*?)\"$")
	public void Display_incorrect_answers_uncheck(String days)
			throws InterruptedException {
		lpSettingsPg.QuizAttempts(days);
	}

	@When("^I check the setting Allow student to print$")
	public void Allow_print_check() {
		lpSettingsPg.AllowPrintCheck();
	}

	@When("^I set the setting Quiz pass mark: attempts to \"(.*?)\"$")
	public void Quiz_pass_Mark_Quiz(String marks) throws InterruptedException {
		lpSettingsPg.QuizAttempts("99");
		lpSettingsPg.QuizPassMarks(marks);
	}

	@And("^I should set the following settings for awards$")
	public void i_should_set_the_following_settings_for_awards(
			List<Map<String, String>> input) throws Throwable {
		lpSettingsPg.AwardsQuizzesPassed();
		Iterator<Map<String, String>> inIterator = input.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();
			// System.out.println(row);
			String awardName = row.get("Award Name");
			String awardValue = row.get("Value");
			lpSettingsPg.setAwards(awardName, awardValue);
		}
	}

	@When("^I set the setting Allow students to search outside educational level to$")
	public void Setting_education_level(List<Map<String, String>> input)
			throws Throwable {
		lpSettingsPg.educationLevelMaincheckbox();
		//lpSettingsPg.educationLeveluncheckbox();
		Iterator<Map<String, String>> inIterator = input.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();
			// System.out.println(row);
			String Educational_Level = row.get("Educational Level");
			String checked = row.get("Value");
			lpSettingsPg.educationLevel(Educational_Level, checked);
		}
	}

	@When("^I should go to search tab$")
	public void click_SearchTab() {
		lpSettingsPg.Searchtab();
	}

	@When("^I should search as a teacher for book \"(.*?)\"$")
	public void SearchBook(String title) {
		lpSettingsPg.Searchkey(title);
	}

	@Then("^I should select Educational Levels in search$")
	public void SearchEducationLevel(List<Map<String, String>> input)
			throws Throwable {
		Iterator<Map<String, String>> inIterator = input.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();
			String searchEducational_Level = row
					.get("Search Educational Level");
			String Searchchecked = row.get("Search Value");
			lpSettingsPg.SearchEducationLevel(searchEducational_Level,
					Searchchecked);
		}
		lpSettingsPg.SearchButton();
		reportLog("Clicked on Search button");
		reportLog("Coolecting list of all the titles shown in teacher search");
		lpSettingsPg.CollectData();
		reportLog("Logging out as teacher");
	}

	@When("^I navigate to settings page$")
	public void i_navigate_to_settings_page() throws Throwable {
    lpHome.goToSettingPage();
	}
	
	@Then("^there will an option to set the classroom/school for GR or lexile$")
	public void there_will_an_option_to_set_the_classroom_school_for_GR_or_lexile() throws Throwable {
	   lpSettingsPg.verifyGRLLxlLevelingSystem();
	}

	public void reportLog(String string) {
		// TODO Auto-generated method stub

	}
	@Then("^I should validate time zone$")
	public void i_should_validate_time_zone() throws Throwable {
	   
	}
	@Then("^I should validate time zone of LitPro Test Settings$")
	public void i_should_validate_time_zone_of_LitPro_Test_Settings() throws Throwable {
	    
	}

	@Then("^I should validate time zone of LitPro Quiz Settings$")
	public void i_should_validate_time_zone_of_LitPro_Quiz_Settings() throws Throwable {
	    
	}

	@Given("^I browse to Litpro as 'CSRep'$")
	public void i_browse_to_Litpro_as_CSRep() throws Throwable {
	   
	}

	@Then("^I should see the schoolname in roster tree$")
	public void i_should_see_the_schoolname_in_roster_tree() throws Throwable {
	   
	}

	@Then("^I should verify that student should not get loaded$")
	public void i_should_verify_that_student_should_not_get_loaded() throws Throwable {
	    
	}

	@When("^I should click on class name in roster tree which has student$")
	public void i_should_click_on_class_name_in_roster_tree_which_has_student() throws Throwable {
	    
	}

	@Then("^I should verify that student should get loaded$")
	public void i_should_verify_that_student_should_get_loaded() throws Throwable {
	    
	}

	@Then("^I should Click on report page$")
	public void i_should_Click_on_report_page() throws Throwable {
	   
	}

	@Then("^I should verify that student should not get loaded for teacher$")
	public void i_should_verify_that_student_should_not_get_loaded_for_teacher() throws Throwable {
	    
	}

	@When("^I should click on class name of teacher in roster tree which has student$")
	public void i_should_click_on_class_name_of_teacher_in_roster_tree_which_has_student() throws Throwable {
	    
	}

	@Then("^I should verify that student should get loaded for teacher$")
	public void i_should_verify_that_student_should_get_loaded_for_teacher() throws Throwable {
	   
	}

	@Then("^\"([^\"]*)\" modal should display following buttons on the header$")
	public void modal_should_display_following_buttons_on_the_header(String arg1, DataTable arg2) throws Throwable {
	    
	}

	@Given("^I browse to Home page as \"([^\"]*)\"$")
	public void i_browse_to_Home_page_as(String arg1) throws Throwable {
	   
	}
	@Then("^I shoud see students in roster tree must be sorted by lastname$")
	public void i_shoud_see_students_in_roster_tree_must_be_sorted_by_lastname() throws Throwable {
		lpSettingsPg.clickOnSchoolRosterAndVerifySorting();
	}


}
