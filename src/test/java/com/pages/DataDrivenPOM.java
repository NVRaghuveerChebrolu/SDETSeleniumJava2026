package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataDrivenPOM {
	public WebDriver driver;
	
	public DataDrivenPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@ng-model='FirstName']")
	public WebElement FirstName;
	
	@FindBy(xpath="//input[@ng-model='LastName']")
	public WebElement LastName;
	
	@FindBy(xpath="//textarea[@ng-model='Adress']")
	public WebElement Address;
	
	@FindBy(xpath="//input[@ng-model='EmailAdress']")
	public WebElement Email;
	
	@FindBy(xpath="//input[@ng-model='Phone']")
	public WebElement Phone;
	
	@FindBy(xpath="//input[@ng-model='radiovalue' and @value='Male']")
	public WebElement GenderMale;
	
	@FindBy(xpath="//input[@ng-model='radiovalue' and @value='FeMale']")
	public WebElement GenderFeMale;
	
	@FindBy(xpath="//input[@id='checkbox1']")
	public WebElement HobbiesCricket;

	@FindBy(xpath="//input[@id='checkbox2']")
	public WebElement HobbiesMovies;
	
	@FindBy(xpath="//input[@id='checkbox3']")
	public WebElement HobbiesHockey;
	
	@FindBy(xpath="//div[@id='msdd']")
	public WebElement Languages;
	
	@FindBy(xpath="//div[@id='msdd']/following-sibling::div/ul/li")
	public List<WebElement> AllLanguages;
	
	@FindBy(xpath="//span[@class='ui-icon ui-icon-close']")
	public WebElement closeLanguageSelected;
	
	@FindBy(xpath="//select[@id='Skills']")
	public WebElement Skills;
	
	@FindBy(xpath="//select[@id='countries']")
	public WebElement Country;
	
	@FindBy(xpath="//span[@role='combobox']")
	public WebElement selectCountry;
	
	@FindBy(xpath="//input[@role='textbox']")
	public WebElement TextBoxOfSelectCountry;
	
	@FindBy(xpath="//select[@id='yearbox']")
	public WebElement DOB_YY;
	
	@FindBy(xpath="//select[@id='yearbox']/option")
	public List<WebElement> AllYears;
	
	@FindBy(xpath="//select[@placeholder='Month']/option")
	public List<WebElement> AllMonths;
	
	@FindBy(xpath="//label[text()='Skills']")
	public WebElement label_skills;
	
	@FindBy(xpath="//select[@id='daybox']/option")
	public List<WebElement> AllDays;
	
	@FindBy(xpath="//select[@placeholder='Month']")
	public WebElement DOB_MM;
	
	@FindBy(xpath="//select[@id='daybox']")
	public WebElement DOB_DD;
	
	@FindBy(xpath="//input[@id='firstpassword']")
	public WebElement Password;
	
	@FindBy(xpath="//input[@id='secondpassword']")
	public WebElement ConformPwd;
	
	
	
	
}
