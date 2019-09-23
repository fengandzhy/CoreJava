package org.zhouhy.java8.lambda;
/**
* <p>className: Address</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月24日
*/
public class Address {
	private String province;
	private String city;
	private String street;
	
	
	public Address(String province, String city, String street) {
		super();
		this.province = province;
		this.city = city;
		this.street = street;
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city + ", street=" + street + "]";
	}
	
}
