package com.scholastic.intl.litpro.test.automation.pageobjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;

public class BenchmarkPg extends ParentPage {
	// WebDriver driver;

	@FindBy(xpath = "//h2[contains(text(), 'Benchmark Proficiency Bands for')]")
	WebElement pgHeader;

	@FindBy(xpath = "//button[i[@class='img-btn-dwnarrow']]")
	WebElement benchmarkDropDownBtn;

	@FindBy(xpath = "//ul[@class='dropdown-menu']/li")
	List<WebElement> benchmarkItems;

	@FindBy(xpath = "//div[@id='cohortSearch']/input")
	WebElement searchTxtBox;

	@FindBy(xpath = "//button[span[text()='Save']]")
	WebElement saveBtn;

	@FindBy(xpath = "//div[contains(@class,'notification-content')]/h3")
	WebElement saveNotification;

	@FindBy(xpath = "//div[@id='benchmarkTable']//thead//th")
	List<WebElement> benchmarkCategories;

	@FindBy(xpath = "//a[contains(text(),'Global English Language Learners')]")
	WebElement benchmarkGELL;

	@FindBy(xpath = "//a[contains(text(),'LitPro Standard')]")
	WebElement benchmarkLPS;

	// @FindBy(xpath =
	// "div[1]/div[3]/div/div/div[1]/div[1]/div[2]/div/form/div/input")
	@FindBy(xpath = "//*[@id='cohortSearch']/input")
	WebElement searchBox;

	@FindBy(xpath = "//*[@id='cohortSearch']/button")
	WebElement searchBTN;

	@FindBy(xpath = "//div[@id='sidebar']/div[2]/div/roster-tree/ul/li/ins")
	WebElement smartbarArrow;

	@FindBy(xpath = "//a[contains(text(),'Lui Class')]")
	WebElement smartbarClass;

	public BenchmarkPg(WebDriver driver, LitProUserType userType) {
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

	public void clickBenchmarkDropdown() throws InterruptedException {
		this.reportLog("Click Benchmark dropdown");
		this.click(this.benchmarkDropDownBtn);
		Thread.sleep(3000);
		reportLog("dropdown clicked");
	}

	public List<String> getBenchmarkNames() {
		List<String> bnames = new ArrayList<String>();
		for (WebElement e : benchmarkItems) {
			String str = this.getText(e);
			this.reportLog(str);
			bnames.add(str);
		}
		return bnames;
	}

	public boolean isBenchmarkCategoryDisplayed(String catName) {
		String xpath = "//div[@id='benchmarkTable']//thead//th[div/span[text()='"
				+ catName + "']]";
		WebElement benchmarkItem = this.getElement(By.xpath(xpath));
		if (benchmarkItem != null)
			return true;
		return false;
	}

	public boolean isStandardValueDisplayed(String stdValue, Integer x) {
		// System.out.println(stdValue+" passed to isStandardSettingDisplayed");
		// System.out.println("row = "+x);
		// define web elements used for verification
		// Cells in table row
		
		reportLog("***************1**********************");
		String cellYearXpath = "//*[@id='benchmarkTable']/table/tbody/tr[" + x
				+ "]/th";
		By by = By.xpath(cellYearXpath);
		WebElement yearElement = this.getElement(by);
		String cellBelowXpath = "//*[@id='benchmarkTable']/table/tbody/tr[" + x
				+ "]/td[1]/div/div";
		by = By.xpath(cellBelowXpath);
		WebElement belowElement = getElement(by);
		String cellBasicXpath = "//*[@id='benchmarkTable']/table/tbody/tr[" + x
				+ "]/td[2]/div/div";
		by = By.xpath(cellBasicXpath);
		WebElement basicElement = getElement(by);
		String cellProficientXpath = "//*[@id='benchmarkTable']/table/tbody/tr["
				+ x + "]/td[3]/div/div";
		by = By.xpath(cellProficientXpath);
		WebElement proficientElement = getElement(by);
		String cellAdvancedXpath = "//*[@id='benchmarkTable']/table/tbody/tr["
				+ x + "]/td[4]/div/div";
		by = By.xpath(cellAdvancedXpath);
		WebElement advancedElement = getElement(by);
		// these vars are for the high and low values in each column to verify
		// there are no gaps

		reportLog("***************2**********************");
		// Get text for headings
		String col1hdXpath = "//*[@id='benchmarkTable']/table/thead/tr/th[2]/div/span";
		by = By.xpath(col1hdXpath);
		WebElement col1Element = getElement(by);
		String col1Text = col1Element.getText();
		String col2hdXpath = "//*[@id='benchmarkTable']/table/thead/tr/th[3]/div/span";
		by = By.xpath(col2hdXpath);
		WebElement col2Element = getElement(by);
		String col2Text = col2Element.getText();
		String col3hdXpath = "//*[@id='benchmarkTable']/table/thead/tr/th[4]/div/span";
		by = By.xpath(col3hdXpath);
		WebElement col3Element = getElement(by);
		String col3Text = col3Element.getText();
		String col4hdXpath = "//*[@id='benchmarkTable']/table/thead/tr/th[5]/div/span";
		by = By.xpath(col4hdXpath);
		WebElement col4Element = getElement(by);
		String col4Text = col4Element.getText();
		reportLog("***************3**********************");
		reportLog(stdValue+"^^^^^^^^^^^^^^^^^^^^^"+(yearElement.getText()));

		if (stdValue.contains(yearElement.getText())) {
			reportLog("Year matches");
		} else {
			reportLog("Year does not match expected value");
			return false;
		}
		if (stdValue.contains(col1Text + "=" + belowElement.getText())) {
			reportLog(col1Text+" matches");
		} else {
			reportLog(col1Text+" does not match expected value");
			return false;
		}
		if (stdValue.contains(col2Text + "=" + basicElement.getText())) {
			reportLog(col2Text+" matches");
		} else {
			reportLog(col2Text+" does not match expected value");
			return false;
		}
		if (stdValue.contains(proficientElement.getText())) {
			reportLog(col3Text+" matches");
		} else {
			reportLog(col3Text+" does not match expected value");
			return false;
		}
		if (stdValue.contains(advancedElement.getText())) {
			reportLog(col4Text+" matches");
		} else {
			reportLog(col4Text+" does not match expected value");
			return false;
		}

		return true;
	}

	public boolean areValuesConnected(String stdValue, Integer x) {
		reportLog("***************4**********************");
String cellBelowXpath = "//*[@id='benchmarkTable']/table/tbody/tr[" + x
				+ "]/td[1]/div/div";
		By by = By.xpath(cellBelowXpath);
		WebElement belowElement = getElement(by);
		String cellBasicXpath = "//*[@id='benchmarkTable']/table/tbody/tr[" + x
				+ "]/td[2]/div/div";
		by = By.xpath(cellBasicXpath);
		WebElement basicElement = getElement(by);
		String cellProficientXpath = "//*[@id='benchmarkTable']/table/tbody/tr["
				+ x + "]/td[3]/div/div";
		by = By.xpath(cellProficientXpath);
		WebElement proficientElement = getElement(by);
		String cellAdvancedXpath = "//*[@id='benchmarkTable']/table/tbody/tr["
				+ x + "]/td[4]/div/div/span";
		by = By.xpath(cellAdvancedXpath);
		WebElement advancedElement = getElement(by);
		// get the values to connect
		reportLog("***************5**********************");
String[] parts = belowElement.getText().split("-");
		String col1HiValue = parts[1];
		parts = basicElement.getText().split("-");
		String col2LoValue = parts[0];
		String col2HiValue = parts[1];
		parts = proficientElement.getText().split("-");
		String col3LoValue = parts[0];
		String col3HiValue = parts[1];
		String col4LoValue = advancedElement.getText();
		String regex = "[0-9]+";

		reportLog("***************6**********************");
		reportLog(col1HiValue+"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+col2LoValue);

if (!check_for_gaps(col1HiValue, col2LoValue)) {
			return false;
		}
		if (!check_for_gaps(col2HiValue, col3LoValue)) {
			return false;
		}
		if (!check_for_gaps(col3HiValue, col4LoValue)) {
			return false;
		}
		return true;

	}

	public boolean check_for_gaps(String highval, String lowval) {
		String regex = "[0-9]+";
		if (highval.equals("BR2000")) {
			// loval must be either BR or 100
			if (lowval.equals("BR2000")) {
				// System.out.println("both BR");
				return true;
			} else if (Integer.parseInt(lowval) == 100) {
				// System.out.println(" BR and 100");
				return true;
			} else {
				// System.out.println("Low value is invalid " +lowval);
				return false;
			}
		} else if (highval.matches(regex)) {
			// Col1+1 must equal col2
			if ((Integer.parseInt(highval) + 1) == Integer.parseInt(lowval)) {
				// System.out.println("high val + 1 ==  Low val ");
				return true;
			} else {
				// System.out.println("Gap or overlap beween values ");
				return false;
			}
		} else {
			// System.out.println("The value is invalid. "+highval);
			return false;
		}
	}

	public boolean selectBenchmarkAndSave(String benchmarkName) {
		// String xpath = "//ul[@class='dropdown-menu']/li[a[text()='"+
		// benchmarkName +"']]";
		this.reportLog(benchmarkName);
		this.reportLog("Select Benchmark item from Dropdown");
		if (benchmarkName.equals("Global English Language Learners")) {
			this.reportLog("found GELL");
			benchmarkGELL.click();
		} else if (benchmarkName.equals("LitPro Standard")) {
			this.reportLog("found LPS");
			benchmarkLPS.click();
			this.reportLog("clicked LPS");
		}

		this.reportLog("Click Benchmark Save button");
		this.click(this.saveBtn);
		reportLog("save clicked");
		return false;
	}

	public String getNotificationText() {
		String notiString = this.getText(saveNotification).trim();
		this.reportLog("Notification Text- " + notiString);
		return notiString;
	}

	public void clickSmartBarArrow() {
		smartbarArrow.click();
		reportLog("smartbar arrow clicked");
	}

	public void selectClass(String className) {
		reportLog("Select Class");
		smartbarClass.click();
	}

	public boolean DublicateBenchmarksVerify() {
		reportLog("Verifying dublicate benchmarks");
		List<WebElement> booktitle = this.getElements(By
				.xpath("//*[@id='benchmarks']//ul/li/a"));

		Set<String> set = new HashSet<String>();
		for (int i = 1; i <= booktitle.size(); i++) {
			String title = driver
					.findElement(
							By.xpath("//*[@id='benchmarks']//ul/li[" + i
									+ "]/a")).getText().trim();
			set.add(title);
		}
		System.out.println("Size of set " + (set.size()));
		System.out.println("Size of benchmark present in dropdown "
				+ booktitle.size());

		if (set.size() == booktitle.size()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}
}
