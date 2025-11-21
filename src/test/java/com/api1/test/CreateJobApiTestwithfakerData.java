package com.api1.test;




import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.utils.FakerDataGenerator;
import com.api.utils.SpecUtil;
import com.pojo.CreateJobPayload;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobApiTestwithfakerData { 
	private CreateJobPayload createJobPayload;
	//private final static String COUNTRY="India"  ; //var for country
	
	@BeforeTest(description="verify create job api payload")
      public void setup(){
		   //util class
		createJobPayload= FakerDataGenerator.generateFakeCraeteJobData();  /* use fake data generator class of FakerDataGenerator*/
	}
	
	
	@Test(description="verify correct craetejob api warranty",groups={"api","regression","uat"})
	public void createJobApiTest() {
	
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
