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

	public class TC_AjioSearchProduct_01 extends TestBase {
		
		@Test(dataProvider="getData")
		public void SearchProducts(String Products) throws InterruptedException, IOException {
			
		
			ajio.getSerachBoxField().sendKeys(Products);
			Thread.sleep(5000);
			ajio.getSerachBoxField().sendKeys(Keys.ENTER);
			
			List<WebElement> ProductNames =ajio.getProductName();
			Thread.sleep(5000);
		    Reporter.log("Total no of Products loaded are: " + ProductNames.size(),true);
		    
		    for (WebElement ProductName : ProductNames) {
		    	 Reporter.log(ProductName.getText(),true);
		    }		
		  
		  
		 
			String title = driver.getTitle();
			Thread.sleep(5000);
			if(title.contains(Products))
			{
				 Reporter.log("Product is Searched",true);
		         Assert.assertTrue(true);
			}
			else
			{
				 captureScreenShot(driver,"SearchProducts");
				 Reporter.log("Product is not searched",true);
				 Assert.assertTrue(false);
			}
		
		}
		@DataProvider
		   public String[][] getData() throws IOException {
			
			String xFile="C:\\Users\\Priti\\Desktop\\LP IAT(Batch 8)\\SeleniumProject2\\src\\test\\java\\com\\qa\\testdata\\testdata.xlsx";
			String xSheet="Sheet1";
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
