package com.zoopla.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.Driver.Driver;
import com.zoopla.property.Property;

import com.zoopla.utilities.Utilities;

public class HomePage {
	
	
	@FindBy(xpath=".//input[@id=\"search-input-location\"]")
	WebElement searchBar;
	
	@FindBy(xpath="//*[@id=\"search-submit\"]")
	WebElement searchButton;
	
	public HomePage() 
	{
		PageFactory.initElements(Driver.driver, this);
	}
	public void searchLocation() 
	{
		
		Utilities.enterText(Property.readProperty("location"), searchBar);
		
		Utilities.waitTill(Driver.driver.findElement(By.id("ui-id-1")));
		List<WebElement> elememnt = Driver.driver.findElements(By.xpath("//ul[@id=\"ui-id-1\"]/li[@class=\"ui-menu-item\"]"));
	
		for(WebElement ele : elememnt) 
		{
	
			if(ele.getAttribute("innerText").equals("London")) 
			{
				Utilities.waitTill(ele);
				ele.click();
				break;
				
			}
		}
		
	}
	
	public SearchPage clickOnSearch()
	{
		
		Utilities.clickUsingJavaScript(searchButton);
		return new SearchPage();
	}

}
