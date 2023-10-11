package testpack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.ProductPage;
import pages.ResultOfProduct;
import pages.ShoppingCartPage;
import pages.SignUpPage;

public class AddToCartTestClass {
	
	public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	
//	SignUpPage _signUpPage = new SignUpPage(driver);
//	
//	_signUpPage.clickOnSignUpButton();
//	_signUpPage.enterMobileNumber("9922810367");
//	_signUpPage.enterPassword("amazon");
//	
//	Thread.sleep(6000);
	
	HomePage _homePage = new HomePage(driver);
	_homePage.sendProductInSearchBox("shoes");
	
	ResultOfProduct _resultOfProduct = new ResultOfProduct(driver);
	_resultOfProduct.clickOnSelectedProduct();
	
	ProductPage _productPage = new ProductPage(driver);
	_productPage.clickOnCartButton();
	
	ShoppingCartPage _shoppingCartPage = new ShoppingCartPage(driver);
	_shoppingCartPage.clickOnGoToCartButton();
	_shoppingCartPage.selectQuantityOfProductButton();
	_shoppingCartPage.selectTwoQuantityOfProduct();
	_shoppingCartPage.clickOnProceedToBuyButton();
	
	
	

}
}
