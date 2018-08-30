package com.scholastic.intl.litpro.test.automation.pageobjects.slz;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import com.thoughtworks.selenium.webdriven.commands.Submit;
import com.scholastic.intl.litpro.test.automation.keys.Keys.HomePageLocators;
import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;


public class CreateOrderPg extends ParentPage {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();
	@FindBy(xpath = ".//*[@name='country']")
	private WebElement selectCountry;
	@FindBy(xpath = ".//*[@name='orgName']")
	private WebElement orgName;
	@FindBy(xpath = ".//*[@name='inVoiceNumber']")
	private WebElement invoiceNumber;
	@FindBy(xpath = ".//button[contains(text(),'Add Order Line')]")
	private WebElement addOrderLine;
	@FindBy(xpath = ".//*[@ng-model='initProduct']")
	private WebElement intProductChkbox;
	@FindBy(xpath = ".//*[@name='initProductId']")
	private WebElement intlProductDropdown;
	@FindBy(xpath = ".//*[@name='initProductLan']")
	private WebElement intlProductLang;
	@FindBy(xpath = ".//*[@ng-model='product.salesRepId']")
	private WebElement salesRepId;
	@FindBy(xpath = ".//*[@ng-model='product.orderTypeId']")
	private WebElement orderType;
	@FindBy(xpath = ".//*[@ng-model='product.licenseCount']")
	private WebElement licenseCount;
	@FindBy(xpath = ".//*[@ng-model='product.salesAmount']")
	private WebElement salesAmount;
	@FindBy(xpath = ".//button[contains(text(),'Create Order Line')]")
	private WebElement createOrderLine;
	@FindBy(xpath = ".//button[contains(text(),'Create Order')]")
	private WebElement createOrder;
	@FindBy(id = "quicksearchQuery")
	private WebElement searchBox;
	
	

	public CreateOrderPg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public void CreateOrder(String orgname, String CustType, String OrgType) {
		this.getElement(By.xpath(".//*[@href='#/createOrder']")).click();
		lazyWait(5);
		selectCountry();
		//driver.navigate().refresh();
		waitForPageLoad(5);
		lazyWait(10);
		//selectCountry();
		System.out.println(orgname);
		orgName.sendKeys(orgname);
		lazyWait(10);
		lazyWait(3);
		driver.findElement(By.xpath(".//*[@class='createorder-dropdown']/ul/li[1]/ul")).click();
		lazyWait(5);
		invoiceNumber.sendKeys("12");
		addOrderLine.click();

	}

	public void CreateOrderLine(String product, String productType, String email) {
		waitForPageLoad(2);
		selectProductChkBox();
		//waitForPageLoad(10);
		lazyWait(5);
		selectIntlProduct(productType);
		selectIntlLang("en_us");
		waitForPageLoad(3);
		selectSalesRepEmail(email);
		selectOrderType("Normal");
		licenseCount.sendKeys("30");
		salesAmount.sendKeys("12");
		createOrderLine.click();

	}
//Needs to Change Index
	public void selectCountry() {
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

	public int genRandomNumber(int min, int max) {

		int diff = max - min;
		Random rn = new Random();
		int i = rn.nextInt(diff + 1);
		return i;

	}

	public void selectSalesRepEmail(String custGourp) {
		Select dropdown = new Select(salesRepId);
		dropdown.selectByIndex(2);

	}

	public void selectIntlLang(String custrtype) {
		Select dropdown = new Select(intlProductLang);
		dropdown.selectByVisibleText(custrtype);

	}

	public void selectIntlProduct(String orgtype) {
		Select dropdown = new Select(intlProductDropdown);
		dropdown.selectByVisibleText(orgtype);

	}

	public void selectOrderType(String custrtype) {
		Select dropdown = new Select(orderType);
		dropdown.selectByVisibleText(custrtype);

	}

	public void clickAddOrganisation() {
		Actions act = new Actions(driver);
		act.moveToElement(driver
				.findElement(By.xpath(".//*[@class='nav nav-pills pull-left']/li[3]/a[contains(text(),'Accounts')]")))
				.click(driver.findElement(By.xpath(".//ul/li[3]/ul/li[1]/a"))).build().perform();
	}

	public String getSucessMessage() {
		return this.getElement(By.xpath(".//*[@class='modal-body']/div[3]/span")).getText();

	}

	public void clickOkButton() {
		this.getElement(By.xpath(".//button[contains(text(),'Ok')]")).click();
	}

	public void selectProductChkBox() {
		if (!intProductChkbox.isSelected()) {
			intProductChkbox.click();
		}
	}

	public boolean isOrderLineDisplayed() {
		if (this.getElement(By.xpath(".//*[@class='table table-bordered orderLinesTab']//tbody/tr/td[1]"))
				.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickAddOrderLine() {
		this.addOrderLine.click();
	}

	public void clickCreateOrderButton() {
		this.sync(createOrder);
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
			
	        executor.executeScript("arguments[0].click();", createOrder);
	}

	public String getSuccessOrderMessage() {
             lazyWait(5);
		return this.getElement(By.xpath(".//*[@class='text-success']/span")).getText();

	}

	public void clickSearchGroupAdmin() {
		Actions act = new Actions(driver);
		//act.clickAndHold(driver.findElement(By.xpath(".//*[@class='nav nav-pills pull-left']/li[5]/a[contains(text(),'Groups')]"))).click(driver.findElement(By.xpath(".//*[@href='#/searchAdmin']"))).build().perform();


		act.click(driver.findElement(By.xpath(".//*[@class='nav nav-pills pull-left']/li[5]/a[contains(text(),'Groups')]"))).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		
	}

	public void searchSchool(String schl) {
		this.sync(searchBox);
		this.getElement(By.id("quicksearchQuery")).sendKeys(schl);
		this.getElement(By.xpath(".//*[@ng-click='quickSearch()']")).click();
		
	}

	public boolean isSchoolDisplayed(String schl) throws InterruptedException {
		boolean flag =false;
		Thread.sleep(10000);
		this.sync(driver.findElement(By.xpath(".//section/table[1]/tbody/tr/td[2]")));
		List<WebElement> ele = this.getElements(By.xpath(".//section/table[1]/tbody/tr/td[2]"));
		for(WebElement e : ele ){
			if(e.getText().equalsIgnoreCase(schl)){
				flag = true;
			}
			
		}
		return flag;
		
	}

	public void selectSchool(String schl) {
		this.sync(driver.findElement(By.xpath(".//section/table[1]/tbody/tr/td[2]")));
		List<WebElement> ele = this.getElements(By.xpath(".//section/table[1]/tbody/tr/td[2]"));
		for(WebElement e : ele ){
			if(e.getText().equalsIgnoreCase(schl)){
			e.click();
			}
			
		}
		
	}

	public String getHeader() throws InterruptedException {
		Thread.sleep(5000);
		return this.sync(driver.findElement(By.xpath(".//div[1]/h3"))).getText();
		
	}
	
	
}
