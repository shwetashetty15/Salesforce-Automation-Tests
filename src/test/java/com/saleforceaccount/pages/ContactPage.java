package com.saleforceaccount.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.saleforceaccount.basepage.BasePage;

public class ContactPage extends BasePage{

	public ContactPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="Contact_Tab")
	WebElement contactTab;
	public void contactTabClick() {
		contactTab.click();
	}
	
	@FindBy(name = "new")
	WebElement newContact;
	public void clicknewContact() {
		newContact.click();
	}
	
	@FindBy(id = "name_lastcon2")
	WebElement lastNameOfcontact;
	public void lastNameOfcontact(String lastName) {
		waitForVisiblity(20, lastNameOfcontact);
		lastNameOfcontact.sendKeys(lastName);
	}
	
	@FindBy(id="con4")
	WebElement accountName;
	public void accountName() {
		accountName.sendKeys("Shweta");
	}
	
	@FindBy(name = "save")
	WebElement saveContact;
	public void saveContact() {
		saveContact.click();
	}
	
	@FindBy(className = "topName")
	WebElement ValidateContactName;
	public void ValidateContactName(String expected) {
		waitForVisiblity(20, ValidateContactName);
		String actual =ValidateContactName.getText();
		Assert.assertEquals(actual, expected);
		
	}
	
	@FindBy(xpath = "//a[text()='Create New View']")
	WebElement accountNewView;
	public void accountNewView() {
		waitForVisiblity(20, accountNewView);
		accountNewView.click();
	}
	
	@FindBy(id="fname")
	WebElement viewName;
	String contactviewName="HIJK";
	public void enterViewName() {
		waitForVisiblity(20, viewName);
		viewName.sendKeys(contactviewName);
	}
	
	@FindBy(id="devname")
	WebElement uniqueViewName;
	String uniqueviewname =RandomStringUtils.randomAlphabetic(4);
	public void enteruniqueViewName() {
		uniqueViewName.click();
		uniqueViewName.clear();
		uniqueViewName.sendKeys(uniqueviewname);
	}
	
	@FindBy(name = "save")
	WebElement saveNewView;
	public void saveNewView() {
		saveNewView.click();
	}
	
	@FindBy(name="fcf")
	WebElement contactViewNme;
	public void validateViewName() {
		waitForVisiblity(20, contactViewNme);
		String expected=contactviewName;
		Select select = new Select(contactViewNme);
		String actual =select.getFirstSelectedOption().getText();
		Assert.assertEquals(actual, expected);
	}
	
	public void selectViewedContact(String visibleText) {
		Select select = new Select(contactViewNme);
		select.selectByVisibleText(visibleText);
		
	}
	
	@FindBy(xpath = "//a[contains(text(),'smaya')]")
	WebElement contactName;
	public void contactName() {
		waitForVisiblity(20, contactName);
		contactName.click();
	}
	
	@FindBy(xpath = "//h2[normalize-space()='smaya']")
	WebElement validatecontactName;
	public void validateRecentcontactName() {
		String expected="smaya";
		String actual=validatecontactName.getText();
		Assert.assertTrue(actual.equalsIgnoreCase(expected));
	}
	
	@FindBy(className = "errorMsg")
	WebElement errorMessageValidation;
	public void errorMessageValidation(String expected) {
		String actual =errorMessageValidation.getText();
		Assert.assertTrue(actual.equalsIgnoreCase(expected));
		
	}
	
	@FindBy(name = "cancel")
	WebElement cancelnewView;
	public void cancelnewView() {
		cancelnewView.click();
	}
	
	public void noViewNameValidation() {
		String value="HIJK";
		List<String> viewNamePresent = new ArrayList<String>();
		Select select = new Select(contactViewNme);
		for(WebElement element:select.getOptions()) {
			viewNamePresent.add(element.getText());
		}
		
		for(int i=0; i<viewNamePresent.size();i++) {
			
				if((viewNamePresent.get(i)).equalsIgnoreCase(value)) {
					Assert.assertTrue(false);;
				}
		}
		
		
	}
	
	@FindBy(id="con4")
	WebElement newAccountName;
	public void newAccountName(String name) {
		newAccountName.sendKeys(name);
	}
	
	@FindBy(name = "save_new")
	WebElement saveAndNew;
	public void saveAndNew() {
		saveAndNew.click();
	}
	
	@FindBy(className = "pageDescription")
	WebElement displayedpage;
	public void displayedPageValidation(String expected) {
		waitForVisiblity(20, displayedpage);
		String actual=displayedpage.getText();
		Assert.assertEquals(actual, expected);
	}
	
	@FindBy(className = "lookupIcon")
	WebElement MagnifierForAccountName;
	public void MagnifierForAccountName() {
		
		MagnifierForAccountName.click();
	}
	
	@FindBy(name="resultsFrame")
	WebElement frame;
	@FindBy(xpath = "//table[@class='list']//a[text()='Global Media']")
	WebElement ClickOnAccountName;
	public void ClickOnAccountName() throws InterruptedException {
		
		Set<String> window = driver.getWindowHandles(); 
		Iterator<String> i= window.iterator();
		String parentWindow=i.next();
		String childWindow=i.next();
		driver.switchTo().window(childWindow);
		Thread.sleep(5000);
		ClickOnAccountName.click();
	}
}
