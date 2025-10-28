package com.api1.test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static com.api.utils.AuthToken.*;

import com.api.constant.Role;
import com.api.utils.ConfigManager;

import io.restassured.http.ContentType;
import io.restassured.http.Header;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class UserdeatilsTest {
	  @Test
	public void Test() {
		 
		 Header m = new Header("Authorization",getToken(Role.FD));
		
		 
			
		 given()
			        .baseUri(ConfigManager.getProperty("BASE_URI"))
			        .contentType(ContentType.JSON)
			        .header(m)
			       .when()
			        .get("userdetails")
			        .then()
			        .log().all()
			        .statusCode(200)
			        .log().status()
			        .log().body()
			        .body( "message",equalTo("Success"))
			        .and()
			        .time(lessThan(2000L))
			        .and()
			        .body(matchesJsonSchemaInClasspath("schema/userdetails.json"))
			        .extract().response();
	}
	

}
