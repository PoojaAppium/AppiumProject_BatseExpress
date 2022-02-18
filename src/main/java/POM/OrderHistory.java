package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class OrderHistory {
	
	
	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	
	
	@FindBy(how=How.XPATH , using = "//android.widget.TextView")
	private WebElement OutletName;
	
	@FindBy(how=How.XPATH , using = "")
	private WebElement Time;
	
	@FindBy(how=How.XPATH , using = "")
	private WebElement Date;
	
	@FindBy(how=How.XPATH , using = "")
	private WebElement itemName;
	
	@FindBy(how=How.XPATH , using = "")
	private WebElement ViewDetails;
	
	@FindBy(how=How.XPATH , using = "")
	private WebElement Status;
	
	
	@FindBy(how=How.XPATH , using = "")
	private WebElement ItemAmount;
	
	
	@FindBy(how=How.XPATH , using = "")
	private WebElement Title;
	
	
	public OrderHistory(AndroidDriver<WebElement> driver) {
		
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
	}
 
	
	public void Validate_OrderHistory(String OutletName , String itemName) throws InterruptedException {
		Thread.sleep(2000);
	if(	MDF.OrderHistory_Validate_OutletName(OutletName)==true) {
		
		MDF.Text_WebElement(itemName).isDisplayed();

		
	}
		
	else {
		System.out.println("PROBLEM");
	}
		
		
	}
	
	public void ExitPage() {
		MDF.Back();
	}
	
}
