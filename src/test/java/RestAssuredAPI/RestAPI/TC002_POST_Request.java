package RestAssuredAPI.RestAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	@Test
	public void Registration(){
		
		//base URL
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request object.
		RequestSpecification httprequest = RestAssured.given();
		
		//Point 1:-Reqquest payload sending along with post request.
		JSONObject requestParams= new JSONObject();
		requestParams.put("name","JohnM");
		requestParams.put("Job","managerXF");
		
		//Point 2:-what kind of Request data we send with API (we need specify in header we are sending data in JSON format)
		httprequest.header("Contact-type","application/json");
		
		
		// point 1 and 2 we need send along with request  
		httprequest.body(requestParams.toJSONString());
		
		//Response Object
		Response response = httprequest.request(Method.POST,"/users");
		
		//status code validation.
		int StatusCode=response.getStatusCode();
		System.out.println("Status code is:-"+StatusCode);
		Assert.assertEquals(StatusCode, 201);
				
		//status code validation.
		//String successcode= response.jsonPath().get("SuccessCode");
		//System.out.println("successcode is"+successcode);
		//Assert.assertEquals(successcode, "OPERATION_SUCCESS");
		
	}
	
	 //status code validation.
    //status line validation.
	
//------Multipal Users add ------------------------------------------------
	
	/*@Test(dataProvider="empdataprovider")
	public void Registrations(String name,String Job){
		
		//base URL
				RestAssured.baseURI="https://reqres.in/api";
				
				//Request object.
				RequestSpecification httprequest = RestAssured.given();
				
				//Point 1:-Reqquest payload sending along with post request.
				JSONObject requestParams= new JSONObject();
				requestParams.put("name",name);
				requestParams.put("Job",Job);
				
				//Point 2:-what kind of Request data we send with API (we need specify in header we are sending data in JSON format)
				httprequest.header("Contact-type","application/json");
				
				
				// point 1 and 2 we need send along with request  
				httprequest.body(requestParams.toJSONString());
				
				//Response Object
				Response response = httprequest.request(Method.POST,"/users");
				
				//status code validation.
				int StatusCode=response.getStatusCode();
				System.out.println("Status code is:-"+StatusCode);
				Assert.assertEquals(StatusCode, 201);
						
				//status code validation.
				//String successcode= response.jsonPath().get("SuccessCode");
				//System.out.println("successcode is"+successcode);
				//Assert.assertEquals(successcode, "OPERATION_SUCCESS");
	}
	
	
	@DataProvider(name="empdataprovider")
	String [][] getempdata(){
		
	String empdata [] [] ={{"Jitu","PM"},{"Jiten","Owner"},{"Jitendra","Programer"}};
	return empdata;
	}
*/
}
