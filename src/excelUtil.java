import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtil {

	private XSSFWorkbook excelWBook;
	private XSSFSheet excelWSheet;

	public excelUtil() {
		try {
			FileInputStream excelFile = new FileInputStream(
					"C:/Eclipse/daneSeleniumExcel.xlsx");

			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet("Arkusz1");
		} catch (FileNotFoundException e) {
			System.out.println("Coœ nie tak z plikiem");
		} catch (IOException e) {
			System.out.println("Nie zamkniêto excelBook?");
		}
	}

	public int getNumberOfRows() {
		return excelWSheet.getPhysicalNumberOfRows();
	}

	public int getNumberOfCells(int row) {
		return excelWSheet.getRow(row).getPhysicalNumberOfCells();
	}

	public double getCellData(int row, int column) {
		return Double.parseDouble(excelWSheet.getRow(row).getCell(column)
				.getRawValue().toString());
	}
}
