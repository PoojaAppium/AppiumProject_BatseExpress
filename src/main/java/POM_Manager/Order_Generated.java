package POM_Manager;

import java.io.IOException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import POM.Excel;
import POM.Tracking;
import io.appium.java_client.android.AndroidDriver;

public class Order_Generated {

	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Tracking T;
	Excel E;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_order_id")
	private WebElement 	Order_ID;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_time")
	private WebElement Order_Time;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/customerNameTv")
	private WebElement Customer_Name;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/amountToCollectTv")
	private WebElement Total_Pay;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_accept")
	private WebElement 	Accept_Request;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_cancel")
	private WebElement Refuse_Order;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/arrowIv")
	private WebElement Arrow;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_delivery_charges")
	private WebElement DeliveryCharges;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_taxes")
	private WebElement 	Taxes;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_total_price")
	private WebElement Total_Price;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/couponTv")
	private WebElement coupon;
	
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'New Order']")
	private WebElement NEW_ORDER;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_o_id")
	private WebElement orderID;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_price")
	private WebElement item_portionPrice;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_total_price")
	private WebElement Total;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/amountToCollectTv")
	private WebElement Payble;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_addons")
	private WebElement ADons;
	

	
	
	
	
	


	
	public Order_Generated(AndroidDriver<WebElement> driver) {
		T = new Tracking(driver);
		E = new Excel(driver);
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
		
	}
	
    
			
			
	 public void Accept_Order_Any() {
		
		//driver.activateApp("com.batse.batseexpressmanager");
		MDF.WaitForElement(30 , NEW_ORDER);
		try {
		if(NEW_ORDER.isDisplayed()){
			
			MDF.Click(Accept_Request);
			
		}
		}
		
		catch(NoSuchElementException E) {
			
			System.out.println("No Order Request Was Generated Between flow");
			
		}
		
		
	}
	
    public void Accept_Order_Selected() throws IOException, InterruptedException  {
    	
    	
    	
    	int ID = (int) E.ReadExcel(0,0,0);
    	
    	System.out.println("DONE1");
    	Thread.sleep(1000);
    	
    	MDF.WaitForElement(30 ,NEW_ORDER);
    
    	int OrderID = MDF.Extract_int(Order_ID);
    	System.out.println("DONE");
		try {
		if(OrderID == ID){
		        Thread.sleep(2000);
		        MDF.Click(Arrow);
		        Thread.sleep(2000);
		        int PaybleAmount =  MDF.Extract_int(Payble);
		        MDF.AssertPrice(PaybleAmount, E.ReadExcel(0, 5, 0));
		        int portionAmount =  MDF.Extract_int(item_portionPrice);
		        MDF.AssertPrice(portionAmount, E.ReadExcel(0, 1, 0));
		      //  int Customization =  MDF.Extract_int(ADons);
		     //   MDF.AssertPrice(Customization, E.ReadExcel(1, 0, 0));
		        try {
		        int taxes =  MDF.Extract_int(Taxes);
		        MDF.AssertPrice(taxes, E.ReadExcel(0, 3, 0));
		        int total =  MDF.Extract_int(Total);
		        MDF.AssertPrice(total, E.ReadExcel(0, 5, 0));
				MDF.Click(Accept_Request);
		        }
		        catch(NoSuchElementException E2) {
		        	try {
		        	  int deliveryCharges =  MDF.Extract_int(DeliveryCharges);
				      MDF.AssertPrice(deliveryCharges, E.ReadExcel(0, 4, 0));
				      int total =  MDF.Extract_int(Total);
				        MDF.AssertPrice(total, E.ReadExcel(0, 5, 0));
				        Thread.sleep(2000);
		    		MDF.Click(Accept_Request);
		        	}
		        	catch(NoSuchElementException E3) {
		        		 int total =  MDF.Extract_int(Total);
					        MDF.AssertPrice(total, E.ReadExcel(0, 5, 0));
					        Thread.sleep(2000);
			    		MDF.Click(Accept_Request);
		        	}
		        }
		}
		}
		
		catch(NoSuchElementException E) {
			
		if(OrderID!=ID) {
			 Thread.sleep(2000);
			MDF.Click(Refuse_Order);
			
			}
else {
			System.out.println("No Order Request Was Generated Between flow");
		}
		}
		
		
		
	}
	
    public void Refuse_Order() throws InterruptedException {
		
    	MDF.WaitForElement(30 ,NEW_ORDER);
  
		try {
		if(NEW_ORDER.isDisplayed()){
			
			MDF.Click(Refuse_Order);
			
		}
		}
		
		catch(NoSuchElementException E) {
			
			System.out.println("No Order Request Was Generated Between flow");
			
		}
		
		
		
	}
	
    public int Order_ID() {
    	return MDF.Extract_int(Order_ID);
    }
    
    public void OrderAccept() {
    	MDF.Click(Accept_Request);
    }
    
    public void Orderrefuse() {
    	MDF.Click(Refuse_Order);
    }
    
   
    
    
    
    
    
    
    
    
    
    
	
}
