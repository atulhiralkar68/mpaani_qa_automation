package com.lovelocal.pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lovelocal.automation.framework.TestSession;
import com.lovelocal.automation.framework.pagefactory.MobileWebViewPage;
import com.lovelocal.utils.InitData;

public class CheckoutPage extends MobileWebViewPage {
	public static String platformName = InitData.platformName;
	Cartpage cartpage = new Cartpage(session);

	public CheckoutPage(TestSession session) throws Exception {
		super(session, "Applications/" + platformName + "/SignUPLogin");
	}

	public boolean selectHomeDeliveryOption() {
		boolean value = false;
		if (new WebDriverWait(session.driver, 80)
				.until(ExpectedConditions.elementToBeClickable(By.id("btnSelectHomeDelivery"))).isDisplayed()) {
			element("homeDelivery").click();
			value = true;
		}
		return value;
	}

	/**
	 * Used to verify Total amount appears on checkout page
	 * 
	 * @return
	 */
	public boolean totalAmountAppearOnCheckoutPage() {
		boolean value = false;
		try {
			WebElement totalAmount = new WebDriverWait(session.driver, 30)
					.until(ExpectedConditions.elementToBeClickable(By.id("tvTotalAmount")));
			value = true;
		} catch (Exception e) {
			WebElement totalAmount2 = new WebDriverWait(session.driver, 30)
					.until(ExpectedConditions.elementToBeClickable(By.id("tvTotalPayable")));
			value = true;
		}
		return value;

	}

	/**
	 * Used to verify Total amount appears on cart page
	 * 
	 * @return
	 */
	public boolean totalAmountAppear() {
		new WebDriverWait(session.driver, 80).until(ExpectedConditions.elementToBeClickable(element("totalcost")))
				.isDisplayed();
		System.out.println(System.getProperty("ProductName") + "---" + element("totalcost").getText());
		return System.getProperty("ProductName").equals(element("totalcost").getText());
	}

	public boolean selectDeliveryoption(String option) {
		boolean value = false;
		WebElement PickUp = new WebDriverWait(session.driver, 80)
				.until(ExpectedConditions.elementToBeClickable(By.id("tvPickupTitle")));
		if (PickUp.isDisplayed()) {
			assertEquals(option, PickUp.getText());
			PickUp.click();
			value = true;
		}
		return value;
	}

	/**
	 * Used to click on place order button
	 * 
	 * @return
	 */
	public boolean clickInPlaceOrderBtn() {
		boolean value = false;
		if (element("placeOrder").isDisplayed()) {
			element("placeOrder").click();
			value = true;
		}
		return value;
	}

	/**
	 * Used to click on place order button
	 * 
	 * @return
	 */
	public boolean clickInstoreBtn() {
		boolean value = false;
		if (element("title").isDisplayed()) {
			element("title").click();
			value = true;
		}
		return value;
	}

	/**
	 * Used to click on place order button
	 * 
	 * @return
	 */
	public boolean clickInPlaceOrderBtnInCheckouPage() {
		boolean value = false;
		if (element("checkoutPage").isDisplayed()) {
			element("checkoutPage").click();
			value = true;
		}
		return value;
	}

	public boolean recommendedItemIsVisible() throws InterruptedException {
		Thread.sleep(3000);
		boolean value = false;
		try {
			element("recommendedItmName").isDisplayed();
			element("recommendedItmPrice").isDisplayed();
			value = true;
		} catch (Exception e) {
			System.out.println("No recommeded items present for this product");
			value = true;
		}
		return value;
	}

	public boolean verifyTheAllTheDetailsPresentInShopPage() throws InterruptedException {
		Thread.sleep(6000);
//	new WebDriverWait(session.driver, 80)
//	.until(ExpectedConditions.elementToBeClickable(By.id(apppackage + ":id/tvAvailableOffers"))).isDisplayed();
		return element("DeiveryIcon").isDisplayed() && element("shopDistance").isDisplayed();
	}

	/**
	 * this method is to verify profile icon and cart icon
	 * 
	 * @return
	 */
	public boolean verifyCheckoutScreen() {
		WebElement totalAmount = new WebDriverWait(session.driver, 80)
				.until(ExpectedConditions.elementToBeClickable(By.id("tvTotalAmount")));
		WebElement checkoutTitle = new WebDriverWait(session.driver, 80)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Checkout']")));
		return totalAmount.isDisplayed() && checkoutTitle.isDisplayed();
	}
	
	/**
	 * user enters name on checkout on page
	 */
	public void enterName() {
		try{
			new WebDriverWait(session.driver, 80)
		
		.until(ExpectedConditions.elementToBeClickable(By.id("edtName"))).sendKeys("user");
		}
		catch(Exception e) {
			System.out.println("name and email section is not displayed");
		}
	}
}
