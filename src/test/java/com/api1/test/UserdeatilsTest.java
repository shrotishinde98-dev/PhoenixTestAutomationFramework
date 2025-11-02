package com.api1.test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static com.api.utils.AuthToken.*;

import static com.api.constant.Role.*;

import com.api.constant.Role;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;

import io.restassured.http.ContentType;
import io.restassured.http.Header;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class UserdeatilsTest {
	  @Test(description="verify correct userdetails api",groups={"api","regression","uat"})
	public void Test() {
    
		  Header m = new Header("Authorization",getToken(Role.FD));

		//Header m = new Header("Authorization",getToken(FD));
		 
		         given()
		 /*       .baseUri(ConfigManager.getProperty("BASE_URI"))
		        .contentType(ContentType.JSON)
           	    .header(m)  */
		      
		            .spec(SpecUtil.AuthrequestSpec(Role.ENG))
			        .when()
			        .get("userdetails")
			        .then()
			        .spec(SpecUtil.responseSpec())
			       /* .log().all()
			        .statusCode(200)
			        .log().status()
			        .log().body()
			        .time(lessThan(2000L))  */
			        .body( "message",equalTo("Success"))
			        .body(matchesJsonSchemaInClasspath("schema/userdetails.json"))
			        .extract().response();
		         
	}
	

}
