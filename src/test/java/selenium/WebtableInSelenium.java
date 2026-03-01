package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebtableInSelenium {
	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://editor.datatables.net/examples/inline-editing/simple");
	driver.manage().window().maximize();
	WebElement table = driver.findElement(By.xpath("//table[@id='example']"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", table);
	String FirstName ="Brenden";
	List<WebElement> AllRows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
	System.out.println("AllRows:"+AllRows.size());
	for(int row=1;row <= AllRows.size();row++){
		String FirstNameFromWebTable = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+row+"]/td[2]")).getText();
		System.out.println("RowNumber:"+row + " FirstNameFromWebTable:"+FirstNameFromWebTable);
		if(FirstNameFromWebTable.equalsIgnoreCase(FirstName)) {
			String LastNameFromWebTable = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+row+"]/td[3]")).getText();
			String PositionFromWebTable = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+row+"]/td[4]")).getText();
			String OfficeFromWebTable = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+row+"]/td[5]")).getText();
			String StartDateFromWebTable = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+row+"]/td[6]")).getText();
			String SalaryFromWebTable = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+row+"]/td[7]")).getText();
			System.out.println("RowNumber:"+row + " LastNameFromWebTable:"+LastNameFromWebTable);
			System.out.println("RowNumber:"+row + " PositionFromWebTable:"+PositionFromWebTable);
			System.out.println("RowNumber:"+row + " OfficeFromWebTable:"+OfficeFromWebTable);
			System.out.println("RowNumber:"+row + " StartDateFromWebTable:"+StartDateFromWebTable);
			System.out.println("RowNumber:"+row + " SalaryFromWebTable:"+SalaryFromWebTable);
			break;
		}
	}
	}
}
