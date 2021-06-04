package restAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.SerializationAddPlace;
import pojo.SerializationLocationSubJson;

import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddPlaceBySerializationSpecBuilder {
	public static String place_id_value;
	public static String updatedPlace;

	public static void main(String[] args) throws IOException {
		//implementation of serialization
		SerializationAddPlace sap = new SerializationAddPlace();
		sap.setAccuracy(50);
		sap.setAddress("shop no 11,SSc market ,Kurnool");
		sap.setLanguage("Telugu IN");
		sap.setPhone_number("9876534568");
		sap.setWebsite("http://Rahulshettyacademy.com");
		sap.setName("Saree park");
		List<String> myList = new ArrayList<String>();
		myList.add("Saree house");
		myList.add("shop");
		sap.setTypes(myList);
		SerializationLocationSubJson sj = new SerializationLocationSubJson();
		sj.setLat(-38.323464);
		sj.setLng(33.478776);
		sap.setLocation(sj);

//post by SpecBuilders

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();

		RequestSpecification r1 = given().log().all().spec(req).body(sap);
		String response = r1.when().post("maps/api/place/add/json").then().spec(res).extract().response().asString();

		System.out.println(response);

	}

}
