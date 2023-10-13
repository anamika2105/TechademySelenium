package stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import techademy.ajaxLoaderPage;
import techademy.base;

public class stepDefination_AjaxLoaderPopUp extends base{
	
	ajaxLoaderPage ajaxPageObj = new ajaxLoaderPage(driver);
	
	public stepDefination_AjaxLoaderPopUp() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Given("AJAX LOADER page")
	public void ajax_loader_page() {
		//ajaxPageObj.verifyAjaxPageisOpened();
	}
	
	@When("I click the {string} button")
	public void i_click_the_button(String string) throws InterruptedException {
		ajaxPageObj.clickOnClickMeBtn();
	}
	
	@Then("pop should display")
	public void pop_should_display() throws InterruptedException, IOException {
		ajaxPageObj.verifyPopUpisDispalyed();
		takeScreenshot(driver, "C:\\Users\\Administrator\\E2EProject\\test-output\\screenshots");
	}
	
	@And("bowser should close")
	public void bowser_should_close() {
		ajaxPageObj.teardDown();
	}


}
