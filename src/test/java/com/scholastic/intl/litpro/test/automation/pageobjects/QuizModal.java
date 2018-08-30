package com.scholastic.intl.litpro.test.automation.pageobjects;

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

//import pageobject.ParentPage;

public class QuizModal extends ParentPage {
	WebDriver driver;
	final String PAGE_TITLE = "Scholastic";
	SettingsPg lpSettingsPg;

	@FindBy(xpath = "//div[contains(@class,'available-quizzes-modal')]//h3[contains(text(),'Quizzes for')]")
	private WebElement quizModalHeader;

	@FindBy(xpath = "//div[contains(@class,'available-quizzes-modal')]//button[span[text()='Take Quiz']]")
	private WebElement takeQuizBtn;

	@FindBy(xpath = "//div[contains(@class,'available-quizzes-modal')]//button[i[@class='img-btn-close']]")
	WebElement quizModalCloseBtn;

	@FindBy(xpath = "//div[contains(@class,'SRCQuizView')]//div[contains(@class,'quizIcon-0')]")
	private WebElement firstAnswer;

	@FindBy(xpath = "//div[contains(@class,'SRCQuizView')]//div[contains(@class,'quizIcon-1')]")
	private WebElement secAnswer;

	@FindBy(xpath = "//div[contains(@class,'SRCQuizView')]//div[contains(@class,'quizIcon-2')]")
	private WebElement thirdAnswer;

	@FindBy(xpath = "//div[contains(@class,'SRCQuizView')]//div[contains(@class,'quizIcon-3')]")
	private WebElement fourthAnswer;

	@FindBy(xpath = "//div[contains(@class,'SRCQuizView')]//div[contains(@class,'quizIcon-0-true')]")
	private WebElement firstAnswerSelected;

	@FindBy(xpath = "//div[contains(@class,'SRCQuizView')]//div[@class='answerrow-true-live']")
	private WebElement selectedAnsText;

	@FindBy(xpath = "//div[contains(@class,'SRCQuizView')]//input[@value='Next']")
	private WebElement nextBtn;

	@FindBy(xpath = "//div[contains(@class,'SRCQuizView')]//div[contains(@class,'quizContentDiv')]/div[contains(@class, 'question')]")
	private WebElement questionText;

	@FindBy(xpath = "//div[@class='myCommentsModal']//input[@value='Done']")
	private WebElement doneBtn;

	@FindBy(xpath = "//input[@value='Finish']")
	private WebElement finishBtn;

	@FindBy(xpath = "//div[@class='myCommentsModal']/div[@class='scorerow']/div[1]")
	private WebElement scoreText;

	@FindBy(xpath = "//div[@class='myCommentsModal']/div[@class='scorerow']/div[2]")
	private WebElement scorePercentage;

	@FindBy(xpath = "//div[@class='myCommentsModal']/div[@class='ratingrow']//input[@value='Loved it!']")
	private WebElement ratingLovedIt;

	@FindBy(xpath = "//div[@class='myCommentsModal']//input[@value='View Incorrect Answers']")
	private WebElement ViewIncorrectAnswers;

	@FindBy(xpath = "//div[contains(@class,'notification-content')]/h3")
	private WebElement error_message_search;

	@FindBy(xpath = "//div[@class='srcQuitDialog quitModalBody ng-scope']")
	private WebElement ResumeQuizBox;

	@FindBy(xpath = "//div[@class='srcQuitDialog quitModalBody ng-scope']//button[@class='btn btn-primary btn-large quitRButton']")
	private WebElement NewQuizButton;

	@FindBy(xpath = ".//textarea[@placeholder='Type your comments here...']")
	private WebElement commentTextbox;
	
	public QuizModal(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public String getModalHeader() {
		this.sync(quizModalHeader);
		return this.getText(quizModalHeader);
	}

	public void clickTakeQuiz() {
		this.reportLog("Click 'Take Quiz' button");
		this.sync(takeQuizBtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", takeQuizBtn);
		//this.click(this.takeQuizBtn);
		 executor.executeScript("arguments[0].click();", takeQuizBtn);
		 lazyWait(3);
		try {
			if (ResumeQuizBox.isDisplayed()) {
				JavascriptExecutor executor1 = (JavascriptExecutor) driver;
				executor1.executeScript("arguments[0].click();",NewQuizButton);
				//executor1.NewQuizButton.click();
				this.reportLog("A new quiz is started");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void completeQuiz() throws InterruptedException {
		this.reportLog("Attending quiz..");
		boolean lastQuestion = this.isQuizOver();
		boolean clickFinish = lastQuestion;

		while (!lastQuestion || clickFinish) {
			this.reportLog("Question: " + this.getText(questionText));
			this.answerRandomly();
			this.reportLog("Ans Selected: " + this.getText(selectedAnsText));
			Thread.sleep(3000);
			if (clickFinish) {
				this.reportLog("Click 'Finish' Button");
				this.click(this.finishBtn);
				lastQuestion = true;
				clickFinish = false;
			} else {
				this.reportLog("Click 'Next' Button");
				this.click(this.nextBtn);
				lastQuestion = this.isQuizOver();
				clickFinish = lastQuestion;
			}
		}
	}

	private void answerRandomly() throws InterruptedException {
		int random = (int) (Math.random() * 4);
		String xpath = "//div[contains(@class,'SRCQuizView')]//div[contains(@class,'quizIcon-"
				+ random + "')]";
		WebElement answere = this.getElement(By.xpath(xpath));
		if (answere != null) {
			this.reportLog("Select Answer#" + random);
			answere.click();
			Thread.sleep(2000);
		} else {
			this.reportLog("Answer#" + random
					+ " NOT displayed, so selecting answer#1");
			this.click(this.firstAnswer);
			Thread.sleep(2000);
		}
	}

	public String getQuizScore() {
		String scr = this.getText(scoreText);
		this.reportLog("Quiz Score: " + scr);
		return scr;
	}

	public String getQuizPercentage() {
		String per = this.getText(scorePercentage);
		this.reportLog("Quiz Percentage: " + per);
		return per;
	}

	public void clickDoneBtn() {
		this.reportLog("Click 'Done' Button");
		this.sync(doneBtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", doneBtn);
		doneBtn.click();
	}

	public boolean selectRating() {
		String xpath = "//div[@class='myCommentsModal']/div[@class='ratingrow']//input[@value='Loved it!']";
		WebElement lovedItButton = this.getElement(By.xpath(xpath));
		if (lovedItButton != null) {
			this.reportLog("Quiz Cleared Successfully");
			lovedItButton.click();
			return true;
		}
		return false;
	}
	
	public void Comments(String comments){
		commentTextbox.sendKeys(comments);
	}

	private boolean isQuizOver() {
		try {
			this.waitForNextQuestion();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@value='Finish']"));
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	private void waitForNextQuestion() {
		try {
			(new WebDriverWait(driver, 2))
					.until(ExpectedConditions.invisibilityOfElementLocated(By
							.xpath("//div[contains(@class,'SRCQuizView')]//div[@class='answerrow-true-live']")));
		} catch (Exception e) {

		}
	}

	public boolean isIncorrectAnsExist() {
		String xpath = "//div[contains(@class,'SRCQuizView')]//div[@class='answerrow-true-review']";

		if (this.getElement(By.xpath(xpath)) != null)
			return true;
		else
			return false;
	}

	public void clickViewIncorrectAns() {
		WebElement we = this.getElement(By
				.xpath("//input[@value='View Incorrect Answers']"));
		we.click();

	}

	public void clickExitQuizBtn() {
		WebElement we = this
				.getElement(By.xpath("//input[@value='Exit Quiz']"));
		we.click();

	}

	/****************************************************************************************/

	public boolean ViewIncorrectAnswer() {
		if (ViewIncorrectAnswers.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ViewIncorrectAnswerhide() {
		if (ViewIncorrectAnswers.isDisplayed()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean Error_mesages() throws InterruptedException {
		this.click(this.takeQuizBtn);
		Thread.sleep(2000);
		this.reportLog("Message should be displayed for exceeding max number of attempts for the quiz");
		try {
			this.sync(driver.findElement(By.xpath("//div[contains(@class,'notification-content')]/h3")));
			error_message_search.isDisplayed();
			String time = error_message_search.getText();
			time.equals("You have exceeded max attempts for this quiz.");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean QuizzeBox() {
		try {
			this.sync(firstAnswer).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean TakeQuizVerifyError() {
		this.reportLog("Click 'Take Quiz' button");
		this.sync(takeQuizBtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", takeQuizBtn);
		takeQuizBtn.click();
		try {
			error_message_search.isDisplayed();
			String time = error_message_search.getText();
			time.contains("Time interval between quizzes is too low");
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean testScore() {
		String percentage;
		percentage = getQuizPercentage().trim();
		try {
			percentage.equals(SettingsPg.PassmarksmarksStudent);
			//ratingLovedIt.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void clickTakeQuizError() {
		this.reportLog("Click 'Take Quiz' button");
		
	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}
	public void clickSingleTakequizButton() {
		lazyWait(4);
		this.sync(driver.findElement(By.xpath(".//input[@value='Take the Quiz']"))).click();
		
	}

	public void startTheQuiz() {
		try {
			if (ResumeQuizBox.isDisplayed()) {
				NewQuizButton.click();
				this.reportLog("A new quiz is started");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
	//util util1 = util.getInstance();
	public boolean verifyQuesAndAnswers() throws InterruptedException {
		boolean flag = true;
		this.reportLog("Attending quiz..");
		boolean lastQuestion = this.isQuizOver();
		boolean clickFinish = lastQuestion;
		System.out.println(util.getMap());
		Map<String, String> map = util.getMap();
         System.out.println(map.size());
         lazyWait(5);
		while (!lastQuestion || clickFinish) {
			this.reportLog("Question: " + this.getText(questionText));
			String questextfromapp= this.getText(questionText);
			String afterrem=questextfromapp.replaceAll("^(\\d+)\\.", "").trim();
			String values=getkeyvalmap(afterrem,map);
			//String values =util.getValue(afterrem);
			System.out.println(afterrem);
			//values.replaceAll(regex, replacement)
			//values.replaceAll("^(\\d+)\\.", "");
			System.out.println(values);
			String actual =driver.findElement(By.xpath("//div[contains(@class,'SRCQuizView')]/div[2]//div[contains(@class,'span8')]")).getText();
			//String actual=map.get(values);
			System.out.println("Teacher quiz ans"+values);
			System.out.println("student quiz ans"+actual);
			if(!compareTeacherwithStudentAnswers(values,actual)){
				System.out.println("------------------false-----------");
				return false;
			}
			this.answerRandomly();
			this.reportLog("Ans Selected: " + this.getText(selectedAnsText));
			Thread.sleep(3000);
			if (clickFinish) {
				this.reportLog("Click 'Finish' Button");
				this.click(this.finishBtn);
				lastQuestion = true;
				clickFinish = false;
			} else {
				this.reportLog("Click 'Next' Button");
				this.click(this.nextBtn);
				lastQuestion = this.isQuizOver();
				clickFinish = lastQuestion;
			}
		}
		return flag;
		
	}

	private boolean compareTeacherwithStudentAnswers(String values, String actual) {
		boolean flag=true;
		 String[]  array = values.split(".");
		 for(String s : array){
			 System.out.println("inside loop-------------------------------------------------"+s);
			 System.out.println("inside loop-------------------------------------------------"+actual);
			if( !(actual.contains(s))){
				flag=false;
				
			}
		 }
		return flag;
		
	}
	public String getkeyvalmap(String afterrem, Map<String, String> map){
		String value = null;
	
	for (Entry<String, String> entry :map.entrySet()) {
		System.out.println("---------------map"+entry.getKey());
		System.out.println(afterrem);
        if (entry.getKey().contains(afterrem)) {
            System.out.println(entry.getKey());
            value =entry.getValue();
            System.out.println(value);
        }
    }
	return value;
	}
}