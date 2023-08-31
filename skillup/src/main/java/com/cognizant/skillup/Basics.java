package com.cognizant.skillup;

import static io.restassured.RestAssured.*;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
//import files.Payload;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json;charset=UTF-8")
		.body(Payload.file()).when().post("maps/api/place/add/json")
					.then().statusCode(200)
					.header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String placeId=js.getString("place_id");
		System.out.println(placeId);
		String str="70 Summer walk, USA";
		given().log().all().queryParam("key","qaclick")
		.header("Content-Type","application/json;charset=UTF-8")
		.body("{\r\n"+
			"\"place_id\":\""+placeId+"\",\r\n"+
			"\"address\":\""+ str +"\",\r\n"+
			"\"key\":\"qaclick123\"\r\n"+
			"}").when().put("maps/api/place/update/json")
			.then().assertThat().log().all().statusCode(200)
			.body("msg",equalTo("Address successfully updated"));
		
		String getStr=given().queryParam("key","qaclick123")
		.queryParam("place_id",placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200)
		.extract().response().asString();
		
		JsonPath j=new JsonPath(getStr);
		String st=j.getString("address");
		Assert.assertEquals(st,str);
		
		
		
	}

}
