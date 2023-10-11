package testpack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.ProductPage;
import pages.ResultOfProduct;
import pages.SignUpPage;

public class BuyNowTestClass {
	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(8000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
//		SignUpPage _signUpPage = new SignUpPage(driver);	
//		_signUpPage.clickOnSignUpButton();
//		_signUpPage.enterMobileNumber("9922810367");
//		_signUpPage.enterPassword("amazon");

		
		HomePage _homePage = new HomePage(driver);
		_homePage.sendProductInSearchBox("shoes");
		
		ResultOfProduct _resultOfProduct = new ResultOfProduct(driver);
		_resultOfProduct.clickOnSelectedProduct();
		
		ProductPage _productPage =new ProductPage(driver);
		
		_productPage.clickOnBuyNowButton();
		
		Thread.sleep(2000);
		 SignUpPage _signUpPage = new SignUpPage(driver);	
//		_signUpPage.clickOnSignUpButton();
		_signUpPage.enterMobileNumber("9922810367");
		_signUpPage.enterPassword("amazon");
		
	}

}
