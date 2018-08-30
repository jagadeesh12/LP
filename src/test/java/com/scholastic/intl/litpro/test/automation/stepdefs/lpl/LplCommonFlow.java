package com.scholastic.intl.litpro.test.automation.stepdefs.lpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//import com.google.common.base.Verify;



import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.scholastic.intl.litpro.test.automation.pageobjects.lpl.BooksPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.lpl.CollectionsPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.lpl.LitProLibraryHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.lpl.StudentsPage;
//import stepdefination.SharedDriver;
import com.scholastic.intl.litpro.test.automation.stepdefs.LPHomeStDf;
import com.scholastic.intl.litpro.test.automation.stepdefs.lpl.*;
import com.scholastic.torque.common.TestBaseProvider;

/* @ Author: Rajesh R
 * @ Created Date:04/01/2016
 * @ Functionality:Common Flows step Definition
 * @ Type: Smoke, regression
 * 
 * 
 * @ Updated Date
 * @ Updated By Rajesh R
 * 
 */

public class LplCommonFlow {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	// Scenario scenario;
	SlzLoginPg slzLogin = null;
	SlzHomePg slzHome;
	LitProLibraryHomePg lplHome;
	StudentsPage stdPage;
	BooksPage bookPage;
	CollectionsPage collectionPage;
	String beforeAssign = null;
	BasePage base = new BasePage(driver);
	LitProUserType lpUserType;
	SlzHomePg slzHomePg;

	@When("^I launch LitProLibrary as \"(.*?)\"$")
	public void i_launch_LitProLibrary_as(String userType) throws Throwable {
		SlzLoginPg slzLogin = new SlzLoginPg(driver);
		lpUserType = slzLogin.getLitProUserType(userType);
		base.launchPortal(lpUserType);
		SlzHomePg slzHome = new SlzHomePg(driver);
		base.launchRPLLPL(lpUserType);

		lplHome = new LitProLibraryHomePg(driver, lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lplHome);
	}

	@When("^I login into SLZ as a \"([^\"]*)\"$")
	public void i_login_into_SLZ_as_a(String userType) throws Throwable {
		SlzLoginPg slzLogin = new SlzLoginPg(driver);
		lpUserType = slzLogin.getLitProUserType(userType);
		base.launchPortal(lpUserType);
		SlzHomePg slzHome = new SlzHomePg(driver);

	}

	@Then("^I should click on \"([^\"]*)\" in roster tree$")
	public void i_should_click_on_something_in_roster_tree(String Schoolname) throws Throwable {
		slzHomePg = new SlzHomePg(driver);
		slzHomePg.SchoolName(Schoolname);
	}

	@Then("^I should click on student \"([^\"]*)\" in roster tree$")
	public void i_should_click_on_student_something_in_roster_tree(String StudName) throws Throwable {
		slzHomePg.StudName(StudName);
	}

	@Then("^I should compare usage detail info of student with teacher$")
	public void i_should_compare_usage_detail_info_of_student_with_teacher() throws Throwable {
		assertTrue("Teacher and Student usage details are not matching for LPL", slzHomePg.UsageDetailCompare());
	}

	@Then("^I should wait for sometime in LPL page$")
	public void i_should_wait_for_something_min_in_lpl_page() throws Throwable {
		slzHomePg.WaitinLPL();
	}

	@And("^Logout of LPL$")
	public void logout_of_lpl() throws Throwable {
		slzHomePg.logout();
	}

	@Then("^I should open LPL application$")
	public void i_should_open_lpl_application() throws Throwable {
		slzHomePg.launchRPLLPL();
	}

	@Then("^I should collect the usage detail info$")
	public void i_should_collect_the_usage_detail_info() throws Throwable {
		slzHomePg = new SlzHomePg(driver);
		slzHomePg.StudentLPLSession();
		slzHomePg.StudentLPLMinutes();
	}

	@Then("^I should collect the usage details info and verify the information$")
	public void i_should_collect_the_usage_details_info_and_verify_the_information() throws Throwable {
		slzHomePg = new SlzHomePg(driver);
		assertTrue("Verifed the usage details they have not increased even after usage", slzHomePg.VerifyUsagereport());
	}

	@Then("^I should see Scholastic Literacy Library Home Page$")
	public void i_should_see_Scholastic_Literacy_Library_Home_Page() throws Throwable {
		lplHome = new LitProLibraryHomePg(driver, lpUserType);
		assertTrue("The expected LitproLibrary icon is not displayed ", lplHome.isLitproLibraryIconDisplayed());
	}

	@Then("^I should see user Profile$")
	public void i_should_see_user_Profile() throws Throwable {
		assertTrue("The expected LitproLibrary icon is not displayed ", lplHome.isUserProfileDisplayed());
	}

	@When("^I click on collection tab$")
	public void i_click_on_collection_tab() throws Throwable {
		// collectionPage.goToBooksPage();
	}

	@When("^I click on message icon$")
	public void i_click_on_message_icon() throws Throwable {
		lplHome.MessageIcon();
	}

	@Then("^student should see a message \"([^\"]*)\" for collection assignment$")
	public void student_should_see_a_message_something_for_collection_assignment(String Message) throws Throwable {
		assertTrue("The Collection Assiging message was not displayed to student", lplHome.AssignmentMessage(Message));
	}

	@When("^I click on the collection message student$")
	public void i_click_on_the_collection_message_student() throws Throwable {
		assertTrue("The collection assigned by teacher is NOT visible to student", lplHome.ClickCollectionMessage());
	}

	@Then("^I should see litLibrary below tabs:$")
	public void i_should_see_litLibrary_below_tabs(List<String> tabList) throws Throwable {
		System.out.println(lpUserType);
		lplHome = new LitProLibraryHomePg(driver, lpUserType);
		String actual = lplHome.getDisplayedTabNames().toString();
		System.out.println(lplHome.getDisplayedTabNames().toString());
		String expected = tabList.toString();

		assertTrue("The expected Tabs list was '" + expected + "' but actually was: " + actual,
				actual.contains(expected));
	}

	@Then("^I should see Logout dropdown$")
	public void i_should_see_Logout_dropdown() throws Throwable {
		assertTrue("The expected Logout  is not displayed ", lplHome.isLogOutDisplayed());
		Thread.sleep(6000);
	}

	@When("^I click on Students tab$")
	public void i_click_on_Students_tab() throws Throwable {
		stdPage = lplHome.goToStudentsPage();

	}

	@Then("^I should see Students Page$")
	public void i_should_see_Students_Page() throws Throwable {
		assertTrue("Students page header is not displayed", stdPage.verifyStudentsheader());

	}

	@Then("^I should see student profile$")
	public void i_should_see_student_profile() throws Throwable {
		assertTrue("Students Profiles is not displayed", stdPage.verifyStudentsheader());

	}

	@When("^I click on Books tab$")
	public void i_click_on_Books_tab() throws Throwable {
		bookPage = lplHome.goToBooksPage();
	}

	@And("^I should search for Hidden book$")
	public void i_should_search_for_hidden_book() throws Throwable {
		bookPage.Searchhiddenbook();
	}

	@When("^I set a lexile level from \"([^\"]*)\" to \"([^\"]*)\" for Student$")
	public void i_set_a_lexile_level_from_something_to_something_for_student(String StrtLexile, String EndLexile)
			throws Throwable {
		bookPage.LexileRangeStudent(StrtLexile, EndLexile);
	}

	@Then("^I should see Books  Page$")
    public void i_should_see_books_page() throws Throwable {
		assertTrue("Books page  is not displayed", bookPage.verifyBookPage());
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Then("^I should see Assign books Header$")
	public void i_should_see_Assign_books_Header() throws Throwable {
		assertTrue("Books header  is not displayed", bookPage.verifyBookHeader());

	}

	@When("^I click on Collections tab$")
	public void i_click_on_Collections_tab() throws Throwable {
		collectionPage = lplHome.goToCollectionsPage();
	}

	@Then("^I should see collections Page$")
	public void i_should_see_collections_Page() throws Throwable {
		assertTrue("Books header  is not displayed", collectionPage.verifyCollectionHeader());
	}

	@When("^I should open a Collection$")
	public void i_should_open_a_collection() throws Throwable {
		collectionPage.OpenCollection();
	}

	@And("^I should sort the books of collection by \"([^\"]*)\"$")
	public void i_should_sort_the_books_of_collection_by_something(String SortBy) throws Throwable {
		collectionPage.SortCollection(SortBy);
	}

	@Then("^I should see the books of the collections arranged by \"([^\"]*)\"$")
	public void i_should_see_the_books_of_the_collections_arranged_by_something(String Sorting) throws Throwable {
		assertTrue("Books in collections are not sorting according to \"" + Sorting + "\"",
				collectionPage.VerifySortingCollection(Sorting));
	}

	@Then("^I should see collections Page Student$")
	public void i_should_see_collections_page_student() throws Throwable {
		assertTrue("Books header  is not displayed", collectionPage.verifyCollectionHeaderStudent());
	}

	@When("^I should open a Collection as a student$")
	public void i_should_open_a_collection_as_a_student() throws Throwable {
		collectionPage.OpenCollectionStudent();
	}

	@And("^I should verify that collections are arrange in alphabetical order in student collection page$")
	public void i_should_verify_that_collections_are_arrange_in_alphabetical_order_in_student_collection_page()
			throws Throwable {
		assertTrue("Books header  is not displayed", collectionPage.CollectionAlphabeticalOrderStudent());
	}

	@And("^I should verify that collections are arrange in alphabetical order$")
	public void i_should_verify_that_collections_are_arrange_in_alphabetical_order() throws Throwable {
		assertTrue("Collectiosn are not displayed in Aplhabetical order",
				collectionPage.CollectionAlphabeticalOrderStudent());
	}

	@Then("^I should see number of Students$")
	public void i_should_see_number_of_Students() throws Throwable {
		assertTrue("Students is not displayed", lplHome.verifySudents());
	}

	@Then("^I should see Assigned books$")
	public void i_should_see_Assigned_books() throws Throwable {
		assertTrue("Assigned Books is not displayed", lplHome.verifyAssignedBooks());
	}

	@Then("^I should see Completed Books$")
	public void i_should_see_Completed_Books() throws Throwable {
		assertTrue("Completed Books is not displayed", lplHome.verifyCompletedBooks());
	}

	@Then("^I should see Assigned Collections$")
	public void i_should_see_Assigned_Collections() throws Throwable {
		assertTrue("CAssigned Collections is not displayed", lplHome.verifyAssignedCollections());

	}

	@Then("^I should see Words Read By Class$")
	public void i_should_see_Words_Read_By_Class() throws Throwable {
		assertTrue(" Words Read By Class is not displayed", lplHome.verifyWordsReadByClass());

	}

	@Then("^I should see Time Spent Reading by class$")
	public void i_should_see_Time_Spent_Reading_by_class() throws Throwable {
		assertTrue(" Time Spent Reading by class is not displayed", lplHome.verifyTimeSpentReadingByClass());

	}

	@Then("^I should see Average time spent per book$")
	public void i_should_see_Average_time_spent_per_book() throws Throwable {
		assertTrue("Average time spent per book is not displayed", lplHome.verifyAverageTimePerBook());

	}

	@Then("^I should see My Lexile$")
	public void i_should_see_My_Lexile() throws Throwable {
		assertTrue("My Lexile is not displayed", lplHome.verifyMyLexile());

	}

	@Then("^I should see Words Read$")
	public void i_should_see_Words_Read() throws Throwable {
		assertTrue("Words Read  is not displayed", lplHome.verifyWordsRead());
	}

	@Then("^I should see Time Spent Reading$")
	public void i_should_see_Time_Spent_Reading() throws Throwable {
		assertTrue("Time Spent Reading is not displayed", lplHome.verifyTimeSpentReadingByClass());
	}

	@Then("^I should see the books page$")
	public void i_should_see_the_books_page() throws Throwable {
		assertTrue("Books page is not displayed", bookPage.isBooks_Page_dislayed());
	}
	
	@And("^I should see the hiden book as grey$")
    public void i_should_see_the_hiden_book_as_grey() throws Throwable {
		assertTrue("Books page is not displayed", bookPage.isBooks_HideBook_Grey());
    }
	
	@When("^I try to assign the hidden book to student$")
    public void i_try_to_assign_the_hidden_book_to_student() throws Throwable {
		bookPage.AssignHiddenBook();
    }

    @Then("^I should not be able to assign it$")
    public void i_should_not_be_able_to_assign_it() throws Throwable {
    	assertTrue("Books are hidden still teacher is able to assign them", bookPage.HiddenBookStudentDisable());
    }

	@When("^I click on Assign text on the book$")
	public void i_click_on_Assign_text_on_the_book() throws Throwable {
		bookPage.ClickOndropDown_Selection_To_Show_Books();
		bookPage.ClickOn_Select_All();
		bookPage.clickOnAssign();
	}

	@When("^I click on ASSIGNED text on the book$")
	public void i_click_on_ASSIGNED_text_on_the_book() throws Throwable {
		// bookPage.ClickOn_Select_All();
		bookPage.clickOnASSIGNED();
	}

	@Then("^I should see the pop up with Read and Assign buttons$")
	public void i_shoiuld_see_the_pop_up_with_Read_and_Assign_buttons() throws Throwable {
		assertTrue("Read button is not dislayed", bookPage.isReadbuttondislayed());
		assertTrue("Assign button is not dislayed", bookPage.isAssignbuttondislayed());
	}

	@Then("^I should see the Assign Books and Hide Books options are disabled$")
	public void i_should_see_the_Assign_Books_and_Hide_Books_options_are_disabled() throws Throwable {
		assertTrue("Assign Books button is enabled", bookPage.isAssign_books_hidden_button_displayed());
		assertTrue("Hide Books button is enabled", bookPage.isHide_books_hidden_button_displayed());
	}

	@Then("^I should see the Assign Books and Hide Books options are enabled$")
	public void i_should_see_the_Assign_Books_and_Hide_Books_options_are_enabled() throws Throwable {
		assertTrue("Assign Books button is disabled", bookPage.isAssign_books_enabled_button_displayed());
		assertTrue("Hide Books button is disabled", bookPage.isHide_books_enabled_button_displayed());
	}

	@Then("^I should see the pop up with Read and Assigned buttons$")
	public void i_shoiuld_see_the_pop_up_with_Read_and_Assigned_buttons() throws Throwable {
		assertTrue("Read button is not dislayed", bookPage.isReadbuttondislayed());
		assertTrue("Assigned button is not dislayed", bookPage.isAssignedbuttondislayed());
	}

	@When("^I click on Home tab$")
	public void i_click_on_home_tab() throws Throwable {
		bookPage.Hometab();
	}

	@Then("^I should verify that Recent Assignments should contain above book$")
	public void i_should_verify_that_recent_assignments_should_contain_above_book() throws Throwable {
		assertTrue("Recent Assignments doesnot contain Assigned books", bookPage.VerifyBooksInRecentAssignments());
	}

	@And("^I should verify that Recent student activity should contain above book with Status as \"([^\"]*)\"$")
	public void i_should_verify_that_recent_student_activity_should_contain_above_book_with_status_as_something(
			String Status) throws Throwable {
		assertTrue("Recent student activity doesnot contain Assigned books",
				lplHome.VerifyBooksInRecentStudentActivity(Status));
	}

	@When("^I click on Assign button$")
	public void i_click_on_Assign_button() throws Throwable {
		bookPage.clickOn_Assign_InPopup();
	}

	@When("^I click on Assigned button$")
	public void i_click_on_Assigned_button() throws Throwable {
		bookPage.clickOn_Assigned_InPopup();
	}

	@When("^I click on Choose Multiple Books button$")
	public void i_click_on_Choose_Multiple_Books_button() throws Throwable {
		// bookPage.UnassignBooks();
		bookPage.clickOn_Choose_Multiple_Books();

	}

	@When("^I click on Assign Books button$")
	public void i_click_on_Assign_Books_button() throws Throwable {
		bookPage.clickOnAssign_books_enabled();

	}

	@When("^I select the multiple books by clicking on tick mark$")
	public void i_select_the_multiple_books_by_clicking_on_tick_mark() throws Throwable {
		bookPage.ClickOnFirstBook();
		bookPage.ClickOnSecondBook();
		bookPage.ClickOnThirdBook();

	}

	@Then("^I should see the Assign to header$")
	public void i_should_see_the_Assign_to_header() throws Throwable {
		assertTrue("Text is not displayed", bookPage.isAssign_to_text_displayed());
	}

	@Then("^I should see the Assigned to header$")
	public void i_should_see_the_Assigned_to_header() throws Throwable {
		assertTrue("Text is not displayed", bookPage.isAssigned_to_text_displayed());
	}

	@Then("^I should see the entire class students$")
	public void i_should_see_the_entire_class_students() throws Throwable {
		assertTrue("Students are not listing", bookPage.isEntireClass_students_dislayed());
		// scenario.write("Students are not listing"+
		// function.isEntireClass_students_dislayed());

	}

	@When("^I click on Assign to students$")
	public void i_click_on_Assign_to_students() throws Throwable {
		bookPage.clickOnAssign_to_Students();
	}

	@Then("^successful pop up should be displayed$")
	public void successful_pop_up_should_be_displayed() throws Throwable {
		String actual = bookPage.Assigned_text();
		String expected = "This assignment has been sent to your students";
		Assert.assertEquals(actual, expected);
	}

	@When("^I click on done button$")
	public void i_click_on_done_class() throws Throwable {
		bookPage.clickOndone_button();
	}

	@Then("^I should see the pop up with Hide/Unhide this book button$")
	public void i_should_see_the_pop_up_with_Hide_Unhide_this_book_button() throws Throwable {
		assertTrue("Hide/Unhide this book button is not dislayed", bookPage.isHide_Unhide_button_displyed());
	}

	@When("^I click on Hide/Unhide this book button$")
	public void i_click_on_Hide_Unhide_this_book_button() throws Throwable {
		bookPage.clickOn_hide_unhide_Button();
	}

	// @Test(dependsOnMethods="i_click_on_Hide_Unhide_this_book_button")
	@Then("^I should see the Hide/Unhide this book from header$")
	public void i_should_see_the_Hide_Unhide_this_book_from_header() throws Throwable {
		assertTrue("Text is not displayed", bookPage.is_hide_Unhide_text_displayed());

		// scenario.write("Text is not displayed: "+
		// function.is_hide_Unhide_text_displayed());
	}

	@When("^I click on Save changes$")
	public void i_click_on_Save_changes() throws Throwable {
		bookPage.clickOn_save_changes_button();
	}

	@When("^I click on the book$")
	public void i_click_on_the_book() throws Throwable {
		bookPage.clickOn_first_book_BooksTab();
	}

	@Then("^I should see the VIEW MESSAGES$")
	public void i_should_see_the_VIEW_MESSAGES() throws Throwable {
		assertTrue("ViewMessages Text is not displayed", bookPage.isViewMessagesDisplayed());
	}

	@When("^Click on close button$")
	public void Click_on_close_button() throws Throwable {
		bookPage.clickOn_close_button_for_OpenBook();
	}

	@Then("^I should see Assigned by my teacher header$")
	public void i_should_see_Assigned_by_my_teacher_header() throws Throwable {
		assertTrue("Assigned by my teacher Text is not displayed", lplHome.assignedByMyTeacherHeaderIsDisplayed());
	}

	@Then("^I should see Books I selected Header$")
	public void i_should_see_Books_I_selected_Header() throws Throwable {
		assertTrue("ViewMessages Text is not displayed", lplHome.booksISelectedHeaderIsDisplayed());
	}

	@Then("^I should see See All link for Books selected$")
	public void i_should_see_See_All_link_for_Books_selected() throws Throwable {
		assertTrue("See All link for Books selected not displayed", lplHome.isSeeAllLinkForBookIsDisplayed());
	}

	@Then("^I should see See All link for Assigned by my teacher$")
	public void i_should_see_See_All_link_for_Assigned_by_my_teacher() throws Throwable {
		assertTrue("See All link for Assigned by my teacher not displayed.",
				lplHome.isSeeAllLinkForAssignedByMyTeacherIsDisplayed());
	}

	@When("^I click on send audio recording$")
	public void i_click_on_send_audio_recording() throws Throwable {
		lplHome.clickAudioRecordingButton();
	}

	@Then("^I must see Cancel button$")
	public void i_must_see_Cancel_button() throws Throwable {
		assertTrue("See All link for Assigned by my teacher not displayed.", lplHome.iscancelButtonIsDisplayed());

	}

	@Then("^I must see Record button$")
	public void i_must_see_Record_button() throws Throwable {
		assertTrue("Cancel button not displayed.", lplHome.iscancelButtonIsDisplayed());

	}

	@Then("^i must see time lable$")
	public void i_must_see_time_lable() throws Throwable {
		assertTrue("Cancel button not displayed.", lplHome.isTimeLabelDisplayed());
	}

	@Then("^I should see the default books_40 to show in a page$")
	public void i_should_see_the_default_books_40_to_show_in_a_page() throws Throwable {
		assertTrue("Books Count 40 is not displayed", bookPage.is_Show_40_displayed());
	}

	@Then("^I should see the selected as 80 in a header$")
	public void i_should_see_the_selected_as_80_in_a_header() throws Throwable {
		assertTrue("Books Count 80 is not displayed", bookPage.is_Show_80_displayed());
	}

	@Then("^I should see the Assigned tag to be displayed in the current selection$")
	public void i_should_see_the_Assigned_tag_to_be_displayed_in_the_current_selection() throws Throwable {
		assertTrue("Assigned tag is not displayed", bookPage.is_Assigned_tag_displayed());
	}

	@Then("^I should see the ASSIGNED books should be displayed in the page$")
	public void i_should_see_the_ASSIGNED_books_should_be_displayed_in_the_page() throws Throwable {
		assertTrue("Assigned books are not displayed", bookPage.is_ASSINGNED_Books_displayed());
	}

	@Then("^I should see the selected as All in a header$")
	public void i_should_see_the_selected_as_All_in_a_header() throws Throwable {
		assertTrue("Books Count All is not displayed", bookPage.is_Show_All_displayed());
	}

	@Then("^I should see the Scholastic collections header$")
	public void i_should_see_the_Scholastic_collections_header() throws Throwable {
		assertTrue("Scholastic_collections_header is not displayed",
				collectionPage.isScholastic_collections_header_displayed());
	}

	@Then("^I should see the Read and Assign buttons in popup$")
	public void i_should_see_the_Read_and_Assign_buttons_in_popup() throws Throwable {
		assertTrue("Read button is not dislayed", collectionPage.isReadbuttondislayed());
		assertTrue("Assign button is not dislayed", collectionPage.isAssignbuttondislayed());
	}

	@Then("^I should see the Disable audio recording text$")
	public void i_should_see_the_Disable_audio_recording_text() throws Throwable {
		assertTrue("Disable audio recording text is not dislayed", stdPage.isDisable_audio_recording_dislayed());
	}

	@Then("^I should see the selected class students$")
	public void i_should_see_the_selected_class_students() throws Throwable {
		assertTrue("Selected class is not displayed", stdPage.isMath_class_Text_dislayed());
	}

	@Then("^I should see the selected class students in Home page$")
	public void i_should_see_the_selected_class_students_in_home_page() throws Throwable {
		assertTrue("Selected class is not displayed", lplHome.isMath_class_Text_displayed());
	}

	@Then("^I should see the Enable audio recording$")
	public void i_should_see_the_Enable_audio_recording() throws Throwable {
		assertTrue("Enable audio recording text is not dislayed", stdPage.isEnable_audio_recording_dislayed());
	}

	@Then("^I should see the MY PROFILE text and Sign Out$")
	public void i_should_see_the_MY_PROFILE_text_and_Sign_Out() throws Throwable {
		assertTrue("MY_PROFILE_text is not dislayed", lplHome.is_MY_PROFILE_Text_displayed());
		assertTrue("Sign_Out_text is not dislayed", lplHome.is_SignOut_button_displayed());
	}

	@Then("^I should see the Your profile image header$")
	public void i_should_see_the_Your_profile_image_header() throws Throwable {
		assertTrue("Your profile image_text is not dislayed", lplHome.is_Your_profile_image_header_displayed());
	}

	@Then("^I should see the changed profile image$")
	public void i_should_see_the_changed_profile_image() throws Throwable {
		assertTrue("Changed image is not dislayed", lplHome.is_middle_eastern_teacher_img_displayed());
	}

	@Then("^I should see the profile image boarder$")
	public void i_should_see_the_profile_image_boarder() throws Throwable {
		assertTrue("profile image boarder is not dislayed", lplHome.is_profile_image_boarder_displayed());
	}

	@Then("^I should see the proper webPage URL opened$")
	public void i_should_see_the_proper_webPage_URL_opened() throws Throwable {
		// assertTrue("Changed image is not
		// dislayed",lplHome.is_middle_eastern_teacher_img_displayed());
		lplHome.verify_help_link_URL();
	}

	@Then("^I should see the disabled next button$")
	public void i_should_see_the_disabled_next_button() throws Throwable {
		assertTrue("Disabled button is not displayed", lplHome.is_next_button_disabled_Recent_Assignments());
	}

	@Then("^I click on next button till end in Recent Assignments$")
	public void i_click_on_next_button_till_end_in_Recent_Assignments() throws Throwable {
		lplHome.clickOn_next_button_Recent_Assignments();
	}

	@When("^I click on Assign button in popup$")
	public void i_click_on_Assign_button_in_popup() throws Throwable {
		collectionPage.clickOn_Assign_InPopup();
	}

	@Then("^I should see the Assign to header in popup$")
	public void i_should_see_the_Assign_to_headers() throws Throwable {
		assertTrue("Text is not displayed", collectionPage.isAssign_to_text_displayed());
	}

	@When("^I click on entire class$")
	public void i_click_on_entire_class() throws Throwable {
		BooksPage function = PageFactory.initElements(driver, BooksPage.class);
		function.clickOnEntire_class();
		// bookPage.clickOnEntire_class();
	}

	@Then("^I should see the entire class students in popup$")
	public void i_should_see_the_entire_class_students_in_popup() throws Throwable {
		assertTrue("Students are not listing", collectionPage.isEntireClass_students_dislayed());
		// scenario.write("Students are not listing"+
		// function.isEntireClass_students_dislayed());
	}

	@When("^I click on select drop down button$")
	public void i_click_on_select_drop_down_button() throws Throwable {
		bookPage.ClickOndropDown_Selection_To_Show_Books();
	}

	@When("^I click on Assigned in FILTER selection$")
	public void i_click_on_Assigned_in_FILTER_selection() throws Throwable {
		bookPage.ClickOndropDown_Selection_To_Show_Books();
		bookPage.ClickOn_Select_All();
		bookPage.ClickOn_Assigned_Selection_FILTER();
	}

	@When("^I select the 80 to show$")
	public void i_select_the_80_to_show() throws Throwable {
		bookPage.ClickOn_Select_80();
	}

	@When("^I select the All to show$")
	public void i_select_the_All_to_show() throws Throwable {
		bookPage.ClickOn_Select_All();
	}

	@When("^I click on Assign to students in popup$")
	public void i_click_on_Assign_to_students_in_popup() throws Throwable {
		collectionPage.clickOnAssign_to_Students();
	}

	@When("^I click on ASSIGN text on the book in Collections Page$")
	public void i_click_on_ASSIGN_text_on_the_book_in_Collections_Page() throws Throwable {
		collectionPage.clickOn_ASSIGN_Text_On_Book();
	}

	@When("^I click assign a collection$")
	public void i_click_assign_a_collection() throws Throwable {
		collectionPage.clickOn_Assign_Collection();
	}

	@When("^I click on Disable audio recording$")
	public void i_click_on_Disable_audio_recording() throws Throwable {
		stdPage.clickOn_Disable_audio_recording();
	}

	@When("^I click on Enable audio recording$")
	public void i_click_on_Enable_audio_recording() throws Throwable {
		stdPage.clickOn_Enable_audio_recording();
	}

	@Then("^successful pop up should be displayed in popup$")
	public void successful_pop_up_should_be_displayed_in_popup() throws Throwable {
		String actual = collectionPage.Assigned_text();
		String expected = "This assignment has been sent to your students";
		Assert.assertEquals(actual, expected);
	}

	@When("^I click on done button in popup$")
	public void i_click_on_done_button() throws Throwable {
		collectionPage.clickOndone_button();
	}

	@When("^I click on the collection of books to assign$")
	public void i_click_on_the_collection_of_books_to_assign() throws Throwable {
		collectionPage.clickOn_collection_of_book_Assign();
	}

	@When("^I click on Jon Snow student$")
	public void i_click_on_Jon_Snow_student() throws Throwable {
		stdPage.clickOn_JonSnow_Student();
	}

	@When("^I click on select drop down list$")
	public void i_click_on_select_drop_down_list() throws Throwable {
		stdPage.clickOn_Select_drop_down_class();
	}

	@When("^I click on select drop down list in Home page$")
	public void i_click_on_select_drop_down_list_in_home_page() throws Throwable {
		lplHome.clickOn_Select_drop_down_class();
	}

	@When("^I click on Profile edit button$")
	public void i_click_on_Profile_edit_button() throws Throwable {
		lplHome.clickOn_Profile_edit_button();
	}

	@When("^I click on help link text in Home page$")
	public void i_click_on_help_link_text_in_Home_page() throws Throwable {
		lplHome.clickOn_Help_link();
	}

	@When("^I click on Done button in prof edit popup$")
	public void i_click_on_Done_button_in_prof_edit_popup() throws Throwable {
		lplHome.clickOn_Done_button_in_popup();
	}

	@When("^I select particular image$")
	public void i_select_particular_image() throws Throwable {
		lplHome.clickOn_middle_eastern_teacher();
	}

	@When("^I select profile image$")
	public void i_select_profile_image() throws Throwable {
		lplHome.clickOn_teacher();
	}

	@When("^I click on profile selection drop down list in Home page$")
	public void i_click_on_profile_selection_drop_down_list_in_Home_page() throws Throwable {
		lplHome.clickOn_Profile_select_button();
	}

	@When("^I select the specific class$")
	public void i_select_the_specific_class() throws Throwable {
		stdPage.clickOn_Math_class();
	}

	@When("^I select the specific class in Home page$")
	public void i_select_the_specific_class_in_home_page() throws Throwable {
		lplHome.clickMath_class_selection();
	}

	@When("^I click on book in Assigned by Teacher$")
	public void i_click_on_book_in_Assigned_by_Teacher() throws Throwable {
		lplHome.clickOn_first_assigned_book_by_teacher();
	}

	// 05/02/2016
	@Then("^I Should see Quiz button$")
	public void i_should_see_quiz_button() throws Throwable {
		assertTrue("Quiz button not displayed", bookPage.isQuizButtondisplayed());
	}

	@Then("^I get Assigned books count$")
	public void i_get_Assigned_books_count() throws Throwable {
		beforeAssign = lplHome.getAssignedBooksCount();
	}

	@Then("^Assigned book count must be increased by (\\d+)$")
	public void assigned_book_count_must_be_increased_by(int bookCount) throws Throwable {
		bookPage.goToHomePage();
		String afterAssign = lplHome.getAssignedBooksCount();
		int actualCount = Integer.parseInt(afterAssign);
		int afterAssign1 = Integer.parseInt(beforeAssign) + 2;

		assertTrue("Book count is not as expected", actualCount == afterAssign1);

	}

	@Then("^I get Assigned collections count$")
	public void i_get_Assigned_collections_count() throws Throwable {
		beforeAssign = lplHome.getNoOfAssignedCollections();
	}

	@Then("^Assigned collections count must be increased by (\\d+)$")
	public void assigned_collections_count_must_be_increased_by(int collectionCount) throws Throwable {
		collectionPage.goToHomePage();
		String afterAssign = lplHome.getNoOfAssignedCollections();
		int actualCount = Integer.parseInt(afterAssign);
		int afterAssign1 = Integer.parseInt(beforeAssign) + 2;
		System.out.println(actualCount);
		assertTrue("Book count is not as expected", actualCount == afterAssign1);
	}

	@When("^I click on Allow in Flash player$")
	public void i_click_on_Allow() throws Throwable {
		lplHome.click_on_Allow_in_Flash_player();
	}

	@Then("^I should see the book header$")
	public void i_should_see_the_book_header() throws Throwable {
		assertTrue("open book header is not dislayed", lplHome.is_header_in_open_book_displayed());
	}

	@Then("^I should see the Play button$")
	public void i_should_see_the_Play_button() throws Throwable {
		assertTrue("Play_button is not dislayed", lplHome.is_Play_button_in_open_book_displayed());
	}

	@Then("^I should see the Send audio recording$")
	public void i_should_see_the_Send_audio_recording() throws Throwable {
		assertTrue("Send_audio_recording is not dislayed", lplHome.is_Send_audio_recording_displayed());
	}

	@Then("^I should see the Send a message$")
	public void i_should_see_the_Send_a_message() throws Throwable {
		assertTrue("SEND_A_MESSAGE is not dislayed", lplHome.is_SEND_A_MESSAGE_in_open_book_displayed());
	}

	@Then("^I should see the View messages$")
	public void i_should_see_the_View_messages() throws Throwable {
		assertTrue("VIEW_MESSAGES is not dislayed", lplHome.is_VIEW_MESSAGES_in_open_book_displayed());
	}

	@Then("^I should see the Cancel button$")
	public void i_should_see_the_Cancel_button() throws Throwable {
		assertTrue("CANCEL button is not dislayed", lplHome.is_CANCEL_in_Send_audio_recording_displayed());
	}

	@Then("^I should see the Time$")
	public void i_should_see_the_Time() throws Throwable {
		assertTrue("TIME is not dislayed", lplHome.is_TIME_in_Send_audio_recording_displayed());
	}

	@Then("^I should see the Record button$")
	public void i_should_see_the_Record_button() throws Throwable {
		assertTrue("RECORD button is not dislayed", lplHome.is_RECORD_in_Send_audio_recording_displayed());
	}

	@When("^I click on SeeAll linkText assigned by teacher$")
	public void i_click_on_SeeAll_linkText_assigned_by_teacher() throws Throwable {
		lplHome.clickOn_SeeAll_Assigned_by_teacher();
	}

	@Then("^I should see the home to books page$")
	public void i_should_see_the_home_to_books_page() throws Throwable {
		assertTrue("Books page is not displayed", lplHome.isHome_to_Books_Page_dislayed());
	}

	///////////////// 01-02-2016 ///////////////////////
	@Then("^I should see the Assigned By My Teacher header$")
	public void i_should_see_the_Assigned_By_My_Teacher_header() throws Throwable {
		assertTrue("Assignd_By_My_Teacher is not displayed", lplHome.is_Assignd_By_My_Teacher_header_dislayed());
	}

	@When("^I click on info icon on the book$")
	public void i_click_on_info_icon_on_the_book() throws Throwable {
		lplHome.clickOn_info_icon();
	}

	@Then("^I should see the summary of the book$")
	public void i_should_see_the_summary_of_the_book() throws Throwable {
		assertTrue("Summary of the book is not dislayed", lplHome.is_Summary_of_the_book_dislayed());
	}

	@Then("^I should see the Read button$")
	public void i_should_see_the_Read_button() throws Throwable {
		assertTrue("Read button is not dislayed", lplHome.isReadbuttondislayed());
	}

	@When("^I click on the book in books page$")
	public void i_click_on_the_book_in_books_page() throws Throwable {
		bookPage.ClickOn_the_book();
	}

	@When("^I click on next button till end of the book$")
	public void i_click_on_next_button_till_end_of_the_book() throws Throwable {
		bookPage.clickOn_next_button_open_book();
	}

	@When("^I click on previous button till the first page$")
	public void i_click_on_previous_button_till_the_first_page() throws Throwable {
		bookPage.clickOn_previous_button_open_book();
	}

	@Then("^I should see the disabled next button in books page$")
	public void i_should_see_the_disabled_next_button_in_books_page() throws Throwable {
		assertTrue("Disabled button is not displayed", bookPage.is_next_button_disable_in_open_book_displayed());
	}

	@Then("^I should see the disabled previous button in books page$")
	public void i_should_see_the_disabled_previous_button() throws Throwable {
		assertTrue("Disabled button is not displayed", bookPage.is_previous_button_disable_in_open_book_displayed());
	}
	////////////////// 04-02-2016//////////////////

	@Then("^successful pop up should be displayed_single$")
	public void successful_pop_up_should_be_displayed_single() throws Throwable {
		String actual = bookPage.Assigned_text_single();
		String expected = "This assignment has been sent to your student";
		Assert.assertEquals(actual, expected);
	}

	///////////////// 10-02-2016 //////////////////////
	@Then("^I should see the book status as NOT STARTED$")
	public void i_should_see_the_book_status_as_NOT_STARTED() throws Throwable {
		String actual = bookPage.reading_book_status();
		String expected = "book.statusText == 'NOTSTARTED'";
		System.out.println(actual);
		boolean exp = actual.contains("NOTSTARTED");
		Assert.assertEquals(true, exp);
	}

	@When("^I click on Reading Level$")
	public void i_click_on_Reading_Level() throws Throwable {
		bookPage.clickOn_reading_level();
	}

	@Then("^I should see the Lexile Level header$")
	public void i_should_see_the_Lexile_Level_header() throws Throwable {
		assertTrue("Lexile_Level is not displayed ", bookPage.is_Lexile_Level_Displayed());
	}

	@When("^I enter from$")
	public void i_enter_from() throws Throwable {
		bookPage.Lexile_Level_From("10");
	}

	@When("^I enter to$")
	public void i_enter_to() throws Throwable {
		bookPage.Lexile_Level_to("100");
	}

	@When("^I open the book from the selection$")
	public void i_open_the_book_from_the_selection() throws Throwable {
		bookPage.clickOn_filtered_selection_book();
	}

	@Then("^I should see the Lexile value$")
	public void i_should_see_the_Lexile_value() throws Throwable {
		bookPage.Lexile_value_validation();
	}

	@When("^I click on close button in popup$")
	public void i_click_on_close_button_in_popup() throws Throwable {
		bookPage.clickOn_close_button_in_popup();
	}

	////////////// 15-02-2016 ////////////////////////////
	@Then("^Colour wheel header should be displayed$")
	public void Colour_wheel_header_should_be_displayed() throws Throwable {
		assertTrue("Colour_wheel_header is not displayed ", bookPage.is_Colour_wheel_header_Displayed());
	}

	@When("^Select the Magenta colour from the list$")
	public void Select_the_Magenta_colour_from_the_list() throws Throwable {
		bookPage.clickOn_Colour_Magenta();
	}

	@Then("^Magenta tag should be displayed in the current selection$")
	public void Magenta_tag_should_be_displayed_in_the_current_selection() throws Throwable {
		assertTrue("Magenta_tag is not displayed ", bookPage.is_Magenta_tag_Displayed());
	}

	@Then("^the colour wheel name should be displayed$")
	public void the_colour_wheel_name_should_be_displayed() throws Throwable {
		bookPage.validation_of_colour_wheel_name();
	}

	@Then("^Reading Level header should be displayed$")
	public void Reading_Level_header_should_be_displayed() throws Throwable {
		assertTrue("Reading_Level_header is not displayed ", bookPage.is_Reading_Level_header_Displayed());
	}

	@When("^Select the 1-8 level from the list$")
	public void select_the_1_8_level_from_the_list() throws Throwable {
		bookPage.clickOn_One_to_8_selection_in_Reading_Level();
	}

	@Then("^1-8 tag should be displayed in the current selection$")
	public void one_to_8_tag_should_be_displayed_in_the_current_selection() throws Throwable {
		assertTrue("One_to_8_tag is not displayed ", bookPage.is_One_to_8_tag_Displayed());
	}

	@Then("^the Reading level value should be displayed$")
	public void the_Reading_level_value_should_be_displayed() throws Throwable {
		bookPage.validation_of_Reading_Level_Value_1_8();
	}

	@When("^select the colour from the list and it's validation$")
	public void select_the_colour_from_the_list_and_its_validation() throws Throwable {
		bookPage.selection_of_colour_and_validation();
	}

	@When("^select the reading level value from the list and it's validation$")
	public void select_the_reading_level_value_from_the_list_and_its_validation() throws Throwable {
		bookPage.selection_of_Reading_level_and_validation();
	}

	/////////////////// 16-02-2016 /////////////////////
	@When("^click on Genre button$")
	public void click_on_Genre_button() throws Throwable {
		bookPage.ClickOn_Genre_button();
	}

	@Then("^Genre header should be displayed$")
	public void Genre_header_should_be_displayed() throws Throwable {
		assertTrue("Genre_header is not displayed ", bookPage.is_Genre_header_displayed());
	}

	@When("^Select the Fiction from the list$")
	public void Select_the_Fiction_from_the_list() throws Throwable {
		bookPage.ClickOn_Fiction_in_Genre();
	}

	@Then("^Fiction tag should be displayed$")
	public void Fiction_tag_should_be_displayed() throws Throwable {
		assertTrue("Fiction_tag is not displayed", bookPage.is_Fiction_tag_displayed());
	}

	@Then("^Expected Genre value Fiction should be displayed$")
	public void Expected_Genre_value_Fiction_should_be_displayed() throws Throwable {
		bookPage.validation_of_Genre_type_Fiction();
	}

	@When("^Select the NonFiction from the list$")
	public void Select_the_NonFiction_from_the_list() throws Throwable {
		bookPage.ClickOn_NonFiction_in_Genre();
	}

	@Then("^NonFiction tag should be displayed$")
	public void NonFiction_tag_should_be_displayed() throws Throwable {
		assertTrue("Non Fiction_tag is not displayed", bookPage.is_NonFiction_tag_displayed());
	}

	@Then("^Expected Genre value NonFiction should be displayed$")
	public void Expected_Genre_value_NonFiction_should_be_displayed() throws Throwable {
		bookPage.validation_of_Genre_type_NonFiction();
	}

	@When("^Click on Interest category$")
	public void Click_on_Interest_category() throws Throwable {
		bookPage.MinReadingLevel();
		bookPage.ClickOn_Interest_category_button();
	}

	@When("^Click on Education Level$")
	public void click_on_education_level() throws Throwable {
		bookPage.MinReadingLevel();
		bookPage.ClickOn_EducationLevel();
	}

	@Then("^I should verify that follwing Eduation level is present$")
	public void i_should_verify_that_follwing_Eduation_level_is_present(List<String> uiElements) throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("All the education levels are not displayed", bookPage.EducationlevelVerify(repName));
		}
	}
	
	@Then("^I should vaildate all the search filters$")
	public void i_should_vaildate_all_the_search_filters(List<String> uiElements) throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("All the education levels are not displayed", bookPage.SearchFilter(repName));
		}
	}

	@And("^I should see two extra filters also$")
    public void i_should_see_two_extra_filters_also(List<String> uiElements) throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("All the education levels are not displayed", bookPage.ExtraSearchFilter(repName));
		}
	}
	
	@And("^I should vaildate all the search filters of student$")
    public void i_should_vaildate_all_the_search_filters_of_student(List<String> uiElements) throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("All the education levels are not displayed", bookPage.SearchFilterStudent(repName));
		}
	}

	@And("^I should see two extra filters of student$")
    public void i_should_see_two_extra_filters_of_student(List<String> uiElements) throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("All the education levels are not displayed", bookPage.ExtraSearchFilterStudent(repName));
		}
	}		
    		
	
	@When("^I select \"([^\"]*)\" education level$")
    public void i_select_something_education_level(String repName) throws Throwable {
		bookPage.EducationlevelSelection(repName);
    }
	
	@Then("^I should verify the education level of the books as \"([^\"]*)\"$")
    public void i_should_verify_the_education_level_of_the_books_as_something(String EduLevel) throws Throwable {
		assertTrue("All the books doesnot have correct Education level", bookPage.VerifyEducationlevelBook(EduLevel));
    }
	

	@Then("^I should verify that all the Interest category are arranged in Alphabetical order$")
	public void i_should_verify_that_all_the_interest_category_are_arranged_in_alphabetical_order() throws Throwable {
		// bookPage.InterestcategoryPlus();
		bookPage.CollectInterestcategory();
	}

	@When("^I click on Series option$")
	public void i_click_on_series_option() throws Throwable {
		bookPage.ClickOn_Series_button();
	}

	@Then("^Interest category header should be displayed$")
	public void Interest_category_header_should_be_displayed() throws Throwable {
		assertTrue("Interest_category_header is not displayed ", bookPage.is_Interest_category_header_displayed());
		Thread.sleep(5000);
	}

	@Then("^I should not see \"([^\"]*)\" Series$")
	public void i_should_not_see_something_series(String Series) throws Throwable {
		assertTrue("Interest_category_header is not displayed ", bookPage.is_Not_Series_displayed(Series));
	}

	@Then("^I should not see \"([^\"]*)\" Filter for \"([^\"]*)\"$")
	public void i_should_not_see_something_filter_for_something(String user, String filter) throws Throwable {
		assertTrue("Filter " + filter + " is displayed books tab", bookPage.is_Not_filter_displayed(filter, user));
	}

	@When("^Select the category from the list and it's validation$")
	public void Select_the_category_from_the_list_and_its_validation() throws Throwable {
		bookPage.selection_of_category_and_validation();
	}

	//////////////// 17-02-2016 /////////////////
	@When("^Open the book from the selection$")
	public void Open_the_book_from_the_selection() throws Throwable {
		bookPage.clickOn_filtered_selection_book_student();
	}

	//////////////// 18-02-2016 ////////////////////
	@When("^go to Home page$")
	public void go_to_Home_page() throws Throwable {
		lplHome.clickOn_homeTab();
	}

	@When("^get the value from the recent book and open it in Books page$")
	public void get_the_value_from_the_recent_book_and_open_in_books_page() throws Throwable {
		String src_value = lplHome.getting_the_src_value_of_FirstBook();
		// System.out.println("########### XPATH VALUE IS: "+src_value);
		lplHome.goToBooksPage();
		bookPage.ClickOndropDown_Selection_To_Show_Books();
		bookPage.ClickOn_Select_All();
		driver.findElement(By.xpath(src_value)).click();
	}

	@When("^Click on Send a message$")
	public void Click_on_Send_a_message() throws Throwable {
		lplHome.clickOn_SEND_A_MESSAGE_in_open_book();
	}

	@Then("^Message container header should be displayed$")
	public void Message_container_header_should_be_displayed() throws Throwable {
		assertTrue("Message_container_header is not displayed ", bookPage.is_message_container_header_displayed());
	}

	@When("^Click on drop down list to select the students$")
	public void click_on_drop_down_list_to_select_the_students() throws Throwable {
		bookPage.clickOn_dropDown_to_select_students_for_sending_message();
	}

	@Then("^Students class header should be displayed$")
	public void students_class_header_should_be_displayed() throws Throwable {
		assertTrue("students_class_header is not displayed ", bookPage.is_Students_class_header_displayed());
	}

	@When("^Select the student from the list$")
	public void select_the_student_from_the_list() throws Throwable {
		bookPage.clickOn_student3_for_sending_message();
	}

	@When("^Click on Select message recipients$")
	public void click_on_select_message_recipients() throws Throwable {
		bookPage.clickOn_select_message_recipients();
	}

	@When("^Enter the message in the text area$")
	public void enter_the_message_in_the_text_area() throws Throwable {
		bookPage.clickOn_Text_area_for_sending_message();
		bookPage.message_to_send("Hi Jon, this is test mail.");
	}

	@When("^Click on Send button$")
	public void click_on_send_button() throws Throwable {
		bookPage.clickOn_Send_button_for_sending_message();
	}

	@Then("^Confirmation message should be displaed$")
	public void confirmation_message_should_be_displaed() throws Throwable {
		assertTrue("students_class_header is not displayed ",
				bookPage.is_confirmation_message_after_sent_message_displayed());
	}

	@When("^Click on Okay button$")
	public void click_on_okay_button() throws Throwable {
		bookPage.clickOn_Okay_button_in_confirmation_message();
	}

	////////////////// 19-02-2016 //////////////////////
	@When("^Mouse over the message box$")
	public void Mouse_over_the_message_box() throws Throwable {
		lplHome.mouseOver_on_message_inbox();
	}

	@When("^Open the first message$")
	public void Open_the_first_message() throws Throwable {
		lplHome.clickOn_first_message_in_inbox();
	}

	@Then("^Message header should be displayed$")
	public void Message_header_should_be_displayed() throws Throwable {
		assertTrue("Message_header is not displayed ", lplHome.is_Message_header_displayed());
	}

	@When("^Expected message should be displayed$")
	public void Expected_message_should_be_displayed() throws Throwable {
		lplHome.verify_text_message2();
	}

	////////////////// 22-02-2016 /////////////////////
	@When("^Search for the book$")
	public void Search_for_the_book() throws Throwable {
		bookPage.clickClearButton();
		bookPage.enter_the_text_in_Search_field();
		bookPage.clickOn_Search_button();
	}

	@Then("^Expected book should be displayed$")
	public void Expected_book_should_be_displayed() throws Throwable {
		bookPage.verify_header_of_the_book();
	}

	@When("^I click on ASSIGNED text on the book for cleanup$")
	public void i_click_on_ASSIGNED_text_on_the_book_for_cleanup() throws Throwable {
		while (bookPage.isAssignedbookDisplayed()) {
			bookPage.clickOnASSIGNED();
			bookPage.clickOn_Assigned_InPopup();
			BooksPage function = PageFactory.initElements(driver, BooksPage.class);
			// function.clickOnEntire_class();
			bookPage.clickOn_clearAllAssignments();
			bookPage.clickOn_save_changes_button();

		}
	}

	@Then("^I click on clear all assignments$")
	public void i_click_on_clear_all_assignments() throws Throwable {
		bookPage.clickOn_clearAllAssignments();
	}

	@When("^I click on Unhide book for cleanup$")
	public void i_click_on_Unhide_book_for_cleanup() throws Throwable {
		bookPage.clickHiddenFilter();
		while (bookPage.isAssignbookDisplayed()) {
			bookPage.clickOnAssignhidden();
			bookPage.clickOn_hide_unhide_Button();
			bookPage.UncheckEntire_class();
			bookPage.clickOn_save_changes_button();
			// bookPage.clickHiddenFilter();
		}
	}

	@When("^I click on ASSIGNED text on the book in Collections Page$")
	public void i_click_on_ASSIGNED_text_on_the_book_in_Collections_Page() throws Throwable {
		collectionPage.clickOnAssignedOnCollection();
	}

	@When("^I click on entire class in colletion Page$")
	public void i_click_on_entire_class_in_colletion_Page() throws Throwable {
		collectionPage.clickOnEntire_class();
	}

	@When("^I click on clear all assignments in collections Page$")
	public void i_click_on_clear_all_assignments_in_collections_Page() throws Throwable {
		collectionPage.clickOn_clearAllAssignments();
	}

	@When("^I click on Save changes in collections Page$")
	public void i_click_on_Save_changes_in_collections_Page() throws Throwable {
		collectionPage.clickOn_save_changes_button();
	}

	@When("^I click on ASSIGNED text on the book in Collections Page for cleanup$")
	public void i_click_on_ASSIGNED_text_on_the_book_in_Collections_Page_for_cleanup() throws Throwable {
		while (collectionPage.isAssignedbookDisplayed()) {
			collectionPage.clickOnASSIGNED();
			collectionPage.clickOn_clearAllAssignments();
			collectionPage.clickOn_save_changes_button();

		}
	}

	@When("^I should verify Books in My Lexile Range should be of \"([^\"]*)\" to \"([^\"]*)\"$")
	public void i_should_verify_books_in_my_lexile_range_should_be_of_something_to_something(String StrtLexile,
			String EndLexile) throws Throwable {
		assertTrue("All the books did not opened", bookPage.BookLexileRange(StrtLexile, EndLexile));
	}

	@When("^I set a lexile level from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void i_set_a_lexile_level_from_something_to_something(String StrtLexile, String EndLexile) throws Throwable {
		bookPage.LexileRange(StrtLexile, EndLexile);
	}

	@And("^I should check option \"([^\"]*)\"$")
	public void i_should_check_option_something(String Status) throws Throwable {
		bookPage.MyBook(Status);
	}

	@When("^I set a lexile level from \"([^\"]*)\" to \"([^\"]*)\" for teacher$")
	public void i_set_a_lexile_level_from_something_to_something_for_teacher(String StrtLexile, String EndLexile)
			throws Throwable {
		bookPage.LexileRangeTeacher(StrtLexile, EndLexile);
	}

	@Then("^I should click on search button$")
	public void i_should_click_on_search_button() throws Throwable {
		bookPage.SrchBttn();
	}

	@Then("^I should click on search button for teacher$")
	public void i_should_click_on_search_button_for_teacher() throws Throwable {
		bookPage.SrchBttnTch();
	}

	@Then("^I should validate that book should not be shown in search result$")
	public void i_should_validate_that_book_should_not_be_shown_in_search_result() throws Throwable {
		assertTrue("Book is visible even after teacher has hidden it", bookPage.ValidateBookVisiblity());
	}

	@When("^I open the information pop of assigned book$")
	public void i_open_the_information_pop_of_assigned_book() throws Throwable {
		// bookPage.ClickOndropDown_Selection_To_Show_Books();
		// bookPage.ClickOn_Select_All();
		bookPage.AssignedInfo();
	}

	@When("^I open the information pop of Books I Selected$")
	public void i_open_the_information_pop_of_books_i_selected() throws Throwable {
		bookPage.SelfAssignedInfo();
	}

	@When("^I open the Assign pop and valiate that the books shown should have BR in the lexile$")
	public void i_open_the_assign_pop_and_valiate_that_the_books_shown_should_have_br_in_the_lexile() throws Throwable {
		assertTrue("All the books did not opened", bookPage.AssignPopup());
	}

	
	@When("^I open the Assign pop and Click on Quiz button$")
    public void i_open_the_assign_pop_and_click_on_quiz_button() throws Throwable {
		bookPage.QuizPopup();
    }
	
	@When("^I open the info pop and Click on Quiz button$")
    public void i_open_the_info_pop_and_click_on_quiz_button() throws Throwable {
		bookPage.Quizinfo();
	}
	
	@When("^I should Click on Quiz button of book cover$")
    public void i_should_click_on_quiz_button_of_book_cover() throws Throwable {
		bookPage.QuizBookCover();
	}
	
	@Then("^I should verify that teacher is redirected to LP page \"([^\"]*)\" to take a Quiz Popup$")
    public void i_should_verify_that_teacher_is_redirected_to_lp_page_something_to_take_a_quiz_popup(String bookTitle) throws Throwable {
		bookPage.VerifyLP_LPL_integration(bookTitle);
	}
	
	@Then("^I should verify that Student is redirected to LP page \"([^\"]*)\" to take a Quiz Popup$")
    public void i_should_verify_that_student_is_redirected_to_lp_page_something_to_take_a_quiz_popup(String bookTitle) throws Throwable {
		bookPage.VerifyLP_LPL_integrationStudent(bookTitle);
	}
	
	@And("^I click on View quiz button and verify that quiz$")
    public void i_click_on_view_quiz_button_and_verify_that_quiz() throws Throwable {
		assertTrue("LP-LPL ingetration is working as expected", bookPage.ViewQuizAndVerify());
	}
	
	@And("^I should close the Quiz popup$")
    public void i_should_close_the_quiz_popup() throws Throwable {
		bookPage.ClosePopUp();
	}
	
	@When("^I search for the book \"([^\"]*)\" in litpro$")
    public void i_search_for_the_book_something_in_litpro(String BookTitle) throws Throwable {
		bookPage.SearchBookLP(BookTitle);
    }
	
	@When("^I search for the book \"([^\"]*)\" in litpro as student$")
    public void i_search_for_the_book_something_in_litpro_as_student(String BookTitle) throws Throwable {
		bookPage.SearchBookLPStn(BookTitle);
    }
	
	@When("^I Click on the read book button of \"([^\"]*)\"$")
    public void i_click_on_the_read_book_button_of_something(String Book) throws Throwable {
		bookPage.ReadBookBtn(Book);
    }

    @Then("^I should be taken to LPL read book page of \"([^\"]*)\"$")
    public void i_should_be_taken_to_lpl_read_book_page_of_something(String Book) throws Throwable {
    	assertTrue("Books are not opening in LPL from LP side", bookPage.VerifyBookLPL(Book));
    }
	
    @When("^I Click on the read book button of \"([^\"]*)\" as student$")
    public void i_click_on_the_read_book_button_of_something_as_student(String Book) throws Throwable {
		bookPage.ReadBookBtnStn(Book);
   	}
    
	@When("^I open the Assign pop and valiate that the books shown should have 0 in the lexile$")
    public void i_open_the_assign_pop_and_valiate_that_the_books_shown_should_have_0_in_the_lexile() throws Throwable {
		assertTrue("All the books did not opened", bookPage.AssignPopupZeroVerify());
	}

	@When("^I open the information pop$")
	public void i_open_the_information_pop() throws Throwable {
		bookPage.InformationPopup();
	}
	
	@Then("^I should valiatae that the books shown should have lexile range from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_should_valiatae_that_the_books_shown_should_have_lexile_range_from_something_to_something(String strArg1, String strArg2) throws Throwable {
		assertTrue("Search book lexile is not in the range", bookPage.AssignPopupLexile(strArg1, strArg2));
	}
	
	@When("^I open the information pop and valiate that the books shown should have BR in the lexile$")
    public void i_open_the_information_pop_and_valiate_that_the_books_shown_should_have_br_in_the_lexile() throws Throwable {
		bookPage.InformationPopupValidation();
    }
	

	@And("^I should click on Read button$")
	public void i_should_click_on_read_button() throws Throwable {
		bookPage.ReadBtn();
	}



	
	@Then("^I should verify that when I hovered over send audio A message should displays \"([^\"]*)\"$")
    public void i_should_verify_that_when_i_hovered_over_send_audio_a_message_should_displays_something(String strArg1) throws Throwable {
		assertTrue("Hovered over send audio A message IS NOT displaying", bookPage.AudioMessageNoRecording());
	}
	

	@And("^I should read the books and record the audio$")
	public void i_should_read_the_books_and_record_the_audio() throws Throwable {
		bookPage.ReadandRecord();
	}

	@And("^I should read the book for some time$")
	public void i_should_read_the_book_for_some_time() throws Throwable {
		bookPage.Readbook();
	}

	@And("^I should read the books completetly$")
	public void i_should_read_the_books_completetly() throws Throwable {
		bookPage.ReadbookCompletely();
	}

	@Then("^I should see the completed book in last section of Books I Selected$")
	public void i_should_see_the_completed_book_in_last_section_of_books_i_selected() throws Throwable {
		bookPage.bookcompletedVerifyHome();
	}

	@Then("^I should valiate that the books shown should have BR in the lexile$")
	public void i_should_valiate_that_the_books_shown_should_have_br_in_the_lexile() throws Throwable {
		assertTrue("The expected LitproLibrary icon is not displayed ", bookPage.ValidateBookLexile());
	}

	@And("^I should validate that the Student lexile score at dashboard should have BR$")
	public void i_should_validate_that_the_student_lexile_score_at_dashboard_should_have_br() throws Throwable {
		assertTrue("Student lexile score at dashboard is not displaying BR", lplHome.MyLexile());
	}

	@When("^I go to Student overview page$")
	public void i_go_to_student_overview_page() throws Throwable {
		lplHome.OverviewPage();
	}

	
	@And("^I select student data in table view$")
    public void i_select_student_data_in_table_view() throws Throwable {
		lplHome.TableView();
    }

	@And("^I should select All Classes from dropdown$")
    public void i_should_select_all_classes_from_dropdown() throws Throwable {
		lplHome.SelectAllClasses();
    }
	
	@Then("^I should verify the content of the table$")
    public void i_should_verify_the_content_of_the_table(List<String> uiElements) throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("Table header of STUDENT OVERVIEW are not correct", lplHome.VerifyTableContent(repName));
		}
	}
	

	@When("^I click on the export button and export \"([^\"]*)\" CSV$")
    public void i_click_on_the_export_button_and_export_something_csv(String fileName) throws Throwable {
    	String downloadFilePath;    	
    	lplHome.ExportBtn();
    	
    	String autoItExeFilePath = new File(".").getCanonicalPath() + "\\src\\test\\resources\\autoit\\download.exe";
		
		 downloadFilePath = new File(".").getCanonicalPath() + "\\test-data\\download_files\\"+ fileName;
		new ProcessBuilder(autoItExeFilePath,"firefox",downloadFilePath,"10").start();
		Thread.sleep(20000);
    }
	
	@Then("^I should verify that Class column should shown below classes$")
    public void i_should_verify_that_class_column_should_shown_below_classes(List<String> uiElements) throws Throwable {
		Iterator<String> uieleIterator = uiElements.iterator();
		uieleIterator.next();
		while (uieleIterator.hasNext()) {
			String repName = uieleIterator.next();
			assertTrue("Table header of STUDENT OVERVIEW are not correct", lplHome.VerifyClassCol(repName));
		}
	}
	
	@Then("^I should verify that the content of the tables are arranged in alphanumerical order by class$")
    public void i_should_verify_that_the_content_of_the_tables_are_arranged_in_alphanumerical_order_by_class() throws Throwable {
		lplHome.VerifyTableContentAplha();
    }
	
	@And("^I should verify that user should be able to sort column \"([^\"]*)\"$")
    public void i_should_verify_that_user_should_be_able_to_sort_column_something(String col) throws Throwable {
		assertTrue("Not able to sort column "+col+" in Student Overview table", lplHome.Tablesorting(col));
		
	}
	

	@Then("^I should see BR in the lexile score for student \"([^\"]*)\"$")
	public void i_should_see_br_in_the_lexile_score_for_student_something(String StudentName) throws Throwable {
		assertTrue("Student lexile score at student overview is not displaying BR",
				lplHome.StdTabStudentLexile(StudentName));
	}

	@And("^I should collect the WORDS READ and TIME SPENT READING data$")
	public void i_should_collect_the_words_read_and_time_spent_reading_data() throws Throwable {
		lplHome.CollectStdData();
		// assertTrue("Student lexile score at student overview is not
		// displaying BR", lplHome.CollectStdData());
	}

	@When("^I check option \"([^\"]*)\"$")
	public void i_check_option_something(String Option) throws Throwable {
		lplHome.SelectOptionMyBook(Option);
	}

	@Then("^I should collect word count information$")
	public void i_should_collect_word_count_information() throws Throwable {
		lplHome.CollectWrdCnt();
	}

	@When("^I click on the read button and half read the book$")
	public void i_click_on_the_read_button_and_half_read_the_book_for_something_sec() throws Throwable {
		lplHome.ReadBtn();
		lplHome.loadinimg();
	}

	@And("^the close the book$")
	public void the_close_the_book() throws Throwable {
		lplHome.CloseBook();
	}

	@Then("^I should verify that WORDS READ and TIME SPENT READING data should increase accordingly$")
	public void i_should_verify_that_words_read_and_time_spent_reading_data_should_increase_accordingly()
			throws Throwable {
		assertTrue("WORDS READ and TIME SPENT READING data are not increasing for half read book",
				lplHome.VerifyWordReadTimeSentReading());
	}

	@And("^I should click on Class dropdown$")
	public void i_should_click_on_class_dropdown_and_collect_all_the_class_names() throws Throwable {
		lplHome.ClassDrpDwn();
	}

	@Then("^I should validate the Alphabetical order of the student last name$")
	public void i_should_validate_the_alphabetical_order_of_the_student_last_name() throws Throwable {
		assertTrue("Classes are not arrange in Alphabetical order", lplHome.CollectStudentdata());
	}

	@Then("^I should validate the Alphabetical order of the class$")
	public void i_should_validate_the_alphabetical_order_of_the_class() throws Throwable {
		assertTrue("Classes are not arrange in Alphabetical order", lplHome.CollectClassdata());
	}

	@When("^I should go to ASSIGNED BOOKS REPORT page$")
	public void i_should_go_to_assigned_books_report_page() throws Throwable {
		lplHome.AssignedBooksReport();
	}

	@And("^I should search for keyword \"([^\"]*)\"$")
	public void i_should_search_for_keyword_something(String keyword) throws Throwable {
		lplHome.Searchkeyword(keyword);
	}

	@Then("^I should validate the Alphabetical order of the class in ASSIGNED BOOKS REPORT page$")
	public void i_should_validate_the_alphabetical_order_of_the_class_in_assigned_books_report_page() throws Throwable {
		assertTrue("Classes are not arrange in Alphabetical order in ASSIGNED BOOKS REPORT page",
				lplHome.AlphabeticalOrder());
	}

	@When("^I open the Assign pop and click on assign button$")
	public void i_open_the_assign_pop_and_click_on_assign_button() throws Throwable {
		bookPage.AssignBok();
	}

	@Then("^I should validate the Alphabetical order of the class for book assigning$")
	public void i_should_validate_the_alphabetical_order_of_the_class_for_book_assigning() throws Throwable {
		assertTrue("Classes are not arrange in Alphabetical order", bookPage.CollectClassdata());
	}

	@Then("^I click assign book report$")
	public void i_click_assign_book_report() throws Throwable {
		lplHome.ClickAssignBookReport();
	}

	@Then("^I must see assignned book report headder$")
	public void i_must_see_assignned_book_report_headder() throws Throwable {
		assertTrue("Assign Book report is nt displayed", stdPage.isAssignBookReportTitleDisplayed());
	}

	@Then("^I Click on see progress in recent assigment$")
	public void i_Click_on_see_progress_in_recent_assigment() throws Throwable {
		// stdPage.searchRecentBook();
		stdPage.clickSeeProgress();
	}

	@Then("^I must see progress details$")
	public void i_must_see_progress_details() throws Throwable {
		assertTrue("Assign Book report is nt displayed", stdPage.isProgressDisplayed());
	}

	@When("^I open the information pop of Books assigned by teacher$")
	public void i_open_the_information_pop_of_Books_assigned_by_teacher() throws Throwable {
		lplHome.openAssignedBookStudent();
	}

	@When("^I should click on Read button in teacher assigned$")
	public void i_should_click_on_Read_button_in_teacher_assigned() throws Throwable {
		lplHome.clickReadBtn();
	}

	@Then("^I click student overview$")
	public void i_click_student_overview() throws Throwable {
		lplHome.clickStudentOverview();
	}

	@Then("^I must see  student overview headder$")
	public void i_must_see_student_overview_headder() throws Throwable {

		assertTrue("student overview is nt displayed", stdPage.isStudentOvervieDisplayed());
	}

	@Then("^I must see progress report with name progress lexile time spent$")
	public void i_must_see_progress_report_with_name_progress_lexile_time_spent() throws Throwable {
		assertTrue("student overview is nt displayed", stdPage.isProgressTimespentLexile());
	}
	@When("^I click on student link in the report$")
	public void i_click_on_student_link_in_the_report() throws Throwable {
		stdPage.clickOn_StudentLinkReport();
	}

	@Then("^I must see report of each student$")
	public void i_must_see_report_of_each_student() throws Throwable {
		assertTrue("student overview is nt displayed", stdPage.isStudentReportDisplayed());
	}
	@When("^I search for book \"([^\"]*)\"$")
	public void i_search_for_book(String book) throws Throwable {
		stdPage.searchRecentBook(book);
	}

	@Then("^I must see error message$")
	public void i_must_see_error_message() throws Throwable {
		assertTrue("student overview is nt displayed", stdPage.isSearchBookDisplayed().contains("No results found"));
		
	}

	@Then("^I must see search result$")
	public void i_must_see_search_result() throws Throwable {
		assertTrue("student overview is nt displayed", stdPage.isSearchBookDisplayed().contains("results found")); 
	}
	
	@When("^I select all classes from dropdown$")
	public void i_select_all_classes_from_dropdown() throws Throwable {
		stdPage.SelectAllStudentsinStdOveriew();
	}

	@Then("^I click on Export button in overview$")
	public void i_click_on_Export_button_in_overview() throws Throwable {
		stdPage.clickExportButtenStudentOverview();
	}

	@Then("^I must see Export all classes and Students$")
	public void i_must_see_Export_all_classes_and_Students() throws Throwable {
		assertTrue("Export classes students is nt displayed", stdPage.isExportDropDowndisplayed()); 
	}
	@Then("^I must see recent activity and recent assingment$")
	public void i_must_see_recent_activity_and_recent_assingment() throws Throwable {
		//slplHome.isRecentactivityAssingmentDisplayed();
	}
}