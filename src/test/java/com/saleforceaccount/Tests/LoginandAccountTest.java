package com.saleforceaccount.Tests;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.commonutilities.common.CommomUtilities;
import com.saleforce.log.Log;
import com.saleforceaccount.basetest.BaseTest;
import com.saleforceaccount.pages.AccountPage;
import com.saleforceaccount.pages.LoginPage;

public class LoginandAccountTest extends BaseTest {
	WebDriver driver;
	CommomUtilities commom = new CommomUtilities();
	String url;
	LoginPage login;
	AccountPage account;
	String username;
	String password;
	String accountname = "smayaashetty";
	String newViewName = "shwetashetty";
	String uniqueViewName = RandomStringUtils.randomAlphabetic(8);
	String newReportName = RandomStringUtils.randomAlphabetic(3);
	String uniqueReportName = RandomStringUtils.randomAlphabetic(4);

	@BeforeMethod
	public void beforemethod() throws IOException {
		driver = getDriver();
		url = commom.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Logging in for  ACcounts");
		login = new LoginPage(driver);
		account = new AccountPage(driver);
		Log.info("Logging into saleforce login");

		username = commom.getProperty("username");
		password = commom.getProperty("password");
		
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		

		
		Log.info("Logged in succefully");

	}

	@Test
	public void TC10() {

		Log.info("Clicking Account tab");
		account.clickOnAccountTab();

		Log.info("closing the Swtiching log");
		account.closeLigthingTab();

		Log.info("Click on new link");
		account.clickNewButton();

		Log.info("EnterAccount Name");
		account.enterAccountName(accountname);

		Log.info("TYPE TEChonlogy Partner");
		account.selectType("Technology Partner");

		Log.info("Customer Priority");
		account.selectCustomerPriority("High");

		Log.info("Saving the info");
		account.saveAccount();

		Log.info("Validation");
		account.validate(accountname);

	}

	@Test
	public void TC11() throws InterruptedException {

		Log.info("Clicking Account tab");
		account.clickOnAccountTab();

		Log.info("closing the Swtiching log");
		account.closeLigthingTab();
		Log.info("Clicking New Link");
		account.newViewLink();
		Log.info("Enter new view name");
		account.enternewViewName(newViewName);
		Log.info("Enter unique name");
		account.enterUniqueViewName(uniqueViewName);
		Log.info("save new view");
		account.saveViewName();

		Log.info("Validate");
		account.validateViewName(newViewName);
		
		account.deleteViewName();
	}

	@Test
	public void TC12() {
		Log.info("Clicking Account tab");
		account.clickOnAccountTab();

		Log.info("closing the Swtiching log");
		account.closeLigthingTab();

		Log.info("Clicking New Link");
		account.newViewLink();
		Log.info("Enter new view name");
		account.enternewViewName(newViewName);
		Log.info("Enter unique name");
		account.enterUniqueViewName(uniqueViewName);
		Log.info("save new view");
		account.saveViewName();

		Log.info("Editing new view Link");
		account.editViewNamebutton();
		Log.info("Enter new View Name");
		account.enternewViewName(newViewName);

		Log.info("Enter new  Unique View Name");
		account.enterUniqueViewName(uniqueViewName);

		Log.info("Select Filte Field");
		account.filterField("Account Name");

		Log.info("Select Filter Operator");
		account.filterOperator("contains");

		Log.info("type value ");
		account.filterValue("a");

		Log.info("saving ");
		account.saveViewName();

	}
	
	@Test
	public void TC13() throws InterruptedException {
		Log.info("Clicking Account tab");
		account.clickOnAccountTab();

		Log.info("closing the Swtiching log");
		account.closeLigthingTab();
		Log.info("Click on new link");
		for(int i=1;i<3;i++) {
		account.clickNewButton();
		account.enterAccountName("text"+i);
		account.selectType("Technology Partner");
		account.selectCustomerPriority("High");
		account.saveAccount();
		Thread.sleep(5000);
		account.clickOnAccountTab();
		}
		
		account.mergeAccountLink();
		account.searchAccountsToMerge();
		Log.info("deleteAccount");
		account.deleteAccount();
		
	}
	
	

	@Test
	public void TC14() throws InterruptedException {
		Log.info("Clicking Account tab");
		account.clickOnAccountTab();

		Log.info("closing the Swtiching log");
		account.closeLigthingTab();

		Log.info("Cliking on account Link");
		account.reportActivity30();

		Log.info("Select create date arrow");
		account.selectCreateDateField1();

		Log.info("Select create date a");
		account.selectCreateDateField2();

		Log.info("Click calender image");
		account.fromcalenderLink();

		Log.info("Select today date from From Tab");
		account.fromtodayLink();

		Log.info("Click calender image");
		account.tocalenderLink();

		Log.info("Select today date from From Tab");
		account.totodayLink();

		Log.info("save todays date link");
		account.saveReportDate();

		Log.info("Enter report name");
		account.reportName(newReportName);

		Log.info("Enter report unique name");
		account.uniqueReportName(newReportName);

		Log.info("Save the report");
		account.saveReport();

	}
	
	

	@AfterMethod
	public void tearDown() throws IOException {
		takeScreenShot(driver);
		driver.close();
	}

}
