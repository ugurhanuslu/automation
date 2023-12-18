package com.ugurhan.beymen.element;

import com.ugurhan.beymen.manager.RandomProductGenerator;
import org.openqa.selenium.By;



public class HomePageElements {

    public static final By ACCEPT_COOKIES = By.id("onetrust-accept-btn-handler");
    public static final By GENDER_CLOSE = By.cssSelector("body > div.o-home > div:nth-child(6) > div.o-modal.genderPopup > div > div.o-modal__header > button");
    public static final By SEARCH_BOX = By.className("o-header__search--input");
    public static final By SEARCH_BOX_AFTER = By.id("o-searchSuggestion__input");
    public static final By RANDOM_PRODUCT = RandomProductGenerator.randomProduct();


}

