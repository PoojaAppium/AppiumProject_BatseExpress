package Script;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass_Manager {
	
	AndroidDriver<WebElement> driver;
	
	@BeforeMethod()
	
	public void SetUp()  {
		
		try{
		String	AppActivity = "com.dexit.yumboxmanager.activity.SplashActivity";
		String	AppPackage = "com.batse.batseexpressmanager";
			
			
		DesiredCapabilities DC = new DesiredCapabilities();
		DC.setCapability("PlatformVersion", "11");
		DC.setCapability("deviceName", "OnePlus Nord2 5G");
		DC.setCapability("UDID", "QOKNMJVCJFL7YPOF");
		DC.setCapability("platformName", "Android");
		DC.setCapability("appActivity", AppActivity);
		DC.setCapability("appPackage", AppPackage);
		DC.setCapability("automationName", "UiAutomator2");
		DC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		DC.setCapability("noSign", true);
		DC.setCapability("autoGrantPermissions",true);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		
		driver = new AndroidDriver<WebElement>(url,DC);
		driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS); 
		System.out.println("System Started");
		
		Thread.sleep(5000);
		
		}
		catch(Exception exe) {
			exe.printStackTrace();
		}
		
		
	}
	
	
	@AfterMethod()
	
public void Quit() {
		
		driver.quit();
		
	}
	



}
