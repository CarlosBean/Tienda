package com.tienda.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {

	@Id
	@Column(name = "id", length = 15)
	private String id;

	@Column(name = "description", length = 20, nullable = false)
	private String description;

	@ManyToMany(mappedBy = "rolList")
	private List<User> userList;

	public Rol() {
	}

	public Rol(String id) {
		this.id = id;
	}

	public Rol(String id, String description, List<User> userList) {
		super();
		this.id = id;
		this.description = description;
		this.userList = userList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	};

}
