package com.saleforceaccount.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.saleforceaccount.basepage.BasePage;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Account_Tab")
	WebElement accountTabbutton;

	public void clickOnAccountTab() {
		accountTabbutton.click();
	}

	@FindBy(id = "tryLexDialogX")
	WebElement closeLigthingTab;

	public void closeLigthingTab() {
		waitForVisiblity(10, closeLigthingTab);
		closeLigthingTab.click();
	}

	@FindBy(name = "new")
	WebElement newAccount;

	public void clickNewButton() {
		newAccount.click();
	}

	@FindBy(xpath = "//table[@class='detailList'][1]/tbody/tr[2]/td[2]//input[@id='acc2']")
	WebElement accountName;

	public void enterAccountName(String name) {
		waitForVisiblity(10, accountName);
		accountName.sendKeys(name);
	}

	@FindBy(id = "acc6")
	WebElement type;

	public void selectType(String visibleText) {
		selectFromDropDown(type, visibleText);
	}

	@FindBy(id = "00NDm000005yNWa")
	WebElement priority;

	public void selectCustomerPriority(String visibleText) {
		selectFromDropDown(priority, visibleText);
	}

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@value=' Save ']")
	WebElement saveAccount;

	public void saveAccount() {
		waitForVisiblity(5, saveAccount);
		saveAccount.click();
	}

	@FindBy(xpath = "//table[@id='bodyTable']/tbody/tr/td[@id='bodyCell']//div[@class='textBlock']/h2")
	WebElement validatingElement;

	public void validate(String expected) {
		waitForVisiblity(5, validatingElement);
		String actual = validatingElement.getText();
		System.out.println(expected);
		System.out.println(actual);
		compareTo(expected, actual);

	}

	@FindBy(xpath = "//table[@id='bodyTable']/tbody/tr/td[@id='bodyCell']//a[text()='Create New View']")
	WebElement newViewLink;

	public void newViewLink() {
		newViewLink.click();
	}

	@FindBy(id = "fname")
	WebElement newViewNameBox;

	public void enternewViewName(String newViewName) {
		waitForVisiblity(5, newViewNameBox);
		newViewNameBox.sendKeys(newViewName);
	}

	@FindBy(id = "devname")
	WebElement uniqueViewNameBox;

	public void enterUniqueViewName(String UniqueViewName) {
		uniqueViewNameBox.click();	
		uniqueViewNameBox.clear();
		uniqueViewNameBox.sendKeys("UniqueViewName");
	}

	@FindBy(name = "save")
	WebElement saveViewName;

	public void saveViewName() {
		saveViewName.click();
	}

	@FindBy(xpath = "//select[@class='title']")
	WebElement validateViewName;

	public void validateViewName(String expected) throws InterruptedException {
		Thread.sleep(5000);
		Select select = new Select(validateViewName);
		String actual=select.getFirstSelectedOption().getText();
		compareTo(actual,expected);
	}
	
	@FindBy(xpath="//a[text()='Delete']")
	WebElement deleteViewName;
	public void deleteViewName() {
		
		deleteViewName.click();
		driver.switchTo().alert().accept();
	}
	

	@FindBy(xpath = "//table[@id='bodyTable']/tbody/tr/td[@id='bodyCell']//a[text()='Edit']")
	WebElement edit;

	public void editViewNamebutton() {
		waitForVisiblity(8, edit);
		edit.click();
	}

	@FindBy(id = "fcol1")
	WebElement filterField;

	public void filterField(String visibletext) {
		selectFromDropDown(filterField, visibletext);
	}

	@FindBy(id = "fop1")
	WebElement filterOperator;

	public void filterOperator(String visibletext) {
		selectFromDropDown(filterOperator, visibletext);
	}

	@FindBy(id = "fval1")
	WebElement filterValue;

	public void filterValue(String value) {
		filterValue.sendKeys(value);
	}

	@FindBy(xpath = "//table[@id='toolsContent']/tbody//a[text()='Merge Accounts']")
	WebElement mergeAccountLink;

	public void mergeAccountLink() {
		waitForVisiblity(8, mergeAccountLink);
		mergeAccountLink.click();
	}

	/*
	 * @FindBy(id = "srch") WebElement mergeAccountName; public void
	 * mergeAccountName() { waitForVisiblity(5, mergeAccountName);
	 * mergeAccountName.sendKeys(); }
	 */

	@FindBy(xpath = "//table[@id='toolsContent']//a[text()='Accounts with last activity > 30 days']")
	WebElement reportActivity30;

	public void reportActivity30() {
		waitForVisiblity(8, reportActivity30);
		reportActivity30.click();
	}

	@FindBy(id = "ext-gen148")
	WebElement selectCreateDateField;

	public void selectCreateDateField1() {
		//windowchange();
		//System.out.println(driver.getWindowHandle());
		waitForVisiblity(8, selectCreateDateField);
		selectCreateDateField.click();
	}
	
	@FindBy(xpath = "//div[text()='Created Date']")
	WebElement selectCreateDateField2;
	public void selectCreateDateField2() {
		selectCreateDateField2.click();
	}

	@FindBy(id = "ext-gen152")
	WebElement fromcalenderLink;

	public void fromcalenderLink() {
		fromcalenderLink.click();
	}

	@FindBy(xpath = "//table[@id='ext-comp-1112']//button[text()='Today']")
	WebElement fromtodayLink;

	public void fromtodayLink() {
		waitForVisiblity(5, fromtodayLink);
		fromtodayLink.click();
	}

	@FindBy(id = "ext-gen154")
	WebElement tocalenderLink;

	public void tocalenderLink() {
		tocalenderLink.click();
	}

	@FindBy(xpath = "//table[@cellspacing='0']/tbody//td[@class='x-btn-mc']//button[@id='ext-gen296']")
	WebElement totodayLink;

	public void totodayLink() {
		waitForVisiblity(10, totodayLink);
		totodayLink.click();
	}

	@FindBy(xpath = "//table[@id='saveReportBtn']//button[text()='Save']")
	WebElement saveReportDate;

	public void saveReportDate() {
		waitForVisiblity(5, saveReportDate);
		saveReportDate.click();
	}

	@FindBy(id = "saveReportDlg_reportNameField")
	WebElement reportName;

	public void reportName(String name) {

		waitForVisiblity(5, reportName);
		reportName.sendKeys(name);
	}

	@FindBy(id = "x-form-el-saveReportDlg_DeveloperName")
	WebElement uniqueReportName;

	public void uniqueReportName(String name) throws InterruptedException {

		waitForVisiblity(5, uniqueReportName);
		uniqueReportName.sendKeys(name);
		Thread.sleep(2000);
		
		
	}

	@FindBy(xpath = "//table[@id='dlgSaveAndRun']//button[text()='Save and Run Report']")
	WebElement saveReport;
	public void saveReport() {
		waitForVisiblity(5, saveReport);
		saveReport.click();
		//System.out.println("abc");
	}
	
	@FindBy(xpath = "//a[text()='text2']")
	WebElement account2;
	@FindBy(xpath = "//a[text()='text1']")
	WebElement account1;
	@FindBy(name = "delete")
	WebElement deleteAccount;
	
	
	public void deleteAccount() {
		
		account1.click();
		waitForVisiblity(30, deleteAccount);
		deleteAccount.click();
		driver.switchTo().alert().accept();
		//account2.click();
		//deleteAccount.click();
		
	}
	
	
	@FindBy(id = "srch")
	WebElement search;
	
	@FindBy(name="srchbutton")
	WebElement FindButton;
	
	@FindBy(name = "goNext")
	WebElement goNext;
	
	@FindBy(name = "save")
	WebElement saveTheMerge;
	
	
	public void searchAccountsToMerge() {
		search.sendKeys("text");
		FindButton.click();
		goNext.click();
		saveTheMerge.click();
		driver.switchTo().alert().accept();
	}
	
	
	
}
