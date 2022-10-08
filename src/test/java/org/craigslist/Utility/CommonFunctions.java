package org.craigslist.Utility;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CommonFunctions extends BaseClass{

    public List<String> Sorting(List<WebElement> SortingPrice, String sorting ){
        List<String> SortingPriceList = new ArrayList<>();
        for(WebElement p: SortingPrice){
            SortingPriceList.add(p.getText().replace( "€", "").replace( ",", ""));
        }
        System.out.println("Price list" + sorting + SortingPriceList);
    return SortingPriceList;
    }

}
