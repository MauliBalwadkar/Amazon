package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	@FindBy (xpath="//span[text()='Hello, sign in']")
	private WebElement signUpButton;
	
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password ;
	
	
			//constructor
	
	public SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
				//method
	
	public void clickOnSignUpButton()
	{
		signUpButton.click();
	}
	
	
	public void enterMobileNumber(String number)   
	{
		mobileNumber.sendKeys(number);
	    mobileNumber.sendKeys(Keys.ENTER);
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
		password.sendKeys(Keys.ENTER);
	}
	
	
	
	
	
}
