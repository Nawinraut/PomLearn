package com.hilton.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hilton.TestBase.TestBase;

public class TestUtil extends TestBase {
	public static long Page_Load_Timeout=50;
	public static long Implicit_wait=30;

    	
	//Explicit wait applied to the element
	public void waitForElement(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	//Scroll until the element is in view
	
	public void scrollToViewElement(WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	//For the mouse Hover and perform click
	
	public void mouseHover(WebElement ele)
	{
		Actions action=new Actions(driver);
		action.moveToElement(ele).build().perform();
		
	}
	
	public void switchFrame(WebElement framename)
	{
		
		 driver.switchTo().frame(framename);
		 System.out.println("util driver"+ driver);
		 
	}
	
	
	//For switching window
	public void switchWindow()
	{
		//String windowHandle = driver.getWindowHandle();
	}
	
	
	public static String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		
		File destination=new File(path);
		
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		
		return path;
	}
}