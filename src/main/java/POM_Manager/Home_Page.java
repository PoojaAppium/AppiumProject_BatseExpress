package POM_Manager;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import A_utilities.MobileDriverFactory.DIRECTION;
import io.appium.java_client.android.AndroidDriver;

public class Home_Page {
	
	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
    Login_M LMM;
    Order_Generated OG;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/restoName")
	private WebElement 	Outlet_HeaderName;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/logoutTv")
	private WebElement Logout;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_all")
	private WebElement No_Of_Order;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_no_order")
	private WebElement There_AreNoOrder;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/signU")
	private WebElement FirstTimeUser;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_order_id")
	private WebElement 	OrderID;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/callIv")
	private WebElement Call;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/customerNameTv")
	private WebElement CustomerName;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_time")
	private WebElement Time;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_price")
	private WebElement Amount;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_qty")
	private WebElement Quantity;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/amountToCollectTv")
	private WebElement PaybleAmount;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_order_status")
	private WebElement Order_Status;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/statusSwitch")
	private WebElement Switch;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/restoName")
	private WebElement RestroName;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_preparing")
	private WebElement preparing;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/tv_ready")
	private WebElement Ready;
	@FindBy(how=How.ID , using = "com.batse.batseexpressmanager:id/h_scroll_view")
	private WebElement ScrollRight;
	
	


	
	public Home_Page(AndroidDriver<WebElement> driver) {
		
		OG= new Order_Generated(driver);
		LMM = new Login_M(driver);
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
		
	}
	
//______________________________________________________________________________________________________________________	
	
	 public boolean findElement(int OrderID , String status)
	  	{
	  		try {
	  		
				if((MDF.Status_Manager(OrderID, status) != null))
	  			{
	  				return true;
	  			}
	  			else
	  			{
	  				return false;
	  			}
	  		} catch (Exception e) {
	  			// TODO: handle exception
	  			return false;
	  		}
	  		
	  	}
	
//____________________________________________________________________________________________________________________
	 
	 
public boolean Switch_Status() throws InterruptedException {
	
	try {
	if (Switch.getAttribute("checked") == "true") {
		System.out.println("Switch is ON");
		
		return true;
	}
	
	else {
	
	    System.out.println("Switch is off");
		return false;
	}
	}
	catch(Exception E) {
		if (Switch.getAttribute("Checked") == "true") {
			System.out.println("Switch is ON");
			
			return true;
		}
		
		else {
		
		    System.out.println("Switch is off");
			return false;
		}
	}
	}
	
public void Click_on_Switch() throws InterruptedException {
	Thread.sleep(1000);
	MDF.Click(Switch);
}
	


    public void LOGOUT() throws InterruptedException {
	Thread.sleep(1000);
	MDF.Click(Logout);
    }
	
   public void Relogin( String MN , String Pass) throws InterruptedException {
	   

		   	 MDF.Click(Logout);
			 Thread.sleep(1000);
             LMM.Login(MN, Pass);
				
		
   }
   
   public WebElement OutletName() {
	   return RestroName;
   }
   
   public WebElement logout() {
	   return Logout;
   }
   
  
   
    
   public void Preparing(int OrderID) throws InterruptedException {
   	Thread.sleep(3000);
   	MDF.Click(preparing);
   	Thread.sleep(2000);

   	while(true)
    {
    	if(findElement(OrderID  , "Ready"))
    	{
    		break;
    	}
        else 
        {
           MDF.Scroll_Down();
        }
        
       
        
    }
    MDF.ChangeStatus(OrderID, "Ready");
   
   }
   
   
   public void Ready(int OrderID) throws InterruptedException {
	   
	   
	 
		Thread.sleep(2000);
	   	MDF.Click(Ready);
	   	Thread.sleep(2000);
	   	
	   	while(true)
	    {
	    	if(findElement(OrderID , "Dispatch Now"))
	    	{
	    		break;
	    	}
	        else 
	        {
	           MDF.Scroll_Down();
	        }
	        
	       
	        
	    }
	    MDF.ChangeStatus(OrderID, "Dispatch Now");
	   
	   	
   }
   
 

}



