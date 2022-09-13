import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetRequest {
	@Test
	void getempdetails() {
		//specify base URI
		//RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		//Request object-for request
		RequestSpecification httprequest = RestAssured.given();
		//Response object- for response
		Response response= httprequest.request(Method.GET);
		//print response in console
		String resbody=response.getBody().asPrettyString();
		System.out.println("Response body=="+resbody);
		
		//status code validation
		int scode =response.getStatusCode();
		System.out.println("Status code="+scode);
		Assert.assertEquals(scode, 200);
		
		//status line verification
		String sline= response.getStatusLine();
		System.out.println("Status line=="+sline);
		Assert.assertEquals(sline, "HTTP/1.1 200 OK");
		
		
	}

}
