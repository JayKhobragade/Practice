package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class UtilityClass {
	
	
	//Automation TE: Jay
	//Date: 20-02-2023
	//Day: Monday
	//Title: Fetching data from excelsheet and propertyfile and capturing screenshot
	
	
	
	@Test
	public static String getdatafrompf(String key) throws IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\tina\\eclipse-workspace\\Maven_1Oct\\PropFile.properties");
		Properties prop=new Properties();
		prop.load(file);
		String Value1=prop.getProperty(key);
		return Value1;
	}
	public static String getdatafromexcelsheet(int RowIndex,int CellIndex ) throws IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\tina\\eclipse-workspace\\Maven_1Oct\\Test Data\\DDF.xlsx");
		Sheet Sh=WorkbookFactory.create(file).getSheet("Sheet1");
		
		String ExpectedemailAddress=Sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		return ExpectedemailAddress;
	}
	public static void Screenshot(WebDriver driver, int TestCaseID) throws IOException 
	{ 
	File Source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File Destination= new File("C:\\Users\\tina\\eclipse-workspace\\Maven_1Oct\\Screenshot\\"+TestCaseID+".jpg");
	
	FileHandler.copy(Source, Destination);
	
	}

}









