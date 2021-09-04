package pageObject;

import org.openqa.selenium.WebDriver;

import commom.BasePage;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
	waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
	clickToElement(driver, HomePageUI.REGISTER_LINK);	
	}

	public boolean verifySliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isDisplayed(driver, HomePageUI.HOME_PAGE_SLIDER);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElementByJS(driver, HomePageUI.LOGIN_LINK);
	}

	public RegisterPageObject getRegisterPage() {
		return new RegisterPageObject(driver);
	}

	public LoginPageObject getLoginPage() {
		return new LoginPageObject(driver);
	}

	

}


