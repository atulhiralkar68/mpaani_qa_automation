package com.lovelocal.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lovelocal.automation.framework.TestSession;
import com.lovelocal.automation.framework.pagefactory.MobileWebViewPage;
import com.lovelocal.helper.CommonGestures;
import com.lovelocal.utils.InitData;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SortAndFilterPage extends MobileWebViewPage{
	public static String platformName = InitData.platformName;
	public SortAndFilterPage(TestSession session) throws Exception {
		super(session, "Applications/" + platformName + "/SignUPLogin");
		System.out.println("Executed platform name  " + platformName);
	}
	/**
	 * Used to filter the product
	 * @return
	 */
	public boolean filterProduct() {
		boolean value=false;
	try {	WebElement rating = new WebDriverWait(session.driver, 20)
		.until(ExpectedConditions.elementToBeClickable(element("rating")));
		Double shoprating=Double.valueOf(rating.getText()); 
		value=shoprating>4.0;
		}catch (Exception e) {
			WebElement noShop = new WebDriverWait(session.driver, 20)
					.until(ExpectedConditions.elementToBeClickable(By.id("emptyContentTitle")));
			System.out.println(noShop.getText()+" shop is not persent!!!");
			value=true;
		}
		return value;
	}
	/**
	 * Used to select one filter and select one filter option
	 * @param filter
	 * @param option
	 * @return
	 */
	public boolean selectFilter(String filter, String option) {
		boolean value=false;
		WebElement sortAndFilter = new WebDriverWait(session.driver, 20)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='" + filter + "']")));
		if(sortAndFilter.isDisplayed()) {
			sortAndFilter.click();
		new WebDriverWait(session.driver, 20)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='" + option + "']"))).click();
		value=true;
		}
		new WebDriverWait(session.driver, 20)
		.until(ExpectedConditions.elementToBeClickable(element("expand"))).click();
		return value;
	}
	/**
	 * Used to click on view and result button on sort and filter popup
	 * @return
	 */
	public boolean clickOnViewResultButton() {
		boolean value=false;
		WebElement sortAndFilter = new WebDriverWait(session.driver, 20)
		.until(ExpectedConditions.elementToBeClickable(element("viewResult")));
		if(sortAndFilter.isDisplayed()) {
			sortAndFilter.click();
				value=true;
		}
		return value;
	}
	/**
	 * This method is for Scrolling
	 *
	 */

	public void scroll() throws InterruptedException {
		CommonGestures.longScrolldownMobile();

	}
	/**
	 * This method is used to scroll the page to particular button
	 * @param section
	 * @return
	 * @throws InterruptedException
	 */
	public boolean scrollToTheSection(String section) throws InterruptedException {
		int i = 0;
		boolean value=false;
		while (i < 5) {
			try {
				session.driver.findElement(By.xpath("//*[@text='" + section + "']")).isDisplayed();
				value=true;
				break;
			} catch (Exception e) {
				element("expand").click();
				i++;
			}
		}
		return value;
	}
}
