package POM;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import A_utilities.Write_in_Excel;
import io.appium.java_client.android.AndroidDriver;


public class WaitingScreen {

	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	Alert A ;
	Write_in_Excel WIE;
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_o_id")
	private WebElement OrderID;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/outletRl")
	private WebElement OutletName;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/boldHeadingTv")
	private WebElement HeadingText;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/bodyTxtTv")
	private WebElement SorryMessage;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/callOutletBigIv")
	private WebElement CallToOutlet;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/cancelOrderTv")
	private WebElement CancelOrderButton;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/img_back")
	private WebElement backButton;
	
	
	public WaitingScreen(AndroidDriver<WebElement> driver) {
		
		A = new Alert(driver);
		MDF = new MobileDriverFactory(driver);
		WIE = new Write_in_Excel(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void CancelOrder(String Name) throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(OutletName, Name);
		MDF.AssertTitle(HeadingText, "¡ESPERA A QUE EL NEGOCIO ACEPTE TU PEDIDO!");
		MDF.AssertTitle(SorryMessage, "Si este no es aceptado en 3 minutos, te recomendamos llamar al negocio para confirmar el estado del pedido");
		MDF.Click(CancelOrderButton);
		Thread.sleep(2000);
		A.AcceptAlert();
		
		
	}
	
	public int OrderID() {
		return MDF.Extract_int(OrderID);
		
	}
	
	public void WriteOrderID(int sheet , int row , int cell ) throws IOException, InterruptedException {
		WIE.Write(sheet, row , cell ,OrderID());
	}
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
