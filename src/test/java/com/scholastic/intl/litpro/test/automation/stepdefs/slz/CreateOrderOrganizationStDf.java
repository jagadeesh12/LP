package com.scholastic.intl.litpro.test.automation.stepdefs.slz;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg.SearchResultBook;
//import pageobject.lpl.BooksPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.AddOrganizationPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.CreateOrderPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.SearchGroupAdminPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.SlzManageUsersPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.SlzMngUserPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.SlzMngUserPg.LitProUserType;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.SlzOrderDetailsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.Slzobj;

public class CreateOrderOrganizationStDf {
	SlzLoginPg slzLogin = null;
	SlzHomePg slzHome;
	Scenario scenario;
	SlzLoginPg slzLoginPg;
	SlzHomePg slzHomePg;
	SlzManageUsersPg slzManageUsersPg;
	AddOrganizationPg addOrgPg;
	CreateOrderPg createOrderPg;
	LitProHomePg lpHomePage;
	String orgname;
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	List<SearchResultBook> resultBooks;
	Slzobj obj1 = new Slzobj();

	public static enum LitProUserType {
		SCHOOL_ADMIN, STUDENT, CS_REP, TEACHER
	};

	private LitProUserType lpUserType;
/*
	public CreateOrderOrganizationStDf(SharedDriver driver) {
		this.driver = driver;
	}
	*/
	@Then("^I create organization with following details$")
	public void i_create_organization_with_following_details(Map<String, String> values) throws Throwable {
		AddOrganizationPg addOrgPg = new AddOrganizationPg(driver);
		Slzobj obj1 = new Slzobj();
		 orgname = obj1.getOrgname();
		addOrgPg.addDetailsCreateOrganisation(orgname,values.get("customer Group"),values.get("customer Type"),values.get("org Type"));
	}
 
	@Then("^I should see Success Creation Message$")
	public void i_should_see_Success_Creation_Message() throws Throwable {
		AddOrganizationPg addOrgPg = new AddOrganizationPg(driver);
		assertTrue("Succes creation not  displayed.", addOrgPg.getSucessMessage().contains("successfully"));
		CreateOrderPg createOrderPg = addOrgPg.clickOkButton();
	}
	
	@When("^I create new order with following orderline details$")
	public void i_create_new_order_with_following_orderline_details(Map<String, String> values) throws Throwable {
		CreateOrderPg createOrderPg = new CreateOrderPg(driver);
		
		 orgname = obj1.getOrgaizationName();
		createOrderPg.CreateOrder(orgname,"CAN","12");
		createOrderPg.CreateOrderLine(values.get("Product Type"),values.get("Product"),values.get("Rep Email"));
	}

	@Then("^I should see order lines Created with \"([^\"]*)\"$")
	public void i_should_see_order_lines_Created_with(String arg1) throws Throwable {
		CreateOrderPg createOrderPg = new CreateOrderPg(driver);
		createOrderPg.isOrderLineDisplayed();
	}

	@Then("^I create another order with following details$")
	public void i_create_another_order_with_following_details(Map<String, String> values) throws Throwable {
		CreateOrderPg createOrderPg = new CreateOrderPg(driver);
		createOrderPg.clickAddOrderLine() ;
		createOrderPg.CreateOrderLine(values.get("Product Type"),values.get("Product"),values.get("Rep Email"));
		
	}

	@When("^I click on create order button$")
    public void i_click_on_create_order_button() throws Throwable {
    	CreateOrderPg createOrderPg = new CreateOrderPg(driver);
    	createOrderPg.clickCreateOrderButton();
    }

    @Then("^I should see successful order creation message$")
    public void i_should_see_successful_order_creation_message() throws Throwable {
    	CreateOrderPg createOrderPg = new CreateOrderPg(driver);
    	//System.out.println(createOrderPg.getSuccessOrderMessage());
    	assertTrue("Succes Order creation not displayed.", createOrderPg.getSuccessOrderMessage().contains("The Order has been created successfully."));
    	createOrderPg.clickOkButton();
    }

    @When("^I click on slz access link$")
    public void i_click_on_slz_access_link() throws Throwable {
    	SlzOrderDetailsPg slzOrderDetailsPg = new SlzOrderDetailsPg(driver);
    	SlzMngUserPg mngUserPage = slzOrderDetailsPg.clickSlzLink();
    }

    @Then("^I should see Slz order details Page$")
    public void i_should_see_slz_order_details_page() throws Throwable {
        SlzOrderDetailsPg slzOrderDetailsPg = new SlzOrderDetailsPg(driver);
        assertTrue("Slz Link not displayed ",slzOrderDetailsPg.slzLinkDetailsDisplayed());
        
    }

    @Then("^I must go to manage users Page$")
    public void i_must_go_to_manage_users_page() throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver);
    	mngUserPage.isManageUserPageDisplayed();
    	mngUserPage.clickManageUsers();
    }
    @When("^I upload \"([^\"]*)\" to the organisation$")
    public void i_upload_something_to_the_organisation(String user) throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver);
    	if(user.contains("Teachers"))
    		mngUserPage.uploadSTeacher();
    	else
    		mngUserPage.uploadStudents();
    		
    	
    }
   

    @Then("^I should see \"([^\"]*)\" in Accounts uploaded$")
    public void i_should_see_something_in_accounts_uploaded(String user) throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver);
    	if(user.contains("Teachers"))
    		
    		 assertTrue("Teachers not created ",mngUserPage.verifyTeacherName("John"));
    	else 
    		assertTrue("Students not created  ",mngUserPage.verifyStudentName("Lisa"));	
    		
    		
    }
    @When("^I search for book Black hole$")
    public void i_search_for_book_black_hole() throws Throwable {
    	String searchKey = "Black Hole";
    	SearchPg searchPg = new SearchPg(driver,LitProHomePg.LitProUserType.STUDENT);
    	searchPg.selectChkBoxScholasticEbbokCollection();
    	searchPg.typeSearchKeyAndHitQuickSearchBtnAsCsrep("Black Hole");
    	searchPg.waitWhenLoadingBarActive();
		
    }

    @When("^I click on ReadBook$")
    public void i_click_on_readbook() throws Throwable {
    	/*SearchPg searchPg = new SearchPg(driver,LitProHomePg.LitProUserType.STUDENT);
    	searchPg.clickReadBook();*/
  	
      
    }

    @Then("^I click on litpro subscibed product$")
    public void i_click_on_litpro_subscibed_product() throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver);
    	LitProHomePg lpHomePage = mngUserPage.clickLpLink();
    
        
    }

    @Then("^I must navigate to Litpro Home Page$")
    public void i_must_navigate_to_litpro_home_page() throws Throwable {
    	LitProHomePg lpHomePage = new LitProHomePg(driver);
    	//System.out.println(driver.getCurrentUrl());
    	lpHomePage.clickOnClosePopUp();
    	String expected = "Welcome,";
		String actual = lpHomePage.getUserGreetingText();
		assertTrue("The expected Greet Text was '" + expected + "' but actually was: " + actual, actual.contains("Welcome, "));
		lpHomePage.goToSeachPage();
    }
    

    @Then("^I should see corresponding book$")
    public void i_should_see_corresponding_book() throws Throwable {
    	/*BooksPage bookPg = new BooksPage(driver);
    	bookPg.getbooktitle().contains("Black Holes");*/
       
    }

    @Then("^I must navigate to Litpro Library$")
    public void i_must_navigate_to_litpro_library() throws Throwable {
    	//assertTrue("Current Page is not Litpro", driver.getCurrentUrl().contains("lplibrary"));
    	//driver.getCurrentUrl().contains("lplibrary");
    	//System.out.println(driver.getCurrentUrl());
    }
    @When("^I click on quiz button$")
    public void i_click_on_quiz_button() throws Throwable {
    	/*BooksPage bookPg = new BooksPage(driver);
    	bookPg.clickViewQuiz();*/
    }
   
    @Then("^I must navigate to litrpo home with Quizz popup$")
    public void i_must_navigate_to_litrpo_home_with_Quizz_popup() throws Throwable {
    	LitProHomePg lpHomePage = new LitProHomePg(driver);
    	lpHomePage.clickOnClosePopUp();
    }

    

    @Then("^I must see quizz header corresponding to the book$")
    public void i_must_see_quizz_header_corresponding_to_the_book() throws Throwable {
    	LitProHomePg lpHomePage = new LitProHomePg(driver);
    	assertTrue("Header doesnot contains corresponding Book Qizz", lpHomePage.checkQuizHeadder().contains("Black Holes"));
    }

    @When("^I click on ViewQuizz header$")
    public void i_click_on_ViewQuizz_header() throws Throwable {
    	LitProHomePg lpHomePage = new LitProHomePg(driver);
    	lpHomePage.clickViewQiz();
    }

    @Then("^I should see Quizzes$")
    public void i_should_see_Quizzes() throws Throwable {
    	LitProHomePg lpHomePage = new LitProHomePg(driver);
    	assertTrue("Header doesnot contains corresponding Book Qizz",lpHomePage.getQuizzPageHeader().contains("Black Holes"));
    	
    }
    @When("^I add Administrator manually$")
    public void i_add_Administrator_manually() throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver);
    	mngUserPage.addAdministrator();
    }

    @Then("^I should see administrator created$")
    public void i_should_see_administrator_created() throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver);
    	assertTrue("Admin not created", mngUserPage.isAdminCreated("Walter"));
    }
    @When("^I edit order by Extended sales amount and license count$")
    public void i_edit_order_by_Extended_sales_amount_and_license_count() throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver);
    	mngUserPage.editSalesAmountLicenseCount();
    }

    @When("^I click update order$")
    public void i_click_update_order() throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver);
    	mngUserPage.clickUpdateOrder();
    	
    }

    @Then("^I must see updated sales amount and license count$")
    public void i_must_see_updated_sales_amount_and_license_count() throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver);  
    	assertTrue("Edit License and Sales amount is not as expected ",mngUserPage.validateSalesAmountAndLicense());
    }
    @Then("^I search for admin \"([^\"]*)\"$")
    public void i_search_for_admin(String admin) throws Throwable {
    	CreateOrderPg createOrderPg = new CreateOrderPg(driver);
    	createOrderPg.clickSearchGroupAdmin();
    	SearchGroupAdminPg srchGrpAdminPg = new SearchGroupAdminPg(driver);
    	srchGrpAdminPg.searchAdmin(admin);
    	
    }

    @Then("^I must see \"([^\"]*)\" in search result$")
    public void i_must_see_in_search_result(String admin) throws Throwable {
    	SearchGroupAdminPg srchGrpAdminPg = new SearchGroupAdminPg(driver);
    	assertTrue("Admin not displayed",	srchGrpAdminPg.isSearchedAdminDisplayed(admin));
    }
    @When("^I search for School \"([^\"]*)\"$")
    public void i_search_for_School(String schl) throws Throwable {
    	CreateOrderPg createOrderPg = new CreateOrderPg(driver);
    	createOrderPg.searchSchool(schl);
    	assertTrue("School searched is not displayed ",createOrderPg.isSchoolDisplayed(schl));
    	
    	createOrderPg.selectSchool(schl);
    	
        
    }

    @Then("^I should see \"([^\"]*)\" as header$")
    public void i_should_see_as_header(String schl) throws Throwable {
    	CreateOrderPg createOrderPg = new CreateOrderPg(driver);
    	assertTrue("School header is not displayed ",createOrderPg.getHeader().equalsIgnoreCase(schl));
    }

    @Then("^I select student \"([^\"]*)\"$")
    public void i_select_student(String student) throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver); 
    	mngUserPage.selectStudent(student);
    	mngUserPage.editStudentMoveToOtherClass();
    	mngUserPage.changeStudentGrade();
    	mngUserPage.clickSubmit();

    }

    @Then("^I Must see student changes to different class$")
    public void i_Must_see_student_changes_to_different_class() throws Throwable {
    	
    	
    }
    
    @Then("^I subscribe Subscribtion to Students$")
    public void i_subscribe_Subscribtion_to_Students() throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver);
    	mngUserPage.subscribeStudents();
    }

    @Then("^I subscribe subscriptions to Teachers and edit password$")
    public void i_subscribe_subscriptions_to_Teachers_and_edit_password() throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver);
    	mngUserPage.subscribeTeachers();
    	mngUserPage.editTchrPassword();
    }

    @Then("^I subscribe subscriptions to Admin and edit password$")
    public void i_subscribe_subscriptions_to_Admin_and_edit_password() throws Throwable {
    	SlzMngUserPg mngUserPage = new SlzMngUserPg(driver); 
    	mngUserPage.addSubscriptionTadmin();
    	mngUserPage.editAdminPassword();
   
    }
    @Then("^I create organization with following details with \"([^\"]*)\" with \"([^\"]*)\" with \"([^\"]*)\" with \"([^\"]*)\"$")
    public void i_create_organization_with_following_details_with_with_with_with(String customerGroup, String customerType, String orgType,String orgname) throws Throwable {
    	AddOrganizationPg addOrgPg = new AddOrganizationPg(driver);
		  obj1.setOrgname(orgname);
		addOrgPg.addDetailsCreateOrganisation(orgname,customerGroup,customerType,orgType); 
       
    }
}
