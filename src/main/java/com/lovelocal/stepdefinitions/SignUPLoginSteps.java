package com.lovelocal.stepdefinitions;

import org.codehaus.groovy.runtime.powerassert.AssertionRenderer;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUPLoginSteps extends StepDefinitionInit {

	@Given("^user on the love local splash screen page$")
	public void user_on_the_love_local_splash_screen_page() throws Throwable {
		String actual = "Let’s start shopping from local shops near you";
		Assert.assertEquals(actual, signUPLoginPage.splashscreenTitle());
	}

	@Then("^user sees the language page and selects \"([^\"]*)\" as the app's language$")
	public void user_sees_the_language_page_and_selects_something_as_the_apps_language(String lang) throws Throwable {
		signUPLoginPage.changeLanguageBtnIsClicked(lang);
	}

	@Then("^User should be redirected to the home page$")
	public void user_should_be_redirected_to_the_home_page() throws Throwable {
		signUPLoginPage.homeofLoveLocalScreenAppear();
	}

	@When("^user enters mobilenumber and otp$")
	public void user_enters_mobilenumber_and_otp() throws Throwable {
		signUPLoginPage.userEnterValidNumberAndOTP();
	}

	@When("^user click in GetStarted btn$")
	public void user_click_in_GetStarted_btn() throws Throwable {
		signUPLoginPage.getStartedButtonIsclicked();
	}

	@And("^under offer for you section \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" is appears$")
	public void under_offer_for_you_section_something_somethingsomething_something_something_is_appears(String strArg1,
			String strArg2, String strArg3, String strArg4, String strArg5) throws Throwable {
		signUPLoginPage.offersForYouSection(strArg1, strArg2, strArg3, strArg4, strArg5);
	}

	@Then("^scroll the page user is able to see \"([^\"]*)\" ,\"([^\"]*)\"$")
	public void scroll_the_page_user_is_able_to_see(String arg1, String arg2) throws Throwable {
		signUPLoginPage.scrollThepageAndCheckTheSection(arg1, arg2);
	}

	@Then("^scroll the page user is able to see \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void scroll_the_page_user_is_able_to_see_somethingsomethingsomethingsomething(String sec1, String sec2,
			String sec3, String sec4) throws Throwable {
		Assert.assertTrue(signUPLoginPage.scrollThepageAndCheckTheSection(sec1, sec2, sec3));
	}

	@And("^under offer for you section \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" appears$")
	public void under_offer_for_you_section_something_somethingsomething_something_something_appears(String sec1,
			String sec2, String sec3, String sec4, String sec5) throws Throwable {
		Assert.assertTrue(signUPLoginPage.offersForYouSection(sec1, sec2, sec3, sec4,sec5));
	}

	@Then("^user is able to see search text field with \"([^\"]*)\"$")
	public void user_is_able_to_see_search_text_field_with_something(String text) throws Throwable {
		signUPLoginPage.clickonSearchTexField(text);
	}

	@Then("^related \"([^\"]*)\" product is displayed on the page$")
	public void related_something_product_is_displayed_on_the_page(String product) throws Throwable {
		Assert.assertTrue(signUPLoginPage.productNameAppear(product));
	}
	@Then("^related \"([^\"]*)\" product is displayed$")
	public void related_something_product_is_displayed(String product) throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifyText(product));
	}

	@And("^user enter \"([^\"]*)\" name on search text field$")
	public void user_enter_something_name_on_search_text_field(String text) throws Throwable {
		signUPLoginPage.verifySearchTextField(text);
	}

	@Then("^user click in help icon$")
	public void user_click_in_help_icon() throws Throwable {
		signUPLoginPage.clickonHelpicon();
	}

	@When("^user click on \"([^\"]*)\" button$")
	public void user_click_on_something_button(String button) throws Throwable {
		signUPLoginPage.cickOnPerticularbutton(button);
	}

	@When("^user clicks on \"([^\"]*)\" text$")
	public void user_clicks_on_something_text(String Text) throws Throwable {
		signUPLoginPage.clickOnBtn(Text);
	}

	@When("^user clicks on \"([^\"]*)\" to change the location$")
	public void user_clicks_on_something_to_change_the_location(String Text) throws Throwable {
		signUPLoginPage.cickOnPerticularText(Text);
	}

	@Then("^I verify I am able to browse \"([^\"]*)\"$")
	public void i_verify_i_am_able_to_browse_something(String text) throws Throwable {
		signUPLoginPage.verifySearchTextField(text);
	}

	@When("^user click on \"([^\"]*)\" to add the product$")
	public void user_click_on_something_to_add_the_product(String Text) throws Throwable {
		signUPLoginPage.cickOnPerticularText(Text);
	}

	@When("^I click on the cart icon$")
	public void i_click_on_the_cart_icon() throws Throwable {
		signUPLoginPage.clickOnCartIcon();
	}

	@And("^user is able to see profile icon and cart icon on home page$")
	public void user_is_able_to_see_profile_icon_and_cart_icon_on_home_page() throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifyProfileIconAndCartIcon());
	}

	@Then("^I verify \"([^\"]*)\" is displayed on the splash screen$")
	public void i_verify_something_is_displayed_on_the_splash_screen(String text) throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifyText(text));
	}
	
	@Then("^I verify \"([^\"]*)\" is displayed on the screen$")
	public void i_verify_something_is_displayed_on_the_screen(String text) throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifyText(text));
	}

	@And("^user enters valid credentials when checkout page ask to login$")
	public void user_enters_valid_credentials_when_checkout_page_ask_to_login() throws Throwable {
		signUPLoginPage.userEnterValidNumberAndOTP();
	}

	@When("^user clicks on Help button for support$")
	public void user_clicks_on_help_button_for_support() throws Throwable {
		signUPLoginPage.clickOnHelpBtn();
	}

	@Then("^I verify user is able to chat with LoveLocal$")
	public void i_verify_user_is_able_to_chat_with_lovelocal() throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifyUserIsAbletoChat());
	}

	@When("^I click on the device back button$")
	public void i_click_on_the_device_back_button() throws Throwable {
		Thread.sleep(2000);
		session.driver.navigate().back();
	}

    @And("^user click on skip button$")
    public void user_click_on_skip_button() throws Throwable {
    	Assert.assertTrue(signUPLoginPage.ClickInSkipButton());
    }
	@And("^I click on cross icon for help support popup$")
	public void i_click_on_cross_icon_for_help_support_popup() throws Throwable {
		signUPLoginPage.clickonCrossIcon();
	}

	@When("^user clicks on \"([^\"]*)\" page$")
	public void user_clicks_on_something_page(String Text) throws Throwable {
		signUPLoginPage.cickOnPerticularText(Text);
	}

	@When("^user selects \"([^\"]*)\" as the app's language$")
	public void user_selects_something_as_the_apps_language(String lang) throws Throwable {
		signUPLoginPage.changeLanguageBtnIsClicked(lang);
	}

	@When("^user clicks on \"([^\"]*)\" coupon, then \"([^\"]*)\" popup appears$")
	public void user_clicks_on_something_coupon_then_something_popup_appears(String value, String value2)
			throws Throwable {
		Assert.assertTrue(signUPLoginPage.verfiyReferralCoupons(value, value2));
	}

	@Then("^user \"([^\"]*)\" the location of the app$")
	public void user_something_the_location_of_the_app(String location) throws Throwable {
		signUPLoginPage.denyLocationBtnIsClicked(location);
	}

	@When("^user enters mobile number and otp$")
	public void user_enters_mobile_number_and_otp() throws Throwable {
		signUPLoginPage.userEnterValidNumberAndOTP();
	}

	@When("^user clicks on Get Started btn$")
	public void user_clicks_in_Get_Started_btn() throws Throwable {
		signUPLoginPage.getStartedButtonIsclicked();
	}

	@Then("^user is redirect to help bottom device$")
	public void user_is_redirect_to_help_bottom_device() throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifyUserIsRedirectedHelp());
	}

	@Then("^user verify the filter text option is visible$")
	public void user_verify_the_filter_text_option_is_visible() throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifyFilterTextIsDisplayed());
	}

	@Then("^user verify entered value \"([^\"]*)\" in search field$")
	public void user_verify_entered_value_in_search_field(String text) throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifyEnteredValueInSearchField(text));
	}

	@When("^user clicks filter option$")
	public void user_clicks_filter_option() throws Throwable {
		signUPLoginPage.clickFilterOption();
	}

	@When("^user clicks shops icon in bottom menu$")
	public void user_clicks_shops_icon_in_bottom_menu() throws Throwable {
		signUPLoginPage.clickShopsMenuInNavigationBar();
	}

	@Then("^user verifies shops page is opened$")
	public void user_verifies_shops_page_is_opened() throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifyShopsPage());
	}

	@When("^user clicks sort and filter option$")
	public void user_clicks_sort_and_filter_option() throws Throwable {
		signUPLoginPage.clickSortAndFilterOption();
	}

	@Then("^user verifies sort and filter section$")
	public void user_verifies_sort_and_filter_section() throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifySortAndFilterSection());
	}

	@When("^user edits the quantity in search result page$")
	public void user_edits_the_quantity_in_search_result_page() throws Throwable {
		signUPLoginPage.editProductQuantity();
	}

	@Then("^user verifies the updated quantity$")
	public void user_verifies_the_updated_quantity() throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifyProductsUpdatedQuantity());
	}

	@When("^user clicks add$")
	public void user_clicks_add() throws Throwable {
		signUPLoginPage.clickAdd();
	}

	@When("^user selects store and add product to cart$")
	public void user_selects_store_and_add_product_to_cart() throws Throwable {
		signUPLoginPage.selectStoreAndClickAdd();
	}

	@Then("^user verifies the product in cart$")
	public void user_verifies_the_product_in_cart() throws Throwable {
		Assert.assertTrue(signUPLoginPage.verifyProductQuantityInCart());
	}

}
