package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	
	public String readDataFromExcelFile(String sheetName, int rowNumber, int cellNumber) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		String data = cell.getStringCellValue();
		return data;
	}
	
	
	public void writeDataIntoExcel(String sheetName, int rowNumber, int cellNumber, String value) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		 Row row = sheet.getRow(rowNumber);
		 Cell cell = row.getCell(cellNumber);
		  cell.setCellValue(value);
		  
		  FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		  workbook.write(fos);
	}
}
