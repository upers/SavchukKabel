package com.savchuk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.savchuk.dao.CategoryDao;
import com.savchuk.model.Category;

@Service("categoryService")
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDao dao;
	
	public Category findById(int id) {
		return dao.getById(id);
	}
	
	public List<Category> findAllCategories() {
  		List<Category> categories = dao.findAll();
		return categories;
	}

	public void saveCategory(Category category) {
		dao.persist(category);
	}
	
	public List<Category> findAllMainCategories() {
  		List<Category> categories = dao.findAllMainCategories();
		return categories;
	} 
	
}
