import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PostMethodWB {
	@Test
	public void postmeth() {
		//we can use without creating object res with Response
		//without using json object
		
		given()
		.header("Content-Type","application/json")
		.body("{\n"
				+ "    \"name\": \"ssss\",\n"
				+ "    \"job\": \"king\"\n"
				+ "}")
		.when()
		.post("https://reqres.in/api/users")
		//.then().log().all();
		
		//log will print everything
		.then().assertThat().statusCode(201).log().all();
		System.out.println();
		
	}
	@Test
	public void postmethjson() {
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("name","xxxx");
		jsonobj.put("job","TL");
		Response res= given()
				.header("Content-Type","application/json")
				.body(jsonobj.toString())
				.when()
				.post("https://reqres.in/api/users")
				.then().extract().response();
				//Assert is used for validation-comparing between actual and expected
				//.then().assertThat().body("name",equalTo("xxxx")).extract().response();
		
		
		
		System.out.println("It uses json method ===>"+res.body().asPrettyString());
		System.out.println("Status code===>"+res.getStatusCode());
		System.out.println("Content type==>"+res.getContentType());
		Assert.assertEquals(res.getStatusCode(),201);
}
}
