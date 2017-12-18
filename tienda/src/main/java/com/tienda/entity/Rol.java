package com.tienda.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "description", length=10, nullable=false)
	private String description;

	@ManyToMany(mappedBy = "rolList")
	private List<User> userList;

	public Rol() {
	}

	public Rol(Integer id, String description, List<User> userList) {
		super();
		this.id = id;
		this.description = description;
		this.userList = userList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
