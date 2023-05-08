package vtigerFrameworkReal.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersImplimentation implements ITestListener{

	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"----->executionstarted-----<",true);
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"----->test successful-----<",true);
	}

	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"----->test fail-----<",true);
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"----->test skipped-----<",true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		Reporter.log("execution started",true);
			}

	public void onFinish(ITestContext context) {
		Reporter.log("execution completed",true);
	}

}
