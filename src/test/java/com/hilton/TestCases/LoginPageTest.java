package com.hilton.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hilton.TestBase.TestBase;
import com.hilton.UIpages.HomePage;
import com.hilton.UIpages.LoginPage;
import com.hilton.UIpages.SignIn;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;
	SignIn signIn;
	
	
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup() 
	{
		init();
		signIn=new SignIn();
		loginPage = signIn.verifySignInButton();
		
	}

	@Test(priority=1)
	public void verifyLoginPageTitle()
	{
		String LoginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(LoginPageTitle,"Sign In - Hilton Honors");
	}

	@Test(priority=2)
	public void loginSuccess()
	{
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("Password"));
	}
	

	@AfterMethod
	public void closeBrowser()
	{
		
		driver.quit();
	}
}
