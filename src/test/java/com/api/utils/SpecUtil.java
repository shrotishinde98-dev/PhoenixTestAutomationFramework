package com.api.utils;


import org.hamcrest.Matchers;

import com.api.constant.Role;
import com.api.utils.ConfigManager;
import com.pojo.user;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class SpecUtil {
	//POST-
	
  //static block
	
	public static RequestSpecification requestSpec() {
		
		RequestSpecification request =	 new RequestSpecBuilder()
				  .setBaseUri(ConfigManager.getProperty("BASE_URI"))
				  .setContentType(ContentType.JSON)
				  .setAccept(ContentType.JSON)
				  .log(LogDetail.URI)
				  .log(LogDetail.METHOD)
				  .log(LogDetail.HEADERS)
				  .log(LogDetail.BODY)
				  .build();
		           return request;	      
			}
	
	
	
public static RequestSpecification  AuthrequestSpec(Role role) {    
		
		RequestSpecification requesta=	 new RequestSpecBuilder()
				  .setBaseUri(ConfigManager.getProperty("BASE_URI"))
				  .setContentType(ContentType.JSON)
				  .setAccept(ContentType.JSON)
				  .addHeader("Authorization",AuthToken.getToken(role))
				  .log(LogDetail.URI)
				  .log(LogDetail.METHOD)
				  .log(LogDetail.HEADERS)
				  .log(LogDetail.BODY)
				  .build();
		           return requesta;   
			}
public static RequestSpecification  AuthrequestSpec(Role role,Object Payload) {    
	//set payload for create job method overloading
	RequestSpecification requesta=	 new RequestSpecBuilder()
			  .setBaseUri(ConfigManager.getProperty("BASE_URI"))
			  .setContentType(ContentType.JSON)
			  .setAccept(ContentType.JSON)
			  .addHeader("Authorization",AuthToken.getToken(role))
			  .setBody(Payload)
			  .log(LogDetail.URI)
			  .log(LogDetail.METHOD)
			  .log(LogDetail.HEADERS)
			  .log(LogDetail.BODY)
			  .build();
	           return requesta;   
		}

	
	//POST-PUT-PATCH //user u--object payload
	public static RequestSpecification requestSpec(user u) {
		
RequestSpecification request =	 new RequestSpecBuilder()
		  .setBaseUri(ConfigManager.getProperty("BASE_URI"))
		  .setContentType(ContentType.JSON)
		  .setAccept(ContentType.JSON)
          .setBody(u)
		  .log(LogDetail.URI)
		  .log(LogDetail.METHOD)
		  .log(LogDetail.HEADERS)
		  .log(LogDetail.BODY)
		  .build();
           return request;

 
		
		   
		      
	}
	public static  ResponseSpecification responseSpec() {
	      
ResponseSpecification response = new ResponseSpecBuilder()
                   .expectContentType(ContentType.JSON)
                   .expectStatusCode(200)
                   .expectResponseTime(Matchers.lessThan(4000L))
                   .log(LogDetail.ALL)
                   .build();
     return response;
}

  //response 
	
}