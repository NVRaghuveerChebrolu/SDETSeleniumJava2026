package selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesAndWindowsSelenium {
	//Example of Linear FrameWork
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(frame);
		String frameText= driver.findElement(By.xpath("//body[@id='tinymce']")).getText();
		System.out.println("frameText:"+frameText);
		driver.switchTo().defaultContent();//to come out of the frame
		
		//Handling Windows
		String parentWindow = driver.getWindowHandle();
		
		//clicking on the link powered by essential selenium
		driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).click();

		//Explicit Wait : Applicable for one webElement.
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		//Fluent Wait : Similar to explicit wait , polling and ignoring exception are added
		FluentWait wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(25))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchWindowException.class);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				
		//taking control of all windows and switching to child window
		Set<String> AllWindows = driver.getWindowHandles();
		System.out.println("Total number of windows:"+ AllWindows.size());
		
		for(String Individualwindow : AllWindows) {
			driver.switchTo().window(Individualwindow);
			driver.manage().window().maximize();
			if(driver.getTitle().equalsIgnoreCase("Home | Elemental Selenium")) {
			driver.findElement(By.xpath("//*[text()='Take me to the tips! ']")).click();
			System.out.println(driver.getTitle());
				driver.close();//close the child window
			}
		}
		
		//switching back to parent window
		driver.switchTo().window(parentWindow);
		
	}

}
