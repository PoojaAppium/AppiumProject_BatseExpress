package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Check_Out {
	
	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	PrePaymentAlert PPA;
	
	
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'Check Out']")
	private WebElement Header;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/cv_pay")
	private WebElement PAY;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/addAmountEt")
	private WebElement Amount_ToPay;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/walletAmountTv")
	private WebElement Wallet_Amount;
	
	
	
	
	
	public Check_Out(AndroidDriver<WebElement> driver) {

		MDF = new MobileDriverFactory(driver);
		PPA = new PrePaymentAlert(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void PAY( ) throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(Header, "Check Out");
	   int A = MDF.Extract_int(Wallet_Amount);
	   int B = MDF.Extract_int(Amount_ToPay);
	  if (A>B) {
		
		MDF.Click(PAY);
		PPA.AcceptAlert();
	  }
	  
	  else {
		  System.out.println("Not Enough Wallet Amount");
	  }
	}
	

	
	
	
	
	

}
