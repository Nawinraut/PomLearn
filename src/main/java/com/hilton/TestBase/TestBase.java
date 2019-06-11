package com.hilton.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.hilton.utils.TestUtil;

public class TestBase {

	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static Properties prop;
	public TestBase() 
	{
		try {
			prop= new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\nawkumar\\git\\PomLearn\\src\\main\\java\\com\\hilton\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();	
		}
	}

	public static void init() throws IOException
	{
		try{	
		String browsername=prop.getProperty("Browser");
			if(browsername.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\Users\\nawkumar\\git\\PomLearn\\Driver\\geckodriver.exe");
				driver=new FirefoxDriver();
				log.info("Launching Firefox Browser");
			}
			else if(browsername.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\nawkumar\\git\\PomLearn\\Driver\\chromedriver.exe");
				driver=new ChromeDriver();
				log.info("Launching Chrome Browser");
			}
		}catch(Exception e)
		{
			log.info("Can't launch browser");
		}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		
		
	}
	
}

