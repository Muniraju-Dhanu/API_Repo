package com.get;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutandPatch {

	@Test
	public void put() {
		
		JSONObject request = new JSONObject();

		request.put("name", "Dhanu");
		request.put("job", "QA");

		System.out.println(request);
		System.out.println(request.toString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().put("https://reqres.in/api/users/2").then().statusCode(200);
	}

	@Test 
	public void patch() {

		JSONObject request = new JSONObject();

		request.put("name", "Dhanu");
		request.put("job", "QA");

		System.out.println(request);
		System.out.println(request.toString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200);
	
	}
}

