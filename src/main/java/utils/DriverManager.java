package utils;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static WebDriver driver = null;
	private static String browser =  System.getProperty("browser");;
	private static String host = Constants.HOST;

	public static void initDriver() throws Exception {
		System.out.println("Opening browser [" + browser.toUpperCase() + "]...");

		if (browser.contentEquals("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_PATH);
			driver = new FirefoxDriver();
		} else if (browser.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Oppening URL [" + host + "] ");
		driver.get(host);

		System.out.println(
				"\n\n\n==========================================================================================="
						+ "\n ============================= TEST STARTED ==============================\n");
	}

	
	public static void closeDriver() {
		System.out.println(
				"\n\n\n==========================================================================================="
						+ "\n ============================= TEST ENDED - Closing browser ==============================\n");
		driver.close();
		driver.quit();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public void clearCookies() {
		Set<Cookie> cookies = getDriver().manage().getCookies();
		for (Cookie cookie : cookies) {
			getDriver().manage().deleteCookie(cookie);
		}
	}

}
