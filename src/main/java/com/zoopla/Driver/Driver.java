package com.zoopla.Driver;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.zoopla.property.Property;

public class Driver {
	
	public static WebDriver driver ;

	
	public static void driverInit() 
	{
                   		if(Property.readProperty("browser").equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
			driver= new ChromeDriver();
		}

                else if(Property.readProperty("browser").equalsIgnoreCase("FF")) 
		{
			System.setProperty("webdriver.gecko.driver", "D:\\selenium\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					capabilities.setCapability("chrome.switches", Arrays.asList("--disable-local-storage"));
			driver= new ChromeDriver();
		}

		else
		{
			try {
				throw new Exception("Driver is unrecognisable(chrome/FF)");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(Property.readProperty("url"));
	}

}
