package com.dd.kayak.testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

public class LocatorProvider extends BaseDataProvider {
		
	public static Map<String, By> provideFor(String pageName)  { 
		XSSFWorkbook myExcelBook =null;
		Map<String, By> locatorMap=null;
		try {
		myExcelBook = new XSSFWorkbook(new FileInputStream(fileName));
		locatorMap = new  HashMap<String, By>();

			XSSFSheet myExcelSheet = myExcelBook.getSheet(pageName);
			for (int i=1;i<=myExcelSheet.getLastRowNum();i++)  {
				XSSFRow row = myExcelSheet.getRow(i);
				String name= row.getCell(0).getStringCellValue();
				String type= row.getCell(1).getStringCellValue();
				String value= row.getCell(2).getStringCellValue();
				locatorMap.put(name, convertToLocator(type, value));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				myExcelBook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return locatorMap;
		
		}
	
	private static By convertToLocator(String type,String value){

		By loc =null;
		switch (type.toLowerCase()) {
		case "id":
			loc = By.id(value);
			break;
		case "classname":
			loc = By.className(value);
			break;
		case "cssselector":
			loc = By.cssSelector(value);
			break;
		case "linktext":
			loc = By.linkText(value);
			break;
		case "name":
			loc = By.name(value);
			break;
		case "partiallinktext":
			loc = By.partialLinkText(value);
			break;
		case "tagname":
			loc = By.tagName(value);
			break;
		case "xpath":
			loc = By.xpath(value);
			break;
		default:
			loc = By.id(value);
			break;
		}
		return loc;
	}

	

}
