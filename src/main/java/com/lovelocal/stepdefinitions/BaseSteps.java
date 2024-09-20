package com.lovelocal.stepdefinitions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Rule;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.lovelocal.utils.BaseRetryDecision;
import com.lovelocal.utils.PropFileHandler;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.ScenarioImpl;
import gherkin.formatter.model.Result;


public class BaseSteps extends StepDefinitionInit {
	public static Scenario scenario;
	@Before
	public void setUp(Scenario scenario) throws Exception {

		System.out.println("STARTING TEST..... ");
		String output = scenario.getId().split(";")[0];
		String featureName = output.substring(0, 1).toUpperCase() + output.substring(1);
		PropFileHandler.writeToFile("scenarioName", scenario.getName() + " - " + featureName);
		session = getTestSession();
		Thread.sleep(5000);
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		this.scenario = scenario;
		if (scenario.isFailed()) {
			logError(scenario);
			// Take a screenshot...
			System.out.println("Scenario name ******* " + scenario.getName());
//			System.out.println("The test case " + ID + " is " + scenario.getStatus());

			final byte[] screenshot = ((TakesScreenshot) session.driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); // ... and embed it in the report.

			InputStream in = new ByteArrayInputStream(screenshot);
			BufferedImage bImageFromConvert = ImageIO.read(in);

		}
		System.out.println("I am in the tear function...");
		try {
			session.driver.quit();
			System.out.println("Session is not terminated!!!");
		} finally {
			session = null;
		}
	}

	private void logError(Scenario scenario) {

		Field field = FieldUtils.getField(((ScenarioImpl) scenario).getClass(), "stepResults", true);
		field.setAccessible(true);
		try {
			ArrayList<Result> results = (ArrayList<Result>) field.get(scenario);

		} catch (Exception e) {

			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			System.out.println("*********************" + exceptionAsString);
			e.printStackTrace();

		}

	}
}