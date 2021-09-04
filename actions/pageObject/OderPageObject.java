package pageObject;

import org.openqa.selenium.WebDriver;

import commom.BasePage;

public class OderPageObject extends BasePage {
	WebDriver driver;
	public OderPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
