package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.qa.pages.AjioPages;
public class TestBase {
	
	protected static WebDriver driver;
	protected static AjioPages ajio;
	
	
    @Parameters({"Browser","url"})

	@BeforeClass
    public void setUp(String Browser,String url) {
	  
	if(Browser.equalsIgnoreCase("Chrome"))
		{
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\Priti\\Desktop\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\Priti\\Desktop\\Drivers\\edgedriver_win64\\msedgedriver.exe");
			driver= new EdgeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Priti\\Desktop\\Drivers\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
	
	        driver.manage().window().maximize();
			ajio = new AjioPages(driver);
			driver.get(url);
			}
	
	    
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	public void captureScreenShot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot screenShot=(TakesScreenshot) driver;
		File Sources=screenShot.getScreenshotAs(OutputType.FILE);
		String Dest= System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
		FileUtils.copyFile(Sources,new File(Dest));
		
	}
}	



