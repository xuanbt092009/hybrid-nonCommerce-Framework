package pageObject;

import org.openqa.selenium.WebDriver;

import commom.BasePage;

public class ShoppingCartPageObject extends BasePage {
	WebDriver driver;
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
