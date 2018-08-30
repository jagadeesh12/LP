package com.scholastic.intl.litpro.test.automation.pageobjects;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.bytecode.opencsv.CSVReader;

import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;

public class InLibraryPg extends ParentPage {
	WebDriver driver;
	final String PAGE_TITLE = "Scholastic Literacy Pro";
	final String PAGE_HEADER = "Match Your Library Books";
	String fileName;

	@FindBy(xpath = "//div[input[@type='file']]/input")
	private WebElement selectFileButton;

	@FindBy(xpath = "//button[text()='Upload']")
	private WebElement uploadButton;

	@FindBy(xpath = "//div[@id='heading']/h3")
	private WebElement pgHeader;

	@FindBy(xpath = "//div[@id='school-upload-history']//table/tbody/tr[1]/td[@data-title='Status']")
	private WebElement uploadStatus;

	@FindBy(xpath = ".//img[@src='images/icon_inSchoolLibraryColor.png']/parent::a//div[contains(text(),'Click here to match books in your school library to books and quizzes in Scholastic Literacy Pro')]")	
	public WebElement ToolTipReadinglistschoollibrary;
	
	public InLibraryPg(WebDriver driver, LitProUserType userType) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(this.DRIVER_WAIT);
	}

	public String getExpectedTitle() {
		return PAGE_TITLE;
	}

	public String getPageHeader() {
		String head = this.getText(pgHeader);
		this.reportLog("Page Header: " + head);
		return head;
	}

	/* selects file */
	public boolean selectFile(String completeFileName) {
		this.fileName = completeFileName;
		WebElement fileSelect = this.getElement(By
				.xpath("//input[@type='file']"));
		if (fileSelect == null) {
			this.reportLog("File selector NOT displayed");
			return false;
		}

		// change the opacity to have it visible
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].style.opacity='1';", fileSelect);
		this.lazyWait(5);

		try {
			String uploadFilePath = new File(".").getCanonicalPath()
					+ "//src//test//resources//upload_files//";
			String fullPath = uploadFilePath + completeFileName;
			this.reportLog("Select file: " + fullPath);
			File fl = new File(fullPath);
			if (fl.exists()) {
				fileSelect.sendKeys(uploadFilePath + completeFileName);
				this.lazyWait(5);
				return true;
			} else {
				this.reportLog("[ERROR] File " + completeFileName
						+ " NOT found at test-data/upload_files ");
				return false;
			}
		}

		catch (Exception e) {
			this.reportLog("[ERROR] Failed to select file: " + completeFileName
					+ e);
			return false;
		} finally {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].style.opacity='0';", fileSelect);
		}
	}

	public void clickUploadButton() {
		WebElement uploadBtn = this.getElement(By
				.xpath("//button[text()='Upload']"));
		this.reportLog("Click Upload Button");
		this.click(uploadBtn);
	}

	public String getImportStatus() {
		boolean upStatus = waitForFileUpload();
		this.reportLog(fileName + " File Upload: "
				+ (upStatus ? "Successful" : "Failed"));
		return this.getText(uploadStatus);
	}

	public int getHistoryTblRowCount() {
		String xpath = "//div[@id='school-upload-history']//table/tbody/tr";
		java.util.List<WebElement> rows = this.getElements(By.xpath(xpath));

		if (rows != null) {
			this.reportLog("History Table count: " + rows.size());
			return rows.size();
		}
		return 0;
	}

	public String tooltip(){
		reportLog("Validating the tool tip of \"Limit reading list titles to only those in the school library\"");
		String tooltip = null;
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath(".//img[@src='images/icon_inSchoolLibraryColor.png']")))
				.build().perform();
		lazyWait(1);
		
		if(ToolTipReadinglistschoollibrary.isDisplayed()){
			tooltip= ToolTipReadinglistschoollibrary.getText();
		}
		return tooltip;
	}
	
	public UploadHistoryData getHistoryTblFirstRow() {

		String xpath = "//div[@id='school-upload-history']//table/tbody/tr[1]";
		WebElement firstTr = this.getElement(By.xpath(xpath));
		try {
			if (firstTr != null) {
				UploadHistoryData uhd = new UploadHistoryData();
				// File Name
				WebElement fileNameElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='File Name']"), 2);
				uhd.fileName = fileNameElement.getText().trim();

				// Status
				WebElement statusElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Status']"), 2);
				uhd.status = statusElement.getText().trim();

				// Matches Count
				WebElement matchesElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Successful Matches']"), 2);
				uhd.successfulMatchesCount = matchesElement.getText().trim();

				// No Matches Count
				WebElement noMatchesElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='No Matches Found']"), 2);
				uhd.noMatchesCount = noMatchesElement.getText().trim();

				// No Matches Count
				WebElement dateElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Date Uploaded']"), 2);
				uhd.dateUploaded = dateElement.getText().trim();

				// No Matches Count
				WebElement userElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Uploaded By']"), 2);
				uhd.uploadedBy = userElement.getText().trim();

				// Failed Records
				WebElement failedElement = this.getChildElement(firstTr,
						By.xpath(".//td[@data-title='Failed Records']"), 2);
				uhd.failedRecordsCount = failedElement.getText().trim();

				this.reportLog(uhd.toString());
				return uhd;
			} else {
				this.reportLog("[Error] Upload history table NOT displayed");
				return null;
			}

		} catch (Exception e) {
			this.reportLog("Exception while reading Upload History table");
			return null;
		}
	}

	private boolean waitForFileUpload() {
		this.lazyWait(5);

		final String statusXpath = "//div[@id='school-upload-history']//table/tbody/tr[1]/td[@data-title='Status']";
		// final WebElement we = this.getElement(By.xpath(statusXpath));

		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver
						.findElement(
								By.xpath("//div[@id='school-upload-history']//table/tbody/tr[1]/td[@data-title='Status']"))
						.getText().trim().equalsIgnoreCase("Done");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 240);
		try {
			wait.until(condition);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public List<String> getHistoryTableColumnNames() {
		List<String> columnList = null;

		List<WebElement> columnListWebElmt = this
				.getElements(By
						.xpath("//div[@id='school-upload-history']//table/thead/tr/td"));

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

	public void clickFirstRowSuccessfulMatchesLink() {
		this.reportLog("Click Successful Matches link");
		String statusXpath = "//div[@id='school-upload-history']//table//tbody/tr[1]/td[@data-title='Successful Matches']/a";
		final WebElement we = this.getElement(By.xpath(statusXpath));
		this.click(we);
	}

	public void clickFirstRowFailedMatchesLink() {
		this.reportLog("Click Failed Matches link");
		String statusXpath = "//div[@id='school-upload-history']//table//tbody/tr[1]/td[@data-title='Failed Records']/a";
		final WebElement we = this.getElement(By.xpath(statusXpath));
		this.click(we);
	}

	public List<Map<String, String>> getCSVData(String filepath)
			throws Exception {
		File path1 = null;
		boolean flag = false;
		File[] files = new File(new File(".").getCanonicalPath()
				+ "\\test-data\\download_files").listFiles();
		Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);

		this.reportLog("Read " + filepath);
		HashMap<String, String> map = null;
		List<Map<String, String>> tempDataSheet = new ArrayList<Map<String, String>>();
		if (!files.equals(null)) {

			for (File f : files) {

				if (f.getName().contains(filepath)) {
					Date date = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"yyyy-MM-dd HH-mm-ss");
					path1 = new File(new File(".").getCanonicalPath()
							+ "\\test-data\\download_files\\"
							+ dateFormat.format(date) + ".csv");
					boolean fnew = f.renameTo(path1);
					if (fnew)
						reportLog("File name changed " + path1);
					// filepathnew = new File(".").getCanonicalPath() +
					// "\\test-data\\download_files\\" + f;
					flag = true;

				}
				if (flag)
					break;
			}

		}
		System.out.println(path1);
		CSVReader csvReader = new CSVReader(new FileReader(path1.toString()));
		String[] headerRow = csvReader.readNext();

		String[] row = null;
		while ((row = csvReader.readNext()) != null) {
			map = new HashMap<String, String>();
			for (int j = 0; j < row.length; j++) {
				map.put(headerRow[j].trim(), row[j].trim());
			}
			tempDataSheet.add(map);
			System.out.println(" Record: " + map.toString());
		}

		csvReader.close();

		return tempDataSheet;
	}

	public class UploadHistoryData {
		public String fileName = "";
		public String status = "";
		public String successfulMatchesCount = "";
		public String noMatchesCount = "";
		public String failedRecordsCount = "";
		public String dateUploaded = "";
		public String uploadedBy = "";

		@Override
		public String toString() {
			return "{FileName:" + fileName + ",Status:" + status + ",Matches:"
					+ successfulMatchesCount + ",No Matches:" + noMatchesCount
					+ ",Failed Recs:" + failedRecordsCount + ",Date:"
					+ dateUploaded + ",Uploaded By:" + uploadedBy + "}";

		}

	}

	public void clickReviewClosedReviewMatches() {
		this.sync(driver.findElement(By.xpath(".//*[@id='close-match']/a")))
				.click();
	}

	public boolean checkMatchFound(String book, String Author) {
		boolean Flag = false;
		boolean authorFlag = false;

		List<WebElement> ele = this.driver.findElements(By
				.xpath(".//*[@id='match']/div/div/div/div[1]"));

		for (WebElement element : ele) {
			element.getText().contains(book);
			reportLog("Book found " + book);
			Flag = true;

		}
		List<WebElement> authorNames = this.driver.findElements(By
				.xpath(".//*[@id='match']/div/div/div[1]/div[2]"));

		for (WebElement element : authorNames) {
			element.getText().contains(Author);
			reportLog("Book found " + Author);
			authorFlag = true;
			break;

		}

		if (Flag && authorFlag)
			return true;

		return false;

	}

	public boolean selectMatchedCheckbox(String author) {
		boolean flag = false;
		List<WebElement> ele = this.driver
				.findElements(By
						.xpath(".//*[@id='match']/div/div/div[2]/label[1]/div[1]/span"));
		for (int i = 0; i < ele.size(); i++) {
			if (ele.get(i).getText().contains(author)) {
				this.driver.findElement(
						By.xpath(".//*[@id='match']/div/div[" + i
								+ "]/div[2]/label[1]/div[1]/div")).click();
				flag = true;
				break;
			}
		}
		return flag;

	}

	public boolean checkCloseMatchReviewIsZero() {
		return this
				.sync(driver.findElement(By
						.cssSelector(".match-count.ng-binding"))).getText()
				.contains("Close matches left to review");

	}

	public void clickFirstRowNoMatchesLink() {
		this.reportLog("Click No Matches link");
		String statusXpath = "//div[@id='school-upload-history']//table//tbody/tr[1]/td[@data-title='No Matches Found']/a";
		final WebElement we = this.getElement(By.xpath(statusXpath));
		this.click(we);
	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}

}
