package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.AdminLoginPageTests;
import utils.Browser;

public class GiftVoucherPage {

	public final static String URL_VOUCHER = "http://shop.pragmatic.bg/admin/index.php?route=sale/voucher&token=1ab95f646a3cad33f8d959d44da0705b";

	@FindBy(xpath = "//div[@class='heading']//h1")
	public static WebElement voucherHeading;
	@FindBy(linkText = "Insert")
	public static WebElement insertButton;
	@FindBy(name = "code")
	public static WebElement codeInput;
	@FindBy(name = "from_name")
	public static WebElement fromNameInput;
	@FindBy(name = "from_email")
	public static WebElement fromEmailInput;
	@FindBy(name = "to_name")
	public static WebElement toNameInput;
	@FindBy(name = "to_email")
	public static WebElement toEmailInput;
	@FindBy(name = "message")
	public static WebElement messageInput;
	@FindBy(name = "voucher_theme_id")
	public static WebElement themeDropdown;
	@FindBy(name = "status")
	public static WebElement statusDropdown;
	@FindBy(name = "amount")
	public static WebElement amountInput;
	@FindBy(linkText = "Save")
	public static WebElement saveButton;
	@FindBy(css = ".success")
	public static WebElement successMsg;
	@FindBy(css = ".warning")
	public static WebElement warningMsg;
	@FindBy(linkText = "Delete")
	public static WebElement deleteButton;

	public static void open() {
		Browser.driver.get(URL_VOUCHER);
		PageFactory.initElements(Browser.driver, AdminLogInPage.class);
		AdminLogInPage.logIn(AdminLoginPageTests.USERNAME, AdminLoginPageTests.PASSWORD);
		PageFactory.initElements(Browser.driver, GiftVoucherPage.class);

	}

	public static void isAt() {
		assertEquals("Gift Voucher", voucherHeading.getText());
	}

	public static void createNewGiftVoucher(String code, String fromName, String fromEmail, String toName,
			String toEmail, String theme, String message, String amount, String status) {
		fillCode(code);
		fillFromName(fromName);
		fillFromEmail(fromEmail);
		fillToName(toName);
		fillToEmail(toEmail);
		pickTheme(theme);
		fillMessage(message);
		fillAmount(amount);
		pickStatus(status);
		clickSaveButton();

	}

	public static void deleteVoucherCodeSet(String code) {
		WebElement checkbox = Browser.driver
				.findElement(By.xpath("//td[.='" + code + "']/preceding-sibling::td/input[@name='selected[]']"));
		checkbox.click();
		deleteButton.click();
	}

	public static void clickInsertButton() {
		insertButton.click();
	}

	public static void fillCode(String code) {
		codeInput.sendKeys(code);
	}

	public static void fillFromName(String fromName) {
		fromNameInput.sendKeys(fromName);
	}

	public static void fillToName(String toName) {
		toNameInput.sendKeys(toName);
	}

	public static void fillFromEmail(String fromEmail) {
		fromEmailInput.sendKeys(fromEmail);
	}

	public static void fillToEmail(String toEmail) {
		toEmailInput.sendKeys(toEmail);
	}

	public static void fillMessage(String message) {
		messageInput.sendKeys(message);
	}

	public static void fillAmount(String amount) {
		amountInput.sendKeys(amount);
	}

	public static void pickTheme(String theme) {
		Select dropdown = new Select(themeDropdown);
		dropdown.selectByVisibleText(theme);
	}

	public static void pickStatus(String status) {
		Select dropdown = new Select(statusDropdown);
		dropdown.selectByVisibleText(status);
	}

	public static void clickSaveButton() {
		saveButton.click();
	}

}
