package com.qa.apiautomation.restassured.testscripts;

import static io.restassured.RestAssured.given;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.response.Response;



// Get request to get all ids with its respective salaries and showing it on console
public class TC_003_GET_Request_DummyRestAPI {
	
	
	@Test
	public void getEmployeeIdsWithSalaries(){
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
	 
	List<String> idList=response.jsonPath().getList("data.id");
	List<String> salaryList=response.jsonPath().getList("data.employee_salary");
	
	Map<String , String> map = new LinkedHashMap<String , String>();
	
	for(int i=0;i<idList.size();i++)
	{
		map.put(idList.get(i), salaryList.get(i));
	}
	
	System.out.println(map);
	
	}
	

}
