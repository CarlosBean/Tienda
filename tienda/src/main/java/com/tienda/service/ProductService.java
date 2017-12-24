package com.tienda.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tienda.entity.Product;
import com.tienda.repository.ProductRepository;

@Service("productService")
public class ProductService {

	private static final Log LOG = LogFactory.getLog(ProductService.class);

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	public List<Product> listAllProducts() {
		LOG.info("METHOD: listAllProducts()");
		return productRepository.findAll();
	}

	public Product findProductById(Integer id) {
		LOG.info("METHOD: findProductById() -- PARAMS: " + id);
		return productRepository.findById(id);
	}

	public void removeProduct(Integer id) {
		LOG.info("METHOD: removeProduct() -- PARAMS: " + id);
		Product product = findProductById(id);
		if (product != null) {
			productRepository.delete(id);
		}
	}

	public Product addProduct(Product product) {
		LOG.info("METHOD: addProduct() -- PARAMS: " + product.toString());
		Product foundProduct = productRepository.findByProductNum(product.getProductNum());
		if (foundProduct == null) {
			productRepository.save(product);
		} else {
			LOG.error("El codigo de producto " + product.getProductNum() + " ya se encuentra registrado.");
		}
		return product;
	}
}
