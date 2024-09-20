Feature: User is able to add products or brand stores and view the price, stock availability, coupons or discounts


  @smoke @LL51 @ShopsPage
  Scenario: LL51 -Verify user is able to click cart and view the prodocuts
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "Proceed" button
    # And user "Deny" the location of the app
    When user click on "OK GOT IT" button
    Then user is able to see search text field with "Search products or brands across shops"
    When user enter "Mixture" name on search text field
    Then related "Mixture" product is displayed on the page
    And user is able to add the prduct in cart page
    And user is able to select "Labbaik Stores" shop
    And user is able to add the prduct in cart page
    Then user is able to see the notification in cart icon
    Then user is able to see the product added in cart page
