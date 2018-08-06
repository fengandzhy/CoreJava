package com.citi.hz41382.java.model.creator.demo01.builder;

import com.citi.hz41382.java.model.creator.demo01.product.InsuranceContract;

public class ConcreteBuilder implements Builder{
	
	private InsuranceContract myContract = new InsuranceContract(); 
	
	@Override
	public InsuranceContract build() {		
		return myContract;
	}
	
	public void buildContractId(String contractId){
		this.myContract.setContractId(contractId);
	}
	
	public void buildPersonName(String personName){
		this.myContract.setPersonName(personName);
	}
	
	public void buildCompanyName(String companyName){
		this.myContract.setCompanyName(companyName);
	}
	
	

}
