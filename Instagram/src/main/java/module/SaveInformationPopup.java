package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveInformationPopup {
	
	@FindBy (xpath="//button[@class='_a9-- _a9_1']")
	private WebElement notNowButton;
	
	//Constructor
	public SaveInformationPopup(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public void clickOnNowButton() throws InterruptedException
	{
		Thread.sleep(4000);
		notNowButton.click();
	}
	

}
//div[text()='Not now']
//button[@class='_a9-- _a9_1']