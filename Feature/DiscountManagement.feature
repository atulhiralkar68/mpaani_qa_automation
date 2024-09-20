Feature: Apply (Auto/Manual) - Coupons / Scratch Cards / Offers in Checkout Page

   @smoke @LL58 @DiscountManagement
  Scenario: Verify user is able to click and view the referral coupons
    Given user on the love local splash screen page
    When user clicks on Get Started btn
    And user enters mobile number and otp
    Then user sees the language page and selects "English" as the app's language
     When user clicks on "Referral" coupon, then "how you can grab Referral Bonus" popup appears
    And I click on the device back button
    #When user clicks on "Scratch Cards" coupon, then "LoveLocal Rewards" page appears
    #And I click on the device back button
    When user clicks on "Combo Offers" coupon, then "Combo Offers" page appears
    And I click on the device back button
    When user clicks on "Value Offers" coupon, then "Value Offers" page appears
    And I click on the device back button
    When user clicks on "Coupons" coupon, then "LoveLocal Coupons" page appears