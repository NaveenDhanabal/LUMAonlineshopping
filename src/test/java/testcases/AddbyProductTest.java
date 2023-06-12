package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObject.AddbyProduct;

public class AddbyProductTest extends BaseClass{
	
	@Test
	public void ByProduct() throws InterruptedException {
		AddbyProduct product = new AddbyProduct(driver);
		product.byProduct();
		Thread.sleep(2000);
		product.Signin(prop.getProperty("EmailId"), prop.getProperty("Password"));
		Thread.sleep(2000);
		product.Addressinfo(prop.getProperty("Address"),prop.getProperty("city"),prop.getProperty("State"),prop.getProperty("Postcode"),prop.getProperty("PhoneNumber"));
		
		
	}

}
