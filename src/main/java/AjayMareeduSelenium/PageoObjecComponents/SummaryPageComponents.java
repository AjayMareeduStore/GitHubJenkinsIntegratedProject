package AjayMareeduSelenium.PageoObjecComponents;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AjayMareedu.AbstractComponents.ReusableMethods;

public class SummaryPageComponents extends ReusableMethods{
	
	WebDriver driver;
	
	public SummaryPageComponents(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="(//td[contains(@class,'product-info-column')]/div)[1]")
	WebElement textVerification;
	
	@FindBy(xpath="//*[normalize-space(text())='Thankyou for the order.']")
	WebElement Output;
	
	
	public String verifyPoductOrdered() {
		
		visibilityOfElementLocatedByDriverLocator(textVerification);
		String PoductOrdered =  textVerification.getText();
		return PoductOrdered;
	
	}
	
public String verifySuccessMessage() {
		
		String SuccessMessage =  Output.getText();
		return SuccessMessage;
	
	}
	
}
