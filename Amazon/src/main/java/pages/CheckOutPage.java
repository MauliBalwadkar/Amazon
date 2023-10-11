package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	
	@FindBy (xpath="(//input[@type='radio'])[1]")
	private WebElement addressRadioButton;
	
	
	@FindBy(xpath="//input[@aria-labelledby='shipToThisAddressButton-announce']")
	private WebElement useThisAddressButton;
			
	
					//constructor
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
					//methods
	
	public void selectAddressRadioButton()
	{
		boolean result=addressRadioButton.isSelected();
		
		System.out.println(result);
		
		if(result==true)
		{
			System.out.println("element is selected");
			
		}
		else
		{
			addressRadioButton.click();
		}
	}
	
		public void clickOnUseThisAddressButton()
		{
			 useThisAddressButton.click();
		}
	

}
