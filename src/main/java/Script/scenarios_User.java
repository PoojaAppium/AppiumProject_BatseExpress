package Script;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.DecimalFormat;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;

import POM.CancellationScreen;
import POM.Check_Out;
import POM.Excel;
import POM.HomePage;
import POM.Order_Details;
import POM.Outlet_Screen;
import POM.PaymentMethod;
import POM.ProfileBatse;
import POM.Tracking;
import POM.Transaction;
import POM.WaitingScreen;
import POM_Manager.Home_Page;
import POM_Manager.Login_M;
import POM_Manager.Order_Generated;
import POM_Rider.HomePage_Rider;
import POM_Rider.Login_Rider;
import POM_Rider.Request_Generation;
import io.appium.java_client.android.Activity;

public class scenarios_User extends BaseClass_User {

//	Check_out = (0,0,1)  // payment method wallet amount = (0,0,2)
//  Order ID = (0,0,0) 
// Customization , portion amount , tax value , payble amount = (0,n,0)
//Wallet Transaction Amount = (0,0,3) //Payble Amount In CheckOut Screen = (0,0,4)
	
	//________________________________________________________________________________________________________________________________
	
	@Test(priority = 1 , enabled = false)
	public void MakeOrder_1C1P_CurrentLocation() throws InterruptedException, IOException {
		
		String MobileNumber = "8210157528" ;
		String FirstName = "A" ;
		String MiddleName = "B" ;
		String LastName = "Test" ;
		String NationalID = "1234567890" ;
		String Email = "ab1@gmail.com" ;
		String Password = "123456" ;
		String Outlet = "Green Apple" ;
		String Item = "Green Apple Item 1" ;
		
		String	AppActivity = "com.dexit.yumboxmanager.activity.SplashActivity";
		String	AppPackage = "com.batse.batseexpressmanager";
	
		Thread.sleep(6000);
		
		HomePage HP = new HomePage(driver);
		HP.Scroll_To_OutletList(Outlet);
		HP.Outlet_Status(Outlet);
		System.out.println("done");
		
	 if(HP.Outlet_Status(Outlet)==true) { // Closed outlet 

		try {
		driver.startActivity(new Activity( AppPackage, AppActivity));
		}
		catch(WebDriverException e) {
	
		Thread.sleep(1000);
		Login_M LPM = new Login_M(driver);
		LPM.Login("8888000011", "123456" );
		
		Home_Page HPM = new Home_Page(driver);
		if(HPM.Switch_Status() == false) {
			
			HPM.Click_on_Switch();
			
		}
		else {
			
			System.out.println("Switch is already ON");
		
			
		}
		}}
	 
		else if (HP.Outlet_Status(Outlet)==false) {
	   	HP.Select_Outlet(Outlet);
		  Outlet_Screen OS = new Outlet_Screen(driver);
	      OS.Add_Item(Outlet, Item);
		  Order_Details OD = new Order_Details(driver);
		  OD.Make_Order(MobileNumber, FirstName, MiddleName, LastName, NationalID, Email, Password, Outlet, Item);
		  WaitingScreen W = new WaitingScreen(driver);
		  W.WriteOrderID(0, 0, 0);
		
		}
	 }
	
//________________________________________________________________________________________________________________________________________________

	
	@Test(priority = 1 , enabled = true )
	public void MakeOrder_AllCustomozation1portion_CurrentLocation() throws InterruptedException, IOException {
		
		String MobileNumber = "8210100019" ;
		String FirstName = "A" ;
		String MiddleName = "B" ;
		String LastName = "Test" ;
		String NationalID = "1234567890" ;
		String Email = "ab1@gmail.com" ;
		String Password = "654321" ;
		String Outlet = "Peanut Automate" ;
		String Item = "Moongfali" ;
		
		
	
		Thread.sleep(6000);
		
		HomePage HP = new HomePage(driver);
		HP.Scroll_To_OutletList(Outlet);
		HP.Outlet_Status(Outlet);
		System.out.println("done");

	   	HP.Select_Outlet(Outlet);
		  Outlet_Screen OS = new Outlet_Screen(driver);
	      OS.Add_Item_AC(Outlet, Item);
		  Order_Details OD = new Order_Details(driver);
		  OD.Make_Order_AllCustomization(MobileNumber, FirstName, MiddleName, LastName, NationalID, Email, Password, Outlet, Item);
		  WaitingScreen W = new WaitingScreen(driver);
		  W.WriteOrderID(0, 0, 0);
		  
	
		
		}
	 

	
//________________________________________________________________________________________________________________________________________
	
	@Test(priority =2 , invocationCount=1 , enabled = false )
	public void DispatchOrder() throws InterruptedException, IOException {
		Excel E = new Excel(driver);
	    int ID = (int) E.ReadExcel(0,0,0);
		
		Login_M LMM = new Login_M(driver);
		Home_Page HPM = new Home_Page(driver);
		Order_Generated OG = new Order_Generated(driver);
	
		String	AppActivity = "com.dexit.yumboxmanager.activity.SplashActivity";
		String	AppPackage = "com.batse.batseexpressmanager";
		String Outlet = "Pizza Outlet" ;
		String OutletNumber = "1111000088";
		String Password = "123456";
		driver.startActivity(new Activity( AppPackage, AppActivity));
		try {
		if(LMM.loginHeader().isDisplayed()) {
			
			LMM.Login(OutletNumber, Password);
			OG.Accept_Order_Selected();
			 HPM.Preparing(ID);
			 HPM.Ready(ID);
		}
		}
		
		catch(NoSuchElementException E1) {
		try {
		 if (HPM.logout().isDisplayed()) {
			
			if(HPM.OutletName().getText().equalsIgnoreCase(Outlet)) {
				
				OG.Accept_Order_Selected();
				 HPM.Preparing(ID);
				 HPM.Ready(ID);
				
			}
			else if(HPM.OutletName().getText()!=Outlet){
				HPM.LOGOUT();
				LMM.Login(OutletNumber, Password);
				OG.Accept_Order_Selected();
				 HPM.Preparing(ID);
				 HPM.Ready(ID);
			}
		 }
		 
		}
		 
		 catch(NoSuchElementException E2) {
			 
			 if(OG.Order_ID()==ID) {
				 OG.Accept_Order_Selected();
				 HPM.Preparing(ID);
				 HPM.Ready(ID);
			 }
			 else if (OG.Order_ID()!=ID) {
				 OG.Refuse_Order();
			 }
			 
		 }
		
		}

	}
	
//________________________________________________________________________________________________________________________________________________	
	
				
	@Test(priority = 3 , enabled = false)	
	public void Rider_Delivered() throws IOException, InterruptedException {
		
		String	AppActivity = "com.example.onesis.splash.SplashActivity";
		String	AppPackage = "com.batse.batseexpressrider";
		
		
	    
	  Login_Rider  RL = new Login_Rider(driver);
	  Request_Generation RG = new Request_Generation(driver);
	  HomePage_Rider HPR = new HomePage_Rider(driver);
	  
		driver.startActivity(new Activity( AppPackage, AppActivity));
	  
	  RL.Login();
	  RG.Accept();
	  HPR.OrderPickUP();
	  HPR.ReachedLocation();
	  HPR.Deliver();

	}
	
	


//_________________________________________________________________________________________________________________________________________________________________

	@Test(dependsOnMethods = "MakeOrder_AllCustomozation1portion_CurrentLocation" , enabled = true)
	public void CancelRequestByUser() throws InterruptedException, IOException {
		
		String OutletName = "Peanut Automate" ;
		
		
		WaitingScreen W = new WaitingScreen(driver);
		W.CancelOrder(OutletName);
		CancellationScreen CS = new CancellationScreen(driver);
		CS.ValidateCancellationText();
		CS.ReturnToWallet();
		
	//ExpectedResult
		
		ProfileBatse P = new ProfileBatse(driver);
		P.ProfileTab();
		P.PaymentMethod();
		PaymentMethod PM = new PaymentMethod(driver);
		PM.WriteWalletAmount(0, 0, 1);
		Check_Out CO = new Check_Out(driver);
		SoftAssert SA = new SoftAssert();
		SA.assertEquals(PM.GetWalletAmount(), CO.WalletAmount()); // Validate Same Amount in wallet
		PM.ExistPage();
		
	}
	
//___________________________________________________________________________________________________________________________________________________________________________________________	
	
	@Test(dependsOnMethods = "CancelRequestByUser" , enabled = true)
	public void Check_Transaction() throws InterruptedException, IOException {
		
		ProfileBatse P = new ProfileBatse(driver);
		P.TransactionTab();
		Thread.sleep(2000);
		Transaction T = new Transaction(driver);
		T.ValidateTransaction();
		T.ExitPage();
		
		
		
	}
	
	@Test(dependsOnMethods = "Check_Transaction" , enabled = true)
	public void Order_History() throws InterruptedException, IOException {
		
		String Outlet = "Peanut Automate" ;
		String Item = "Moongfali" ;
		
		
		ProfileBatse P = new ProfileBatse(driver);
		P.Order_History();
		Thread.sleep(7000);
		POM.OrderHistory OH = new POM.OrderHistory(driver);
		OH.Validate_OrderHistory(Outlet, Item);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(enabled = true)
	public void TestInt() {
		String number = "1000500000.574";
		double amount = Double.parseDouble(number);
		DecimalFormat formatter = new DecimalFormat("#,###.00");

		System.out.println(formatter.format(amount));
		
	}
	
	@Test()
	public void OrderHistory() {
		
	}
	
	@Test()
	public void TransactionStatus() {
		
	}
	
	@Test()
	public void Profile() {
		
	}
	
	@Test()
	public void MakeOrderFromBanner() {
		
	}
	
	@Test()
	public void MakeOrderFromCart() {
		
	}
	
	@Test()
	public void MakeOrderFromCategories() {
		
	}
	
	@Test()
	public void TrackingStatus() {
		
	}
	
	
	
}
