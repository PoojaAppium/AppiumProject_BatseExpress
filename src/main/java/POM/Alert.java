package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Alert{

	AndroidDriver<WebElement> driver;
	MobileDriverFactory MDF;
	
	
	@FindBy(how=How.ID , using ="com.batse.batseexpress:id/modeText")
	private WebElement YES;
	@FindBy(how=How.ID , using ="com.batse.batseexpress:id/cancelText")
	private WebElement NO;
	
	public Alert(AndroidDriver<WebElement> driver) {
		
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void AcceptAlert() throws InterruptedException {
		
		Thread.sleep(1000);
		MDF.Click(YES);
	}
	
	
	
	
	
}
