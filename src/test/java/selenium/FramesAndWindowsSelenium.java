package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesAndWindowsSelenium {

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
