package com.zoopla.tests;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zoopla.Driver.Driver;
import com.zoopla.pages.AgeentDetailssPage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.PropertyDetails;
import com.zoopla.pages.SearchPage;
import com.zoopla.utilities.Scroll;


public class Tests1 {
	
	public SearchPage sp;
	public PropertyDetails pd;
	public AgeentDetailssPage ag;
	
	@BeforeTest
	public void setup() 
	{
		Driver.driverInit();
	
	}
	
	@Test(priority = 1)
	public void searchTest() 
	{
		HomePage hp = new HomePage();
		
		hp.searchLocation();
	
		sp= hp.clickOnSearch();
		
	}
	
	@Test(priority = 2)
	public void priceTest() {
		Scroll.scrollDown();
		sp.printPropertyPrice();
		
	}
		
		
	@Test(priority = 3)
	public void SelectFifthProperty()
	{
		pd =sp.selectProperty();
	}
	
	@Test(priority = 4)
	public void agentsPageTest()
	{
		ag =pd.clickOnAgentLogo();
		ag.chkAgentName();
	}
	
	@AfterTest
	public void tearDown() 
	{
	//Driver.driver.quit();
		}

}
