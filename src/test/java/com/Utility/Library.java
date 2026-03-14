package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

public class Library {
	public HashMap<String,String> TestDataHashMap = new HashMap<String,String>();
	public static Properties objProp;
	public static WebDriver driver;
	
	public void LaunchBrowser() {
		System.out.println("inside launchBrowser");
		driver= new ChromeDriver();
	}
	
	
	public void LaunchBrowserInSeleniumGrid(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String,Object> ChromePreferences = new HashMap<String,Object>();
			ChromePreferences.put("download.default_directory", System.getProperty("user.dir"));
			options.addArguments("--disable-pop-up-blocking");
			options.setExperimentalOption("prefs", ChromePreferences);
			
			/*
			 * visit below url and download the Selenium Grid jar File.
			 * https://github.com/SeleniumHQ/selenium/releases/tag/selenium-4.41.0 open Git
			 * Bash or terminal and go into the location where jar file is avaialble.
			 * Execute below command java -jar selenium-server-4.41.0.jar standalone
			 * Selenium Grid will point port number 4444
			 */
			
			try {
				driver= new RemoteWebDriver(new URL("http://localhost:4444"),options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(browserName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			Map<String,Object> edgePreferences = new HashMap<String,Object>();
			edgePreferences.put("download.default_directory", System.getProperty("user.dir"));
			options.addArguments("--disable-pop-up-blocking");
			options.setExperimentalOption("prefs", edgePreferences);
			try {
				driver= new RemoteWebDriver(new URL("http://localhost:4444"),options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
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
	
	public HashMap<String, String> ReadTestDataDromExcel(int row, XSSFSheet objSheet) {
		DataFormatter objdataFormatter = new DataFormatter();
		TestDataHashMap.put("RunMode", objSheet.getRow(row).getCell(0).getStringCellValue());
		TestDataHashMap.put("TestCaseName", objSheet.getRow(row).getCell(1).getStringCellValue());
		TestDataHashMap.put("FirstName", objSheet.getRow(row).getCell(2).getStringCellValue());
		TestDataHashMap.put("LastName", objSheet.getRow(row).getCell(3).getStringCellValue());
		TestDataHashMap.put("Address", objSheet.getRow(row).getCell(4).getStringCellValue());
		TestDataHashMap.put("Email", objSheet.getRow(row).getCell(5).getStringCellValue());
		TestDataHashMap.put("PhoneNumber", objdataFormatter.formatCellValue(objSheet.getRow(row).getCell(6)));
		TestDataHashMap.put("Gender", objSheet.getRow(row).getCell(7).getStringCellValue());
		TestDataHashMap.put("Hobbies", objSheet.getRow(row).getCell(8).getStringCellValue());
		TestDataHashMap.put("Languages", objSheet.getRow(row).getCell(9).getStringCellValue());
		TestDataHashMap.put("Skills", objSheet.getRow(row).getCell(10).getStringCellValue());
		TestDataHashMap.put("Country", objSheet.getRow(row).getCell(11).getStringCellValue());
		TestDataHashMap.put("Selectcountry", objSheet.getRow(row).getCell(12).getStringCellValue());
		TestDataHashMap.put("DOB_YY", objdataFormatter.formatCellValue(objSheet.getRow(row).getCell(13)));
		TestDataHashMap.put("DOB_MM", objSheet.getRow(row).getCell(14).getStringCellValue());
		TestDataHashMap.put("DOB_DD", objdataFormatter.formatCellValue(objSheet.getRow(row).getCell(15)));
		TestDataHashMap.put("Password", objSheet.getRow(row).getCell(16).getStringCellValue());
		TestDataHashMap.put("ConformPwd", objSheet.getRow(row).getCell(17).getStringCellValue());				
		return TestDataHashMap;
	}
	

	public void selectRequiredValueFromDropDown(List<WebElement> AllElements, String valueFromExcel) {
		int numberOfDropDownValues = AllElements.size();
		for(int i=1; i<=numberOfDropDownValues;i++) {
			String IndividualDropDownValueFromWebApplication = AllElements.get(i).getText();
			if(IndividualDropDownValueFromWebApplication.equalsIgnoreCase(valueFromExcel)) {
				AllElements.get(i).click();
				break;
			}
		}
	}
	

	public void WriteToExcel(int row, XSSFSheet objSheet) {
		objSheet.getRow(row).createCell(18).setCellValue("Pass");
	}
	
	public static void ReadPropertiesFile() throws IOException {
		File objPropertiesFile = new File(System.getProperty("user.dir")+"//src//test//resources//config.properties");
		try {
			FileInputStream objFileInput = new FileInputStream(objPropertiesFile);
			objProp = new Properties();
			objProp.load(objFileInput);
			System.out.println("info coming from properties file for AlertsURL:"+objProp.getProperty("AlertsURL"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void PageLoadTimeOut(int seconds) {
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}


}
