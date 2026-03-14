package BDDAlerts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.Utility.Library;
import com.pages.AlertsPOM;
import com.pages.GmoOnlinePOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertsBDD extends Library {
	Alert objAlert;

	@Given("User is on Alerts Page")
	public void user_is_on_alerts_page() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		ReadPropertiesFile();
		LaunchBrowser();
		driver.get(objProp.getProperty("AlertsURL"));
		PageLoadTimeOut(30);
	}

	@Then("I validate the title")
	public void validate_the_TitleForAlerts() {
		// Write code here that turns the phrase above into concrete actions
		String TitleOfAlertsPage = driver.getTitle();
		SoftAssert objSoftAssert = new SoftAssert();

		// Explicit Wait : Applicable for one webElement.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("Alerts"));

		objSoftAssert.assertEquals(TitleOfAlertsPage, "Alerts");
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		objAlertPOM.ConsentPopUp.click();
		objSoftAssert.assertAll();
	}

	@When("user click on alert with OK and cancel")
	public void user_click_on_alert_with_ok_and_cancel() {
		// Write code here that turns the phrase above into concrete actions
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		objAlertPOM.CancelTab.click();
	}

	@When("click the button to display a confirm box")
	public void click_the_button_to_display_a_confirm_box() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("inside ConformBoxAlert");
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		objAlertPOM.ConformBoxAlert.click();

	}

	@Then("Validate Alert PopUp Appears")
	public void validate_alert_pop_up_appears() {
		// Write code here that turns the phrase above into concrete actions
		objAlert = driver.switchTo().alert();

	}

	@Then("validate Text Of Confirm Box Alert")
	public void validate_text_of_confirm_box_alert() {
		// Write code here that turns the phrase above into concrete actions
		String text = objAlert.getText();
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		System.out.println("messageForOK:" + text);
		Assert.assertEquals(text, "Press a Button !");

	}

	@When("user perform click on OK button of confirm box alert")
	public void user_perform_click_on_ok_button_of_confirm_box_alert() {
		// Write code here that turns the phrase above into concrete actions
		objAlert.accept();
	}

	@Then("Validate You pressed OK is displayed")
	public void validate_you_pressed_ok_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		AlertsPOM objAlertPOM = new AlertsPOM(driver);
		String text= objAlertPOM.MessageAfterAcceptingConformBoxAlert.getText();
		Assert.assertEquals(text, "You pressed Ok");
	}

}
