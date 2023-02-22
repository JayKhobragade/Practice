package Module1_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_Broker_Insurance_Webpage {
	//POM-II
	
	@FindBy(xpath="//h4[text()='saradeg41@gmail.com']") private WebElement SignedinAs;
	@FindBy(xpath="//input[@value='Log out']") private WebElement LogoutBtn;
	
	
	public Insurance_Broker_Insurance_Webpage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getemail() 
	{
		String ActualemailAddress=SignedinAs.getText();
		return ActualemailAddress;
	}
	
	public void clicklogoutBtn() 
	{
		LogoutBtn.click();
	}

}
