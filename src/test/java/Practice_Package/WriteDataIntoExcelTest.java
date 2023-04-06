package Practice_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        wb.getSheet("sheet").getRow(4).getCell(0).setCellValue("Pyspiders");
        
        FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Excel.xlsx");
        wb.write(fos);
        wb.close();
	}

}
