package restAPI;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import files.ReUsableMethods;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourse;
import pojo.WebAutomation;

public class OAuth2point0 {

	public static void main(String[] args) throws InterruptedException {
		String[] expectedCourses = { "Selenium Webdriver Java","Cypress","Protractor"};

//		System.setProperty("webdriver.chrome.driver", "C:\\Chrome_89\\chromedriver.exe");
//		WebDriver dr=new ChromeDriver();
//		dr.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/"
//				+ "userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2h"
//				+ "k7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=krcharan");
//		dr.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.chord("ks.chajhghgh@gmail.com",Keys.ENTER));
//		dr.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.chord("ghgughg",Keys.ENTER));
//		Thread.sleep(3000);
//		String URL=dr.getCurrentUrl();

		String URL = "https://rahulshettyacademy.com/getCourse.php?state=krcharan&code=4%2F0AY0e-g4zbSbJ1aAzGRiBGG0tnU-uvOqWa8D9O_eQRyMB3YeAepY-h4OVEibboZIid2z69w&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none#";
		String split1 = URL.split("&code=")[1];
		String authCode = split1.split("&scope")[0];
		System.out.println(authCode);

		String exchangeCodeResponse = given().urlEncodingEnabled(false).queryParam("code", authCode)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code").when()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();

		JsonPath jp = ReUsableMethods.rawToJson(exchangeCodeResponse);
		String accessToken = jp.get("access_token");

		GetCourse classResponse = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		System.out.println(classResponse.getLinkedIn());
		System.out.println(classResponse.getInstructor());

		System.out.println(classResponse.getCourses().getApi().get(1).getCourseTitle());

		List<Api> apiCourses = classResponse.getCourses().getApi();
		for (int i = 0; i < apiCourses.size(); i++) {
			if (classResponse.getCourses().getApi().get(i).getCourseTitle()
					.equalsIgnoreCase("SoapUI Webservices testing"))

			{
				System.out.println(classResponse.getCourses().getApi().get(i).getPrice());

			}

		}

		System.out.println("WebAutomation course titles are below");
		ArrayList<String> a = new ArrayList<String>();
		List<WebAutomation> WAcourses = classResponse.getCourses().getWebAutomation();
		for (WebAutomation courseTitle : WAcourses) {

			a.add(courseTitle.getCourseTitle());
		}
		List<String> expectedTitles = Arrays.asList(expectedCourses);
		Assert.assertTrue(a.equals(expectedTitles));
		System.out.println("All titles are expected");

	}

}
