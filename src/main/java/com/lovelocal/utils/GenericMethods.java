//package com.lovelocal.utils;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Properties;
//
//import javax.mail.MessagingException;
//import javax.mail.Store;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.testing.framework.EmailUtils;
//
//public class GenericMethods {
//
//	/**
//	 * Checking whether string is json
//	 * 
//	 * @param string
//	 * @return
//	 */
//	public static boolean isStringJson(String string) {
//		Boolean flag;
//		if (string.substring(0, 1).equals("{") || string.substring(0, 1).equals("[")) {
//			flag = true;
//		} else {
//			flag = false;
//		}
//		return flag;
//	}
//
//	/**
//	 * Checking whether string is xml
//	 * 
//	 * @param string
//	 * @return
//	 */
//	public static boolean isStringXml(String string) {
//		Boolean flag;
//		if (string.substring(0, 1).equals("<")) {
//			flag = true;
//		} else {
//			flag = false;
//		}
//		return flag;
//	}
//
//	public static String GetOTPFromEmail() throws Exception {
//		String code = null;
//		EmailUtils emailUtils = new EmailUtils();
//		Properties prop = new Properties();
//		String projectPath = System.getProperty("user.dir");
//		String filePath = projectPath + "/src/main/resources/dataFile/email.properties";
//		prop.load(new FileInputStream(filePath));
//		Store connection = emailUtils.connectToGmail(prop);
//		emailUtils.getUnreadMessages(connection, "Inbox");
//
//		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
//				PropFileHandler.readProperty("emailFrom"), PropFileHandler.readProperty("emailSubject"));
//
//		int inboxMessageCount = emailtext.size();
//		Thread.sleep(10000);
//		System.out.println("|||||||||||||||||||||||  unread messsage count is  " + emailtext.size());
//
//		if (emailtext.size() == 0) {
//			throw new Exception("**************************   No Email Received ");
//		}
////		else if (emailtext.size() == 1) {
////			String regex = "[^\\d]+";
////			String[] emailContent = emailtext.get(0).split("This is your one-time passcode,");
////			String[] OTP = emailContent[1].split(regex);
////			System.out.println("OTP is ************* : " + OTP[1]);
////			code=OTP[1];
////			return code;
////		}
//
//		else {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(inboxMessageCount - 1).split("This is your one-time passcode,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		}
//	}
//
//	public static String GetOTPFromEmail_NewEmailID() throws Exception {
//		String code = null;
//		EmailUtils emailUtils = new EmailUtils();
//		Properties prop = new Properties();
//		String projectPath = System.getProperty("user.dir");
//		String filePath = projectPath + "/src/main/resources/dataFile/email_OTP_NewEmailID.properties";
//		prop.load(new FileInputStream(filePath));
//		Store connection = emailUtils.connectToGmail(prop);
//		emailUtils.getUnreadMessages(connection, "Inbox");
//
//		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
//				PropFileHandler.readProperty("emailFrom"), PropFileHandler.readProperty("emailSubject"));
//
//		int inboxMessageCount = emailtext.size();
//		Thread.sleep(5000);
//		System.out.println("|||||||||||||||||||||||  unread messsage count is  " + emailtext.size());
//
//		if (emailtext.size() == 0) {
//			throw new Exception("**************************   No Email Received ");
//		}
//		else if (emailtext.size() == 1) {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(0).split("This is your one-time passcode,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//		    code=OTP[1];
//			return code;
//		}
//
//		else {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(inboxMessageCount - 1).split("This is your one-time passcode,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		}
//	}
//
//	public static String GetOTPFromEmailForAccount2() throws Exception {
//		String code = null;
//		EmailUtils emailUtils = new EmailUtils();
//		Properties prop = new Properties();
//		String projectPath = System.getProperty("user.dir");
//		String filePath = projectPath + "/src/main/resources/dataFile/emailiOS.properties";
//		prop.load(new FileInputStream(filePath));
//		Thread.sleep(3500);
//		Store connection = emailUtils.connectToGmail(prop);
//		emailUtils.getUnreadMessages(connection, "Inbox");
//
//		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
//				PropFileHandler.readProperty("emailFrom"), PropFileHandler.readProperty("emailSubject"));
//
//		System.out.println("|||||||||||||||||||||||  unread messsage count is  " + emailtext.size());
//		int inboxMessageCount = emailtext.size();
//
//		if (emailtext.size() < 1)
//			throw new Exception("**************************   No Email Received ");
//
//		else if (emailtext.size() == 1) {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(0).split("This is your one-time passcode,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		} else {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(inboxMessageCount - 1).split("This is your one-time passcode,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		}
//	}
//
//	public static String GetOTPE2EAndroid() throws Exception {
//		String code = null;
//		EmailUtils emailUtils = new EmailUtils();
//		Properties prop = new Properties();
//		String projectPath = System.getProperty("user.dir");
//		String filePath = projectPath + "/src/main/resources/dataFile/EtoEAndroid.properties";
//		prop.load(new FileInputStream(filePath));
//		Thread.sleep(3500);
//		Store connection = emailUtils.connectToGmail(prop);
//		emailUtils.getUnreadMessages(connection, "Inbox");
//		Thread.sleep(5000);
//		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
//				PropFileHandler.readProperty("emailFrom"), "Avibra One-Time Authorization Code");
//
//		System.out.println("|||||||||||||||||||||||  unread messsage count is  " + emailtext.size());
//
//		System.out.println(PropFileHandler.readProperty("emailFrom") + "      !!!!!!!!!!!!!       "
//				+ PropFileHandler.readProperty("emailSubject"));
//		int inboxMessageCount = emailtext.size();
//		System.out.println("inbox message count     " + inboxMessageCount);
//
//		if (emailtext.size() < 1)
//			throw new Exception("**************************   No Email Received ");
//
//		else if (emailtext.size() == 1) {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(0).split("This is your one-time authorization code,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		}
//
//		else {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(inboxMessageCount - 1)
//					.split("This is your one-time authorization code,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		}
//	}
//	
//	public static String GetOTPDeleteAndroid() throws Exception {
//		String code = null;
//		EmailUtils emailUtils = new EmailUtils();
//		Properties prop = new Properties();
//		String projectPath = System.getProperty("user.dir");
//		String filePath = projectPath + "/src/main/resources/dataFile/deleteAccountAndroid.properties";
//		prop.load(new FileInputStream(filePath));
//		Thread.sleep(3500);
//		Store connection = emailUtils.connectToGmail(prop);
//		emailUtils.getUnreadMessages(connection, "Inbox");
//		Thread.sleep(5000);
//		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
//				PropFileHandler.readProperty("emailFrom"), "Avibra One-Time Authorization Code");
//
//		System.out.println("|||||||||||||||||||||||  unread messsage count is  " + emailtext.size());
//
//		System.out.println(PropFileHandler.readProperty("emailFrom") + "      !!!!!!!!!!!!!       "
//				+ PropFileHandler.readProperty("emailSubject"));
//		int inboxMessageCount = emailtext.size();
//		System.out.println("inbox message count     " + inboxMessageCount);
//
//		if (emailtext.size() < 1)
//			throw new Exception("**************************   No Email Received ");
//
//		else if (emailtext.size() == 1) {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(0).split("This is your one-time authorization code,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		}
//
//		else {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(inboxMessageCount - 1)
//					.split("This is your one-time authorization code,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		}
//	}
//
//	public static String GetOTPFromEmailForiOSEndToEnd() throws Exception {
//		String code = null;
//		EmailUtils emailUtils = new EmailUtils();
//		Properties prop = new Properties();
//		String projectPath = System.getProperty("user.dir");
//		String filePath = projectPath + "/src/main/resources/dataFile/EtoEiOS.properties";
//		prop.load(new FileInputStream(filePath));
//		Store connection = emailUtils.connectToGmail(prop);
//		emailUtils.getUnreadMessages(connection, "Inbox");
//		Thread.sleep(8000);
//		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
//				PropFileHandler.readProperty("emailFrom"), "Avibra One-Time Authorization Code");
//		Thread.sleep(5000);
//		System.out.println("|||||||||||||||||||||||  unread messsage count is  " + emailtext.size());
//
//		int inboxMessageCount = emailtext.size();
//		System.out.println("inbox message count     " + inboxMessageCount);
//
//		if (emailtext.size() < 1)
//			throw new Exception("**************************   No Email Received ");
//
//		else if (emailtext.size() == 1) {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(0).split("This is your one-time authorization code,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		}
//
//		else {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(inboxMessageCount - 1)
//					.split("This is your one-time authorization code,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		}
//	}
//
//	public static String GetOTPFromEmailForiOSEndToEndonLoginWithCode() throws Exception {
//		String code = null;
//		EmailUtils emailUtils = new EmailUtils();
//		Properties prop = new Properties();
//		String projectPath = System.getProperty("user.dir");
//		String filePath = projectPath + "/src/main/resources/dataFile/EtoEiOS.properties";
//		prop.load(new FileInputStream(filePath));
//		Store connection = emailUtils.connectToGmail(prop);
//		emailUtils.getUnreadMessages(connection, "Inbox");
//		Thread.sleep(5000);
//		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
//				PropFileHandler.readProperty("emailFrom"), PropFileHandler.readProperty("emailSubject"));
//
//		System.out.println("|||||||||||||||||||||||  unread messsage count is  " + emailtext.size());
//
//		int inboxMessageCount = emailtext.size();
//		System.out.println("inbox message count     " + inboxMessageCount);
//
//		if (emailtext.size() < 1)
//			throw new Exception("**************************   No Email Received ");
//
//		else if (emailtext.size() == 1) {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(0).split("This is your one-time passcode,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		}
//
//		else {
//			String regex = "[^\\d]+";
//			String[] emailContent = emailtext.get(inboxMessageCount - 1).split("This is your one-time passcode,");
//			String[] OTP = emailContent[1].split(regex);
//			System.out.println("OTP is ************* : " + OTP[1]);
//			code = OTP[1];
//			return code;
//		}
//	}
//
//	public static String GetPasswordFromEmail() throws Exception {
//		String code = null;
//		EmailUtils emailUtils = new EmailUtils();
//		Properties prop = new Properties();
//		String projectPath = System.getProperty("user.dir");
//		String filePath = projectPath + "/src/main/resources/dataFile/email.properties";
//		prop.load(new FileInputStream(filePath));
//		Store connection = emailUtils.connectToGmail(prop);
//		emailUtils.getUnreadMessages(connection, "Inbox");
//
//		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
//				PropFileHandler.readProperty("emailFrom"),
//				PropFileHandler.readPropertyAndroid("emailSubjectforPassword"));
//
//		int inboxMessageCount = emailtext.size();
//		Thread.sleep(10000);
//		System.out.println("|||||||||||||||||||||||  unread messsage count is  " + emailtext.size());
//
//		if (emailtext.size() == 0) {
//			throw new Exception("**************************   No Email Received ");
//		}
//
//		else {
//			String regex = ". Please make sure";
//			// String[] emailContent = emailtext.get(inboxMessageCount-1).split("You're
//			// receiving this email because you requested a password reset for your Avibra
//			// account. Your new password is ");
//			// String[] password = emailContent[0].split(regex);
//			String[] parts = emailtext.get(0).split("Your new password is");
//			String password = parts[1].split(". ")[0].trim();
//
//			System.out.println("password is ************* : " + password);
//			code = password;
//			return code;
//		}
//	}
//	
//	public static String GetPasswordFromEmailForiOS() throws Exception {
//		String code = null;
//		EmailUtils emailUtils = new EmailUtils();
//		Properties prop = new Properties();
//		String projectPath = System.getProperty("user.dir");
//		String filePath = projectPath + "/src/main/resources/dataFile/forgotPasswordiOS.properties";
//		prop.load(new FileInputStream(filePath));
//		Store connection = emailUtils.connectToGmail(prop);
//		emailUtils.getUnreadMessages(connection, "Inbox");
//
//		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
//				PropFileHandler.readProperty("emailFrom"),
//				PropFileHandler.readPropertyAndroid("emailSubjectforPassword"));
//
//		int inboxMessageCount = emailtext.size();
//		Thread.sleep(10000);
//		System.out.println("|||||||||||||||||||||||  unread messsage count is  " + emailtext.size());
//
//		if (emailtext.size() == 0) {
//			throw new Exception("**************************   No Email Received ");
//		}
//
//		else {
//			String regex = ". Please make sure";
//			// String[] emailContent = emailtext.get(inboxMessageCount-1).split("You're
//			// receiving this email because you requested a password reset for your Avibra
//			// account. Your new password is ");
//			// String[] password = emailContent[0].split(regex);
//			String[] parts = emailtext.get(0).split("Your new password is");
//			String password = parts[1].split(". ")[0].trim();
//
//			System.out.println("password is ************* : " + password);
//			code = password;
//			return code;
//		}
//	}
//	
//	/**
//	 * This method is to read the login email for iOS from excel sheet
//	 * @return 
//	 * @throws IOException 
//	 */
//	
//	public static String readExcelData(int platform) throws IOException
//	{
//		FileInputStream excel = new FileInputStream("src/main/resources/builds/testdataResource/testDataForLogin.xlsx");
//		Workbook workbook = new XSSFWorkbook(excel);
//		Sheet sheet = workbook.getSheetAt(platform); // platform = 0 means iOS // platform = 1 means android
//		Iterator<Row> row = sheet.iterator();
//		String login = null;
//		while(row.hasNext())
//		{
//			Row rowvalue = row.next();
//			Iterator<Cell> column = rowvalue.iterator();
//			while(column.hasNext())
//			{
//				Cell cellValue = column.next();
//				System.out.println("the email is " + cellValue);
//				login = cellValue.getStringCellValue();
//			}
//			
//		}
//		
//		return login;
//		
//	}
//	
//	/**
//	 * This method is to read the new password from the gmail for iOS
//	 * updatemailfeb@gmail.com
//	 */
//	
//	public static String GetNewPasswordUpdateEmailiOS() throws Exception {
//		String code = null;
//		EmailUtils emailUtils = new EmailUtils();
//		Properties prop = new Properties();
//		String projectPath = System.getProperty("user.dir");
//		String filePath = projectPath + "/src/main/resources/dataFile/updateNewEmailiOS.properties";
//		prop.load(new FileInputStream(filePath));
//		Store connection = emailUtils.connectToGmail(prop);
//		emailUtils.getUnreadMessages(connection, "Inbox");
//
//		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
//				PropFileHandler.readProperty("emailFrom"),
//				PropFileHandler.readPropertyAndroid("emailSubjectforPassword"));
//
//		int inboxMessageCount = emailtext.size();
//		Thread.sleep(10000);
//		System.out.println("|||||||||||||||||||||||  unread messsage count is  " + emailtext.size());
//
//		if (emailtext.size() == 0) {
//			throw new Exception("**************************   No Email Received ");
//		}
//
//		else {
//			String regex = ". Please make sure";
//			// String[] emailContent = emailtext.get(inboxMessageCount-1).split("You're
//			// receiving this email because you requested a password reset for your Avibra
//			// account. Your new password is ");
//			// String[] password = emailContent[0].split(regex);
//			String[] parts = emailtext.get(0).split("Your new password is");
//			String password = parts[1].split(". ")[0].trim();
//
//			System.out.println("password is ************* : " + password);
//			code = password;
//			return code;
//		}
//	}
//
//	/**
//	 * This method is to read the new password from the gmail for iOS
//	 * updatemailjan@gmail.com
//	 */
//	public static String GetOldPasswordUpdateEmailiOS() throws Exception {
//		String code = null;
//		EmailUtils emailUtils = new EmailUtils();
//		Properties prop = new Properties();
//		String projectPath = System.getProperty("user.dir");
//		String filePath = projectPath + "/src/main/resources/dataFile/updateToOldEmail.properties";
//		prop.load(new FileInputStream(filePath));
//		Store connection = emailUtils.connectToGmail(prop);
//		emailUtils.getUnreadMessages(connection, "Inbox");
//
//		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
//				PropFileHandler.readProperty("emailFrom"),
//				PropFileHandler.readPropertyAndroid("emailSubjectforPassword"));
//
//		int inboxMessageCount = emailtext.size();
//		Thread.sleep(10000);
//		System.out.println("|||||||||||||||||||||||  unread messsage count is  " + emailtext.size());
//
//		if (emailtext.size() == 0) {
//			throw new Exception("**************************   No Email Received ");
//		}
//
//		else {
//			String regex = ". Please make sure";
//			// String[] emailContent = emailtext.get(inboxMessageCount-1).split("You're
//			// receiving this email because you requested a password reset for your Avibra
//			// account. Your new password is ");
//			// String[] password = emailContent[0].split(regex);
//			String[] parts = emailtext.get(0).split("Your new password is");
//			String password = parts[1].split(". ")[0].trim();
//
//			System.out.println("password is ************* : " + password);
//			code = password;
//			return code;
//		}
//	}
//
//	
//}
