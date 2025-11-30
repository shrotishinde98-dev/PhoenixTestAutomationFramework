package com.dataproviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.utils.CSVReaderUtil;
import com.api.utils.CreateJobBeanMapper;
import com.api.utils.ExcelReaderUtil2;
import com.api.utils.FakerDataGenerator;
import com.database.dao.CreateJobPayloadDataDao;
import com.dataproviders.api.bean.CreateJobBean;
import com.dataproviders.api.bean.UserBean;
import com.pojo.CreateJobPayload;
import com.pojo.user;

public class DataProviderUtils {
	@DataProvider(name = "LoginAPIDataProvider", parallel =true)
	public static Iterator<UserBean> LoginAPIDataProvider() {
	return	CSVReaderUtil.loadCSV("testData/LoginCred.csv",UserBean.class);
		//IF not given name to data provider then the name of dataprovider is method name
	}
    //data provider return data [] ,[] [] array ,iterator
	
	
	
	
	@DataProvider(name = "CraeteJobAPIDataprovider",parallel=true)
  public static Iterator<CreateJobPayload> createJobDataProvider() {
	  
		Iterator<CreateJobBean> createJobBeanIterator = CSVReaderUtil.loadCSV("testData/CreateJobData.csv",
				CreateJobBean.class);

		List<CreateJobPayload> payloadList = new ArrayList<CreateJobPayload>();
		CreateJobBean tempBean;

		CreateJobPayload tempPayload;
		while (createJobBeanIterator.hasNext()) {
			tempBean = createJobBeanIterator.next();
			tempPayload = CreateJobBeanMapper.mapper(tempBean);
			payloadList.add(tempPayload);

		}
		return payloadList.iterator();
	}
	
	@DataProvider(name = "CraeteJobAPIFakeDataprovider",parallel=true)
	  public static Iterator<CreateJobPayload> createJobFakeDataProvider() {
		Iterator<CreateJobPayload> payloadIterator=FakerDataGenerator.generateFakeCraeteJobData(3);
		return payloadIterator;
		
		
	}
	
	@DataProvider(name = "LoginAPIExcelDataProvider", parallel =true)
	public static Iterator<UserBean> LoginAPIExcelDataProvider() {
      return ExcelReaderUtil2.loadTestData("testData/PhoenixTestData.xlsx","LoginTestData", UserBean.class);
		//loginof excel
	}
	
	@DataProvider(name = "CraeteJobAPIExcelDataprovider",parallel=true)
	  public static Iterator<CreateJobPayload> CraeteJobAPIExcelDataprovider() {
		Iterator<CreateJobBean> iterator = ExcelReaderUtil2.loadTestData("testData\\PhoenixTestData.xlsx", "CreateJobTestData", CreateJobBean.class);


			List<CreateJobPayload> payloadList = new ArrayList<CreateJobPayload>();
			CreateJobBean tempBean;

			CreateJobPayload tempPayload;
			while (iterator.hasNext()) {
				tempBean = iterator.next();
				tempPayload = CreateJobBeanMapper.mapper(tempBean);
				payloadList.add(tempPayload);

			}
			return payloadList.iterator();
		}

	
	@DataProvider(name = "CraeteJobAPIDBDataprovider",parallel=true)
	  public static Iterator<CreateJobPayload> CraeteJobAPIDBDataprovider() {
		
		List<CreateJobBean> beanList=CreateJobPayloadDataDao.getCreateJobPayloadData();;

		List<CreateJobPayload>  payloadList = new ArrayList<CreateJobPayload>();  //limit 4
		for (CreateJobBean createJobBean : beanList) {
			CreateJobPayload payload=CreateJobBeanMapper.mapper(createJobBean);
			payloadList.add(payload);
			
			
		}
		   return payloadList.iterator();
		
		}
	
}
