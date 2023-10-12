package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	@FindBy (xpath="//img[@crossorigin='anonymous']")
	private WebElement profilePicture;
	
	@FindBy (xpath="(//div[@class=\"x1n2onr6 x6s0dn4 x78zum5\"])[12]")
	private WebElement moreOptions;
	
	@FindBy(xpath="//span[text()='Log out']")
	private WebElement logOut;
	
	@FindBy (xpath="//input[@value='Log in']")
	private WebElement login;
	
	@FindBy (xpath="(//a[@role='link'])[3]")
	private WebElement searchBox;
	
	@FindBy (xpath="//input[@aria-label='Search input']")
	private WebElement searchUser;
	
	@FindBy (xpath="//span[text()='mauli_balwadkar']")
	private WebElement user;
	
	private WebDriver driver;
	
	//Constructor
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	//Methods
	public void clickOnProfilePicture()
	{
		profilePicture.click();
	}
	
	public void clickOnMoreOptionButton()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(moreOptions));
		 moreOptions.click();
		
	}
	
	public void clickOnSearchBox()
	{
		JavascriptExecutor _javascriptExecutor = (JavascriptExecutor)driver;
		_javascriptExecutor.executeScript("arguments[0].click()", searchBox);
		//searchBox.click();
	}
	
	public void clickOnSearchUser()
	{
		
		searchUser.sendKeys("mauli");
	}
	
	public void clickOnUser()
	{
		user.click();
	}
	public void clickOnLogInPopUp()
	{
		login.click();
	}
	public void clickOnLogOutButton()
	{
		logOut.click();
	}
	
	

}
