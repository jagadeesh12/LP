package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;

import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.MyResultsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SettingsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBaseProvider;

public class LpStudentMyResultsStDf {
	private LitProUserType lpUserType;

	WebDriver driver=TestBaseProvider.getTestBase().getDriver();
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	LitProHomePg lpHome= new LitProHomePg(driver,lpUserType);
	MyResultsPg lpResults = new MyResultsPg(driver, lpUserType);
	SettingsPg lpSettingsPg = new SettingsPg(driver, lpUserType);

	Scenario scenario;

	// public LpStudentMyResultsStDf(SharedDriver driver) {
	// this.driver = driver;
	// }

//	@Before
//	public void before(Scenario scenario) {
//		this.scenario = scenario;
//	}

	@When("^I click on My Results tab$")
	public void i_click_on_My_Results_tab() throws Throwable {
		lpHome = new LitProHomePg(driver, lpUserType);
		lpResults = lpHome.goToMyResultsPage();
		Thread.sleep(5000);
		System.out.println("I click on My Results tab END");
	}

	@Then("^I should validate the dashboard of My result page$")
    public void i_should_validate_the_dashboard_of_my_result_page(
			List<String> elems) throws Throwable {
		Iterator<String> repsIterator = elems.iterator();
		repsIterator.next();
		while (repsIterator.hasNext()) {
			String repItem = repsIterator.next();
			assertTrue("Report item '" + repItem + "' NOT displayed ",
					!lpResults.MyResultDashboard(repItem).equals("NULL"));
		}
	}
	
	@Then("^I should validate the Quizzes Passed field in my result page$")
    public void i_should_validate_the_quizzes_passed_field_in_my_result_page() throws Throwable {
		assertTrue("Quizzes Passed field in my result page is not showing correct results",
				lpResults.QuizzesPassedMyresult());
	}
	
	@Then("^I should validate the Words read field in my result page$")
    public void i_should_validate_the_words_read_field_in_my_result_page() throws Throwable {
		assertTrue("Word read field in my result page is not showing correct results",
				lpResults.WordsReadMyresult());
    }
	
	@Then("^I should validate the Average Quiz Score dashboard in my result page$")
    public void i_should_validate_the_average_quiz_score_dashboard_in_my_result_page() throws Throwable {
		assertTrue("Average Quiz Score dashboard in my result page is not showing correct results",
				lpResults.AverageQuizScoreMyresult());
    }
	
	@Then("^I should see My Results Page$")
	public void i_should_see_My_Results_Page() throws Throwable {
		String actual = lpResults.getmylexileLabel();
		String expected = "My Lexile";
		assertTrue(
				" NOT matched. Expected: " + expected + ", Actual:" + actual,
				actual.equals(expected));
		actual = lpResults.getmylexileText();
		assertTrue(" My Lexile NOT matched. Expected pattern .*L  Actual:"
				+ actual, actual.matches(".*L"));

		actual = lpResults.getcertificateLabel();
		expected = "Certificate Level";
		assertTrue(
				" NOT matched. Expected: " + expected + ", Actual:" + actual,
				actual.equals(expected));
		actual = lpResults.getcertificateText();
		assertTrue(
				"Get Certificate text NOT matched. Expected pattern '-' , Actual: "
						+ actual, actual.matches("[A-Z][a-z]+"));

		actual = lpResults.getquizpassedLabel();
		expected = "Quizzes Passed";
		assertTrue("Quizzes Passed label NOT matched. Expected: " + expected
				+ ", Actual:" + actual, actual.equals(expected));
		actual = lpResults.getquizpassedText();
		assertTrue(
				"Quizzes Passed text NOT matched. Expected pattern '\\d+' , Actual: "
						+ actual, actual.matches("\\d+"));

		actual = lpResults.getwordsLabel();
		expected = "Words Read";
		assertTrue("Words Read label NOT matched. Expected: " + expected
				+ ", Actual:" + actual, actual.equals(expected));
		actual = lpResults.getwordsText();
		assertTrue(
				"Words Read text NOT matched. Expected pattern '\\d+' , Actual: "
						+ actual, actual.matches("[0-9]{1,3},[0-9]{1,3}"));

		actual = lpResults.getavgquizscoreLabel();
		expected = "Average Quiz Score";
		assertTrue(
				" NOT matched. Expected: " + expected + ", Actual:" + actual,
				actual.equals(expected));
		actual = lpResults.getavgquizscoreText();
		assertTrue(
				" NOT matched. Expected pattern '\\d+%' , Actual: " + actual,
				actual.matches("\\d+%"));

		actual = lpResults.gettitleLabel();
		expected = "Title";
		assertTrue(
				" NOT matched. Expected: " + expected + ", Actual:" + actual,
				actual.equals(expected));
		actual = lpResults.gettitleText();
		assertTrue(" NOT matched. Expected pattern '.*' , Actual: " + actual,
				actual.matches(".*"));

		actual = lpResults.getauthorLabel();
		expected = "Author";
		assertTrue(
				" NOT matched. Expected: " + expected + ", Actual:" + actual,
				actual.equals(expected));
		actual = lpResults.getauthorText();
		assertTrue(" NOT matched. Expected pattern '.*' , Actual: " + actual,
				actual.matches(".*"));

		actual = lpResults.getlexileLabel();
		expected = "Lexile";
		assertTrue(
				" NOT matched. Expected: " + expected + ", Actual:" + actual,
				actual.equals(expected));
		actual = lpResults.getlexileText();
		assertTrue(
				" NOT matched. Expected pattern '\\d+L' , Actual: " + actual,
				actual.matches("\\d+L"));

		actual = lpResults.getwordcountLabel();
		expected = "Word Count";
		assertTrue(
				" NOT matched. Expected: " + expected + ", Actual:" + actual,
				actual.equals(expected));
		actual = lpResults.getwordcountText();
		assertTrue(" NOT matched. Expected pattern '\\d+' , Actual: " + actual,
				actual.matches("\\d+"));

		actual = lpResults.getscoreLabel();
		expected = "Score";
		assertTrue(
				" NOT matched. Expected: " + expected + ", Actual:" + actual,
				actual.equals(expected));
		actual = lpResults.getscoreText();
		assertTrue(
				" NOT matched. Expected pattern '\\d+%' , Actual: " + actual,
				actual.matches("\\d+%"));

		actual = lpResults.getpointsLabel();
		expected = "Points";
		assertTrue("Points NOT matched. Expected: " + expected + ", Actual:"
				+ actual, actual.equals(expected));
		actual = lpResults.getpointsText();
		assertTrue("Points NOT matched. Expected pattern '\\d+' , Actual: "
				+ actual, actual.matches("\\d+"));

		actual = lpResults.getdateLabel();
		expected = "Date";
		assertTrue("Date NOT matched. Expected: " + expected + ", Actual:"
				+ actual, actual.equals(expected));
		actual = lpResults.getdateText();
		assertTrue(
				"Date NOT matched. Expected pattern '\\d{2}\\s\\w{3}\\s\\d{4}' , Actual: "
						+ actual, actual.matches("\\d{2}\\s\\w{3}\\s\\d{4}"));

	}

	@When("^I click date sort column$")
	public void i_click_date_sort_column() throws Throwable {
		lpResults.sortByDate();
	}

	@Then("^the quiz results date order should change$")
	public void the_quiz_results_order_should_change() throws Throwable {
		String date1 = lpResults.getdateText();
		System.out.println(date1);
		lpResults.sortByDate();
		String date2 = lpResults.getdateText();
		System.out.println(date2);
		assertTrue("date1 and date2 match but should not.",
				!date1.matches(date2));
	}

	@When("^I click title sort column$")
	public void i_click_title_sort_column() throws Throwable {
		lpResults.sortByTitle();
	}

	@Then("^the quiz results title order should change$")
	public void the_quiz_results_title_order_should_change() throws Throwable {
		String title1 = lpResults.gettitleText();
		System.out.println(title1);
		lpResults.sortByTitle();
		String title2 = lpResults.gettitleText();
		System.out.println(title2);
		assertTrue("title1 and title2 match but should not.",
				!title1.matches(title2));
	}

	@When("^I click author sort column$")
	public void i_click_author_sort_column() throws Throwable {
		lpResults.sortByAuthor();
	}

	@Then("^the quiz results author order should change$")
	public void the_quiz_results_author_order_should_change() throws Throwable {
		String author1 = lpResults.getauthorText();
		System.out.println(author1);
		lpResults.sortByAuthor();
		String author2 = lpResults.getauthorText();
		System.out.println(author2);
		assertTrue("author1 and author2 match but should not.",
				!author1.matches(author2));
	}

	@When("^I click lexile sort column$")
	public void i_click_lexile_sort_column() throws Throwable {
		lpResults.sortByLexile();
	}

	@Then("^the quiz results lexile order should change$")
	public void the_quiz_results_lexile_order_should_change() throws Throwable {
		String lexile1 = lpResults.getauthorText();
		System.out.println(lexile1);
		lpResults.sortByLexile();
		String lexile2 = lpResults.getauthorText();
		System.out.println(lexile2);
		assertTrue("lexile1 and lexile2 match but should not.",
				!lexile1.matches(lexile2));
	}

	@When("^I click score sort column$")
	public void i_click_score_column() throws Throwable {
		lpResults.sortByScore();
	}

	@Then("^the quiz results score order should change$")
	public void the_quiz_results_score_order_should_change() throws Throwable {
		String score1 = lpResults.getscoreText();
		System.out.println(score1);
		lpResults.sortByScore();
		String score2 = lpResults.getscoreText();
		System.out.println(score2);
		assertTrue("score1 and score2 match but should not.",
				!score1.matches(score2));
	}

	@When("^I click points sort column$")
	public void i_click_points_sort_column() throws Throwable {
		lpResults.sortByPoints();
	}

	@Then("^the quiz results points order should change$")
	public void the_quiz_results_points_order_should_change() throws Throwable {
		String points1 = lpResults.getpointsText();
		System.out.println(points1);
		lpResults.sortByPoints();
		String points2 = lpResults.getpointsText();
		System.out.println(points2);
		assertTrue("points1 and points2 match but should not.",
				!points1.matches(points2));

	}

	/*************************************************************************************/

	@Then("^Verify that correct certificate is shown to user$")
	public void Verify_correct_certificate_shown(List<Map<String, String>> input)
			throws Throwable {
		Iterator<Map<String, String>> inIterator = input.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();
			// System.out.println(row);
			String awardName = row.get("Award Name");
			String awardValue = row.get("Value");
			lpResults.AwardvaluesFilling(awardName, awardValue);
		}
		lpResults.VerifyingAwards();

	}

	@Then("^I should verify See My Book Rating button for the above book. verify the book title and book comment \"([^\"]*)\"$")
    public void i_should_verify_see_my_book_rating_button_for_the_above_book_verify_the_book_title_and_book_comment_something(String CommentVerify) throws Throwable {
    	assertTrue(
				"\"See my Rating\" popup is not working at My result tab as expected.",
				lpResults.SeeMyRatingButton());
    	String Actual=CommentVerify;
		String Expected = lpResults.CommentVerifying(CommentVerify);
		assertTrue(
				"Comments in the section is not matching",
				Actual.equalsIgnoreCase(Expected));
		lpResults.DoneButton();
	}
	
	@Then("^I should Click on \"([^\"]*)\"$")
    public void i_should_click_on_something(String Text) throws Throwable {
		lpResults.button(Text);
    }
	
	@And("^I should validate the user data of See my comments in my results$")
    public void i_should_validate_the_user_data_of_see_my_comments_in_my_results(List<String> tabList) {
		System.out.println(lpUserType);
		String actual = lpResults.VerifyUserCredentails().toString();
		String expected = tabList.toString();
		assertTrue("The data credentials of view comments as Admin expected " + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}
	
	@And("^I should validate the title of See my comments in my results$")
    public void i_should_validate_the_title_of_see_my_comments_in_my_results(List<String> tabList) throws Throwable {
		System.out.println(lpUserType);
		String actual = lpResults.SeeMyCommentsTitle().toString();
		String expected = tabList.toString();
		System.out.println(actual+"========="+expected);
		assertTrue("The data credentials of view comments as Admin expected " + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}

	@And("^I should see the comments \"([^\"]*)\" for above books in my result$")
    public void i_should_see_the_comments_something_for_above_books_in_my_result(String VerifyComments) throws Throwable {
		String actual = lpResults.VerifyUserComments().toString();
		String expected = VerifyComments;
		System.out.println(actual + "---------------------" + expected);
		assertTrue("The data credentials of view comments as Admin expected " + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}
	
	@Then("^I click on list view$")
	public void I_click_on_listview() throws Throwable {
		lpResults.Listview();
	}

	@Then("^I should click on the print activity$")
	public void i_should_click_on_the_print_activity() throws Throwable {
	}

	@Then("^I should validate the print result with my result activities$")
	public void I_should_valideate_print_result_with_my_result_activities()
			throws Throwable {
		assertTrue("My result activity is not matching with print activity",
				lpResults.compare());
	}

	@Then("^I should see the certificate$")
	public void i_should_see_the_certificate() throws Throwable {
		lpResults.Myresultcertificate();
	}

	@When("^I click on the print certificate option$")
	public void i_click_on_the_print_certificate_option() throws Throwable {
		lpResults.PrintCertificate();
	}

	@Then("^I should validate the certificate$")
	public void i_should_validate_the_certificate() throws Throwable {
		assertTrue(
				"Student Print certificate in My result is not displaying correct awards",
				lpResults.comparecertificate());
	}
	@Then("^the negative lexile is displayed with \"([^\"]*)\" prefix$")
	public void the_negative_lexile_is_displayed_with_prefix(String brValue) throws Throwable {
		assertTrue( "Lexile not displayed with BR prefix",lpResults.getmylexileText().contains(brValue));
	}
}
