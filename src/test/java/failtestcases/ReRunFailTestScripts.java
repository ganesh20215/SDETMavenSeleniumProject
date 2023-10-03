package failtestcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReRunFailTestScripts implements IRetryAnalyzer {

    private static int maxRetryCount = 3;
    private static int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
