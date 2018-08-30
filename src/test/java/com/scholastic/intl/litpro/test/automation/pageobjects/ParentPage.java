/**
 * 
 */
package com.scholastic.intl.litpro.test.automation.pageobjects;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scholastic.intl.litpro.test.automation.keys.Keys.hooksConstants;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.torque.common.BaseTestPage;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.torque.common.TestPage;

import static org.junit.Assert.assertTrue;

/**
 * @author Sadananda
 * 
 */
public class ParentPage extends BaseTestPage<TestPage> implements hooksConstants {
	public int DRIVER_WAIT = 120; // in seconds

	public WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	String windowHandle = "";
	public static Properties appConfig;
	TestBase testBase = TestBaseProvider.getTestBase();

	public ParentPage(WebDriver driver) {
		/*
		 * org.openqa.selenium.support.pagefactory.ElementLocatorFactory finder
		 * = new
		 * org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory(
		 * driver, DRIVER_WAIT); PageFactory.initElements(finder, this);
		 * this.driver = driver;
		 */
		this.driver = TestBaseProvider.getTestBase().getDriver();
		this.setWindowHandle();
//		loadConf();

	}

	public void loadConf() {
		Properties appConfig = new Properties();
		try {
			appConfig.load(getClass().getResourceAsStream("/conf.properties"));
		} catch (Exception e) {
			System.out.println("Unable to load conf.properties. "
					+ e.getMessage());
		}
	}

	private void setWindowHandle() {
		if (driver != null) {
			this.reportLog("Initiating Shared Web Driver..");
			Set<String> winHandles = driver.getWindowHandles();
			windowHandle = winHandles.toArray()[winHandles.size() - 1]
					.toString();
			String pStr = "Object/PageTitle/WinHandler: "
					+ this.getClass().getName() + "/" + driver.getTitle() + "/"
					+ windowHandle;
			this.reportLog("Active entities: \n" + pStr);
		}
	}

	public String getWindowHandle() {
		return this.windowHandle;
	}

	public WebElement sync(WebElement e) {
		try {
			(new WebDriverWait(driver, DRIVER_WAIT)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions
					.visibilityOf(e));
		}

		catch (NoSuchElementException nse) {
			this.reportLog(this.getClass().getName() + "/" + nse.getMessage());
			assertTrue(this.getClass().getName() + "/" + nse.getMessage(),
					false);
		} catch (TimeoutException toe) {
			Throwable tr = toe;
			// get the root cause
			while (tr.getCause() != null) {
				tr = tr.getCause();
			}
			String expString = tr.getMessage();
			expString = expString
					.replace(
							"(WARNING: The server did not provide any stacktrace information)",
							"");
			this.reportLog(this.getClass().getName() + "/" + expString);
			assertTrue(this.getClass().getName() + "/" + expString, false);
		}
		return e;
	}

	public String getText(WebElement e) {
		return this.sync(e).getText().trim();
	}

	public void click(WebElement e) {
		this.sync(e).click();
	}

	public void type(WebElement e, String text) {
		this.sync(e).clear();
		e.sendKeys(text);

	}

	public boolean isVisible(WebElement e) {
		return this.sync(e).isDisplayed();
	}

	public WebElement getElement(final By by) {
		ExpectedCondition<WebElement> condition = new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, DRIVER_WAIT);
		try {
			return wait.until(condition);
		} catch (TimeoutException e) {
			this.reportLog("Element NOT present/enabled/visible. Selector: "
					+ by.toString());
			return null;
		}
	}

	public WebElement getElement(final By by, int waitInSecs) {
		ExpectedCondition<WebElement> condition = new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, waitInSecs);
		try {
			return wait.until(condition);
		} catch (TimeoutException e) {
			this.reportLog("Element NOT present/enabled/visible. Selector: "
					+ by.toString());
			return null;
		}
	}

	public List<WebElement> getElements(final By by) {
		ExpectedCondition<List<WebElement>> condition = new ExpectedCondition<List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(by);
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, DRIVER_WAIT);
		try {
			return wait.until(condition);
		} catch (TimeoutException e) {
			return null;
		}
	}

	public WebElement getChildElement(final WebElement we, final By by) {
		sync(we);
		ExpectedCondition<WebElement> condition = new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				return we.findElement(by);
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, DRIVER_WAIT);
		try {
			return wait.until(condition);
		} catch (TimeoutException e) {
			return null;
		}
	}

	public WebElement getChildElement(final WebElement we, final By by,
			int waitSec) {
		sync(we);
		ExpectedCondition<WebElement> condition = new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				return we.findElement(by);
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, waitSec);
		try {
			return wait.until(condition);
		} catch (TimeoutException e) {
			return null;
		}
	}

	public List<WebElement> getChildElements(final WebElement we, final By by) {
		sync(we);

		ExpectedCondition<List<WebElement>> condition = new ExpectedCondition<List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				return we.findElements(by);
			}
		};

		System.out.println("inside parent page"+driver+" "+condition);
		Wait<WebDriver> wait = new WebDriverWait(driver, DRIVER_WAIT);
		try {
			return wait.until(condition);
		} catch (TimeoutException e) {
			return null;
		}
	}

	public List<WebElement> getChildElements(final WebElement we, final By by,
			int waitSecs) {
		sync(we);

		ExpectedCondition<List<WebElement>> condition = new ExpectedCondition<List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				return we.findElements(by);
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, waitSecs);
		try {
			return wait.until(condition);
		} catch (TimeoutException e) {
			return null;
		}
	}

	/* switches to new window, assuming current window is parent */
	public boolean switchToNewWindow() {
		boolean flag = false;
		this.lazyWait(10);
		Set<String> winHandles = driver.getWindowHandles();
		// this.log("There were '"+winHandles.size()+"' browser windows");
		if (winHandles.size() >= 1) {
			String winHndl = winHandles.toArray()[winHandles.size() - 1]
					.toString();

			driver.switchTo().window(winHndl);
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			this.reportLog("Driver switched to new window:'" + winHndl + "'");
			flag = true;
		}
		return flag;
	}

	public String getAttribute(WebElement e, String attribue) {
		return sync(e).getAttribute(attribue);
	}

	public void lazyWait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
		}
	}

	public void waitForPageLoad(int sec) {
		long startTime, endTime = 0;
		double duration = 0;
		String pageTtl;
		this.reportLog("Waiting for Page load...");
		try {
			ExpectedCondition<Boolean> ex = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript(
							"return document.readyState").equals("complete");
				}
			};

			startTime = System.nanoTime();
			Wait<WebDriver> wait = new WebDriverWait(driver, 60);
			wait.until(ex);
			this.waitWhenLoadingBarActive();
			// calculate time taken to load
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1.0E09;
			pageTtl = driver.getTitle().trim();
			pageTtl = (pageTtl.length() > 0) ? pageTtl : "Blank Web Driver";
			this.reportLog(pageTtl
					+ " Page displayed (time took: ~"
					+ String.valueOf(new DecimalFormat("##.00")
							.format(duration)) + " secs)");
			this.reportLog("Current URL:" + driver.getCurrentUrl());
		} catch (TimeoutException e) {
			this.reportLog("Wait for page load timedout (waited: " + sec
					+ " secs)");
			assertTrue("Page load Timed out", false);
		} catch (WebDriverException wde) {
			this.reportLog("[ERROR] WebDriver Exception");
			String expString = wde.getCause().getMessage();
			expString = expString
					.replace(
							"(WARNING: The server did not provide any stacktrace information)",
							"");
			assertTrue(this.getClass().getName() + "/" + expString, false);
		}
	}

	public boolean waitWhenLoadingBarActive() {
		try {
			(new WebDriverWait(driver, 30)).until(ExpectedConditions
					.invisibilityOfElementLocated(By.id("loading-bar")));
			return true;
		} catch (Exception e) {
			this.reportLog("Wait for Blue Loading Bar invisibility timed out");
			return false;
		}
	}

	public void reportLog(String msg) {
		String methodName = Thread.currentThread().getStackTrace()[2]
				.getMethodName();
		int lineNum = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String timeNow = new SimpleDateFormat("hh:mm:ss a").format(new Date());
		System.out.println("[" + timeNow + " - " + methodName + ":" + lineNum
				+ "]: " + msg);
	}

	/**
	 * Converts the Date to any format.
	 *
	 * @param str
	 *            the str
	 * @return Date in string
	 */
	public String getFormattedDate(Date date, String format) {
		String formatedDate = "";
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			formatedDate = sdf.format(cal.getTime());
		}

		catch (Exception e) {
			return formatedDate;
		}
		return formatedDate;
	}

	// This code is for scrolling down till the end
	public void scrolldownTillEnd() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		reportLog("scrolling down till the end of the page");
		for (int second = 0;; second++) {
			if (second >= 10) {
				break;
			}
			jse.executeScript("window.scrollBy(0,800)", ""); // y value '800'
																// can be
																// altered
			Thread.sleep(3000);
		}
	}
	
	public void scrolldownTillEnd(int scroll) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String t = "window.scrollBy(0,"+scroll+")";
		for (int second = 0;; second++) {
			if (second >= 1) {
				break;
			}
			
			jse.executeScript(t, ""); // y value '800'
																// can be
																// altered
		}
	}
	
	public void scrolldowntoElement(WebElement element) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		reportLog("scrolling down to the page");
		for (int second = 0;second<=2000; second++) {
			System.out.println("--------------------"+second);
			try {
				System.out.println("*******************"+element);
				if (element.isDisplayed()) {
					System.out.println("0000000Hello000000000");
					break;
				}
			} catch (Exception e) {
				jse.executeScript("window.scrollBy(0,200)", ""); // y value '800' can be altered
			}
		}
	}

	/*
	 * This method is written to get the search title for testing the settings
	 * "Allow students to search outside educational level"
	 */
	public ArrayList getsearchtitlesetting() {
		return ParentPage.booksearch;
	}

	public void setsearchtitlesetting(ArrayList booksearch) {
		ParentPage.booksearch = booksearch;
	}

	public static ArrayList booksearch;

	public static String booktitle;

	public String getbooktitlesb() {
		return ParentPage.booktitle;
	}

	public void setbooktitle(String booktitle) {
		ParentPage.booktitle = booktitle;
	}
	
	public static String Collectiontitle;

	public String getCollectionTitle() {
		return ParentPage.Collectiontitle;
	}

	public void setCollectionTitle(String booktitle) {
		ParentPage.Collectiontitle = booktitle;
	}

	
	public void switchtoWindow(int n) throws AWTException {
		boolean flag = false;
		Set<String> availableWindows = driver.getWindowHandles();
		String current = driver.getWindowHandle();
		String previous = null;
		for (String window : availableWindows) {
			if (!window.equalsIgnoreCase(current)
					|| !driver.getTitle().contains("Scholastic Learning Zone")) {
				closewindow();
				previous = window;
				driver.switchTo().window(previous);
				current = driver.getWindowHandle();

				break;
			}
		}

	}

	public void closewindow() throws AWTException {

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
	}
	


	protected void openPage() {
		// TODO Auto-generated method stub
		
	}
	
	public String getDateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate localDate = LocalDate.now();
		return dtf.format(localDate);
	}

	public ArrayList getReadCSVFile(String path) {
		String csvFile = path;
		String line = "";

		ArrayList a = new ArrayList();
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				a.add(line + "*");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	public int RandomNumber() {
		Random rnd = new Random();
		int n = rnd.nextInt(90) + 10;
		return n;
	}
	
	public int RandomNumber3Digit() {
		Random rnd = new Random();
		int n = rnd.nextInt(1000/2) *2;
		return n;
	}
	
	protected WebDriverWait wait = new WebDriverWait(driver, 10);
	
	
}