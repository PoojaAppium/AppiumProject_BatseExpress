package Script;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM_Manager.Login_M;
import POM_Manager.Order_Generated;

public class Scenarios_Manager extends BaseClass_Manager {

	String Outlet = "Paneer" ;

	@Test()
	public void Manager_Login() throws InterruptedException {

		Login_M L = new Login_M(driver);
		L.Login("9999000077", "123456" );
		
	}
		
		@Test(dataProvider = "OrderId")
		public void Dispatch_Order(int orderID) throws InterruptedException, IOException {

			Login_M L = new Login_M(driver);
			L.Login("9999777711", "123456");
			Order_Generated OG = new Order_Generated(driver);
		    OG.Accept_Order_Selected();
	}
	
}
