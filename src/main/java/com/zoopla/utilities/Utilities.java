package com.zoopla.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zoopla.Driver.Driver;

public class Utilities {
	
	public static WebDriverWait wait ;
	
	public static void enterText(String text,WebElement element) 
	{
		wait = new WebDriverWait(Driver.driver,10);
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	}
	
	public static void clickOn(WebElement element) 
	{
		wait = new WebDriverWait(Driver.driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static JavascriptExecutor  javaScriptExecutor() 
	{
		JavascriptExecutor js = (JavascriptExecutor)Driver.driver;
		return js;
	}
	
	public static void SwitchToFrame(String FrameID) 

	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		Driver.driver.switchTo().frame(FrameID);
	}
	public static void waitTill(WebElement element) 
	{
		while(true) 
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			if(element.isDisplayed()) 
			{
				break;
			}
		}
	}

	public static void clickUsingJavaScript(WebElement element) 
	{
		Utilities.javaScriptExecutor().executeScript("arguments[0].click();",element);
	}
}
