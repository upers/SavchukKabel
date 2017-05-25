package com.savchuk.controller;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.savchuk.jsonbean.ProductFormAddition;
import com.savchuk.annotations.PrintRequest;
import com.savchuk.beans.WebSessionWrapper;
import com.savchuk.jsonbean.AjaxMsg;

@Controller
@RequestMapping("/cart")
public class CartController {

	private static final Log log = LogFactory.getLog(CartController.class);
	
	@Autowired
	private WebSessionWrapper webSession;
	
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String testAddToCartView(ModelMap model) {
		return "add-prod-test";
	}

	@PrintRequest
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public @ResponseBody AjaxMsg testAddToCartJson(ModelMap model, @RequestBody ProductFormAddition form) {
		int id = form.getId();
		int amount = form.getAmount();
		AjaxMsg msg = new AjaxMsg("Products added to cart successfully");
		
		webSession.addProduct(id, amount);
		printCartContent();
		return msg;
	}
	
	@RequestMapping(value = { "/add-multiple" }, method = RequestMethod.GET)
	public String testAddManyToCartView(ModelMap model) {
		return "add-multiple-prod-test";
	}
	
	@PrintRequest
	@RequestMapping(value = { "/add-multiple" }, method = RequestMethod.POST)
	public @ResponseBody AjaxMsg testAddMultipleProdToCart(ModelMap model, @RequestBody ProductFormAddition[] forms) {
		log.info(forms);
		for (ProductFormAddition singleForm : forms) {
			int id = singleForm.getId();
			int amount = singleForm.getAmount();
			webSession.addProduct(id, amount);
		}
		printCartContent();
		AjaxMsg msg = new AjaxMsg("Products added to cart successfully");
		return msg;
	}
	
	
	private void printCartContent() {
		log.info("-------------Cart content------------");
		Map<Integer, Integer> cartContent = webSession.getCartContent();
		for (Integer prodId : cartContent.keySet()) {
			log.info("Product id: " + prodId + "    amount: " + cartContent.get(prodId));
		}
		log.info("-------------------------------------");
	}

}
