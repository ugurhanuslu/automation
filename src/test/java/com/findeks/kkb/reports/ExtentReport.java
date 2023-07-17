package com.findeks.kkb.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

/**
 * Created by Ipek Cinar
 * Date: 17.07.2023
 */

public class ExtentReport {

    private static ExtentReports extent;

    public static void initReports() {
        if (Objects.isNull(ExtentManager.getExtentTest())) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/report/extent-report.html");
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("Findeks Automation Report");
            spark.config().setDocumentTitle("Findeks Automation");
            extent.attachReporter(spark);
        }
    }

    public static void tearDownReports() {
        if (Objects.nonNull(ExtentManager.getExtentTest())) {
            extent.flush();
            ExtentManager.unload();
        }
    }

    public static void createTest(String testCaseName) {
        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }
}
