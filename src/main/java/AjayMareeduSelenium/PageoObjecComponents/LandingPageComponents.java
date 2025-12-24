package AjayMareeduSelenium.PageoObjecComponents;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AjayMareedu.AbstractComponents.ReusableMethods;

public class LandingPageComponents extends ReusableMethods {

	
	WebDriver driver;
	
	//Constructor is the first method to run in a class
	//By using constructor we can catch the driver from test class
	//this. is refers to current class only
	
	public LandingPageComponents(WebDriver driver) { //Constructor is the first method to run in a class
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);//This step will create one time driver.elements as required
		
	}
	
	//WebElement ele = driver.findElement(By.id("userEmail"));; - this is one way of declaring
	//Page factory element which are smart way to store the webelemets
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submitButton;
	
	@FindBy(css=".toast-message")
	WebElement loginErrorMessage;
	
	
	public String VerifyLoginError() {
		
		visibilityOfElementLocatedByDriverLocator(loginErrorMessage);
		String errorMessage = loginErrorMessage.getText();
		return errorMessage;
	}
	
	
	//Creating a method to do actions called as action method
	
	public PageCatalougeComponents loginTo(String userName,String userPassword) {
		
		userEmail.sendKeys(userName);
		password.sendKeys(userPassword);
		submitButton.click();
		return new PageCatalougeComponents(driver);		
		
	}
		
	
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	
	
}
