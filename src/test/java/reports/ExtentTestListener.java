package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.base.BaseTest;
import utils.ScreenshotUtils;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getExtent();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }


@Override
public void onTestFailure(ITestResult result) {

    test.get().fail(result.getThrowable());

    Object testClass = result.getInstance();
    WebDriver driver =
            ((BaseTest) testClass).getDriver();

    String screenshotPath =
            utils.ScreenshotUtils.takeScreenshot(
                    driver,
                    result.getMethod().getMethodName()
            );

    if (screenshotPath != null) {
        test.get().addScreenCaptureFromPath(screenshotPath);
    }
}


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
