package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	@FindBy (xpath="//a[@data-csa-c-type='button']")
	private WebElement goToCartButton;
	
	@FindBy (xpath="//span[@data-action='a-dropdown-button']")
	private WebElement QuantityOfProductButton;
	
	@FindBy (xpath="//a[@id='quantity_2']")
	private WebElement twoQuantity;
	
	
	@FindBy (xpath="//input[@value='Proceed to checkout']")
	private WebElement proceedToBuyButton;
	
	@FindBy (xpath="//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-base']//li[1]")
	private WebElement cartProductName;
	//constructor
	
	public  ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//method
	public void clickOnGoToCartButton()
	{
		goToCartButton.click();
	}
	
	public void selectQuantityOfProductButton()
	{
		QuantityOfProductButton.click();
	}
	
	public void selectTwoQuantityOfProduct()
	{
		twoQuantity.click();
	}
	
	public void clickOnProceedToBuyButton()
	{
		 proceedToBuyButton.click();
	}
	
	public String getCartProductName()
	{
		return cartProductName.getText();
	}
	
	
	

}
