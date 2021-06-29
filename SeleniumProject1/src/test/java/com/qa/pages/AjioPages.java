package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjioPages {
	

	WebDriver driver;
	
	
	@FindBy(name="searchVal")
	WebElement SearchBoxField;
	
	public WebElement getSerachBoxField() {
	 return SearchBoxField;
	}
	
	
	@FindAll(@FindBy(xpath="//div[@class='item rilrtl-products-list__item item']"))
    List<WebElement> ProductName;
	public List<WebElement> getProductName()
	{
		return ProductName;
	}
	
	
	@FindBy(xpath="//header/div[1]/ul[1]/li[2]/a[1]")
	WebElement CustomerCareLink;
	public WebElement getCustomerCareLink(){
		return CustomerCareLink;
	}
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]")
	WebElement SearchField;
	public WebElement getSearchField() {
		return SearchField;
	}
	
	@FindAll(@FindBy(xpath="//div[@class='nav-item']"))
    List<WebElement> TopicName;
	public List<WebElement> getTopicName()
	{
		return TopicName;
	}
	
	
	public AjioPages(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
}
