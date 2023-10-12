package TestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import module.NotificationPopUp;
import module.SaveInformationPopup;
import pages.EditProfilePage;
import pages.HomePage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ProfilePage;

public class Testclass {
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
		 
		 _profilepage.clickOnEditProfileButton();
		 
		 EditProfilePage _editProfilePage= new EditProfilePage (driver);
		 
		 _editProfilePage.clickOnGenderOption();
		 _editProfilePage.selectOptionFromGenderFiled();
		 _editProfilePage.clickOnDoneButton();
		
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
		 
		  WebElement checkBoxOfShowAccountSugestions=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_aahg']")));
		 
		 _editProfilePage.clcikOnCheckBoxOfShowAccountSugestions();
		 _editProfilePage.clickOnSubmitButton();
		 
		 
//		 LogOutPage _logout = new  LogOutPage(driver);
//		 
//		 _logout.clickOnLogoutButton();
		
		 HomePage _homepage1=new  HomePage(driver);
		       //Thread.sleep(8000);
		 _homepage1.clickOnProfilePicture();
		
		 ProfilePage _profilePage1 = new ProfilePage(driver);
		 _profilePage1.clickOnsettingButton();
		 
		 LogOutPage _logOutPage = new LogOutPage(driver);
		 _logOutPage.clickOnLogoutButton();
		
	}

}
