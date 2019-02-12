package com.citi.hz41382.java.clone.md02;
/**
* <p>className: Address</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月31日
*/
public class Address {
	private String state;
    private String province;
    private String city;
    
    public Address(String state, String province, String city) {
        this.state = state;
        this.province = province;
        this.city = city;
    }

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
    
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("国家：" + state + ", ");
        sb.append("省：" + province + ", ");
        sb.append("市：" + city);
        return sb.toString();
    }
}
