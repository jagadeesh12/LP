package com.scholastic.intl.litpro.test.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;

public class TestPg extends ParentPage {
	WebDriver driver;
	final String PAGE_TITLE = "Scholastic Literacy Pro";

	@FindBy(xpath = "//input[contains(@value,'Get Started')]")
	private WebElement launchAssessmentBtn; // this is lets get started button

	@FindBy(xpath = "//div[contains(@class,'test-tab-text')]")
	private WebElement testTabText; // this is lets get started button

	public TestPg(WebDriver driver, LitProUserType userType) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public AssessmentPg launchAssessmentPg() {
		this.reportLog("Launch Assessment Page");
		this.click(launchAssessmentBtn);
		//this.switchToNewWindow();
		return new AssessmentPg(driver);
	}

	public String getGreetingMessage() {
		String txt = this.getText(testTabText);
		return txt;
	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}
}
