package automation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import techademy.ajaxLoaderPage;
import techademy.base;

public class TestApplication extends base{
	
	//public static WebDriver driver =null;
	static ajaxLoaderPage ajaxPageObj;
	public TestApplication() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public static void IntializeDriver() throws IOException {
		initializeDriver();
		ajaxPageObj = new ajaxLoaderPage(driver);
	}
	
	@Test (threadPoolSize = 5, invocationCount = 10)
	public static void verifyAjaxLoader() throws InterruptedException, IOException {
		launchurl();
		ajaxPageObj.verifyAjaxloaderLink();
		ajaxPageObj.openAjaxLoaderPage();
		ajaxPageObj.verifyAjaxPageisOpened();
		ajaxPageObj.verifyAjaxPageisOpened();
		takeScreenshot(driver, "D:\\Screenshots\\screenshot.png");
	}
	
	@Test ()
	public static void verifypupUp() throws InterruptedException, IOException {
		verifyAjaxLoader();
		ajaxPageObj.clickOnClickMeBtn();
		ajaxPageObj.verifyPopUpisDispalyed();
		takeScreenshot(driver, "D:\\Screenshots\\screenshot.png");
	}
	
	@AfterMethod
	public static void closeBrowser() {
		ajaxPageObj.teardDown();
		
	}
	

}
