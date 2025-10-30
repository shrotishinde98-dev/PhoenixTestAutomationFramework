package com.api.utils;

import static io.restassured.RestAssured.*;

import static com.api.constant.Role.*;

import com.api.constant.Role;
import com.pojo.user;

import io.restassured.http.ContentType;

public class AuthToken {
	private AuthToken(){
		//constructor of utility no obj crreation
	}

	public static String getToken(Role role) {
		
		user userdetails = null;
		
		
		if(role == FD) {
			userdetails =	new user("iamfd", "password");
		}
		else if (role == SUP)
		{
			userdetails =	new user("iamsup", "password");
			}
		else if (role == ENG){
			userdetails =	new user("iameng", "password");
			}
		else if (role == QC) 
		{
			userdetails =	new user("iamqc", "password");
			}
		
		
		// TODO Auto-generated method stub
		
		
 String token =      given()
       .baseUri(ConfigManager.getProperty("BASE_URI"))
       .contentType(ContentType.JSON)
       .body(userdetails)
       .when()
       .post("login")
       .then()
       .log().ifValidationFails()
       .statusCode(200)
       .extract().body().jsonPath().getString("data.token");
     
     //  System.out.println("------------------------");
       //System.out.println(token);
         return token;
       
       
       
    
	}


}
