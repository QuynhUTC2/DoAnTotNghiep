package QuynhTVN.com.Base;

import QuynhTVN.com.SetUpLog.log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext result) {

    }

    @Override
    public void onStart(ITestContext result) {

        log.info("Đã chạy test case" + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Đây là test case bị fail: " + result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Đây là test case bị bỏ qua: " + result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {

        log.info("Đã chạy test case" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Đây là test case chạy thành công: " + result.getName());

    }
}
