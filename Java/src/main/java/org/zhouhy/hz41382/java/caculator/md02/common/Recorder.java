package org.zhouhy.hz41382.java.caculator.md02.common;

import java.util.ArrayList;
import java.util.List;

public class Recorder {
	private List<String> list;
	private boolean isExistDot;	
	private int bracketLevel =0;
	
	public Recorder(){
		this.list = new ArrayList<>();
	}
	
	public void push(String item){		
		list.add(item);
	}
	
	public String pop(){
		if(!list.isEmpty()){
			String item = list.get(list.size()-1);
			list.remove(list.size()-1);
			return item;
		}		
		return null;
	}
	
	public List<String> getList(){
		return list;
	}
	
	public boolean isEmpty(){
		if(list.isEmpty()){
			return true;
		}
		return false;
	}
	
	public int size(){
		return list.size();
	}
	
	public void removeAll(){
		while(!list.isEmpty()){
			list.remove(0);
		}
	}
	
	public void addBracketLevel(){
		bracketLevel ++;
	}
	
	public void substractBracketLevel(){
		bracketLevel --;
	}
	
	public boolean isBracketClosed(){
		if(bracketLevel ==0){
			return true;
		}
		return false;
	}
	
	public boolean isExistDot() {
		return isExistDot;
	}

	public void setExistDot(boolean isExistDot) {
		this.isExistDot = isExistDot;
	}
}
