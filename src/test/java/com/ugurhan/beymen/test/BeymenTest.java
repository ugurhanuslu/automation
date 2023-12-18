package com.ugurhan.beymen.test;
import com.ugurhan.beymen.constant.BasketPageConstants;
import com.ugurhan.beymen.constant.HomePageConstants;
import com.ugurhan.beymen.element.HomePageElements;
import com.ugurhan.beymen.functions.BaseFunctions;
import com.ugurhan.beymen.manager.ExcelManager;
import com.ugurhan.beymen.manager.RandomProductGenerator;
import com.ugurhan.beymen.element.BasketPageElements;
import com.ugurhan.beymen.element.ProductPageElements;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.*;
import java.util.List;


public class BeymenTest extends BaseFunctions {


    @Test
    public void Beymen_Demo_Test_Case() throws IOException, InterruptedException {
        open_homepage();
        make_search();
        select_random_product();
        check_basket_price();
        increase_item_quantity();
        check_item_quantity();
        empty_basket_and_check();
    }

    public void open_homepage() {
        verifyTitle(HomePageConstants.HOMEPAGE_TITLE);
        click(HomePageElements.ACCEPT_COOKIES);
        click(HomePageElements.GENDER_CLOSE);
    }

    public void make_search() throws IOException, InterruptedException {
        writeText(HomePageElements.SEARCH_BOX, new ExcelManager().readExcelFile("B1"));
        wait(1);
        clear(HomePageElements.SEARCH_BOX_AFTER);
        writeText(HomePageElements.SEARCH_BOX_AFTER, new ExcelManager().readExcelFile("A1"));
        pressKeyboard(HomePageElements.SEARCH_BOX_AFTER, "ENTER");
    }

    public void retry() throws InterruptedException, IOException {
        click(BasketPageElements.DELETE_ITEM);
        wait(1);
        driver.navigate().back();
        wait(1);
        driver.navigate().back();
        make_search();
        select_random_product();
    }

    public void select_random_product() throws IOException, InterruptedException {
        click(RandomProductGenerator.randomProduct());
        writeToTxt(ProductPageElements.PRODUCT_DESCRIPTION, ProductPageElements.PRODUCT_PRICE);
        new ExcelManager().writeExcelFile(getText(ProductPageElements.PRODUCT_PRICE));
        List<WebElement> forms = driver.findElements(By.cssSelector("#sizes > div span"));
        int count = forms.size();

            if (count > 1) {
                click(ProductPageElements.PRODUCT_SIZE);
                click(ProductPageElements.ADD_BASKET);
            } else {
                click(ProductPageElements.ADD_BASKET);
            }

        click(ProductPageElements.BASKET_BUTTON);
    }

    public void increase_item_quantity() throws InterruptedException, IOException {
        click(BasketPageElements.ITEM_VALUE);
        if (elementExist(BasketPageElements.VALUE)) {
            setValue(BasketPageElements.ITEM_VALUE, "2");
            wait(2);
        } else {
            retry();
        }
    }

    public void check_basket_price() throws IOException {
        assertEquals(new ExcelManager().readExcelFile("C1").replaceAll(" TL", ""), getText(BasketPageElements.BASKET_PRICE).replaceAll(",00 TL", ""));
    }

    public void check_item_quantity() {
        assertEquals(getText(BasketPageElements.FINAL_ITEM_VALUE), BasketPageConstants.ITEM_QUANTITY);
    }

    public void empty_basket_and_check() throws InterruptedException {
        click(BasketPageElements.DELETE_ITEM);
        wait(3);
        assertEquals(getText(BasketPageElements.EMPTY_MESSAGE), BasketPageConstants.EMPTY_MESSAGE);
    }

}
