package com.scholastic.intl.litpro.test.automation.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scholastic.intl.litpro.test.automation.keys.Keys.hooksConstants;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;
import com.scholastic.torque.common.BaseTestPage;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.torque.common.TestPage;
import com.scholastic.torque.common.WaitUtils;
import com.scholastic.torque.webdriver.ExtendedElement;

public class BasePage extends ParentPage implements hooksConstants{
	Logger logger = LoggerFactory.getLogger(BasePage.class);
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();

	@FindBy(xpath = "(.//*[@id='csvUploadInstr']//div[@ng-show='!IsVisible'])[1]")
	WebElement CalenderYear;
	
	@FindBy(xpath = ".//button[contains(text(),'Manage Calendar')]")
	WebElement Calender;
	
	@FindBy(xpath = ".//button[contains(text(),'Close')]")
	WebElement CloseButton;
	public BasePage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
				DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	  
	public void launchPortal(LitProUserType lpUserType){
		String url = testBase.getContext().getString(URL);
		if(url.contains("slz")){
	SlzLoginPg slzlogin = new SlzLoginPg(driver);
	       slzlogin.launchSlz();
			slzlogin.loginAs(lpUserType);
		}else if(url.contains("dp")){
	SDMSignInPage sdmlogin = new SDMSignInPage(driver);
			sdmlogin.loginSDM(lpUserType);
		}
	}
	
	public void launchApp(LitProUserType lpUserType){
		String url = testBase.getContext().getString(URL);
		if(url.contains("slz")){
			SlzHomePg slzhome = new SlzHomePg(driver);
				slzhome.launchLitPro(lpUserType);
			}else if(url.contains("dp")){
				SDMHomePage sdmhome = new SDMHomePage(driver);
				sdmhome.launchRP(lpUserType);
		}
	}
	
	public void launchRPLLPL(LitProUserType lpUserType) throws InterruptedException{
		String url = testBase.getContext().getString(URL);
		if(url.contains("slz")){
			SlzHomePg slzhome = new SlzHomePg(driver);
				slzhome.launchLitProLibrary(lpUserType);
				switchToNewWindow();
			}else if(url.contains("dp")){
				SDMHomePage sdmhome = new SDMHomePage(driver);
				sdmhome.launchRPL(lpUserType);
		}
	}

	public void loginApp(String username, String password) {
		String url = testBase.getContext().getString(URL);
		if(url.contains("slz")){
			SlzLoginPg slzlogin = new SlzLoginPg(driver);
			slzlogin.login(username, password);
		}
		else if(url.contains("dp")){
			SDMSignInPage sdmsignin = new SDMSignInPage(driver);
			sdmsignin.loginsdm(username, password);
		}
	}
	
	public void calender(){
		Calender.click();
		String calenderTxt=CalenderYear.getText();
		ArrayList month = new ArrayList();
		String monthStart = null;
		String monthEnd = null;
		String [] calenderTxtSplit = calenderTxt.split("-");
		monthStart = months(calenderTxtSplit[2]);
		monthEnd = months(calenderTxtSplit[4]);
		CloseButton.click();
		setbooktitle(monthStart +"1"+ monthEnd);
	}
	
	public String months(String calenderTxtSplit){
		Map<String,String> map=new HashMap<String,String>();  
		  map.put("01","Jan"); 
		  map.put("02","Feb"); 
		  map.put("03","Mar"); 
		  map.put("04","Apr"); 
		  map.put("05","May"); 
		  map.put("06","Jun"); 
		  map.put("07","Jul"); 
		  map.put("08","Aug"); 
		  map.put("09","Sep"); 
		  map.put("10","Oct"); 
		  map.put("11","Nov"); 
		  map.put("12","Dec");
		  
		  String mon = map.get(calenderTxtSplit);
		return mon;
	}
	
	
	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}


	public void launchAppJoey(LitProUserType lpUserType) throws InterruptedException {
		SlzHomePg slzhome = new SlzHomePg(driver);
		slzhome.launchJoey(lpUserType);
		
	}
}
