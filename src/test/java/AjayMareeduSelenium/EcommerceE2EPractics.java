package AjayMareeduSelenium;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AjayMareeduSelenium.PageoObjecComponents.CartPageComponents;
import AjayMareeduSelenium.PageoObjecComponents.OrderPageComponents;
import AjayMareeduSelenium.PageoObjecComponents.PageCatalougeComponents;
import AjayMareeduSelenium.PageoObjecComponents.SummaryPageComponents;
import AjayMareeduSelenium.PageoObjecComponents.billingPageComponents;
import TestReusableComponents.BaseTest;

public class EcommerceE2EPractics extends BaseTest {

	String RequiredProductName = "ZARA COAT 3";

	@Test(dataProvider="getDataWithHashMap",groups="differentDataSet")
	public void placeAnOrder(HashMap<String,String> input) throws IOException {

		PageCatalougeComponents PageCatalougeComponents = LandingPageComponents
				.loginTo(input.get("Email"),input.get("Password"));

		PageCatalougeComponents.AddtoCart(input.get("PrdName"));
		PageCatalougeComponents.popUpsToDiappear();
		CartPageComponents CartPageComponents = PageCatalougeComponents.globalHeaderCartLink();

		billingPageComponents billingPageComponents = CartPageComponents
				.cartProductsListVerifacationByNameAndProceedToBillingPage(input.get("PrdName"));
		billingPageComponents.enterCountryName("ind");
		billingPageComponents.waitForResultsAndClickOncountryName();
		SummaryPageComponents SummaryPageComponents = billingPageComponents.placeOrder();

		SummaryPageComponents.verifyPoductOrdered().equalsIgnoreCase(input.get("PrdName"));
		String SuccessMessage = SummaryPageComponents.verifySuccessMessage();
		Assert.assertTrue(SuccessMessage.equalsIgnoreCase("Thankyou for the order."));
		System.out.println(SuccessMessage);

	}

	@Test(dependsOnMethods = { "placeAnOrder" })
	public void orderHistoryValidation() {

		PageCatalougeComponents PageCatalougeComponents = LandingPageComponents.loginTo("ajayselenium@gmail.com",
				"Ajay@123");
		OrderPageComponents OrderPageComponents = PageCatalougeComponents.globalHeaderOrdersLink();
		OrderPageComponents.OrderpageValidation(RequiredProductName);
		Assert.assertTrue(OrderPageComponents.OrderpageValidation(RequiredProductName));

	}

	
	//Data provider with hashmap 
	
	@DataProvider
	public Object[][] getDataWithHashMap() throws IOException {
		List<HashMap<String, String>> map = readData(System.getProperty("user.dir")+
				"\\src\\test\\java\\TestDataCreation\\testData.json");
		return new Object[] [] {{map.get(0)},{map.get(1)}};
	
	
	
	
	}
	


	}


//DataProvider with multi dimensional array objec
	
//	@DataProvider
//	public void getDataWithAnArray() {
		

//		return new Object[][] { { "ajayselenium1@gmail.com", "Ajay@123", "ZARA COAT 3" },
//				{ "ajayselenium@gmail.com", "Ajay@123", "ADIDAS ORIGINAL" } };
	
//}
	
	//Creating an object with hashmap
//	HashMap<Object,Object> map = new HashMap<Object,Object>();
//	map.put("Email", "ajayselenium@gmail.com");
//	map.put("Password", "Ajay@123");
//	map.put("PrdName", "ADIDAS ORIGINAL");
//	
//	HashMap<Object,Object> map1 = new HashMap<Object,Object>();
//	map1.put("Email", "ajayselenium1@gmail.com");
//	map1.put("Password", "Ajay@123");
//	map1.put("PrdName", "ZARA COAT 3");

