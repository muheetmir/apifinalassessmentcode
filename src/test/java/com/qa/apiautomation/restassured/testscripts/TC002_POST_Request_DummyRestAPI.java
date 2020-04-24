package com.qa.apiautomation.restassured.testscripts;

import static io.restassured.RestAssured.given;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.apiautomation.restassured.utilities.RestUtils;

import io.restassured.RestAssured;

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
	
	@Test(priority=1)
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
	
	@Test(priority=2)
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
