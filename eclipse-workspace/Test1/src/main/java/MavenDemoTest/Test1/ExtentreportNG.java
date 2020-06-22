package MavenDemoTest.Test1;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentreportNG {
	public static ExtentReports report;
	public static  ExtentTest logger;
	

	public ExtentReports getReportObject()
	{
		String path = System.getProperty("C:\\Users\\LENOVO\\eclipse-workspace\\Test1\\Reports"+"/Reports/MyReport.html");
	 report = new ExtentReports(path);
	 logger=report.startTest("demo");
	 report.addSystemInfo("hostname","System info");
	 report.addSystemInfo("sonam", "developer");
	 report.loadConfig(new File(System.getProperty("user.dir")+"extent-config.xml"));
	 report.close();
	 report.flush();
	 return report;

	}

}
