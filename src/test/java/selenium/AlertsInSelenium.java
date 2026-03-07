package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Library;

public class AlertsInSelenium extends Library{
//Example of Modular FrameWork
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//p[text()='Consent']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		Alert objAlert = driver.switchTo().alert();
		String TextOfNormalAlert = objAlert.getText();
		System.out.println("TextOfNormalAlert:"+TextOfNormalAlert);
		objAlert.accept();
		
		
		driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		objAlert.dismiss();
		String messageForCancel = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println("messageForCancel:"+messageForCancel);
		
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
		driver.findElement(By.xpath("//button[text()='click the button to demonstrate the prompt box ']")).click();
		objAlert.sendKeys("I am automating alerts");
		objAlert.accept();
		String MessageOfTextBox = driver.findElement(By.xpath("//p[@id='demo1']")).getText(); 
		System.out.println("MessageOfTextBox:"+MessageOfTextBox);
		driver.quit();
	
		
	}

}
