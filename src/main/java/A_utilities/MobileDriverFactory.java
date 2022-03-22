package A_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import io.appium.java_client.MobileBy;
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
			            startY = (int) (size.height / 5);
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
		 
  public void Get_Outlet(String outlet) {
		
		WebElement Ele = driver.findElement(By.xpath("//android.widget.TextView[@text='"+outlet+"']"));
	    Ele.click();
	
	}
  
  public WebElement Outlet(String outlet) {
		
		return driver.findElement(By.xpath("//android.widget.TextView[@text='"+outlet+"']"));
	  
	
	}
  
  
  public void Scroll_Down() {
	 
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
  
	
	 
	 
	 public void Scroll_Down(String outlet) throws InterruptedException {
		 
		 Thread.sleep(3000);
		 
		 try {
			
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
				    
			  
		    Outlet(outlet).isDisplayed();
		 }
		 
		 catch(NoSuchElementException E) {
			 
	
				  //The viewing size of the device
				    Dimension size1 = driver.manage().window().getSize();
				  
				    //x position set to mid-screen horizontally
				    int width1 = size1.width / 2;

				    //Starting y location set to 80% of the height (near bottom)
				    int startPoint1 = (int) (size1.getHeight() * 0.80);

				    //Ending y location set to 20% of the height (near top)
				    int endPoint1 = (int) (size1.getHeight() * 0.20);

				    TouchAction action1 = new TouchAction(driver);
				    action1.press(PointOption.point(width1, startPoint1)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width1, endPoint1)).release().perform();
		
			    Outlet(outlet).isDisplayed();
		 }
	 }
	 
	
	public int Extract_int(WebElement Ele) {
		
		
		String Price = Ele.getText();
		String A = Price.replaceAll("[^0-9]", "");
		int Amount = Integer. parseInt(A);    
		System.out.println(Amount);
		 return Amount ;
	
	}
	 
	public int SumAmount(WebElement Ele1 , WebElement i ) {
		

		String Price1 = Ele1.getText();

		String AA = Price1.replaceAll("[^0-9]", "");
		int Amount1 = Integer. parseInt(AA);
	       
	
		
	
		
		 
		 String Price2 = i.getText();
			String BB = Price2.replaceAll("[^0-9]", "");
		    int Amount2 = Integer. parseInt(BB);
		       
			
			
		
		int Sum = Amount1 + Amount2;
		
		System.out.println(Sum);
		
		return Sum;
		

		
	}
	
public int SumAmount_W2Int(WebElement Ele1 , int i ) {
		

		String Price1 = Ele1.getText();

		String AA = Price1.replaceAll("[^0-9]", "");
		String string_temp1 = new Double(AA).toString();
		String string_form1 = string_temp1.substring(0,string_temp1.indexOf('.'));
		double t1 = Double.valueOf(string_form1);
		int Amount1 = (int)t1;
	
		int Sum = Amount1 + i;
		
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

public void WaitForElement(int Seconds , WebElement Ele) {
	
	WebDriverWait wait = new WebDriverWait (driver, Seconds);
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



public void MoveToElement(int A , String text) {
	
	new Actions(driver).moveToElement(driver.findElement(By.xpath("//android.widget.TextView[@text = '"+A+"']//following::android.widget.TextView[@text = '"+text+"'][1]")));

}	
	
public void ChangeStatus(int OrderID , String text) {
	WebElement Ele =driver.findElement(By.xpath("//android.widget.TextView[@text = '"+OrderID+"']//following::android.widget.TextView[@text = '"+text+"'][1]"));
    Ele.click();

}
	

public int AllItem() {
	
	List<WebElement> items_AddButton = driver.findElements(By.xpath("//android.widget.TextView[@text = 'ADD']"));
	int no_of_ADD = items_AddButton.size();
	System.out.print(no_of_ADD);
	
	return no_of_ADD;

	
}

public void SelectAllCustomization() throws IOException {
	
	List<WebElement> customizationNo = driver.findElements(By.id("com.batse.batseexpress:id/img_uncheck_box"));
	int no_of_Cus = customizationNo.size();
	System.out.print(no_of_Cus);
	
for (int i = 1 ;  i<=no_of_Cus ; i++) {
	
	 WebElement CheckBox = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Please select add-ons']//following::android.widget.ImageView[@index = '0']["+i+"]"));
	 CheckBox.click();

	 WebElement price_C = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Please select add-ons']//following::android.widget.TextView[@index = '2']["+i+"]"));
	   String Price = price_C.getText();
	   String A = Price.replaceAll("[^0-9]", "");
	   int Amount = Integer. parseInt(A);
	   Write_in_Excel W = new Write_in_Excel(driver);
	   W.Write(0, 5+i, 0, Amount);
	

}

int Total = 0 ;

for(int j = 1 ; j<=no_of_Cus ; j++) {



   Read_Excel R = new Read_Excel(driver);
   int  Cj  = R.Read(0, 5+j, 0);
   Total = Total + Cj ;
   Write_in_Excel W = new Write_in_Excel(driver);
   W.Write(1, 0, 0, Total);                        ///// Total customization written here
   

  }
 
System.out.println(Total);
  

}


public void scrollByID_Manager() {
	String Id = "com.batse.batseexpressmanager:id/h_scroll_view" ;
    try {

         driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+Id+"\").instance(2));")); 

    } catch (Exception e) {
       e.printStackTrace();
    }
}


public void Back() {
	
	WebElement Back = driver.findElement(By.id("com.batse.batseexpress:id/img_back"));
	Back.click();
	
	
}


public boolean OrderHistory_Validate_OutletName(String Outletname) {
	
	return Outlet(Outletname).getText().equalsIgnoreCase(Outletname);

	
	
}

public WebElement Text_WebElement(String Text) {
	
	return driver.findElement(By.xpath("//android.widget.TextView[@text='"+Text+"']"));
	
}



public void SelectAll_Item(String itemName) throws IOException {
	
	List<WebElement> customizationNo = driver.findElements(By.id("com.batse.batseexpress:id/itemsRv"));
	int no_of_item = customizationNo.size();
	System.out.print(no_of_item);
	
for (int i = 1 ;  i<=no_of_item ; i++) {
	
	 WebElement Add = driver.findElement(By.xpath("//android.widget.TextView[@text = '"+itemName+"']//following::android.widget.ImageView[@text = 'ADD']["+i+"]"));
	 Add.click();
	 WebElement CheckBox = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Please select add-ons']//following::android.widget.ImageView[@index = '0']["+i+"]"));
	 CheckBox.click();

	 WebElement price_C = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Please select add-ons']//following::android.widget.TextView[@index = '2']["+i+"]"));
	   String Price = price_C.getText();
	   String A = Price.replaceAll("[^0-9]", "");
	   int Amount = Integer. parseInt(A);
	   Write_in_Excel W = new Write_in_Excel(driver);
	   W.Write(0, 5+i, 0, Amount);
	

}

int Total = 0 ;

for(int j = 1 ; j<=no_of_item ; j++) {



   Read_Excel R = new Read_Excel(driver);
   int  Cj  = R.Read(0, 5+j, 0);
   Total = Total + Cj ;
   Write_in_Excel W = new Write_in_Excel(driver);
   W.Write(1, 0, 0, Total);                        ///// Total customization written here
   

  }
 
System.out.println(Total);
  

}	


public WebElement Status_Manager(int OrderID , String text) {
	WebElement Ele =driver.findElement(By.xpath("//android.widget.TextView[@text = '"+OrderID+"']//following::android.widget.TextView[@text = '"+text+"'][1]"));
   return Ele;

}
	
public void Scroll_Downward(int OrderID , String text) throws InterruptedException {
	
	//WebElement element =driver.findElement(By.xpath("//android.widget.TextView[@text = '"+OrderID+"']//following::android.widget.TextView[@text = '"+text+"'][1]"));
	  
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//android.widget.TextView[@text = '"+OrderID+"']//following::android.widget.TextView[@text = '"+text+"'][1]"))
	  );
	Thread.sleep(500); 
	
	
}






}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

