package com.api1.test;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;

import com.pojo.user;

import io.restassured.http.ContentType;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static io.restassured.RestAssured.*;

public class LoginApiTest {
	
	private user u;
	
	@BeforeTest(description = "create payload for login api")
	public void setup(){
		 u = new user("iamfd","password");
	}
	
	@Test(description= "Verifying if login api is working for FD user",groups= {"api","regression","smoke"})
	public void Test()  throws IOException {
	
    given()
		.spec(SpecUtil.requestSpec(u))
	
        .when()
        .post("login")
        .then()
        .spec(SpecUtil.responseSpec())
        .body( "message",equalTo("Success"))
        .body(matchesJsonSchemaInClasspath("schema/login.json"))
        .extract().response();
		
		
		
		
		
	}

}