package com.tienda.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tienda.entity.Product;
import com.tienda.entity.ProductType;
import com.tienda.service.ProductService;
import com.tienda.service.ProductTypeService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private static final String PRODUCTS_VIEW = "products";
	private static final String PRODUCT_FORM_VIEW = "productform";
	private static final Log LOG = LogFactory.getLog(ProductController.class);

	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("productTypeService")
	private ProductTypeService productTypeService;

	@GetMapping("/showproducts")
	public ModelAndView showProducts() {
		ModelAndView mav = new ModelAndView(PRODUCTS_VIEW);
		mav.addObject("products", productService.listAllProducts());
		return mav;
	}

	@GetMapping("/removeproduct")
	public ModelAndView removeProduct(Integer id) {
		productService.removeProduct(id);
		return showProducts();
	}

	@PostMapping("/addproduct")
	public String addProduct(@ModelAttribute(name = "productModel") Product product, Model model) {
		if (productService.addProduct(product) != null) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		LOG.info("METHOD: addProduct() -- PARAMS: " + model.toString() + ", " + product.toString());
		return "redirect:/products/showproducts";
	}

	@GetMapping("/productform")
	public String redirectProductForm(@RequestParam(name = "id") Integer id, Model model) {
		Product product = new Product();
		List<ProductType> productTypesList = productTypeService.listAllProductTypes();
		if (productService.findProductById(id) != null) {
			product = productService.findProductById(id);
		}
		model.addAttribute("productTypes", productTypesList);
		model.addAttribute("productModel", product);
		LOG.info("METHOD: redirectProductForm() -- PARAMS: " + model);
		return PRODUCT_FORM_VIEW;
	}
}
