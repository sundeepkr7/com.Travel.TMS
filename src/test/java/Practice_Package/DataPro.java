package Practice_Package;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.TMS.GenericUtilities.IpathConstants;

public class DataPro {

	public Object[][] data() throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DP");
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
				for(int i=0;i<lastRow;i++)
				{
					for(int j=0;i<lastCell;i++)
					{
						obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
					}
				}
				return obj;
		
		
		
	}
}
