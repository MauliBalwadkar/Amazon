package testpack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.SignUpPage;

public class VerifyCartAndBuyNow {
	
	private WebDriver driver;
	
	@BeforeClass
	public void launchBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
	}

	
	@BeforeMethod
	public void VerifyProductFunctionality()
	{
		driver.get("https://www.amazon.in/");
		
		SignUpPage _signUpPage = new SignUpPage(driver);
		_signUpPage.clickOnSignUpButton();
		_signUpPage.enterMobileNumber("9922810367");
		_signUpPage.enterPassword("amazon");
		
		
	}
	
	
	@Test
	public void test()
	{
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("afterMethod");
	}
	
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("after class");
	}

	
}
