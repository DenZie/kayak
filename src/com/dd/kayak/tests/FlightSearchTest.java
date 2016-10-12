package com.dd.kayak.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dd.kayak.testdata.TestDataProvider;
import com.dd.kayak.testdata.TravelInfo;

import pages.FlightsPage;
import pages.HomePage;
import pages.SearchResultsPage;

public class FlightSearchTest extends BaseTest{
	WebDriver driver;
	@BeforeClass
	public void initialise() {
		driver= new FirefoxDriver();
	}
	
	@Test(dataProvider="flightSearchData", dataProviderClass=TestDataProvider.class)
	public void searchandDisplayResults(TravelInfo ti) {
//		TravelInfo ti = new TravelInfo();
		HomePage hp = new HomePage(driver);
		hp.load("https://www.kayak.com/flights");
		FlightsPage fltPge = hp.navigateToFlightsPage();
		SearchResultsPage srPge= fltPge.searchFlights(ti);
		srPge.storeSearchResult();
		
		
//		SearchResultsPage srPge= new SearchResultsPage(driver);
//		srPge.load("https://www.kayak.com/flights/LON-NYC/2017-02-01/2017-02-02/business/2adults");
//		srPge.storeSearchResult();
		
	}

}
