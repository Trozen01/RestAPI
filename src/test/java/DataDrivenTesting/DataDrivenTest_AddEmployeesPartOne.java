package DataDrivenTesting;

import junit.framework.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest_AddEmployeesPartOne {
	
	@Test (dataProvider="empdataprovider")
	public void postNewEmployee(String ename, String position){
		
		//base URL
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request object.
		RequestSpecification httprequest = RestAssured.given();
		
		//Point 1:-Reqquest payload sending along with post request.
		JSONObject requestParams= new JSONObject();
		requestParams.put("name",ename);
		requestParams.put("Job",position);
		
		//Add a header string the Request body is a JSON.
		httprequest.header("Contact-type","application/json");
		
		//Add the json to the body of the request. 
		httprequest.body(requestParams.toJSONString());
		
		//Response Object
		Response response = httprequest.request(Method.POST,"/users");
		
		//print response in console window.
		String responsebody =response.getBody().asString();
		System.out.println("Response body is:-"+responsebody);
				
		//status code validation.
		int StatusCode=response.getStatusCode();
		System.out.println("Status code is:-"+StatusCode);
		Assert.assertEquals(StatusCode, 201);
		
		
		//Assert.assertEquals(responsebody.contains(ename),true);
		//Assert.assertEquals(responsebody.contains(position),true);
		
	}
	
	
	@DataProvider (name="empdataprovider")
	String [][] getempdata(){
	String empdata[][]={ {"Jitu2","Manager"}, {"Suraj2","Manager"}, {"Ram3","Manager"}};
	return (empdata);
	}
}
