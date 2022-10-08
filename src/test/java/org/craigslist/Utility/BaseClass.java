package org.craigslist.Utility;

import org.craigslist.DataManagement.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass
{
    public static WebDriver driver;
    public static String pURL;

    public static void Launch_Browser()
    {
        PropertyFileReader PR = new PropertyFileReader();
        String pBrowsername = PR.fn_ReadPropertyFile().getProperty("browser");
        pURL = PR.fn_ReadPropertyFile().getProperty("url");

        if(pBrowsername.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        else if (pBrowsername.equals("IE")) {
            System.setProperty("webdriver.ie.driver", "Path of IE driver");
            driver = new InternetExplorerDriver();
        }
        else {
            System.out.println("Invalid BrowserName, please check the name in config.property file");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
