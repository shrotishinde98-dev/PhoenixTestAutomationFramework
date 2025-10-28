package com.api1.test;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.utils.ConfigManager;
import com.pojo.user;

import io.restassured.http.ContentType;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static io.restassured.RestAssured.*;

public class LoginApiTest {
	@Test
	public void Test()  throws IOException {
	
		user u = new user("iamfd","password");
	 given()
		.baseUri(ConfigManager.getProperty("BASE_URI"))
        .contentType(ContentType.JSON)
        .body(u)
        .log().uri()
        .log().method()
        .log().body()
        .when()
        .post("login")
        .then()
        .statusCode(200)
        .log().body()
        .body( "message",equalTo("Success"))
        .time(lessThan(2000L))
        .body(matchesJsonSchemaInClasspath("schema/login.json"))
        .extract().response();
		
		
		
		
		
	}

}