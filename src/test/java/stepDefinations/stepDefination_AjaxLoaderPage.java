package stepDefinations;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import techademy.ajaxLoaderPage;
import techademy.base;

public class stepDefination_AjaxLoaderPage extends base{
	
	ajaxLoaderPage ajaxPageObj = new ajaxLoaderPage(driver);
	
	public stepDefination_AjaxLoaderPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Given("launch the URL {string}")
	public void launch_the_url(String string) {
		//initializeDriver();
		ajaxPageObj.setup();
		launchurl();
	}
	
	@And("verify that AJAX LOADER link is present")
	public void verify_that_ajax_loader_link_is_present() throws InterruptedException {
		ajaxPageObj.verifyAjaxloaderLink();
	  
	}
	@When("I click on the AJAX LOADER link")
	public void i_click_on_the_ajax_loader_link() throws InterruptedException {
		ajaxPageObj.openAjaxLoaderPage();
	}
	@Then("AJAX LOADER page should open")
	public void ajax_loader_page_should_open() throws IOException {
		ajaxPageObj.verifyAjaxPageisOpened();
		takeScreenshot(driver, "C:\\Users\\Administrator\\E2EProject\\test-output\\screenshots");
	}

}
