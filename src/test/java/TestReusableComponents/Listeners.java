package TestReusableComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import AjayMareduSelenium.Resources.ExtentReportMechanism;

public class Listeners extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReportMechanism.extentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    
	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//This acual stores static value even we use same time different values

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.get().log(Status.PASS,"Test Ran Successfully");

	}

	

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest.get().fail(result.getThrowable());
		String filepath =null;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
	
		try {
			filepath = takeScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

		// SreenShot Method attaching
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
