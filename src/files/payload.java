package files;

import restAPI.basics;

public class payload {
	public static String putPlace;

	public static String addPlace()

	{

		return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.393494,\r\n" + "    \"lng\": 33.470362\r\n"
				+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"chan  silk house\",\r\n"
				+ "  \"phone_number\": \"(+91) 9929234567\",\r\n"
				+ "  \"address\": \"shop no 11,SSc market ,Kurnool\",\r\n" + "  \"types\": [\r\n"
				+ "    \"cloth shop\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n"
				+ "  \"website\": \"https://rahulshettyacademy.com\",\r\n" + "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n" + "";
	}

	public static String updatePlace() {
		putPlace = "shop no. 21 A,N.r ,Kurnool-518001";
		return "{\r\n" + 
				"    \r\n" + 
				"    \"place_id\": \"\""+ basics.place_id_value +"\",\r\n" + 
				"    \"address\": \"shop no. 11 A,SSC Market ,Kurnool-518001\",\r\n" + 
				"    \"key\":\"qaclick123\"\r\n" + 
				"    \r\n" + 
				"}";
}

	public static String coursesInfo() {

		return "{\r\n" + "\r\n" + "\"dashboard\": {\r\n" + "\r\n" + "\"purchaseAmount\": 910,\r\n" + "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n" + "\r\n" + "},\r\n" + "\r\n" + "\"courses\": [\r\n"
				+ "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"Selenium Python\",\r\n" + "\r\n" + "\"price\": 50,\r\n"
				+ "\r\n" + "\"copies\": 6\r\n" + "\r\n" + "},\r\n" + "\r\n" + "{\r\n" + "\r\n"
				+ "\"title\": \"Cypress\",\r\n" + "\r\n" + "\"price\": 40,\r\n" + "\r\n" + "\"copies\": 4\r\n" + "\r\n"
				+ "},\r\n" + "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"RPA\",\r\n" + "\r\n" + "\"price\": 45,\r\n"
				+ "\r\n" + "\"copies\": 10\r\n" + "\r\n" + "}\r\n" + "\r\n" + "]\r\n" + "\r\n" + "}\r\n" + "\r\n" + "";

	}

	public static String addBookJson(String isbn, String aisle) {
		String addBookJsonFormat = "{\r\n" + "\"name\":\"Learn Appium Automations with Java\",\r\n" + "\"isbn\":\""
				+ isbn + "\",\r\n" + "\"aisle\":\"" + aisle + "\",\r\n" + "\"author\":\"SaiCharan\"\r\n" + "}\r\n" + "";

		return addBookJsonFormat;

	}

	public static String delteBookJson(String ID) {
		String deleteBookJsonString = "{\r\n" + " \r\n" + "\"ID\" : \"" + ID + "\"\r\n" + " \r\n" + "} \r\n" + "";
		return deleteBookJsonString;
	}

}
