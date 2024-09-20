package com.lovelocal.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lovelocal.automation.framework.TestSession;
import com.lovelocal.automation.framework.pagefactory.MobileWebViewPage;
import com.lovelocal.helper.CommonGestures;
import com.lovelocal.utils.InitData;

public class SearchPage extends MobileWebViewPage {
	public static String platformName = InitData.platformName;

	public SearchPage(TestSession session) throws Exception {
		super(session, "Applications/" + platformName + "/SignUPLogin");
		System.out.println("Executed platform name  " + platformName);
	}

	/**
	 * Used to click on search page button
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean clickInsearchStorButton() throws InterruptedException {
		boolean value = false;
		Thread.sleep(2000);
		new WebDriverWait(session.driver, 80).until(ExpectedConditions.elementToBeClickable(element("searchForStore")))
				.click();
		return true;
	}

	/**
	 * Used to verify the total amount of the product
	 * 
	 * @return
	 */
	public boolean totalAmountAppearOnScreen() {
		new WebDriverWait(session.driver, 80).until(ExpectedConditions.elementToBeClickable(element("totalcost")))
				.isDisplayed();
		System.out.println(System.getProperty("ProductName") + "---" + element("totalcost").getText());
		return element("totalcost").isDisplayed();
	}

	/**
	 * Used to select one shop
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean selectOneShop() throws InterruptedException {
		boolean value = false;
		Thread.sleep(1000);
		if (new WebDriverWait(session.driver, 30).until(ExpectedConditions.elementToBeClickable(element("shopName")))
				.isDisplayed()) {
			value = true;
			new WebDriverWait(session.driver, 20).until(ExpectedConditions.elementToBeClickable(element("shopName")))
					.click();
		}
		return new WebDriverWait(session.driver, 80)
				.until(ExpectedConditions.elementToBeClickable(element("storeName"))).isDisplayed();
	}

	/**
	 * This method is used to select one category In shop page
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public boolean selectOneCategory() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		boolean value = false;
		WebElement stores = new WebDriverWait(session.driver, 80)
				.until(ExpectedConditions.elementToBeClickable(element("storeName")));
		if (stores.isDisplayed()) {
			value = true;
			Thread.sleep(1000);
			Robot robot = new Robot();
			int i = 0;
			CommonGestures.scrollDownMobile();
			robot.keyRelease(KeyEvent.VK_DOWN);
			while (i < 12) {
				robot.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
				i++;
			}
			robot.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			
			new WebDriverWait(session.driver, 90)
			.until(ExpectedConditions.elementToBeClickable(element("category"))).click();
			new WebDriverWait(session.driver, 90)
			.until(ExpectedConditions.elementToBeClickable(element("category"))).click();
		}
		return value;
	}

	/**
	 * Used to verify the product specification page appear
	 * 
	 * @return
	 */
	public boolean productSpecificationPage() {
		WebElement product = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(element("productCategoryTitle")));
		String name = product.getText();
		new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(element("productCategoryImage"))).click();
		String productName = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(element("productSpecificationPage"))).getText();
		return name.toUpperCase().contains(productName.toUpperCase());
	}

	/**
	 * This method is used to search store name
	 */

	public void searchTheStore(String text) {
		WebElement search = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.id("etStoreSearch")));
		search.click();
		element("searchTextField").sendKeys(text);
	}

}
