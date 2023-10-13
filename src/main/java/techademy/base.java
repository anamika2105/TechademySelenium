package techademy;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public static WebDriver driver =null;
	public static Properties prop;
	
	public base() throws IOException{
		
		try {
			
			prop = new Properties();
			FileInputStream fis = new FileInputStream ("C:\\Users\\Administrator\\E2EProject\\resources\\data.properties");
			if(fis != null) {
				prop.load(fis);}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void initializeDriver() {
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webDriver.chrome.driver","D:\\Softwares\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));
		
	}
	
	public static void launchurl() {
		driver.get("http://webdriveruniversity.com/index.html");
	}
	
	public static void takeScreenshot(WebDriver webdriver,String fileWithPath) throws IOException {
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 File DestFile=new File(fileWithPath);
         FileUtils.copyFile(SrcFile, DestFile);

	}
}
