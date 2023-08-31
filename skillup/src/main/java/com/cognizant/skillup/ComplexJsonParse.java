package com.cognizant.skillup;

import java.nio.file.Files;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	public static void main(String args[])
	{
		JsonPath js=new JsonPath(Payload.coursePrice());
		// count No of courses returned by API
		int count=js.getInt("courses.size()");
		System.out.println(count);
		// print Purchase amount
		int purchase=js.getInt("dashboard.purchaseAmount");
		System.out.println(purchase);
		//print Title of the first course
		String fcourse=js.get ("courses[0].title");
		System.out.println(fcourse);
		for(int i=0;i<count;i++)
		{
			String courseTitles=js.getString("courses["+i+"].title");
			System.out.println(courseTitles);
			System.out.println(js.get("courses["+i+"].price"));
			
		}
		// print total number of purchase amount is same after calculation of no of copies* price
		int total=0;
		for(int i=0;i<count;i++)
		{
			 total=total+(js.getInt("courses["+i+"].price"))*(js.getInt("courses["+i+"].copies"));
		}
		if(purchase==total)
			System.out.println("Total amount matched");
		else
			System.out.println("Not Matched");
		//print total no of copies sold by RPA
		
	}
}
