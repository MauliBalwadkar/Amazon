package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageAddresses {
	
	@FindBy (xpath="//div[@id='ya-myab-plus-address-icon']")
	private WebElement addAddress;
	
	@FindBy (xpath="(//a[text()='Remove'])[2]")
	private WebElement removeAddressLink;
	
	@FindBy (xpath="//ul[@class='a-unordered-list a-nostyle a-vertical']//li//span[@id='address-ui-widgets-PhoneNumber']")
	private List<WebElement> listOfAddress;
	
	private WebDriver driver;
	
	//Constructor
	public ManageAddresses(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//Method
	public void clickOnAddAddress()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(addAddress));
		addAddress.click();
	}
	
	public void clickOnRemoveAddressLink()
	{
		for(int i=0;i<listOfAddress.size();i++)
		{
			String result=listOfAddress.get(i).getText();
			System.out.println(result);
			
			if(result.contains("7796282694"))
			{
				removeAddressLink.click();
				break;
			}
			
		}
		
		
		
		
	}
	
	

	
}
