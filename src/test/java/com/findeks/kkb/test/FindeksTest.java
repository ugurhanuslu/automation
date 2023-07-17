package com.findeks.kkb.test;

import com.findeks.kkb.constant.LoginPageConstants;
import com.findeks.kkb.element.*;
import com.findeks.kkb.base.StepImplementations;
import org.testng.annotations.Test;

/**
 * Created by Ipek Cinar 17.07.2023
 * Date: 26.06.2023
 */

public class FindeksTest extends StepImplementations {

    @Test(testName = "All input areas empty case")
    public void all_input_areas_empty() throws InterruptedException {
        click(HomePageElements.ACCEPT_COOKIES);
        isDisplayed(HomePageElements.INSIDER_LOGO);
        click(HomePageElements.LOGIN_BUTTON);
        click(HomePageElements.TICARI_BUTTON);
        switchToNewTab();
        click(LoginPageElements.LOGIN_BUTTON);
        verifyText(LoginPageElements.TAX_NO_ERROR_SUMMARY, LoginPageConstants.TAX_NO_ERROR_SUMMARY);
        verifyText(LoginPageElements.TAX_NO_ERROR_DETAIL, LoginPageConstants.TAX_NO_ERROR_DETAIL);
        verifyText(LoginPageElements.ID_NO_ERROR_SUMMARY, LoginPageConstants.ID_NO_ERROR_SUMMARY);
        verifyText(LoginPageElements.ID_NO_ERROR_DETAIL, LoginPageConstants.ID_NO_ERROR_DETAIL);
        verifyColor(LoginPageElements.PASSWORD_INPUT, LoginPageConstants.COLOR_ID);
    }
    @Test(testName = "Only tax id filled case")
    public void only_tax_id_filled() throws InterruptedException {
        click(HomePageElements.ACCEPT_COOKIES);
        isDisplayed(HomePageElements.INSIDER_LOGO);
        click(HomePageElements.LOGIN_BUTTON);
        click(HomePageElements.TICARI_BUTTON);
        switchToNewTab();
        wait(1);
        writeText(LoginPageElements.TAX_ID_INPUT, LoginPageConstants.DUMMY_TAX_ID);
        click(LoginPageElements.LOGIN_BUTTON);
        verifyText(LoginPageElements.ID_NO_ERROR_SUMMARY, LoginPageConstants.ID_NO_ERROR_SUMMARY);
        verifyText(LoginPageElements.ID_NO_ERROR_DETAIL, LoginPageConstants.ID_NO_ERROR_DETAIL);
        verifyColor(LoginPageElements.PASSWORD_INPUT, LoginPageConstants.COLOR_ID);
        wait(5);
    }
    @Test(testName = "Only id filled case")
    public void only_id_filled() throws InterruptedException {
        click(HomePageElements.ACCEPT_COOKIES);
        isDisplayed(HomePageElements.INSIDER_LOGO);
        click(HomePageElements.LOGIN_BUTTON);
        click(HomePageElements.TICARI_BUTTON);
        switchToNewTab();
        wait(1);
        writeText(LoginPageElements.ID_INPUT, LoginPageConstants.DUMMY_ID);
        click(LoginPageElements.LOGIN_BUTTON);
        verifyText(LoginPageElements.TAX_NO_ERROR_SUMMARY, LoginPageConstants.TAX_NO_ERROR_SUMMARY);
        verifyText(LoginPageElements.TAX_NO_ERROR_DETAIL, LoginPageConstants.TAX_NO_ERROR_DETAIL);
        verifyColor(LoginPageElements.PASSWORD_INPUT, LoginPageConstants.COLOR_ID);
        wait(5);
    }
    @Test(testName = "KNOWN FAIL SCENARIO - Only password filled case")
    public void KNOWN_FAIL_SCENARIO_only_password_filled() throws InterruptedException {
        click(HomePageElements.ACCEPT_COOKIES);
        isDisplayed(HomePageElements.INSIDER_LOGO);
        click(HomePageElements.LOGIN_BUTTON);
        click(HomePageElements.TICARI_BUTTON);
        switchToNewTab();
        wait(1);
        writeText(LoginPageElements.PASSWORD_INPUT, LoginPageConstants.DUMMY_PASSWORD);
        click(LoginPageElements.LOGIN_BUTTON);
        verifyText(LoginPageElements.TAX_NO_ERROR_SUMMARY, LoginPageConstants.TAX_NO_ERROR_SUMMARY);
        verifyText(LoginPageElements.TAX_NO_ERROR_DETAIL, LoginPageConstants.TAX_NO_ERROR_DETAIL);
        verifyText(LoginPageElements.ID_NO_ERROR_SUMMARY, LoginPageConstants.ID_NO_ERROR_SUMMARY);
        verifyText(LoginPageElements.ID_NO_ERROR_DETAIL, LoginPageConstants.ID_NO_ERROR_DETAIL);
        verifyColor(LoginPageElements.PASSWORD_INPUT, LoginPageConstants.COLOR_ID);
        wait(5);
    }
    @Test(testName = "All areas filled case")
    public void all_areas_filled() throws InterruptedException {
        click(HomePageElements.ACCEPT_COOKIES);
        isDisplayed(HomePageElements.INSIDER_LOGO);
        click(HomePageElements.LOGIN_BUTTON);
        click(HomePageElements.TICARI_BUTTON);
        switchToNewTab();
        wait(1);
        writeText(LoginPageElements.TAX_ID_INPUT, LoginPageConstants.DUMMY_TAX_ID);
        writeText(LoginPageElements.ID_INPUT, LoginPageConstants.DUMMY_ID);
        writeText(LoginPageElements.PASSWORD_INPUT, LoginPageConstants.DUMMY_PASSWORD);
        click(LoginPageElements.LOGIN_BUTTON);
        click(LoginPageElements.ERROR_MESSAGE);
        verifyText(LoginPageElements.ERROR_MESSAGE, LoginPageConstants.ERROR_MESSAGE);
        isDisplayed(LoginPageElements.CAPTCHA_IMAGE);
    }
}
