package com.lovelocal.stepdefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaymentMethodBottomSheetPageSteps extends StepDefinitionInit{
	  @Then("^user is able to see \"([^\"]*)\" page$")
	    public void user_is_able_to_see_something_page(String page) throws Throwable {
	      paymentMethodBottomSheetPage.verifyScreen(page);
	    }

	    @Then("^select the payment method \"([^\"]*)\"$")
	    public void select_the_payment_method_something(String btn) throws Throwable {
	    	paymentMethodBottomSheetPage.clickInButton(btn);
	    }

	    @Then("^user is able to select \"([^\"]*)\"$")
	    public void user_is_able_to_select_something(String btn) throws Throwable {
	    	paymentMethodBottomSheetPage.clickInButton(btn);
	    }
	    
	    @When("^user selects location \"([^\"]*)\"$")
	    public void user_selects_location_something(String btn) throws Throwable {
	    	paymentMethodBottomSheetPage.selectLocation(btn);
	    }


}
