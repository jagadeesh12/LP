package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gherkin.deps.com.google.gson.Gson;

import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.torque.common.WaitUtils;

@SuppressWarnings("deprecation")
public class LpReportsStDf {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	LitProUserType lpUserType;
	SlzHomePg slzHome = new SlzHomePg(driver);
	LitProHomePg lpHome = new LitProHomePg(driver, lpUserType);
	Scenario scenario;
	ReportsPg lpReportsPg = new ReportsPg(driver, lpUserType);
	String reportName = null;
	BasePage base = new BasePage(driver);
	String lexile;

	@Given("^I browse to 'Reports' page as an \"(.*?)\"$")
	public void i_browse_to_Reports_page_as_an(String userType) throws Throwable {
		slzLogin = new SlzLoginPg(driver);
		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);

		// lpHome = slzHome.launchLitPro(lpUserType);
		base = new BasePage(driver);
		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		lpReportsPg = lpHome.goToReportsPage();
	}

	/*
	 * @Given("^I browse to Home page as \"([^\"]*)\"$") public void
	 * i_browse_to_home_page_as_something(String userType) throws Throwable {
	 * slzLogin = new SlzLoginPg(driver);
	 * 
	 * // lpHome = slzHome.launchLitPro(lpUserType); base = new
	 * BasePage(driver); base.launchPortal(lpUserType);
	 * base.launchApp(lpUserType); assertNotNull(
	 * "Could NOT launch litpro. Check log", lpHome); }
	 */
	@Given("^I launch Litpro and browse to 'Reports' page using \"([^\"]*)\" and \"([^\"]*)\" with with \"([^\"]*)\"$")
	public void i_launch_Litpro_and_browse_to_Reports_page_using_and_with_with(String username, String password,
			String userType) throws Throwable {
		slzLogin = new SlzLoginPg(driver);

		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);

		base.loginApp(username, password);
		base.launchApp(lpUserType);

		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		Thread.sleep(5000);
		lpReportsPg = lpHome.goToReportsPage();
	}

	@Then("^I should see Reports page header with text \"(.*?)\"$")
	public void i_should_see_Reports_page_header_with_text(String expected) throws Throwable {
		String actual = lpReportsPg.getHeaderText();
		assertTrue("The expected Page Header was '" + expected + "' but actually was: " + actual,
				actual.contains(expected));
	}

	@Then("^I should see report card name \"(.*?)\"$")
	public void i_should_see_report_card_name(String repName) throws Throwable {
		reportName = repName;
		assertTrue("'" + reportName + "' Report link is NOT displayed ", lpReportsPg.isReportDisplayed(reportName));
	}

	@When("^I click on View Report button$")
	public void i_click_on_View_Report_button() throws Throwable {
		String expected = "There is no data for this report for the selected year";
		lpReportsPg.openReport(reportName);
		String notification = lpReportsPg.getNotificationText();

		if (StringUtils.containsIgnoreCase(notification, expected)) {
			System.out.println("'" + notification + "' notification displayed");
			// scenario.write("'" + notification + "' notification displayed");
		} else if (StringUtils.containsIgnoreCase(notification, "Error")
				|| StringUtils.containsIgnoreCase(notification, "Exception")) {
			assertTrue("Error/Exception occured. " + notification, false);
		}
	}

	@Then("^I see the report card on a modal with header \"(.*?)\"$")
	public void i_see_the_report_card_on_a_modal_with_header(String repHeader) throws Throwable {
		String expected = repHeader;
		String actual = lpReportsPg.getReportModalHeaderText();
		if (actual != "NULL") {
			assertTrue("The expected Header was '" + expected + "' but actually was: " + actual,
					expected.equals(actual));
		}
	}

	@Then("^the report modal description should read 'This report shows the percentage or number of students in each proficiency band\\.'$")
	public void the_report_modal_description_should_read_This_report_shows_the_percentage_or_number_of_students_in_each_proficiency_band()
			throws Throwable {
		String expected = "This report shows the percentage or number of students in each proficiency band.";
		String actual = lpReportsPg.getReportModalDescriptionText();
		if (actual != "NULL") {
			assertTrue("The expected Header was '" + expected + "' but actually was: " + actual,
					expected.equals(actual));
		}

	}

	@Then("^the report modal footer should read '\\*Imported data may affect averages across reports\\. For more information, click here\\.'$")
	public void the_report_modal_footer_should_read_Imported_data_may_affect_averages_across_reports_For_more_information_click_here()
			throws Throwable {
		lpReportsPg.getReportModalFooterText();
	}

	@And("modal should display following buttons on the header$")
	public void Reading_Proficiency_Report_modal_should_display_following_buttons_on_the_header(List<String> uiElements)
			throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("'" + repName + "' Report link NOT displayed ",
					lpReportsPg.isReportHeaderButtonsDisplayed(repName));
		}
	}

	@Then("^Reading Proficiency Report modal should display following reports$")
	public void Reading_Proficiency_Report_modal_should_display_following_reports(List<String> repElements)
			throws Throwable {
		Iterator<String> uieleIterator = repElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("'" + repName + "' Report link NOT displayed ", lpReportsPg.isReportCatsDisplayed(repName));
		}
	}

	@When("^I click on 'School Calendar' dropdown$")
	public void i_click_on_School_Calendar_dropdown() throws Throwable {
		lpReportsPg.clickSchoolYearsDropDown();
	}

	@Then("^I should see list of school year options$")
	public void i_should_see_list_of_school_year_options() throws Throwable {
		List<String> displayedSchoolYears = lpReportsPg.getSchoolYearsList();
		if (displayedSchoolYears.isEmpty()) {
			System.out.println("There are no school years to be displayed");
			// scenario.write("There are no school years to be displayed");
		}
	}

	@When("^I click on bar 'graph' button$")
	public void i_click_on_bar_graph_button() throws Throwable {
		lpReportsPg.isReportGroupDisplayed("graph");
	}

	@When("^I click on 'table' button$")
	public void i_click_on_table_button() throws Throwable {
		lpReportsPg.isReportGroupDisplayed("table");
	}

	@When("^I click on 'close' button$")
	public void i_click_on_close_button() throws Throwable {
		lpReportsPg.closeReport();
	}

	@Then("^Book Comprehension Report modal should display following buttons on the header$")
	public void book_Comprehension_Report_modal_should_display_following_buttons_on_the_header(List<String> uiElements)
			throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("'" + repName + "' Report link NOT displayed ",
					lpReportsPg.isReportHeaderButtonsDisplayed(repName));
		}
	}

	@Then("^Book Comprehension Report modal should display following reports$")
	public void book_Comprehension_Report_modal_should_display_following_reports(List<String> repElements)
			throws Throwable {
		Iterator<String> uieleIterator = repElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("'" + repName + "' Report link NOT displayed ", lpReportsPg.isReportCatsDisplayed(repName));
		}
	}

	@Then("^Quiz Pass Rate Report modal should display following buttons on the header$")
	public void quiz_Pass_Rate_Report_modal_should_display_following_buttons_on_the_header(List<String> uiElements)
			throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("'" + repName + "' Report link NOT displayed ",
					lpReportsPg.isReportHeaderButtonsDisplayed(repName));
		}
	}

	@Then("^Quiz Pass Rate Report modal should display following reports$")
	public void quiz_Pass_Rate_Report_modal_should_display_following_reports(List<String> repElements)
			throws Throwable {
		Iterator<String> uieleIterator = repElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("'" + repName + "' Report link NOT displayed ", lpReportsPg.isReportCatsDisplayed(repName));
		}
	}

	@When("^they navigate to the Reports tab$")
	public void they_navigate_to_the_Reports_tab() throws Throwable {
		lpHome.goToReportsPage();

	}

	@Then("^the \\[enter student data\\] button is disabled$")
	public void the_enter_student_data_button_is_disabled() throws Throwable {
		WaitUtils.waitForDisplayed(lpReportsPg.getStudentDataButton());
		Assert.assertFalse(lpReportsPg.getStudentDataButton().isEnabled());
	}

	@Then("^the Enter Student Scores button will be enabled when the teacher clicks on a class with students in the My Students selector \"([^\"]*)\"$")
	public void the_Enter_Student_Scores_button_will_be_enabled_when_the_teacher_clicks_on_a_class_with_students_in_the_My_Students_selector(
			String className) throws Throwable {
		lpReportsPg.clickOnClassName(className);
		WaitUtils.waitForDisplayed(lpReportsPg.getStudentDataButton());
		Assert.assertTrue(lpReportsPg.getStudentDataButton().isEnabled());
	}

	@Then("^disabled when she clicks on class with no students in the My Students selector \"([^\"]*)\"$")
	public void disabled_when_she_clicks_on_class_with_no_students_in_the_My_Students_selector(String className)
			throws Throwable {
		lpReportsPg.clickOnClassName(className);
		WaitUtils.waitForDisplayed(lpReportsPg.getStudentDataButton());
		Assert.assertTrue(!lpReportsPg.getStudentDataButton().isEnabled());
	}

	@When("^opens the modal \"([^\"]*)\"$")
	public void opens_the_modal(String className) throws Throwable {
		lpReportsPg.clickOnClassName(className);
		WaitUtils.waitForDisplayed(lpReportsPg.getStudentDataButton());
		lpReportsPg.getStudentDataButton().click();
		WaitUtils.waitForDisplayed(lpReportsPg.enterStudentDataModal());
		Assert.assertTrue(lpReportsPg.enterStudentDataModal().isDisplayed());
	}

	@When("^they select a student in the my students selector \"([^\"]*)\" \"([^\"]*)\"$")
	public void they_select_a_student_in_the_my_students_selector(String studentname, String classname)
			throws Throwable {
		lpReportsPg.selectStudentFromClass(studentname, classname);
	}

	@When("^they select a class with has students \"([^\"]*)\"$")
	public void they_select_a_class_with_has_students(String classname) throws Throwable {
		lpReportsPg.selectClass(classname);
	}

	@Then("^the enter student data button is enabled$")
	public void the_enter_student_data_button_is_enabled() throws Throwable {
		Assert.assertTrue(lpReportsPg.getStudentDataButton().isEnabled());
		Thread.sleep(2000);

	}

	@Then("^each student with no previous RP score in the currently selected class is visible \"([^\"]*)\"$")
	public void each_student_with_no_previous_RP_score_in_the_currently_selected_class_is_visible(String studentName)
			throws Throwable {

		List<String> studentNames = new Gson().fromJson(studentName, List.class);
		List<String> actual = lpReportsPg.getStudentNamesFromTheDataModal();
		Assert.assertTrue(studentNames.containsAll(actual) && actual.containsAll(studentNames));

	}

	@Then("^there is a student in the class with previous RP score , he is not included in the modal because there is no need to enter the info\\. \"([^\"]*)\"$")
	public void there_is_a_student_in_the_class_with_previous_RP_score_he_is_not_included_in_the_modal_because_there_is_no_need_to_enter_the_info(
			String studentName) throws Throwable {
		Assert.assertFalse(lpReportsPg.getStudentNamesFromTheDataModal().contains(studentName));
	}

	@When("^all students in the class have Reading Pro scores from any time in the past,modal will not open \"([^\"]*)\"$")
	public void all_students_in_the_class_have_Reading_Pro_scores_from_any_time_in_the_past_modal_will_not_open(
			String arg1) throws Throwable {

	}

	@When("^an error message will be shown with the text \"([^\"]*)\"$")
	public void an_error_message_will_be_shown_with_the_text(String arg1) throws Throwable {

	}

	@Given("^changes the Teacher Judgment value for a student \"([^\"]*)\"$")
	public void changes_the_Teacher_Judgment_value_for_a_student(String studentname) throws Throwable {
		lpReportsPg.changeTeacherJudgement(studentname);
	}

	@When("^the teacher hits Save button$")
	public void the_teacher_hits_Save_button() throws Throwable {
		lpReportsPg.clickSave();
	}

	@Then("^the data will be saved$")
	public void the_data_will_be_saved() throws Throwable {

	}

	@Then("^I should validated and select the school year for which the data was uplaoded$")
    public void i_should_validated_and_select_the_school_year_for_which_the_data_was_uplaoded() throws Throwable {
		Assert.assertTrue("school calender year is not correct",lpReportsPg.VerifyschoolCalnderYer());
	}
	
	@When("^a student does not have a Reading Pro Lexile from any time/year in the past is displayed in the modal \"([^\"]*)\"$")
	public void a_student_does_not_have_a_Reading_Pro_Lexile_from_any_time_year_in_the_past_is_displayed_in_the_modal(
			String studentname) throws Throwable {
		lpReportsPg.verifyStudentOnTheModal(studentname);
	}

	@Then("^the no RP score will be displayed And the At Grade Level value under Teacher Judgment will be selected by default$")
	public void the_no_RP_score_will_be_displayed_And_the_At_Grade_Level_value_under_Teacher_Judgment_will_be_selected_by_default()
			throws Throwable {

	}

	@Given("^a student does not have a Reading Pro Lexile from any time in the past,doesnot have a prior assessment score and teacher saved a teacher judgement value in the past\\.$")
	public void a_student_does_not_have_a_Reading_Pro_Lexile_from_any_time_in_the_past_doesnot_have_a_prior_assessment_score_and_teacher_saved_a_teacher_judgement_value_in_the_past()
			throws Throwable {

	}

	@When("^that modal opens$")
	public void that_modal_opens() throws Throwable {
		Assert.assertTrue(lpReportsPg.enterStudentDataModal().isDisplayed());
	}

	@Then("^the no RP score will be displayed \"([^\"]*)\"$")
	public void the_no_RP_score_will_be_displayed(String studentName) throws Throwable {
		String expected = "";
		Assert.assertEquals(expected, lpReportsPg.getRPScoreForAStudent(studentName));
	}

	@Then("^Teacher Judgment = previously saved value \"([^\"]*)\" \"([^\"]*)\"$")
	public void teacher_Judgment_previously_saved_value(String previoussavedvalue, String studentname)
			throws Throwable {
		Assert.assertTrue(lpReportsPg.getTeacherJudgementValue(studentname).equalsIgnoreCase(previoussavedvalue));
	}

	@Then("^students are sorted alphabetically by last name$")
	public void students_are_sorted_alphabetically_by_last_name() throws Throwable {

	}

	// ####################################################################################################
	@When("^I search for the class \"([^\"]*)\"$")
	public void i_search_for_the_class_something(String ClassName) throws Throwable {
		lpReportsPg.searchSmartbar(ClassName);
	}

	@When("^I Click on View Reprot button of \"([^\"]*)\"$")
	public void i_click_on_view_reprot_button_of_something(String ReportsName) throws Throwable {
		lpReportsPg.ClickviewReprotButton(ReportsName);
	}

	@Then("^I should see then report header as \"([^\"]*)\"$")
	public void i_should_see_then_report_header_as_something(String ReprotLabel) throws Throwable {
		assertTrue("Correct report is not opened " + ReprotLabel, lpReportsPg.RerpotLabel().equals(ReprotLabel));
	}
	
	@And("^I should see an asterisk with message \"([^\"]*)\"$")
    public void i_should_see_an_asterisk_with_message_something(String Actual) throws Throwable {
		String expected = lpReportsPg.message();
		assertTrue("Correct message is not displayed Expected: " + expected+ " Actual :" + expected, expected.equals(Actual));
	}

	@When("^I select grade from the grade dropdown$")
	public void i_select_grade_something_for_the_grade_dropdown() throws Throwable {
		lpReportsPg.GradeDropDown();
	}

	@When("^I go to \"([^\"]*)\" for school level reprot validation.$")
	public void i_go_to_something_for_school_level_reprot_validation(String SchoolName) throws Throwable {
		lpReportsPg.SchoolLevelReport(SchoolName);
	}

	@Then("^I should validate the reports data of Reading Proficiency Report for \"([^\"]*)\" class level for Student$")
	public void i_should_validate_the_reports_data_of_reading_proficiency_report_for_something_class_level_for_student(
			String ClassName) throws Throwable {
		if (ClassName != null) {
			lpReportsPg.Reading_Proficiency_Report_class(ClassName);
		} else {
			assertTrue("Please enter the class name", false);
		}
	}

	@Then("^I should validate the reports data of Reading Proficiency Report at Grade \"([^\"]*)\" level for Student$")
	public void i_should_validate_the_reports_data_of_reading_proficiency_report_at_grade_something_level_for_student() throws Throwable {
			lpReportsPg.Reading_Proficiency_Report_Grade();
	}

	@Then("^I should validate the reports data of Reading Proficiency Report at school level for Student$")
	public void i_should_validate_the_reports_data_of_reading_proficiency_report_at_school_level_for_student()
			throws Throwable {
		lpReportsPg.Reading_Proficiency_Report_School();
	}
	
	@Then("^I should validate the reports data of historical Reading Proficiency Report at school level$")
    public void i_should_validate_the_reports_data_of_historical_reading_proficiency_report_at_school_level() throws Throwable {
		lpReportsPg.Historical_Reading_Proficiency_Report_School();
	}

	@Then("^I should validate the reports data of Lexile Compared to Norm Report at Grade level for Student$")
	public void i_should_validate_the_reports_data_of_lexile_compared_to_norm_report_at_something_level_for_student() throws Throwable {
		lpReportsPg.Lexile_Compared_Norm_Report_Grade();
	}

	@Then("^I should validate the reports data of Lexile Compared to Norm Report for \"([^\"]*)\" class level for Student$")
	public void i_should_validate_the_reports_data_of_lexile_compared_to_norm_report_for_something_class_level_for_student(
			String ClassName) throws Throwable {
		if (ClassName != null) {
			assertTrue("RErpots data is not mataching ", lpReportsPg.Lexile_Compared_Norm_Report_class(ClassName));
		} else {
			assertTrue("Please enter the class name", false);
		}
	}

	@Then("^I should validate the reports data of Class Quiz Activity Report for \"([^\"]*)\" class level for Student$")
	public void i_should_validate_the_reports_data_of_class_quiz_activity_report_for_something_class_level_for_student(
			String ClassName) throws Throwable {
		if (ClassName != null) {
			assertTrue("RErpots data is not mataching ", lpReportsPg.Class_Quiz_Activity_Report_class(ClassName));
		} else {
			assertTrue("Please enter the class name", false);
		}
	}

	@Then("^I should validate the reports data of Lexile Compared to Norm Report at school level for Student$")
	public void i_should_validate_the_reports_data_of_lexile_compared_to_norm_report_at_school_level_for_student()
			throws Throwable {
		lpReportsPg.Lexile_Compared_Norm_Report_school();
	}
	
	@Then("^I should validate the reports data of historical Lexile Compared to Norm Report at school level$")
    public void i_should_validate_the_reports_data_of_historical_lexile_compared_to_norm_report_at_school_level() throws Throwable {
    	lpReportsPg.Historical_Lexile_Compared_Norm_Report_school();
    }

	@Then("^I should collect the data of all students$")
	public void i_should_collect_the_data_of_all_students_delete(List<String> uiElements) throws Throwable {

		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			lpReportsPg.getStudentNameLabel(repName);
		}
	}

	@Then("^I should validate the reports data of Quiz Pass Rate Report for \"([^\"]*)\" class level for Student$")
	public void i_should_validate_the_reports_data_of_book_comprehension_report_for_something_class_level_for_student(
			String ClassName) throws Throwable {
		if (ClassName != null) {
			assertTrue("Rerpots data is not matching for Book Comprehension Report at Class level ",
					lpReportsPg.Quiz_Pass_Rate_Report_class(ClassName));
		} else {
			assertTrue("Please enter the class name", false);
		}
	}

	@Then("^I should validate the reports data of Quiz Pass Rate Report at Grade level for Student$")
	public void i_should_validate_the_reports_data_of_quiz_pass_rate_report_at_grade_something_level_for_student() throws Throwable {
		lpReportsPg.Quiz_Pass_Rate_Report_Grade();
	}

	@Then("^I should validate the reports data of Quiz Pass Rate Report at school level for Student$")
	public void i_should_validate_the_reports_data_of_quiz_pass_rate_report_at_school_level_for_student()
			throws Throwable {
		lpReportsPg.Quiz_Pass_Rate_Report_school();
	}

	@Then("^I should validate the reports data of Expected Lexile Growth Report for \"([^\"]*)\" class level for Student$")
	public void i_should_validate_the_reports_data_of_expected_lexile_growth_report_for_something_class_level_for_student(
			String ClassName) throws Throwable {
		if (ClassName != null) {
			assertTrue("Rerpots data is not matching for Lexile Growth Report at Class level ",
					lpReportsPg.Expected_Lexile_Growth_Report_class(ClassName));
		} else {
			assertTrue("Please enter the class name", false);
		}
	}

	@Then("^I should validate the reports data of Lexile Growth Report for \"([^\"]*)\" class level for Student$")
	public void i_should_validate_the_reports_data_of_lexile_growth_report_for_something_class_level_for_student(
			String ClassName) throws Throwable {
		if (ClassName != null) {
			assertTrue("Rerpots data is not matching for Lexile Growth Report at Class level ",
					lpReportsPg.Lexile_Growth_Report_class(ClassName));
		} else {
			assertTrue("Please enter the class name", false);
		}
	}

	@Then("^I should validate the reports data of Lexile Growth Report at Grade \"([^\"]*)\" level for Student$")
	public void i_should_validate_the_reports_data_of_lexile_growth_report_at_grade_something_level_for_student() throws Throwable {
			lpReportsPg.Lexile_Growth_Report_grade();
	}

	@Then("^I should validate the reports data of Lexile Growth Report at School level for Student$")
	public void i_should_validate_the_reports_data_of_lexile_growth_report_at_school_level_for_student()
			throws Throwable {
		lpReportsPg.Lexile_Growth_Report_school();
	}
	
	@Then("^I should validate the reports data of historical Lexile Growth Report at school level$")
    public void i_should_validate_the_reports_data_of_historical_lexile_growth_report_at_school_level() throws Throwable {
		lpReportsPg.Historical_Lexile_Growth_Report_school();
    }

	@Then("^I should validate the reports data of Expected Lexile Growth Report at Grade level for Student$")
	public void i_should_validate_the_reports_data_of_expected_lexile_growth_report_at_grade_something_level_for_student() throws Throwable {
			lpReportsPg.Expected_Lexile_Growth_Report_Grade();
	}

	@Then("^I should validate the reports data of Expected Lexile Growth Report at School level for Student$")
	public void i_should_validate_the_reports_data_of_expected_lexile_growth_report_at_school_level_for_student()
			throws Throwable {
		lpReportsPg.Expected_Lexile_Growth_Report_school();
	}
	
	@Then("^I should validate the student lexile history report should show reports for current year$")
    public void i_should_validate_the_student_lexile_history_report_should_show_reports_for_current_year() throws Throwable {
		assertTrue("Student Lexile History Report is not showing current school year data",
				lpReportsPg.CurrentSchoolYear());
	}
	
	@When("^I select \"([^\"]*)\" option from dropdown$")
    public void i_select_something_option_from_dropdown(String Year) throws Throwable {
		lpReportsPg.Yearselect(Year);
	}
	
	@Then("^I should Verify that all the lexile scores should be shown$")
    public void i_should_verify_that_all_the_lexile_scores_should_be_shown() throws Throwable {
		assertTrue("Student Lexile History Report is not showing current school year data",
				lpReportsPg.AllSchoolYear());
	}
	
	@Then("^I should validate the reports data of historical Expected Lexile Growth Report at school level$")
    public void i_should_validate_the_reports_data_of_historical_expected_lexile_growth_report_at_school_level() throws Throwable {
		lpReportsPg.Historical_Expected_Lexile_Growth_Report_school();
    }
	
	@Then("^I should validate the reports data of Class Reading Report Card for \"([^\"]*)\" class level for Student$")
	public void i_should_validate_the_reports_data_of_class_reading_report_card_for_something_class_level_for_student(
			String ClassName) throws Throwable {
		if (ClassName != null) {
			assertTrue("Rerpots data of Class Reading Report Card at class level is not mataching with student data",
					lpReportsPg.Class_Reading_Report_class(ClassName));
		} else {
			assertTrue("Please enter the class name", false);
		}
	}

	@Then("^I should see following reports in dashboard$")
	public void i_should_see_following_reports_in_dashboard(List<String> uiElements) throws Throwable {

		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String DashboardReport = uieleIterator.next();
			assertTrue(DashboardReport + " Rerpots is missing from Admin/Teacher dashboard",
					lpReportsPg.DashboardReportVisibility(DashboardReport));
		}
	}

	@Then("^I should validate the reports data of Class Lexile History Report Card for \"([^\"]*)\" class level for Student$")
	public void i_should_validate_the_reports_data_of_class_lexile_history_report_card_for_something_class_level_for_student(
			String ClassName) throws Throwable {
		if (ClassName != null) {
			assertTrue(
					"Rerpots data of Class Lexile History Report Card at class level is not mataching with student data",
					lpReportsPg.Class_Lexile_History_Report_class(ClassName));
		} else {
			assertTrue("Please enter the class name", false);
		}
	}

	@Then("^I should validate the Teacher dashboard reports$")
	public void i_should_validate_the_teacher_dashboard_reports() throws Throwable {
		assertTrue("Rerpots data at dashboard is not matching with actual student data",
				lpReportsPg.TeacherDashboardReportValidate());
	}

	@Then("^I should validate the Admin dashboard reports$")
	public void i_should_validate_the_admin_dashboard_reports() throws Throwable {
		assertTrue("Rerpots data at dashboard is not matching with actual student data",
				lpReportsPg.AdminDashboardReportValidate());
	}

	@Then("^I should see negatieve BR on Lexile Compared to Norm Report$")
	public void i_should_see_negatieve_br_on_lexile_compared_to_norm_report() throws Throwable {
		assertTrue("Rerpots data is displayed with Negatieve BR", lpReportsPg.getLexilecomparedToNormReport());
	}

	@Then("^I should see negatieve BR for Lexile Compared to Norm Report at Grade \"([^\"]*)\" level for Student$")
	public void i_should_see_negatieve_br_for_lexile_compared_to_norm_report_at_grade_something_level_for_student(
			String strArg1) throws Throwable {
		assertTrue("Rerpots data is displayed with Negatieve BR", lpReportsPg.getLexileComparedWithnormAtGradeLevel());
	}

	@Then("^I should see negatieve BR on Lexile Compared to Norm Report at school level for Student$")
	public void i_should_see_negatieve_br_on_lexile_compared_to_norm_report_at_school_level_for_student()
			throws Throwable {
		assertTrue("Rerpots data at dashboard is not matching with actual student data",
				lpReportsPg.getLexileComparedWithnormAtSchoolLevel());
	}

	@Then("^I should see negatieve BR on Reading Proficiency Report for \"([^\"]*)\" class level for Student$")
	public void i_should_see_negatieve_br_on_reading_proficiency_report_for_something_class_level_for_student(
			String strArg1) throws Throwable {
		assertTrue("Rerpots data is displayed with Negatieve BR", lpReportsPg.getLexileReadingProficiencyReport());
	}

	@Then("^I should see negatieve BR on Lexile Growth Report for \"([^\"]*)\" class level for Student$")
	public void i_should_see_negatieve_br_on_lexile_growth_report_for_something_class_level_for_student(String strArg1)
			throws Throwable {
		assertTrue("Rerpots data is displayed with Negatieve BR", lpReportsPg.getLexilecomparedToNormReport());
	}

	@Then("^I should see negatieve BR on Lexile Growth Report at Grade \"([^\"]*)\" level for Student$")
	public void i_should_see_negatieve_br_on_lexile_growth_report_at_grade_something_level_for_student(String strArg1)
			throws Throwable {
		assertTrue("Rerpots data is displayed with Negatieve BR", lpReportsPg.getLexileComparedWithnormAtGradeLevel());
	}

	@Then("^I should see negatieve BR on Lexile Growth Report at School level for Student$")
	public void i_should_see_negatieve_br_on_lexile_growth_report_at_school_level_for_student() throws Throwable {
		assertTrue("Rerpots data at dashboard is not matching with actual student data",
				lpReportsPg.getLexileComparedWithnormAtSchoolLevel());
	}

	@Then("^I should see negatieve BR on Expected Lexile Growth Report for \"([^\"]*)\" class level for Student$")
	public void i_should_see_negatieve_br_on_expected_lexile_growth_report_for_something_class_level_for_student(
			String strArg1) throws Throwable {
		assertTrue("Rerpots data is displayed with Negatieve BR", lpReportsPg.getExpectedLexileGrowth());

	}

	@Then("^I should see negatieve BR on Expected Lexile Growth Report at School level for Student$")
	public void i_should_see_negatieve_br_on_expected_lexile_growth_report_at_school_level_for_student()
			throws Throwable {
		assertTrue("Rerpots data is displayed with Negatieve BR", lpReportsPg.getExpectedLexileGrowthgradeLevel());

	}

	@Then("^I should see negatieve BR on Expected Lexile Growth Report at Grade \"([^\"]*)\" level for Student$")
	public void i_should_see_negatieve_BR_on_Expected_Lexile_Growth_Report_at_Grade_level_for_Student(String arg1)
			throws Throwable {
		assertTrue("Rerpots data is displayed with Negatieve BR", lpReportsPg.getExpectedLexileGrowthgradeLevel());
	}

	@Then("^I should see negatieve BR on Class Reading Report Card for \"([^\"]*)\" class level for Student$")
	public void i_should_see_negatieve_BR_on_Class_Reading_Report_Card_for_class_level_for_Student(String arg1)
			throws Throwable {
		assertTrue("Rerpots data is displayed with Negatieve BR", lpReportsPg.getExpectedLexileGrowth());

	}

	@Then("^I should see negatieve BR on Class Lexile History Report Card for \"([^\"]*)\" class level for Student$")
	public void i_should_see_negatieve_BR_on_Class_Lexile_History_Report_Card_for_class_level_for_Student(String arg1)
			throws Throwable {
		assertTrue("Rerpots data is displayed with Negatieve BR", lpReportsPg.getHistoryReportcard());

	}

	@When("^I click on home page$")
	public void i_click_on_home_page() throws Throwable {
		lpReportsPg.homepage();
	}

	@Then("^I must see below reports$")
	public void i_must_see_below_reports(List<String> reports) throws Throwable {
		Iterator<String> repIterator = reports.iterator();
		while (repIterator.hasNext()) {
			String reportname = repIterator.next();

			assertTrue("The Reports has not been displayed '" + reportname + "' NOT displayed ",
					lpReportsPg.isreportDisplayed(reportname));

		}
	}

	@Then("^I must not see below reports$")
	public void i_must_not_see_below_reports(List<String> reports) throws Throwable {
		Iterator<String> repIterator = reports.iterator();
		while (repIterator.hasNext()) {
			String reportname = repIterator.next();

			assertTrue("The Reports has not been displayed '" + reportname + "' NOT displayed ",
					!(lpReportsPg.isreportDisplayed(reportname)));
		}
	}

	@Then("^I collect Reading Report card data for student$")
	public void i_collect_Reading_Report_card_data_for_student() throws Throwable {
		 lexile =lpReportsPg.getStudnetData();
	}

	@Then("^I print Parent Letter$")
	public void i_print_Parent_Letter() throws Throwable {
		lpReportsPg.printparentletter();
	}

	@Then("^student Report card data should match Parent Letter$")
	public void student_Report_card_data_should_match_Parent_Letter() throws Throwable {
		assertTrue("Parent Letter does not have correct data ",lpReportsPg.VerifyStudetDataInParentLetter(lexile));
	}
	@Then("^I print Parent Letter for multiple students$")
	public void i_print_Parent_Letter_for_multiple_students() throws Throwable {
		lpReportsPg.clickParentLetterForStudents();
		
	}

	@Then("^Students Report card data should match in the Parent Letter$")
	public void students_Report_card_data_should_match_in_the_Parent_Letter(List<String> studentname) throws Throwable {
		Iterator<String> uieleIterator = studentname.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("'" + repName + "' Parent Letter is no correct ", lpReportsPg.VerifyMultipleStudetsDataInParentLetter(repName));
	}
	}
	@Then("^Students Report card data should match in the Reading Report card Letter$")
	public void students_Report_card_data_should_match_in_the_Reading_Report_card_Letter( List<String> studentname) throws Throwable {
		Iterator<String> uieleIterator = studentname.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("'" + repName + "' Print  Student report Card  is no correct ", lpReportsPg.VerifyMultipleStudetsDataInReadingReportCardLetter(repName));
	} 
	}
	@When("^I print Reading Report Card for multiple students$")
	public void i_print_Reading_Report_Card_for_multiple_students() throws Throwable {
		lpReportsPg.printReadingReportcard();
	}
	@When("^I click on print certificates options at class level$")
    public void i_click_on_print_certificates_options_at_class_level() throws Throwable {
		lpReportsPg.ClassCertificate();
    }
	@Then("^I should validate the certificate of all the students in the class \"([^\"]*)\"$")
    public void i_should_validate_the_certificate_of_all_the_students_in_the_class_something(String classname) throws Throwable {
        lpReportsPg.ClassCertificatevalidation(classname);
    }
	
	@Then("^I should click on \"([^\"]*)\" option.$")
    public void i_should_click_on_something_option(String SetCutmRange) throws Throwable {
		lpReportsPg.CustomRange(SetCutmRange);
    }
	
	@Then("^I should verify that left calender is of previous month and right calender of current month$")
    public void i_should_verify_that_left_calender_is_of_previous_month_and_right_calender_of_current_month() throws Throwable {
		assertTrue("Custom date is not showing correct pre and current month ",lpReportsPg.VerfycalenderMonth());
    }
	
	@When("^I click on left icon I should see previous month in calender$")
    public void i_click_on_left_icon_i_should_see_previous_month_in_calender() throws Throwable {
		assertTrue("Date range in calender year is not correct after clicking on the PREV ARROW icon ",lpReportsPg.LeftArrowcalender());
	}
	
	@When("^I click on right icon I should see furture month in calender$")
    public void i_click_on_right_icon_i_should_see_furture_month_in_calender() throws Throwable {
		assertTrue("Date range in calender year is not correct after clicking on the FURTURE ARROW icon ",lpReportsPg.RightArrowcalender());
	}
	
	@Then("^I should click on Cancel button$")
    public void i_should_click_on_cancel_button() throws Throwable {
		lpReportsPg.CalenderCancelBtn();
    }
	
	@Then("^I should Click on Apply button and year dropdown button should change to according selected date$")
    public void i_should_click_on_apply_button_and_year_dropdown_button_should_change_to_according_selected_date() throws Throwable {
		assertTrue("Apply button is NOT changing the Year dropdown button Value ",lpReportsPg.VerifyBtnName());
	}
	
	@When("^I click on the X button next to date range$")
    public void i_click_on_the_x_button_next_to_date_range() throws Throwable {
		lpReportsPg.CrossBtn();
	}
	
	@Then("^The date range will be cleared and default school year \"([^\"]*)\" will be shown$")
    public void the_date_range_will_be_cleared_and_default_school_year_something_will_be_shown(String Schoolyear) throws Throwable {
		assertTrue("Calendar Dropdown name should not change after clicking on X button ",lpReportsPg.calendarName(Schoolyear));
	}
	
	@Then("^I should see calendar tray collapse and same year \"([^\"]*)\" dropdown button name$")
    public void i_should_see_calendar_tray_collapse_and_same_year_something_dropdown_button_name(String SchoolYear) throws Throwable {
		assertTrue("Calendar Tray did not collapse after Clicking on cancel button ",lpReportsPg.calendartraycollapse());
		assertTrue("Calendar Dropdown name should not change after clicking on canel button ",lpReportsPg.calendarName(SchoolYear));
	}
	
	@When("^I select TO date$")
    public void i_select_to_date() throws Throwable {
		lpReportsPg.SelectAnydate();
	}
	
	@Then("^I should not be able to select more then 365 days from TO date$")
    public void i_should_not_be_able_to_select_more_then_365_days_from_to_date() throws Throwable {
		assertTrue("Calendar Dropdown name should not change after clicking on canel button ",lpReportsPg.Moredays365());
	}
}