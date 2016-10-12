package com.dd.kayak.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.dd.kayak.testdata.BaseDataProvider;

public class BaseTest {
	WebDriver driver;
	@BeforeSuite
	@Parameters({"testdata", "browser"})
	public void initialize(String testDatafile, String browser) {
		BaseDataProvider.fileName = testDatafile;
	}
	
	public void createDriver(String browserName) {
		
		switch (browserName) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "internetexplorer":
			driver = new InternetExplorerDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "opera":
			driver = new OperaDriver();
			break;
		default:
			driver = new FirefoxDriver();
			break;
		}
	}

}
