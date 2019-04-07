package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.HomePage;
import page.objects.LoginPage;
import page.objects.RegistrationPage;
import utility.DataUtils;
import utility.ExcelUtils;

public class LoginTest {
	public static void fillform(WebDriver dr, int i) throws Exception {
		String data;
		ExcelUtils.setExcelFile(DataUtils.PATH_TESTDATA + DataUtils.FILE_TESTDATA, DataUtils.SHEET1);
		LoginPage.clickUser(dr);
		data = ExcelUtils.getCellData(i, 2);
		LoginPage.sendKeysUser(dr, data);
		LoginPage.clickPass(dr);
		data = ExcelUtils.getCellData(i, 4);
		LoginPage.sendKeysPass(dr, data);

		LoginPage.clickLogin(dr);
	}

	public static void fillForm(WebDriver dr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite user");
		String user = sc.nextLine();
		LoginPage.sendKeysUser(dr, user);
		System.out.println("Unesite pass");
		String pass = sc.nextLine();
		LoginPage.sendKeysPass(dr, pass);

		LoginPage.clickLogin(dr);
	}

	public static void testWithAllData(WebDriver dr) throws Exception {
		ExcelUtils.setExcelFile(DataUtils.PATH_TESTDATA + DataUtils.FILE_TESTDATA, DataUtils.SHEET1);
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum(); i++) {
			LoginTest.fillform(dr,i);
			LoginPage.clickLogout(dr);
		}

	}

}
