package com.qa.apiautomation.restassured.testscripts;

import static io.restassured.RestAssured.given;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.apiautomation.restassured.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC002_POST_Request_DummyRestAPI {
	
	public Map<String, String> map= new HashMap<String, String>();
	
	@BeforeClass
	public void postdata() {
		map.put("name", RestUtils.getName());
		map.put("salary", "7000");
		map.put("age", "45");
		
		
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/create";
	}
	
	@Test
	public void testpost() {
		given()
		   .contentType("application/json")
		   .body(map)
		.when()
		  .post()
		.then()
		   .statusCode(200)
		.log().all();
	}
	
	
	

}
