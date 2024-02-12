package com.saleforceaccount.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.saleforceaccount.basepage.BasePage;

public class LeadPage extends BasePage {
	
	
	public LeadPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="Lead_Tab")
	WebElement leadTab;
	public void leadTabClick() {
		leadTab.click();
	}
	
	@FindBy(id="fcf")
	WebElement leadDropDown;
	public void checkLeadDropDown() {
		List expected =new ArrayList();
		
		expected.add("All Open Leads");
		expected.add("My Unread Leads");
		expected.add("Recently Viewed Leads");
		expected.add("Today's Leads");
		expected.add("View - Custom 1");
		expected.add("View - Custom 2");
		
		
		List actual = new ArrayList();
		Select select = new Select(leadDropDown);
		for(WebElement element: select.getOptions()) {
			actual.add(element.getText());
		}
		
		for(int i=0; i<actual.size();i++) {
			Assert.assertEquals(actual.get(i), expected.get(i));;
		}
		
		
	}
	
	
	
	public void selectMyUnreadLeads() {
		Select select = new Select(leadDropDown);
		select.selectByVisibleText("My Unread Leads");
		
	}
	
	public void selectTodaysLead() {
		Select select = new Select(leadDropDown);
		select.selectByVisibleText("Today's Leads");
	}
	
	@FindBy(id="userNavButton")
	WebElement userMenuDropdown;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;
	public void logout() {
		userMenuDropdown.click();
		logout.click();
	}
	
	@FindBy(name="fcf")
	WebElement leadDropDownAfterGo;
	public void checkTabDiplayed() {
		String expected="My Unread Leads";
		waitForVisiblity(20, leadDropDownAfterGo);
		Select select =new Select(leadDropDownAfterGo);
		String actual =select.getFirstSelectedOption().getText();
		Assert.assertEquals(actual, expected);
	}
	
	@FindBy(name="go")
	WebElement go;
	public void goButton() {
		go.click();
	}
	
	
	@FindBy(xpath = "//form[@id='hotlist']//input[@name='new']")
	WebElement newLead;
	public void newLead() {
		newLead.click();
	}
	
	@FindBy(xpath = "//table[@class='detailList']//input[@id='name_lastlea2']")
	WebElement leadLastName;
	public void leadLastName() {
		//String lastName=RandomStringUtils.randomAlphabetic(4);
		leadLastName.sendKeys("ABCDE");
	}
	
	@FindBy(xpath ="//table[@class='detailList']//input[@id='lea3']")
	WebElement leadCompanyName;
	public void leadCompanyName() {
		leadCompanyName.sendKeys("ABCDE");
	}
	
	@FindBy(name = "save")
	WebElement saveLead;
	public void saveLead() {
		saveLead.click();
	}
	
	@FindBy(className = "topName")
	WebElement validateLead;
	public void validateLead() {
		waitForVisiblity(20, validateLead);
		String expected ="ABCDE";
String actual=validateLead.getText();
Assert.assertEquals(actual, expected);
	}

}
