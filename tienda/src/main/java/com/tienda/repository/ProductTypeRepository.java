package com.tienda.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entity.ProductType;

@Repository("productTypeRepository")
public interface ProductTypeRepository extends JpaRepository<ProductType, Serializable>{
	
	public abstract List<ProductType> findAll();
	public abstract ProductType findById(Integer id);
}
