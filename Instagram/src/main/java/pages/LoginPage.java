package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy (xpath="//input[@name='username']")
	private WebElement userName;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy (xpath="//div[text()='Log in']")
	private WebElement loginButton;
	
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public void sendUserName(String user)
	{
		userName.sendKeys(user);
	}
	
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
}
