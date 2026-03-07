package com.Utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

public class Library {
	
	public static WebDriver driver;
	
	public void LaunchBrowser() {
		System.out.println("inside launchBrowser");
		driver= new ChromeDriver();
	}
	
	public void ValidatingTheResultOfTestCase(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			takeScreenShot(result);
		}
	}
	
	public void takeScreenShot(ITestResult result) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"//src//test//resources//ScreenShots//"+result.getName()+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
