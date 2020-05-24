package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	FileInputStream fis = null;

	public static int rowcount;

	public FileInputStream getFileInputStream() {

		String filepath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\ExcelData.xlsx";
		File srcFile = new File(filepath);
		System.out.println(filepath);

		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found..." + e.getMessage());
			System.exit(0);
		}

		return fis;

	}

	public Object[][] getExcelData(int sheetno, int colno) throws IOException {

		fis = getFileInputStream();
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetno);

		int TotalNumberOfRows = (sheet.getLastRowNum() + 1);
		int TotalNumberOfCols = colno;

		rowcount = TotalNumberOfRows;

		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];

		for (int i = 0; i < TotalNumberOfRows; i++) {

			for (int j = 0; j < TotalNumberOfCols; j++) {

				XSSFRow row = sheet.getRow(i);

				if (row.getCell(0) != null) {
					arrayExcelData[i][j] = (row.getCell(j)).toString();
					System.out.println(arrayExcelData[i][j]);
				}

			}
		}

		workbook.close();
		return arrayExcelData;

	}

}
