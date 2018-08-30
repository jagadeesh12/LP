package com.scholastic.intl.litpro.test.automation.pageobjects;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import static org.junit.Assert.assertTrue;







//import pageobject.ParentPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.torque.common.TestBaseProvider;

public class MyResultsPg extends ParentPage {
	BooksObject booksObj = new BooksObject();
	BooksObject booksObjs = new BooksObject();
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	LitProHomePg lpHome;
	int goldpoint = 0;
	int silverpoint = 0;
	int bronzepoint = 0;
	int redpoint = 0;
	int bluepoint = 0;
	int points = 0;

	@FindBy(xpath = "//div[@class='myResultsTabContentHeader']/div[text()='Date']")
	private WebElement dateSortLink;
	// @FindBy(xpath = "")
	// private WebElement ;

	@FindBy(xpath = "//*[@id='results']/div[1]/div/div[1]/p[1]")
	private WebElement mylexileLabel;

	@FindBy(xpath = "//*[@id='results']/div[1]/div/div[1]/p[2]")
	private WebElement mylexileText;

	@FindBy(xpath = "//*[@id='results']/div[1]/div/div[2]/p[1]")
	private WebElement certificateLabel;

	@FindBy(xpath = "//*[@id='results']//div[2]/p[2]")
	private WebElement certificateText;

	@FindBy(xpath = "//*[@id='results']/div[1]/div/div[3]/p[1]")
	private WebElement quizpassedLabel;

	@FindBy(xpath = "//*[@id='results']//div[3]/p[2]")
	private WebElement quizpassedText;

	@FindBy(xpath = "//*[@id='results']/div[1]/div/div[4]/p[1]")
	private WebElement wordsreadLabel;

	@FindBy(xpath = "//*[@id='results']/div[1]/div/div[4]/p[2]")
	private WebElement wordsreadText;

	@FindBy(xpath = "//*[@id='results']/div[1]/div/div[5]/p[1]")
	private WebElement avgquizscoreLabel;

	@FindBy(xpath = "//*[@id='results']/div[1]/div/div[5]/p[2]")
	private WebElement avgquizscoreText;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[1]/div[1]")
	private WebElement titleLabel;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[2]/div[1]/div[1]/div[1]")
	private WebElement titleText;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[1]/div[2]")
	private WebElement authorLabel;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[2]/div/div[1]/div[2]")
	private WebElement authorText;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[1]/div[3]")
	private WebElement lexileLabel;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[2]/div/div[1]/div[3]")
	private WebElement lexileText;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[1]/div[4]")
	private WebElement wordcountLabel;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[2]/div/div[1]/div[4]")
	private WebElement wordcountText;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[1]/div[5]")
	private WebElement scoreLabel;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[2]/div[1]/div[1]/div[5]")
	private WebElement scoreText;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[1]/div[6]")
	private WebElement pointsLabel;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[2]/div/div[1]/div[6]")
	private WebElement pointsText;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[1]/div[7]")
	private WebElement dateLabel;

	@FindBy(xpath = "//*[@id='results']/div[3]/div/div[2]/div/div[1]/div[7]")
	private WebElement dateText;

	@FindBy(xpath = "//*[@id='results']/div[2]/div/div/button[2]")
	private WebElement talbeview;
	@FindBy(xpath = "//div[@class='row commentslabel ng-scope ng-binding']")
	private WebElement bookRating;

	@FindBy(xpath = ".//div[@class='title ng-binding']")
	private WebElement bookRatingTitle;

	@FindBy(xpath = ".//input[@value = 'Done']")
	private WebElement DoneButton;

	@FindBy(xpath = "//span")
	private WebElement PrintCertificateStudentName;

	@FindBy(xpath = ".//*[@id='ng-app']//div[contains(text(),'Welcome')]")
	private WebElement StudentNameLitpro;

	@FindBy(xpath = "html/body/div[1]/img[3]")
	private WebElement PrintMyresultAwardCertificate;

	@FindBy(xpath = ".//img[contains(@src,'star_icon_blue.png')]")
	private WebElement PrintMyresultCertificateStar;

	@FindBy(xpath = ".//*[@id='results']//ul/li/button/span[contains(text(),'Print Award Certificate')]")
	private WebElement PrintMyresultCertificate;

	@FindBy(xpath = ".//*[@id='results']//div[2]/p[2]")
	private WebElement CertificateMyresult;

	@FindBy(xpath = ".//*[@id='results']/div[2]/div/div[2]/button[2]")
	private WebElement PrintList;

	@FindBy(xpath = ".//*[@id='results']//ul/li/button/span[contains(text(),'Print My Activities')]")
	private WebElement PrintActivites;

	@FindBy(xpath = ".//*[@id='results']/div[2]/div/div[1]/button[2]")
	private WebElement Listview;

	// *[@id='save-settings']

	public MyResultsPg(WebDriver driver, LitProUserType userType) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public void sortByDate() {
		this.reportLog("Sort by Date");
		this.click(dateSortLink);
	}

	public void sortByTitle() {
		this.reportLog("Sort by Title");
		this.click(titleLabel);
	}

	public void sortByAuthor() {
		this.reportLog("Sort by Author");
		this.click(authorLabel);
	}

	public void sortByLexile() {
		this.reportLog("Sort by Lexile");
		this.click(lexileLabel);
	}

	public void sortByScore() {
		this.reportLog("Sort by Score");
		this.click(scoreLabel);
	}

	public void sortByPoints() {
		this.reportLog("Sort by Points");
		this.click(pointsLabel);
	}

	public QuizResult getQuizResultForBook(String bookTitle) {
		QuizResult result = null;
		this.sortByDate();
		String bookXpath = "//div[div[contains(@class,'title') and text()=\""
				+ bookTitle + "\"]]";
		WebElement children = this.getElement(By.xpath(bookXpath));
		if (children != null) {
			result = new QuizResult();
			result.bookTitle = bookTitle;
			result.percentage = this.getChildElement(children,
					By.xpath("./div[6]")).getText();
			result.quizDate = this.getChildElement(children,
					By.xpath("./div[8]")).getText();
			this.reportLog("Quiz Result: " + result.toString());
		}
		return result;
	}

	public class QuizResult {
		public String bookTitle = "";
		public String author = "";
		public String percentage = "";
		public String points = "";
		public String quizDate = "";

		@Override
		public String toString() {
			return "{BookTitle:" + bookTitle + ", Author:" + author + ",%:"
					+ percentage + ",Points:" + points + ",Date:" + quizDate
					+ "}";
		}
	}

	public String getmylexileLabel() {
		String str = mylexileLabel.getText();
		return str;
	}
	

	public String MyResultDashboard(String dashboard) {
		String xpath = ".//*[@id='results']//p[contains(text(),'"
				+ dashboard + "')]";
		WebElement reportLink = this.getElement(By.xpath(xpath));

		if (reportLink != null) {
			String repItemValue = this.getText(reportLink);
			this.reportLog("Student dasboard Expected '" + dashboard + "' Actual: "
					+ repItemValue);
			return repItemValue;
		}
		return "NULL";
	}
	
	public int QuizzesPassed() throws InterruptedException {
		int Quizpassed=0;
		int size=driver.findElements(By.xpath(".//*[@id='results']/div[3]/div/div[2]/div/div//input[1]")).size();
		for(int i=1; i<=size; i++){
			String xpath=".//*[@id='results']/div[3]/div/div[2]/div["+i+"]/div//input[@value='See My Book Rating']";
			if(driver.findElement(By.xpath(xpath)).isDisplayed()){
				Quizpassed=Quizpassed+1;
			}
		}
		return Quizpassed;
	}

	public boolean QuizzesPassedMyresult() throws InterruptedException {
		boolean result = false;
		Listview();
		int quiz =Integer.parseInt(driver.findElement(By.xpath(".//*[@id='results']/div[1]/div/div[3]/p[2]")).getText());
		reportLog("Nuber of quizzes actually passed are :"+QuizzesPassed());
		reportLog("Nuber of quizzes shown in dashboard :"+quiz);
		if(QuizzesPassed()==quiz){
			result=true;
		}
		return result;
	}
	
	public int WordsRead() throws InterruptedException {
		int WordsRead=0;
		int BookWordsRead=0;
		int size=driver.findElements(By.xpath(".//*[@id='results']/div[3]/div/div[2]/div/div//input[1]")).size();
		for(int i=1; i<=size; i++){
			String xpath=".//*[@id='results']/div[3]/div/div[2]/div["+i+"]/div//input[@value='See My Book Rating']";
			String xpath1=".//*[@id='results']/div[3]/div/div[2]/div["+i+"]/div/div[4]";
			
			if(driver.findElement(By.xpath(xpath)).isDisplayed()){
				BookWordsRead=Integer.parseInt(driver.findElement(By.xpath(xpath1)).getText());
				WordsRead +=BookWordsRead;
			}
		}
		return WordsRead;
	}

	public boolean WordsReadMyresult() throws InterruptedException {
		boolean result = false;
		int WrdRead =Integer.parseInt(driver.findElement(By.xpath(".//*[@id='results']/div[1]/div/div[4]/p[2]")).getText().replaceAll(",", ""));
		reportLog("Words Read actually are :"+WordsRead());
		reportLog("Words Read shown in dashboard :"+WrdRead);
		if(WordsRead()==WrdRead){
			result=true;
		}
		return result;
	}
	
	public int AverageQuizScore() throws InterruptedException {
		int AverageQuizScore=0;
		int count=0;
		int BookAverageQuizScore=0;
		int size=driver.findElements(By.xpath(".//*[@id='results']/div[3]/div/div[2]/div/div//input[1]")).size();
		for(int i=1; i<=size; i++){
			String xpath=".//*[@id='results']/div[3]/div/div[2]/div["+i+"]/div//input[@value='See My Book Rating']";
			String xpath1=".//*[@id='results']/div[3]/div/div[2]/div["+i+"]/div/div[5]";
			
			if(driver.findElement(By.xpath(xpath)).isDisplayed()){
				BookAverageQuizScore=Integer.parseInt(driver.findElement(By.xpath(xpath1)).getText().replaceAll("%", ""));
				AverageQuizScore +=BookAverageQuizScore;
				count=count+1;
			}
		}
		AverageQuizScore=(AverageQuizScore/count);
		return AverageQuizScore;
	}

	public boolean AverageQuizScoreMyresult() throws InterruptedException {
		boolean result = false;
		int AvgQuz =Integer.parseInt(driver.findElement(By.xpath(".//*[@id='results']/div[1]/div/div[5]/p[2]")).getText().replaceAll("%", ""));
		reportLog("Average Quiz Score Myresult actually are :"+AverageQuizScore());
		reportLog("Average Quiz Score Myresult shown in dashboard :"+AvgQuz);
		if(AverageQuizScore()==AvgQuz){
			result=true;
		}
		return result;
	}

	public String getmylexileText() {
		String str = mylexileText.getText();
		return str;
	}

	public String getcertificateLabel() {
		String str = certificateLabel.getText();
		return str;
	}

	public String getcertificateText() {
		String str = certificateText.getText();
		return str;
	}

	public String getquizpassedLabel() {
		String str = quizpassedLabel.getText();
		return str;
	}

	public String getquizpassedText() {
		String str = quizpassedText.getText();
		return str;
	}

	public String getwordsLabel() {
		String str = wordsreadLabel.getText();
		return str;
	}

	public String getwordsText() {
		String str = wordsreadText.getText();
		return str;
	}

	public String getscoreLabel() {
		String str = scoreLabel.getText();
		return str;
	}

	public String getscoreText() {
		String str = scoreText.getText();
		return str;
	}

	public String gettitleLabel() {
		String str = titleLabel.getText();
		return str;
	}

	public String gettitleText() {
		String str = titleText.getText();
		return str;
	}

	public String getauthorLabel() {
		String str = authorLabel.getText();
		return str;
	}

	public String getauthorText() {
		String str = authorText.getText();
		return str;
	}

	public String getlexileLabel() {
		String str = lexileLabel.getText();
		return str;
	}

	public String getlexileText() {
		String str = lexileText.getText();
		return str;
	}

	public String getwordcountLabel() {
		String str = wordcountLabel.getText();
		return str;
	}

	public String getwordcountText() {
		String str = wordcountText.getText();
		return str;
	}

	public String getpointsLabel() {
		String str = pointsLabel.getText();
		return str;
	}

	public String getpointsText() {
		String str = pointsText.getText();
		return str;
	}

	public String getdateLabel() {
		String str = dateLabel.getText();
		return str;
	}

	public String getdateText() {
		String str = dateText.getText();
		return str;
	}

	public String getavgquizscoreLabel() {

		String str = avgquizscoreLabel.getText();
		return str;
	}

	public String getavgquizscoreText() {
		String str = avgquizscoreText.getText();
		return str;
	}

	/**
	 * @throws InterruptedException
	 *******************************************************************************/

	public int MyresultquizpassedText() {
		String hello = quizpassedText.getText();
		System.out.println(quizpassedText.getText() + "   %%");
		System.out.println(hello);
		int hello1 = Integer.parseInt(hello);
		return hello1;

	}

	// );

	public void AwardvaluesFilling(String awardName, String awardValue) {
		if (awardName.contains("Gold")) {
			goldpoint = Integer.parseInt(awardValue);
		}
		if (awardName.contains("Silver")) {
			silverpoint = Integer.parseInt(awardValue);
		}
		if (awardName.contains("Bronze")) {
			bronzepoint = Integer.parseInt(awardValue);
		}
		if (awardName.contains("Red")) {
			redpoint = Integer.parseInt(awardValue);
		}
		if (awardName.contains("Blue")) {
			bluepoint = Integer.parseInt(awardValue);
		}
	}

	public void VerifyingAwards() {
		reportLog("Verifing the awards");
		String certificateTexts = certificateText.getText().trim();
		points = MyresultquizpassedText();
		if ((goldpoint >= points) && (points > silverpoint)) {
			assertTrue("Gold certificate should be shown",
					certificateTexts.equals("Gold"));
		}
		if ((silverpoint >= points) && (points > bronzepoint)) {
			assertTrue("Silver certificate should be shown",
					certificateTexts.equals("Silver"));
		}
		if ((bronzepoint >= points) && (points > redpoint)) {
			assertTrue("Bronze certificate should be shown",
					certificateTexts.equals("Bronze"));
		}
		if ((redpoint >= points) && (points > bluepoint)) {
			assertTrue("Red certificate should be shown",
					certificateTexts.equals("Red"));
		}
		if ((bluepoint >= points)) {
			assertTrue("Blue certificate should be shown",
					certificateTexts.equals("Blue"));
		}
		reportLog("Completed the awards Verifications");
	}

	public boolean SeeMyRatingButton() throws InterruptedException {
		int check = 0;
		talbeview.click();
		dateSortLink.click();
		dateSortLink.click();

		String bookTitle = getbooktitlesb();
		List<WebElement> NumberOfBooks = this.getElements(By
				.xpath(".//*[@id='results']/div[3]/div/div[2]/div"));

		this.reportLog("Searching for the book" + bookTitle);
		this.reportLog("There are " + NumberOfBooks.size() + " Numbers of book");
		for (int i = 1; i < NumberOfBooks.size(); i++) {
			String title = driver
					.findElement(
							By.xpath(".//*[@id='results']/div[3]/div/div[2]/div["
									+ i + "]/div/div[1]")).getText().trim();
			System.out.println(title);

			if (title.equals(bookTitle)) {
				this.reportLog("Found the book --> " + bookTitle);
				String buttonText = driver.findElement(
						By.xpath(".//*[@id='results']/div[3]/div/div[2]/div["
								+ i + "]/div/div[8]//input[1]")).getAttribute(
						"value");
				this.reportLog(bookTitle + " has button " + buttonText);

				if (buttonText.equalsIgnoreCase("See My Book Rating")) {
					driver.findElement(
							By.xpath("//*[@id='results']/div[3]/div/div[2]/div["
									+ i + "]/div/div[8]//input[1]")).click();
					this.lazyWait(4);
					String bookRatings = bookRating.getText().trim();
					String bookRatingTitles = bookRatingTitle.getText().trim();
					if (bookTitle.equalsIgnoreCase(bookRatingTitles)
							&& bookRatings
									.equals("Here is how you rated the book: Loved it!")) {
						this.reportLog("Verified the title and rating of the book in \"See my rating\" window");
						check = 1;
					}
					break;
				}
			}
		}
		if (check == 0) {
			return false;
		} else {
			return true;
		}
	}

	public String CommentVerifying(String CommentVerify){
		CommentVerify = CommentVerifyTxtBox.getText();
		return CommentVerify;
	}
	
	public void button(String text) {
		String xpath = ".//button/span[contains(text(),'"+text+"')]";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public List<String> SeeMyCommentsTitle(){
		lazyWait(2);
		ArrayList<String> value = new ArrayList<String>();
		reportLog("Collecting title data from comments window");
		int i=driver.findElements(By.xpath("html/body/div[2]/div")).size();
		for(int j=1; j<=i; j++){
			String xpath ="html/body/div[2]/div["+j+"]";
			value.add(driver.findElement(By.xpath(xpath)).getText());		
		}
		return value;
	}
	
	public String VerifyUserComments(){
		String Comment = null;
		reportLog("Verifying the comments in the comment window");
		String expectedtitle = booksObj.getBooktitle();
		reportLog("Verifying the comments for the book "+expectedtitle);
		int count=driver.findElements(By.xpath("html/body/div/div[2]/span")).size();
		for(int i = 3; i<count; i++){
			String xpath="html/body/div["+i+"]/div[2]/span";
			String title=driver.findElement(By.xpath(xpath)).getText();
			if(title.equalsIgnoreCase(expectedtitle)){
				reportLog("I am trying to verify the titles for which comment was put");
				Comment = driver.findElement(By.xpath("html/body/div["+i+"]/div[2]//li")).getText();
				reportLog("The "+expectedtitle+" book has the comments "+Comment);
			}
		}
		return Comment;
	}
	
	public List<String> VerifyUserCredentails(){
		lazyWait(2);
		this.switchToNewWindow();
		reportLog("Switched to comments window");
		lazyWait(5);
		ArrayList<String> value = new ArrayList<String>();
		reportLog("Coolecting data from comments window");
		value.add(StudentName.getText());
		value.add(StudentGrade.getText());
		value.add(StudentClass.getText());		
		return value;
	}
	
	@FindBy(xpath = "html/body/h4")
	WebElement StudentName;
	
	@FindBy(xpath = "html/body/h5[1]")
	WebElement StudentGrade;
	
	@FindBy(xpath = "html/body/h5[2]")
	WebElement StudentClass;
	
	@FindBy(xpath = ".//div[@class='commentarea']/p")
	private WebElement CommentVerifyTxtBox;
	
	public void DoneButton() {
		DoneButton.click();
	}

	public void Listview() throws InterruptedException {
		Listview.click();
		scrolldownTillEnd();
	}

	private List<SearchResultBook> getListViewMYResultsStudent() {

		List<SearchResultBook> bookList = new ArrayList<SearchResultBook>();
		List<WebElement> children = this.getElements(By
				.xpath(".//*[@id='results']/div[3]/div/div[2]/div"));
		this.reportLog((children.size()) + " Books Displayed(Student Search)");
		if (children != null) {
			Iterator<WebElement> resultRows = children.iterator();
			while (resultRows.hasNext()) {
				WebElement elemTr = resultRows.next();

				SearchResultBook newBook = new SearchResultBook();
				// title
				WebElement bookTitleElement = this.getChildElement(elemTr,
						By.xpath("./div/div[1]"));
				newBook.title = this.getText(bookTitleElement);

				// author
				WebElement bookAutElement = this.getChildElement(elemTr,
						By.xpath("./div/div[2]"));
				newBook.author = this.getText(bookAutElement);

				// lex
				WebElement booklexElement = this.getChildElement(elemTr,
						By.xpath("./div/div[3]"));
				newBook.lexile = this.getText(booklexElement);

				// wc
				WebElement bookwcElement = this.getChildElement(elemTr,
						By.xpath("./div/div[4]"));
				newBook.wordCount = this.getText(bookwcElement);

				// score
				WebElement bookscoreElement = this.getChildElement(elemTr,
						By.xpath("./div/div[5]"));
				newBook.score = this.getText(bookscoreElement);

				// points
				WebElement bookpointElement = this.getChildElement(elemTr,
						By.xpath("./div/div[6]"));
				newBook.points = this.getText(bookpointElement);

				// date
				WebElement bookdateElement = this.getChildElement(elemTr,
						By.xpath("./div/div[7]"));
				newBook.date = this.getText(bookdateElement);

				this.reportLog(newBook.toString());
				bookList.add(newBook);
			}
		}
		System.out.println(bookList);
		return bookList;
	}

	private List<SearchResultBook> getListViewPrintMYResultsStudent() {
		List<SearchResultBook> bookList = new ArrayList<SearchResultBook>();
		List<WebElement> children = this.getElements(By
				.xpath("html/body/div[2]/div/div"));
		this.reportLog((children.size()) + " Books Displayed(Student Search)");

		for (int i = 2; i <= children.size(); i++) {
			/*
			 * Iterator<WebElement> resultRows = children.iterator(); while
			 * (resultRows.hasNext()) { WebElement elemTr = resultRows.next();
			 */

			SearchResultBook newBook = new SearchResultBook();
			// title
			WebElement bookTitleElement = driver.findElement(By
					.xpath("html/body/div[2]/div/div[" + i + "]/div/div[1]"));
			newBook.title = this.getText(bookTitleElement);

			// author
			WebElement bookAutElement = driver.findElement(By
					.xpath("html/body/div[2]/div/div[" + i + "]/div/div[2]"));
			newBook.author = this.getText(bookAutElement);

			// lex
			WebElement booklexElement = driver.findElement(By
					.xpath("html/body/div[2]/div/div[" + i + "]/div/div[3]"));
			newBook.lexile = this.getText(booklexElement);

			// wc
			WebElement bookwcElement = driver.findElement(By
					.xpath("html/body/div[2]/div/div[" + i + "]/div/div[4]"));
			newBook.wordCount = this.getText(bookwcElement);

			// score
			WebElement bookscoreElement = driver.findElement(By
					.xpath("html/body/div[2]/div/div[" + i + "]/div/div[5]"));
			newBook.score = this.getText(bookscoreElement);

			// points
			WebElement bookpointElement = driver.findElement(By
					.xpath("html/body/div[2]/div/div[" + i + "]/div/div[6]"));
			newBook.points = this.getText(bookpointElement);

			// date
			WebElement bookdateElement = driver.findElement(By
					.xpath("html/body/div[2]/div/div[" + i + "]/div/div[7]"));
			newBook.date = this.getText(bookdateElement);

			this.reportLog(newBook.toString());
			bookList.add(newBook);

		}

		System.out.println(bookList);
		return bookList;
	}

	public class SearchResultBook {
		public String title = "";
		public String author = "";
		public String lexile = "";
		public String points = "";
		public String wordCount = "";
		public String score = "";
		public String date = ""; // comma separated

		@Override
		public String toString() {
			return "{BookTitle:" + title + ", Author:" + author + ", Lexile:"
					+ lexile + ", Point:" + points + ", Word Count:"
					+ wordCount + ", Score:" + score + ", date:" + date + "}";
		}
	}

	public boolean compare() throws InterruptedException {
		List<SearchResultBook> searchresultTeacherCompare = getListViewMYResultsStudent();
		PrintList.click();
		lazyWait(1);
		PrintActivites.click();
		this.lazyWait(5);
		switchToNewWindow();
		List<SearchResultBook> printsearchresultTeachercompare = getListViewPrintMYResultsStudent();

		if (searchresultTeacherCompare.toString().equals(
				printsearchresultTeachercompare.toString())) {
			System.out
					.println("Verified the search result and print result. They both are same");
			return true;
		} else {
			System.out
					.println("Verified the Admin/teacher search result and print result of search. They both not same. Please check the reuslts");
			return false;
		}
	}

	public String Myresultcertificate() {
		String Certificate = CertificateMyresult.getText().toLowerCase();
		System.out
				.println("Student has scored " + Certificate + " Certificate");
		String CertificateStudentname = Certificate + "'"
				+ StudentNameLitpro.getText().replaceAll("Welcome, ", "");
		return CertificateStudentname;
	}

	public void PrintCertificate() {
		PrintList.click();
		lazyWait(1);
		PrintMyresultCertificate.click();
		this.lazyWait(5);

	}

	public boolean comparecertificate() throws AWTException {
		String CertificateStudentname = Myresultcertificate();
		switchToNewWindow();

		String[] CertificateStudentname1 = CertificateStudentname.split("'");

		int condition = 1;

		System.out.println(CertificateStudentname1[0] + "^^^^^^^^^^^^"
				+ CertificateStudentname1[1]);

		if (CertificateStudentname1[0].contains("-")
				&& PrintCertificateStudentName.getText().contains(
						CertificateStudentname1[1])) {
			System.out.println("Student has NO Certificate");
			System.out.println("Student name "
					+ PrintCertificateStudentName.getText()
					+ "is printed on the certificate");
			condition = 0;
		} else if ((PrintMyresultAwardCertificate.getAttribute("src"))
				.contains(CertificateStudentname1[0])
				&& PrintCertificateStudentName.getText().contains(
						CertificateStudentname1[1])) {
			System.out.println("Student Blue Certificate got printed");
			System.out.println("Student name "
					+ PrintCertificateStudentName.getText()
					+ "is printed on the certificate");
			condition = 0;
		} else if ((PrintMyresultAwardCertificate.getAttribute("src"))
				.contains(CertificateStudentname1[0])
				&& PrintCertificateStudentName.getText().contains(
						CertificateStudentname1[1])) {
			System.out.println("Student Red Certificate got printed");
			System.out.println("Student name "
					+ PrintCertificateStudentName.getText()
					+ "is printed on the certificate");
			condition = 0;
		} else if ((PrintMyresultAwardCertificate.getAttribute("src"))
				.contains(CertificateStudentname1[0])
				&& PrintCertificateStudentName.getText().contains(
						CertificateStudentname1[1])) {
			System.out.println("Student Bronze Certificate got printed");
			System.out.println("Student name "
					+ PrintCertificateStudentName.getText()
					+ "is printed on the certificate");
			condition = 0;
		} else if ((PrintMyresultAwardCertificate.getAttribute("src"))
				.contains(CertificateStudentname1[0])
				&& PrintCertificateStudentName.getText().contains(
						CertificateStudentname1[1])) {
			System.out.println("Student Silver Certificate got printed");
			System.out.println("Student name "
					+ PrintCertificateStudentName.getText()
					+ "is printed on the certificate");
			condition = 0;
		} else if ((PrintMyresultAwardCertificate.getAttribute("src"))
				.contains(CertificateStudentname1[0])
				&& PrintCertificateStudentName.getText().contains(
						CertificateStudentname1[1])) {
			System.out.println("Student Gold Certificate got printed");
			System.out.println("Student name "
					+ PrintCertificateStudentName.getText()
					+ "is printed on the certificate");
			condition = 0;
		} else {
			condition = 1;
		}

		switchtoWindow(2);

		if (condition == 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}
}