package com.scholastic.intl.litpro.automation.pageobjects.joey;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.torque.common.TestBaseProvider;

public class JoeyhomePage extends ParentPage {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();

	public JoeyhomePage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	@FindBy(xpath = "//div[contains(text(),'Welcome,')]")
	private WebElement greetText;
	@FindBy(xpath = ".//*[@id='logotopBar']/div[1]/a/img")
	private WebElement HomePgHeader;
	@FindBy(xpath = ".//*[@href='Logout']")
	private WebElement logOutLink;
	@FindBy(xpath = ".//*[@class='top-search']//input")
	private WebElement searchBar;
	@FindBy(xpath = "(.//*[@class='pull-right']/button[2])[1]")
	private WebElement assesmentbutton;
	@FindBy(xpath = ".//*[@id='title']/h4")
	private WebElement assesmentHeader;
	@FindBy(xpath = ".//*[@id='rightPanelAss']/div[1]/div[2]/a")
	private WebElement testSubmitButton;
	@FindBy(xpath = ".//*[@id='rightPanelAss']/div/div/div[3]/a")
	private WebElement reportOrReview;
	
	
	
	
	

	public boolean isGreetTextDisplayed() {

		return this.sync(greetText).isDisplayed();

	}

	public boolean isJoeyhomePageDisplayed() {

		return this.sync(HomePgHeader).isDisplayed();
	}

	public List<String> getDisplayedTabNames() {
		List<String> tabs = null;
		List<WebElement> tabList = null;
		tabList = this.getElements(By.xpath(".//div[2]/ul/li/a"));
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

	public boolean isSearchBarDisplayed() {
		return this.sync(HomePgHeader).isDisplayed();
	}

	public boolean isLogoutDisplayed() {
		return this.sync(logOutLink).isDisplayed();	
		}

	public void clickAssesmentButton() {
		this.sync(assesmentbutton).click();
		
	}

	public boolean isAssesmentHeaderDisplayed() {
		 return this.sync(assesmentHeader).isDisplayed();
		
	}
	
	public void completeAssessment() {
		boolean flag=false;
		while (!this.isTestOver()) {
			for(int i=1;i<=3;i++){
				flag = false;
				lazyWait(3);
				this.sync(driver.findElement(By.xpath(".//*[@id='rightPanelAss']//li["+i+"]/label"))).click();
				testSubmitButton.click();
				if(!isTheAnswerWrong()){
					System.out.println("answer correct");
					flag=true;
				}
				if(flag)
					break;
				testSubmitButton.click();
			}
			
	}
		testSubmitButton.click();
	}

	private boolean isTheAnswerWrong() {
		boolean flag =false;
		lazyWait(3);
		flag= this.sync(driver.findElement(By.xpath(".//*[@id='rightPanelAss']/div[1]/div[2]/a"))).getText().contains("Retry");
        return flag;	
	}

	private boolean isTestOver() {
		try {
			lazyWait(3);
			if(testSubmitButton.getText().equals("Finish"))
			return true;

		} catch (Exception e) {
		}
		return false;
	}

	public boolean isTestfinished() {
		boolean flag =false;
		lazyWait(3);
		flag= this.sync(reportOrReview).getText().contains("View Reports")||this.sync(reportOrReview).getText().contains("Review");
        return flag;
		
	}
	
}
