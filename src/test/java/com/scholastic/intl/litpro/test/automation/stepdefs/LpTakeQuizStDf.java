package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.scholastic.intl.litpro.test.automation.pageobjects.AssessmentPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.MyResultsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.MyResultsPg.QuizResult;
import com.scholastic.intl.litpro.test.automation.pageobjects.QuizModal;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SettingsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LpTakeQuizStDf {
	LitProUserType lpUserType;
	WebDriver driver=TestBaseProvider.getTestBase().getDriver();
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	LitProHomePg lpHome = new LitProHomePg(driver,lpUserType);
	SettingsPg lpSettingsPg= new SettingsPg(driver, lpUserType);
	AssessmentPg lpAssessmentPg= new AssessmentPg(driver);
	ReportsPg lpReportsPg= new ReportsPg(driver, lpUserType);
	SearchPg lpSearchPg= new SearchPg(driver,lpUserType);
	QuizModal lpQuizModal= new QuizModal(driver);
	MyResultsPg lpMyResPg= new MyResultsPg(driver, lpUserType);
	BasePage base = new BasePage(driver);
	Scenario scenario;
	QuizResult quizResult;
	String bookTitle = "Mouse Tales";
	String score;
	String percentage;

	//
	// public LpTakeQuizStDf(SharedDriver driver) {
	// this.driver = driver;
	// }

//	 @Before
//	 public void before(Scenario scenario) {
//	 this.scenario = scenario;
//	 }

	@When("^As a student, I am on the search page showing results for word \"(.*?)\"$")
	public void i_am_on_the_search_page_showing_results_for_word(String key)
			throws Throwable {
		slzLogin = new SlzLoginPg(driver);
		/*assertTrue("Failed to Launch AUT due to missing info. Check the log.",
				slzLogin.launchSlz());*/
		// slzHome = slzLogin.loginAs(LitProUserType.STUDENT);
		LitProUserType lpUserType = slzLogin.getLitProUserType("student");
//		slzHome = slzLogin.loginAs(lpUserType);
	//	scenario.write("Credentials: " + slzLogin.getUserCreds());
//
//		lpHome = slzHome.launchLitPro(LitProUserType.STUDENT);
		base = new BasePage(driver);
		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);

		lpSearchPg = lpHome.goToSeachPage();
		SearchPg lpSearchPg= new SearchPg(driver,lpUserType);
		String actual = lpSearchPg.getPageHeader();
		String expected = "Search";
		assertTrue("The expected Search Page Header was '" + expected
				+ "' but actually was: " + actual,
				actual.equalsIgnoreCase(expected));
		lpSearchPg.checkQuizzesOnly();
		lpSearchPg.typeSearchKeyAndHitQuickSearchBtn(key);
		lpHome.waitWhenLoadingBarActive();

	}

	@And("^I click Take Quiz button for a random book$")
	public void i_click_Take_Quiz_button_for_a_random_book() throws Throwable {
		lpSearchPg = new SearchPg(driver);
		bookTitle = lpSearchPg.clickRandomBookTakeQuizButton();
		if (!(bookTitle.trim().length() > 1)) {
			/*scenario.write("No Books found with the 'Take quiz' button."
					+ bookTitle);
			throw new PendingException();*/
		}

		//scenario.write("Attended quiz for book: " + bookTitle);
	}

	@Then("^I should see quiz popup with header text starting with \"(.*?)\"$")
	public void i_should_see_quiz_popup_with_header_text_starting_with(
			String header) throws Throwable {
		lpQuizModal = new QuizModal(driver);
		String expected = header;
		String actual = lpQuizModal.getModalHeader();
		assertTrue("The expected Header was '" + expected
				+ "' but actually was: " + actual, actual.contains(expected));
	}

	@When("^I click Take Quiz button in Quiz Popup$")
	public void i_click_Take_Quiz_button_in_Quiz_Popup() throws Throwable {
		lpQuizModal.clickTakeQuiz();
	}

	@When("^I complete the quiz$")
	public void i_complete_the_quiz() throws Throwable {
		try {
			lpQuizModal.completeQuiz();
		} catch (Exception e) {
			String exp = e.getMessage();
			assertTrue("Error while attending quiz. " + exp, false);
		}

		if (lpQuizModal.selectRating()) {
			//scenario.write("Quiz Result: Pass");
		} else {
			//scenario.write("Quiz Result: Fail");
		}
	}

	@And("^I should enter the comments \"([^\"]*)\"$")
    public void i_should_enter_the_comments_something(String comments) throws Throwable {
		lpQuizModal.Comments(comments);
    }

	@Then("^I should see score and percentage$")
	public void i_should_see_score_and_percentage() throws Throwable {
		score = lpQuizModal.getQuizScore();
		percentage = lpQuizModal.getQuizPercentage();
		//scenario.write("Score: " + score + ". Percentage: " + percentage);
		assertTrue("Score NOT displayed", score.trim().length() > 0);
		assertTrue("Percentage NOT displayed", percentage.trim().length() > 0);
		lpQuizModal.clickDoneBtn();
	}

	@When("^I goto My Results page$")
	public void i_goto_My_Results_page() throws Throwable {
		lpMyResPg = lpHome.goToMyResultsPage();
	}

	@Then("^I should see book details on which quiz was taken$")
	public void i_should_see_book_details_on_which_quiz_was_taken()
			throws Throwable {
		quizResult = lpMyResPg.getQuizResultForBook(bookTitle);
		assertTrue("Quiz results NOT displyed for the book: " + bookTitle,
				quizResult != null);

	}

	@Then("^Score and Quiz date should match$")
	public void score_and_Quiz_date_should_match() throws Throwable {
		assertTrue("Quiz Percentage NOT matched. Expected: " + this.percentage
				+ ". Actual:" + quizResult.percentage,
				quizResult.percentage.equalsIgnoreCase(this.percentage));
	}

	@Then("^I should see 'View Incorrect Answer' button$")
	public void i_should_see_View_Incorrect_Answer_button() throws Throwable {

	}

	@When("^I click 'View Incorrect Answer' button$")
	public void i_click_View_Incorrect_Answer_button() throws Throwable {
		lpQuizModal.clickViewIncorrectAns();
	}

	@Then("^I should see pop up showing incorrect answers$")
	public void i_should_see_pop_up_showing_incorrect_answers()
			throws Throwable {
		lpQuizModal.isIncorrectAnsExist();
	}

	@Then("^Incorrect answer should be selected for all incorrect answers$")
	public void correct_answer_should_be_selected_for_all_incorrect_answers()
			throws Throwable {
		assertTrue("Incorrect ans NOT displayed.",
				lpQuizModal.isIncorrectAnsExist());
	}

	@When("^I click 'Exit Quiz' button$")
	public void i_click_exit_quiz_button() throws Throwable {
		lpQuizModal.clickExitQuizBtn();
	}

	@Then("^Popup should close$")
	public void popup_should_close() throws Throwable {
		assertTrue("Pop up not closed", !lpQuizModal.isIncorrectAnsExist());
	}

	@Then("^Verify that View Incorrect Answers button is visible$")
	public void i_should_see_ViewIncorrectAnswer_button() throws Throwable {
		assertTrue("Button \"View Incorrect Answers\" is not visible",
				lpQuizModal.ViewIncorrectAnswer());
	}

	@Then("^Verify that View Incorrect Answers button should be Invisible$")
	public void Invisible_ViewIncorrectAnswer_button() throws Throwable {
		assertTrue("Button \"View Incorrect Answers\" is visible",
				lpQuizModal.ViewIncorrectAnswerhide());
	}

	/*
	 * @And("^I click Take Quiz button for a random book$") public void
	 * i_click_Take_Quiz_button_for_a_random_book() throws Throwable {
	 * lpSearchPg = new SearchPg(driver); bookTitle =
	 * lpSearchPg.clickRandomBookTakeQuizButton(); if
	 * (!(bookTitle.trim().length() > 1)) {
	 * scenario.write("No Books found with the 'Take quiz' button." +
	 * bookTitle); throw new PendingException(); }
	 * 
	 * scenario.write("Attended quiz for book: " + bookTitle); }
	 */

	@And("^I should not be able to take a quiz for the above random book again$")
	public void i_click_Take_Quiz_button_for_above_book() throws Throwable {
		lpSearchPg = new SearchPg(driver);
		lpSearchPg.clickKnowBookTakeQuizButton();
	}

	@And("^I should see my rating button. verify the book title and book comment \"([^\"]*)\"$")
    public void i_should_see_my_rating_button_verify_the_book_title_and_book_comment_something(String CommentVerify) throws Throwable {
    	lpSearchPg = new SearchPg(driver);
		assertTrue(
				"\"See my Rating\" popup is not working at search tab as expected.",
				lpSearchPg.SeeMyRatingButton());
		String Actual=CommentVerify;
		String Expected = lpSearchPg.CommentVerifying(CommentVerify);
		assertTrue(
				"Comments in the section is not matching",
				Actual.equalsIgnoreCase(Expected));
		lpSearchPg.DoneButton();
	}

	@And("^I should see the error message$")
	public void Error_mesage() throws InterruptedException {
		// lpQuizModal.Error_mesages();
		assertTrue(
				"Error message \"You have exceeded max attempts for this quiz.\" not dispalyed.",
				lpQuizModal.Error_mesages());
	}

	@And("^I should be able to take a quiz again for the above book$")
	public void Take_quiz_popup() {
		// lpQuizModal.Error_mesages();
		assertTrue("Error message should not be dispalyed.",
				lpQuizModal.QuizzeBox());
	}

	@And("^I should click Take Quiz button in Quiz Popup and verify error message for the above book$")
	public void TakeQuizButton_ErrorMoreDays_Mesage() {
		// lpQuizModal.Error_mesages();
		assertTrue("Quiz should not be shown",
				lpQuizModal.TakeQuizVerifyError());
	}

	@Then("^I should see score and percentage and verify if student passed or failed$")
	public void Verify_score_and_percentage_PassorFail() throws Throwable {
		assertTrue(
				"Students have not passed the quiz even after scoring more then set pass percentage",
				lpQuizModal.testScore());
		lpQuizModal.clickDoneBtn();
	}
	@When("^I click Take Quiz button in Quiz Popup for error$")
	public void i_click_Take_Quiz_button_in_Quiz_Popup_for_error() throws Throwable {
		lpQuizModal.clickTakeQuizError(); 
	}
	@Then("^I navigate to the search page showing results for word \"([^\"]*)\"$")
	public void i_navigate_to_the_search_page_showing_results_for_word(String key) throws Throwable {
		lpSearchPg = lpHome.goToSeachPage();
		SearchPg lpSearchPg= new SearchPg(driver,LitProUserType.STUDENT);
		String actual = lpSearchPg.getPageHeader();
		String expected = "Search";
		assertTrue("The expected Search Page Header was '" + expected
				+ "' but actually was: " + actual,
				actual.equalsIgnoreCase(expected));
		lpSearchPg.checkQuizzesOnly();
		lpSearchPg.typeSearchKeyAndHitQuickSearchBtn(key);
		lpHome.waitWhenLoadingBarActive();
	}
	

}
