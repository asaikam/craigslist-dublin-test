package org.craigslist.StepDefination;

import io.cucumber.java.en.Then;
import org.craigslist.PageObjects.Housingpage_TS02_PO;
import org.craigslist.PageObjects.LaunchBrowser_PO;
import org.craigslist.Utility.BaseClass;

public class HousingPage_TS02_StepDefinition extends BaseClass {

    Housingpage_TS02_PO hp = new Housingpage_TS02_PO();
    LaunchBrowser_PO lb = new LaunchBrowser_PO(driver);

    @Then("Sorting dropdown should have default values")
    public void sorting_dropdown_should_have_default_values() {
        hp.sortingDropdown();
        lb.browerQuit();
    }
}
