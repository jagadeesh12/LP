package com.scholastic.intl.litpro.test.automation.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scholastic.torque.common.TestBaseProvider;

//import pageobject.ParentPage;

public class AssessmentPg extends ParentPage {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	final String PAGE_TITLE = "Scholastic";

	@FindBy(xpath = "//button[contains(text(),'Get Started')]")
	private WebElement letsGetStartedBtn;

	@FindBy(xpath = "//button[contains(text(),'Go On')]")
	private WebElement goOndBtn;

	@FindBy(xpath = "(//div[@class='quizContentDiv']//div[contains(@class,'answertext')])[1]")
	private WebElement firstAnswer;

	@FindBy(xpath = "(//div[contains(@class,'answertext')])[2]")
	private WebElement secAnswer;

	@FindBy(xpath = "(//div[contains(@class,'answertext')])[3]")
	private WebElement thirdAnswer;

	@FindBy(xpath = "(//div[contains(@class,'answertext')])[4]")
	private WebElement fourthAnswer;

	@FindBy(xpath = "//div[contains(@class,'testIcon-0-true')]")
	private WebElement firstAnswerSelected;

	@FindBy(xpath = "//div[@class='quizContentDiv']/div[@class='selected-true']")
	private WebElement selectedAnsText;

	@FindBy(xpath = "//div[@class='buttonArea']/button[contains(text(),'Next')]")
	private WebElement nextBtn;

	@FindBy(xpath = "//div[@class='sriQuizPage']/div[contains(@class, 'question')]")
	private WebElement questionText;

	@FindBy(xpath = "//div[contains(text(),'Congratulations')]")
	private WebElement congratsMessage;

	@FindBy(xpath = "//button[contains(text(),'Create Reading List')]")
	private WebElement creatingReadingListBtn;

	@FindBy(xpath = ".//*[@class='lex ng-binding']")
	private WebElement Lexilescoreendtest;
	@FindBy(xpath = ".//a[contains(text(),'Logout')]")
	private WebElement logout;

	@FindBy(xpath = "//button[@class='btn btn-teal btn-circle ng-scope']")
	private WebElement CrossOnTab;

	@FindBy(xpath = ".//div[@class='litpro-quitTestDialogDiv row ng-scope']//strong")
	private WebElement CrossOnTabConformation;

	@FindBy(xpath = "//button[contains(text(),'Yes, quit')]")
	private WebElement YesquitBtn;
	@FindBy(xpath = "//button[contains(text(),'Skip')]")
	private WebElement Skipbutton;

	@FindBy(xpath = "//button[contains(text(),'Go On')]")
	private WebElement GoOnButton;

	public AssessmentPg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public boolean startAssessment() {
		boolean flag = true;
		this.reportLog("Click 'Lets get started' button");
		this.click(letsGetStartedBtn);

		// check if there are any assessment left or left the earlier assessment
		// incomplete
		WebElement infoTextElement = this.getElement(By
				.xpath("//h2[@class='infotext']/strong"));
		if (infoTextElement != null) {
			this.lazyWait(5);
			String infoTextString = infoTextElement.getText();
			this.reportLog("Info Text: " + infoTextString);
			if (infoTextString
					.contains("You are resuming a test you started earlier")) {
				this.reportLog("Resumed the earlier test");
				this.click(this.goOndBtn);
			}
			if (infoTextString.contains("There are no SRI questions remaining")) {
				this.reportLog("There were no SRI questions left");
				this.click(this.goOndBtn);
				flag = false;
			}
		}

		return flag;
	}

	public void completeAssessment() {
		while (!this.isTestOver()) {
			//this.reportLog("Question: " + this.getText(questionText));
			this.answerRandomly();
			this.reportLog("Ans Selected: " + this.getText(selectedAnsText));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			this.sync(nextBtn);
			executor.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
			
			this.click(this.nextBtn);
		}
	}
	
	public static HashMap<String, String> hmap = new HashMap<String, String>();
	
	util StudentTestData = util.getInstance();
	
	public HashMap<String, String> completeAssessmentStore() {
		String selectedAnswer;
		String Question;
		String answer;
		while (!this.isTestOver()) {
			//this.reportLog("Question: " + this.getText(questionText));
			Question = "Passage :"+this.getText(PassageTest).replaceAll("\n"," ").replaceAll("  "," ")+"Questions :"+this.getText(questionText).replaceAll("_", "");
			this.answerRandomly();
			this.reportLog("Ans Selected: " + this.getText(selectedAnsText));
			selectedAnswer=" Answer "+this.getText(selectedAnsText);
			answer=this.getText(firstAnswer)+","+this.getText(secAnswer)+","+this.getText(thirdAnswer)+","+this.getText(fourthAnswer)+","+selectedAnswer;
			StudentTestData.add(Question, answer);
			System.out.println("^^^^^^^^^"+Question);
			System.out.println("-------------"+answer);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			this.sync(nextBtn);
			executor.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
			
			this.click(this.nextBtn);
		}
		return hmap;
	}
	
	@FindBy(xpath = "//div[@ng-bind-html='passage']")
	private WebElement PassageTest;
	
	private boolean isTestOver() {
		try {
			this.waitForNextQuestion();
			Thread.sleep(3000);
			driver.findElement(By
					.xpath("//button[contains(text(),'Create Reading List')]"));
			return true;

		} catch (Exception e) {
		}
		return false;
	}

	/* waits until there is no selected ans, that is new question */
	private void waitForNextQuestion() {
		try {
			(new WebDriverWait(driver, 2))
					.until(ExpectedConditions.invisibilityOfElementLocated(By
							.xpath("//div[@class='quizContentDiv']/div[@class='selected-true']")));
		} catch (Exception e) {

		}
	}

	// select a random answer
	private void answerRandomly() {
		int random = (int) (Math.random() * 4);
		String xpath = "//div[@class='quizContentDiv']//div[contains(@class,'testIcon-"
				+ random + "')]";

		WebElement answere = this.getElement(By.xpath(xpath));
		if (answere != null) {
			answere.click();
		} else {
			this.click(this.firstAnswer);
		}
	}

	public void clickCreateReadingList() {
		this.reportLog("Click 'Create My Reading list' Button");
		this.sync(creatingReadingListBtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", creatingReadingListBtn);
		
	}

	public void goToLpHomePg() {
		this.reportLog("Goto LitPro Home");
		this.click(creatingReadingListBtn);
	}

	public void incompleteAssessment() {

		this.reportLog("Question: " + this.getText(questionText));
		this.answerRandomly();
		this.reportLog("Ans Selected: " + this.getText(selectedAnsText));
		this.click(this.nextBtn);
	}

	public boolean LexileScore() {
		if (Lexilescoreendtest.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean NoLexileScore() {
		if (Lexilescoreendtest.isDisplayed()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean verifyDirectionValue(String value) {

		boolean flag = false;

		WebElement infoTextElement = this.getElement(By
				.xpath(".//*[@id='ng-app']/body/div[6]/div[2]"));
		this.reportLog(infoTextElement.getText());
		if (infoTextElement != null) {
			String infoTextString = infoTextElement.getText();
			this.reportLog("Info Text: " + infoTextString);
			if (infoTextString.contains(value)) {
				this.reportLog("Direction Page data  found ");
				flag = true;
			} else {
				this.reportLog("No direction page data not found");
				flag = false;
			}

		}
		return flag;
	}

	public boolean completeAssessment_practisetest() {
		boolean flag = false;
		while (!this.isTestOver()) {
			try {
				GoOn_practiseButton();
				this.reportLog("Question: " + this.getText(questionText));
				this.answerRandomly();
				this.reportLog("Ans Selected: " + this.getText(selectedAnsText));

				if ((flag == false) && !(Skipbutton.isDisplayed())) {
					this.reportLog("^^111^^^");
					flag = true;
				}
			} catch (Exception e) {
			}
			this.click(this.nextBtn);
		}
		return flag;
	}

	public void GoOn_practiseButton() {
		try {
			if (GoOnButton.isDisplayed()) {
				GoOnButton.click();
			}
		} catch (Exception e) {
		}
	}

	public void closePopup() {
		reportLog("Closing the test popup to interupt the test");
		CrossOnTab.click();
		try {
			if (CrossOnTabConformation.isDisplayed()) {
				reportLog(CrossOnTabConformation.getText());
				YesquitBtn.click();
				reportLog("Pressed button " + YesquitBtn.getText());
			}
		} catch (Exception e) {

		}
	}

	public boolean startPauseAssessment() {
		boolean flag = false;
		this.reportLog("Click 'Lets get started' button");
		this.click(letsGetStartedBtn);

		// check if there are any assessment left or left the earlier assessment
		// incomplete
		WebElement infoTextElement = this.getElement(By
				.xpath("//h2[@class='infotext']/strong"));
		if (infoTextElement != null) {
			this.lazyWait(5);
			String infoTextString = infoTextElement.getText();
			this.reportLog("Info Text: " + infoTextString);
			if (infoTextString
					.contains("You are resuming a test you started earlier")) {
				this.reportLog("Resumed the earlier test");
				this.click(this.goOndBtn);
				flag = true;
			}
		}

		return flag;
	}

	public void Handletestalert() {
		logout.click();
		reportLog("Logging out as a student");
		/*
		 * lazyWait(5); Alert alert = driver.switchTo().alert(); alert.accept();
		 * lazyWait(5);
		 */

		switchToNewWindow();
	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}
}