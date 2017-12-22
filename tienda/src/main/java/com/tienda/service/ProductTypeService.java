package com.tienda.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tienda.entity.ProductType;
import com.tienda.repository.ProductTypeRepository;

@Service("productTypeService")
public class ProductTypeService {
	
	private static final Log LOG = LogFactory.getLog(ProductTypeService.class);
	
	@Autowired
	@Qualifier("productTypeRepository")
	private ProductTypeRepository productTypeRepository;
	
	public List<ProductType> listAllProductTypes(){
		LOG.info("METHOD: listAllProductTypes()");
		return productTypeRepository.findAll();
	}
	
	public ProductType findProductTypeById(Integer id) {
		LOG.info("METHOD: findProducTypeById -- PARAMS: " + id);
		return productTypeRepository.findById(id);
	}
	
}
