package com.api1.test;

import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.utils.AuthToken;
import com.api.utils.ConfigManager;
import com.pojo.CreateJobPayload;
import com.pojo.Customer;
import com.pojo.Customer_address;
import com.pojo.Customer_product;
import com.pojo.Problems;

import io.restassured.http.ContentType;
import io.restassured.http.Header;

import static com.api.utils.AuthToken.getToken;
import static io.restassured.RestAssured.*;

import java.net.Authenticator;

public class CreateJobApiTest { 
	@Test
	public void createJobApiTest() {
		
		Customer customer = new Customer("sanket", "mane", "8765432121", " ", "sanket393@gmail.com", "shrotishinde98@gmail.com");
		Customer_address customer_address = new Customer_address("402", "shiv", "mandir road ","jain school", "laxmi nagar", "421102", "India",  "Maharashtra");
		Customer_product customer_product = new Customer_product("2025-08-31T18:30:00.000Z","04871502270775", "04871502270775", "04871502270775", "2025-08-31T18:30:00.000Z", 3, 3);
		Problems prob = new Problems(2,"battery");
		Problems[] problemArray = new Problems[1];
		problemArray[0] = prob;
		
		CreateJobPayload createJobPayload = new CreateJobPayload(0, 2, 1, 2, customer, customer_address, customer_product, problemArray);
	given()
    .baseUri(ConfigManager.getProperty("BASE_URI"))
    .header("Authorization", AuthToken.getToken(Role.FD))
    .contentType(ContentType.JSON)
    .body(createJobPayload)
    .log().all()
    .when()
    .post("/job/create")
    .then()
    .log().all()
    .statusCode(200);
	}

}
