package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.zoopla.Driver.Driver;
import com.zoopla.utilities.Utilities;

public class PropertyDetails{
	
	@FindBy(xpath=".//div[@id=\"dp-sticky-element\"]/descendant::div[@class=\"ui-agent__logo\"]/img")
	WebElement dealerLogoLink;
	
	
	
	public PropertyDetails() 
	{
		PageFactory.initElements(Driver.driver, this);
	}
	public AgeentDetailssPage clickOnAgentLogo() 
	{
		Utilities.clickUsingJavaScript(dealerLogoLink);
		return new AgeentDetailssPage();
	}
	
	
	

}
