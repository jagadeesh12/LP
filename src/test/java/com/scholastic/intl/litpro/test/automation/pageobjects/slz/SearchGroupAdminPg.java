package com.scholastic.intl.litpro.test.automation.pageobjects.slz;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;

public class SearchGroupAdminPg extends ParentPage {
	WebDriver driver;
	

	@FindBy(xpath = ".//*[@id='searchUser']")
	private WebElement searchTextbox;
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
	
	
	
	
	
	public SearchGroupAdminPg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}
	
	public void searchAdmin(String admin){
		this.sync(searchTextbox).sendKeys(admin);
		this.sync(driver.findElement(By.xpath(".//button[contains(text(),'Search')]"))).click();
		
	}
	
	//.//*[@id='searchUser']
	
	
	public boolean isSearchedAdminDisplayed(String admin){
		if (this.sync(driver.findElement(By.xpath(".//*[@href='#/adminDetails']"))).getText().contains(admin)) 
		return true;
		return false;
		
	}
}
