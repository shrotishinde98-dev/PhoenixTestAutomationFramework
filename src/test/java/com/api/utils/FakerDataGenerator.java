package com.api.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import com.pojo.CreateJobPayload;
import com.pojo.Customer;
import com.pojo.Customer_address;
import com.pojo.Customer_product;
import com.pojo.Problems;

public class FakerDataGenerator {
	private static Faker faker = new Faker(new Locale("en-IND"));
	private final static String COUNTRY="India"  ; 
	private final static Random RANDOM = new Random();
	private final static int MST_SERVICE_LOCATION_ID=0;
	private final static int MST_PLATFORM_ID=2;
	private final static int MST_WARR_STATUS_ID=1;
	private final static int MST_OEM_ID=1;
	private final static int PRODUCT_ID=1;
	private final static int MST_MODEL_ID=1;
	
	private final static int validProblemsId[]= {1,2,3,4,5,6,7,8,9,10,11,12,15,16,17,19,20,22,24,26,27,28,29};
	//util class 
	
	private FakerDataGenerator() {
		//constructor
	}
	
	public static CreateJobPayload generateFakeCraeteJobData() {
		
		Customer customer =  generateFakeCustomerData();
		Customer_address customerAddress = generateFakeCustomerAddressData();
		Customer_product customer_product = generateFakeCustomerProduct();
		List<Problems> ProblemsList = generateFakeProblemsList();
		
		CreateJobPayload payload = new CreateJobPayload(MST_SERVICE_LOCATION_ID, MST_PLATFORM_ID, MST_WARR_STATUS_ID, MST_OEM_ID, customer, customerAddress, customer_product, ProblemsList);
		System.out.println(payload);
		return payload;
	}

	//to create 100 bject//iterator which created to provide for DataProvider
      public static Iterator<CreateJobPayload> generateFakeCraeteJobData(int count) {
		List<CreateJobPayload> payloadList= new ArrayList<CreateJobPayload>();
		for (int i=1; i<=count;i++) {
		Customer customer =  generateFakeCustomerData();
		Customer_address customerAddress = generateFakeCustomerAddressData();
		Customer_product customer_product = generateFakeCustomerProduct();
		List<Problems> ProblemsList = generateFakeProblemsList();
		
		CreateJobPayload payload = new CreateJobPayload(MST_SERVICE_LOCATION_ID, MST_PLATFORM_ID, MST_WARR_STATUS_ID, MST_OEM_ID, customer, customerAddress, customer_product, ProblemsList);
		payloadList.add(payload);
		}
		return payloadList.iterator();
	}



	private static List<Problems> generateFakeProblemsList() {
		// TODO Auto-generated method stub
		//I want to generate random no 1 to 27
			
		int randomIndex =RANDOM.nextInt(validProblemsId.length);
		String fakeRemark = faker.lorem().sentence(2);

		Problems problems = new Problems(validProblemsId[randomIndex], fakeRemark);
	

	List<Problems> problemList = new ArrayList<Problems>();
		problemList.add(problems);
		//System.out.println(problemList);
		return problemList;
	}

	private static Customer_product generateFakeCustomerProduct() {
		// TODO Auto-generated method stub
		String dop =DateTimeUtil.getTimewithDaysAgo(10);
		String imeiserialNumber = faker.numerify("###############");
		String popUrl= faker.internet().url();
		Customer_product   customer_product = new Customer_product(dop, imeiserialNumber, imeiserialNumber, imeiserialNumber, popUrl, PRODUCT_ID, MST_MODEL_ID);
		//System.out.println(customer_product);
		return customer_product;
	}

	private static Customer_address generateFakeCustomerAddressData() {
		// TODO Auto-generated method stub
		String FlatNumber= faker.numerify("###");
		String apartmentName= faker.address().streetName();
		String streetName= faker.address().streetName();
		String landmark=faker.address().streetName();
		String area= faker.address().streetAddress();
		String pincode=faker.numerify("#####");
	   //  String country ="India"   ;
		String state= faker.address().state();
		
		Customer_address customerAddress= new Customer_address(FlatNumber, apartmentName, streetName, landmark, area, pincode, COUNTRY, state);
		//System.out.println(customerAddress);
		
		return customerAddress;
	}

	private static Customer generateFakeCustomerData() {
		// TODO Auto-generated method stub
		Faker faker = new Faker(new Locale("en-IND"));
		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		String mobileNumber = faker.numerify("70########");
		String alternatemobileNumber = faker.numerify("70########");
		String customerEmailAddress = faker.internet().emailAddress();
		String altcustomerEmailAddress = faker.internet().emailAddress();

		Customer customer = new Customer(fname, lname, mobileNumber, alternatemobileNumber, customerEmailAddress,altcustomerEmailAddress);
		//System.out.println(customer);
		return  customer;

		
		
	}
	
	
}
