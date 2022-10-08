package org.craigslist.StepDefination;

import io.cucumber.java.en.*;
import org.craigslist.PageObjects.Housingpage_PO;
import org.craigslist.Utility.BaseClass;

public class HousingPage_StepDefinition extends BaseClass {

    Housingpage_PO hp;

    @Given("User in craigslist Dublin webpage")
    public void user_in_craigslist_dublin_webpage() {
        BaseClass.Launch_Browser();
        driver.get(pURL);
    }

    @When("user navigates to housing page")
    public void user_navigates_to_housing_page() {
        hp = new Housingpage_PO(driver);
        hp.housingPage();
    }

    @Then("Sorting dropdown should have values")
    public void sorting_dropdown_should_have_values() {
       hp.sortingDropdownList();
    }

    //TS01
    @Then("priceAsc priceDsc should work as expected")
    public void priceAsc_priceDsc_should_work_as_expected() {
        hp.priceSorting();
    }

    //TS02
    @Then("Sorting dropdown should have default values")
    public void sorting_dropdown_should_have_default_values() {
        hp = new Housingpage_PO(driver);
        hp.sortingDropdownDefaultValues();
    }

    //TS03
    @Then("Sorting dropdown should have additional values after search")
    public void sorting_dropdown_should_have_additional_values_after_search() {
        hp = new Housingpage_PO(driver);
        hp.searchHouse();
        hp.searchButton();
        hp.sortingDropdownSearchtValues();
        driver.quit();
    }

}
