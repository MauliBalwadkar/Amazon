package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultOfProduct {

	@FindBy (xpath="(//div[contains(@class,'_bGlmZ_itemImage_2uzWz')])[1]")
	private WebElement selectedProduct;
	
	@FindBy
	
	private WebDriver driver;
	
	
	public ResultOfProduct(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

   //
	public void clickOnSelectedProduct()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(selectedProduct));
		selectedProduct.click();
	}





}
