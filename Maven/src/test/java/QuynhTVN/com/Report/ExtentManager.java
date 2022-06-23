package QuynhTVN.com.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static final ExtentReports extentReports = new ExtentReports();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/ExtentReport2.html"  + dateFormat.format(new Date()));
        reporter.config().setReportName("Demo Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java Framework | QuynhUTC2");
        extentReports.setSystemInfo("Author", "QuynhUTC2");
        return extentReports;
    }
}
