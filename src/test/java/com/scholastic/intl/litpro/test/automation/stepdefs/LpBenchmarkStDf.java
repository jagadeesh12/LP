package com.scholastic.intl.litpro.test.automation.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

import com.scholastic.intl.litpro.test.automation.pageobjects.BasePage;
import com.scholastic.intl.litpro.test.automation.pageobjects.BenchmarkPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;

public class LpBenchmarkStDf {
	LitProUserType lpUserType;
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	LitProHomePg lpHome = new LitProHomePg(driver,lpUserType);
	BenchmarkPg lpBenchmarkPg = new BenchmarkPg(driver, lpUserType);
	BasePage base = new BasePage(driver);
	//Scenario scenario;
	TestBase testBase=TestBaseProvider.getTestBase();
	SearchPg lpSearchPg = new SearchPg(driver, lpUserType);

//
//	 @Before
//	 public void before(Scenario scenario) {
//		 this.scenario = scenario;
//	 }

	@Given("^I browse to Benchmark Page as \"(.*?)\"$")
	public void i_browse_to_Benchmark_Page_as(String userType) throws Throwable {
		LitProUserType lpUserType = slzLogin.getLitProUserType(userType);

		base.launchPortal(lpUserType);
		base.launchApp(lpUserType);
		assertNotNull("Could NOT launch litpro. Check log", lpHome);
		LitProHomePg lpHome = new LitProHomePg(driver);
		lpHome.goToBenchmarksPage();

	}

	@Then("^I should see Benchmark Page Page Header starting with \"(.*?)\"$")
	public void i_should_see_Benchmark_Page_Page_Header_starting_with(
			String expected) throws Throwable {
		lpBenchmarkPg = new BenchmarkPg(driver, lpUserType);
		String actual = lpBenchmarkPg.getHeaderText();
		// System.out.println(actual);
		assertTrue("The expected Page Header was '" + expected
				+ "' but actually was: " + actual, actual.contains(expected));
	}

	@Then("^I should see default selected benchmark as \"(.*?)\"$")
	public void i_should_see_default_selected_benchmark_as(String arg1)
			throws InterruptedException {
		lpBenchmarkPg.clickBenchmarkDropdown();
	}

	@Then("^I should see benchmark table with following category$")
	public void i_should_see_benchmark_table_with_following_category(
			List<String> catNames) throws Throwable {
		Iterator<String> catIterator = catNames.iterator();
		while (catIterator.hasNext()) {
			String categoryName = catIterator.next();
			// System.out.println(categoryName);
			assertTrue("The Benchmark Category '" + categoryName
					+ "' NOT displayed ",
					lpBenchmarkPg.isBenchmarkCategoryDisplayed(categoryName));
		}
	}

	@When("^I click on Save \"(.*?)\"$")
	public void i_click_on_Save(String standard) throws Throwable {
		lpBenchmarkPg.clickBenchmarkDropdown();
		lpBenchmarkPg.selectBenchmarkAndSave(standard);
	}

	@Then("^'Benchmark Saved' Message should display$")
	public void benchmark_Saved_Message_should_be_displayed() throws Throwable {
		// System.out.println("got to Benchmark message");
		String actual = lpBenchmarkPg.getNotificationText();
		assertTrue("'Benchmark Saved' message NOT matched. Actual: " + actual,
				actual.equalsIgnoreCase("Benchmark Saved"));
		Thread.sleep(5000);
	}

	//
	@Given("^I am on the Benchmark page$")
	public void i_am_on_thebenchmark_page() throws Throwable {
		// System.out.println("on benchmark page");
	}

	@When("^I enter search string \"(.*?)\"$")
	public void i_enter_search_string(String benchmarkclass) throws Throwable {
		// System.out.println("i_enter_search_string");
		lpBenchmarkPg.clickSmartBarArrow();
		lpBenchmarkPg.selectClass(benchmarkclass);
	}

	@And("^I should see the values for grades$")
	public void i_should_see_the_values_for_grades(
			List<Map<String, String>> scores) throws Throwable {
		// System.out.println("i_should_see_the_values_for_grades");
		// System.out.println(SharedDriver.appConfig.getProperty("org.id"));
		// if(!StringUtils.contains(ParentPage.appConfig.getProperty("org.id"),"AUS")){
		// System.out.println("ORG ID does not contain AUS");
		// return;
		// }
		Iterator<Map<String, String>> scIterator = scores.iterator();
		Integer i = 1;
		while (scIterator.hasNext()) {
			Map<String, String> row = scIterator.next();
			// System.out.println("row is "+row);
			String rowText = row.toString();
			assertTrue("Row for Year/Grade '" + row.get("")
					+ "' NOT displaying correct values ",
					lpBenchmarkPg.isStandardValueDisplayed(rowText, i));
			assertTrue("Row for Year/Grade '" + row.get("")
					+ "' NOT displaying correct values ",
					lpBenchmarkPg.areValuesConnected(rowText, i));
			i++;
		}
		return;
	}

	@And("^I should see the values for grades in Canada$")
	public void i_should_see_the_values_for_grades_in_canada(
			List<Map<String, String>> scores) throws Throwable {
		// System.out.println("i_should_see_the_values_for_grades_in_canada");
		// System.out.println(SharedDriver.appConfig.getProperty("org.id"));
		if (!StringUtils
				.contains(testBase.getContext().getString("url"), "CAN")) {
			// System.out.println("ORG ID does not contain CAN");
			return;
		}

		Iterator<Map<String, String>> scIterator = scores.iterator();
		Integer i = 1;
		while (scIterator.hasNext()) {
			Map<String, String> row = scIterator.next();
			// System.out.println("row is "+row);
			String rowText = row.toString();
			// System.out.println("rowText = "+rowText);
			assertTrue("Row for Year/Grade '" + row.get("")
					+ "' NOT displaying correct values ",
					lpBenchmarkPg.isStandardValueDisplayed(rowText, i));
			assertTrue("Row for Year/Grade '" + row.get("")
					+ "' NOT displaying correct values ",
					lpBenchmarkPg.areValuesConnected(rowText, i));
			i++;
		}
		return;
	}

	@Then("^I should click on benckmark dropdown$")
	public void I_should_click_benckmark_dropdown() throws InterruptedException {
		lpBenchmarkPg.clickBenchmarkDropdown();
	}

	@Then("^I should verify the dublicate benchmark$")
	public void I_should_verify_the_dublicate_benchmark()
			throws InterruptedException {
		assertTrue("There are dublicate benchmarks",
				lpBenchmarkPg.DublicateBenchmarksVerify());
	}
	
	@When("^I navigate to the benchmark page$")
	public void i_navigate_to_the_benchmark_page() throws Throwable {
		lpHome.goToBenchmarksPage();
	}

	@Then("^the roster information does not appear$")
	public void the_roster_information_does_not_appear() throws Throwable {
		boolean searchbarelement = lpSearchPg.isElementPresent(By.xpath("//div[@class='rosterTree']"));
		Assert.assertEquals(searchbarelement, false);
	}
	

	
}
