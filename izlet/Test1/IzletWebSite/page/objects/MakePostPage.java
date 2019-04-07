package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MakePostPage {
	public static final String MAKE_URL = "http://localhost/izlet/dashboard.php";
	private static final String MAKEPOST = "//a[contains(text(),'Make a post')]";
	private static final String NASLOV = "//input[@placeholder='Naziv']";
	private static final String LOKACIJA = "//input[@placeholder='Lokacija']";
	private static final String OPIS = "//textarea[@placeholder='Opis']";
	private static final String POST = "//input[@value='Post']";
	private static final String MORE = "fa-ellipsis-v";
	private static final String EDIT = "fa-edit";
	private static final String DELETE = "fa-trash-alt";

	private static final String EDITBUTTON = "//div[@class='popupEdit']//input[@value='Post']";
	private static final String EDIT_OPIS = "//textarea[@id='description']";
	private static final String OPIS_NA_DASHBOARDU = "(//div[@class='textbody'])";

	// Get opis from deshboard
	public static WebElement getOpisFromDashboard(WebDriver driver, int postNumber) {
		return driver.findElement(By.xpath(OPIS_NA_DASHBOARDU + "[" + postNumber + "]"));
	}

	// Make a post
	public static WebElement getMakePost(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(MAKEPOST));
		return wb;
	}

	public static void clickMakePost(WebDriver dr) {
		getMakePost(dr).click();
	}

	// Naslov
	public static WebElement getNaslov(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(NASLOV));
		return wb;
	}

	public static void clickNaslov(WebDriver dr) {
		getNaslov(dr).click();
	}

	public static void sendKeysNaslov(WebDriver dr, String str) {
		getNaslov(dr).sendKeys(str);
	}

	// Lokacija
	public static WebElement getLokacija(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOKACIJA));
		return wb;
	}

	public static void clickLokacija(WebDriver dr) {
		getLokacija(dr).click();
	}

	public static void sendKeysLokacija(WebDriver dr, String str) {
		getLokacija(dr).sendKeys(str);
	}

	// Opis
	public static WebElement getOpis(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(OPIS));
		return wb;
	}

	public static void clickOpis(WebDriver dr) {
		getOpis(dr).click();
	}

	public static void sendKeysOpis(WebDriver dr, String str) {
		getOpis(dr).sendKeys(str);
	}

	// Post
	public static WebElement getPost(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(POST));
		return wb;
	}

	public static void clickPost(WebDriver dr) {
		getPost(dr).click();
	}

	// get More
	public static WebElement getMore(WebDriver dr, int postNumber) {
		List<WebElement> lst = dr.findElements(By.className(MORE));
		WebElement wb = lst.get(postNumber);
		return wb;
	}

	public static void clickMore(WebDriver dr, int postNumber) {
		getMore(dr, postNumber).click();
	}

	// get Edit
	public static WebElement getEdit(WebDriver dr, int postNumber) {
		List<WebElement> lst = dr.findElements(By.className(EDIT));
		WebElement wb = lst.get(postNumber);
		return wb;
	}

	public static void clickEdit(WebDriver dr, int postNumber) {
		getMore(dr, postNumber).click();
	}

	// get More
	public static WebElement getDelete(WebDriver dr, int postNumber) {
		List<WebElement> lst = dr.findElements(By.className(DELETE));
		WebElement wb = lst.get(postNumber);
		return wb;
	}

	public static void clickDelete(WebDriver dr, int postNumber) {
		getMore(dr, postNumber).click();
	}

	// edit opis
	public static WebElement getEditOpis(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDIT_OPIS));
		return wb;
	}

	public static void clickEditOpis(WebDriver dr) {
		getOpis(dr).click();
	}

	public static void sendKeysEditOpis(WebDriver dr, String str) {
		getOpis(dr).sendKeys(str);
	}

	public static WebElement getEditB(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDITBUTTON));
		return wb;
	}

	public static void clickEditB(WebDriver dr) {
		getEditB(dr).click();
	}

	// Open page
	public static void openPage(WebDriver dr) {
		dr.get(MAKE_URL);
	}

	// Navigate to Page
	public static void navigateTo(WebDriver dr) {
		dr.navigate().to(MAKE_URL);
	}

}
