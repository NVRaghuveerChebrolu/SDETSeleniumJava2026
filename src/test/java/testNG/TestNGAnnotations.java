package testNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.AlertsPOM;

public class TestNGAnnotations {
	public WebDriver driver;
	

	@Test(priority=1)
	public void launchBrowser() {
		System.out.println("inside launch browser method");
		driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		String TitleOfAlertsPage= driver.getTitle();
		SoftAssert objSoftAssert = new SoftAssert();
		objSoftAssert.assertEquals(TitleOfAlertsPage, "Alert");
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		objAlertPOM.ConsentPopUp.click();
		objSoftAssert.assertAll();
	}
	
	@Test(priority=2,dependsOnMethods= {"launchBrowser"})
	public void validateNormalAlert() {
		System.out.println("inside validateNormalAlert");
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		objAlertPOM.NormalAlert.click();
		Alert objAlert = driver.switchTo().alert();
		String TextOfNormalAlert = objAlert.getText();
		System.out.println("TextOfNormalAlert:"+TextOfNormalAlert);
		objAlert.accept();
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
	public void AfterMethod() {
		System.out.println("inside After Method");
	}
	
	@AfterClass
	public void Afterclass() {
		System.out.println("inside After Class");
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
