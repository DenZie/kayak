package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchResultsPage extends HomePage{
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}

	public void storeSearchResult() {
		WebElement secondRowEl = driver.findElement(locators.get("secRowLoc"));
		System.out.println(secondRowEl.getAttribute("data-index"));
		String secondRowId = secondRowEl.getAttribute("id");
		secondRowId = secondRowId.replace("tbd", "");
		System.out.println(secondRowId);
		By priceLoc = By.xpath("//div[@id='priceAnchor" + secondRowId+"']/a");
		String price = driver.findElement(priceLoc).getText();
		By airLineLoc = By.xpath("//div[@id='infolink" + secondRowId+"']/div[2]/div[2]/div[2]");
		String airlineName = driver.findElement(airLineLoc).getText();
		System.out.println(airlineName);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
           try {
			FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		originEl.sendKeys(ti.getOrigin());
//		WebElement destEl = driver.findElement(destLoc);
//		destEl.sendKeys(ti.getDestination());
//		String masterId = getMasterId();
//		startDtLoc = By.id(masterId +  "-travelDates-start-display");
////		By class = By.id(masterId +  "-travelers");
//		By cabinTypeLoc = By.id(masterId +  "-cabinType-select");
//		Select cabinTypeSel = new Select(driver.findElement(cabinTypeLoc));
//		cabinTypeSel.selectByValue("b");
//		WebElement countIncreaseEl =  driver.findElement(By.id(masterId +  "-adults")).findElement(By.xpath("//div/div[3]/button"));
//		countIncreaseEl.click();
//		By closeLnkLoc = By.className("closeLink");
//		driver.findElement(closeLnkLoc).click();
//		searchButton = By.id(masterId +  "-submit");
//		driver.findElement(searchButtonLoc).submit(); 
	}
	
	public void load(String url) {
		this.driver.get(url);
	}
	
	
}
