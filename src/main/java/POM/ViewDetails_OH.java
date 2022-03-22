package POM;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class ViewDetails_OH {

	

	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Excel E ;
	
	
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/rv_order_item")
	private WebElement OrdersItems_ItemAmount;
	
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/payableAmountTv")
	private WebElement TotalPaybleAmount;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_taxes")
	private WebElement TaxAmount;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_delivery_fee")
	private WebElement DeliveryAmount;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/totalFareTv")
	private WebElement Total;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_my_address")
	private WebElement Address;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_restro_name")
	private WebElement Outlet_Name;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_date")
	private WebElement Date_Time;
	
	@FindBy(how=How.XPATH , using = "com.batse.batseexpress:id/deliveryMsgTv")
	private WebElement DeliveryMessage;
	
	@FindBy(how=How.XPATH , using = "com.batse.batseexpress:id/orderIdTv")
	private WebElement OrderID;
	
	
	public ViewDetails_OH(AndroidDriver<WebElement> driver) {
		
		E = new Excel(driver);
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void UI() {
		
	}
	
	public void ExitPage() {
		
	}
	
	public void TrackingScreen() {
		
	}
	
	public void DetailsValidation() throws IOException {
		
		SoftAssert SA = new SoftAssert();
	     
		//Same OrderID
		int orderid =  MDF.Extract_int(OrderID);
	    SA.assertEquals(E.ReadExcel(0, 0, 0), orderid , "Order ID validated"); 
	      
	      
		//Same Address 
	    String address = MDF.Extract_Text(Address);
	    SA.assertEquals(address, E.ReadExcelString(0, 8, 0)  , "Address Validated ");
	    
		//Same Items Name 
   if (MDF.Extract_Text(OrdersItems_ItemAmount).contains(E.ReadExcelString(0, 7, 0))){
	    
	   
	   System.out.println("Item validated");
	   
   }
	    
	    
		//Same Amount Details 
   if (MDF.Extract_int(OrdersItems_ItemAmount)==E.ReadExcel(0, 2, 0)){
	   
	   System.out.println("Item Amount Validated");
	   
   }
   
		//Same Time 
   
   
   
		//Same Delivery Charges 
   if (MDF.Extract_int(DeliveryAmount)==E.ReadExcel(0, 4, 0)){
	   
	   System.out.println("Delivery Amount Validated");
	   
   }
   
		//Same Tax Amount 
   
   if (MDF.Extract_int(TaxAmount)==E.ReadExcel(0, 3, 0)){
	   
	   System.out.println("Tax Amount Validated");
	   
   }
   
   
		//Same Total
		
  if (MDF.Extract_int(Total)==E.ReadExcel(0, 5, 0)){
	   
	   System.out.println("Total Amount Validated");
	   
}	
		
		
	}
	
	
	
	
}
