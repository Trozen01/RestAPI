package RestAssuredAPI.RestAPI;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;

public class TC007_GET_Request_Autherization {
	
	public void AutherizationTest(){
		
		//Base URL
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/checkForAuthentication";

		
		//Basic autherization need to do before create Request and response object.
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		RestAssured.authentication=authscheme;
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
				
		//Response Object
		Response response = httpRequest.request(Method.GET,"/");
				
		//print response.
		String responsebody =response.getBody().asString();
		System.out.println("Response body is:-"+responsebody);
				
		//status code validation.
		int StatusCode=response.getStatusCode();
		System.out.println("Status code is:-"+StatusCode);
		Assert.assertEquals(StatusCode, 200);
				
				
	}

}
