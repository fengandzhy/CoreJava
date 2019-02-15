package com.citi.hz41382.java.model.creator.demo02.builders;

import com.citi.hz41382.java.model.creator.demo02.Builder;
import com.citi.hz41382.java.model.creator.demo02.products.GoodbyeMessage;


/**
* <p>className: GoodbyeBuilder</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class GoodbyeBuilder extends Builder {

	public GoodbyeBuilder(){
        msg = new GoodbyeMessage();
    }
	
	@Override
	public void buildSubject() {
		msg.setSubject("欢送标题");
	}

	@Override
	public void buildBody() {
		msg.setBody("欢送内容");
	}

}
