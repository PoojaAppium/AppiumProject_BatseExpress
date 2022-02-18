package POM;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import A_utilities.Write_in_Excel;
import io.appium.java_client.android.AndroidDriver;

public class PaymentMethod {

	 MobileDriverFactory MDF ;
	 AndroidDriver<WebElement> driver;
	 Write_in_Excel WIE;	
	 ProfileBatse P ;
		
		@FindBy(how=How.ID , using = "com.batse.batseexpress:id/walletAmountTv")
		private WebElement WalletAmount;
		@FindBy(how=How.ID , using = "com.batse.batseexpress:id/cv_add_money")
		private WebElement AddMoney;
		@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'Card Registration']")
		private WebElement HeaderText;
		@FindBy(how=How.ID , using = "com.batse.batseexpress:id/addNewCardRl")
		private WebElement AddNewCard;
		@FindBy(how=How.ID , using = "com.batse.batseexpress:id/navigation_profile")
		private WebElement 	ProfileTab;
		@FindBy(how=How.ID , using = "com.batse.batseexpress:id/placeToPayIv")
		private WebElement PlaceToPayLogo;
		@FindBy(how=How.ID , using = "ccom.batse.batseexpress:id/faqLayout")
		private WebElement FaqLogo;
		@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'Pagá directamente con tu tarjeta']")
		private WebElement AddCardHeading;
		@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'MI BILLETERA']")
		private WebElement AddWalletHeading;
		@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'Saldo disponible en billetera']")
		private WebElement Wallet_Text;
		
		
		public PaymentMethod(AndroidDriver<WebElement> driver) {
			
			P = new ProfileBatse(driver);
			WIE = new Write_in_Excel(driver);
			MDF = new MobileDriverFactory(driver);
			PageFactory.initElements(driver, this);
			
		}
		
	 public void ValidateUI() throws InterruptedException {
	    P.ProfileTab();
		Thread.sleep(2000);
	    P.PaymentMethod();
		Thread.sleep(2000); 
		AddWalletHeading.isDisplayed();
		try {
		AddCardHeading.isDisplayed();
		FaqLogo.isDisplayed();
		PlaceToPayLogo.isDisplayed();
		}
		catch(NoSuchElementException E) {
			System.out.println("Flag 0 case");
		}
		
		HeaderText.isDisplayed();
		Wallet_Text.isDisplayed();
		MDF.Back();
	 }
	
	 public int GetWalletAmount() {
		 
		 return MDF.Extract_int(WalletAmount);
		 
	 }
	
	public void WriteWalletAmount(int sheet ,int row , int cell) throws IOException {
		
		WIE.Write(sheet, row, cell, GetWalletAmount());
		
	}
	 
	public void ExistPage() {
		
		MDF.Back();
		
	}
	 
	 
	 
	 
	 
	 
}
