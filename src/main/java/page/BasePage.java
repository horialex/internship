package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverManager;

public class BasePage {

	private WebDriver webdriver;
	private WebDriverWait wait;
	
	public BasePage() {
		this.webdriver = DriverManager.getDriver();
		this.wait = new WebDriverWait(this.webdriver, 15);
	}
	
	public WebDriver getDriver() {
		return webdriver;
	}

	public void goTo(String url) {
		webdriver.get(url);
	}

	public void refresh() {
		webdriver.navigate().refresh();
	}

	public void closeDriver() {
		System.out.println(
				"\n\n\n==========================================================================================="
						+ "\n ============================= TEST ENDED - Closing browser ==============================\n");
		webdriver.close();
		webdriver.quit();
	}

	protected void waitForElementToAppear(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void waitForElementToDisappear(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	protected void waitForTextToDisappear(By locator, String text) {
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
	}

}
