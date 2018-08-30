package com.scholastic.intl.litpro.test.automation.pageobjects;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.testng.Assert;


















//import pageobject.ParentPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.torque.common.WaitUtils;

public class ReportsPg extends ParentPage {
	BooksObject booksObj = new BooksObject();
	BooksObject booksObjs = new BooksObject();
	WebDriver driver;

	@FindBy(xpath = "//h3[contains(text(), 'Reports for')]")
	private WebElement pgHeader;

	@FindBy(xpath = "//button[i[@class='img-btn-close']]")
	WebElement reportModalCloseBtn;

	@FindBy(xpath = "//div[7]/div[1]/div/div[2]/h3")
	WebElement reportHeading;

	@FindBy(xpath = "//div[@id='cohortSearch']/input")
	WebElement searchTxtBox;

	@FindBy(xpath = "//div[@id='cohortSearch']/button")
	WebElement searchBtn;

	@FindBy(xpath = "//div[contains(@class,'notification-content')]/h3")
	private WebElement notificationText;

	// *** Student data entry pop up modal ***//
	@FindBy(id = "")
	private WebElement studentdatabutton;

	// ******** Below added for Student Report Card **********************
	@FindBy(xpath = "(.//h3)[2]")
	private WebElement pageTitle;

	@FindBy(xpath = "//*[@id='main-content']//h4/span[contains(text(), 'Grade:')]")
	private WebElement gradeLabel;

	@FindBy(xpath = "//*[@id='main-content']//h4/span[contains(text(), 'Class:')]")
	private WebElement classLabel;

	@FindBy(xpath = "//span[contains(text(), 'Current Lexile')]")
	private WebElement lexileLabel;

	// 483L
	@FindBy(xpath = "//span[contains(text(), 'Current Lexile')]/parent::div/parent::div/div[2]/span")
	private WebElement lexileText;

	@FindBy(xpath = "(.//h3)[2]/parent::div/parent::div[1]/div[4]/div/div[1]/span")
	private WebElement lexilegrowthLabel;

	// @FindBy(xpath = "")
	// private WebElement lexilegrowthText;

	@FindBy(xpath = "//span[contains(text(), 'Date of Last Completed LitPro Test')]")
	private WebElement lastcompletedLabel;

	@FindBy(xpath = "//span[contains(text(), 'Date of Last Completed LitPro Test')]/parent::div/parent::div/div[2]/span")
	private WebElement lastcompdateText;
	
	@FindBy(xpath = "//span[contains(text(), 'Lexile Growth')]/parent::div/parent::div/div[2]/span")
	private WebElement LexileGrowthText;

	@FindBy(xpath = "//span[contains(text(), 'Lexile Growth')]")
	private WebElement LexileGrowthLabel;
	
	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Certificate Level')]")
	private WebElement certificateLabel;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Certificate Level')]/parent::div/parent::div/div[2]//span")
	private WebElement certificateText;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Proficiency Band')]")
	private WebElement proficiencyLabel;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Proficiency Band')]/parent::div/parent::div/div[2]/span")
	private WebElement proficiencyText;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), '# of Quizzes Passed/Attempted')]")
	private WebElement quizpaLabel;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), '# of Quizzes Passed/Attempted')]/parent::div/parent::div/div[2]/span")
	private WebElement quizpaText;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Average Quiz Score')]")
	private WebElement avgscoreLabel;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Average Quiz Score')]/parent::div/parent::div/div[2]/span")
	private WebElement avgscoreText;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Average Lexile of Quizzes Passed')]")
	private WebElement avglexquizpassedLabel;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Average Lexile of Quizzes Passed')]/parent::div/parent::div/div[2]/span")
	private WebElement avglexquizpassedText;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Words Read')]")
	private WebElement wordsreadLabel;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Words Read')]/parent::div/parent::div/div[2]/span")
	private WebElement wordsreadText;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Quiz Points Earned')]")
	private WebElement ptsearnedLabel;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Quiz Points Earned')]/parent::div/parent::div/div[2]/span")
	private WebElement ptsearnedText;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Teacher-Added Points')]")
	private WebElement teacherptsLabel;

	@FindBy(xpath = "//*[@id='main-content']//span[contains(text(), 'Teacher-Added Points')]/parent::div/parent::div/div[2]/span")
	private WebElement teacherptsText;
	// *****
	@FindBy(xpath = "//*[@id='main-content']/div[2]/div[3]/div/div[2]/div[1]/h4")
	private WebElement lexhistoryLabel;
	
	@FindBy(xpath = "//*[@class='row-fluid quiz-cell ng-scope']")
	private WebElement StudentActivity;

	@FindBy(xpath = ".//div[@class='report-card']/div[2]/div[3]//button[2]")
	private WebElement calendarArrow;

	@FindBy(xpath = ".//div[@class='report-card']/div[2]/div[3]/div[1]/button")
	private WebElement viewreportButton;

	@FindBy(xpath = "html/body/h4")
	WebElement StudentName;
	
	@FindBy(xpath = "html/body/span[1]")
	WebElement StudentGrade;
	
	@FindBy(xpath = "html/body/span[2]")
	WebElement StudentClass;

	@FindBy(xpath = "//*[@id='main-content']/div[2]/div[4]/div[1]/div[1]/h3")
	private WebElement studentactivitiesLabel;

	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[1]/div[1]/a/h4")
	private WebElement titleauthorLink;

	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[1]/div[2]/a/h4")
	private WebElement lexileLink;

	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[1]/div[3]/a/h4")
	private WebElement wordcountLink;

	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[1]/div[4]/a/h4")
	private WebElement dateLink;

	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[1]/div[5]/a/h4")
	private WebElement scoreLink;

	@FindBy(xpath = ".//img[@ng-src='../../images/logo_scholastic.png']")
	private WebElement LiproLogo;

	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[1]/div[6]/a/h4")
	private WebElement pointsLink;

	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[1]/div[7]/h4")
	private WebElement viewLabel;

	@FindBy(xpath = "//*[@id='main-content']/div[2]/div[2]/div/div/div[13]/div/div[2]")
	private WebElement addedpointsText;

	@FindBy(xpath = "//*[@id='main-content']/div[2]/div[1]/div[2]/button[2]")
	private WebElement printArrow;

	@FindBy(xpath = "//*[@id='main-content']/div[2]/div[1]/div[2]/ul/li[1]/a")
	private WebElement printParent;

	@FindBy(xpath = "//*[@id='main-content']/div[2]/div[1]/div[2]/ul/li[2]/a")
	private WebElement printTest;

	@FindBy(xpath = "//*[@id='main-content']/div[2]/div[1]/div[2]/ul/li[3]/a")
	private WebElement printReportCard;

	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[1]")
	private WebElement sa_titleText;

	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[1]")
	private WebElement sa_authorText;

	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[2]")
	private WebElement sa_lexileText;
	
	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[3]")
	private WebElement sa_wordcountText;

	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[4]")
	private WebElement sa_dateText;
	
	@FindBy(xpath = "(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[5]")
	private WebElement sa_scoreText;
	
	@FindBy(xpath = "html/body/div[2]/span")
	WebElement StudentNameRRC;
	
	@FindBy(xpath = "html/body/div[3]/span")
	WebElement StudentGradeRRC;
	
	@FindBy(xpath = "html/body/div[4]/span")
	WebElement StudentClassRRC;
	
	@FindBy(xpath = ".//h5[contains(text(),'Student:')]")
	WebElement StudentNameTest;
	
	@FindBy(xpath = ".//h5[contains(text(),'Grade:')]")
	WebElement StudentGradeTest;
	
	@FindBy(xpath = ".//h5[contains(text(),'Class:')]")
	WebElement StudentClassTest;
	
	@FindBy(xpath = "//div[2]/div[3]/div/div/div[2]/div[2]/div[4]/div[2]/div/div[2]/div/div[6]/form/input")
	private WebElement sa_pointsText;
	
	@FindBy(xpath = "//div[2]/div[3]/div/div/div[2]/div[2]/div[4]/div[2]/div/div[2]/div/div[6]/form/button")
	private WebElement sa_editLink;
	
	@FindBy(xpath = "//div[2]/div[3]/div/div/div[2]/div[2]/div[4]/div[2]/div/div[2]/div/div[7]/a")
	private WebElement sa_quizLink;
	
	@FindBy(xpath = "html/body/div[1]/img[2]")
	WebElement PrintMyresultAwardCertificate;

	@FindBy(xpath = "//span")
	WebElement PrintCertificateStudentName;

	@FindBy(xpath =".//*[@id='navHome']/a/span")
	private WebElement hometab;
	
	@FindBy(xpath = "//*[@id='metrics']//span[contains(text(), 'Average Quiz Score')]/parent::div/parent::div/div[2]//span")
	private WebElement AverageQuizScoreDshBord;
	
	@FindBy(xpath = "//*[@id='metrics']//span[contains(text(), 'Number of Quizzes Taken')]/parent::div/parent::div/div[2]//span")
	private WebElement NumberQuizzesTakenDshBord;
	
	@FindBy(xpath = "//*[@id='metrics']//span[contains(text(), 'Quiz Pass Rate')]/parent::div/parent::div/div[2]//span")
	private WebElement QuizPassRateDshBord;
	
	@FindBy(xpath = "//*[@id='metrics']//span[contains(text(), 'Words Read')]/parent::div/parent::div/div[2]//span")
	private WebElement WordsReadDshBord;
	
	@FindBy(xpath = "//*[@id='metrics']//span[contains(text(), 'Average Lexile Growth This Year')]/parent::div/parent::div/div[2]//span")
	private WebElement AvgLexGrowthDshBord;
	
	@FindBy(xpath = "//*[@id='metrics']//span[contains(text(), 'Average Lexile')]/parent::div/parent::div/div[2]//span")
	private WebElement AvgLexileDshBord;
	
	@FindBy(xpath = ".//*[@id='main-content']//button[@ng-controller = 'CreateActivityController']")
	private WebElement AddActivityButton;
	
	@FindBy(xpath = "//span[contains(text(), '01')]")
	private WebElement AddActivityDate01;
	
	@FindBy(xpath = "//h3[contains(text(), 'Add Activity')]")
	private WebElement AddActivityWindowHeader;
	
	@FindBy(xpath = "//div[5]/button/span[contains(text(), 'Add Activity')]/parent::button")
	private WebElement AddActivitybuttonPOPup2;

	@FindBy(xpath = "//div[5]/button/span[contains(text(), 'Add Activity')]")
	private WebElement AddActivitybuttonPOPup;

	@FindBy(xpath = "//li//div[@ng-class='{roundBorder: questionObj.studentAnsDisplay === $index}']")
	private WebElement Answer;
	
	@FindBy(xpath = "(.//span[contains(text(), 'Print Options')])[1]")
	private WebElement PrintOption;
	
	@FindBy(xpath = ".//a[contains(text(), 'Print Student Test')]")
	private WebElement PrintStudentTest;

	@FindBy(xpath = "//input[@placeholder='Title of Activity']")
	private WebElement AddActivityTitle;
	
	@FindBy(xpath = "//input[@placeholder='Points']")
	private WebElement AddActivityPoint;
	
	@FindBy(xpath = "//input[@placeholder='Date']")
	private WebElement AddActivityDate;

	@FindBy(xpath = "//input[@placeholder='Title of Book (optional)']")
	private WebElement AddActivityTitleBook;

	@FindBy(xpath = ".//*[@id='main-content']//span[contains(@class,'report-card-data ng-scope ng-binding')]")
	WebElement ReportStudentAwardCertificate;

	@FindBy(xpath = ".//*[@id='main-content']//button[1]/span[contains(text(), 'Print Options')]")
	WebElement PrintOptions;

	@FindBy(xpath = ".//span[contains(text(), 'Print Certificate')]")
	WebElement PrintCertificate;

	@FindBy(xpath = ".//*[@id='main-content']//h3[contains(text(), 'Reports for')]")
	WebElement StudentNameLitpro;
	
	@FindBy(xpath = "//*[@id='reports-table']/tbody/tr[1]/td[1]")
	private WebElement StudentNameLabel;

	@FindBy(xpath = "//*[@id='reports-table']/tbody/tr")
	private WebElement ReportsTable;
	
	@FindBy(xpath = "//div[2]/h3")
	private WebElement LexileGrowthReport_label;

	@FindBy(xpath = "//*[@id='grade-selector']")
	private WebElement GradeLevelDropdwon;
	
	@FindBy(xpath = "//button[@analytics-label='Lexile Growth Report']")
	private WebElement LexileGrowthReport_viewReprotButton;
	
	@FindBy(xpath = "//button[@analytics-label='Lexile Compared to Norm Report']")
	private WebElement LexileComparedNormReport_viewReprotButton;
	
	@FindBy(xpath = "//button[@analytics-label='Class Lexile History Report']")
	private WebElement ClassLexileHistoryReport_viewReprotButton;
	
	@FindBy(xpath = "//button[@analytics-label='Class Reading Report Card']")
	private WebElement ClassReadingReportCard_viewReprotButton;
	
	@FindBy(xpath = "//button[@analytics-label='Class Quiz Activity Report']")
	private WebElement ClassQuizActivityReport_viewReprotButton;
	
	@FindBy(xpath = "//button[@analytics-label='Expected Lexile Growth Report']")
	private WebElement ExpectedLexileGrowthReport_viewReprotButton;
	
	@FindBy(xpath = "//button[@analytics-label='Book Comprehension Report']")
	private WebElement BookComprehensionReport_viewReprotButton;
	
	@FindBy(xpath = "//button[@analytics-label='Quiz Pass Rate Report']")
	private WebElement QuizPassRateReport_viewReprotButton;

	@FindBy(xpath = "//button[@analytics-label='Reading Proficiency Report']")
	private WebElement ReadingProficiencyReport_viewReprotButton;
	
	@FindBy(xpath = "//*[@id='grade-selector']")
	private WebElement gradeSelector;
	
	@FindBy(xpath = "//button[@analytics-label='Student Lexile History Report']")
	private WebElement StudentLexileHistoryReport_viewReprotButton;

	@FindBy(xpath = "//*[@id='reports-table']/tbody/tr[1]/th")
	private WebElement StudentFirstDate;
		
	@FindBy(xpath = "//*[@id='reports-table']/tbody/tr[1]/td")
	private WebElement StudentFirstLexile;
	
	@FindBy(xpath="//a[text()='%s']")
	private WebElement className;

	@FindBy(xpath=".//*[@id='main-content']//button[@ng-controller='CreateActivityController']/span")
	private WebElement addactivityButton;
	
	@FindBy(xpath = ".//*[@ng-repeat='quiz in quizzes | orderByUndefinedLast:predicate:reverse'][1]//button")
	private WebElement editLink1;
	
	@FindBy(xpath = ".//button/span[contains(text(), 'View All Comments')]")
	private WebElement viewcommentsButton;

	public WebElement getStudentDataButton(){
		return studentdatabutton;
	}
	@FindBy(id="WIP")
	private WebElement studentdatamodal;

	@FindBy(id="SaveButtonLocatorWIP")
	private WebElement savebuttonmodal;
	// Student Activities
	
	@FindBy(xpath = ".//h3[contains(text(), 'Points Updated')]")
	private WebElement PopupMessage;
	
	@FindBy(xpath = "(//button/span[contains(text(),'School Calendar 2017-2018')])[2]")
	private WebElement YearDropDown;

	@FindBy(xpath = "(.//span[contains(text(), 'Print Options')])[2]")
	private WebElement OptionClass;
	
	public ReportsPg(WebDriver driver, LitProUserType userType) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public String getHeaderText() {
		return this.getText(pgHeader);
	}

	public boolean isReportDisplayed(String reportName) {
		String xpath = "//div[h4[text()='" + reportName + "']]";
		WebElement ReportTextElement = this.getElement(By.xpath(xpath));

		if (ReportTextElement != null)
			return true;

		return false;
	}

	public void openReport(String reportName) {
		this.reportLog("Open '" + reportName + "' Report");
		String xpath = "//div[div[h4[text()='" + reportName
				+ "']]]//button[text()='View Report']";
		WebElement ReportLink = this.getElement(By.xpath(xpath));
		this.click(ReportLink);
	}

	public String getNotificationHeader() {
		WebElement we = this
				.getElement(
						By.xpath("//div[contains(@class,'dr-notification-wrapper')][1]//h3"),
						5);
		String text = "";
		if (we != null) {
			text = this.getText(we);
			this.reportLog("Notification: " + text);
			return text;
		}
		this.reportLog("No Notification Displayed");
		return text;
	}

	public String getNotificationText() {
		WebElement we = this
				.getElement(
						By.xpath("//div[contains(@class,'dr-notification-wrapper')][1]//p"),
						5);
		String text = "";
		if (we != null) {
			text = this.getText(we);
			this.reportLog("Notification: " + text);
			return text;
		}
		this.reportLog("No Notification Displayed");
		return text;
	}

	public String getReportModalHeaderText() {
		String popHeader = "NULL";
		String xpathExpression = "//div[contains(@class, 'modal-header')]//h3";
		WebElement reportModalHeader = this.getElement(By
				.xpath(xpathExpression));
		if (reportModalHeader != null) {
			popHeader = reportModalHeader.getText();
			this.reportLog("Report Popup header: " + popHeader);
		}

		return popHeader;

	}

	public void closeReport() {
		this.reportLog("Closing Report");
		this.click(this.reportModalCloseBtn);
	}

	public void searchStudentReportByUserName(String studentId) {
		this.reportLog("Search Student: " + studentId);
		this.type(this.searchTxtBox, studentId);
		this.searchTxtBox.submit();
	}

	public String getReportCardItemValue(String itemName) {
		String xpath = "//div[contains(@class,'report-card-item') and .//span[text()='"
				+ itemName + "']]//span[contains(@class,'report-card-data')]";
		WebElement reportLink = this.getElement(By.xpath(xpath));

		if (reportLink != null) {
			String repItemValue = this.getText(reportLink);
			this.reportLog("Report Item '" + itemName + "' value: "
					+ repItemValue);
			return repItemValue;
		}
		return "NULL";
	}

	public void searchSmartbar(String searchName) {
		reportLog("Searching for " + searchName);
		searchTxtBox.clear();
		searchTxtBox.sendKeys(searchName);
		searchBtn.click();
		waitForPageLoad(3000);
		reportLog("Search completed for " + searchName);
		lazyWait(5);
	}

	public String getpageTitle() {
		return pageTitle.getText();
	}

	public String getclassLabel() {
		return classLabel.getText();
	}

	public String getStudentNameLabel() {
		return pgHeader.getText().replaceAll("Reports for ", "");
	}

	public String getgradeLabel() {
		reportLog("Collecting student grade");
		return gradeLabel.getText();
	}

	public String getlexileLabel() {
		return lexileLabel.getText();
	}

	public String getlexileText() {
		reportLog("Collecting student Lexile");
		return lexileText.getText();
	}

	public String getlexilegrowthLabel() {
		return lexilegrowthLabel.getText();
	}

	public String getlastcompletedLabel() {
		return lastcompletedLabel.getText();
	}

	public String getlastcompdateText() {
		reportLog("Collecting student Last complete date");
		return lastcompdateText.getText();
	}
	
	public String getLexileGrowthText() {
		reportLog("Collecting student Last complete date");
		String LexileGrowthTexts=LexileGrowthText.getText();
		if(LexileGrowthTexts.equals("")){
			LexileGrowthTexts="0";
		}
		return LexileGrowthTexts;
	}

	public String getcertificateLabel() {
		return certificateLabel.getText();
	}

	public String getcertificateText() {
		return certificateText.getText();
	}

	public String getproficiencyLabel() {
		return proficiencyLabel.getText();
	}

	public String getproficiencyText() {
		reportLog("Collecting student Proficiency band");
		return proficiencyText.getText();
	}

	public String getquizpaLabel() {
		return quizpaLabel.getText();
	}

	public String getquizpaText() {
		return quizpaText.getText();
	}

	public String getavgscoreLabel() {
		return avgscoreLabel.getText();
	}

	public String getavgscoreText() {
		return avgscoreText.getText();
	}

	public String getavglexquizpassedLabel() {
		return avglexquizpassedLabel.getText();
	}

	public String getavglexquizpassedText() {
		return avglexquizpassedText.getText();
	}

	public String getwordsreadLabel() {
		return wordsreadLabel.getText();
	}

	public String getwordsreadText() {
		return wordsreadText.getText().replaceAll(",", "");
	}

	public String getptsearnedLabel() {
		return ptsearnedLabel.getText();
	}

	public String getptsearnedText() {
		return ptsearnedText.getText();
	}

	public String getteacherptsLabel() {
		return teacherptsLabel.getText();
	}

	public String getteacherptsText() {
		return teacherptsText.getText();
	}

	public Object gettitleauthorLink() {
		return this.sync(titleauthorLink).getText();
	}

	public Object getlexileLink() {
		return lexileLink.getText();
	}

	public Object getwordcountLink() {
		return wordcountLink.getText();
	}

	public Object getdateLink() {
		return dateLink.getText();
	}

	public Object getscoreLink() {
		return scoreLink.getText();
	}

	public Object getpointsLink() {
		return pointsLink.getText();
	}

	public Object getviewLabel() {
		return viewLabel.getText();
	}

	public boolean verifycalendarDropdown() {
		calendarArrow.click();
		String expected = "School Calendar 2017-2018";
		String actual;
		// Find element
		// School Calendar 2015
		actual = driver
				.findElement(By
						.xpath(".//div[@class='report-card']/div[2]/div[3]/div[2]/div/div/ul/li[1]/a")).getText();
		if (!actual.equals(expected))
			return false;
		// Find element All years
		System.out.println(actual+"^^^^^^^^1^^^^^^"+expected);
		expected = "View all years";
		actual = driver
				.findElement(By
						.xpath(".//*[@id='main-content']/div[2]/div[4]/div/div[2]/div[3]/div[2]/div/div/ul/li/a[contains(text(), 'View all years')]")).getText();
		System.out.println(actual+"^^^^^^^^2^^^^^^"+expected);
		if (!actual.equals(expected))
			return false;
		// driver.findElement(By.xpath(""));
		return true;
	}

	public boolean verifyreport() {
		viewreportButton.click();
		String expected = "Student Lexile History Report";
		String actual = "";
		actual = this.sync(reportHeading).getText();
		if (actual.equals(expected)) {
			reportModalCloseBtn.click();
			return true;
		}
		return false;
	}
	
	public boolean VerifyClassGrade(){
		String classN = getclassLabel();
		String Grade = getgradeLabel();
		boolean result=false;
		reportLog("Comapring students grade and classes");
		if(!classN.isEmpty() && !Grade.isEmpty()){
			result = true;
		}
		return result;		
	}

	public boolean verifycolumnsort() {
		titleauthorLink.click();
		WebElement top1 = driver
				.findElement(By
						.xpath("(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[1]"));
		titleauthorLink.click();

		WebElement top2 = driver
				.findElement(By
						.xpath("(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[1]"));
		if (top1.getText().equals(top2.getText()))
			return true;
		top1 = driver
				.findElement(By
						.xpath("(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[2]"));
		lexileLink.click();
		top2 = driver
				.findElement(By
						.xpath("(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[2]"));
		if (top1.getText().equals(top2.getText()))
			return true;
		top1 = driver
				.findElement(By
						.xpath("(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[3]"));
		wordcountLink.click();
		top2 = driver
				.findElement(By
						.xpath("(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[3]"));

		if (top1.getText().equals(top2.getText()))
			return true;
		dateLink.click();
		top1 = driver
				.findElement(By
						.xpath("(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[4]"));
		dateLink.click();
		top2 = driver
				.findElement(By
						.xpath("(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[4]"));

		if (top1.getText().equals(top2.getText()))
			return true;
		top1 = driver
				.findElement(By
						.xpath("(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[5]"));
		scoreLink.click();
		top2 = driver
				.findElement(By
						.xpath("(.//h3)[3]/parent::div/parent::div/parent::div/div[2]/div/div[2]/div/div[5]"));
		System.out.println("top1 = " + top1.getText() + "top2 = "
				+ top2.getText());
		if (top1.getText().equals(top2.getText()))
			return true;

		return true;
	}

	public boolean verifyprintparentletter() {
		printArrow.click();
		if (printParent.isEnabled()) {
			return true;
		}
		// String window1 = driver.getWindowHandle();
		printParent.click();
		// Set<String> window2 = driver.getWindowHandles();
		return false;
	}

	public boolean verifyprintstudenttest() {
		printArrow.click();
		System.out.println("Print arrow clicked");
		if (printTest.isEnabled()) {
			return true;
		}
		// String window1 = driver.getWindowHandle();
		printParent.click();
		// Set<String> window2 = driver.getWindowHandles();
		return false;
	}

	public boolean verifyprintreportcard() {
		printArrow.click();
		if (printReportCard.isEnabled()) {
			return true;
		}
		// String window1 = driver.getWindowHandle();
		printParent.click();
		// Set<String> window2 = driver.getWindowHandles();
		return false;
	}

	public boolean verifyreportheader() {
		if (pgHeader.getText().startsWith("Reports for"))
			return true;
		else
			return false;
	}
	public void clickeditpts() {
		// Click on edit activity button
		editLink1.click();
		reportLog("Clicked on edit link");
	}

	public void TeacherEditedPoints(String point) throws InterruptedException {
		TeacherAddedPoint = Integer.parseInt(teacherptsText.getText());
		int ActualPoint;
		reportLog("Teacher Added points before edit " + TeacherAddedPoint);
		try {
			ActualPoint = Integer
					.parseInt(driver
							.findElement(
									By.xpath(".//*[@ng-repeat='quiz in quizzes | orderByUndefinedLast:predicate:reverse'][1]//input"))
							.getAttribute("value"));
		} catch (Exception e){
			ActualPoint =0;
		}
		
		reportLog("Actual point of the books " + ActualPoint);
		// After edit
		int AfterEditPoint = (ActualPoint + Integer.parseInt(point));
		driver.findElement(
				By.xpath(".//*[@ng-repeat='quiz in quizzes | orderByUndefinedLast:predicate:reverse'][1]//input"))
				.clear();
		driver.findElement(
				By.xpath(".//*[@ng-repeat='quiz in quizzes | orderByUndefinedLast:predicate:reverse'][1]//input"))
				.sendKeys(Integer.toString(AfterEditPoint));
		reportLog("Points after editing the points of the books " + AfterEditPoint);
		editLink1.click();
	}

	public boolean MessagePopup(String message) {
		boolean flag = false;
		if (PopupMessage.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public boolean verifyteacheraddedpts() {
		boolean flag = false;
		TeacherAddedPoint = getTeacherAddedPoint();
		for (int i = 0; i <= 60; i++) {
			int TeacherAfterEditPoint = Integer.parseInt(teacherptsText
					.getText());
			if (TeacherAfterEditPoint == (TeacherAddedPoint + 2)) {
				flag = true;
				reportLog("Points after points are edited "+TeacherAfterEditPoint);
				break;
			}
			lazyWait(1);
		}		
		return flag;
	}
	
	private static int TeacherAddedPoint;

	public int getTeacherAddedPoint() {
		return this.TeacherAddedPoint;
	}

	public void setTeacherAddedPoint(int TeacherAddedPoint) {
		ReportsPg.TeacherAddedPoint = TeacherAddedPoint;
	}
	
	private static int QuizPointsEarned;

	public int getQuizPointsEarned() {
		return this.QuizPointsEarned;
	}

	public void setQuizPointsEarned(int QuizPointsEarned) {
		ReportsPg.QuizPointsEarned = QuizPointsEarned;
	}
	public void CollectPointData(){
		setQuizPointsEarned(Integer.parseInt(teacherptsText.getText()));
		setTeacherAddedPoint(Integer.parseInt(ptsearnedText.getText()));
	}

	public boolean PointsDataValidation(){
		boolean flag=false;
		int TeacherAddedPoint =getTeacherAddedPoint();
		int QuizPointsEarned = getQuizPointsEarned();
		int ptsearnedTexts = Integer.parseInt(ptsearnedText.getText());
		if(ptsearnedTexts==(TeacherAddedPoint +QuizPointsEarned)){
			flag=true;
		}
		return flag;
	}
	/*
	 * sa_titleText sa_authorText sa_lexileText; sa_wordcountText; sa_dateText;
	 * sa_scoreText; sa_pointsText; sa_editLink; sa_quizLink;
	 */

	public boolean verifyquizrow() {
		this.sync(sa_titleText);
		System.out.println("sa_titleText");
		if (!sa_titleText.getText().matches(".*")) {
			System.out.println("sa_titleText");
			return true;
		}
		if (!sa_authorText.getText().matches(".*")) {
			System.out.println("sa_authorText");
			return true;
		}
		System.out.println(sa_lexileText.getText());
		if (!sa_lexileText.getText().matches(".*")) {
			System.out.println("sa_lexileText");
			return true;
		}
		System.out.println(sa_wordcountText.getText());
		if (!sa_wordcountText.getText().matches("\\d*")) {
			System.out.println("sa_wordcountText");
			return true;
		}
		System.out.println(sa_dateText.getText());
		if (!sa_dateText.getText().matches("\\d{2}\\s\\w{3}\\s\\d{4}")) {
			System.out.println("sa_dateText");
			System.out.println("Date not matched");
			return true;
		}
		if (!sa_scoreText.getText().matches("\\d/10")) {
			System.out.println("sa_scoreText");
			return true;
		}
		return true;
	}

	public String getPageHeader() {
		System.out.println("Reports page getPageHeader");
		String header = this.getText(pgHeader);
		this.reportLog("Get Page Header: " + header);
		return header;
	}

	public String getReportModalDescriptionText() {
		String descText = "NULL";
		String xpath = "//div[contains(@class, 'modal-body')]//div/p";
		WebElement reportModalHeader = this.getElement(By.xpath(xpath));
		if (reportModalHeader != null) {
			descText = reportModalHeader.getText();
			this.reportLog("Report Popup header: " + descText);
		}
		return descText;
	}

	public String getReportModalFooterText() {
		String fotrText = "NULL";
		String xpath = "//div[contains(@class, 'modal-footer')]//p";
		WebElement reportModalHeader = this.getElement(By.xpath(xpath));
		if (reportModalHeader != null) {
			fotrText = reportModalHeader.getText();
			this.reportLog("Report Popup header: " + fotrText);
		}
		return fotrText;
	}

	public boolean isPieReportsLegendDisplayed(int lgndNo) {
		String xpath = "//div[@id='report-container']//reading-prof-summary-pie-schools/*[name()='svg']/*[name()='g']/*[name()='g']["
				+ lgndNo + "]";
		WebElement legendCategory = this.getElement(By.xpath(xpath));
		if (legendCategory != null)
			return false;
		return true;
	}

	public boolean isBarOneReportsLegendDisplayed(int lgndNo) {
		String xpath = "//div[@id='report-container']//reading-prof-summary-graph-schools/*[name()='svg']/*[name()='g']/*[name()='g']["
				+ lgndNo + "]";
		WebElement legendCategory = this.getElement(By.xpath(xpath));
		if (legendCategory != null)
			return false;
		return true;
	}

	public boolean isBarTwoReportsLegendDisplayed(int lgndNo) {
		String xpath = "//div[@id='report-container']//reading-prof-detail-stack-schools/*[name()='svg']/*[name()='g']/*[name()='g']["
				+ lgndNo + "]";
		WebElement legendCategory = this.getElement(By.xpath(xpath));
		if (legendCategory != null)
			return false;
		return true;
	}

	public boolean isBarThreeReportsLegendDisplayed(int lgndNo) {
		String xpath = "//div[@id='report-container']//reading-prof-detail-graph-schools/*[name()='svg']/*[name()='g']/*[name()='g']["
				+ lgndNo + "]";
		WebElement legendCategory = this.getElement(By.xpath(xpath));
		if (legendCategory != null)
			return false;
		return true;
	}

	public boolean isReportHeaderButtonsDisplayed(String headerbtnName) {
		String xpath = "//div[contains(@class, 'modal-header')]//i[contains(@class, '"
				+ headerbtnName + "')]";
		WebElement ReportTextElement = this.getElement(By.xpath(xpath));

		if (ReportTextElement != null)
			return true;

		return false;
	}

	public boolean isReportCatsDisplayed(String repCatsName) {
		String xpath = "//div[contains(@class, 'modal-body')]/div[3]//i[contains(@class, '"
				+ repCatsName + "')]";
		WebElement ReportTextElement = this.getElement(By.xpath(xpath));

		if (ReportTextElement != null)
			return true;

		return false;
	}

	public void clickSchoolYearsDropDown() {
		String xpath = "//div[contains(@class, 'modal-body')]/div[3]//i[contains(@class, 'btn-dwnarrow')]";
		WebElement schoolYearDrpDwn = this.getElement(By.xpath(xpath));
		this.click(schoolYearDrpDwn);
		reportLog("Clicked on the school year dropdown calender year");
	}

	public List<String> getSchoolYearsList() {
		List<String> schlYearsList = new ArrayList<String>();
		String xpath = "//div[contains(@class, 'modal-body')]/div[4]//ul[contains(@class, 'dropdown-menu')]";
		List<WebElement> yearsList = this.getElements(By.xpath(xpath));
		for (WebElement e : yearsList) {
			String years = this.getText(e);
			this.reportLog("School years displayed: " + years);
			schlYearsList.add(years);
		}
		return schlYearsList;
	}

	public boolean isReportGroupDisplayed(String reportName) {
		String xpath = "//div[contains(@class, 'modal-body')]/div[3]//i[contains(@class, '"
				+ reportName + "')]";
		WebElement ReportTextElement = this.getElement(By.xpath(xpath));
		
		driver.findElement(By.xpath(xpath)).click();
		
		if (ReportTextElement != null)
			return true;

		return false;
	}

	public boolean isIncompleteTestPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTooltipDisplayed() {
		// TODO Auto-generated method stub
		String xpath = "sas";
		WebElement ReportTextElement = this.getElement(By.xpath(xpath));

		if (ReportTextElement != null)
			return true;

		return false;
	}

	public void clickToolTip() {
		// TODO Auto-generated method stub

	}

	public boolean isClassQuizzActivityReportDisplayed() {

		String xpath = "sas";
		WebElement ReportTextElement = this.getElement(By.xpath(xpath));

		if (ReportTextElement != null)
			return true;

		return false;
	}

	public String ReportCertificate() {
		String Certificate = ReportStudentAwardCertificate.getText()
				.toLowerCase();
		System.out
		.println("Student has scored " + Certificate + " Certificate");
		String CertificateStudentname = Certificate
				+ "'"
				+ StudentNameLitpro.getText().replaceAll("Reports for ", "")
				.replaceAll(":", "");
		return CertificateStudentname;
	}

	public void ReportStudentCertificate() {
		PrintOptions.click();
		lazyWait(1);
		PrintCertificate.click();
		lazyWait(1);
	}
	
	public void ClassCertificate() {
		OptionClass.click();
		lazyWait(2);
		if (driver.findElement(By.xpath("//*[@id='main-content']/div[2]/div[1]/div[3]/ul/li[1]")).isEnabled()) {
			driver.findElement(By.xpath("//*[@id='main-content']/div[2]/div[1]/div[3]/ul/li[1]")).click();
		}
	}
	
	public HashMap<String, String> Studentdata(String classname){
		String Stduentname;
		String Stduentcertificate;
		HashMap<String, String> hmap = new HashMap<String, String>();
		lazyWait(2);
		switchToNewWindow();
		String[] a = Studentclass(classname).toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
		for(int j=0; j<a.length; j++){
			String x=a[j].trim();
			Stduentname = (util.getValue(x.trim()+"_Name"));
			Stduentcertificate = (util.getValue(x.trim()+"_CertificateLevel"));
			hmap.put(Stduentname, Stduentcertificate);
		}
		return hmap;
	}

	public boolean ClassCertificatevalidation(String classname){
		String Studentname;
		int count=0;
		boolean result=false;
		String ClassNamecertificate;
		Map<String, String> actualHashMap = Studentdata(classname); 
		int i=driver.findElements(By.xpath("html/body/div/div/span")).size();
		for(int j=1; j<=i; j++){
			String xpath = "html/body/div["+j+"]/div/span";
			String xpath1 = "html/body/div["+j+"]/img[2]";
			Studentname = driver.findElement(By.xpath(xpath)).getText();
			ClassNamecertificate = driver.findElement(By.xpath(xpath1)).getAttribute("src");
			reportLog("Student :"+ Studentname+" has certificate : "+actualHashMap.get(Studentname));
			if(ClassNamecertificate.contains((actualHashMap.get(Studentname)).toLowerCase())){
				count=count+1;
			}
		}
		if(count==i){
			result=true;
		}
		return result;
	}
	public boolean VerifyPrintStudentCertificate() throws AWTException {
		String CertificateStudentname = ReportCertificate();
		switchToNewWindow();

		String[] CertificateStudentname1 = CertificateStudentname.split("'");

		int condition = 1;

		if ((PrintMyresultAwardCertificate.getAttribute("src"))
				.contains(CertificateStudentname1[0])
				&& PrintCertificateStudentName.getText().contains(
						CertificateStudentname1[1])) {
			System.out.println("Student Blue Certificate got printed");
			System.out.println("Student name "
					+ PrintCertificateStudentName.getText()
					+ " is printed on the certificate");
			condition = 0;
		} else if ((PrintMyresultAwardCertificate.getAttribute("src"))
				.contains(CertificateStudentname1[0])
				&& PrintCertificateStudentName.getText().contains(
						CertificateStudentname1[1])) {
			System.out.println("Student Red Certificate got printed");
			System.out.println("Student name "
					+ PrintCertificateStudentName.getText()
					+ " is printed on the certificate");
			condition = 0;
		} else if ((PrintMyresultAwardCertificate.getAttribute("src"))
				.contains(CertificateStudentname1[0])
				&& PrintCertificateStudentName.getText().contains(
						CertificateStudentname1[1])) {
			System.out.println("Student Bronze Certificate got printed");
			System.out.println("Student name "
					+ PrintCertificateStudentName.getText()
					+ " is printed on the certificate");
			condition = 0;
		} else if ((PrintMyresultAwardCertificate.getAttribute("src"))
				.contains(CertificateStudentname1[0])
				&& PrintCertificateStudentName.getText().contains(
						CertificateStudentname1[1])) {
			System.out.println("Student Silver Certificate got printed");
			System.out.println("Student name "
					+ PrintCertificateStudentName.getText()
					+ " is printed on the certificate");
			condition = 0;
		} else if ((PrintMyresultAwardCertificate.getAttribute("src"))
				.contains(CertificateStudentname1[0])
				&& PrintCertificateStudentName.getText().contains(
						CertificateStudentname1[1])) {
			System.out.println("Student Gold Certificate got printed");
			System.out.println("Student name "
					+ PrintCertificateStudentName.getText()
					+ " is printed on the certificate");
			condition = 0;
		} else {
			condition = 1;
		}

		switchtoWindow(2);

		if (condition == 1) {
			return false;
		} else {
			return true;
		}
	}

	public WebElement getClassName(String classname){
		String xpath = String.format("//a[text()='%s']", classname);
		WebElement ele = getElement(By.xpath(xpath),5);
		return ele;
	}
	public void clickOnClassName(String classname){
		click(getClassName(classname));
	}

	public WebElement enterStudentDataModal(){
		return studentdatamodal;
	}
    
	public void clickStudentDataButton(){
		WaitUtils.waitForDisplayed(studentdatabutton);
		click(studentdatabutton);
	}


	public void changeTeacherJudgement(String studentname){	 
		String xpath = String.format("//a[text()='%s']", studentname);
		List<WebElement> RadioButtons = getElements(By.xpath(xpath));
		
			boolean bValue = false;
			bValue = RadioButtons.get(0).isSelected();
			if(bValue = true){
				RadioButtons.get(1).click();
			}else{
				RadioButtons.get(0).click();
			}
		
	}
	
	public void clickSave(){
		WaitUtils.waitForDisplayed(savebuttonmodal);
		click(savebuttonmodal);
	}
	public void selectClass(String classname){
		String classNameXpath = String.format("", classname);
		WebElement className = getElement(By.xpath(classNameXpath));
		click(className);
		lazyWait(3);
	}
	public void selectStudentFromClass(String studentname,String classname){
		String classNameXpath = String.format("", classname);
		WebElement className = getElement(By.xpath(classNameXpath));
		click(className);
		lazyWait(3);
		String studentNameXpath = String.format("", studentname);
		WebElement studentName = getElement(By.xpath(studentNameXpath));
		click(studentName);
		lazyWait(3);
	}
	
	public void verifyStudentOnTheModal(String studentname){
		String studentNameXpath = String.format("", studentname);
		WebElement studentName = getElement(By.xpath(studentNameXpath),2);
		Assert.assertEquals(studentname,studentName.getText());
		
	}
	
	public boolean VerifyschoolCalnderYer() throws IOException{
		boolean result = false;
		int schyer = driver.findElements(By.xpath("//div[contains(@class, 'modal-body')]/div[4]//ul[contains(@class, 'dropdown-menu')]//a")).size();
		for (int i=1; i<=schyer; i++){
			String xpaths = "(//div[contains(@class, 'modal-body')]/div[4]//ul[contains(@class, 'dropdown-menu')]//a)["+i+"]";
			String year = driver.findElement(By.xpath(xpaths)).getText();
			if(year.equalsIgnoreCase(YearExpected())){
				System.out.println(xpaths);
				reportLog("Clicked on the year dropdown "+driver.findElement(By.xpath(xpaths)).getText());
				driver.findElement(By.xpath(xpaths)).click();
				result = true;
			}
		}
		return result;
	}
	
	public String YearExpected() throws IOException{
		String[] yeardata = Years().toString().replaceAll("^\\[|\\]$", "").replaceAll("\"", "").split("\\*\\,");
		String year= null;
		for (int i = 0; i < yeardata.length; i++) {
			yeardata[i] = yeardata[i].trim();
			if(yeardata[i].contains("/")){
				yeardata[i]=yeardata[i].substring((yeardata[i].length() - 4));
				year = yeardata[i];
			}
		}
		String[] month = getbooktitlesb().split("1");
		String Schoolcalender = (year+"-"+month[0]+" to "+(Integer.parseInt(year)+1)+"-"+month[1]);
		return Schoolcalender;
	}
	
	public ArrayList Years() throws IOException {
		ArrayList Year = new ArrayList();
		String UploadedFilePath;
/*		String UploadedFilePath = new File(".").getCanonicalPath()
				+ "\\src\\test\\resources\\upload_files\\.csv";
*/
		//for Linux
		String os=System.getProperty("os.name");
		if(os.contains("Windows"))
		{ UploadedFilePath = new File(".").getCanonicalPath()
		+ "\\src\\test\\resources\\upload_files\\sriUpload.csv";
		}else{
		 UploadedFilePath="/home/linux-gui/.jenkins/workspace/Csrep/litpro-test/src/test/resources/upload_files/sriUpload.csv";
		}
		String b = getReadCSVFile(UploadedFilePath).toString();
		String[] CSVquiz = b.split("\\*\\,");
		for (int i = 1; i < CSVquiz.length; i++) {
			String[] quiz = CSVquiz[i].split("\\,");
			Year.add(quiz[2].trim()+"*");
			Year.add(quiz[3].trim()+"*");
		}
		return Year;
	}
	
	public ArrayList<String> getStudentNamesFromTheDataModal(){
		List<WebElement> studentNames = getElements(By.xpath(""));
		lazyWait(3);
		ArrayList<String> a = new ArrayList<String>();
		for(WebElement studentName: studentNames){
			String name = studentName.getText();
			a.add(name);
		}
		return a;
	}
	
		public String getRPScoreForAStudent(String studentName){
		String studentNameXpath = String.format("", studentName);
		WebElement rpScoreStudent = getElement(By.xpath(studentNameXpath),3);
		String rpscore = rpScoreStudent.getText();
		return rpscore;
	}
		
	public String getTeacherJudgementValue(String studentName){
			String xpath = String.format("WIP", studentName);
			
			List<WebElement> RadioButtons = getElements(By.xpath(xpath));
				if(RadioButtons.get(0).isSelected()){
					return "Below Grade Level";
			}else if(RadioButtons.get(1).isSelected()){
				return "At Grade Level";
		}else{
			return "Above Grade Level";
		}
	}
		
	public ArrayList<String> getStudentNamesSortedByLastName(){
		ArrayList<String> obtainedList = new ArrayList();
		List<WebElement> studentNames = getElements(By.xpath(""));
		for(WebElement studentName: studentNames){
			String studentname = studentName.getText();
			String[] parts = studentname.split("\\s+");
			String lastname = parts[1];
		 	obtainedList.add(lastname);
		}
		return obtainedList;
		}
	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	public void ClickviewReprotButton(String ReportsName){
		if(ReportsName.equalsIgnoreCase("Lexile Growth Report")){
			LexileGrowthReport_viewReprotButton.click();
		}
		else if(ReportsName.equalsIgnoreCase("Lexile Compared to Norm Report")){
			LexileComparedNormReport_viewReprotButton.click();
		}
		else if(ReportsName.equalsIgnoreCase("Student Lexile History Report")){
			StudentLexileHistoryReport_viewReprotButton.click();
		}
		else if(ReportsName.equalsIgnoreCase("Reading Proficiency Report")){
			ReadingProficiencyReport_viewReprotButton.click();
		}
		else if(ReportsName.equalsIgnoreCase("Expected Lexile Growth Report")){
			ExpectedLexileGrowthReport_viewReprotButton.click();
		}
		else if(ReportsName.equalsIgnoreCase("Book Comprehension Report")){
			BookComprehensionReport_viewReprotButton.click();
		}
		else if(ReportsName.equalsIgnoreCase("Quiz Pass Rate Report")){
			QuizPassRateReport_viewReprotButton.click();
		}
		else if(ReportsName.equalsIgnoreCase("Class Lexile History Report")){
			ClassLexileHistoryReport_viewReprotButton.click();
		}
		else if(ReportsName.equalsIgnoreCase("Class Reading Report Card")){
			ClassReadingReportCard_viewReprotButton.click();
		}
		else if(ReportsName.equalsIgnoreCase("Class Quiz Activity Report")){
			ClassQuizActivityReport_viewReprotButton.click();
		}
		reportLog("Clicked on " +ReportsName+" Button");
		lazyWait(5);
	}
	
	public String RerpotLabel(){
		return LexileGrowthReport_label.getText();
	}
	
	public ArrayList<String> ReportsData() {

		int rowCount = driver.findElements(	By.xpath("//*[@id='reports-table']/tbody/tr")).size();
		int colCount = driver.findElements(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td")).size();


		ArrayList<String> a = new ArrayList<String>();
		for (int i = 0; i < rowCount; i++) {

			String final_xpath = "//*[@id='reports-table']/tbody/tr["+ (i + 1) + "]";
			a.add(driver.findElement(By.xpath(final_xpath)).getText()+"*");


		}

		return a;
	}

	public String message(){
		String message;
		message = ExpectedLexileGrowthReport_message.getText();
		return message;
	}
	
	@FindBy(xpath = ".//div[contains(text(),' Expected growth data is only available for students in year/grade 3-10.')]")
	private WebElement ExpectedLexileGrowthReport_message;
	
	public ArrayList<String> ReadingProficiencyReportReportsData() {
		ArrayList<String> a = new ArrayList<String>();
		for (int i = 0; i < 2; i++) {
			String final_xpath = "//*[@id='reports-table']/tbody/tr["+ (i + 1) + "]";
			a.add(driver.findElement(By.xpath(final_xpath)).getText()+"*");
		}
		return a;
	}
	
	public String NormLexile( String grade){
		System.out.println("'''''''''''''''''''''''''3''''''''"+grade);
		HashMap<String, String> NormLexile = new HashMap<String, String>();
		NormLexile.put("1", "150");
		NormLexile.put("2", "475");
		NormLexile.put("3", "590");
		NormLexile.put("4", "700");
		NormLexile.put("5", "810");
		NormLexile.put("6", "880");
		NormLexile.put("7", "955");
		NormLexile.put("8", "1000");
		NormLexile.put("9", "1045");
		NormLexile.put("10", "1080");
		NormLexile.put("11", "1090");
		NormLexile.put("12", "1100");

		System.out.println(".............."+GradeConverstion(grade));
		String NormedLexile = NormLexile.get(GradeConverstion(grade));
		return NormedLexile;		
	}
	
	public String GradeConverstion(String Grade){
		HashMap<String, String> GradeStanderd = new HashMap<String, String>();
		GradeStanderd.put("Year 1", "1");
		GradeStanderd.put("Year 2", "2");
		GradeStanderd.put("Year 3", "3");
		GradeStanderd.put("Year 4", "4");
		GradeStanderd.put("Year 5", "5");
		GradeStanderd.put("Year 6", "6");
		GradeStanderd.put("Year 7", "7");
		GradeStanderd.put("Year 8", "8");
		GradeStanderd.put("Year 9", "9");
		GradeStanderd.put("Year 10", "10");
		GradeStanderd.put("Year 11", "11");
		GradeStanderd.put("Year 12", "12");
		GradeStanderd.put("Class 1", "1");
		GradeStanderd.put("Class 2", "2");
		GradeStanderd.put("Class 3", "3");
		GradeStanderd.put("Class 4", "4");
		GradeStanderd.put("Class 5", "5");
		GradeStanderd.put("Class 6", "6");
		GradeStanderd.put("Class 7", "7");
		GradeStanderd.put("Class 8", "8");
		GradeStanderd.put("Class 9", "9");
		GradeStanderd.put("Class 10", "10");
		GradeStanderd.put("Class 11", "11");
		GradeStanderd.put("Class 12", "12");
		GradeStanderd.put("Grade 1", "1");
		GradeStanderd.put("Grade 2", "2");
		GradeStanderd.put("Grade 3", "3");
		GradeStanderd.put("Grade 4", "4");
		GradeStanderd.put("Grade 5", "5");
		GradeStanderd.put("Grade 6", "6");
		GradeStanderd.put("Grade 7", "7");
		GradeStanderd.put("Grade 8", "8");
		GradeStanderd.put("Grade 9", "9");
		GradeStanderd.put("Grade 10", "10");
		GradeStanderd.put("Grade 11", "11");
		GradeStanderd.put("Grade 12", "12");
		GradeStanderd.put("Primary 1", "1");
		GradeStanderd.put("Primary 2", "2");
		GradeStanderd.put("Primary 3", "3");
		GradeStanderd.put("Primary 4", "4");
		GradeStanderd.put("Primary 5", "5");
		GradeStanderd.put("Primary 6", "6");
		GradeStanderd.put("Secondary 1/Junior Secondary 1", "7");
		GradeStanderd.put("Secondary 2/Junior Secondary 2", "8");
		GradeStanderd.put("Secondary 3/Junior Secondary 3", "9");
		GradeStanderd.put("Secondary 4/Junior Secondary 1", "10");
		GradeStanderd.put("Secondary 5/Junior Secondary 2", "11");
		GradeStanderd.put("Secondary 6/Junior Secondary 3", "12");
		String Tempgrade = GradeStanderd.get(Grade);

		return Tempgrade;
		
	}

	public void GradeDropDown(){
		String Grade=util.getValue("JoeMartina_Grade");
		reportLog("Searching for Grade "+Grade+" Report");
		gradeSelector.click();	
        String cl=Grade.replaceAll("[^0-9]", "");
		String Xpath = "//*[@id='grade-selector']//a/span[contains(text(), '"+cl+"')]";
		
		driver.findElement(By.xpath(Xpath)).click();
		reportLog("Viewing reports of grade "+Grade+" Report");
	}
	
	public void SchoolLevelReport(String SchoolName){
		String Xpath = ".//*[@id='sidebar']/div[3]/div/roster-tree/ul/li/a[contains(text(), '"+SchoolName+"')]";
		System.out.println(Xpath);
		driver.findElement(By.xpath(Xpath)).click();
	}
	
	public static HashMap<String, String> hmap = new HashMap<String, String>();
	
	util util1 = util.getInstance();
	public HashMap<String, String> getStudentNameLabel(String repName){
		searchSmartbar(repName);
		String[] student = FirstTestLexile();
		util.add(repName+"_Name", getStudentNameLabel().replace(":", ""));
		util.add(repName+"_Class", getclassLabel().replace("Class: ", ""));
		util.add(repName+"_Grade", getgradeLabel().replace("Grade: ", ""));
		util.add(repName+"_Lexile", getlexileText().replaceAll("BR", "-").replaceAll("L", ""));
		util.add(repName+"_LexileGrowth", getLexileGrowthText());
		util.add(repName+"_LastCompDate", getlastcompdateText());
		util.add(repName+"_ProficiencyBand", getproficiencyText());
		util.add(repName+"_CertificateLevel", getcertificateText());
		util.add(repName+"_QuizzesPassedAttempted", getquizpaText());
		util.add(repName+"_AverageQuizScore", getavgscoreText());
		util.add(repName+"_AverageLexileQuizzesPassed", getavglexquizpassedText());
		util.add(repName+"_WordsRead", getwordsreadText());
		util.add(repName+"_QuizPointsEarned", getptsearnedText());
		util.add(repName+"_TeacherAddedPoints", getteacherptsText());
		util.add(repName+"_HistoricalTestData", getHistoricalTestData());
		util.add(repName+"_FirstTestDate", student[0].replaceAll("BR", "-").replaceAll("L", ""));
		util.add(repName+"_FirstTestLexile", student[1].replaceAll("BR", "-").replaceAll("L", ""));
		util.add(repName+"_StudentActivity", getStudentActivity());
		return hmap;
	}
	
	public String getStudentActivity() {
		int i = driver.findElements(By.xpath("//*[@class='row-fluid quiz-cell ng-scope']")).size();
		ArrayList<String> Activity=new ArrayList<String>(); 
		for(int j=1; j<i+1; j++){
			String xpath = "//*[@class='row-fluid quiz-cell ng-scope']["+j+"]//div";
			if(driver.findElement(By.xpath("//*[@class='row-fluid quiz-cell ng-scope']["+j+"]//div[3]")).getText().isEmpty()){
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			}
			if(!driver.findElement(By.xpath("//*[@class='row-fluid quiz-cell ng-scope']["+j+"]//div[3]")).getText().isEmpty()){
				Activity.add(driver.findElement(By.xpath(xpath)).getText());
			}
		}
		String Activities =  Activity.toString();
		System.out.println("^^^^"+Activities);
		return Activities;
	}
	
	public String getHistoricalTestData(){
		StudentLexileHistoryReport_viewReprotButton.click();
		isReportGroupDisplayed("table");
		String TestDate;
		String Lexile;
		ArrayList al=new ArrayList();
		int rowCount = driver.findElements(	By.xpath("//*[@id='reports-table']/tbody/tr")).size();
		for (int i = 1; i <= rowCount; i++) {
			String final_xpath = "//*[@id='reports-table']/tbody/tr["+ (i) + "]";
			TestDate = (driver.findElement(By.xpath(final_xpath+"/th")).getText().trim());
			Lexile = (driver.findElement(By.xpath(final_xpath+"/td")).getText().trim());
			al.add(TestDate+","+Lexile);
		}
		reportModalCloseBtn.click();
		return al.toString();
	}
	
	public String[] FirstTestLexile(){
		StudentLexileHistoryReport_viewReprotButton.click();
		isReportGroupDisplayed("table");
		String[] data = new String[2];
		data[0]=StudentFirstDate.getText();
		data[1]=StudentFirstLexile.getText();
		reportModalCloseBtn.click();
		return data;
	}

	public String getCertificateLevelText() {
		reportLog("Collecting student Last complete date");
		return lastcompdateText.getText();
	}
	
	public ArrayList<String> Studentclass(String ClassName){
		Map<String, String> map = util.getMap();
		ArrayList<String> a = new ArrayList<String>();
		for ( Entry<String, String> key : map.entrySet()) {
			if(util.getValue(key.getKey()).equals(ClassName)){
				String Student = key.getKey();
				a.add(Student.replaceAll("_class", ""));
			}
		}
		return a;
	}
		
	public ArrayList<String> StudentGrade(String Grade){
		Map<String, String> map = util.getMap();
		ArrayList<String> a = new ArrayList<String>();
		for ( Entry<String, String> key : map.entrySet()) {
			if(util.getValue(key.getKey()).equals(Grade)){
				
				String Student = key.getKey();
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+Student);
				a.add(Student.replaceAll("_Grade", ""));
			}
		}
		return a;
	}
	
	public ArrayList<String> StudentSchool(){
		Map<String, String> map = util.getMap();
		ArrayList<String> a = new ArrayList<String>();
		for ( Entry<String, String> key : map.entrySet()) {
			if(key.getKey().contains("_Name")){
				String Student = key.getKey();
				a.add(Student.replaceAll("_Name", ""));
			}
		}
		return a;
	}
	
	public boolean Lexile_Growth_Report_class(String ClassName){
		String Rerpot_FirstTestDate;
		String Rerpot_FirstTestLexile;
		String Rerpot_MstRectTstDate;
		String Rerpot_MstRectTstLexile = null;
		String Report_StudentName = null;
		int Rerpot_Variance;
		int Expected_Variance;
		boolean result = false;
		int count = 0;
		
		
		System.out.println("'''''''''''"+Studentclass(ClassName).toString());
		String[] a = Studentclass(ClassName).toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
		for(int j=0; j<a.length; j++){
			String x=a[j].trim();
			int rowCount = driver.findElements(	By.xpath("//*[@id='reports-table']/tbody/tr")).size();
			int z=Integer.parseInt(util.getValue(x+"_Lexile"));
			int v=Integer.parseInt(util.getValue(x+"_FirstTestLexile"));
			
			System.out.println(z+"*******************"+v);
			
			Expected_Variance= Integer.parseInt(util.getValue(x+"_Lexile"))-(Integer.parseInt(util.getValue(x+"_FirstTestLexile")));
			
			for (int i = 1; i <= rowCount; i++) {
				String final_xpath = "//*[@id='reports-table']/tbody/tr["+ (i) + "]";
				Report_StudentName = (driver.findElement(By.xpath(final_xpath+"/th")).getText());
				Rerpot_FirstTestDate =(driver.findElement(By.xpath(final_xpath+"/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
				Rerpot_FirstTestLexile =(driver.findElement(By.xpath(final_xpath+"/td[2]")).getText().replaceAll("BR", "-").replaceAll("L", ""));
				Rerpot_MstRectTstDate =(driver.findElement(By.xpath(final_xpath+"/td[3]")).getText());
				Rerpot_MstRectTstLexile =(driver.findElement(By.xpath(final_xpath+"/td[4]")).getText().replaceAll("BR", "-").replaceAll("L", ""));
				Rerpot_Variance =Integer.parseInt(driver.findElement(By.xpath(final_xpath+"/td[5]")).getText());
				
				if(Report_StudentName.equalsIgnoreCase(util.getValue(x.trim()+"_Name")) 
						&& Rerpot_FirstTestDate.equalsIgnoreCase(util.getValue(x.trim()+"_FirstTestDate")) 
						&& Rerpot_FirstTestLexile.equalsIgnoreCase(util.getValue(x.trim()+"_FirstTestLexile")) 
						&& Rerpot_MstRectTstDate.equalsIgnoreCase(util.getValue(x.trim()+"_LastCompDate")) 
						&& Rerpot_MstRectTstLexile.equalsIgnoreCase(util.getValue(x.trim()+"_Lexile")) 
						&& (Expected_Variance==Rerpot_Variance)){
					reportLog("Student NAME at class level report "+Report_StudentName+" is matching with student level report "+util.getValue(x.trim()+"_Name")+" names");
					reportLog("Student FIRST TEST DATE at class level report "+Rerpot_FirstTestDate+" is matching with student level report "+util.getValue(x+"_FirstTestDate")+" Lexile");
					reportLog("Student FIRST TEST LEXILE at class level report "+Rerpot_FirstTestLexile+" is matching with student level report "+util.getValue(x+"_FirstTestLexile")+" Lexile");
					reportLog("Student LAST TEST DATE at class level report "+Rerpot_MstRectTstDate+" is matching with student level report "+util.getValue(x+"_LastCompDate")+" Lexile");
					reportLog("Student LAST TEST LEXILE at class level report "+Rerpot_MstRectTstLexile+" is matching with student level report "+util.getValue(x+"_Lexile")+" Lexile");
					reportLog("Student VARIANCE IN LEXILE at class level report "+Rerpot_Variance+" is matching with student level report "+Expected_Variance+" Lexile");
					count = count+1;
				}
			}
		}
		if(count==a.length){
			result = true;
		}
		return result;
	}
	
	public void Lexile_Growth_Report_grade(){
		String Grade=util.getValue("JoeMartina_Grade");
		int FirstTest = 0;
		int LastTest = 0;
		int Variance = 0;
		String Report_FirstTest = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_LastTest = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[2]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_Variance = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[3]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		
		System.out.println(Studentclass(Grade).toString());

		String[] a = Studentclass(Grade).toString().replaceAll("^\\[|\\]$|_Grade", "").split(",");
		for(int j=0; j<a.length; j++){
			String x=a[j].trim();
			
			FirstTest = FirstTest + Integer.parseInt(util.getValue(x+"_FirstTestLexile"));
			LastTest = LastTest+Integer.parseInt(util.getValue(x+"_Lexile"));
		}
		FirstTest = (FirstTest/a.length);
		LastTest = (LastTest/a.length);
		Variance = LastTest-FirstTest;
		
		Assert.assertEquals(Integer.parseInt(Report_FirstTest), FirstTest, "Student FIRST TEST at Grade level report "+Report_FirstTest+" is NOT matching with student level report "+FirstTest+" Lexile");
		Assert.assertEquals(Integer.parseInt(Rerpot_LastTest), LastTest, "Studen LAST TEST at Grade level report "+Rerpot_LastTest+" is NOT matching with student level report "+LastTest+" Lexile");					
		Assert.assertEquals(Integer.parseInt(Rerpot_Variance), Variance, "Student VARIANCE at Grade level report "+Rerpot_Variance+" is NOT matching with student level report "+Variance+" Lexile");					
		reportLog("Expected Student FIRST TEST at Grade level report "+Report_FirstTest+"--- Actual Lexile at student level report "+FirstTest+" Lexile");
		reportLog("Expected Student LAST TEST at Grade level report "+Rerpot_LastTest+"--- Actual student level report "+LastTest+" Lexile");
		reportLog("Expected VARIANCE at Grade level report "+Rerpot_Variance+"---- Actual student level report "+Variance+" Lexile");
	}
	
	public void Lexile_Growth_Report_school(){

		int FirstTest = 0;
		int LastTest = 0;
		int Variance = 0;
		int length = 0;
		String x;
		String Report_FirstTest = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_LastTest = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[2]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_Variance = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[3]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		
		Map<String, String> map = util.getMap();
		for ( Entry<String, String> key : map.entrySet()) {
			if(key.getKey().contains("_Name"))
			{
			 x= key.getKey().replaceAll("_Name", "");


		
			FirstTest = FirstTest + Integer.parseInt(util.getValue(x+"_FirstTestLexile"));
			LastTest = LastTest+Integer.parseInt(util.getValue(x+"_Lexile"));
			length = length+1;
			}
		}
		
		FirstTest = (FirstTest/length);
		LastTest = (LastTest/length);
		Variance = LastTest-FirstTest;
		



		Assert.assertEquals(Integer.parseInt(Report_FirstTest), FirstTest, "Student FIRST TEST at Grade level report "+Report_FirstTest+" is NOT matching with student level report "+FirstTest+" Lexile");
		Assert.assertEquals(Integer.parseInt(Rerpot_LastTest), LastTest, "Studen LAST TEST at Grade level report "+Rerpot_LastTest+" is NOT matching with student level report "+LastTest+" Lexile");					
		Assert.assertEquals(Integer.parseInt(Rerpot_Variance), Variance, "Student VARIANCE at Grade level report "+Rerpot_Variance+" is NOT matching with student level report "+Variance+" Lexile");					
	}

	public void Historical_Lexile_Growth_Report_school() throws IOException{
		String[] lexie = lexile().toString().replaceAll("[^a-zA-Z0-9]+","").split("c");
		
		int Studentno = lexie.length;
		
		int i=Integer.parseInt(lexie[0])+Integer.parseInt(lexie[1]);
		
		int FirstTest = (i/Studentno);
		int LastTest = (i/Studentno);
		int Variance = FirstTest-LastTest;
		String Report_FirstTest = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_LastTest = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[2]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_Variance = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[3]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		
		System.out.println("############1###############"+i);
		System.out.println("############2###############"+FirstTest);
		System.out.println("############3###############"+Studentno);
		Assert.assertEquals(Integer.parseInt(Report_FirstTest), FirstTest, "Student FIRST TEST at Grade level report "+Report_FirstTest+" is NOT matching with student level report "+FirstTest+" Lexile");
		Assert.assertEquals(Integer.parseInt(Rerpot_LastTest), LastTest, "Studen LAST TEST at Grade level report "+Rerpot_LastTest+" is NOT matching with student level report "+LastTest+" Lexile");					
		Assert.assertEquals(Integer.parseInt(Rerpot_Variance), Variance, "Student VARIANCE at Grade level report "+Rerpot_Variance+" is NOT matching with student level report "+Variance+" Lexile");					
	}
	
	public ArrayList lexile() throws IOException {
		ArrayList Year = new ArrayList();
		/*String UploadedFilePath = new File(".").getCanonicalPath()
				+ "\\src\\test\\resources\\upload_files\\sriUpload.csv";*/
		String UploadedFilePath="/home/linux-gui/.jenkins/workspace/Csrep/litpro-test/src/test/resources/upload_files/sriUpload.csv";
		String b = getReadCSVFile(UploadedFilePath).toString();
		String[] CSVquiz = b.split("\\*\\,");
		for (int i = 1; i < CSVquiz.length; i++) {
			String[] quiz = CSVquiz[i].split("\\,");
			Year.add(quiz[3].trim()+"c");
		}
		return Year;
	}
	
	public boolean Lexile_Compared_Norm_Report_class(String ClassName){
		String Report_StudentName = null;
		String Rerpot_Lexile;
		String Rerpot_NormedLexile;
		String Rerpot_Variance;
		int StudentLexileNormed;
		boolean result = false;
		int count = 0;
		int Expected_Variance;
		
		String[] a = Studentclass(ClassName).toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
		//for loop for Student data in Expected Lexile Growth Report class card
		
		for(int j=0; j<a.length; j++){
			String x=a[j].trim();
			StudentLexileNormed = (Integer.parseInt(NormLexile(util.getValue(x+"_Grade"))));
			Expected_Variance = (Integer.parseInt(util.getValue(x.trim()+"_Lexile"))-StudentLexileNormed);
			
			int rowCount = driver.findElements(	By.xpath("//*[@id='reports-table']/tbody/tr")).size();
			//for loop for Student data in Expected Lexile Growth Report class card
			for (int i = 1; i <= rowCount; i++) {
				String final_xpath = "//*[@id='reports-table']/tbody/tr["+ (i) + "]";
				Report_StudentName = (driver.findElement(By.xpath(final_xpath+"/th")).getText());
				Rerpot_Lexile =(driver.findElement(By.xpath(final_xpath+"/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
				Rerpot_NormedLexile =(driver.findElement(By.xpath(final_xpath+"/td[2]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
				Rerpot_Variance =(driver.findElement(By.xpath(final_xpath+"/td[3]")).getText().replaceAll("BR", "-").replaceAll("L|,", ""));
				
				if(!Rerpot_NormedLexile.contains("-")){
					if(Report_StudentName.equalsIgnoreCase(util.getValue(x.trim()+"_Name"))
							&& (Integer.parseInt(Rerpot_NormedLexile)==(StudentLexileNormed)) 
							&& Rerpot_Lexile.equalsIgnoreCase(util.getValue(x+"_Lexile"))
							&& Rerpot_Variance.equalsIgnoreCase(Integer.toString(Expected_Variance))){
						reportLog("Student NAME at class level report "+Report_StudentName+" is matching with student level report "+util.getValue(x.trim()+"_Name")+" names");
						reportLog("Student EXPECTED LEXILE GROWTH REPORT at class level report "+Rerpot_NormedLexile+" is matching with student level report "+StudentLexileNormed+" Lexile");
						reportLog("Student Lexile at class level report "+Rerpot_Lexile+" is matching with student level report "+util.getValue(x.trim()+"_Lexile")+" names");
						reportLog("Student EXPECTED LEXILE GROWTH REPORT at class level report "+Rerpot_Variance+" is matching with student level report "+Expected_Variance+" Lexile");
						count = count+1;
						break;
					}
				}
				if(Rerpot_NormedLexile.contains("-")){
					if(Report_StudentName.equalsIgnoreCase(util.getValue(x.trim()+"_Name")) 
							&& Rerpot_Lexile.equalsIgnoreCase(util.getValue(x+"_Lexile"))){
						reportLog("Student NAME at class level report "+Report_StudentName+" is matching with student level report "+util.getValue(x.trim()+"_Name")+" names");
						reportLog("Student Lexile at class level report "+Rerpot_Lexile+" is matching with student level report "+util.getValue(x.trim()+"_Lexile")+" names");
						count = count+1;
						break;
					}
				}
			}
		}
		if(count==a.length){
			result = true;
		}
		return result;
	}
	
	public void Lexile_Compared_Norm_Report_Grade(){
		String Grade=util.getValue("JoeMartina_Grade").replaceAll("Grade: ", "");
		System.out.println("---------------------------"+Grade);
		int Lexile = 0;
		int NormedLexile;
		int Variance = 0;
		String Report_CurentLexile = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_NormedLexile = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[2]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_Variance = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[3]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		
		
		String[] a = Studentclass(Grade).toString().replaceAll("^\\[|\\]$|_Grade", "").split(",");
		System.out.println("===="+StudentGrade(Grade).toString());
		for(int j=0; j<a.length; j++){
			String x=a[j].trim();
			System.out.println("++++++++++++++++++++++++++++++++"+x);
			Lexile = Lexile + Integer.parseInt(util.getValue(x+"_Lexile"));
		}
		Lexile = (Lexile/a.length);
		NormedLexile = Integer.parseInt(NormLexile(Grade));
		Variance = Lexile-NormedLexile;
		reportLog("Comapring the data of Lexile Compared Norm Report at Grade level with student data");
		
		reportLog("Student FIRST TEST at Grade level report ("+Report_CurentLexile+") is NOT matching with student level report ("+Lexile+") Lexile");
		reportLog("Student EXPECTED LEXILE GROWTH REPORT at Grade level report ("+Rerpot_NormedLexile+") is NOT matching with student level report ("+NormedLexile+") Lexile");
		reportLog("Student Variance: Expected EOY Lexile to Current Lexile at Grade level report ("+Rerpot_Variance+") is NOT matching with student level report ("+Variance+") Lexile");
		Assert.assertEquals(Integer.parseInt(Report_CurentLexile), Lexile, "Student FIRST TEST at Grade level report "+Report_CurentLexile+" is NOT matching with student level report "+Lexile+" Lexile");
		Assert.assertEquals(Integer.parseInt(Rerpot_NormedLexile), NormedLexile, "Student EXPECTED LEXILE GROWTH REPORT at Grade level report "+Rerpot_NormedLexile+" is NOT matching with student level report "+NormedLexile+" Lexile");
		Assert.assertEquals(Integer.parseInt(Rerpot_Variance), Variance, "Student Variance: Expected EOY Lexile to Current Lexile at Grade level report "+Rerpot_Variance+" is NOT matching with student level report "+Variance+" Lexile");
	}
	
	public void Lexile_Compared_Norm_Report_school(){
		int StudentLexileAVG = 0;
		int length = 0;
		String XPath;
		
		String Report_FirstTest = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		
		Map<String, String> map = util.getMap();
		for ( Entry<String, String> key : map.entrySet()) {
			if(key.getKey().contains("_Name"))
			{
			 XPath= key.getKey().replaceAll("_Name", "");
		
			StudentLexileAVG = StudentLexileAVG + Integer.parseInt(util.getValue(XPath+"_Lexile"));
			length = length+1;
			}
		}
		
		StudentLexileAVG = (StudentLexileAVG/length);
		
		Assert.assertEquals(Integer.parseInt(Report_FirstTest), StudentLexileAVG, "Student FIRST TEST at Grade level report "+Report_FirstTest+" is NOT matching with student level report "+StudentLexileAVG+" Lexile");
	}
	
	
	public void Historical_Lexile_Compared_Norm_Report_school() throws IOException{
		String[] lexie = lexile().toString().replaceAll("[^a-zA-Z0-9]+","").split("c");
		int Studentno = lexie.length;
		int i=Integer.parseInt(lexie[0])+Integer.parseInt(lexie[1]);
		
		int StudentLexileAVG = (i/Studentno);
		String Report_FirstTest = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		
		Assert.assertEquals(Integer.parseInt(Report_FirstTest), StudentLexileAVG, "Student FIRST TEST at Grade level report "+Report_FirstTest+" is NOT matching with student level report "+StudentLexileAVG+" Lexile");
	}
	
	public boolean Expected_Lexile_Growth_Report_class(String ClassName){
		String Report_StudentName = null;
		String Rerpot_Lexile;
		String Rerpot_ExpectedlexGrowth;
		String Rerpot_VarianceExpectedLexTOCurrentLex;
		String Rerpot_VarianceExpectedLexTONorm;

		String ExpectedLexGrowth;


		boolean result = false;
		int count = 0;
		int Expected_ExpectedLexileToCurrentLexile;
		int Expected_VarianceExpectedLexTOLexile;
		

		String[] a = Studentclass(ClassName).toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
		//for loop for Student data in Expected Lexile Growth Report class card
		
		for(int j=0; j<a.length; j++){
			String x=a[j].trim();
			ExpectedLexGrowth = getPropValues(Integer.parseInt(util.getValue(x+"_Grade")),Integer.parseInt(util.getValue(x+"_FirstTestLexile")));



			Expected_ExpectedLexileToCurrentLexile = (Integer.parseInt(util.getValue(x+"_Lexile"))-Integer.parseInt(ExpectedLexGrowth));
			Expected_VarianceExpectedLexTOLexile = (Integer.parseInt(ExpectedLexGrowth)-Integer.parseInt(NormLexile(util.getValue(x+"_Grade"))));
			
			int rowCount = driver.findElements(	By.xpath("//*[@id='reports-table']/tbody/tr")).size();


			//for loop for Student data in Expected Lexile Growth Report class card
			for (int i = 1; i <= rowCount; i++) {
				String final_xpath = "//*[@id='reports-table']/tbody/tr["+ (i) + "]";
				Report_StudentName = (driver.findElement(By.xpath(final_xpath+"/th")).getText());
				Rerpot_Lexile =(driver.findElement(By.xpath(final_xpath+"/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
				Rerpot_ExpectedlexGrowth =(driver.findElement(By.xpath(final_xpath+"/td[2]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
				Rerpot_VarianceExpectedLexTOCurrentLex =(driver.findElement(By.xpath(final_xpath+"/td[3]")).getText().replaceAll("BR", "-").replaceAll("L", ""));
				Rerpot_VarianceExpectedLexTONorm =(driver.findElement(By.xpath(final_xpath+"/td[4]")).getText());

				if(!Rerpot_VarianceExpectedLexTONorm.contains("-")){				
					if(Report_StudentName.equalsIgnoreCase(util.getValue(x.trim()+"_Name"))
						&& Rerpot_ExpectedlexGrowth.equalsIgnoreCase(ExpectedLexGrowth) 
						&& Rerpot_VarianceExpectedLexTOCurrentLex.equalsIgnoreCase(Integer.toString(Expected_ExpectedLexileToCurrentLexile))
						&& Rerpot_VarianceExpectedLexTONorm.equalsIgnoreCase(Integer.toString(Expected_VarianceExpectedLexTOLexile))

						&& Rerpot_Lexile.equalsIgnoreCase(util.getValue(x+"_Lexile"))){
						reportLog("Student NAME at class level report "+Report_StudentName+" is matching with student level report "+util.getValue(x.trim()+"_Name")+" names");
						reportLog("Student EXPECTED LEXILE GROWTH REPORT at class level report "+Rerpot_ExpectedlexGrowth+" is matching with student level report "+ExpectedLexGrowth+" Lexile");

						reportLog("Student Variance: Expected EOY Lexile to Current Lexile at class level report "+Rerpot_VarianceExpectedLexTOCurrentLex+" is matching with student level report "+Expected_ExpectedLexileToCurrentLexile+" Lexile");
	
						reportLog("Student Variance: Expected EOY Lexile to Norm at class level report "+Rerpot_VarianceExpectedLexTONorm+" is matching with student level report "+Expected_VarianceExpectedLexTOLexile+" Lexile");
						count = count+1;
	
						break;
					}	
				}	
				if(Rerpot_VarianceExpectedLexTONorm.contains("-")){				
					if(Report_StudentName.equalsIgnoreCase(util.getValue(x.trim()+"_Name"))
							&& Rerpot_ExpectedlexGrowth.equalsIgnoreCase(ExpectedLexGrowth) 
							&& Rerpot_VarianceExpectedLexTOCurrentLex.equalsIgnoreCase(Integer.toString(Expected_ExpectedLexileToCurrentLexile))
							&& Rerpot_Lexile.equalsIgnoreCase(util.getValue(x+"_Lexile"))){
						reportLog("Student NAME at class level report "+Report_StudentName+" is matching with student level report "+util.getValue(x.trim()+"_Name")+" names");
						reportLog("Student EXPECTED LEXILE GROWTH REPORT at class level report "+Rerpot_ExpectedlexGrowth+" is matching with student level report "+ExpectedLexGrowth+" Lexile");

						reportLog("Student Variance: Expected EOY Lexile to Current Lexile at class level report "+Rerpot_VarianceExpectedLexTOCurrentLex+" is matching with student level report "+Expected_ExpectedLexileToCurrentLexile+" Lexile");

						reportLog("Student Variance: Expected EOY Lexile to Norm at class level report "+Rerpot_VarianceExpectedLexTONorm+" is matching with student level report "+Expected_VarianceExpectedLexTOLexile+" Lexile");
						count = count+1;

						break;
					}	
				}	
			}
		}
		if(count==a.length){
			result = true;
		}
		return result;
	}
	
	/*public String[] StudentActivity(String ClassName){
		String ExpectedLexGrowth;
		System.out.println("===="+Studentclass(ClassName).toString());
		String[] a = Studentclass(ClassName).toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
		//for loop for Student data in Expected Lexile Growth Report class card
		
		for(int j=0; j<a.length; j++){
			String x=a[j].trim();
			ExpectedLexGrowth = util.getValue(x+"_StudentActivity");			
			System.out.println("------------------_StudentActivity-------------------------------"+ ExpectedLexGrowth);
			String[] b = ExpectedLexGrowth.replaceAll("^\\[|\\]$|_Class", "").split("Delete,");
			for(int i=0; i<a.length; i++){
				System.out.println("------------------Hello-------------------------------"+ b[i]);
				for(int k=0; k<a.length; k++){
					System.out.println("------------------Hello-------------------------------"+ b[i]);
				}
			}
		}
		return a;
	}*/
	
	public boolean Quiz_Pass_Rate_Report_class(String ClassName){
		String Report_StudentName = null;
		boolean result = false;
		String pass;
		String Attempts;
		String ReportPass;
		String ReportAttempts;
		int count = 0;
		
		String Quizpassrate;
		String[] a = Studentclass(ClassName).toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
		//for loop for Student data in Quiz Pass Rate Report class card
		for(int j=0; j<a.length; j++){
			String x=a[j].trim();
			Quizpassrate = util.getValue(x+"_QuizzesPassedAttempted");
			
			String[] b = Quizpassrate.split("/");
			pass=b[0];
			Attempts=b[1];
			
			int rowCount = driver.findElements(	By.xpath("//*[@id='reports-table']/tbody/tr")).size();

			//for loop for Student data in Quiz Pass Rate Report class card
			for (int i = 1; i <= rowCount; i++) {
				String final_xpath = "//*[@id='reports-table']/tbody/tr["+ (i) + "]";
				Report_StudentName = (driver.findElement(By.xpath(final_xpath+"/th")).getText());
				ReportPass =driver.findElement(By.xpath(final_xpath+"/td[2]")).getText();
				ReportAttempts =driver.findElement(By.xpath(final_xpath+"/td[1]")).getText();
				
				if(Report_StudentName.equalsIgnoreCase(util.getValue(x.trim()+"_Name"))
						&& ReportPass.equals(pass) && ReportAttempts.equals(Attempts)){
					reportLog("Student NAME at class level report "+Report_StudentName+" is matching with student level report "+util.getValue(x.trim()+"_Name")+" names");
					reportLog("Student Quiz Pass Rate Report at class level report "+ReportPass+" is matching with student level report "+pass+" PASS");
					reportLog("Student Quiz Pass Rate Report at class level report "+ReportAttempts+" is matching with student level report "+Attempts+" ATTEMPTS");
					count = count+1;
					break;
				}				
			}
		}
		
		if(count==a.length){
			result = true;
		}
		return result;	
	}
	
	public void Quiz_Pass_Rate_Report_Grade(){
		String Grade=util.getValue("JoeMartina_Grade");
		int pass = 0;
		int Attempts = 0;
		String Quizpassrate;
		int Report_GradeAttempt = Integer.parseInt(driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td[1]")).getText());
		int Rerpot_GradePass = Integer.parseInt(driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[2]/td[1]")).getText());
		
		String[] a = Studentclass(Grade).toString().replaceAll("^\\[|\\]$|_Grade", "").split(",");
		for(int j=0; j<a.length; j++){
			String x=a[j].trim();
			Quizpassrate = util.getValue(x+"_QuizzesPassedAttempted");
			
			String[] b = Quizpassrate.split("/");
			Attempts=Attempts+Integer.parseInt(b[1]);
			pass = pass+ Integer.parseInt(b[0]);
		}
		reportLog("---1Student Pass Quiz at Grade level report"+Rerpot_GradePass+"is NOT matching with student level report"+pass+"Quiz pass");
		reportLog("---2Student Quiz Attempt at Grade level report"+Report_GradeAttempt+"is NOT matching with student level report"+Attempts+"Quiz attempt");
		Assert.assertEquals(Rerpot_GradePass, pass, "Student Pass Quiz at Grade level report"+Rerpot_GradePass+"is NOT matching with student level report"+pass+"Quiz pass");
		Assert.assertEquals(Report_GradeAttempt, Attempts, "Student Quiz Attempt at Grade level report"+Report_GradeAttempt+"is NOT matching with student level report"+Attempts+"Quiz attempt");					
	}
	
	public void Quiz_Pass_Rate_Report_school(){
		int pass = 0;
		int Attempts = 0;
		String x;
		String Quizpassrate;
		int Report_GradeAttempt = Integer.parseInt(driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td[1]")).getText());
		int Rerpot_GradePass = Integer.parseInt(driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[2]/td[1]")).getText());
	
		
		Map<String, String> map = util.getMap();
		for (Entry<String, String> key : map.entrySet()) {
			if (key.getKey().contains("_Name")) {
				x= key.getKey().replaceAll("_Name", "");
				Quizpassrate = util.getValue(x + "_QuizzesPassedAttempted");
				String[] b = Quizpassrate.split("/");
				Attempts = Attempts + Integer.parseInt(b[1]);
				pass = pass + Integer.parseInt(b[0]);
			}
		}
		Assert.assertEquals(Rerpot_GradePass, pass, "Student Pass Quiz at Grade level report"+Rerpot_GradePass+"is NOT matching with student level report"+pass+"Quiz pass");
		Assert.assertEquals(Report_GradeAttempt, Attempts, "Student Quiz Attempt at Grade level report"+Report_GradeAttempt+"is NOT matching with student level report"+Attempts+"Quiz attempt");					
	}

	public boolean Class_Quiz_Activity_Report_class(String ClassName){
		boolean result = false;

		reportLog("processing the data Collected from class level reports");
		//Collecting date of student activity data from class level reports and processing it
		ArrayList<String> StudentActReport = new ArrayList<String>();
		int num1 = driver.findElements(By.xpath(".//*[@id='reports-table']/tbody/tr")).size();
		for(int j=1; j<=num1; j++){
			StudentActReport.add(driver.findElement(By.xpath(".//*[@id='reports-table']/tbody/tr["+j+"]/th")).getText().trim());
			StudentActReport.add(driver.findElement(By.xpath(".//*[@id='reports-table']/tbody/tr["+j+"]/td[1]")).getText().trim());
			StudentActReport.add(driver.findElement(By.xpath(".//*[@id='reports-table']/tbody/tr["+j+"]/td[4]")).getText().trim());
			StudentActReport.add(driver.findElement(By.xpath(".//*[@id='reports-table']/tbody/tr["+j+"]/td[5]")).getText().trim());
			StudentActReport.add(driver.findElement(By.xpath(".//*[@id='reports-table']/tbody/tr["+j+"]/td[3]")).getText().trim());
			StudentActReport.add(driver.findElement(By.xpath(".//*[@id='reports-table']/tbody/tr["+j+"]/td[2]")).getText().trim());
		}
		
		
		String StudentAct = StudentActivity(ClassName).toString();
		String StudentClassReprot = StudentActReport.toString();
		
		reportLog("Comapring the data collected from both class and student level reports");
		reportLog("StudentClassReprot "+StudentClassReprot);
		reportLog("StudentClassReprot "+StudentClassReprot);
		if(StudentClassReprot.contains(StudentClassReprot)){
			result=true;
		}
		return result;
	}

	public ArrayList<String> StudentActivity(String ClassName) {
		reportLog("processing the data Collected from reading report cards Student Activity");
		//Collecting date of student from the reading report cards and processing it
		String QuizActivity;
		ArrayList<String> StudentAct = new ArrayList<String>();

		String[] a = Studentclass(ClassName).toString()
				.replaceAll("^\\[|\\]$|_Class", "").split(",");
		// for loop for Student data in Quiz Pass Rate Report class card
		for (int j = 0; j < a.length; j++) {
			String x = a[j].trim();
			QuizActivity = util.getValue(x + "_StudentActivity");
			String[] b = QuizActivity.split("Delete,");
			for (int i = 0; i < b.length; i++) {
				b[i] = b[i].replaceAll("[\\[\\]]", "");
				String[] z = b[i].split("\\r|\\n");
				for (int y = 0; y < z.length; y++) {
					if (y == 0 || y == 2 || y == 3 || y == 4 || y == 5) {
						if (y == 5) {
							StudentAct.add(percentage(z[y]));
						}
						if (y == 0) {
							StudentAct.add(util.getValue(x + "_Name") + ", "+ (z[y].trim()));
						}
						if (y == 2 || y == 3 || y == 4 || y == 6) {
							StudentAct.add(z[y]);
						}
					}
				}
			}
		}
		return StudentAct;
	}
	
		
	public String percentage(String Num){
		String [] Num1=Num.split("/");
		int r=((Integer.parseInt(Num1[0])*100)/(Integer.parseInt(Num1[1])));
		String percentage=(r+"%");
		return percentage;
		
	}	
	public void Expected_Lexile_Growth_Report_Grade(){
		String Grade=util.getValue("JoeMartina_Grade");
		int FirstTest = 0;
		int ExpectedLexGrowth = 0;
		int Variance = 0;
		String Report_CurentLexile = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_ExpectedEndLexile = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[2]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_VarianceExpectedEOYLexileCurrent = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[3]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		
		System.out.println("---"+Studentclass(Grade).toString());
		
		String[] a = Studentclass(Grade).toString().replaceAll("^\\[|\\]$|_Grade", "").split(",");
		for(int j=0; j<a.length; j++){
			String x=a[j].trim();
			
			FirstTest = FirstTest + Integer.parseInt(util.getValue(x+"_Lexile"));
			
			ExpectedLexGrowth = ExpectedLexGrowth +Integer.parseInt(getPropValuesGrade(util.getValue(x+"_Grade"),Integer.parseInt(util.getValue(x+"_FirstTestLexile")))); 
		}
		FirstTest = (FirstTest/a.length);
		ExpectedLexGrowth = (ExpectedLexGrowth/a.length);
		Variance = FirstTest-ExpectedLexGrowth;
		
		reportLog("Student EXPECTED FIRST TEST at Grade level report "+Report_CurentLexile+" ACTUAL student level report "+FirstTest+" Lexile");
		reportLog("Student EXPECTED LEXILE GROWTH REPORT at Grade level report "+Rerpot_ExpectedEndLexile+" ACTUAL student level report "+ExpectedLexGrowth+" Lexile");
		reportLog("Student EXPECTED Variance: Expected EOY Lexile to Current Lexile at Grade level report "+Rerpot_VarianceExpectedEOYLexileCurrent+" ACTUAL student level report "+Variance+" Lexile");

		Assert.assertEquals(Integer.parseInt(Report_CurentLexile), FirstTest, "Student FIRST TEST at Grade level report "+Report_CurentLexile+" is NOT matching with student level report "+FirstTest+" Lexile");
		Assert.assertEquals(Integer.parseInt(Rerpot_ExpectedEndLexile), ExpectedLexGrowth, "Student EXPECTED LEXILE GROWTH REPORT at Grade level report "+Rerpot_ExpectedEndLexile+" is NOT matching with student level report "+ExpectedLexGrowth+" Lexile");					
		Assert.assertEquals(Integer.parseInt(Rerpot_VarianceExpectedEOYLexileCurrent), Variance, "Student Variance: Expected EOY Lexile to Current Lexile at Grade level report "+Rerpot_VarianceExpectedEOYLexileCurrent+" is NOT matching with student level report "+Variance+" Lexile");					
	}
	
	public void Expected_Lexile_Growth_Report_school(){
		int StudentLexile = 0;
		int ExpectedLexGrowth = 0;
		int Variance = 0;
		int length = 0;
		String x;
		String Report_CurentLexile = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_ExpectedEndLexile = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[2]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_VarianceExpectedEOYLexileCurrent = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[3]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		
		Map<String, String> map = util.getMap();
		for ( Entry<String, String> key : map.entrySet()) {
			if(key.getKey().contains("_Name"))
			{
				x= key.getKey().replaceAll("_Name", "");
				StudentLexile = StudentLexile + Integer.parseInt(util.getValue(x+"_Lexile"));
				ExpectedLexGrowth = ExpectedLexGrowth +Integer.parseInt(getPropValues(Integer.parseInt(util.getValue(x+"_Grade")),Integer.parseInt(util.getValue(x+"_FirstTestLexile")))); 
				length = length+1;
			}
		}
		
		StudentLexile = (StudentLexile/length);
		ExpectedLexGrowth = (ExpectedLexGrowth/length);
		Variance = StudentLexile-ExpectedLexGrowth;
		
		Assert.assertEquals(Integer.parseInt(Report_CurentLexile), StudentLexile, "Student FIRST TEST at School level report "+Report_CurentLexile+" is NOT matching with student level report "+StudentLexile+" Lexile");
		Assert.assertEquals(Integer.parseInt(Rerpot_ExpectedEndLexile), ExpectedLexGrowth, "Studen EXPECTED LEXILE GROWTH REPORT at School level report "+Rerpot_ExpectedEndLexile+" is NOT matching with student level report "+ExpectedLexGrowth+" Lexile");					
		Assert.assertEquals(Integer.parseInt(Rerpot_VarianceExpectedEOYLexileCurrent), Variance, "Student Variance: Expected EOY Lexile to Current Lexile at School level report "+Rerpot_VarianceExpectedEOYLexileCurrent+" is NOT matching with student level report "+Variance+" Lexile");					
	}
	
	public void Historical_Expected_Lexile_Growth_Report_school() throws IOException{
		int ExpectedLexGrowth = 0;
		int Variance = 0;
		int length = 0;
		String x;
		String Report_CurentLexile = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[1]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_ExpectedEndLexile = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[2]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		String Rerpot_VarianceExpectedEOYLexileCurrent = (driver.findElement(By.xpath("//*[@id='reports-table']/tbody/tr[3]/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
		
		String[] lexie = lexile().toString().replaceAll("[^a-zA-Z0-9]+","").split("c");
		int Studentno = lexie.length;
		String[] grade = Grade().toString().replaceAll("[^a-zA-Z0-9]+","").split("c");
		
		int i=Integer.parseInt(lexie[0])+Integer.parseInt(lexie[1]);
		
		int StudentLexile = (i/Studentno);
		
		for (int j=0; j<grade.length; j++) {
			ExpectedLexGrowth = ExpectedLexGrowth +Integer.parseInt(getPropValues(Integer.parseInt(grade[j]),Integer.parseInt(lexie[j])));
			length = length+1;			
		}
		ExpectedLexGrowth = (ExpectedLexGrowth/length);
		Variance = StudentLexile-ExpectedLexGrowth;
		
		Assert.assertEquals(Integer.parseInt(Report_CurentLexile), StudentLexile, "Student FIRST TEST at School level report "+Report_CurentLexile+" is NOT matching with student level report "+StudentLexile+" Lexile");
		Assert.assertEquals(Integer.parseInt(Rerpot_ExpectedEndLexile), ExpectedLexGrowth, "Studen EXPECTED LEXILE GROWTH REPORT at School level report "+Rerpot_ExpectedEndLexile+" is NOT matching with student level report "+ExpectedLexGrowth+" Lexile");					
		Assert.assertEquals(Integer.parseInt(Rerpot_VarianceExpectedEOYLexileCurrent), Variance, "Student Variance: Expected EOY Lexile to Current Lexile at School level report "+Rerpot_VarianceExpectedEOYLexileCurrent+" is NOT matching with student level report "+Variance+" Lexile");					
	}
	
	public ArrayList Grade() throws IOException {
		ArrayList Year = new ArrayList();
		/*String UploadedFilePath = new File(".").getCanonicalPath()
				+ "\\src\\test\\resources\\upload_files\\sriUpload.csv";*/
		String UploadedFilePath="/home/linux-gui/.jenkins/workspace/Csrep/litpro-test/src/test/resources/upload_files/sriUpload.csv";
		String b = getReadCSVFile(UploadedFilePath).toString();
		String[] CSVquiz = b.split("\\*\\,");
		for (int i = 1; i < CSVquiz.length; i++) {
			String[] quiz = CSVquiz[i].split("\\,");
			Year.add(quiz[1].trim()+"c");
		}
		return Year;
	}
	
	public void Reading_Proficiency_Report_class(String ClassName){
		int Advanced = 0;
		int Proficient = 0;
		int Basic = 0;
		int Below_Basic = 0;
		int AdvancedGraph = 0;
		int ProficientGraph = 0;
		int BasicGraph = 0;
		int Below_BasicGraph = 0;
		int Below_BasicPercentageGraph = 0;
		int BasicPercentageGraph = 0;
		int ProficientPercentageGraph = 0;
		int AdvancedPercentageGraph = 0;
		String ProficiencyBand;
		
		String[] a = Studentclass(ClassName).toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
		for(int j=0; j<a.length; j++){
			String StudentName=a[j].trim();
			ProficiencyBand = util.getValue(StudentName+"_ProficiencyBand");
			if(ProficiencyBand.equalsIgnoreCase("Below Basic")){
				Below_Basic = Below_Basic+1;
			}
			else if(ProficiencyBand.equalsIgnoreCase("Basic")){
				Basic = Basic+1;
			}
			else if(ProficiencyBand.equalsIgnoreCase("Proficient")){
				Proficient=Proficient+1;
			}
			else if(ProficiencyBand.equalsIgnoreCase("Advanced")){
				Advanced=Advanced+1;
			}
		}
		
		int totalstudent=(Advanced + Proficient + Basic + Below_Basic);
		System.out.println("---------"+totalstudent);
		int AdvancedPercentage = (Advanced/totalstudent)*100;
		int ProficientPercentage =  (Proficient/totalstudent)*100;
		int BasicPercentage =  (Basic/totalstudent)*100;
		int Below_BasicPercentage =  (Below_Basic/totalstudent)*100;
		
		String Lexile_Compared_Norm_Report = ReadingProficiencyReportReportsData().toString().replaceAll("BR", "-").replaceAll("^\\[|\\]$|L|,", "");		
		String[] LCNRData = Lexile_Compared_Norm_Report.substring(0, Lexile_Compared_Norm_Report.length() - 1).split("\\*");
		for(int i=0; i<LCNRData.length; i++){
			LCNRData[i] = LCNRData[i].trim();
			if (LCNRData[i].contains("# of students")){
			String[] GradeData = LCNRData[i].trim().split("(?<=\\D)(?=\\d)");
				Below_BasicGraph = Integer.parseInt(GradeData[1].trim());
				BasicGraph = Integer.parseInt(GradeData[2].trim());
				ProficientGraph = Integer.parseInt(GradeData[3].trim());
				AdvancedGraph = Integer.parseInt(GradeData[4].trim());						
			}
			if (LCNRData[i].contains("% of students")){
				String[] GradeData = LCNRData[i].trim().split("(?<=\\D)(?=\\d)");
				Below_BasicPercentageGraph = Integer.parseInt(GradeData[1].replaceAll("%", "").trim());
				BasicPercentageGraph = Integer.parseInt(GradeData[2].replaceAll("%", "").trim());
				ProficientPercentageGraph = Integer.parseInt(GradeData[3].replaceAll("%", "").trim());
				AdvancedPercentageGraph = Integer.parseInt(GradeData[4].replaceAll("%", "").trim());						
			}		
		}
		
		
		
		Assert.assertEquals((Below_BasicGraph), Below_Basic,"For Reading Proficiency Report Number of student in Bellow basic should be "+Below_Basic+" Instead it is showing "+ (Below_Basic));
		Assert.assertEquals((BasicGraph), Basic,"For Reading Proficiency Report percentage of student in Basic should be "+BasicGraph+" Instead it is showing "+ (Basic));
		Assert.assertEquals((ProficientGraph), Proficient, "For Reading Proficiency Report percentage of student in Proficient should be "+ProficientPercentage+" Instead it is showing "+ (Proficient));
		Assert.assertEquals((AdvancedGraph), Advanced, "For Reading Proficiency Report percentage of student in Advanced should be "+AdvancedPercentage+" Instead it is showing "+ (Advanced));
		
		Assert.assertEquals((Below_BasicPercentage), Below_BasicPercentageGraph,"For Reading Proficiency Report percentage of student in Bellow basic should be "+Below_BasicPercentage+" Instead it is showing "+ (Below_BasicPercentageGraph));
		Assert.assertEquals((BasicPercentage), BasicPercentageGraph, "For Reading Proficiency Report percentage of student in Basic should be "+BasicPercentage+" Instead it is showing "+ (BasicPercentageGraph));
		Assert.assertEquals((ProficientPercentage), ProficientPercentageGraph, "For Reading Proficiency Report percentage of student in Proficient should be "+ProficientPercentage+" Instead it is showing "+ (ProficientPercentageGraph));
		Assert.assertEquals((AdvancedPercentage), AdvancedPercentageGraph,"For Reading Proficiency Report percentage of student in Advanced should be "+AdvancedPercentage+" Instead it is showing "+ (AdvancedPercentageGraph));
	}
	
	
	public void Reading_Proficiency_Report_Grade(){
		String Grade=util.getValue("JoeMartina_Grade");
		int Advanced = 0;
		int Proficient = 0;
		int Basic = 0;
		int Below_Basic = 0;
		int AdvancedGraph = 0;
		int ProficientGraph = 0;
		int BasicGraph = 0;
		int Below_BasicGraph = 0;
		int Below_BasicPercentageGraph = 0;
		int BasicPercentageGraph = 0;
		int ProficientPercentageGraph = 0;
		int AdvancedPercentageGraph = 0;
		String ProficiencyBand;
		
		String[] a = StudentGrade(Grade).toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
		for(int j=0; j<a.length; j++){
			String StudentName=a[j].trim();
			ProficiencyBand = util.getValue(StudentName+"_ProficiencyBand");
			System.out.println("^^^ProficiencyBand^^"+ProficiencyBand);
			if(ProficiencyBand.equalsIgnoreCase("Below Basic")){
					Below_Basic = Below_Basic+1;
			}
			else if(ProficiencyBand.equalsIgnoreCase("Basic")){
				Basic = Basic+1;
			}
			else if(ProficiencyBand.equalsIgnoreCase("Proficient")){
				Proficient=Proficient+1;
			}
			else if(ProficiencyBand.equalsIgnoreCase("Advanced")){
				Advanced=Advanced+1;
			}
	    }
		
		int totalstudent=(Advanced + Proficient + Basic + Below_Basic);
		int AdvancedPercentage = (Advanced/totalstudent)*100;
		int ProficientPercentage =  (Proficient/totalstudent)*100;
		int BasicPercentage =  (Basic/totalstudent)*100;
		int Below_BasicPercentage =  (Below_Basic/totalstudent)*100;
		
		String Lexile_Compared_Norm_Report = ReadingProficiencyReportReportsData().toString().replaceAll("BR", "-").replaceAll("^\\[|\\]$|L|,", "");		//collecting data from Lexile Compared Norm Report at class level in arraylist
		String[] LCNRData = Lexile_Compared_Norm_Report.substring(0, Lexile_Compared_Norm_Report.length() - 1).split("\\*");						// spliting the arraylist by ","
		for(int i=0; i<LCNRData.length; i++){											// doing for loop to collect all the data from the table of Lexile Compared Norm Report
			LCNRData[i] = LCNRData[i].trim();
			if (LCNRData[i].contains("# of students")){
			String[] GradeData = LCNRData[i].trim().split("(?<=\\D)(?=\\d)");
					Below_BasicGraph = Integer.parseInt(GradeData[1].trim());
					BasicGraph = Integer.parseInt(GradeData[2].trim());
					ProficientGraph = Integer.parseInt(GradeData[3].trim());
					AdvancedGraph = Integer.parseInt(GradeData[4].trim());						
			}
			if (LCNRData[i].contains("% of students")){
				String[] GradeData = LCNRData[i].trim().split("(?<=\\D)(?=\\d)");
				Below_BasicPercentageGraph = Integer.parseInt(GradeData[1].replaceAll("%", "").trim());
				BasicPercentageGraph = Integer.parseInt(GradeData[2].replaceAll("%", "").trim());
				ProficientPercentageGraph = Integer.parseInt(GradeData[3].replaceAll("%", "").trim());
				AdvancedPercentageGraph = Integer.parseInt(GradeData[4].replaceAll("%", "").trim());						
				}
		}

		Assert.assertEquals((Below_BasicGraph), Below_Basic, "For Reading Proficiency Report Number of student in Bellow basic should be "+Below_Basic+" Instead it is showing "+ (Below_BasicGraph));
		Assert.assertEquals((Basic), BasicGraph,"For Reading Proficiency Report Number of student in Basic should be "+Basic+" Instead it is showing "+ (BasicGraph));
		Assert.assertEquals((Proficient), ProficientGraph,"For Reading Proficiency Report Number of student in Proficient should be "+Proficient+" Instead it is showing "+ (ProficientGraph));
		Assert.assertEquals((Advanced), AdvancedGraph, "For Reading Proficiency Report Number of student in Advanced should be "+Advanced+" Instead it is showing "+ (AdvancedGraph));
		
		Assert.assertEquals((Below_BasicPercentage), Below_BasicPercentageGraph, "For Reading Proficiency Report percentage of student in Bellow basic should be "+Below_BasicPercentage+" Instead it is showing "+ (Below_BasicPercentageGraph));
		Assert.assertEquals((BasicPercentage), BasicPercentageGraph, "For Reading Proficiency Report percentage of student in Basic should be "+BasicPercentage+" Instead it is showing "+ (BasicPercentageGraph));
		Assert.assertEquals((ProficientPercentage), ProficientPercentageGraph,"For Reading Proficiency Report percentage of student in Proficient should be "+ProficientPercentage+" Instead it is showing "+ (ProficientPercentageGraph));
		Assert.assertEquals((AdvancedPercentage), AdvancedPercentageGraph, "For Reading Proficiency Report percentage of student in Advanced should be "+AdvancedPercentage+" Instead it is showing "+ (AdvancedPercentageGraph));
	}
	
	public void Reading_Proficiency_Report_School(){
	    	int Advanced = 0;
			int Proficient = 0;
			int Basic = 0;
			int Below_Basic = 0;
			int AdvancedGraph = 0;
			int ProficientGraph = 0;
			int BasicGraph = 0;
			int Below_BasicGraph = 0;
			int Below_BasicPercentageGraph = 0;
			int BasicPercentageGraph = 0;
			int ProficientPercentageGraph = 0;
			int AdvancedPercentageGraph = 0;
			String ProficiencyBand;
			
			Map<String, String> map = util.getMap();
			for ( Entry<String, String> key : map.entrySet()) {
				if(key.getKey().contains("_ProficiencyBand")){
					ProficiencyBand = key.getValue();
					if(ProficiencyBand.equalsIgnoreCase("Below Basic")){
						Below_Basic = Below_Basic+1;
					}
					else if(ProficiencyBand.equalsIgnoreCase("Basic")){
						Basic = Basic+1;
					}
					else if(ProficiencyBand.equalsIgnoreCase("Proficient")){
						Proficient=Proficient+1;
					}
					else if(ProficiencyBand.equalsIgnoreCase("Advanced")){
						Advanced=Advanced+1;
					}
			    }
			}
			int totalstudent=(Advanced + Proficient + Basic + Below_Basic);
			int AdvancedPercentage = (Advanced/totalstudent)*100;
			int ProficientPercentage =  (Proficient/totalstudent)*100;
			int BasicPercentage =  (Basic/totalstudent)*100;
			int Below_BasicPercentage =  (Below_Basic/totalstudent)*100;
			
			String Lexile_Compared_Norm_Report = ReadingProficiencyReportReportsData().toString().replaceAll("BR", "-").replaceAll("^\\[|\\]$|L|,", "");		//collecting data from Lexile Compared Norm Report at class level in arraylist
			String[] LCNRData = Lexile_Compared_Norm_Report.substring(0, Lexile_Compared_Norm_Report.length() - 1).split("\\*");						// spliting the arraylist by ","
			for(int i=0; i<LCNRData.length; i++){											// doing for loop to collect all the data from the table of Lexile Compared Norm Report
				LCNRData[i] = LCNRData[i].trim();
				if (LCNRData[i].contains("# of students")){
				String[] GradeData = LCNRData[i].trim().split("(?<=\\D)(?=\\d)");
						Below_BasicGraph = Integer.parseInt(GradeData[1].trim());
						BasicGraph = Integer.parseInt(GradeData[2].trim());
						ProficientGraph = Integer.parseInt(GradeData[3].trim());
						AdvancedGraph = Integer.parseInt(GradeData[4].trim());						
				}
				if (LCNRData[i].contains("% of students")){
					String[] GradeData = LCNRData[i].trim().split("(?<=\\D)(?=\\d)");
					Below_BasicPercentageGraph = Integer.parseInt(GradeData[1].replaceAll("%", "").trim());
					BasicPercentageGraph = Integer.parseInt(GradeData[2].replaceAll("%", "").trim());
					ProficientPercentageGraph = Integer.parseInt(GradeData[3].replaceAll("%", "").trim());
					AdvancedPercentageGraph = Integer.parseInt(GradeData[4].replaceAll("%", "").trim());						
					}
			}

			Assert.assertEquals((Below_BasicGraph), Below_Basic,"For Reading Proficiency Report Number of student in Bellow basic should be "+Below_Basic+" Instead it is showing "+ (Below_BasicGraph));
			Assert.assertEquals((Basic), BasicGraph,"For Reading Proficiency Report Number of student in Basic should be "+Basic+" Instead it is showing "+ (BasicGraph));
			Assert.assertEquals((Proficient), ProficientGraph,"For Reading Proficiency Report Number of student in Proficient should be "+Proficient+" Instead it is showing "+ (ProficientGraph));
			Assert.assertEquals((Advanced), AdvancedGraph, "For Reading Proficiency Report Number of student in Advanced should be "+Advanced+" Instead it is showing "+ (AdvancedGraph));
			
			Assert.assertEquals((Below_BasicPercentage), Below_BasicPercentageGraph,"For Reading Proficiency Report percentage of student in Bellow basic should be "+Below_BasicPercentage+" Instead it is showing "+ (Below_BasicPercentageGraph));
			Assert.assertEquals((BasicPercentage), BasicPercentageGraph,"For Reading Proficiency Report percentage of student in Basic should be "+BasicPercentage+" Instead it is showing "+ (BasicPercentageGraph));
			Assert.assertEquals((ProficientPercentage), ProficientPercentageGraph,"For Reading Proficiency Report percentage of student in Proficient should be "+ProficientPercentage+" Instead it is showing "+ (ProficientPercentageGraph));
			Assert.assertEquals((AdvancedPercentage), AdvancedPercentageGraph,"For Reading Proficiency Report percentage of student in Advanced should be "+AdvancedPercentage+" Instead it is showing "+ (AdvancedPercentageGraph));
	}
	
	public void Historical_Reading_Proficiency_Report_School() throws IOException{
    	int Advanced = 0;
		int Proficient= 0;
		int Basic = 0;
		int Below_Basic = 0;
		int AdvancedGraph = 0;
		int ProficientGraph = 0;
		int BasicGraph = 0;
		int Below_BasicGraph = 0;
		int Below_BasicPercentageGraph = 0;
		int BasicPercentageGraph = 0;
		int ProficientPercentageGraph = 0;
		int AdvancedPercentageGraph = 0;
		String ProficiencyBand;
		int count = 0;
		String benchmark;
		
		String[] lexie = lexile().toString().replaceAll("[^a-zA-Z0-9]+","").split("c");
		String[] Grade = Grade().toString().replaceAll("[^a-zA-Z0-9]+","").split("c");
		int Studentno = lexie.length;
		for(int i=0; i <Studentno; i++){
			benchmark = Benchmark(Integer.parseInt(Grade[i]), Integer.parseInt(lexie[i]));
			if(benchmark.equalsIgnoreCase("Below Basic")){
				Below_Basic=Below_Basic+1;
			}
			if(benchmark.equalsIgnoreCase("Basic")){
				Basic=Basic+1;
			}
			if(benchmark.equalsIgnoreCase("Proficient")){
				Proficient=Proficient+1;
			}
			if(benchmark.equalsIgnoreCase("Advanced")){
				Advanced=Advanced+1;
			}
		}
		
		System.out.println();
		int totalstudent=(Advanced + Proficient + Basic + Below_Basic);
		int AdvancedPercentage = (Advanced*100/totalstudent);
		int ProficientPercentage =  (Proficient*100/totalstudent);
		int BasicPercentage =  (Basic*100/totalstudent);
		int Below_BasicPercentage =  (Below_Basic*100/totalstudent);
		
		String Lexile_Compared_Norm_Report = ReadingProficiencyReportReportsData().toString().replaceAll("BR", "-").replaceAll("^\\[|\\]$|L|,", "");		//collecting data from Lexile Compared Norm Report at class level in arraylist
		String[] LCNRData = Lexile_Compared_Norm_Report.substring(0, Lexile_Compared_Norm_Report.length() - 1).split("\\*");						// spliting the arraylist by ","
		for(int j=0; j<LCNRData.length; j++){											// doing for loop to collect all the data from the table of Lexile Compared Norm Report
			LCNRData[j] = LCNRData[j].trim();
			if (LCNRData[j].contains("# of students")){
			String[] GradeData = LCNRData[j].trim().split("(?<=\\D)(?=\\d)");
					Below_BasicGraph = Integer.parseInt(GradeData[1].trim());
					BasicGraph = Integer.parseInt(GradeData[2].trim());
					ProficientGraph = Integer.parseInt(GradeData[3].trim());
					AdvancedGraph = Integer.parseInt(GradeData[4].trim());						
			}
			if (LCNRData[j].contains("% of students")){
				String[] GradeData = LCNRData[j].trim().split("(?<=\\D)(?=\\d)");
				Below_BasicPercentageGraph = Integer.parseInt(GradeData[1].replaceAll("%", "").trim());
				BasicPercentageGraph = Integer.parseInt(GradeData[2].replaceAll("%", "").trim());
				ProficientPercentageGraph = Integer.parseInt(GradeData[3].replaceAll("%", "").trim());
				AdvancedPercentageGraph = Integer.parseInt(GradeData[4].replaceAll("%", "").trim());						
				}
		}
		

		Assert.assertEquals((Below_BasicGraph), Below_Basic,"For Reading Proficiency Report Number of student in Bellow basic should be "+Below_Basic+" Instead it is showing "+ (Below_BasicGraph));
		Assert.assertEquals((Basic), BasicGraph,"For Reading Proficiency Report Number of student in Basic should be "+Basic+" Instead it is showing "+ (BasicGraph));
		Assert.assertEquals((Proficient), ProficientGraph,"For Reading Proficiency Report Number of student in Proficient should be "+Proficient+" Instead it is showing "+ (ProficientGraph));
		Assert.assertEquals((Advanced), AdvancedGraph, "For Reading Proficiency Report Number of student in Advanced should be "+Advanced+" Instead it is showing "+ (AdvancedGraph));
		
		Assert.assertEquals((Below_BasicPercentage), Below_BasicPercentageGraph,"For Reading Proficiency Report percentage of student in Bellow basic should be "+Below_BasicPercentage+" Instead it is showing "+ (Below_BasicPercentageGraph));
		Assert.assertEquals((BasicPercentage), BasicPercentageGraph,"For Reading Proficiency Report percentage of student in Basic should be "+BasicPercentage+" Instead it is showing "+ (BasicPercentageGraph));
		Assert.assertEquals((ProficientPercentage), ProficientPercentageGraph,"For Reading Proficiency Report percentage of student in Proficient should be "+ProficientPercentage+" Instead it is showing "+ (ProficientPercentageGraph));
		Assert.assertEquals((AdvancedPercentage), AdvancedPercentageGraph,"For Reading Proficiency Report percentage of student in Advanced should be "+AdvancedPercentage+" Instead it is showing "+ (AdvancedPercentageGraph));
	}
	
	public String Benchmark(int grade, int lexile) {
		String benchmark = null;
		if (grade == 1) {
			if (0 < lexile) {
				benchmark = "Below Basic";
			}
			if (1 <= lexile && lexile <= 99) {
				benchmark = "Basic";
			}
			if (100 <= lexile && lexile <= 400) {
				benchmark = "Proficient";
			}
			if (lexile > 401) {
				benchmark = "Advanced";
			}
		}
		if (grade == 2) {
			if (0 <= lexile && lexile <= 99) {
				benchmark = "Below Basic";
			}
			if (100 <= lexile && lexile <= 299) {
				benchmark = "Basic";
			}
			if (300 <= lexile && lexile <= 600) {
				benchmark = "Proficient";
			}
			if (lexile > 601) {
				benchmark = "Advanced";
			}
		}
		if (grade == 3) {
			if (0 <= lexile && lexile <= 249) {
				benchmark = "Below Basic";
			}
			if (250 <= lexile && lexile <= 499) {
				benchmark = "Basic";
			}
			if (500 <= lexile && lexile <= 800) {
				benchmark = "Proficient";
			}
			if (lexile > 801) {
				benchmark = "Advanced";
			}
		}
		if (grade == 4) {
			if (0 <= lexile && lexile <= 349) {
				benchmark = "Below Basic";
			}
			if (350 <= lexile && lexile <= 599) {
				benchmark = "Basic";
			}
			if (600 <= lexile && lexile <= 900) {
				benchmark = "Proficient";
			}
			if (lexile > 901) {
				benchmark = "Advanced";
			}
		}
		if (grade == 5) {
			if (0 <= lexile && lexile <= 449) {
				benchmark = "Below Basic";
			}
			if (450 <= lexile && lexile <= 699) {
				benchmark = "Basic";
			}
			if (700 <= lexile && lexile <= 1000) {
				benchmark = "Proficient";
			}
			if (lexile > 1001) {
				benchmark = "Advanced";
			}
		}
		if (grade == 6) {
			if (0 <= lexile && lexile <= 499) {
				benchmark = "Below Basic";
			}
			if (500 <= lexile && lexile <= 799) {
				benchmark = "Basic";
			}
			if (800 <= lexile && lexile <= 1050) {
				benchmark = "Proficient";
			}
			if (lexile > 1051) {
				benchmark = "Advanced";
			}
		}
		if (grade == 7) {
			if (0 <= lexile && lexile <= 549) {
				benchmark = "Below Basic";
			}
			if (550 <= lexile && lexile <= 849) {
				benchmark = "Basic";
			}
			if (850 <= lexile && lexile <= 1100) {
				benchmark = "Proficient";
			}
			if (lexile > 1101) {
				benchmark = "Advanced";
			}
		}
		if (grade == 8) {
			if (0 <= lexile && lexile <= 599) {
				benchmark = "Below Basic";
			}
			if (600 <= lexile && lexile <= 899) {
				benchmark = "Basic";
			}
			if (900 <= lexile && lexile <= 1150) {
				benchmark = "Proficient";
			}
			if (lexile > 1151) {
				benchmark = "Advanced";
			}
		}
		if (grade == 9) {
			if (0 <= lexile && lexile <= 649) {
				benchmark = "Below Basic";
			}
			if (650 <= lexile && lexile <= 999) {
				benchmark = "Basic";
			}
			if (1000 <= lexile && lexile <= 1200) {
				benchmark = "Proficient";
			}
			if (lexile > 1201) {
				benchmark = "Advanced";
			}
		}
		if (grade == 10) {
			if (0 <= lexile && lexile <= 699) {
				benchmark = "Below Basic";
			}
			if (700 <= lexile && lexile <= 1024) {
				benchmark = "Basic";
			}
			if (1025 <= lexile && lexile <= 1250) {
				benchmark = "Proficient";
			}
			if (lexile > 1251) {
				benchmark = "Advanced";
			}
		}
		if (grade == 11 && grade == 12) {
			if (0 <= lexile && lexile <= 799) {
				benchmark = "Below Basic";
			}
			if (800 <= lexile && lexile <= 1049) {
				benchmark = "Basic";
			}
			if (1050 <= lexile && lexile <= 1300) {
				benchmark = "Proficient";
			}
			if (lexile > 1301) {
				benchmark = "Advanced";
			}
		}
		return benchmark;
	}
	
	public String getPropValuesGrade(String grade, int FirstLexile) {
		String ExpectedGrowthReport = null;
		int tempgrade = Integer.parseInt(GradeConverstion(grade));
		if (1 < tempgrade && tempgrade < 11) {

			if (100 > FirstLexile) {
				FirstLexile = 99;
			}
			int i = (int) (Math.floor(FirstLexile / 10d) * 10);
			i = ((i * 100) + tempgrade);
			ExpectedGrowthReport = testBase.getContext().getString(
					Integer.toString(i));
		}
		return ExpectedGrowthReport;
	}
	
	public String getPropValues(int grade, int FirstLexile) {
		String ExpectedGrowthReport = null;
		if (1 < grade && grade < 11) {
			if (100 > FirstLexile) {
				FirstLexile = 99;
			}
			int i = (int) (Math.floor(FirstLexile / 10d) * 10);
			i = ((i * 100) + grade);
			ExpectedGrowthReport = testBase.getContext().getString(
					Integer.toString(i));
		}
		return ExpectedGrowthReport;
	}

	
	public boolean Class_Reading_Report_class(String ClassName){
		String Student_Name;
		String Report_StudentName = null;
		boolean result = false;
		int count = 0;
		
		String[] a = Studentclass(ClassName).toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
		for(int j=0; j<a.length; j++){
			System.out.println("==="+a.length);
			
			String x=a[j].trim();
			int rowCount = driver.findElements(	By.xpath("//*[@id='reports-table']/tbody/tr")).size();
			for (int i = 1; i <= rowCount; i++) {
				String final_xpath = "//*[@id='reports-table']/tbody/tr["+ (i) + "]";
				Report_StudentName = (driver.findElement(By.xpath(final_xpath+"/th")).getText());
				String Rerpot_CurrentLexile =(driver.findElement(By.xpath(final_xpath+"/td[1]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
				String Report_LexileGrowth =(driver.findElement(By.xpath(final_xpath+"/td[2]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
				String Report_DateLastCompletedTest =(driver.findElement(By.xpath(final_xpath+"/td[3]")).getText());
				String Report_ProficiencyBand =(driver.findElement(By.xpath(final_xpath+"/td[4]")).getText());
				String Report_CertificateLevel =(driver.findElement(By.xpath(final_xpath+"/td[5]")).getText());
				String Report_QuizzesPassedAttempted =(driver.findElement(By.xpath(final_xpath+"/td[6]")).getText());
				String Report_AverageQuizScore =(driver.findElement(By.xpath(final_xpath+"/td[7]")).getText());
				String Report_AverageLexileQuizzesPassed =(driver.findElement(By.xpath(final_xpath+"/td[8]")).getText()).replaceAll("BR", "-").replaceAll("L", "");
				String Report_WordsRead =(driver.findElement(By.xpath(final_xpath+"/td[9]")).getText()).replaceAll(",", "");
				String Report_QuizPointsEarned =(driver.findElement(By.xpath(final_xpath+"/td[10]")).getText());
				String Report_TeacherAddedPoints =(driver.findElement(By.xpath(final_xpath+"/td[11]")).getText());
				Student_Name = util.getValue(x.trim()+"_Name");
				String Student_CurrentLexile=util.getValue(x.trim()+"_Lexile").replaceAll("BR", "-").replaceAll("L", "");
				String Student_LexileGrowth=util.getValue(x.trim()+"_LexileGrowth").replaceAll("BR", "-").replaceAll("L", "");
				String Student_DateLastCompletedTest=util.getValue(x.trim()+"_LastCompDate");
				String Student_ProficiencyBand=util.getValue(x.trim()+"_ProficiencyBand");
				String Student_CertificateLevel=util.getValue(x.trim()+"_CertificateLevel");
				String Student_QuizzesPassedAttempted=util.getValue(x.trim()+"_QuizzesPassedAttempted");
				String Student_AverageQuizScore=util.getValue(x.trim()+"_AverageQuizScore");
				String Student_AverageLexileQuizzesPassed=util.getValue(x.trim()+"_AverageLexileQuizzesPassed").replaceAll("BR", "-").replaceAll("L", "");
				String Student_WordsRead=util.getValue(x.trim()+"_WordsRead");
				String Student_QuizPointsEarned=util.getValue(x.trim()+"_QuizPointsEarned");
				String Student_TeacherAddedPoints=util.getValue(x.trim()+"_TeacherAddedPoints");
				
				
				if(Report_StudentName.equalsIgnoreCase(Student_Name)
						&& Rerpot_CurrentLexile.equalsIgnoreCase(Student_CurrentLexile) 
						&& Report_LexileGrowth.equalsIgnoreCase(Student_LexileGrowth)
						&& Report_DateLastCompletedTest.equalsIgnoreCase(Student_DateLastCompletedTest)
						&& Report_ProficiencyBand.equalsIgnoreCase(Student_ProficiencyBand)
						&& Report_CertificateLevel.equalsIgnoreCase(Student_CertificateLevel)
						&& Report_QuizzesPassedAttempted.equalsIgnoreCase(Student_QuizzesPassedAttempted)
						&& Report_AverageQuizScore.equalsIgnoreCase(Student_AverageQuizScore)
						&& Report_AverageLexileQuizzesPassed.equalsIgnoreCase(Student_AverageLexileQuizzesPassed)
						&& Report_WordsRead.equalsIgnoreCase(Student_WordsRead)
						&& Report_QuizPointsEarned.equalsIgnoreCase(Student_QuizPointsEarned)
						&& Report_TeacherAddedPoints.equalsIgnoreCase(Student_TeacherAddedPoints)){
					
					System.out.println("Student NAME at Class Reading Report class level report "+Report_StudentName+" is matching with student level report "+Student_Name+" names");
					System.out.println("Student Current Lexile at Class Reading Report class level report "+Rerpot_CurrentLexile+" is matching with student level report "+Student_CurrentLexile+" names");
					System.out.println("Student Lexile Growth at Class Reading Report class level report "+Report_LexileGrowth+" is matching with student level report "+Student_LexileGrowth+" names");
					System.out.println("Student Date of Last Completed LitPro Test at Class Reading Report class level report "+Report_DateLastCompletedTest+" is matching with student level report "+Student_DateLastCompletedTest+" names");
					System.out.println("Student Proficiency Band at Class Reading Report class level report "+Report_ProficiencyBand+" is matching with student level report "+Student_ProficiencyBand+" names");
					System.out.println("Student Certificate Level at Class Reading Report class level report "+Report_CertificateLevel+" is matching with student level report "+Student_CertificateLevel+" names");
					System.out.println("Student # of Quizzes Passed/Attempted at Class Reading Report class level report "+Report_QuizzesPassedAttempted+" is matching with student level report "+Student_QuizzesPassedAttempted+" names");
					System.out.println("Student Average Quiz Score at Class Reading Report class level report "+Report_AverageQuizScore+" is matching with student level report "+Student_AverageQuizScore+" names");
					System.out.println("Student Average Lexile of Quizzes Passed at Class Reading Report class level report "+Report_AverageLexileQuizzesPassed+" is matching with student level report "+Student_AverageLexileQuizzesPassed+" names");
					System.out.println("Student Words Read at Class Reading Report class level report "+Report_WordsRead+" is matching with student level report "+Student_WordsRead+" names");
					System.out.println("Student Quiz Points Earned at Class Reading Report class level report "+Report_QuizPointsEarned+" is matching with student level report "+Student_QuizPointsEarned+" names");
					System.out.println("Student Teacher-Added Points at Class Reading Report class level report "+Report_TeacherAddedPoints+" is matching with student level report "+Student_TeacherAddedPoints+" names");
					count = count+1;
				}				
			}
		}
		System.out.println(count+"^^^^^^^^^^^^^^^"+a.length);
		if(count==a.length){
			result = true;
		}
		return result;
	}
	
	public boolean Class_Lexile_History_Report_class(String ClassName){
		String Student_Name;
		String Report_StudentName = null;
		boolean result = false;
		int count = 0;
		String ReportDatas;
		String StudentData;
		ArrayList<String> ReprotData = new ArrayList<String>();
		
		String[] a = Studentclass(ClassName).toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
		for(int j=0; j<a.length; j++){
			String x=a[j].trim();
			Student_Name=(util.getValue(x+"_Name"));
			int rowCount = driver.findElements(	By.xpath("//*[@id='reports-table']/tbody/tr")).size();
			for (int i = 1; i <= rowCount; i++) {
				String xpath = "//*[@id='reports-table']/tbody/tr["+ (i) + "]";
				Report_StudentName = (driver.findElement(By.xpath(xpath+"/th")).getText());
				if(Report_StudentName.equalsIgnoreCase(Student_Name)){
					int rowCount1 = driver.findElements(By.xpath(xpath+"/td")).size();
					for(int k=1; k<rowCount1; k++){
						String xpath1 = "//*[@id='reports-table']/tbody/tr["+i+"]/td["+ (k) + "]";
						String value =driver.findElement(By.xpath(xpath1)).getText().trim();
						if(!value.isEmpty()){
							ReprotData.add(value.trim());
						}						
					}
				}
			}
			ReportDatas=ReprotData.toString().replaceAll(" ", "").replaceAll("^\\[|\\]$", "");
			StudentData=util.getValue(x+"_HistoricalTestData").replaceAll(" ", "").replaceAll("^\\[|\\]$", "");
			if(ReportDatas.contains(StudentData)){
				count = count+1;
			}		
		}
		if(count==a.length){
			result = true;
		}
		return result;
	}
	
	public void AddActivityButton(){
		AddActivityButton.click();
		reportLog("Clicked on student activity button");
	}
	public String getActivityHeaderText(){
		lazyWait(10);
		return AddActivityWindowHeader.getText();
	}
	
	public boolean AddActivity(){
		int result = 0;
		String ExpectedPoint;
		String ExpectedTitle;
		String ExpectedDate;
		int num=RandomNumber();
		AddActivityTitle.sendKeys("Test"+num);
		AddActivityPoint.sendKeys("0"+num);
		AddActivityDate.sendKeys("01-March-2017");
		AddActivityDate.sendKeys(Keys.ENTER);
		AddActivityTitleBook.click();
		AddActivityTitleBook.sendKeys("Test"+num);
		
		String ActualTitle = "Test"+num;
		String ActualActivityPoint =Integer.toString(num);
		//String ActualActivityPoint = (String) ((JavascriptExecutor) driver).executeScript("'$('input[placeholder='Title of Activity']').val();'");
		String Actualdate = getDateTime();
		AddActivitybuttonPOPup.click();
		
		
		///Activity added
		lazyWait(10);
		int col = driver.findElements(By.xpath("//*[@id='main-content']/div[2]/div[4]/div[2]/div/div/div//input")).size();
		for(int i=2; i<col; i++){
			ExpectedPoint =driver.findElement(By.xpath("//*[@id='main-content']/div[2]/div[4]/div[2]/div/div["+i+"]/div//input")).getAttribute("value");
			ExpectedTitle =driver.findElement(By.xpath("//*[@id='main-content']/div[2]/div[4]/div[2]/div/div["+i+"]/div//div[1]/div[1]")).getText();
			ExpectedDate =driver.findElement(By.xpath("//*[@id='main-content']/div[2]/div[4]/div[2]/div/div["+i+"]/div//div[4]")).getText();
			//comparing the data
			if(ActualTitle.equalsIgnoreCase(ExpectedTitle) && 
					ActualActivityPoint.equalsIgnoreCase(ExpectedPoint) &&
					Actualdate.equalsIgnoreCase(ExpectedDate)){
				System.out.println(ActualActivityPoint+"Point added"+ExpectedPoint);
				System.out.println(ActualTitle+"Title added"+ExpectedTitle);
				System.out.println(Actualdate+"Date Added"+ExpectedDate);
				result=1;
			}
		}
		
		if(result==0){
			reportLog("Foolowing Title "+ ActualTitle + " Points "+ActualActivityPoint+" Date of Avtiviy "+Actualdate+" were not added");
			return false;
		}
		else{
			reportLog("Admin/Teacher is able to add the activity for a student");
			return true;
		}
	}
	
	public Boolean DashboardReportVisibility(String DashboardReport){
		Boolean result = driver.findElement(By.xpath("//*[@id='metrics']//span[contains(text(), '"+DashboardReport+"')]")).isDisplayed();
		reportLog(DashboardReport + " Report is visible at Dashboard");
		return result;
	}
	
	public int getNumQuizTaken(String user){
		String[] QuizAttempted;
		int num1;
		int QuizAttemptes=0;
		if (user.equalsIgnoreCase("Teacher")){
			String[] a = Studentclass("Lui Class").toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
			for(int j=0; j<a.length; j++){
				String x=a[j].trim();
				String QuizAttempteds=(util.getValue(x+"_QuizzesPassedAttempted"));
				QuizAttempted = QuizAttempteds.split("\\/");
				num1 = Integer.valueOf(QuizAttempted[1]);
				QuizAttemptes = QuizAttemptes+num1;
			}
		}
		if (user.equalsIgnoreCase("Admin")){
			String[] a = StudentSchool().toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
			for(int j=0; j<a.length; j++){
				String x=a[j].trim();
				String QuizAttempteds=(util.getValue(x+"_QuizzesPassedAttempted"));
				QuizAttempted = QuizAttempteds.split("\\/");
				num1 = Integer.valueOf(QuizAttempted[1]);
				QuizAttemptes = QuizAttemptes+num1;
			}
		}
		return QuizAttemptes;
	}
	
	public int getWordRead(String user){
		String Data;
		int RealData=0;
		if (user.equalsIgnoreCase("Teacher")){
			String[] a = Studentclass("Lui Class").toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
			for(int j=0; j<a.length; j++){
				String x=a[j].trim();
				Data=(util.getValue(x+"_WordsRead")).replaceAll(",", "");
				RealData = RealData+Integer.valueOf(Data);
			}	
		}
		if (user.equalsIgnoreCase("Admin")){
			String[] a = StudentSchool().toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
			for(int j=0; j<a.length; j++){
				String x=a[j].trim();
				Data=(util.getValue(x+"_WordsRead")).replaceAll(",", "");
				RealData = RealData+Integer.valueOf(Data);
			}
		}
		return RealData;
	}
	
	public int getQuizPassRate(String user){
		String[] QuizAttempted;
		int num2;
		int num1;
		int QuizAttemptes=0;
		int QuizPassed = 0;
		if (user.equalsIgnoreCase("Teacher")) {
			String[] a = Studentclass("Lui Class").toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
			for (int j = 0; j < a.length; j++) {
				String x = a[j].trim();
				String QuizAttempteds = (util.getValue(x+ "_QuizzesPassedAttempted"));
				QuizAttempted = QuizAttempteds.split("\\/");
				num1 = Integer.valueOf(QuizAttempted[1]);
				num2 = Integer.valueOf(QuizAttempted[0]);
				QuizAttemptes = QuizAttemptes + num1;
				QuizPassed = QuizPassed + num2;
			}
		}
		if (user.equalsIgnoreCase("Admin")) {
			String[] a = StudentSchool().toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
			for (int j = 0; j < a.length; j++) {
				String x = a[j].trim();
				String QuizAttempteds = (util.getValue(x+ "_QuizzesPassedAttempted"));
				QuizAttempted = QuizAttempteds.split("\\/");
				num1 = Integer.valueOf(QuizAttempted[1]);
				num2 = Integer.valueOf(QuizAttempted[0]);
				QuizAttemptes = QuizAttemptes + num1;
				QuizPassed = QuizPassed + num2;
			}
		}
		double percentage =(double) QuizPassed / QuizAttemptes;
		int QuizPassrate = (int) Math.floor(percentage*100);
		return QuizPassrate;
	}
	
	public int getAvgLexile(String user){
		String Data;
		int RealData=0;
		int numcount=0;
		if (user.equalsIgnoreCase("Teacher")){
			String[] a = Studentclass("Lui Class").toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
			for(int j=0; j<a.length; j++){
				String x=a[j].trim();
				Data=(util.getValue(x+"_Lexile")).replaceAll(",", "").replaceAll("BR", "-").replaceAll("L", "");
				RealData = RealData+Integer.valueOf(Data);
				numcount = numcount+1;
			}
			RealData=(int) Math.round((double)RealData/(double)numcount);	
		}
		if (user.equalsIgnoreCase("Admin")){
			String[] a = StudentSchool().toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
			for(int j=0; j<a.length; j++){
				String x=a[j].trim();
				Data=(util.getValue(x+"_Lexile")).replaceAll(",", "").replaceAll("BR", "-").replaceAll("L", "");
				RealData = RealData+Integer.valueOf(Data);
				numcount = numcount+1;
			}
			RealData=(int) Math.round((double)RealData/(double)numcount);	
		}
		return RealData;
	}
	
	public int getAvgLexGrowth(String user){
		String Data;
		int AvgLexGrowth = 0;
		double RealData=0;
		double numcount=0;
		if (user.equalsIgnoreCase("Teacher")){
			String[] a = Studentclass("Lui Class").toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
			for(int j=0; j<a.length; j++){
				String x=a[j].trim();
				Data=(util.getValue(x+"_LexileGrowth")).replaceAll(",", "").replaceAll("BR", "-").replaceAll("L", "");
				RealData = RealData+Integer.valueOf(Data);
				numcount = numcount+1;
			}
			RealData=new BigDecimal(RealData/numcount).setScale(0, RoundingMode.HALF_DOWN)
	                .doubleValue();
			AvgLexGrowth = (int)RealData;
		}
		if (user.equalsIgnoreCase("Admin")){
			String[] a = StudentSchool().toString().replaceAll("^\\[|\\]$|_Class", "").split(",");
			for(int j=0; j<a.length; j++){
				String x=a[j].trim();
				Data=(util.getValue(x+"_LexileGrowth")).replaceAll(",", "").replaceAll("BR", "-").replaceAll("L", "");
				RealData = RealData+Integer.valueOf(Data);
				numcount = numcount+1;
			}
			RealData=new BigDecimal(RealData/numcount).setScale(0, RoundingMode.HALF_DOWN)
	                .doubleValue();
			AvgLexGrowth = (int)RealData;
		}
		return AvgLexGrowth;
	}
	
	public boolean TeacherDashboardReportValidate(){
		int num=0;
		boolean result = true;
		String NumQuizTakens = Integer.toString(getNumQuizTaken("Teacher"));
		String NumberQuizTakensDash = NumberQuizzesTakenDshBord.getText();
		
		String WordRead = Integer.toString(getWordRead("Teacher"));
		String WordReadDash = WordsReadDshBord.getText().replaceAll(",", "");
		
		String QuizPassRate = Integer.toString(getQuizPassRate("Teacher"));
		String QuizPassRateDash = QuizPassRateDshBord.getText().replaceAll("%", "");
		
		String  AvgLexile= Integer.toString(getAvgLexile("Teacher"));
		String AvgLexileDsh = AvgLexileDshBord.getText().replaceAll("BR", "-").replaceAll("L", "");
		
		String AvgLexGrowth;
		if(getAvgLexGrowth("Teacher")>=0){
			AvgLexGrowth = "+"+Integer.toString(getAvgLexGrowth("Teacher"));
		}
		else{
			AvgLexGrowth = Integer.toString(getAvgLexGrowth("Teacher"));
		}
		String AvgLexGrowthDsh = AvgLexGrowthDshBord.getText().replaceAll("L", "");
		
		System.out.println(NumQuizTakens+"^^^^^^"+NumberQuizTakensDash);
		System.out.println(WordRead+"^^^^^^"+WordReadDash);
		System.out.println(QuizPassRate+"^^^^^^"+QuizPassRateDash);
		System.out.println(AvgLexile+"^^^^^^"+AvgLexileDsh);
		System.out.println(AvgLexGrowth+"^^^^^^"+AvgLexGrowthDsh);
		
		if(!NumberQuizTakensDash.equalsIgnoreCase(NumQuizTakens)){
			num=1;
		}
		
		if(!WordReadDash.equalsIgnoreCase(WordRead)){
			num=1;
		}
		if(!QuizPassRateDash.equalsIgnoreCase(QuizPassRate)){
			num=1;
		}
		
		if(!AvgLexileDsh.equalsIgnoreCase(AvgLexile)){
			num=1;
		}
		if(!AvgLexGrowthDsh.equalsIgnoreCase(AvgLexGrowth)){
			num=1;
		}
		
		if(num ==1){
			result=false;
		}
		return result;
	}
	
	public boolean AdminDashboardReportValidate(){
		int num=0;
		boolean result = true;
				
		String NumQuizTakens = Integer.toString(getNumQuizTaken("Admin"));
		String NumberQuizTakensDash = NumberQuizzesTakenDshBord.getText();
		
		String WordRead = Integer.toString(getWordRead("Admin"));
		String WordReadDash = WordsReadDshBord.getText().replaceAll(",", "");
		
		String QuizPassRate = Integer.toString(getQuizPassRate("Admin"));
		String QuizPassRateDash = QuizPassRateDshBord.getText().replaceAll("%", "");
		
		String  AvgLexile= Integer.toString(getAvgLexile("Admin"));
		String AvgLexileDsh = AvgLexileDshBord.getText().replaceAll("BR", "-").replaceAll("L", "");
		
		String AvgLexGrowth;
		if(getAvgLexGrowth("Admin")>=0){
			AvgLexGrowth = "+"+Integer.toString(getAvgLexGrowth("Admin"));
		}
		else{
			AvgLexGrowth = Integer.toString(getAvgLexGrowth("Admin"));
		}
		String AvgLexGrowthDsh = AvgLexGrowthDshBord.getText().replaceAll("L", "");
		
		System.out.println(NumQuizTakens+"^^^^^^"+NumberQuizTakensDash);
		System.out.println(WordRead+"^^^^^^"+WordReadDash);
		System.out.println(QuizPassRate+"^^^^^^"+QuizPassRateDash);
		System.out.println(AvgLexile+"^^^^^^"+AvgLexileDsh);
		System.out.println(AvgLexGrowth+"^^^^^^"+AvgLexGrowthDsh);
		
		if(!NumberQuizTakensDash.equalsIgnoreCase(NumQuizTakens)){
			num=1;
		}
		if(!WordReadDash.equalsIgnoreCase(WordRead)){
			num=1;
		}
		if(!QuizPassRateDash.equalsIgnoreCase(QuizPassRate)){
			num=1;
		}
		
		if(!AvgLexileDsh.equalsIgnoreCase(AvgLexile)){
			num=1;
		}
		if(!AvgLexGrowthDsh.equalsIgnoreCase(AvgLexGrowth)){
			num=1;
		}
		if(num ==1){
			result=false;
		}
		return result;
	}

	public boolean getLexilecomparedToNormReport() {
		
		  boolean result = false;
	     int rowCount = driver.findElements( By.xpath("//*[@id='reports-table']/tbody/tr")).size();
		   //for loop for Student data in Expected Lexile Growth Report class card
		   for (int i = 1; i <= rowCount; i++) {
		    String final_xpath = "//*[@id='reports-table']/tbody/tr["+ (i) + "]";
		    if(driver.findElement(By.xpath(final_xpath)).getText().contains("BR")){
		    	result = true;
		     }
		   }
		
		return result;
	}

	public boolean getLexileComparedWithnormAtGradeLevel() {
		  boolean result = false;
		     int rowCount = driver.findElements( By.xpath(".//*[@id='reports-table']/tbody/tr[1]/td")).size();
			   //for loop for Student data in Expected Lexile Growth Report class card
			   for (int i = 1; i <= rowCount; i++) {
			    String final_xpath = ".//*[@id='reports-table']/tbody/tr[1]/td["+ (i) + "]";
			    if(driver.findElement(By.xpath(final_xpath)).getText().contains("BR")){
			    	result = true;
			     }
			   }
			
			return result;
	}

	public boolean getLexileComparedWithnormAtSchoolLevel() {
		 boolean result = false;
	     int rowCount = driver.findElements( By.xpath(".//*[@id='reports-table']/tbody/tr[1]/td")).size();
		   //for loop for Student data in Expected Lexile Growth Report class card
		   for (int i = 1; i <= rowCount; i++) {
		    String final_xpath = ".//*[@id='reports-table']/tbody/tr[1]/td["+ (i) + "]";
		    if(driver.findElement(By.xpath(final_xpath)).getText().contains("BR")){
		    	result = true;
		     }
		   }
		
		return result;
	}
	
	public boolean getLexileReadingProficiencyReport() {
		
		  boolean result = false;
	     int rowCount = driver.findElements( By.xpath(".//reading-prof-detail-table-classes/table/tbody/tr")).size();
		   //for loop for Student data in Expected Lexile Growth Report class card
	     
	     for (int i = 1; i <= rowCount; i++) {
		    String final_xpath = ".//reading-prof-detail-table-classes/table/tbody/tr["+ (i) + "]/td[1]";
		    if(driver.findElement(By.xpath(final_xpath)).getText().contains("BR")){
		    	result = true;
		     }
		   }
		
		return result;
	}

	public boolean getExpectedLexileGrowth() {
		
		  boolean result = false;
	     int rowCount = driver.findElements( By.xpath("//*[@id='reports-table']/tbody/tr")).size();
		   //for loop for Student data in Expected Lexile Growth Report class card
		   for (int i = 1; i <= rowCount; i++) {
		    String final_xpath = "//*[@id='reports-table']/tbody/tr["+ (i) + "]/td[1]";
		    if(driver.findElement(By.xpath(final_xpath)).getText().contains("BR")){
		    	result = true;
		     }
		   }
		
		return result;
	}
	public boolean getExpectedLexileGrowthgradeLevel() {
		
		  boolean result = false;                                                     
	     int rowCount = driver.findElements( By.xpath(".//*[@id='reports-table']/tbody/tr[1]/td")).size();
		   //for loop for Student data in Expected Lexile Growth Report class card
		   for (int i = 1; i <= rowCount; i++) {
		    String final_xpath = "//*[@id='reports-table']/tbody/tr[1]/td["+ (i) + "]";
		    if(driver.findElement(By.xpath(final_xpath)).getText().contains("BR")){
		    	result = true;
		     }
		   }
		
		return result;
	}

	public boolean getHistoryReportcard() {
		boolean result = false;
		 int rowCount = driver.findElements( By.xpath(".//*[@id='reports-table']/tbody/tr[1]/td")).size()-1;
		 String final_xpath = "//*[@id='reports-table']/tbody/tr[1]/td["+ rowCount + "]";
       if(driver.findElement(By.xpath(final_xpath)).getText().contains("BR")){
		    	result = true;
		     }
	return result;
		
	}
	
	public void homepage(){
		hometab.click();
	}
	
	public void ViewAllComment(){
		viewcommentsButton.click();
	}
	
	public List<String> VerifyUserCredentails(){
		lazyWait(2);
		this.switchToNewWindow();
		reportLog("Switched to comments window");
		lazyWait(5);
		ArrayList<String> value = new ArrayList<String>();
		reportLog("Collecting data from comments window");
		value.add(StudentName.getText());
		value.add(StudentGrade.getText());
		value.add(StudentClass.getText());		
		return value;
	}

	public List<String> VerifyUserCredentailsTest(){
		lazyWait(2);
		this.switchToNewWindow();
		reportLog("Switched to comments window");
		lazyWait(5);
		ArrayList<String> value = new ArrayList<String>();
		reportLog("Collecting data from comments window");
		value.add(StudentNameTest.getText().replaceAll("Student: ", ""));
		value.add(StudentGradeTest.getText().replaceAll("Grade: ", ""));
		value.add(StudentClassTest.getText().replaceAll("Class: ", ""));		
		return value;
	}
	
	
	public List<String> VerifyUserCredentailsRRC(){
		lazyWait(2);
		this.switchToNewWindow();
		reportLog("Switched to comments window");
		lazyWait(5);
		ArrayList<String> value = new ArrayList<String>();
		reportLog("Collecting data from comments window");
		value.add(StudentNameRRC.getText().replaceAll("Name: ", ""));
		value.add(StudentGradeRRC.getText().replaceAll("Grade: ", ""));
		value.add(StudentClassRRC.getText().replaceAll("Class: ", ""));		
		return value;
	}

	
	public List<String> SeeMyCommentsTitle(){
		lazyWait(2);
		ArrayList<String> value = new ArrayList<String>();
		reportLog("Collecting title data from comments window");
		int i=driver.findElements(By.xpath("html/body/div[2]/div/strong")).size();
		for(int j=1; j<=i; j++){
			String xpath ="html/body/div[2]/div["+j+"]/strong";
			value.add(driver.findElement(By.xpath(xpath)).getText());		
		}
		return value;
	}
	
	public String VerifyUserComments(){
		String Comment = null;
		reportLog("Verifying the comments in the comment window");
		String expectedtitle = booksObj.getBooktitle();
		reportLog("Verifying the comments for the book "+expectedtitle);
		int count=driver.findElements(By.xpath("html/body/div/div[2]/span")).size();
		for(int i = 3; i<count; i++){
			String xpath="html/body/div["+i+"]/div[2]/span";
			String title=driver.findElement(By.xpath(xpath)).getText();
			if(title.equalsIgnoreCase(expectedtitle)){
				reportLog("I am trying to verify the titles for which comment was put");
				Comment = driver.findElement(By.xpath("html/body/div["+i+"]/div[2]//li")).getText();
				reportLog("The "+expectedtitle+" book has the comments "+Comment);
			}
		}
		return Comment;
	}
	
	public boolean isNotificationDisplayed() {
		boolean flag =false;
	 	flag =this.sync(driver.findElement(By.xpath(".//div[@class='inc-test-alert']"))).getText().contains("did not complete");
	 	return flag;
		
	}

	public String isTestToolTipDisplayed() {
		 this.sync(driver.findElement(By.xpath(".//div[@class='span11']/a/span")));
		Actions builder= new Actions(driver);
		//find the tool tip message xpath
		WebElement tooltip = driver.findElement(By.xpath(".//div[@class='span11']/a/span"));
		
		builder.moveToElement(tooltip).perform();
		//get the text
		String tooltip_message = tooltip.getAttribute("tooltip");
		return tooltip_message;
	

	}

	public boolean isreportDisplayed(String reportname) {
		boolean flag = false;
		lazyWait(5);
		this.sync(driver.findElement(By.xpath(".//*[@id='main-content']//h4")));
		List<WebElement> ele = driver.findElements(By.xpath(".//*[@id='main-content']//h4"));
		for(WebElement rep : ele)
		{
			if(rep.getText().contains(reportname)){
			flag=true;
			break;
			}
		}
		return flag;
		
		
	}

	public String getStudnetData() {
		String lexile =lexileText.getText();
		return lexile;
		
	}
	public boolean printparentletter() {
		printArrow.click();
		if (printParent.isEnabled()) {
			driver.findElement(By.xpath("//*[@id='main-content']/div[2]/div[1]/div[2]/ul/li[2]/a")).click();
			return true;
		}
		
		return false;
	}

	public boolean VerifyStudetDataInParentLetter(String lexile) {
		switchToNewWindow();
		lazyWait(5);
		boolean flag = true;

		if (!(driver.findElement(By.xpath("(.//div[1]/h5)[1]")).getText().contains("Jon Snow"))) {
			flag = false;
		}

		if (!(driver.findElement(By.xpath("(.//div[2]/h5)[1]")).getText().contains("breaking bad"))) {
			flag = false;
		}

		if (!(driver.findElement(By.xpath("(.//div[6]/div)[1]")).getText().contains(lexile))) {
			flag = false;
		}
		if (!(driver.findElement(By.xpath("(.//div[6]/div)[1]")).getText().contains("Tony Stark"))) {
			flag = false;
		}

		return flag;

	}
	Map<String, String> map = util.getMap();
	public boolean VerifyMultipleStudetsDataInParentLetter(String student){
		switchToNewWindow();
		lazyWait(5);
		boolean flag = false;
		System.out.println(student);
		for(int i=1;i<=3;i=i+2){
			System.out.println(driver.findElement(By.xpath("(.//div[1]/h5)["+i+"]")).getText());
			if ((driver.findElement(By.xpath("(.//div[1]/h5)["+i+"]")).getText().trim().contains(student))) {
				 flag = true;
				
			}
			 if(flag)
				 break;
			System.out.println(flag);
			
		}
		assertTrue("'" + student + "' Parent Letter is no correct ", flag);
		for(int i=1;i<=3;i=i+2){
			System.out.println(map); 
			student =student.replace(" ","");
			System.out.println((student+"_Lexile"));
			String Lex = util.getValue((student+"_Lexile"));
			System.out.println(Lex);
			Lex=Lex.replace("-", "BR");
			if ((driver.findElement(By.xpath("(.//div[6]/div)["+i+"]")).getText().contains(Lex))) {
				 flag = true;
				
			}	
			 if(flag)
				 break;
		}
		assertTrue("'" + student + "' Parent Letter is no correct ", flag);
		return flag;
		
	}

	public boolean clickParentLetterForStudents() {
		lazyWait(5);
		driver.findElement(By.xpath("(//*[@id='main-content']/div[2]/div[1]/div[3]/button)[1]")).click();
		if (driver.findElement(By.xpath("//*[@id='main-content']/div[2]/div[1]/div[3]/ul/li[4]")).isEnabled()) {
			driver.findElement(By.xpath("//*[@id='main-content']/div[2]/div[1]/div[3]/ul/li[4]")).click();
			return true;
		}
		
		return false;
		
	}

	public boolean printReadingReportcard() {
		lazyWait(5);
		driver.findElement(By.xpath("(//*[@id='main-content']/div[2]/div[1]/div[3]/button)[1]")).click();
		if (driver.findElement(By.xpath("//*[@id='main-content']/div[2]/div[1]/div[3]/ul/li[2]")).isEnabled()) {
			driver.findElement(By.xpath("//*[@id='main-content']/div[2]/div[1]/div[3]/ul/li[2]")).click();
			return true;
		}
		return false;
		
		
	}

	public boolean VerifyMultipleStudetsDataInReadingReportCardLetter(
			String student) {
		switchToNewWindow();
		lazyWait(5);
		boolean flag = false;
		System.out.println(student);
		String[] name = student.split(" ");
		for (int i = 1; i <= 2; i = i++) {
			if ((driver
					.findElement(By.xpath(".//body/div[" + i + "]div[2]/span"))
					.getText().trim().contains(name[0]))) {
				flag = true;
			}
			if (flag)
				break;
			System.out.println(flag);

		}
		assertTrue("'" + student + "' Reading Report Letter is no correct ",
				flag);
		for (int i = 1; i <= 2; i = i++) {
			student = student.replace(" ", "");
			String Lex = util.getValue((student + "_Lexile"));
			Lex = Lex.replace("-", "BR");
			if ((driver.findElement(
					By.xpath("//body/div[" + i
							+ "]/div[6]/div[3]/div/div[2]/span")).getText()
					.contains(Lex))) {
				flag = true;

			}
			if (flag)
				break;

		}
		assertTrue("'" + student + "' Reading Report Letter is no correct ",
				flag);
		for (int i = 1; i <= 2; i = i++) {
			String Lex = util.getValue((student + "_LexileGrowth"));
			if ((driver.findElement(
					By.xpath("//body/div[" + i
							+ "]/div[6]/div[4]/div/div[2]/span")).getText()
					.contains(Lex))) {
				flag = true;
			}
			if (flag)
				break;
		}
		assertTrue("'" + student + "' Reading Report Letter is no correct ",
				flag);

		for (int i = 1; i <= 2; i = i++) {
			String Lex = util.getValue((student + "_LastCompDate"));
			if ((driver.findElement(
					By.xpath("//body/div[" + i
							+ "]/div[6]/div[5]/div/div[2]/span")).getText()
					.contains(Lex))) {
				flag = true;
			}
			if (flag)
				break;
		}
		assertTrue("'" + student + "' Reading Report Letter is no correct ",
				flag);

		for (int i = 1; i <= 2; i = i++) {
			String Lex = util.getValue((student + "_ProficiencyBand"));
			if ((driver.findElement(
					By.xpath("//div[" + i + "]/div[6]/div[6]/div/div[2]/span"))
					.getText().contains(Lex))) {
				flag = true;
			}
			if (flag)
				break;
		}
		assertTrue("'" + student + "' Reading Report Letter is no correct ",
				flag);
		for (int i = 1; i <= 2; i = i++) {
			String Lex = util.getValue((student + "_CertificateLevel"));
			if ((driver.findElement(
					By.xpath("//div[" + i
							+ "]/div[6]/div[7]/div/div[2]/div/span")).getText()
					.contains(Lex))) {
				flag = true;
			}
			if (flag)
				break;
		}
		assertTrue("'" + student + "' Reading Report Letter is no correct ",
				flag);

		for (int i = 1; i <= 2; i = i++) {
			String Lex = util.getValue((student + "_QuizzesPassedAttempted"));
			if ((driver.findElement(
					By.xpath("//div[" + i + "]/div[6]/div[8]/div/div[2]/span"))
					.getText().contains(Lex))) {
				flag = true;
			}
			if (flag)
				break;
		}
		assertTrue("'" + student + "' Reading Report Letter is no correct ",
				flag);
		for (int i = 1; i <= 2; i = i++) {
			String Lex = util.getValue((student + "_AverageQuizScore"));
			if ((driver.findElement(
					By.xpath("//div[" + i + "]/div[6]/div[9]/div/div[2]/span"))
					.getText().contains(Lex))) {
				flag = true;
			}
			if (flag)
				break;
		}
		assertTrue("'" + student + "' Reading Report Letter is no correct ",
				flag);

		for (int i = 1; i <= 2; i = i++) {
			String Lex = util.getValue((student + "_AverageQuizScore"));
			if ((driver.findElement(
					By.xpath("//div[" + i + "]/div[6]/div[9]/div/div[2]/span"))
					.getText().contains(Lex))) {
				flag = true;
			}
			if (flag)
				break;
		}
		assertTrue("'" + student + "' Reading Report Letter is no correct ",
				flag);

		return flag;

	}
	
	
	
	
	public boolean CurrentSchoolYear(){
		int size=driver.findElements(By.xpath(".//*[@id='reports-table']/tbody/tr/th")).size();
		boolean result=false;
		int count=0;
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		int year = now.get(Calendar.YEAR);
		
		for (int i=1; i<=size; i++){
			String xpath=".//*[@id='reports-table']/tbody/tr["+i+"]/th";
			String reprotyear = driver.findElement(By.xpath(xpath)).getText();
			String[] years=reprotyear.split(" ");
			if(Integer.parseInt(years[2])==(year) || Integer.parseInt(years[2])==(year-1)){
				count=count+1;
			}
		}
		
		if(count==size){
			result=true;
		}
		return result;
	}
	
	public void Yearselect(String Year){
		String xpath = "(//a[contains(text(),'"+Year+"')])[2]";
		YearDropDown.click();
		reportLog("Clicked on school calendar year dropdown");
		driver.findElement(By.xpath(xpath)).click();
		reportLog("Selected school year "+Year+" from the calendar dropdown");
	}

	public boolean AllSchoolYear(){
		int size=driver.findElements(By.xpath(".//*[@id='reports-table']/tbody/tr/th")).size();
		boolean result=false;
		int count=0;
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		int year = now.get(Calendar.YEAR);
		lazyWait(3);
		for (int i=1; i<=size; i++){
			String xpath=".//*[@id='reports-table']/tbody/tr["+i+"]/th";
			String reprotyear = driver.findElement(By.xpath(xpath)).getText();
			String[] years=reprotyear.split(" ");
			//years[2] is table school year
			//year is the current year
			//I am comparing and if the data shown is less then current year then it is assume that it is shown data of all the school years
			if((Integer.parseInt(years[2])==(year) || Integer.parseInt(years[2])==(year-1)) && (Integer.parseInt(years[2])<(year-1))){
				result=true;
			}
		}
		return result;
	}
	
	public void printoption(){
		PrintOption.click();
	}
	
	public void PrintStudentTest(){
		lazyWait(2);
		PrintStudentTest.click();
	}
	
	public void PrintReadingReportCard(){
		lazyWait(2);
		PrintReadingReportCard.click();
	}
	
	@FindBy(xpath = ".//a[contains(text(), 'Print Reading Report Card')]")
	private WebElement PrintReadingReportCard;
	
	public boolean VerifyLitproLogo(){
		boolean result=false;
		if(LiproLogo.isDisplayed()){
			reportLog("Litpro logo verified");
			result=true;
		}
		return result;
	}

	public boolean PrintTestReport(){
		String Questions;
		String passage;
		String PrintTestQuestions;
		String PrintTestanswer;
		int count;
		int counts = 0;
		boolean result=false;
		String actualAnswer;
		count = driver.findElements(By.xpath("//li/span")).size();
		for(int i=1; i<=count; i++){
			String xpathQ="//li["+i+"]/span";
			String xpathA="//li["+i+"]/p";
			String panswerXpath = "((//li//ul)["+i+"]";
			String pselectedAnswerXpath= "(//li//ul)["+i+"]//div[@class='choice leftAlignDiv ng-binding roundBorder']";
			
			String PselectedAnsText= driver.findElement(By.xpath(pselectedAnswerXpath)).getText();
			String Pfirstanswer = driver.findElement(By.xpath(panswerXpath+"//div[@ng-class='{roundBorder: questionObj.studentAnsDisplay === $index}'])[1]")).getText();
			String PSecondanswer = driver.findElement(By.xpath(panswerXpath+"//div[@ng-class='{roundBorder: questionObj.studentAnsDisplay === $index}'])[2]")).getText();
			String PThirdanswer = driver.findElement(By.xpath(panswerXpath+"//div[@ng-class='{roundBorder: questionObj.studentAnsDisplay === $index}'])[3]")).getText();
			String Pfourthanswer = driver.findElement(By.xpath(panswerXpath+"//div[@ng-class='{roundBorder: questionObj.studentAnsDisplay === $index}'])[4]")).getText();
			passage = driver.findElement(By.xpath(xpathQ)).getText();
			Questions= driver.findElement(By.xpath(xpathA)).getText().replaceAll("_", "");;
			PrintTestQuestions= "Passage :"+passage+"Questions :"+Questions;
			
			String pselectedAnswer=" Answer "+PselectedAnsText;
			PrintTestanswer=Pfirstanswer+","+PSecondanswer+","+PThirdanswer+","+Pfourthanswer+","+pselectedAnswer;
			//System.out.println("*******"+PrintTestQuestions);
			actualAnswer = util.getValue(PrintTestQuestions);
			if(PrintTestanswer.equalsIgnoreCase(actualAnswer)){
				counts = counts+1;
			}
			if(!PrintTestanswer.equalsIgnoreCase(actualAnswer)){
				System.out.println("Actual :"+ actualAnswer);
				System.out.println("Expected :"+ PrintTestanswer);
			}
		}
		reportLog("Expected number of questions : "+count);
		reportLog("Actual number of questions : "+counts);
		
		if(counts==count){
			result=true;
		}
		return result;
	}

	public HashMap<String, String> DataCollectionStudentRRC(String repName){
		searchSmartbar(repName);
		String[] student = FirstTestLexile();
		util.add(lexileLabel.getText(), lexileText.getText());
		util.add(LexileGrowthLabel.getText(), LexileGrowthText.getText());
		util.add(lastcompletedLabel.getText(), lastcompdateText.getText());
		util.add(proficiencyLabel.getText(), proficiencyText.getText());
		util.add(certificateLabel.getText(), certificateText.getText());
		util.add(quizpaLabel.getText(), quizpaText.getText());
		util.add(avgscoreLabel.getText(), avgscoreText.getText());
		util.add(quizpaLabel.getText(), quizpaText.getText());
		util.add(wordsreadLabel.getText(), wordsreadText.getText());
		util.add(ptsearnedLabel.getText(), ptsearnedText.getText());
		util.add(teacherptsLabel.getText(), teacherptsText.getText());		
		return hmap;
	}
	
	public void ValidateReadingReportCard(String Studentname){
		System.out.println("^^^^^^^^^^^^^^^^^^"+util.getValue(lexileLabel.getText()));
		if(util.getValue(lexileLabel.getText()).equalsIgnoreCase(lexileText.getText())){
			
		}
	}
	
	public void CustomRange(String DateRange) {
		SetCustomRange.click();
		reportLog("Clicked on set Custome date range dropdown ");
	}
	
	public Boolean VerfycalenderMonth() throws ParseException{
		boolean result= false;
		String UIcurrentmonth = CalenderRightmonth.getText();
		String UIPrevmonth = CalenderLeftmonth.getText();
		reportLog("Getting current the calender month");
		System.out.println(CalMonth(0)+"-----------"+CalMonth(1));
		if(UIcurrentmonth.equalsIgnoreCase(CalMonth(0)) && UIPrevmonth.equalsIgnoreCase(CalMonth(1))){
			reportLog("Actual current month "+CalMonth(0));
			reportLog("Expected current month "+UIcurrentmonth);
			
			reportLog("Actual previous month "+CalMonth(1));
			reportLog("Expected previous month "+UIPrevmonth);
			result= true;
		}
		return result;
	}
	
	public String CalMonth(int i){
		DateFormat dateFormat = new SimpleDateFormat("MMM YYYY");
		Date current = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(current);
		cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)-i));
		current = cal.getTime();
		return dateFormat.format(current);
	}
	
	public Boolean LeftArrowcalender(){
		boolean result=false;
		int count=2;
		for(int i=1; i<=count; i++){
			LeftArrow.click();
			lazyWait(1);
		}
		String UIPrevmonth = CalenderLeftmonth.getText();
		String ExpCurrentMonth = CalMonth(count+1);
		reportLog("Expected Current month is "+UIPrevmonth);
		reportLog("Actual Current month is "+ExpCurrentMonth);
		if(UIPrevmonth.equalsIgnoreCase(ExpCurrentMonth)){
			result=true;
		}
		return result;
	}

	public Boolean RightArrowcalender(){
		boolean result=false;
		int count=2;
		for(int i=1; i<=count; i++){
			RightArrow.click();
			lazyWait(1);
		}
		String UIPrevmonth = CalenderRightmonth.getText();
		String ExpCurrentMonth = CalMonth(-(count));
		reportLog("Expected Current month is "+UIPrevmonth);
		reportLog("Actual Current month is "+ExpCurrentMonth);
		if(UIPrevmonth.equalsIgnoreCase(ExpCurrentMonth)){
			result=true;
		}
		return result;
	}
	
	public void CalenderCancelBtn(){
		CancelButton.click();
		reportLog("Clicked on the cancel button");
	}
	
	public boolean VerifyBtnName(){
		boolean result = false;
		String StrDatepicker=StartDatepicker.getAttribute("value");
		reportLog("Collecting the start date range");
		String EndDatepickers=EndDatepicker.getAttribute("value");
		reportLog("Collecting the End date range");
		String BtnText = StrDatepicker+" - " + EndDatepickers;
		ApplyButton.click();
		reportLog("Clicked on the apply button");
		lazyWait(2);
		String xpath="(//span[contains(text(),'"+BtnText+"')])[2]";
		int i=driver.findElements(By.xpath(xpath)).size();
		if(i>0){
			result = true;
			reportLog("Text of dropdown button changed as expected.");
		}		
		return result;
	}
	
	public void CrossBtn(){
		Xbutton.click();
		reportLog("Clicked on X button");
	}
	
	public boolean calendartraycollapse(){
		lazyWait(5);
		return !(ApplyButton.isDisplayed());
	}
	
	public boolean calendarName(String SchoolYear){
		boolean result=false;
		String ActualSchoolYear = YearDropName.getText();
		reportLog("Actual button name :- "+ActualSchoolYear);
		reportLog("Expected button name :- "+SchoolYear);
		if(ActualSchoolYear.contains(SchoolYear)){
			result=true;
		}
		return result;
	}
	
	public void SelectAnydate(){
		driver.findElement(By.xpath("//div[@class='calendar left']//tr[2]/td[6]")).click();
	}
	
	public boolean Moredays365(){
		boolean result=false;
		int count=13;
		for(int i=1; i<=count; i++){
			RightArrow.click();
			lazyWait(1);
		}
		String text = driver.findElement(By.xpath("//div[@class='calendar left']//tr[2]/td[6]")).getAttribute("class");
		System.out.println("*****"+text);
		if(text.contains("off disabled")){
			result=true;
		}
		return result;
	}
	
	@FindBy(xpath = "(//i[@class='dateclose'])[11]")
	WebElement Xbutton;
	
	@FindBy(xpath = "//div[contains(@class, 'modal-body')]/div[3]//span")
	WebElement YearDropName;	
	
	@FindBy(xpath = "//div[contains(@class, 'daterangepicker dropdown-menu ltr show-calendar opensright') and contains(@style, 'top: 1691.25px; left: 837.083px; right: auto; display: block;')]")
	WebElement CalenderTray;			
	
	@FindBy(xpath = "(//input[@name='daterangepicker_end'])[4]")
	WebElement EndDatepicker;
			
	@FindBy(xpath = "(//input[@name='daterangepicker_start'])[4]")
	WebElement StartDatepicker;
			
	@FindBy(xpath = "(//button[contains(text(), 'Apply')])[4]")
	WebElement ApplyButton;
			
	@FindBy(xpath = "(//button[contains(text(), 'Cancel')])[4]")
	WebElement CancelButton;
	
	@FindBy(xpath = "//i[@class='fa fa-chevron-right glyphicon glyphicon-chevron-right']")
	WebElement RightArrow;
	
	@FindBy(xpath = "//i[@class='fa fa-chevron-left glyphicon glyphicon-chevron-left']")
	WebElement LeftArrow;
	
	@FindBy(xpath = "//div[@class='calendar right']//tr[1]/th[2]")
	WebElement CalenderRightmonth;
	
	@FindBy(xpath = "//div[@class='calendar left']//tr[1]/th[2]")
	WebElement CalenderLeftmonth;
	
	@FindBy(xpath = "//div[contains(@class, 'modal-body')]/div[3]//i[contains(@class, 'btn-dwnarrow')]/parent::button/parent::div//input[@placeholder='Set Custom Range']")
	WebElement SetCustomRange;
}