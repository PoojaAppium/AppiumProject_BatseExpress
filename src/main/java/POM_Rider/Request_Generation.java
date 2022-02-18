package POM_Rider;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import POM.Excel;
import io.appium.java_client.android.AndroidDriver;

public class Request_Generation {

	
	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Excel E ;
    
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_accept")
	private WebElement 	Accept;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_cancel")
	private WebElement 	Cancel;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_order_id")
	private WebElement 	Order_Id;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_time")
	private WebElement 	Timing;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_qty")
	private WebElement 	Quantity;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_name")
	private WebElement 	ItemName;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_addons")
	private WebElement 	Customization;
	
	
	
	public Request_Generation(AndroidDriver<WebElement> driver) {
		
		super();
		E = new Excel(driver);
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
		
	}
    
	public void Accept() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		int ID = E.ReadExcel(0, 0, 0);
	int orderID = MDF.Extract_int(Order_Id);
	
		if(orderID==ID) {
			
			MDF.Click(Accept);
			
		}
		
		else if (orderID!=ID) {
			MDF.Click(Cancel);
		}
		
		else {
			
			System.out.println("No Request Gererated In Rider");
		}
		
	}
	
	public void Cancel() throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.WaitForElement(30 ,Cancel);
		MDF.Click(Cancel);
	}
}
