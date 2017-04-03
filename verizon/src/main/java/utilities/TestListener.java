package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

	@Override
	public void onFinish(ITestContext test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext test) {
			System.out.println(test.getName() + " started");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult test) {
		System.out.println("Taking screenshot for test method: " + test.getMethod().getMethodName());
		ScreenshotUtils.screenshotOnFailure();
	}

	@Override
	public void onTestSkipped(ITestResult test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult test) {
		// TODO Auto-generated method stub
		
	}
	

}
