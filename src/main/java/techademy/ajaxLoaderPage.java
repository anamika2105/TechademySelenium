package techademy;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ajaxLoaderPage extends base {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ajaxLoaderPage(WebDriver driver) throws IOException {
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath="//a[@id='ajax-loader']/div/div/h1[text()='AJAX LOADER']")
	WebElement ajaxLoader;
	
	@Before
	public void setup() {
		
		initializeDriver();
	}
	public void verifyAjaxloaderLink() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		 js.executeScript("window.scrollBy(0,-800)"); //vertical scroll
		Assert.assertTrue(driver.findElement(By.xpath("//a[@id='ajax-loader']/div/div/h1[text()='AJAX LOADER']")).isDisplayed(), "AJAX LOADER link is present");
	}
	
    public void openAjaxLoaderPage() throws InterruptedException {
    	
    	driver.findElement(By.xpath("//a[@id='ajax-loader']/div/div/h1[text()='AJAX LOADER']")).click();
    	 Set<String> windows = driver.getWindowHandles();
    	 Iterator<String> it = windows.iterator();
    	 String parentWindow = it.next();
    	 String childWindow = it.next();
    	 driver.switchTo().window(childWindow);
         Thread.sleep(10000);
     
    }

    public void verifyAjaxPageisOpened() {
    	
    	String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "WebDriver | Ajax-Loader");
    }
    
    public void clickOnClickMeBtn() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//div[@id='myDiv']/span/p[text()='CLICK ME!']")));
    	//Thread.sleep(10000);
    	driver.findElement(By.xpath("//div[@id='myDiv']/span/p[text()='CLICK ME!']")).click();
    	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    
    public void verifyPopUpisDispalyed() throws InterruptedException {
    	Thread.sleep(10000);
    	WebElement popup = driver.findElement(By.xpath("//div[@class='modal-header']/h4[text()='Well Done For Waiting....!!!']"));
    	Assert.assertTrue(popup.isDisplayed());
    }
    
    @After
    public void teardDown() {
    	driver.quit();
    }
}

