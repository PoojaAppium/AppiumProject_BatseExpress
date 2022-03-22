package POM;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import A_utilities.Write_in_Excel;
import io.appium.java_client.android.AndroidDriver;

public class TrackingStatus {


	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Write_in_Excel WIE;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_o_id")
	private WebElement OrderID;
	
	
	
	
	public TrackingStatus(AndroidDriver<WebElement> driver) {
		
		
		MDF = new MobileDriverFactory(driver);
		WIE = new Write_in_Excel(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void Exit_Page(){
		
		MDF.Back();

	}
	
	
	
	
	
}
