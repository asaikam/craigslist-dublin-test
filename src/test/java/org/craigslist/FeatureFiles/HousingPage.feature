@Regression
Feature: Craigslist housing page sorting functionality validation

  @TS01
  Scenario: housing page ascending and descending TS_01
    Given User in craigslist Dublin webpage
    When user navigates to housing page
    Then Sorting dropdown should have values
    And priceAsc priceDsc should work as expected

  @TS02
  Scenario: housing page default sorting dropdown values TS_02
    Then Sorting dropdown should have default values

  @TS03
  Scenario: housing page default sorting dropdown values after using search such TS_03
    Then Sorting dropdown should have additional values after search