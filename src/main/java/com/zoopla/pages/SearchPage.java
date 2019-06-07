package com.zoopla.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.zoopla.Driver.Driver;
import com.zoopla.utilities.Utilities;

public class SearchPage 
{
	
	public void printPropertyPrice() 
	{
		List<Long> p = new  ArrayList<Long>();
		List<WebElement> list = Driver.driver.findElements(By.xpath(".//li[@class=\"srp clearfix   \"]/descendant::a[@class=\"listing-results-price text-price\"]"));
		for(WebElement li : list) 
		{
			
		long price = Long.parseLong(li.getText().replaceAll("[^\\d]",""));
		p.add(price);
			
		}
	Collections.sort(p);
	Collections.reverse(p);
	
for(long price : p) 
{
 System.out.println(price);	
}
	}
	
	public PropertyDetails selectProperty() 
	{
		int counter = 1 ;
		int inc= 5;
		List<WebElement> list = Driver.driver.findElements(By.xpath(".//li[@class=\"srp clearfix   \"]/descendant::a[@class=\"listing-results-price text-price\"]"));
		for(WebElement li : list) 
		{
			if(counter==inc) 
			{
				Utilities.clickUsingJavaScript(li);
				break;
			}
			counter++;
		}
		return new PropertyDetails();
	}

}
