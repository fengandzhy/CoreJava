package org.zhouhy.hz41382.java.caculator.md02.emus;


public enum BinaryOperatorsEmu {
	ADD("+"), 
	DIVOPR("÷"), 
	MULTIPLY("*"), 
	DIVISION("/"),
	MODULE("%"),
	POWER("^");
	
	private String operator;
	
	// 构造方法
    private BinaryOperatorsEmu(String operator) {
        this.operator = operator;
    }
    
    public static boolean isExists(String str){
    	boolean flag = false;
    	for(BinaryOperatorsEmu emu : BinaryOperatorsEmu.values()){
    		if(emu.getOperator().equals(str) ){
    			flag = true;
    		}   		
    	}
    	return flag;
    }
    
    public static BinaryOperatorsEmu getOperatorByStr(String str){
    	for(BinaryOperatorsEmu emu : BinaryOperatorsEmu.values()){
    		if(str.equals(emu.getOperator()) ){
    			return emu;
    		}   		
    	}
    	return null;
    }
    
    public String getOperator(){
    	return operator;
    }
}
