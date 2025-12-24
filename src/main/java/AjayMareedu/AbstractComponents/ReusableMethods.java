package AjayMareedu.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AjayMareeduSelenium.PageoObjecComponents.CartPageComponents;
import AjayMareeduSelenium.PageoObjecComponents.OrderPageComponents;

public class ReusableMethods {

	WebDriver driver;

	public ReusableMethods(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	By cartClick = By.cssSelector("button[routerlink*='cart']");
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement OrdersLink;

	

	public void visibilityOfElementLocated(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void visibilityOfElementLocatedByDriverLocator(WebElement locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public void visibilityOfElementLocatedAndProceedByClick(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy)).click();
		
	}

	public void InvisibilityOfElementLocatedBy(By FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));
	}

	public void InvisibilityOfElementLocated(WebElement loader) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}

	public WebElement elementToBeClickable() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(cartClick));
		return cartLink;
	}
	
	public void visibilityOfAllElementsLocated(List<WebElement> cartProducts) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(cartProducts));
	}
	
	
	
	public Actions actions() {
		
		Actions act = new Actions(driver);
		return act;

		
	}
	
	public CartPageComponents globalHeaderCartLink() {

		elementToBeClickable();
		elementToBeClickable().click();
		return new CartPageComponents(driver);

	}
	
	public OrderPageComponents globalHeaderOrdersLink() {

		OrdersLink.click();
		OrderPageComponents orderpage = new OrderPageComponents(driver);
		return orderpage;

	}
	

	
	

}
