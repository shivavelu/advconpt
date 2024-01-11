package com.fm.pracs;

import java.sql.Driver;

public class FC {

    public DriverFactory intantiateDriver(String s)
    {
        if(s.equalsIgnoreCase("appium"))
        {
            return new AppriumDriver();
        }
        else if(s.equalsIgnoreCase("WebDriver"))
        {
            return new WebDriver();
        }
        else
            return new WinAppDriver();
    }

    public static void main(String[] args)
    {
        FC obj1= new FC();
        DriverFactory driver= obj1.intantiateDriver("kjhh");
        driver.getDriver();

    }
}
