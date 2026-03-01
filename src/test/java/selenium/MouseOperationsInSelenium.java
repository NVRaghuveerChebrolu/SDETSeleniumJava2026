package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOperationsInSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frameElement);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		// drag and drop mouse operation

		Actions objActions = new Actions(driver);
		objActions.dragAndDrop(source, target).build().perform();

		driver.switchTo().defaultContent();// come out of the frame
		driver.findElement(By.xpath("//a[text()='Accept']")).click();

		// double click operation using selenium action class

		driver.navigate().to("https://api.jquery.com/dblclick/");
		driver.navigate().back();
		driver.navigate().forward();

		WebElement frameElement1 = driver.findElement(By.xpath("//iframe"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", frameElement1);
		driver.switchTo().frame(frameElement1);

		WebElement BlueBox = driver
				.findElement(By.xpath("//span[text()='Double click the block']/preceding-sibling::div"));
		objActions.doubleClick(BlueBox).build().perform();
		driver.switchTo().defaultContent();

		// contextClick method in actions class performs right click action in selenium
		driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightClickButton = driver.findElement(By.xpath("//span[text()='right click me']"));
		objActions.contextClick(rightClickButton).build().perform();

	}

}
