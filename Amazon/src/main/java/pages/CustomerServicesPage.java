package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerServicesPage {
	
	@FindBy (xpath="(//div[@class='a-box-inner'])[3]")
	private WebElement manageAddresses;
	
//	@FindBy (xpath="")
//	private WebElement 
	
	private WebDriver driver;
	
	//Constructor
	public CustomerServicesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//Methods
	
	public void clickOnManageAddresses()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(manageAddresses));
		manageAddresses.click();
	}


}
