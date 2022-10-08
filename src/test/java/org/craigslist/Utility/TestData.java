package org.craigslist.Utility;

import java.util.*;

public class TestData {

    public static final String tBeforeSorting = " before sorting ";

    public static final String tAfterSorting_priceAsc = " after sorting Asc: ";

    public static final String tAfterSorting_priceDsc = " after sorting Dsc: ";

    public static final String tSearchData = "dublin";

    //Test Case Fail testcase data
    public List<String> tDefaultDropdownValues(){
        List Values = new ArrayList();
        Values.add("newest");
        Values.add("£ → £££");
        Values.add("£££ → £");
        return Values;
    }

    public List<String> tSearchDropdownValues(){
        List Values = new ArrayList();
        Values.add("upcoming");
        Values.add("newest");
        Values.add("oldest");
        Values.add("relevant");
        Values.add("£ → £££");
        Values.add("£££ → £");
        return Values;
    }

    /*    public List<String> tDefaultDropdownValues(){
        List Values = new ArrayList();
        Values.add("upcoming");
        Values.add("newest");
        Values.add("oldest");
        Values.add("£ → £££");
        Values.add("£££ → £");
        return Values;
    }*/
}
