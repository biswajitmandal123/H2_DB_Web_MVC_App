package com.biswajit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.biswajit.entity.Product;
import com.biswajit.repository.ProductRepository;

@Controller
public class ProductController {
	private ProductRepository repo;
	
	@GetMapping("/products")
	public String loadProduct(Model model) {
		
		model.addAttribute("products",repo.findAll());
		return "data";
		
	}
	

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("p", new Product());

		return "index";

	}

	@PostMapping("/product")
	public String handleSave(@ModelAttribute("p") Product p, Model model) {

		p = repo.save(p);
		if (p.getPid() != null) {
			model.addAttribute("msg", "product save");
		}

		return "index";

	}
	
	
	
	

}
