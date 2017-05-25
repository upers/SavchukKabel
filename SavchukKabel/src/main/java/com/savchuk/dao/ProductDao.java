package com.savchuk.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.savchuk.model.Product;

@Repository("productDao")
public class ProductDao extends AbstractDao<Product> {

	public Product findByIdEager(int id) {
		Product product = findById(id);
		Hibernate.initialize(product.getCategory());

		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> findByIds(Set<Integer> ids) {
		return createEntityCriteria().add(Restrictions.in("id", ids)).list();
	}

}
