package com.savchuk.service;

import java.util.Collections;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.savchuk.dao.CategoryDao;
import com.savchuk.dao.ProductDao;
import com.savchuk.model.Category;
import com.savchuk.model.Product;
import com.savchuk.util.PropertiesCopier;

@Service("productService")
@Transactional
public class ProductService {
	
	@Autowired
	private ProductDao prodDAO;
	
	@Autowired
	private CategoryDao categDAO;
	
	@Autowired
	private PropertiesCopier propertiesCopier;
	
	public Product findById(int id) {
		return prodDAO.findById(id);
	}
	
	public List<Product> findAllProducts() {
  		List<Product> categories = prodDAO.findAll();
		return categories;
	}

	public void saveProduct(Product product) {
		prodDAO.persist(product);
	}
	
	public Product findbyIdEager(int id) {
		return prodDAO.findByIdEager(id);
	}
	
	public Product findAndInit(int id) {
		Product product = prodDAO.findById(id);
		Category category = product.getCategory();
		Hibernate.initialize(category);
		prodDAO.evict(product);
		
		//Get all chain of categories
		List<Category> categoriesChain = categDAO.extractParentCategRecursively(category);
		
		//Copy properties to product from category if category properties is NULL 
		String [] ignoredProperties = {"id", "category"};
		for (Category c : categoriesChain) {
			propertiesCopier.copyNotNullProperties(c, product, ignoredProperties);
		}
		
		return product;
	}
	
}
