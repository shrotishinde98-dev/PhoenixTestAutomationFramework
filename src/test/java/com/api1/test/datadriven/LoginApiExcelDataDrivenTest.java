package com.api1.test.datadriven;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;
import com.dataproviders.api.bean.UserBean;
import com.pojo.user;

import io.restassured.http.ContentType;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static io.restassured.RestAssured.*;

public class LoginApiExcelDataDrivenTest {
	
	
	
	@Test(description= "Verifying if login api excel is working for FD user",
			groups= {"api","regression","data driven"},
			dataProviderClass =com.dataproviders.DataProviderUtils.class,
			dataProvider = "LoginAPIExcelDataProvider"
			)
	public void Test(UserBean userBean) {
		//object user details 
	    given()
			.spec(SpecUtil.requestSpec(userBean))
		
	        .when()
	        .post("login")
	        .then()
	        .spec(SpecUtil.responseSpec())
	        .body( "message",equalTo("Success"))
	        .body(matchesJsonSchemaInClasspath("schema/login.json"))
	        .extract().response();
			
			
			
			
			
		}

	

}