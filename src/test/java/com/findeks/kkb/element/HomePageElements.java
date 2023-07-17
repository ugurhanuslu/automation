package com.findeks.kkb.element;

import org.openqa.selenium.By;

/**
 * Created by Ipek Cinar
 * Date: 17.07.2023
 */

public class HomePageElements {

    public static final By ACCEPT_COOKIES = By.cssSelector("body > div.cookie.addSlideAnimation > div.cookie__buttons > button");
    public static final By INSIDER_LOGO = By.cssSelector("#header > div.container-controller.flex > div.logo > a > img");
    public static final By LOGIN_BUTTON = By.id("btn-login");
    public static final By TICARI_BUTTON = By.linkText("Ticari");
}
