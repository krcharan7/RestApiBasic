package restAPI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class LibraryAPI {
	public static String bookId;

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
// AddBook
		String postedBookResponse = given().header("Content-Type", "application/json")
				.body(payload.addBookJson(isbn, aisle)).when().post("/Library/Addbook.php").then().assertThat()
				.statusCode(200).extract().response().asString();

		JsonPath jp = ReUsableMethods.rawToJson(postedBookResponse);
		bookId = jp.get("ID");
		System.out.println("the newly added book ID is " + bookId);
//DelBook		
		String delResponse = given().header("Content-Type", "application/json").body(payload.delteBookJson(bookId))
				.when().delete("/Library/DeleteBook.php").then().assertThat().statusCode(200).extract().response()
				.asString();
		JsonPath jp1 = ReUsableMethods.rawToJson(delResponse);
		String deleteMsg = jp1.get("msg");
		System.out.println(deleteMsg);
	}

	@DataProvider(name = "BooksData")

	public Object[][] getData() {
		return new Object[][] { { "kllm", "9988" }, { "jkli", "7225" }, { "lljy", "9915" } };
	}

}
