package RestAssuredAPI.RestAPI;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_Request {
	
	@Test
	public void getweatherdetails(){
		
		//Base URL
		RestAssured.baseURI="https://reqres.in/api/";

		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"users?page=2");
		
		//print response in console window.
		String responsebody =response.getBody().asString();
		System.out.println("Response body is:-"+responsebody);
		
		//status code validation.
		int StatusCode=response.getStatusCode();
		System.out.println("Status code is:-"+StatusCode);
		Assert.assertEquals(StatusCode, 200);
		
		//status line validation.
		String statusline= response.getStatusLine();
		System.out.println("Status Line:-"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		

		//status code validation.
		//status line validation.
	}

}
