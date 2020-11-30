package DataDrivenTesting;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest_AddEmployeesPartTwo {
	
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
	String [][] getempdata() throws IOException
	{
		//Read data from excel.
		String Exfilepath="D:\\jitu\\migration\\selenium\\RestAPI\\src\\test\\java\\DataDrivenTesting\\TestData.xlsx";
		
		int rowcount = XLUtils.getRowCount(Exfilepath,"Sheet1");
		int columncount = XLUtils.getCellCount(Exfilepath,"Sheet1",1);
		
		System.out.println("Total row no is" + rowcount);
		System.out.println("Total column no is" + columncount);
		
		//create multi dymencial array because we dont know hoe many rows and column are avaliable in excel.
		String empdata [][]= new String[rowcount] [columncount];
		
		//i for row and j for column
		for(int i = 1;i<= rowcount; i++){
			
			for(int j=0;j< columncount; j++){
				
			   empdata[i-1][j] =XLUtils.getCellData(Exfilepath, "Sheet1", i, j)	;
			   System.out.println("Value is"+ empdata[i-1][j]);
			}
		}
		
	       return (empdata);
	}

}
