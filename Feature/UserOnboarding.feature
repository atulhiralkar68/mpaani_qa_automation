Feature: User is able to sign up and login on the app with phone number

  Background: 

  @smoke @LL01 @UserOnboadrding @physicalDeviceWithSim
  Scenario: LL01- Verify user is able to signup using phone number and otp
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    Then User should be redirected to the home page

  @smoke @LL02 @UserOnboadrding @physicalDeviceWithSim
  Scenario: LL02-Verify user is able to change language of the app
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "हिंदी" as the app's language
    Then User should be redirected to the home page

  @smoke @LL04 @UserOnboadrding @physicalDeviceWithSim
  Scenario: LL04- Verify the user is able to deny device location to locate your current location
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    # And user "Deny" the location of the app
    Then User should be redirected to the home page

  @smoke @LL03 @UserOnboadrding @physicalDeviceWithSim
  Scenario: LL03-Verify the user is able to access device location to locate your current location
    # Then click on Home location icon and select the default address
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    # And user "Deny" the location of the app
    Then User should be redirected to the home page
    #Then click on Home location icon and select the default address
    When user selects location "Thimphu, Bhutan"
    Then I verify "Thimphu, Bhutan" is displayed on the screen

  @smoke @LL06 @SignUpLogin @physicalDeviceWithSim
  Scenario: LL06-Verify user is able to see all buttons  (Ref, SC, CO, Offers & Coupons) present in home page
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    Then User should be redirected to the home page
    And under offer for you section "Referral", "Scratch Cards","Combo Offers", "Value Offers", "Coupons" appears

  @smoke @LL07 @UserOnboadrding
  Scenario: LL07-Verify user is able to see Shop your Monthly saman ,Best Rated shop, All local shop Near you, Exciting combo offer, Best deals for you, shops By category sections appears
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    And scroll the page user is able to see "Want to repeat?","Shop Your Monthly Samaan","Best Rated Shops","Shop By Category"

  @smoke @LL08 @UserOnboadrding
  Scenario: LL08-Verify user is redirect to help bottom sheet after clicking on help icon
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    # And user "Deny" the location of the app
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    And user click on help icon
    Then user is redirect to help bottom device

  @smoke @LL47 @SignUpLogin
  Scenario: LL47-Verify user is able to click Guest user and continue to language selection sheet
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page

  @regression @LL10 @UserOnboadrding @physicalDeviceWithSim
  Scenario: LL10-Verify user is able to see profile icon and cart icon on home page.
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    # And user "Deny" the location of the app
    Then User should be redirected to the home page
    And user is able to see profile icon and cart icon on home page

  @smoke @LL55 @CheckoutPage
  Scenario: LL55-Verify user is able to login with valid credentials when checkout page ask to login
    Given user on the love local splash screen page
    When user clicks on "Continue as guest" text
    Then user sees the language page and selects "English" as the app's language
    When user click on "OK GOT IT" button
    And user presses the downward key until "Shop Your Monthly Samaan" appears
    And user clicks on Add button
    When user clicks on "CHECKOUT" text
    When user click on "PLACE ORDER" button
    And user click on "CONTINUE" button
    And user enters valid credentials when checkout page ask to login
    And I verify user is logged in successfully with valid credentials when checkout page ask to login

  #And I verify user is logged in successfully with valid credentials when checkout page ask to login
  @smoke @LL57 @UserOnboadrding
  Scenario: LL57-Verify user is able to chat with LoveLocal in all the pages wherever support option available
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
    #Then user "Deny" the location of the app
    When user click on "OK GOT IT" button
    Then User should be redirected to the home page
    When user clicks on Help button for support
    When user clicks on "Chat Support" text
    Then I verify user is able to chat with LoveLocal
    When I click on the device back button
    And I click on cross icon for help support popup
    When user clicks on "Shops" page
    When user clicks on Help button for support
    When user clicks on "Chat Support" text
    Then I verify user is able to chat with LoveLocal
    When I click on the device back button
    And I click on cross icon for help support popup
    When user clicks on "Offers" page
    When user clicks on Help button for support
    When user clicks on "Chat Support" text
    Then I verify user is able to chat with LoveLocal
    When I click on the device back button
    And I click on cross icon for help support popup
    When user clicks on "Orders" page
    When user clicks on Help button for support
    When user clicks on "Chat Support" text

  @regression @LL64 @UserOnboadrding
  Scenario: LL64-Verify user is able to change the language once the sign in successfully completed
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    When user selects "English" as the app's language
    Then User should be redirected to the home page
    When User changes the language "हिंदी" as the app's language
    Then User should be redirected to the home page
    Then I verify "आपके लिए ऑफ़र्स" is displayed on the splash screen
