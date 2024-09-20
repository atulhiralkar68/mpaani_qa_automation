package com.lovelocal.pageObjects;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;	
import java.awt.event.InputEvent;	
import java.awt.event.KeyEvent;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lovelocal.automation.framework.TestSession;
import com.lovelocal.automation.framework.pagefactory.MobileWebViewPage;
import com.lovelocal.helper.CommonGestures;
import com.lovelocal.utils.InitData;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Cartpage extends MobileWebViewPage {
	public static String platformName = InitData.platformName;
	private String store;
	public String productPrice;

	public Cartpage(TestSession session) throws Exception {
		super(session, "Applications/" + platformName + "/SignUPLogin");
	}

	/**
	 * This method used to change the quantity of the product
	 * @throws AWTException 
	 * @throws InterruptedException 
	 */
	public void changeTheQuantity() throws AWTException, InterruptedException  {
		element("dropdownIcon").click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		 robot.keyPress(KeyEvent.VK_ENTER);	
		 Thread.sleep(2000);
	}

	/**
	 * This method is used to add the product in cart
	 */
	public void clickInaddBtn() {
		element("addButtn").click();
//		System.out.println( element("comboOffers").isDisplayed());
//System.out.println(element("rating").isDisplayed()+" rating an offer present"+element("shopDistance").isDisplayed());
//System.out.println(element("DeiveryIcon").isDisplayed());
	}

	public boolean verifyItemsPresentInCartPage() throws InterruptedException {
//		WebElement storeName = new WebDriverWait(session.driver, 80)
//				.until(ExpectedConditions.elementToBeClickable(By.id("tvShopName")));
//		storeName.getText().contains(store);
		WebElement productName = new WebDriverWait(session.driver, 80)
				.until(ExpectedConditions.elementToBeClickable(By.id("tvProductName")));
		System.out.println(productName.getText());
		Thread.sleep(2000);
		WebElement cart = new WebDriverWait(session.driver, 80)
				.until(ExpectedConditions.elementToBeClickable(By.id("tvCartCount")));
		cart.click();
		WebElement productName2 = new WebDriverWait(session.driver, 80)
				.until(ExpectedConditions.elementToBeClickable(By.id("tvProductName")));
		System.setProperty("ProductName", productPrice);
		System.out.println(
				productName.getText() + "------" + productName2.getText() + "****" + System.getProperty("ProductName"));
		return productName.getText().equals(productName2.getText());
	}

	public String priceOfProductInSearchPage() {
		return element("priceOfProduct").getText();
	}

	public void selectOneshop(String text) {
		WebElement shopName = new WebDriverWait(session.driver, 80)
				.until(ExpectedConditions.elementToBeClickable(By.id("tvShopName")));
		String shop = shopName.getText();
		store = shop;
		System.out.println("store selected" + store);
		productPrice = priceOfProductInSearchPage();
	}

	/**
	 * Used to verify after adding the p
	 * 
	 * @return
	 */
	public boolean verifyNotificationInCartIcon() {
		WebElement cart = new WebDriverWait(session.driver, 80)
				.until(ExpectedConditions.elementToBeClickable(By.id("tvCartCount")));
		return cart.isDisplayed();
	}

	/**
	 * Used to add more quantity of the product in cart page
	 * 
	 * @return
	 */
	public boolean addQuntityofTheProduct() {
		boolean value = false;
		if (element("addButton").isDisplayed()) {
			element("addButton").click();
			value = true;
		}
		return value;
	}

	/**
	 * verify the product price, discount, shop name, rating, day, distance on
	 * select a shop to buy page
	 */
	public void verifyProductDetails() {
		assertTrue(element("rating").isDisplayed());
		assertTrue(element("shopDistance").isDisplayed());
	}

	/**
	 * verify user is able to see the item in cart page
	 */
	public void recommedeItemsInCartPage() {
		assertTrue(element("rating").isDisplayed());
		assertTrue(element("shopDistance").isDisplayed());
	}

	public boolean checkTheQuantityAfterRemoveTheItem1() {
		String before = element("cartNotification").getText();
		if (element("minusButtn").isDisplayed())
			element("minusButtn").click();
		System.out.println(before + "____" + Integer.parseInt(element("cartNotification").getText()));
		return Integer.parseInt(element("cartNotification").getText()) == 1;
	}
	/**
	 * to validate user is able to remove items in cart page
	 * @return
	 */
		public boolean checkTheQuantityAfterRemoveTheItem() {
			if (element("minusButtn").isDisplayed())
				element("minusButtn").click();
			WebElement cart = new WebDriverWait(session.driver, 80)
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@text,'Your cart is so empty')]")));
			return cart.isDisplayed();
		}
	public boolean clickInProfileIcon() throws InterruptedException {
		boolean value = false;
		if (element("profile").isDisplayed()) {
			element("profile").click();
			value = true;
		}
		return value;
	}

	/**
	 * This method is used scroll and click on logout method
	 * 
	 * @param arg1
	 * @return
	 * @throws InterruptedException
	 */
	public boolean scrollAndClickOnButton(String arg1) throws InterruptedException {
		boolean value = false;
		CommonGestures.scrollDownMobile();
		WebElement page = session.driver.findElement(By.xpath("//*[@text='" + arg1 + "']"));
		System.out.println("\nScrolling the screen downwards and check the element" + page.getText());
		if (page.getText().contains(arg1)) {
			value = true;
			page.click();
		}
		return value;
	}

	/**
	 * This method is used to scroll right to left to view recommended offers and
	 * add products to their cart
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean scrollAndAddRecommendedOffer() throws InterruptedException {
		boolean value = false;
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		while (stopWatch.getTime() <= 9000) {
			CommonGestures.swipeFromRightToLeft();
			System.out.println("\nSwiping from Right to Left !!!");
			clickInaddBtn();
			value = true;
		}
		return value;
	}

	/**
	 * This method is used to click on delete icon
	 */
	public void deleteTheProduct() {
		new WebDriverWait(session.driver, 80).until(ExpectedConditions.elementToBeClickable(By.id("ivIconDelete")))
				.click();
	}

	public void ableToSearchProduct() {
		System.out.println(element("heading").getText());
		element("itemName").sendKeys("Atta");
		element("addQuantity").sendKeys("1 kg");
		clickInaddBtn();
	}

	public void clickOnCantFindThemButton() throws InterruptedException {
		CommonGestures.scrollDownMobile();
		element("cantfindItem").click();
	}

	public boolean checkTheQuantityInCartIcon(String items) {
		WebElement item = new WebDriverWait(session.driver, 90)
				.until(ExpectedConditions.elementToBeClickable(By.id("tvCartCount")));
		System.out.println(item.getText());
		return item.getText().equals(items);
	}

}
