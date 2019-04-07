package page.tests;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page.objects.LoginPage;
import page.objects.MakePostPage;
import utility.DataUtils;
import utility.ExcelUtils;

public class MakePostTest {
	public static void fillform(WebDriver dr, int i) throws Exception {
		String data;
		ExcelUtils.setExcelFile(DataUtils.PATH_TESTDATA + DataUtils.FILE_TESTDATA, DataUtils.SHEET2);
		MakePostPage.clickMakePost(dr);
		// naslov
		data = ExcelUtils.getCellData(i, 1);
		MakePostPage.clickNaslov(dr);
		MakePostPage.sendKeysNaslov(dr, data);
		// lokacija
		data = ExcelUtils.getCellData(i, 2);
		MakePostPage.clickLokacija(dr);
		MakePostPage.sendKeysLokacija(dr, data);
		// opis
		data = ExcelUtils.getCellData(i, 0);
		MakePostPage.clickOpis(dr);
		MakePostPage.sendKeysOpis(dr, data);

		MakePostPage.clickPost(dr);

	}

	public static void makePost(WebDriver dr) {
		Scanner sc = new Scanner(System.in); // unosenje podataka preko skenera
		// naslov
		MakePostPage.clickMakePost(dr);
		System.out.println("Unesite naslov");
		String naslov = sc.nextLine();
		MakePostPage.clickNaslov(dr);
		MakePostPage.sendKeysNaslov(dr, naslov);
		// lokacija
		System.out.println("Unesite lokaciju");
		String lokacija = sc.nextLine();
		MakePostPage.clickLokacija(dr);
		MakePostPage.sendKeysLokacija(dr, lokacija);
		// opis
		System.out.println("Unesite opis");
		String opis = sc.nextLine();
		MakePostPage.clickOpis(dr);
		MakePostPage.sendKeysOpis(dr, opis);

		MakePostPage.clickPost(dr);

	}

	public static void deletePost(WebDriver dr, int postNumber) {

		MakePostPage.clickMore(dr, postNumber);
		MakePostPage.clickDelete(dr, postNumber);
	}

	public static void deletePosts(WebDriver dr, int k) {
		for (int i = 0, j = 0; j < k; j++) {
			MakePostPage.getMore(dr, i);
			MakePostPage.clickDelete(dr, i);
		}
	}

	public static void editPost(WebDriver dr, int p) {
		Scanner sc = new Scanner(System.in);
		// More options button
		MakePostPage.clickMore(dr, p);
		// Edit button
		MakePostPage.clickEdit(dr, p);
		// Naziv
		
		System.out.println("Enter opis:");
		String opis = sc.nextLine();
		MakePostPage.clickEditOpis(dr);
		MakePostPage.sendKeysEditOpis(dr, opis);
		// Confirm button to edit a post
		MakePostPage.clickEditB(dr);
		sc.close();
	}
	
	
	public static void editPostExcel(WebDriver dr, int p, int i) throws Exception {
		String data;
		// Setting excel file
		ExcelUtils.setExcelFile(DataUtils.PATH_TESTDATA + DataUtils.FILE_TESTDATA, DataUtils.SHEET2);
		// More options button
		MakePostPage.clickMore(dr, p);
		// Edit button
		MakePostPage.clickEdit(dr, p);
		
		// Opis
		data = ExcelUtils.getCellData(i, 0);
		MakePostPage.clickEditOpis(dr);
		MakePostPage.sendKeysEditOpis(dr, data);
		// Confirm button to edit a post
		MakePostPage.clickEditB(dr);
	}
	
	
	
	
	
	

	public static void testWithAllData(WebDriver dr) throws Exception {
		ExcelUtils.setExcelFile(DataUtils.PATH_TESTDATA + DataUtils.FILE_TESTDATA, DataUtils.SHEET1);
		for (int i = 1; i < 3; i++) {
			MakePostPage.clickMakePost(dr);
			MakePostTest.fillform(dr, i);

		}

	}
}
