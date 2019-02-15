package com.citi.hz41382.java.proxy.md02;

import org.junit.Test;

/**
* <p>className: Client</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月28日
*/
public class Client {
	
	private Client(){
		//empty
	}
	@Test
	public static void main(String[] args) {
		GetProxy proxy = new GetProxy();
		ForumServiceImpl forumService = (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
		
		forumService.removeTopic(222);

	}

}
