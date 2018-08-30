package com.scholastic.intl.litpro.test.automation.pageobjects.slz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;


public class SlzManageUsersPg extends ParentPage {
	WebDriver driver;
	 
//	@FindBy(xpath = "//h2[contains(text(), 'Benchmark Proficiency Bands for')]")
//	 WebElement pgHeader;

	
	@FindBy(id = "create-drop-down")
	private WebElement userTypeSelect;

	@FindBy(id = "create-ssu-user")
	private WebElement createUserButton;

	@FindBy(id = "create-ssu-single-user")
	private WebElement addUserForm;

	@FindBy(id = "username")
	private WebElement userNameTxtBx;
	
	@FindBy(id = "firstname")
	private WebElement firstnameTxtBx;
	
	@FindBy(id = "lastname")
	private WebElement lastnameTxtBx;
	
	@FindBy(id = "password")
	private WebElement passwordTxtBx;
	
	@FindBy(id = "confirm_password")
	private WebElement confirmPasswordTxtBx;
	
	@FindBy(id = "districtid")
	private WebElement districtIdTxtBx;
	
	@FindBy(id = "lexile")
	private WebElement lexileTxtBx;
	
	@FindBy(id = "import_grade")
	private WebElement gradeSelect;
	
	@FindBy(id = "add-class-autocomplete")
	private WebElement studAddClass;
	
	@FindBy(id = "//button[span[text(),'Submit']]")
	private WebElement submitBtn;
		
	@FindBy(xpath = "//*[@id='option1']/h3")
	private WebElement createuserLabel;
	
	public SlzManageUsersPg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}
	
	public void selectAddUserType(String userTypeString){		
		this.reportLog("Select User Type: " + userTypeString);
		Select select = new Select(this.sync(userTypeSelect));
		select.selectByVisibleText(userTypeString);
	}
	
	public void clickCreateButton(){
		this.reportLog("Click Create Button");
		this.click(this.createUserButton);
	}
	
	public void createStudent() throws Throwable{
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("DHHmmssSSS");
		String timestamp = ft.format(dNow);
		String student ="jb"+timestamp;
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(student);
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Jerome" + timestamp);
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("Brown" + timestamp);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("welcome1");
		driver.findElement(By.id("confirm_pasword")).clear();
		driver.findElement(By.id("confirm_pasword")).sendKeys("welcome1");
		driver.findElement(By.id("districtid")).clear();
		driver.findElement(By.id("districtid")).sendKeys(student);
		driver.findElement(By.id("lexile")).clear();
		driver.findElement(By.id("lexile")).sendKeys("444");
		new Select(driver.findElement(By.id("import_grade"))).selectByVisibleText("Grade 4");
		driver.findElement(By.id("add-class-autocomplete")).sendKeys("Math");
		driver.findElement(By.id("add-class-autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("add-class-autocomplete")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//button[@type='button']")).click();		
	}

	public boolean verifySingleUserPopup() {		
		if(driver.findElement(By.id("ui-dialog-title-dialog-form")).getText().equals("Add single user"))	
			return true;
		else
			return false;
	}
		
	public boolean verifyManageUsersPg(){
		String str;		 
		str = createuserLabel.getText();
		if (str.equals("Create New User"))
			return true;	 
		else 
			return false;			 		 
	}
	
	public boolean verifyStudentCreated(){
		if(driver.findElement(By.xpath("//div[@id='instructions']/h4")).getText().equals("Option 2: Create a new user"))	
			return true;
		else
			return false;
	}
}
