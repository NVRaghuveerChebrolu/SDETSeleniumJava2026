package selenium;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		Map<String,Object> ChromePreferences = new HashMap<String,Object>();
		ChromePreferences.put("download.default_directory", System.getProperty("user.dir"));
		options.addArguments("--disable-pop-up-blocking");
		options.setExperimentalOption("prefs", ChromePreferences);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download./");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//p[text()='Consent']")).click();
		driver.findElement(By.xpath("//td[@class='file-ext' and text()='100kB']/following-sibling::td[4]/a")).click();
		
		File objFile = new File(System.getProperty("user.dir"));
		File[] AllFiles=objFile.listFiles();
		
		for(File IndividualFile:AllFiles) {
			Boolean FileFound=false;
			String NameOfFile= IndividualFile.getName();
			System.out.println("NameOfFile:"+NameOfFile);
			if(NameOfFile.contains("100kB")) {
				FileFound=true;
				IndividualFile.delete();
				System.out.println("File deleted successfully");
				break;
			}
		}
	}

}
