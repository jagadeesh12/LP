package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;

import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.MyResultsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SettingsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBaseProvider;

public class LpStudentReportCardStDf {
	WebDriver driver=TestBaseProvider.getTestBase().getDriver();
	private LitProUserType lpUserType;
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome= new SlzHomePg(driver);
	LitProHomePg lpHome= new LitProHomePg(driver,lpUserType);
	MyResultsPg lpResults= new MyResultsPg(driver, lpUserType);
	SettingsPg lpSettingsPg= new SettingsPg(driver, lpUserType);
	ReportsPg lpReportsPg= new ReportsPg(driver, lpUserType);
	BasePage base = new BasePage(driver);
	

	
	Scenario scenario;

	//
	// public LpStudentReportCardStDf(SharedDriver driver) {
	// this.driver = driver;
	// }

//	@Before
//	public void before(Scenario scenario) {
//		this.scenario = scenario;
//	}

	// ReportsPg lpReportsPg;
	@Given("^I browse to Report Page as \"(.*?)\"$")
	public void i_browse_to_Report_Page_as(String userType) throws Throwable {
//		assertTrue("Failed to Launch AUT due to missing info. Check the log.",
//				slzLogin.launchSlz());
		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);
	//   scenario.write("Credentials: " + slzLogin.getUserCreds());
		base = new BasePage(driver);
		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);
//		slzHome = slzLogin.loginAs(lpUserType);
//		lpHome = slzHome.launchLitPro(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		lpReportsPg = lpHome.goToReportsPage();
	}
	
	@Given("^I browse to Report Page for historical data as \"([^\"]*)\"$")
    public void i_browse_to_report_page_for_historical_data_as_something(String userType) throws Throwable {
		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);
		base = new BasePage(driver);
		base.launchPortal(lpUserType);
		base.calender();
		base.launchApp(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		lpReportsPg = lpHome.goToReportsPage();
	}
	@Given("^I browse launch LitPro and browse to Report Page using \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_browse_launch_LitPro_and_browse_to_Report_Page_using_and_with(String username, String password, String userType) throws Throwable {
		slzLogin = new SlzLoginPg(driver);

		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);

		base = new BasePage(driver);
		base.loginApp(username,password);
		base.launchApp(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		lpReportsPg = lpHome.goToReportsPage();
	}

	@Then("^I should see header text for Reports page$")
	public void i_should_see_header_text_for_Reports_page() throws Throwable {
		assertTrue("Header text does not begin with Reports for", lpReportsPg
				.getHeaderText().startsWith("Reports for"));
	}
	
	@When("^I click on Print option$")
    public void i_click_on_print_option() throws Throwable {
		lpReportsPg.printoption();
    }
	
	@When("^I Should click on Print Reading Report Card option$")
    public void i_should_click_on_print_reading_report_card_option() throws Throwable {
		lpReportsPg.PrintReadingReportCard();
	}
	
	@When("^I Should click on Print Student Test option$")
    public void i_should_click_on_print_student_test_option() throws Throwable {
		lpReportsPg.PrintStudentTest();
    }

	@When("^I enter Reports search string \"(.*?)\"$")
	public void i_enter_Reports_search_string(String arg1) throws Throwable {
		lpReportsPg = new ReportsPg(driver, lpUserType);// hmmm
		System.out.println("I enter Reports search string");
		lpReportsPg.searchSmartbar(arg1);
	}

	@Then("^I should see the Students Reading Report Card$")
	public void i_should_see_the_Students_Reading_Report_Card()
			throws Throwable {
		String expected = "Reading Report Card";
		assertTrue("Page Title is not " + expected, lpReportsPg.getpageTitle()
				.equals(expected));
		expected = "Grade: Class 4";
		assertTrue("Grade Label is not " + expected, lpReportsPg
				.getgradeLabel().equals(expected));
		expected = "Class: Lui Class";
		assertTrue("Class label is not " + expected, lpReportsPg
				.getclassLabel().equals(expected));
		expected = "Current Lexile";
		assertTrue("Current Lexile is not " + expected, lpReportsPg
				.getlexileLabel().equals(expected));
		assertTrue("Current Lexile does not match .*L ", lpReportsPg
				.getlexileText().matches(".*L"));
		expected = "Lexile Growth";
		assertTrue("Lexile Growth is not " + expected, lpReportsPg
				.getlexilegrowthLabel().equals(expected));
		expected = "Date of Last Completed LitPro Test";
		assertTrue("Date of Last Completed LitPro Test is not " + expected,
				lpReportsPg.getlastcompletedLabel().equals(expected));
		assertTrue(
				"Date of Last Completed LitPro Test does not match \\d{2}\\s\\w{3}\\s\\d{4} ",
				lpReportsPg.getlastcompdateText().matches(
						"^$|\\d{2}\\s\\w{3}\\s\\d{4}"));
		expected = "Proficiency Band";
		assertTrue("Proficiency Band label is not" + expected, lpReportsPg
				.getproficiencyLabel().equals(expected));
		System.out.println(lpReportsPg.getproficiencyText());
		assertTrue("Proficiency Band does not match [a-zA-Z]", lpReportsPg
				.getproficiencyText().matches("([\\w\\s]+)"));
		expected = "Certificate Level";
		assertTrue("Certificate Level is not " + expected, lpReportsPg
				.getcertificateLabel().equals(expected));
		System.out.println( lpReportsPg
				.getcertificateText());
		assertTrue("Certificate Level does not match ", lpReportsPg
				.getcertificateText().matches("[A-Z][a-z]+"));
		expected = "# of Quizzes Passed/Attempted";
		assertTrue("# of Quizzes Passed/Attempted is not " + expected,
				lpReportsPg.getquizpaLabel().equals(expected));
		assertTrue("# of Quizzes Passed/Attempted does not match \\d+/\\d+",
				lpReportsPg.getquizpaText().matches("^$|\\d+/\\d+"));
		expected = "Average Quiz Score";
		assertTrue("Average Quiz Score is not " + expected, lpReportsPg
				.getavgscoreLabel().equals(expected));
		System.out.println(lpReportsPg
				.getavgscoreText());
		assertTrue("Average Quiz Score does not match \\d+%", lpReportsPg
				.getavgscoreText().matches("^$|\\d+%"));
		expected = "Average Lexile of Quizzes Passed";
		assertTrue("Average Lexile of Quizzes Passed is not " + expected,
				lpReportsPg.getavglexquizpassedLabel().equals(expected));
		assertTrue("Average Lexile of Quizzes Passed does not match \\d+L ",
				lpReportsPg.getavglexquizpassedText().matches("\\d+L"));
		expected = "Words Read";
		assertTrue("Words Read label is not " + expected, lpReportsPg
				.getwordsreadLabel().equals(expected));
		assertTrue("Words Read does not match \\d+,\\d+", lpReportsPg
				.getwordsreadText().matches("[0-9]{1,3}[0-9]{1,3}"));
		expected = "Quiz Points Earned";
		assertTrue("Quiz Points Earned is not " + expected, lpReportsPg
				.getptsearnedLabel().equals(expected));
		assertTrue("Quiz Points Earned does not match \\d+", lpReportsPg
				.getptsearnedText().matches("\\d+"));
		expected = "Teacher-Added Points";
		assertTrue("Teacher-Added Points is not " + expected, lpReportsPg
				.getteacherptsLabel().equals(expected));
		assertTrue("Teacher-Added Points does not match \\d", lpReportsPg
				.getteacherptsText().matches("[0-9]{1,2}"));
	}

	@Then("^I should see the Student Activities UI elements$")
	public void i_should_see_the_Student_Activities_UI_elements()
			throws Throwable {
		
		String expected = "Title/Author";
		assertTrue("Title Author link is not " + expected, lpReportsPg
				.gettitleauthorLink().equals(expected));
		expected = "Lexile";
		assertTrue("Lexile link is not " + expected, lpReportsPg
				.getlexileLink().equals(expected));
		expected = "Word Count";
		assertTrue("Word Count link is not " + expected, lpReportsPg
				.getwordcountLink().equals(expected));
		expected = "Date";
		assertTrue("Date link is not " + expected, lpReportsPg.getdateLink()
				.equals(expected));
		expected = "Score";
		assertTrue("Score link is not " + expected, lpReportsPg.getscoreLink()
				.equals(expected));
		expected = "Points "; // the extra space is expected
		assertTrue("Points link is not " + expected, lpReportsPg
				.getpointsLink().equals(expected));
		expected = "View";
		assertTrue("View link is not " + expected, lpReportsPg.getviewLabel()
				.equals(expected));
	}

	// needs work
	@When("^I click the School Calendar arrow the calendar drop down displays$")
	public void i_click_the_School_Calendar_arrow_the_calendar_drop_down_displays()
			throws Throwable {
		assertTrue("Calendar dropdown is not as expected ",
				lpReportsPg.verifycalendarDropdown());
	}

	@When("^I click the View Report button the Student Lexile History Report displays$")
	public void i_click_the_View_Report_button_the_Student_Lexile_History_Report_displays()
			throws Throwable {
		assertTrue("Student Lexile History Report not displayed",
				lpReportsPg.verifyreport());
	}

	@When("^I click Student Activity column headings the sort order changes$")
	public void i_click_Student_Activity_column_headings_the_sort_order_changes()
			throws Throwable {
		assertTrue("Student Activity column headings the sort",
				lpReportsPg.verifycolumnsort());
	}

	@When("^I click the Print Options Print Parent Letter link the Parent letter displays$")
	public void i_click_the_Print_Options_Print_Parent_Letter_link_the_Parent_letter_displays()
			throws Throwable {
		assertTrue("Print Options Print Parent Letter",
				lpReportsPg.verifyprintparentletter());
	}

	@When("^I click the Print Options Print Student Test link the Student Test displays$")
	public void i_click_the_Print_Options_Print_Student_Test_link_the_Student_Test_displays()
			throws Throwable {
		assertTrue("Print Options Print Student Test",
				lpReportsPg.verifyprintstudenttest());
	}

	@When("^I click the Print Options Print Reading Report Card link the Print Reading Report Card displays$")
	public void i_click_the_Print_Options_Print_Reading_Report_Card_link_the_Print_Reading_Report_Card_displays()
			throws Throwable {
		assertTrue("Print Options Print Reading Report Card",
				lpReportsPg.verifyprintreportcard());
	}

	/*
	 * expected = ""; assertTrue("is not"+expected, lpReportsPg.get().);
	 * assertTrue("does not match "+expected, lpReportsPg.get().);
	 * assertTrue(""+expected, lpReportsPg.get().equals(expected));
	 * assertTrue(""+expected, lpReportsPg.get().matches(""));
	 * assertTrue(""+expected, lpReportsPg.get().); assertTrue(""+expected,
	 * lpReportsPg.get().); assertTrue(""+expected, lpReportsPg.get().);
	 * assertTrue(""+expected, lpReportsPg.get().); assertTrue(""+expected,
	 * lpReportsPg.get().); assertTrue(""+expected, lpReportsPg.get().);
	 */

	@Then("^I should see student certificate$")
	public void i_should_see_student_certificate() throws Throwable {
		lpReportsPg.ReportCertificate();
	}

	@When("^I click on Print certificate in print option$")
	public void i_click_on_print_certificate_in_print_option() throws Throwable {
		lpReportsPg.ReportStudentCertificate();
	}

	@Then("^I should verify award certificate$")
	public void i_should_verify_award_certificate() throws Throwable {
		assertTrue(
				"Student Print certificate is not displaying correct awards",
				lpReportsPg.VerifyPrintStudentCertificate());
	}
	
	@Then("^I should click on View All Comments button$")
    public void i_should_click_on_view_all_comments_button() throws Throwable {
		lpReportsPg.ViewAllComment();
	}
	
	@And("^I should validate the user data of See my comments$")
    public void i_should_validate_the_data_of_view_report_button(List<String> tabList) {
		System.out.println(lpUserType);
		String actual = lpReportsPg.VerifyUserCredentails().toString();
		String expected = tabList.toString();
		System.out.println(actual+"========="+expected);
		assertTrue("The data credentials of view comments as Admin expected " + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}
	
	@And("^I should validate the user data of print student test$")
    public void i_should_validate_the_user_data_of_print_student_test(List<String> tabList) {
		System.out.println(lpUserType);
		String actual = lpReportsPg.VerifyUserCredentailsTest().toString();
		String expected = tabList.toString();
		System.out.println(actual+"========="+expected);
		assertTrue("The data credentials of view comments as Admin expected " + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}
	
	@And("^I should validate the user data of print Reading Report Card$")
    public void i_should_validate_the_user_data_of_print_reading_report_card(List<String> tabList) {
		System.out.println(lpUserType);
		String actual = lpReportsPg.VerifyUserCredentailsRRC().toString();
		String expected = tabList.toString();
		System.out.println(actual+"========="+expected);
		assertTrue("The data credentials of view comments as Admin expected " + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}
	
	@Then("^I should Validate the Reading Report Card of the students \"([^\"]*)\"$")
    public void i_should_validate_the_reading_report_card_of_the_students_something(String Studentname) throws Throwable {
		lpReportsPg.ValidateReadingReportCard(Studentname);
    }
	
	@And("^I should validate the title of See my comments$")
    public void i_should_validate_the_title_of_see_my_comments(List<String> tabList) throws Throwable {
		System.out.println(lpUserType);
		String actual = lpReportsPg.SeeMyCommentsTitle().toString();
		String expected = tabList.toString();
		assertTrue("The data credentials of view comments as Admin expected " + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}
	
	@And("^I should see the comments \"([^\"]*)\" for above books$")
	public void i_should_see_the_comments_something_for_above_books(
			String VerifyComments) throws Throwable {
		String actual = lpReportsPg.VerifyUserComments().toString();
		String expected = VerifyComments;
		System.out.println(actual + "---------------------" + expected);
		assertTrue("The data credentials of view comments as Admin expected " + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}
	@Then("^I should see Test Incomplete notification$")
	public void i_should_see_Test_Incomplete_notification() throws Throwable {
		assertTrue("Notification not displayed ",lpReportsPg.isNotificationDisplayed());
	}

	@Then("^I should see tooltip as \"([^\"]*)\"$")
	public void i_should_see_tooltip_as(String tooltip) throws Throwable {
		assertTrue("toot tip are not equal ",lpReportsPg.isTestToolTipDisplayed().equals(tooltip));
	}
	@Then("^I should not see Test Incomplete notification$")
	public void i_should_not_see_Test_Incomplete_notification() throws Throwable {
		assertTrue("Notification not displayed ",!(lpReportsPg.isNotificationDisplayed()));
	}
	
	@Then("^I should Validate the test question taken by students$")
    public void i_should_validate_the_test_question_taken_by_students() throws Throwable {
		assertTrue("Print test at reading report card is showing wrong test questions or not showing complete questions",lpReportsPg.PrintTestReport());
    }
	
	@Then("^I should collect the all the data of the student \"([^\"]*)\"$")
    public void i_should_collect_the_all_the_data_of_the_student_something(String Studentname) throws Throwable {
		lpReportsPg.DataCollectionStudentRRC(Studentname);
    }
	
	@Then("^I should verify the litpro logo$")
    public void i_should_verify_the_litpro_logo() throws Throwable {
		assertTrue("Litpro logo is not shown in the page ",lpReportsPg.VerifyLitproLogo());
    }	
	
	
}
