package com.dd.kayak.testdata;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseDataProvider{
	
	@DataProvider
	public static Object[][] flightSearchData() throws IOException { 
		XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(fileName));
		Object[][] td = null;
		try {
			XSSFSheet myExcelSheet = myExcelBook.getSheet("TravelSearchData");
			td = new Object[myExcelSheet.getLastRowNum()][1];
			
			for (int i=1;i<=myExcelSheet.getLastRowNum();i++)  {
				XSSFRow row = myExcelSheet.getRow(i);
				TravelInfo ti = new TravelInfo() ;
				ti.setOrigin(row.getCell(0).getStringCellValue());
				ti.setDestination(row.getCell(1).getStringCellValue());
				ti.setClassType(row.getCell(4).getStringCellValue());
				td[i-1][0] =  ti;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			myExcelBook.close(); 
		}
		return td;
		}

	

}
