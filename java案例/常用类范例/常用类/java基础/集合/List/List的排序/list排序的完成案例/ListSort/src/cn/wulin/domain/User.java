package cn.wulin.domain;

public class User {
	
	public User() {}
	
	public User(String username, Integer age) {
		super();
		this.username = username;
		this.age = age;
	}

	/**
	 * �û�����
	 */
	private String username; 
	
	/**
	 * �û�����
	 */
	private Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		return "username : "+username+" , age : "+age;
	}
	
	
}
