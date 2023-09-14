package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class EnterTimeTrackPage 
{
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public EnterTimeTrackPage(WebDriver  driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickLogoutLink()
	{
		logoutLink.click();
	}
	
	public boolean verifyLogoutIsDisplayed(WebDriverWait wait)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(logoutLink));
			Reporter.log("Home Page is displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			Reporter.log("Home Page is NOT displayed",true);
			return false;
		}
	}
}
