package TestReusableComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFlakyTests implements IRetryAnalyzer{

	//this will helpfull to rerun our failed cases to ensure
	
	int count = 0;
	int maxTry = 1;
	@Override
	public boolean retry(ITestResult result) {

if(count<maxTry) {
	
	count++;
	return true;
}
		
		return false;
	}
	
	

}
