package pageObject;

import org.openqa.selenium.WebDriver;

import commom.BasePage;
import commom.PageGeneratorManager;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
	waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
	clickToElement(driver, HomePageUI.REGISTER_LINK);	
	return PageGeneratorManager.getRegisterPage(driver);
	}

	public boolean verifySliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_SLIDER);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElementByJS(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public RegisterPageObject getRegisterPage() {
		return new RegisterPageObject(driver);
	}

	public LoginPageObject getLoginPage() {
		return new LoginPageObject(driver);
	}

	

}


