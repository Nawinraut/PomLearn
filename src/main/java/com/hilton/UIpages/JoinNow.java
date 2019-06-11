package com.hilton.UIpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hilton.TestBase.TestBase;
import com.hilton.utils.TestUtil;

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
	
	@FindBy (xpath="//iframe[contains(@name,'a-')]")
	WebElement frame;
	
	@FindBy (id="recaptcha-anchor")
	WebElement capchachkbox;
	
	@FindBy (xpath="//iframe[contains(@name,'c-')]")
	WebElement verifyFrame;
	
	@FindBy (id="recaptcha-verify-button")
	WebElement verifycapcha;
	
	@FindBy(xpath="//*[@id='enrollForm']/p[2]/button/span")
	WebElement submit;
	
	
	TestUtil testUtil=new TestUtil();
	public JoinNow()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyJoinNowPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	
	public void joinHiltonHonor(String FirstName,String LastName,String Phone,String Email,String Address,String City,String region,
			String PostalCode,String Password,String ConirmPswd)
	{

		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		phone.sendKeys(Phone);
		email.sendKeys(Email);
		address1.sendKeys(Address);
		zip.sendKeys(PostalCode);
		password.sendKeys(Password);
		confirmPswd.sendKeys(ConirmPswd);
		testUtil.switchFrame(frame);
		capchachkbox.click();
		driver.switchTo().defaultContent();
		testUtil.switchFrame(verifyFrame);
		verifycapcha.click();
		testUtil.scrollToViewElement(submit);
		submit.click();
	}
	
}
