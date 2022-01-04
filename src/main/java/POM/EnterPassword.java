package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class EnterPassword {

	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;

	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/et_pass")
	private WebElement Enterpassword;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_next")
	private WebElement Submit;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_sign_up")
	private WebElement header;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_login_with_otp")
	private WebElement loginByOTP;
	
	
	public EnterPassword(AndroidDriver<WebElement> driver) {
		
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void Enter_Password(String Password) throws InterruptedException {
		
		Thread.sleep(1000);
		MDF.AssertTitle(header, "Enter Password");
		MDF.EnterData(Enterpassword, Password);
		MDF.Click(Submit);
		
	}
	
	
	
	
}
