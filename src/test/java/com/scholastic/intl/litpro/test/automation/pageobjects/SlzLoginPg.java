package com.scholastic.intl.litpro.test.automation.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.bytecode.opencsv.CSVWriter;

import com.scholastic.intl.litpro.test.automation.keys.Keys.LoginPageLocators;
import com.scholastic.intl.litpro.test.automation.keys.Keys.hooksConstants;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.SlzCSRHomePg;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.torque.webdriver.ExtendedElement;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class SlzLoginPg extends ParentPage implements LoginPageLocators,hooksConstants{
	WebDriver driver= TestBaseProvider.getTestBase().getDriver();
	private String launchUrl = null;
	private String userType = null;
	private String userName = "";
	private String password = "";
	TestBase testBase = TestBaseProvider.getTestBase();

	@FindBy(how = How.ID_OR_NAME, using = "username")
	private WebElement usernameTextBox;

	@FindBy(how = How.ID_OR_NAME, using = "password")
	private WebElement passwordTextBox;

	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	private WebElement login;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutLink;

	@FindBy(how = How.CSS, using = "p.warning")
	private WebElement loginError;
	
	@FindBy(xpath = LOGIN_UNAME_TEXTBOX_SDM)
	private WebElement loginunametextboxsdm;

	@FindBy(xpath = LOGIN_PWD_TEXTBOX_SDM)
	private WebElement loginpwdtextboxsdm;

	@FindBy(id = LOGIN_SIGNIN_BUTTON_SDM)
	private WebElement loginsigninbuttonsdm;
	
	@FindBy(xpath=".//img[@alt='btn_lf']")
	private WebElement lpLink;
	
	@FindBy(xpath="//a[contains(text(),'Scholastic Learning Zone')]")
	private WebElement SLZPassthoghLnk;
	
	@FindBy(xpath="//*[contains(text(),'Loading')]")
	private WebElement LoadingImage;
	
	@FindBy(xpath="//*[@id='quicksearchQuery']")
	private WebElement SearchTextBox;
	
	@FindBy(xpath="//a[contains(text(),'breaking bad 6')]")
	private WebElement SchoolNameSLZ;
	
	@FindBy(xpath="//button[@ng-click='quickSearch()']")
	private WebElement SearchButton;

	public SlzLoginPg(WebDriver driver) {
		super(driver);
		driver = TestBaseProvider.getTestBase().getDriver();
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public String getURL() {
		return launchUrl;
	}

	public boolean launchSlz() {
		/*loadConf();
		boolean areParamsPresent = ParentPage.appConfig
				.containsKey("app.url.base")
				&& ParentPage.appConfig.containsKey("app.login")
				&& ParentPage.appConfig.containsKey("org.id");
		if (!areParamsPresent) {
			this.reportLog("[Error] AUT info required. Base URL, Login URL or Ord Id is not passed or empty");
			return false;
		}
		String baseUrl = ParentPage.appConfig.getProperty("app.url.base")
				.trim();
		String loginUrl = ParentPage.appConfig.getProperty("app.login").trim();
		String csRepLoginUrl = ParentPage.appConfig.getProperty(
				"app.csrep.login").trim();

		String orgId = ParentPage.appConfig.getProperty("org.id").trim();

		boolean isAppConfigProper = baseUrl.isEmpty() || loginUrl.isEmpty()
				|| csRepLoginUrl.isEmpty();
		if (!isAppConfigProper) {
			launchUrl = baseUrl + loginUrl + orgId;
			this.reportLog("Launch Slz Login Page..");
			this.reportLog("URL: " + launchUrl);

			if (launchUrl != null) {
				driver.get(launchUrl);
				// driver.navigate().refresh();
				// logout if already logged in
				this.logout();
			}

			return true;
		} else {
			this.reportLog("[Error] AUT info required. Base URL, Login URL or Ord Id is not passed or empty");
			this.reportLog("Base URL: " + baseUrl);
			this.reportLog("Login URL: " + loginUrl);
			this.reportLog("Org Id: " + orgId);
			return false;
		}*/
		String launchUrl = testBase.getContext().getString(URL);
		if (launchUrl != null) {
			//driver.get(launchUrl);
			// driver.navigate().refresh();
			// logout if already logged in
			this.logout();
			return true;
		}
		return false;
	}

	public boolean launchSlzForCSRep() {
		boolean areParamsPresent = ParentPage.appConfig
				.containsKey("app.csrep.login");
		if (!areParamsPresent) {
			this.reportLog("[Error] AUT info required. Base URL, Login URL or Ord Id is not passed or empty");
			return false;
		}
		String baseUrl = ParentPage.appConfig.getProperty("app.url.base")
				.trim();
		String csRepLoginUrl = ParentPage.appConfig.getProperty(
				"app.csrep.login").trim();

		String orgId = ParentPage.appConfig.getProperty("org.id").trim();

		boolean isAppConfigProper = baseUrl.isEmpty() || orgId.isEmpty()
				|| csRepLoginUrl.isEmpty();
		if (!isAppConfigProper) {
			launchUrl = baseUrl + csRepLoginUrl;
			this.reportLog("Launch Slz Login Page for CSRep..");
			this.reportLog("URL: " + launchUrl);

			if (launchUrl != null) {
				driver.get(launchUrl);
				// logout if already logged in
				this.logout();
			}

			return true;
		} else {
			this.reportLog("[Error] AUT info required. Base URL, Login URL or Ord Id is not passed or empty");
			this.reportLog("Base URL: " + baseUrl);
			return false;
		}
	}

	public void logout() {

		/*String xpath;
		String baseUrl = ParentPage.appConfig.getProperty("app.url.base")
				.trim();
		System.out.println(baseUrl);
		if ((baseUrl.contains("qa-slz2")) || (baseUrl.contains("stress"))) {
			xpath = "slz-logout";
		} else*/
			String xpath = "slz-logout";
		WebElement logoutElement = this.getElement(By.id(xpath), 5);
		if (logoutElement != null) {
			System.out.println(logoutElement.isDisplayed());
			this.reportLog("Logout from Slz Home");
			if (logoutElement.isDisplayed())
				logoutElement.click();
			driver.navigate().refresh();
		}
	}

	public SlzHomePg login(String username, String password) {
		this.userName = username;
		this.password = password;
		this.reportLog("Login to Scholastic Learning Zone(" + username + "/"
				+ password + ")");
		/*this.type(usernameTextBox, username);
		this.type(passwordTextBox, password);
		passwordTextBox.submit();*/
		WebElement uidE = this.getElement(By.name("UserName"));
		WebElement passE = this.getElement(By.name("password"));
		WebElement btnSubmit = this.getElement(By.xpath(".//button[contains(text(),'Login')]"));
		
		this.type(uidE, userName);
		this.type(passE, password);
		btnSubmit.click();
		return new SlzHomePg(driver);
	}

	public SlzHomePg loginAs(LitProUserType lpUserType) {	
		String userName = this.getUserId(lpUserType);
		String password = "welcome1";
		return this.login(userName, password);	
	}


	
/*	public SlzCSRHomePg loginAsCSRep() {

		this.userName = this.getUserId(LitProUserType.CS_REP);

		this.password = "welcome1";

		WebElement uidE = this.getElement(By.id("email"));
		WebElement passE = this.getElement(By.id("password"));
		WebElement btnSubmit = this.getElement(By.id("submit-button"));






		this.type(uidE, userName);
		this.type(passE, password);
		btnSubmit.click();

		return new SlzCSRHomePg(driver);
	}*/
	 

	public LitProUserType getLitProUserType(String userType) {
		this.userType = userType;
		if (StringUtils.containsIgnoreCase(this.userType, "Student")) {
			return LitProUserType.STUDENT;
		} else if (userType.contains("Admin")) {
			return LitProUserType.SCHOOL_ADMIN;
		} else if (userType.contains("Teacher")) {
			return LitProUserType.TEACHER;
		} else if (userType.contains("CSRep")) {
			return LitProUserType.CS_REP;



		}

		return LitProUserType.SCHOOL_ADMIN;
	}

	public String getUserId(LitProUserType userType) {
		String username;
		String password = "welcome1";

		switch (userType) {
		case STUDENT:
			username = testBase.getContext().getString("student.id");
			this.reportLog("Student Credetials (" + username + "/" + password
					+ ")");
			break;

		case SCHOOL_ADMIN:
			username = testBase.getContext().getString("admin.id");
			this.reportLog("SchoolAdmin Credetials(" + username + "/"
					+ password + ")");
			break;

		case TEACHER:
			username = testBase.getContext().getString("teacher.id");
			this.reportLog("Teacher Credetials (" + username + "/" + password
					+ ")");
			break;

		case CS_REP:
			username = testBase.getContext().getString("csrep.id");
			this.reportLog("CS Rep Credetials (" + username + "/" + password
					+ ")");
			break;

		default:
			username = testBase.getContext().getString("csrep.id");
			this.reportLog("Default Credetials (" + username + "/" + password
					+ ")");
		}

		return username;
	}

	/*
	 * private String getBrowserString(){ switch(SharedDriver.ACTIVE_BROWSER){
	 * case FIREFOX: return "fx"; case CHROME: return "cr"; case IE: return
	 * "ie"; default: return "fx"; }
	 */

	// }

	public String getLoginErrorText() {
		return loginError.getText();
	}

	public String getUserCreds() {
		if (!this.userName.isEmpty() || !this.password.isEmpty())
			return this.userName + "/" + this.password;
		else
			return "";
	}

	
	public SlzCSRHomePg loginAsCSRep(String username) {
		this.userName = username;
		this.password = "welcome1";


		WebElement uidE = this.getElement(By.name("email"));
		WebElement passE = this.getElement(By.name("password"));
		WebElement btnSubmit = this.getElement(By

				.cssSelector(".btn.btn-primary"));

		this.type(uidE, userName);
		this.type(passE, password);




		btnSubmit.click();

		return new SlzCSRHomePg(driver);
	}

	public void clickForgotPasswordLink() {
		this.sync(driver.findElement(By.xpath(".//a[@href='#forgotPassword']")))
				.click();

	}

	public void isErrorMessageDisplayed() {

		this.sync(driver.findElement(By.xpath("(.//h4)[1]"))).getText()
				.contains("Having trouble signing in?");

	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}

	
	public void SearchSchool(String SchoolName) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lazyWait(10);
		reportLog("Searching for the school "+SchoolName);
		SearchTextBox.sendKeys(SchoolName);
		SearchButton.click();
		String xpath = "//a[contains(text(),'" + SchoolName + "')]";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void PassThroughLink(){
		lazyWait(5);
		int k=this.sync(OrgID).getText().length();
		String OrgId=OrgID.getText().substring(k-7);
		setbooktitle(OrgId);
		System.out.println(OrgId);
		SLZPassthoghLnk.click();
		reportLog("Clicked on the pass through link in SLZ");
	}
	
	public void OpenApplication() {
		this.switchToNewWindow();
		this.lazyWait(10);
		this.sync(lpLink).click();
		this.lazyWait(10);
		this.switchToNewWindow();
		
	}

	public void Openmanager() {
		//testBase.getContext().getString("url");
		String url = driver.getCurrentUrl();
		driver.get(url.replace("/#/home", "/manager"));
		reportLog("Opening the maager tool");
	}

	public void ManagerQuizzes() {
		Actions action = new Actions(driver);
		reportLog("Opening the Quiz upload page");
		action.moveToElement(
				driver.findElement(By.xpath("//span[text()='Quizzes']")))
				.build().perform();
		MigrateQuiz.click();
		lazyWait(2);
		reportLog("Quiz upload page is not opened");
		QuizzesOrgIDTextBox.sendKeys(getbooktitlesb());
		NextButtn.click();
		SelectSource.click();
		reportLog("Uploading the quiz");
		LexileFramework.click();
		NextButtn.click();
	}
	
	public boolean UploadCSV() throws InterruptedException, AWTException, IOException{
		reportLog("Uploading the Quiz CSV file which got created earlier");
		String Status;
		boolean result = false;
		int count = 0;
		String UploadedFilePath;
		String os=System.getProperty("os.name");
		if(os.contains("Windows"))
		{ UploadedFilePath = new File(".").getCanonicalPath()
		+ "\\src\\test\\resources\\upload_files\\quizupload.csv";
		}else{
		 UploadedFilePath="/home/linux-gui/.jenkins/workspace/Csrep/litpro-test/src/test/resources/upload_files/quizupload.csv";
		}
		/*String UploadedFilePath = new File(".").getCanonicalPath()
				+ "/src/test/resources/upload_files/quizupload.csv";*/
		lazyWait(10);
		ChooseButton.sendKeys(UploadedFilePath);
		lazyWait(10);
		UplaodButton.click();
		lazyWait(2);
		int rowCount1 = driver.findElements(By.xpath("//*[@id='mainForm:importItemsDataTable_data']/tr/td[3]")).size();
		for(int i=1; i<=rowCount1; i++){
			String xpath="//*[@id='mainForm:importItemsDataTable_data']/tr["+i+"]/td[3]";
			Status = driver.findElement(By.xpath(xpath)).getText();
			if(Status.contains("Success")){
				count = count +1;
			}
			if(!Status.contains("Success")){
				System.out.println("Question which was not uploaded succesfully was -->"+driver.findElement(By.xpath("//*[@id='mainForm:importItemsDataTable_data']/tr["+i+"]/td[2]")).getText());
			}
		}
		if(count > 0){
			result = true;
		}
		reportLog("CSV file got uplaoded successfully");
		return result;
	}
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public String tableQuiz() {
		int a = driver
				.findElements(
						By.xpath("//*[@id='mainForm:importItemsDataTable_data']/tr/td[2]"))
				.size();
		String Question = null;
		for (int i = 1; i <= a; i++) {
			Question = Question
					+ driver.findElement(By.xpath("//*[@id='mainForm:importItemsDataTable_data']/tr["+i+"]/td[2]")).getText().trim() + "*";
		}
		return Question;
	}

	public ArrayList CSVQuestions() throws IOException {
		ArrayList Questions = new ArrayList();
		String UploadedFilePath;
		String os=System.getProperty("os.name");
		if(os.contains("Windows"))
		{ UploadedFilePath = new File(".").getCanonicalPath()
		+ "\\src\\test\\resources\\upload_files\\quizupload.csv";
		}else{
		 UploadedFilePath="/home/linux-gui/.jenkins/workspace/Csrep/litpro-test/src/test/resources/upload_files/quizupload.csv";
		}
		//String UploadedFilePath = "/home/linux-gui/.jenkins/workspace/CsrepStage/litpro-test/src/test/resources/upload_files/quizupload.csv";
		String b = getReadCSVFile(UploadedFilePath).toString();
		String[] CSVquiz = b.split("\\*\\,");
		for (int i = 1; i < CSVquiz.length; i++) {
			String[] quiz = CSVquiz[i].split("\\,");
			Questions.add(quiz[2].trim()+"*");
		}
		return Questions;
	}

	public ArrayList UIQuestion() throws IOException {
		ArrayList Questions = new ArrayList();
		String b = tableQuiz();
		String[] CSVquiz = b.split("\\*");
		for (int i = 0; i < CSVquiz.length; i++) {
			Questions.add(CSVquiz[i].replaceAll("null", "")+"*");
		}
		return Questions;
	}

	public boolean ValidateuplaodedQuizzes() throws IOException {
		reportLog("Validating if all the file ot uplaoded successfully");
		int count = 0;
		boolean result = false;
		//getting quiz from application
		String[] UIquiz = UIQuestion().toString().replaceAll("^\\[|\\]$", "").split("\\*\\,");
		//getting quiz from CSV file
		String[] CSVquiz = CSVQuestions().toString().replaceAll("^\\[|\\]$", "").split("\\*\\,");
		for (int j = 0; j < UIquiz.length; j++) {
			String Status = driver.findElement(By.xpath("//*[@id='mainForm:importItemsDataTable_data']/tr["+ (j+1) + "]/td[3]")).getText();
			if (Status.equalsIgnoreCase("Success")) {
				for (int i = 0; i < CSVquiz.length; i++) {
					if (Status.equalsIgnoreCase("Success")
							&& (UIquiz[i].trim()).equalsIgnoreCase(CSVquiz[j].replaceAll("\"", "").trim())) {
						count = 1 + count;
					}
				}
			}
		}
		if (count == UIquiz.length) {
			result = true;
			reportLog("All the files got uplaoded successfully");
		}
		return result;
	}
	
	public boolean NextButtonComplete(){
		boolean result = false;
		NextButtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Download']")));
		if(DownloadButton.isDisplayed()){
			result=true;
			reportLog("Uploading of the quiz was  successfully");
		}
		return result;
	}
	
	public void BookImportEport(){
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("//*[@id='toolbarForm:toolbar']//span[contains(text(),'Books')]")))
				.build().perform();
		reportLog("Mouse hovered over Books link");
		BooksImportExport.click();
	}

	public void SOARImport(String name){
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("//*[@id='toolbarForm:toolbar']//span[contains(text(),'Students')]")))
				.build().perform();
		reportLog("Mouse hovered over Books link");
		String xpaths = ".//*[@id='toolbarForm:j_idt42']/span[contains(text(),'"+name+"')]";
		driver.findElement(By.xpath(xpaths)).click();
	}
	
	public void EnterORDID(){
		lazyWait(5);
		reportLog("Entering the ORGID");
		String orgid = getbooktitlesb();
		EnterOrgID.sendKeys(orgid);
		NextButton.click();
		reportLog("Clicked on next button"+orgid);
	}
	
	public boolean ConfirmSchool(){
		boolean result = false;
		lazyWait(4);
		String orgid = getbooktitlesb();
		String ORGIDs=this.sync(ORGID).getText();
		if(ORGIDs.equals(orgid)){
			NextButton.click();
			result = true;
		}
		return result;
	}
	public int RandomNumberYear() {
		Random r = new Random();
		int Low = 1900;
		int High = 2016;
		int Result = r.nextInt(High-Low) + Low;
		return Result;
	}
	
	public void CreateSRICSV() throws IOException{
		String csv ="/home/linux-gui/.jenkins/workspace/lpdatafiles/sriUpload.csv";
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+csv);
		int year = RandomNumberYear();
		CSVWriter writer = new CSVWriter(new FileWriter(csv));

		List<String[]> data = new ArrayList<String[]>();
		data.add(new String[] {"USERNAME","Grade","Date","LEXILE"});
		data.add(new String[] {"JonSnow","4","11/12/"+year,Integer.toString(RandomNumber3Digit())});
		data.add(new String[] {"AryaStark","5","12/12/"+year,Integer.toString(RandomNumber3Digit())});

		writer.writeAll(data);

		writer.close();
	}
	
	public void UploadSRIFile(String filename) throws IOException{
		/*String UploadedFilePath = new File(".").getCanonicalPath()
				+ "sriUpload.csv";
		*
		*/
		String UploadedFilePath;
		String os=System.getProperty("os.name");
		if(os.contains("Windows"))
		{ UploadedFilePath = new File(".").getCanonicalPath()
		+ "\\src\\test\\resources\\upload_files\\sriUpload.csv";
		}else{
		 UploadedFilePath="/home/linux-gui/.jenkins/workspace/lpdatafiles/sriUpload.csv";
		}
		//String UploadedFilePath = "/home/linux-gui/.jenkins/workspace/CsrepStage/litpro-test/src/test/resources/upload_files/sriUpload.csv";
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+UploadedFilePath);
		ChooseButton.sendKeys(UploadedFilePath);
		lazyWait(5);
		WebElement Uploadbutton1 =driver.findElement(By.xpath(".//*[@class='ui-wizard-content']/div/div[2]/div[1]//button[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Uploadbutton1);
		reportLog("The Historical SRI file is uploading");
		
		lazyWait(10);
		
		try {
			if (uploadtable.isDisplayed()) {
				reportLog("SRI data is Upload");
				driver.findElement(By.xpath("(.//*[@role='button'][2])[2]")).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean VerifyUpload(){
		lazyWait(4);
		int Tablecount=0;
		boolean result=false; 
		int count = driver.findElements(By.xpath(".//*[@id='mainForm:completedImports_data']/tr/td[5]")).size();
		for(int i=1; i<=count; i++){
			String xpath = ".//*[@id='mainForm:completedImports_data']/tr["+i+"]/td[5]";
			String Status = driver.findElement(By.xpath(xpath)).getText();
			if(Status.equalsIgnoreCase("ok")){
				reportLog("Checking the status of the scores uplaoded");
				Tablecount=Tablecount+1;
			}
		}
		if(Tablecount==count){
			result=true;			
		}
		
		return result;
	}
	@FindBy(xpath=".//*[@id='mainForm:pendingImports_data']/tr[1]/td")
	private WebElement uploadtable;

	@FindBy(xpath=".//ul/li[contains(text(),'upload')]")
	private WebElement Uploadbutton;
	
	@FindBy(xpath=".//*[@class='ui-fileupload ui-widget']/div[1]/button[1]")
	private WebElement UploadSRIText;
	
	@FindBy(xpath=".//tbody/tr[1]/td[2]")
	private WebElement ORGID;
	
	@FindBy(xpath=".//*[@role='textbox']")
	private WebElement EnterOrgID;
		
	@FindBy(xpath=".//*[@role='button'][2]")
	private WebElement NextButton;
	
	public boolean uplaodBookXML(String FileName) throws InterruptedException,
			AWTException, IOException {
		String Status;
		boolean result = false;
		int count = 0;
		String UploadedFilePath = new File(".").getCanonicalPath()
				+ "\\src\\test\\resources\\upload_files\\" + FileName + ".xml";
		reportLog("Uploading the XML's");
		BooksUploadtextbox.sendKeys(UploadedFilePath);
		lazyWait(2);
		BooksUploadbutton.click();
		reportLog("Clicked on the upload button");
		lazyWait(2);
		String xpath = "//*[@id='mainForm:bookFileUpload']//td[contains(text(),'"
				+ FileName + ".xml')]";
		for (int i = 0; i <= 30; i++) {
			if (driver.findElements(By.xpath(xpath)).size() == 0) {
				result = true;
				reportLog("Book XML got uplaoded successfully");
				break;
			}
			lazyWait(1);
		}
		return result;
	}
	
	public void CreateCSV(String title, String authorfirstname, String authorlastname) throws IOException{
		/*String csv =new File(".").getCanonicalPath()
				+ "/src/test/resources/upload_files/quizupload.csv";*/ 
		
		
		String csv ="/home/linux-gui/.jenkins/workspace/lpdatafiles/quizupload.csv";
		reportLog("Creating an CSV file for uploading the Quiz");
		CSVWriter writer = new CSVWriter(new FileWriter(csv));

		List<String[]> data = new ArrayList<String[]>();
		data.add(new String[] {"book","","",title,authorfirstname,authorlastname});
		data.add(new String[] {"question","Q1","Question"+Integer.toString(RandomNumber()),"correct 1","answer 11","answer 21","answer 31"});
		data.add(new String[] {"question","Q2","Question2"+Integer.toString(RandomNumber()),"correct 2","answer 12","answer 21","answer 31"});
		data.add(new String[] {"question","Q3","time to go","correct 3","answer 13","answer 21","answer 31"});
		data.add(new String[] {"question","Q4","hello how are you","correct 4","answer 14","answer 21","answer 31"});
		data.add(new String[] {"question","Q5","this is testing","correct 5","answer 15","answer 21","answer 31"});
		data.add(new String[] {"question","Q6","Automation of the litpro","correct 6","answer 16","answer 21","answer 31"});
		data.add(new String[] {"question","Q7","I am good","correct 7","answer 17","answer 21","answer 31"});
		data.add(new String[] {"question","Q8","time of tool","correct 8","answer 18","answer 21","answer 31"});
		data.add(new String[] {"question","Q9","matthew if the","correct 9","answer 19","answer 21","answer 31"});
		data.add(new String[] {"question","Q10","go to the time of hello","correct 10","answer 20","answer 21","answer 31"});

		writer.writeAll(data);

		writer.close();
		reportLog("CSV file got created");
	}
	@FindBy(xpath="//*[@id='toolbarForm:j_idt15']/span")
	private WebElement BooksImportExport;
	
	@FindBy(xpath=".//*[@id='mainForm:bookFileUpload']/div[1]/button[1]")
	private WebElement BooksUploadbutton;
	
	@FindBy(xpath="//*[@id='mainForm:bookFileUpload_input']")
	private WebElement BooksUploadtextbox;
	
	@FindBy(xpath = ".//input[@value='Download']")
	private WebElement DownloadButton;
	
	@FindBy(xpath = ".//*[@id='j_idt111']")
	private WebElement loadedimage;
	
	@FindBy(xpath = "//span[contains(text(),'Choose')]/parent::label/input")
	private WebElement ChooseButton;
	
	@FindBy(xpath = ".//button/span[contains(text(), 'Upload')]")
	private WebElement UplaodButton;
	
	@FindBy(xpath = "//li[contains(text(),'Lexile Framework')]")
	private WebElement LexileFramework;
	
	@FindBy(xpath = "//*[@id='mainForm:sourceDropDown_label']")
	private WebElement SelectSource;
	
	@FindBy(xpath = ".//span[contains(text(),'Next')]")
	private WebElement NextButtn;
	
	@FindBy(xpath = "//*[@id='mainForm:j_idt81_input']/parent::label/span[2]")
	private WebElement ChooseButton2;
	
	@FindBy(xpath = "//Strong[contains(text(),'Student URL:')]/parent::h5/parent::li/span")
	private WebElement OrgID;
	
	@FindBy(xpath = "//td[text()='Org Id:']/parent::tr//input")
	private WebElement QuizzesOrgIDTextBox;
	
	@FindBy(xpath = "//span[text()='Quizzes']")
	private WebElement Quizzes;
	
	@FindBy(xpath = "//span[text()='Migrate Quiz']")
	private WebElement MigrateQuiz;
	@FindBy(xpath = ".//span[contains(text(),'Sync Log')]")
	private WebElement syncLog;
	@FindBy(id = "mainForm:btnBookSync")
	private WebElement syncNowButton;
	
	
	
	public String getSchoolname() {
		return SlzLoginPg.Schoolname;
	}

	public void setSchoolname(String Schoolname) {
		SlzLoginPg.Schoolname = Schoolname;
	}

	public static String Schoolname;
	
	public void BookSyncLog(){
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("//*[@id='toolbarForm:toolbar']//span[contains(text(),'Books')]")))
				.build().perform();
		reportLog("Mouse hovered over Books link");
		this.sync(syncLog);
		syncLog.click();
	}

	public boolean isBookSynced() {
		this.sync(syncNowButton);
		return syncNowButton.isEnabled();
	}
	public static HashMap<String, String> hmap = new HashMap<String, String>();
	
	public void CreateXML(String SchoolName){
		
		lazyWait(1);
		SchoolSrch.clear();
		SchoolSrch.sendKeys(SchoolName);
		SrchBtn.click();
		String xpath="//td/a[contains(text(),'"+SchoolName+"')]";
		lazyWait(2);
		driver.findElement(By.xpath(xpath)).click();
		lazyWait(4);
		
		String SchoolURL1=SchoolURL.getText();
		System.out.println("^^^^^^^^^^^^^"+SchoolURL1);
		
		
		hmap.put(SchoolName, SchoolURL1);
	
	}
	
	   
	public void EditXML(){
		try {
			String filepath;
			String os=System.getProperty("os.name");
			//if(os.contains("Windows"))
			 filepath = new File(".").getCanonicalPath()
			+ "/config/lpdatacreation.xml";
/*//			}else{
//				filepath="/home/linux-gui/.jenkins/workspace/Csrep/litpro-test/config/lpdatacreation.xml";
//			}
*/			//String filepath = "D:\\delete\\delete1\\src\\delete1\\RegressionZone9-ProdChrome.xml";
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document document = db.parse(new File(filepath));
	        NodeList nodeList = document.getElementsByTagName("parameter");
	        int j=1;
	        for(int x=5,size= nodeList.getLength(); x<size; x=x+6) {
	        	System.out.println(nodeList.item(x).getAttributes().getNamedItem("value").getNodeValue());
			    nodeList.item(x).getAttributes().getNamedItem("value").setNodeValue(hmap.get("breaking bad "+j));
			    System.out.println("===="+hmap.get("breaking bad "+j));
			    System.out.println(nodeList.item(x).getAttributes().getNamedItem("value").getNodeValue());
			    j++;
			}
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
		} 
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void EditXML1(){
		try {
			String filepath;
			String os=System.getProperty("os.name");
			//if(os.contains("Windows"))
			filepath = new File(".").getCanonicalPath()
			+ "/config/lpregressionnotQA.xml";
			/*}else{
				filepath="/home/linux-gui/.jenkins/workspace/Csrep/litpro-test/config/lpregressionnotQA.xml";
			}*/
			//String filepath = "D:\\delete\\delete1\\src\\delete1\\RegressionZone9-ProdChrome.xml";
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document document = db.parse(new File(filepath));
	        NodeList nodeList = document.getElementsByTagName("parameter");
	        int j=6;
	        System.out.println("^^^^^^^11^^^^"+nodeList.getLength());
	        for(int x=11,size= nodeList.getLength(); x<size; x=x+6) {
	        	System.out.println(nodeList.item(x).getAttributes().getNamedItem("value").getNodeValue());
			    nodeList.item(x).getAttributes().getNamedItem("value").setNodeValue(hmap.get("breaking bad "+j));
			    System.out.println("===="+hmap.get("breaking bad "+j));
			    System.out.println(nodeList.item(x).getAttributes().getNamedItem("value").getNodeValue());
			    System.out.println("''''");
			    j++;
			}
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
		} 
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	public void EditXML2(){
		try {
			String filepath;
			String os=System.getProperty("os.name");
			//if(os.contains("Windows"))
			
				filepath = new File(".").getCanonicalPath()+ "/config/lpregressionnotQA.xml";
			/*}else{
				filepath="/home/linux-gui/.jenkins/workspace/Csrep/litpro-test/config/lpregressionnotQA.xml";
			}*/
			//String filepath = "D:\\delete\\delete1\\src\\delete1\\RegressionZone9-ProdChrome.xml";
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document document = db.parse(new File(filepath));
	        NodeList nodeList = document.getElementsByTagName("parameter");
	        int j=6;
	        System.out.println("@@@@@@@@"+hmap.size());
	        System.out.println("^^^^^^^11^^^^"+nodeList.getLength());
	        for(int x=11,size= nodeList.getLength(); x<size; x=x+6) {
	        	System.out.println(nodeList.item(x).getAttributes().getNamedItem("value").getNodeValue());
			    nodeList.item(x).getAttributes().getNamedItem("value").setNodeValue(hmap.get("breaking bad "+j));
			    System.out.println("===="+hmap.get("breaking bad "+j));
			    System.out.println(nodeList.item(x).getAttributes().getNamedItem("value").getNodeValue());
			    System.out.println("''''");
			    j++;
			}
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
		} 
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	@FindBy(how = How.XPATH, using = ".//ul/li[2]/span")
	private WebElement SchoolURL;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='quicksearchQuery']")
	private WebElement SchoolSrch;
	
	@FindBy(how = How.XPATH, using = "//button[@ng-click='quickSearch()']")
	private WebElement SrchBtn;
	
	
}