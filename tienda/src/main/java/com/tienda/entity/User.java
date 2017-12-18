package com.tienda.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "document_num", nullable = false, unique = true)
	private String documentNum;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "telephone", nullable = false)
	private String telephone;

	@OneToMany(mappedBy = "idCashier")
	private List<Invoice> invoiceCashierList;

	@OneToMany(mappedBy = "idCustomer")
	private List<Invoice> invoiceCustomerList;

	@JoinTable(name = "users_has_roles", joinColumns = {
			@JoinColumn(name = "id_users", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_roles", referencedColumnName = "id") })
	@ManyToMany
	private List<Rol> rolList;

	public User() {
	}

	public User(Integer id, String documentNum, String firstName, String lastName, String telephone,
			List<Invoice> invoiceCashierList, List<Invoice> invoiceCustomerList, List<Rol> rolList) {
		super();
		this.id = id;
		this.documentNum = documentNum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.invoiceCashierList = invoiceCashierList;
		this.invoiceCustomerList = invoiceCustomerList;
		this.rolList = rolList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumentNum() {
		return documentNum;
	}

	public void setDocumentNum(String documentNum) {
		this.documentNum = documentNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Invoice> getInvoiceCashierList() {
		return invoiceCashierList;
	}

	public void setInvoiceCashierList(List<Invoice> invoiceCashierList) {
		this.invoiceCashierList = invoiceCashierList;
	}

	public List<Invoice> getInvoiceCustomerList() {
		return invoiceCustomerList;
	}

	public void setInvoiceCustomerList(List<Invoice> invoiceCustomerList) {
		this.invoiceCustomerList = invoiceCustomerList;
	}

	public List<Rol> getRolList() {
		return rolList;
	}

	public void setRolList(List<Rol> rolList) {
		this.rolList = rolList;
	};

}
