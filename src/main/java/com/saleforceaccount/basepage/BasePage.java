package com.saleforceaccount.basepage;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	protected WebDriver driver;
	
	

	public  BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void compareTo(String expected,String actual) {
		Assert.assertEquals(expected, actual);
	}
	
	public void selectFromDropDown(WebElement element, String visibleText) {
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void waitForVisiblity(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void windowchange() {
		String parentWindowHandle =driver.getWindowHandle();
		Set<String> wH =new HashSet<String>(driver.getWindowHandles());
		for(String handles:wH) {
			driver.switchTo().window(handles);
		}
	}

}
