package module;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveAddressConfirmationPopUp {
	
	@FindBy (xpath="(//span[text()='Yes'])[3]")
	private WebElement yesButton;
	
	private WebDriver driver;
	//
	
	public RemoveAddressConfirmationPopUp(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	public void clickOnYesButton() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait (driver,Duration.ofSeconds(8));
		
		wait.until(ExpectedConditions.visibilityOf(yesButton));
		Thread.sleep(3000);
		 yesButton.click();
	}
	
}
