package testpack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CustomerServicesPage;
import pages.HomePage;
import pages.ManageAddresses;
import pages.NewAddress;
import pages.SignUpPage;

public class AddNewAddressTestClass {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		SignUpPage _signUpPage = new SignUpPage(driver);
		
		_signUpPage.clickOnSignUpButton();
		_signUpPage.enterMobileNumber("9922810367");
		_signUpPage.enterPassword("amazon");
		
		 HomePage _homePage = new  HomePage(driver);
		 _homePage.clickOnAllAmazonSections();
		 _homePage.clickOnCustomerService();
		 
		 CustomerServicesPage _customerServicesPage = new CustomerServicesPage(driver);
		 _customerServicesPage.clickOnManageAddresses();
		 
		 ManageAddresses _manageAddresses = new ManageAddresses(driver);
		 _manageAddresses.clickOnAddAddress();
		 
		 NewAddress _newAddress = new NewAddress(driver);
	//	 _newAddress.clickOnAutofillButton();
		 _newAddress.clickOnCountryDropDown();
		 _newAddress.selectOptionfromCountryDropDown();
		 
		 _newAddress.enterFullName("Mauli");
    	 _newAddress.enterMobileNumber("7796282694");
    	 //Thread.sleep(2000);
		 _newAddress.enterPincode("411045");
		 _newAddress.enetrApartmentNAme("Shivam Residency");
		 _newAddress.enetrArea("Balewadi");
		 _newAddress.enetrTown("Pune");
		 _newAddress.clickOnStateDropDown();
		 _newAddress.selectOptionfromStateDropDown();
		 _newAddress.clickOnAddAddressButton();
		
		// _newAddress.clickOnAddAddressButton();
		 
		 
		 

}
}
