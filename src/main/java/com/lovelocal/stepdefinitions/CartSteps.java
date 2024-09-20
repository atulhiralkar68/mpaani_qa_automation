package com.lovelocal.stepdefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Then;

public class CartSteps extends StepDefinitionInit {
	@Then("^user is able to see the product added in cart page$")
	public void user_is_able_to_see_the_product_added_in_cart_page() throws Throwable {
		Assert.assertTrue(cartpage.verifyItemsPresentInCartPage());
	}

	@Then("^user is able to change the quantity of the product$")
	public void user_is_able_to_change_the_quantity_of_the_product() throws Throwable {
		cartpage.changeTheQuantity();
	}

	@Then("^user is able to add the prduct in cart page$")
	public void user_is_able_to_add_the_prduct_in_cart_page() throws Throwable {
		cartpage.clickInaddBtn();
	}

	@Then("^user is able to select \"([^\"]*)\" shop$")
	public void user_is_able_to_select_shop(String text) throws Throwable {
		cartpage.selectOneshop(text);
	}

	@Then("^user is able to see the notification in cart icon$")
	public void user_is_able_to_see_the_notification_in_cart_icon() throws Throwable {
		Assert.assertTrue(cartpage.verifyNotificationInCartIcon());
	}

	@Then("^user is able to add more quantty of the product$")
	public void user_is_able_to_add_more_quantty_of_the_product() throws Throwable {
		Assert.assertTrue(cartpage.addQuntityofTheProduct());
	}

	@Then("^user is able remove the items in cart page$")
	public void user_is_able_remove_the_items_in_cart_page() throws Throwable {
		Assert.assertTrue(cartpage.checkTheQuantityAfterRemoveTheItem());
	}

	@Then("^user click on profile icon$")
	public void user_click_on_profile_icon() throws Throwable {
		Assert.assertTrue(cartpage.clickInProfileIcon());
	}

	@Then("^user click \"([^\"]*)\" button present on screen$")
	public void user_click_button_present_on_screen(String arg1) throws Throwable {
		Assert.assertTrue(cartpage.scrollAndClickOnButton(arg1));
	}

	@Then("^user is able to scroll right to left to view recommended offers and add products to their cart$")
	public void user_is_able_to_scroll_right_to_left_to_view_recommended_offers_and_add_products_to_their_cart()
			throws Throwable {
		Assert.assertTrue(cartpage.scrollAndAddRecommendedOffer());
	}

	@Then("^user is able to see \"([^\"]*)\" and serch the product$")
	public void user_is_able_to_see_something_and_serch_the_product(String strArg1) throws Throwable {
		cartpage.ableToSearchProduct();
	}

	@Then("^user is able to remove the product on cart page$")
	public void user_is_able_to_remove_the_product_on_cart_page() throws Throwable {
		cartpage.deleteTheProduct();
	}

	@Then("^user is able to click on Can't find an item$")
	public void user_is_able_to_click_on_cant_find_an_item() throws Throwable {
		cartpage.clickOnCantFindThemButton();
	}

	@Then("^user is able to see \"([^\"]*)\" items in cart page$")
	public void user_is_able_to_see_something_items_in_cart_page(String items) throws Throwable {
		Assert.assertTrue(cartpage.checkTheQuantityInCartIcon(items));
	}

}
