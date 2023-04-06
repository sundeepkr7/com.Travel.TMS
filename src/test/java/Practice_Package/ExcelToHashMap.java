package Practice_Package;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelToHashMap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\student.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("student data");
        int rowcount = sh.getLastRowNum();
        
        Map<String,String> data = new HashMap<String, String>();
        //Reading data from Excel to Hashmap
        for(int i =0;i<rowcount;i++) {
        	String key = sh.getRow(i).getCell(0).getStringCellValue();
        	String value = sh.getRow(i).getCell(1).getStringCellValue();
        	data.put(key, value);
        }
        //Read data from Hashmap
        for(Map.Entry entry : data.entrySet()) {
        	System.out.println(entry.getKey()+ " " + entry.getValue());
        }
	}

}
