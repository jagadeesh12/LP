package com.scholastic.intl.litpro.test.automation.pageobjects;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
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
import org.openqa.selenium.Alert;


//import pageobject.ParentPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.torque.common.WaitUtils;

public class SettingsPg extends ParentPage{
	WebDriver driver;
	final String PAGE_TITLE = "Scholastic Literacy Pro";

	@FindBy(xpath = "//div[@id='main-content']//h2")
	private WebElement pgHeader;

	@FindBy(xpath = "//button[span[text()='Save']]")
	private WebElement saveButton;

	@FindBy(xpath = "//button[span[text()='Restore Defaults']]")
	private WebElement restoreDefaultButton;

	@FindBy(xpath = "//div[contains(@class,'notification-content')]/h3")
	private WebElement saveNotification;

	@FindBy(xpath = "//*[@id='cohortSearch']/button")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='cohortSearch']/input")
	private WebElement searchText;

	@FindBy(xpath = "//*[@id='sidebar']/div[2]/div/roster-tree/ul/li/ins")
	private WebElement smartbarArrow;

	@FindBy(xpath = "//*[@id='sidebar']/div[2]/div/roster-tree/ul/li/ul/li[2]/ins")
	private WebElement mathArrow;

	@FindBy(xpath = "//*[@id='sidebar']/div[2]/div/roster-tree/ul/li/ul/li[2]/a")
	private WebElement smartbarClass;

	@FindBy(xpath = "//*[@id='sidebar']/div[2]/div/roster-tree/ul/li/ul/li[2]/ul/li[3]/a")
	private WebElement studentLink;

	@FindBy(xpath = "//label[span[contains(text(),'Minimum number of days between completed tests')]]")
	private WebElement mindaysCheckbox;

	@FindBy(xpath = ".//*[@id='min_num_days_input']")
	public WebElement mindaysText;

	@FindBy(xpath = "//label[span[contains(text(),'Require students to take practice test')]]")
	private WebElement reqpracticeCheckbox;

	@FindBy(xpath = "//label[span[contains(text(),'Limit reading list titles to only those in the school library')]]")
	private WebElement limit2libraryCheckbox;

	@FindBy(xpath = "//label[span[contains(text(),'Limit number of books in reading list to')]]")
	private WebElement limitlistCheckbox;

	@FindBy(xpath = ".//*[@ng-model='mergedSettings.sri_reading_list_book_limit.value']")
	private WebElement limitlistText;

	@FindBy(xpath = "//label[span[contains(text(),'Show student Lexile measure after test completion')]]")
	private WebElement showlexileCheckbox;

	@FindBy(xpath = "//label[span[contains(text(),'Limit test access to certain days and times')]]")
	private WebElement limittimeCheckbox;

	@FindBy(xpath = "//label[span[contains(text(),'Allow students to see their reading list')]]")
	private WebElement seelistCheckbox;

	@FindBy(xpath = "//label[span[contains(text(),'Limit reading list to titles with book quizzes')]]")
	private WebElement withquizCheckbox;

	@FindBy(xpath = "//label[span[contains(text(),'Limit practice test to one per student')]]")
	private WebElement onepracticeCheckbox;

	@FindBy(xpath = "//label[span[contains(text(),'Allow students to change reading interests')]]")
	private WebElement changeinterestsCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[1]/setting-boolean/ng-form/div/label/span")
	private WebElement displayincorrectCheckbox;

	@FindBy(xpath = "//*[@id='src_allow_student_to_print']/span")
	private WebElement allowprintCheckbox;

	@FindBy(xpath = "//*[@id='src_quiz_pass_mark_input']")
	private WebElement quizpassText;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[7]/time-restriction/ng-form/div/div/label/span")
	private WebElement quizaccessCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[8]/setting-boolean/ng-form/div/label/span")
	private WebElement teacherptsCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[2]/ng-form/div/label/span")
	private WebElement quizattemptsCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[2]/ng-form/div/input")
	private WebElement quizattemptsText;

	@FindBy(xpath = "//*[@id='src_num_days_between_tests']/span")
	private WebElement daysbetweenquizCheckbox;

	@FindBy(xpath = "//*[@id='src_num_days_between_tests_input']")
	private WebElement daysbetweenquizText;

	@FindBy(xpath = "//*[@id='src_show_search_results_outside_student_interest_levels']/span")
	private WebElement educationlevelCheckbox;

	@FindBy(xpath = "//*[@id='interestLevels']/div[1]/label/span")
	private WebElement lowerprimaryCheckbox;

	@FindBy(xpath = "//*[@id='interestLevels']/div[2]/label/span")
	private WebElement middleprimaryCheckbox;

	@FindBy(xpath = "//*[@id='interestLevels']/div[3]/label/span")
	private WebElement upperprimaryCheckbox;

	@FindBy(xpath = "//*[@id='interestLevels']/div[4]/label/span")
	private WebElement secondaryCheckbox;

	//@FindBy(xpath = "//*[@id='settings']/form/div[4]/div[5]/div/div/div/button")
	@FindBy(xpath = ".//*[@class='leadcontainer']/button")
	private WebElement awardsbasedDropdown;

	@FindBy(xpath = ".//*[@id='settings']//ul/li[1]/a")
	private WebElement quizzespassedLink;

	@FindBy(xpath = "//*[@id='awards_level_gold_points']/div[4]/input")
	private WebElement goldptsText;

	@FindBy(xpath = "//*[@id='awards_level_gold_books']/div[4]/input")
	private WebElement goldbooksText;

	@FindBy(xpath = "//*[@id='awards_level_silver_points']/div[4]/input")
	private WebElement silverptsText;

	@FindBy(xpath = "//*[@id='awards_level_silver_books']/div[4]/input")
	private WebElement silverbooksText;

	@FindBy(xpath = "//*[@id='awards_level_bronze_points']/div[4]/input")
	private WebElement bronzeptsText;

	@FindBy(xpath = "//*[@id='awards_level_bronze_books']/div[4]/input")
	private WebElement bronzebooksText;

	@FindBy(xpath = "//*[@id='awards_level_red_points']/div[4]/input")
	private WebElement redptsText;

	@FindBy(xpath = "//*[@id='awards_level_red_books']/div[4]/input")
	private WebElement redbooksText;

	@FindBy(xpath = "//*[@id='awards_level_blue_points']/div[4]/input")
	private WebElement blueptsText;

	@FindBy(xpath = "//*[@id='awards_level_blue_books']/div[4]/input")
	private WebElement bluebooksText;

	@FindBy(xpath = "//*[@id='sidebar']/div[2]/div/roster-tree/ul/li/a")
	private WebElement schoolLink;

	@FindBy(xpath = "//div[3]/div/div[2]/div[2]/p")
	private WebElement errorText;

	@FindBy(xpath = "//div[3]/div/div[2]/div[2]/h3")
	private WebElement short_errorText;

	@FindBy(xpath = ".//*[@id='quizSettingsList']//time-restriction/ng-form/div/div/label/span")
	private WebElement quizdayrestrictCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[7]/time-restriction/ng-form/div[2]/div[1]/div")
	private WebElement restricttimeText;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[7]/time-restriction/ng-form/div[2]/div[2]/div[1]/label/span")
	private WebElement quizrestrictSundayCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[7]/time-restriction/ng-form/div[2]/div[2]/div[2]/label/span")
	private WebElement quizrestrictMondayCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[7]/time-restriction/ng-form/div[2]/div[2]/div[3]/label/span")
	private WebElement quizrestrictTuesdayCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[7]/time-restriction/ng-form/div[2]/div[2]/div[4]/label/span")
	private WebElement quizrestrictWednesdayCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[7]/time-restriction/ng-form/div[2]/div[2]/div[5]/label/span")
	private WebElement quizrestrictThursdayCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[7]/time-restriction/ng-form/div[2]/div[2]/div[6]/label/span")
	private WebElement quizrestrictFridayCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[7]/time-restriction/ng-form/div[2]/div[2]/div[7]/label/span")
	private WebElement quizrestrictSaturdayCheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[7]/time-restriction/ng-form/div[2]/div[4]/div[2]/table/tbody/tr[1]/td[1]/a/i")
	private WebElement quizstarthourincreaseArrow;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[7]/time-restriction/ng-form/div[2]/div[4]/div[4]/table/tbody/tr[1]/td[1]/a/i")
	private WebElement quizendhourincreaseArrow;

	@FindBy(xpath = "//*[@id='navReports']/a/span")
	private WebElement reportsLink;

	@FindBy(xpath = "//*[@id='testSettingsList']/div[3]/setting-boolean/ng-form/div/label/input")
	private WebElement Allow_students_to_see_their_reading_lists;

	@FindBy(xpath = "//*[@id='min_num_days_input']")
	private WebElement MinNumberOfDaySettings;

	@FindBy(xpath = "//*[@id='testSettingsList']/div[5]/setting-boolean/ng-form/div/label/input")
	private WebElement LimitReadingListSetting;

	@FindBy(xpath = "//*[@id='testSettingsList']/div[7]/setting-boolean/ng-form/div/label/input")
	private WebElement LimitReadingListInlibSetting;

	@FindBy(xpath = "//*[@id='testSettingsList']/div[9]/ng-form/div/input")
	private WebElement LimitReadingListNumberSetting;

	@FindBy(xpath = "//*[@id='testSettingsList']/div[9]/ng-form/div/label/input")
	private WebElement LimitReadingListNumberSettingcheckbox;

	@FindBy(xpath = "//*[@id='quizSettingsList']/div[1]/setting-boolean/ng-form/div/label/input")
	private WebElement DisplayIncorectAnswer;

	@FindBy(xpath = "	//*[@id='src_allow_student_to_print']/input")
	private WebElement AllowPrintCheckbox;

	@FindBy(xpath = "//*[@id='settings']//button[@class='btn btn-primary dropdown-toggle']")
	private WebElement Awarddropdown;

	@FindBy(xpath = "//*[@id='settings']//li[1]/a")
	private WebElement AwardQuizzesPassed;

	@FindBy(xpath = ".//*[@id='interestLevels']//span[contains(text(),'Lower Primary')]")
	private WebElement LowerPrimary;

	@FindBy(xpath = ".//*[@id='interestLevels']//span[contains(text(),'Middle Primary')]")
	private WebElement MiddlePrimary;

	@FindBy(xpath = ".//*[@id='interestLevels']//span[contains(text(),'Upper Primary')]")
	private WebElement UpperPrimary;

	@FindBy(xpath = ".//*[@id='interestLevels']//span[contains(text(),'Lower Secondary')]")
	private WebElement LowerSecondary;

	@FindBy(xpath = ".//*[@id='interestLevels']//span[contains(text(),'Middle Secondary')]")
	private WebElement MiddleSecondary;

	@FindBy(xpath = ".//*[@id='interestLevels']//span[contains(text(),'Upper Secondary')]")
	private WebElement UpperSecondary;

	@FindBy(xpath = "//*[@id='src_show_search_results_outside_student_interest_levels']/input")
	private WebElement educationLevelCheckbox;

	@FindBy(xpath = "//*[@id='list-view-button-teacher']")
	private WebElement ListviewButton;

	@FindBy(xpath = "//*[@id='navSearch']/a/span")
	private WebElement SearchTab;

	@FindBy(xpath = "//*[@id='mainSearch']//div[3]/div[1]/input")
	private WebElement SearchText;

	@FindBy(xpath = "//*[@id='addtl-opts']/a[2]/span")
	private WebElement Clearall;

	@FindBy(xpath = "//*[@id='interest-level-option']/label/span[contains(text(),'Lower Primary')]")
	private WebElement searchLowerPrimary;

	@FindBy(xpath = "//*[@id='interest-level-option']/label/span[contains(text(),'Middle Primary')]")
	private WebElement searchMiddlePrimary;

	@FindBy(xpath = "//*[@id='interest-level-option']/label/span[contains(text(),'Upper Primary')]")
	private WebElement searchUpperPrimary;

	@FindBy(xpath = "//*[@id='interest-level-option']/label/span[contains(text(),'Lower Secondary')]")
	private WebElement searchLowerSecondary;

	@FindBy(xpath = "//*[@id='interest-level-option']/label/span[contains(text(),'Middle Secondary')]")
	private WebElement searchMiddleSecondary;

	@FindBy(xpath = "//*[@id='interest-level-option']/label/span[contains(text(),'Upper Secondary')]")
	private WebElement searchUpperSecondary;

	@FindBy(xpath = "//*[@id='addtl-opts']/a[1]/span")
	private WebElement AdditionalSearchOptions;

	@FindBy(xpath = "//*[@id='teacher-quick-search-button']")
	private WebElement Searchbutton;
	@FindBy(xpath = "//*[@id='cohort-results']//h4")
	private WebElement classsearchresult_roster;
	
	@FindBy(xpath= "//a[text()='Logout']")
	private WebElement logout;

	@FindBy(xpath = "//*[@id='navReports']/a/span")
	private WebElement ReportTab;

	@FindBy(xpath = "//roster-tree/ul/li/a")
	private WebElement RosterFirstText;

	@FindBy(xpath = "//*[@id='topNavBar']//span[2]")
	private WebElement Schoolname;

	@FindBy(xpath = "//roster-tree/ul/li/ins")
	private WebElement rosterFirstArrow;

	@FindBy(xpath = "//roster-tree/ul/li/ul/li/ins")
	private WebElement RosterSecondArrow;
	
	public static String PassmarksmarksStudent;
	BooksObject booksObjs = new BooksObject();

	public SettingsPg(WebDriver driver, LitProUserType userType) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
		this.lazyWait(10);
	}

	public String getExpectedTitle() {
		return PAGE_TITLE;
	}

	public String getPageHeader() {
		String header = this.getText(pgHeader);
		this.reportLog("Get Page Header: " + header);
		return header;
	}

	public String getPageHeaderclass(String str) {
		try {
			if (classsearchresult_roster.isDisplayed()) {
				driver.findElement(
						By.xpath("//*[@id='cohort-results']//span[contains(text(),'"
								+ str + "')]")).click();
			}
		} catch (Exception e) {
		}
		lazyWait(5);
		String header = this.getText(pgHeader);
		this.reportLog("Get Page Header: " + header);
		return header;
	}

	/* checks setting presence */
	public boolean isSettingExist(String settingName) {
		boolean flag = false;
		String controlXpath = "//label[span[contains(text(),'" + settingName
				+ "')]]";
		
		//By by = By.xpath(controlXpath);
		WebElement settingElement = getDriver().findElement(By.xpath(controlXpath));
		System.out.println(controlXpath);
		if (settingElement != null) {
			flag = true;
			this.reportLog("Setting: '" + settingName + "' Displayed");
		} else {
			this.reportLog("Setting: '" + settingName + "' NOT Displayed");
		}
		return flag;
	}

	/* checks if setting is enabled */
	public boolean isSettingEnabled(String settingName) {
		boolean flag = true;
		String controlXpath = "//label[span[contains(text(),'" + settingName
				+ "')]]/input[@type='checkbox']";
		By by = By.xpath(controlXpath);
		WebElement settingElement = this.getElement(by);
		System.out.println(controlXpath);
		if (settingElement != null) {
			if (settingElement.isSelected()) {
				this.reportLog("Setting: '" + settingName + "' Enabled");
				flag = true;
			} else {
				this.reportLog("Setting: '" + settingName + "' NOT Enabled");
			}
		} else {
			// System.out.println(settingName+" is null in isSettingEnabled");
			return true;
		}
		return flag;
	}

	public boolean isSettingEnabledExpected(String settingName,
			String enabledValue) {
		System.out.println(settingName + " " + enabledValue);
		String controlXpath = null;
		if (enabledValue.equalsIgnoreCase("NA")) {
			// this applies to quiz pass mark only
			reportLog("quiz pass mark is NA");
			return true;
		} else if (enabledValue.equalsIgnoreCase("Yes")
				|| enabledValue.equalsIgnoreCase("No")) {
			controlXpath = "//label[span[contains(text(),'" + settingName
					+ "')]]/input[@type='checkbox']";
			System.out.println(controlXpath);
		} else {
			reportLog("Invalid enabled value " + enabledValue
					+ ". only Yes No and NA are valid.");
			return false;
		}
		// String controlXpath = "//label[span[contains(text(),'" + settingName
		// + "')]]/input[@type='checkbox']";
		By by = By.xpath(controlXpath);
		WebElement settingElement = this.getElement(by);

		// verify if setting is selected
		if (settingElement != null) {
			if (settingElement.isSelected()) {
				System.out.println(settingElement.isSelected());
				System.out.println(settingElement.isEnabled());
				if (enabledValue.equalsIgnoreCase("Yes")) {
					this.reportLog("Setting: '" + settingName
							+ "' Enabled and is expected to be enabled");
					return true;
				} else if (enabledValue.equalsIgnoreCase("No")) {
					reportLog("Setting: '" + settingName
							+ "' Enabled and is expected to be disabled");
					return false;
				} else if (enabledValue.equalsIgnoreCase("NA")) {
					reportLog("Setting: '" + settingName
							+ "' Enabled and is expected to be Not Applicable");
					return false;
				}

			} else { // setting is disabled
				if (enabledValue.equalsIgnoreCase("No")) {
					reportLog("Setting: '" + settingName
							+ "' Disabled and is expected to be disabled");
					return true;
				}
				if (enabledValue.equalsIgnoreCase("Yes")) {
					reportLog("Setting: '" + settingName
							+ "' Disabled and is expected to be enabled");
					return false;
				}
				if (enabledValue.equalsIgnoreCase("NA")) {
					reportLog("Setting: '" + settingName
							+ "' Disabled and is expected to be NA");
					return false;
				}
			}
			// settingElement is null
		}

		return true;
	}

	public boolean isSettingExpectedValue(String settingName,
			String defaultValue) {
		// System.out.println("isSettingExpectedValue "+settingName+" "+defaultValue);
		if (defaultValue.equalsIgnoreCase("NA")) {
			// values that are NA should not have a UI control associated
			reportLog("There is no value associated with " + settingName);
			return true;
		} else if (defaultValue.equalsIgnoreCase("")
				|| defaultValue.matches("[0-9]+")) {
			if (defaultValue.equalsIgnoreCase(getSettingValue(settingName))) {
				reportLog(settingName + " value matches expected value"
						+ defaultValue);
				return true;
			}
		} else {
			reportLog("Invalid default value in isSettingExpectedValue "
					+ defaultValue
					+ ". only NA, null string, and digits are valid.");
			return false;
		}

		return false;
	}

	public String getSettingValue(String settingName) {
		String flag = null;
		String controlXpath = "//div[label[span[contains(text(),'"
				+ settingName + "')]]]//input[@type='number']";
		By by = By.xpath(controlXpath);
		WebElement settingElement = this.getElement(by);

		if (settingElement != null) {
			flag = settingElement.getAttribute("value").trim();
			this.reportLog("Setting: '" + settingName + "' Get Value: " + flag);
		} else {
			// System.out.println("settingElement is null in getSettingValue");
		}
		return flag;
	}

	public boolean setSettingValue(String settingName, String setValue) throws InterruptedException {
		boolean flag = false;

		String controlXpath = "//div[label[span[contains(text(),'"
				+ settingName + "')]]]//input[@type='number']";
		By by = By.xpath(controlXpath);
		WebElement settingElement = this.getElement(by);

		if (settingElement != null) {
			this.reportLog("Setting: '" + settingName + "' Change Value: "
					+ setValue);
			settingElement.clear();
			settingElement.clear();
			Thread.sleep(2000);
			settingElement.sendKeys(setValue);
			flag = true;
		}
		return flag;
	}

	/* changes the setting */
	public boolean enableSetting(String settingName) {
		boolean flag = false;
		String controlXpath = "//label[span[contains(text(),'" + settingName
				+ "')]]/input[@type='checkbox']";
		By by = By.xpath(controlXpath);
		WebElement settingElement = this.getElement(by);
System.out.println(controlXpath);
		if (settingElement != null) {
			System.out.println(settingElement.isSelected());
			if (!settingElement.isSelected()) {
				this.reportLog("Setting: '" + settingName + "' Enabled");
				this.click(driver.findElement(By.xpath("//label[span[contains(text(),'" + settingName+ "')]]")));
			}
			flag = true;
		}
		return flag;
	}

	/* changes the setting */
	public boolean disableSetting(String settingName) {
		boolean flag = false;
		String controlXpath = "//label[span[contains(text(),'" + settingName
				+ "')]]/input[@type='checkbox']";
		By by = By.xpath(controlXpath);
		WebElement settingElement = this.getElement(by);
System.out.println(controlXpath);
		if (settingElement != null) {
			if (settingElement.isSelected()) {
				this.reportLog("Setting: '" + settingName + "' Disabled");
				//this.click(settingElement);
				this.click(driver.findElement(By.xpath("//label[span[contains(text(),'" + settingName
				+ "')]]")));
			}
			flag = true;
		}
		return flag;
	}

	public void saveSettings() {
		this.reportLog("Click Save Settings Button");
		this.click(this.saveButton);

	}

	public String getSaveNotification() {
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// saveNotification =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'notification-content')]/h3")
		// ));
		String notiStr = this.getText(saveNotification).trim();
		lazyWait(3);
		return notiStr;
		
	}

	public String getAwardsBased() {
		String notiStr = this.getText(awardsbasedDropdown).trim();
		// System.out.println("notiStr is "+notiStr);
		return notiStr;
	}

	public boolean verifyAwards(String awardName, String awardValue) {
		if (awardName.equalsIgnoreCase("Gold")) {
			if (awardValue.equalsIgnoreCase(goldptsText.getAttribute("value")
					.trim())) {
				reportLog("Gold award value matches expected value");
				return true;
			} else {
				reportLog("Gold award value "
						+ goldptsText.getAttribute("value").trim()
						+ "does NOT match expected value " + awardValue);
				return false;
			}
		}
		if (awardName.equalsIgnoreCase("Silver")) {
			if (awardValue.equalsIgnoreCase(silverptsText.getAttribute("value")
					.trim())) {
				reportLog("Silver award value matches expected value");
				return true;
			} else {
				reportLog("Silver award value "
						+ silverptsText.getAttribute("value").trim()
						+ "does NOT match expected value " + awardValue);
				return false;
			}
		}
		if (awardName.equalsIgnoreCase("Bronze")) {
			if (awardValue.equalsIgnoreCase(bronzeptsText.getAttribute("value")
					.trim())) {
				reportLog("Bronze award value matches expected value");
				return true;
			} else {
				reportLog("Bronze award value does NOT match "
						+ bronzeptsText.getAttribute("value").trim()
						+ ". Actual value " + awardValue);
				return false;
			}
		}
		if (awardName.equalsIgnoreCase("Red")) {
			if (awardValue.equalsIgnoreCase(redptsText.getAttribute("value")
					.trim())) {
				reportLog("Red award value matches expected value");
				return true;
			} else {
				reportLog("Red award value does NOT match "
						+ redptsText.getAttribute("value").trim()
						+ ". Actual value " + awardValue);
				return false;
			}
		}
		if (awardName.equalsIgnoreCase("Blue")) {
			if (awardValue.equalsIgnoreCase(blueptsText.getAttribute("value")
					.trim())) {
				reportLog("Blue award value matches expected value");
				return true;
			} else {
				reportLog("Blue award value does NOT match  "
						+ blueptsText.getAttribute("value").trim()
						+ ". Actual value " + awardValue);
				return false;
			}
		}
		return false;
	}

	public boolean verifybookAwards(String awardName, String awardValue) {
		if (awardName.equalsIgnoreCase("Gold")) {
			if (awardValue.equalsIgnoreCase(goldbooksText.getAttribute("value")
					.trim())) {
				reportLog("Gold award value matches expected value");
				return true;
			} else {
				reportLog("Gold award value "
						+ goldbooksText.getAttribute("value").trim()
						+ "does NOT match expected value " + awardValue);
				return false;
			}
		}
		if (awardName.equalsIgnoreCase("Silver")) {
			if (awardValue.equalsIgnoreCase(silverbooksText.getAttribute(
					"value").trim())) {
				reportLog("Silver award value matches expected value");
				return true;
			} else {
				reportLog("Silver award value "
						+ silverbooksText.getAttribute("value").trim()
						+ "does NOT match expected value " + awardValue);
				return false;
			}
		}
		if (awardName.equalsIgnoreCase("Bronze")) {
			if (awardValue.equalsIgnoreCase(bronzebooksText.getAttribute(
					"value").trim())) {
				reportLog("Bronze award value matches expected value");
				return true;
			} else {
				reportLog("Bronze award value does NOT match "
						+ bronzebooksText.getAttribute("value").trim()
						+ ". Actual value " + awardValue);
				return false;
			}
		}
		if (awardName.equalsIgnoreCase("Red")) {
			if (awardValue.equalsIgnoreCase(redbooksText.getAttribute("value")
					.trim())) {
				reportLog("Red award value matches expected value");
				return true;
			} else {
				reportLog("Red award value does NOT match "
						+ redbooksText.getAttribute("value").trim()
						+ ". Actual value " + awardValue);
				return false;
			}
		}
		if (awardName.equalsIgnoreCase("Blue")) {
			if (awardValue.equalsIgnoreCase(bluebooksText.getAttribute("value")
					.trim())) {
				reportLog("Blue award value matches expected value");
				return true;
			} else {
				reportLog("Blue award value does NOT match  "
						+ bluebooksText.getAttribute("value").trim()
						+ ". Actual value " + awardValue);
				return false;
			}
		}

		return false;
	}

	public void clickSmartBarArrow() {
		smartbarArrow.click();
		reportLog("smartbar arrow clicked");
	}

	public void selectClass(String className) {
		reportLog("Select Class");
		smartbarClass.click();
	}

	public void searchSmartbar(String searchName) throws Throwable {
		reportLog("Search for " + searchName);
		searchText.clear();
		searchText.sendKeys(searchName);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				searchButton);
		// searchButton.click();
		waitForPageLoad(3000);
	}

	// get an error message that goes away too fast if searchSmartbar() used on
	// errors
	public void searchError(String searchName) throws Throwable {
		reportLog("Search for " + searchName);
		searchText.clear();
		searchText.sendKeys(searchName);
		searchButton.click();
	}

	public void searchtooshortError(String searchName) throws Throwable {
		reportLog("Search for " + searchName);
		searchText.clear();
		searchText.sendKeys(searchName);
		searchButton.click();
	}

	// added for return to default settings
	public void changeallSettings() throws InterruptedException {
		reportLog("Entered change all settings");
		Thread.sleep(2000);
		mindaysText.clear();
		mindaysText.sendKeys("49");
		mindaysCheckbox.click();
		Thread.sleep(10000);
		reqpracticeCheckbox.click();	
		limit2libraryCheckbox.click();
		limitlistCheckbox.click();
		limitlistText.sendKeys("1");
		showlexileCheckbox.click();
		limittimeCheckbox.click();
		seelistCheckbox.click();
		withquizCheckbox.click();
		onepracticeCheckbox.click();
		changeinterestsCheckbox.click();
		displayincorrectCheckbox.click();
		allowprintCheckbox.click();
		quizpassText.clear();
		quizpassText.sendKeys("60");
		quizaccessCheckbox.click();
		// the setting below appears on School page but not on class page
		Boolean isPresent = driver
				.findElements(
						By.xpath("//*[@id='quizSettingsList']/div[8]/setting-boolean/ng-form/div/label/span"))
				.size() > 0;
		if (isPresent) {
			teacherptsCheckbox.click();
		}
		quizattemptsText.clear();
		quizattemptsText.sendKeys("33");
		quizattemptsCheckbox.click();
		daysbetweenquizText.clear();
		daysbetweenquizText.sendKeys("77");
		daysbetweenquizCheckbox.click();
		educationlevelCheckbox.click();
		// lowerprimaryCheckbox.click();
		// middleprimaryCheckbox.click();
		// upperprimaryCheckbox.click();
		// secondaryCheckbox.click();
		awardsbasedDropdown.click();
		quizzespassedLink.click();
		goldbooksText.clear();
		goldbooksText.sendKeys("40");
		silverbooksText.clear();
		silverbooksText.sendKeys("20");
		bronzebooksText.clear();
		bronzebooksText.sendKeys("8");
		redbooksText.clear();
		redbooksText.sendKeys("4");
		bluebooksText.clear();
		bluebooksText.sendKeys("2");
		reportLog("change all complete");
	}

	public void restoreDefaults() throws InterruptedException {
		reportLog("Restore to default values");
		waitForPageLoad(6000);
		// WebDriverWait wait = new WebDriverWait(driver,30);
		// wait.until(ExpectedConditions.elementToBeClickable(restoreDefaultButton));
		restoreDefaultButton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		reportLog("Restore to default values succeeded");

	}

	public String getRestoreNotification() {
		String notiStr = this.getText(saveNotification).trim();
		return notiStr;
	}

	public String getErrorMessage() {
		String errorStr = this.getText(errorText).trim();
		System.out.println(errorStr);
		return errorStr;
	}

	public String getTooShortErrorMessage() {
		String errorStr = this.getText(short_errorText).trim();
		System.out.println(errorStr);
		return errorStr;
	}

	public void clickSchool() throws InterruptedException {
		schoolLink.click();
		Thread.sleep(3000);

	}

	public boolean restoredefaultsButton_not_visible() {
		Boolean isPresent = driver.findElements(
				By.xpath("//button[span[text()='Restore Defaults']]")).size() > 0;
		if (!isPresent) {
			reportLog("No restore defaults button on Class page");
			return true;
		} else {
			reportLog("Unexpected restore defaults button on Class page");
			return false;
		}

	}

	public void change_class_settings() throws InterruptedException {
		reportLog("Entered change class/student settings");
		Thread.sleep(2000);
		reqpracticeCheckbox.click();
		allowprintCheckbox.click();
		awardsbasedDropdown.click();
		quizzespassedLink.click();
		goldbooksText.clear();
		goldbooksText.sendKeys("39");
		silverbooksText.clear();
		silverbooksText.sendKeys("19");
		bronzebooksText.clear();
		bronzebooksText.sendKeys("7");
		redbooksText.clear();
		redbooksText.sendKeys("3");
		bluebooksText.clear();
		bluebooksText.sendKeys("1");
	}

	public void enabletimerestictSetting() {
		quizdayrestrictCheckbox.click();
	}

	public boolean verifydaytimecontrols() {
		String str = restricttimeText.getText();

		if (str.equals("Set the days and times during which students can access book quizzes")) {
			return true;
		}
		return false;
	}

	public void disabletodaySetting() {
		DateTime dt = new DateTime();
		String dow = dt.dayOfWeek().getAsText();
		System.out.println("Day of Week is " + dow);
		if (dow.equals("Sunday")) {
			quizrestrictSundayCheckbox.click();
			return;
		}
		if (dow.equals("Monday")) {
			quizrestrictMondayCheckbox.click();
			return;
		}
		if (dow.equals("Tuesday")) {
			quizrestrictTuesdayCheckbox.click();
			return;
		}
		if (dow.equals("Wednesday")) {
			quizrestrictWednesdayCheckbox.click();
			return;
		}
		if (dow.equals("Thursday")) {
			quizrestrictThursdayCheckbox.click();
			return;
		}
		if (dow.equals("Friday")) {
			quizrestrictFridayCheckbox.click();
			return;
		}
		if (dow.equals("Saturday")) {
			quizrestrictSaturdayCheckbox.click();
			return;
		}

	}
	public void clickLogout(){
		WaitUtils.waitForDisplayed(logout);
		click(logout);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void disablenowSetting() {
		DateTime dt = new DateTime();
		// String curtime = dt.dayOfWeek().getAsText();
		int curtime = dt.getHourOfDay();
		int starttime = curtime + 2;
		int endtime = curtime + 4;
		System.out.println("Current time  " + curtime);
		int i;
		for (i = 0; i < starttime; i++)
			quizstarthourincreaseArrow.click();
		for (i = 0; i <= endtime; i++)
			quizendhourincreaseArrow.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enablenowSetting() {
		DateTime dt = new DateTime();
		// String curtime = dt.dayOfWeek().getAsText();
		int curtime = dt.getHourOfDay();
		int starttime = curtime - 1;
		int endtime = curtime + 1;
		System.out.println("Current time  " + curtime);
		int i;
		for (i = 0; i < starttime; i++)
			quizstarthourincreaseArrow.click();
		for (i = 0; i <= endtime; i++)
			quizendhourincreaseArrow.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean enableteacherpts() throws Throwable {
		if (!teacherptsCheckbox.isEnabled()) {
			System.out.println("teacherptsCheckbox not enabled ");
			return false;
		}

		if (!teacherptsCheckbox.isSelected()) {
			teacherptsCheckbox.click();
			System.out.println("teacherptsCheckbox Selected ");
			return true;
		} else {
			System.out.println("teacherptsCheckbox Selected ALREADY ");
			return true;
		}

	}

	public void clickReports() throws Throwable {
		reportsLink.click();

		Thread.sleep(5000);

	}

	// *************************************************************************************************************************

	public void Limit_reading_list_Inlib_settings_checked() {
		if (LimitReadingListInlibSetting.isSelected()) {
			this.reportLog("Setting \"Limit reading list titles to only those in the school library\" is already selected");
		} else {
			LimitReadingListInlibSetting.click();
			this.reportLog("Setting \"Limit reading list titles to only those in the school library\" is now selected");
		}
	}

	public void ChangeReadingInterestSettingsCheck() {
		if (changeinterestsCheckbox.isSelected()) {
			this.reportLog("Setting \"Allow students to change reading interests\" is already selected");
		} else {
			changeinterestsCheckbox.click();
			this.reportLog("Setting \"Allow students to change reading interests\" is now selected");
		}
	}

	public void IncorrectAnswerUnCheck() {
		if (DisplayIncorectAnswer.isSelected()) {
			DisplayIncorectAnswer.click();
			this.reportLog("Setting \"Display incorrect answers\" is now Unchecked");
		} else {

			this.reportLog("Setting \"Display incorrect answers\" is already checked");
		}
	}

	public void QuizPassMarks(String marks) {
		quizpassText.clear();
		quizpassText.sendKeys(marks);
		PassmarksmarksStudent = marks;
	}

	public void QuizAttempts(String QuizNumber) {
		quizattemptsText.clear();
		quizattemptsText.sendKeys(QuizNumber);
	}

	public void AllowPrintCheck() {
		if (AllowPrintCheckbox.isSelected()) {
			this.reportLog("Setting \"Allow student to print\" is already checked");
		} else {
			AllowPrintCheckbox.click();
			this.reportLog("Setting \"Allow student to print\" is now checked");
		}
	}

	public void AwardsQuizzesPassed() {
		Awarddropdown.click();
		AwardQuizzesPassed.click();
	}

	public void setAwards(String awardName, String awardValue) {

		if (awardName.equalsIgnoreCase("Gold")) {
			goldbooksText.clear();
			goldbooksText.sendKeys(awardValue);
			this.reportLog("The porint for Gold is set to " + awardValue);
		}
		if (awardName.equalsIgnoreCase("Silver")) {
			silverbooksText.clear();
			silverbooksText.sendKeys(awardValue);
			this.reportLog("The porint for Siliver is set to " + awardValue);
		}
		if (awardName.equalsIgnoreCase("Bronze")) {
			bronzebooksText.clear();
			bronzebooksText.sendKeys(awardValue);
			this.reportLog("The porint for Bronze is set to " + awardValue);
		}
		if (awardName.equalsIgnoreCase("Red")) {
			redbooksText.clear();
			redbooksText.sendKeys(awardValue);
			this.reportLog("The porint for Red is set to " + awardValue);
		}
		if (awardName.equalsIgnoreCase("Blue")) {
			bluebooksText.clear();
			bluebooksText.sendKeys(awardValue);
			this.reportLog("The porint for Blue is set to " + awardValue);
		}
	}

	public void educationLevelMaincheckbox() throws InterruptedException {
		//Thread.sleep(10000);
		System.out.println(educationLevelCheckbox.isSelected());
		//Thread.sleep(10000);
		if (educationLevelCheckbox.isSelected()) {
			reportLog("\"Allow students to search outside educational level\" is already selected");
		} else {
			this.driver.findElement(By.id("src_show_search_results_outside_student_interest_levels")).click();
			reportLog("\"Allow students to search outside educational level\" is now selected");
		}
	}

	public void educationLeveluncheckbox() {
		reportLog("Unselecting all the checkboxes");
		List<WebElement> educationLevelcheckbox = this.getElements(By
				.xpath(".//*[@id='interestLevels']/div//input"));
		int checkboxsize = educationLevelcheckbox.size();

		for (int j = 0; j < checkboxsize; j++) {
			if (educationLevelcheckbox.get(j).isSelected()) {
				educationLevelcheckbox.get(j).click();
			}
		}
		reportLog("All the checkboxes are unselected");
	}

	public void educationLevel(String Educational_Level, String checked) throws InterruptedException {
            Thread.sleep(10000);
		if (Educational_Level.equals("Lower Primary")
				&& checked.equals("Checked")) {
			LowerPrimary.click();
			reportLog("\"Lower Primary\" is now selected");
		}
		if (Educational_Level.equals("Middle Primary")
				&& checked.equals("Checked")) {
			MiddlePrimary.click();
			reportLog("\"Lower Primary\" is now selected");
		}
		if (Educational_Level.equals("Upper Primary")
				&& checked.equals("Checked")) {
			UpperPrimary.click();
			reportLog("\"Lower Primary\" is now selected");
		}
		if (Educational_Level.equals("Lower Secondary")
				&& checked.equals("Checked")) {
			LowerSecondary.click();
			reportLog("\"Lower Primary\" is now selected");
		}
		if (Educational_Level.equals("Middle Secondary")
				&& checked.equals("Checked")) {
			MiddleSecondary.click();
			reportLog("\"Middle Secondary\" is now selected");
		}
		if (Educational_Level.equals("Upper Secondary")
				&& checked.equals("Checked")) {
			UpperSecondary.click();
			reportLog("\"Upper Secondary\" is now selected");
		}

	}

	public boolean orderEducationlevel() {
		int set = 1;
		List<WebElement> booktitle = this.getElements(By
				.xpath("//*[@id='interestLevels']/div"));
		int checkboxsize = booktitle.size();
		for (int i = 1; i <= checkboxsize; i++) {
			String educationlevel = driver
					.findElement(
							By.xpath(".//*[@id='interestLevels']/div[" + i
									+ "]//span")).getText().trim();
			if (i == 1 && !educationlevel.equals("Lower Primary")) {
				set = 0;
				break;
			}
			if (i == 2 && !educationlevel.equals("Middle Primary")) {
				set = 0;
				break;
			}
			if (i == 3 && !educationlevel.equals("Upper Primary")) {
				set = 0;
				break;
			}
			if (i == 4 && !educationlevel.equals("Lowers Secondary")) {
				set = 0;
				break;
			}
			if (i == 5 && !educationlevel.equals("Middle Secondary")) {
				set = 0;
				break;
			}
			if (i == 6 && !educationlevel.equals("Upper Secondary")) {
				set = 0;
				break;
			}
		}
		if (set == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void Searchtab() {
		SearchTab.click();
		reportLog("Clicking on search tab");
	}

	public void Searchkey(String searchKey) {
		Clearall.click();
		reportLog("clicked on clear all button");
		SearchText.sendKeys(searchKey);
		AdditionalSearchOptions.click();
		reportLog("Clicked on Additional link");
	}

	public void SearchEducationLevel(String searchEducational_Level,
			String Searchchecked) {
		if (searchEducational_Level.equals("Lower Primary")
				&& Searchchecked.equals("Checked")) {
			searchLowerPrimary.click();
			reportLog("Serach \"Lower Primary\" is now selected");
		}
		if (searchEducational_Level.equals("Middle Primary")
				&& Searchchecked.equals("Checked")) {
			searchMiddlePrimary.click();
			reportLog("Serach \"Middle Primary\" is now selected");
		}
		if (searchEducational_Level.equals("Upper Primary")
				&& Searchchecked.equals("Checked")) {
			searchUpperPrimary.click();
			reportLog("Serach \"Upper Primary\" is now selected");
		}
		if (searchEducational_Level.equals("Lower Secondary")
				&& Searchchecked.equals("Checked")) {
			searchLowerSecondary.click();
			reportLog("Serach \"Lower Secondary\" is now selected");
		}
		if (searchEducational_Level.equals("Middle Secondary")
				&& Searchchecked.equals("Checked")) {
			searchMiddleSecondary.click();
			reportLog("Serach \"Middle Secondary\" is now selected");
		}
		if (searchEducational_Level.equals("Upper Secondary")
				&& Searchchecked.equals("Checked")) {
			searchUpperSecondary.click();
			reportLog("Serach \"Upper Secondary\" is now selected");
		}
	}

	public void SearchButton() {
		Searchbutton.click();
	}

	public ArrayList<String> CollectData() throws InterruptedException {
		this.sync(ListviewButton).click();
		scrolldownTillEnd();
		ArrayList<String> searchtitle = new ArrayList<String>();

		List<WebElement> booktitle = this.getElements(By
				.xpath("//*[@id='search-results']/tbody/tr"));
		int checkboxsize = booktitle.size();

		for (int j = 1; j <= checkboxsize; j = j + 3) {

			String title = driver
					.findElement(
							By.xpath("//*[@id='search-results']/tbody/tr[" + j
									+ "]/td[3]/div/span")).getText().trim();
			// String title= booktitle.get(j).getText().trim();
			searchtitle.add(title);
			System.out.println("*********" + title);
		}
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + searchtitle);
		setsearchtitlesetting(searchtitle);
		return searchtitle;
	}

	public void Limit_reading_list_books_settings_unchecked() {
		if (LimitReadingListNumberSettingcheckbox.isSelected()) {
			LimitReadingListNumberSettingcheckbox.click();
		} else {
		}
	}

	public void uncheck_see_reading_list() {
		if (!Allow_students_to_see_their_reading_lists.isSelected()) {
			Allow_students_to_see_their_reading_lists.click();
		} else {
		}
	}

	public void unchecked_Limit_reading_list_bookquizzes() {
		if (LimitReadingListSetting.isSelected()) {
		} else {
			LimitReadingListSetting.click();
		}
	}

	public boolean readinglistLibrarytooltip() throws InterruptedException {
		Actions act = new Actions(driver);
		this.reportLog("Hover above tooltip of reading list Library");
		act.moveToElement(readinglistLibrarytooltip).perform();
		this.reportLog("Verifying text of tooltip reading list Library");
		this.lazyWait(2);
		if (readinglistLibrarytooltext
				.getText()
				.equals("Checking this setting will limit the titles in the student's reading list to only those that have been matched using the Library Match feature.")) {
			this.reportLog("verified text of tooltip reading list Library");
			return true;
		} else {
			this.reportLog("verified text of tooltip reading list Library");
			return false;
		}

	}

	public boolean Educationlevelsettingtooltip() throws InterruptedException {
		Actions act = new Actions(driver);
		this.reportLog("Hovering over tooltip of Education level setting");
		act.moveToElement(Educationlevelsettingtooltip).perform();
		this.reportLog("Verifying text of tooltip Education level setting");
		this.lazyWait(2);
		if (Educationlevelsettingtooltext
				.getText()
				.equals("Checking this setting will give the student access to titles that have an age-level designation that falls outside the student's grade range.")) {
			this.reportLog("verified text of tooltip reading list Library");
			return true;
		} else {
			this.reportLog("verified text of tooltip reading list Library");
			return false;
		}
	}

	public boolean awardlevelsettingtooltip() throws InterruptedException {
		Actions act = new Actions(driver);
		this.reportLog("Hovering over tooltip of Award level setting");
		act.moveToElement(awardlevelsettingtooltip).perform();
		this.reportLog("Verifying text of tooltip Award level setting");
		this.lazyWait(2);
		if (awardlevelsettingtooltext.getText().equals(
				"Click on a number to edit the value.")) {
			this.reportLog("verified text of tooltip reading list Library");
			return true;
		} else {
			this.reportLog("verified text of tooltip reading list Library");
			return false;
		}
	}

	public void ValidateTimeZoneTest() {
		String text = TimeZoneTest.getText().trim();
		try {
			if (!text.isEmpty()) {
				saveSettings();
				String actual = getSaveNotification();
				String expected = "Settings Saved";
				assertTrue("Setting saved message NOT matched. Expected: "
						+ expected + ", Actual:" + actual,
						actual.equals(expected));
			}
			if (text.isEmpty()) {
				saveSettings();
				String actual = getSaveNotification();
				String expected = "No time zone selected. Go to SLZ Manage Calendar to select a time zone.";
				assertTrue("Setting saved message NOT matched. Expected: "
						+ expected + ", Actual:" + actual,
						actual.equals(expected));
			}
		} catch (Exception e) {

		}
	}

	public void ValidateTimeZoneQuiz() {
		String text = TimeZoneQuiz.getText().trim();
		try {
			if (!text.isEmpty()) {
				saveSettings();
				String actual = getSaveNotification();
				String expected = "Settings Saved";
				assertTrue("Setting saved message NOT matched. Expected: "
						+ expected + ", Actual:" + actual,
						actual.equals(expected));
			}
			if (text.isEmpty()) {
				saveSettings();
				String actual = getSaveNotification();
				String expected = "No time zone selected. Go to SLZ Manage Calendar to select a time zone.";
				assertTrue("Setting saved message NOT matched. Expected: "
						+ expected + ", Actual:" + actual,
						actual.equals(expected));
			}
		} catch (Exception e) {

		}
	}

	public void LogoutClick() {
		logoutLink.click();

	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	private WebElement logoutLink;

	@FindBy(xpath = ".//*[@id='testSettingsList']//time-restriction//span[2]")
	private WebElement TimeZoneQuiz;

	@FindBy(xpath = ".//*[@id='testSettingsList']//time-restriction//span[2]")
	private WebElement TimeZoneTest;

	@FindBy(xpath = ".//*[@id='testSettingsList']//i")
	private WebElement readinglistLibrarytooltip;

	@FindBy(xpath = "//*[@id='testSettingsList']//div/div[2]")
	private WebElement readinglistLibrarytooltext;

	@FindBy(xpath = ".//*[@id='allow-search-outside-help']")
	private WebElement Educationlevelsettingtooltip;

	@FindBy(xpath = ".//*[@id='quizSettingsList']//div/div[1]/div[2]")
	private WebElement Educationlevelsettingtooltext;

	@FindBy(xpath = "//*[@id='award-help']")
	private WebElement awardlevelsettingtooltip;

	@FindBy(xpath = ".//*[@id='settings']//div[2]/div[2]")
	private WebElement awardlevelsettingtooltext;

	public boolean SchoolNameRostertree() {
		reportLog("Verifying the roster tree ");
		String RosterSchoolname = RosterFirstText.getText().trim();
		String schoolname = Schoolname.getText().trim();
		if (RosterSchoolname.equals(schoolname)) {
			reportLog("Name of the school in Roster tree \"" + RosterSchoolname
					+ "\"");
			return true;
		} else {
			return false;
		}
	}

	public boolean ClassNameRostertree() {
		Boolean RosterTreestudentname = driver.findElements(
				By.xpath("//roster-tree/ul/li/ul/li[1]/ul/li/a")).size() > 0;
		Boolean rosterClassboolean = driver.findElements(
				By.xpath("//roster-tree/ul/li/ul/li[1]/a")).size() > 0;
		if (rosterClassboolean && !RosterTreestudentname) {
			reportLog("Class name was loaded and student name was not loaded. Which is correct");
			return true;
		} else {
			reportLog("Class name was loaded and student name was also loaded with page load. Which is not correct");
			return false;
		}
	}

	public void ClickClassRoster() {
		reportLog("Dsiaplying all the classes");
		rosterFirstArrow.click();
		lazyWait(2);
		reportLog("Loading all the students of a class");
		RosterSecondArrow.click();
		lazyWait(5);
	}

	public boolean StudentNameRostertreeVerifiy() {
		Boolean RosterTreestudentname = driver.findElements(
				By.xpath("//roster-tree/ul/li/ul/li[1]/ul/li/a")).size() > 0;
		if (RosterTreestudentname) {
			reportLog("Student name was loaded. Which is correct");
			return true;
		} else {
			reportLog("Student name was not loaded. Which is not correct");
			return false;
		}
	}

	public boolean ClassRostertree() {
		Boolean RosterTreeclass = driver.findElements(
				By.xpath("//roster-tree/ul/li[1]/a")).size() > 0;
		Boolean rosterTreeStudnet = driver.findElements(
				By.xpath(".//roster-tree/ul/li/ul/li/a")).size() > 0;
		if (RosterTreeclass && !rosterTreeStudnet) {
			reportLog("Class name was loaded and student name was not loaded. Which is correct");
			return true;
		} else {
			reportLog("Class name was loaded and student name was also loaded with page load. Which is not correct");
			return false;
		}
	}

	public void ClickClassRosterTeacher() {
		reportLog("Loading all the students of a class");
		rosterFirstArrow.click();
		lazyWait(2);
	}

	public boolean StudentRostertreeVerifiy() {
		Boolean RosterTreestudentname = driver.findElements(
				By.xpath("//roster-tree/ul/li/ul/li[1]/a")).size() > 0;
		if (RosterTreestudentname) {
			reportLog("Student name was loaded. Which is correct");
			return true;
		} else {
			reportLog("Student name was not loaded. Which is not correct");
			return false;
		}
	}

	public void ClickReportPage() {
		reportLog("Refreshing the Litpro");
		driver.navigate().refresh();
		ReportTab.click();
		reportLog("Clicked on Reports tab");
	}

	
	public void verifyGRLLxlLevelingSystem(){
		WebElement levelingheadertext = getElement(By.xpath("//span[text()='Choose Your Leveling System']"),2);
		levelingheadertext.isDisplayed();
		WebElement lexilesetting = getElement(By.id("show_lexile"),2);
		lexilesetting.isDisplayed();
		WebElement grlsetting = getElement(By.id("show_grl"),2);
		grlsetting.isDisplayed();
	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}
	
	public String tooltip(){
		reportLog("Validating the tool tip of \"Limit reading list titles to only those in the school library\"");
		String tooltip = null;
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath(".//span[contains(text(),'Limit reading list titles to only those in the school library')]/parent::label/parent::div/i")))
				.build().perform();
		lazyWait(1);
		
		if(ToolTipReadinglistschoollibrary.isDisplayed()){
			tooltip= ToolTipReadinglistschoollibrary.getText();
		}
		return tooltip;
	}
	
	public String tooltipEducation(){
		reportLog("Validating the tool tip of \"Allow students to search outside educational level\"");
		String tooltip = null;
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath(".//span[contains(text(),'Allow students to search outside educational level')]/parent::label/parent::div/i")))
				.build().perform();
		lazyWait(1);
		
		if(ToolTipEducationlevel.isDisplayed()){
			tooltip= ToolTipEducationlevel.getText();
		}
		return tooltip;
	}
		
	public String tooltipAwards(){
		reportLog("Validating the tool tip of \"Awards are based on:\"");
		String tooltip = null;
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath(".//*[@id='award-help']")))
				.build().perform();
		lazyWait(1);
		if(ToolTipAwards.isDisplayed()){
			tooltip= ToolTipAwards.getText();
		}
		return tooltip;
	}
	
	@FindBy(xpath = ".//div[@class='tooltip-inner ng-binding']")
	public WebElement ToolTipAwards;

	@FindBy(xpath = ".//span[contains(text(),'Limit reading list titles to only those in the school library')]/parent::label/parent::div/div/div[@class='tooltip-inner ng-binding']")
	public WebElement ToolTipReadinglistschoollibrary;

	@FindBy(xpath = ".//span[contains(text(),'Allow students to search outside educational level')]/parent::label/parent::div/div/div[@class='tooltip-inner ng-binding']")
	public WebElement ToolTipEducationlevel;

public boolean clickOnSchoolRosterAndVerifySorting(){
	lazyWait(5);
	WebElement roster=this.sync(driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div/roster-tree/ul/li/ins")));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();",
			roster);
	lazyWait(3);
	WebElement school=this.sync(driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/div/roster-tree//a[contains(text(),'Lui')]/parent::li/ins")));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();",
			school);
	
	return verifySort();
}

@SuppressWarnings("null")
private boolean verifySort() {
	lazyWait(3);
List<WebElement> ele = driver.findElements(By.xpath(".//*[@id='sidebar']/div[2]/div/roster-tree//a[contains(text(),'Lui')]/parent::li//ul/li/a"));
String Studentsname ;
String[] LastName = null;
String[] bfrsort=null;
String[] lastnameAfterSplit = new String[5];
 int j=1;;
for( int i = 0; i < ele.size(); i++)
{
	Studentsname=ele.get(i).getText();
	System.out.println(Studentsname);
	LastName=Studentsname.trim().split("\\s+");
	lastnameAfterSplit[i]=LastName[1];
    System.out.println( LastName[1] );    
}
bfrsort=LastName;
Arrays.sort(LastName);
return bfrsort.equals(LastName);


}


}