package TestPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import module.NotificationPopUp;
import module.SaveInformationPopup;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.ViewArchievePage;

public class ViewArchieveTestClass {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
		driver.manage().window().maximize();
		
		LoginPage _loginpage=new LoginPage(driver);
		
		 _loginpage. sendUserName("yash_kabbdi_5");
		 _loginpage.sendPassword("yashbalwadkar");
		 _loginpage.clickOnLoginButton();
		 
		 NotificationPopUp _notificationPopUp = new NotificationPopUp(driver);
		 _notificationPopUp.clickOnNotNowButton();
		 
		 SaveInformationPopup _saveInformationPopup = new SaveInformationPopup(driver);
		 _saveInformationPopup.clickOnNowButton();
		 
		 
		 
		 HomePage _homepage=new  HomePage(driver);
		  
		 _homepage.clickOnProfilePicture();
		 
		 ProfilePage _profilepage=new ProfilePage(driver);
		 
		 _profilepage.clickOnViewArchieveButton();
		 
		 ViewArchievePage _viewArchievePage = new ViewArchievePage(driver);
		 _viewArchievePage.clickOnArchieveStories();
		 
		
		
	}

}
