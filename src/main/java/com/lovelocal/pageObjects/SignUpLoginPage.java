package com.lovelocal.pageObjects;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lovelocal.automation.framework.TestSession;
import com.lovelocal.automation.framework.pagefactory.MobileWebViewPage;
import com.lovelocal.utils.InitData;
import com.lovelocal.utils.PropFileHandler;

import io.appium.java_client.MobileElement;

public class SignUpLoginPage extends MobileWebViewPage {
	public static String platformName = InitData.platformName;

	public SignUpLoginPage(TestSession session) throws Exception {
		super(session, "Applications/" + platformName + "/SignUPLogin");
		System.out.println("Executed platform name  " + platformName);
	}

	public static String phoneNumber = System.getProperty("phoneNumber");

	/**
	 * click on back button
	 */
	public void tapOnBackbutton() {

		WebDriverWait wait = new WebDriverWait(session.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element("backButton")));
		element("backButton").click();
	}

	/**
	 * click on back button
	 */
	public void tapOnBackbuttonOnResetPINscreen() {

		WebDriverWait wait = new WebDriverWait(session.driver, 50);
		wait.until(ExpectedConditions.visibilityOf(element("backButtonInResetPinScreen")));

		element("backButtonInResetPinScreen").click();
	}

	/**
	 * verify screen
	 * 
	 * @param text
	 * @return
	 */

	public boolean verifyScreen(String screen) {
		System.out.println("waitng for the message........");
		String x = "//*[@text='";
		String y = "']";
		String xpath = x + screen + y;
		System.out.println("========================");
		System.out.println("xpath is :");
		WebDriverWait wait = new WebDriverWait(session.driver, 200);
		WebElement locate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return locate.isDisplayed();
	}

	/**
	 * This method used to click on get started button on splash screen
	 */
	public void getStartedButtonIsclicked() {
		assertEquals(element("getStarted").getText(), "Get Started");
		element("getStarted").click();
	}

	/***
	 * This method is used to enter valid numberand otp number
	 * 
	 * @throws InterruptedException
	 */
	public void userEnterValidNumberAndOTP() throws InterruptedException {
		try {
			new WebDriverWait(session.driver, 30)
					.until(ExpectedConditions.elementToBeClickable(element("NoneOfTheAbove"))).click();
		} catch (Exception e) {
			System.out.println("Mobile number suggestion popup is not displayed");
		}
		element("mobileNmber").clear();
		if (platformName.equals("androidProd")) {
			System.out.println("otp is clicked automatically in prod");
			if (phoneNumber == null) 
				element("mobileNmber").sendKeys(PropFileHandler.readProperty("PhoneNumbForPhysicalDevice"));
			 else 
				element("mobileNmber").sendKeys(phoneNumber);
			element("sendOTP").click();
		} else if (platformName.equals("androidStaging")) {
			if (phoneNumber == null) 
				element("mobileNmber").sendKeys(PropFileHandler.readProperty("PhoneNumbStaging2"));
			 else 
				element("mobileNmber").sendKeys(phoneNumber);
			element("sendOTP").click();
			new WebDriverWait(session.driver, 60).until(ExpectedConditions.elementToBeClickable(By.id("edtOTP")))
					.sendKeys(PropFileHandler.readProperty("OTP"));
			element("sendOTP").click();
		}
	}

	/**
	 * This method used to select the language
	 * 
	 * @param lang
	 * @throws InterruptedException
	 */
	public void changeLanguageBtnIsClicked(String lang) throws InterruptedException {
		new WebDriverWait(session.driver, 40)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='" + lang + "']"))).click();
		new WebDriverWait(session.driver, 60).until(ExpectedConditions.elementToBeClickable(By.id("btnChangeLanguage")))
				.click();

	}

	/**
	 * This method is used to deny the location of app
	 */
	public void denyLocationBtnIsClicked(String location) {
		new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='" + location + "']"))).click();
	}

	/**
	 * This method is used verify home page appear on the screen
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean homeofLoveLocalScreenAppear() throws InterruptedException {
		Thread.sleep(1000);
		boolean value = false;
		try {
			new WebDriverWait(session.driver, 50)
					.until(ExpectedConditions.elementToBeClickable(element("seeOrderDetails"))).click();
			if (element("backClass").isDisplayed())
				element("backClass").click();
			value = true;
			new WebDriverWait(session.driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("vTitle")))
					.isDisplayed();
		} catch (Exception e) {
			new WebDriverWait(session.driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("vTitle")))
					.isDisplayed();
		}
		return value;
	}

	/**
	 * This method is used to verify title of the love local page
	 * 
	 * @return
	 */
	public Object splashscreenTitle() {
		new WebDriverWait(session.driver, 90);
		System.out.println(element("title").getText());
		return element("title").getText();
	}

	/**
	 * This method used to verify the offers present in love local app
	 * 
	 * @param args
	 */
	public boolean offersForYouSection(String... args) {
		boolean value = false;
		String[] expected = new String[] { "Referral", "ScratchCard", "ComboOffer", "ValueOffer", "Coupons" };
		for (int i = 0; i <= 5 - 1; i++) {

			WebElement offers = new WebDriverWait(session.driver, 20)
					.until(ExpectedConditions.elementToBeClickable(By.id("tv" + expected[i])));
			System.out.println(offers.getText() + "****");
			value = true;
//			assertEquals(offers.getText(), args[i]);
//			offers.click();
//			if(new WebDriverWait(session.driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id(apppackage+"tvTitle"))).isDisplayed())
//			session.driver.navigate().back();
//			if(element("backClass").isDisplayed())
//				element("backClass").click();
		}
		return value;
	}

	/**
	 * This method is used to scroll the page and check all the offer section is
	 * available
	 * 
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @param arg4
	 * @param arg5
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public boolean scrollThepageAndCheckTheSection(String... expected) throws AWTException, InterruptedException {
		boolean value = false;
		for (int i = 0; i <= 3; i++) {
			Robot robot = new Robot();
			int j = 0;
			String section = null;
			robot.keyRelease(KeyEvent.VK_DOWN);
			while (j < 10) {
				robot.keyPress(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
				j++;
				try {
					WebElement page = session.driver.findElement(By.id("tvTitle"));
					System.out.println("Scrolling the screen downwards and check the section " + page.getText());
					section = page.getText();
					if (page.getText().contains(expected[i])) {
						value = true;
						break;
					}
				} catch (Exception e) {
					System.out.println("No section appear in home page");
				}
				if (section.contains("All Local Shops Near You"))
					break;
			}
		}
		return value;
	}

	/**
	 * This method is used to click on help icon
	 */
	public boolean clickonHelpicon() {
		element("helpIcon").click();
		return new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("tvHelp"))).isDisplayed();
	}

	/**
	 * This method is used to click on search text field
	 * 
	 * @throws InterruptedException
	 */
	public void clickonSearchTexField(String text) {
		WebElement search = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.id("svHome")));
		System.out.println("search Text field" + search.getText());
		assertEquals(text, search.getText());
	}

	/**
	 * This method is used to enter the product name , shop name on search text
	 * field
	 * 
	 * @param text
	 * @throws InterruptedException
	 */
	public void verifySearchTextField(String text) throws InterruptedException {
		WebElement searchbar = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.id("svHome")));
		searchbar.click();
		WebElement search = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.id("edtSearch")));
//		 WebElement storeSearch = new WebDriverWait(session.driver, 20)
//					.until(ExpectedConditions.elementToBeClickable(By.id(apppackage+"etStoreSearch")));
		search.click();
		element("searchTextField").sendKeys(text);
	}

	/**
	 * This method is used to verify the searched product is appear
	 * 
	 * @param product
	 * @return
	 * @throws InterruptedException
	 */
	public boolean productNameAppear(String product) throws InterruptedException {
		Thread.sleep(3000);
		new WebDriverWait(session.driver, 20).until(ExpectedConditions.elementToBeClickable(element("relateditem")))
				.click();
		WebElement shopName1 = new WebDriverWait(session.driver, 30)
				.until(ExpectedConditions.elementToBeClickable(By.id("tvProductName")));
		System.out.println(shopName1.getText().toUpperCase() + "----------" + product.toUpperCase());
		return shopName1.getText().toUpperCase().contains(product.toUpperCase());
	}

	/**
	 * click on perticular text
	 * 
	 * @param Text
	 * @throws InterruptedException
	 */
	public void cickOnPerticularText(String Text) throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> element = elements("Texts");
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().equals(Text)) {
				WebDriverWait wait = new WebDriverWait(session.driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(element.get(i))).click();
				break;
			}
		}

	}

	public void cickOnPerticularbutton(String button) throws InterruptedException {
		Thread.sleep(4000);
		List<WebElement> element = elements("buttons");
		try {
			for (int i = 0; i < element.size(); i++) {
				if (element.get(i).getText().equals(button)) {
					new WebDriverWait(session.driver, 30).until(ExpectedConditions.elementToBeClickable(element.get(i)))
							.click();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(button + " is not present");
		}
	}

	/**
	 * This method is used to enter the name of product in search bar
	 * 
	 * @param text
	 * @return
	 * @throws InterruptedException
	 */

	public boolean enterDataInSearchBar(String text) throws InterruptedException {
		MobileElement element = (MobileElement) element("searchBar");
		MobileElement element2 = (MobileElement) element("searchTextField");
		element.click();
		Thread.sleep(2000);
		element2.click();
		element2.sendKeys(text);
		Thread.sleep(2000);
		return element2.getText().equals(text);
	}

	public void clickOnCartIcon() {
		element("cart").click();
	}

	/**
	 * This method is to verify profile icon and cart icon
	 * 
	 * @return
	 */
	public boolean verifyProfileIconAndCartIcon() {
		WebElement profileIcon = new WebDriverWait(session.driver, 30)
				.until(ExpectedConditions.elementToBeClickable(By.id("menuProfile")));
		WebElement cartIcon = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.id("ivImg")));
		return profileIcon.isDisplayed() && cartIcon.isDisplayed();
	}

	/**
	 * 
	 * @param text
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyText(String text) throws InterruptedException {
		Thread.sleep(2000);
		return session.driver.findElement(By.xpath("//*[contains(@text,'" + text + "')]")).isDisplayed();
	}

	/**
	 * This method used to click on get help btn
	 */
	public void clickOnHelpBtn() {
		// assertEquals(element("helpBtn").getText(), "Help");
		element("helpBtn").click();
	}

	/**
	 * this method is to verify profile icon and cart icon
	 * 
	 * @return
	 */
	public boolean verifyCheckoutScreen() {
		WebElement totalAmount = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.id("tvTotalAmountTitle")));
		WebElement productName = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.id("tvProductName")));
		return totalAmount.isDisplayed() && productName.isDisplayed();
	}

	public boolean verifyUserIsAbletoChat() throws InterruptedException {
		element("TextField").click();
		element("TextField").clear();
		element("TextField").sendKeys("test1");

		Thread.sleep(1000);
		WebElement sendIcon = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.id("freshchat_conv_detail_send_reply_button")));
//				 WebElement storeSearch = new WebDriverWait(session.driver, 20)
//							.until(ExpectedConditions.elementToBeClickable(By.id(apppackage+"etStoreSearch")));
		sendIcon.click();

		return element("sentText").isDisplayed();

	}

	/**
	 * enter valid first name
	 * 
	 * @param validfirstName
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyUserIsRedirectedHelp() throws InterruptedException {
		return element("helpBtn").isDisplayed();

	}

	/**
	 * This method is used to click on cross icon
	 * 
	 * @throws InterruptedException
	 */
	public void clickonCrossIcon() {
		WebElement crossIcon = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.id("ivCancel")));

		crossIcon.click();
	}

	/**
	 * This method used to select the language
	 * 
	 * @param lang
	 * @throws InterruptedException
	 */
	public void clickOnBtn(String lang) throws InterruptedException {
		new WebDriverWait(session.driver, 40)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='" + lang + "']"))).click();
//				assertEquals(element("changelanguage").getText(), "Proceed");

	}

	/**
	 * verfiy user is able to click and view the referral coupons
	 */
	public boolean verfiyReferralCoupons(String value, String value2) {
		// element("relateditem").click();
		String xpath = "//*[@text='" + value + "']";
		WebElement coupons = new WebDriverWait(session.driver, 50)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		session.driver.findElement(By.xpath(xpath)).click();
		String xpath2 = "//*[contains(@text,'" + value2 + "')]";
		WebElement referralCoupons = new WebDriverWait(session.driver, 150)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath2)));

		return session.driver.findElement(By.xpath(xpath2)).isDisplayed();

	}


	public boolean verifyFilterTextIsDisplayed() {
		return element("filterText").isDisplayed();
	}

	public boolean verifyEnteredValueInSearchField(String text) {
		System.out.println(element("searchTextField").getText());
		return text.equalsIgnoreCase(element("searchTextField").getText());
	}

	public void clickFilterOption() {
		element("filterText").click();
	}


	public void clickShopsMenuInNavigationBar() {
		element("shopsMenuIcon").click();
	}

	public boolean verifyShopsPage() {
		new WebDriverWait(session.driver, 20).until(ExpectedConditions.visibilityOf(element("shopsSortAndFilter")));
		return ((element("shopsSortAndFilter").isDisplayed() && element("newlyOpenedInShopsPage").isDisplayed()));
	}

	/**
	 * Dynamic method to click on button
	 * 
	 * @throws InterruptedException
	 */
	public void clickSortAndFilterOption() throws InterruptedException {
		Thread.sleep(1000);
		WebElement button = new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(element("shopsSortAndFilter")));
		System.out.println(button.getText() + " Button is clicked");
	}

	/**
	 * This method is used to verify all the fiter after clicking on sort and filter
	 * 
	 * @return
	 */
	public boolean verifySortAndFilterSection() {

		return (element("shopsSortAndFilterClear").isDisplayed()
				&& (element("shopsSortAndFilterViewResults").isDisplayed())
				&& (element("shopsSortAndFilterTitleText").isDisplayed())
				&& (element("shopsSortAndFilterSortByOption").isDisplayed())
				&& (element("shopsSortAndFilterShopTypeOption").isDisplayed())
				&& (element("shopsSortAndFilterRatingsOption").isDisplayed())
				&& (element("shopsSortAndFilterDistanceOption").isDisplayed())
				&& (element("shopsSortAndFilterShopsWithOffers").isDisplayed())
				&& (element("shopsSortAndFilterShopCategories").isDisplayed())
				&& (element("shopsSortAndFilterClose").isDisplayed()));
	}

	public void editProductQuantity() {
		new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(element("searchPageProductQuantity")));
		element("searchPageProductQuantity").click();
		new WebDriverWait(session.driver, 20)
				.until(ExpectedConditions.elementToBeClickable(element("searchPageProductQuantityUpdate")));
		element("searchPageProductQuantityUpdate").click();

	}

	public boolean verifyProductsUpdatedQuantity() {
		return (element("searchPageProductQuantityUpdate").isDisplayed());
	}

	public void clickAdd() {
		element("searchPageAddButton").click();

	}

	public void selectStoreAndClickAdd() {
		new WebDriverWait(session.driver, 20).until(ExpectedConditions.visibilityOf(element("selectAShopToBuyText")));
		clickAdd();
	}

	public boolean verifyProductQuantityInCart() {
		new WebDriverWait(session.driver, 20).until(ExpectedConditions.elementToBeClickable(element("cart")));
		clickOnCartIcon();
		new WebDriverWait(session.driver, 20).until(ExpectedConditions.visibilityOf(element("cartPageItemCount")));
		return element("cartProductNameAndQuantityText").isDisplayed();
	}

	/**
	 * Thos method is used to click on skip button
	 * 
	 * @return
	 */

	public boolean ClickInSkipButton() {
		boolean value = false;
		if (new WebDriverWait(session.driver, 20).until(ExpectedConditions.elementToBeClickable(element("skipButton")))
				.isDisplayed()) {
			value = true;
			new WebDriverWait(session.driver, 20).until(ExpectedConditions.elementToBeClickable(element("skipButton")))
					.click();
		}
		return value;
	}

	/**
	 * This method used to change the language
	 * 
	 * @param lang
	 * @throws InterruptedException
	 */

	public void changeLanguage(String lang) throws InterruptedException {
		new WebDriverWait(session.driver, 60).until(ExpectedConditions.elementToBeClickable(By.id("menuProfile")))
				.click();
		new WebDriverWait(session.driver, 60)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Change Language']"))).click();
		new WebDriverWait(session.driver, 40)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='" + lang + "']"))).click();
		new WebDriverWait(session.driver, 60).until(ExpectedConditions.elementToBeClickable(By.id("btnChangeLanguage")))
				.click();

	}

}
