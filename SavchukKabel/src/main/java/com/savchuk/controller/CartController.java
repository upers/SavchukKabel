package com.savchuk.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.savchuk.jsonbean.AjaxMsg;
import com.savchuk.jsonbean.OrderElement;
import com.savchuk.jsonbean.LightOrderElement;
import com.savchuk.model.Product;
import com.savchuk.service.ProductService;
import com.savchuk.spring.components.Cart;

@Controller
@RequestMapping("/cart")
public class CartController {

	private static final Log log = LogFactory.getLog(CartController.class);

	@Autowired
	private ProductService productServicel;

	@Autowired
	private Cart cart;

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String testAddToCartView(ModelMap model) {
		return "add-prod-test";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public @ResponseBody AjaxMsg testAddToCartJson(ModelMap model, @RequestBody LightOrderElement form) {
		int id = form.getId();
		int amount = form.getAmount();
		AjaxMsg msg = new AjaxMsg("Products added to cart successfully");

		cart.addElement(id, amount);
		
		return msg;
	}

	@RequestMapping(value = { "/add-multiple" }, method = RequestMethod.GET)
	public String testAddMultipleOrderElement(ModelMap model) {
		return "add-multiple-prod-test";
	}

	@RequestMapping(value = { "/add-multiple" }, method = RequestMethod.POST)
	public @ResponseBody AjaxMsg addMultipleOrderElement(ModelMap model, @RequestBody LightOrderElement[] orderElements) {
		for (LightOrderElement element : orderElements) 
			cart.addElement(element.getId(), element.getAmount());
		
		return new AjaxMsg("Products added to cart successfully");
	}
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String cart(ModelMap model) {
		Set<Integer> productIds = cart.getElementsKeys();
		//select data about product from DB
		List<Product> prods = productServicel.findAndInit( productIds );
		//update element in cart
		cart.updateElements(prods);
		
		List<OrderElement> orderElements = cart.getOrderElements();
		model.addAttribute("orderElements", orderElements);
		
		return "cart";
	}

}
