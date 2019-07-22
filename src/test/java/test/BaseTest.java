package test;

import org.junit.After;
import org.junit.Before;

import utils.DriverManager;

public class BaseTest {

	@Before
	public void setup() throws Exception {
		DriverManager.initDriver();
	}

	@After
	public void tearDown() {
		//DriverManager.closeDriver();
	}

}
