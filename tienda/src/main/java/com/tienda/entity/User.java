package com.tienda.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@Column(name = "document_num", nullable = false, unique = true, length = 20)
	private String documentNum;

	@Column(name = "password", nullable = true, length = 100)
	private String password;

	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 45)
	private String lastName;

	@Column(name = "telephone", nullable = false, length = 20)
	private String telephone;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@OneToMany(mappedBy = "idCashier")
	private List<Invoice> invoiceCashierList;

	@OneToMany(mappedBy = "idCustomer")
	private List<Invoice> invoiceCustomerList;

	@JoinTable(name = "users_has_roles", joinColumns = {
			@JoinColumn(name = "id_users", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_roles", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Rol> rolList;

	public User() {
	}

	public User(Integer id, String documentNum, String password, String firstName, String lastName, String telephone,
			boolean enabled, List<Invoice> invoiceCashierList, List<Invoice> invoiceCustomerList, List<Rol> rolList) {
		super();
		this.id = id;
		this.documentNum = documentNum;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.enabled = enabled;
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
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [documentNum=" + documentNum + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", telephone=" + telephone + ", enabled=" + enabled + "]";
	}

}
