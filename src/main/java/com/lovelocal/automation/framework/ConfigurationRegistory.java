
package com.lovelocal.automation.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.yaml.snakeyaml.Yaml;

import com.lovelocal.utils.InitData;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ConfigurationRegistory {
	public static String sauceURL = System.getProperty("sauceUrl");
	public static String sauceAndroidBuild = System.getProperty("sauceAndroidBuild");
	public static String sauceiOSBuild = System.getProperty("sauceiOSBuild");
	public static String iOSdeviceName = System.getProperty("iOSdeviceName");
	public static String iosplatformVersion = System.getProperty("iosplatformVersion");
	public static String androidDeviceName = System.getProperty("androidDeviceName");
	public static String androidPlatformVersion = System.getProperty("androidPlatformVersion");

	Map<String, Object> registry;
	private static String OS = System.getProperty("os.name").toLowerCase();

	@SuppressWarnings("unchecked")
	public ConfigurationRegistory() {
		registry = (Map<String, Object>) new Yaml()
				.load(getClass().getClassLoader().getResourceAsStream("configurationRegistry.yaml"));
	}

	public WebDriver getDriver(Map<String, Object> config) throws MalformedURLException {
		Map<String, Object> options = new HashMap<String, Object>();
		return getDriver(config, options);
	}

	public WebDriver getDriver(Map<String, Object> config, Map<String, Object> options) throws MalformedURLException {
		String projectPath = System.getProperty("user.dir");
		String driverPath = null;
		String apkPath = null;
		String testConfiguration = null;

		System.out.println("The driver path is " + driverPath);

		if (options.containsKey("TEST_CONFIGURATION")) {
			testConfiguration = options.get("TEST_CONFIGURATION").toString();
		}

		TestSession.logger.info("Launching Test Configuration: " + testConfiguration + " ...");
		System.out.println("Launching Test on Configuration: " + testConfiguration + " ...");

		Map<String, String> configRegistry = (Map<String, String>) registry.get(testConfiguration);

		String appPath = apkPath;
		WebDriver driver = null;

		switch (InitData.platformName) {
		case "androidStaging":
			System.out.println("In the Android Staging");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			appPath = projectPath + "" + "/src/main/resources/builds/app-debug.apk";
			capabilities.setCapability("app", appPath);
			capabilities.setCapability("appPackage", "chotelal.mpaani.com.android.chotelal.debug");
			capabilities.setCapability("appWaitActivity", "com.mpaani.auth.host.view.AuthActivity");
			capabilities.setCapability("newCommandTimeout", 60000);
			capabilities.setCapability("udid", registry.get("deviceId"));
			capabilities.setCapability("deviceName", "Android");
			capabilities.setCapability("autoGrantPermissions", "true");
			capabilities.setCapability("unicodeKeyboard", true);
			// capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//			capabilities.setCapability("noReset", "false");
//			capabilities.setCapability("fullReset", "true");
			capabilities.setCapability("androidInstallTimeout", 180000);
//			capabilities.setCapability("adbExecTimeout", "60000");
			capabilities.setCapability("adbExecTimeout", "60000");
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

			break;

		case "androidProd":
			System.out.println("In the Android Production");
			DesiredCapabilities capabilities1 = new DesiredCapabilities();
			appPath = projectPath + "" + "/src/main/resources/builds/app-prodDebug.apk";
			capabilities1.setCapability("app", appPath);
			capabilities1.setCapability("appPackage", "chotelal.mpaani.com.android.chotelal");
			capabilities1.setCapability("appWaitActivity", "com.mpaani.auth.host.view.AuthActivity");
			capabilities1.setCapability("newCommandTimeout", 60000);
			capabilities1.setCapability("udid", registry.get("deviceId"));
			capabilities1.setCapability("deviceName", "Android");
			capabilities1.setCapability("autoGrantPermissions", "true");

			capabilities1.setCapability("unicodeKeyboard", true);
			// capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//				capabilities1.setCapability("noReset", "false");
//				capabilities1.setCapability("fullReset", "true");
			capabilities1.setCapability("androidInstallTimeout", 180000);
			capabilities1.setCapability("adbExecTimeout", "60000");
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities1);

			break;
		case "iPhone":
			System.out.println("In the iPhone configuration");
			DesiredCapabilities capabilitiess = new DesiredCapabilities();
			appPath = "/Users/appzlogic/Downloads/LovelocalPreprod_10.58.app";
			capabilitiess.setCapability("platformVersion", "15.0");
			capabilitiess.setCapability("deviceName", "iPhone 12");
			// appPath = projectPath + "" + "/src/main/resources/builds/Lovelocal10.27.ipa";
			// capabilitiess.setCapability("platformVersion", "15.3.1");
			// capabilitiess.setCapability("deviceName", "iPhone 7 Plus");
			capabilitiess.setCapability("automationName", "XCUITest");
			capabilitiess.setCapability("platformName", "iOS");
			capabilitiess.setCapability("waitForQuiescence", false);
			System.out.println("App current path is:" + appPath);
			capabilitiess.setCapability("app", appPath);
			capabilitiess.setCapability(MobileCapabilityType.NO_RESET, false);
			capabilitiess.setCapability(MobileCapabilityType.FULL_RESET, true);
			capabilitiess.setCapability("clearSystemFiles", true);
			capabilitiess.setCapability("showXcodeLog", true);
			capabilitiess.setCapability("unicodeKeyboard", true);
			capabilitiess.setCapability("waitForAppScript", "$.delay(5000);$.acceptAlert(); true;");
			@SuppressWarnings("rawtypes")
			IOSDriver iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiess);
			driver = iosDriver;
			break;
		}

		return driver;
	}

	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

	}

}
