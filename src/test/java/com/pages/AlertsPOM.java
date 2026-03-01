package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPOM {
	WebDriver driver;
	
	public AlertsPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[text()='Consent']")
	public WebElement ConsentPopUp;
	

	@FindBy(xpath="//button[@class='btn btn-danger']")
	public WebElement NormalAlert;
	

	@FindBy(xpath="//a[@href='#CancelTab']")
	public WebElement CancelTab;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	public WebElement ConformBoxAlert;
	
	@FindBy(xpath="//p[@id='demo']")
	public WebElement messageAfterCancel;
	
	@FindBy(xpath="//a[text()='Alert with Textbox ']")
	public WebElement AlertwithTextBoxButton;
	
	@FindBy(xpath="//button[text()='click the button to demonstrate the prompt box ']")
	public WebElement promptBoxAlert;
	
	@FindBy(xpath="//p[@id='demo1']")
	public WebElement MessageAfterAcceptingPromptBoxAlert;

}
