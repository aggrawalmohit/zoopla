package com.zoopla.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.zoopla.Driver.Driver;

public class AgeentDetailssPage {
	
	@FindBy(xpath="//*[@id=\"listings-agent\"]/div/p[1]/strong")
	WebElement agentNaameONAgentDEtails;
	
	@FindBy(xpath=".//div[@id=\"dp-sticky-element\"]/descendant::div[@class=\"ui-agent__text\"]/h4")
	WebElement agentNaameOnPropetyDetailsPage;
	
	
	
	
	
	public AgeentDetailssPage() 
	{
		PageFactory.initElements(Driver.driver,this);
	}
	
	public void chkAgentName() 
	{
		String agentName = agentNaameONAgentDEtails.getAttribute("innerText");
		
		List<WebElement> list = Driver.driver.findElements(By.xpath(".//li[@class=\"srp clearfix   \"]/descendant::a[@class=\"listing-results-price text-price\"]"));
		for(WebElement li : list) 
		{
			li.click();
		String name = agentNaameOnPropetyDetailsPage.getAttribute("innerText");
		Assert.assertEquals(agentName, name);
		Driver.driver.navigate().back();
			
		}
	}
	
	

}
