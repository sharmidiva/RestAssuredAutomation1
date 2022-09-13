import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteRequestWB {
	@Test
	public void delmeth() {
		
		
		Response res =given()

				.when()
				.delete("https://reqres.in/api/users/2")
				.then().extract().response();
			//	.then().assertThat().statusCode(204).log().all();
				System.out.println("Status code of delete ===>"+res.getStatusCode());
				System.out.println("Body of delete====>"+res.body().asPrettyString());
				System.out.println("Status Line of delete===>"+res.getStatusLine());
		
	}
	@Test
	
	public void delmethjson() {
		JSONObject jsonobj=new JSONObject();
		Response res= given()
				.header("Content-Type","application/json")
				.body(jsonobj.toString())
				.when()
				.delete("https://reqres.in/api/users/2")
				.then().extract().response();
		System.out.println("It uses json method for delete  ===>"+res.body().asPrettyString());
		System.out.println("Status code for delete using json===>"+res.getStatusCode());
		System.out.println("Content type for delete using json ==>"+res.getContentType());


		
	}

}
