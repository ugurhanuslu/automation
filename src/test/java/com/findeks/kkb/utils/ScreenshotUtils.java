package com.findeks.kkb.utils;

import com.findeks.kkb.manager.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String getBase64Image() {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
