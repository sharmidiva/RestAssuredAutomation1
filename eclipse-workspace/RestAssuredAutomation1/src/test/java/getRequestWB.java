import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class getRequestWB {
	@Test
	public void getmeth() {
		
				
				Response res =given()
				.when()
				.get("https://reqres.in/api/users?page=2")
				.then().extract().response();


				
				System.out.println("Status code===>"+res.getStatusCode());
				System.out.println("Body====>"+res.body().asPrettyString());
				System.out.println("Status Line===>"+res.getStatusLine());
		
	}
	@Test
    public void getRequestWithQueryParam() {
        Response response = given()
                .param("id", "7")
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .extract().response();		

        
		System.out.println("Body====>"+response.body().asPrettyString());
		


        Assert.assertEquals(200, response.statusCode());	


    }

}
