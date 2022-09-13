import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostRequest {
	@Test
	void postreq() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpreq =RestAssured.given();
		//Request payload sending along with post request
		JSONObject reqparam=new JSONObject();
		reqparam.put("name","Adam");
		reqparam.put("job","QA");
		
		httpreq.header("Content-Type","application/json");
		httpreq.body(reqparam.toJSONString());
		
		Response response=httpreq.request(Method.POST);
		String resbody=response.getBody().asString();
		System.out.println("Response body=="+resbody);
		
		//status code validation
		int scode =response.getStatusCode();
		System.out.println("Status code="+scode);
		Assert.assertEquals(scode, 201);
		
		
		//status line verification
		String sline= response.getStatusLine();
		String ctype=response.getContentType();
		System.out.println("Status line=="+sline);
		System.out.println("content type="+ctype);
		Assert.assertEquals(sline, "HTTP/1.1 201 Created");
		
		
	}

}
