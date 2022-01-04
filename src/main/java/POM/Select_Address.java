package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Select_Address {
	
	AndroidDriver<WebElement> driver;
	MobileDriverFactory MDF ;
	Address A ;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_add_new_address")
	private WebElement AddNewAddress;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/selectedAddressLl")
	private WebElement CurrentLocation;
	
	
	
	public Select_Address(AndroidDriver<WebElement> driver) {
		
		
		A = new Address(driver);
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
		
	}

	
	public void SelectAddress(String AddressType) throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AddressSelection_Type(AddressType);
		
	}
	
	
	public void Add_newAddress(String CompleteAddress , String LandMark ) throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.Click(AddNewAddress);
		A.Add_Address(CompleteAddress, LandMark);
		
	}
	
	
}
