package com.savchuk.beans;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("WebSessionWrapper")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WebSessionWrapper {

	private static final Log log = LogFactory.getLog(WebSessionWrapper.class);

	private Map<Integer, Integer> productsInCart;

	public WebSessionWrapper() {
		productsInCart = new HashMap<>();
	}

	public void addProduct(int prodId) {
		addProduct(prodId, 1);
	}

	public void addProduct(int prodId, int amount) {
		Integer curAmount = productsInCart.get(prodId);
		if (curAmount == null)
			curAmount = 0;

		productsInCart.put(prodId, curAmount + amount);
		log.info("Product with id: " + prodId + "   added to cart. In a amount of: " + amount);
	}

	public void removeProduct(int prodId) {
		productsInCart.remove(prodId);
		log.info("Product with id: " + prodId + "   removed from cart.");
	}

	/**
	 * key is <i>productId</i> value is <i>Amount</i>
	 * 
	 * @return Map<Integer, Integer>
	 */
	public Map<Integer, Integer> getCartContent() {
		return productsInCart;
	}

}
