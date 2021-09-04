package commom;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.MyAccountPageObject;
import pageObject.OderPageObject;
import pageObject.SearchPageObject;
import pageObject.ShoppingCartPageObject;
import pageObject.SiteMapPageObject;
import pageUIs.BasePageUI;

public class BasePage {

	public void getURL(WebDriver driver, String URL) {
		driver.get(URL);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void alertToAccept(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	public void dismissToAccept(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	public void sendKeysToAccept(WebDriver driver, String Text) {
		driver.switchTo().alert().sendKeys(Text);

	}
	public String getALertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void waitALertPresence(WebDriver driver) {
		expliciteWait = new WebDriverWait(driver, timeout);
		expliciteWait.until(ExpectedConditions.alertIsPresent());
	}
	public void switchToWindowByID(WebDriver driver, String ParentID) {
		Set<String> currentWindows = driver.getWindowHandles();
		for(String currentWindow : currentWindows) {
			if(!currentWindow.equals(ParentID)) {
				driver.switchTo().window(currentWindow);
			}
		}	
	}
	
	public void switchToWindowByTitle(WebDriver driver, String ParentTitle) {
		Set<String> currentWindows = driver.getWindowHandles();
		for(String currentWindow : currentWindows) {
		   driver.switchTo().window(currentWindow);
		   if(driver.getTitle().equals(ParentTitle)) {
			   break;
		   }
		}	
	}
	public void closeAllWindowsWithoutParent(WebDriver driver, String ParentID) {
		Set<String> currentWindows = driver.getWindowHandles();
		for(String currentWindow : currentWindows) {
		   if(!currentWindow.equals(ParentID)) {
			   driver.switchTo().window(currentWindow);
			   driver.close();
		   }
		   driver.switchTo().window(ParentID);
		}	
	}
	
	public By getByXpath(String locator ) {
		return By.xpath(locator);
	}
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver,locator).click();	 
	}
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).sendKeys(value);
	}
	public void selectItemInDropdown(WebDriver driver, String locator, String text) {
		select = new Select(getElement(driver,locator));
		select.selectByVisibleText(text);	
	}
	public String getSelectItemInDropdown(WebDriver driver, String locator) {
		select = new Select(getElement(driver,locator));
		return select.getFirstSelectedOption().getText();	
	}
	public Boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver,locator));
		return select.isMultiple();	
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		expliciteWait = new WebDriverWait(driver, timeout);
		List<WebElement> allItems = expliciteWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	public String getAttributeValue(WebDriver driver, String locator,String attribute) {
		return getElement(driver, locator).getAttribute(attribute);
	}
	public String getTextElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	
	public String getCssValue(WebDriver driver, String locator, String CssValue) {
		return getElement(driver, locator).getCssValue(CssValue);
	}
	
	public void convertRgbaToHexa(WebDriver driver, String rgbaValue) {
		 Color.fromString(rgbaValue).asHex();
	}
	public int getElementSize(WebDriver driver, String locator)
	{
		return driver.findElements(getByXpath(locator)).size();	
    }

	public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {

		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		if (element.isSelected()) {
			element.click();
		}
	}
	public boolean isDisplayed(WebDriver driver, String locator) {
	        return getElement(driver, locator).isDisplayed();
	}
	
	public boolean isSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	public boolean isEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	public WebDriver switchToFrame_IframeByElement (WebDriver driver, String locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}
	
	public WebDriver switchToDefaultContent(WebDriver driver) {
		return driver.switchTo().defaultContent();
	}
	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}
	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();
	}
	
	public void moveToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}
	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}
	public void dragAndDroptoElement(WebDriver driver, String source, String destination) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, source), getElement(driver, destination)).perform();
	}
	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}
	
	public void sendKeyOneFile(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		expliciteWait = new WebDriverWait(driver, timeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return expliciteWait.until(jQueryLoad) && expliciteWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void sendKeyOneFile(WebDriver driver, String locator, String filePath) {
		getElement(driver, locator).sendKeys(filePath);
	}
	
	public void sendKeyMultiFile(WebDriver driver, String locator, String filePath1, String filePath2) {
		 getElement(driver, locator).sendKeys(filePath2 + '\n'+ filePath2);
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		expliciteWait = new WebDriverWait(driver,timeout);
		expliciteWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitForAllElementVisible(WebDriver driver, String locator) {
		expliciteWait = new WebDriverWait(driver,timeout);
		expliciteWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	public void waitForElementClickable(WebDriver driver, String locator) {
		expliciteWait = new WebDriverWait(driver,timeout);
		expliciteWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		expliciteWait = new WebDriverWait(driver,timeout);
		expliciteWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	
	public OderPageObject getOrderPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ORDER_FOOTER);
		clickToElement(driver, BasePageUI.ORDER_FOOTER);
		return PageGeneratorManager.getOrderPage(driver);
		
	}
	
	public MyAccountPageObject getMyAccountPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_ACCOUNT_FOOTER);
		clickToElement(driver, BasePageUI.MY_ACCOUNT_FOOTER);	
		return PageGeneratorManager.getMyAccountPage(driver);
	}
	public SearchPageObject getSearchPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.SEARCH_FOOTER);
		clickToElement(driver, BasePageUI.SEARCH_FOOTER);	
		return PageGeneratorManager.getSearchPage(driver);
	}
	
	public ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.SHOPPING_CART_FOOTER);
		clickToElement(driver, BasePageUI.SHOPPING_CART_FOOTER);	
		return PageGeneratorManager.getShoppingCartPage(driver);
	}
	
	public SiteMapPageObject getSiteMapPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.SITE_MAP_FOOTER);
		clickToElement(driver, BasePageUI.SITE_MAP_FOOTER);	
		return PageGeneratorManager.getSiteMapPage(driver);
	
	}
	public void sleepInSecond(int sec) {
		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JavascriptExecutor jsExecutor;
	private WebDriverWait expliciteWait;
	private WebElement element;
	private long timeout = 30;
	private Actions action;	
	private Select select;
	private String color;
	
}
