package com.get;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PostMethod {

	@Test
	public void postMethod() {

		//Post is used to create a resource on Server, hence we need to give JSON Body

		JSONObject request = new JSONObject();

		request.put("name", "Dhanu");
		request.put("job", "QA");

		System.out.println(request);
		System.out.println(request.toString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().post("https://reqres.in/api/users").then().statusCode(201);
	}
}
