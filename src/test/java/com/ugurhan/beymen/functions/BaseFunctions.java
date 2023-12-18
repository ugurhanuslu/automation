package com.ugurhan.beymen.functions;
import com.ugurhan.beymen.manager.TextFileManager;
import com.ugurhan.beymen.test.BaseTest;
import com.ugurhan.beymen.utils.WaitElementUtils;
import com.ugurhan.beymen.manager.DriverFactory;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public abstract class BaseFunctions extends BaseTest {
    private static final Logger logger = Logger.getLogger(BaseFunctions.class);

    public void clickElement(By by) {
        WaitElementUtils.waitUntilClickableOfElementLocatedBy(by);
        Actions action = new Actions(DriverFactory.driver);
        action.moveToElement(findElement(by));
        action.click();
        action.build().perform();
        logger.info("Element clicked " + by);
    }
    public void clearElement(By by) {
        WaitElementUtils.waitUntilClickableOfElementLocatedBy(by);
        Actions action = new Actions(DriverFactory.driver);
        action.moveToElement(findElement(by));
        findElement(by).clear();
        logger.info("Element cleared " + by);
    }

    public Boolean elementExist(By by) {
        try {
            DriverFactory.driver.findElement(by);
        } catch (NoSuchElementException e) {
            logger.error("Element not exist " + by);
            return false;
        }
        logger.info("Element exist " + by);
        return true;
    }
    public void setValue(By by, String value) {
        WaitElementUtils.waitUntilVisibilityOfElementLocatedBy(by);
        WebElement selectElement = findElement(by);
        Select select = new Select(selectElement);
        select.selectByValue(value);
        logger.info("Value set " + value);
    }
    public void writeText(By by, String text) {
        WaitElementUtils.waitUntilVisibilityOfElementLocatedBy(by);
        WebElement element = findElement(by);
        Actions action = new Actions(DriverFactory.driver);
        action.moveToElement(findElement(by));
        element.sendKeys(text);
        action.build().perform();
        logger.info("Text written " + by);
    }

    public void writeToTxt(By by, By ba) throws InterruptedException {
        wait(2);
        WebElement desc = findElement(by);
        WebElement prc = findElement(ba);
        TextFileManager.WriteLine(desc.getText(), prc.getText());
        logger.info("Written to TXT " + by + "and" + ba);
    }

    public void pressKeyboard(By by, String text) {
        WaitElementUtils.waitUntilVisibilityOfElementLocatedBy(by);
        WebElement element = findElement(by);
        Actions action = new Actions(DriverFactory.driver);
        action.moveToElement(findElement(by));
        element.sendKeys(Keys.ENTER);
        logger.info("Keyboard pressed " + text);
    }

    public WebElement findElement(By by) {
        WaitElementUtils.waitUntilPresenceOfElementLocatedBy(by);
        WaitElementUtils.waitUntilVisibilityOfElementLocatedBy(by);
        logger.info("Element found " + by);
        return DriverFactory.driver.findElement(by);
    }



    public void wait(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }



    public void click(By by) {
        try {
            clickElement(by);
            logger.info("Clicked element: " + by);
        } catch (Exception e) {
            logger.error("Can not clicked element: " + by);
            assertFail();
        }
    }


    public void clear(By by) {
        try {
            clearElement(by);
            logger.info("Clicked element: " + by);
        } catch (Exception e) {
            logger.error("Can not clicked element: " + by);
            assertFail();
        }
    }


    public void verifyTitle(String text) {
        try {
            wait(3);
            assertEquals(DriverFactory.driver.getTitle(), text);
            logger.info(DriverFactory.driver.getTitle() + " title is checked successfully");
            System.out.println(DriverFactory.driver.getTitle());
        } catch (Exception e) {
            logger.error(DriverFactory.driver.getTitle() + " title is not checked successfully");
            assertFail();
        }
    }

    public String getText(By by) {
        return findElement(by).getText();
    }
    public String getColor(By by) {
        return findElement(by).getCssValue("color").trim();
    }

    public void isElementDisplayed(By by) {
        findElement(by).isDisplayed();
    }

    public void assertEquals(String actualText, String expectedText) {
            Assertions.assertTrue(actualText.contains(expectedText));
    }

    public void assertFail() {
        Assertions.fail();
    }
}
