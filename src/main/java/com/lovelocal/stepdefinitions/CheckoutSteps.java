package com.lovelocal.stepdefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Then;

public class CheckoutSteps extends StepDefinitionInit{
	   @Then("^user select home delivery services$")
	    public void user_select_home_delivery_services() throws Throwable {
	    	Assert.assertTrue(checkoutPage.selectHomeDeliveryOption());
	    }
	    @Then("^total amount of the product is dispalyed$")
	    public void total_amount_of_the_product_is_dispalyed() throws Throwable {
	    	Assert.assertTrue(checkoutPage.totalAmountAppear());
	    }
	    
	    @Then("^user selects \"([^\"]*)\" delivery option$")
	    public void user_selects_something_delivery_option(String option) throws Throwable {
	    	Assert.assertTrue(checkoutPage.selectDeliveryoption(option));
	    }

	    @Then("^user click on place order button$")
	    public void user_click_on_place_order_button() throws Throwable {
	    	Assert.assertTrue(checkoutPage.clickInPlaceOrderBtnInCheckouPage());
	    }
	    @Then("^total amount of the product is dispalyed on checkout page$")
	    public void total_amount_of_the_product_is_dispalyed_on_checkout_page() throws Throwable {
	    	Assert.assertTrue(checkoutPage.totalAmountAppearOnCheckoutPage());
	    }

	    @Then("^click on place order button$")
	    public void click_on_place_order_button() throws Throwable {
	    	Assert.assertTrue(checkoutPage.clickInPlaceOrderBtn());
	    }
	    @Then("^user is able to see the recommended items on cart page$")
	    public void user_is_able_to_see_the_recommended_items_on_cart_page() throws Throwable {
	    	Assert.assertTrue(checkoutPage.recommendedItemIsVisible());
	    }
	    @Then("^user is able to see price, discount, shop name, rating, day, distance$")
	    public void user_is_able_to_see_price_discount_shop_name_rating_day_distance() throws Throwable {
	    	Assert.assertTrue(checkoutPage.verifyTheAllTheDetailsPresentInShopPage());
	    }
	    
	    @Then("^I verify user is logged in successfully with valid credentials when checkout page ask to login$")
		public void i_verify_user_is_logged_in_successfully_with_valid_credentials_when_checkout_page_ask_to_login()
				throws Throwable {
			Assert.assertTrue(checkoutPage.verifyCheckoutScreen());
		}
	    @Then("^user enter the name in chekout page$")
	    public void user_enter_the_name_in_chekout_page() throws Throwable {
	    	checkoutPage.enterName();
	    }
}
