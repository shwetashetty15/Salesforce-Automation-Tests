package com.saleforceaccount.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.commonutilities.common.CommomUtilities;
import com.saleforceaccount.basetest.BaseTest;
import com.saleforceaccount.pages.AccountPage;
import com.saleforceaccount.pages.LeadPage;
import com.saleforceaccount.pages.LoginPage;

public class LeadTest extends BaseTest{
	WebDriver driver;
	String url;
	CommomUtilities common = new CommomUtilities();
	String username;
	String password;
	AccountPage account;
	LoginPage login;
	LeadPage lead;
	
	
	
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver=getDriver();
		url=common.getProperty("url");
		driver.get(url);
		
		login = new LoginPage(driver);
		lead= new LeadPage(driver);
		account=new AccountPage(driver);
		
		
	}
	
	@Test
	public void TC21() throws IOException{
		
		username = common.getProperty("username");
		password = common.getProperty("password");
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		lead.leadTabClick();
		account.closeLigthingTab();
		lead.checkLeadDropDown();
	
	}
	
	@Test
	public void TC22() throws IOException, InterruptedException{
		
		username = common.getProperty("username");
		password = common.getProperty("password");
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		lead.leadTabClick();
		account.closeLigthingTab();
		lead.selectMyUnreadLeads();
		lead.logout();
		
		login.enterpassword(password);
		login.enterUsername(username);
		login.clickLoginButton();
		
		lead.leadTabClick();
		lead.goButton();
		
		lead.checkTabDiplayed() ;
	
	}
	
	@Test
	public void TC24() throws IOException, InterruptedException{
		
		username = common.getProperty("username");
		password = common.getProperty("password");
		login.enterUsername(username);
		login.enterpassword(password);
		login.clickLoginButton();
		lead.leadTabClick();
		account.closeLigthingTab();
		lead.selectTodaysLead();
		lead.newLead();
		lead.leadLastName();
		lead.leadCompanyName();
		lead.saveLead();
		lead.validateLead();

	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		takeScreenShot(driver);
		driver.close();
	}

}
