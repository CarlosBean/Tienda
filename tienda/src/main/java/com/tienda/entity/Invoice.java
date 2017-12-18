package com.tienda.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "total", nullable = false)
	private double total;

	@Column(name = "totalIva", nullable = false)
	private double totalIva;

	@ManyToOne(optional=false)
	@JoinColumn(name = "id_cashier", referencedColumnName = "id", nullable=false)
	private User idCashier;

	@ManyToOne
	@JoinColumn(name = "id_customer", referencedColumnName = "id")
	private User idCustomer;

	@OneToMany(mappedBy = "idInvoice")
	private List<DetailInvoice> detailInvoiceList;

	public Invoice() {
	}

	public Invoice(Integer id, Date date, double total, double totalIva, User idCashier, User idCustomer,
			List<DetailInvoice> detailInvoiceList) {
		super();
		this.id = id;
		this.date = date;
		this.total = total;
		this.totalIva = totalIva;
		this.idCashier = idCashier;
		this.idCustomer = idCustomer;
		this.detailInvoiceList = detailInvoiceList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalIva() {
		return totalIva;
	}

	public void setTotalIva(double totalIva) {
		this.totalIva = totalIva;
	}

	public User getIdCashier() {
		return idCashier;
	}

	public void setIdCashier(User idCashier) {
		this.idCashier = idCashier;
	}

	public User getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(User idCustomer) {
		this.idCustomer = idCustomer;
	}

	public List<DetailInvoice> getDetailInvoiceList() {
		return detailInvoiceList;
	}

	public void setDetailInvoiceList(List<DetailInvoice> detailInvoiceList) {
		this.detailInvoiceList = detailInvoiceList;
	};

}
