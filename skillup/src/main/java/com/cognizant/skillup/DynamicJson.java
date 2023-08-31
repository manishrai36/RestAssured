package com.cognizant.skillup;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import files.Payload;

public class DynamicJson {
	
	@Test	
	public void addBook()
	{
			RestAssured.baseURI="http://216.10.245.166";
			String str=given().log().all().header("Content-Type","application/json")
			.body(Payload.Addbook())
			.when().post("/Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200)
			.extract().response().asString();
			//JsonPath js=new JsonPath(str);
			//String id=js.get("ID");
		//	System.out.println(id);
			
	}
	
}
