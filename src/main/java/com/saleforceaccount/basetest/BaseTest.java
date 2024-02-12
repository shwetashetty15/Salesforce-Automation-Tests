package com.saleforceaccount.basetest;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	
	public WebDriver getDriver() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		return driver;
		
	}
	
	public void takeScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot takeshot =(TakesScreenshot)driver;
		File ScrFile=takeshot.getScreenshotAs(OutputType.FILE);
		Date currentDate = new Date();
		String timstamp =new SimpleDateFormat("mm-dd-yyyy--hh-mm-ss").format(currentDate);
		String scShotLoaction="/Users/srikanth/eclipse/trainingworkspace/SaleforceAccountFrameWork/ScreenShot/Account"+timstamp+".jpeg";
		File file = new File(scShotLoaction);
		FileUtils.copyFile(ScrFile, file);
	}

}
