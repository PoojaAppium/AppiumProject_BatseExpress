package POM;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import A_utilities.Write_in_Excel;
import io.appium.java_client.android.AndroidDriver;

public class Check_Out {
	
	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Alert PPA;
	Write_in_Excel WIE;
	
	
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'Card Registration']")
	private WebElement Header;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/cv_pay")
	private WebElement PAY;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/addAmountEt")
	private WebElement Amount_ToPay;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/walletAmountTv")
	private WebElement Wallet_Amount;
	
	
	
	
	
	public Check_Out(AndroidDriver<WebElement> driver) {
        
		WIE = new Write_in_Excel(driver);
		MDF = new MobileDriverFactory(driver);
		PPA = new Alert(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void PAY( ) throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(Header, "Card Registration");
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
	

	public int WalletAmount() {
		return MDF.Extract_int(Wallet_Amount);
	}
	
	public void WriteWalletAmount(int sheet , int row , int cell) throws IOException {
		
		WIE.Write(sheet , row, cell, WalletAmount());
		
		
	}
	
	

}
