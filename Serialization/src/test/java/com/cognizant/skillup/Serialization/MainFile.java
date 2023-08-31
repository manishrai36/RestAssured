package com.cognizant.skillup.Serialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MainFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddPlace ad=new AddPlace();
		ad.setAccuracy(60);
		ad.setName("SNS Homes");
		ad.setPhone_number("4589345690");
		ad.setWebsite("http://google.com");
		ad.setLanguage("English");
		List<String> ar=new ArrayList<>();
		ar.add("shoes park");
		ar.add("shop");
		ad.setTypes(ar);
		Location lt=new Location();
		lt.setLng("33.427362");
		lt.setLat("-38.383494");
		ad.setLocation(lt);
		
// Print Value to check is it setting data or not
	/*	int ac=ad.getAccuracy();
		String sn=ad.getName();
		String ph=ad.getPhone_number();
		String wb=ad.getWebsite();
		String lg=ad.getLanguage();
		List<String> tps=ad.getTypes();
		String lng=ad.getLocation().getLng();
		String lat=ad.getLocation().getLat();
		System.out.println(lat);
		System.out.println(lng);
		System.out.println(tps);
		System.out.println(lg);
		System.out.println(wb);
		System.out.println(ph);
		System.out.println(sn);
		System.out.println(ac);
		
		*/
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response rs=given().log().all().queryParam("key","qaclick123")
				.body(ad)
				.when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200)
				.extract().response();
		String res=rs.asString();
		System.out.println(res);

	}

}
