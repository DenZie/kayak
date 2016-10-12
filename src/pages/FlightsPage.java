package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dd.kayak.testdata.TravelInfo;

public class FlightsPage extends HomePage{
	By originLoc = By.name("origin");
	By destLoc = By.name("destination");
	By startDtLoc = By.name("");
	By returnDtLoc = By.name("");
	By datepickerLoc = By.id("datepicker");
	By searchButtonLoc = By.name("");
	
	public FlightsPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}

	public SearchResultsPage searchFlights(TravelInfo ti) {
		driver.manage().window().maximize();
		String masterId = getMasterId();
		WebElement originEl = driver.findElement(locators.get("originLoc"));
		originEl.sendKeys(ti.getOrigin());
		WebElement londonLnkEl = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(locators.get("originLnkLoc")));
		londonLnkEl.click();
		WebElement destEl = driver.findElement(locators.get("destLoc"));
		destEl.sendKeys(ti.getDestination());
		WebElement newyorkLnkEl = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(locators.get("destLnkLoc")));
		newyorkLnkEl.click();
		
		startDtLoc = By.id(masterId +  "-travelDates-start-placeholder");
		driver.findElement(startDtLoc).click();
		driver.findElement(locators.get("datepicker")).click();
		By traverlersLoc = By.id(masterId +  "-travelers");
		driver.findElement(traverlersLoc).click();
		By cabinTypeLoc = By.id(masterId +  "-cabinType-select");
		Select cabinTypeSel = new Select(driver.findElement(cabinTypeLoc));
		cabinTypeSel.selectByValue("b");
		WebElement countIncreaseEl =  driver.findElement(By.id(masterId +  "-adults")).findElement(By.xpath("//div/div[3]/button"));
		countIncreaseEl.click();
		driver.findElement(locators.get("closeLnkLoc")).click();
		By searchButton = By.id(masterId +  "-submit");
		driver.findElement(searchButton).submit();
		SearchResultsPage srpge = new SearchResultsPage(driver);
		return srpge;
	}
	
	public String getMasterId() {
		WebElement flightSearchdiv = driver.findElement(By.cssSelector("div.Flights-Search-FlightSearchForm.fd"));
		String masterID = flightSearchdiv.getAttribute("id");
		return masterID;
		
	}
}
