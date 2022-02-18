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
	
	public int ReadExcel(int sheet ,int row , int cell) throws IOException {
	return RWE.Read(sheet , row , cell );
		
	}

	public void WriteExcel(int sheet ,int row , int cell , int orderNo) throws IOException {
		WIE.Write(sheet , row , cell , orderNo);
	}

	public String ReadExcelString(int sheet ,int row , int cell) throws IOException {
		return RWE.ReadString(sheet , row , cell );
			
		}
	public void WriteExcelString(int sheet ,int row , int cell , String Data) throws IOException {
		WIE.WriteString(sheet , row , cell , Data);
	}
	
//________________________________________________________________________________________________________________
	
	public void Write_OutletName(int sheet ,int row , int cell , int orderNo) throws IOException {
		WIE.Write(sheet , row , cell , orderNo);
	}
	
	public void Write_ItemName(int sheet ,int row , int cell , int orderNo) throws IOException {
		WIE.Write(sheet , row , cell , orderNo);
	}
	
	public void Write_Portion(int sheet ,int row , int cell , int orderNo) throws IOException {
		WIE.Write(sheet , row , cell , orderNo);
	}
	
	public void Write_Customization(int sheet ,int row , int cell , int orderNo) throws IOException {
		WIE.Write(sheet , row , cell , orderNo);
	}
	
	public void Write_OrderID(int sheet ,int row , int cell , int orderNo) throws IOException {
		WIE.Write(sheet , row , cell , orderNo);
	}
	
	public void Write_WalletAmount(int sheet ,int row , int cell , int orderNo) throws IOException {
		WIE.Write(sheet , row , cell , orderNo);
	}
	
	public void Write_PaybleAmount(int sheet ,int row , int cell , int orderNo) throws IOException {
		WIE.Write(sheet , row , cell , orderNo);
	}
	
	public void Write_ItemAmount(int sheet ,int row , int cell , int orderNo) throws IOException {
		WIE.Write(sheet , row , cell , orderNo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
