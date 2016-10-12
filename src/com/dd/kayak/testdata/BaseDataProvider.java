package com.dd.kayak.testdata;

import org.openqa.selenium.By;

public class BaseDataProvider {
	public static String fileName ;	
		
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
