package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAddress {
	@FindBy (xpath="(//span[@class='a-button-text a-declarative'])[1]")
	private WebElement countryDropDown;
	
	@FindBy (xpath="//ul[@tabindex='-1']//li//a[text()='India']")
	private WebElement optionfromCountryDropDown;
	
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressFullName']")
	private WebElement fullName;
	
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	private WebElement mobileNumber;
	
	@FindBy (xpath="(//div[@class='a-section a-spacing-base adddress-ui-widgets-form-field-container'])[4]")
	private WebElement pincode;
	
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressLine1']")
	private WebElement apartmentName;
	
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressLine2']")
	private WebElement area;
	
	@FindBy (xpath="//input[@id='address-ui-widgets-enterAddressCity']")
	private WebElement town;
	
	@FindBy (xpath="(//span[@class='a-button-text a-declarative'])[2]")
	private WebElement stateDropDown;
	
	@FindBy (xpath="//a[text()='MAHARASHTRA']")
	private WebElement optionfromStateDropDown;
	
	@FindBy (xpath="//span[@id='address-ui-widgets-form-submit-button']")
	private WebElement addAddress;
	
	@FindBy (xpath="//button[@id='address-ui-widgets-DetectLocationButton-announce']")
	private WebElement autofillButton;
	
	
	private WebDriver driver;
	
	//Constructor
	public NewAddress(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methos
	
	public void clickOnCountryDropDown()
	{
		countryDropDown.click();
	}
	
	public void selectOptionfromCountryDropDown()
	{
		optionfromCountryDropDown.click();
	}
	
	public void enterFullName(String fName)
	{
		fullName.sendKeys(fName);
	}
	
	public void enterMobileNumber(String mobileNo)
	{
//		Actions action = new Actions(driver);
//		action.click(mobileNumber).sendKeys(mobileNo);
		mobileNumber.sendKeys(mobileNo);
		mobileNumber.sendKeys(Keys.TAB);
	}
	
	public void enterPincode(String citycode) throws InterruptedException
	{
		//Actions action = new Actions(driver);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOf(pincode));
		//pincode.clear();
		//Thread.sleep(1000);
		//action.click(pincode).sendKeys(cityCode);
		
		//pincode.sendKeys(citycode);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].sendKeys(citycode)",pincode);
		js.executeScript("arguments[0].setAttribute('value', '" + citycode +"')", pincode);
		
	}
	
	public void enetrApartmentNAme(String apartment)
	{
		apartmentName.sendKeys(apartment);
	}
	
	public void enetrArea(String village)
	{
		area.sendKeys(village);
	}
	
	public void enetrTown(String townname)
	{
		town.sendKeys(townname);
	}
	
	public void clickOnStateDropDown()
	{
		stateDropDown.click();
	}
	
	public void selectOptionfromStateDropDown()
	{
		optionfromStateDropDown.click();
	}
	
	public void clickOnAddAddressButton()
	{
		addAddress.click();
	}
	
  public void clickOnAutofillButton()
  {
	  autofillButton.click();
  }

}
