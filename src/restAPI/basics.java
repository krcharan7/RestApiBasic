package restAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;


public class basics {
 public static String place_id_value;
 public static String updatedPlace;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//post
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response =given().log().all().queryParam("key", "qaclick123").header("content-type","application/json")
		.body(payload.addPlace()).when().post("maps/api/place/add/json")

		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server","Apache/2.4.18 (Ubuntu)").extract().response().asString();
	//new String(Files.readAllBytes(Paths.get("C:\\Users\\charan\\locationJson.json")))
		System.out.println(response);		
	
		 JsonPath jp=ReUsableMethods.rawToJson(response);
	 place_id_value=jp.getString("place_id");
		System.out.println(place_id_value);
	//put	
		
		given().log().all().queryParams("key","qaclick123").header("content-type", "application/json")
		.body(payload.updatePlace()).when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
	//Get
	
	String getResponse=	given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id_value)
		.when().log().all().get("maps/api/place/get/json")
		.then().statusCode(200).extract().response().asString();
		

		 JsonPath jp1=ReUsableMethods.rawToJson(getResponse);
		 updatedPlace= jp1.getString("address");
		 
		 Assert.assertEquals(updatedPlace, payload.putPlace);
		 System.out.println(updatedPlace+":"+ payload.putPlace);
		
	}

}
