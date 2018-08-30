package com.scholastic.intl.litpro.test.automation.pageobjects.bman;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.slz.Slzobj;

import au.com.bytecode.opencsv.CSVReader;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BmanHomePage extends ParentPage {

		
	public BmanHomePage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}
	
	@FindBy(xpath = ".//*[@id='headerForm']/h1")
	private WebElement header;
	@FindBy(xpath = ".//a/span[contains(text(),'Books')]")
	private WebElement booksLink;
	@FindBy(xpath = ".//a/span[contains(text(),'Create Book')]")
	private WebElement createbooksLink;
	@FindBy(xpath = ".//*[@id='headerForm']/h1")
	private WebElement createbooksheader;
	@FindBy(id = "mainForm:fieldTitle")
	private WebElement booktitle;
	@FindBy(id = "mainForm:fieldAuthorLastName")
	private WebElement bookAutorLastname;
	@FindBy(id = "mainForm:fieldIsbn")
	private WebElement isbn;
	@FindBy(xpath = ".//button/span[contains(text(),'Search')]")
	private WebElement searchbutton;
	@FindBy(xpath = ".//h1[contains(text(),'Add new book')]")
	private WebElement headerAddnewbook;
	@FindBy(id = "mainForm:fieldDescription")
	private WebElement bookDescription;
	@FindBy(id = "mainForm:fieldInterestLevel_label")
	private WebElement EducationLevel;
	@FindBy(xpath = ".//*[@id='mainForm:fieldInterestLevel_panel']//li[2]")
	private WebElement EduLevelSelect;
	@FindBy(xpath = ".//*[@id='mainForm:fieldCategories']/a")
	private WebElement category;
	@FindBy(xpath = ".//span[contains(text(),'Action')]")
	private WebElement categorychkbox;
	@FindBy(xpath = ".//*[@id='mainForm:categoryelectDialogContent']/div[2]//span[contains(text(),'Save')]")
	private WebElement categorySave;
	@FindBy(id = "mainForm:fieldLexile")
	private WebElement lexil;
	@FindBy(xpath = ".//button/span[contains(text(),'Publish')]")
	private WebElement publish;
	@FindBy(xpath = ".//*[@id='headerForm:messages']/div/ul/li/span")
	private WebElement successMsg;
	@FindBy(xpath = ".//span[contains(text(),'Create Quiz')]")
	private WebElement createQuiz;
	@FindBy(xpath = ".//span[contains(text(),'Add Question')]")
	private WebElement addQuestion;
	@FindBy(xpath = ".//*[@id='newQuestionDialog_title']")
	private WebElement addQuestionHeader;
	@FindBy(xpath = ".//*[@id='newQuestionDialogForm:fieldNewAnswerCorrect']")
	private WebElement correctanswer;
	@FindBy(xpath = ".//*[@id='newQuestionDialogForm:fieldNewDistractor1']")
	private WebElement answer2;
	@FindBy(xpath = ".//*[@id='newQuestionDialogForm:fieldNewDistractor2']")
	private WebElement answer3;
	@FindBy(xpath = ".//*[@id='newQuestionDialogForm:fieldNewDistractor3']")
	private WebElement answer4;
	@FindBy(xpath = ".//*[@id='newQuestionDialogForm:newQuestionDialogContent']//span[contains(text(),'Save')]")
	private WebElement savebutton;
	
		
	public boolean isHeaderPresent() {
		return this.sync(header).isDisplayed();
		
	}
	public void Createbook() throws IOException{
		Slzobj ob = new Slzobj();
		long number = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
		Actions act = new Actions(driver);
		this.reportLog("Hover above books link");
		act.moveToElement(booksLink).perform();
		this.sync(createbooksLink).click();
		generateisbn();
		assertTrue("Create book not displaed",this.sync(createbooksheader).isDisplayed());
		
		this.sync(booktitle).sendKeys("AutomationTitle"+ob.generateRandomString());
		bookAutorLastname.sendKeys("AutomationLastname");
		isbn.sendKeys(Long.toString(number));
		searchbutton.click();
		lazyWait(5);
		assertTrue("Add book not displaed",this.sync(headerAddnewbook).isDisplayed());
		this.sync(bookDescription).sendKeys("Automation Description");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", EducationLevel);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				EducationLevel);
		//EducationLevel.click();
		this.sync(EduLevelSelect).click();
		isbn.clear();
		isbn.sendKeys(generateisbn());
		category.click();
		this.sync(categorychkbox).click();
		lazyWait(10);
		categorySave.click();
		lazyWait(10);
		lexil.sendKeys("22");
		publish.click();
		lazyWait(10);
	}
	
	public String generateisbn() throws IOException{
		String UploadedFilePath;
		String isb = null;
		 String[] b = null;
		String os=System.getProperty("os.name");
		if(os.contains("Windows"))
		{ UploadedFilePath = new File(".").getCanonicalPath()
		+ "\\src\\test\\resources\\upload_files\\isbn.csv";
		}else{
		 UploadedFilePath="/home/linux-gui/.jenkins/workspace/isbn.csv";
		}
		
		String splitBy = ",";
        BufferedReader br = new BufferedReader(new FileReader(UploadedFilePath));
        String line ;
        int k=0;
        while((line = br.readLine())!=null){
              b = line.split(splitBy);
             System.out.println(b[0]);
       k++; 
       if(k!=0)
    	   break;
        }
        br.close();

  
		return b[0];
		
	}
	
	public String getBookCreatedSuccess(){
		this.sync(successMsg);
		
		return successMsg.getText();
		
	}
	public void createQuizz() {
		
		this.sync(createQuiz).click();
		for(int i=0;i<5;i++){
		   this.sync(addQuestion).click();
		   this.sync(addQuestionHeader);
		   this.sync(correctanswer).sendKeys("correct Answer");
		   this.sync(answer2).sendKeys("Answer2");
		   this.sync(answer3).sendKeys("Answer3");
		   this.sync(answer4).sendKeys("Answer4");
		   this.sync(savebutton).click();
		}
		
	}
}
