package commom;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	public enum BROWSER{
		CHROME,FIREFOX, IE, SAFARI,EDGE;
	}
	
	public WebDriver getBrowserName(String browserName, String URL) throws IOException {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser == BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\Browserdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser == BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\Browserdriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			throw new IOException("Browser chua duoc support");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
	
	
}
