package com.scholastic.intl.litpro.test.automation.pageobjects.lpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
//import stepdefination.SharedDriver;


/* @ Author: Rajesh R
 * @ Created Date:04/01/2016
 * @ Functionality: Home Page Object
 * @ Type: Smoke, regression
 * 
 * 
 * @ Updated Date
 * @ Updated By Rajesh R
 * 
 */

public class LitProLibraryHomePg extends ParentPage {
	//TestBase testBase = TestBaseProvider.getTestBase();
	//WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	WebDriver driver;
	WebElement categoryElement;
	public static enum LitProlibraryUserType {
		SCHOOL_ADMIN, STUDENT, CS_REP, TEACHER
	};
	private LitProUserType lpUserType;
	/*public static enum LitProUserType {
		SCHOOL_ADMIN, STUDENT, CS_REP, TEACHER
	};*/
	
	

	final String PAGE_TITLE = "Scholastic Literacy Pro";

	@FindBy(xpath = "//div[contains(text(),'HOME')]")
	private WebElement homeTab;

	@FindBy(xpath = "//div[contains(text(),'STUDENTS')]")
	private WebElement studentsTab;

	@FindBy(css = ".//header/div[2]/div[2][contains(text(),'BOOKS')]")
	private WebElement booksTab;

	/*@FindBy(css = ".lpl-menu-item.lpl-collections-menu.lpl-teacher-collections-menu>a")
	private WebElement collectionsTab;
*/
	@FindBy(xpath = "//div[@class='lpl-menu-container']//*[contains(text(),'COLLECTIONS')]")
	private WebElement collectionsTab;
	
	@FindBy(xpath="//img[@src='app/themes/images/icon-window.png']")	
	private WebElement WindowPOPup;
	
	// @FindBy(xpath = "//div[@class='lpl-menu-container']")//header/div[2]/
	@FindBy(xpath = "//header/div[2]")
	private WebElement adminNavigationBar;

	@FindBy(xpath = "(//span[text()='Quiz']/parent::a/parent::show-quiz-button/parent::div/parent::div//img[2])[1]")
	private WebElement TeacherAssignedBook;
	
	@FindBy(xpath = "(//div[@class='owl-next']/*//a/img)[1]")
	private WebElement TeacherAssignedrightArrow;
	
	@FindBy(xpath = "//header/div[2]")
	private WebElement studNavigationBar;

	@FindBy(css = ".lpl-menu-item.lpl-students-menu")
	private WebElement StudentTab;

	@FindBy(xpath = ".//*[@alt='LPL']")
	private WebElement LitproLibraryIcon;

	@FindBy(css = ".dropdown-toggle.ng-binding")
	private WebElement profile;

	@FindBy(css = ".dropdown-toggle.ng-binding")
	private WebElement stdprofile;
	
	@FindBy(xpath = ".//*[@id='book-reader-page']/div[2]/span[2]")
	private WebElement CloseBook;

	@FindBy(xpath = ".//*[@id='book-reader-page']/div[2]/div/div[1]/input")
	private WebElement PageNumTxt;
	
	@FindBy(css = ".btn.lpl-profile-sign-out")
	private WebElement logOut;

	@FindBy(xpath = "//span[@class='selected ng-binding']")
	private WebElement Select_drop_down_class;
	@FindBy(xpath = "//a[text()='Math']")
	private WebElement Math_class_selection;
	@FindBy(xpath = "//span[text()='Math']")
	private WebElement Math_class_Text;
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-triangle-bottom']")
	private WebElement Profile_select_button;
	@FindBy(xpath = "//img[@class='lpl-profile-dropdown-profile-edit']")
	private WebElement Profile_edit_button;
	@FindBy(xpath = "//img[@src='app/themes/images/avatars/middle_eastern_teacher.png']")
	private WebElement middle_eastern_teacher;
	@FindBy(xpath = "html/body/div[4]/div/div/div[2]/div[2]/div[3]/img")
	private WebElement middle_eastern_teacher1;
	@FindBy(xpath = "html/body/div[4]/div/div/div[2]/div[2]/div[1]/img")
	private WebElement asian_female_teacher1;
	@FindBy(xpath = "html/body/div[4]/div/div/div[2]/div[2]/div[2]/img")
	private WebElement asian_male_teacher1;
	@FindBy(xpath = "html/body/div[4]/div/div/div[2]/div[2]/div[4]/img")
	private WebElement multi_ethnic_teacher1;
	@FindBy(xpath = "html/body/div[4]/div/div/div[2]/div[2]/div[5]/img")
	private WebElement asian_female1;
	@FindBy(xpath = "//button[text()='Done']")
	private WebElement Done_button_in_popup;
	@FindBy(xpath = "(//img[@src='app/themes/images/avatars/middle_eastern_teacher.png'])[1]")
	private WebElement middle_eastern_teacher_img_validation;
	@FindBy(xpath = "//img[@class='lpl-icon-user lpl-border-none']")
	private WebElement profile_image_boarder;
	@FindBy(xpath = "//div[text()='MY PROFILE']")
	private WebElement MY_PROFILE_Text;
	@FindBy(xpath = "//button[text()='Sign Out']")
	private WebElement SignOut_button;
	@FindBy(xpath = "//div[text()='Your profile image']")
	private WebElement Your_profile_image_text;
	@FindBy(linkText = "Help")
	private WebElement Help_link;
	@FindBy(xpath = "(.//*[@src='app/themes/images/icon-right-arrow.png'])[1]")
	private WebElement next_button_Recent_Assignments;
	@FindBy(xpath = "//img[@src='app/themes/images/prev-grey.png']")
	private WebElement previous_button_disable_open_book;
	
	@FindBy(xpath = ".//*[@id='searchBooks']")
	private WebElement SrchTxtBx;
	
	@FindBy(xpath = "//div[@dropdown-item-label='className' and @dropdown-model='classSelection']/span")
	private WebElement ClssDrpdwn;
	
	@FindBy(xpath = "//div[@class='lpl-modal-pagination']/input")
	private WebElement PgeNumTxtBox;
	
	@FindBy(xpath = "//div[@class='lpl-modal-pagination']/span[3]")
	private WebElement PgeNum;
		
	@FindBy(xpath = "//img[@class='lpl-icon-right-arrow']")
	private WebElement NextArrow;
	
	@FindBy(xpath = "//input[@ng-model='displayPageNo']")
	private WebElement PageNum;
	
	@FindBy(xpath = "//div[@id='popupBookShow']/img[@alt='loader']")
	private WebElement loadingBtn;
	
	@FindBy(xpath = "//div[@class='modal-footer lpl-border-0 ng-scope']/button[1]")
	private WebElement Readbtn;	

	@FindBy(xpath = "//span[@ng-bind='bookDetails.wordCount']")
	private WebElement WrdCnt;
	
	@FindBy(xpath = "//div[contains(text(),'TIME SPENT READING')]/parent::div//div[2]")
	private WebElement TimeSpendStd;
	
	@FindBy(xpath = "//div[contains(text(),'WORDS READ')]/parent::div//div[2]")
	private WebElement WordReadStd;

	@FindBy(xpath = "//div[contains(text(),'Jon Snow')]/parent::div/div[2]")
	private WebElement StdTabStudentLex;
	
	@FindBy(xpath = "//ul/li/a[contains(text(),'STUDENT OVERVIEW')]")
	private WebElement StudentOverView;
	
	@FindBy(xpath = "//ul/li/a[contains(text(),'ASSIGNED BOOKS REPORT')]")
	private WebElement AssignedBooksReportdrpdwn;
	
	@FindBy(xpath = "//ul/li/div[contains(text(),'STUDENTS')]")
	private WebElement Student;
	
	@FindBy(xpath = "//div[contains(text(),'MY LEXILE')]/parent::div/div[2]")
	private WebElement MYLexile;
	
	
	@FindBy(xpath = "//img[@src='app/themes/images/next-grey.png']")
	private WebElement next_button_disabled_Recent_Assignments;
	@FindBy(xpath = "(//div[@class='lpl-avatar-position-bottom'])[1]")
	private WebElement first_assigned_book_by_teacher;
	@FindBy(xpath = "//img[@id='microphoneImg']")
	private WebElement Send_audio_recording;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-play']")	
	private WebElement Play_button_in_open_book;
	@FindBy(xpath="//img[@class='lpl-icon-pencil1']")	
	private WebElement SEND_A_MESSAGE_in_open_book;
	@FindBy(xpath="//img[@class='lpl-margin-top-15px lpl-icon-message-small1']")	
	private WebElement VIEW_MESSAGES_in_open_book;
	@FindBy(xpath="//img[@class='lpl-icon-cancel1']")	
	private WebElement CANCEL_in_Send_audio_recording;
	@FindBy(xpath="//span[text()='TIME']")	
	private WebElement TIME_in_Send_audio_recording;
	@FindBy(xpath="//span[text()='RECORD']")	
	private WebElement RECORD_in_Send_audio_recording;
	@FindBy(xpath="//span[@class='lpl-modal-title ng-binding']")	
	private WebElement header_in_open_book;
	@FindBy(xpath="(//span[@class='lpl-see-allbooks lpl-textCapitalize'])[1]")	
	private WebElement SeeAll_Assigned_by_teacher;
	@FindBy(how=How.XPATH,using="//span[text()='Books']")	
	WebElement Home_to_Books_Page;
///////////////// 01-02-2016 //////////////////////////
	@FindBy(how=How.XPATH,using="//span[text()='Assigned by my teacher']")	
	WebElement Assignd_By_My_Teacher_header;
	@FindBy(how=How.XPATH,using="(//div[div[img[@ng-if='book.isBook == true']]])[1]/div[2]/img[1]")	
	WebElement info_icon_single_book;
	@FindBy(how=How.XPATH,using="(//div[div[img[@ng-if='book.isBook == false']]])[1]/div[2]/img[1]")	
	WebElement info_icon_collection_of_books;
	@FindBy(how=How.XPATH,using="//div[text()='SUMMARY']")	
	WebElement Summary_of_the_book;
	@FindBy(how=How.XPATH,using="//button[text()='Read']")	
	WebElement Read_InPopup;
////////////////18-02-2016 //////////////////
	@FindBy(xpath="(//img[@class='lpl-book-style'])[1]")	
	private WebElement First_book_of_RecentAssignments;
////////////////19-02-2016 //////////////////
	@FindBy(xpath="//span[@class='lpl-icon-message']")	
	private WebElement Message_inbox;
	@FindBy(xpath="(//li[@class='lpl-message-list-item ng-scope'])[1]")	
	private WebElement first_message_in_inbox;
	@FindBy(xpath="//div[@class='lpl-reader-message-title ng-scope']")	
	private WebElement Message_header;
	@FindBy(xpath="//div[@class='lpl-all-messages-para ng-binding ng-scope']")	
	private WebElement Text_of_message;

	@FindBy(xpath = "//span[@class='lpl-page-title1 ng-binding']/span")
	private WebElement CollectionTitleNum;
	
	@FindBy(xpath = "//span[@class='lpl-page-title1 ng-binding']")
	private WebElement CollectionTitle;
	
	@FindBy(xpath = "(//div[@class='lpl-msg-subject-container']/span)[1]")
	private WebElement Message;

	@FindBy(xpath = "//span[@class='lpl-icon-message lpl-icon-message-skyblue']")
	private WebElement MessageIcon;
	
	@FindBy(xpath = "(//button[contains(text(),'Read')])[1]")
	private WebElement ReadBtns;
	public LitProLibraryHomePg(WebDriver driver, LitProUserType userType) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver=driver;
		this.lpUserType = userType;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public LitProLibraryHomePg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		// this.lpUserType = userType;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public String getExpectedTitle() {
		return PAGE_TITLE;
	}

	/* returns comma separated tab names */
	public List<String> getDisplayedTabNames() {
		List<String> tabs = null;
		List<WebElement> tabList = null;
		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			tabList = this.getChildElements(adminNavigationBar,
					By.xpath("//li"));
			

		} else if (lpUserType == LitProUserType.STUDENT) {
			tabList =this.getElements(By.xpath(".//header/div[2]/div"));
		}

		if (tabList.size() > 0) {
			tabs = new ArrayList<String>();
			for (WebElement tab : tabList) {
				String tabName = tab.getText();
				if (!(tabName.isEmpty()) && (tabName != null))
					tabs.add(tabName);
			}
		}
		return tabs;
	}

	public StudentsPage goToStudentsPage() {
		//this.click(this.StudentTab);
		click(Student);
		click(StudentOverView);
		return new StudentsPage(driver);
	}

	public BooksPage goToBooksPage() {
		WebElement bookstab = null;
		/*//this.click(this.booksTab);
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", booksTab);*/
		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			bookstab = this.getElement(By.xpath(".//header/div[2]/ul/li[3]/a"));
			

		} else if (lpUserType == LitProUserType.STUDENT) {
			bookstab = this.getElement(By.xpath(".//header/div[2]/div[2][contains(text(),'BOOKS')]"));
		}
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", bookstab);
		
		return new BooksPage(driver);
	}

	public CollectionsPage goToCollectionsPage() {
		this.click(this.collectionsTab);
		return new CollectionsPage(driver);
	}

	public boolean isLitproLibraryIconDisplayed() {
		boolean flag = false;
		//driver = TestBaseProvider.getTestBase().getDriver();
		if(TestBaseProvider.getTestBase().getString(URL).contains("GBR"))
		{
			flag =this.sync(driver.findElement(By.xpath(".//*[@alt='RPL']"))).isDisplayed();
		}
		
		else if(this.sync(LitproLibraryIcon).isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public boolean isUserProfileDisplayed() {
		boolean flag = false;
		if (lpUserType == LitProUserType.TEACHER) {
			flag = this.sync(profile).isDisplayed();
		}

		if (lpUserType == LitProUserType.STUDENT) {
			flag = this.sync(stdprofile).isDisplayed();
		}
		return flag;
	}

	public boolean isLogOutDisplayed() {

		if (lpUserType == LitProUserType.TEACHER) {
			this.sync(profile).click();
		}

		if (lpUserType == LitProUserType.STUDENT) {
			this.sync(stdprofile).click();
		}

		if (this.sync(logOut).isDisplayed()) {
			return true;
		} else
			return false;
	}
	
	

	public boolean verifySudents() {
		if (this.sync(
				driver.findElement(By
						.xpath(".//*[@class='lpl-body-container ng-scope']/div/div[1]/div[2]/div/div[1]/div/div[1]")))
				.getText().contains("STUDENTS"))
			return true;
		else
			return false;
	}

	public String getNoOfStudents() {
		String noOfStudents = null;
		noOfStudents = this
				.sync(driver.findElement(By
						.xpath(".//*[@class='lpl-body-container ng-scope']/div/div[1]/div[2]/div/div[1]/div/div[2]")))
				.getText();
		return noOfStudents;

	}

	public boolean verifyAssignedBooks() {
		boolean flag = false;

		if (lpUserType == LitProUserType.TEACHER) {
			if (this.sync(
					driver.findElement(By
							.xpath(".//*[@class='lpl-body-container ng-scope']/div/div[1]/div[2]/div/div[2]/div/div[1]")))
					.getText().contains("ASSIGNED BOOKS"))
				flag = true;
		}
		if (lpUserType == LitProUserType.STUDENT) {
			if (this.sync(
					driver.findElement(By
							.xpath(".//*[@class='lpl-progress-row']/div[2]/div[1]/div[1]")))
					.getText().contains("ASSIGNED BOOKS"))
				flag = true;

		}
		return flag;
	}

	public String getNoOfBooks() {
		String noOfBooks = null;
		noOfBooks = this
				.sync(driver.findElement(By
						.xpath(".//*[@class='lpl-body-container ng-scope']/div/div[1]/div[2]/div/div[2]/div/div[2]")))
				.getText();
		return noOfBooks;
	}

	public boolean verifyCompletedBooks() {
		boolean flag = false;

		if (lpUserType == LitProUserType.TEACHER) {
			if (this.sync(
					driver.findElement(By
							.xpath(".//*[@class='lpl-body-container ng-scope']/div/div[1]/div[2]/div/div[3]/div/div[1]")))
					.getText().contains("COMPLETED BOOKS"))
				flag = true;
		}
		if (lpUserType == LitProUserType.STUDENT) {
			if (this.sync(
					driver.findElement(By
							.xpath(".//*[@class='lpl-progress-row']/div[3]/div[1]/div[1]")))
					.getText().contains("COMPLETED BOOKS"))
				flag = true;
		}
		return flag;
	}

	public String getNoOfBooksCompleted() {
		String noOfBooks = null;
		noOfBooks = this
				.sync(driver.findElement(By
						.xpath(".//*[@class='lpl-body-container ng-scope']/div/div[1]/div[2]/div/div[3]/div/div[2]")))
				.getText();
		return noOfBooks;
	}

	public boolean verifyAssignedCollections() {
		if (this.sync(
				driver.findElement(By
						.xpath(".//*[@class='lpl-body-container ng-scope']/div/div[1]/div[2]/div/div[4]/div/div[1]")))
				.getText().contains("ASSIGNED COLLECTIONS"))
			return true;
		else
			return false;
	}

	public String getNoOfAssignedCollections() {
		String assignedCollections = null;
		assignedCollections = this
				.sync(driver.findElement(By
						.xpath(".//*[@class='lpl-body-container ng-scope']/div/div[1]/div[2]/div/div[4]/div/div[2]")))
				.getText();
		return assignedCollections;
	}

	public boolean verifyWordsReadByClass() {
		if (this.sync(
				driver.findElement(By
						.xpath(".//*[@class='lpl-body-container ng-scope']/div/div[1]/div[3]/div/div[1]/div/div[1]")))
				.getText().contains("WORDS READ BY CLASS"))
			return true;
		else
			return false;
	}

	public String getNoOfWordsReadByClass() {
		String assignedCollections = null;
		assignedCollections = this
				.sync(driver.findElement(By
						.xpath(".//*[@class='lpl-body-container ng-scope']/div/div[1]/div[3]/div/div[1]/div/div[2]")))
				.getText();
		return assignedCollections;
	}

	public boolean verifyTimeSpentReadingByClass() {
		boolean flag = false;

		if (lpUserType == LitProUserType.TEACHER) {
			if (this.sync(
					driver.findElement(By
							.xpath("//*[@class='lpl-body-container ng-scope']/div/div[1]/div[3]/div/div[2]/div/div[1]")))
					.getText().contains("TIME SPENT READING BY CLASS"))
				;
			flag = true;
		}
		if (lpUserType == LitProUserType.STUDENT) {
			if (this.sync(
					driver.findElement(By
							.xpath(".//*[@class='lpl-progress-row']/div[5]/div[1]/div[1]")))
					.getText().contains("TIME SPENT READING"))
				flag = true;
		}
		return flag;
	}

	public boolean verifyAverageTimePerBook() {
		if (this.sync(
				driver.findElement(By
						.xpath(".//*[@class='lpl-body-container ng-scope']/div/div[1]/div[3]/div/div[3]/div/div[1]")))
				.getText().contains("AVERAGE TIME PER BOOK"))
			return true;
		else
			return false;
	}

	public boolean verifyMyLexile() {
		if (this.sync(
				driver.findElement(By
						.xpath(".//*[@class='lpl-progress-row']/div[1]/div[1]/div[1]")))
				.getText().contains("MY LEXILE"))
			return true;
		else
			return false;
	}

	public String getLexileScore() {
		String score = null;
		score = this
				.sync(driver.findElement(By
						.xpath(".//*[@class='lpl-progress-row']/div[1]/div[1]/div[2]")))
				.getText();
		return score;

	}

	/*
	 * public boolean verifyAssignedBooks() {
	 * if(this.sync(driver.findElement(By.
	 * xpath(".//*[@class='lpl-progress-row']/div[2]/div[1]/div[1]"
	 * ))).getText().contains("ASSIGNED BOOKS")) return true; else return false;
	 * }
	 */
	public String getAssignedBooksCount() {
		String score = null;
		lazyWait(5);
		score = this
				.sync(driver.findElement(By
						.xpath("(.//*[@class='lpl-progress-row']/div[2]/div[1]/div[2])[1]")))
				.getText();
		return score;

	}

	public String getCompletedBooksCount() {
		String score = null;
		score = this
				.sync(driver.findElement(By
						.xpath(".//*[@class='lpl-progress-row']/div[3]/div[1]/div[2]")))
				.getText();
		return score;

	}

	// WORDS READ
	public boolean verifyWordsRead() {
		if (this.sync(
				driver.findElement(By
						.xpath(".//*[@class='lpl-progress-row']/div[4]/div[1]/div[1]")))
				.getText().contains("WORDS READ"))
			return true;
		else
			return false;
	}

	public String getWordsReadCount() {
		String score = null;
		score = this
				.sync(driver.findElement(By
						.xpath(".//*[@class='lpl-progress-row']/div[4]/div[1]/div[2]")))
				.getText();
		return score;

	}

	
	public void openAssignedBookStudent() {
		String MessageBook = null;
		lazyWait(10);
		for(int i=0; i<=30; i++){
			if (TeacherAssignedBook.isDisplayed()) {
				MessageBook = TeacherAssignedBook.getAttribute("src");
				TeacherAssignedBook.click();
				break;
			}
			else{
				click(TeacherAssignedrightArrow);	
			}
		}
		setbooktitle(MessageBook);
	}
	

	public void writeAMessageToTeacher(String Message) throws InterruptedException {
		Thread.sleep(20000);

		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		/*this.sync(
				driver.findElement(By.xpath("//img[@class='lpl-icon-pencil1']")));*/
		
		 WebDriverWait wait = new WebDriverWait(driver, 360);
		 Boolean element2 = wait.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath(".//*[@src='app/themes/images/ajax-loader.gif']"))));
		 WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='send a message']")));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", element);
	        WebDriverWait wait1 = new WebDriverWait(driver, 360);
	     element2 = wait1.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath(".//*[@src='app/themes/images/ajax-loader.gif']"))));
	     this.sync(driver.findElement(By
						.xpath(".//textarea")));
	     driver.findElement(By
					.xpath(".//textarea")).click();
		this.sync(
				driver.findElement(By
						.xpath(".//textarea")))
				.sendKeys(Message);
	}

	public void sendMessageToTeachersButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click((driver.findElement(By
						.xpath(".//*[@type='button'][contains(text(),'Send')]"))));
	}

	public void cancelMessageToTeacherButton() {
		this.sync(
				driver.findElement(By
						.xpath(".//*[@class='lpl-message-button-container']/button[contains(text(),'Cancel')]")))
				.click();
	}

	public boolean isAssignedBookDisplayed() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if (this.sync(
				driver.findElement(By
						.cssSelector(".lpl-modal-title.ng-binding")))
				.isDisplayed())
			return true;
		else
			return false;

	}
	
	
	
	public boolean isSucessMessageDisplayed() {
	    lazyWait(4);
		if (this.sync(driver.findElement(By.className("confirm-text")))
				.getText().contains("Your message has been sent"))
			return true;
		else
			return false;

	}

	public boolean assignedByMyTeacherHeaderIsDisplayed() {
		
		if (this.sync(
				driver.findElement(By
						.cssSelector(".lpl-book-carousel-title")))
				.getText().contains("Assigned By My Teacher"))
			return true;
		else
			return false;
	}

	public boolean isSeeAllLinkForBookIsDisplayed() {
		
		if (this.sync(
				driver.findElement(By
						.xpath("(//div[@class='lpl-bookgrid-title-right-container ng-scope']/span)[1]")))
				.getText().contains("See All"))
			return true;
		else
			return false;

	}

	public boolean booksISelectedHeaderIsDisplayed() {
		
		if (this.sync(
				driver.findElement(By
						.cssSelector(".lpl-book-carousel-title.ng-scope")))
				.getText().contains("Books I Selected"))
			return true;
		else
			return false;
	}

	public boolean isSeeAllLinkForAssignedByMyTeacherIsDisplayed() {
		//System.out.println(driver.findElement(
		
		if (this.sync(
				driver.findElement(By
						.xpath("(//div[@class='lpl-bookgrid-title-right-container ng-scope']/span)[2]")))
				.getText().equalsIgnoreCase("See All"))
			return true;
		else
			return false;

	}

	public boolean iscancelButtonIsDisplayed() {
		//
		if (this.sync(
				driver.findElement(By
						.xpath(".//*[@id='recorderSegment']/ul/li[7]/a/span/span[2]")))
				.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickAudioRecordingButton() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='microphoneImg']")));
		this.sync(driver.findElement(By.xpath(".//*[@id='microphoneImg']")))
				.click();
        Thread.sleep(10000);
		final Screen scrn;
		scrn = new Screen();
		try {
			scrn.wait("src/test/resources/images/images/FlashAllow.PNG", 2500);
			scrn.click("/images/FlashAllow.PNG");
			lazyWait(2000);
		} catch (FindFailed e) {

			e.printStackTrace();
		}
	}

	public boolean isTimeLabelDisplayed() {
		if (this.sync(
				driver.findElement(By
						.xpath(".//*[@class='lpl-content-top']/div[3]/div[2]/span")))
				.getText().contains("See all"))
			return true;
		else
			return false;
	}

	public void clickOn_Select_drop_down_class(){
		this.sync(Select_drop_down_class).click();
	}
	public void clickMath_class_selection(){
		this.sync(Math_class_selection).click();
	}
	public void clickOn_Profile_select_button(){
		this.sync(Profile_select_button).click();
	}
	public void clickOn_Profile_edit_button(){
		this.sync(Profile_edit_button).click();
	}
	public void clickOn_middle_eastern_teacher(){
		this.sync(middle_eastern_teacher).click();
	}
	
	
	public void clickOn_teacher(){
		String expected="lpl-student-profile-pic active";
		//System.out.println("***EXPECTED IS:"+expected);
		
		String actual=asian_female_teacher1.getAttribute("class");
		String actual2=asian_male_teacher1.getAttribute("class");
		String actual3=middle_eastern_teacher1.getAttribute("class");
		String actual4=multi_ethnic_teacher1.getAttribute("class");
		String actual5=asian_female1.getAttribute("class");
		if(expected.equals(actual)) {
			//System.out.println("***ACTUAL IS:"+actual);
			this.sync(asian_male_teacher1).click();
		}else if (expected.equals(actual2)) {
			//System.out.println("***ACTUAL IS:"+actual2);
			this.sync(middle_eastern_teacher1).click();
		}else if (expected.equals(actual3)) {
			//System.out.println("***ACTUAL IS:"+actual3);
			this.sync(multi_ethnic_teacher1).click();
		}else if (expected.equals(actual4)) {
			//System.out.println("***ACTUAL IS:"+actual4);
			this.sync(asian_female1).click();
		}else if (expected.equals(actual5)) {
			//System.out.println("***ACTUAL IS:"+actual5);
			this.sync(asian_female_teacher1).click();
		}
		
	}
	
	
	public void clickOn_Done_button_in_popup(){
		this.sync(Done_button_in_popup).click();
	}
	public void clickOn_Help_link(){
		this.sync(Help_link).click();
	}
	public void clickOn_first_assigned_book_by_teacher(){
		this.sync(first_assigned_book_by_teacher).click();
	}
	public void clickOn_Send_audio_recording() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.sync(Send_audio_recording).click();
	}
	public void clickOn_next_button_Recent_Assignments(){
		try{
		while(next_button_Recent_Assignments.isDisplayed()){
			//this.sync(next_button_Recent_Assignments).click();
			try{
				this.sync(next_button_Recent_Assignments).click();

			}
			catch (Exception e) {
				//System.out.println("Button is disabled");
			}
			
		}			
	}catch (Exception e) {
		//System.out.println("Button is disabled");
	}
	}
	public boolean is_next_button_disabled_Recent_Assignments(){
		boolean flag= false;
		try{
			next_button_disabled_Recent_Assignments.isDisplayed();
				flag = true;
		}
			catch(Exception e)
		{
				flag = true;
		}
			return flag;
			
	}
	public boolean is_profile_image_boarder_displayed(){
		if(profile_image_boarder.isDisplayed() )
			return true;
		else
			return false;
			
	}
	
	public void verify_help_link_URL() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Set<String> allwindows=driver.getWindowHandles();
		Iterator<String> wind=allwindows.iterator();
		String page1=wind.next();
		String page2=wind.next();
		String page3=wind.next();
		driver.switchTo().window(page3);
		String expected="https://scholastic-learning-zone.custhelp.com/";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		//driver.close();
		
	}
	public boolean isMath_class_Text_displayed(){
		if(Math_class_Text.isDisplayed() )
			return true;
		else
			return false;
			
	}
	public boolean is_middle_eastern_teacher_img_displayed() throws InterruptedException{
		Thread.sleep(2000);
		if(middle_eastern_teacher_img_validation.isDisplayed() )
			return true;
		else
			return false;
			
	}
	public boolean is_MY_PROFILE_Text_displayed(){
		if(MY_PROFILE_Text.isDisplayed() )
			return true;
		else
			return false;
			
	}
	public boolean is_SignOut_button_displayed(){
		if(SignOut_button.isDisplayed() )
			return true;
		else
			return false;
			
	}
	public boolean is_Your_profile_image_header_displayed(){
		if(this.sync(Your_profile_image_text).isDisplayed() )
			return true;
		else
			return false;
			
	}
	public void clickOn_Play_button_in_open_book(){
		this.sync(Play_button_in_open_book).click();
	}
	public boolean is_Play_button_in_open_book_displayed(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(Play_button_in_open_book.isDisplayed() )
			return true;
		else
			return false;	
	}
	public void clickOn_SEND_A_MESSAGE_in_open_book() throws InterruptedException{
		Thread.sleep(7000);
		this.sync(SEND_A_MESSAGE_in_open_book).click();
	}
	public boolean is_SEND_A_MESSAGE_in_open_book_displayed(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(SEND_A_MESSAGE_in_open_book.isDisplayed() )
			return true;
		else
			return false;	
	}
	public void clickOn_VIEW_MESSAGES_in_open_book(){
		this.sync(VIEW_MESSAGES_in_open_book).click();
	}
	public boolean is_VIEW_MESSAGES_in_open_book_displayed(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(VIEW_MESSAGES_in_open_book.isDisplayed() )
			return true;
		else
			return false;	
	}
	public void clickOn_CANCEL_in_Send_audio_recording(){
		this.sync(CANCEL_in_Send_audio_recording).click();
	}
	public boolean is_CANCEL_in_Send_audio_recording_displayed(){
		if(CANCEL_in_Send_audio_recording.isDisplayed() )
			return true;
		else
			return false;	
	}
	public boolean is_TIME_in_Send_audio_recording_displayed(){
		if(TIME_in_Send_audio_recording.isDisplayed() )
			return true;
		else
			return false;	
	}
	public void clickOn_RECORD_in_Send_audio_recording(){
		this.sync(RECORD_in_Send_audio_recording).click();
	}
	public boolean is_RECORD_in_Send_audio_recording_displayed(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(RECORD_in_Send_audio_recording.isDisplayed() )
			return true;
		else
			return false;	
	}
	public boolean is_header_in_open_book_displayed() throws InterruptedException{
		Thread.sleep(2000);
		if(header_in_open_book.isDisplayed() )
			return true;
		else
			return false;	
	}
	public boolean is_Send_audio_recording_displayed() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		if(Send_audio_recording.isDisplayed() )
			return true;
		else
			return false;	
	}
	public void click_on_Allow_in_Flash_player() throws InterruptedException{
		Thread.sleep(15000);
		Screen screen=new Screen();
		Pattern image1=new Pattern("C:\\Sikuli\\Allow.PNG");
		try {
			screen.click(image1);
		} catch (Exception e) {
			//System.out.println("image not found");
		}
	}
	public void clickOn_SeeAll_Assigned_by_teacher(){
		this.sync(SeeAll_Assigned_by_teacher).click();
	}
	
	public boolean isHome_to_Books_Page_dislayed(){
		if(Home_to_Books_Page.isDisplayed() )
			return true;
		else
			return false;
			
	}
	
//////////////// 01-02-2016 /////////////////////////
	
	public boolean is_Assignd_By_My_Teacher_header_dislayed(){
		if(Assignd_By_My_Teacher_header.isDisplayed() )
			return true;
		else
			return false;
	}
	public void clickOn_info_icon(){
		try {
			if(info_icon_single_book.isDisplayed() ){
				//this.sync(info_icon_single_book).click();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
	             executor.executeScript("arguments[0].click();", info_icon_single_book);
	             System.out.println("inside book");
				
			}} catch (Exception e) {
			if(info_icon_collection_of_books.isDisplayed() )
				this.sync(info_icon_collection_of_books).click();
			System.out.println("inside collections");
		}
		
	}
	
	
	public boolean is_Summary_of_the_book_dislayed(){
		if(Summary_of_the_book.isDisplayed() )
			return true;
		else
			return false;
	}
	public boolean isReadbuttondislayed(){
		if(Read_InPopup.isDisplayed() )
			return true;
		else
			return false;
			
	}
///////////////18-02-2016 ////////////////////
	public void clickOn_homeTab(){
		this.sync(homeTab).click();
	}
	public String getting_the_src_value_of_FirstBook() throws InterruptedException{
		Thread.sleep(4000);
		String value=First_book_of_RecentAssignments.getAttribute("src");
		String value2="(//img[@src='"+value+"'])[2]";
		return value2;
	}
///////////////19-02-2016 ////////////////////	
	public void mouseOver_on_message_inbox() throws InterruptedException{
		WebElement inbox=Message_inbox;
		Actions act=new Actions(driver);
		act.moveToElement(inbox).perform();
		Thread.sleep(3000);
	}
	public void clickOn_first_message_in_inbox() throws InterruptedException{
		this.sync(first_message_in_inbox).click();
		Thread.sleep(4000);
	}
	public boolean is_Message_header_displayed() throws InterruptedException{
		Thread.sleep(8000);
		if(Message_header.isDisplayed() )
			return true;
		else
			return false;
	}
	public boolean verify_text_message() {
		if(Text_of_message.getText().contains("Hi Jon, this is test mail."))
			return true;
		else
			return false;
	}
	public void verify_text_message2(){
		String value=Text_of_message.getText();
		//System.out.println("############ACTUAL IS: "+value);
		String expected="Hi Jon, this is test mail.";
		Assert.assertEquals("Text message is not same", value, expected);
	}
	
	public void clickSucessfulOkButton(){
		this.sync(driver.findElement(By.xpath(".//*[@id='pop-up-button-yes']")))
		.click();
	}
	
	public boolean MyLexile(){
		reportLog("Checking My lexile if it has a BR assocated with it");
		boolean result=false;
		String Lexile = getText(MYLexile);
		String Str = new String(Lexile);
		if(Str.matches("BR(.*)") && Str.matches("(.*)[0-9](.*)") && Str.matches("(.*)L")){
			result=true;
			reportLog("Checked and conformed that Lexile score has BR in the Prefix if the student has negative lexile score");
		}
		return result;
	}
	
	public void OverviewPage(){
		click(Student);
		click(StudentOverView);
		reportLog("Clicked on the class overview buton");
	}
	
	public void TableView(){
		click(TableView);
	}
	@FindBy(xpath = "//button[@ng-class='{active:tableView}']")
	private WebElement TableView;
	
	@FindBy(xpath = "//div[@dropdown-select-all-class='classSelections']/span")
	private WebElement ClassDropdown;
	
	public void SelectAllClasses(){
		lazyWait(4);
		click(ClassDropdown);
		click(driver.findElement(By.xpath("//ul/li/a[contains(text(),'All Classes')]")));
	}
	
	public boolean VerifyTableContent(String TableContent){
		lazyWait(3);
		boolean result = false;
		ArrayList<String> a= new ArrayList<String>();
		int size =driver.findElements(By.xpath("//tr/th")).size();
		for(int i=1; i<=size; i++){
			String xpaths="(//tr/th)["+i+"]";
			a.add(getText(driver.findElement(By.xpath(xpaths))));
		}
		System.out.println(a+"========================================="+(TableContent));
		if(a.contains(TableContent)){
			result=true;
		}
		return result;
	}
	
	public boolean VerifyClassCol(String TableContent){
		lazyWait(3);
		boolean result = false;
		ArrayList<String> a= new ArrayList<String>();
		int size =driver.findElements(By.xpath(".//*[@id='class-students-table']/tbody/tr/td[1]/span")).size();
		for(int i=1; i<=size; i++){
			String xpaths="(.//*[@id='class-students-table']/tbody/tr/td[1]/span)["+i+"]";
			a.add(getText(driver.findElement(By.xpath(xpaths))));
		}
		System.out.println(a+"========================================="+(TableContent));
		if(a.contains(TableContent)){
			result=true;
		}
		return result;
	}
	
	
	public boolean VerifyTableContentAplha(){
		boolean result=false;
		ArrayList<String> a= new ArrayList<String>();
		ArrayList<String> b= new ArrayList<String>();
		int i = driver.findElements(By.xpath(".//*[@id='class-students-table']/tbody/tr/td[1]/span")).size();
		for(int j=1; j<=i; j++){
			System.out.println(j);
			String xpaths="(.//*[@id='class-students-table']/tbody/tr/td[1]/span)["+j+"]";
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		System.out.println(a);
		b.addAll(a);
		Collections.sort(a);
		System.out.println("Before sorting "+b);
		System.out.println("After sorting "+a);
		if(b.equals(a)){
			reportLog("The data is arranged in Alphabetical order of class");
			result=true;
		}
		return result;
	}
	
	public boolean Tablesorting(String col){
		boolean result=false;
		String SortXpath=".//*[@id='class-students-table']/thead/tr/th[contains(text(),'"+col+"')]";
		
		System.out.println("----------------------------------------------------"+col);
		click(driver.findElement(By.xpath(SortXpath)));
		lazyWait(2);
		String TableXpath = null;
		if(col.equalsIgnoreCase("Average Lexile")){
			TableXpath = ".//*[@id='class-students-table']/tbody/tr/td[2]";
		}
		else if(col.equalsIgnoreCase("Assigned Books")){
			TableXpath = ".//*[@id='class-students-table']/tbody/tr/td[3]";
		}
		else if(col.equalsIgnoreCase("Completed Books")){
			TableXpath = ".//*[@id='class-students-table']/tbody/tr/td[4]";
		}
		else if(col.equalsIgnoreCase("Words Read")){
			TableXpath = ".//*[@id='class-students-table']/tbody/tr/td[5]";
		}
		
		
		int c;
		ArrayList<Integer> a= new ArrayList<Integer>();
		ArrayList<Integer> b= new ArrayList<Integer>();
		int i = driver.findElements(By.xpath(TableXpath)).size();
		for(int j=1; j<=i; j++){
			System.out.println(j);
			String xpaths="("+TableXpath+")["+j+"]";
			c=Integer.parseInt(driver.findElement(By.xpath(xpaths)).getText().replaceAll("[BR, L, ',']", ""));
			a.add(c);
		}
		System.out.println("_____________________________"+a);
		b.addAll(a);
		Collections.sort(a);
		System.out.println("Before sorting "+b);
		System.out.println("After sorting "+a);
		if(b.equals(a)){
			reportLog("The data is arranged in Alphabetical order of class");
			result=true;
		}
		lazyWait(2);
		return result;
	}
	
	public boolean StdTabStudentLexile(String StudentName){
		reportLog("Checking Student lexile in overview if it has a BR assocated with it");
		boolean result=false;
		String xpath = "//div[contains(text(),'"+StudentName+"')]/parent::div/div[2]";
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath(xpath))));
		WebElement StdTabStudentLex = driver.findElement(By.xpath(xpath));
		click(StdTabStudentLex);
		String Lexile = getText(StdTabStudentLex);
		String Str = new String(Lexile);
		if(Str.matches("BR(.*)") && Str.matches("(.*)[0-9](.*)") && Str.matches("(.*)L")){
			result=true;
			reportLog("Checked and conformed that Lexile score has BR in the Prefix if the student has negative lexile score");
		}
		return result;
	}

	static String wordreadStds;
	static String TimeSpendStds;
	public void CollectStdData(){
		wordreadStds = getText(WordReadStd).replace(",", "");
		TimeSpendStds = getText(TimeSpendStd);
		TimeSpendStds = TimeSpendStds.substring(TimeSpendStds.indexOf("hrs") + 3);
		TimeSpendStds = TimeSpendStds.substring(0, TimeSpendStds.indexOf("mins"));
		
		reportLog(wordreadStds +"=============="+TimeSpendStds);
	}
	
	public void SelectOptionMyBook(String Option){
		String xpath="//span[contains(text(),'My books')]/parent::div/parent::div//div[contains(text(),'"+Option+"')]";
		lazyWait(5);
		click(driver.findElement(By.xpath(xpath)));
	}
	
	static String BookWrdCnt;
	public void CollectWrdCnt(){
		BookWrdCnt = getText(WrdCnt);
	}
	
	public void ReadBtn(){
		click(Readbtn);
	}
	
    public int TimeSpntBook;
	public void loadinimg(){
		WebDriverWait wait1 = new WebDriverWait(driver, 360);
		wait1.until(ExpectedConditions.elementToBeClickable((By.xpath("//img[@class='lpl-icon-right-arrow']"))));
		lazyWait(5);
		
		PageNumTxt.sendKeys("1");
		reportLog("Setting the page number to 1 for starting");
		int CurrrentPg;
		int ActualPg = Integer.parseInt(PgeNum.getText());
		
		
		for (int i=1; i<=ActualPg; i++){
			wait1.until(ExpectedConditions.elementToBeClickable((By.xpath("//img[@class='lpl-icon-right-arrow']"))));
			click(NextArrow);
			lazyWait(3);
			CurrrentPg  = Integer.parseInt(PageNumTxt.getAttribute("value"));
			if(CurrrentPg == ActualPg){
				TimeSpntBook =  Integer.parseInt(new SimpleDateFormat("mm").format(Calendar.getInstance().getTime()));
				break;
			}
		}
		reportLog("Reading the book and pausing them");
	}
	
	public void CloseBook(){
		click(CloseBook);
		reportLog("Closed the book after reading");
		lazyWait(10);
	}
	
	public boolean VerifyWordReadTimeSentReading(){
		boolean result=false;
		lazyWait(10);
		String ActualwordreadStds = getText(WordReadStd).replace(",", "");
		String ActualTimeSpendStds = getText(TimeSpendStd);
		ActualTimeSpendStds = ActualTimeSpendStds.substring(ActualTimeSpendStds.indexOf("hrs") + 3);
		ActualTimeSpendStds = ActualTimeSpendStds.substring(0, ActualTimeSpendStds.indexOf("mins"));
		
		int ExpectedwordreadStds =Integer.parseInt(wordreadStds)+ Integer.parseInt(BookWrdCnt);
		
		System.out.println(ActualwordreadStds+"------------------------------"+(String.valueOf(ExpectedwordreadStds)));
		if(ActualwordreadStds.equals(String.valueOf(ExpectedwordreadStds))){
			result=true;
		}
		return result;
	}
	
	
	public String actualData(){
		wordreadStds = getText(WordReadStd).replace(",", "");
		TimeSpendStds = getText(TimeSpendStd);
		TimeSpendStds = TimeSpendStds.substring(TimeSpendStds.indexOf("hrs") + 3);
		TimeSpendStds = TimeSpendStds.substring(0, TimeSpendStds.indexOf("mins"));
		
		reportLog(wordreadStds +"=============="+TimeSpendStds);
		return PAGE_TITLE;
	}
	
	@FindBy(xpath="//button//span[contains(text(),'Export')]")	
	private WebElement ExportBtn;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu']//a[contains(text(),'Export All')])[1]")	
	private WebElement ExportDrpDwn;
	public void ExportBtn(){
		click(ExportBtn);
		lazyWait(1);
		click(ExportDrpDwn);		
		lazyWait(10);
	}
	
	public void ClassDrpDwn(){
		click(ClssDrpdwn);
		reportLog("Clicked on the class dropdown");
	}
	
	public boolean CollectClassdata(){
		boolean result=false;
		ArrayList<String> a= new ArrayList<String>();
		ArrayList<String> b= new ArrayList<String>();
		int i = driver.findElements(By.xpath("//div[@dropdown-item-label='className' and @dropdown-model='classSelection']//a")).size();
		for(int j=1; j<=(i-1); j++){
			System.out.println(j);
			String xpaths="(//div[@dropdown-item-label='className' and @dropdown-model='classSelection']//a)["+j+"]";
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		System.out.println(a);
		b.addAll(a);
		Collections.sort(a);
		System.out.println(a);
		System.out.println(b);
		if(b.equals(a)){
			reportLog("The classes are arranged in Alphabetical order");
			result=true;
		}
		return result;
	}
	
	public boolean CollectStudentdata(){
		lazyWait(7);
		String lastname;
		String[] arrSplit;
		boolean result=false;
		ArrayList<String> a= new ArrayList<String>();
		ArrayList<String> b= new ArrayList<String>();
		int i = driver.findElements(By.xpath("//div[@class='lpl-student-profile-text1 ng-binding']")).size();
		for(int j=1; j<=i; j++){
			String xpaths="(//div[@class='lpl-student-profile-text1 ng-binding'])["+j+"]";
			lastname = driver.findElement(By.xpath(xpaths)).getText();
			arrSplit=lastname.split(" ");
			a.add(arrSplit[1]);
		}
		System.out.println(a);
		b.addAll(a);
		Collections.sort(a);
		System.out.println(a);
		System.out.println(b);
		if(b.equals(a)){
			reportLog("The classes are arranged in Alphabetical order");
			result=true;
		}
		return result;
	}
	
	public boolean AlphabeticalOrder(){
		boolean result=false;
		ArrayList<String> a= new ArrayList<String>();
		ArrayList<String> b= new ArrayList<String>();
		int i = driver.findElements(By.xpath("//div[@class='lpl-student-grade-dropdown lpl-dropdown-blue wrap-dd-select ng-isolate-scope active']//a")).size();
		for(int j=1; j<=i; j++){
			System.out.println(j);
			String xpaths="(//div[@class='lpl-student-grade-dropdown lpl-dropdown-blue wrap-dd-select ng-isolate-scope active']//a)["+j+"]";
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		System.out.println(a);
		b.addAll(a);
		Collections.sort(a);
		System.out.println(a);
		System.out.println(b);
		if(b.equals(a)){
			reportLog("The classes are arranged in Alphabetical order");
			result=true;
		}
		return result;
	}
	
	public void AssignedBooksReport(){
		click(Student);
		click(AssignedBooksReportdrpdwn);
		reportLog("Clicked on the Assigned book report from the tab");
		lazyWait(5);
	}
	
	public void Searchkeyword(String keyword){
		SrchTxtBx.sendKeys(keyword);
	}

	public boolean VerifyBooksInRecentStudentActivity(String Status){
		boolean result = false;
		isVisible(previous_button_disable_open_book);
		String Xpath = "(//div[@class='owl-wrapper'])[2]//img[@src=\""+getbooktitlesb()+"\"]";
		System.out.println("'''''''''''''''''''"+Xpath);
		int num = driver.findElements(By.xpath(Xpath)).size();
		System.out.println("-------num-----------------"+num);
		String XpathStatus = "((//div[@class='owl-wrapper'])[2]//img[@src=\""+getbooktitlesb()+"\"]/parent::div/parent::div//span)[1]";
		String Statusreport = driver.findElement(By.xpath(XpathStatus)).getText();
		
		System.out.println("-------num-----------------"+num);
		System.out.println(Statusreport+"------status---------------"+Status);
		
		if(num>0 && Statusreport.equalsIgnoreCase(Status)){
			reportLog("Found the book which student read completely in Recent Student Activity section");
			reportLog("Status of the book is :"+Status);
			result=true;
		}
		return result;
	}
	
	public void MessageIcon(){
		Actions act=new Actions(driver);
		act.moveToElement(MessageIcon).perform();
	}
	
	public boolean AssignmentMessage(String Message){
		boolean result=false;
		String ActualMEssage =driver.findElement(By.xpath("(//div[@class='lpl-msg-subject-container']/span)[1]")).getText();
		String ExpectedMessage = Message +" "+getCollectionTitle();
		System.out.println(ExpectedMessage+"----------------------------"+ActualMEssage);
		if(ExpectedMessage.contains(ActualMEssage)){
			reportLog("The Collection Assiging message was displayed to student");
			result=true;
		}
		return result;
	}
	
	public boolean ClickCollectionMessage(){
		boolean result = false;
		Message.click();
		lazyWait(3);
		String Collecitiontitle = CollectionTitle.getText();
		int Expectednum =Integer.parseInt(CollectionTitleNum.getText().replace("(", "").replace(")", "").trim());
		int ActualNum = driver.findElements(By.xpath("//img[@class='lpl-book-style lpl-avatar-relative lpl-avatar-maxheight']")).size();
		if(Collecitiontitle.contains(getCollectionTitle()) && Expectednum==ActualNum){
			reportLog("The collection assigned by teacher is visible to student");
			result = true;
		}
		return result;
	}
	public void ClickAssignBookReport(){
	  this.sync(driver.findElement(By.xpath(".//a[contains(text(),'ASSIGNED BOOKS REPORT')]"))).click();
	  lazyWait(5);
	}

	public void clickReadBtn() {
		this.sync(ReadBtns).click();
		
	}

	public void clickStudentOverview() {
		this.sync(driver.findElement(By.xpath(".//li[1]/a[text()='STUDENT OVERVIEW']"))).click();
		
	}
}