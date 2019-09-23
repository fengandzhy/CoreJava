package org.zhouhy.hz41382.java.model.creator.demo02.builders;

import org.zhouhy.hz41382.java.model.creator.demo02.Builder;
import org.zhouhy.hz41382.java.model.creator.demo02.products.WelcomeMessage;

/**
* <p>className: WelcomeBuilder</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class WelcomeBuilder extends Builder {

	public WelcomeBuilder(){
        msg = new WelcomeMessage();
    }
	
	@Override
	public void buildSubject() {
		msg.setSubject("欢迎标题");
		
	}

	@Override
	public void buildBody() {
		msg.setBody("欢迎内容");		
	}

}
