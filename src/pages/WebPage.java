package pages;

import org.openqa.selenium.WebDriver;

public class WebPage {
	protected WebDriver driver;
	
	public WebPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
