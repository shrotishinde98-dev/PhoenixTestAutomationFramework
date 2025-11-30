package com.database.dao;

import java.util.ArrayList;
import java.util.List;

import com.api.utils.CreateJobBeanMapper;
import com.dataproviders.api.bean.CreateJobBean;
import com.pojo.CreateJobPayload;

public class DaoDemoRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	List<CreateJobBean> beanList=CreateJobPayloadDataDao.getCreateJobPayloadData();;

	List<CreateJobPayload>  payloadList = new ArrayList<CreateJobPayload>();  //limit 4
	for (CreateJobBean createJobBean : beanList) {
		CreateJobPayload payload=CreateJobBeanMapper.mapper(createJobBean);
		payloadList.add(payload);
		
		
	}
	
	System.out.println("------------------------------------");
	for (CreateJobPayload  payload: payloadList) {
		System.out.println(payload);
	}
	}

}
