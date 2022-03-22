package POM;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Outlet_Screen  {
	
	AndroidDriver<WebElement> driver;
	MobileDriverFactory MDF;
	Outlet_Details OD;
	Excel E;

	
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/restro_name")
	private WebElement header;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_add_btn")
	private WebElement Add;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_customization")
	private WebElement Customization_Available;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/itemsRv")
	private WebElement Item_List;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_total_price")
	private WebElement Total_Price;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/rl_add")
	private WebElement plus;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/cv_check_out")
	private WebElement VIEW_CART;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_total_price")
	private WebElement TotalPrice;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_item_name")
	private WebElement ItemName;
	
	
	
	
	
	public Outlet_Screen(AndroidDriver<WebElement> driver) {
		
	    E = new Excel(driver);
		MDF = new MobileDriverFactory(driver);
		OD = new Outlet_Details(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void Add_Item(String Outlet_Name , String Item_Name) throws InterruptedException, IOException {
		
		Thread.sleep(1000);
		MDF.AssertTitle(header, Outlet_Name);
	    String Item =	MDF.Extract_Text(ItemName);
	    E.WriteExcelString(0, 7, 0, Item);
		
		MDF.Click(Add);
		Thread.sleep(1000);
		OD.Add_Customization(Item_Name);
		Thread.sleep(1000);
        int T1 =  OD.Total_Price();
        OD.Add();
        int T2 = MDF.Extract_int(TotalPrice);
        MDF.AssertPrice(T1, T2);
        Thread.sleep(1000);

	}

	public int VIEW_CART_Ammount() {
		
		return MDF.Extract_int(Total_Price);
	}
	
public void Add_Item_AC(String Outlet_Name , String Item_Name) throws InterruptedException, IOException {
		
		Thread.sleep(1000);
		MDF.AssertTitle(header, Outlet_Name);
		MDF.Click(Add);
		Thread.sleep(1000);
		OD.Add_ALL_Customization(Item_Name);
		Thread.sleep(1000);
        int T1 =  OD.Total_Price_AllCustomization();
        OD.Add();
        int T2 = MDF.Extract_int(TotalPrice);
        MDF.AssertPrice(T1, T2);
        Thread.sleep(1000);

	}
	
	
}
