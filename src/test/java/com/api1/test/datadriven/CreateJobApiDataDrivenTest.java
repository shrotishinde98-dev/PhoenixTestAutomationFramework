package com.api1.test.datadriven;




import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
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

public class CreateJobApiDataDrivenTest { 
	private CreateJobPayload createJobPayload;

	@Test(description="verify correct craetejob api warranty",groups={"api","regression","uat","data driven"},
	  dataProviderClass= com.dataproviders.DataProviderUtils.class,
	  dataProvider = "CraeteJobAPIDataprovider"
			
			)
	public void createJobApiTest(CreateJobPayload createJobPayload) {
		
		
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
