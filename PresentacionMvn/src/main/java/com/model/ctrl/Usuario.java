package com.model.ctrl;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="user")
@SessionScoped
public class Usuario {
	
	private int Id;
	private String name;
	private String password;
	private String text;
	private Boolean isValid;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
