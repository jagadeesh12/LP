package com.scholastic.intl.litpro.test.automation.pageobjects.slz;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;

public class SlzOrderDetailsPg extends ParentPage {
	WebDriver driver;
	

	@FindBy(xpath = ".//*[@ng-show='account.enabled']//a")
	private WebElement slzLink;
	@FindBy(xpath = ".//*[@name='orgName']")
	private WebElement orgName;
	@FindBy(xpath = ".//*[@name='streetName']")
	private WebElement strtName;
	@FindBy(xpath = ".//*[@name='localityName']")
	private WebElement loclName ;
	@FindBy(xpath = ".//*[@name='customerGroup']")
	private WebElement custGrp;
	@FindBy(xpath = ".//*[@name='customerType']")
	private WebElement custype;
	@FindBy(xpath = ".//*[@name='orgType']")
	private WebElement orgType;
	@FindBy(xpath = ".//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath = ".//button[contains(text(),'Ok')]")
	private WebElement okButton;
	
	
	
	
	
	public SlzOrderDetailsPg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}
	
	public SlzMngUserPg clickSlzLink(){
		if(slzLink!=null){
			this.sync(slzLink);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", slzLink);
			 //lpLink.click();
            this.switchToNewWindow();
            return new SlzMngUserPg(driver);
		}
		else{
			this.reportLog("Slz link not displayed");
			return null;
		}
		
		
		
	}

	public boolean slzLinkDetailsDisplayed() {
		lazyWait(5);
		return this.slzLink.isDisplayed();
		
	}
	
}
