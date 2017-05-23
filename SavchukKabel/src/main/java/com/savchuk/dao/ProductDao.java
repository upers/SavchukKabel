package com.savchuk.dao;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.savchuk.model.Product;

@Repository("productDao")
public class ProductDao extends AbstractDao<Product> {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public Product findByIdEager(int id) {
		Product product = findById(id);
		Hibernate.initialize(product.getCategory());
		
		return product;
	}
	
}
