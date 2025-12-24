package AjayMareeduSelenium.PageoObjecComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AjayMareedu.AbstractComponents.ReusableMethods;

public class PageCatalougeComponents extends ReusableMethods {

	WebDriver driver;

	public PageCatalougeComponents(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".col-lg-4")
	List<WebElement> productsList;

	@FindBy(css = ".ng-animating")
	WebElement loader;

	By addTocartElement = By.cssSelector(".card-body button:last-of-type");
	By findBy = By.cssSelector(".col-lg-4");
	By popUp = By.cssSelector("#toast-container");

	public void AddtoCart(String RequiredProductName) {

		visibilityOfElementLocated(findBy);
		WebElement product = productsList.stream()
				.filter(prd -> prd.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(RequiredProductName))
				.findFirst().orElse(null);
		product.findElement(addTocartElement).click();

	}

	public void popUpsToDiappear() {

		InvisibilityOfElementLocatedBy(popUp);
		InvisibilityOfElementLocated(loader);
	}

	
}
