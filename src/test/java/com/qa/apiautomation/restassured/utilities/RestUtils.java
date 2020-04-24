package com.qa.apiautomation.restassured.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getName()
	{
		String generatedString=RandomStringUtils.randomNumeric(3);
		return("Test"+generatedString);
	}

}
