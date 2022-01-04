package POM;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Order_Details  {

	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Login L;
	Verification V ;
	Basic_Details BD ;
	EnterPassword EP;
	HomePage HP;
	Outlet_Screen OS;
	Select_Address SA;
	Check_Out CO;
	PrePaymentAlert PPA;

	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/selectAddressLabelTv")
	private WebElement Select_Address;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text='Order Details']")
	private WebElement Header;
	@FindBy(how=How.XPATH , using = "//	android.widget.ImageView[@bounds = '[956,627][1016,687]']")
	private WebElement Plus;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/commentsEt")
	private WebElement AddComment;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/ll_total")
	private WebElement Total;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_total")
	private WebElement GrandTotal;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_taxes")
	private WebElement TaxesAmount;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_cust")
	private WebElement CustomizationAmount;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_selling_price")
	private WebElement PortionPrice;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_item_name")
	private WebElement Item_Name;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_sign_up")
	private WebElement LoginHeader;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text='Phone Verification']")
	private WebElement Verificationheader;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text='Enter Password']")
	private WebElement EnterPasswordHeader;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/cv_check_out")
	private WebElement ViewCart;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text='PAY']")
	private WebElement PAY;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_total")
	private WebElement PAY_Amount;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_taxes")
	private WebElement Tax_Amount;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_total_price")
	private WebElement TotalPrice;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/cv_check_out")
	private WebElement VIEW_CART;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_delivery_fee")
	private WebElement DeliveryCharge;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/selectedAddressLl")
	private WebElement CurrentLocation;
	
	public Order_Details(AndroidDriver<WebElement> driver) {
			
		L = new Login(driver);
		V= new Verification(driver);
		BD = new Basic_Details(driver);
		EP = new EnterPassword(driver);
		HP = new HomePage(driver);
        OS = new Outlet_Screen(driver);
		SA= new Select_Address(driver);
		CO = new Check_Out(driver);
		MDF = new MobileDriverFactory(driver);
		PPA = new PrePaymentAlert(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void Make_Order(String MN ,String FN, String SN, String LN, String NationalID, String Email, String Pass , String Outlet , String item) throws InterruptedException {
		
		int View_Cart_Amount = OS.VIEW_CART_Ammount();
		MDF.Click(VIEW_CART);
		Thread.sleep(1000);
		int Total = MDF.Extract_int(PAY_Amount);
		int CustomizionAmount = MDF.Extract_int(CustomizationAmount);
		int PortionAmount = MDF.Extract_int(TaxesAmount);
		int Taxes = MDF.Extract_int(PortionPrice);
		
	   int	T = CustomizionAmount + PortionAmount;
		MDF.AssertPrice(View_Cart_Amount, T);
		
	   int	GrandTotal = CustomizionAmount+PortionAmount+Taxes;
		MDF.AssertPrice(Total, GrandTotal);
		
		int Pay = MDF.Extract_int(PAY_Amount);
		
		
		MDF.Click(Select_Address);
		
		if (LoginHeader.isDisplayed()) {
			
			Thread.sleep(2000);
			L.FillMobileNumber(MN);
			
			try {
			if (Verificationheader.isDisplayed()) {
				
			V.VerificationN();
			BD.FillDetails(FN, SN, LN, NationalID, Email, Pass);
			HP.Scroll_To_OutletList(Outlet);
			HP.Select_Outlet(Outlet);
			Thread.sleep(1000);
//Price Assertion
			
			MDF.Click(ViewCart);
			Thread.sleep(1000);
			
//---------------

//Assert Price				
				int DeliveryAmount = MDF.Extract_int(DeliveryCharge);
			    int	Final = DeliveryAmount +GrandTotal;
			    MDF.AssertPrice(Pay, Final);
//---------------------
			    
 // Add Comment 		    
			    MDF.EnterData(AddComment, "Testing");
//--------------			    
				MDF.Click(PAY);
				CO.PAY();
				}
				}
		
			
			
			
			catch(NoSuchElementException E) {
		
				EP.Enter_Password(Pass);
				HP.Select_Outlet(Outlet);
				Thread.sleep(1000);
//Assert Price				
		
				MDF.Click(ViewCart);
				Thread.sleep(1000);
				
				
//----------------------
				
				
				int DeliveryAmount = MDF.Extract_int(DeliveryCharge);
			    int	Final = DeliveryAmount +GrandTotal;
			    MDF.AssertPrice(Pay, Final);
				
	//Add Comment 
			    
			    MDF.EnterData(AddComment, "Testing");
			    
//-----------
				MDF.Click(PAY);
				CO.PAY();
				
			}}
		}
	
		
			

		
		
		
			
			


	
	
	
public void Make_Order_DifferentAddress(String MN ,String FN, String SN, String LN, String NationalID, String Email, String Pass , String Outlet , String item) throws InterruptedException {
		
		int View_Cart_Amount = OS.VIEW_CART_Ammount();
		MDF.Click(VIEW_CART);
		Thread.sleep(1000);
		int Total = MDF.Extract_int(PAY_Amount);
		int CustomizionAmount = MDF.Extract_int(CustomizationAmount);
		int PortionAmount = MDF.Extract_int(TaxesAmount);
		int Taxes = MDF.Extract_int(PortionPrice);
		
	   int	T = CustomizionAmount + PortionAmount;
		MDF.AssertPrice(View_Cart_Amount, T);
		
	   int	GrandTotal = CustomizionAmount+PortionAmount+Taxes;
		MDF.AssertPrice(Total, GrandTotal);
		
		int Pay = MDF.Extract_int(PAY_Amount);
		
		
		MDF.Click(Select_Address);
		
		if (LoginHeader.isDisplayed()) {
			
			Thread.sleep(2000);
			L.FillMobileNumber(MN);
			
			try {
			if (Verificationheader.isDisplayed()) {
				
			V.VerificationN();
			BD.FillDetails(FN, SN, LN, NationalID, Email, Pass);
			HP.Scroll_To_OutletList(Outlet);
			HP.Select_Outlet(Outlet);
			Thread.sleep(1000);
//Price Assertion
			
			MDF.Click(ViewCart);
			Thread.sleep(1000);
			
//---------------
			Thread.sleep(1000);
			MDF.Click(CurrentLocation); //DOBARA ADDRESS
           try {
				
				if (MDF.AddressSelection("Home").isDisplayed()) {	
					MDF.AddressSelection("Home").click();
//Assert Price				
				int DeliveryAmount = MDF.Extract_int(DeliveryCharge);
			    int	Final = DeliveryAmount +GrandTotal;
			    MDF.AssertPrice(Pay, Final);
//---------------------
			    
 // Add Comment 		    
			    MDF.EnterData(AddComment, "Testing");
//--------------			    
				MDF.Click(PAY);
				CO.PAY();
				}
				}
				catch(NoSuchElementException E1) {
					SA.Add_newAddress("ABC PVT ", "Near Mother Dairy");
					MDF.AddressSelection("Home").click();
	//Assert Price				
					int DeliveryAmount = MDF.Extract_int(DeliveryCharge);
				    int	Final = DeliveryAmount +GrandTotal;
				    MDF.AssertPrice(Pay, Final);
	//--------------------- 
    // Add Comment 
				    MDF.EnterData(AddComment, "Testing");
   //--------------------- 				
					MDF.Click(PAY);
					CO.PAY();
			
		}}
		
			}
			
			
			catch(NoSuchElementException E) {
		
				EP.Enter_Password(Pass);
				HP.Select_Outlet(Outlet);
				Thread.sleep(1000);
//Assert Price				
		
				MDF.Click(ViewCart);
				Thread.sleep(1000);
				
				
//----------------------
				Thread.sleep(1000);
				MDF.Click(CurrentLocation); // DOBARA ADDRESS
				
				try {
				
				if (MDF.AddressSelection("Home").isDisplayed()) {	
				MDF.AddressSelection("Home").click();
				
				int DeliveryAmount = MDF.Extract_int(DeliveryCharge);
			    int	Final = DeliveryAmount +GrandTotal;
			    MDF.AssertPrice(Pay, Final);
				
	//Add Comment 
			    
			    MDF.EnterData(AddComment, "Testing");
			    
//-----------
				MDF.Click(PAY);
				CO.PAY();
				}
				}
				catch(NoSuchElementException E1) {
					SA.Add_newAddress("ABC PVT ", "Near Mother Dairy");
					SA.SelectAddress("Home");
					
					int DeliveryAmount = MDF.Extract_int(DeliveryCharge);
				    int	Final = DeliveryAmount +GrandTotal;
				    MDF.AssertPrice(Pay, Final);
				    
	 //Add Comment 
				    
				    MDF.EnterData(AddComment, "Testing");
				    
	//-----------
					
					MDF.Click(PAY);
					CO.PAY();
			
		}}
		
		}
	
		
			
			
		
		
		else {
			 
			MDF.Click(Select_Address);
			
			if (MDF.AddressSelection("Home").isDisplayed()) {
			MDF.AddressSelection("Home").click();
			
			int DeliveryAmount = MDF.Extract_int(DeliveryCharge);
		    int	Final = DeliveryAmount +GrandTotal;
		    MDF.AssertPrice(Pay, Final);
		    
 //Add Comment 
		    
		    MDF.EnterData(AddComment, "Testing");
		    
//-----------
			
			MDF.Click(PAY);
			CO.PAY();
			}
			else {
				
				SA.Add_newAddress("ABC PVT ", "Near Mother Dairy");
				SA.SelectAddress("Home");
				
				int DeliveryAmount = MDF.Extract_int(DeliveryCharge);
			  int	Final = DeliveryAmount +GrandTotal;
			    MDF.AssertPrice(Pay, Final);
			 
//Add Comment 
			    
			    MDF.EnterData(AddComment, "Testing");
			    
//-----------
				
				MDF.Click(PAY);
				CO.PAY();
				
				
				
			}
			
			
}

	
	}


}	



