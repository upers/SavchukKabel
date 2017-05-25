package com.savchuk.jsonbean;

import com.savchuk.model.Product;

public class OrderElement {
	private Product product;

	private int amount;
	
	public OrderElement() {}
	
	public OrderElement(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
