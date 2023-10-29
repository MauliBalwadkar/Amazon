package TestNGTestPackage;


import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.BrowserLaunch;
import io.github.bonigarcia.wdm.WebDriverManager;
import module.RemoveAddressConfirmationPopUp;
import pages.CustomerServicesPage;
import pages.HomePage;
import pages.ManageAddresses;
import pages.NewAddress;

import pages.SignUpPage;
import util.Utility;


public class VerifyManageAddressFunctionality extends BrowserLaunch {
	
	private WebDriver driver;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	
	@Parameters("browser")
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
	
//	@BeforeClass
//	 public void creatingPomObject()
//	 {
//		
//	 }
	
	@BeforeMethod
	public void openProductpage() throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(5000);
		
         SignUpPage _signUpPage = new SignUpPage(driver);
		_signUpPage.clickOnSignUpButton();
		_signUpPage.enterMobileNumber(Utility.getDataFromExcellSheet("src\\test\\resources\\TestData\\amazon cart.xlsx","TestData",1, 0));
		_signUpPage.enterPassword(Utility.getDataFromExcellSheet("src\\test\\resources\\TestData\\amazon cart.xlsx","TestData",1, 1));
		
		 HomePage _homePage = new  HomePage(driver);
		 _homePage.clickOnAllAmazonSections();
		 _homePage.clickOnCustomerService();
		 
		 CustomerServicesPage _customerServicesPage = new CustomerServicesPage(driver);
		 _customerServicesPage.clickOnManageAddresses();
	}
	
	@Test(groups="High Priority")
	public void printStatement()
	{
		System.out.println("printTestCasePass");
		System.out.println("Hi");
		System.out.println("Hi");
	}
	
	@Test (priority=1,enabled=false)
	public void verifyAddAdressFunctionality() throws InterruptedException
	{
		 ManageAddresses _manageAddresses = new ManageAddresses(driver);
		 _manageAddresses.clickOnAddAddress();
		 
		 NewAddress _newAddress = new NewAddress(driver);
		 _newAddress.clickOnCountryDropDown();
		 _newAddress.selectOptionfromCountryDropDown();
		 _newAddress.enterFullName("Mauli");
		 _newAddress.enterMobileNumber("7796282694");
		 Thread.sleep(2000);
		 _newAddress.enterPincode("411045");
		 _newAddress.enetrApartmentNAme("Shivam Residency");
		 _newAddress.enetrArea("Balewadi");
		 _newAddress.enetrTown("Pune");
		 _newAddress.clickOnStateDropDown();
		 _newAddress.selectOptionfromStateDropDown();
		 Thread.sleep(2000);
		 _newAddress.clickOnAddAddressButton();
	}
	
	@Test (priority=2,enabled=false)
	public void verifyRemoveAddressFunctionality() throws InterruptedException
	{
		 ManageAddresses _manageAddresses = new ManageAddresses(driver);
		 _manageAddresses.clickOnRemoveAddressLink();

		 RemoveAddressConfirmationPopUp _removeAddressConfirmationPopUp = new RemoveAddressConfirmationPopUp(driver);
		 _removeAddressConfirmationPopUp.clickOnYesButton();
	
	}
	
	@AfterMethod
	public void signOut()
	{
		 HomePage _homePage = new  HomePage(driver);
		 _homePage.clickOnAllAmazonSections();
		 _homePage.clickOnSignOut();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
	
	
	

}
