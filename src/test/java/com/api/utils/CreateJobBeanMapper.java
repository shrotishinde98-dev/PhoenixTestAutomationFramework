package com.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.dataproviders.api.bean.CreateJobBean;
import com.pojo.CreateJobPayload;
import com.pojo.Customer;
import com.pojo.Customer_address;
import com.pojo.Customer_product;
import com.pojo.Problems;

public class CreateJobBeanMapper {
	//uitility class
	//bean will create the payload
  private CreateJobBeanMapper() {
	  
	  
  }
  public static CreateJobPayload mapper(CreateJobBean  bean) {
	  //Bean---createjobpayload object
	int  mst_service_location_Id=Integer.parseInt( bean.getMst_service_location_id());
	int  mst_platform_Id=Integer.parseInt( bean.getMst_platform_id());
	int  mst_warrenty_status_Id=Integer.parseInt( bean.getMst_warrenty_status_id());
	int  mst_oem_Id=Integer.parseInt( bean.getMst_oem_id());
	
	Customer customer= new Customer(bean.getCustomer__first_name(),
			bean.getCustomer__last_name(), 
			bean.getCustomer__mobile_number(), 
			bean.getCustomer__mobile_number_alt(), 
			bean.getCustomer__email_id(), 
			bean.getCustomer__email_id_alt());
	
	Customer_address  customerAddress = new Customer_address(bean.getCustomer_address__flat_number(), 
			bean.getCustomer_address__apartment_name(), 
			bean.getCustomer_address__street_name(), 
			bean.getCustomer_address__landmark(), 
			bean.getCustomer_address__area(), 
            bean.getCustomer_address__pincode(),
            bean.getCustomer_address__country(), 
            bean.getCustomer_address__state());
	
	int productId= Integer.parseInt(bean.getCustomer_product__product_id());//integer to string
	   int modeId= Integer.parseInt(bean.getCustomer_product__mst_model_id());
	
	Customer_product customerProduct = new Customer_product(bean.getCustomer_product__dop(),bean.getCustomer_product__serial_number(), bean.getCustomer_product__imei1(),bean.getCustomer_product__imei2(), bean.getCustomer_product__popurl(), productId, modeId);
        List<Problems> problemList = new ArrayList<Problems>();
           int problemId= Integer.parseInt(bean.getProblems__id());
        Problems problem= new Problems(problemId, bean.getProblems__remark());
        problemList.add(problem);
        
        
 
	     
      
	  CreateJobPayload payload = new CreateJobPayload(mst_service_location_Id, mst_platform_Id, mst_warrenty_status_Id, mst_oem_Id, 
			  customer, 
			  customerAddress, 
			  customerProduct, 
			  problemList);
     return payload;
  }
}
