package A_utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class DriverFactory {
	

	 WebDriver Driver ; 
	
	
	public DriverFactory(WebDriver Driver) {
		
		this.Driver = Driver;
	}
	
	public void EnterData(WebElement Space , String Text) throws InterruptedException {
		
		Actions Act = new Actions(Driver);
		Act.moveToElement(Space).click();
		Space.clear();
		Thread.sleep(1000);
		Space.sendKeys(Text);
	}
	
	public void Click(WebElement W) {
		
		  Actions Act = new Actions(Driver);
	 Act.moveToElement(W);
	 Act.click().build().perform();
		//Click.click();
	}
	
	public void AssertTitle(WebElement Title , String Text) {
		
	
	     String Actual = Title.getText();
		 SoftAssert SA = new SoftAssert();
		 SA.assertEquals(Actual, Text);
	
		// System.out.println("Title Verified: "+Text+"");
		
		
	}
	
	public void SearchAndEnter(WebElement Element , String Text) {
		
	
		
		Element.sendKeys(Text , Keys.ENTER);
		
	}
	
	public void print_TextFromWebElement(WebElement Element) {
		
		
		try {
		if(Element.isDisplayed()) {
		
		String Text = Element.getText();
		System.out.println(Text);
		
		}
		}
		catch(Exception e) {
				
			String Text = Element.getText();
			System.out.println(Text);
			
		}
		}
	
	
	
	public void NavigateToBack() {
		
		Driver.navigate().back();
	}
	
	
	public void SelectByDrpdwn(WebElement Element , String Text) {
		
		
		
		
		
		if(Element.isDisplayed()){
			try {
		Select Sel = new Select(Element);	
		Sel.selectByVisibleText(Text);
		
		}
		
		catch(Exception E) {
			
		}
		}
		
		else {
			System.out.println(""+Text+" -- Not Found in Product_DrpDwn");
		}
		
	}
	
	public void MoveToElement(int A) {
		
		new Actions(Driver).moveToElement(Driver.findElement(By.xpath("//android.widget.TextView[@text = '"+A+"']")));
	
	}

	
	
	
	
	
	
	
}
