package com.ugurhan.beymen.manager;
import org.openqa.selenium.By;

import java.util.Random;

public class RandomProductGenerator {
    public static By randomProduct() {
        Random random = new Random();
        int child = 2 + random.nextInt(47);
        return (By) By.cssSelector("#productList > div:nth-child(" + child + ")");
    }

}
