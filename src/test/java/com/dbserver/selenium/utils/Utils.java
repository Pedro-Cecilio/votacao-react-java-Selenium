package com.dbserver.selenium.utils;

import org.openqa.selenium.By;

public class Utils {
    public static By byDataTestId(String testId){
        return By.cssSelector("[data-testid=%s]".formatted(testId));
    }
}
