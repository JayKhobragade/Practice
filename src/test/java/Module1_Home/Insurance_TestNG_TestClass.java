package Module1_Home;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Library_Files.BaseClass;
import Library_Files.UtilityClass;


public class Insurance_TestNG_TestClass extends BaseClass
{    
	//TestClass
	//extends BaseClass
	Insurance_Login login;
	Insurance_Broker_Insurance_Webpage Broker;
	int TestCaseID;
	
	
	@BeforeClass
	public void OpenBrowser() 
	{   
		InitializeBrowser();
	
		login=new Insurance_Login(driver);
	
		Broker= new Insurance_Broker_Insurance_Webpage(driver);
	}
	
	@BeforeMethod
	public void LogintoApp() throws IOException 
	{
		login.enteremail(UtilityClass.getdatafrompf("EM"));
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		login.enterpassword(UtilityClass.getdatafrompf("PSW"));	
		
		login.clickLoginBtn();
	}
	@Test (priority=1)
	public void VerifyEmail() throws IOException 
	{
		TestCaseID = 100;
		String Actualemail=Broker.getemail();
		
		String Expectedemail=UtilityClass.getdatafromexcelsheet(2, 1);
		
		Assert.assertEquals(Actualemail, Expectedemail);
	}
	@Test(priority=2)
	public void getTitle() throws IOException 
	{	TestCaseID = 101;
		String ActualTitle=driver.getTitle();
		String ExpectedTitle=UtilityClass.getdatafromexcelsheet(3, 1);
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@AfterMethod
	public void logout(ITestResult Result) throws IOException 
	{	
		if(Result.getStatus()==ITestResult.FAILURE)
	{
		UtilityClass.Screenshot(driver,TestCaseID);
		
	}
		Broker.clicklogoutBtn();
	}
	
	@AfterClass
	public void CloseBrowser() 
	{
		driver.close();
	}





























}
