package com.scholastic.intl.litpro.test.automation.pageobjects;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.scholastic.intl.litpro.test.automation.keys.Keys.LoginPageLocators;
import com.scholastic.intl.litpro.test.automation.keys.Keys.hooksConstants;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.torque.common.AssertUtils;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.torque.common.WaitUtils;
import com.scholastic.torque.webdriver.ExtendedElement;

public class SDMSignInPage extends ParentPage implements LoginPageLocators,
		hooksConstants {
	WebDriver driver= TestBaseProvider.getTestBase().getDriver();
	private String userName = "";
	private String password = "";
	@FindBy(xpath = "//input[contains(@class,'usernamefield')]")
	private WebElement loginunametextboxsdm;

	@FindBy(xpath = "//input[contains(@class,'passwordfield')]")
	private WebElement loginpwdtextboxsdm;

	@FindBy(id="loginButton")
	private WebElement loginsigninbuttonsdm;

	
	
	TestBase testBase = TestBaseProvider.getTestBase();

	public SDMSignInPage(WebDriver driver) {
		super(driver);
		driver = TestBaseProvider.getTestBase().getDriver();
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}
	
	public void verifyUnamePwdSigninBtnDisplayed(){
		WaitUtils.waitForDisplayed(loginunametextboxsdm);
		AssertUtils.assertDisplayed(loginunametextboxsdm);
		WaitUtils.waitForDisplayed(loginpwdtextboxsdm);
		AssertUtils.assertDisplayed(loginpwdtextboxsdm);
		WaitUtils.waitForDisplayed(loginsigninbuttonsdm);
		AssertUtils.assertDisplayed(loginsigninbuttonsdm);
	}

	public String getPasswordSDM(LitProUserType userType) {
		String password;
		switch (userType) {
		case STUDENT:
			password = testBase.getContext().getString("student.password");
			break;

		case SCHOOL_ADMIN:
			password = testBase.getContext().getString("admin.password");
			break;

		case TEACHER:
			password = testBase.getContext().getString("teacher.password");
			break;

		case CS_REP:
			password = testBase.getContext().getString("csrep.password");
			break;

		default:
			password = testBase.getContext().getString("csrep.password");
		}

		return password;
	}
	

	public String getUserIdSDM(LitProUserType userType) {
		String username;
		switch (userType) {
		case STUDENT:
			username = testBase.getContext().getString("student.id");
			this.reportLog("Student Credetials (" + username + "/" + password
					+ ")");
			break;

		case SCHOOL_ADMIN:
			username = testBase.getContext().getString("admin.id");
			this.reportLog("SchoolAdmin Credetials(" + username + "/"
					+ password + ")");
			break;

		case TEACHER:
			username = testBase.getContext().getString("teacher.id");
			this.reportLog("Teacher Credetials (" + username + "/" + password
					+ ")");
			break;

		case CS_REP:
			username = testBase.getContext().getString("csrep.id");
			this.reportLog("CS Rep Credetials (" + username + "/" + password
					+ ")");
			break;

		default:
			username = testBase.getContext().getString("csrep.id");
			this.reportLog("Default Credetials (" + username + "/" + password
					+ ")");
		}

		return username;
	}
	
	public SDMHomePage loginsdm(String username, String password){
		this.userName = username;
		this.password = password;
		this.reportLog("Login to Scholastic Digital Manager(" + username + "/"
				+ password + ")");
		loginunametextboxsdm.sendKeys(username);
		loginpwdtextboxsdm.sendKeys(password);
		loginsigninbuttonsdm.click();
		
		return new SDMHomePage(driver);
	}

	public SDMHomePage loginSDM(LitProUserType lpUserType){
		String password = this.getPasswordSDM(lpUserType);
		SlzLoginPg slz = new SlzLoginPg(driver);
		String userName = slz.getUserId(lpUserType);
		return this.loginsdm(userName,password);
	}

	

	@Override
	protected void openPage() {

	}

}