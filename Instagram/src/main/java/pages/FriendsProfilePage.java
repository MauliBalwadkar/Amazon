package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FriendsProfilePage {
	
	@FindBy (xpath="//span[text()='Posts']")
	private WebElement postSection;
	
	@FindBy (xpath="(//div[@class='_aabd _aa8k  _al3l'])[1]")
	private WebElement friendPost;
	
	@FindBy (xpath="//div[@class='x160vmok x10l6tqk x1eu8d0j x1vjfegm']")
	private WebElement closeThePost;
	
	@FindBy (xpath="//span[text()='Tagged']")
	private WebElement tagSection;
	
	@FindBy (xpath="(//div[@class='_aagw'])[2]")
	private WebElement tagPost;
	
	@FindBy(xpath="//div[@class='x160vmok x10l6tqk x1eu8d0j x1vjfegm']")
	private WebElement closeTheTagPost;
	
	private WebDriver driver;
	
	//
	public FriendsProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	//
	
	public void clickOnPostSection()
	{
		postSection.click();
	}
	
	public void clickOnFriendPost()
	{
		friendPost.click();
	}
	
	public void ClickTheCrossButtonOnPost()
	{
		closeThePost.click();
	}
	
	public void selectTagSection()
	{
		tagSection.click();
	}
	public void selectTagPost() throws InterruptedException
	{
		tagPost.click();
		Thread.sleep(2000);
	}
	public void clickOncloseTheTagPost()
	{
		closeTheTagPost.click();
	}
	
	

}
