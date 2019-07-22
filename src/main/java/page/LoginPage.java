package page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
	
	public LoginPage() {
		super();
	}
	
	
	By emailInput = By.cssSelector("form#login-form input[type = 'email']");
	By passInput = By.cssSelector("form#login-form input[type = 'password']");
	By loginSubmitButton = By.cssSelector("form#login-form button[type='submit']");
	
	
	public void typeEmail(String email) {
		getDriver().findElement(emailInput).clear();
		getDriver().findElement(emailInput).sendKeys(email);
	}
	
	
	public void typePassword(String pass) {
		getDriver().findElement(passInput).clear();
		getDriver().findElement(passInput).sendKeys(pass);
	}
	

	
	public void performLogin(String email, String password) {
		typeEmail(email);
		typePassword(password);
		getDriver().findElement(loginSubmitButton).click();
	}

}
