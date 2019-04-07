package excel;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.HomePage;
import page.objects.MakePostPage;
import page.tests.LoginTest;
import page.tests.MakePostTest;
import page.tests.RegistrationTest;

public class GlavniProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WebDriver driver = new ChromeDriver();
		HomePage.maximizeWindow(driver);
		try {

			HomePage.openPage(driver);
			RegistrationTest.testWithAllData(driver);
			LoginTest.testWithAllData(driver);
			LoginTest.fillform(driver, 2);
			

			MakePostTest.editPost(driver, 0);
			MakePostTest.deletePost(driver, 1);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

}
