package nopCommerce.user;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commom.BaseTest;
import commom.PageGeneratorManager;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class User_01_Register_Login_GenetateManager extends BaseTest {
	WebDriver driver;
	String username, email;
	@Parameters({"browser", "URL"}) 
	@BeforeClass
	public void beforeClass(String browserName, String URL) throws IOException {
			driver = getBrowserName(browserName,URL);
			username = "xuanbt" ;
			email = username + generateEmail();
					
		}
	@Test
	public void User_01_Register_Account() {
		
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.verifySliderDisplayed());
		homePage.clickToRegisterLink();
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.sendDataToFirstNameTextbox(username);
		registerPage.sendDataToLastNameTextbox("BuiXuan");
		registerPage.sendDataToEmailTextbox(email);
		registerPage.sendDataToPasswordTextbox("123456");
		registerPage.sendDataToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.messageRegisterSuccessful());
		registerPage.clickToLogoutSystemlink();
	}
	@Test
	public void User_02_Login() {
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.verifySliderDisplayed());
		homePage.clickToLoginLink();
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.inputDataToEmailTextbox(email);
		loginPage.inputDataToPasswordTextbox("123456");
		loginPage.clickRememberCheckbox();
		loginPage.clickToLoginButton();
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.verifySliderDisplayed());
		
	}
	
	public String generateEmail() {
		Random random = new Random();
		return random.nextInt(9999) + "@gmail.com";
	}
	@AfterClass
	public void afterClass() {
	}
     HomePageObject homePage;
     LoginPageObject loginPage;
     RegisterPageObject registerPage;
}
