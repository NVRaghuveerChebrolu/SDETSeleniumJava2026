package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DoubtAmazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String textOfBestSellers = driver.findElement(By.xpath("//a[normalize-space()='Bestsellers']")).getText();
		System.out.println("textOfBestSellers:"+textOfBestSellers);
	}

}
