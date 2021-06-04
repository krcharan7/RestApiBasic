package files;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	static int totalAmount;
	static int sum=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
JsonPath jp=ReUsableMethods.rawToJson(payload.coursesInfo());
int courseCount=jp.getInt("courses.size()");
System.out.println("the total course count is "+courseCount);
 totalAmount=jp.getInt("dashboard.purchaseAmount");
System.out.println("The total courses amount is "+totalAmount);


for(int i=0;i<courseCount;i++) {
	String courseTitle=jp.get("courses["+i+"].title");
	System.out.println("The "+i+"st coursetitle is "+courseTitle);
	System.out.println(jp.get("courses["+i+"].price").toString());
		
}
System.out.println("Print the price of RPA course");
for(int i=0;i<courseCount;i++) {
	String courseTitle=jp.get("courses["+i+"].title");
	if(courseTitle.equalsIgnoreCase("rpa")) {
		System.out.println(jp.get("courses["+i+"].copies").toString());
		break;
	}
	
		
}
System.out.println("Print the total price of courses");
for(int i=0;i<courseCount;i++) {
	
	int coursePrice=jp.getInt("courses["+i+"].price");
	int courseCopies=jp.getInt("courses["+i+"].copies");
	sum=sum+(coursePrice*courseCopies);
	

}
System.out.println("sum is"+sum);
Assert.assertEquals(sum, totalAmount);
	}
	
		
}

	

