package POM;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import A_utilities.Read_Excel;
import A_utilities.Write_in_Excel;
import io.appium.java_client.android.AndroidDriver;

public class Tracking {
	
	
	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Write_in_Excel WIE;
	Read_Excel RE;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_o_id")
	private WebElement id_no;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/img_accepted")
	private WebElement accepted;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/img_processing")
	private WebElement processing;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/img_ready")
	private WebElement ready;
	@FindBy(how=How.XPATH , using = "com.batse.batseexpress:id/img_dispatched")
	private WebElement dispatched;
	@FindBy(how=How.XPATH , using = "com.batse.batseexpress:id/img_delivered")
	private WebElement delivered;
	
	
	
	public Tracking(AndroidDriver<WebElement> driver) {
	   super();
		WIE = new Write_in_Excel(driver);
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
	}
	
	public int order_id() throws InterruptedException {
		
		Thread.sleep(2000);
		return MDF.Extract_int(id_no);
		
	}
	
	public void WriteOrderID(int sheet , int row , int cell ) throws IOException, InterruptedException {
		WIE.Write(sheet, row , cell ,order_id());
	}
   
	public void ReadOrderID(int sheet , int row , int cell ) throws IOException {
		RE.Read(sheet , row , cell);
	}

}
