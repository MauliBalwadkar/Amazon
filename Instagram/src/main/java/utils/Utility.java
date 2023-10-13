package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void captureScreenshot(WebDriver driver ,String TestID) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy   HH mm ss");  
		 Date date = new Date();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("test-output\\FailedTestCasesScreenshot\\"+TestID+ " "+formatter.format(date));
		FileHandler.copy(src, dest);
	}
	
	
	public static String getDataFromExcelSheet(String filepath,String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		String data="";
		FileInputStream file=new FileInputStream(filepath);
		
		Workbook workbook =WorkbookFactory.create(file);
		Sheet sheet	=workbook.getSheet(sheetName);
		Row rowValue=sheet.getRow(row);
		Cell cellValue = rowValue.getCell(cell);
		
		try
		{
		  data=cellValue.getStringCellValue();
		}
		catch(IllegalStateException e)
		{
			double doubleValue=cellValue.getNumericCellValue();
			String result = String.format("%.0f", doubleValue);
			
			data=result;
		}
		return data;
		
		
		
	}
	
	
	
	
	

}
