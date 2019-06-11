package com.hilton.UIpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hilton.TestBase.TestBase;
import com.hilton.utils.TestUtil;

public class LoginPage extends TestBase {
	
	@FindBy (xpath="//label[contains(text(),'Username')]")
	WebElement uname;
	
	@FindBy (id="username")
	WebElement userTxtBox;
	
	@FindBy (xpath="//label[contains(text(),'Password')]")
	WebElement password;
	
	@FindBy (id="password")
	WebElement pwdTxtBox;
	
	@FindBy (xpath="//a[@class='formSignIn-forgotPassword']")
	WebElement forgotpwd;
	
	@FindBy (className="linkBtn")
	WebElement submitBtn;
	
	@FindBy (id="logInRememberMe")
	WebElement rememberMe;
	
	@FindBy (xpath="//*[@id='recaptcha-anchor']/div[1]")
	WebElement captcha;
	
	@FindBy (xpath="//iframe[contains(@name,'a-')]")
	WebElement frame;
	
	@FindBy (xpath="//iframe[contains(@name,'c-')]")
	WebElement verifyFrame;
	
	@FindBy (id="recaptcha-verify-button")
	WebElement verifyButton;
	
	TestUtil testUtil=new TestUtil();
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String username,String passwd)
	{
		uname.click();
		userTxtBox.sendKeys(username);
		password.click();
		pwdTxtBox.sendKeys(passwd);
		System.out.println("login page driver"+ driver);
		testUtil.switchFrame(frame);
		captcha.click();
		driver.switchTo().defaultContent();
        driver.switchTo().frame(verifyFrame);
        verifyButton.click();
        return new HomePage();
	}
}
