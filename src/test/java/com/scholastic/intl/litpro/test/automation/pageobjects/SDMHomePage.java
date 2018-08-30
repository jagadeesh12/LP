package com.scholastic.intl.litpro.test.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.scholastic.intl.litpro.test.automation.keys.Keys.HomePageLocators;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.torque.common.WaitUtils;
import com.scholastic.torque.webdriver.ExtendedElement;

public class SDMHomePage extends ParentPage implements HomePageLocators {
	@FindBy(xpath = "//div[@id='schoolProductsDiv']/div[1]")
	private WebElement ReadingProIconTchr;
	@FindBy(xpath = "//div[@id='schoolProductsDiv']/div[2]")
	private WebElement ReadingProLibIconTchr;
	@FindBy(xpath = "//div[@id='studentProductLaunch']/div[1]/img")
	private WebElement ReadingProIconStudnt;
	@FindBy(xpath = "//div[@id='studentProductLaunch']/div[2]/img")
	private WebElement ReadingProLibIconStudnt;
	@FindBy(xpath = "//div[@class='subscriptionLogoDiv ng-scope']/div[1]/div[@class='subscriptionAppInfo']/button[text()='LAUNCH']")
	private WebElement ReadingProIconAdmn;
	@FindBy(xpath = "//div[@class='subscriptionLogoDiv ng-scope']/div[3]/div[@class='subscriptionAppInfo']/button[text()='LAUNCH']")
	private WebElement ReadingProLibIconAdmn;
	

	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	
	public SDMHomePage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}


	public void launchRP(LitProUserType userType) {
		switch(userType) {
		case TEACHER:
			WaitUtils.waitForDisplayed(ReadingProIconTchr);
			click(ReadingProIconTchr);
			break;
			
		case STUDENT:
			WaitUtils.waitForDisplayed(ReadingProIconStudnt);
			click(ReadingProIconStudnt);
			break;
			
		case SCHOOL_ADMIN:
			WaitUtils.waitForDisplayed(ReadingProIconAdmn);
			click(ReadingProIconAdmn);
			break;
		}
	}

	
	public void launchRPL(LitProUserType userType){
		switch(userType) {
		case TEACHER:
			WaitUtils.waitForDisplayed(ReadingProLibIconTchr);
			click(ReadingProLibIconTchr);
			break;
			
		case STUDENT:
			WaitUtils.waitForDisplayed(ReadingProLibIconStudnt);
			click(ReadingProLibIconStudnt);
			break;
			
		case SCHOOL_ADMIN:
			WaitUtils.waitForDisplayed(ReadingProLibIconAdmn);
			click(ReadingProLibIconAdmn);
			break;
		}
	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}

}
