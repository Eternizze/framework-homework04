package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.AdminLogInPage;
import pages.DashboardPage;
import utils.Browser;

public class DashboardPageTest {

	@Before
	public void setUp() {
		Browser.init("chrome");
		DashboardPage.open();
	}

	@Test
	public void logout() {
		DashboardPage.logout();
		AdminLogInPage.isAt();
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1500);
		Browser.driver.quit();
	}

}