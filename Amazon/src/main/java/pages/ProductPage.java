package pages;


	
	import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class ProductPage {

		@FindBy(xpath="//span[@id='submit.add-to-cart']")
		private WebElement addToCartButton;
		
		@FindBy (xpath="//span[@id='submit.buy-now']")
		private WebElement buyNowButton;
		
		@FindBy (xpath="//span[@id='productTitle']")
		private WebElement productName;
		
		private WebDriver driver;

		// constructor
		public ProductPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			this.driver=driver;
		}

		//method
		
		public String getProductName()
		{
			return productName.getText();
		}
		
		
		public void clickOnCartButton()
		{
			addToCartButton.click();
		}
		
		public void clickOnBuyNowButton() {
			
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)",addToCartButton);
				
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(buyNowButton));
//			JavascriptExecutor _javaScriptExecutor = (JavascriptExecutor)driver;
//			_javaScriptExecutor.executeScript("arguments[0].click()", buyNowButton);
			
			 buyNowButton.click();
		}
	}



