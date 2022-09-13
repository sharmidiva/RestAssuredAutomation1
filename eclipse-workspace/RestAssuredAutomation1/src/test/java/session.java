import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;


public class session {
	@Test
	
	public void getmeth() {
	Response res = RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println("Body==>"+res.asPrettyString());
	System.out.println("Status Code===>"+res.statusCode());
	}
	@Test
	public void getmethBDD() {
		
		
		Response res =given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then().extract().response();


		
		System.out.println("Status code===>"+res.getStatusCode());
		System.out.println("Body====>"+res.body().asPrettyString());
		System.out.println("Status Line===>"+res.getStatusLine());

}


}
