package AjayMareduSelenium.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportMechanism {
	
	
	public static ExtentReports extentReports() {
		
		//We need to get the extent reports dependecies from maven repository and need to set in pom.xml
		// we need to use two classes to set report mechanism - ExtentSparkReporter and ExtentReports
		
		String path = System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test_Results");
		reporter.config().setReportName("AjayMareedu");
		
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ajay Mareedu"); // it wil create a test file in the given path
		return extent;
		
		
	}

}
