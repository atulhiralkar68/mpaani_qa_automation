package com.lovelocal.stepdefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Then;

public class HomePageSteps extends StepDefinitionInit {

	@Then("^user presses the downward key until \"([^\"]*)\" appears$")
	public void user_presses_the_downward_key_until_something_appears(String section) throws Throwable {
		Assert.assertTrue(homepage.scrollToTheSection(section));
	}

	@Then("^user click on help icon$")
	public void user_click_on_help_icon() throws Throwable {
		homepage.cickOnHelpIcon();
	}

	@Then("^user verifies filter options present is based on categories,price,offers or shop delivery option$")
	public void user_verifies_filter_options_present_is_based_on_categories_price_offers_or_shop_delivery_option()
			throws Throwable {
		Assert.assertTrue(homepage.verifyFilterOptions());
	}
	 @Then("^user clicks on Add button$")
	    public void user_clicks_on_add_button() throws Throwable {
	        homepage.clickOnAddBtn();
	    }

}
