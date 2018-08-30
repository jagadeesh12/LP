package com.scholastic.intl.litpro.test.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.scholastic.intl.litpro.automation.pageobjects.joey.JoeyhomePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.lpl.LitProLibraryHomePg;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

public class SlzHomePg extends ParentPage{
	TestBase testBase = TestBaseProvider.getTestBase();
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();

	@FindBy(xpath = "//*[@id='topnav']/p[1]")
	private WebElement studentText;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Hi ')]")
	private WebElement greetText;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'zone=LF')]")
	private WebElement lpProduct;

	@FindBy(xpath = "//*[@id='product-access']/div/ul/li/a/img")
	private WebElement lpIcon;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage users')]")
	private WebElement manageUsersLink;
	
	@FindBy(xpath = "(//table/tbody/tr[1]/td[2])[1]")
	private WebElement StdUsageSessionYTDs;


	public SlzHomePg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public String getUserGreetingText() {
		return this.getText(greetText);
	}

	public String getStudentGreetingText() {
		return this.getText(studentText);
	}

	public LitProHomePg launchLitPro(LitProUserType userType) {
		this.reportLog("Launch LitPro");
		switch (userType) {
		case TEACHER:
			this.closeWelcomePopup();
			break;
		case SCHOOL_ADMIN:
			this.acceptOfToSDialog();
			this.closeWelcomePopup();

			break;
		case STUDENT:
			break;
		case CS_REP:
			break;
		}

		
		if (!this.clickLpProductLink()) {
			this.reportLog("[Error] LitPro product link NOT displayed");
			return null;
		}

		this.switchToNewWindow();
		checknotificationbar();
		

		return new LitProHomePg(driver, userType);
	}

	private boolean checknotificationbar() {
		lazyWait(3);
		WebElement doNotHeaderNotification = this.getElement(By.xpath(".//label[@class='checkbox']/span[contains(text(),'Do not')]"),
				5);
		if (doNotHeaderNotification != null) {
			doNotHeaderNotification.click();
			WebElement welcomePopupOkBtn = this.getElement(By
					.xpath(".//button[contains(text(),'Close')]"));
			if (welcomePopupOkBtn != null) {
				welcomePopupOkBtn.click();
				this.reportLog("Closed Welcome Popup");
				lazyWait(5);
				return true;
			} else {
				this.reportLog("'Ok' button NOT displayed in Welcome popup");
				return false;
			}
		} else {
			this.reportLog("Welcome Popup NOT displayed");
		}
		lazyWait(5);
		return true;
		
	}

	public void goToManageUsersPg() {
		this.reportLog("Go to Manage Users Page");
		this.click(manageUsersLink);
	}

	public boolean closeWelcomePopup() {
		lazyWait(3);
		WebElement doNotShowWelcomeChkBx = this.getElement(By.xpath(".//*[@ng-model='dontShowAgain']"),
				5);
		if (doNotShowWelcomeChkBx != null) {
			doNotShowWelcomeChkBx.click();
			WebElement welcomePopupOkBtn = this.getElement(By
					.xpath(".//button[contains(text(),'Ok')]"));
			if (welcomePopupOkBtn != null) {
				welcomePopupOkBtn.click();
				this.reportLog("Closed Welcome Popup");
				return true;
			} else {
				this.reportLog("'Ok' button NOT displayed in Welcome popup");
				return false;
			}
		} else {
			this.reportLog("Welcome Popup NOT displayed");
		}
		return true;
	}

	/* clicks the Litpro product link on Slz Home */
	public boolean clickLpProductLink() {
		WebElement lpLink = this.getElement(By
				.xpath(".//img[@alt='btn_lf']"));
		if (lpLink != null) {
			lpLink.click();
			return true;
		} else {
			this.reportLog("LitPro product link NOT displayed. If logging in first time, close the welcome popup");
			return false;
		}
	}

	/* accept Terms of service */
	public boolean acceptOfToSDialog() {
		lazyWait(3);
		WebElement dialogWe = this.getElement(By.id("termsOfServicePopup"),
				3);
		if (dialogWe != null) {
			WebElement tosPopupOkBtn = this.getElement(By
					.xpath(".//*[@id='termsOfServicePopup']//button[1]"));
			tosPopupOkBtn.click();
			this.reportLog("Accepted the ToS");
			return true;
		}
		return false;
	}

	public void clickLPIcon() {

		lpIcon.click();
	}

	public LitProLibraryHomePg launchLitProLibrary(LitProUserType userType) throws InterruptedException {
		this.reportLog("Launch LitPro");

		if (!this.clickLpLibraryProductLink()) {
			this.reportLog("[Error] LitProLibrary product link NOT displayed");
			return null;
		}

		this.switchToNewWindow();
		return new LitProLibraryHomePg(driver, userType);
	}
 
	/*clicks the LitproLib product link on Slz Home*/
	public boolean clickLpLibraryProductLink() throws InterruptedException{
		driver=TestBaseProvider.getTestBase().getDriver();
		this.sync(this.getElement(By.xpath(".//*[@alt='btn_ebb']")));
		 WebElement lpLink = this.getElement(By.xpath(".//*[@alt='btn_ebb']"));
			if(lpLink!=null){
				
				JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", lpLink);
				 //lpLink.click();
				 return true;
			}
			else{
				this.reportLog("LitProLbrary product link NOT displayed. If logging in first time, close the welcome popup");
				return false;
			}
	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}
	public JoeyhomePage launchJoey(LitProUserType userType) throws InterruptedException {
		this.reportLog("Launch LitPro");

		if (!this.LaunchJoeyLink()) {
			this.reportLog("[Error] Joey product link NOT displayed");
			return null;
		}

		this.switchToNewWindow();
		return new JoeyhomePage(driver);
	}

	public boolean LaunchJoeyLink() {
		driver=TestBaseProvider.getTestBase().getDriver();
		this.sync(this.getElement(By.xpath(".//*[@alt='btn_ppl']")));
		 WebElement lpLink = this.getElement(By.xpath(".//*[@alt='btn_ppl']"));
			if(lpLink!=null){
				
				JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", lpLink);
				 //lpLink.click();
				 return true;
			}
			else{
				this.reportLog("Joey product link NOT displayed. If logging in first time, close the welcome popup");
				return false;
			}
		
	}
	
	static String StdUsageSessionYTD;
	static String StdUsageMinYTD;
	static String LPLwaitTime;
	
	public void StudentLPLSession(){
		lazyWait(5);
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@ng-change='studentUsageForStudentLogin();']")));
		dropdown.selectByVisibleText("Sessions");
		StdUsageSessionYTD = getText(StdUsageSessionYTDs);
		System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''"+StdUsageSessionYTD);
	}
	
	public void StudentLPLMinutes(){
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@ng-change='studentUsageForStudentLogin();']")));
		dropdown.selectByVisibleText("Minutes");
		lazyWait(2);
		StdUsageMinYTD = getText(StdUsageSessionYTDs).replace("min", "").trim();
		System.out.println("''''''''''''''''''''''22'''''''''''''''''''''''''''''''''''''"+StdUsageMinYTD);
	}
	
	public void WaitinLPL(){
		lazyWait(68);		
	}
	
	public void launchRPLLPL(){
		click(LPLIcon);
		switchToNewWindow();
	}
	
	public void logout(){
		this.sync(stdprofile).click();
		click(logOut);
		switchToNewWindow();
	}

	@FindBy(css = ".btn.lpl-profile-sign-out")
	private WebElement logOut;
	
	@FindBy(css = ".dropdown-toggle.ng-binding")
	private WebElement stdprofile;
	
	@FindBy(xpath = "//img[@ng-src='https://qa-cdn.scholasticlearningzone.com/intl/assets/r2.3.3/slz-portal/images/btn_ebb.png']")
	private WebElement LPLIcon;
	
	public boolean VerifyUsagereport(){
		boolean result = false;
		driver.navigate().refresh();
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@ng-change='studentUsageForStudentLogin();']")));
		dropdown.selectByVisibleText("Sessions");
		lazyWait(2);
		int AfterStdUsageSessionYTD = Integer.parseInt(getText(StdUsageSessionYTDs));
		
		dropdown = new Select(driver.findElement(By.xpath("//select[@ng-change='studentUsageForStudentLogin();']")));
		dropdown.selectByVisibleText("Minutes");
		lazyWait(2);
		int AfterStdUsageMinYTD = Integer.parseInt(getText(StdUsageSessionYTDs).replace("min", "").trim());
		
		int BeforeStdUsageSessionYTD = Integer.parseInt(StdUsageSessionYTD);
		int BeforeStdUsageMinYTD = Integer.parseInt(StdUsageMinYTD);
		
		if(BeforeStdUsageSessionYTD < AfterStdUsageSessionYTD && BeforeStdUsageMinYTD<AfterStdUsageMinYTD){
			reportLog("Usage reprot of LPL is showing increase in Sessions and Minutes after student login");
			result = true;
		}
		return result;
	}
	
	public void SchoolName(String Schoolname){
		reportLog("Clicking on the roster tree of "+Schoolname);
		lazyWait(2);
		String xpath="//ul/li/span[contains(text(),'"+Schoolname+"')]/parent::li/i[1]";
		System.out.println("-----------------------"+xpath);
		click(driver.findElement(By.xpath(xpath)));
	}
	
	public void StudName(String StudName){
		reportLog("Clicking on the roster tree of "+StudName);
		lazyWait(2);
		String xpath="//ul/li/span[contains(text(),'"+StudName+"')]";
		System.out.println("-----------------------"+xpath);
		click(driver.findElement(By.xpath(xpath)));
	}
	
	public boolean UsageDetailCompare(){
		boolean result = false;
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@ng-change='studentLevelApps();']")));
		dropdown.selectByVisibleText("Sessions");
		lazyWait(2);
		int AfterStdUsageSessionYTD = Integer.parseInt(getText(StdUsageSessionYTDt));
		
		dropdown = new Select(driver.findElement(By.xpath("//select[@ng-change='studentLevelApps();']")));
		dropdown.selectByVisibleText("Minutes");
		lazyWait(2);
		int AfterStdUsageMinYTD = Integer.parseInt(getText(StdUsageSessionYTDt).replace("min", "").trim());
		
		int BeforeStdUsageSessionYTD = Integer.parseInt(StdUsageSessionYTD);
		int BeforeStdUsageMinYTD = Integer.parseInt(StdUsageMinYTD);
		
		if(BeforeStdUsageSessionYTD == AfterStdUsageSessionYTD && BeforeStdUsageMinYTD==AfterStdUsageMinYTD){
			reportLog("Usage reprot of LPL is same for teacher and student");
			result = true;
		}
		return result;
	}
	
	@FindBy(xpath = "(//table/tbody/tr[1]/td[2])[3]")
	private WebElement StdUsageSessionYTDt;
}
