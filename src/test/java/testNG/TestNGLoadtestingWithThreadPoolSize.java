package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGLoadtestingWithThreadPoolSize {
	
	@Test(groups= {"regression"})
	public void testCase1() {
		System.out.println("inside testCase1");
	}
	
	@Test(invocationCount=10,threadPoolSize=5)
	public void testGoogleSearch() {
		System.out.println("Thread Id is:"+Thread.currentThread().getId());
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
		driver.findElement(By.xpath("//textarea[@title = 'Suche']")).sendKeys("automation testing");
		driver.close();
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
