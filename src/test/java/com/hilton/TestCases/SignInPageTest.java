package com.hilton.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import com.hilton.TestBase.TestBase;
import com.hilton.UIpages.LoginPage;
import com.hilton.UIpages.SignIn;


public class SignInPageTest extends TestBase {

	public static final Logger log=Logger.getLogger(SignInPageTest.class.getClass());
	SignIn signinpage;
	LoginPage loginPage;
	
	public SignInPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		init();
		signinpage=new SignIn();
	}
	
	@Test(priority=1)
	public void verifySignInPageTitle()
	{
		String title = signinpage.validateSignInPageTiltle();
		Assert.assertEquals("Hilton Hotels and Resorts - Find Hotel Rooms", title);
		log.info("Sign in Page title is verified");
	}
	
	@Test(priority=2)
	public void verifyLogoTest()
	{
		boolean logo = signinpage.validateLogo();
		Assert.assertTrue(logo);  
		log.info("Sign in Page logo is verified");
	}
	
	@Test(priority=3)
	public void clickSignInButtonTest()
	{
		loginPage = signinpage.verifySignInButton();
		log.info("Login Page displayed");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
		log.info("Browser is closed");
	}
}
