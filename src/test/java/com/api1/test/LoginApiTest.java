package com.api1.test;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import com.pojo.user;

import io.restassured.http.ContentType;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static io.restassured.RestAssured.*;

public class LoginApiTest {
	@Test
	public void Test() {
	
		user u = new user("iamfd","password");

		given()
        .baseUri("http://64.227.160.186:9000/v1")
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
        .time(lessThan(1000L))
        .body(matchesJsonSchemaInClasspath("schema/login.json"))
        .extract().response();
		
		
		
		
		
	}

}