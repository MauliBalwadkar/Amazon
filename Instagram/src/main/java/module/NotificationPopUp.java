package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPopUp {
	
	@FindBy (xpath="//div[text()='Not now']")
	private WebElement notNowButton;
	
	//Constructor
	public NotificationPopUp(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Methods
	public void clickOnNotNowButton()
	{
		notNowButton.click();
	}

}
////button[@class='_a9-- _a9_1']