package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.AdminLogInPage;
import pages.DashboardPage;
import utils.Browser;

public class AdminLoginPageTests {

	public final static String USERNAME = "admin";
	public final static String PASSWORD = "parola";

	@Before
	public void setup() {
		Browser.init("firefox");
		// Browser.init("chrome");
		AdminLogInPage.open();
	}

	@Test
	public void logInPositive() {
		AdminLogInPage.logIn(USERNAME, PASSWORD);
		DashboardPage.isAt();

	}

	@Test
	public void logInNegative() {
		AdminLogInPage.logIn("name", "pass");
		Assert.assertEquals("No match for Username and/or Password.", AdminLogInPage.warnning.getText());
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1500);
		Browser.driver.quit();
	}

}
