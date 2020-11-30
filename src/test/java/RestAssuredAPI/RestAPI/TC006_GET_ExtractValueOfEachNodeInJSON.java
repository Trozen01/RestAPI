package RestAssuredAPI.RestAPI;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import org.testng.annotations.Test;

public class TC006_GET_ExtractValueOfEachNodeInJSON {
	
	@Test
	public void getdetails(){
		
		        //Base URL
				RestAssured.baseURI="http://fakerestapi.azurewebsites.net/api";

				//Request Object
				RequestSpecification httpRequest=RestAssured.given();
						
				//Response Object
				Response response = httpRequest.request(Method.GET,"/Activities?ID=1");
								
				//the response body is in json format and we need to extract each option for this we need use seperate class JSONPATH class.
				
				JsonPath jpath= response.jsonPath();   // we store our response in JSONPATH class
				
				
				System.out.println("ID is:"+jpath.get("ID"));
				System.out.println("Title is:"+jpath.get("Title"));
				System.out.println("DueDate is:"+jpath.get("DueDate"));
				System.out.println("Completed is:"+jpath.get("Completed"));

				Assert.assertEquals("Activity 1", jpath.get("Title"));
				
	}

}
