Feature: User is able to search products or brand stores and view the price, stock availability, coupons or discounts

  @smoke @LL05 @ProductDiscovery @physicalDeviceWithSim
  Scenario: LL05-Verify that after entering search text and clicking on search icon, the search should be performed
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    #And user "Deny" the location of the app
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page

  @smoke @LL17-1 @ProductDiscovery @physicalDeviceWithSim
  Scenario: LL17-Verify that user is able to change the quantity of product
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    And user is able to add the prduct in cart page
    And user is able to select "Ruhani Medical & General Store" shop
    And user is able to add the prduct in cart page
    Then user is able to see the notification in cart icon

  #And user is able to change the quantity of the product
  #And user is able to add the prduct in cart page
  @smoke @ProductDiscovery @LL11 @physicalDeviceWithSim
  Scenario: LL11-Verify user is able to clicks on a product, user should be redirected to product specification page.
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    And user is able to add the prduct in cart page
    And user select one shop and scroll the shop page
    Then select one category and click on category image
    Then user is able to see product specification page

  @smoke @LL21 @ProductDiscovery @LL18 @physicalDeviceWithSim
  Scenario: LL21-Verify user is able to see the notification is appear on cart icon on left top of the page/Verify user is able to select the shop after selecting one product on search page
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "" name on search text field
    And click on search for store button
    And user enter "medical" name on store search text field
    And user select one shop and scroll the shop page
    Then select one category and click on category image
    And user is able to add the prduct in cart page
    Then user is able to see the notification in cart icon

  @smoke @ProductDiscovery @LL20 @physicalDeviceWithSim
  Scenario: LL20-Verify that when user clicks on add button, the product should be added to cart.
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    # And user "DENY" the location of the app
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    And user is able to add the prduct in cart page
    And user is able to select "Ruhani Medical & General Store" shop
    And user is able to add the prduct in cart page
    Then user is able to see the notification in cart icon
    And user is able to add more quantty of the product
    Then user is able to see the product added in cart page

  @smoke @LL09 @WIP @ProductDiscovery
  Scenario: LL09Verify user is able to enter a valid store name and click on the search icon. It should show the result with the given Store name.
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "" name on search text field
    And click on search for store button
    And user enter "medical" name on store search text field
    And user select one shop and scroll the shop page

  #Then related "Labbaik Stores" product is displayed on the page
  #And user is able to add the prduct in cart page
  @smoke @LL12 @ProductDiscovery
  Scenario: LL12-Verify user is able to see price, discount, shop name, rating, day, distance after selecting shop to buy product
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    # # And user "DENY" the location of the app
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "" name on search text field
    #When user click on "Search for Store" button
    And click on search for store button
    Then user is able to see price, discount, shop name, rating, day, distance

  @smoke @LL16 @ProductDiscovery
  Scenario: LL16-Verify that images of product and it's price are displayed correctly on search page
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    # # And user "DENY" the location of the app
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    Then total amount of the product is dispalyed on search page

  @smoke @LL49 @ProductDiscovery
  Scenario: LL49-Verify user is able to browse products/Shops using guest user
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "Proceed" button
    # # And user "DENY" the location of the app
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    And user is able to add the prduct in cart page
    And user is able to select "Labbaik Stores" shop

  @smoke @LL22 @ProductDiscovery
  Scenario: LL22-Verify that user should be able to continue shopping after adding items to cart.
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "Proceed" button
    # # And user "DENY" the location of the app
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    And user is able to add the prduct in cart page
    And user is able to select "Labbaik Stores" shop
    And user is able to add the prduct in cart page
    Then user is able to see the notification in cart icon
    Then user is able to see the product added in cart page
    Then user is able to scroll right to left to view recommended offers and add products to their cart
    And user is able to remove the product on cart page
    And user is able to click on Can't find an item
    Then user is able to see "" and serch the product
    Then user is able to see "02" items in cart page

  @LL73 @ProductDiscovery @smoke
  Scenario: LL73-Verify user is able to search shops using shop type/ratings/distance/shop with offers/shop categories in Shops Page -> Sort & Filter section
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "Proceed" button
    # And user "DENY" the location of the app
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    When user clicks shops icon in bottom menu
    Then user verifies shops page is opened
    When user clicks on "Newly Opened" text
    When user clicks sort and filter option
    Then user verifies sort and filter section
    Then user click on "SORT BY" filter and select "Distance" option
    And select view result button
    When user clicks sort and filter option
    Then user click on "RATINGS" filter and select "4 star and up" option
    And select view result button
    Then user is able to see the filtered product

  @LL72 @ProductDiscovery @smoke
  Scenario: LL72Verify user is able to search product and change UOM (ex: KG/Grams/Liters) and then add product to cart
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "Proceed" button
    # And user "DENY" the location of the app
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Rice" name on search text field
    Then related "Rice" product is displayed on the page
    When user edits the quantity in search result page
    Then user verifies the updated quantity
    When user clicks add
    And user selects store and add product to cart
    Then user verifies the product in cart

  @LL13 @ProductDiscovery @smoke
  Scenario: LL13-Verify that Filtering options should be present on search results page
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "Proceed" button
    # And user "DENY" the location of the app
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    Then user verify the filter text option is visible

  @LL15 @ProductDiscovery @smoke
  Scenario: Verify user is able to enter numbers or symbols in search field.
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "Proceed" button
    # And user "DENY" the location of the app
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "S98#$%" name on search text field
    And user verify entered value "S98#$%" in search field

  @LL14 @ProductDiscovery @smoke
  Scenario: LL14-Verify that filter should be present for filtering the search results based on Categories, Price, Offers or shop delivery option.
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "Proceed" button
    # And user "DENY" the location of the app
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    When user clicks filter option
    When user clicks on "Cookies & Biscuits" text
    Then user scrolls the filter screen and "VIEW RESULTS" button appears
    #And user presses the downward key until "VIEW RESULTS" appears
    Then user verifies filter options present is based on categories,price,offers or shop delivery option
    And select view result button
    Then related "Cookies" product is displayed
