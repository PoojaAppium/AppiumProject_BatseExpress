package POM_Manager;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Login_M {

	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Order_Generated OG;

	
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/phoneNumber")
	private WebElement UserName;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/verifyCode")
	private WebElement Password;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_sign_up")
	private WebElement Header;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_login")
	private WebElement Submit;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/signU")
	private WebElement FirstTimeUser;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/signU")
	private WebElement SignUPHeader;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/restoName")
	private WebElement 	Outlet_HeaderName;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/logoutTv")
	private WebElement Logout;

	
	public Login_M(AndroidDriver<WebElement> driver) {
	    
	    OG = new Order_Generated(driver);
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void Login(String MN , String Pass ) throws InterruptedException {
	

		
			
		Thread.sleep(1000);
		MDF.EnterData(UserName, MN);
		MDF.EnterData(Password, Pass);
		MDF.Click(Submit);
		
		
		
		}
		
		public WebElement loginHeader() {
			return Header;
		}

}
		

		
		
		
		
		
	
	

