package vtigerFrameworkReal.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryAnalyserImplementation implements IRetryAnalyzer {

	public boolean retry(ITestResult result) 
	{
		int count=0;
		int retrycount = 3;
		while(count<retrycount)
		{
			count++;
			return true;
		}
		
		
		return false;
	}

}
