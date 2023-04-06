package Practice_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Book.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Sheet");
		//int count= sh.getLastRowNum();
		
        FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Book.xlsx");
        for(int i=1;i<=4;i++) {
        	sh.getRow(i).getCell(0).setCellValue("pqr");
        	 wb.write(fos);
			
     //   wb.close();
       }
        wb.close();
	}
}

