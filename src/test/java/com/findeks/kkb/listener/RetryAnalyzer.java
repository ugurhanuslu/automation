package com.findeks.kkb.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by Ipek Cinar
 * Date: 17.07.2023
 */

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
