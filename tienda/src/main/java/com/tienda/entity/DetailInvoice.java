package com.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_invoices")
public class DetailInvoice {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "amount", nullable = false)
	private int amount;

	@Column(name = "subtotal", nullable = false)
	private double subtotal;

	@ManyToOne(optional=false)
	@JoinColumn(name = "id_invoices", referencedColumnName = "id", nullable=false)
	private Invoice idInvoice;

	@ManyToOne(optional=false)
	@JoinColumn(name = "id_products", referencedColumnName = "id", nullable=false)
	private Product idProduct;

	public DetailInvoice() {
	};

	public DetailInvoice(Integer id, int amount, double subtotal, Invoice idInvoice, Product idProduct) {
		super();
		this.id = id;
		this.amount = amount;
		this.subtotal = subtotal;
		this.idInvoice = idInvoice;
		this.idProduct = idProduct;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Invoice getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(Invoice idInvoice) {
		this.idInvoice = idInvoice;
	}

	public Product getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Product idProduct) {
		this.idProduct = idProduct;
	}

}
