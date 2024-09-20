package com.lovelocal.stepdefinitions;

import org.junit.Assert;

import cucumber.api.java.en.When;

public class DiscountManagementSteps extends StepDefinitionInit {
	
	 @When("^user clicks on \"([^\"]*)\" coupon, then \"([^\"]*)\" page appears$")
	    public void user_clicks_on_something_coupon_then_something_page_appears(String value, String value2) throws Throwable {
	    	Assert.assertTrue(discountManagement.verfiyReferralCoupons(value, value2));
	    }


}
