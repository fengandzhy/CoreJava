package com.citi.hz41382.java.model.creator.demo01.product;

import org.apache.log4j.Logger;

public class InsuranceContract {
	
	private Logger logger = Logger.getLogger(InsuranceContract.class);
	
	private String contractId;
	
	private String personName;
    //�����չ�˾������
	
	private String companyName;
    //���տ�ʼ��Ч����
	
	private long beginDate;
    //����ʧЧ���ڣ�һ������ڱ��տ�ʼ��Ч����
	
	private long endDate;
    //��������
	
	private String otherData;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(long beginDate) {
		this.beginDate = beginDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public String getOtherData() {
		return otherData;
	}

	public void setOtherData(String otherData) {
		this.otherData = otherData;
	}
	
}
