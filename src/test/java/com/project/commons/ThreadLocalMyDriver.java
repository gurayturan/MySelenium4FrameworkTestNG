package com.project.commons;

import org.openqa.selenium.WebDriver;

public class ThreadLocalMyDriver {

    private static ThreadLocal<WebDriver> myDriver =new ThreadLocal<>();

    public static synchronized WebDriver getMyDriver() {
        return myDriver.get();
    }

    public static synchronized void setMyDriver(WebDriver driver) {
        myDriver.set(driver);
    }
}
