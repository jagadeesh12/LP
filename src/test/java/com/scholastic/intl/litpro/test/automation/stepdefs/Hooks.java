package com.scholastic.intl.litpro.test.automation.stepdefs;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.saucelabs.saucerest.SauceREST;
import com.scholastic.intl.litpro.test.automation.keys.Keys.hooksConstants;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks implements hooksConstants{

	@Before
	public void beforeHook(Scenario scenario) {
		synchronized (this) {
			TestBase testBase = TestBaseProvider.getTestBase();
			testBase.getContext().subset("testexecution").clear();
			String session = testBase.getSessionID();
			if (!session.equalsIgnoreCase("") && !testBase.getContext().getString("sauce").equalsIgnoreCase("false")) {
				SauceREST sClient = new SauceREST(testBase.getContext().getString("sauce.username"),
						testBase.getContext().getString("sauce.access.key"));
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("name", scenario.getName());
				sClient.updateJobInfo(session, params);
			}
			testBase.getDriver().manage().deleteAllCookies();
			testBase.getDriver().manage().window().maximize();
			TestBaseProvider.getTestBase().getDriver().get(testBase.getString(URL));
		}
	}

	@After
	public void afterHook(Scenario scenario) {
		synchronized (this) {
			WebDriver driver = TestBaseProvider.getTestBase().getDriver();
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");

			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

			String session = TestBaseProvider.getTestBase().getSessionID();
			if (!scenario.isFailed())
				System.out.println(
						"ScenarioFailed=" + scenario.getName() + "<>Session=" + session + "<>Status=Passed<>Platform="
								+ TestBaseProvider.getTestBase().getContext().getString("driver.name"));
			else
				System.out.println(
						"ScenarioFailed=" + scenario.getName() + "<>Session=" + session + "<>Status=Failed<>Platform="
								+ TestBaseProvider.getTestBase().getContext().getString("driver.name"));
			System.out.println("SauceOnDemandSessionID=" + session + " job-name=" + scenario.getName());
			if (!session.equalsIgnoreCase("")
					&& !TestBaseProvider.getTestBase().getContext().getString("sauce").equalsIgnoreCase("false")) {
				TestBase testBase = TestBaseProvider.getTestBase();
				SauceREST sClient = new SauceREST(testBase.getContext().getString("sauce.username"),
						testBase.getContext().getString("sauce.access.key"));
				System.out.println("SessionID::" + session);
				if (scenario.isFailed())
					sClient.jobFailed(session);
				else
					sClient.jobPassed(session);
			}
			TestBaseProvider.getTestBase().tearDown();
		}
	}




}
