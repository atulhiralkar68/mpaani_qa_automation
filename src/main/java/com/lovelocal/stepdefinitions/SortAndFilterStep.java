package com.lovelocal.stepdefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SortAndFilterStep extends StepDefinitionInit{
	  @Then("^user click on \"([^\"]*)\" filter and select \"([^\"]*)\" option$")
	    public void user_click_on_something_filter_and_select_something_option(String filter, String option) throws Throwable {
		  Assert.assertTrue(sortAndFilterPage.selectFilter(filter,option));
	    }

	    @Then("^user is able to see the filtered product$")
	    public void user_is_able_to_see_the_filtered_product() throws Throwable {
	    	 Assert.assertTrue(sortAndFilterPage.filterProduct());
	    }

	    @Then("^select view result button$")
	    public void select_view_result_button() throws Throwable {
	    	 Assert.assertTrue(sortAndFilterPage.clickOnViewResultButton());
	    }
	    @When("^I scroll the screen upwards$")
	    public void i_scroll_the_screen_upwards() throws Throwable {
	    	sortAndFilterPage.scroll();
	    }
	    @Then("^user scrolls the filter screen and \"([^\"]*)\" button appears$")
	    public void user_scrolls_the_filter_screen_and_something_button_appears(String filterBtn) throws Throwable {
	    	Assert.assertTrue(sortAndFilterPage.scrollToTheSection(filterBtn));
	    }
}
