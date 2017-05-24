package com.savchuk.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.savchuk.jsonbean.AddCart;
import com.savchuk.model.Product;
import com.savchuk.service.CategoryService;
import com.savchuk.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	private static final Log log = LogFactory.getLog(CartController.class);
	
	@Autowired
	CategoryService categService;

	@Autowired
	ProductService productService;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/add"}, method = RequestMethod.GET)
	public String testAddToCartView(ModelMap model) {
		log.info("-=-=-=-=-=-==-=-=-==-===-");
		return "add-to-cart-test";
	}
	
	@RequestMapping(value = { "/add"}, method = RequestMethod.POST)
	public String testAddToCart(ModelMap model, @RequestBody AddCart product) {
		int id = product.getId();
		System.out.println("id: " + id);
		return "add-to-cart-test";
	}
	
}
