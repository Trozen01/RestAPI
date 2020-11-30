package RestAssuredAPI.RestAPI;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_GET_Request {
	
	// This testcase show to you how to do header verification.
	
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
		
		//status code validation.
		int StatusCode=response.getStatusCode();
		System.out.println("Status code is:-"+StatusCode);
		Assert.assertEquals(StatusCode, 201);
		
		//status line validation.
		String statusline= response.getStatusLine();
		System.out.println("Status Line:-"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
				
		// validate header
		//validate contact type
		String contentype= response.header("content-type");
		System.out.println("Content type is:-"+contentype);
		Assert.assertEquals(contentype, "application/json; charset=utf-8");
				
		//validate Contenten_Coding
		String contentencoding= response.header("content-encoding");
		System.out.println("Content encoding is:-"+contentencoding);
		Assert.assertEquals(contentencoding, "gzip");
		
	}
	
	//Validations.
	//status code.
	//status line.
	//header (content-type,content-encoding,content-length etc...)
}
