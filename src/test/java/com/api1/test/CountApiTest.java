package com.api1.test;

import static io.restassured.RestAssured.*;


import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.utils.AuthToken;
import com.api.utils.ConfigManager;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CountApiTest {
	@Test
	public void CoutApiTest() {
		given()
		.baseUri(ConfigManager.getProperty("BASE_URI"))
		.header("Authorization",AuthToken.getToken(Role.FD))
		.log().uri()
		.when()
		.get("/dashboard/count")
		.then()
		.statusCode(200)
		.log().all()
		.body( "message", Matchers.equalTo("Success"))
		.body("data", Matchers.notNullValue())
		.time(Matchers.lessThan(1000L))
		.body("data.size()",Matchers.equalTo(3))
		.body("data.count",Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)))
		.body("data.label", Matchers.everyItem(Matchers.not(Matchers.blankOrNullString())))
		.body("data.key",Matchers.containsInAnyOrder("pending_for_delivery","created_today","pending_fst_assignment"))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/verifycount.json"));

		
    }
	
	@Test
	public void NeagtiveTest() {
		given()
		.baseUri(ConfigManager.getProperty("BASE_URI"))
		//.header("Authorization",AuthToken.getToken(Role.FD))
		.when()
		.get("/dashboard/count")
		.then()
		.statusCode(401)
		.log().all();
	}

}
