package page;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;

public class MyAccountPage extends BasePage {
	public MyAccountPage() {
		super();
		PageFactory.initElements(getDriver(), this);
	}
	
	//Old way of identifing web elements
	//By greetingMessage = By.cssSelector("div.my-account  div.welcome-msg strong");
	
	
	//Page factory way of using web elements
	@FindBy(css = "div.my-account  div.welcome-msg strong")
	private WebElement greetingMessage;
	
	public void assertLoggedIn() {
		Assert.assertTrue(getDriver().getCurrentUrl().contentEquals(Constants.HOST.concat("/customer/account/")));
		Assert.assertTrue(greetingMessage.getText().contains(Constants.USER_NAME));
	}
}
