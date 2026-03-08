package testNG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Utility.Library;
import com.pages.AlertsPOM;
import com.pages.DataDrivenPOM;

public class TestNG_DataDriven extends Library {
	public HashMap<String,String> TestDataHashMap = new HashMap<String,String>();
	
	@Test(priority=1,groups= {"regression"})
	public void DataDrivenFromExcel() throws IOException, AWTException {
		System.out.println("inside DataDrivenFromExcel");
		LaunchBrowser();
		driver.get(objProp.getProperty("dataDriveURL"));
		driver.manage().window().maximize();
		String TitleOfAutomationTestingRegisterPage= driver.getTitle();
		
		//Explicit Wait : Applicable for one webElement.
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("Register"));
		
		Assert.assertEquals(TitleOfAutomationTestingRegisterPage, "Register");
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		objAlertPOM.ConsentPopUp.click();
		
		File TestdataFile = new File(System.getProperty("user.dir")+"//src//test//resources//Testdata//AutomationDemoSite.xlsx");
		try {
			//For reading from a file we need to take FileInputStream
			//For writing into a file we need to take FileOutputStream
			FileInputStream objFileInput = new FileInputStream(TestdataFile);

			
			XSSFWorkbook objWorkBook = new XSSFWorkbook(objFileInput);
			XSSFSheet objSheet = objWorkBook.getSheet("TestData");
			int AllRows = objSheet.getLastRowNum();
			DataDrivenPOM objDataDrivenPOM = new DataDrivenPOM(driver);
			
			//scroll into first name
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", objDataDrivenPOM.FirstName);
	
			for(int row =1 ; row<=AllRows ;  row++) {
				System.out.println("data from row: "+row);
				TestDataHashMap = ReadTestDataDromExcel(row,objSheet);
				if(TestDataHashMap.get("RunMode").equalsIgnoreCase("yes")) {
					
					objDataDrivenPOM.FirstName.clear();
					objDataDrivenPOM.FirstName.sendKeys(TestDataHashMap.get("FirstName"));
					
					objDataDrivenPOM.LastName.clear();
					objDataDrivenPOM.LastName.sendKeys(TestDataHashMap.get("LastName"));
					
					objDataDrivenPOM.Address.clear();
					objDataDrivenPOM.Address.sendKeys(TestDataHashMap.get("Address"));
					
					objDataDrivenPOM.Email.clear();
					objDataDrivenPOM.Email.sendKeys(TestDataHashMap.get("Email"));
					
					objDataDrivenPOM.Phone.clear();
					objDataDrivenPOM.Phone.sendKeys(TestDataHashMap.get("PhoneNumber"));
					
					if(TestDataHashMap.get("Gender").equalsIgnoreCase("male")) {
						objDataDrivenPOM.GenderMale.click();
					}else {
						objDataDrivenPOM.GenderFeMale.click();
					}
					
					if(TestDataHashMap.get("Hobbies").equalsIgnoreCase("cricket")) {
						objDataDrivenPOM.HobbiesCricket.click();
					}else if(TestDataHashMap.get("Hobbies").equalsIgnoreCase("movies")) {
							objDataDrivenPOM.HobbiesMovies.click();
					} else {
						objDataDrivenPOM.HobbiesHockey.click();
					}
					
					if(row>1) {
						objDataDrivenPOM.closeLanguageSelected.click();
					}
					
					objDataDrivenPOM.Languages.click();
					selectRequiredValueFromDropDown(objDataDrivenPOM.AllLanguages,TestDataHashMap.get("Languages"));
					
					
					objDataDrivenPOM.label_skills.click();
					
					Select objselectSkills = new Select(objDataDrivenPOM.Skills);
					objselectSkills.selectByValue(TestDataHashMap.get("Skills"));
					
//					Select objselectCountry = new Select(objDataDrivenPOM.Country);
//					objselectCountry.selectByValue(TestDataHashMap.get("Country"));
					
//					Select obj_selectCountry = new Select(objDataDrivenPOM.selectCountry);
//					obj_selectCountry.selectByValue(TestDataHashMap.get("Selectcountry"));
					
					objDataDrivenPOM.selectCountry.click();
					objDataDrivenPOM.TextBoxOfSelectCountry.sendKeys(TestDataHashMap.get("Selectcountry"));
					
					Robot obj = new Robot();
					obj.keyPress(KeyEvent.VK_ENTER);
					obj.keyRelease(KeyEvent.VK_ENTER);
					
					objDataDrivenPOM.DOB_YY.click();
					selectRequiredValueFromDropDown(objDataDrivenPOM.AllYears,TestDataHashMap.get("DOB_YY"));
					
					objDataDrivenPOM.DOB_MM.click();
					selectRequiredValueFromDropDown(objDataDrivenPOM.AllMonths,TestDataHashMap.get("DOB_MM"));
					
					objDataDrivenPOM.DOB_DD.click();
					selectRequiredValueFromDropDown(objDataDrivenPOM.AllDays,TestDataHashMap.get("DOB_DD"));
					
					objDataDrivenPOM.Password.clear();
					objDataDrivenPOM.Password.sendKeys(TestDataHashMap.get("Password"));
					
					objDataDrivenPOM.ConformPwd.clear();
					objDataDrivenPOM.ConformPwd.sendKeys(TestDataHashMap.get("ConformPwd"));
					
					FileOutputStream objFileOuput = new FileOutputStream(TestdataFile);
					WriteToExcel(row,objSheet);
					objWorkBook.write(objFileOuput);
				}else {
					System.out.println("Run Mode is not marked as Yes for "+row+" in the Test Data Excel File");
				}
			}
			objWorkBook.close();
			objFileInput.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
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
	public void BeforeSuite() throws IOException {
		System.out.println("inside Before Suite");
		ReadPropertiesFile();
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
