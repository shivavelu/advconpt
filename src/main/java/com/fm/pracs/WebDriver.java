package com.fm.pracs;

public class WebDriver implements DriverFactory {
    @Override
    public void getDriver() {
        System.out.println("Web driver");
    }
}
