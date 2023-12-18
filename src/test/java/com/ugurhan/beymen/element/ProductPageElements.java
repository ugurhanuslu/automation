package com.ugurhan.beymen.element;

import org.openqa.selenium.By;


public class ProductPageElements {

    public static final By PRODUCT_DESCRIPTION = By.className("o-productDetail__description");
    public static final By PRODUCT_PRICE = By.id("priceNew");
    public static final By PRODUCT_SIZE = By.xpath("//span[@class='m-variation__item'] | //span[@class='m-variation__item -criticalStock']");
    public static final By ADD_BASKET = By.id("addBasket");
    public static final By BASKET_BUTTON = By.xpath("//button[contains(text(),'Sepete Git')]");
}
