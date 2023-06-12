package testcases;

import org.testng.annotations.Test;
import pageObject.SigninPage;

import base.BaseClass;

public class SigninTest extends BaseClass{
	
	@Test
	public void signin_ValidCredential() throws InterruptedException {
		SigninPage signin = new SigninPage(driver);
		signin.SignIn();
		signin.Credential(prop.getProperty("EmailId"),prop.getProperty("Password"));
		
	    String errorMessage = signin.getErrorMessage();
	    if (errorMessage.isEmpty()) {
	        System.out.println("Sign-in successful!");
	    } else {
	        System.out.println("Sign-in failed. Error message: " + errorMessage);
	    }
}
	
	@Test
	public void signin_InValidCredential() throws InterruptedException {
		SigninPage signin = new SigninPage(driver);
		signin.SignIn();
		signin.Credential(prop.getProperty("EmailId"),prop.getProperty("InvalidPass"));
		
	    String errorMessage = signin.getErrorMessage();
	    if (errorMessage.isEmpty()) {
	        System.out.println("Sign-in successful!");
	    } else {
	        System.out.println("Sign-in failed. Error message: " + errorMessage);
	    }
}

}
