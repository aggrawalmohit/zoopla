package com.zoopla.utilities;

import org.openqa.selenium.WebElement;



public class Scroll {
	
	
	
	public static void scrollToElement(WebElement element) 
	{
		Utilities.javaScriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void scrollDown() 
	{
		long height = Long.parseLong((Utilities.javaScriptExecutor().executeScript("return document.body.scrollHeight").toString()));
		while(true) 
		{
			Utilities.javaScriptExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight)");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			long newHeight = Long.parseLong((Utilities.javaScriptExecutor().executeScript("return document.body.scrollHeight").toString()));
			if(newHeight==height) 
			{
				break;
			}
			height=newHeight;
		}
	}

}
