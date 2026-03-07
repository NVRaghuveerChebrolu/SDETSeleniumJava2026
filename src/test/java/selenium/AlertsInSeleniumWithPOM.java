package selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AlertsPOM;

public class AlertsInSeleniumWithPOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		objAlertPOM.ConsentPopUp.click();
		
		objAlertPOM.NormalAlert.click();
		
		//Explicit Wait : Applicable for one webElement.
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert objAlert = driver.switchTo().alert();
		String TextOfNormalAlert = objAlert.getText();
		System.out.println("TextOfNormalAlert:"+TextOfNormalAlert);
		objAlert.accept();
		
		objAlertPOM.CancelTab.click();
		objAlertPOM.ConformBoxAlert.click();
		objAlert.dismiss();
		String messageForCancel =objAlertPOM.messageAfterCancel.getText();
		System.out.println("messageForCancel:"+messageForCancel);
		
		objAlertPOM.AlertwithTextBoxButton.click();
		objAlertPOM.promptBoxAlert.click();
		objAlert.sendKeys("I am automating alerts");
		objAlert.accept();
		String MessageOfTextBox = objAlertPOM.MessageAfterAcceptingPromptBoxAlert.getText(); 
		System.out.println("MessageOfTextBox:"+MessageOfTextBox);
		driver.quit();
	
		
	}

}
