package com.savchuk.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.savchuk.model.Category;

@Repository("categoryDao")
public class CategoryDao extends AbstractDao<Category> {
	
	@SuppressWarnings("unchecked")
	public List<Category> findAllMainCategories() {
		return this.createEntityCriteria().add(Restrictions.isNull("parentCategory")).list();
	}
	
	public Category findByIdEager(int id) {
		Category category = findById(id);
		Hibernate.initialize(category.getChildCategories());
		Hibernate.initialize(category.getParentCategory());
		Hibernate.initialize(category.getProducts());
		return category;
	}
	
	public Category findByIdWithProducts(int id) {
		Category category = findById(id);
		Hibernate.initialize(category.getProducts());
		return category;
	}
	
	/**
	 * Find all chain of parent category and add it to the list<br>
	 * In order from junior to senior<br>
	 * If <i>category</i> is null return empty list<br>
	 * Category <i>MUST</i> have <i>persist</i> hibernate state
	 * @param category
	 * @return categories list with current category and all its chain of parent
	 */
	public List<Category> extractParentCategRecursively(Category category) {
		if (category == null)
			return new ArrayList<Category>();
		
		return extractParentCategRecursively(category, new ArrayList<Category>());
	}
	
	private List<Category> extractParentCategRecursively(Category category, List<Category> categories) {
			
		categories.add(category);
		Category parentCat = category.getParentCategory();
		if (parentCat != null )
			extractParentCategRecursively(parentCat, categories);
		
		return categories;
	}
	
}
