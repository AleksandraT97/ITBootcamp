package page.tests;

import java.util.Scanner;

import org.apache.bcel.classfile.Constant;
import org.openqa.selenium.WebDriver;

import page.objects.HomePage;
import page.objects.RegistrationPage;
import utility.DataUtils;
import utility.ExcelUtils;

public class RegistrationTest {
	private static final String Sheet1 = null;

	public static void fillForm(WebDriver dr, int i) throws Exception {
		String data;
		ExcelUtils.setExcelFile(DataUtils.PATH_TESTDATA + DataUtils.FILE_TESTDATA, DataUtils.SHEET1);
		RegistrationPage.clickFirstName(dr);
		data = ExcelUtils.getCellData(i, 0);
		RegistrationPage.sendKeysFirstName(dr, data);
		RegistrationPage.clickLastName(dr);
		data = ExcelUtils.getCellData(i, 1);
		RegistrationPage.sendKeysLastName(dr, data);
		RegistrationPage.clickUsername(dr);
		data = ExcelUtils.getCellData(i, 2);
		RegistrationPage.sendKeysUsername(dr, data);
		RegistrationPage.clickEmail(dr);
		data = ExcelUtils.getCellData(i, 3);
		RegistrationPage.sendKeysEmail(dr, data);
		RegistrationPage.clickPassword(dr);
		data = ExcelUtils.getCellData(i, 4);
		RegistrationPage.sendKeysPassword(dr, data);

		RegistrationPage.clickRegister(dr);
	}

	public static void fillForm(WebDriver dr) {
		Scanner sc = new Scanner(System.in);
		
		//firstName
		System.out.println("Unesite firstName");
		String firstName = sc.nextLine();
		RegistrationPage.sendKeysFirstName(dr, firstName);
		//lastName
		System.out.println("Unesite lastName");
		String lastName = sc.nextLine();
		RegistrationPage.sendKeysLastName(dr, lastName);
		//username
		System.out.println("Unesite username");
		String username = sc.nextLine();
		RegistrationPage.sendKeysUsername(dr, username);
		//email
		System.out.println("Unesite email");
		String email = sc.nextLine();
		RegistrationPage.sendKeysEmail(dr, email);
		//password
		System.out.println("Unesite password");
		String password = sc.nextLine();
		RegistrationPage.sendKeysPassword(dr, password);

		RegistrationPage.clickRegister(dr);
	}

	public static void testWithAllData(WebDriver dr) throws Exception {
		ExcelUtils.setExcelFile(DataUtils.PATH_TESTDATA + DataUtils.FILE_TESTDATA, DataUtils.SHEET1);
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum(); i++) {
			RegistrationTest.fillForm(dr, i);
			RegistrationPage.navigateTo(dr);

		}

	}
}