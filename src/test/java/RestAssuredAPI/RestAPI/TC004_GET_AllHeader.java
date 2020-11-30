package RestAssuredAPI.RestAPI;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_GET_AllHeader {

	
	@Test
	public void getdetails(){
		
		//Base URL
		RestAssured.baseURI="https://reqres.in";

		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
				
		//Response Object
		Response response = httpRequest.request(Method.GET,"/api/users?page=2");
				
		//print ResponseBody.
		String responsebody =response.getBody().asString();
		System.out.println("Response body is:-"+responsebody);
				
		//print all header.
		//(every header has 2 part one is key and second is value) for this we use hashmap structure in java 
		//for all header we have 2 parts for we use following code. 
		Headers allheaders=response.headers();   // capture all headers from response.
		
		System.out.println("Header loop start");
		//loop for extract all header from allheaders.
		for(Header head:allheaders){
			
		System.out.println(head.getName()+"       "+head.getValue());
		}
		
	}
}
