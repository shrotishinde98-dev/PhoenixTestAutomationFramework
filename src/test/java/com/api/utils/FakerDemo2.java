package com.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import com.pojo.CreateJobPayload;
import com.pojo.Customer;
import com.pojo.Customer_address;
import com.pojo.Customer_product;
import com.pojo.Problems;

public class FakerDemo2 {

	private final static String COUNTRY="India"  ; //var for country
	public static void main(String[] args) {
		// Fake data for CreateJOBAPI 
	
		
		Faker faker = new Faker(new Locale("en-IND"));
		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		String mobileNumber = faker.numerify("70########");
		String alternatemobileNumber = faker.numerify("70########");
		String customerEmailAddress = faker.internet().emailAddress();
		String altcustomerEmailAddress = faker.internet().emailAddress();

		Customer customer = new Customer(fname, lname, mobileNumber, alternatemobileNumber, customerEmailAddress,
				altcustomerEmailAddress);
		System.out.println(customer);

		String FlatNumber= faker.numerify("###");
		String apartmentName= faker.address().streetName();
		String streetName= faker.address().streetName();
		String landmark=faker.address().streetName();
		String area= faker.address().streetAddress();
		String pincode=faker.numerify("#####");
	   //  String country ="India"   ;
		String state= faker.address().state();
		
		Customer_address customerAddress= new Customer_address(FlatNumber, apartmentName, streetName, landmark, area, pincode, COUNTRY, state);
		System.out.println(customerAddress);
		
		String dop =DateTimeUtil.getTimewithDaysAgo(10);
			String imeiserialNumber = faker.numerify("###############");
			String popUrl= faker.internet().url();
			Customer_product   customer_product = new Customer_product(dop, imeiserialNumber, imeiserialNumber, imeiserialNumber, popUrl, 1, 1);

		System.out.println(customer_product);
		
	
		
		String fakeRemark= faker.lorem().sentence(4);
	//I want to generate random no 1 to 27
		Random random = new Random();
		int problemId=random.nextInt(26)+1;
		
		Problems problems= new Problems(problemId, fakeRemark);
		System.out.println(problems);
		
     List<Problems>  problemList = new ArrayList<Problems>();
		problemList.add(problems);
		
		
		CreateJobPayload payload = new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customer_product, problemList);
		System.out.println();
		
	  
		
		

	}


}
