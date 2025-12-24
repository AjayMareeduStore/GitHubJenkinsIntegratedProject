package AjayMareeduSelenium.PageoObjecComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AjayMareedu.AbstractComponents.ReusableMethods;

public class billingPageComponents extends ReusableMethods{

	
	WebDriver driver;
	
	public billingPageComponents(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	By countryLocator = By.xpath("//input[@placeholder='Select Country']");
	By results = By.cssSelector(".ta-results");
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
    WebElement indLocator;
	
	@FindBy(xpath="//*[normalize-space(text())='Place Order']")
	WebElement placeOrderLocator;
	
	
	
	public void enterCountryName(String CountryName) {
		
		visibilityOfElementLocatedAndProceedByClick(countryLocator);
		actions().sendKeys(CountryName).build().perform();	
	}
	
	public void waitForResultsAndClickOncountryName() {
		
		visibilityOfElementLocated(results);
		actions().moveToElement(indLocator).click().perform();

					
	}
	
	public SummaryPageComponents placeOrder() {
		
		actions().moveToElement(placeOrderLocator).click().perform();
		return new SummaryPageComponents(driver);
		
	}
	
	
	

	
}
