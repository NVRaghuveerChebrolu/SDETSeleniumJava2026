package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;

import javax.activation.DataHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUpload {

	public static void main(String[] args) throws UnsupportedFlavorException, IOException, AWTException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/FileUpload.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//p[text()='Consent']")).click();
		WebElement browseButton = driver.findElement(By.xpath("//span[text()='Browse …']"));
		Actions obj = new Actions(driver);
		obj.click(browseButton).build().perform();
		File objFile = new File(System.getProperty("user.dir")+"/Images/SampleFileToUpload.jpg");
		
		StringSelection objStringSelection = new StringSelection(objFile.toString());
		Clipboard objclipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		objclipboard.setContents(objStringSelection,null);
		Transferable objTransferable = objclipboard.getContents(null);
		
		if(objTransferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			System.out.println(objTransferable.getTransferData(DataFlavor.stringFlavor));
		}
		
		Robot objRobot = new Robot();
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		objRobot.keyPress(KeyEvent.VK_CONTROL);
		objRobot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		objRobot.keyRelease(KeyEvent.VK_V);
		objRobot.keyRelease(KeyEvent.VK_CONTROL);
		
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
