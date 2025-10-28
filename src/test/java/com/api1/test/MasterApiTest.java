package com.api1.test;

import static org.testng.Assert.assertNotNull;

import org.checkerframework.checker.index.qual.LessThan;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.utils.AuthToken;
import com.api.utils.ConfigManager;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class MasterApiTest {
	@Test
	public void MasterApiTest() {
		given()
		.baseUri(ConfigManager.getProperty("BASE_URI"))
	
		.header("Authorization",AuthToken.getToken(Role.FD))
		.contentType(" ")
		.log().uri()
		.when()
		.post("master")
		.then()
		.statusCode(200)
		.body("message", Matchers.equalTo("Success"))
		.body("data", Matchers.notNullValue())
		.time(Matchers.lessThan(1000L))
	    .body("data",Matchers.hasKey("mst_oem"))
	    .body("data",Matchers.hasKey("mst_model"))
		.body("data.size()",Matchers.greaterThanOrEqualTo(0))
		.body("data.mst_oem.size()",Matchers.equalTo(2))
		.body("data.mst_oem.id",Matchers.notNullValue())
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/master.json"))
	   	.log().all();
 	}
     @Test
     public void Auth_missing() {
    	 given()
 		.baseUri(ConfigManager.getProperty("BASE_URI"))
 		.contentType(" ")
 		.when()
 		.post("master")
 		.then()
 		.statusCode(401);
     }
     
}
