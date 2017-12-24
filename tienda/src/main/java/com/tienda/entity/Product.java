package com.tienda.entity;

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
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="product_num", unique=true, length=10)
	private String productNum;

	@Column(name = "name", nullable = false, length=45)
	private String name;

	@Column(name = "base_price", nullable = false)
	private double basePrice;

	@Column(name = "stock", nullable = false)
	private int stock;

	@Column(name = "min_amount", nullable = false)
	private int minAmount;

	@ManyToOne
	@JoinColumn(name = "id_product_types", referencedColumnName = "id")
	private ProductType idProductType;

	@OneToMany(mappedBy = "idProduct")
	private List<DetailInvoice> detailInvoiceList;

	public Product() {
	}

	public Product(Integer id, String name, String productNum, double basePrice, int stock, int minAmount, ProductType idProductType,
			List<DetailInvoice> detailInvoiceList) {
		super();
		this.id = id;
		this.name = name;
		this.productNum = productNum;
		this.basePrice = basePrice;
		this.stock = stock;
		this.minAmount = minAmount;
		this.idProductType = idProductType;
		this.detailInvoiceList = detailInvoiceList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public ProductType getIdProductType() {
		return idProductType;
	}

	public void setIdProductType(ProductType idProductType) {
		this.idProductType = idProductType;
	}

	public List<DetailInvoice> getDetailInvoiceList() {
		return detailInvoiceList;
	}

	public void setDetailInvoiceList(List<DetailInvoice> detailInvoiceList) {
		this.detailInvoiceList = detailInvoiceList;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productNum=" + productNum + ", name=" + name + ", basePrice=" + basePrice
				+ ", stock=" + stock + ", minAmount=" + minAmount + ", idProductType=" + idProductType + "]";
	}
}
