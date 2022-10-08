package org.craigslist.PageObjects;

import org.craigslist.Utility.CommonFunctions;
import org.craigslist.Utility.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class Housingpage_PO {

    CommonFunctions cf = new CommonFunctions();
    TestData td = new TestData();

    @FindBy(xpath = "//a[contains(@href, '/search/hhh') and @class='hhh']")
    WebElement housingPage;

    @FindBy(xpath = "//h4[@class = 'ban nearby']/preceding::li/div/span[2]/span[@class = 'result-price']")
    List<WebElement> beforeSortingPriceList;

    @FindBy(xpath = "//div[@class = 'dropdown dropdown-sort dropdown-arrows']/child::ul[1]")
    WebElement sortingDropdown;

    @FindBy(xpath = "//div[@class = 'search-sort']/div/ul/li")
    List<WebElement> sortingDropdownValues;

    @FindBy(xpath = "//div[@class = 'search-sort']/div/ul/li/a[@data-selection ='priceasc']")
    WebElement priceAsc;

    @FindBy(xpath = "//div[@class = 'search-sort']/div/ul/li/a[@data-selection ='pricedsc']")
    WebElement priceDsc;

    @FindBy(xpath = "//input[@placeholder = 'search housing']")
    WebElement searchTextbox;

    @FindBy(xpath = "//button[@type = 'submit' and @class='searchbtn changed_input clickme']")
    WebElement searchButton;

    //Constructor that will be automatically called as soon as the object of the class is created
    public Housingpage_PO(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void housingPage() {
        housingPage.click();
    }

    public void searchHouse() {
        searchTextbox.sendKeys(td.tSearchData);
    }

    public void searchButton() {
        searchButton.click();
    }

    public List<String> sortingDropdownList() {
        sortingDropdown.click();
        List<WebElement> dropdown = sortingDropdownValues;
        List<String> wDropdownList = new ArrayList<String>();
        for (int i = 0; i < dropdown.size(); i++) {
            wDropdownList.add(dropdown.get(i).getText());
        }
        System.out.println("Webpage drop down values: " + wDropdownList);
        Assert.assertNotNull(wDropdownList);
        return wDropdownList;
    }

    public void priceSorting() {
        List<String> beforeSorting = cf.Sorting(beforeSortingPriceList, td.tBeforeSorting );
        beforeSorting.remove("0");
        Collections.sort(beforeSorting);
        System.out.println("Price list after manual sorting " + beforeSorting);

        priceAsc.click();
        List<String> afterSortingAsc = cf.Sorting(beforeSortingPriceList, td.tAfterSorting_priceAsc);
        Assert.assertEquals(beforeSorting,afterSortingAsc);

        Collections.reverse(beforeSorting);
        sortingDropdown.click();
        priceDsc.click();
        List<String> afterSortingDsc = cf.Sorting(beforeSortingPriceList, td.tAfterSorting_priceDsc);
        Assert.assertEquals(beforeSorting,afterSortingDsc);
    }

    public List<String> sortingDropdownDefaultValues() {
        List<String> wDropdownDefaultList = sortingDropdownList();
        System.out.println("Test data  expected default drop down values : " + td.tDefaultDropdownValues());
        System.out.println("Webpage actual default drop down values: " + wDropdownDefaultList);
        Assert.assertEquals(td.tDefaultDropdownValues(), wDropdownDefaultList);
        return wDropdownDefaultList;
    }

    public List<String> sortingDropdownSearchtValues() {
        List<String> wDropdownSearchList = sortingDropdownList();
        System.out.println("Test data expected Search drop down values: " + td.tSearchDropdownValues());
        System.out.println("Webpage actual Search drop down values: " + wDropdownSearchList);
        Assert.assertEquals(td.tSearchDropdownValues(), wDropdownSearchList);
        return wDropdownSearchList;
    }
}
