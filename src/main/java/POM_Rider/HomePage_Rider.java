package POM_Rider;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import POM.Excel;
import io.appium.java_client.android.AndroidDriver;

public class HomePage_Rider {

	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Excel E;
    
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/restoName")
	private WebElement 	HeaderName;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/statusImage")
	private WebElement 	Status;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/ll_delivered")
	private WebElement 	Delivered;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/ll_pending")
	private WebElement 	Pending;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/nameTv")
	private WebElement 	Name;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/restrictionLetterIv")
	private WebElement 	Link;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/supportIv")
	private WebElement link2	;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_accept_btn")
	private WebElement 	Order_PickUP;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/callLl")
	private WebElement 	Call;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/navLl")
	private WebElement 	Map;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_qty")
	private WebElement 	Quantity;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_order_id")
	private WebElement OrderID	;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/customerNameTv")
	private WebElement 	UserName;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_time")
	private WebElement 	Timing;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_name")
	private WebElement 	ItemName;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_addons")
	private WebElement 	Customization;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/restroNameTv")
	private WebElement OutletName	;
	

	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_accept")
	private WebElement 	Alert_YES;
	@FindBy(how=How.ID , using = "com.batse.batseexpressrider:id/tv_cancel")
	private WebElement Alert_NO	;
	
	
	
	
	
	public HomePage_Rider(AndroidDriver<WebElement> driver) {
		E = new Excel(driver);
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
		
	}
    
	public void OrderPickUP() throws IOException, InterruptedException {
	
	Thread.sleep(2000);	
//	String UserName = E.ReadExcelString(0,6,0);
//	String OrderID = E.ReadExcelString(0,0,0);
//	String ItemName = E.ReadExcelString(0,8,0);
//	String Address = E.ReadExcelString(0,9,0);
//	String quantity = E.ReadExcelString(0,10,0);
//	String portionName = E.ReadExcelString(0,11,0);
//	String customization  = E.ReadExcelString(0,12,0);
	
	int OrderiD = MDF.Extract_int(OrderID);
	
	
    if(OrderiD == E.ReadExcel(0, 0, 0)) {
    	
	MDF.Click(Order_PickUP);
	Thread.sleep(1000);
	MDF.Click(Alert_YES);
	
    }
    
    else{
    	
    	System.out.println("orderID is not same to process");
    	
    }
	
		
		
	}
	
	
	public void ReachedLocation() throws IOException, InterruptedException {
		
		Thread.sleep(2000);	
//		String UserName = E.ReadExcelString(0,6,0);
//		String OrderID = E.ReadExcelString(0,0,0);
//		String ItemName = E.ReadExcelString(0,8,0);
//		String Address = E.ReadExcelString(0,9,0);
//		String quantity = E.ReadExcelString(0,10,0);
//		String portionName = E.ReadExcelString(0,11,0);
//		String customization  = E.ReadExcelString(0,12,0);
		
		int OrderiD = MDF.Extract_int(OrderID);
		
		
	    if(OrderiD == E.ReadExcel(0, 0, 0)) {
	    	
		MDF.Click(Order_PickUP);
		Thread.sleep(1000);
		MDF.Click(Alert_YES);
		
	    }
	    
	    else{
	    	
	    	System.out.println("orderID is not same to process");
	    	
	    }
		
			
			
		}
	
	
public void Deliver() throws IOException, InterruptedException {
		
		Thread.sleep(2000);	
//		String UserName = E.ReadExcelString(0,6,0);
//		String OrderID = E.ReadExcelString(0,0,0);
//		String ItemName = E.ReadExcelString(0,8,0);
//		String Address = E.ReadExcelString(0,9,0);
//		String quantity = E.ReadExcelString(0,10,0);
//		String portionName = E.ReadExcelString(0,11,0);
//		String customization  = E.ReadExcelString(0,12,0);
		
		int OrderiD = MDF.Extract_int(OrderID);
		
		
	    if(OrderiD == E.ReadExcel(0, 0, 0)) {
	    	
		MDF.Click(Order_PickUP);
		Thread.sleep(1000);
		MDF.Click(Alert_YES);
		
	    }
	    
	    else{
	    	
	    	System.out.println("orderID is not same to process");
	    	
	    }
		
			
			
		}
	
    
	
}
