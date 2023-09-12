package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest3 {
	public final String d_browser="chrome";
	public final String d_appurl="http://www.google.com";	
	public final String d_ito="10";
	public final String d_eto="10";
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Parameters({"browser","appurl","ito","eto"})
	@BeforeMethod
	public void preCondition(
			@Optional(d_browser) String browser,
			@Optional(d_appurl) String appurl,
			@Optional(d_ito) String ito,
			@Optional(d_eto) String eto)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		driver.get(appurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ito)));
		wait=new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(eto)));		
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.quit();
	}
}

