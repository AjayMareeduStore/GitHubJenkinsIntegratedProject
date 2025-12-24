package AjayMareeduSelenium.PageoObjecComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AjayMareedu.AbstractComponents.ReusableMethods;

public class CartPageComponents extends ReusableMethods {
	
	WebDriver driver;
	
	public CartPageComponents(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".infoWrap")
	List<WebElement> cartProducts;
    
    By selector = By.cssSelector("h3");
    By moveToBillingPage =  By.cssSelector(".cartSection button:first-of-type");
    
    public billingPageComponents cartProductsListVerifacationByNameAndProceedToBillingPage(String RequiredProductName) {
    	 
    	visibilityOfAllElementsLocated(cartProducts);
    	WebElement cartProductName = cartProducts.stream( )
				.filter(cart -> cart.findElement(selector).getText().equalsIgnoreCase(RequiredProductName))
				.findFirst().orElse(null);
		cartProductName.findElement(moveToBillingPage).click();
		return new billingPageComponents(driver);
    	
		
    	
    }

	
}
