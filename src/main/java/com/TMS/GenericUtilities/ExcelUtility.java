package com.TMS.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

		/**
		 * This method is used to read data from Excel sheet
		 * @param SheetName
		 * @param RowNo
		 * @param ColumnNo
		 * @return
		 * @throws Throwable 
		 * @author sundeep
		 * @return 
		 */
		public String readdataFromExcel(String SheetName,int RowNo, int ColumnNo)  
		{   String value="";
			try {
			FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			value = sh.getRow(RowNo).getCell(ColumnNo).getStringCellValue();
				
			}
			catch(Exception e) {
				
			}
			return value;
		}
		/**
		 * This method is used to get LastRowNumber
		 * @return 
		 * @paramSheetName
		 * @throws Throwable 
		 */
		public int getLastRowNo(String SheetName){
			int count=0;
		try {
			FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			count = sh.getLastRowNum();	
		}
		  catch(Exception e)
		  {
			
		   }
		    return count;
		}
		/**
		 * 
		 * @param SheetName
		 * @param RowNo
		 * @param ColumnNo
		 * @param data
		 * @throws Throwable 
		 */
		public void writedataIntoExcel(String SheetName,int RowNo,int ColumnNo,String data) throws Throwable {
			FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			sh.getRow(RowNo).createCell(ColumnNo).setCellValue(data);
			FileOutputStream fos = new FileOutputStream(IpathConstants.ExcelPath);
			wb.write(fos);
	}
		/**
		 * 
		 * @param SheetName
		 * @return
		 * @throws Throwable 
		 * @throws EncryptedDocumentException 
		 */
		public  HashMap<String,String> readMultipleData(String SheetName) throws EncryptedDocumentException, Throwable {
			FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Package.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet("Tour");
			
			int rowcount = sh.getLastRowNum();
			HashMap<String,String> map = new HashMap<String,String>();
			for(int i=1;i<=rowcount;i++) {
				String key = sh.getRow(i).getCell(0).getStringCellValue();
				String value = sh.getRow(i).getCell(1).getStringCellValue();
			    map.put(key, value);
			}
			return map;
		}
		
		public ArrayList<String> getMultipleData(String Sheetname,int column)
		{
		ArrayList<String> array = new ArrayList<String>();
		try {
		FileInputStream fi = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);	
		Sheet sh = wb.getSheet(Sheetname);
		int lastRow = getLastRowNo(Sheetname);
		for(int i=1;i<=lastRow;i++)
		{
			String Value = sh.getRow(i).getCell(column).getStringCellValue();
			array.add(Value);
		}
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
		return array;
		}	
		public Object[][] readmultipleSetOfdata(String Sheetname) throws Throwable
		{
			FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(Sheetname);
			int lastRow = sh.getLastRowNum()+1;
			int lastCell = sh.getRow(0).getLastCellNum();
			
			Object[][] obj = new Object[lastRow][lastCell];
			for(int i=0;i<lastRow;i++)
			{
				for(int j=0;j<lastCell;j++)
				{
					obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return obj;
		}
}

