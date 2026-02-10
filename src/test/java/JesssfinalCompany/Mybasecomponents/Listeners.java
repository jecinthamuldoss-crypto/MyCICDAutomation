package JesssfinalCompany.Mybasecomponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import JesssfinalCompany.Resources.ExtentreportsNG;

public class Listeners extends basetest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentreportsNG.getreportsobject();
	ThreadLocal<ExtentTest> thread = new ThreadLocal();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		thread.set(test);  // it creates an unique ID for the each testcase
	    
	  }

	  
	public void onTestSuccess(ITestResult result) {
		thread.get().log(Status.PASS, "Testcase is passed");
	    
	  }

	  
	public void onTestFailure(ITestResult result) {
		thread.get().fail(result.getThrowable()); //creates unique ID for failed tescase
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String filepath = null;
		try {
			filepath = Getscreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		
		
	}

	 
	public void onTestSkipped(ITestResult result) {
	
	  }

	public void onTestFailedWithTimeout(ITestResult result) {
	 
	  }
	public void onFinish(ITestContext context) {
		 extent.flush();
		
	}
	 
}
