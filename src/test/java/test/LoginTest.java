package test;

import org.junit.Test;

import page.HeaderPage;
import page.LoginPage;
import page.MyAccountPage;
import utils.Constants;

public class LoginTest extends BaseTest{
	
	HeaderPage headerPage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;

	@Test
	public void loginTest() {
		System.out.println("LOGIN TEST");
		headerPage  = new HeaderPage();
		loginPage = new LoginPage();
		myAccountPage = new MyAccountPage();
		
		headerPage.clickAccountButton();
		headerPage.selectAccountAction("Log In");
		loginPage.performLogin(Constants.USER_EMAIL, Constants.USER_PASS);
		myAccountPage.assertLoggedIn();
		
	}

}
