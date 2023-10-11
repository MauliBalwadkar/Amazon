package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	
	public static WebDriver driver;

	public static String getDataFromExcellSheet(String filepath,String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		String data="";
		
		FileInputStream file = new FileInputStream(filepath);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet	=workbook.getSheet(sheetName);
		Row rowData = sheet.getRow(row);
		Cell cellData = rowData.getCell(cell);
		
		try
		{
			  data = cellData.getStringCellValue();
			 
		}
	   catch(IllegalStateException s)
		{
		   double value = cellData.getNumericCellValue();
		   System.out.println(value);
		    String result = String.format("%.0f", value);
		    System.out.println(result);
		     data=result;
		}
		catch(NullPointerException s)
		{
			System.out.println("Field Is Empty");
		}
		
		workbook.close();
		return data;
	}
	
	//static public String testID="";
	public static void captureScreenshot(WebDriver driver, String testID) throws IOException
	{
		//testID=Utility.testID;
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Documents\\selenium\\New folder\\chromedriver-win64\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.facebook.com/");
		
		
		TakesScreenshot ts = (TakesScreenshot)driver; 
		
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy   HH mm ss");  
		 Date date = new Date(); 
		 System.out.println("hi");
		File dest = new File("test-output\\FailedScreenshot\\"+testID+" " +formatter.format(date) + ".png" );
		System.out.println("hello");
		FileHandler.copy(src, dest);
		System.out.println("hmm");
		
		
			
	}
	
	
	
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		//getDataFromExcellSheet("C:\\Users\\DELL\\Documents\\TestData.xlsx","Sheet1",1,0);
		
	//	captureScreenshot();
		
	}
	
}	
	
	

