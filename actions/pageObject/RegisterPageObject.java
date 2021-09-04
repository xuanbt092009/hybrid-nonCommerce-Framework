package pageObject;

import org.openqa.selenium.WebDriver;

import commom.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject  extends BasePage{
   private WebDriver driver;

public RegisterPageObject(WebDriver driver) {
	super();
	this.driver = driver;
}

public void sendDataToFirstNameTextbox(String value) {
	waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
	sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, value);
	
}

public void sendDataToLastNameTextbox(String value) {
	waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
	sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, value);
}
public void sendDataToEmailTextbox(String email) {
	waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
	sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
}
public void sendDataToPasswordTextbox(String value) {
	waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
	sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, value);
	
}


public void sendDataToConfirmPasswordTextbox(String value) {
	waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXBOX);
	sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXBOX, value);
	
	
}

public void clickToRegisterButton() {
	waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
	clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	
}

public boolean messageRegisterSuccessful() {
	waitForElementVisible(driver, RegisterPageUI.MESSAGE_SUCCESS_REGISTER);
	return isDisplayed(driver, RegisterPageUI.MESSAGE_SUCCESS_REGISTER);
}

public void clickToLogoutSystemlink() {
	waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
	clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
	
}


   
}
