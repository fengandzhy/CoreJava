package com.citi.hz41382.java.model.creator.demo02.director;

import com.citi.hz41382.java.model.creator.demo02.AutoMessage;
import com.citi.hz41382.java.model.creator.demo02.Builder;

/**
* <p>className: Director</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class Director {
	private Builder builder;
	
	public Director(Builder builder){
		this.builder = builder;
	}
	
	public AutoMessage getMessage(String toAddress , String fromAddress){
		construct(toAddress,fromAddress);
		return builder.getMessage();
	}
	
	private void construct(String toAddress , String fromAddress){
		this.builder.buildTo(toAddress);
        this.builder.buildFrom(fromAddress);
        this.builder.buildSubject();
        this.builder.buildBody();
        this.builder.buildSendDate();
        this.builder.sendMessage();
	}
	
	
}
