package com.qa.apiautomation.restassured.testscripts;

import org.testng.annotations.Test;



import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TC001_GET_Request_JsonPlaceHolder {
	
// counting the number of users in the response total
	@Test(priority=1)
	public void getCountOfAllUsers() {
		
		String url="https://jsonplaceholder.typicode.com/posts";
		Response response=null;
		
		 response = 
			given()
			.when()
		   .get(url)
		   .then()
		    .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		    .header("Content-Type", "application/json; charset=utf-8")
		    //.log().all()
		    .extract().response();
		 int size=response.jsonPath().getList("id").size();
		 System.out.println("count of all users = "+size); 
		
}

	
//  counting the number of users in the response based on condition	
	@Test(priority=2)
	public void getallUsersWithCondition()
	{
		String url="https://jsonplaceholder.typicode.com/posts";
		Response response=null;
		
		 response = 
			given()
			.queryParam("userId", "2")
			.when()
		   .get(url)
		   .then()
		    .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		    .header("Content-Type", "application/json; charset=utf-8")
		    .extract().response();
		 int size=response.jsonPath().getList("id").size();
		 System.out.println("Count of users wher Userid is 2 = "+size);
		 
	}

// fetching the user ids of users 
	@Test(priority=3)
	public void getUsersKeyId()
	{
		String url="https://jsonplaceholder.typicode.com/posts";
		Response response=null;
		
		 response = 
			given()
			.queryParam("userId", "2")
			.when()
		   .get(url)
		   .then()
		    .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		    .header("Content-Type", "application/json; charset=utf-8")
		  // .log().all()
		    .extract().response();
		 String userid=response.jsonPath().getString("id");
		 System.out.println("Userid's of users where userId is 2 = "+userid);
	}

}
