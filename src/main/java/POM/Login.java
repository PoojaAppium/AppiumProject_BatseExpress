package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Login {
	
	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/et_num")
	private WebElement MobileNumber;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_next")
	private WebElement Submit;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_sign_up")
	private WebElement header;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/codeTv")
	private WebElement code;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = '91']")
	private WebElement code_91;
	
	
	public Login(AndroidDriver<WebElement> driver) {
	   
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void FillMobileNumber(String MN) throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(header, "Login");
		MDF.Click(code);
		MDF.Click(code_91);
		MDF.EnterData(MobileNumber, MN);
		MDF.Click(Submit);
	}
	
	

}
