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

public class TC_003_GET_Request_DummyRestAPI {
	
	@Test
	public void testGet(){
	String url="http://dummy.restapiexample.com/api/v1/employees";
	
	Response response=null;
	
	 response = 
		given()
		.when()
	   .get(url)
	   .then()
	    .statusCode(200)
	    .statusLine("HTTP/1.1 200 OK")
	    .header("Content-Type", "application/json;charset=utf-8")
	    .log().all()
	    .extract().response();
	List<String> list=response.jsonPath().getList("data");
	 
	System.out.println(list);
	 
	
	}
	

}
