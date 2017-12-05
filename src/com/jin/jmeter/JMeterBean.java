package com.jin.jmeter;

/**
 * @describe jmeterBean
 * @author 锦锦金
 * @date 2017年12月4日
 */
public class JMeterBean {

	private String name;
	private String friend;

	public JMeterBean(String name) {
		this(name, null);
	}
	
	public JMeterBean(String name, String friend) {
		this.name = name;
		this.friend = friend;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFriend() {
		return friend;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}
}
