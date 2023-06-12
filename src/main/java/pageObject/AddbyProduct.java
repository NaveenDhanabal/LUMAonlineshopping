package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddbyProduct {
	public WebDriver driver;
	public AddbyProduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[@id='ui-id-6'])[1]")
	WebElement gear;
	
	@FindBy(xpath="(//a[@id='ui-id-27'])[1]")
	WebElement watches;
	
	@FindBy(xpath="(//img[@alt='Cruise Dual Analog Watch'])[1]")
	WebElement analogWatch;
	
	@FindBy(xpath="(//button[@id='product-addtocart-button'])[1]")
	WebElement addtocart;
	
	@FindBy(xpath="(//div[@class='minicart-wrapper'])[1]")
	WebElement cartbutton;
	
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']")
	WebElement proceedcheckout;
	
	@FindBy(xpath="(//div[@name='shippingAddress.street.0'])[1]")
	WebElement addressline1;
	
	@FindBy(xpath="//input[@id='FSACQTF']")
	WebElement city;
	
	@FindBy(xpath="(//select[@id='GX8QTKO'])[1]")
	WebElement state;
	
	@FindBy(xpath="(//input[@id='KIM7DKC'])[1]")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@id='CX11SWT']")
	WebElement phonenumber;
	
	@FindBy(xpath="(//input[@name='ko_unique_13'])[1]")
	WebElement radiobutton;
	
	@FindBy(xpath="(//span[normalize-space()='Next'])[1]")
	WebElement nextbutton;
	
	@FindBy(xpath="//button[@type='button']//span[contains(text(),'Sign In')]")
	WebElement signin;
	
	@FindBy(xpath="//input[@id='login-email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='login-password']")
	WebElement password;
	
	@FindBy(xpath="//form[@data-role='login']//button[@type='submit']")
	WebElement signinbutton;
	
	public void byProduct() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(gear).perform();
		Thread.sleep(2000);
		watches.click();
		Thread.sleep(2000);
		actions.scrollToElement(analogWatch);
		Thread.sleep(2000);
		analogWatch.click();
		Thread.sleep(2000);
		addtocart.click();
		Thread.sleep(2000);
		cartbutton.click();
		Thread.sleep(2000);
		proceedcheckout.click();
		Thread.sleep(2000);
		}
	
	public void Signin(String EmailId, String Password) throws InterruptedException {
		signin.click();
		Thread.sleep(1500);
		username.sendKeys(EmailId);
		Thread.sleep(1500);
		password.sendKeys(Password);
		Thread.sleep(1500);
		signinbutton.click();
		}
	
	public void Addressinfo(String Address, String City, String State, String Postcode,String PhoneNumber) throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Wait for a maximum of 10 seconds
		 	addressline1.sendKeys(Address);
		    wait.until(ExpectedConditions.elementToBeClickable(city)).sendKeys(City);
		    wait.until(ExpectedConditions.elementToBeClickable(state)).sendKeys(State);
		    wait.until(ExpectedConditions.elementToBeClickable(zipcode)).sendKeys(Postcode);
		    wait.until(ExpectedConditions.elementToBeClickable(phonenumber)).sendKeys(PhoneNumber);
		Thread.sleep(2000);
		radiobutton.click();
		Thread.sleep(2000);
		nextbutton.click();
	}
	

}
