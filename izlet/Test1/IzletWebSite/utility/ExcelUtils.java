package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.bcel.classfile.Constant;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelUtils {

	private static HSSFSheet ExcelWSheet;
	private static HSSFWorkbook ExcelWBook;
	private static HSSFCell Cell;
	private static HSSFRow Row;
	private static DataFormatter formatter;

	// Metoda koja nam postavlja excel file
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {

			FileInputStream ExcelFile = new FileInputStream(Path);

			// ovaramo excel file
			ExcelWBook = new HSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			formatter = new DataFormatter();
		} catch (Exception e) {
			throw (e);
		}

	}

	// uzimamo podatak iz excel tabele za kolonu i red
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			// Pretvara u string infomarcije iz celije
			String CellData = formatter.formatCellValue(Cell);

			return CellData;
		} catch (Exception e) {
			return "";
		}

	}

	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {

			// uzimamo red
			Row = ExcelWSheet.getRow(RowNum);

			// uzimamo celiju
			Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);
			} else {

				Cell.setCellValue(Result);
			}

			// Ovaj deo koda upisuje izmene u excel file
			FileOutputStream fileOut = new FileOutputStream(DataUtils.PATH_TESTDATA + DataUtils.FILE_TESTDATA);
			ExcelWBook.write(fileOut);

			// prazni podatke unutar fajla
			fileOut.flush();

			// zatvaramo izlazni tok ka fajlu
			fileOut.close();
		} catch (Exception e) {
			throw (e);

		}

	}

	// Vraca referencu na worksheet
	public static HSSFSheet getWorkSheet() {
		return ExcelWSheet;
	}
}
