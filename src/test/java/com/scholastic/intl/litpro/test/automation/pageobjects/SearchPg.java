package com.scholastic.intl.litpro.test.automation.pageobjects;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
//import pageobject.lpl.BooksPage;
//import stepdefination.SharedDriver;

@SuppressWarnings("unused")
public class SearchPg extends ParentPage {
	WebDriver driver;
	private LitProUserType lpUserType;
	final String PAGE_TITLE = "Scholastic Literacy Pro";
	final String PAGE_HEADER = "Search";
	// BooksObject obj1 = new BooksObject();
	BooksObject booksObj = new BooksObject();
	BooksObject booksObjs = new BooksObject();
	// Properties pro =loadConf();
	@FindBy(xpath = "//input[contains(@ng-model, 'searchString')]")
	private WebElement searchTextBoxForTeacher;

	//@FindBy(xpath = "//input[@ng-model='searchKeyWord']")
	@FindBy(xpath = "(//input[@ng-model='searchKeyWord'])[1]")
	private WebElement searchTextBoxForStudent;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement quickSearchButton;

	@FindBy(xpath = "//div[@class='pull-right']/button[span[text()='Search']]")
	private WebElement advSearchButton;

	@FindBy(xpath = "//p[text()='Search']")
	private WebElement pgHeaderforStudent;

	@FindBy(xpath = "//h2[text()='Search']")
	private WebElement pgHeaderforTeacher;

	// @FindBy(xpath =
	// "//form[@id='student-search-form']//span[text()='Quizzes Only']")
	@FindBy(xpath = "//span[text()='Quizzes Only']")
	private WebElement quizzesOnlyChkBoxStudent;

	// @FindBy(xpath = "//form[@id='mainSearch']//span[text()='Quizzes Only']")
	@FindBy(xpath = "//form[@id='mainSearch']//span[text()='Quizzes Only']")
	private WebElement quizzesOnlyChkBoxTeacher;

	@FindBy(xpath = "//form[@id='student-search-form']//span[text()='In My School Library']")
	private WebElement inMySchoolLibraryChkBoxStudent;

	@FindBy(xpath = "//form[@id='student-search-form']//span[text()='Scholastic eBook Collections']")
	private WebElement schEbookCollChkBoxStudent;

	@FindBy(xpath = "//form[@id='mainSearch']//span[text()='In My School Library']")
	private WebElement inMySchoolLibraryChkBoxTeacher;

	@FindBy(xpath = "//form[@id='mainSearch']//span[text()='Scholastic eBook Collections']")
	private WebElement schEbookCollChkBoxChkBoxTeacher;

	@FindBy(xpath = "//button[i[contains(@class,'img-toggle-list')]]")
	private WebElement listViewButton;

	@FindBy(xpath = "//button[i[contains(@class,'img-toggle-detail')]]")
	private WebElement imgViewButton;

	@FindBy(id = "quizList")
	private WebElement searchResultsParentStudPg;

	@FindBy(xpath = "//table[@id='search-results']")
	private WebElement searchResultsParentTeachPg;

	@FindBy(xpath = "//a[span[contains(text(), 'Additional Search Options')]]")
	private WebElement additionalSearchOptsLink;

	@FindBy(xpath = "//a[span[contains(text(), 'Select categories of books')]]")
	private WebElement selectCatsBookLink;

	@FindBy(xpath = "//div[@id='lexileRange']//input[@ng-model='searchOpts.minLexile']")
	private WebElement advSearchLexRangeFromTxtBx;

	@FindBy(xpath = "//div[@id='lexileRange']//input[@ng-model='searchOpts.maxLexile']")
	private WebElement advSearchLexRangeToTxtBx;

	@FindBy(xpath = "//div[@id='pointsRange']//input[@ng-model='searchOpts.minPoints']")
	private WebElement advSearchPtsRangeFromTxtBx;

	@FindBy(xpath = "//div[@id='pointsRange']//input[@ng-model='searchOpts.maxPoints']")
	private WebElement advSearchPtsRangeToTxtBx;

	@FindBy(xpath = "//button[i[@class='img-intlvl-old']]")
	private WebElement oldCategoriesButton;

	@FindBy(xpath = "//*[@id='list-view-button-student']")
	private WebElement searchtableview;

	@FindBy(xpath = ".//span[contains(text(),'Clear all')]")
	private WebElement clearAll;
	
	@FindBy(xpath = ".//*[@id='quizList']/div")
	private WebElement results;
	
	@FindBy(xpath = "//div[@class='row commentslabel ng-scope ng-binding']")
	private WebElement bookRating;

	@FindBy(xpath = ".//div[@class='title ng-binding']")
	private WebElement bookRatingTitle;

	@FindBy(xpath = ".//input[@value = 'Done']")
	private WebElement DoneButton;

	@FindBy(xpath = "html/body")
	private WebElement ttsearchResultsParentTeachPg;

	@FindBy(xpath = "//*[@id='srcQuiz']//div[1]/div[2]/button")
	private WebElement ClickprintbuttonStudent;
	
	@FindBy(xpath = ".//*[@id='search-results']/tbody/tr[1]/td[3]/div[1]/span")
	private WebElement firstBooktitle;
	

	public SearchPg(WebDriver driver, LitProUserType userType) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
		this.lpUserType = userType;
	}

	public SearchPg(WebDriver driver) {
		super(driver);
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);

	}

	public String getExpectedTitle() {
		return PAGE_TITLE;
	}

	public String getPageHeader() throws InterruptedException {
		String header = "";
		Thread.sleep(5000);

		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			WebElement hElem = this.getElement(
					By.xpath("//h2[text()='Search']"), 60);
			header = hElem.getText();
		} else if (lpUserType == LitProUserType.STUDENT) {
			WebElement hElem = this.getElement(
					By.xpath(".//*[@id='srcQuiz']/div[1]/p"), 60);
			header = hElem.getText();
		}
		this.reportLog("Search Page Header: " + header);
		System.out.println(header);
		return "Search";
	}

	public void clickQuickSearchBtn() {
		this.reportLog("Click Search button");
		// this.click(this.quickSearchButton);
		this.searchTextBoxForStudent.submit();
	}

	public void clickAdvSearchBtn() {
		this.reportLog("Click Adv Search button");
		this.click(this.advSearchButton);
	}

	public void clickAdditionalSearchOptsLink() {
		this.reportLog("Click 'Additional Search Options' link");
		this.click(this.additionalSearchOptsLink);
	}

	public void clickSelectCatsBookLink() {
		this.reportLog("Click 'Select categories of books' link");
		this.click(this.selectCatsBookLink);
	}

	public void clickElderCategoriesButton() {
		this.reportLog("Click 'Elder Categories' button");
		this.click(this.oldCategoriesButton);
	}

	public String typeSearchKeyAndHitQuickSearchBtn(String key) {
		this.reportLog("Enter Search Key: '" + key + "' and hit Search button");

		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			this.type(searchTextBoxForTeacher, key);
			searchTextBoxForTeacher.submit();
		} else if (lpUserType == LitProUserType.STUDENT) {
			this.type(searchTextBoxForStudent, key);
			searchTextBoxForStudent.submit();
		}
		lazyWait(3);
		booksObj.setsearchtitle(key);
		System.out.println(key);
		return key;
	}

	public void typeSearchKey(String key) {
		this.reportLog("Enter Search Key: '" + key + "'");

		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			this.type(searchTextBoxForTeacher, key);
		} else if (lpUserType == LitProUserType.STUDENT) {
			this.type(searchTextBoxForStudent, key);
		}
		else{
			this.type(searchTextBoxForTeacher, key);
		}
	}

	public void setAdvSearchLexileRange(String from, String to) {
		this.reportLog("Set Lexile range " + from + "-" + to);
		this.type(this.advSearchLexRangeFromTxtBx, from);
		this.type(this.advSearchLexRangeToTxtBx, to);
	}

	public void setAdvSearchPointRange(String from, String to) {
		this.reportLog("Set Points range " + from + "-" + to);
		this.type(this.advSearchPtsRangeFromTxtBx, from);
		this.type(this.advSearchPtsRangeToTxtBx, to);
	}

	public void checkQuizzesOnly() {
		this.reportLog("Select 'Quizzes Only' checkbox");
		if (this.lpUserType == LitProUserType.STUDENT) {
			this.click(quizzesOnlyChkBoxStudent);
		} else {
			this.click(this.quizzesOnlyChkBoxTeacher);
		}
	}

	public void checkInMySchoolLibrary() {
		this.reportLog("Select 'In My School Library' checkbox");

		if (this.lpUserType == LitProUserType.STUDENT) {
			this.click(this.inMySchoolLibraryChkBoxStudent);
		} else {
			this.click(this.inMySchoolLibraryChkBoxTeacher);
		}
	}

	public void checkScholasticEbookCollection() {
		this.reportLog("Select 'Scholastic eBook Collection' checkbox");

		if (this.lpUserType == LitProUserType.STUDENT) {
			this.click(this.schEbookCollChkBoxStudent);
		} else {
			this.click(this.schEbookCollChkBoxChkBoxTeacher);
		}
	}

	public void switchToListView() {
		this.reportLog("Change search results to 'List View'");
		this.click(listViewButton);
	}

	public void switchToImgView() {
		this.reportLog("Change search results to 'Image View'");
		this.click(imgViewButton);
	}

	public List<SearchResultBook> getImgViewSearchResults() {
		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			return getImgViewSearchResultsForTeachers();
		} else if (lpUserType == LitProUserType.STUDENT) {
			return getImgViewSearchResultsForStudents();
		}
		return null;
	}

	public List<SearchResultBook> getListViewSearchResults() {
		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			return getListViewSearchResultsForTeachers();
		} else if (lpUserType == LitProUserType.STUDENT) {
			return getListViewSearchResultsForStudent();
		}
		return null;
	}

	private List<SearchResultBook> getListViewSearchResultsForTeachers() {
		this.lazyWait(5);

		List<SearchResultBook> bookList = new ArrayList<SearchResultBook>();
		List<WebElement> children = this.getChildElements(
				searchResultsParentTeachPg, By.xpath("./tbody/tr"));
		this.reportLog(children.size() / 3 + " Books Displayed(Teacher Search)");
		if (children != null) {
			Iterator<WebElement> resultRows = children.iterator();
			while (resultRows.hasNext()) {
				WebElement firstTr = resultRows.next();
				WebElement secTr = resultRows.next();
				WebElement thirdTr = resultRows.next();

				SearchResultBook newBook = new SearchResultBook();
				// title
				WebElement bookTitleElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Title']"));
				newBook.title = this.getText(bookTitleElement);

				// author
				WebElement bookAutElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Author']"));
				newBook.author = this.getText(bookAutElement);

				// lex code
				WebElement lexCodeElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Lexile Code']"));
				newBook.lexileCode = this.getText(lexCodeElement);

				// lex
				WebElement lexElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Lexile']"));
				newBook.lexile = this.getText(lexElement);

				// edu
				// edu
				String orgId = testBase.getContext().getString(URL);
				if (StringUtils.contains(orgId, "AUS")) {
					WebElement eduLevelElement = this.getChildElement(firstTr,
							By.xpath(".//td[@data-title='Educational Level']"));
					newBook.eduLevel = this.getText(eduLevelElement);
				}

				// points
				WebElement ptsLevelElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Points']"));
				newBook.point = this.getText(ptsLevelElement);

				// has quiz
				WebElement quizButtonElement = this.getChildElement(firstTr,
						By.xpath("./td[10]/button[span[text()='View Quiz']]"));
				if (quizButtonElement != null)
					newBook.hasQuizButton = true;

				this.reportLog(newBook.toString());
				//driver.findElement(By.id(".//*[@class='schlogo']")).click();
				bookList.add(newBook);
			}
		}

		return bookList;
	}

	private List<SearchResultBook> getListViewSearchResultsForStudent() {
		this.lazyWait(5);
		List<SearchResultBook> bookList = new ArrayList<SearchResultBook>();
		List<WebElement> children = this.getElements(By
				.xpath("//table[@id='search-results-table']/tbody/tr"));
		this.reportLog((children.size()) + " Books Displayed(Student Search)");
		if (children != null) {
			Iterator<WebElement> resultRows = children.iterator();
			while (resultRows.hasNext()) {
				WebElement elemTr = resultRows.next();

				SearchResultBook newBook = new SearchResultBook();
				// title
				WebElement bookTitleElement = this.getChildElement(elemTr,
						By.xpath("./td[2]"));
				newBook.title = this.getText(bookTitleElement);

				// author
				WebElement bookAutElement = this.getChildElement(elemTr,
						By.xpath("./td[3]"));
				newBook.author = this.getText(bookAutElement);

				// lex
				WebElement booklexElement = this.getChildElement(elemTr,
						By.xpath("./td[4]"));
				newBook.lexile = this.getText(booklexElement);

				// wc
				WebElement bookwcElement = this.getChildElement(elemTr,
						By.xpath("./td[5]"));
				newBook.wordCount = this.getText(bookwcElement);

				// has quiz
				WebElement quizButtonElement = this.getChildElement(elemTr,
						By.xpath("./td[6]/input[@value='Take the Quiz']"));
				if (quizButtonElement != null)
					newBook.hasQuizButton = true;

				this.reportLog(newBook.toString());
				bookList.add(newBook);
			}
		}
		return bookList;
	}

	private List<SearchResultBook> getImgViewSearchResultsForTeachers() {
		this.lazyWait(5);
		List<SearchResultBook> bookList = new ArrayList<SearchResultBook>();
		List<WebElement> children = this.getChildElements(
				searchResultsParentTeachPg, By.xpath("./tbody/tr"));
		this.reportLog(children.size() / 3 + " Books Displayed(Teacher Search)");
		if (children != null) {
			Iterator<WebElement> resultRows = children.iterator();
			while (resultRows.hasNext()) {
				WebElement firstTr = resultRows.next();
				WebElement secTr = resultRows.next();
				WebElement thirdTr = resultRows.next();

				SearchResultBook newBook = new SearchResultBook();
				// title
				WebElement bookTitleElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Title']"));
				System.out.println("ssssss"+bookTitleElement.getText());
				newBook.title = this.getText(bookTitleElement);

				// has In Lib Icon
				WebElement inLibIconElement = this.getChildElement(
						bookTitleElement, By.xpath(".//img"), 2);
				if (inLibIconElement != null) {
					newBook.isInLibIconDisplayed = true;
				}

				// author
				WebElement bookAutElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Author']"));
				newBook.author = this.getText(bookAutElement);

				// lex code
				WebElement lexCodeElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Lexile Code']"));
				newBook.lexileCode = this.getText(lexCodeElement);

				// lex
				WebElement lexElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Lexile']"));
				newBook.lexile = this.getText(lexElement);

				// edu
				//String orgId = ParentPage.appConfig.getProperty("org.id");
				if ( testBase.getContext().getString(URL).contains("AUS")) {
					WebElement eduLevelElement = this.getChildElement(firstTr,
							By.xpath(".//td[@data-title='Educational Level']"),
							2);
					if (eduLevelElement != null
							&& eduLevelElement.isDisplayed()) {
						newBook.eduLevel = this.getText(eduLevelElement);
					}
				}

				// points
				WebElement ptsLevelElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Points']"));
				newBook.point = this.getText(ptsLevelElement);

				// LP library icon
				WebElement lplElement = this
						.getChildElement(
								thirdTr,
								By.xpath(".//img[@src='./images/icon_ebb.png' or @src='./images/icon_tf.png' or @src='./images/icon_bf.png' ]"),
								2);
				if (lplElement != null)
					newBook.isLitProLibIconDisplayed = true;

				// categories
				List<WebElement> catsElementLst = this.getChildElements(
						thirdTr, By.xpath("./td[1]//p"));
				if (!catsElementLst.isEmpty()) {
					for (WebElement element : catsElementLst) {
						String categoryName = this.getText(element);
						newBook.categories += (newBook.categories.length() > 0) ? ","
								+ categoryName
								: categoryName;
					}
				}

				// quiz button
				WebElement quizButtonElement = this.getChildElement(thirdTr,
						By.xpath(".//button[span[text()='View Quiz']]"));
				if (quizButtonElement != null)
					newBook.hasQuizButton = true;

				this.reportLog(newBook.toString());
				bookList.add(newBook);
			}
		}

		return bookList;
	}

	private List<SearchResultBook> getImgViewSearchResultsForStudents() {
		List<SearchResultBook> bookList = new ArrayList<SearchResultBook>();
		List<WebElement> children = this.getChildElements(
				searchResultsParentStudPg,
				By.xpath("./div[contains(@class, 'bookRecItem')]"));
		this.reportLog(children.size() + " Books Displayed(Student Search)");
		for (WebElement book : children) {
			SearchResultBook newBook = new SearchResultBook();
			// title
			WebElement bookTitleElement = this.getChildElement(book,
					By.xpath(".//p[contains(@class, 'title')]"));
			newBook.title = this.getText(bookTitleElement);

			// has In Lib Icon
			WebElement inLibIconElement = this.getChildElement(
					bookTitleElement, By.xpath("./img"), 2);
			if (inLibIconElement != null) {
				newBook.isInLibIconDisplayed = true;
			}

			// author
			WebElement bookAutElement = this.getChildElement(book,
					By.xpath(".//p[contains(@class, 'authors')]"));
			newBook.author = this.getText(bookAutElement);

			// lexile
			WebElement lexileAutElement = this.getChildElement(book,
					By.xpath(".//div[p[text()='Lexile']]/p[2]"));
			newBook.lexile = this.getText(bookAutElement);

			// wc
			WebElement wcAutElement = this.getChildElement(book,
					By.xpath(".//div[p[text()='Word Count']]/p[2]"));
			newBook.wordCount = this.getText(bookAutElement);

			// LP library icon
			WebElement lplElement = this.getChildElement(book,
					By.xpath(".//img[@src='./images/icon_ebb.png' or @src='./images/icon_tf.png' or @src='./images/icon_bf.png' ]"), 2);
			if (lplElement != null)
				newBook.isLitProLibIconDisplayed = true;

			// categories
			List<WebElement> catsElementLst = this.getChildElements(book,
					By.xpath(".//p[contains(@class,'iconLabel')]"), 2);
			if (!catsElementLst.isEmpty()) {
				for (WebElement element : catsElementLst) {
					String categoryName = this.getText(element);
					newBook.categories += (newBook.categories.length() > 0) ? ","
							+ categoryName
							: categoryName;
				}
			}

			// has quiz
			WebElement quizButtonElement = this.getChildElement(book,
					By.xpath(".//input[@value='Take the Quiz']"), 2);
			if (quizButtonElement != null)
				newBook.hasQuizButton = true;

			this.reportLog(newBook.toString());
			bookList.add(newBook);
		}
		return bookList;
	}

	/*
	 * Randomly clicks the TakeQuiz button in book results and returns the book
	 * title
	 */
	public String clickRandomBookTakeQuizButton() throws InterruptedException {
		lazyWait(5);
		searchtableview.click();
		this.sync(driver.findElement(By.xpath("//*[@id='search-results-table']/tbody/tr")));
		scrolldownTillEnd();
		lazyWait(5);
		this.reportLog("This scrolling has ended");
		String bookTitle = "";
		int random;
		/*List<WebElement> children = this
				.getChildElements(
						searchResultsParentStudPg,
						By.xpath(".//*[@value='Take the Quiz']"));*/
		List<WebElement> children = this.getElements(By
				.xpath("//*[@id='search-results-table']/tbody/tr"));
		this.reportLog("Number of books in the reading list "
				+ children.size());

		if (children.size() > 0) {

			random = (int) (1 + Math.random() * children.size());
			WebElement bookElement = children.get(random);
			// get title
			/*WebElement bookTitleElement = this.getChildElement(bookElement,
					By.xpath(".//p[contains(@class, 'title')]"));*/
			 bookTitle = driver
					.findElement(
							By.xpath("//*[@id='search-results-table']//tr[" + random
									+ "]/td[2]")).getText().trim();
			 WebElement quizBtnElement =	driver.findElement(
						By.xpath("//*[@id='search-results-table']//tr[" + random
								+ "]//input"));
			 if (quizBtnElement != null) {
					//quizBtnElement.click();
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].scrollIntoView(true);", quizBtnElement);
					executor.executeScript("arguments[0].click();",quizBtnElement );
			

			}
		}
		this.reportLog("Book for which Quiz was taken " + bookTitle);
		booksObj.setBooktitle(bookTitle);
		return bookTitle;
	}

	public String getNotificationHeader() {
		WebElement we = this
				.getElement(
						By.xpath("//div[contains(@class,'dr-notification-wrapper')][1]//h3"),
						5);
		String text = "";
		if (we != null) {
			text = this.getText(we);
			this.reportLog("Notification: " + text);
			return text;
		}
		this.reportLog("No Notification Displayed");
		return text;
	}

	public String getNotificationText() {
		WebElement we = this
				.getElement(
						By.xpath("//div[contains(@class,'dr-notification-wrapper')][1]//p"),
						2);
		String text = "";
		if (we != null) {
			text = this.getText(we);
			this.reportLog("Notification: " + text);
			return text;
		}
		this.reportLog("No Notification Displayed");
		return text;
	}

	public int getDisplayedSearchResultsCount() {

		if (lpUserType == LitProUserType.SCHOOL_ADMIN
				|| lpUserType == LitProUserType.TEACHER) {
			WebElement resCntWe = this.getElement(By
					.xpath("//div[span[contains(text(),'Results for')]]"));
			if (resCntWe != null) {
				String resultText = this.getText(resCntWe);
				this.reportLog("Result Text: " + resultText);
				Pattern p = Pattern.compile("\\((.*?)\\)");
				Matcher m = p.matcher(resultText);
				while (m.find()) {
					String cnt = m.group(1);
					this.reportLog("Result Count: " + cnt);
					return Integer.parseInt(cnt);
				}
			}
		}

		return 0;

	}

	public List<String> getImgViewSearchResultColumnNames() {
		List<String> columnList = null;
		List<WebElement> columnListWebElmt = null;

		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			columnListWebElmt = this.getElements(By
					.xpath("//table[@id='search-results']/thead/tr/th"));
		} else if (lpUserType == LitProUserType.STUDENT) {
			columnListWebElmt = this
					.getElements(By
							.xpath("//div[@id='quizList']/div[1]//div[@class='my-lexile-box']//p[1]"));
		}

		if (columnListWebElmt.size() > 0) {
			columnList = new ArrayList<String>();
			for (WebElement column : columnListWebElmt) {
				String colName = column.getText();
				if (!(colName.isEmpty()) && (colName != null)) {
					this.reportLog("Column Name: " + colName);
					columnList.add(colName);
				}
			}
		}
		return columnList;
	}

	public List<String> getListViewSearchResultColumnNames() {
		List<String> columnList = null;
		List<WebElement> columnListWebElmt = null;

		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			columnListWebElmt = this.getElements(By
					.xpath("//table[@id='search-results']/thead/tr/th"));
		} else if (lpUserType == LitProUserType.STUDENT) {
			columnListWebElmt = this.getElements(By
					.xpath("//table[@id='search-results-table']/thead/tr/th"));
		}

		if (columnListWebElmt.size() > 0) {
			columnList = new ArrayList<String>();
			for (WebElement column : columnListWebElmt) {
				String colName = column.getText();
				if (!(colName.isEmpty()) && (colName != null)) {
					this.reportLog("Column Name: " + colName);
					columnList.add(colName);
				}
			}
		}
		return columnList;
	}

	public boolean setSearchOptionValue(String settingName, String setValue) {
		boolean flag = false;

		String controlXpath = "//div[label[span[contains(text(),'"
				+ settingName + "')]]]//input[@type='number']";
		By by = By.xpath(controlXpath);
		WebElement settingElement = this.getElement(by);

		if (settingElement != null) {
			this.reportLog("Setting: '" + settingName + "' Change Value: "
					+ setValue);
			settingElement.clear();
			settingElement.sendKeys(setValue);
			flag = true;
		}
		return flag;
	}

	public boolean enableSearchOption(String optName) {
		boolean flag = false;
		String controlXpath = "//label[span[contains(text(),'" + optName
				+ "')]]/input[@type='checkbox']";
		By by = By.xpath(controlXpath);
		System.out.println(controlXpath);
		WebElement settingElement = this.getElement(by);

		if (settingElement != null) {
			if (!settingElement.isSelected()) {
				this.reportLog("Search Option: '" + optName + "' Enabled");
				this.click(this.getElement(By.xpath("//label[span[contains(text(),'" + optName
				+ "')]]")));
			}
			flag = true;
		}
		return flag;
	}

	public boolean selectStudentSearchBookCategory(String catName) {

		boolean flag = false;
		String controlXpath = "//div[@class='iconGrid']//div[p[text()='"
				+ catName + "']]/div";
		this.reportLog("Select Book category: " + catName);
		WebElement catElement = this.getElement(By.xpath(controlXpath));
		System.out.println(controlXpath);
		if (catElement != null) {
			this.click(catElement);
			flag = true;
		}
		return flag;
	}

	private List<SearchResultBook> getImgViewBooks() {
		List<SearchResultBook> bookList = new ArrayList<SearchResultBook>();

		List<WebElement> children = this
				.getElements(By
						.xpath("//div[@id='rlist']/div[contains(@class, 'bookRecItem')]"));

		this.reportLog(children.size() + " Books Displayed(Student Search)");
		for (WebElement book : children) {
			SearchResultBook newBook = new SearchResultBook();
			// title
			WebElement bookTitleElement = this.getChildElement(book,
					By.xpath(".//p[contains(@class, 'title')]"));
			newBook.title = this.getText(bookTitleElement);

			// has In Lib Icon
			WebElement inLibIconElement = this.getChildElement(
					bookTitleElement, By.xpath("./img"), 2);
			if (inLibIconElement != null) {
				newBook.isInLibIconDisplayed = true;
			}

			// author
			WebElement bookAutElement = this.getChildElement(book,
					By.xpath(".//p[contains(@class, 'authors')]"));
			newBook.author = this.getText(bookAutElement);

			// lexile
			WebElement lexileAutElement = this.getChildElement(book,
					By.xpath(".//div[p[text()='Lexile']]/p[2]"));
			newBook.lexile = this.getText(bookAutElement);

			// wc
			WebElement wcAutElement = this.getChildElement(book,
					By.xpath(".//div[p[text()='Word Count']]/p[2]"));
			newBook.wordCount = this.getText(bookAutElement);

			// LP library icon
			WebElement lplElement = this.getChildElement(book,
					By.xpath(".//img[@src='/images/icon_lpl.png']"), 2);
			if (lplElement != null)
				newBook.isLitProLibIconDisplayed = true;

			// categories
			List<WebElement> catsElementLst = this.getChildElements(book,
					By.xpath(".//p[contains(@class,'iconLabel')]"), 2);
			if (!catsElementLst.isEmpty()) {
				for (WebElement element : catsElementLst) {
					String categoryName = this.getText(element);
					newBook.categories += (newBook.categories.length() > 0) ? ","
							+ categoryName
							: categoryName;
				}
			}

			// has quiz
			WebElement quizButtonElement = this.getChildElement(book,
					By.xpath(".//input[@value='Take the Quiz']"), 2);
			if (quizButtonElement != null)
				newBook.hasQuizButton = true;

			this.reportLog(newBook.toString());
			bookList.add(newBook);
		}
		return bookList;
	}

	public class SearchResultBook {
		public String title = "";
		public String author = "";
		public String lexileCode = "";
		public String lexile = "";
		public String eduLevel = "";
		public String point = "";
		public String wordCount = "";
		public String categories = ""; // comma separated
		public boolean hasQuizButton = false;
		public boolean isInLibIconDisplayed = false;
		public boolean isLitProLibIconDisplayed = false;

		@Override
		public String toString() {
			return "{BookTitle:" + title + ", Author:" + author
					+ ", Lexile Code:" + lexileCode + ", Lexile:" + lexile
					+ ", Edu Level:" + eduLevel + ", Point:" + point
					+ ", Word Count:" + wordCount + ", Categories:"
					+ categories + ", Quiz Button:" + hasQuizButton
					+ ", isInLibIconDisplayed:" + isInLibIconDisplayed
					+ ",isLitProLibIconDisplayed:" + isLitProLibIconDisplayed
					+ "}";
		}
	}

	public boolean isTooltipDisplayed() {

		String xpath = "sas";
		WebElement ReportTextElement = this.getElement(By.xpath(xpath));

		if (ReportTextElement != null)
			return true;

		return false;
	}

	/**
	 * @throws InterruptedException
	 *****************************************************************************/

	public void clickKnowBookTakeQuizButton() throws InterruptedException {
		Thread.sleep(10000);
		searchtableview.click();
		this.sync(driver.findElement(By.xpath("//*[@id='search-results-table']/tbody/tr")));
		scrolldownTillEnd();

		this.reportLog("This scrolling has ended");

		String bookTitle = booksObj.getBooktitle();
		System.out.println(bookTitle);
		List<WebElement> NumberOfBooks = this.getElements(By
				.xpath("//*[@id='search-results-table']/tbody/tr"));
		this.reportLog("Number of books in the reading list "
				+ NumberOfBooks.size());

		this.reportLog("Searching for the book");

		for (int i = 1; i < NumberOfBooks.size(); i++) {
			String title = driver
					.findElement(
							By.xpath("//*[@id='search-results-table']//tr[" + i
									+ "]/td[2]")).getText().trim();
			if (title.equals(bookTitle)) {
				WebElement quiz =	driver.findElement(
						By.xpath("//*[@id='search-results-table']//tr[" + i
								+ "]//input"));
				System.out.println(quiz);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", quiz);
				executor.executeScript("arguments[0].click();",quiz );
			
				
				Thread.sleep(5000);
				break;
			}
		}
	}
	
	public String CommentVerifying(String CommentVerify){
		CommentVerify = CommentVerifyTxtBox.getText();
		return CommentVerify;
	}
	
	@FindBy(xpath = ".//div[@class='commentarea']/p")
	private WebElement CommentVerifyTxtBox;
	
	
	public boolean SeeMyRatingButton() throws InterruptedException {
		int check = 0;
		Thread.sleep(10000);
		searchtableview.click();
		scrolldownTillEnd();
		this.reportLog("This scrolling has ended");

		String bookTitle = booksObj.getBooktitle();
		setbooktitle(bookTitle);
		List<WebElement> NumberOfBooks = this.getElements(By
				.xpath("//*[@id='search-results-table']/tbody/tr"));
		this.reportLog("Number of books in the reading list "
				+ NumberOfBooks.size());

		this.reportLog("Searching for the book" + bookTitle);
		this.reportLog("There are " + NumberOfBooks.size() + " Numbers of book");
		for (int i = 1; i < NumberOfBooks.size(); i++) {
			String title = driver
					.findElement(
							By.xpath("//*[@id='search-results-table']//tr[" + i
									+ "]/td[2]")).getText().trim();

			if (title.equals(bookTitle)) {
				this.reportLog("Found the book --> " + bookTitle);
				String buttonText = driver.findElement(
						By.xpath("//*[@id='search-results-table']//tr[" + i
								+ "]//input")).getAttribute("value");
				this.reportLog(bookTitle + " has button " + buttonText);

				if (buttonText.equalsIgnoreCase("See My Book Rating")) {
					driver.findElement(
							By.xpath("//*[@id='search-results-table']//tr[" + i
									+ "]//input")).click();
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
	@FindBy(xpath = ".//div[@class='commentarea']/p")
	private WebElement CommentSee;

	public String typeSearchaboveKeyAndHitQuickSearchBtn() {
		String key = booksObj.getsearchtitle();
		this.reportLog("Enter Search Key: '" + key + "' and hit Search button");

		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			this.type(searchTextBoxForTeacher, key);
			searchTextBoxForTeacher.submit();
		} else if (lpUserType == LitProUserType.STUDENT) {
			searchTextBoxForStudent.clear();
			this.type(searchTextBoxForStudent, key);
			searchTextBoxForStudent.submit();
		}
		return key;
	}

	public boolean validateTitles() throws InterruptedException {
		this.sync(searchtableview).click();
		reportLog("Clicked on tablew view of search");
		scrolldownTillEnd();
		ArrayList<String> searchtitleStudent = new ArrayList<String>();
		List<WebElement> booktitle = this.getElements(By
				.xpath(".//*[@id='search-results-table']/tbody/tr/td[2]"));
		int checkboxsize = booktitle.size();
		for (int j = 0; j < checkboxsize; j++) {
			String title = booktitle.get(j).getText();
			searchtitleStudent.add(title);
		}
		reportLog("Comparing the data of the student and teacher");
		System.out.println(searchtitleStudent);
		System.out.println(getsearchtitlesetting());
		if (getsearchtitlesetting().equals(searchtitleStudent)) {
			return true;
		} else {
			return false;
		}
	}

	public String typeSearchKeyAndHitQuickSearchBtnStudent(String key) {
		this.reportLog("Enter Search Key: '" + key + "' and hit Search button");
		System.out.println(lpUserType);
		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			this.type(searchTextBoxForTeacher, key);
			searchTextBoxForTeacher.submit();
		} else if (lpUserType == LitProUserType.STUDENT) {
			this.type(searchTextBoxForStudent, key);
			searchTextBoxForStudent.submit();
		}
		booksObj.setsearchtitle(key);
		return key;
	}

	public void clickClearAllbutton() {
		this.reportLog("Click Clear ALL button");
		this.click(this.clearAll);

	}

	public boolean checkEduOptionsSelected(String level) {
		boolean flag = true;
		String controlXpath = "//label[span[contains(text(),'" + level
				+ "')]]/input[@type='checkbox']";
		By by = By.xpath(controlXpath);
		WebElement settingElement = this.getElement(by);

		if (settingElement != null) {
			if (!settingElement.isSelected()) {
				this.reportLog("Search Option: '" + level + "' Enabled");
				flag = false;
			}

		}
		return flag;

	}

	public boolean checkAdvSearchPointRangeDisplayed() {

		boolean flag = this.sync(advSearchPtsRangeFromTxtBx).isDisplayed();

		return flag;

	}

	public boolean isResultsDisplayed() {
		lazyWait(3);
		boolean flag = false;
		try {
			results.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;

		}
		return flag;
	}

	public boolean isGRLDisplayed() {

		lazyWait(3);
		boolean flag = false;
		try {
			flag = driver
					.findElement(
							By.xpath(".//*[@id='search-results']//span[contains(text(),'GRL')]"))
					.isDisplayed();
		} catch (Exception e) {
			flag = false;

		}
		return flag;
	}

	/*
	 * public BooksPage clickReadBook() {
	 * 
	 * 
	 * 
	 * JavascriptExecutor executor = (JavascriptExecutor)driver;
	 * executor.executeScript("arguments[0].click();",
	 * this.sync(driver.findElement
	 * (By.xpath(" (//a[span[text()='Read Book']])[2]"))));
	 * 
	 * return new BooksPage(driver);
	 * 
	 * 
	 * }
	 */
	public void selectChkBoxScholasticEbbokCollection() {
		this.sync(
				driver.findElement(By
						.xpath("//span[text()='Scholastic eBook Collections']")))
				.click();
	}

	public void typeSearchKeyAndHitQuickSearchBtnAsCsrep(String key) {
		this.reportLog("Enter Search Key: '" + key + "' and hit Search button");

		this.type(this.sync(driver.findElement(By
				.xpath(".//*[@ng-model='searchOpts.searchString']"))), key);
		this.sync(
				driver.findElement(By
						.xpath("(//button[span[text()='Search']])[1]")))
				.submit();

	}

	public String typeSearchKeyAndHitQuickSearchBtnStudentQuizzesONLY(String key) {
		this.reportLog("Enter Search Key: '" + key + "' and hit Search button");
		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			this.type(searchTextBoxForTeacher, key);
			quizzesOnlyChkBoxStudent.click();
			searchTextBoxForTeacher.submit();
		} else if (lpUserType == LitProUserType.STUDENT) {
			this.type(searchTextBoxForStudent, key);
			quizzesOnlyChkBoxStudent.click();
			searchTextBoxForStudent.submit();
		}
		booksObj.setsearchtitle(key);
		return key;
	}

	public void DoneButton() {
		DoneButton.click();
	}

	public void Clickprintbutton() {
		Printsearchresult.click();
		reportLog("Clicked on Print button of search tab");

	}

	public boolean searchresultnumber() throws InterruptedException {
		scrolldownTillEnd();
		List<WebElement> NumberOfBooks = this.getElements(By
				.xpath("//*[@id='search-results']/tbody/tr"));

		if (NumberOfBooks.size() <= 300) {
			reportLog("The search result is showing less then 300");
			return true;
		} else {
			reportLog("The search result is showing more then 300");
			return false;
		}
	}

	public boolean comapre() throws InterruptedException, AWTException {

		List<SearchResultBookTeacher> searchresultTeacherCompare = getSearchResultsForTeacher();
		List<SearchResultBookTeacher> printsearchresultTeachercompare = getPrintListViewSearchResultsForTeachers();
		switchtoWindow(2); // this is to close the print window
		System.out.println(searchresultTeacherCompare.toString());
		System.out.println(printsearchresultTeachercompare.toString());
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

	public class SearchResultBookTeacher {
		public String title = "";
		public String author = "";
		public String lexileCode = "";
		public String lexile = "";
		public String point = "";
		public boolean isInLibIconDisplayed = false;
		public boolean isLitProLibIconDisplayed = false;

		@Override
		public String toString() {
			return "{BookTitle:" + title + ", Author:" + author
					+ ", Lexile Code:" + lexileCode + ", Lexile:" + lexile
					+ ", Point:" + point + "}";
		}
	}

	private List<SearchResultBookTeacher> getPrintListViewSearchResultsForTeachers() {
		Clickprintbutton();
		this.lazyWait(5);
		switchToNewWindow();
		List<SearchResultBookTeacher> bookList = new ArrayList<SearchResultBookTeacher>();
		List<WebElement> children = this.getChildElements(
				ttsearchResultsParentTeachPg, By.xpath("./div/div[2]"));
		this.reportLog(children.size() - 1 + " Books Displayed(Teacher Search)");

		for (int i = 3; i <= (children.size() + 1); i++) {
			SearchResultBookTeacher newBook = new SearchResultBookTeacher();
			// title
			WebElement bookTitleElement = driver.findElement(By
					.xpath("html/body/div[" + i + "]/div[2]"));
			newBook.title = this.getText(bookTitleElement);

			// author
			WebElement bookAutElement = driver.findElement(By
					.xpath("html/body/div[" + i + "]/div[3]"));
			newBook.author = this.getText(bookAutElement);

			// lex code
			WebElement lexCodeElement = driver.findElement(By
					.xpath("html/body/div[" + i + "]/div[4]"));
			newBook.lexileCode = this.getText(lexCodeElement);

			// lex
			WebElement lexElement = driver.findElement(By
					.xpath("html/body/div[" + i + "]/div[5]"));
			newBook.lexile = this.getText(lexElement);

			// points
			WebElement ptsLevelElement = driver.findElement(By
					.xpath("html/body/div[" + i + "]/div[7]"));
			newBook.point = this.getText(ptsLevelElement);

			// has In Lib Icon
			WebElement inLibIconElement = driver.findElement(By
					.xpath("html/body/div[" + i + "]/div[1]"));
			if (inLibIconElement != null) {
				newBook.isInLibIconDisplayed = true;
			}
			this.reportLog(newBook.toString());
			bookList.add(newBook);
		}
		return bookList;
	}

	private List<SearchResultBookTeacher> getSearchResultsForTeacher()
			throws InterruptedException {
		this.lazyWait(5);
		scrolldownTillEnd();
		List<SearchResultBookTeacher> bookList = new ArrayList<SearchResultBookTeacher>();
		List<WebElement> children = this.getChildElements(
				searchResultsParentTeachPg, By.xpath("./tbody/tr"));
		this.reportLog(children.size() / 3 + " Books Displayed(Teacher Search)");
		if (children != null) {
			Iterator<WebElement> resultRows = children.iterator();
			while (resultRows.hasNext()) {
				WebElement firstTr = resultRows.next();
				WebElement secTr = resultRows.next();
				WebElement thirdTr = resultRows.next();

				SearchResultBookTeacher newBook = new SearchResultBookTeacher();
				// title
				WebElement bookTitleElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Title']"));
				newBook.title = this.getText(bookTitleElement);

				// author
				WebElement bookAutElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Author']"));
				newBook.author = this.getText(bookAutElement);

				// lex code
				WebElement lexCodeElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Lexile Code']"));
				newBook.lexileCode = this.getText(lexCodeElement);

				// lex
				WebElement lexElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Lexile']"));

				newBook.lexile = lexElement.getText();

				// points
				WebElement ptsLevelElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Points']"));
				newBook.point = this.getText(ptsLevelElement);

				// has In Lib Icon
				WebElement inLibIconElement = this.getChildElement(
						bookTitleElement, By.xpath(".//img"), 2);
				if (inLibIconElement != null) {
					newBook.isInLibIconDisplayed = true;
				}

				this.reportLog(newBook.toString());
				bookList.add(newBook);
			}
		}

		return bookList;
	}

	@FindBy(xpath = "//button[@class='btn btn-primary ng-scope']")
	private WebElement Printsearchresult;

	public boolean StudentSearchPrint() throws InterruptedException,
			AWTException {

		List<SearchResultBook> searchresultTeacherCompare = getListViewSearchResultsStudent();
		List<SearchResultBook> printsearchresultTeachercompare = getPrintListViewSearchResultsForStudent();
		switchtoWindow(2); // this is to close the print window
		System.out.println(searchresultTeacherCompare.toString());
		System.out.println(printsearchresultTeachercompare.toString());
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

	private List<SearchResultBook> getPrintListViewSearchResultsForStudent() {
		ClickprintbuttonStudent.click();
		this.lazyWait(5);
		switchToNewWindow();
		List<SearchResultBook> bookList = new ArrayList<SearchResultBook>();
		List<WebElement> children = this.getElements(By
				.xpath("html/body/table/tbody/tr"));
		this.reportLog((children.size()) + " Books Displayed(Student Search)");
		if (children != null) {
			Iterator<WebElement> resultRows = children.iterator();
			while (resultRows.hasNext()) {
				WebElement elemTr = resultRows.next();

				SearchResultBook newBook = new SearchResultBook();
				// title
				WebElement bookTitleElement = this.getChildElement(elemTr,
						By.xpath("./td[2]"));
				newBook.title = this.getText(bookTitleElement);

				// author
				WebElement bookAutElement = this.getChildElement(elemTr,
						By.xpath("./td[3]"));
				newBook.author = this.getText(bookAutElement);

				// lex
				WebElement booklexElement = this.getChildElement(elemTr,
						By.xpath("./td[4]"));
				newBook.lexile = this.getText(booklexElement);

				// wc
				WebElement bookwcElement = this.getChildElement(elemTr,
						By.xpath("./td[5]"));
				newBook.wordCount = this.getText(bookwcElement);

				this.reportLog(newBook.toString());
				bookList.add(newBook);
			}
		}
		//System.out.println("^^" + bookList);
		return bookList;
	}

	private List<SearchResultBook> getListViewSearchResultsStudent() {
		this.lazyWait(5);
		searchtableview.click();
		lazyWait(5);
		List<SearchResultBook> bookList = new ArrayList<SearchResultBook>();
		List<WebElement> children = this.getElements(By
				.xpath("//table[@id='search-results-table']/tbody/tr"));
		this.reportLog((children.size()) + " Books Displayed(Student Search)");
		if (children != null) {
			Iterator<WebElement> resultRows = children.iterator();
			while (resultRows.hasNext()) {
				WebElement elemTr = resultRows.next();

				SearchResultBook newBook = new SearchResultBook();
				// title
				WebElement bookTitleElement = this.getChildElement(elemTr,
						By.xpath("./td[2]"));
				newBook.title = this.getText(bookTitleElement);

				// author
				WebElement bookAutElement = this.getChildElement(elemTr,
						By.xpath("./td[3]"));
				newBook.author = this.getText(bookAutElement);

				// lex
				WebElement booklexElement = this.getChildElement(elemTr,
						By.xpath("./td[4]"));
				newBook.lexile = this.getText(booklexElement);

				// wc
				WebElement bookwcElement = this.getChildElement(elemTr,
						By.xpath("./td[5]"));
				newBook.wordCount = this.getText(bookwcElement);

				// has quiz
				WebElement quizButtonElement = this.getChildElement(elemTr,
						By.xpath("./td[6]/input[@value='Take the Quiz']"));
				if (quizButtonElement != null)
					newBook.hasQuizButton = true;

				this.reportLog(newBook.toString());
				bookList.add(newBook);
			}
		}
		System.out.println(bookList);
		return bookList;
	}

	@FindBy(xpath = "//span[text()='Scholastic eBook Collections']")
	private WebElement eBookcollectionSearch;

	public void ebookcollection() {
		eBookcollectionSearch.click();
		reportLog("Clicked on ebookcollection checkbox");
	}

	public boolean VerifyEbookIconTecher() throws InterruptedException {
		reportLog("Scrolling down to page end");
		scrolldownTillEnd();
		List<WebElement> NumberOfBooks = this.getElements(By
				.xpath("//*[@id='search-results']/tbody/tr"));

		int bookflix_Icon = 0;
		int trueflix_Icon = 0;
		int LitporLib_Icon = 0;

		this.reportLog("There are " + NumberOfBooks.size() + " Numbers of book");
		for (int i = 3; i < NumberOfBooks.size(); i = i + 3) {
			WebElement ebookIcon = driver.findElement(By
					.xpath("//*[@id='search-results']/tbody/tr[" + i
							+ "]/td[1]/show-product-icons/div/img"));
			String ebook = ebookIcon.getAttribute("src");
			if (ebook.contains("icon_tf")) {
				trueflix_Icon = 1;
			}
			if (ebook.contains("icon_bf")) {
				bookflix_Icon = 1;
			}
			if (ebook.contains("icon_ebb")) {
				LitporLib_Icon = 1;
			}
		}

		if (trueflix_Icon == 1 && bookflix_Icon == 1 && LitporLib_Icon == 1) {
			reportLog("All the 3 ebook icons are shown to user");
			return true;
		} else {
			reportLog("Either one of the icon or all the 3 ebook icons are missing from the user search. Please check the serach result manually");
			return false;
		}
	}

	public boolean VerifyEbookIconStudent() throws InterruptedException {
		reportLog("Scrolling down to page end");
		scrolldownTillEnd();
		//System.out.println("################################################");
		List<WebElement> NumberOfBooks = this.getElements(By
				.xpath("//*[@id='quizList']/div"));

		int bookflix_Icon = 0;
		int trueflix_Icon = 0;
		int LitporLib_Icon = 0;

		for (int i = 1; i < NumberOfBooks.size(); i++) {
			WebElement ebookIcon = driver.findElement(By
					.xpath("//*[@id='quizList']/div[" + i
							+ "]/div[2]/div[3]/show-product-icons/div[1]/img"));
			String ebook = ebookIcon.getAttribute("src");
			System.out.println(ebook);
			if (ebook.contains("icon_tf")) {
				trueflix_Icon = 1;
			}
			if (ebook.contains("icon_bf")) {
				bookflix_Icon = 1;
			}
			if (ebook.contains("icon_ebb")) {
				LitporLib_Icon = 1;
			}
		}

		if (trueflix_Icon == 1 || bookflix_Icon == 1 || LitporLib_Icon == 1) {
			reportLog("All the 3 ebook icons are shown to user");
			return true;
		} else {
			reportLog("Either one of the icon or all the 3 ebook icons are missing from the user search. Please check the serach result manually");
			return false;
		}
	}

	public boolean quizzes_enabled() {
		if (this.topquizButton.isEnabled()) {
			this.reportLog("Quizzes ENABLED on student page");
			return true;
		} else {
			this.reportLog("Quizzes DISABLED on student page");
			return false;
		}

	}

	public boolean quizzes_disabled() {
		if (!this.topquizButton.isEnabled()) {
			System.out.println(topquizButton.isEnabled());
			this.reportLog("Quizzes DISABLED on student page");
			return true;
		} else {
			this.reportLog("Quizzes ENABLED on student page");
			return false;
		}

	}
	
	public boolean isElementPresent(By by){
	try{
		driver.findElement(by);
			return true;
    }catch(NoSuchElementException e){
    	return false;
    }
	
}

	public int getSudentSearchResultsCount() {
		  WebElement resCntWe = this.getElement(By
		    .xpath("//*[@id='quizList']/div"));
		  if (resCntWe != null) {
		   int SearchCount = driver.findElements(By.xpath("//*[@id='quizList']/div")).size();
		   return SearchCount;   
		  }
		  return 0;
		 }
	
	public void SearchKeyword() throws IOException {
		String[] CSVquiz = CSVQuestions().toString()
				.replaceAll("^\\[|\\]$", "").split("\\,");
		//String key = "\"" + CSVquiz[3] + "\"";
		String key =CSVquiz[3];
		this.reportLog("Enter Search Key: '" + key + "'");
		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
			this.type(searchTextBoxForTeacher, key);
			searchTextBoxForTeacher.submit();
		} else if (lpUserType == LitProUserType.STUDENT) {
			this.type(searchTextBoxForStudent, key);
			searchTextBoxForStudent.submit();
		}
	}

	public boolean SearchresultViewQuiz() throws IOException {
		boolean result=false;
		lazyWait(5);
		ListviewButton.click();
		reportLog("Converted the search resilt into table view");
		lazyWait(2);		
		int a = driver
				.findElements(
						By.xpath(".//*[@id='search-results']//tr/td[3]"))
				.size();
		reportLog("Number of result shown in the search result is :"+a);
		String[] CSVquiz = CSVQuestions().toString()
				.replaceAll("^\\[|\\]$|\"", "").split("\\,");
		String key =CSVquiz[3];
		reportLog("Searching for the book :"+key);
		String Booktitle = null;
		for (int i = 1; i <= a; i=i+3) {
			Booktitle = driver.findElement(By.xpath(".//*[@id='search-results']//tr["+i+"]/td[3]//span")).getText().trim();
			if(Booktitle.equalsIgnoreCase(key)){
				driver.findElement(By.xpath(".//*[@id='search-results']//tr["+i+"]//button")).click();
				result =true;
				break;
			}
		}
		return result;
	}
	
	public void ClickViewQuiz() throws InterruptedException {
		lazyWait(4);
		int a = driver.findElements(By.xpath("//div[7]/div/div[2]/div")).size();
		System.out.println("Number of Quizzes inside the book are :" + a);
		ArrayList<String> q = new ArrayList<String>();
		
		for (int i = 2; i <= a; i++) {
			String xpath = "//div[7]/div/div[2]/div[" + i + "]/div[1]";
			q.add(driver.findElement(By.xpath(xpath)).getText().trim());
		}
		Collections.sort(q, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return extractInt(o1) - extractInt(o2);
			}

			int extractInt(String s) {
				String num = s.replaceAll("\\D", "");
				// return 0 if no digits found
				return num.isEmpty() ? 0 : Integer.parseInt(num);
			}
		});
		int LargestQuiz = q.size() - 1;
		System.out.println("Click on the View quiz button of :"+ q.get(LargestQuiz));
		String QuizTitle = q.get(LargestQuiz);
		String xpaths = "//div[contains(text(),'" + QuizTitle + "')]/parent::div//button";
		driver.findElement(By.xpath(xpaths)).click();
	}
	
	public boolean VerifyQuizzes() throws IOException{
		int Num=0;
		boolean result = false;
		switchToNewWindow();
		int numbQuestion = driver.findElements(By.xpath(".//*[@id='quizView']/div/div[4]/ol/li")).size();
		String[] CSVquiz = CSVQuestions().toString().replaceAll("^\\[|\\]$|\"|\"", "").split("\\,");
		for(int i=8; i<=CSVquiz.length; i=i+7){
			for (int j=1; j<=numbQuestion; j++){
				String Questions = driver.findElement(By.xpath("//*[@id='quizView']/div/div[4]/ol/li["+j+"]")).getText();
				String Answer = driver.findElement(By.xpath("//*[@id='quizView']/div/div[4]/ol/li["+j+"]/ol")).getText();
				String UIQuestions=Questions.replaceAll(Answer, "");
				if(CSVquiz[i].trim().equalsIgnoreCase(UIQuestions.trim())){
					Num=Num+1;
					break;
				}
			}
		}
		if(Num==numbQuestion){
			result=true;
		}
		return result;
	}
	public ArrayList CSVQuestions() throws IOException {
		ArrayList Questions = new ArrayList();
		String UploadedFilePath;
		String os=System.getProperty("os.name");
		if(os.contains("Windows"))
		{ UploadedFilePath = new File(".").getCanonicalPath()
		+ "\\src\\test\\resources\\upload_files\\quizupload.csv";
		}else{
		 UploadedFilePath="/home/linux-gui/.jenkins/workspace/lpdatafiles/quizupload.csv";
		}
		 //UploadedFilePath = "/home/linux-gui/.jenkins/workspace/CsrepStage/litpro-test/src/test/resources/upload_files/quizupload.csv";
		String b = getReadCSVFile(UploadedFilePath).toString();
		Questions.add(b.trim() + "*");
		return Questions;
	}
	
	@FindBy(xpath = "//*[@id='list-view-button-teacher']")
	private WebElement ListviewButton;
	
	@FindBy(xpath = "(.//*[@value='Take the Quiz'])[1]")
	private WebElement topquizButton;

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}

	public String getSeriesName() {
		String series=null;
		
		if (lpUserType == LitProUserType.TEACHER
				|| lpUserType == LitProUserType.SCHOOL_ADMIN) {
		 series =this.sync(driver.findElement(By.xpath(".//*[@class='result-series ng-scope']/a"))).getText();
		} else if (lpUserType == LitProUserType.STUDENT) {
			series =this.sync(driver.findElement(By.xpath(".//*[@class='series ng-scope']/a"))).getText();
		}
		 
		return series;
		
	}

	public String ClickViewQuizbutton() {
		lazyWait(4);
		driver.findElement(By.xpath(".//td[2]//button")).click();
		lazyWait(4);
		String title=this.sync(driver.findElement(By.xpath(".//div[2]/h3"))).getText();
		driver.findElement(By.xpath("//div[contains(@class,'available-quizzes-modal')]//button[span[text()='View Quiz']]")).click();
		//getQuestionsAndAnswersInQuiz();
		return title.replace("Quizzes for", "");
	}
public static HashMap<String, String> hmap = new HashMap<String, String>();
	
	util util1 = util.getInstance();
    public  HashMap<String, String>  getQuestionsAndAnswersInQuiz(){
    	String que=null;
    	String ans =null;
    	switchToNewWindow();
    	List<WebElement> ele =driver.findElements(By.xpath("html/body/div[2]/div/div[4]/ol/li"));
    	
    	//HashMap newmap = new HashMap();
    	
    	for(int i=1;i<=ele.size();i++){
    		que=driver.findElement(By.xpath(".//div[4]/ol/li["+i+"]")).getText().trim();
    		ans=driver.findElement(By.xpath(".//div[4]/ol/li["+i+"]/ol")).getText().trim();
    		System.out.println(que);
    		 util1.add(que, ans);
    	}
    	System.out.println(hmap);
		return hmap;
    }

	public boolean verifyBookTitle(String key) {
		lazyWait(5);
		this.sync(firstBooktitle);
		return firstBooktitle.getText().contains(key);
		
		
	}


		
	
	
}