package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	
	@FindBy (xpath="//button[text()='Log out']")
	private WebElement logoutButton;
	
	private WebDriver driver;
	
	
	public LogOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void clickOnLogoutButton()
	{
		logoutButton.click();
	}

}
