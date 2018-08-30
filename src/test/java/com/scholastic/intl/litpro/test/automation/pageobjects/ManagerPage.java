package com.scholastic.intl.litpro.test.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import pageobject.ParentPage;

public class ManagerPage extends ParentPage {
	WebDriver driver;
	final String PAGE_TITLE = "Scholastic";
	SettingsPg lpSettingsPg;

	@FindBy(xpath = "//div[contains(@class,'available-quizzes-modal')]//h3[contains(text(),'Quizzes for')]")
	private WebElement quizModalHeader;


	public ManagerPage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}
	
	
}