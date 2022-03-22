package POM;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class CancellationScreen {

	AndroidDriver<WebElement> driver;
	MobileDriverFactory MDF;

	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_o_id")
	private WebElement OrderID;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/outletRl")
	private WebElement OutletName;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'YOUR ORDER WAS CANCELLED']")
	private WebElement HeadingText;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'We are Sorry']")
	private WebElement SorryMessage;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'Your order has been canceled because the business did not accept it. Your money was added to your Batsë Express wallet to make another purchase.']")
	private WebElement 	Discription;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/complaintTv")
	private WebElement CompalaintLink;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/returnToWalletTv")
	private WebElement ReturnToWalletbutton;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/img_back")
	private WebElement backButton;
	
	
	public CancellationScreen(AndroidDriver<WebElement> driver) {
		
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void ReturnToWallet() throws InterruptedException {
		Thread.sleep(2000);
		try {
		MDF.Click(ReturnToWalletbutton);
		
		}
		catch(StaleElementReferenceException E) {
			MDF.Click(ReturnToWalletbutton);
		
		
		}
		
	}
	
	public void ValidateCancellationText() throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(HeadingText, "YOUR ORDER WAS CANCELLED");
		MDF.AssertTitle(SorryMessage, "We are Sorry");
		MDF.AssertTitle(Discription, "Your order has been canceled because the business did not accept it. Your money was added to your Batsë Express wallet to make another purchase.");
		MDF.AssertTitle(CompalaintLink, "To manage a complaint, enter here");
		MDF.AssertTitle(ReturnToWalletbutton, "LEAVE IN WALLET");
		
	}
	
  
  public void ValidateCancellationText_AfterReturnWalletAmount() throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(HeadingText, "YOUR ORDER WAS CANCELLED");
		MDF.AssertTitle(SorryMessage, "We are Sorry");
		MDF.AssertTitle(Discription, "Your order has been canceled because the business did not accept it. Your money was added to your Batsë Express wallet to make another purchase.");
		MDF.AssertTitle(CompalaintLink, "To manage a complaint, enter here");
		
	}
	
  public void ExitPage() {
	  
	  MDF.Back();
	
}
	
	
	
	
	
}
