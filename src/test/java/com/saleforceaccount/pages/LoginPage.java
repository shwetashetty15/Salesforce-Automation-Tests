package com.saleforceaccount.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.saleforceaccount.basepage.BasePage;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "username")
	WebElement email;

	public void enterUsername(String myusername) {
		email.sendKeys(myusername);
	}

	@FindBy(id = "password")
	WebElement password;

	public void enterpassword(String mypassword) {
		waitForVisiblity(20, password);
		password.sendKeys(mypassword);
	}

	@FindBy(id = "Login")
	WebElement login;

	public void clickLoginButton() {
		login.click();
	}
	
	

}
