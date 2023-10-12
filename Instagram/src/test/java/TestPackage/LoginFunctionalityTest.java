package TestPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import module.NotificationPopUp;
import module.SaveInformationPopup;
import pages.LoginPage;

public class LoginFunctionalityTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		
		LoginPage _loginpage=new LoginPage(driver);
		
		 _loginpage. sendUserName("yash_kabbdi_5");
		 _loginpage.sendPassword("yashbalwadkar");
		 _loginpage.clickOnLoginButton();
		 
		 NotificationPopUp _notificationPopUp = new NotificationPopUp(driver);
		 _notificationPopUp.clickOnNotNowButton();
		 
		 SaveInformationPopup _saveInformationPopup = new SaveInformationPopup(driver);
		 _saveInformationPopup.clickOnNowButton();
		 
	}

}
