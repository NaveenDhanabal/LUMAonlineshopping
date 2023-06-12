package base;


import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.Utility;

public class BaseClass extends Utility{
	
	@BeforeMethod
	public void Startup() throws IOException, InterruptedException {
		driver=intitalizeDriver();
		driver.get(prop.getProperty("url"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("return document.readyState").toString().equals("complete");
		String s = driver.getCurrentUrl();
	if (s.equals(prop.getProperty("url"))) {
	         System.out.println("Page Loaded");
	         System.out.println("Url: " + s);
	      }
	      else {
	         System.out.println("Page did not load");
	      }

		Thread.sleep(2000);
		String titleText =  js.executeScript("return document.title;").toString();
		System.out.println("Page Title : "+titleText);
		}


	
//	@AfterMethod
//	public void close() {
//		driver.quit();
//		}
	
}
