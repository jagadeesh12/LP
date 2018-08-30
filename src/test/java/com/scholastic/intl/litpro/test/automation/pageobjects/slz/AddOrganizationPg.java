package com.scholastic.intl.litpro.test.automation.pageobjects.slz;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

public class AddOrganizationPg extends ParentPage {
	WebDriver driver;
	TestBase testBase = TestBaseProvider.getTestBase();

	@FindBy(xpath = ".//*[@name='country']")
	private WebElement selectCountry;
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
	
	
	
	
	
	public AddOrganizationPg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}
	
	
	public void addDetailsCreateOrganisation(String orgName1 , String custGroup,String CustType,String OrgType){
		Slzobj obj1 = new Slzobj();
		String orgname = obj1.getOrgname();
		clickAddOrganisation();
		selectCountry();
		orgName.sendKeys(orgName1);	
		System.out.println(orgName1);
		strtName.sendKeys("randomstreet");
		loclName.sendKeys("randomlocality");
		selectCustomerGroup(custGroup);
		selectCustomerType(CustType);
		selectOrgType(OrgType);
		submitButton.click();
		
	}
	
	public void selectCountry(){
		//int i =genRandomNumber(0,20);
		/*Select dropdown = new Select(selectCountry);
		
		dropdown.selectByIndex(1);*/
		int i = genRandomNumber(0, 20);
		Select dropdown = new Select(selectCountry);
		String VisibleText = null;
		String zone = testBase.getContext().getString("zone");
		if(zone.equals("3")){
			System.out.println("insideeeeeeeeee"+zone );
			VisibleText="United Kingdom";
		}
		else
		if(zone.equals("5")){
			VisibleText="China";	
		}
		else
			if(zone.equals("2")){
				VisibleText="Student_Upload_TemplateIND.csv";	
		}
		else
		if(zone.equals("1")){
			VisibleText="Student_Upload_TemplateUS.csv";	
		}
		dropdown.selectByVisibleText(VisibleText);;
		
		
	}
public int genRandomNumber(int min , int max ){
	
    int diff=max-min;
    Random rn = new Random();
    int i = rn.nextInt(diff+1);
	return i;
    
}
public void selectCustomerGroup(String custGourp){
	Select dropdown = new Select(custGrp);
		dropdown.selectByVisibleText(custGourp);	
	
}
public void selectCustomerType (String custrtype){
	Select dropdown = new Select(custype);
		dropdown.selectByVisibleText(custrtype);	
	
}	

public void selectOrgType (String OrgType){
	Select dropdown = new Select(orgType);
		dropdown.selectByVisibleText(OrgType);	
	
}
public void clickAddOrganisation(){
	lazyWait(5);
	this.sync(driver.findElement(By.xpath(".//*[@class='nav nav-pills pull-left']/li[3]/a[contains(text(),'Accounts')]")));
	Actions act = new Actions(driver);
	//act.clickAndHold(driver.findElement(By.xpath(".//*[@class='nav nav-pills pull-left']/li[3]/a[contains(text(),'Accounts')]"))).click(driver.findElement(By.xpath(".//ul/li[3]/ul/li[1]/a"))).build().perform();
	act.click(driver.findElement(By.xpath(".//*[@class='nav nav-pills pull-left']/li[3]/a[contains(text(),'Accounts')]"))).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
	}

public String getSucessMessage(){
	//System.out.println(this.getElement(By.xpath(".//*[@class='alert alert-success']/span")).getText());
	return this.getElement(By.xpath(".//*[@class='alert alert-success']/span")).getText();
	
}
public CreateOrderPg clickOkButton(){
	this.getElement(By.xpath(".//button[contains(text(),'Ok')]")).click();
	return new CreateOrderPg(driver);
}



}
