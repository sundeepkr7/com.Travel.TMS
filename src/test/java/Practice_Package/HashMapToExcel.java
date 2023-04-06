package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapToExcel {

	public static void main(String[] args) throws IOException {
		/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\student.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("student data1");*/
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("student data");
		
		Map<String,String> data = new HashMap<String,String>();
		data.put("101","John");
		data.put("102","James");
		data.put("103","Smith");
		data.put("104","David");
		data.put("105","Clark");
		
		int rowno=0;
		for(Map.Entry entry: data.entrySet()) {
			Row row = sh.createRow(rowno++);
			row.createCell(0).setCellValue((String)entry.getKey());
			row.createCell(1).setCellValue((String) entry.getValue());	
		}
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\student.xlsx");
         wb.write(fos);
         wb.close();
         System.out.println("excel file successfully executed");
	}

}
