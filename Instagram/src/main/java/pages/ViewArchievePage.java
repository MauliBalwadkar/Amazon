package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewArchievePage {
	
	
	@FindBy (xpath="(//div[@aria-disabled='false'])[1]")
	private WebElement archieveStories;
	
	@FindBy (xpath="(//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k'])[4]")
	private WebElement closeButton;
	
	private WebDriver driver;
	
	
	public ViewArchievePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	public void clickOnArchieveStories()
	{
		archieveStories.click();
	}
	
	public void clickOnCloseButton()
	{
		closeButton.click();
	}
	
	
}
