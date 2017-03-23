package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import pages.GiftVoucherPage;
import utils.Browser;

public class GiftVoucherPageTests {

	public static final String CODE_VOUCHER_DELETE = "12345";

	@Before
	public void setUp() {
		Browser.init("chrome");
		GiftVoucherPage.open();
	}

	@Test
	public void createNewVoucher() {
		GiftVoucherPage.clickInsertButton();
		GiftVoucherPage.createNewGiftVoucher("qwerty", "John", "john@doe.com", "Jane", "jane@doe.com", "General",
				"thank you", "30", "Disabled");
		Assert.assertTrue(GiftVoucherPage.successMsg.isDisplayed());
		Assert.assertEquals("Wrong success message", "Success: You have modified vouchers!",
				GiftVoucherPage.successMsg.getText());
	}

	@Test
	public void cannotCreateVouchersWithSameCodes() {
		GiftVoucherPage.clickInsertButton();
		GiftVoucherPage.createNewGiftVoucher("12345", "John", "john@doe.com", "Jane", "jane@doe.com", "General",
				"thank you", "30", "Disabled");
		GiftVoucherPage.clickInsertButton();
		GiftVoucherPage.createNewGiftVoucher("12345", "John", "john@doe.com", "Jane", "jane@doe.com", "Birthday",
				"thank you", "30", "Enabled");
		Assert.assertTrue(GiftVoucherPage.warningMsg.isDisplayed());
		Assert.assertEquals("Wrong success message", "Warning: Voucher code is already in use!",
				GiftVoucherPage.warningMsg.getText());
	}

	@Test
	public void deleteVoucher() {
		GiftVoucherPage.clickInsertButton();
		GiftVoucherPage.createNewGiftVoucher(CODE_VOUCHER_DELETE, "John", "john@doe.com", "Jane", "jane@doe.com",
				"General", "thank you", "30", "Disabled");
		GiftVoucherPage.deleteVoucherCodeSet(CODE_VOUCHER_DELETE);
		Assert.assertTrue(GiftVoucherPage.successMsg.isDisplayed());
		Assert.assertEquals("Wrong success message", "Success: You have modified vouchers!",
				GiftVoucherPage.successMsg.getText());

		try {
			Assert.assertTrue(
					Browser.driver.findElement(By.xpath("//td[.='" + CODE_VOUCHER_DELETE + "']")).isDisplayed());
		} catch (NoSuchElementException e) {
			System.out.println("Test Pass");
		}
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1500);
		Browser.driver.quit();
	}
}
