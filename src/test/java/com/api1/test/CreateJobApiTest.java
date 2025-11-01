package com.api1.test;




import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constant.Model;
import com.api.constant.OEM;
import com.api.constant.Platform;
import com.api.constant.Problem;
import com.api.constant.Product;
import com.api.constant.Role;
import com.api.constant.ServiceLocation;
import com.api.constant.Warranty_status;
import com.api.utils.AuthToken;
import com.api.utils.ConfigManager;
import com.api.utils.DateTimeUtil;
import com.api.utils.SpecUtil;
import com.pojo.CreateJobPayload;
import com.pojo.Customer;
import com.pojo.Customer_address;
import com.pojo.Customer_product;
import com.pojo.Problems;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

import static com.api.utils.AuthToken.getToken;
import static io.restassured.RestAssured.*;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;

public class CreateJobApiTest { 
	@Test
	public void createJobApiTest() {
		
		Customer customer = new Customer("shruti", "mane", "9004568952", " ", "shrutimane25@gmail.com", "shrotishinde98@gmail.com");
		Customer_address customer_address = new Customer_address("304", "nmk", "nhi ","girgo", "pune", "421102", "India",  "Maharashtra");
		Customer_product customer_product =  new Customer_product(DateTimeUtil.getTimewithDaysAgo(10),"12345678998869", "12345678998869", "12345678998869", DateTimeUtil.getTimewithDaysAgo(10), Product.Nexus_2.getCode(), Model.Nexus_2_blue.getCode());
		Problems prob = new Problems(Problem.Smartphone_is_running_slow.getCode(),"battery");
		List<Problems>  problemList = new ArrayList<Problems>();
		problemList.add(prob);
		
		CreateJobPayload createJobPayload = new CreateJobPayload(ServiceLocation.SERVICE_LOCA_A.getCode(), Platform.FRONT_DESK.getCode(), Warranty_status.IN_WARRANTY.getCode(), OEM.GOOGLE.getCode(), customer, customer_address, customer_product, problemList);
	given()
    //.baseUri(ConfigManager.getProperty("BASE_URI"))
    //.header("Authorization", AuthToken.getToken(Role.FD))
    //.contentType(ContentType.JSON)
    .spec(SpecUtil.AuthrequestSpec(Role.FD, createJobPayload))
    //.body(createJobPayload)
    //.log().all()
    .when()
    .post("/job/create")
    .then()
    
    .spec(SpecUtil.responseSpec())
    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/createjob.json"))
     .body("message",Matchers.equalTo("Job created successfully. "))
     .body("data.mst_service_location_id",Matchers.equalTo(1))
     .body("data.job_number", Matchers.startsWith("JOB_"));
    
	
   
   
	}

}
