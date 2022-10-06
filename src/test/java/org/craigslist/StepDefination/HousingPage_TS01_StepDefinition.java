package org.craigslist.StepDefination;

import io.cucumber.java.en.*;
import org.craigslist.PageObjects.Housingpage_TS01_PO;
import org.craigslist.PageObjects.LaunchBrowser_PO;
import org.craigslist.Utility.BaseClass;
import org.craigslist.Utility.TestData;
import org.junit.Assert;

import java.util.List;

public class HousingPage_TS01_StepDefinition extends BaseClass {

    //Creating object of LaunchBrowser_PO
    LaunchBrowser_PO lb;
    Housingpage_TS01_PO hp;
    TestData td = new TestData();

    @Given("User in craigslist Dublin webpage")
    public void user_in_craigslist_dublin_webpage() {
        BaseClass.Launch_Browser();
        lb = new LaunchBrowser_PO(driver);
        lb.craigslistUrl();
        Assert.assertEquals(driver.getTitle(), td.tPAGE_TITLE );
    }

    @When("user navigates to housing page")
    public void user_navigates_to_housing_page() {
        hp = new Housingpage_TS01_PO(driver);
        hp.housingPage();
    }

    @Then("Sorting dropdown should have values")
    public void sorting_dropdown_should_have_values() {
        List<String> wDropdownList =  hp.sortingDropdown();
        Assert.assertNotNull(wDropdownList);
    }

    @Then("priceAsc priceDsc should work as expected")
    public void priceAsc_priceDsc_should_work_as_expected() {
        hp.Sorting();
        lb.browerQuit();
    }

}
