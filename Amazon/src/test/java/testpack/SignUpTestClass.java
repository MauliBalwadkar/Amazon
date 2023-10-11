package testpack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SignUpPage;

public class SignUpTestClass {
	
		public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		SignUpPage _signUpPage = new SignUpPage(driver);
		
		_signUpPage.clickOnSignUpButton();
		_signUpPage.enterMobileNumber("9922810367");
		_signUpPage.enterPassword("amazon");
		
	}

}
