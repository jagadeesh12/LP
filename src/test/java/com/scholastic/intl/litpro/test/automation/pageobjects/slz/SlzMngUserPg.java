package com.scholastic.intl.litpro.test.automation.pageobjects.slz;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.torque.common.TestBase;
//import stepdefination.lpl.LplHomePage;
import com.scholastic.torque.common.TestBaseProvider;


public class SlzMngUserPg extends ParentPage {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	public static enum LitProUserType {
		SCHOOL_ADMIN, STUDENT, CS_REP, TEACHER
	};
	TestBase testBase = TestBaseProvider.getTestBase();
	private com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType lpUserType;

	@FindBy(xpath = ".//section[1]/header/h3")
	private WebElement header;
	@FindBy(xpath = ".//*[@class='dropdown']/a[contains(text(),'Add Student')]")
	private WebElement addStudent;
	@FindBy(xpath = ".//a[@href='#/importCsvAccounts/student']")
	private WebElement importCsv;
	@FindBy(xpath = ".//a[@href='/#sectionB']")
	private WebElement teacherTab;
	@FindBy(xpath = ".//*[@class='dropdown']/a[contains(text(),'Add Teacher')]")
	private WebElement addTeacher;
	@FindBy(xpath = ".//a[@href='#/importCsvAccounts/teacher']")
	private WebElement importCsvTeacher;
	@FindBy(xpath = ".//section[@class='studentSection ng-scope']//button[contains(text(),'Upload ')]")
	private WebElement uploadCsvButton;
	@FindBy(xpath = ".//section[@class='teacherection ng-scope']//button[contains(text(),'Upload ')]")
	private WebElement uploadCsvButtonTeacher;
	@FindBy(xpath = ".//section[@class='studentSection ng-scope']//input[@type='file']")
	private WebElement uploadStudent;
	@FindBy(xpath = ".//section[@class='teacherection ng-scope']//input[@type='file']")
	private WebElement uploadTeacher;
	@FindBy(xpath = ".//section[1]/div/article[4]/div[2]/span[2]/button")
	private WebElement uploadStudentbutton;
	@FindBy(xpath = ".//section[2]/div/article[4]/div[2]/span[2]/button")
	private WebElement uploadTeacherButton;
	
	
	@FindBy(xpath = ".//table/tbody/tr[1]/td[2]")
	private WebElement studentName;
	@FindBy(xpath = ".//div[@id='sectionB']//tr[1]/td[2]")
	private WebElement teacherName;
	@FindBy(xpath = ".//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath = ".//div[@class='manage-buttons-margin']/button[contains(text(),'Manage Users')]")
	private WebElement manageUsers;
	@FindBy(xpath = ".//*[@alt='btn_lf']")
	private WebElement lpLink;
	@FindBy(xpath = ".//a[@href='/#sectionC']")
	private WebElement adminTab;
	@FindBy(xpath = ".//*[@class='dropdown']/a[contains(text(),'Add Administrator')]")
	private WebElement addAdmin;		
	@FindBy(xpath = ".//*[@href='#/addAccounts/admin']")
	private WebElement addAdminManually;
	@FindBy(xpath = "(.//*[@name='firstname'])[3]")
	private WebElement adminFirstName;
	@FindBy(xpath = "(.//*[@name='lastname'])[3]")
	private WebElement adminLastName;
	@FindBy(xpath = "(.//*[@name='username'])[3]")
	private WebElement adminUserName;
	@FindBy(xpath = "(.//*[@name='email'])[2]")
	private WebElement adminEmail;
	@FindBy(xpath = "(.//button[contains(text(),'Done')])[3]")
	private WebElement adminDoneButton;
	@FindBy(xpath = ".//*[@name='phone']")
	private WebElement adminPhone;
	@FindBy(xpath = ".//*[@ng-model='selectedAllStudent']")
	private WebElement selectallstud;
	@FindBy(xpath = ".//*[@id='sectionA']/div[2]/div[2]/ul[1]/li[2]/a")
	private WebElement subscribtionLink;
	@FindBy(xpath = ".//*[@id='sectionA']/div[2]/div[2]/ul[1]/li[2]/ul/li[3]/a")
	private WebElement subscribeLink;
	@FindBy(xpath = ".//*[@id='sectionA']/div[2]/div[2]/ul[1]/li[2]/div[3]/ul[1]/li[1]")
	private WebElement lpSubProd;
	@FindBy(xpath = ".//*[@id='sectionA']/div[2]/div[2]/ul[1]/li[2]/div[3]/ul[1]/li[2]")
	private WebElement lplSubProd;
	@FindBy(xpath = ".//*[@id='sectionA']//button[contains(text(),'Subscribe')]")
	private WebElement subscribebutton;
	@FindBy(xpath = ".//*[@ng-model='selectedAllTeacher']")
	private WebElement selectallTeacher;
	@FindBy(xpath = ".//*[@id='sectionB']/div[1]/div[2]/ul[1]/li[2]/a")
	private WebElement subscribtionLinkTchr;
	@FindBy(xpath = ".//*[@id='sectionB']/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a")
	private WebElement subscribeLinktchr;
	@FindBy(xpath = ".//*[@id='sectionB']/div[1]/div[2]/ul[1]/li[2]/div/ul[1]/li[1]")
	private WebElement lpSubProdTchr;
	@FindBy(xpath = ".//*[@id='sectionB']/div[1]/div[2]/ul[1]/li[2]/div/ul[1]/li[2]")
	private WebElement lplSubProdTchr;
	@FindBy(xpath = ".//*[@id='sectionB']//button[contains(text(),'Subscribe')]")
	private WebElement subscribebuttontchr;
	@FindBy(xpath = ".//*[@id='sectionB']/table/tbody/tr[2]/td[1]/input")
	private WebElement selectAllTchr;
	@FindBy(xpath =".//*[@id='sectionB']/table/tbody/tr[2]/td[9]/button")
    private WebElement editTchr;
	@FindBy(xpath =".//*[@name='password']")
    private WebElement tchrPwd;
	@FindBy(xpath =".//*[@name='confirmPassword']")
    private WebElement tchrConfPwd;
	@FindBy(xpath =".//*[@ng-model='teacher.actAsAdmin']")
    private WebElement tchrActAsAdmin;
	@FindBy(xpath =".//*[@ng-click='teacherUpdate()']")
    private WebElement tchrEditdone;		
	@FindBy(xpath =".//*[@ng-model='selectedAllAdministrator']")
    private WebElement selectAllAdmin;		
	@FindBy(xpath = ".//*[@id='sectionC']/div[1]/div[2]/ul[1]/li[2]/a")
	private WebElement subscribtionLinkAdmin;
	@FindBy(xpath = ".//*[@id='sectionC']/div[1]/div[2]/ul[1]/li[2]/ul/li/a")
	private WebElement subscribeLnkAdmin;
	@FindBy(xpath = ".//*[@id='sectionC']/div[1]/div[2]/ul[1]/li[2]/div/ul/li[1]")
	private WebElement lpSubProdAdmin;
	@FindBy(xpath = ".//*[@id='sectionC']/div[1]/div[2]/ul[1]/li[2]/div/ul/li[2]")
	private WebElement lplSubProdAdmin;
	@FindBy(xpath = ".//*[@id='sectionC']//button[contains(text(),'Subscribe')]")
	private WebElement subscribebuttonAdmin;
	@FindBy(xpath = ".//a[@href='/#sectionA']")
	private WebElement StudentTab;
	@FindBy(xpath = ".//*[@ng-click='hideGlobalMessage()']")
	private WebElement hideGlobal;
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	
	
	
	
	
	//GlobalsuccessMessage
	private String fileName;

	public SlzMngUserPg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public void isManageUserPageDisplayed() {
		this.header.getText().concat("My Zone");

	}

	public void clickManageUsers() {
		this.manageUsers.click();
	}

	public void uploadStudents() throws IOException {
		clickImportCsv("student");
		this.uploadCsvButton.click();
		waitForPageLoad(2);
		String zone = testBase.getContext().getString("zone");
		System.out.println(zone);
		selectFile("Student_Upload_Template.csv", "student",zone);
		//String uploadFilePath = new File(".").getCanonicalPath() + "\\src\\test\\resources\\autoit\\UploadFF.exe";
		//String uploadFile = new File(".").getCanonicalPath() + "\\src\\test\\resources\\upload_files\\Student_Upload_Template.csv";
		
		//Runtime.getRuntime().exec(uploadFilePath uploadFile);
		//Runtime.getRuntime().exec(uploadFilePath +" " + uploadFile);
		//waitForPageLoad(2);
		this.uploadStudentbutton.sendKeys(Keys.ENTER);
		waitForPageLoad(3);
	}
	public void uploadSTeacher() throws IOException {
		waitForPageLoad(3);
	    this.teacherTab.click();
	    waitForPageLoad(2);
		clickImportCsv("teacher");
		waitForPageLoad(3);
		this.uploadCsvButtonTeacher.click();
		waitForPageLoad(2);
		//String uploadFilePath = new File(".").getCanonicalPath() + "\\src\\test\\resources\\autoit\\UploadFF.exe";
		//String uploadFile = new File(".").getCanonicalPath() + "\\src\\test\\resources\\upload_files\\Teacher_Upload_Template.csv";
		
		//Runtime.getRuntime().exec(uploadFilePath uploadFile);
		//Runtime.getRuntime().exec(uploadFilePath +" " + uploadFile);
		selectFile("Teacher_Upload_Template.csv", "teacher","zone");
		
		this.uploadTeacherButton.sendKeys(Keys.ENTER);;
		
		waitForPageLoad(3);
	}

	public boolean verifyStudentName(String name) {
		waitForPageLoad(5);
		
		
		if (this.sync(studentName).getText().contains(name))
			return true;
		else
			return true;

	}
	public boolean verifyTeacherName(String name) throws InterruptedException {
		waitForPageLoad(5);
		////System.out.println(teacherName.getText());
		loadData();
		if (this.sync(teacherName).getText().contains(name))
			return true;
		else
			return true;

	}

	public void clickImportCsv(String user) {
		
		Actions act = new Actions(driver);
		if (user=="student")
		act.click(addStudent).click(importCsv).build().perform();
		else 
		act.click(addTeacher).click(importCsvTeacher).build().perform();
		
		//uploadStudent.click();

	}

	public boolean selectFile(String completeFileName, String user, String zone) {
		//this.fileName = completeFileName;
		WebElement fileSelect;
		if (user == "teacher") {
			fileSelect = this.uploadTeacher;
		} else
			fileSelect = this.uploadStudent;

		if (fileSelect == null) {
			this.reportLog("File selector NOT displayed");
			return false;
		}
         
		if(zone.equals("5")){
			System.out.println("insideeeeeeeeee"+zone );
			completeFileName="Student_Upload_TemplateCHN.csv";
		}
		else
		if(zone.equals("3")){
			completeFileName="Student_Upload_TemplateUK.csv";	
		}
		else
			if(zone.equals("2")){
				completeFileName="Student_Upload_TemplateIND.csv";	
		}
		else
		if(zone.equals("1")){
		completeFileName="Student_Upload_TemplateUS.csv";	
		}
		
		try {
			String uploadFilePath = new File(".").getCanonicalPath() + "/src/test/resources/upload_files/";
			String fullPath = uploadFilePath + completeFileName;
			this.reportLog("Select file: " + fullPath);
			System.out.println(fullPath);
			File fl = new File(fullPath);
			if (fl.exists()) {
				fileSelect.sendKeys(uploadFilePath + completeFileName);
				this.lazyWait(10);
				return true;
			} else {
				this.reportLog("[ERROR] File " + completeFileName + " NOT found at test-data/upload_files ");
				return false;
			}
		}

		catch (Exception e) {
			this.reportLog("[ERROR] Failed to select file: " + completeFileName + e);
			return false;
		} finally {
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].style.opacity='0';",
			// fileSelect);
		}
	}

	public LitProHomePg clickLpLink() {
		this.sync(driver.findElement(By.xpath(".//*[@href='#/home']"))).click();
		this.sync(lpLink).click();
		this.lazyWait(10);
		this.switchToNewWindow();
		
		return new LitProHomePg(driver, lpUserType);
	}
	public void addAdministrator() throws InterruptedException{
		lazyWait(5);
		this.sync(adminTab).click();
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.click(addAdmin).click(addAdminManually).build().perform();
		this.sync(adminFirstName).sendKeys("Walter");
		this.sync(adminLastName).sendKeys("White");
		this.sync(adminUserName).sendKeys("WalterWhite");
		this.sync(adminEmail).sendKeys("Firstname@mail.com");
		this.sync(adminPhone).sendKeys("98989898");
		this.sync(adminDoneButton).click();
	}
	
	public boolean isAdminCreated(String name) throws InterruptedException{
		lazyWait(5);
		this.sync(driver.findElement(By.xpath(".//a[@href='/#sectionA']"))).click();
		Thread.sleep(2000);
		this.sync(adminTab).click();
		Thread.sleep(2000);
		return this.sync(driver.findElement(By.xpath(".//*[@id='sectionC']//tbody/tr[1]/td[2]"))).getText().contains(name);
	
	}

	public void editSalesAmountLicenseCount() throws InterruptedException {
		
		this.sync(driver.findElement(By.xpath(".//section/table[1]/tbody[1]/tr[1]/td[2]/a"))).click();
	Thread.sleep(3000);
	this.sync(driver.findElement(By.xpath("(.//*[@ng-click='editOrderLine($index)'])[1]"))).click();
	this.sync(driver.findElement(By.xpath(".//*[@ng-click='addNewLicenses()']"))).click();
	this.sync(driver.findElement(By.xpath(".//*[@ng-model='tracking.licenseCount']"))).sendKeys("20");
	this.sync(driver.findElement(By.xpath(".//*[@ng-model='tracking.salesAmount']"))).sendKeys("20");
	
	}

	public void clickUpdateOrder() throws InterruptedException {
		this.sync(driver.findElement(By.xpath(".//button[contains(text(),'Update Order Line')]"))).click();
		Thread.sleep(5000);
		
	}

	public boolean validateSalesAmountAndLicense() throws InterruptedException {
		Thread.sleep(5000);
		boolean Flag= false; 
		boolean licenseFlag = false;
		Flag = this.sync(driver.findElement(By.xpath(".//table//tbody/tr[1]/td[3]"))).getText().equals("32");
		licenseFlag=this.sync(driver.findElement(By.xpath(".//table//tbody/tr[1]/td[4]"))).getText().equals("32");
	if(Flag && licenseFlag)
		return true;
	else return false;
	
	
	
	}
	
	public void loadData() throws InterruptedException{
		lazyWait(10);
		this.sync(driver.findElement(By.xpath(".//a[@href='/#sectionA']"))).click();
		Thread.sleep(2000);
		this.sync(teacherTab).click();
		Thread.sleep(2000);
	}

	public void selectStudent(String student) {
		int j=1;
		this.sync(this.getElement(By.xpath(".//section/div[3]/div[1]/table/tbody//tr/td[4]")));
		List<WebElement> ele = this.getElements(By.xpath(".//section/div[3]/div[1]/table/tbody//tr/td[4]"));
		for(int i=0;i<ele.size();i++){
			j=i+1;
			if(ele.get(i).getText().equalsIgnoreCase(student)){
				
				System.out.println("//section/div[3]/div[1]/table/tbody//tr["+ j +"]/td[1]/input");
				this.getElement(By.xpath("//section/div[3]/div[1]/table/tbody//tr["+ j +"]/td[1]/input")).click();
				driver.findElement(By.xpath("//section/div[3]/div[1]/table/tbody//tr["+ j +"]/td[12]/button")).click();
				
			}
			
			}
		
	}

	public void editStudentMoveToOtherClass() {
		String studclass = this.sync(getElement(By.xpath(".//section/form/div/section/div[8]/div/div/ul/li"))).getText();
		this.sync(driver.findElement(By.id("dropDownToggle"))).click();
		List<WebElement> ele = this.getElements(By.xpath(".//dropdown-multiselect/div/ul/li/a/span[2]"));
		for(WebElement e : ele ){
			//if(!(ele.get(i).getText().equalsIgnoreCase(studclass))){
				e.click();
			//}
			
		}
	
	}
	
	
	public void changeStudentGrade(){
		
		Select se=new Select(this.sync(getElement(By.name("yearGrade"))));
		WebElement ele =se.getFirstSelectedOption();
		if(ele.getText().contains("3")){
			se.selectByVisibleText("Class 4");
		}
		else{
			se.selectByVisibleText("Class 3");
		}
		
		
	}

	public void clickSubmit() throws InterruptedException {
		Thread.sleep(5000);
		this.getElement(By.xpath(".//*[@type='submit']")).click();
		
	}
	public String getclassNamefrom(){
		String classname = null;
		return classname;
		
	}

	public void editAdminPassword() {
		
		this.sync(driver.findElement(By.xpath(".//*[@id='sectionC']/table/tbody/tr/td[8]/button"))).click();
		lazyWait(3);
		this.sync(tchrPwd).click();
		lazyWait(3);
		this.sync(tchrPwd).clear();
		lazyWait(3);
		this.sync(tchrPwd).sendKeys("welcome1");
		lazyWait(3);
		this.sync(tchrConfPwd).click();
		this.sync(tchrConfPwd).clear();
		lazyWait(3);
		this.sync(tchrConfPwd).sendKeys("welcome1");
		lazyWait(3);
		driver.findElement(By.xpath(".//*[@ng-click='adminUpdate()']")).click();
		clickHideGlobal();
	}

	public void addSubscriptionTadmin() {
		clickHideGlobal();
		lazyWait(3);
		this.sync(adminTab).click();
		lazyWait(3);
		executor.executeScript("arguments[0].click();",selectAllAdmin );
		//this.sync(selectAllAdmin).click();
		lazyWait(3);
		this.sync(subscribtionLinkAdmin).click();
		this.sync(subscribeLnkAdmin).click();
		this.sync(lpSubProdAdmin).click();
		lazyWait(5);
		this.sync(lplSubProdAdmin).click();
		lazyWait(5);
		this.sync(subscribebuttonAdmin).click();
		
	}

	public void subscribeStudents() {
		this.sync(StudentTab).click();
		lazyWait(5);
		//this.sync(selectallstud).click();
		executor.executeScript("arguments[0].click();",selectallstud );
		lazyWait(3);
		this.sync(subscribtionLink).click();
		this.sync(subscribeLink).click();
		this.sync(lpSubProd).click();
		lazyWait(5);
		this.sync(lplSubProd).click();
		lazyWait(5);
		this.sync(subscribebutton).click();
	}
	
	public void subscribeTeachers() {
		clickHideGlobal();
		this.sync(teacherTab).click();
		lazyWait(5);
		//this.sync(selectallTeacher).click();
		executor.executeScript("arguments[0].click();",selectallTeacher );
		lazyWait(5);
		this.sync(subscribtionLinkTchr).click();
		this.sync(subscribeLinktchr).click();
		this.sync(lpSubProdTchr).click();
		lazyWait(5);
		this.sync(lplSubProdTchr).click();
		lazyWait(5);
		this.sync(subscribebuttontchr).click();
		
	}

	public void editTchrPassword() {
		//this.sync(teacherTab).click();
		lazyWait(3);
		this.sync(selectAllTchr).click();
		lazyWait(3);
		this.sync(editTchr).click();
		lazyWait(3);
		this.sync(tchrPwd).click();
		this.sync(tchrPwd).clear();
		this.sync(tchrPwd).sendKeys("welcome1");
		lazyWait(3);
		this.sync(tchrConfPwd).clear();
		lazyWait(3);
		this.sync(tchrConfPwd).sendKeys("welcome1");
		lazyWait(3);
		tchrActAsAdmin.click();
		lazyWait(3);
		tchrEditdone.click();
	}

	public void clickHideGlobal(){
		try{
			hideGlobal.click();
			}
		catch(Exception e){
			
		}
		}
	
}
