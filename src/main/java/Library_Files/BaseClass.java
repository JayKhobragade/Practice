package Library_Files;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	
	
	public void InitializeBrowser() 
	{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\tina\\eclipse-workspace\\Maven_1Oct\\Browser Folder\\chromedriver.exe");
			driver=new ChromeDriver();
		
		
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		
		driver.manage().window().maximize();	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
}
}
