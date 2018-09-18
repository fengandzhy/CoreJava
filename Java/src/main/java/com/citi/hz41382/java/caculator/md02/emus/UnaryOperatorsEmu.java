package com.citi.hz41382.java.caculator.md02.emus;

public enum UnaryOperatorsEmu {
	SIN("sin"), 
	COS("cos"), 
	TAN("tan"), 
	CTG("ctg"),
	LOG("log");
	
	private String operator;
	
	// 构造方法
    private UnaryOperatorsEmu(String operator) {
        this.operator = operator;
    }
    
    public static boolean isExists(String str){
    	boolean flag = false;
    	for(UnaryOperatorsEmu emu : UnaryOperatorsEmu.values()){
    		if(str.indexOf(emu.getOperator())!=-1 ){
    			flag = true;
    		}   		
    	}
    	return flag;
    }
    
    public static UnaryOperatorsEmu getOperator(String str){
    	for(UnaryOperatorsEmu emu : UnaryOperatorsEmu.values()){
    		if(str.indexOf(emu.getOperator())!=-1 ){
    			return emu;
    		}   		
    	}
    	return null;
    }
    
    public String getOperator(){
    	return operator;
    }
}
