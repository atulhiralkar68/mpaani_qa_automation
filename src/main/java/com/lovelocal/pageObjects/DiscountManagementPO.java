package com.lovelocal.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lovelocal.automation.framework.TestSession;
import com.lovelocal.automation.framework.pagefactory.MobileWebViewPage;
import com.lovelocal.utils.InitData;

public class DiscountManagementPO extends MobileWebViewPage {
	public static String platformName = InitData.platformName;
	Cartpage cartpage=new Cartpage(session);
	public DiscountManagementPO(TestSession session) throws Exception {
		super(session, "Applications/" + platformName + "/SignUPLogin");
	}
	
	/**
		 * verfiy user is able to click and view the referral coupons
 */
	
		public boolean verfiyReferralCoupons(String value, String value2) {
			// element("relateditem").click();
			String xpath = "//*[@text='" + value + "']";
			WebElement coupons = new WebDriverWait(session.driver, 30)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		session.driver.findElement(By.xpath(xpath)).click();
			String xpath2 = "//*[contains(@text,'" + value2 + "')]";
			WebElement referralCoupons = new WebDriverWait(session.driver, 30)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath2)));
	
			return session.driver.findElement(By.xpath(xpath2)).isDisplayed();
	
		}
}
