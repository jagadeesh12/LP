package com.scholastic.intl.litpro.test.automation.pageobjects.lpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;


/* @ Author: Rajesh R
 * @ Created Date:04/01/2016
 * @ Functionality: Collection Page Objects
 * @ Type: Smoke, regression
 * 
 * 
 * @ Updated Date:
 * @ Updated By Rajesh R
 * 
 */

public class CollectionsPage extends ParentPage {
	private LitProUserType lpUserType;

	@FindBy(css = ".lpl-page-title1")
	private WebElement pgHeader;
	@FindBy(xpath = "(//div[text()='ASSIGN'])[1]")
	private WebElement ASSIGN;
	@FindBy(xpath = "(//div[text()='ASSIGNED'])[1]")
	private WebElement ASSIGNED;
	@FindBy(xpath = "//span[text()='Assign to']")
	private WebElement Assign_to_InPopup;
	@FindBy(xpath = "//div[@class='lpl-assigned-student-name ng-binding']")
	private WebElement entireClass_students;
	@FindBy(xpath = "//button[text()='Assign to Students']")
	private WebElement Assign_to_Students;
	@FindBy(xpath = "//span[text()='This assignment has been sent to your students']")
	private WebElement Assigned_text;
	@FindBy(xpath = "//button[@id='assignedConfimed']")
	private WebElement done_button;
	@FindBy(xpath = "(//div[div[@class='lpl-teacher-book-list-book-assign ng-scope']]/div[2])[1]")
	private WebElement first_book_of_ASSIGN;
	@FindBy(xpath = "//span[@class='lpl-page-title-collections lpl-cursor-pointer']")
	private WebElement Scholastic_collections_header;
	@FindBy(how = How.XPATH, using = "//button[text()='Read']")
	private WebElement Read_InPopup;
	@FindBy(how = How.XPATH, using = "//button[text()='Assign']")
	private WebElement Assign_InPopup;
	
	@FindBy(xpath = "//a[contains(text(),'HOME')]")
	private WebElement homeTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Entire Class']")
	WebElement Entire_class;
	@FindBy(how = How.XPATH, using = "//span[text()='Assigned to']")
	WebElement Assigned_to_InPopup;
	@FindBy(xpath = ".//button[text()='Clear all assignments']")
	private WebElement clearAllAssignments;
	@FindBy(how = How.XPATH, using = "//button[text()='Save Changes']")
	WebElement save_changes_button;
	@FindBy(how = How.XPATH, using = "//button[text()='Assigned']")
	WebElement Assigned_InPopup;
	
	@FindBy(xpath = "(//div[contains(@class,'lpl-teacher-book-list-book-assign')])[1]")
	private WebElement Assign_colleaction;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='selected ng-binding'])[1]")
	private WebElement SortNAme;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='lpl-book-list-grid-item col-md-4 ng-scope']//img)[1]")
	private WebElement FirstCollection;

	public CollectionsPage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(this.DRIVER_WAIT);
	}

	WebDriver driver;
	final String PAGE_TITLE = "Literacy Pro Library";
	final String PAGE_HEADER = "Students";

	public String getHeaderText() {
		return this.getText(pgHeader);
	}

	public boolean verifyCollectionHeader() {
		if (pgHeader.getText().contains("Scholastic Collections"))
			return true;
		else
			return false;
	}
	
	public boolean verifyCollectionHeaderStudent() {
		if (pgHeader.getText().contains("Collections"))
			return true;
		else
			return false;
	}
	
	public void OpenCollection(){
		click(FirstCollection);
	}
	
	public void OpenCollectionStudent(){
		click(FirstcollectionStudent);
	}
	
	@FindBy(xpath = "(//div[@class='lpl-book-list-book-img']/img[2])[1]")
	private WebElement FirstcollectionStudent;
	
	public void SortCollection(String SortBy){
		click(SortNAme);
		String Xpath = "//ul/li/a[contains(text(),'"+SortBy+"')]";
		click(driver.findElement(By.xpath(Xpath)));
		reportLog("Sorting collections book by name");
	}

	public boolean VerifySortingCollection(String Sorting) throws InterruptedException{
		lazyWait(5);
		boolean result = false;
		String Xpath = "//div[@class='lpl-book-list-book-assign assigned ng-scope']";
		int count = driver.findElements(By.xpath(Xpath)).size();
		ArrayList<String> obtainedList = new ArrayList<String>(); 
		String title;
		if(Sorting.equalsIgnoreCase("NAME")){
			for(int i=1; i<=count; i++){
				lazyWait(3);
				System.out.println("---------------------------"+i);
				System.out.println("(//div[@class='lpl-book-list-book-assign assigned ng-scope'])["+i+"]");
				driver.findElement(By.xpath("(//div[@class='lpl-book-list-book-assign assigned ng-scope'])["+i+"]")).click();
				wait.until(ExpectedConditions.visibilityOf(TitlePopup));				
				title = getText(TitlePopup);
				obtainedList.add(title);
				click(ClosePopup);
				if(i%5==0){
					scrolldownTillEnd(300);
					System.out.println("I am scrolling ");
				}
			}
			
			System.out.println("+++++++++++++++++++++++++++++++++"+obtainedList.toString());
			
			ArrayList<String> sortedList = new ArrayList<String>();
			for (String s : obtainedList) {
				sortedList.add(s);
			}
			Collections.sort(sortedList);

			System.out.println("=================================="+sortedList.toString());
			
			System.out.println(sortedList.toString()+"-------------"+(obtainedList.toString()));

			if(sortedList.toString().equals(obtainedList.toString())){
				result = true;
				reportLog("Collections are sorted in alphabetical order");
			}			
		}
		
		ArrayList<Integer> NumLex = new ArrayList<Integer>();
		ArrayList<Integer> Sorted = new ArrayList<Integer>();
		if(Sorting.equalsIgnoreCase("LEXILE")){
				for(int i=1; i<=count; i++){
					lazyWait(3);
					System.out.println("---------------------------"+i);
					System.out.println("(//div[@class='lpl-book-list-book-assign assigned ng-scope'])["+i+"]");
					driver.findElement(By.xpath("(//div[@class='lpl-book-list-book-assign assigned ng-scope'])["+i+"]")).click();
					wait.until(ExpectedConditions.visibilityOf(TitlePopup));				
					title = getText(driver.findElement(By.xpath("//span[contains(text(),'Lexile:')]/parent::div/span[2]"))).replace("L", "");
					System.out.println("__"+title);
					NumLex.add(Integer.parseInt(title));
					Sorted.add(Integer.parseInt(title));
					click(ClosePopup);
					if(i%5==0){
						scrolldownTillEnd(300);
						System.out.println("I am scrolling ");
					}
				}
			 Collections.sort(NumLex);
			 System.out.println(NumLex.toString()+"''''''''''''''''''''''''"+(Sorted.toString()));
			 if(NumLex.toString().equals(Sorted.toString())){
					result = true;
					reportLog("Collections are sorted in Lexile order");
			 }
			}
		
		return result;
	}
	
	@FindBy(xpath = "//span[@class='lpl-modal-title ng-binding']")
	private WebElement TitlePopup;
	
	@FindBy(xpath = "//span[@class='lpl-icon lpl-icon-close']")
	private WebElement ClosePopup;
	
	public boolean CollectionAlphabeticalOrderStudent(){
		boolean result = false;
		
		ArrayList<String> obtainedList = new ArrayList<String>(); 
		List<WebElement> elementList= driver.findElements(By.xpath("//div[contains(@class,'lpl-student-book-list-grid-item-width')]/div[1]"));
		for (WebElement we : elementList) {
			obtainedList.add(we.getText());
		}
		obtainedList.toString();
		
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);

		if(sortedList.toString().equals(obtainedList.toString())){
			result = true;
			reportLog("Collections are sorted in alphabetical order");
		}
		return result;		
	}
	
	public boolean CollectionAlphabeticalOrder(){
		boolean result = false;
		
		ArrayList<String> obtainedList = new ArrayList<String>(); 
		List<WebElement> elementList= driver.findElements(By.xpath("//div[contains(@class,'lpl-teacher-book-list-book-assign')]/parent::div/div[1]"));
		for (WebElement we : elementList) {
			obtainedList.add(we.getText());
		}
		obtainedList.toString();
		
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);

		if(sortedList.toString().equals(obtainedList.toString())){
			result = true;
			reportLog("Collections are sorted in alphabetical order");
		}
		
		return result;
	}
	
	public void clickOn_Assign_Collection() throws InterruptedException{
			Thread.sleep(3000);
			String Assign = Assign_colleaction.getText();
			if(Assign.equalsIgnoreCase("ASSIGNED")){
				reportLog("The Collection is Assigned, So I am unassigning it");
				this.sync(ASSIGNED).click();
				Thread.sleep(3000);
				//clickOnEntire_class();
				this.sync(driver.findElement(By.xpath(".//button[contains(text(),'Clear all')]"))).click();
				Thread.sleep(3000);
				this.sync(driver.findElement(By.xpath(".//button[contains(text(),'Save Changes')]"))).click();
				Thread.sleep(3000);
				//clickOndone_button();
				//Thread.sleep(3000);
			}
			setCollectionTitle(driver.findElement(By.xpath("(//div[contains(@class,'lpl-teacher-book-list-book-assign')])[1]/parent::div/div/div")).getText());
			ASSIGN.click();
			reportLog("Assigning the collections to the student");
	}
	
	public void clickOn_ASSIGN_Text_On_Book() throws InterruptedException {
		//this.sync(ASSIGN).click();
	try{
		Thread.sleep(3000);
		setCollectionTitle(driver.findElement(By.xpath("(//div[text()='ASSIGN'])[1]/parent::div/div/div")).getText());
		ASSIGN.click();
	}
	catch(Exception e){
		this.sync(ASSIGNED).click();
		Thread.sleep(3000);
		//clickOnEntire_class();
		this.sync(driver.findElement(By.xpath(".//button[contains(text(),'Clear all')]"))).click();
		Thread.sleep(3000);
		this.sync(driver.findElement(By.xpath(".//button[contains(text(),'Save Changes')]"))).click();
		Thread.sleep(3000);
		clickOndone_button();
		Thread.sleep(3000);
		setCollectionTitle(driver.findElement(By.xpath("(//div[text()='ASSIGN'])[1]/parent::div/div/div")).getText());
		this.sync(ASSIGN).click();
	}
	}

	public void clickOn_ASSIGNED_Text_On_Book() {
		this.sync(ASSIGNED).click();
	}

	public void clickOnAssign_to_Students() {
		this.sync(Assign_to_Students).click();
	}

	public void clickOndone_button() {
		this.sync(done_button).click();
	}

	public void clickOn_collection_of_book_Assign() {
		this.sync(first_book_of_ASSIGN).click();
	}

	public void clickOn_Assign_InPopup() {
		this.sync(Assign_InPopup).click();
	}

	public String Assigned_text() {
		String value = Assigned_text.getText();
		return value;
	}

	public boolean isAssign_to_text_displayed() {
		if (this.sync(Assign_to_InPopup).isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isScholastic_collections_header_displayed() {
		if (this.sync(Scholastic_collections_header).isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isEntireClass_students_dislayed() {
		if (this.sync(entireClass_students).isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isReadbuttondislayed() {
		this.sync(Read_InPopup);
		if (Read_InPopup.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isAssignbuttondislayed() {
		if (this.sync(Assign_InPopup).isDisplayed())
			return true;
		else
			return false;

	}

	public LitProLibraryHomePg goToHomePage() {
		this.sync(homeTab);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", homeTab);
		return new LitProLibraryHomePg(driver, lpUserType);
	}
	
	public void clickOnEntire_class() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
      boolean entireSelected =  (Boolean) executor.executeScript("return $('#entire-select').is(':checked')");
		
      try{
    	  if(!entireSelected){
      
          Entire_class.click();
    	  }
		else{
			/*Entire_class.click();
			Thread.sleep(3000);
			Entire_class.click();*/
			Thread.sleep(3000);
		}
      }
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickOnAssignedOnCollection() {
		try{
			Thread.sleep(3000);
			this.sync(ASSIGNED);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", ASSIGNED);
		}
		catch(Exception e){
			e.printStackTrace();
		
	}
	}
	public boolean isAssigned_to_text_displayed() {
		this.sync(Assigned_to_InPopup);
		if (Assigned_to_InPopup.isDisplayed())
			return true;
		else
			return false;

	}
	public void clickOn_clearAllAssignments() {
		lazyWait(4);
		this.sync(clearAllAssignments);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", clearAllAssignments);
	}
	public void clickOn_save_changes_button() {
		lazyWait(4);
		this.sync(save_changes_button);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", save_changes_button);
		lazyWait(4);
		driver.navigate().refresh();
	}
	public boolean isAssignedbookDisplayed() {
		if(this.sync(ASSIGNED).isDisplayed())
			return true;
		return false;
	}
	public void clickOnASSIGNED() {
		lazyWait(4);
		this.sync(ASSIGNED);
       JavascriptExecutor executor = (JavascriptExecutor)driver;
		
        executor.executeScript("arguments[0].click();", ASSIGNED);
    	lazyWait(4);
	}
}