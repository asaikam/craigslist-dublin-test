package org.craigslist.PageObjects;

import org.craigslist.Utility.BaseClass;
import org.craigslist.Utility.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Housingpage_TS02_PO extends BaseClass {

    Housingpage_TS01_PO ts01 = new Housingpage_TS01_PO(driver);
    TestData ta = new TestData();

    public List<String> sortingDropdown() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ts01.sortingDropdown.click();
        List<WebElement> dropdown = ts01.sortingDropdownList;
        List<String> wDropdownList = new ArrayList<String>();
        for (int i = 0; i < dropdown.size(); i++) {
            wDropdownList.add(dropdown.get(i).getText());
        }
        System.out.println("Test data expected drop down values: " + ta.tDropdownList);
        System.out.println("Webpage actual drop down values: " + wDropdownList);
        try{
            Assert.assertEquals(ta.tDropdownList, wDropdownList);
        }
        catch(AssertionError e)
        {
            System.out.println("Assertion error. ");
        }
        return wDropdownList;
    }
}
