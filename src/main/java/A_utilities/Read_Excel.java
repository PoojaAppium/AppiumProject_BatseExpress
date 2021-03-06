package A_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Read_Excel {
	WebDriver Driver ; 
	
public Read_Excel(WebDriver Driver) {
		
		this.Driver = Driver;
	}

    public int Read(int sheet ,int row , int cell ) throws IOException {   
        //Create an object of File class to open xlsx file
        File file =    new File(".\\TestData\\OrderID.xlsx");
        
        FileInputStream inputStream = new FileInputStream(file);
        

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
  
        //Creating a Sheet object using the sheet Name
       int orderID =  (int) wb.getSheetAt(sheet).getRow(row).getCell(cell).getNumericCellValue();
 
       System.out.println(orderID);
        return orderID;
       
        
       
    }
    
    
    
    public String ReadString(int sheet ,int row , int cell ) throws IOException {   
        //Create an object of File class to open xlsx file
        File file =    new File(".\\TestData\\OrderID.xlsx");
        
        FileInputStream inputStream = new FileInputStream(file);
        

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
  
        //Creating a Sheet object using the sheet Name
       String Data =   wb.getSheetAt(sheet).getRow(row).getCell(cell).getStringCellValue();
 
       System.out.println(Data);
        return Data;
       
        
       
    }
    
    
    
    
    
    
    
    
    
    
    
}