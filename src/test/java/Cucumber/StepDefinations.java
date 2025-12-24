package Cucumber;

import TestReusableComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.testng.Assert;

import AjayMareeduSelenium.PageoObjecComponents.CartPageComponents;
import AjayMareeduSelenium.PageoObjecComponents.LandingPageComponents;
import AjayMareeduSelenium.PageoObjecComponents.PageCatalougeComponents;
import AjayMareeduSelenium.PageoObjecComponents.SummaryPageComponents;
import AjayMareeduSelenium.PageoObjecComponents.billingPageComponents;

public class StepDefinations extends BaseTest {

	public LandingPageComponents LandingPageComponents;
	public PageCatalougeComponents PageCatalougeComponents;
	public CartPageComponents CartPageComponents;
	public billingPageComponents billingPageComponents;
	public SummaryPageComponents SummaryPageComponents;

	@Given("Launch the browser and application site")
	public void Launch_the_browser_and_application_site() throws IOException {

		LandingPageComponents = hitUrl();

	}

	@Given("^User login with (.+) and (.+)$")
	public void User_login_with_username_and_password(String username, String password) {
		
		 PageCatalougeComponents = LandingPageComponents
				.loginTo(username,password);

	}
	
	@When ("^Search of required (.+)$")
	public void Search_of_required_product(String product) {
		

		PageCatalougeComponents.AddtoCart(product);
		PageCatalougeComponents.popUpsToDiappear();
		
	}
    @And ("Move to cart page by clicking on Cart link")
    public void Move_to_cart_page_by_clicking_on_Cart_link() {
    	
    	 CartPageComponents = PageCatalougeComponents.globalHeaderCartLink();
    	
    }
    @And ("^Verify for the (.+) added in cart$")
    public void Verify_for_the_product_added_in_cart(String product) {
    	
    	billingPageComponents = CartPageComponents
				.cartProductsListVerifacationByNameAndProceedToBillingPage(product);
    	
    }
    
    @And ("^place and order by selecting the (.+) in the billing page$")
    public void place_and_order_by_selecting_the_countryname_in_the_billing_page(String countryname) {
    	
		billingPageComponents.enterCountryName(countryname);
		billingPageComponents.waitForResultsAndClickOncountryName();
	 SummaryPageComponents = billingPageComponents.placeOrder();
    }
    
    
    @Then ("^Verify the (.+) order placed$")
    public void Verify_the_product_order_placed(String product) {
    	SummaryPageComponents.verifyPoductOrdered().equalsIgnoreCase(product);
    	
    }
    @And ("^verify the (.+) after placing the order$")
    public void verify_the_successmessage_after_placing_the_order(String successmessage) {
    	
    	String SuccessMessage = SummaryPageComponents.verifySuccessMessage();
		Assert.assertTrue(SuccessMessage.equalsIgnoreCase(successmessage));
    	System.out.println(SuccessMessage);
		driver.close();		

    	
    }

}
