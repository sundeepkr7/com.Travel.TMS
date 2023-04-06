package Practice_Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelUsingIterator {

	public static void main(String[] args) throws IOException {
		//Get the path of the excel file
		String ExcelFilePath = ".\\src\\test\\resources\\countries.xlsx";
		
		//Open the file using fileinputstream
		FileInputStream fis = new FileInputStream(ExcelFilePath);
		
		//get the workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		//get the sheet
		XSSFSheet sh = wb.getSheet("countries data");
		//XSSFSheet sh = wb.getSheetAt(0);
		
/////Iterator ---> Using iterator we can repeat all the rows and cells
		Iterator itr = sh.iterator();   //get all the rows in iterator
		while(itr.hasNext()) // checking inside iterator has next record
		{
		XSSFRow row = (XSSFRow) itr.next();	// using iterator we get row one by one 
		Iterator cellitr = row.cellIterator();   //It will capture all the cells in this row and store it in variable cellitr
			while(cellitr.hasNext())//for checking multiple cells within row 
			{
				XSSFCell cell = (XSSFCell) cellitr.next();
				switch(cell.getCellType())
				{
				case STRING: System.out.print(cell.getStringCellValue());break;
				case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;
				case NUMERIC: System.out.print(cell.getNumericCellValue());break;
			    }
				System.out.print(" | ");
		   }
			System.out.println();
		}
	}
}
