package page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HeaderPage extends BasePage {

	public HeaderPage() {
		super();
	}

	By accountButton = By.cssSelector(".account-cart-wrapper > a");
	By accountOptionsList = By.cssSelector("div#header-account ul li a");

	public void clickAccountButton() {
		getDriver().findElement(accountButton).click();
	}

	public void selectAccountAction(String actionName) {
		boolean elementFound = false;
		List<WebElement> elementsList = getDriver().findElements(accountOptionsList);
		for (WebElement element : elementsList) {
			if (element.getText().contentEquals(actionName)) {
				element.click();
				elementFound = true;
				break;
			}
		}
		Assert.assertTrue("The searched element" + actionName + " was not found in the account action list",
				elementFound);
	}
	
	

}
