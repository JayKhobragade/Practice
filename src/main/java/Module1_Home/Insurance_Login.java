package Module1_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_Login {
	//POM-I
	
	@FindBy(xpath="//input[@id='email']") private WebElement Email;
	@FindBy(xpath="//input[@id='password']") private WebElement Password;
	@FindBy(xpath="//input[@name='submit']") private WebElement LoginBtn;
	
	public Insurance_Login(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	} 
	
	public void enteremail(String EM) 
	{
		Email.sendKeys(EM);
	}
	
	public void enterpassword(String PSW) 
	{
		Password.sendKeys(PSW);
	}
	
	public void clickLoginBtn() 
	{
		LoginBtn.click();
	}

}
