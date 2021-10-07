package com.get;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetMethod {
	
	@Test
	
	void getMethod() {
		
		//verifying particular ID or validating response
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[1]", equalTo(8)); //we made import stmt as static (No need to create object for given())
		
		//verifying particular Name or validating response
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.first_name", hasItems("Michael", "Lindsay")); //we made import stmt as static (No need to create object for given())
		
		
		/*
		 * //When header is provided given().header("Content-Type",
		 * "application/json").accept(ContentType).get(
		 * "https://reqres.in/api/users?page=2").then().statusCode(200).body(
		 * "data.id[1]", equalTo(8));
		 */
	
	}
}
