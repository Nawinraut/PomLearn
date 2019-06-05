package com.hilton.UIpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;
import com.hilton.TestBase.TestBase;
import com.hilton.utils.TestUtil;


public class SignIn extends TestBase {

	@FindBy(xpath="//a[@id='sign_in']")
	WebElement SignIn;
	
	@FindBy(id="hhonors_dock_logo")
	WebElement logo;
	
	
	public static final Logger log=Logger.getLogger(SignIn.class.getClass());
	TestUtil util;
	
	public SignIn()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateSignInPageTiltle()
	{
		
		if(driver.getTitle() != null)
		{
			log.info("Title is displayed");
			return driver.getTitle();
		}else
		{
		log.info("Title is not displayed");
			return null;
		}
	}
	
	public boolean validateLogo()
	{
		if(logo.isDisplayed())
		{
			log.info("Logo is displayed");
			return logo.isDisplayed();
		}else
		{
		log.info("Logo is not displayed");
			return false;
		}
	}
	
	public LoginPage verifySignInButton()
	{
		SignIn.click();	
		log.info("Sign In Button is clicked");
		return new LoginPage();
	}
	
	  
}
