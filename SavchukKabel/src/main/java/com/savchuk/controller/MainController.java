package com.savchuk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.savchuk.model.Category;
import com.savchuk.model.Product;
import com.savchuk.service.CategoryService;
import com.savchuk.service.ProductService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	CategoryService categService;

	@Autowired
	ProductService productService;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listCategories(ModelMap model) {
		List<Category> categories = categService.findAllMainCategories();
		model.addAttribute("categories", categories);
		return "categories";
	}

	@RequestMapping(value = { "/category/{categId}" }, method = RequestMethod.GET)
	public String listProductsByCategoryId(ModelMap model, @PathVariable Integer categId) {
		Category category = categService.findByIdEager(categId);
		List<Category> childCategories = category.getChildCategories();

		if (!childCategories.isEmpty()) {
			model.addAttribute("categories", childCategories);
			return "categories";
		} else {
			model.addAttribute("category", category);
			model.addAttribute("products", category.getProducts());
			return "products";
		}
	}

	@RequestMapping(value = { "/product/{prodId}" }, method = RequestMethod.GET)
	public String product(ModelMap model, @PathVariable Integer prodId) {
		Product product = productService.findAndInit(prodId);
		model.addAttribute("product", product);
		
		return "product";
	}
	
}
