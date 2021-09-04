package pageObject;

import org.openqa.selenium.WebDriver;

import commom.BasePage;

public class SearchPageObject extends BasePage{
   WebDriver driver;
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
