package Script;

import org.testng.annotations.Test;

import java.io.IOException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;

import POM.Excel;
import POM.HomePage;
import POM.Order_Details;
import POM.Outlet_Screen;
import POM.Tracking;
import POM_Manager.Home_Page;
import POM_Manager.Login_M;
import POM_Manager.Order_Generated;
import io.appium.java_client.android.Activity;

public class scenarios_User extends BaseClass_User {

	
	@Test(priority = 1 , enabled = true)
	public void MakeOrder() throws InterruptedException, IOException {
		
		String MobileNumber = "8210157528" ;
		String FirstName = "A" ;
		String MiddleName = "B" ;
		String LastName = "Test" ;
		String NationalID = "1234567890" ;
		String Email = "ab1@gmail.com" ;
		String Password = "123456" ;
		String Outlet = "Orange Outlet" ;
		String Item = "Orange outlet" ;
		
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
		  Tracking T = new Tracking(driver);
		//  int id = T.order_id();
		  T.WriteOrderID();
		//  System.out.println(id);
		//  ((AndroidDriver)driver).runAppInBackground(Duration.ofSeconds(40));
		  
		
		}
	 }
	
	@Test(priority =2 , invocationCount=1 , enabled = true )
	public void DispatchOrder() throws InterruptedException, IOException {
		Excel E = new Excel(driver);
	    int ID = (int) E.ReadExcel();
		
		Login_M LMM = new Login_M(driver);
		Home_Page HPM = new Home_Page(driver);
		Order_Generated OG = new Order_Generated(driver);
	
		String	AppActivity = "com.dexit.yumboxmanager.activity.SplashActivity";
		String	AppPackage = "com.batse.batseexpressmanager";
		String Outlet = "Orange Outlet" ;
		String OutletNumber = "8888000011";
		String Password = "123456";
		driver.startActivity(new Activity( AppPackage, AppActivity));
		try {
		if(LMM.loginHeader().isDisplayed()) {
			
			LMM.Login(OutletNumber, Password);
			OG.Accept_Order_Selected();
		}
		}
		
		catch(NoSuchElementException E1) {
		try {
		 if (HPM.logout().isDisplayed()) {
			
			if(HPM.OutletName().getText().equalsIgnoreCase(Outlet)) {
				
				OG.Accept_Order_Selected();
				
			}
			else if(HPM.OutletName().getText()!=Outlet){
				HPM.LOGOUT();
				LMM.Login(OutletNumber, Password);
				OG.Accept_Order_Selected();
			}
		 }
		 
		}
		 
		 catch(NoSuchElementException E2) {
			 
			 if(OG.Order_ID()==ID) {
				 OG.OrderAccept();
			 }
			 else if (OG.Order_ID()!=ID) {
				 OG.Refuse_Order();
			 }
			 
		 }
		
		}

	}
				
		
	

	
}
