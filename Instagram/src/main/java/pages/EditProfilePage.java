package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditProfilePage {
	
	@FindBy (xpath="//input[@id='pepGender']")
	private WebElement genderFiled;
	
	@FindBy (xpath="(//input[@name='gender'])[3]")
	private WebElement optionFromGenderFiled;
	
	@FindBy (xpath="//button[text()='Done']")
	private WebElement doneButton;
	
	@FindBy (xpath="//div[@class='_aahg']")
	private WebElement checkBoxOfShowAccountSugestions;
	
	@FindBy (xpath="//div[@class='_ab47']")
	private WebElement submitButton;
	
	@FindBy (xpath="//span[text()='yash_kabbdi_5']")
	private WebElement profileName;
	
	private WebDriver driver;
	
	
	//Constructor
	public EditProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	
	//Methods
	public void clickOnGenderOption()
	{
		genderFiled.click();
	}
	
	public void selectOptionFromGenderFiled() throws InterruptedException
	{
		 boolean result=optionFromGenderFiled.isSelected();
	       System.out.println(result);
	       
	       if(result==true)
	       {
	    	   System.out.println("element is selected");
	       }
	       else
	       {
	    	   System.out.println("element is not selected");
	    	   Thread.sleep(2000);
	    	   optionFromGenderFiled.click();
	       }
	}
	
	public void clickOnDoneButton()
	{
		doneButton.click();
	}
	
	public void clcikOnCheckBoxOfShowAccountSugestions()
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
		 checkBoxOfShowAccountSugestions=wait.until(ExpectedConditions.elementToBeClickable(checkBoxOfShowAccountSugestions));
		 checkBoxOfShowAccountSugestions.click();
	}
	
	public void clickOnSubmitButton()
	{
		submitButton.click();
	}
	
	
	public String getProfileName()
	{
		 return profileName.getText();
		
	}
	
	
	
	

}
