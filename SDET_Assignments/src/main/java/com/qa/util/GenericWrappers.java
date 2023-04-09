package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class GenericWrappers {

    static WebDriver driver;

    public GenericWrappers(WebDriver driver) {
        GenericWrappers.driver =driver;
    }

    public static void ClickButton(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void SendKeys(String name) {
        driver.findElement(By.name(name)).sendKeys("standard_user");
    }

    public static void sendkeys(String name) {
        driver.findElement(By.name(name)).sendKeys("secret_sauce");
    }

    public static void FilterButton(String className) {
        driver.findElement(By.className(className)).click();
    }

}
