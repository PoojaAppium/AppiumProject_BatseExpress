package POM;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import A_utilities.MobileDriverFactory;
import A_utilities.Write_in_Excel;
import io.appium.java_client.android.AndroidDriver;

public class Transaction {

	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Order_Details OD;
	Excel E;
	

	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@bounds='[899,313][1050,374]']")
	private WebElement TransactionAmount;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@bounds='[30,344][443,395]']")
	private WebElement TransactionTiming;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@bounds='[30,395][609,446]']")
	private WebElement TransactionStatus;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text='Wallet Transactions']")
	private WebElement Title;
	
	public Transaction(AndroidDriver<WebElement> driver) {
		
		
		E = new Excel(driver);
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateUI() throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(Title, "Wallet Transaction");
		TransactionTiming.isDisplayed();
		TransactionAmount.isDisplayed();
		TransactionStatus.isDisplayed();
		
		
	}

	public void ValidateTransaction() throws IOException {
		

	    int Pay =E.ReadExcel(0, 5, 0);
		MDF.Extract_int(TransactionAmount);
		SoftAssert SA = new SoftAssert();
		SA.assertEquals(Pay, MDF.Extract_int(TransactionAmount));
		
	}
	
	public void ExitPage() {
		MDF.Back();
	}
	
	
	
}
