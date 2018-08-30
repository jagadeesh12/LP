package com.scholastic.intl.litpro.test.automation.pageobjects.slz;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
//import stepdefination.SharedDriver;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;

public class SlzCSRHomePg extends ParentPage {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//div[@id='globalNav']//li[contains(text(),'Logged in as')]")
	private WebElement loggedInAsText;
	
	@FindBy(xpath = "//form[@id='slz-customer-quicksearch-form']/input[@name='keystring' and @type='text']")
	private WebElement quickSearchTxtBx;
	
	@FindBy(xpath = "//form[@id='slz-customer-quicksearch-form']/button[@type='submit']")
	private WebElement quickSearchBtn;
	
	@FindBy(xpath = "//div[@id='mainContent']/h3[@class='title']")
	private WebElement accountDetailsHeaderTxt;
	
	@FindBy(xpath = "//a[text()='Scholastic Learning Zone']")
	private WebElement linkAccessToCustSlzHome;
	
	
	public SlzCSRHomePg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public String getLoggedInText() {
		return this.getText(accountDetailsHeaderTxt);
	}

	public SlzHomePg searchOrgAndLaunchCustSLZAccount(){
		//String schoolName = SharedDriver.appConfig.getProperty("org.name");
		if(StringUtils.isNotEmpty("schoolName")){
			
			if(!this.quickSearchOrg("schoolName")){
				return null;
			}
			((JavascriptExecutor) driver).executeScript("arguments[0].target='';", linkAccessToCustSlzHome);
			this.lazyWait(2);
			this.click(linkAccessToCustSlzHome);
			return new SlzHomePg(driver);
		}
		return null;
	}
	
	private boolean quickSearchOrg(String orgName){
		this.type(this.quickSearchTxtBx, orgName);
		this.click(this.quickSearchBtn);
		WebElement acHeaderElem = this.getElement(By.xpath("//div[@id='mainContent']/h3[@class='title']"));
		if(acHeaderElem!=null){
			String accountDetailsHdr = acHeaderElem.getText();
			if(StringUtils.isEmpty(accountDetailsHdr)){
				this.reportLog("Couldn't find Org. Make sure you pass the complete Org name");
				return false;
			}
			return true;
		}
		
		return false;
	}	
		

	public boolean isCreateOrderDisplayed() {
		WebElement lpLink = this.getElement(By.xpath(".//*[@href='#/createOrder']"));
		if(lpLink!=null){
			 
			 return true;
		}
		else{
			this.reportLog("Create Order Link is not displayed ");
			return false;
		}
		
	}
	 
}
