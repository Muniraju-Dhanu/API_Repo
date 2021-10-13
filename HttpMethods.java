package org.com.httpmethods;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class HttpMethods {
	
	@Test
	public void getRequest() {
			baseURI = "https://qaautomationappz.testrail.io/";
			Response response = RestAssured.given().auth().preemptive().basic("shadabanwar.appz@gmail.com", "Test@123")
				.get("index.php?/api/v2/get_case/2");
			
			int statuscode = response.getStatusCode();
			
			Assert.assertEquals(statuscode, 200);
			
			System.out.println("The status code is: "+statuscode);
			System.out.println("The body: "+ response.getBody().asPrettyString());
			System.out.println("Status Line:"+ response.getStatusLine());
			System.out.println("Header is:" + response.getHeader("content-type"));
			System.out.println("Response time is:"+ response.getTime());
			System.out.println();
	}
	
	@Test
	public void postRequest() {
		
		Map<String, Object> mp = new HashMap<String, Object>();
		
		JSONObject jsonResponse = new JSONObject();
		
		jsonResponse.put("title", "Test case created to check login feature ");
		
		System.out.println(jsonResponse.toString());
		
		baseURI = "https://qaautomationappz.testrail.io/";
		
		given().auth().preemptive().basic("shadabanwar.appz@gmail.com", "Test@123")
		.header("Content-Type", "application/json")
		.accept(ContentType.JSON)
		.body(jsonResponse.toString())
		.when()
		.post("index.php?/api/v2/add_case/1")
		.then()
		.statusCode(200)
		.log().all();
		
		System.out.println(jsonResponse);
		System.out.println();
	}
	
	
	  @Test public void putRequest() {
		  
		  Map<String, Object> mp = new HashMap<String, Object>();
		  
		  JSONObject jsonResponse = new JSONObject();
		  
		  jsonResponse.put("title", "This is test a created by Dhanushree");
		  
		  System.out.println(jsonResponse.toString());
		  
		  baseURI = "https://qaautomationappz.testrail.io/";
		   
		   given().auth().preemptive().basic("shadabanwar.appz@gmail.com", "Test@123")
		  .header("Content-Type", "application/json")
		  .accept(ContentType.JSON)
		  .body(jsonResponse.toString()) 
		  .when()
		  .post("index.php?/api/v2/update_case/39")
		  .then()
		  .statusCode(200)
		  .log().all(); 
		   
		  System.out.println(jsonResponse); 
	  }
		  	  
	  @Test
	    public void deleteRequest() {

		  baseURI = "https://qaautomationappz.testrail.io/"; 
			
		  Response response = RestAssured.given().auth().preemptive().basic("shadabanwar.appz@gmail.com","Test@123")
	                .header("Content-type", "application/json")
	                .when()
	                .delete("index.php?/api/v2/delete_case/39");
        }
}