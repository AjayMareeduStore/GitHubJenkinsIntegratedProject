package AjayMareeduSelenium.PageoObjecComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AjayMareedu.AbstractComponents.ReusableMethods;

public class OrderPageComponents extends ReusableMethods {

	WebDriver driver;

	public OrderPageComponents(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> OrderProducts;

	public boolean OrderpageValidation(String RequiredProductName) {

		visibilityOfAllElementsLocated(OrderProducts);
		boolean match = OrderProducts.stream().anyMatch(order -> order.getText().equalsIgnoreCase(RequiredProductName));
		return match;

	}

}
