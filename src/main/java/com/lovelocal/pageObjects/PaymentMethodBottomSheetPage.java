package com.lovelocal.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lovelocal.automation.framework.TestSession;
import com.lovelocal.automation.framework.pagefactory.MobileWebViewPage;
import com.lovelocal.utils.InitData;

public class PaymentMethodBottomSheetPage extends MobileWebViewPage {
	public static String platformName = InitData.platformName;

	public PaymentMethodBottomSheetPage(TestSession session) throws Exception {
		super(session, "Applications/" + platformName + "/SignUPLogin");
		System.out.println("Executed platform name  " + platformName);
	}

	public void verifyScreen(String page) {
		new WebDriverWait(session.driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='" + page + "']")))
				.isDisplayed();
	}

	public void clickInButton(String btn) {

		new WebDriverWait(session.driver, 30)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='" + btn + "']"))).click();
		;
	}

	/**
	 * used to select the address
	 * 
	 * @param btn
	 * @throws Exception 
	 */
	public void selectLocation(String btn) throws Exception {
		new WebDriverWait(session.driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("ivMyLocation")))
				.click();
		
			HomePage home=new HomePage(session);
			home.scrollToTheSection(btn);
			new WebDriverWait(session.driver, 30)
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='" + btn + "']"))).click();
			try {
				new WebDriverWait(session.driver, 30)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Okay, Change Location']"))).click();
			}
			catch(Exception E) {
				System.out.println("no popup appears");
			}
		
			
		
	}

}
