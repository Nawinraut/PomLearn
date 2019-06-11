package com.hilton.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReader {

	public  String ExcelFileWithPath=null;
	public static  String fileExtensionName;
	private static Workbook workbook = null;
	private Cell cell = null;
	public Sheet sheet = null;
	private Row row   =null;
	public ExcelReader(String ExcelFileWithPath)  
	{

		this.ExcelFileWithPath=ExcelFileWithPath;

		//Create an object of File class to open xlsx file
		File file =    new File(ExcelFileWithPath);
		try
		{
			//Create an object of FileInputStream class to read excel file
			FileInputStream ExcelFileInput = new FileInputStream(file);

			//Find the file extension by splitting file name in substring  and getting only extension name
			fileExtensionName = ExcelFileWithPath.substring(ExcelFileWithPath.indexOf("."));
			//System.out.println("fileExtensionName is " +fileExtensionName);

			//Check condition if the file is xlsx file
			if(fileExtensionName.equals(".xlsx"))
			{
				workbook = new XSSFWorkbook(ExcelFileInput);
			}else if(fileExtensionName.equals(".xls"))
			{
				workbook = new HSSFWorkbook(ExcelFileInput);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} 

	}


	public boolean isSheetExist(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1){
			index=workbook.getSheetIndex(sheetName.toUpperCase());
			if(index==-1)
				return false;
			else
				return true;
		}
		else
			return true;
	}


	public  Object[][] getTestDataAsTwoDimesionalObjectArray(String sheetName) throws Exception {
		FileInputStream ExcelFileInput = new FileInputStream(ExcelFileWithPath);
		Object[][] excelObjectArray = null;
		if(fileExtensionName.equals(".xlsx"))
		{
			workbook = new XSSFWorkbook(ExcelFileInput);
		}else if(fileExtensionName.equals(".xls"))
		{
			workbook = new HSSFWorkbook(ExcelFileInput);
		}
		Sheet sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();

		excelObjectArray=new Object[rowcount][colcount];
		String cellValue = "";
		int k = 0;
		for(int r=1;r<=rowcount;r++,k++)
		{
			row = sheet.getRow(r);
			int l=0;
			for(int c=0;c<colcount;c++,l++)
			{
				if (row.getCell(c) != null) 
				{
					cell=row.getCell(c); 
					if(cell.getCellTypeEnum()==CellType.STRING)
					{
						cellValue=cell.getStringCellValue();
						excelObjectArray[k][l] =cellValue;
						System.out.println(excelObjectArray[k][l]);
					}
					else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA)
					{ 
						cellValue  = String.valueOf(cell.getNumericCellValue());
						excelObjectArray[k][l] =cellValue;
						System.out.println(excelObjectArray[k][l]);
					}
				}
				else {
					cellValue = "";
					excelObjectArray[k][l] = cellValue;
				}

			}
		}
		return excelObjectArray;
	}


}
