package com.citi.hz41382.java.model.creator.demo01.product;

import org.apache.log4j.Logger;

public class InsuranceContract {
	
	private Logger logger = Logger.getLogger(InsuranceContract.class);
	
	private String contractId;
	
	private String personName;
    //被保险公司的名称
	
	private String companyName;
    //保险开始生效日期
	
	private long beginDate;
    //保险失效日期，一定会大于保险开始生效日期
	
	private long endDate;
    //其他数据
	
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
