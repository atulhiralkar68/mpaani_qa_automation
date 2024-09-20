package com.lovelocal.helper;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lovelocal.stepdefinitions.StepDefinitionInit;

import cucumber.api.DataTable;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class CommonGestures extends StepDefinitionInit {

	/**
	 * Method is used to wait still page is loading. Wait for the second specified.
	 */
	public static void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(session.driver, 180);
			boolean result = wait.until(expectation);
			System.out.println(result + " *******************Page is loaded completely***************");
		} catch (Throwable error) {
			org.junit.Assert.fail("Timeout waiting for 90 secondes to Page Load Request to complete.");
		}
	}

	public static void scrollDown() {
		((JavascriptExecutor) session.driver).executeScript("window.scroll(0,250)", "");
	}

	public static void scrollUp() {
		((JavascriptExecutor) session.driver).executeScript("window.scroll(0,-250)", "");
	}

	public static void threadWait(int waitsec) {
		threadWait(waitsec, null);
	}

	public static void threadWait(int waitsec, String message) {
		if (System.getProperty("implicitWait") != null && Integer.parseInt(System.getProperty("implicitWait")) >= 0) {
			waitsec = Integer.parseInt(System.getProperty("implicitWait"));
		}
		if (message != null) {
			System.out.println("\nWAITING " + waitsec + " seconds - " + message);
		} else {
			System.out.println("\nWAITING " + waitsec + " seconds for page synchronization!!!");
		}
		System.out.println(new String(new char[waitsec]).replace("\0", "="));
		for (int i = 0; i < waitsec; i++) {
			try {
				Thread.sleep(1000);
				System.out.print("=");
			} catch (InterruptedException ex) {
			}
		}
		System.out.println("");
	}

	public static HashMap<String, String> convertDataTableToMap(DataTable datatable) {
		HashMap<String, String> datamap = new HashMap<String, String>();
		for (int i = 0; i < datatable.getGherkinRows().get(0).getCells().size(); i++) {
			datamap.put(datatable.getGherkinRows().get(0).getCells().get(i),
					datatable.getGherkinRows().get(1).getCells().get(i));
		}
		return datamap;
	}

	/**
	 *
	 * @param app      xpro
	 * @param usertype user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getRegisterDataFromYaml(String app, String usertype) {
		String registerYamlPath = "src/test/resources/testData/register-data.yml";

		YamlHandler yamlhandler = new YamlHandler(registerYamlPath);
		Map<String, String> registerMap = (Map<String, String>) yamlhandler.getYamlValues(app).get(usertype);

		return registerMap;
	}

	/**
	 * Method is used to return the unique username
	 * 
	 * @return
	 */
	public static String uniqueUserName() {
		int number = uniqueNumber();
		String n = String.valueOf(number);
		String username = "nimit" + n + "Jain";
		return username;
	}

	/**
	 * Method is used to return the unique Email Address
	 * 
	 * @return
	 */
	public static String uniqueEmailAddress() {
		int number = uniqueNumber();
		String n = String.valueOf(number);
		String email = "nimit" + n + "@malinator.com";
		return email;
	}

	public static String Playlist()

	{
		int number = uniqueNumber();
		String n = String.valueOf(number);
		String playlist = "RockMusic" + n;
		return playlist;
	}

	/**
	 * Method is used to generate a uniqueNumber upto 7 digit
	 * 
	 * @return
	 */
	public static int uniqueNumber() {
		Random rnd = new Random();
		int n = 1000000 + rnd.nextInt(9000000);
		return n;
	}

	public static int singleUnique() {

		Random rnd = new Random();

		int singlevalue = 1 + rnd.nextInt(9);

		return singlevalue;
	}

	@SuppressWarnings({ "unused", "rawtypes", "static-access" })
	public static void scrollDownMobile() throws InterruptedException {
		Thread.sleep(2000);
		MobileDriver androidriver = (MobileDriver) session.driver;
		Dimension dim = session.driver.manage().window().getSize();

		int height = dim.getHeight();

		int width = dim.getWidth();

		int x = width/2 ;
		//int x = x1+400;
		int top_y = (int) (height * 0.83);

		int bottom_y = (int) (height * 0.10);


		new TouchAction((MobileDriver) session.driver).press(ElementOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3500))).moveTo(ElementOption.point(x, bottom_y)).release().perform();	

		System.out.println("\nScrolling the screen upwards !!!");

		Thread.sleep(1000);

	}
	public static void longScrolldownMobile() throws InterruptedException {
		Thread.sleep(2000);
		MobileDriver androidriver = (MobileDriver) session.driver;
		Dimension dim = session.driver.manage().window().getSize();

		int height = dim.getHeight();

		int width = dim.getWidth();

		int x = width / 2;

		int top_y = (int) (height * 0.80);

		int bottom_y = (int) (height * 0.10);


		new TouchAction((MobileDriver) session.driver).press(ElementOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3500))).moveTo(ElementOption.point(x, bottom_y)).release().perform();	

		System.out.println("\nScrolling the screen upwards !!!");

		Thread.sleep(1000);

	}

	public static void checkCity() throws InterruptedException {

		for(int i =0; i< 10; i++) {

			List<WebElement> city =  session.driver.findElements(By.id("edt_city"));

			try {

				if(city.size() > 0) {

					city.get(0).click();

					break;

				}else {

					scrollDownMobile();
				}

			}catch(Exception e) {

				scrollDownMobile();
			}

		}

	}


	@SuppressWarnings({ "unused", "rawtypes", "static-access" })
	public static void scrollUpMobile() throws InterruptedException {
		MobileDriver androidriver = (MobileDriver) session.driver;

		Dimension dim = session.driver.manage().window().getSize();

		int height = dim.getHeight();

		int width = dim.getWidth();

		int x = width / 2;

		int top_y = (int) (height * 0.20);

		int bottom_y = (int) (height * 0.80);

		new TouchAction((MobileDriver) session.driver).press(ElementOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(ElementOption.point(x, bottom_y)).release().perform();

		System.out.println("\nScrolling the screen upwards !!!");

		Thread.sleep(1000);

	}


	public static void closeKeyPad()
	{
		AndroidDriver androidriver = (AndroidDriver) session.driver;

		androidriver.hideKeyboard();
	}

	public static String scrollUpToElement() throws InterruptedException

	{
		String text = "";

		for (int i = 0; i < 10; i++)

		{

			try

			{

				MobileElement element = (MobileElement) session.driver.findElement(By.id("ivSearch"));

				Thread.sleep(2000);

				element.click();

				break;

			} catch (Exception e)

			{

				scrollUpMobile();
			}

		}

		return text;

	}

	@SuppressWarnings({ "rawtypes", "unused", "static-access" })
	public static void longPressingOnScreen() throws InterruptedException {

		MobileDriver androidriver = (MobileDriver) session.driver;

		Dimension dim = session.driver.manage().window().getSize();

		int height = dim.getHeight();

		int width = dim.getWidth();

		int x = width / 2;

		int y = (int) (height * 0.50);

		System.out.println("Started long pressings");

		new TouchAction((MobileDriver) session.driver).longPress(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10))).release().perform();

		CommonGestures.scrollDownMobile();

		System.out.println("\nLong pressed !!!");

		Thread.sleep(2000);
	}


	@SuppressWarnings({ "rawtypes", "unused", "static-access" })
	public static void swipeFromRightToLeft() throws InterruptedException {

		MobileDriver androidriver = (MobileDriver) session.driver;
		Dimension dim = session.driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = height / 4;
		int x_right = (int) (width * 0.8);
		int x_left = (int) (width * 0.2);
		new TouchAction((MobileDriver) session.driver).press(ElementOption.point(x_right, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(ElementOption.point(x_left,y)).release().perform();
		System.out.println("\nSwiping from Right to Left !!!");

		Thread.sleep(2000);
	}


	@SuppressWarnings({ "rawtypes", "unused", "static-access" })
	public static void swipeFromLeftToRight() throws InterruptedException {

		MobileDriver androidriver = (MobileDriver) session.driver;

		Dimension dim = session.driver.manage().window().getSize();

		int height = dim.getHeight();

		int width = dim.getWidth();

		int y = height/2;
		System.out.println("********************value of y is"+" "+y);

		int x_right = (int) (width * 0.8);
		
		System.out.println("********************value of x_right is"+" "+x_right);

		int x_left = (int)(width * 0.20);
		System.out.println("********************value of x_left is"+" "+x_left);

		new TouchAction((MobileDriver) session.driver).press(ElementOption.point(x_left, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(ElementOption.point(x_right,y)).release().perform();

		System.out.println("\nSwiping from Left to Right !!!");

		Thread.sleep(2000);
	}


	public static void longpressScrollSimultaneously() throws InterruptedException {

		Thread.sleep(2000);
		MobileDriver androidriver = (MobileDriver) session.driver;
		Dimension dim = session.driver.manage().window().getSize();

		int height = dim.getHeight();

		int width = dim.getWidth();

		int x = width / 2;

		int top_y = (int) (height * 0.50);

		int bottom_y = (int) (height * 0.20);

		new TouchAction((MobileDriver) session.driver).longPress(ElementOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2500))).moveTo(ElementOption.point(x, bottom_y)).release().perform();	

		System.out.println("\nScrolling the screen downwards !!!");

		Thread.sleep(2000);

	}

	public static void longpressScrollDownSimultaneously() throws InterruptedException {

		Thread.sleep(1000);
		MobileDriver androidriver = (MobileDriver) session.driver;
		Dimension dim = session.driver.manage().window().getSize();

		int height = dim.getHeight();

		int width = dim.getWidth();

		int x = width / 2;

		int top_y = (int) (height * 0.50);

		int bottom_y = (int) (height * 0.80);

		new TouchAction((MobileDriver) session.driver).longPress(ElementOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(ElementOption.point(x, bottom_y)).release().perform();	

		System.out.println("\nScrolling the screen downwards !!!");

		Thread.sleep(2000);

	}

	public static void swipeleftCornerToRight() throws InterruptedException {

		MobileDriver androidriver = (MobileDriver) session.driver;

		Dimension dim = session.driver.manage().window().getSize();

		int height = dim.getHeight();

		int width = dim.getWidth();

		int y = height/2;

		int x_right = (int) (width * 0.8);

		int x_left = (int)(width * 0.025);

		new TouchAction((MobileDriver) session.driver).press(ElementOption.point(x_left, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(ElementOption.point(x_right,y)).release().perform();

		System.out.println("\nSwiping from Left to Right !!!");

		Thread.sleep(2000);

	}

	public static void longpressScrollUpwardSimultaneously() throws InterruptedException {

		Thread.sleep(1000);
		MobileDriver androidriver = (MobileDriver) session.driver;
		Dimension dim = session.driver.manage().window().getSize();

		int height = dim.getHeight();

		int width = dim.getWidth();

		int x = width / 2;

		int top_y = (int) (height * 0.50);

		int bottom_y = (int) (height * 0.20);

		new TouchAction((MobileDriver) session.driver).longPress(ElementOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(ElementOption.point(x, bottom_y)).release().perform();	

		System.out.println("\nScrolling the screen downwards !!!");

		Thread.sleep(1000);

	}

	public static void sendChar(WebElement element, String value)
	{
		element.clear();

		for (int i = 0; i < value.length(); i++){
			char c = value.charAt(i);

			StringBuilder sbd = new StringBuilder();
			sbd.append(c).toString();
			element.sendKeys(sbd);
		}       
	}

	public static void scrollTheScreenAgain() throws InterruptedException {
		Thread.sleep(2000);
		MobileDriver androidriver = (MobileDriver) session.driver;
		Dimension dim = session.driver.manage().window().getSize();

		int height = dim.getHeight();

		int width = dim.getWidth();

		int x = width / 2;

		int top_y = (int) (height * 0.80);

		int bottom_y = (int) (height * 0.50);

		new TouchAction((MobileDriver) session.driver).press(ElementOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3500))).moveTo(ElementOption.point(x, bottom_y)).release().perform();	

		System.out.println("\nScrolling the screen upwards again !!!");

		Thread.sleep(1000);

	}
	
	
	@SuppressWarnings({ "rawtypes", "unused", "static-access" })
	public static void swipeFromRightToLeftSpecificPoint() throws InterruptedException {

		MobileDriver androidriver = (MobileDriver) session.driver;

		Dimension dim = session.driver.manage().window().getSize();

		int height = dim.getHeight();

		int width = dim.getWidth();

		int y = height/4;

		int x_right = (int) (width * 0.8);

		int x_left = (int)(width * 0.2);

		new TouchAction((MobileDriver) session.driver).press(ElementOption.point(x_right, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(ElementOption.point(x_left,y)).release().perform();

		System.out.println("\nSwiping from Right to Left !!!");

		Thread.sleep(2000);
	}

}
