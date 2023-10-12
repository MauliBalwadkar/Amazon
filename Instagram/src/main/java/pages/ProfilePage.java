package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	
	@FindBy (xpath="//a[text()='Edit Profile']")
	private WebElement editProfileButton;
	
	@FindBy(xpath="//a[text()='View archive']")
	private WebElement viewArchieveButton;
	
	@FindBy (xpath="//div[@class='x1q0g3np x2lah0s x8j4wrb']")
	private WebElement settingButton;
	
	@FindBy (xpath="//h2[text()='yash_kabbdi_5']")
	private WebElement profileName;
	
	private WebDriver driver;
	
	//constructor
	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	//Methods
	public void clickOnEditProfileButton()
	{
		editProfileButton.click();
	}
	
	

	public void clickOnViewArchieveButton()
	{
		viewArchieveButton.click();
	}
	
	public void clickOnsettingButton()
	{   driver.navigate().refresh();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(settingButton));
		settingButton.click();
	}
	
	public String getProfileName()
	{
		 return profileName.getText();
	}
	
	
	
}
