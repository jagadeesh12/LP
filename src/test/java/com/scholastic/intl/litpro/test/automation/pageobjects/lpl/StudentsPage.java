package com.scholastic.intl.litpro.test.automation.pageobjects.lpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;

/* @ Author:
 * @ Created Date:
 * @ Functionality:
 * @ Page Object File Name:
 * @ Type: Smoke, regression
 * 
 * 
 * @ Updated Date
 * @ Updated By
 * 
 */

public class StudentsPage extends ParentPage {
	WebDriver driver;
	final String PAGE_TITLE = "Literacy Pro Library";
	final String PAGE_HEADER = "Students";
	String fileName;

	@FindBy(css = ".lpl-page-title1")
	private WebElement pgHeader;
	@FindBy(xpath = ".//*[@class='lpl-student-profile-pic']")
	private WebElement studentProfile;
	@FindBy(xpath = ".//div[2]/div[2]/div/div[1]/img")
	private WebElement JonSnow_Student;
	@FindBy(xpath = "//a[text()='Disable Audio Recording']")
	private WebElement Disable_audio_recording;
	@FindBy(xpath = "//a[text()='Enable Audio Recording']")
	private WebElement Enable_audio_recording;
	@FindBy(xpath = "(//span[@class='selected ng-binding'])[1]")
	private WebElement Selecting_class;
	@FindBy(xpath = "//div/ul/li[2]/a[contains(text(),'Math')]")
	private WebElement Math_class;
	@FindBy(xpath = ".//div[@dropdown-select='classSelections']/span")
	private WebElement Math_class_Text;

	public StudentsPage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(this.DRIVER_WAIT);
	}

	public boolean isStudentHeaderDisplayed() {
		if (pgHeader.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean verifyStudentsheader() {
		if (pgHeader.getText().contains("STUDENT OVERVIEW"))
			return true;
		else
			return false;
	}

	public boolean verifyStudentsProfile() {
		if (studentProfile.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickOn_JonSnow_Student() {
		this.sync(JonSnow_Student).click();
	}

	public void clickOn_Select_drop_down_class() {
		this.sync(Selecting_class).click();
	}

	public void clickOn_Math_class() {
		this.sync(Math_class).click();
	}

	public void clickOn_Disable_audio_recording() {
		this.sync(Disable_audio_recording).click();
	}

	@FindBy(xpath = "//div/a[contains(text(),'Audio Recording')]")
	private WebElement AudioRecording;

	public void clickOn_Enable_audio_recording() {
		String status = getText(AudioRecording);
		if(status.contains("Enable")){
			click(AudioRecording);
		} else{
			reportLog("Audio Recordings are enabled");
		}
	}

	public boolean isDisable_audio_recording_dislayed() throws InterruptedException {
		Thread.sleep(10000);
		String EnableDisable = this.sync(AudioRecording).getText();
		Boolean flag = false;
		if (EnableDisable.contains("Enable")) {
			AudioRecording.click();
			Thread.sleep(10000);
		}
		if (this.sync(AudioRecording).getText().contains("Disable"))
			flag = true;
		else

			flag = false;
		return flag;
	}

	public boolean isEnable_audio_recording_dislayed() throws InterruptedException {
		Thread.sleep(10000);
		String EnableDisable = this.sync(AudioRecording).getText();
		// System.out.println(EnableDisable);
		Boolean flag = false;
		if (EnableDisable.contains("Disable")) {
			AudioRecording.click();
			Thread.sleep(10000);

		} else if (AudioRecording.getText().contains("Enable")) {
			// System.out.println(driver.findElement(By.xpath(".//*[@class='lpl-link
			// ng-scope']")).getText());
			flag = true;
		} else {

			flag = false;
		}

		return flag;

	}

	public boolean isMath_class_Text_dislayed() {
		if (Math_class_Text.isDisplayed())
			return true;
		else
			return false;

	}
	
	public boolean isAssignBookReportTitleDisplayed(){
		return this.sync(driver.findElement(By.xpath(".//*[@class='lpl-page-title']/span[1]"))).getText().contains("Assigned Books Report");
	}

	public void clickSeeProgress() {
		this.sync(driver.findElement(By.xpath("(.//div[contains(text(),'SEE PROGRESS')])[1]"))).click();
		
	}
	public boolean isProgressDisplayed(){
		return this.sync(driver.findElement(By.xpath(".//div[@class='book-progress-class-info']"))).isDisplayed();
		
	}

	public void searchRecentBook(String book) {
		try{
			driver.findElement(By.xpath(".//*[@id='searchBooks']")).click();
		}
		catch(Exception e){
			
		}
		
		this.sync(driver.findElement(By.xpath(".//*[@id='searchBooks']"))).sendKeys(book);
		
	    this.sync(driver.findElement(By.xpath(".//*[@id='searchBooks']/parent::div//span"))).click();
		
	}
	
	public boolean isStudentOvervieDisplayed(){
		lazyWait(3);
		return this.sync(driver.findElement(By.xpath(".//*[@class='lpl-page-title']/span[text()='STUDENT OVERVIEW']"))).isDisplayed();
	}
	
	
	public boolean isProgressTimespentLexile(){
		boolean flag=true;
		lazyWait(5);
	if(!this.sync(driver.findElement(By.xpath(".//*[@id='class-students-table']/thead/tr/th[contains(text(),'Student')]"))).isDisplayed())
	{
		return false;
	}
	if(!this.sync(driver.findElement(By.xpath(".//*[@id='class-students-table']/thead/tr/th[contains(text(),'Lexile')]"))).isDisplayed())
		return false;
	if(!this.sync(driver.findElement(By.xpath(".//*[@id='class-students-table']/thead/tr/th[contains(text(),'Progress')]"))).isDisplayed())
		return false;
     if(!this.sync(driver.findElement(By.xpath(".//*[@id='class-students-table']/thead/tr/th[contains(text(),'Time Spent')]"))).isDisplayed())
    	 return false;
	
	return flag;
	
	}

	public void clickOn_StudentLinkReport() {
		this.sync(driver.findElement(By.xpath(".//*[@id='class-students-table']/tbody/tr[1]/td[1]/span"))).click();
		
	}
	
	public boolean isStudentReportDisplayed(){
		lazyWait(5);
		return this.sync(driver.findElement(By.xpath(".//*[@class='modal-dialog']"))).isDisplayed();
	}
	
	public String isSearchBookDisplayed(){
		lazyWait(5);
		System.out.println(driver.findElement(By.xpath(".//*[@class='lpl-book-list-top']/div[2]/span[1]")).getText());
		return this.sync(driver.findElement(By.xpath(".//*[@class='lpl-book-list-top']/div[2]/span[1]"))).getText();
		
		
	}
	public void SelectAllStudentsinStdOveriew(){
		this.sync(driver.findElement(By.xpath(".//*[@dropdown-select-all-class='classSelections']"))).click();
	   lazyWait(3);
		this.sync(driver.findElement(By.xpath(".//a[text()='All Classes']"))).click();
	}
	public void clickExportButtenStudentOverview(){
		this.sync(driver.findElement(By.xpath(".//*[@class='dropdown exportall-dropdown ng-scope']"))).click();
	}
	public boolean isExportDropDowndisplayed(){
		boolean flag = true;
		this.sync(driver.findElement(By.xpath(".//*[@class='dropdown exportall-dropdown ng-scope open']//li[1]/a"))).getText().contains("Classes Data");
		if(!driver.findElement(By.xpath(".//*[@class='dropdown exportall-dropdown ng-scope open']//li[1]/a")).getText().contains("Classes Data"))
		return false;
		if(!driver.findElement(By.xpath(".//*[@class='dropdown exportall-dropdown ng-scope open']//li[1]/a")).getText().contains("Classes Data"))
	      return false;
		return flag;
	}
	//
	
}
