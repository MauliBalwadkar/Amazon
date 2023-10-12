package TestNGPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.BrowserLaunch;
import io.github.bonigarcia.wdm.WebDriverManager;
import module.NotificationPopUp;
import module.SaveInformationPopup;
import pages.FriendsProfilePage;
import pages.HomePage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ProfilePage;

public class VerifySearchOptionFunctionality extends BrowserLaunch {
	
	private WebDriver driver;
	private LoginPage _loginpage;
	private  NotificationPopUp _notificationPopUp;
	private SaveInformationPopup _saveInformationPopup;
	private HomePage _homepage;
	private FriendsProfilePage _friendsProfilePage;
	private ProfilePage _profilePage1;
	private LogOutPage _logOutPage;
	
	@Parameters ("browser")
	
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver=launchChrome();
		}	
		if(browserName.equals("Edge"))
		{
			driver=launchEdge();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@BeforeClass
	public void createPOMObject()
	{
		_loginpage=new LoginPage(driver);
		_notificationPopUp = new NotificationPopUp(driver);
		_saveInformationPopup = new SaveInformationPopup(driver);
		_homepage=new  HomePage(driver);
		_friendsProfilePage = new FriendsProfilePage(driver);
		 _profilePage1 = new ProfilePage(driver);
		 _logOutPage = new LogOutPage(driver);
	}
	
	
	@BeforeMethod
	public void SearchFriendFunctionality() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.get("https://www.instagram.com/");
		
		 _loginpage. sendUserName("yash_kabbdi_5");
		 _loginpage.sendPassword("yashbalwadkar");
		 _loginpage.clickOnLoginButton();
		 
		 _notificationPopUp.clickOnNotNowButton();
//		 SaveInformationPopup _saveInformationPopup = new SaveInformationPopup(driver);
//		 _saveInformationPopup.clickOnNowButton();
//		 
//		 Thread.sleep(5000);
//		
//		HomePage _homepage=new  HomePage(driver);
//		
//		_homepage.clickOnSearchBox();
//		_homepage.clickOnSearchUser();
//		_homepage.clickOnUser();
	}
	
	@Test (priority=1 ,groups = {"high priority"} )
	public void verifyFriendPostFunctionality() throws InterruptedException
	{
		
		 _saveInformationPopup.clickOnNowButton();
		 
		 Thread.sleep(5000);
		
		_homepage.clickOnSearchBox();
		_homepage.clickOnSearchUser();
		_homepage.clickOnUser();
		
		_friendsProfilePage.clickOnPostSection();
		_friendsProfilePage.clickOnFriendPost();
		Thread.sleep(2000);
		_friendsProfilePage.ClickTheCrossButtonOnPost();
	}
	
	@Test(priority=2)
	public void verifyFriendsTagPostFunctionality() throws InterruptedException
	{
		
		_homepage.clickOnSearchBox();
		_homepage.clickOnSearchUser();
		_homepage.clickOnUser();
		
		_friendsProfilePage.selectTagSection();
	//	Thread.sleep(2000);
		_friendsProfilePage.selectTagPost();
		_friendsProfilePage.clickOncloseTheTagPost();
	}
	
	@AfterMethod
	public void logOutFromApplication() throws InterruptedException
	{
		Thread.sleep(3000);
		_homepage.clickOnProfilePicture();
		
	//	driver.navigate().refresh();
	
		_profilePage1.clickOnsettingButton();
	 
		_logOutPage.clickOnLogoutButton();	
	}
	
	@AfterClass
	public void clearObject()
	{
		_loginpage = null;
		_notificationPopUp = null;
		_saveInformationPopup = null;
		_homepage = null;
		_friendsProfilePage = null;
		 _profilePage1 = null;
		 _logOutPage = null;
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();
	}
	

}
