package org.zhouhy.hz41382.java.model.sigleton;

/**
 * Lazy��thread safe, if there is no volatile it is still a bit problematic. 
 * when jvm running singleton2 = new Singleton2(); three steps will be done
 * 1. allocate memory to singleton2
 * 2. call the constructor to initialize member variables
 * 3. point the singleton2 object to the memory allocated in step1.
 * However, the sequence of last two step in these three step cannot be guaranteed 
 * sometime step 3 will be run before step 2. if this situation occur and at the same 
 * time there is a thread is ruuning singleton2==null, it will get false but at this time
 * the singleton is really null. 
 * author: zhy 
 * date : 20171128
 * target: studing singleton model
 * */
public class Singleton2 {
	private volatile static Singleton2 singleton2;
	
	private Singleton2(){
		
	}
	
	public static Singleton2 getInstance(){
		if(singleton2==null){
			synchronized(Singleton2.class){
				if(singleton2==null){ //check second time 
					singleton2 = new Singleton2();
				}
			}
		}		
		return singleton2;
	}
}
