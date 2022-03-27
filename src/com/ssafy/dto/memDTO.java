package com.ssafy.dto;

public class memDTO {
	String id;
	String pass;
	String name;
	String phone;

	public memDTO(String id, String pass, String name, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "memDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", phone=" + phone + "]";
	}
}
