package com.lovelocal.stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.lovelocal.automation.framework.TestSession;
import com.lovelocal.pageObjects.Cartpage;
import com.lovelocal.pageObjects.CheckoutPage;
import com.lovelocal.pageObjects.DiscountManagementPO;
import com.lovelocal.pageObjects.HomePage;
import com.lovelocal.pageObjects.PaymentMethodBottomSheetPage;
import com.lovelocal.pageObjects.SearchPage;
import com.lovelocal.pageObjects.SignUpLoginPage;
import com.lovelocal.pageObjects.SortAndFilterPage;

public class StepDefinitionInit {

	Map<String, Object> options = new HashMap<String, Object>();
	protected static TestSession session;

	static SignUpLoginPage signUPLoginPage;
	static Cartpage cartpage;
	static PaymentMethodBottomSheetPage paymentMethodBottomSheetPage;
	static CheckoutPage checkoutPage;
	static DiscountManagementPO discountManagement;
	static SearchPage searchPage;
    static SortAndFilterPage sortAndFilterPage;
    static HomePage homepage;
	public TestSession getTestSession() throws Exception {

		if (session == null) {
			session = new TestSession(options);

			signUPLoginPage = new SignUpLoginPage(session);
			cartpage = new Cartpage(session);
			signUPLoginPage = new SignUpLoginPage(session);
			paymentMethodBottomSheetPage = new PaymentMethodBottomSheetPage(session);
			checkoutPage =new CheckoutPage(session);
			searchPage =new SearchPage(session);
			discountManagement = new DiscountManagementPO(session);
			sortAndFilterPage =new SortAndFilterPage(session);
			homepage =new HomePage(session);
		} else {

		}

//		for (Entry<String, Object> entry : session.config.entrySet()) {
////			System.out.println("*********" + entry.getKey() + " " + entry.getValue());
//		}

		return session;
	}

}
