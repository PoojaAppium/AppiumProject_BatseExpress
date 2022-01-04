package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import A_utilities.MobileDriverFactory;
import io.appium.java_client.android.AndroidDriver;

public class Address {
	
	MobileDriverFactory MDF;
	AndroidDriver<WebElement> driver;
	
	
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/et_num")
	private WebElement MobileNumber;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_complete_address")
	private WebElement CompanyAddress;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_landmark")
	private WebElement LandMark;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/rb_one")
	private WebElement Home;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/rb_twos")
	private WebElement Office;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/rb_three")
	private WebElement Other;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/tv_confirm")
	private WebElement Submit;
	@FindBy(how=How.ID , using = "com.batse.batseexpress:id/et_other")
	private WebElement OtherTextBox;
	@FindBy(how=How.XPATH , using = "//android.widget.TextView[@text = 'Add New Location']")
	private WebElement Header;
	
	
	public Address(AndroidDriver<WebElement> driver) {

		MDF = new MobileDriverFactory(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void Add_Address(String completeAdress ,String lanMark ) throws InterruptedException {
		
		Thread.sleep(2000);
		MDF.AssertTitle(Header, "Add New Location");
		MDF.EnterData(CompanyAddress, completeAdress);
		MDF.EnterData(LandMark, lanMark);
		Thread.sleep(2000);
		MDF.Click(Home);
		MDF.Click(Submit);
	}

}
