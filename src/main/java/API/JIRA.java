package API;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

public class JIRA {

	// TEST SCENARIOS 
	//1- LOGIN TO JIRA .
	//2-LOGIN TO JIRA AND CREATE ISSUE 
	//3-LOGIN TO JIRA , CREATE ISSUE AND DELETE THAT ISSUE 
	//4- LOGIN TO JIRA , CREATE ISSUE , ADD COMMENT 
	//5 - GET issue comment and verify added comment and attachment exists using get API issue .
	
	//public static void main(String[] args) {
		
		@Test(enabled = false)
		
		public void Login() {
		
		
	RestAssured.baseURI = "http://localhost:8080" ;
	String UN = "pooja" ;
	String Pass = "123456@pooja";
	
	SessionFilter session = new SessionFilter(); //Under Given Section Only
	 given().log().all().header("content-type", "application/json").body("{ \"username\": \""+UN+"\", \"password\": \""+Pass+"\" }\r\n"
			+ "").filter(session).when().post("/rest/auth/1/session").then().assertThat().statusCode(200).log().all().extract().response().asString();
	 
	 //GETTED SESSION ID , LOGIN DONE 
	 
	 
		}
	
	@Test(enabled = false)
	
	public void AddIssue() {
		
		RestAssured.baseURI = "http://localhost:8080" ;
		String UN = "pooja" ;
		String Pass = "123456@pooja";
		String ProjectCode = "RAN";
		
		SessionFilter session = new SessionFilter(); //Under Given Section Only
		 String SessionID = given().log().all().header("content-type", "application/json").body("{ \"username\": \""+UN+"\", \"password\": \""+Pass+"\" }\r\n"
				+ "").filter(session).when().post("/rest/auth/1/session").then().assertThat().statusCode(200).log().all().extract().response().asString();
		 //LOGIN -- DONE
		 
		 given().log().all().header("content-type", "application/json").header("Cookie" , "JSESSIONID="+SessionID+"").body("{\"fields\":\r\n"
		 		+ "\r\n"
		 		+ "{\"project\":\r\n"
		 		+ "{\r\n"
		 		+ "    \"key\": \""+ProjectCode+"\"\r\n"
		 		+ "},\r\n"
		 		+ "\"summary\" : \"Random Defect\",\r\n"
		 		+ "\"description\": \"creating first issue\" , \r\n"
		 		+ "\"issuetype\" :\r\n"
		 		+ "\r\n"
		 		+ "{\"name\" : \"Bug\"\r\n"
		 		+ "} \r\n"
		 		+ "}\r\n"
		 		+ "}").filter(session).when().post("/rest/api/2/issue").then().assertThat().statusCode(201).log().all().toString();
		
		
	}
	
	
	@Test(enabled = true)
	public void Add_Attachment() {
		
		RestAssured.baseURI = "http://localhost:8080" ;
		String UN = "pooja" ;
		String Pass = "123456@pooja";
		String ProjectCode = "RAN";
		
		SessionFilter session = new SessionFilter(); //Under Given Section Only
		 String SessionID = given().log().all().header("content-type", "application/json").body("{ \"username\": \""+UN+"\", \"password\": \""+Pass+"\" }\r\n"
				+ "").filter(session).when().post("/rest/auth/1/session").then().assertThat().statusCode(200).log().all().extract().response().asString();
		 //LOGIN -- DONE
		 
		 String Response = given().log().all().header("content-type", "application/json").header("Cookie" , "JSESSIONID="+SessionID+"").body("{\"fields\":\r\n"
			 		+ "\r\n"
			 		+ "{\"project\":\r\n"
			 		+ "{\r\n"
			 		+ "    \"key\": \""+ProjectCode+"\"\r\n"
			 		+ "},\r\n"
			 		+ "\"summary\" : \"Random Defect\",\r\n"
			 		+ "\"description\": \"creating first issue\" , \r\n"
			 		+ "\"issuetype\" :\r\n"
			 		+ "\r\n"
			 		+ "{\"name\" : \"Bug\"\r\n"
			 		+ "} \r\n"
			 		+ "}\r\n"
			 		+ "}").filter(session).when().post("/rest/api/2/issue").then().assertThat().statusCode(201).extract().response().asString();
			System.out.println(Response);
			JsonPath JS = new JsonPath(Response);
			String TypeID = JS.getString("id");
			
		 //make issue - get issue ID
		 
		 given().log().all().header("X-Atlassian-Token" , "no-check").pathParam("id", TypeID).filter(session).
		 header("Content-Type", "multipart/form-data").multiPart("file" , new File("Jira.txt"))
		 .when().post("/rest/api/2/issue/{id}/attachments").then().log().all().assertThat().statusCode(200);
 
		
	}
		
	
}
