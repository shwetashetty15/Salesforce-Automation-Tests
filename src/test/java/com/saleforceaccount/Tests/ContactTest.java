package com.saleforceaccount.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.commonutilities.common.CommomUtilities;
import com.saleforceaccount.basetest.BaseTest;
import com.saleforceaccount.pages.AccountPage;
import com.saleforceaccount.pages.ContactPage;
import com.saleforceaccount.pages.LoginPage;

public class ContactTest extends BaseTest {
	WebDriver driver;
	String url;
	CommomUtilities common = new CommomUtilities();
	String username;
	String password;
	AccountPage account;
	LoginPage login;
	ContactPage contact;
	

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver=getDriver();
		url=common.getProperty("url");
		driver.get(url);
		
		login = new LoginPage(driver);
		account=new AccountPage(driver);
		contact=new ContactPage(driver);
		
	}
	
	@Test
	public void TC25() throws IOException {
		username=common.getProperty("username");
		password=common.getProperty("password");
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		contact.contactTabClick();
		account.closeLigthingTab();
		contact.clicknewContact();
		contact.lastNameOfcontact("smashetty");
		contact.saveContact();
		contact.ValidateContactName("smashetty");
	}
	
	@Test
	public void TC26() throws IOException {
		username=common.getProperty("username");
		password=common.getProperty("password");
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		contact.contactTabClick();
		account.closeLigthingTab();
		contact.accountNewView();
		contact.enterViewName();
		contact.enteruniqueViewName();
		contact.saveNewView();
		contact.validateViewName();
	}
	
	
	@Test
	public void TC27() throws IOException {
		username=common.getProperty("username");
		password=common.getProperty("password");
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		contact.contactTabClick();
		account.closeLigthingTab();
		contact.selectViewedContact("Recently Viewed Contacts");
	}
	
	@Test
	public void TC28() throws IOException {
		username=common.getProperty("username");
		password=common.getProperty("password");
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		contact.contactTabClick();
		account.closeLigthingTab();
		contact.selectViewedContact("My Contacts");
	}
	

	@Test
	public void TC29() throws IOException {
		username=common.getProperty("username");
		password=common.getProperty("password");
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		contact.contactTabClick();
		account.closeLigthingTab();
		contact.contactName();
		contact.validateRecentcontactName();

	}

	@Test
	public void TC30() throws IOException {
		username=common.getProperty("username");
		password=common.getProperty("password");
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		contact.contactTabClick();
		account.closeLigthingTab();
		contact.accountNewView();
		contact.enteruniqueViewName();
		contact.saveNewView();
		contact.errorMessageValidation("Error: You must enter a value");
	}
	
	@Test
	public void TC31() throws IOException {
		username=common.getProperty("username");
		password=common.getProperty("password");
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		contact.contactTabClick();
		account.closeLigthingTab();
		contact.accountNewView();
		contact.enterViewName();
		contact.enteruniqueViewName();
		contact.cancelnewView();
		contact.noViewNameValidation();
	}
	
	@Test	public void TC32() throws IOException, InterruptedException {
		username=common.getProperty("username");
		password=common.getProperty("password");
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		contact.contactTabClick();
		account.closeLigthingTab();
		contact.clicknewContact();
		contact.lastNameOfcontact("Indian2");
		contact.MagnifierForAccountName();
		//contact.newAccountName("Global Media");
		Thread.sleep(5000);
		contact.ClickOnAccountName();
		//contact.saveAndNew();
		//contact.displayedPageValidation("New Contact");
		
		
	}

	@AfterMethod
	public void tearDown() throws IOException {
		takeScreenShot(driver);
		driver.close();
	}
}
