package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Basic_Details {

	MobileDriverFactory MDF;	AndroidDriver<WebElement> driver;
	
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'Basic Detais']")
	private WebElement Header;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/firstNameEt")
	private WebElement FN;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/middleNameEt")
	private WebElement MN;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/lastNameEt")
	private WebElement LN;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/nationalIdEt")
	private WebElement MationalID;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/emailEt")
	private WebElement EmailID;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/passEt")
	private WebElement Paswrd;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/confirmPassEt")
	private WebElement Confirm_Password;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/submitTv")
	private WebElement Submit;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/backIv")
	private WebElement Back;
	
	
	
	public Basic_Details(AndroidDriver<WebElement> driver) {
		
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void FillDetails(String firstName , String SecondName ,String ThirdName , String NatioanlID, String Email, String Password ) throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(Header, "Basic Detais");
		MDF.EnterData(FN, firstName);
		MDF.EnterData(MN, SecondName);
		MDF.EnterData(LN, ThirdName);
		Thread.sleep(2000);
		MDF.EnterData(MationalID, NatioanlID);
		MDF.EnterData(EmailID, Email);
		MDF.EnterData(Paswrd, Password);
		MDF.EnterData(Confirm_Password, Password);
		Thread.sleep(2000);
		MDF.Click(Submit);
	}
	
	
	
	
	
}
