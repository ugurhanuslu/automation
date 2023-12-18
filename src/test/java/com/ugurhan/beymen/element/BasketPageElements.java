package com.ugurhan.beymen.element;

import org.openqa.selenium.By;


public class BasketPageElements {

    public static final By ITEM_VALUE = By.id("quantitySelect0-key-0");
    public static final By FINAL_ITEM_VALUE = By.cssSelector("#quantitySelect0-key-0 > option:nth-child(2)");
    public static final By VALUE = By.xpath("//*[@id=\"quantitySelect0-key-0\"]/option[2]");
    public static final By DELETE_ITEM = By.id("removeCartItemBtn0-key-0");
    public static final By BASKET_PRICE = By.className("m-productPrice__salePrice");
    public static final By EMPTY_MESSAGE = By.className("m-empty__messageTitle");


}
