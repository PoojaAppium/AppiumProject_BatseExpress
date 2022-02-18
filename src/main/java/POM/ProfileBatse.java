package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class ProfileBatse {

   MobileDriverFactory MDF ;
   AndroidDriver<WebElement> driver;
	
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/profilePicIv")
	private WebElement Image;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/nameTv")
	private WebElement Name;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'Account Details']")
	private WebElement HeaderText;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/logoutLl")
	private WebElement Logout;
	@FindBy(how=How.XPATH , using = "//android.widget.FrameLayout[@content-desc=\"Perfil\"]/android.widget.ImageView")
	private WebElement 	ProfileTab;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/emailTv")
	private WebElement Email;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/phoneTv")
	private WebElement MobileNumber;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/orderHistoryLl")
	private WebElement OrderHistory;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/walletTransLl")
	private WebElement WalletTransaction;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/customerSupportLl")
	private WebElement CustomerSupport;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/paymentMethodsLl")
	private WebElement PaymentMethod;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/inviteLl")
	private WebElement InviteFriends;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/aboutUsLl")
	private WebElement AboutUs;
	
	
	public ProfileBatse(AndroidDriver<WebElement> driver) {
		
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);

	}
	
	public void PaymentMethod() {
		
		MDF.Click(PaymentMethod);;

		
	}
	
public WebElement AboutUS() {
		
		return AboutUs;

		
	}

public WebElement Transaction() {
	
	return Transaction();

	
}

public WebElement OrderHistory() {
	
	return OrderHistory();

	
}

public WebElement CustomerSupport() {
	
	return CustomerSupport;

	
}

public WebElement InviteFriends() {
	
	return InviteFriends;

	
}
	
public void UI_Validation_Profile(String UserName , String UserEmail , String MobileNo) throws InterruptedException	{
	
	Thread.sleep(2000);
	MDF.Click(ProfileTab);
	Thread.sleep(2000);
	MDF.AssertTitle(HeaderText, "Account Details");
	MDF.AssertTitle(Name, UserName);
	MDF.AssertTitle(Email, UserEmail);
	MDF.AssertTitle(MobileNumber, UserEmail);
	OrderHistory.isDisplayed();
	WalletTransaction.isDisplayed();
	CustomerSupport.isDisplayed();
	PaymentMethod.isDisplayed();
	InviteFriends.isDisplayed();
	AboutUs.isDisplayed();
	Logout.isDisplayed();
	
}
	
	
public void ProfileTab()	{
	
	MDF.Click(ProfileTab);
	
}

public void TransactionTab()	{
	
	MDF.Click(WalletTransaction);
	
}

public void Order_History()	{
	
	MDF.Click(OrderHistory);
	
}

	
	
}
