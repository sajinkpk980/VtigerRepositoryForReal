package practice;



import org.testng.Assert;
import org.testng.annotations.Test;



public class retryanalizerpractice {
@Test(retryAnalyzer=vtigerFrameworkReal.genericutility.ReTryAnalyserImplementation.class)
public void retry() {
	System.out.println("rety analixer");
	Assert.fail();
}
}
