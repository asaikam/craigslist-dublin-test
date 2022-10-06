package org.craigslist.PageObjects;

import io.cucumber.java.AfterAll;
import org.craigslist.Utility.BaseClass;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LaunchBrowser_PO extends BaseClass {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public LaunchBrowser_PO(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void craigslistUrl()
    {
        System.out.println("Pritning the URL " + pURL );
        driver.get(pURL);
    }

    public void browerQuit()
    {
        driver.quit();
    }
}
