package com.lovelocal.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lovelocal.automation.framework.TestSession;
import com.lovelocal.automation.framework.pagefactory.MobileWebViewPage;
import com.lovelocal.helper.CommonGestures;
import com.lovelocal.utils.InitData;

public class HomePage extends MobileWebViewPage {
	public static String platformName = InitData.platformName;

	public HomePage(TestSession session) throws Exception {
		super(session, "Applications/" + platformName + "/SignUPLogin");
	}
/**
 * This method is used to scroll the page to particular element
 * @param section
 * @return
 * @throws InterruptedException
 */
	public boolean scrollToTheSection(String section) throws InterruptedException {
		int i = 0;
		boolean value=false;
		while (i < 10) {
			try {
				session.driver.findElement(By.xpath("//*[@text='" + section + "']")).isDisplayed();
				value=true;
				break;
			} catch (Exception e) {
				CommonGestures.longScrolldownMobile();
				i++;
			}
		}
		return value;
	}

	/**
	 * This method is used to click on help icon
	 */
	public void cickOnHelpIcon() {
		new WebDriverWait(session.driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("ivHelp"))).click();
	}

	public boolean verifyFilterOptions() {
		new WebDriverWait(session.driver, 20).until(ExpectedConditions.visibilityOf(element("filterByText")));
		return (element("filterCategories").isDisplayed() && element("filterOffers").isDisplayed()
				&& element("filterShopDeliveryOptions").isDisplayed());
	}

	/**
	 * This method is used to add the product in cart
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnAddBtn() throws InterruptedException {
		int i = 0;
		while (i < 4) {
			try {
				element("searchPageAddButton").isDisplayed();
				element("searchPageAddButton").click();
				break;
			} catch (Exception e) {
				CommonGestures.longScrolldownMobile();
				i++;
			}
		}
	}

}
