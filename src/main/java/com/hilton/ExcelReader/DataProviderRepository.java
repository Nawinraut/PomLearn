package com.hilton.ExcelReader;

import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hilton.TestBase.TestBase;



public class DataProviderRepository extends TestBase{

	
	public DataProviderRepository()
	{
		super();
	}
	public static ExcelReader excel;
	
	@DataProvider(name = "HiltonDataProvider")
	public static Object[][] HiltonDataProvider(Method method) throws Exception {
		
		String Excelpath = prop.getProperty("ExcelPath");
		excel=new ExcelReader(Excelpath);
		System.out.println("INTEND TO READ THE TEST DATA USING DATAPROVIDER FROM EXCEL WORKBOOK" +Excelpath);
		Object[][] testDataArray = null;
		String sheetname=method.getName();
		System.out.println("READ THE DATA FROM SHEET NAME: "+method.getName());		
		if(excel.isSheetExist(sheetname))
			{
				testDataArray = excel.getTestDataAsTwoDimesionalObjectArray(sheetname);
				System.out.println(testDataArray);
			}
		return testDataArray;
	}
	
}
