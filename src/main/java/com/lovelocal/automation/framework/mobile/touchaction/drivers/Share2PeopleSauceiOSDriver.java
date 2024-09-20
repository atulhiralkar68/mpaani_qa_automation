package com.lovelocal.automation.framework.mobile.touchaction.drivers;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.RemoteTouchScreen;
import io.appium.java_client.ios.IOSDriver;

public class Share2PeopleSauceiOSDriver extends IOSDriver<WebElement> implements HasTouchScreen{

	private RemoteTouchScreen touch;

	public TouchScreen getTouch() {
		// TODO Auto-generated method stub
		return touch;
	}

	public Share2PeopleSauceiOSDriver(URL remoteAddress, Capabilities caps) {
		super(remoteAddress, caps);
		touch = new RemoteTouchScreen(getExecuteMethod());
	}
	
}
