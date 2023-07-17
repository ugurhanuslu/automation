package com.findeks.kkb.base;
import com.findeks.kkb.reports.ExtentLogger;
import com.findeks.kkb.logs.Logs;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * Created by Ipek Cinar
 * Date: 17.07.2023
 */

public class StepImplementations extends BasePage {

    Logger logger = LogManager.getLogger(Logs.class.getName());

    public void click(By by) {
        try {
            clickElement(by);
            ExtentLogger.info("Clicked element: " + by);
            logger.info("Clicked element: " + by);
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            ExtentLogger.info("Can not clicked element: " + by);
            logger.error("Can not clicked element: " + by);
            assertFail();
        }
    }
    public void setText(By by, String text) {
        try {
            writeText(by, text);
            ExtentLogger.info("Clicked element: " + by);
            logger.info("Clicked element: " + by);
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            ExtentLogger.info("Can not clicked element: " + by);
            logger.error("Can not clicked element: " + by);
            assertFail();
        }
    }

    public void scrollToElement(By by) {
        try {
            scrollElement(by);
            ExtentLogger.info("Scrolled to element successfully");
            logger.info("Scrolled to element successfully");
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            ExtentLogger.info("Can not scrolled to element successfully");
            logger.error("Can not scrolled to element successfully");
            assertFail();
        }
    }

    public void verifyText(By by, String text) {
        try {
            assertEquals(getText(by), text);
            ExtentLogger.info(by + " text is checked successfully");
            logger.info(by + " text is checked successfully");
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            ExtentLogger.info(by + " text is not checked successfully");
            logger.error(by + " text is not checked successfully");
            assertFail();
        }
    }
    public void verifyColor(By by, String text) {
        try {
            assertEquals(getColor(by), text);
            ExtentLogger.info(by + " text is checked successfully");
            logger.info(by + " text is checked successfully");
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            ExtentLogger.info(by + " text is not checked successfully");
            logger.error(by + " text is not checked successfully");
            assertFail();
        }
    }


    public void isDisplayed(By by) {
        try {
            isElementDisplayed(by);
            ExtentLogger.info("Element is checked successfully");
            logger.info("Element is checked successfully");
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            ExtentLogger.info("Element is not checked successfully");
            logger.error("Element is not checked successfully");
            assertFail();
        }
    }

    public void switchToNewTab() {
        try {
            switchTab();
            ExtentLogger.info("Switched to new tab successfully");
            logger.info("Switched to new tab successfully");
        } catch (Exception e) {
            ExtentLogger.info(e.getMessage());
            ExtentLogger.info("Can not switched to new tab successfully");
            logger.error("Can not switched to new tab successfully");
            assertFail();
        }
    }
}
