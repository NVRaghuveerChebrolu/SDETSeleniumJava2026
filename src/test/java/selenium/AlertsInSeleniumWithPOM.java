package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
