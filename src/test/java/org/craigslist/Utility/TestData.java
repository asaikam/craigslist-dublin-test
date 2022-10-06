package org.craigslist.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class TestData {

    public static final String tPAGE_TITLE = "craigslist: Dublin jobs, apartments, for sale, services, community, and events";

    public static final List<String> tDropdownList = Arrays.asList("£ → £££", "£££ → £", "newest");

    public static final String tBeforeSorting = " before sorting ";

    public static final String tAfterSorting_priceAsc = " after sorting Asc: ";

    public static final String tAfterSorting_priceDsc = " after sorting Dsc: ";


}
