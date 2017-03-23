package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public final static String PATHFIREFOX = "/Users/Teodora/automation/drivers/geckodriver";
	public final static String PATHCHROME = "/Users/Teodora/automation/drivers/chromedriver";

	public static WebDriver driver;

	public static void init(String browser) {
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", PATHFIREFOX);
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", PATHCHROME);
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
