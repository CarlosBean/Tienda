package com.tienda.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_types")
public class ProductType {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "description", nullable = false, length=45)
	private String description;

	@Column(name = "tax_rate", nullable = false)
	private double taxRate;

	@OneToMany(mappedBy = "idProductType")
	private List<Product> productList;

	public ProductType() {
	}

	public ProductType(Integer id, String description, double taxRate, List<Product> productList) {
		super();
		this.id = id;
		this.description = description;
		this.taxRate = taxRate;
		this.productList = productList;
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

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	};

}
