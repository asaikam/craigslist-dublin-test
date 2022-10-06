package org.craigslist.PageObjects;

import org.craigslist.Utility.CommonFunctions;
import org.craigslist.Utility.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class Housingpage_TS01_PO {

    WebDriver driver;
    CommonFunctions cf = new CommonFunctions();
    TestData ta = new TestData();

    @FindBy(xpath = "//a[contains(@href, '/search/hhh') and @class='hhh']")
    WebElement housing;

    @FindBy(xpath = "//div[@class = 'dropdown dropdown-sort dropdown-arrows']/child::ul[1]")
    WebElement sortingDropdown;

    @FindBy(xpath = "//div[@class = 'search-sort']/div/ul/li")
    List<WebElement> sortingDropdownList;

    @FindBy(xpath = "//div[@class = 'search-sort']/div/ul/li/a[@data-selection ='priceasc']")
    WebElement priceAsc;

    @FindBy(xpath = "//div[@class = 'search-sort']/div/ul/li/a[@data-selection ='pricedsc']")
    WebElement priceDsc;

    @FindBy(xpath = "//h4[@class = 'ban nearby']/preceding::li/div/span[2]/span[@class = 'result-price']")
    List<WebElement> SortingPrice;

    //Constructor that will be automatically called as soon as the object of the class is created
    public Housingpage_TS01_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void housingPage() {
        housing.click();
    }

    public List<String> sortingDropdown() {
        sortingDropdown.click();
        List<WebElement> dropdown = sortingDropdownList;
        List<String> wDropdownList = new ArrayList<String>();
        for (int i = 0; i < dropdown.size(); i++) {
            wDropdownList.add(dropdown.get(i).getText());
        }
//        System.out.println("Test data expected drop down values: " + td.tDropdownList);
        System.out.println("Webpage drop down values: " + wDropdownList);
//        Assert.assertEquals(td.tDropdownList, wDropdownList);
        return wDropdownList;
    }

    public void Sorting() {
        List<String> beforeSorting = cf.Sorting(SortingPrice, ta.tBeforeSorting );
        beforeSorting.remove("0");
        System.out.println("Price list after manual sorting " + beforeSorting);

        priceAsc.click();
        List<String> afterSortingAsc = cf.Sorting(SortingPrice, ta.tAfterSorting_priceAsc);
        Assert.assertNotEquals(beforeSorting,afterSortingAsc);

        sortingDropdown.click();
        priceDsc.click();
        List<String> afterSortingDsc = cf.Sorting(SortingPrice, ta.tAfterSorting_priceDsc);
        Assert.assertEquals(beforeSorting,afterSortingDsc);
    }
}
