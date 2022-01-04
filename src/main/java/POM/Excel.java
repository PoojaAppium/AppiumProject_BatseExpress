package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import A_utilities.DriverFactory;
import A_utilities.Read_Excel;
import A_utilities.Write_in_Excel;

public class Excel {
	
	DriverFactory DF;
	Read_Excel RWE;
	Write_in_Excel WIE;
	
	public Excel(WebDriver driver) {
		super();
		DF = new DriverFactory(driver);
		RWE = new Read_Excel(driver);
		WIE = new Write_in_Excel(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public double ReadExcel() throws IOException {
	return RWE.Read();
		
	}

	public void WriteExcel(int value) throws IOException {
		WIE.Write(value);
	}

	
}
