package POM;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Outlet_Details {
	
	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Excel E;	
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/img_uncheck_box")
	private WebElement Customization;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_confirm")
	private WebElement Add;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_item_name")
	private WebElement Header;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'Please select add-ons']//following::android.widget.TextView[@index='2'][1]")
	private WebElement Customization_Price;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'Please select quantity']//following::android.widget.TextView[@index='0'][1]")
	private WebElement Portion_Price;
	
	public Outlet_Details(AndroidDriver<WebElement> driver) {
		E = new Excel(driver);
		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
	}

	public void Add_Customization(String ItemName) throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(Header, ItemName);
		MDF.Extract_int(Add);
		MDF.Click(Customization);
		Thread.sleep(2000);
		int Sum= MDF.SumAmount(Portion_Price, Customization_Price);
		int Total = MDF.Extract_int(Add);
		MDF.AssertPrice(Sum, Total);
		
	}
	
	public void Add() throws InterruptedException {
		Thread.sleep(2000);
		MDF.Click(Add);
	}
	
	public int Total_Price() {
		
		
	return MDF.SumAmount(Portion_Price, Customization_Price);

	}
	
	public int Total_Price_AllCustomization() throws IOException {
		
		
		return MDF.SumAmount_W2Int(Portion_Price, E.ReadExcel(1,0,0) );

		}
	
	
public void Add_ALL_Customization(String ItemName) throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(Header, ItemName);
		MDF.Extract_int(Add);
		MDF.SelectAllCustomization();
		Thread.sleep(2000);
		int Sum= MDF.SumAmount_W2Int(Portion_Price, E.ReadExcel(1,0,0));
		int Total = MDF.Extract_int(Add);
		MDF.AssertPrice(Sum, Total);
		
	}
	
}



