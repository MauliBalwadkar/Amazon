package TestNGPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
import pages.EditProfilePage;
import pages.HomePage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.ViewArchievePage;

public class VerifyProfilePageFunctionality extends BrowserLaunch {

	
	private WebDriver driver;
	private LoginPage _loginpage;
	private  NotificationPopUp _notificationPopUp;
	private SaveInformationPopup _saveInformationPopup;
	private  HomePage _homepage;
	private ProfilePage _profilepage;
	private  EditProfilePage _editProfilePage;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}
	
	
	
	@BeforeClass
	public void creatingPOMObject()
	{
		_loginpage=new LoginPage(driver);
		_notificationPopUp = new NotificationPopUp(driver);
		_saveInformationPopup = new SaveInformationPopup(driver);
		_homepage=new  HomePage(driver);
		_profilepage=new ProfilePage(driver);
		_editProfilePage= new EditProfilePage (driver);
		 _logOutPage = new LogOutPage(driver);
		
	}
	
	
	@BeforeMethod
	public void openProfilePage() throws InterruptedException
	{   
		Thread.sleep(5000);
		driver.get("https://www.instagram.com/");
		
		 _loginpage. sendUserName("yash_kabbdi_5");
		 _loginpage.sendPassword("yashbalwadkar");
		 _loginpage.clickOnLoginButton();
		 
		 _notificationPopUp.clickOnNotNowButton();
		 
	}


	@Test (priority=1, groups ={"high priority"})
	public void verifyEditProfileFunctionality() throws InterruptedException
	{

		 _saveInformationPopup.clickOnNowButton();
		 
		  _homepage.clickOnProfilePicture();
		  
		 String actualResult = _profilepage.getProfileName();
		
		  _profilepage.clickOnEditProfileButton();
		 
		  String expectedResult=_editProfilePage.getProfileName();
		 
		 Assert.assertEquals(actualResult, expectedResult);
		//Assert.assertNotEquals(actualResult,expectedResult,"profileName is same");  
			  _editProfilePage.clickOnGenderOption();
			  _editProfilePage.selectOptionFromGenderFiled();
			  _editProfilePage.clickOnDoneButton();
			  _editProfilePage.clcikOnCheckBoxOfShowAccountSugestions();
			  _editProfilePage.clickOnSubmitButton();
			  System.out.println("testcase pass");
		 		 
			 
		 
	}
	
	
	@Test (priority=2)
	public void verifyViewArchieveFunctionality()
	{   
         _homepage.clickOnProfilePicture();
		_profilepage.clickOnViewArchieveButton();
		 
//		 ViewArchievePage _viewArchievePage = new ViewArchievePage(driver);
//		 _viewArchievePage.clickOnArchieveStories();
//		 
//		 _viewArchievePage.clickOnCloseButton();
		 
	}
	
	
	@AfterMethod
	public void LogOutFromApllication()
	{
		_homepage.clickOnProfilePicture();
		
		driver.navigate().refresh();
	
	   _profilepage.clickOnsettingButton();
	 
		_logOutPage.clickOnLogoutButton();
	
	}
	
	
	
	@AfterClass
	public void clearObject()
	{
		_loginpage = null;
		_notificationPopUp = null;
		_saveInformationPopup = null;
		_homepage = null;
		_profilepage = null;
		_editProfilePage = null;
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
