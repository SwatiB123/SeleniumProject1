package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

   public class TC_AjioCustomerCare_02 extends TestBase {
		
		@Test(dataProvider="getData")
		public void SearchTopics(String Topics) throws InterruptedException, IOException {
			
		    ajio.getCustomerCareLink().click();
		    ajio.getSearchField().sendKeys(Topics);
			Thread.sleep(5000);
			
			List<WebElement> TopicNames =ajio.getTopicName();
			Thread.sleep(5000);
		    Reporter.log("Total no of Topics loaded are: " + TopicNames.size(),true);
		    
		    for (WebElement TopicName : TopicNames) {
		    	 Reporter.log(TopicName.getText(),true);
		    }		
		  
		    ajio.getSearchField().sendKeys(Keys.ENTER);
		 
			String title = driver.getTitle();
			Thread.sleep(5000);
			if(title.contains(Topics))
			{
				 Reporter.log("Topic is Searched",true);
				 Assert.assertTrue(true);
		        
			}
			else
			{
				 captureScreenShot(driver,"SearchTopics");
				 Reporter.log("Topic is not searched",true);
				 Assert.assertTrue(false);
				 
			}
		
		}
		
		@DataProvider
		   public String[][] getData() throws IOException {
			
			String xFile="C:\\Users\\Priti\\Desktop\\LP IAT(Batch 8)\\SeleniumProject2\\src\\test\\java\\com\\qa\\testdata\\testdata.xlsx";
			String xSheet="Sheet2";
			int rowCount=ExcelUtility.getRowCount(xFile, xSheet);
			int cellCount=ExcelUtility.getcellCount(xFile, xSheet, rowCount);
			
			String[][] data = new String[rowCount][cellCount];
			for(int i=1; i<=rowCount; i++)
			{
				for(int j=0; j<cellCount; j++)
				{
					data[i-1][j]=ExcelUtility.getcellData(xFile, xSheet, i, j);
				}
				
				}
			return data;
			}
		}

