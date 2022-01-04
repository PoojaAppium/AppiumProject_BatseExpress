package A_utilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MobileDriverFactory {

	
	AndroidDriver<WebElement> driver ;
	
	
	public MobileDriverFactory(AndroidDriver<WebElement> driver)
	{
		this.driver = driver ;
	}
//*************************************************************************	
public void EnterData(WebElement Space , String Text) throws InterruptedException {
		
		Actions Act = new Actions(driver);
		Act.moveToElement(Space).click();
		Space.clear();
		Thread.sleep(1000);
		Space.sendKeys(Text);
	}

public void SendKey(WebElement Space , String Text) throws InterruptedException {
	
	Thread.sleep(1000);
	Space.sendKeys(Text);
}
	
	public void Click(WebElement W) {
		
		 W.click();
	}
	
	public void AssertTitle(WebElement Title , String Text) {
		
		
	     String Actual = Title.getText();
		 SoftAssert SA = new SoftAssert();
		 SA.assertEquals(Actual, Text);
}

	 public void Scroll1(String Ad) {
		  
		 try {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     HashMap<String, String> scrollObject = new HashMap<String, String>();
	     scrollObject.put("direction", "down");
	     scrollObject.put("xpath", "//android.widget.TextView[@text = '"+Ad+"']");
	     js.executeScript("mobile:scroll", scrollObject);
		 }
		 
		 catch(UnsupportedCommandException exe) {
			 
			 JavascriptExecutor js = (JavascriptExecutor) driver;
		     HashMap<String, String> scrollObject = new HashMap<String, String>();
		     scrollObject.put("direction", "down");
		     scrollObject.put("xpath", "//android.widget.TextView[@text = '"+Ad+"']");
		     js.executeScript("mobile:scroll", scrollObject);
		 }
	 }
	
	
		 
  public  void swipe(DIRECTION direction, long duration) {
	  
			    Dimension size = driver.manage().window().getSize();

			    int startX = 0;
			    int endX = 0;
			    int startY = 0;
			    int endY = 0;

			    switch (direction) {
			        case RIGHT:
			            startY = (int) (size.height / 2);
			            startX = (int) (size.width * 0.90);
			            endX = (int) (size.width * 0.05);
			            new TouchAction(driver)
			                    .press(PointOption.point(startX, startY))
			                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
			                    .moveTo(PointOption.point(endX, startY))
			                    .release()
			                    .perform();
			            break;

			        case LEFT:
			            startY = (int) (size.height / 2);
			            startX = (int) (size.width * 0.05);
			            endX = (int) (size.width * 0.90);
			            new TouchAction(driver)
			            .press(PointOption.point(startX, startY))
	                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
	                    .moveTo(PointOption.point(endX, startY))
	                    .release()
	                    .perform();

			            break;

			        case UP:
			            endY = (int) (size.height * 0.70);
			            startY = (int) (size.height * 0.30);
			            startX = (size.width / 2);
			            new TouchAction(driver)
			            .press(PointOption.point(startX, startY))
	                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
	                    .moveTo(PointOption.point(endX, startY))
	                    .release()
	                    .perform();
			            break;


			        case DOWN:
			            startY = (int) (size.height * 0.70);
			            endY = (int) (size.height * 0.30);
			            startX = (size.width / 2);
			            new TouchAction(driver)
			            .press(PointOption.point(startX, startY))
	                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
	                    .moveTo(PointOption.point(endX, startY))
	                    .release()
	                    .perform();

			            break;

			    }
			}
  
  public enum DIRECTION {
	    DOWN, UP, LEFT, RIGHT;
	}
		 
	 
	 
	 
	 public void Scroll_Down() throws InterruptedException {
		 
		 Thread.sleep(3000);
		 
		 //The viewing size of the device
		    Dimension size = driver.manage().window().getSize();
		  
		    //x position set to mid-screen horizontally
		    int width = size.width / 2;

		    //Starting y location set to 80% of the height (near bottom)
		    int startPoint = (int) (size.getHeight() * 0.80);

		    //Ending y location set to 20% of the height (near top)
		    int endPoint = (int) (size.getHeight() * 0.20);

		    TouchAction action = new TouchAction(driver);
		    action.press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint)).release().perform();

	 }
	 
	public void Get_Outlet(String outlet) {
		
		WebElement Ele = driver.findElement(By.xpath("//android.widget.TextView[@text='"+outlet+"']"));
	    Ele.click();
	
	}
	
	public int Extract_int(WebElement Ele) {
		
		
		String Price = Ele.getText();
		String A = Price.replaceAll("[^0-9]", "");
		int Amount = Integer.parseInt(A);
		System.out.println(Amount);
		 return Amount ;
	}
	 
	public int SumAmount(WebElement Ele1 , WebElement Ele2 ) {
		

		String Price1 = Ele1.getText();

		String AA = Price1.replaceAll("[^0-9]", "");
		int Amount1 = Integer.parseInt(AA);
	
		 
		 String Price2 = Ele2.getText();
			String BB = Price2.replaceAll("[^0-9]", "");
			int Amount2 = Integer.parseInt(BB);
			
		
		int Sum = Amount1 + Amount2;
		
		System.out.println(Sum);
		
		return Sum;
		

		
	}
	
	public void AssertPrice(int A , int B) {
		
		SoftAssert SA = new SoftAssert();
		
		SA.assertEquals(A, B);
		
		
	}
	
	public WebElement AddressSelection(String A ) {
		
		return driver.findElement(By.xpath("//android.widget.TextView[@text = '"+A+"']"));
		
	}
	
public WebElement AddressSelection_Type(String A ) {
		
		return driver.findElement(By.xpath("//android.widget.TextView[@text = '"+A+"']"));
		
	}
	
	
	
public String Extract_Text(WebElement Ele) {
	
	
	String Text = Ele.getText();
	
	System.out.println(Text);
	
	return Text;
	 
}

public void WaitForElement(WebElement Ele) {
	
	WebDriverWait wait = new WebDriverWait (driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Ele));
	 
}

//______________________________________________________________________________________________________________________________________________________________________________________________________________
	

	
	
	public boolean Check_Outlet_Status(String Outlet)  {
		

	
	try {
		
		WebElement  element  = driver.findElement(By.xpath("//android.widget.TextView[@text= '"+Outlet+"']//following-sibling::android.widget.TextView[@text= 'Closed']"));
		
         if (element.isDisplayed()==true){
        	 return true;
         }
         else {
        	 return false;
         }
    } 
	
	catch (NoSuchElementException e) {
		

        return false;
    }
}
	
	

	
public void Validate_Switch_Status( String Outlet)  {
		
		//Closing The batse App. , Opening Manager App. then checking Switch Status and opening If switch is closed . 
		
		WebElement  closed1  = driver.findElement(By.className("android.widget.RelativeLayout"));
		String text = closed1.getText();
		System.out.println(text);
		
		if (text == Outlet && text == "Closed") {
			driver.quit();
		}}
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

