package testNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Utility.Library;
import com.pages.AlertsPOM;

public class TestNGAlerts extends Library{
	

	@Test(priority=1,groups= {"regression"})
	public void launchingAlertsURL() {
		System.out.println("inside launch browser method");
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		String TitleOfAlertsPage= driver.getTitle();
		SoftAssert objSoftAssert = new SoftAssert();
		
		//Explicit Wait : Applicable for one webElement.
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("Alerts"));
		
		objSoftAssert.assertEquals(TitleOfAlertsPage, "Alerts");
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		objAlertPOM.ConsentPopUp.click();
		objSoftAssert.assertAll();
	}
	
	@Test(priority=2,dependsOnMethods= {"launchingAlertsURL"},groups= {"regression"})
	public void validateNormalAlert() {
		System.out.println("inside validateNormalAlert");
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		objAlertPOM.NormalAlert.click();
		Alert objAlert = driver.switchTo().alert();
		String TextOfNormalAlert = objAlert.getText();
		System.out.println("TextOfNormalAlert:"+TextOfNormalAlert);
		objAlert.accept();
	}
	
	@Test(priority=3,dependsOnMethods= {"validateNormalAlert"},retryAnalyzer=RetryAnalyzer.class)
	public void ConformBoxAlert() {
		System.out.println("inside ConformBoxAlert");
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		objAlertPOM.CancelTab.click();
		objAlertPOM.ConformBoxAlert.click();
		Alert objAlert = driver.switchTo().alert();
		objAlert.dismiss();;
		String messageForCancel =objAlertPOM.messageAfterCancel.getText();
		System.out.println("messageForCancel:"+messageForCancel);
		Assert.assertEquals(messageForCancel, "You Pressed Cance");
	}
	
	@Test(priority=4,dependsOnMethods= {"ConformBoxAlert"})
	public void PromptBoxAlert() {
		System.out.println("inside PromptBoxAlert");
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		objAlertPOM.AlertwithTextBoxButton.click();
		objAlertPOM.promptBoxAlert.click();
		Alert objAlert = driver.switchTo().alert();
		objAlert.sendKeys("I am automating alerts");
		objAlert.accept();
		String MessageOfTextBox = objAlertPOM.MessageAfterAcceptingPromptBoxAlert.getText(); 
		System.out.println("MessageOfTextBox:"+MessageOfTextBox);
		Assert.assertEquals(MessageOfTextBox, "Hello I am automating alerts How are you today");
	}
	
	
	@Test(priority=2,enabled=false)
	public void FirstTestCase() {
		System.out.println("inisde FirstTestCase");
	}
	
	@Test(priority=-1,invocationCount=5)
	public void SecondTestCase() {
		System.out.println("inisde SecondTestCase");
	}
	
	
	@Test(dataProvider="multipleLoginSets")
	public void validateMutipleSetOfTestData(String userName, String password) {
		System.out.println("inisde validateMutipleSetOfTestData");
		System.out.print(userName +" with password "+password);
		
	}
	
	@DataProvider(name="multipleLoginSets")
	public Object[][] getData(){
		return new Object[][] {
			{"userName1","password1"},
			{"userName2","password2"},
			{"userName3","password3"},
			{"userName4","password4"},
			{"userName5","password5"},
			{"userName6","password6"},
		};
	}
	
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() {
		System.out.println("inside Before Method");
	}
	
	@BeforeClass
	public void Beforeclass() {
		System.out.println("inside Before Class");
		LaunchBrowser();
	}
	
	
	@org.testng.annotations.BeforeTest
	public void BeforeTest() {
		System.out.println("inside Before Test");
	}

	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("inside Before Suite");
	}
	
	
	@org.testng.annotations.AfterMethod
	public void AfterMethod(ITestResult result) {
		System.out.println("inside After Method");
		ValidatingTheResultOfTestCase(result);
	}
	


	@AfterClass
	public void Afterclass() {
		System.out.println("inside After Class");
		driver.quit();
	}
	
	
	@org.testng.annotations.AfterTest
	public void AfterTest() {
		System.out.println("inside After Test");
	}

	@org.testng.annotations.AfterSuite
	public void AfterSuite() {
		System.out.println("inside After Suite");
	}
}
