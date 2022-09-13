package DataDrivenRESTASSURED;

import org.testng.annotations.Test;


import org.testng.AssertJUnit;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


import io.restassured.response.Response;
import Utilities.ReadFromExcel;


public class PostDDT extends BaseClass{
	@Test(dataProvider="postddt")
	public  void testpostddt(String name,String job) {
		JSONObject obj=new JSONObject();
		logger.info("getting name from excel");
		obj.put("name",name);
		logger.info("getting job from excel");
		obj.put("job",job);
		logger.info("enter post request");
		Response res=given() 
				      .header("Content-Type","application/json")
				      .body(obj.toString())
		              .when()
		              .post("https://reqres.in/api/users")
		              .then().extract().response();
		logger.info("print the response");
		System.out.println("Response===>"+res.asPrettyString());
		logger.info("print the status code");
		System.out.println("Status Code==>"+res.getStatusCode());
		logger.info("checking the status code");
		AssertJUnit.assertEquals(res.getStatusCode(),201);
		
	}
	@DataProvider(name="postddt")
	
		String [][]getdata() throws IOException{
			String path="/Users/diva/eclipse-workspace/RestAssuredAutomation1/src/test/resources/PostDDT.xlsx";
			int rownum=ReadFromExcel.getRowCount(path, "Sheet1");
			int colcount=ReadFromExcel.getCellCount(path, "Sheet1", 1);
			String postddt[][]=new String[rownum][colcount]; 
			
			for(int i=1;i<=rownum;i++) {
				for(int j=0;j<colcount;j++ ) {
					postddt[i-1][j]=ReadFromExcel.getCellData(path, "Sheet1", i, j);//1  0
				}
			}
			return postddt;
	}
	


}