package com.savchuk.spring.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.savchuk.jsonbean.OrderElement;
import com.savchuk.model.Product;

@Component("WebSessionWrapper")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

	private static final Log log = LogFactory.getLog(Cart.class);

	private Map<Integer, OrderElement> orderElements;

	public Cart() {
		orderElements = new HashMap<>();
	}

	public void addProduct(int prodId) {
		addElement(prodId, 1);
	}

	public void addElement(int prodId, int amount) {
		OrderElement orderElement = orderElements.get(prodId);
		if (orderElement == null)
			orderElement = new OrderElement(new Product(prodId));
		
		int currAmount = orderElement.getAmount();
		orderElement.setAmount(currAmount + amount);
		
		orderElements.put(prodId, orderElement);
		log.info("Product with id: " + prodId + "   added to cart. In a amount of: " + amount);
	}

	public void removeElement(int prodId) {
		orderElements.remove(prodId);
		log.info("Product with id: " + prodId + "   removed from cart.");
	}
	
	/**
	 * Updates matching items in the input list and OrderElemnts that are present
	 * @param products
	 */
	public void updateElements(List<Product> products) {
		for (Product p : products) {
			OrderElement orderE = orderElements.get(p.getId());
			if (orderE != null)
				orderE.setProduct(p);
				
		}
	}
	
	/**
	 * Create Array List from Maps values
	 * @return
	 */
	public List<OrderElement> getOrderElements() {
		return new ArrayList<>(orderElements.values());
	}
	
	/**
	 * return keySet from Order Elements Map
	 * @return
	 */
	public Set<Integer> getElementsKeys() {
		return orderElements.keySet();
	}
	
}
