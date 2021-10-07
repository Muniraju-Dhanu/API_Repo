package com.get;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class Get {

	@Test
	public void getEx() {
		
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		Response response = get("https://reqres.in/api/users?page=2"); // After making import stmt static the above line can be written like this
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	
	public void secondGetEx() {

		//verifying particular ID
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200); //we made import stmt as static (No need to create object for given())
	}
}
