Feature: User is able to use various payment options to make payment for the order

  @smoke @LL24 @PaymentManagement
  Scenario: LL24-Verify user is able to see total amount of all items should be displayed correctly to user.
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    # And user "Deny" the location of the app
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    And user is able to add the prduct in cart page
    And user is able to select "Labbaik Stores" shop
    And user is able to add the prduct in cart page
    Then user is able to see the notification in cart icon
    Then user is able to see the product added in cart page
    And click on place order button
    Then total amount of the product is dispalyed on checkout page

  @smoke @LL25 @PaymentManagement
  Scenario: LL25-Verify that user is able to see a recommended item and its price on cart page
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    Then User should be redirected to the home page
    #When I scroll the screen upwards
    #When I scroll the screen upwards
    And user presses the downward key until "Exciting Combo Offers" appears
    And user clicks on Add button
    #And user is able to add the prduct in cart page
    When user clicks on "CHECKOUT" text
    Then user is able to see the recommended items on cart page
    #And user is able to add the prduct in cart page
    And click on place order button
    #When user click on "PLACE ORDER" button
    Then total amount of the product is dispalyed on checkout page

  @smoke @LL28 @PaymentManagement
  Scenario: LL28-Verify that when user clicks on remove from cart button the item should be removed from the cart.
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    And user is able to add the prduct in cart page
    And user is able to select "Labbaik Stores" shop
    And user is able to add the prduct in cart page
    Then user is able to see the notification in cart icon
    Then user is able to see the product added in cart page
    And user is able remove the items in cart page

  @smoke @LL30 @PaymentManagement
  Scenario: LL30-Verify that items in cart should be present if user logs out and logs in again.
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    # And user "Deny" the location of the app
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    And user is able to add the prduct in cart page
    And user is able to select "Labbaik Stores" shop
    And user is able to add the prduct in cart page
    Then user is able to see the notification in cart icon
    And user is able to add more quantty of the product
    When I click on the device back button
    And user click on profile icon
    And user click "Log Out" button present on screen
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    # And user "Deny" the location of the app
    Then User should be redirected to the home page
    Then user is able to see the notification in cart icon

  @smoke @LL35 @PaymentManagement
  Scenario: LL35-Verify that user is able to select the deliver to location and pickup location
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    # And user "Deny" the location of the app
    Then User should be redirected to the home page
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    And user is able to add the prduct in cart page
    And user is able to select "Labbaik Stores" shop
    And user is able to add the prduct in cart page
    Then user is able to see the product added in cart page
    And click on place order button
    And user select home delivery services
    And user selects "No-touch pickup from shop" delivery option
    And user enter the name in chekout page
    And user click on place order button

  @smoke @LL37 @PaymentManagement
  Scenario: LL37-Verify that after payment has been completed with cash on delivery, confirm that an "Order has been successfully placed" screen appears
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    # And user "Deny" the location of the app
    Then User should be redirected to the home page
    When user selects location "Thimphu, Bhutan" 
    Then user is able to see search text field with "Search products or brands across shops"
    And user enter "Maggi" name on search text field
    Then related "Maggi" product is displayed on the page
    And user is able to add the prduct in cart page
    And user is able to select "Labbaik Stores" shop
    And user is able to add the prduct in cart page
    Then user is able to see the product added in cart page
    And click on place order button
    And user select home delivery services
    And user selects "No-touch pickup from shop" delivery option
    And user enter the name in chekout page
    And user click on place order button
    And user is able to select "Pay at Store"
    And user click on place order button
    Then I verify "Order Placed" is displayed on the screen
    
    
    #And select the payment method "UPI - PhonePe"
    #And user is able to select "Pay Now"
    #And user is able to select "Go Back"
    #Then user is able to see "Order Placed" page
