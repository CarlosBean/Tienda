package com.tienda.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entity.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Serializable>{
	
	public abstract Product findById(Integer id);
	public abstract Product findByName(String name);
	public abstract List<Product> findAll();
}
