package files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

	public static JsonPath rawToJson(String getResponse) {
	 JsonPath jp=new JsonPath(getResponse);
	return jp;
}
}