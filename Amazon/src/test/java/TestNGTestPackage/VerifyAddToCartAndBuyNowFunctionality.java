package TestNGTestPackage;

import java.io.IOException;
import java.lang.foreign.Linker.Option;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.BrowserLaunch;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.ProductPage;
import pages.ResultOfProduct;
import pages.ShoppingCartPage;
import pages.SignUpPage;
import util.Utility;

public class VerifyAddToCartAndBuyNowFunctionality extends BrowserLaunch {
	
	private WebDriver driver;
	private HomePage _homePage;
	private ResultOfProduct _resultOfProduct;
	private  ProductPage _productPage;
	private ShoppingCartPage _shoppingCartPage;
	private  SignUpPage _signUpPage;
	private String testID;
	
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		
		
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		
		if(browserName.equals("chrome"))
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
	 public void creatingPOMObject()
	 {
		_homePage = new HomePage(driver);
		_resultOfProduct = new ResultOfProduct(driver);
		_productPage = new ProductPage(driver);
		_shoppingCartPage = new ShoppingCartPage(driver);
		_signUpPage = new SignUpPage(driver);
	 }
	
	@BeforeMethod
	public void openProductpage()
	{
		driver.get("https://www.amazon.in/");
		
		_homePage.sendProductInSearchBox("shoes");
		_resultOfProduct.clickOnSelectedProduct();
		
	}
	
	@Test (groups="High Priority", priority =1,enabled=false)
	public void verifyAddToCartFunctionality()
	{
	 	testID="T101";
		String actualResult= _productPage.getProductName();
		System.out.println(actualResult);
		
	   _productPage.clickOnCartButton();
	  
		_shoppingCartPage.clickOnGoToCartButton();
		
		
		String expectedResult=_shoppingCartPage.getCartProductName();
		System.out.println(expectedResult);
		    
		 boolean result=expectedResult.contains(actualResult);
		 System.out.println(result);
		 
	    //Assert.assertTrue(result,"product name not matches");
	 	//Assert.assertFalse(result, "product name not matches");
		 
	   SoftAssert softAssert = new SoftAssert();
	 //  softAssert.assertTrue(expectedResult.contains(actualResult));
	   softAssert.assertFalse(result);
	 
		_shoppingCartPage.selectQuantityOfProductButton();
		_shoppingCartPage.selectTwoQuantityOfProduct();
		_shoppingCartPage.clickOnProceedToBuyButton();
		
		softAssert.assertAll();
		system.out.println("hi");
		system.out.println("hello");
		
	}
	
	
	@Test (priority = 2)
	public void verifyBuyNowFunctionality() throws InterruptedException, EncryptedDocumentException, IOException
	{
	 	testID="T102";
	 
		_productPage.clickOnBuyNowButton();
		Thread.sleep(3000); 
		 SignUpPage _signUpPage = new SignUpPage(driver);	
	    _signUpPage.enterMobileNumber( Utility.getDataFromExcellSheet("src\\test\\resources\\TestData\\amazon cart.xlsx","TestData",1, 5));
		_signUpPage.enterPassword(Utility.getDataFromExcellSheet("src\\test\\resources\\TestData\\amazon cart.xlsx","TestData",1, 1));
		
		
	}
	
	@AfterMethod
	public void logOutFromApplication(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			String testID=result.getName();
			Utility.captureScreenshot(driver, testID);
		}
	}
	
	@AfterClass
	public void closeObject()
	{
		_homePage= null;
		_resultOfProduct = null;
		_productPage = null;
		_shoppingCartPage = null;
		_signUpPage = null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();  //garbageCollection
	}
	
	
}
