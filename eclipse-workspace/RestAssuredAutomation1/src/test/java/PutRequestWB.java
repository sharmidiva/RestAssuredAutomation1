import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PutRequestWB {
	@Test
	public void putmeth() {
		given()
		.body("{\n"
				+ "    \"name\": \"Peter\",\n"
				+ "    \"job\": \"Project Manager\"\n"
				+ "}")
		.when()
		.put("https://reqres.in/api/users/2")
		.then().assertThat().statusCode(200).log().all();
		//we can do validation also with the statuscode along with asserthat
		//.then().log().all();
		
	}
	@Test
	public void putmethjson() {
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("name","yyy");
		jsonobj.put("job","BA");
		Response res= given()
				.header("Content-Type","application/json")
				.body(jsonobj.toString())
				.when()
				.put("https://reqres.in/api/users/2")

				.then().extract().response();
		System.out.println("It uses json method ===>"+res.body().asPrettyString());
		System.out.println("Status code===>"+res.getStatusCode());
		System.out.println("Content type==>"+res.getContentType());
		System.out.println("Status Line===>"+res.getStatusLine());

		
		
	}

}
