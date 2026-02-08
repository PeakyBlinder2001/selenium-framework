package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {

        if (extent == null) {
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("target/ExtentReport.html");

            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Selenium Framework Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}
