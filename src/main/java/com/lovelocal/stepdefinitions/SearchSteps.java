package com.lovelocal.stepdefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Then;

public class SearchSteps extends StepDefinitionInit{

	   @Then("^click on search for store button$")
	    public void click_on_search_for_store_button() throws Throwable {
	    	Assert.assertTrue(searchPage.clickInsearchStorButton());
	    }
	   @Then("^total amount of the product is dispalyed on search page$")
	    public void total_amount_of_the_product_is_dispalyed_on_search_page() throws Throwable {
		   Assert.assertTrue(searchPage.totalAmountAppearOnScreen());
	    }
	   @Then("^select one category and click on category image$")
	    public void select_one_category_and_click_on_category_image() throws Throwable {
		   Assert.assertTrue(searchPage.selectOneCategory());
	    }
	   @Then("^User changes the language \"([^\"]*)\" as the app's language$")
	    public void user_changes_the_language_something_as_the_apps_language(String lang) throws Throwable {
			signUPLoginPage.changeLanguage(lang);
	    }
	    @Then("^user is able to see product specification page$")
	    public void user_is_able_to_see_product_specification_page() throws Throwable {
	    	 Assert.assertTrue(searchPage.productSpecificationPage());
	    }

	    @Then("^user select one shop and scroll the shop page$")
	    public void user_select_one_shop_and_scroll_the_shop_page() throws Throwable {
	    	Assert.assertTrue(searchPage.selectOneShop());
	    }
	    @Then("^user enter \"([^\"]*)\" name on store search text field$")
	    public void user_enter_name_on_store_search_text_field(String arg1) throws Throwable {
	    	searchPage.searchTheStore(arg1);
	       
	    }
	
}
