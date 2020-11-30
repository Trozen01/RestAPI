package RestAssuredAPI.RestAPI;

import junit.framework.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

public class TC005_GET_ValidatingJSONResponse {
	
	@Test
	public void getdetails(){
		
		//Base URL
		RestAssured.baseURI="http://fakerestapi.azurewebsites.net/api";

		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
				
		//Response Object
		Response response = httpRequest.request(Method.GET,"/Activities?ID=1");
		
		//status code validation.
		int StatusCode=response.getStatusCode();
		System.out.println("Status code is:-"+StatusCode);
		Assert.assertEquals(StatusCode, 200);
		
		//status line.
		String statusline= response.getStatusLine();
		System.out.println("Status Line:-"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
						
		//print ResponseBody.
		String responsebody =response.getBody().asString();
		System.out.println("Response body is:-"+responsebody);
				
		Assert.assertEquals(responsebody.contains("Activity 1"), true);
	}
	
}


//Validation
//->status code 
//->status line 
//-->Validate Any content from Responsebody