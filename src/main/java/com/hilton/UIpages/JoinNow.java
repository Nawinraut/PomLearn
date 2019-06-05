package com.hilton.UIpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hilton.TestBase.TestBase;

public class JoinNow extends TestBase{

	@FindBy(id="firstNameJoin")
	WebElement firstName;
	
	@FindBy(id="lastNameJoin")
	WebElement lastName;
	
	@FindBy(id="phoneJoin")
	WebElement phone;
	
	@FindBy(id="emailJoin")
	WebElement email;
	
	@FindBy(id="street1")
	WebElement address1;
	
	@FindBy(id="postalCode")
	WebElement zip;
	
	@FindBy(id="passwordJoin")
	WebElement password;
	
	@FindBy(id="passwordConfirmJoin")
	WebElement confirmPswd;
	
	@FindBy(xpath="//span[contains(text(),'Join For Free')]")
	WebElement submit;
	
	public JoinNow()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyJoinNowPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void gitTest()
	{
	 System.out.println("Hello");
	}
	
}
