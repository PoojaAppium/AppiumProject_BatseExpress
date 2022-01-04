package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Verification {
	
	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_sign_up")
	private WebElement header;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/first")
	private WebElement O1;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/second")
	private WebElement O2;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/third")
	private WebElement O3;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/fourth")
	private WebElement O4;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/resendTv")
	private WebElement ResendOTP;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_confirm")
	private WebElement Confirm;
	
	
	public Verification(AndroidDriver<WebElement> driver) {
		
		
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void VerificationN() throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(header, "Phone Verification");
		MDF.Click(O1);
		MDF.EnterData(O1, "1");
		MDF.SendKey(O2, "2");
		MDF.SendKey(O3, "3");
		MDF.SendKey(O4, "4");
		MDF.Click(Confirm);
	}

}
