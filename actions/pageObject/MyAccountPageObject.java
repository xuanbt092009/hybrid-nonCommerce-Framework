package pageObject;

import org.openqa.selenium.WebDriver;

import commom.BasePage;

public class MyAccountPageObject extends BasePage {
WebDriver driver;
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
		
	}
}
