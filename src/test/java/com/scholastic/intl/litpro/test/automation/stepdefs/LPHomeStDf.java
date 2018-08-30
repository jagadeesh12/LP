package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.BenchmarkPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.MyResultsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SDMSignInPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SettingsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.VerifyReadingInterestsList;
import com.scholastic.torque.common.TestBaseProvider;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("deprecation")
public class LPHomeStDf{

	
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	LitProUserType lpUserType;
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	LitProHomePg lpHome = new LitProHomePg(driver,lpUserType);
	ReportsPg reportspg = new ReportsPg(driver, lpUserType);
	SettingsPg settingpg = new SettingsPg(driver, lpUserType);
	BenchmarkPg benchmarkpg = new BenchmarkPg(driver, lpUserType);
	SearchPg searchpg = new SearchPg(driver,lpUserType);
	MyResultsPg myresultspg = new MyResultsPg(driver, lpUserType);
	BasePage base = new BasePage(driver);
	Scenario scenario;
	List<Map<String, String>> listCats;
	List<Map<String, String>> listHomepageCategories;
	String selectedCategoryName;
	String selectedCreateListCategoryName;
	List<String> selectedCategories;
	List<String> createRLSelectedCategories;
	int selectCount = 0;
	boolean creatingReadingInterestFuncFlag = false;
	List<VerifyReadingInterestsList> recommendedBooks;
	List<VerifyReadingInterestsList> fastFindBooks;
	List<String> expectedRIcats;
	String Lexile;
	


	/*
	 * POJO for storing the book categories public class
	 * VerifyReadingInterestsList { public String title = ""; public String
	 * author = ""; public String categories=""; //comma separated
	 * 
	 * @Override public String toString(){ return "{BookTitle:" + title +
	 * ", Author:" + author + ", Categories:" + categories+ "}"; } }
	 */
	/*
	 * public LPHomeStDf(SharedDriver driver) { this.driver = driver; }
	 */
//	@Before
//	public void before(Scenario scenario) {
//		this.scenario = scenario;
//	}

	@Given("^I browse to LitPro homepage as \"(.*?)\"$")
	public void i_browse_to_LitPro_homepage_as(String userType)
			throws Throwable {
		slzLogin = new SlzLoginPg(driver);
//		assertTrue("Failed to Launch AUT due to missing info. Check the log.",
//				slzLogin.launchSlz());
//		lpUserType = slzLogin.getLitProUserType(userType);
//		slzHome = slzLogin.loginAs(lpUserType);
//		scenario.write("Credentials: " + slzLogin.getUserCreds());

	//	lpHome = slzHome.launchLitPro(lpUserType);
		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
	}

@Given("^I launch LitPro homepage using \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$")
public void i_launch_LitPro_homepage_using_and_with(String username,
		String password, String userType) throws Throwable {
	slzLogin = new SlzLoginPg(driver);
//	assertTrue("Failed to Launch AUT due to missing info. Check the log.",
//			slzLogin.launchSlz());
   lpUserType = slzLogin.getLitProUserType(userType);

//	slzHome = slzLogin.login(username, password);
	base.loginApp(username, password);
	//scenario.write("Credentials:username,password ");
	base.launchApp(lpUserType);
//	lpHome = slzHome.launchLitPro(lpUserType);

	assertNotNull("Could NOT launch litpro. Check log", lpHome);
	Thread.sleep(5000);

    
}

	@Then("^I should see user greeting text 'Welcome, '$")
	public void i_should_see_user_greeting_text_Welcome() throws Throwable {
		String expected = "Welcome,";
		LitProHomePg lpHome = new LitProHomePg(driver, lpUserType);
		String actual = lpHome.getUserGreetingText();
		assertTrue("The expected Greet Text was '" + expected
				+ "' but actually was: " + actual, actual.contains("Welcome, "));
	}

	@Then("^I should see the header - \"(.*?)\"$")
	public void i_should_see_the_header(String landingHeader) throws Throwable {
		LitProHomePg lpHome = new LitProHomePg(driver);
		String displayedText = lpHome.getCreateReadingListHeader();
		if (displayedText.length() >= 1) {
			creatingReadingInterestFuncFlag = true;
			assertTrue("The expected header text was '" + landingHeader
					+ "' but actually was: " + displayedText,
					displayedText.contains(landingHeader));

		} else {
			System.out.println("reading list has been created already");
			//scenario.write("reading list has been created already");
		}
	}

	@Then("^I should see the following reading interest categories:$")
	public void i_should_see_the_following_reading_interest_categories(
			List<Map<String, String>> categories) throws Throwable {
		listHomepageCategories = categories;
		if (creatingReadingInterestFuncFlag) {
			Iterator<Map<String, String>> inIterator = categories.iterator();
			while (inIterator.hasNext()) {
				Map<String, String> row = inIterator.next();
				assertTrue(row.get("Reading Interest Categories"),
						lpHome.isReadingInterestCategoryExist(row
								.get("Reading Interest Categories")));
			}
		}

	}

	@Then("^I select (\\d+) random categories$")
	public void i_select_random_categories(int count) throws Throwable {
		selectCount = count;
		int size = listHomepageCategories.size();
		int random;
		// System.out.println("list size:"+size);
		createRLSelectedCategories = new ArrayList<String>();
		if (creatingReadingInterestFuncFlag) {
			for (int i = 0; i < count; i++) {
				random = (int) (Math.random() * size);
				System.out.println("Random number:" + random);
				lpHome.selectInterestCategories(listHomepageCategories.get(
						random).get("Reading Interest Categories"));
				selectedCreateListCategoryName = listHomepageCategories.get(
						random).get("Reading Interest Categories");
				createRLSelectedCategories.add(selectedCreateListCategoryName);
				// System.out.println("category name:"+selectedCreateListCategoryName);
				// System.out.println("Selected category: "+
				// createRLSelectedCategories.get(i));
			}
		}
	}

	@When("^I click 'Create my reading list' button on my homepage$")
	public void i_click_Create_my_reading_list_button() throws Throwable {
		if (creatingReadingInterestFuncFlag) {
			lpHome.clickCreateReadingIntBtn();
		}

	}

	@Then("^I should see My reading interests list$")
	public void i_should_see_My_reading_interests_list() throws Throwable {
		if (creatingReadingInterestFuncFlag) {
			for (int i = 0; i < selectCount; i++) {
				assertTrue(
						selectedCreateListCategoryName,
						lpHome.isSelectedCategoryDisplayed(createRLSelectedCategories
								.get(i)));
			}
		}

		// lpHome.getBooksReadingInterests();
	}

	@Then("^I click on Edit Reading Interests$")
	public void i_click_on_Edit_Reading_Interests() throws Throwable {
		lpHome = new LitProHomePg(driver, lpUserType);
		lpHome.editReadingInterests();
	}

	@Then("^I should see the modal popup header - \"(.*?)\"$")
	public void i_should_see_the_modal_popup_header(String arg1)
			throws Throwable {
		assertTrue("Modal Header is empty ", !lpHome.getModalHeader().trim()
				.isEmpty());
	}

	@Then("^I should see the following reading interest categories in modal popup:$")
	public void i_should_see_the_following_reading_interest_categories_in_modal_popup(
			List<Map<String, String>> option) throws Throwable {
		listCats = option;

		Iterator<Map<String, String>> inIterator = option.iterator();
		while (inIterator.hasNext()) {
			Map<String, String> row = inIterator.next();
			assertTrue(row.get("Reading Interest Categories"),
					lpHome.isReadingInterestCategoryExist(row
							.get("Reading Interest Categories")));
		}
	}

	@Then("^I will deselect the selected reading interest categories$")
	public void i_will_deselect_the_selected_reading_interest_categories()
			throws Throwable {
		lpHome.deselectInterestCats();
	}

	@Then("^I select different reading interest categories$")
	public void i_select_different_reading_interest_categories()
			throws Throwable {
		int size = listCats.size();
		int random;
		System.out.println("list size:" + size);
		selectedCategories = new ArrayList<String>();
		for (int i = 0; i < 2; i++) {
			random = (int) (Math.random() * size);
			System.out.println("Random number:" + random);
			lpHome.selectReadingInterest(listCats.get(random).get(
					"Reading Interest Categories"));
			selectedCategoryName = listCats.get(random).get(
					"Reading Interest Categories");
			selectedCategories.add(selectedCategoryName);
			// System.out.println("category name:"+selectedCategoryName);
			System.out.println("Selected category: "
					+ selectedCategories.get(i));
		}
	}

	@Then("^I click on update reading list button$")
	public void i_click_on_update_reading_list_button() throws Throwable {
		lpHome.clickUpdateReadingIntBtn();
	}

	@Then("^I should be able to view my updated reading interest categories$")
	public void i_should_be_able_to_view_my_updated_reading_interest_categories()
			throws Throwable {
		for (int i = 0; i < 2; i++) {
			assertTrue(selectedCategoryName,
					lpHome.isSelectedCategoryDisplayed(selectedCategories
							.get(i)));
		}
	}

	@When("^I have selected my reading interest categories$")
	public void i_have_selected_my_reading_interest_categories()
			throws Throwable {
		expectedRIcats = lpHome.getReadingInterestsSelected();
		// assertTrue("Student does NOT have any reading interest categories",
		// expectedRIcats.isEmpty());

		if (expectedRIcats.isEmpty()) {
			/*
			 * Checking if there are any reading interests selected by student;
			 * if not, skipping the verification steps
			 */
			System.out.println("Student does NOT have any reading interest categories");
		//	scenario.write("Student does NOT have any reading interest categories");
			throw new PendingException();
		}
	}

	@Then("^I should see the header 'Here are some great books to read!'$")
	public void i_should_see_the_header_Here_are_some_great_books_to_read()
			throws Throwable {
		lpHome.getCategoryResultsHeader();
	}

	@Then("^Book title or author name should not be empty$")
	public void book_title_or_author_name_should_not_be_empty()
			throws Throwable {
		lpHome.waitForPageLoad(30);
		lpHome.lazyWait(10);
		recommendedBooks = new ArrayList<VerifyReadingInterestsList>();
		recommendedBooks = lpHome.getBooksReadingInterests();

		for (VerifyReadingInterestsList book : recommendedBooks) {
			assertTrue("Book title is empty", book.title.length() > 0);
			assertTrue("Book '" + book.title
					+ "' does NOT have author name. Actual Author Name:"
					+ book.author, book.author.length() > 0);
		}
	}

	@Then("^all the books should have atleast one of the reading interest categories$")
	public void all_the_books_should_have_atleast_one_of_the_reading_interest_categories()
			throws Throwable {
		for (VerifyReadingInterestsList book : recommendedBooks) {
			boolean flag = false;
			// System.out.println("----------------" + book.title +
			// "-----------------");
			for (String ri : expectedRIcats) {
				System.out.println("ri: " + ri);
				System.out.println("\n  CATS: " + book.categories);
				System.out.println("\n  CATS: " + book.author);

				if (!(book.author==null)) {
					flag = true;
					break;
				}
				// System.out.println("FLAG: " + flag);
				// System.out.println("------------------------------------------------------");
			}
			assertTrue(
					"Book '"
							+ book.author
							+ "' does NOT have the author name",
					flag);
		}
	}

	@When("^I click on 'Fast find' button$")
	public void i_click_on_Fast_find_button() throws Throwable {
		lpHome.clickFastFindButton();
	}

	@When("^I click on Whats New button$")
	public void i_click_on_What_s_New_button() throws Throwable {
		lpHome.clickWhatsNewButton();
		// throw new PendingException();
	}

	@Then("^validate with edit or create reading list$")
	public void validate_with_edit_or_create_reading_list() throws Throwable {
		lpHome = new LitProHomePg(driver, lpUserType);
		if (lpHome.EditReadingInterestsButtonNotVisible()) {
			lpHome.clickUpdateReadingIntBtn();

		} else
			lpHome.clickCreateReadingIntBtn();

	}

	@When("^I click on corresponding list button$")
	public void i_click_on_corresponding_list_button() throws Throwable {
		// lpHome = new LitProHomePg(driver, lpUserType);
		if (lpHome.EditReadingInterestsButtonNotVisible()) {
			lpHome.clickUpdateReadingIntBtn();

		} else
			lpHome.clickCreateReadingIntBtn();

	}

	@Given("^a teacher launches Reading Pro using \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\" from SDM$")
	public void a_teacher_launches_Reading_Pro_using_and_with_from_SDM(String username, String password, String userType) throws Throwable {
		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);
		base.launchPortal(lpUserType);
		base.loginApp(username, password);
		base.launchApp(lpUserType);
	}

	

@Given("^I launch RPL using \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$")
public void i_launch_RPL_using_and_with(String username, String password, String userType) throws Throwable {

	slzLogin = new SlzLoginPg(driver);
	LitProUserType lpUserType = slzLogin.getLitProUserType(userType);
	base.loginApp(username, password);
	base.launchRPLLPL(lpUserType);
	Thread.sleep(5000);


}

@Then("^the SDM-specific headers elements will be present in the RPL header$")
public void the_SDM_specific_headers_elements_will_be_present_in_the_RPL_header() throws Throwable {
    
}

@Given("^I launch RP using \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$")
public void i_launch_RP_using_and_with(String username, String password, String userType) throws Throwable {
	slzLogin = new SlzLoginPg(driver);
	LitProUserType lpUserType = slzLogin.getLitProUserType(userType);
	base.loginApp(username, password);
	base.launchApp(lpUserType);
	Thread.sleep(5000);
}


@Then("^the user should see the new reading pro logo on all the screens$")
public void the_user_should_see_the_new_reading_pro_logo_on_all_the_screens() throws Throwable {
 	String image = "logo_scholastic_srpus.png";
	String attribute = lpHome.getAttribute(lpHome.getRPlogo(), "src");
	Assert.assertTrue(attribute.contains(image));
	reportspg = lpHome.goToReportsPage();
	Assert.assertTrue(attribute.contains(image));
	benchmarkpg = lpHome.goToBenchmarksPage();
	Assert.assertTrue(attribute.contains(image));
	settingpg = lpHome.goToSettingPage();
	Assert.assertTrue(attribute.contains(image));
	searchpg = lpHome.goToSeachPage();
	Assert.assertTrue(attribute.contains(image));
}

@Then("^the user should see the new reading pro logo on all the  four screens$")
public void the_user_should_see_the_new_reading_pro_logo_on_all_the_four_screens() throws Throwable {
	String image = "logo_scholastic_srpus.png";
	String attribute = lpHome.getAttribute(lpHome.getRPlogoStudent(), "src");
	Assert.assertTrue(attribute.contains(image));
	searchpg = lpHome.goToSeachPage();
	Assert.assertTrue(attribute.contains(image));
	myresultspg = lpHome.goToMyResultsPage();
	Assert.assertTrue(attribute.contains(image));

}

@Then("^the user should see the new reading pro library logo on all the screens\\.$")
public void the_user_should_see_the_new_reading_pro_library_logo_on_all_the_screens() throws Throwable {
	String image = "logorplus.png";
	String attribute = lpHome.getAttribute(lpHome.getRPLlogo(), "src");
	Assert.assertTrue(attribute.contains(image));
}

@Then("^the user should see the new reading pro library logo on all the four screens$")
public void the_user_should_see_the_new_reading_pro_library_logo_on_all_the_four_screens() throws Throwable {
	String image = "logorplus.png";
	String attribute = lpHome.getAttribute(lpHome.getRPLlogo(), "src");
	Assert.assertTrue(attribute.contains(image));
}
@Then("^the SDM-specific headers elements will be present in the RP header like sdm nav bar,apps drop down,log out link$")
public void the_SDM_specific_headers_elements_will_be_present_in_the_RP_header_like_sdm_nav_bar_apps_drop_down_log_out_link() throws Throwable {
   lpHome.verifySDMHeaders();
}
@When("^the user clicks on their name in the top right of header$")
public void the_user_clicks_on_their_name_in_the_top_right_of_header() throws Throwable {
  lpHome.clickOnUserName();
}

@When("^clicks on logout$")
public void clicks_on_logout() throws Throwable {
 lpHome.clickOnLogout(); 
}

@Then("^the user will experience the SDM-defined logout behavior$")
public void the_user_will_experience_the_SDM_defined_logout_behavior() throws Throwable {
	Thread.sleep(5000);
   Assert.assertTrue(driver.getCurrentUrl().contains("dp-portal"));
   SDMSignInPage  sdmsignin = new SDMSignInPage(driver);
   sdmsignin.verifyUnamePwdSigninBtnDisplayed();
}
@When("^the user clicks on the app matrix icon in the top right of header and clicks on the Scholastic Digital Manager in the dropdown$")
public void the_user_clicks_on_the_app_matrix_icon_in_the_top_right_of_header_and_clicks_on_the_Scholastic_Digital_Manager_in_the_dropdown() throws Throwable {
    lpHome.clickOnReturnToSDM();
    Thread.sleep(3000);
    
}

@Then("^the user will experience the SDM-defined SDM navigation behavior$")
public void the_user_will_experience_the_SDM_defined_SDM_navigation_behavior() throws Throwable {
   Assert.assertTrue(driver.getCurrentUrl().contains("products"));
}
@When("^the user clicks on the app matrix icon in the top right of header,another app name is present in the dropdown and clicks on the other app name$")
public void the_user_clicks_on_the_app_matrix_icon_in_the_top_right_of_header_another_app_name_is_present_in_the_dropdown_and_clicks_on_the_other_app_name() throws Throwable {
   lpHome.clickOnAnotherProduct();
   ParentPage parent = new ParentPage(driver);
   parent.switchToNewWindow();
   Thread.sleep(3000);
}

@Then("^the user will experience the SDM-defined other app navigation behavior$")
public void the_user_will_experience_the_SDM_defined_other_app_navigation_behavior() throws Throwable {
    Assert.assertTrue(driver.getCurrentUrl().contains("lplibrary"));
}
@Then("^the user will experience the SDM-defined SDM navigation behavior for student$")
public void the_user_will_experience_the_SDM_defined_SDM_navigation_behavior_for_student() throws Throwable {
	  Assert.assertTrue(driver.getCurrentUrl().contains("studentportal"));
}

@Then("^the user will experience the SDM-defined SDM navigation behavior for admin$")
public void the_user_will_experience_the_SDM_defined_SDM_navigation_behavior_for_admin() throws Throwable {
	  Assert.assertTrue(driver.getCurrentUrl().contains("subscriptions"));
}
@Then("^the user will experience the SDM-defined other app navigation behavior by navigating to another app\\.$")
public void the_user_will_experience_the_SDM_defined_other_app_navigation_behavior_by_navigating_to_another_app() throws Throwable {
	Assert.assertTrue(driver.getCurrentUrl().contains("litpro"));
}
@Then("^I Should see \"([^\"]*)\" in the Dash board$")
public void i_Should_see_in_the_Dash_board(String arg1) throws Throwable {
	assertTrue("There are dublicate benchmarks",
			lpHome.getDashboarData(arg1).contains(arg1)); 
}
}

