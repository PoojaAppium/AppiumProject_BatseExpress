package POM_Rider;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Login_Rider {

	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
    
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_sign_up")
	private WebElement 	Rider_HeaderName;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_info")
	private WebElement 	Rider_Info;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/phoneNumber")
	private WebElement 	Rider_PhoneNo;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/verifyCode")
	private WebElement 	Rider_Password;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/forgetPassTv")
	private WebElement 	Rider_ForgetPassword;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/registerTv")
	private WebElement 	Rider_RegisterHere;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_login")
	private WebElement 	Rider_LoginButton;
	
	
	
	public Login_Rider(AndroidDriver<WebElement> driver) {
		
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
		
	}
    
	public void Login() throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(Rider_HeaderName, "Login");
		MDF.SendKey(Rider_PhoneNo, "9999000125");
		MDF.SendKey(Rider_Password, "123456");
		MDF.Click(Rider_LoginButton);
		
	}
	
}
