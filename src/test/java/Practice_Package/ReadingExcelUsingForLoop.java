package Practice_Package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelUsingForLoop {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\countries.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet("countries data");
        
        int rows = sh.getLastRowNum();
        int cols = sh.getRow(1).getLastCellNum();
        for(int r=0;r<=rows;r++) {
        	XSSFRow row = sh.getRow(r);
        	for(int c=0;c<cols;c++) {
        		XSSFCell cell = row.getCell(c);
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
