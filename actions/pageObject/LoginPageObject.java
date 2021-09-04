package pageObject;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.security.authentication.LoginAuthenticator;

import commom.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputDataToEmailTextbox(String Email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_LOGIN_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_LOGIN_TEXTBOX, Email);
	}

	public void inputDataToPasswordTextbox(String Password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_LOGIN_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_LOGIN_TEXTBOX, Password);
	}

	public void clickRememberCheckbox() {
		waitForElementClickable(driver, LoginPageUI.REMEMBER_LOGIN_CHECKBOX);
		clickToElement(driver, LoginPageUI.REMEMBER_LOGIN_CHECKBOX);
		
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	
	}

	public HomePageObject getHomePage() {
		return new HomePageObject(driver);
	}


	
	

}
