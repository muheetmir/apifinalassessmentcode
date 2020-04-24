package com.qa.apiautomation.restassured.testscripts;

import static io.restassured.RestAssured.given;





import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC003_Delete_Request {
	
	/*public Map<String, String> map= new HashMap<String, String>();*/
	
	@Test
	public void verifydelete() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		Response response=null;
		
		 response = 
			given()
			.when()
		   .delete("/delete/3")
		   .then()
		    .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		    .header("Content-Type", "application/json;charset=utf-8")
		    .log().all()
		    .extract().response();
		 System.out.println("Response : "+response.asString());
		 System.out.println("Response code : "+response.getStatusCode());
		
		
	}
	
	

}
