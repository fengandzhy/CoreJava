package org.zhouhy.java8.stream;
/**
* <p>className: Obj</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月21日
*/
public class Obj {
	private int id;
    private String name;    
	public Obj(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Obj [id=" + id + ", name=" + name + "]";
	}    
}
