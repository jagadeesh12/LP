package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.plexus.util.StringUtils;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.scholastic.intl.litpro.test.automation.pageobjects.InLibraryPg.UploadHistoryData;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.intl.litpro.test.automation.pageobjects.InLibraryPg;


public class LpImportBooksStDf {
	
	
	InLibraryPg lpInLibPg;
	int uploadHistoryCount = 0;
	UploadHistoryData uhData;
	String fileName = "inlibrary_books_yes.csv";
	List<Map<String,String>> actualList;
	String downloadFilePath;
	//WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	LitProUserType lpUserType;
	SlzLoginPg slzLogin = null;
	SlzHomePg slzHome;
	LitProHomePg lpHome;
	SearchPg lpSearchPg;
	ReportsPg lpReportsPg;
	//Scenario scenario;

	  /*  @Before
		public void before(Scenario scenario) {
		    this.scenario = scenario;
		}*/
	@Given("^I browse to In Library Page as \"(.*?)\"$")
	public void i_browse_to_In_Library_Page_as(String userType) {
		WebDriver driver = TestBaseProvider.getTestBase().getDriver();
		slzLogin = new SlzLoginPg(driver);
		assertTrue("Failed to Launch AUT due to missing info. Check the log.", slzLogin.launchSlz());
		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);
		slzHome = slzLogin.loginAs(lpUserType);
		//scenario.write("Credentials: "+slzLogin.getUserCreds());
		
		lpHome = slzHome.launchLitPro(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		lpInLibPg = lpHome.goToInLibraryPage();
		
	}
	
	@Given("^I browse to In Library Page as 'CSRep'$")
	public void i_browse_to_In_Library_Page_as_CSRep() throws Throwable {
		WebDriver driver = TestBaseProvider.getTestBase().getDriver();
		slzLogin = new SlzLoginPg(driver);
		LitProUserType lpUserType = LitProUserType.CS_REP;
		assertTrue("Failed to Launch AUT due to missing info. Check the log.", slzLogin.launchSlzForCSRep());
		/*slzCSRHomePg = slzLogin.loginAsCSRep();
		scenario.write("Credentials: " +slzLogin.getUserCreds());
		slzHome = slzCSRHomePg.searchOrgAndLaunchCustSLZAccount();*/
		lpHome = slzHome.launchLitPro(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		lpInLibPg = lpHome.goToInLibraryPage();
	}

	@Then("^I should see In Library Page Header - \"(.*?)\"$")
	public void i_should_see_In_Library_Page_Header(String expected) throws Throwable {
		String actual = lpInLibPg.getPageHeader();
		assertTrue("The expected Page Header was '" + expected + "' but actually was: " + actual, actual.equalsIgnoreCase(expected)); 
		
		//get the current row count before uploading the file
		uploadHistoryCount = lpInLibPg.getHistoryTblRowCount();
	}
	
	@Then("^I should verify tooltip added to the big Library Match icon in the upper right of home page \"([^\"]*)\"$")
    public void i_should_verify_tooltip_added_to_the_big_library_match_icon_in_the_upper_right_of_home_page_something(String tooltip) throws Throwable {
		String actual = lpInLibPg.tooltip();
		String expected = tooltip;
		assertTrue("The tool tip which was expected :" + expected
				+ " but actually was: " + actual, actual.contains(expected));
	}

	@When("^I select csv file$")
	public void i_select_csv_file() throws Throwable {
		//scenario.write("Select file: " + fileName);
		assertTrue("File NOT found/unable to select file: "+ fileName, lpInLibPg.selectFile(fileName));
		
	}

	@When("^I click Upload button$")
	public void i_click_Upload_button() throws Throwable {
		lpInLibPg.clickUploadButton();
	}

	@Then("^Import status should show \"(.*?)\"$")
	public void import_status_should_be(String expected) throws Throwable {
		String actual = lpInLibPg.getImportStatus();
		assertTrue("The expected Status was '" + expected + "' but actually was: " + actual, actual.equals(expected)); 
	 }
	
	@Then("^I should see a new row added to the Upload History table$")
	public void check_table() throws Throwable {
		lpHome.goToHomePage();
		lpHome.goToInLibraryPage();
		
		int postUploadCount = lpInLibPg.getHistoryTblRowCount();
		assertTrue("Post import, upload history table NOT updated. ", postUploadCount>uploadHistoryCount); 
	 }
	
	@Then("^Upload History table should have following columns:$")
	public void history_table_should_show_following_columns_in_List_View(List<String> columnList)   {
		String actual = lpInLibPg.getHistoryTableColumnNames().toString();
		String expected = columnList.toString();
		assertTrue("The expected Column list was '" + expected + "' but actually was: " + actual, actual.contains(expected));
	}
	
	@Then("^File Name column should show uploaded file name$")
	public void file_Name_column_should_show_uploaded_file_name() throws Throwable {
		uhData = lpInLibPg.getHistoryTblFirstRow();
		
		if(uhData!=null){
			String expected = fileName;
			String actual = uhData.fileName;
			assertTrue("The expected File name was '" + expected + "' but actually was: " + actual, actual.contains(expected));
		}
		else{
			/*scenario.write("Upload History table NOT displayed or unable to read.");
			throw new PendingException();*/
		}
	}
	     

	@Then("^Status should show 'Done'$")
	public void status_should_be_Done() throws Throwable {
		String expected = "Done";
		String actual = uhData.status;
		assertTrue("The expected Status was '" + expected + "' but actually was: " + actual, actual.contains(expected));
	}

	@Then("^Matches \\+ No Matches \\+ Failed Records count should be equal to the count of rows in uploaded file$")
	public void matches_No_Matches_Failed_Records_count_should_be_equal_to_count_of_the_rows_in_uploaded_file() throws Throwable {
		int rowCountInCSV = 10;
		int matchesCount = this.getCountFromString(uhData.successfulMatchesCount);
		int NoMatchesCount = this.getCountFromString(uhData.noMatchesCount);
		int failedMatchesCount = this.getCountFromString(uhData.failedRecordsCount);
		
		int expected = rowCountInCSV;
		int actual = matchesCount + NoMatchesCount + failedMatchesCount;
		assertTrue("The expected count match was '" + expected + "' but actually was: " + actual, expected == actual);
	}

	@Then("^Date uploaded should show current date$")
	public void date_uploaded_should_be_current_date() throws Throwable {
		String expected = lpInLibPg.getFormattedDate(new Date(), "dd MMM YYYY");
		String actual = uhData.dateUploaded;
		assertTrue("The expected Date was '" + expected + "' but actually was: " + actual, actual.contains(expected));  
	}

	@Then("^Uploaded By should show current user name$")
	public void uploaded_By_should_be_the_current_user_name() throws Throwable {
		String expected = lpHome.getUserGreetingText().replace("Welcome,", "").trim();
		String actual = uhData.uploadedBy;
		assertTrue("The expected Uploaded By name was '" + expected + "' but actually was: " + actual, actual.contains(expected)); 
	}
	
	@When("^I click on 'Successful Matches' link$")
	public void i_click_on_Sucessful_Matches_link() throws Throwable {
		lpInLibPg.clickFirstRowSuccessfulMatchesLink();
		this.lpInLibPg.lazyWait(20);
	}

	@Then("^^I should be able to save the csv file as \"(.*?)\"$$")
	public void i_should_be_able_to_save_the_csv_file(String fileName) throws Throwable {
		String autoItExeFilePath = new File(".").getCanonicalPath() + "\\src\\test\\resources\\autoit\\download.exe";
		
		 downloadFilePath = new File(".").getCanonicalPath() + "\\test-data\\download_files\\"+ fileName;
		new ProcessBuilder(autoItExeFilePath,"firefox",downloadFilePath,"10").start();
		this.lpInLibPg.lazyWait(20);
	}
	
	@Then("^'SuccessfulMatch\\.csv' file record count should be (\\d+)$")
	public void successfulmatch_csv_file_record_count_should_be(int expRecCount) throws Throwable {
		actualList = lpInLibPg.getCSVData("Successful");
		//assertTrue("The expected record count was '" + expRecCount + "' but actually was: " + actualList.size(),actualList.size()!= expRecCount); 
	}

	@Then("^'SuccessfulMatch\\.csv' should have following (\\d+) records$")
	public void successfulmatch_csv_should_have_following_records(int recCnt, List<Map<String,String>> expList) throws Throwable {
	     boolean flag = false;
	     boolean flagauthor=false ;
	     String actual = null;
		for(int i = 0; i<expList.size(); i++){
			flag=false;
			String expected = expList.get(i).get("TITLE");
			for(int j=0;j<actualList.size();j++){
				if(actualList.get(j).get("TITLE").contains(expected)){
				 actual  = actualList.get(j).get("TITLE");
				flag = true;
				break;
				}
			}
		
			
			assertTrue("Expected 'TITLE' was '" + expected +"' but actually was: "+ actual, flag);
		}
			for(int k = 0; k<expList.size(); k++){
				flagauthor = false;
				String expectedName = expList.get(k).get("AUTHOR_NAME");
				for(int j=0;j<actualList.size();j++){
					if(actualList.get(j).get("AUTHOR_NAME").contains(expectedName)){
						 actual = actualList.get(j).get("AUTHOR_NAME");
					flagauthor = true;
					break;
					}
					
				}
			 String expected  = expList.get(k).get("AUTHOR_NAME");
			//String actual = actualList.get(j).get("AUTHOR_NAME");
			assertTrue("Expected 'AUTHOR_FIRST_NAME' was '" + expected +"' but actually was: "+ actual, flagauthor);
			
			
		}
	}
	
	@When("^I click on 'Failed Matches' link$")
	public void i_click_on_Failed_Matches_link() throws Throwable {
		lpInLibPg.clickFirstRowFailedMatchesLink();
		this.lpInLibPg.lazyWait(20);
	}

	@Then("^'FailedMatches\\.csv' file record count should be (\\d+)$")
	public void failedmatches_csv_file_record_count_should_be(int expRecCount) throws Throwable {
		actualList = lpInLibPg.getCSVData("Failed");
		assertTrue("The expected record count was '" + expRecCount + "' but actually was: " + actualList.size(),actualList.size()== expRecCount); 
	
	}

	@Then("^'FailedMatches\\.csv' should have following (\\d+) records$")
	public void failedmatches_csv_should_have_following_records(int recCnt, List<Map<String,String>> expList) throws Throwable {
		for(int i = 0; i<expList.size(); i++){
			String expected = expList.get(i).get("ROW_NO");
			String actual  = actualList.get(i).get("ROW_NO");
			assertTrue("Expected 'ROW_NO' was '" + expected +"' but actually was: "+ actual, actual.contains(expected));
			
			expected  = expList.get(i).get("ERROR_ROW_TEXT");
			actual = actualList.get(i).get("ERROR_ROW_TEXT");
			assertTrue("Expected 'ERROR_ROW_TEXT' was '" + expected +"' but actually was: "+ actual, actual.contains(expected));
			
			expected  = expList.get(i).get("ERROR");
			actual = actualList.get(i).get("ERROR");
			assertTrue("Expected 'ERROR' was '" + expected +"' but actually was: "+ actual, actual.contains(expected));
		}
	}

	
	public int getCountFromString(String str){
		String numStr = StringUtils.left(str, 2).trim();
		if(StringUtils.isNumeric(numStr)){
			return Integer.parseInt(numStr);
		}
		return 0;
	}
	
	@Then("^I click on ReviewCloseMatches button$")
	public void i_click_on_ReviewCloseMatches_button() throws Throwable {
		lpInLibPg.clickReviewClosedReviewMatches();
	}

	@Then("^I must see title \"([^\"]*)\" and author \"([^\"]*)\"$")
	public void i_must_see_title_and_author(String book, String Author) throws Throwable {
		assertTrue("Title and Author not found ", lpInLibPg.checkMatchFound(book, Author));
	}
	@Then("^I see and select  possible match book as \"([^\"]*)\"$")
	public void i_see_and_select_possible_match_book_as(String Author) throws Throwable {
		assertTrue("Possible matches not found  ", lpInLibPg.selectMatchedCheckbox(Author));
	}

	@Then("^I must see Close Match Review left is zero$")
	public void i_must_see_Close_Match_Review_left_is_zero() throws Throwable {
		assertTrue("Close review match is not Zero" ,lpInLibPg.checkCloseMatchReviewIsZero());
	}
	
	
	@When("^I click on 'No matches' link$")
	public void i_click_on_No_matches_link() throws Throwable {
		lpInLibPg.clickFirstRowNoMatchesLink();
		this.lpInLibPg.lazyWait(20);
	}

	@Then("^'NoMatches\\.csv' should have following records$")
	public void nomatches_csv_should_have_following_records(List<Map<String,String>> expList) throws Throwable {
		actualList = lpInLibPg.getCSVData("NoMatches");
		boolean flag = false;
	     boolean flagauthor=false ;
	     String actual = null;
		for(int i = 0; i<expList.size(); i++){
			flag=false;
			String expected = expList.get(i).get("TITLE");
			for(int j=0;j<actualList.size();j++){
				if(actualList.get(j).get("TITLE").contains(expected)){
				 actual  = actualList.get(j).get("TITLE");
				flag = true;
				break;
				}
			}
		
			
			assertTrue("Expected 'TITLE' was '" + expected +"' but actually was: "+ actual, flag);
		}
			for(int k = 0; k<expList.size(); k++){
				flagauthor = false;
				String expectedName = expList.get(k).get("AUTHOR_NAME");
				for(int j=0;j<actualList.size();j++){
					if(actualList.get(j).get("AUTHOR_NAME").contains(expectedName)){
						 actual = actualList.get(j).get("AUTHOR_NAME");
					flagauthor = true;
					break;
					}
					
				}
			 String expected  = expList.get(k).get("AUTHOR_NAME");
			//String actual = actualList.get(j).get("AUTHOR_NAME");
			assertTrue("Expected 'AUTHOR_FIRST_NAME' was '" + expected +"' but actually was: "+ actual, flagauthor);
			
		
	}
}
}
