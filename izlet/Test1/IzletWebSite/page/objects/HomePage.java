package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public static final String PAGE_URL = "http://localhost/izlet/";

	// open page
	public static void openPage(WebDriver dr) {
		dr.get(PAGE_URL);
	}

	// navigate to page
	public static void navigateTo(WebDriver dr) {
		dr.navigate().to(PAGE_URL);
	}

	public static void maximizeWindow(WebDriver dr) {
		dr.manage().window().maximize();
	}

}
