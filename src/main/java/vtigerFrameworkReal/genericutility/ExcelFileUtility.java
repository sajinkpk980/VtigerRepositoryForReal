package vtigerFrameworkReal.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * this method is used for reading data from excel sheet
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String readDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./data/vtiger.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return data;
}
/**
 * this method is used for getting the row count
 * @param sheetname
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public int rowCount(String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream("./data/vtiger.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	int rowcount = wb.getSheet(sheetname).getLastRowNum();
	return rowcount;
}
/**
 * this method is used for writing data into excel
 * @param sheetname
 * @param row
 * @param cell
 * @param name
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void writingDataIntoExcel(String sheetname,int row ,int cell,String name) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream("./data/vtiger.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(name);
	FileOutputStream fos = new FileOutputStream("./data/vtiger.xlsx");
	wb.write(fos);
	wb.close();
}

public Object[][] readMultipleData(String sheet) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./data/vtiger.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheet);
	 int lastrow = sh.getLastRowNum();
	 short lastcell = sh.getRow(0).getLastCellNum();
	 Object[][] data = new Object[lastrow][lastcell];
	 for(int i=0;i<lastrow;i++)
	 {
		 for(int j=0;j<lastcell;j++)
			 
		 {
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		 }
	 }
	 return data;
}
}
