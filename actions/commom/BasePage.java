package commom;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.Color;

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
	
	
	public void sleepInSecond(int sec) {
		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private WebDriverWait expliciteWait;
	private JavascriptExecutor jsExecutor;
	private WebElement element;
	private Select select;
	private String color;
	private long timeout = 30;
}
