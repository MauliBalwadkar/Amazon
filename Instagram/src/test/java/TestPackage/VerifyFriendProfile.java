package TestPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import module.NotificationPopUp;
import module.SaveInformationPopup;
import pages.FriendsProfilePage;
import pages.HomePage;
import pages.LoginPage;

public class VerifyFriendProfile {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		
		LoginPage _loginpage=new LoginPage(driver);
		
		 _loginpage. sendUserName("yash_kabbdi_5");
		 _loginpage.sendPassword("yashbalwadkar");
		 _loginpage.clickOnLoginButton();
		 
		 NotificationPopUp _notificationPopUp = new NotificationPopUp(driver);
		 _notificationPopUp.clickOnNotNowButton();
		 
		 SaveInformationPopup _saveInformationPopup = new SaveInformationPopup(driver);
		 _saveInformationPopup.clickOnNowButton();
		 
		 Thread.sleep(3000);
		
		HomePage _homepage=new  HomePage(driver);
		
		_homepage.clickOnSearchBox();
		_homepage.clickOnSearchUser();
		_homepage.clickOnUser();
		
		FriendsProfilePage _friendsProfilePage = new FriendsProfilePage(driver);
		_friendsProfilePage.clickOnPostSection();
		_friendsProfilePage.clickOnFriendPost();
		Thread.sleep(2000);
		_friendsProfilePage.ClickTheCrossButtonOnPost();
		
		_friendsProfilePage.selectTagSection();
		Thread.sleep(2000);
		_friendsProfilePage.selectTagPost();
		_friendsProfilePage.clickOncloseTheTagPost();
		
	}

}
