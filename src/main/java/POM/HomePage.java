package POM;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	 MobileDriverFactory MDF;
	 AndroidDriver<WebElement> driver;
	 
	 @FindBy(how=How.XPATH , using = "//android.widget.TextView[text()='Outlet Production India 2']")
	 private WebElement OutletName;
	 @FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'OutletName']/following::/android.widget.TextView[@text = 'Closed']")
	 private WebElement ClosedStatus ; 
	 
	 public HomePage(AndroidDriver<WebElement> driver) {
		 
		 MDF = new MobileDriverFactory(driver);
		 PageFactory.initElements(driver, this);
		 
		 
	 }
	
	public void Scroll_To_OutletList(String Outlet) throws InterruptedException {
	
		Thread.sleep(3000);
		MDF.Scroll_Down(Outlet);	
		
	
	}
	
	public void Select_Outlet(String Outlet) throws InterruptedException {
		
		Thread.sleep(1000);
		MDF.Get_Outlet(Outlet);
	}
	
public boolean Outlet_Status(String Outlet) throws InterruptedException {
		
	Thread.sleep(1000);
	return MDF.Check_Outlet_Status(Outlet);
		
	}
	
	 
	
	 
	 
}
