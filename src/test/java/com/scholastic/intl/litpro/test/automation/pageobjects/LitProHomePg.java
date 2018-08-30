package com.scholastic.intl.litpro.test.automation.pageobjects;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.scholastic.intl.litpro.test.automation.keys.Keys.LPHomePageLocators;
import com.scholastic.torque.common.AssertUtils;
import com.scholastic.torque.common.WaitUtils;
import com.scholastic.torque.webdriver.ExtendedElement;

public class LitProHomePg extends ParentPage implements LPHomePageLocators{
	WebDriver driver;
	WebElement categoryElement;

	final String PAGE_TITLE = "Scholastic Literacy Pro";

	public static enum LitProUserType {
		SCHOOL_ADMIN, STUDENT, CS_REP, TEACHER
	};

	private LitProUserType lpUserType;

	@FindBy(xpath="//div[contains(text(),'Welcome,')]")
	private WebElement greetText;

	@FindBy(id = "navigation")
	private WebElement adminNavigationBar;

	@FindBy(xpath = "//div[div[@id='myResults']]")
	private WebElement studNavigationBar;

	@FindBy(xpath = "//a[contains(@href,'inlibrary')]")
	private WebElement inLibLink;

	@FindBy(xpath = "//a[span[contains(text(),'Search')]]")
	private WebElement searchTab;

	@FindBy(xpath = "//a[span[contains(text(),'Home')]]")
	private WebElement homeTab;

	@FindBy(xpath = "//a[span[contains(text(),'Settings')]]")
	private WebElement settingsTab;

	@FindBy(xpath = "//a[span[contains(text(),'LitPro Test')]]")
	private WebElement takeTesTab;

	@FindBy(xpath = "//a[span[contains(text(),'Reports')]]")
	private WebElement reportsTab;

	// @FindBy(xpath = "//a[span[contains(text(),'My Results')]]")
	@FindBy(xpath = "//*[@id='myResults']/a/span")
	private WebElement myResultsTab;

	@FindBy(xpath = "//a[span[contains(text(),'Benchmarks')]]")
	private WebElement benchmarksTab;

	@FindBy(id = "takeTest")
	private WebElement takeTestDiv;

	@FindBy(xpath = "//div[@id='educatorHome']//h2")
	private WebElement educatorPgHeader;

	@FindBy(xpath = "//button[contains(text(),'Edit Reading Interests')]")
	private WebElement editReadingInterests;

	@FindBy(xpath = "//div/div[contains(text(),'Choose up to three reading interests:')]")
	private WebElement modalHeader;

	@FindBy(xpath = "//button[contains(text(),'Update My Reading List')]")
	private WebElement updateMyReadingList;

	@FindBy(xpath = "//div/div[contains(text(),'What do you like to read? Choose up to three kinds of books.')]")
	private WebElement createRLHeader;

	@FindBy(xpath = "//div/div[contains(text(), 'Here are some great books to read!')]")
	private WebElement rLResultsHeader;

	@FindBy(xpath = "//button[contains(text(),'Create My Reading List')]")
	private WebElement createMyReadingList;

	@FindBy(xpath = "//button[contains(text(),'Fast Find')]")
	private WebElement fastFindButton;

	@FindBy(xpath = "//button[contains(text(),'New')]")
	private WebElement whatsNewButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	private WebElement logoutLink;

	@FindBy(xpath = "(.//*[@value='Take the Quiz'])[1]")
	private WebElement topquizButton;

	@FindBy(xpath = "//*[@id='readingList']")
	private WebElement Student_readinglist;

	@FindBy(xpath = "//*[@id='takeTest']/a")
	private WebElement LitProTestTab;

	@FindBy(xpath = "//*[@id='readingList']/div[2]")
	private WebElement ReadingListAlreadyCreated;

	@FindBy(xpath = "//*[@id='readingList']/div[2]/div[3]/div[2]/div/button[2]")
	private WebElement ListViewReadingList;

	@FindBy(xpath = "//*[@id='readingList']/div[2]/div[2]/div/button")
	private WebElement editReadingInterestsButton;

	@FindBy(xpath = "//button[@class='btn admin-button btn-large print ng-scope ng-binding']")
	private WebElement PrintbuttonHometab;

	@FindBy(xpath = "//button[@class='btn admin-button btn-large ng-scope ng-binding']")
	private WebElement PrintButtonSearchTab;

	@FindBy(xpath = "//*[@id='takeTest' and @class='span3 navlink navlink-test div-enable']/a")
	private WebElement LitProTestTabEnable;

	@FindBy(xpath = "//*[@id='takeTest' and @class='span3 navlink navlink-test div-disable']/a")
	private WebElement LitProTestTabdisable;

	@FindBy(xpath = "//*[@id='myResults']/a")
	private WebElement Myresulttab;

	@FindBy(xpath = "//*[@id='takeQuiz']/a/span")
	private WebElement Searchtab;

	@FindBy(xpath = "//*[@id='student-search-form']//div[1]/input")
	private WebElement Searchbox;

	@FindBy(xpath = "//*[@id='student-search-form']//div[1]/button")
	private WebElement Searchbutton;

	@FindBy(xpath = "//*[@id='srcQuiz']//div[1]/div[2]/button")
	private WebElement PrinButtonSearchButton;

	@FindBy(xpath = "//*[@id='results']//div[2]/button[1]")
	private WebElement PrinButtonMyresultButton;

	@FindBy(xpath = "//*[@id='results']//div[2]//li[3]/button")
	private WebElement PrintCommentsMyresultButton;

	@FindBy(xpath = "//*[@id='results']//div[2]//li[3]/button")
	private WebElement PrintAwardsMyresultButton;

	@FindBy(xpath = "//*[@id='results']//div[2]//li[3]/button")
	private WebElement PrintactivitiesMyresultButton;

	@FindBy(xpath = "//ul[@class='dropdown-menu ng-scope']/li/a")
	private WebElement helpdropdowntexts;

	@FindBy(css = ".img-grn-help.blue-hover.header-img")
	private WebElement helpIcon;
	
	

	public LitProHomePg(WebDriver driver, LitProUserType userType) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.lpUserType = userType;
		this.waitForPageLoad(DRIVER_WAIT);
		// this.getNotificationText();
	}

	public LitProHomePg(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		// this.lpUserType = userType;
		this.waitForPageLoad(DRIVER_WAIT);
		// this.getNotificationText();
	}

	public String getExpectedTitle() {
		return PAGE_TITLE;
	}

	public String getUserGreetingText(){
		String rStr = null;
		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			rStr = this.getElement(By.xpath("//span[contains(text(),'Welcome,')]")).getText();
		} else if (lpUserType == LitProUserType.STUDENT) {
		rStr = this.getElement(By.xpath("//div[contains(text(),'Welcome,')]")).getText();
		}
		this.reportLog("Home Page Greeting text: " + rStr);
		return rStr;
	}

	/* returns comma separated tab names */
	public List<String> getDisplayedTabNames() {
		List<String> tabs = null;
		List<WebElement> tabList = null;
		System.out.println(lpUserType);
		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			tabList = this.getChildElements(adminNavigationBar,
					By.xpath(".//div"));
		} else if (lpUserType == LitProUserType.STUDENT) {
			tabList = this.getChildElements(studNavigationBar,
					By.xpath(".//div//span"));
		}
				if (tabList.size() > 0) {
			tabs = new ArrayList<String>();
			for (WebElement tab : tabList) {
				String tabName = this.getText(tab);
				System.out.println(tabName);
				if (!(tabName.isEmpty()) && (tabName != null))
					tabs.add(tabName);
			}
		}
		System.out.println("tabs value is: "+tabs);
		return tabs;
	}

	public boolean isLogoutLinkPresent() {
		return this.isVisible(logoutLink);
	}

	public InLibraryPg goToInLibraryPage() {
		this.click(this.inLibLink);
		return new InLibraryPg(driver, lpUserType);
	}

	public SearchPg goToSeachPage() {
		this.reportLog("Goto Search Page");
		this.click(this.searchTab);
		System.out.println(lpUserType +"@inside page");
		return new SearchPg(driver, lpUserType);
		
	}

	public SettingsPg goToSettingPage() {
		this.reportLog("Goto Settings Page");
		this.click(this.settingsTab);
		return new SettingsPg(driver, lpUserType);
	}

	public TestPg goToTakeTestPage() {
		this.reportLog("Goto Take Test Page");
		if (!this.getAttribute(takeTestDiv, "class").contains("disable")) {
			this.click(this.takeTesTab);
			return new TestPg(driver, lpUserType);
		}
		return null;
	}

	public ReportsPg goToReportsPage() {
		this.reportLog("Goto Reports Page");
		this.click(this.reportsTab);
		return new ReportsPg(driver, lpUserType);
	}

	public MyResultsPg goToMyResultsPage() {
		this.reportLog("Goto My Results Page");
		this.click(this.myResultsTab);
		return new MyResultsPg(driver, lpUserType);
	}

	public void clickMyResults() throws InterruptedException {
		myResultsTab.click();
		Thread.sleep(5000);
	}

	public BenchmarkPg goToBenchmarksPage() {
		this.reportLog("Goto Benchmark Page");
		this.click(this.benchmarksTab);
		return new BenchmarkPg(driver, lpUserType);
	}

	public void goToHomePage() {
		this.reportLog("Goto LitPro Home Page");
		this.click(this.homeTab);
	}

	public void switchDriverToHomePg() {
		driver.switchTo().window(this.getWindowHandle());
		this.reportLog("Driver switched to LitPro Home Page - "
				+ this.getWindowHandle());
	}

	public String getMetricValue(String metricName) {
		String xpathString = "//div[@id='metrics']/div[div/span[text()='"
				+ metricName + "']]//div[contains(@class,'metric-number')]";
		WebElement metricBox = this.getElement(By.xpath(xpathString));
		if (metricBox != null) {
			this.reportLog(metricName + " Value: ");
			return metricBox.getText();
		}
		return "";
	}

	public String getNotificationText() {
		WebElement we = this
				.getElement(
						By.xpath("//div[contains(@class,'dr-notification-wrapper')][1]//h3"),
						10);
		String text = "";
		if (we != null) {
			text = this.getText(we);
			this.reportLog("Notification: " + text);
			return text;
		}
		this.reportLog("No Notification Displayed");
		return text;
	}

	public String checkNotifcation() {
		this.settingsTab.click();
		this.getNotificationText();
		this.homeTab.click();
		this.getNotificationText();
		this.searchTab.click();
		this.getNotificationText();
		return "";
	}

	public String getHeader() {
		return this.getText(educatorPgHeader).trim();
	}

	/* Click on edit reading interests button */
	public void editReadingInterests() {
		this.reportLog("Click Edit Reading Interests Button");
		this.click(this.editReadingInterests);
	}

	/* Check if the Modal opened and the header is displayed */
	public String getModalHeader() {
		String header = this.getText(modalHeader);
		this.reportLog("Modal Header: " + header);
		return header;
	}

	/* checks if all the reading interest categories are displayed */
	public boolean isReadingInterestCategoryExist(String categoryName) {
		boolean flag = false;
		String controlXpath = "//div[@class='iconGrid']//div[p[text()='"
				+ categoryName + "']]"; // Example
										// xpath:
										// //div[@class='iconGrid']//div[p[text()='Humour']]
		By by = By.xpath(controlXpath);
		categoryElement = this.getElement(by);

		if (categoryElement != null) {
			flag = true;
			this.reportLog("Reading Interest Category: '" + categoryName
					+ "' Displayed");
		} else {
			this.reportLog("Reading Interest Category: '" + categoryName
					+ "' NOT Displayed");
		}
		return flag;
	}

	/*
	 * Get the selected Reading interest categories' names and deselect the same
	 */
	public void deselectInterestCats() {
		String isSelectedXpath = "//div[div[contains(text(),'Choose up to three reading interests:')]]//div[@class='iconGrid']/div[p[@class='iconLabel-true']]";
		List<WebElement> infoTextElement = this.getElements(By
				.xpath(isSelectedXpath));
		for (WebElement e : infoTextElement) {
			this.reportLog("" + this.getText(e));
			this.click(e);
		}
	}

	/* Select different interest categories */
	public boolean selectReadingInterest(String categoryName) {
		String controlXpath = "//div[div[contains(text(),'Choose up to three reading interests:')]]//div[@class='iconGrid']//div[p[text()='"
				+ categoryName + "']]";
		By by = By.xpath(controlXpath);
		categoryElement = this.getElement(by);
		if (categoryElement != null) {
			categoryElement.click();
			return true;
		}
		return false;
	}

	public void clickUpdateReadingIntBtn() {
		this.reportLog("Click on Update My Reading List Button");
		//this.click(this.updateMyReadingList);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",updateMyReadingList);
	}

	public boolean isSelectedCategoryDisplayed(String categoryName) {
		boolean flag = false;
		String displayedXpath = "//div[contains(@class,'selectedInterestsView')]/div[p[text()='"
				+ categoryName + "']]";
		By by = By.xpath(displayedXpath);
		categoryElement = this.getElement(by);
		if (categoryElement != null) {
			flag = true;
			this.reportLog("Selected Reading Interest Category: '"
					+ categoryName + "' Displayed");
		} else {
			this.reportLog("Selected Reading Interest Category: '"
					+ categoryName + "' NOT Displayed");
		}
		return flag;
	}

	/* Check if the header is displayed on the homepage */
	public String getCreateReadingListHeader() {
		String header = "";
		WebElement headerWe = this
				.getElement(By
						.xpath("//div/div[contains(text(),'What do you like to read? Choose up to three kinds of books.')]"));
		if (headerWe != null) {
			// header = this.getText(headerWe);
			header = headerWe.getText();
			this.reportLog("Create My reading list Header: " + header);
			return header;
		}
		return header;
	}

	/* Select different interest categories */
	public boolean selectInterestCategories(String categoryName) {
		String controlXpath = "//div[@class='iconGrid']//div[p[text()='"
				+ categoryName + "']]";
		By by = By.xpath(controlXpath);
		categoryElement = this.getElement(by);
		if (categoryElement != null) {
			categoryElement.click();
			return true;
		}
		return false;
	}

	/* Click on create my reading list button */
	public void clickCreateReadingIntBtn() {
		this.reportLog("Click on Create My Reading List Button");
		this.click(this.createMyReadingList);
	}

	/* Reading the selected reading interests */
	public List<String> getReadingInterestsSelected() {
		// String categoryName = "";
		List<String> icList = new ArrayList<String>();
		List<WebElement> interestCategory = getDriver().findElements(By
						.xpath("//div[@class='selectedInterestsView iconGrid']/div[contains(@class, 'iconFrame')]"));

		for (WebElement e : interestCategory) {
			String cat = this.getText(e);
			this.reportLog("Selected Reading Interest Categories: " + cat);
			icList.add(cat);
		}
		return icList;
	}

	public String getCategoryResultsHeader() {
		String header = this.getText(rLResultsHeader);
		this.reportLog("Reading Interests results header: " + header);
		return header;
	}

	/*
	 * Reading Title, Author and categories of the displayed books using the
	 * POJO
	 */
	public List<VerifyReadingInterestsList> getBooksReadingInterests() {
		List<VerifyReadingInterestsList> bookInterestCategory = new ArrayList<VerifyReadingInterestsList>();
		List<WebElement> books = this
				.getElements(By
						.xpath("//div[@id='rlist']/div[contains(@class, 'bookRecItem')]"));
		this.reportLog(books.size() + " Books Displayed(Reading Interests)");

		Iterator<WebElement> iterBooks = books.iterator();
		int i = 0;

		while (iterBooks.hasNext() && i <= 5 && books.size() >= i) {
			VerifyReadingInterestsList newBook = new VerifyReadingInterestsList();
			WebElement book = iterBooks.next();

			/* Get Book title */
			WebElement bookTitle = this.getChildElement(book,
					By.xpath(".//div[contains(@class, 'title')]"));
			if (bookTitle != null) {
				newBook.title = this.getText(bookTitle);
			}

			/* Get Author name */
			WebElement bookAuthor = this.getChildElement(book,
					By.xpath(".//div[contains(@class, 'authors')]"));
			if (bookAuthor!= null) {
				newBook.author = this.getText(bookAuthor);
			}
			

			/* Get Categories */
			List<WebElement> bookCategories = this.getChildElements(book,
					By.xpath(".//p[contains(@class,'iconLabel')]"));

			if (!bookCategories.isEmpty()) {
				for (WebElement ele : bookCategories) {
					String categoryName = this.getText(ele);
					newBook.categories += (newBook.categories.length() > 0) ? ","
							+ categoryName
							: categoryName;
				}
			}
			
			this.reportLog(newBook.toString());
			bookInterestCategory.add(newBook);
			i++;
		}

		/*
		 * for(WebElement book : books){ if(i!=5){ VerifyReadingInterestsList
		 * newBook = new VerifyReadingInterestsList();
		 * 
		 * Get Book title WebElement bookTitle = this.getChildElement(book,
		 * By.xpath(".//div[contains(@class, 'title')]")); if(bookTitle!=null){
		 * newBook.title = this.getText(bookTitle); }
		 * 
		 * Get Author name WebElement bookAuthor = this.getChildElement(book,
		 * By.xpath(".//div[contains(@class, 'authors')]")); newBook.author =
		 * this.getText(bookAuthor);
		 * 
		 * 
		 * Get Categories List<WebElement> bookCategories =
		 * this.getChildElements(book,
		 * By.xpath(".//p[contains(@class,'iconLabel')]"));
		 * 
		 * if(!bookCategories.isEmpty()){ for(WebElement ele : bookCategories){
		 * String categoryName = this.getText(ele);
		 * newBook.categories+=(newBook.
		 * categories.length()>0)?","+categoryName:categoryName; } }
		 * this.reportLog(newBook.toString());
		 * bookInterestCategory.add(newBook); i++;
		 * 
		 * } }
		 */

		return bookInterestCategory;
	}

	/* Click on Fast find button */
	public void clickFastFindButton() {
		this.reportLog("Click on Fast Find Button");
		this.click(this.fastFindButton);
	}

	/* Click on What's New button */
	public void clickWhatsNewButton() {
		this.reportLog("Click on What's New button");
		this.click(this.whatsNewButton);
	}

	/* POJO for storing the book categories */
	public class VerifyReadingInterestsList {
		public String title = "";
		public String author = "";
		public String categories = ""; // comma separated
		

		@Override
		public String toString() {
			return "{BookTitle:" + title + ", Author:" + author
					+ ", Categories:" + categories + "}";
		}
	}

	public boolean quizzes_visible() {
		if (this.topquizButton.isDisplayed()) {
			this.reportLog("Quizzes are visible on student page");
			return true;
		}

		else {
			this.reportLog("Quizzes not visible on student page");
			return false;
		}

	}

	public boolean quizzes_disabled() {
		if (!this.topquizButton.isEnabled()) {
			this.reportLog("Quizzes DISABLED on student page");
			return true;
		} else {
			this.reportLog("Quizzes ENABLED on student page");
			return false;
		}

	}

	public boolean quizzes_enabled() {
		if (this.topquizButton.isEnabled()) {
			this.reportLog("Quizzes ENABLED on student page");
			return true;
		} else {
			this.reportLog("Quizzes DISABLED on student page");
			return false;
		}

	}

	public String getLexileScore() {
		WebElement we = this
				.getElement(
						By.xpath(".//*[@id='readingList']/div[1]/div[1]/div[2]/div/p[2]"),
						3);
		String text = "";
		if (we != null) {
			text = this.getText(we);
			this.reportLog("My lexile: " + text);
			return text;
		}
		this.reportLog("No Lexile Displayed");
		return text;
	}

	public void clickOnAlertReport() {
		// TODO Auto-generated method stub

	}

	/****************************************************************************/

	public boolean readinglistDisplayed() {
		try {
			Student_readinglist.isDisplayed();
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public boolean LitProTesttabEnabled() {
		try {
			LitProTestTabEnable.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean LitProTesttabdisabled() {
		try {
			LitProTestTabdisable.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean ReadingLlistAlreadyCreated() {
		if (ReadingListAlreadyCreated.isDisplayed()) {
			return true;
		} else {
			clickCreateReadingIntBtn();
			return true;
		}
	}

	public boolean BooksWithQuizzes() throws InterruptedException {
		ListViewReadingList.click();
		this.reportLog("Reading list is created");
		scrolldownTillEnd();
		int flag = 0;

		List<WebElement> NumberOfBooks = this.getElements(By
				.xpath("//*[@id='readingList']/div[2]/div[5]/table/tbody/tr"));
		this.reportLog("Number of books in the reading list "
				+ NumberOfBooks.size());

		for (int i = 1; i < NumberOfBooks.size(); i++) {
			WebElement Quizbutton = this
					.getElement(By
							.xpath("//*[@id='readingList']/div[2]/div[5]/table/tbody/tr["
									+ i + "]/td[6]/div/input"));
			// System.out.println(Quizbutton.getAttribute("value").equalsIgnoreCase("Take
			// the Quiz"));
			if (Quizbutton != null) {
				flag = 1;
			} else {
				flag = 0;
				break;
			}
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean BooksWithInlibIcons() throws InterruptedException {
		ListViewReadingList.click();
		this.reportLog("Reading list is created");
		int flag = 0;

		scrolldownTillEnd();

		List<WebElement> NumberOfBooks = this.getElements(By
				.xpath("//*[@id='readingList']/div[2]/div[5]/table/tbody/tr"));
		this.reportLog("Number of books in the reading list "
				+ NumberOfBooks.size());

		for (int i = 1; i < NumberOfBooks.size(); i++) {
			WebElement InlibIcon = this
					.getElement(By
							.xpath("//*[@id='readingList']/div[2]/div[5]/table/tbody/tr["
									+ i + "]/td[1]/img"));
			if (InlibIcon != null) {
				flag = 1;
			} else {
				flag = 0;
				break;
			}
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean TenbooksInReadingList() throws InterruptedException {
		ListViewReadingList.click();
		this.reportLog("Reading list is created");

		scrolldownTillEnd();

		List<WebElement> NumberOfBooks = this.getElements(By
				.xpath("//*[@id='readingList']/div[2]/div[5]/table/tbody/tr"));
		NumberOfBooks.size();

		if (NumberOfBooks.size() > 10) {
			return false;
		} else {
			return true;
		}
	}

	public boolean EditReadingInterestsButtonVisible()
			throws InterruptedException {
		try {
			editReadingInterestsButton.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean EditReadingInterestsButtonNotVisible()
			throws InterruptedException {
		try {
			editReadingInterestsButton.isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean PrintButtonHomeStudentVisible() throws InterruptedException {
		try {
			PrintbuttonHometab.isDisplayed();
			this.reportLog("Print button is visible in Home tab");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean SerachButtonStudent() {
		try {
			Searchtab.click();
			Searchbox.sendKeys("time");
			Searchbutton.click();
			PrinButtonSearchButton.isDisplayed();
			this.reportLog("Print button is visible in Search tab");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean MyresultButtonStudent() {
		Myresulttab.click();
		PrinButtonMyresultButton.click();
		try {
			PrintCommentsMyresultButton.isDisplayed();
			PrintAwardsMyresultButton.isDisplayed();
			PrintactivitiesMyresultButton.isDisplayed();
			this.reportLog("Print button is visible in My result tab");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean Verifyhelpicon() {
		try {
			reportLog("Searching for help icon");
			helpIcon.isDisplayed();
			helpIcon.click();
			reportLog("Found helped icon");
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public void isCreateMyReadingListDisplayed() {
		// TODO Auto-generated method stub

	}

	public boolean Verifyhelpdropdownlink() {
		boolean check = true;
		List<WebElement> elements = driver.findElements(By
				.xpath("//ul[@class='dropdown-menu ng-scope']/li/a"));
		for (WebElement element : elements) {

			String helpdropdowntext = element.getText().trim();
			String helpdropdownlink = element.getAttribute("href").trim();

			if (helpdropdowntext.contains("Help FAQs")
					&& (helpdropdownlink
							.contains("https://scholastic-learning-zone.custhelp.com/app/answers/list/p/1087"))) {
				reportLog("\"Help FAQs\" is found in help dropdown");
			}

			else if (helpdropdowntext.contains("User Guide")
					&& (helpdropdownlink
							.contains("https://scholastic-learning-zone.custhelp.com/app/answers/detail/a_id/7212"))) {
				reportLog("\"User Guide\" is found in help dropdown");
			}

			else if (helpdropdowntext.contains("Reports Guide")
					&& (helpdropdownlink
							.contains("https://scholastic-learning-zone.custhelp.com/app/answers/detail/a_id/8074"))) {
				reportLog("\"Reports Guide\" is found in help dropdown");
			}

			else if (helpdropdowntext.contains("Educator's Guide")
					&& (helpdropdownlink
							.contains("https://scholastic-learning-zone.custhelp.com/app/answers/detail/a_id/7213"))) {
				reportLog("\"Educator's Guide\" is found in help dropdown");
			}

			else if (helpdropdowntext.contains("MetaMetrics")
					&& (helpdropdownlink
							.contains("http://www.metametricsinc.com/lexile-framework-reading/"))) {
				reportLog("\"MetaMetrics\" is found in help dropdown");
			} else {
				check = false;
			}

		}
System.out.println(check);
		return check;

	}

	public void clickOnClosePopUp() {
		driver.switchTo().activeElement();
		this.sync(driver.findElement(By
				.xpath(".//button[contains(text(),'Close')]")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By
				.xpath(".//button[contains(text(),'Close')]")));
	}

	public String checkQuizHeadder() {
		WebElement we = this
				.sync(getElement(
						By.xpath(".//*[@class='available-quizzes-modal ng-scope']//h3"),
						3));
		String text = "";
		if (we != null) {
			text = this.getText(we);
			this.reportLog("Quizz header: " + text);
			return text;
		}
		this.reportLog("No Header Displayed");
		return text;
	}

	public boolean clickViewQiz() {
		WebElement we = this.sync(getElement(
				By.xpath(".//span[contains(text(),'View Quiz')]"), 3));
		if (we != null) {

			this.reportLog("Quizz button displayed");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", we);

			return true;
		}
		this.reportLog("No quiz button Displayed");
		return false;

	}

	public String getQuizzPageHeader() throws AWTException {
		this.lazyWait(10);
		this.switchToNewWindow();
		WebElement we = this.sync(getElement(
				By.xpath(".//div[@id='quizView']//h4"), 3));
		String text = "";
		if (we != null) {
			text = this.getText(we);
			this.reportLog("Quizz Page: " + text);

			switchtoWindow(1);
			return text;
		}
		this.reportLog("No quiz Page Displayed");
		return text;

	}
	/** SDM Nav Bar Locators **/
	
	
	@FindBy(xpath="//img[@class='brand']")
	public WebElement RPlogo;
	
	@FindBy(xpath="//img[contains(@class,'lpl-header-logo-img')]")
	public WebElement RPLlogo;
	
	@FindBy(xpath="//img[@class='schlogo']")
	public WebElement RPlogoStudent;
	
	@FindBy(id="sdm-nav")
	public WebElement sdmnav;
	
	@FindBy(className="sdm-usericon-image")
	public WebElement usericonimage;
	
	@FindBy(className="sdm-username")
	public WebElement username;
	
	@FindBy(className="sdm-dropdown-images")
	public WebElement dropdownicon;
	
	@FindBy(className="sdm-dropdown-btn")
	public WebElement dropdownbtn;
	
	@FindBy(id="sdm-logout")
	public WebElement sdmlogout;
	
	@FindBy(xpath="//div[@id='sdm-nav']/div[2]/button")
	public WebElement sdmappdropdown;
	
	@FindBy(id= "sdm-portal-link")
	public WebElement sdmportallink;
	
	@FindBy(xpath="//div[@id='sdm-nav']//div[2]//a[3]")
	public WebElement anotherproduct;
	
	@FindBy(xpath="//div[@id='sdm-nav']//div[2]//a[2]")
	public WebElement oneProduct;
	@FindBy(xpath="(.//*[@id='readingList']//button[2])[1]")
	public WebElement listviewrlist;
	
	public WebElement getRPlogo(){
	WaitUtils.waitForDisplayed(RPlogo);
	return RPlogo;
	}
	public WebElement getRPLlogo(){
		WaitUtils.waitForDisplayed(RPLlogo);
		return RPLlogo;
		}
	
	public WebElement getRPlogoStudent(){
		WaitUtils.waitForDisplayed(RPlogoStudent);
		return RPlogoStudent;
	}

	public void verifySDMHeaders(){
		WaitUtils.waitForDisplayed(sdmnav);
		AssertUtils.assertDisplayed(sdmnav);
		WaitUtils.waitForDisplayed(usericonimage);
		AssertUtils.assertDisplayed(usericonimage);
		WaitUtils.waitForDisplayed(username);
		AssertUtils.assertDisplayed(username);
		WaitUtils.waitForDisplayed(dropdownbtn);
		AssertUtils.assertDisplayed(dropdownbtn);
		click(dropdownbtn);
		WaitUtils.waitForDisplayed(sdmlogout);
		AssertUtils.assertDisplayed(sdmlogout);
		WaitUtils.waitForDisplayed(sdmappdropdown);
		AssertUtils.assertDisplayed(sdmappdropdown);
	}
	
	public void clickOnUserName(){
		WaitUtils.waitForDisplayed(username);
		click(username);
	}
	public void clickOnLogout(){
		WaitUtils.waitForDisplayed(sdmlogout);
		click(sdmlogout);
	}
	public void clickOnReturnToSDM(){
		WaitUtils.waitForDisplayed(sdmappdropdown);
		click(sdmappdropdown);
		WaitUtils.waitForDisplayed(sdmportallink);
		click(sdmportallink);
	}
	public void clickOnAnotherProduct(){
		WaitUtils.waitForDisplayed(sdmappdropdown);
		click(sdmappdropdown);
		if(driver.getCurrentUrl().contains("litpro")){
		WaitUtils.waitForDisplayed(anotherproduct);
		click(anotherproduct);
		}else {
			WaitUtils.waitForDisplayed(oneProduct);
			click(oneProduct);
		}
	}
	
	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}

	public String getDashboarData(String arg1) {
		System.out.println(driver.findElement(By.xpath(".//*[@id='charts']/div[1]/h3/span")).getText());
		 return this.sync(driver.findElement(By.xpath(".//*[@id='charts']/div[1]/h3/span"))).getText();
	}

	public ArrayList<String> storeBooknames() {
		ArrayList<String> ar = new ArrayList<String>();
	
		this.sync(listviewrlist);
		listviewrlist.click();
		List<WebElement> ele = driver.findElements(By.xpath(".//*[@id='readingList']//table/tbody/tr/td[2]"));
	for(WebElement e : ele)
	{
		ar.add(e.getText());
	}
	System.out.println(ar);
	return ar;
	}
}