package POM;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class OrderHistory {
	
	
	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	
	
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@resource-id='com.batse.batseexpress:id/tv_item_one_name'] [1]")
	private WebElement ItemName;
	
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text='View Details'][1]")
	private WebElement VIEWDetails;
	
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@resource-id='com.batse.batseexpress:id/tv_orig_price_one'] [1]")
	private WebElement ItemAmount;
	
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@resource-id='com.batse.batseexpress:id/orderStatusTv'] [1]")
	private WebElement TrackStatus;
	
	
	
	
	public OrderHistory(AndroidDriver<WebElement> driver) {
		
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
	}
 
	
	public void View_Details(String OutletName , String itemName) throws InterruptedException {
		Thread.sleep(2000);
	if(	MDF.OrderHistory_Validate_OutletName(OutletName)==true) {
		
		ItemName.getText().contains(itemName);
        MDF.Click(VIEWDetails);
        Thread.sleep(4000);
        
		
	}
		
	else {
		System.out.println("PROBLEM");
	}
		
		
	}
	
	
	
	
	
	public void ExitPage() {
		MDF.Back();
	}
	
	public void Track_Status_Accepted() {
		
	String status =	MDF.Extract_Text(TrackStatus);

	Assert.assertEquals(status, "aceptada" , "Accepted By Manager / pass");
	System.out.println("Accepted By Manager");
		
	}
	
	public void Track_Status_Ready() {
		
		String status =	MDF.Extract_Text(TrackStatus);
		Assert.assertEquals(status, "Listo" , "Ready By Manager / pass");
		System.out.println("Ready By Manager");
			
		}
	
public void Track_Status_Dispatch() {
		
		String status =	MDF.Extract_Text(TrackStatus);
		Assert.assertEquals(status, "Envio" , "Dispatched By Manager/ pass");
		System.out.println("Dispatch By Manager");
			
		}
	
public void Track_Status_Cancelled() {
	
	String status =	MDF.Extract_Text(TrackStatus);

	Assert.assertEquals(status, "Cliente Cancelar" , "Cancelled By user / pass");
	
		
	}
	
}
