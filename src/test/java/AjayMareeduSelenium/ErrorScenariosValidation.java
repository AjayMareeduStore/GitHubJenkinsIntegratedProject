package AjayMareeduSelenium;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestReusableComponents.BaseTest;
import TestReusableComponents.RetryFlakyTests;

public class ErrorScenariosValidation extends BaseTest {

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=RetryFlakyTests.class)
	public void loginErrorValidation() throws IOException {

		LandingPageComponents.loginTo("ajayseleniu@gmail.com",
				"Ajay@123");
		String errMsg = LandingPageComponents.VerifyLoginError();
		System.out.println(errMsg);
		Assert.assertTrue(errMsg.equalsIgnoreCase("Incorrect email and password."));;
		
  


	}

}
