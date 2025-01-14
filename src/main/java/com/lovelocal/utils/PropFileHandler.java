package com.lovelocal.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.junit.Assert;


public class PropFileHandler extends ConfigFileReader{
	static Properties properties = new Properties();

	static String filePath = "./src/main/resources/dataFile/QA.properties";
	static String android_filePath = "./src/main/resources/dataFile/QAandroid.properties";


	/**
	 * This method is used to read the value of the given property from the properties file.
	 * 
	 * @param property : the property whose value is to be fetched.
	 * @return the value of the given property.
	 */
	public static String readProperty(String property) 
	{
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value=properties.getProperty(property);	
		if(value == null){
			Assert.fail(property+" is not present in properties file.");
		}
		return value;
	}

	/**
	 * This method is used to read the value of the given property from the properties file.
	 * 
	 * @param property : the property whose value is to be fetched.
	 * @return the value of the given property.
	 */
	public static String readPropertyAndroid(String property) 
	{
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream(android_filePath);
			properties.load(inPropFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value=properties.getProperty(property);	
		if(value == null){
			Assert.fail(property+" is not present in properties file.");
		}
		return value;
	}

	
	/**
	 * This method is used to check whether the given parameter is present in properties file.
	 * 
	 * @param property
	 * @return
	 */
	public static boolean hasProperty(String property) 
	{
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value=properties.getProperty(property);	
		if(value == null){
			return false;
		}
		return true;
	}

	/**
	 * This method is used to write the value of the property in property file.
	 * @param property
	 * @param value
	 * @throws IOException
	 */
	public static void writeToFile(String property, String value)  {
		try {
			InputStream inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(filePath);
			properties.setProperty(property, value);
			properties.store(outPropFile, null);
			outPropFile.close();
			System.out.println("Successfully updated for property:" + property + " value:" + value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
