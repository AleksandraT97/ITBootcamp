package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public static final String LOGIN_URL = "http://localhost/izlet/processlogin.php";
	private static final String USER = "//input[@placeholder='username']";
	private static final String PASS = "//input[@placeholder='password']";
	private static final String LOGIN = "//input[@value='Log in']";
	private static final String LOGOUT = "//a[contains(text(),'Logout')]";

	// Username
	public static WebElement getUser(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(USER));
		return wb;
	}

	public static void clickUser(WebDriver dr) {
		getUser(dr).click();
	}

	public static void sendKeysUser(WebDriver dr, String str) {
		getUser(dr).sendKeys(str);
	}

	// Password
	public static WebElement getPass(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(PASS));
		return wb;
	}

	public static void clickPass(WebDriver dr) {
		getPass(dr).click();
	}

	public static void sendKeysPass(WebDriver dr, String str) {
		getPass(dr).sendKeys(str);
	}

	// Login
	public static WebElement getLogin(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOGIN));
		return wb;
	}

	public static void clickLogin(WebDriver dr) {
		getLogin(dr).click();
	}

	// Logout
	public static WebElement getLogout(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOGOUT));
		return wb;
	}

	public static void clickLogout(WebDriver dr) {
		getLogout(dr).click();
	}

	public static void openPage(WebDriver dr) {
		dr.get(LOGIN_URL);
	}

	public static void navigateTo(WebDriver dr) {
		dr.navigate().to(LOGIN_URL);

	}

}
