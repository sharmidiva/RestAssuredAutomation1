import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class fromintelj {
	@Test
	 public void getmeth() {
		/*
		
		//Request and response in normal java for get method
		Response res=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Response body in normal java="+res.asPrettyString());
		System.out.println("Status code from normal java="+res.getStatusCode());
		//Request and response in normal java for delete method
		Response resdel=RestAssured.delete("https://reqres.in/api/users/2");
		System.out.println("Response body for del in normal java="+resdel.asPrettyString());
		System.out.println("Status code for del in normal java="+resdel.getStatusCode());
		
		*/
		
		Response res =given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then().extract().response();


		
		System.out.println("Status code===>"+res.getStatusCode());
		System.out.println("Body====>"+res.body().asPrettyString());
		System.out.println("Status Line===>"+res.getStatusLine());
		Assert.assertEquals(res.getStatusCode(),200);//check for validation using status code
		
		 
	
	 }
@Test
	
	public void getmethjson() {
		JSONObject jsonobj=new JSONObject();
		Response res= given()
				.header("Content-Type","application/json")
				.body(jsonobj.toString())
				.when()
				.get("https://reqres.in/api/users?page=2")

				.then().extract().response();
				


		System.out.println("It uses json method for get  ===>"+res.body().asPrettyString());
		System.out.println("Status code for get using json===>"+res.getStatusCode());
		System.out.println("Content type for get using json ==>"+res.getContentType());
		Assert.assertEquals(res.getStatusCode(),200);



		
	}
	
	@Test
	public void postmeth() {
		given()
		.header("Content-Type","application/json")
		.body("{\n"
				+ "    \"name\": \"ssss\",\n"
				+ "    \"job\": \"king\"\n"
				+ "}")
		.when()
		.post("https://reqres.in/api/users")
		.then().log().all();
		
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
	@Test
	public void putmeth() {
		given()
		.body("{\n"
				+ "    \"name\": \"Peter\",\n"
				+ "    \"job\": \"zion resident\"\n"
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
