package JesssfinalCompany.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportsNG {
	
	public static ExtentReports getreportsobject() {
		//create object for ExtentSparkReporter and extentreports
				String path = System.getProperty("user.dir")+"//reports//index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation results");
				reporter.config().setDocumentTitle("JesssfinalCompany");
				
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Jecintha Amuldoss");
				return extent;
				
				
	}

}
