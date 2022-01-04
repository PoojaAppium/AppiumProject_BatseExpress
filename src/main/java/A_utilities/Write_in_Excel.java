package A_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import POM.Tracking;
import io.appium.java_client.android.AndroidDriver;

 

public class Write_in_Excel {
	
	WebDriver Driver;
	 
	
	public Write_in_Excel(WebDriver Driver) {
			
			this.Driver = Driver;
		}


	public void Write(int orderNo) throws IOException{
        
    	
        File file =    new File(".//TestData//OrderID.xlsx");
       
        FileInputStream inputStream = new FileInputStream(file);
        
       
        XSSFWorkbook  wbs = new XSSFWorkbook(inputStream);
        
        wbs.getSheetAt(0).createRow(0).createCell(0).setCellValue(orderNo);
        

        FileOutputStream outputStream = new FileOutputStream(".//TestData//OrderID.xlsx");
        wbs.write(outputStream);
        outputStream.close();
       
        
        

    }
}