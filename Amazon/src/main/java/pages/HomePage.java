package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	@FindBy(xpath="//input[@aria-label='Search Amazon.in']")
	private WebElement searchBox;
	
	@FindBy (xpath="//a[@id='nav-hamburger-menu']")
	private WebElement allAmazonSections;
	
	@FindBy (xpath="//ul[@class='hmenu hmenu-visible']//li//a[text()='Customer Service']")
	private WebElement customerService;
	
	@FindBy (xpath="//ul[@class='hmenu hmenu-visible']//li//a[text()='Sign Out']")
	private WebElement signOut;
	
	private WebDriver driver;
	
	//constructor
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	
	//methods
	
	public void sendProductInSearchBox(String product)
	{
		searchBox.sendKeys(product);
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public void clickOnAllAmazonSections()
	{
		allAmazonSections.click();
	}
	
	public void clickOnCustomerService()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(customerService));
		customerService.click();
	}
	
	public void clickOnSignOut()
	{
		 signOut.click();
	}
	

}
