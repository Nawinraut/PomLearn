package com.hilton.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.hilton.ExcelReader.DataProviderRepository;
import com.hilton.TestBase.TestBase;
import com.hilton.UIpages.JoinNow;
import com.hilton.UIpages.SignIn;

public class JoinNowTest extends TestBase {

	JoinNow joinNow;
	SignIn signIn;
	
	public JoinNowTest()
	{
		super();
	}
	
	@BeforeTest
	public void setup() throws IOException 
	{
		init();
		signIn=new SignIn();
		joinNow=new  JoinNow();
		joinNow = signIn.verifyJoinLink();
		
	}
	
	
	@Test(dataProvider ="HiltonDataProvider",dataProviderClass = DataProviderRepository.class)
	public void joinNowForm(String FirstName,String LastName,String Phone,String Email,String country,String Address,String City,String region,
			String PostalCode,String Password,String ConirmPswd)
	{
		joinNow.joinHiltonHonor(FirstName, LastName, Phone, Email, Address, City, region, PostalCode, Password, ConirmPswd);
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		
		driver.quit();
	}
	
}
