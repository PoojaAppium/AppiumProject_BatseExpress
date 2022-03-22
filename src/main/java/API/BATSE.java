package API;

import org.testng.annotations.Test;

import A_utilities.Bodies;

import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

public class BATSE {
	
	// Login - By Mobile No. -------- Validate Server / Get Token /
	//Login - Password ---------------
	// Search Outlet On HomePage - Given Lat long
	//

@Test(enabled = true)
public void Login() {
		
RestAssured.baseURI = "https://www.be.cr/api/v1/public/index.php" ; //"http://localhost:8080" ;
SessionFilter session = new SessionFilter(); //Under Given Section Only
given().log().all().header("content-type", "application/json").body(Bodies.UserName()).filter(session).when().post("https://www.be.cr/api/v1/public/index.php"+"/customerSignUpStepOne").then().assertThat().statusCode(200).log().all().extract().response().asString();
}

//______________________________________________________________________________________________________________________________________________________________
		
@Test(dependsOnMethods = "Login" , enabled = true , priority = 1)
public void Validate_Server()
{
			
RestAssured.baseURI = "https://www.be.cr/api/v1/public/index.php" ; //"http://localhost:8080" ;
SessionFilter session = new SessionFilter(); //Under Given Section Only
given().log().all().header("content-type", "application/json").body(Bodies.UserName()).filter(session).when().post("https://www.be.cr/api/v1/public/index.php"+"/customerSignUpStepOne").then().log().all().assertThat().statusCode(200)
.header("Server", "Apache/2.4.41 (Ubuntu)");
}
//___________________________________________________________________________________________________________________________________________________________

@Test(dependsOnMethods = "Login" , enabled = true , priority = 2)
public void Get_Token()
{
RestAssured.baseURI = "https://www.be.cr/api/v1/public/index.php" ; //"http://localhost:8080" ;
SessionFilter session = new SessionFilter(); //Under Given Section Only
String Response = given().log().all().header("content-type", "application/json").body(Bodies.UserName()).filter(session).when().post("https://www.be.cr/api/v1/public/index.php"+"/customerSignUpStepOne").then().assertThat().statusCode(200).log().all().extract().response().asString();
		
JsonPath JP = new JsonPath(Response);
String Token = JP.getString("token");
System.out.println(Token);
				
}

//_________________________________________________________________________________________________________________________________________________________________________
	
@Test(enabled = true)	
public void FillPassword() {
	
	RestAssured.baseURI = "https://www.be.cr/api/v1/public/index.php";
	SessionFilter session = new SessionFilter();
	String Response = given().header("content-type", "application/json").body(Bodies.UserName()).filter(session).when().post("https://www.be.cr/api/v1/public/index.php"+"/customerSignUpStepOne").then().assertThat().statusCode(200).log().all().extract().response().asString();
	
	JsonPath JP = new JsonPath(Response);
	String Token = JP.getString("data.token");
	String str = Token.replaceAll("\\[", "").replaceAll("\\]","");
	System.out.println(str);
	given().header("content-type", "application/json").header("Authorization",str).body(Bodies.Password()).filter(session).when().post("loginUserWithPassword").then().log().all().assertThat().statusCode(200);
	
}
//______________________________________________________________________________________________________________________________________________________________________________________
	
@Test(dependsOnMethods = "FillPassword" , enabled = true)	
public void Search_Outlet_On_HomePage() {
	
	RestAssured.baseURI = "https://www.be.cr/api/v1/public/index.php";
	SessionFilter session = new SessionFilter();
  given().header("content-type", "application/json").body(Bodies.Outlet_List()).filter(session).when().post("https://www.be.cr/api/v1/public/index.php"+"/getNearByOutletList").then().assertThat().statusCode(200).log().all().extract().response().asString();

	
}
//______________________________________________________________________________________________________________________________________________________________________________________


@Test(dependsOnMethods = "Search_Outlet_On_HomePage" , enabled = true)
public static String Get_OutletID() {
	
	RestAssured.baseURI = "https://www.be.cr/api/v1/public/index.php";
	SessionFilter session = new SessionFilter();
	String Response = given().header("content-type", "application/json").body(Bodies.Outlet_List()).filter(session).when().post("https://www.be.cr/api/v1/public/index.php"+"/getNearByOutletList").then().assertThat().statusCode(200).log().all().extract().response().asString();
	
	//Get_OutletID Nearbylocation
	
	JsonPath JP = new JsonPath(Response);
	String OutletID = JP.getString("data[0].details[0].outletId");
	System.out.println("OutletID----  " + OutletID);
	
	return OutletID;
	
	
}

//_______________________________________________________________________________________________________________________________________________________________________________

@Test(dependsOnMethods = "Search_Outlet_On_HomePage" , enabled = true)
public static String Get_Category() {
	
	RestAssured.baseURI = "https://www.be.cr/api/v1/public/index.php";
	SessionFilter session = new SessionFilter();
	String Response = given().header("content-type", "application/json").body(Bodies.CategoryID()).filter(session).when().post("https://www.be.cr/api/v1/public/index.php"+"/getOutletCategoryListCompanyAdmin").then().assertThat().statusCode(200).log().all().extract().response().asString();
	
	//Get_CategoryID Nearbylocation
	
	JsonPath JP = new JsonPath(Response);
	String Category = JP.getString("data[0].details[0].categoryId");
	System.out.println("CategoryID----  " + Category);
	
	return Category;
	
}

//_______________________________________________________________________________________________________________________________________________________________________________

@Test(dependsOnMethods = "Search_Outlet_On_HomePage" , enabled = true)
public void Get_Item() {
	
	RestAssured.baseURI = "https://www.be.cr/api/v1/public/index.php" ;
	SessionFilter session = new SessionFilter();
	given().header("Content-Type","application/json").body(Bodies.Add_Item()).filter(session).when().post("getOutletItemMenu").then().statusCode(200).log().all();
	
	//System.out.println(Bodies.Add_Item());
}

//______________________________________________________________________________________________________________________________________________________________________________




}
