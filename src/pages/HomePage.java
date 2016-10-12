package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dd.kayak.testdata.LocatorProvider;

public class HomePage extends WebPage{
	
	Map<String, By> locators;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		locators = LocatorProvider.provideFor(this.getClass().getSimpleName());
		for ( String locator: locators.keySet()) {
			System.out.println(locator);
			System.out.println(locators.get(locator));
		}
	}
	
	public FlightsPage navigateToFlightsPage(){
		WebElement flightEL = driver.findElement(locators.get("flightsMenuLnk"));
		flightEL.click();
		FlightsPage fp = new FlightsPage(driver);
		return fp;
	}
	
	public void load(String url) {
		this.driver.get(url);
	}
	
}
