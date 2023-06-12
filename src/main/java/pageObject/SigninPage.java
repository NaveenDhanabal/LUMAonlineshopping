package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Scanner;

public class SigninPage {
	public WebDriver driver;
	public SigninPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[contains(text(),'Sign In')])[1]")
	WebElement signinbutton;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement username;
	
	@FindBy(xpath="(//input[@id=\"pass\"])[1]")
	WebElement password;
	
	@FindBy(xpath="(//button[@id='send2'])[1]")
	WebElement signin;
	
	@FindBy(xpath="(//input[@id='captcha_user_login'])[1]")
	WebElement captchaField;
   
	public String getErrorMessage() {
	    // Find all error message elements
	    List<WebElement> errorMessages = driver.findElements(By.xpath("//div[@role='alert']"));

	    // Check if error message element exists
	    if (!errorMessages.isEmpty()) {
	        // Return the first error message text
	        return errorMessages.get(0).getText();
	    }
	    // No error message found
	    return "";
	}
	    
	public void SignIn() {
		signinbutton.click();
	}
	public void Credential(String EmailId, String Password) throws InterruptedException {
	    username.sendKeys(EmailId);
	    Thread.sleep(2000);
	    password.sendKeys(Password);
	    Thread.sleep(2000);
	    signin.click();

	    // Check if CAPTCHA validation is required
	    List<WebElement> captchaElements = driver.findElements(By.xpath("//input[@id='captcha_user_login']"));

	    if (!captchaElements.isEmpty()) {
	        // CAPTCHA field is present, perform CAPTCHA validation
	        WebElement captchaElement = captchaElements.get(0);

	        // Loop for handling incorrect CAPTCHA
	        while (true) {
	            // Wait for user input (CAPTCHA)
	            System.out.println("Please enter the CAPTCHA:");
	            Scanner scanner = new Scanner(System.in);
	            String captcha = scanner.nextLine();

	            // Enter the CAPTCHA value
	            captchaField.sendKeys(captcha);

	            username.sendKeys(EmailId);
	            Thread.sleep(2000);
	            password.sendKeys(Password);
	            Thread.sleep(2000);
	            signin.click();

	            // Check if CAPTCHA validation failed
	            WebElement errorMessage = driver.findElement(By.xpath("//div[@data-bind=\"scope: 'messages'\"]"));
	            if (errorMessage.isDisplayed() && errorMessage.getText().contains("CAPTCHA")) {
	                System.out.println("Incorrect CAPTCHA entered. Please try again.");
	                System.out.println("Error Message: " + errorMessage.getText());
	                captchaField.clear();
	            } else {
	                break;  // Exit the loop if CAPTCHA is valid
	            }
	        }
	    }
	}
	
	
	

}
