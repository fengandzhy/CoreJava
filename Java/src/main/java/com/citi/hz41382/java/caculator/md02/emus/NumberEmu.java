package com.citi.hz41382.java.caculator.md02.emus;

public enum NumberEmu {
	ZERO("0"), 
	ONE("1"), 
	TWO("2"), 
	THREE("3"),
	FOUR("4"),
	FIVE("5"), 
	SIX("6"), 
	SEVEN("7"), 
	EIGHT("8"),	
	NINE("9");
	
	private String operator;
	
	// 构造方法
    private NumberEmu(String operator) {
        this.operator = operator;
    }
    
    public static boolean isExists(String str){
    	boolean flag = false;
    	for(NumberEmu emu : NumberEmu.values()){
    		if(str.indexOf(emu.getOperator())!=-1 ){
    			flag = true;
    		}   		
    	}
    	return flag;
    }
    
    public static NumberEmu getOperator(String str){
    	for(NumberEmu emu : NumberEmu.values()){
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
