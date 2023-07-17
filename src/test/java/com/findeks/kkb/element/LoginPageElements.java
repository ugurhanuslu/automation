package com.findeks.kkb.element;

import org.openqa.selenium.By;

/**
 * Created by Ipek Cinar
 * Date: 17.07.2023
 */

public class LoginPageElements {

    public static final By LOGIN_BUTTON = By.id("kullanicinextButton");
    public static final By TAX_NO_ERROR_SUMMARY = By.id("j_idt30_error-summary");
    public static final By ID_NO_ERROR_SUMMARY = By.id("j_idt33_error-summary");
    public static final By TAX_NO_ERROR_DETAIL = By.id("j_idt30_error-detail");
    public static final By ID_NO_ERROR_DETAIL = By.id("j_idt33_error-detail");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By TAX_ID_INPUT = By.id("vkn");
    public static final By ID_INPUT = By.id("tckn");
    public static final By ERROR_MESSAGE = By.cssSelector("#j_idt16 > div > ul > li > span.ui-messages-error-detail");
    public static final By CAPTCHA_IMAGE = By.id("captchaImage");
}
