package com.savchuk.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.savchuk.model.Category;

@Repository("categoryDao")
public class CategoryDao extends AbstractDao<Category> {
	
	@SuppressWarnings("unchecked")
	public List<Category> findAllMainCategories() {
		return this.createEntityCriteria().add(Restrictions.isNull("parentCategory")).list();
	}
	
}
