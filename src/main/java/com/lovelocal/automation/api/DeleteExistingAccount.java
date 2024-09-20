package com.lovelocal.automation.api;

import static io.restassured.RestAssured.given;

import com.lovelocal.utils.PropFileHandler;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteExistingAccount {
	public static String environment = System.getProperty("environment");

	public static void accountToBeDeleted(String emailIDToBeDeleted) throws Exception {

		if (environment == null) {
			environment = "preprod";
		}
		System.out.println("****************  environment " + environment);
		String emailID = PropFileHandler.readProperty(emailIDToBeDeleted);
		String requesBody_1 = "{\n" + "  \"email\": \"";
		String requesBody_2 = emailID;
		String requesBody_3 = "\" \n}";
		String requestBodyToGetProfileID = requesBody_1 + requesBody_2 + requesBody_3;

		// preprod baseURI to get the profile id
		RestAssured.baseURI = "https://ycpnvxa11i.execute-api.us-east-1.amazonaws.com";
		System.out.println("********* requestBodyToGetProfileID " + requestBodyToGetProfileID);

		Response response = given().header("Content-type", "application/json").and().body(requestBodyToGetProfileID)
				.when().post("/" + environment + "/profiles/byrawemail").then().extract().response();

		String profileId = response.asString().replace("\"", "").replace("[", "").replace("]", "").replace("{", "")
				.replace("}", "");

		if (!(profileId.length() == 0)) {
			System.out.println("***** Email ID found and pulled out the Profile ID  " + profileId + " *****");
			PropFileHandler.writeToFile("profileId_"+emailIDToBeDeleted, profileId);
			String requestBodyToHardDeleteAccount = "\"" + PropFileHandler.readProperty("profileId_"+emailIDToBeDeleted) + "\"";
			System.out.println("********* requestBodyToHardDeleteAccount " + requestBodyToHardDeleteAccount);

			// preprod baseURI to delete the account
			RestAssured.baseURI = "https://ycpnvxa11i.execute-api.us-east-1.amazonaws.com";

			given().header("Content-type", "application/json").and().body(requestBodyToHardDeleteAccount).when()
					.post("/" + environment + "/profiles/delete/hard").then().extract().response();

			System.out.println("***** Account has been deleted *****");

		} else {
			System.out.println("***** No Account found with the given Email ID  " + emailID + "  *******");
		}

	}
 
	
}
